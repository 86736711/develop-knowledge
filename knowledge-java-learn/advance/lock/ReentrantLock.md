# ReentrantLock 可重入锁实现原理

ReentrantLock 重入锁

表示可重入的锁，举个例子：当线程t1通过调用lock()方法获取锁之后，再次调用lock，是不会再阻塞获取锁的，直接增加重试次数就行了。synchronized 和 ReentrantLock 都是可重入锁；
来个简单的demo来说明一下重入性：

```

public class ReentrantDemo{
	public synchronized void demo(){
		System.out.println("begin:demo");
		demo2();
	}
	public void demo2(){
		System.out.println("begin:demo1");
		synchronized (this){
		}
}

public static void main(String[] args) {
	ReentrantDemo rd=new ReentrantDemo();
	new Thread(rd::demo).start();
}


```

## 获取锁

main里面启动了一个线程，调用synchronized修饰的demo方法，获得了当前的对象锁，然后demo中调用了demo2方法，demo2中又存在同一个市里说，此时，当前线程会因为无法持有demo2的对象锁而阻塞，这时就会发生死锁。重入锁的目的是为了避免此种死锁问题。

重入锁的类图：

![](image/reentrantLock1.png)

1. ReentrantLock.lock()

这里是入口了，获取锁的入口；sync是ReentrantLock的抽象的静态内部类，它继承AQS来实现重入锁的逻辑，这个系列博客的第一篇文章介绍了AQS，AQS 是一个同步队列，它能够实现线程的阻塞以及唤醒， 但它并不具备业务功能， 所以在不同的同步场景中，不同的锁会继承 AQS 来实现对应场景的功能；

```
 public void lock() {
        sync.lock();
    }
```

Sync 有两个具体的实现类，分别是：
NofairSync： 表示可以存在抢占锁的功能，也就是说不管当前队列上是否存在其他线程等待，新线程都有机会抢占锁
FailSync: 表示所有线程严格按照 FIFO 来获取锁，需要判断是否有前驱节点；
默认走的是非公平锁的逻辑，我们以非公平锁为例，看一下lock()中的实现

```
 final void lock() {
             if (compareAndSetState(0, 1))
                 setExclusiveOwnerThread(Thread.currentThread());
             else
                 acquire(1);
         }

```

- 非公平锁和公平锁最大的区别在于，在非公平锁中我抢占锁的逻辑是，不管有没有线程排队，我先上来 cas 去抢占一下
- CAS 成功，就表示成功获得了锁
- CAS 失败，调用 acquire(1)走锁竞争逻辑,在公平锁中，是没有这个if判断的，直接走 acquire(1)的逻辑；
下面我们看accquire()的逻辑

2. AQS.accquire()

acquire 是 AQS 中的核心方法，如果 CAS 操作未能成功，已经有别的线程抢到了锁，说明 state 已经不为 0（0是无锁时候的初始态），此时继续 acquire(1)操作；
```
public final void acquire(int arg) {
        if (!tryAcquire(arg) &&
            acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
            selfInterrupt();
    }

```


在第一篇文章AQS里面我们也介绍过这个独占锁的主要逻辑，这里我们再详细分析一下具体实现；

- 通过 tryAcquire 尝试获取独占锁，如果成功返回 true，失败返回 false
- 如果 tryAcquire 失败，则会通过 addWaiter 方法将当前线程封装成 Node 添加到 AQS 队列尾部
- acquireQueued，将 Node 作为参数，通过自旋去尝试获取锁。
下面每个方法逐一分析：

3. NonfairSync.tryAcquire(arg)

AQS 中 tryAcquire 方法的定义，并没有实现，而是抛出异常。这里都留给子类做具体实现了。
```
protected final boolean tryAcquire(int acquires) {
            return nonfairTryAcquire(acquires);
        }
```

nonfairTryAcquire才是真正实现tryAcquire逻辑的方法：

