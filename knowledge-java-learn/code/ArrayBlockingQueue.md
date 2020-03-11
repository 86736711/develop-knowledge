# ArrayBlockingQueue源码解析

数组形式支持的阻塞队列，其实这个实现比较简单，复杂的在锁和阻塞问题上了，这里只讲put和take方法以及一些私有方法

```
这是寻访所有元素的数组
/** The queued items */
    final Object[] items;

//take出去的索引位置，这个和算法中的哨兵的作用很像是为了提高搜索的性能
    /** items index for next take, poll, peek or remove */
    int takeIndex;
//put进去的索引位置，这个和算法中的哨兵的作用很像是为了提高搜索的性能
    /** items index for next put, offer, or add */
    int putIndex;

    /** Number of elements in the queue */
    int count;

    /*
     * Concurrency control uses the classic two-condition algorithm
     * found in any textbook.
     */
     
//这里有个重入锁,关于所的源码另行描述
    /** Main lock guarding all access */
    final ReentrantLock lock;
//condition就是处理阻塞的，满后的阻塞内容
    /** Condition for waiting takes */
    private final Condition notEmpty;
//condition就是处理阻塞的，空后的阻塞内容
    /** Condition for waiting puts */
    private final Condition notFull;

```

```

/**
     * Creates an {@code ArrayBlockingQueue} with the given (fixed)
     * capacity and the specified access policy.
     *//数组的长度
     * @param capacity the capacity of this queue
     * //序列是否保持先进先出的原则
     * @param fair if {@code true} then queue accesses for threads blocked
     *        on insertion or removal, are processed in FIFO order;
     *        if {@code false} the access order is unspecified.
     * @throws IllegalArgumentException if {@code capacity < 1}
     */
public ArrayBlockingQueue(int capacity, boolean fair) {
        if (capacity <= 0)
            throw new IllegalArgumentException();
        this.items = new Object[capacity];
        lock = new ReentrantLock(fair);
        notEmpty = lock.newCondition();
        notFull =  lock.newCondition();
    }

```

```
这个方法是线程安全和阻塞的
/**
     * Inserts the specified element at the tail of this queue, waiting
     * for space to become available if the queue is full.
     *
     * @throws InterruptedException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    public void put(E e) throws InterruptedException {
        checkNotNull(e);
        final ReentrantLock lock = this.lock;
        //可中断锁，因为有阻塞的操作，所以这个锁在阻塞以后需要释放
        lock.lockInterruptibly();
        try {
        //这里会看到如果这个数组的数据已经满了下面就会阻塞这个线程
            while (count == items.length)
                notFull.await();
                //这里就是阻塞都进行进队列的过程
            enqueue(e);
        } finally {
            lock.unlock();
        }
    }

```

```
这里就是插入数据的过程
/**
     * Inserts element at current put position, advances, and signals.
     * Call only when holding lock.
     */
    private void enqueue(E x) {
        // assert lock.getHoldCount() == 1;
        // assert items[putIndex] == null;
        final Object[] items = this.items;
        items[putIndex] = x;
        if (++putIndex == items.length)
            putIndex = 0;
        count++;
        //这里有一个这个过程，这个的意思就是在队列时是空的时候来释放阻塞在空环境中的线程。
        notEmpty.signal();
    }

```


```
这个是一个阻塞的获取数据的方式
public E take() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
        //这里当数组是0的时候将记性阻塞，发现是用空环境来阻塞这个线程
            while (count == 0)
                notEmpty.await();
                //当有数据以后进行出数据
            return dequeue();
        } finally {
            lock.unlock();
        }
    }

```

```
这里就是出数据的过程
/**
     * Extracts element at current take position, advances, and signals.
     * Call only when holding lock.
     */
    private E dequeue() {
        // assert lock.getHoldCount() == 1;
        // assert items[takeIndex] != null;
        final Object[] items = this.items;
        @SuppressWarnings("unchecked")
        E x = (E) items[takeIndex];
        items[takeIndex] = null;
        if (++takeIndex == items.length)
            takeIndex = 0;
        count--;
        if (itrs != null)
            itrs.elementDequeued();
            //值得注意的事，这个是释放慢环境中的线程
        notFull.signal();
        return x;
    }

```

整体的关键代码就这些，这就完成了序列的阻塞队列的方法，记住他的功能可以给一个固定长度的队列，可以订队列是否保持先进先出的原则FIFO
还有就是线程安全的并且可以阻塞队列
