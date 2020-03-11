# java学习地图

让每位java程序员更专业的学习。1

## 一、基础篇

### 基础概念

#### 面向对象

[面向对象、面向过程](basics/concept/object-oriented-vs-procedure-oriented.md)

[面向对象的三大基本特征](basics/concept/characteristics.md)和[五大基本原则](basics/concept/principle.md)

#### 平台无关性

[Java如何实现的平台无关性的](basics/concept/platform-independent.md)

[JVM还支持哪些语言（Kotlin、Groovy、JRuby、Jython、Scala）](basics/concept/jvm-language.md)

#### 值传递

[值传递、引用传递](basics/concept/java-pass-by.md)

#### 封装、继承、多态

[什么是多态](basics/concept/polymorphism.md)、[方法重写与重载](basics/concept/overloading-vs-overriding.md)

Java的继承与实现

[Java的继承与组合](basics/concept/inheritance-composition.md)

[构造函数与默认构造函数](basics/concept/constructor.md)

[类变量、成员变量和局部变量](basics/concept/variable.md)

[成员变量和方法作用域](basics/concept/scope.md)

[java SPI]()

### 基础知识

#### 基本数据类型

[7种基本数据类型：整型、浮点型、布尔型、字符型](basics/basics/basic-data-types.md)

[整型中byte、short、int、long的取值范围](basics/basics/integer-scope.md)

[什么是浮点型？](basics/basics/float.md)

[什么是单精度和双精度？](basics/basics/single-double-float.md)

[为什么不能用浮点型表示金额？](basics/basics/float-amount.md)

#### String

[字符串的不可变性](basics/basics/final-string.md)

[JDK 6和JDK 7中substring的原理及区别](basics/basics/substring.md)

replaceFirst、replaceAll、replace区别(待完成)、

[String对“+”的重载](basics/basics/string-append.md)

[字符串拼接的几种方式和区别](basics/basics/string-concat.md)

[String.valueOf和Integer.toString的区别](basics/basics/value-of-vs-to-string.md)

[switch对String的支持](basics/basics/switch-string.md)

字符串池、常量池（运行时常量池、Class常量池）、intern(待完成)

#### 自动拆装箱

[什么是包装类型、什么是基本类型、什么是自动拆装箱](basics/basics/boxing-unboxing.md)

[Integer的缓存机制](basics/basics/integer-cache.md)

#### 枚举

[枚举的用法](basics/basics/enum-usage.md)

[枚举的实现](basics/basics/enum-impl.md)

[枚举与单例](basics/basics/enum-singleton.md)、Enum类

[Java枚举如何比较](basics/basics/enum-compare.md)

[switch对枚举的支持](basics/basics/enum-switch.md)

[枚举的序列化如何实现](basics/basics/enum-serializable.md)

[枚举的线程安全性问题](basics/basics/enum-thread-safe.md)

#### 集合类

[ArrayList和LinkedList的深入解析](basics/basics/list)

[HashMap和ConcurrentHashMap的深入解析](basics/basics/map)

[ArrayList和LinkedList和Vector的区别](basics/basics/arraylist-vs-linkedlist-vs-vector.md) 

[SynchronizedList和Vector的区别](basics/basics/synchronizedlist-vector.md)、

[HashMap、HashTable、ConcurrentHashMap区别](basics/basics/HashMap-HashTable-ConcurrentHashMap.md)

[Set和List区别？](basics/basics/set-vs-list.md)

[Set如何保证元素不重复?](basics/basics/set-repetition.md)

[Java 8中stream相关用法](basics/basics/stream.md)、

apache集合处理工具类的使用（等待整理）、

不同版本的JDK中HashMap的实现的区别以及原因（等待整理）

[Collection和Collections区别](basics/basics/Collection-vs-Collections.md)

[Arrays.asList获得的List使用时需要注意什么](basics/basics/Arrays-asList.md)

[Enumeration和Iterator区别](basics/basics/Enumeration-vs-Iterator.md)

[fail-fast 和 fail-safe](basics/basics/fail-fast-vs-fail-safe.md)

[CopyOnWriteArrayList](basics/basics/CopyOnWriteArrayList.md)

[ConcurrentSkipListMap](basics/basics/ConcurrentSkipListMap.md)

#### IO

[字符流、字节流](basics/basics/byte-stream-vs-character-stream.md)、[输入流、输出流](basics/basics/input-stream-vs-output-stream.md)

[同步、异步](basics/basics/synchronized-vs-asynchronization.md)、[阻塞、非阻塞](basics/basics/block-vs-non-blocking.md)、[Linux 5种IO模型](basics/basics/linux-io.md)

[BIO、NIO和AIO的区别、三种IO的用法与原理](basics/basics/bio-vs-nio-vs-aio.md)、netty

#### 关键字