```

/*
       * 非公平锁实现尝试获取独占锁
       */
        final boolean nonfairTryAcquire(int acquires) {
            final Thread current = Thread.currentThread();  // 获取当前执行的线程
            int c = getState();    // 获取state的值
            if (c == 0) {     // 无锁状态时（初始态），这里再cas一次试试看能不能抢到
          		//cas 替换 state 的值， cas 成功表示获取锁成功
                if (compareAndSetState(0, acquires)) { 
                //保存当前获得锁的线程,下次再来的时候不需要再尝试竞争锁，直接走后续重入即可:state+1
                    setExclusiveOwnerThread(current);
                    return true;
                }
            }
            else if (current == getExclusiveOwnerThread()) {
            //如果同一个线程来获得锁，直接增加重入次数 ，state的值递增
                int nextc = c + acquires;
                if (nextc < 0) // overflow
                    throw new Error("Maximum lock count exceeded");
                setState(nextc);
                return true;    // 获取锁成功
            }
            return false;   // 获取锁失败
        }

```

4.AQS.addWaiter()

若tryAcquire 方法获取锁成功则执行任务，然后再等着释放即可，我们这里先分析获取锁失败以后线程阻塞态的逻辑。
获取锁失败则会先调用 addWaiter 将当前线程封装成Node，入参 mode 表示当前节点的状态，传递的参数是 Node.EXCLUSIVE，表示独占状态。意味着重入锁用到了 AQS 的独占锁功能；EXCLUSIVE在ReentrantLock好几处都有体现。addWaiter()的逻辑大致分为以下几个步骤：

- 将当前线程封装成 Node
- 当前链表中的 tail 节点是否为空，如果不为空，则通过 cas 操作把当前线程的node 添加到 AQS 队列
- 如果为空或者 cas 失败，调用 enq 将节点添加到 AQS 队列
来看一下addWaiter()和enq()的实现；

addWaiter()

```
    private Node addWaiter(Node mode) {
        Node node = new Node(Thread.currentThread(), mode);
        // Try the fast path of enq; backup to full enq on failure
        Node pred = tail;  // tail是AQS同步队列的队尾，默认为null
        if (pred != null) { // tail不为空，说明队列存在节点
            node.prev = pred; // //把当前线程的 Node 的 prev 指向 tail
            if (compareAndSetTail(pred, node)) { // 通过 cas把node加入到 AQS 队列，也就是设置为 tail
                pred.next = node; // 设置成功后，把原tail节点的next指向当前node
                return node;
            }
        }
        enq(node);  //tail =null ，把node添加到同步队列
        return node;
    }

```

enq()

enq 就是通过自旋操作把当前节点加入到队列中

```

    private Node enq(final Node node) {
        for (;;) {
            Node t = tail;
            if (t == null) { // Must initialize
                if (compareAndSetHead(new Node())) // 通过case初始化一个新的node，
                    tail = head; //初始化状态时头尾指向同一节点
            } else {  
                node.prev = t;
                if (compareAndSetTail(t, node)) {  // 初始化成功后通过cas将节点添加到队尾
                    t.next = node;
                    return t;
                }
            }
        }
    }


```

图解分析：
当三个线程同时来竞争锁时，调用addwaiter方法结束后的逻辑：
ThreadA 获得了锁资源，ThreadB和ThreadC竞争锁，然后排队

![](image/reentrantLock2.png)

5. AQS.acquireQueued()

通过addwaiter()方法把线程添加到链表后，会接着把node做为参数传递给acquireQueued()方法，去竞争锁；结合上一个图解，就是会把ThreadB 和ThreadC 封装后的node节点分别传给acquireQueued，去竞争ThreadA执行完任务后释放的锁；

acquireQueued的主要逻辑如下：

- 获取当前节点的 prev 节点
- 如果 prev 节点为 head 节点，那么它就有资格去争抢锁，调用 tryAcquire 抢占锁
- 抢占锁成功以后，把获得锁的节点设置为 head，并且移除原来的初始化 head节点
- 如果获得锁失败，则根据 waitStatus 决定是否需要挂起线程
- 最后，通过 cancelAcquire 取消获得锁的操作

