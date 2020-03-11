# HashMap源码解析

## 初始

```
这是官方的初始值，二进制标识 1000 这个和后面的计算hash值有关系

    /**
     * The default initial capacity - MUST be a power of two.
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16


```
```
这个就是存储的数据结构有hash值还有链表，hash值怎么来的呢？往下看
/**
     * Basic hash bin node, used for most entries.  (See below for
     * TreeNode subclass, and in LinkedHashMap for its Entry subclass.)
     */
    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;
        
```
```
计算hash值，为什么要位移16位然后异或呢？

/**
     * Computes key.hashCode() and spreads (XORs) higher bits of hash
     * to lower.  Because the table uses power-of-two masking, sets of
     * hashes that vary only in bits above the current mask will
     * always collide. (Among known examples are sets of Float keys
     * holding consecutive whole numbers in small tables.)  So we
     * apply a transform that spreads the impact of higher bits
     * downward. There is a tradeoff between speed, utility, and
     * quality of bit-spreading. Because many common sets of hashes
     * are already reasonably distributed (so don't benefit from
     * spreading), and because we use trees to handle large sets of
     * collisions in bins, we just XOR some shifted bits in the
     * cheapest possible way to reduce systematic lossage, as well as
     * to incorporate impact of the highest bits that would otherwise
     * never be used in index calculations because of table bounds.
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
```

```
发现没有这是个数组，那就是元素的存放
/**
     * The table, initialized on first use, and resized as
     * necessary. When allocated, length is always a power of two.
     * (We also tolerate length zero in some operations to allow
     * bootstrapping mechanics that are currently not needed.)
     */
    transient Node<K,V>[] table;
    
```

```
这里面判断就不说了这里有个方法要值得注意
/**
     * Constructs an empty <tt>HashMap</tt> with the specified initial
     * capacity and load factor.
     *
     * @param  initialCapacity the initial capacity
     * @param  loadFactor      the load factor
     * @throws IllegalArgumentException if the initial capacity is negative
     *         or the load factor is nonpositive
     */
    public HashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                                               initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                                               loadFactor);
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }
    
    
    //为什么传入的只[0]=1 [1-8]=本身 [8-以上] 都是16的倍数，这种位移取或保证了你的长度最终肯定符合插入中的算法
    /**
         * Returns a power of two size for the given target capacity.
         */
        static final int tableSizeFor(int cap) {
                int n = cap - 1; //1100   //1011
                n |= n >>> 1;             //0101 //1111
                n |= n >>> 2;                    //0011 //1111
                n |= n >>> 4;                           //0000 //1111
                n |= n >>> 8;                                  //0000 //1111
                n |= n >>> 16;                                        //0000 //1111
            return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        }
    
```

```
/**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
     *         (A <tt>null</tt> return can also indicate that the map
     *         previously associated <tt>null</tt> with <tt>key</tt>.)
     */
    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    /**
     * Implements Map.put and related methods
     *
     * @param hash hash for key
     * @param key the key
     * @param value the value to put
     * @param onlyIfAbsent if true, don't change existing value
     * @param evict if false, the table is in creation mode.
     * @return previous value, or null if none
     */
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)   
        //为什么要减一与一下hash值 ，这里就是一个很巧妙的方式了，举例就是初始的16个数组，这16个位置要想尽量的均匀put数据
        前面第一个疑问中有个(h = key.hashCode()) ^ (h >>> 16);这样的操作从分析来看
        高16位 0110101001010101
        低16位 0111101101011100
        异或后 0001000100001001  这是最终的hash值,这样做的目的是降低重复率，如果低16位后4位重复，那不一定高16位后4位重复
        这个将 10000 这是数组的长度 - 1 = 01111
        
        0001000100001001
                   01111
        0000000000001001 = 9 就放到9 的位置了。
        
        其实这个过程你就会发现是进行一个0-15的随机数，为什么不用java的随机数呢，或者%16来取模呢。就是1.这个随机数取决hash值，2.这样效率最好
                
            tab[i] = newNode(hash, key, value, null);
        else {
        //这里就是当发现这个节点已经有了数据咋办
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                //如果key值完全一样那好了就覆盖吧
                e = p;
            else if (p instanceof TreeNode)
            //如果发现当前节点是个树形（红黑树）结构，那就加入树中
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
            //如果是链表就循环去找最后一个next是null，加入链表
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        如果这个链表的熟练大于一个阈值那就变成树
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    //如果在链表中找到KEY一样的覆盖
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        //如果这个数组的大小超出阈值，将会扩容从新resize()
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
    
```

```
这是resize的代码，这里的代码也有很巧妙的地方

/**
     * Initializes or doubles table size.  If null, allocates in
     * accord with initial capacity target held in field threshold.
     * Otherwise, because we are using power-of-two expansion, the
     * elements from each bin must either stay at same index, or move
     * with a power of two offset in the new table.
     *
     * @return the table
     */
    final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;
        //老的数据长度
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        //老的数据长度扩容的阈值
        int oldThr = threshold;
        int newCap, newThr = 0;
        //如果老的列表有数据了会进行一下处理
        if (oldCap > 0) {
        //如果老的数据长度已经超出最大容量限制将不再重新resize
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            //否则我就要判断如果新的数组大小扩容以后并且当前的老的
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
        //这里是刚实例化所做的操作因为在这个时候数组还没有元素
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
            Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        //在扩容中，迁移老的数组也是一个难题，看怎么解决的
        if (oldTab != null) {
            //遍历老的数据数据
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    //如果该节点不是链表直接从新根据哈希放单新的数组位置上
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                    //如果这个节点是红黑树，那就行重新加入到新的数组，这里面有节点迁移的问题，以为数组的长度遍历，所以会拆成两个数，可以看两遍的迁移算法差不多
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                    //如果是链表的形式要将链表里面的数据都过滤一遍，并且计算hash的位置，这里面有个比较巧妙的地方，如下
                    // 每个链表里面的节点hash值是 例如
                    // 0110101001010101
                    // 0110101001010101
                    //            01111  这个是 16-1 然后进行与的过程
                    //           011111  现在长度变成32-1了 高位多了一个1，所以这个和原来的hash与后是否是原来的值取决于，新增的一位，那其实只要知道hash对应的一位是0还是1就可以了，是0的话位置不变，是1的话放到新的位置，而且只有这两种情况
                    //            10000  最简单的方式就是用hash只直接与一下老的数据长度16
                    
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            //这就是判断原来的hash只第5位的值的地方（这个位置根据数组的长度而定）
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }
```

到此hashmap的关键的代码都已经分析完了，可以看出JDK吧所有可以优化的地方已经都做了相应的处理