transient、instanceof、volatile、synchronized、final、static、const 原理及用法（待完成）

#### Java反射与javassist

[反射](basics/basics/reflection.md)、 [反射有什么作用](basics/basics/usage-of-reflection.md)

[Class类](basics/basics/Class.md)

`java.lang.reflect.*`

#### 动态代理

[静态代理](basics/basics/static-proxy.md)、[动态代理](basics/basics/dynamic-proxy.md)

[动态代理和反射的关系](basics/basics/dynamic-proxy-vs-reflection.md)

[动态代理的几种实现方式](basics/basics/dynamic-proxy-implementation.md)

[AOP](basics/basics/aop-vs-proxy.md)

#### 序列化

[什么是序列化与反序列化](basics/basics/serialize.md)、[序列化底层原理](basics/basics/serialize-principle.md)、[序列化与单例模式](basics/basics/serialize-singleton.md)

#### 注解

[元注解](basics/basics/meta-annotation.md)、[自定义注解](basics/basics/custom-annotation.md)

Java中常用注解使用、注解与反射的结合（待完成）

[如何自定义一个注解？](basics/basics/create-annotation.md)

[Spring常用注解](basics/basics/annotation-in-spring.md)

#### JMS

什么是Java消息服务、JMS消息传送模型

#### JMX

`java.lang.management.*`、 `javax.management.*`

#### 泛型

泛型与继承、类型擦除、[泛型中K T V E ？ object等的含义](basics/basics/k-t-v-e.md)、泛型各种用法

限定通配符和非限定通配符、上下界限定符extends 和 super

[List<Object>和原始类型List之间的区别?](basics/basics/genericity-list.md)

[List<?>和List<Object>之间的区别是什么?](basics/basics/genericity-list-wildcard.md)

#### 单元测试

junit、mock、mockito、内存数据库（h2）

#### 正则表达式

`java.lang.util.regex.*`

#### 常用的Java工具库

`commons.lang`, `commons.*...` `guava-libraries` `netty`

#### API&SPI

API、[API和SPI的关系和区别](basics/basics/api-vs-spi.md)

[如何定义SPI](basics/basics/create-spi.md)、[SPI的实现原理](basics/basics/spi-principle.md)

#### 异常

异常类型、正确处理异常、自定义异常

Error和Exception

异常链、try-with-resources

finally和return的执行顺序

#### 时间处理

时区、冬令时和夏令时、时间戳、Java中时间API

格林威治时间、CET,UTC,GMT,CST几种常见时间的含义和关系

[SimpleDateFormat的线程安全性问题](basics/basics/simpledateformat-thread-safe.md)

Java 8中的时间处理

如何在东八区的计算机上获取美国时间

#### 编码方式

Unicode、有了Unicode为啥还需要UTF-8

GBK、GB2312、GB18030之间的区别

UTF8、UTF16、UTF32区别

URL编解码、Big Endian和Little Endian

如何解决乱码问题

#### 语法糖

[Java中语法糖原理、解语法糖](basics/basics/syntactic-sugar.md)

[语法糖：switch 支持 String 与枚举、泛型、自动装箱与拆箱、方法变长参数、枚举、内部类、条件编译、 断言、数值字面量、for-each、try-with-resource、Lambda表达式](basics/basics/syntactic-sugar.md)

### 阅读源代码

String、Integer、Long、Enum、BigDecimal、ThreadLocal、ClassLoader & URLClassLoader、ArrayList & LinkedList、 
[HashMap](code/hashmap.md) hashmap中如何存储数据，如何扩容数据，因为没有做同步的处理所以不是线程安全的 
& LinkedHashMap & TreeMap & CouncurrentHashMap、HashSet & LinkedHashSet & TreeSet

[ArrayBlockingQueue](code/ArrayBlockingQueue.md)  从源码能了解序列阻塞的方式

### 代码规范

[java研发规范](basics/阿里巴巴java开发手册1.5.pdf) 这个研发规范完全遵循阿里整理的研发规范。


## 二、进阶篇

### 并发

[java存储模型（JMM）](advance/concurrent/JMM.md)

[并发基础](advance/concurrent/base.md)

[cas概念](advance/lock/cas.md)

[独享锁和共享锁概念](advance/lock/optimistic-pessimistic-locking.md)

[java-Lock](advance/concurrent/Lock.md)

[java-ReentrantLock](advance/lock/ReentrantLock.md)

[java-Synchronized](advance/lock/Synchronized.md)

[AQS](advance/concurrent/AQS.md)

[Disruptor](advance/concurrent/disruptor) Disruptor介绍，架构设计，高性能原理，使用场景等

[Java多线程](advance/concurrent/thread) 线程和进程基本概念、多线程编程面临的问题和解决方案、线程安全、线程协作、线程中断等

