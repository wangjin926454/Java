package thread;

import java.util.concurrent.locks.Lock;

/**
 * 多线程编程核心篇
 *
 * 1.long,double的写操作不是原子性操作，需要使用volatile来保证写操作的原子性
 *
 * 2.多线程数据可见性：在没有volatile修饰时，共享变量的值保存在每个处理器(线程)的寄存器中，某个处理器值改变
 * 并不会影响到其他处理器的值。所以可见性无法保证。如果加了volatile关键字，则每次更新都会通过高速缓存和写缓冲器
 * 更新到主存，并通知其他处理器的高速缓存修改值，从而实现可见性。这个过程被称为冲刷处理器缓存。
 * 其他处理器更新高速缓存值这个过程称为刷新处理器缓存。该过程协议称为缓存一致性协议。
 *
 * 3.线程故障
 *  1）死锁：线程A持有B锁争抢C锁，线程D持有C锁争抢B锁，互不退让，产生死锁
 *  2）锁死：代码不规范，未释放锁（须在finally中释放锁）
 *  3）活锁：需要的资源不存在导致无限循环
 *  4）饥饿：线程一直无法得到CPU时间片来运行
 *
 * 4.锁的获得隐含刷新处理器缓存，锁的释放隐含冲刷处理器缓存
 *
 * 5.锁相关概念
 *  1）可重入锁：A方法中调用B方法，两个方法相同的锁，此时锁计数器再+1即可（开销较小）
 *  2）显示锁java.util.concurrent.locks.Lock 支持公平锁与非公平锁
 *  3）内部锁synchronized与ReentrantLock区别：内部锁不支持其他操作，太笨，例如显示锁可以使用tryLock方法在指定时间
 *                                      内未获得锁直接返回false，内部锁只支持非公平锁等。
 *  4）读写锁ReentrantReadWriteLock对读操作共享，对写操作排它。写锁可以降级（在获得写锁时继续获得读锁），但是不能
 *      升级（在获得读锁时继续获得写锁，必须先释放读锁，再获得写锁）
 * JVM内部对锁的优化（只针对synchronized）
 *  1）锁粗化：三个方法都是同一个锁，直接锁粗化
 *  2）锁消除：运行了很久发现没人抢则锁消除
 *  3）偏向锁：第一次获得锁的线程，再次获得时无需进行CAS操作，中途有别人访问则把偏向锁给最新的人，使得连续两个线程访问时只要一把锁。
 *  4）适应性锁：忙等(自旋)或者WAITING
 *
 * 6.锁实现方式：内存屏障
 *              1）在读写操作前后加入获取屏障与释放屏障，内存屏障可以防止重排序把读写操作排序到临界区之外，
 *              必须获得锁才能访问内存屏障中的值（使之看起来是原子性操作），从而保证同一时刻只有一个线程对内存屏障中的数据进行修改。
 * 7.重排序：临界区之外可以重排序
 *         内存屏障中可以重排序
 *         内存屏障中的指令不能重排序到内存屏障之外
 * 8.volatile 可以保证数组的引用的有序可见性，但无法保证数组中元素的有序可见性，
 *  所以 AtomicIntegerArray AtomicLongArray AtomicReferenceArray
 *
 * 9.CAS：类似乐观锁，更新前检查变量与主存中变量是否相等，不相等则重试，相等则更新
 *
 * 10.发布逸出：私有变量通过public方法改变，有可能导致发布逸出，为避免发布逸出，建议直接使用static、final、volatile直接初始化变量
 *
 * 11.线程数目设置：对于CPU密集型设置为N+1，对于IO密集型，设置为1，向2N靠近（N为CPU个数，通过System.getRuntime.availableProcessors()获取）
 *
 * 12.wait 与 join区别:
 * @see thread.condition.ThreadJoin
 *      wait方法是自身变成WAITING状态，join方法使目标线程与调用join方法的线程串行执行
 *      wait方法需要被notify或notifyAll方法唤醒，join方法在目标线程执行完毕后会自动唤醒执行调用join方法的线程
 *      wait是Object方法，join是Thread方法
 *
 * 13.API
 * @see thread.condition.CountDownLatchTest
 * @see thread.condition.CyclicBarryierTest
 *      CountDownLatch  调用CountDownLatch.await()后，必须等待计数器为0之后才执行自身
 *      CyclicBarrier 需要调用new CyclicBarrier(n) 在n次调用之前，每一次await方法使自身线程进入WAITING状态，直到第n次
 *          await方法唤醒所有线程继续执行。可以重复调用，n+1次await会重新暂停所有线程
 *
 * 14.队列,put(),take()阻塞队列；offer，poll非阻塞
 * @see thread.condition.ArrayBlockQueueTest
 * @see thread.condition.LinkedBlockingQueueTest
 * @see thread.condition.SynchronousQueueTest
 *      有界队列：容量有限
 *          ArrayBlockingQueue内部使用一个显示锁，可能导致高争用
 *          new LinkedBlockingQueue（N)内部使用两个显示锁，putLock和takeLock，由于链接结构会增加垃圾回收负担，以及size是AtomicInteger
 *          需要被生产者以及消费者共同争用，会有额外开销
 *          SynchronousQueue特殊有界队列，put后必须take才会继续put。当没有put操作时，take会暂停，没有take操作时，put会暂停。
 *
 *
 *      无界队列：最大容量Integer.MAX_VALUE(2^31 -1)
 *          new LinkedBlockingQueue；没有显示指定容量时是无界队列
 *
 *      公平与非公平调度：ArrayBlockingQueue和SynchronousQueue支持公平与非公平调度，LinkedBlockingQueue仅支持非公平调度
 *
 *      使用时机：LinkedBlockingQueue适合生产者消费者并发高
 *              ArrayBlockingQueue适合..............低
 *              Synchronous适合....................差不多时
 * 15.信号量Semaphore 限流，只有acquire获得一个信号之后才能进行操作，release释放一个信号量。须配对使用，在finally中释放release
 * @see thread.condition.SemaphoreTest
 *
 * 16.Exchanger 双缓冲区
 * @see thread.condition.ExchangerTest
 *      两个LinkedBlockingQueue，通过Exchanger实例互相交换数据
 *
 * 17.ThreadLocal
 * @see thread.threadlocal.ThreadLocalTest
 *      每个线程持有一份变量副本，互不影响
 *
 * 18.并发集合：
 *      ArrayList    CopyOnWriterArrayList    快照
 *      HashSet      CopyOnWriterArraySet     快照
 *      HashMap      ConcurrentHashMap        准实时
 *      TreeMap      ConcurrentSkipListMap    准实时
 *      TreeSet      ConcurrentSkipListSet    准实时
 *      LinkedList   ConcurrentLinkedQueue    准实时
 *      快照：在创建遍历时创建一个副本，对副本进行遍历，不影响原集合
 *      准实时：不加锁进行遍历，但是也是线程安全的，如果多个线程对同一个并发集合进行遍历，这些线程不适合共享同一个Iterator实例。
 *
 * 19.死锁防止：
 * @see thread.deadLock.DeadLockTest
 *      一个不断运行的工作者线程，检测是否系统中有死锁，有则选取一个发送中断。
 *
 * 20.线程池：
 * @see thread.threadpoolexecutor.ThreadPoolExecutorTest
 * @see thread.threadpoolexecutor.ThreadPoolExecutorTest2
 *      ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit time,
 *          BlockingQueue<Runnable> workQueue,ThradFactory threadFactory,RejectedExecutionHandler handler)
 *      核心线程数，最大线程数，最大空闲时间，时间单位，工作者线程队列，线程工厂，拒绝策略
     *       在ThreadPoolExecutor初始化中Queue为ArrayBlockingQueue和LinkedBlockingQueue和LinkedBlockingDeque且有大小限制时：
     *       1) 当池子大小小于corePoolSize就新建线程，并处理请求
     *       2）当池子大小等于corePoolSize，超过的线程加入ArrayBlockingQueue等待执行,
     *       这个时候getQueue()数量可能小于workQueue初始化的数量，此时一共有maximumPoolSize的线程数
     *       3) 线程池能容纳的最大容量 = maximumPoolSize + Queue(int capacity)
     *       4）当workQueue放不下新入的任务时，就用RejectedExecutionHandler来做拒绝处理
     *       5）另外，当池子的线程数大于corePoolSize的时候，超过corePoolSize的数量的执行完毕的线程
 *              会等待keepAliveTime长的时间，如果无请求可处理就自行销毁
 *      线程首先直接执行，然后加入工作者线程队列，再来的线程加入线程池直到最大线程数。
 *      拒绝策略：可以自定义，拒绝策略有：抛出异常，拒绝而不抛出异常，丢弃老的任务重新尝试接纳刚才线程，在客户端中直接被拒绝的线程。
 *      关闭线程池：shutdown不会马上关闭，执行完毕之后关闭
 *               shutdownNow 马上关闭，返回未被执行的任务列表
 *               awaitTermination（long timeout,timeUnit unit）时间到了之后关闭
 *
 *  四种线程池
 * @see thread.threadpoolexecutor.FourThreadPoolExecutor
    *  * ExecutorThreadPool
    *  * newCachedThreadPool适合耗时短。内部是一个SynchronousQueue,核心线程池大小为0
    *  * newFixedThreadPool//corePoolSize == maxPoolSize 全部都是核心适合生产者消费者固定
    *  * newSingleThreadPool//只有一个核心线程数，但是工作者线程队列是LinkedBlockingQueue无界队列，无限添加。适合多生产者
 * 21.批量执行任务并有返回值：CompletionService
 * @see thread.threadpoolexecutor.ThreadPoolCompletionService
 *
 * 22.定时任务ScheduleThreadPoolExecutor 可以对返回值进行判断做出相应操作。例如取消、异常处理
 * @see thread.schedulethreadpoolexecutortest.ScheduleThreadPoolExecutorTest
 * */
public class PackageInfo {
}