```

      /**
     * Acquires in exclusive uninterruptible mode for thread already in
     * queue. Used by condition wait methods as well as acquire.
     * @param node the node
     * @param arg the acquire argument
     * @return {@code true} if interrupted while waiting
     */
    final boolean acquireQueued(final Node node, int arg) {
        boolean failed = true;
        try {
            boolean interrupted = false;
            for (;;) {
                final Node p = node.predecessor(); // 获得当前节点的前驱节点赋给p
                if (p == head && tryAcquire(arg)) { // 若p为head节点，则当前节点有资格去竞争锁
                    setHead(node);   // 将当前节点设为头结点，也就是当前节点获得锁成功，成为新的头结点获得执行权
                    p.next = null; // 把原头结点断开，从同步队列中删除
                    failed = false;
                    return interrupted;
                }
                // 若此时原头结点ThreadA还没有完全释放锁，则ThreadB/ThreadC就会在tryAcquire时候返回false，
                // 就会走后面的shouldParkAfterFailedAcquire方法，看下面的具体分析
                if (shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt())
                    interrupted = true;
            }
        } finally {
            if (failed)
                cancelAcquire(node);
        }
    }


```

shouldParkAfterFailedAcquire

这个方法的主要作用是，通过 Node 的状态来判断， ThreadB 竞争锁失败以后是否应该被挂起；
先来回顾一下node的五个状态：
Node 有 5 中状态，分别是： CANCELLED（1）， SIGNAL（-1）、 CONDITION（-2）、 PROPAGATE(-3)、默认状态(0)

- CANCELLED: 在同步队列中等待的线程等待超时或被中断，需要从同步队列中取消该 Node 的结点, 其结点的 waitStatus 为 CANCELLED，即结束状态，进入该状态后的结点将不会再变化
- SIGNAL: 只要前置节点释放锁，就会通知标识为 SIGNAL 状态的后续节点的线程CONDITION： 和 Condition 有关系，后续会讲解
- PROPAGATE： 共享模式下， PROPAGATE 状态的线程处于可运行状态
- CONDITION: 只有在等待队列才会有的状态，同步队列不会出现此状态
- 0： 初始状态
ThreadB 竞争锁失败以后是否应该被挂起？？

- 如果 ThreadB 的 pred 节点状态为 SIGNAL，那就表示可以放心挂起当前线程
- 通过循环扫描链表把 CANCELLED 状态的节点移除 （去掉无效的节点）
- 修改 pred 节点的状态为 SIGNAL,返回 false
返回 false 时，也就是不需要挂起，返回 true，则需要调用 parkAndCheckInterrupt挂起当前线程

```

    /**
     * Checks and updates status for a node that failed to acquire.
     * Returns true if thread should block. This is the main signal
     * control in all acquire loops.  Requires that pred == node.prev.
     *
     * @param pred node's predecessor holding status
     * @param node the node
     * @return {@code true} if thread should block
     */
    private static boolean shouldParkAfterFailedAcquire(Node pred, Node node) {
        int ws = pred.waitStatus;   // 获取前驱节点的状态
        if (ws == Node.SIGNAL)  // 前驱节点会singal时候，直接返回true，挂起当前节点
            /*
             * This node has already set status asking a release
             * to signal it, so it can safely park.
             */
            return true;   
        if (ws > 0) {// 状态大于0表示无效节点（只有处于cancel时大于0），取消了排队，需要移除该节点
            /*
             * Predecessor was cancelled. Skip over predecessors and
             * indicate retry.
             */
            do {
                node.prev = pred = pred.prev;  
            } while (pred.waitStatus > 0);   // 从链表中移除该cancel态的节点，用循环保证移除成功
            pred.next = node;
        } else {
            /*
             * waitStatus must be 0 or PROPAGATE.  Indicate that we
             * need a signal, but don't park yet.  Caller will need to
             * retry to make sure it cannot acquire before parking.
             */
             // 利用 cas 设置 prev 节点的状态为 SIGNAL(-1)
            compareAndSetWaitStatus(pred, ws, Node.SIGNAL);
        }
        return false;
    }


```

到这一步，若ThreadA还没有释放锁，ThreadB和ThreadC只能被挂起（标红的表示挂起）

![](image/reentrantLock3.png)


## 释放锁

当ThreadA线程执行完任务后调用finally中的unlock()方法释放锁的时候会经历什么样的操作。

ReentrantLock.unlock()

1. ReentrantLock中的unlock()

```

/*
	* 释放锁
	*/
    public void unlock() {
        sync.release(1);  // sync是继承了AQS的静态内部类
    }

```

2. AQS中的release()