[线程池](advance/concurrent/pool) 线程池解决的问题、阻塞队列、线程池架构、任务饱和策略、线程池配置、线程池关闭、常见线程池类型

### JVM

[java-JVM运行前的编译](advance/jvm/java-compile.md) 深入描述javac的编译机制

[java-JVM运行](advance/jvm/java-run.md) 深入理解java在启动运行后的内存分配

[java-JVM运行中的GC](advance/jvm/java-gc.md) 深入理解java的GC

[垃圾回收](advance/jvm/gc) 各种引用类型、判断对象存活的算法、垃圾回收算法

[内存结构](advance/jvm/structure) Java内存结构图，堆、方法区、虚拟机栈、本地方法栈、程序计数器

[内存模型](advance/jvm/model) 内存模型产生背景、Java内存模型组成分析、内存间的交互操作、运行规则、volatile变量规则等

### JAVA agent

### 锁(待完成)

[java中的锁](advance/lock/optimistic-pessimistic-locking.md)  

[CAS](advance/lock/cas.md)  
数据库相关锁机制  
分布式锁

### 设计模式

设计模式请看[tcsl-smart-designmode-demo](/tcsl-smart-designmode-demo/README.md)，工程的讲解

### 性能调优

[时间复杂度](advance/performance/time-complexity.md)


## 三、分布式篇

### 分布式理论

### 分布式技术

[dubbo](distributed/dubbo) RPC介绍、Dubbo特性、架构、负载均衡、集群容错策略

[netty](distributed/netty) Netty基本概念，网络I/O模型，线程模型，基本工作原理，系统架构

[redis](distributed/redis) Redis基本介绍、数据类型、持久化机制、缓存过期策略、集群方案、与Memcached比较、缓存穿透、缓存雪崩、缓存热点、缓存一致性、线上问题排查

[zookeeper](distributed/zookeeper) 功能与特性、架构设计(高性能、高可用、数据一致性实现原理)、应用场景、作为注册中心缺点分析

[lock](distributed/lock) 分布式锁概念、使用场景、基于Redis/ZooKeeper/数据库的分布式锁方案实现与解析

### 链路跟踪

[Google Dapper] 了解微服务的链路跟踪原理，以及现有的实现开源架构


## 四、数据库篇

[sql性能优化](sqldb/explain),（待完成）

[mysql基础](sqldb/mysql/basic) MySQL的Innodb与MyISAM比较、索引、SQL优化、SQL执行流程、主从同步原理等

[mysql事务](sqldb/mysql/transaction) MySQL事务流程和原理、MVCC原理

[mysql锁](sqldb/mysql/lock) MySQL锁分类，各种锁的作用，加锁原理，加锁分析

### 分布式理论

## 五、数据结构篇

### 概念偏

[数据结构知识](datastructure/data-structure.md) 描述了所有的数据结构的模型和一些查找排序的算法。

### java中的应用

[java中体现的数据结构](datastructure/java-data-structure.md) 根据java中的集合讲述了这些集合怎么使用了数据结构的感念

### 树的详解

[红黑树、B-、B+、B*](datastructure/tree.md) 的详解


## 六、算法篇

### 分布式理论

## 七、安全篇

1、什么是SQL注入 ，如何避免。
2、什么是XSS攻击，如何避免
3、什么是CSRF攻击，如何避免

## 八、网络篇

### 网络协议

[TCP和HTTP](network/protocol/tcphttp) TCP状态变迁图、TCP相关常见问题概念(三次握手，四次挥手)，HTTP相关问题概念解析

[互联网协议](network/protocol/basic) 互联网协议五层协议(应用层、传输层、网络层、链路层、物理层)由来，概念定义、作用的解析

## 九、架构篇

[排查问题](framework/problem) 线上服务应急流程，问题解决的思路、技巧，常见工具，命令行工具脚本

[开源架构学习](framework/learn) 学习开源项目常见错误观点解析，学习的层次，学习的方法步骤介绍

[架构设计思路](framework/idea) 架构设计相关基本概念、架构设计的目的、设计原则、架构设计基本设计流程等

## 十、团队管理

### SCRUM 

[SCRUM的概念总结]

## 十一、推荐书篇

《重构 改善既有代码的设计》  
《大话设计模式》  
《大话数据结构》  
《软件架构师12项修炼》  
《大话数据库》  
《企业IT架构转型之道》  
《深入理解Java虚拟机》  
《Effective Java》  
《深入分析Java Web技术内幕》  
《大型网站技术架构》  
《代码整洁之道》  
《架构整洁之道》  
《Head First设计模式》  
《maven实战》  
《区块链原理、设计与应用》  
《Java并发编程实战》  
《鸟哥的Linux私房菜》  
《从Paxos到Zookeeper》  
《架构即未来》 