```

public final boolean release(int arg) {
    if (tryRelease(arg)) {  // 释放锁成功
        Node h = head; 		// 获取到AQS队列中的头结点
        if (h != null && h.waitStatus != 0) // 如果 头节点不为空 并且状态！=0.
        //调用 unparkSuccessor(h)唤醒后续节点
            unparkSuccessor(h);
        return true;
    }
    return false;
}

```

这里面有两个核心方法，这么机智的你肯定一眼就看出来了，就是tryRelease()和unparkSuccessor();

3. AQS 中的tryRelease()

嗯哼，这块和tryAquire()是一样的，都是模板方法模式的体现，都没有给出具体的实现，真正的tryRelease() 实现还是需要在子类，也就是ReentrantLock的内部类sync中重写tryRelease();

```
    protected boolean tryRelease(int arg) {
        throw new UnsupportedOperationException();
    }
```

4. ReentrantLock中的tryRelease()

这个方法可以认为是一个设置锁状态的操作，通过将state状态减掉传入的参数值（参数为1），结果状态为0，就将独占锁的owner设置为null,方便其他线程有机会抢占锁；

- 在独占锁加锁的时候，我们会将state状态+1，不清楚的看上一篇获取锁的过程，里面有分析到；
- 所以，同一个锁，在重入多次之后，可能被叠加多次，比如重入了4次，最后state的值就是4，getState()得到的结果就是4；
- 在进行unlock的时候，就需要减掉所有的重入次数，才能完全释放锁；
- 也就是unlock()的次数与lock()次数对应上，才能将owner设置为null,释放掉锁，最后返回true;

```
       /*
       * 释放锁
       */       
        protected final boolean tryRelease(int releases) {
            int c = getState() - releases;   //getState获去到总重入次数减去1
            if (Thread.currentThread() != getExclusiveOwnerThread()) // 判断当前线程是否是获取到锁的线程，如果不是就抛异常 （只有获取到锁的当前线程才能释放锁！！）
                throw new IllegalMonitorStateException();
            boolean free = false;
            if (c == 0) {  // 最后减到为0表示释放完毕
                free = true;
                setExclusiveOwnerThread(null);
            }
            setState(c); // 更新重入次数，直到为0 ，否则return false，继续走释放的逻辑
            return free;
        }

```

5. AQS的unparkSuccessor()

直到tryRelease（）返回true，完全释放锁成功后，我们会调用AQS的unparkSuccessor（）唤醒后继节点,英文注释都是大师Doug Lea写的，为了不曲解他的本意，放着让大家看看；

```

    /**
     * Wakes up node's successor, if one exists.
     *
     * @param node the node
     */
    private void unparkSuccessor(Node node) {
        /*
         * If status is negative (i.e., possibly needing signal) try
         * to clear in anticipation of signalling.  It is OK if this
         * fails or if status is changed by waiting thread.
         */
        int ws = node.waitStatus; // 获得 head 节点的状态
        if (ws < 0)
            compareAndSetWaitStatus(node, ws, 0); // 设置 head 节点状态为 0

        /*
         * Thread to unpark is held in successor, which is normally
         * just the next node.  But if cancelled or apparently null,
         * traverse backwards from tail to find the actual
         * non-cancelled successor.
         */
        Node s = node.next; //得到 head 节点的下一个节点
        if (s == null || s.waitStatus > 0) {
        //如果下一个节点为 null 或者 status>0 表示 cancelled 状态.
        //通过从尾部节点开始扫描，找到距离 head 最近的一个waitStatus<=0 的节点
            s = null;
            for (Node t = tail; t != null && t != node; t = t.prev)
                if (t.waitStatus <= 0)
                    s = t;
        }
        if (s != null)
         //next 节点不为空，直接唤醒这个线程即可
            LockSupport.unpark(s.thread);
    }

```

为什么这里是从tail扫描找距离head最近的节点，从head开始扫描的不是更近更快吗？
上一篇分析的enq()构建节点方法里面，最后一步是 t.next=node，设置原tail的next节点指向新的节点，若在 cas 操作之后， t.next=node 操作之前。 存在其他线程调用 unlock 方法从 head开始往后遍历，由于 t.next=node 还没执行意味着链表的关系还没有建立完整。就会导致遍历到 t 节点的时候被中断，因为tail还没有指向新的尾结点。 所以若从后往前遍历，一定不会存在这个问题。




