package io.netty.util;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Recycler<T>
{
  private static final int DEFAULT_INITIAL_MAX_CAPACITY_PER_THREAD = 4096;
  private static final int DEFAULT_MAX_CAPACITY_PER_THREAD;
  private static final int DELAYED_QUEUE_RATIO;
  private static final FastThreadLocal<Map<Stack<?>, WeakOrderQueue>> DELAYED_RECYCLED = new FastThreadLocal()
  {
    protected Map<Recycler.Stack<?>, Recycler.WeakOrderQueue> initialValue()
    {
      return new WeakHashMap();
    }
  };
  private static final AtomicInteger ID_GENERATOR;
  private static final int INITIAL_CAPACITY;
  private static final int LINK_CAPACITY;
  private static final int MAX_DELAYED_QUEUES_PER_THREAD;
  private static final int MAX_SHARED_CAPACITY_FACTOR;
  private static final a NOOP_HANDLE;
  private static final int OWN_THREAD_ID;
  private static final int RATIO;
  private static final InternalLogger logger;
  private final int delayedQueueInterval;
  private final int interval;
  private final int maxCapacityPerThread;
  private final int maxDelayedQueuesPerThread;
  private final int maxSharedCapacityFactor;
  private final FastThreadLocal<Stack<T>> threadLocal = new FastThreadLocal()
  {
    protected Recycler.Stack<T> initialValue()
    {
      return new Recycler.Stack(Recycler.this, Thread.currentThread(), Recycler.this.maxCapacityPerThread, Recycler.this.maxSharedCapacityFactor, Recycler.this.interval, Recycler.this.maxDelayedQueuesPerThread, Recycler.this.delayedQueueInterval);
    }
    
    protected void onRemoval(Recycler.Stack<T> paramAnonymousStack)
    {
      if ((paramAnonymousStack.threadRef.get() == Thread.currentThread()) && (Recycler.DELAYED_RECYCLED.isSet())) {
        ((Map)Recycler.DELAYED_RECYCLED.get()).remove(paramAnonymousStack);
      }
    }
  };
  
  static
  {
    InternalLogger localInternalLogger = InternalLoggerFactory.getInstance(Recycler.class);
    logger = localInternalLogger;
    NOOP_HANDLE = new a()
    {
      public void recycle(Object paramAnonymousObject) {}
    };
    AtomicInteger localAtomicInteger = new AtomicInteger(Integer.MIN_VALUE);
    ID_GENERATOR = localAtomicInteger;
    OWN_THREAD_ID = localAtomicInteger.getAndIncrement();
    int i = 4096;
    int j = SystemPropertyUtil.getInt("io.netty.recycler.maxCapacityPerThread", SystemPropertyUtil.getInt("io.netty.recycler.maxCapacity", 4096));
    if (j >= 0) {
      i = j;
    }
    DEFAULT_MAX_CAPACITY_PER_THREAD = i;
    int k = Math.max(2, SystemPropertyUtil.getInt("io.netty.recycler.maxSharedCapacityFactor", 2));
    MAX_SHARED_CAPACITY_FACTOR = k;
    MAX_DELAYED_QUEUES_PER_THREAD = Math.max(0, SystemPropertyUtil.getInt("io.netty.recycler.maxDelayedQueuesPerThread", NettyRuntime.availableProcessors() * 2));
    int m = MathUtil.safeFindNextPositivePowerOfTwo(Math.max(SystemPropertyUtil.getInt("io.netty.recycler.linkCapacity", 16), 16));
    LINK_CAPACITY = m;
    int n = Math.max(0, SystemPropertyUtil.getInt("io.netty.recycler.ratio", 8));
    RATIO = n;
    j = Math.max(0, SystemPropertyUtil.getInt("io.netty.recycler.delayedQueue.ratio", n));
    DELAYED_QUEUE_RATIO = j;
    if (localInternalLogger.isDebugEnabled()) {
      if (i == 0)
      {
        localInternalLogger.debug("-Dio.netty.recycler.maxCapacityPerThread: disabled");
        localInternalLogger.debug("-Dio.netty.recycler.maxSharedCapacityFactor: disabled");
        localInternalLogger.debug("-Dio.netty.recycler.linkCapacity: disabled");
        localInternalLogger.debug("-Dio.netty.recycler.ratio: disabled");
        localInternalLogger.debug("-Dio.netty.recycler.delayedQueue.ratio: disabled");
      }
      else
      {
        localInternalLogger.debug("-Dio.netty.recycler.maxCapacityPerThread: {}", Integer.valueOf(i));
        localInternalLogger.debug("-Dio.netty.recycler.maxSharedCapacityFactor: {}", Integer.valueOf(k));
        localInternalLogger.debug("-Dio.netty.recycler.linkCapacity: {}", Integer.valueOf(m));
        localInternalLogger.debug("-Dio.netty.recycler.ratio: {}", Integer.valueOf(n));
        localInternalLogger.debug("-Dio.netty.recycler.delayedQueue.ratio: {}", Integer.valueOf(j));
      }
    }
    INITIAL_CAPACITY = Math.min(i, 256);
  }
  
  protected Recycler()
  {
    this(DEFAULT_MAX_CAPACITY_PER_THREAD);
  }
  
  protected Recycler(int paramInt)
  {
    this(paramInt, MAX_SHARED_CAPACITY_FACTOR);
  }
  
  protected Recycler(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, RATIO, MAX_DELAYED_QUEUES_PER_THREAD);
  }
  
  protected Recycler(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, DELAYED_QUEUE_RATIO);
  }
  
  protected Recycler(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.interval = Math.max(0, paramInt3);
    this.delayedQueueInterval = Math.max(0, paramInt5);
    if (paramInt1 <= 0)
    {
      this.maxCapacityPerThread = 0;
      this.maxSharedCapacityFactor = 1;
      this.maxDelayedQueuesPerThread = 0;
    }
    else
    {
      this.maxCapacityPerThread = paramInt1;
      this.maxSharedCapacityFactor = Math.max(1, paramInt2);
      this.maxDelayedQueuesPerThread = Math.max(0, paramInt4);
    }
  }
  
  public final T get()
  {
    if (this.maxCapacityPerThread == 0) {
      return (T)newObject(NOOP_HANDLE);
    }
    Stack localStack = (Stack)this.threadLocal.get();
    DefaultHandle localDefaultHandle1 = localStack.pop();
    DefaultHandle localDefaultHandle2 = localDefaultHandle1;
    if (localDefaultHandle1 == null)
    {
      localDefaultHandle2 = localStack.newHandle();
      localDefaultHandle2.value = newObject(localDefaultHandle2);
    }
    return (T)localDefaultHandle2.value;
  }
  
  protected abstract T newObject(a<T> parama);
  
  @Deprecated
  public final boolean recycle(T paramT, a<T> parama)
  {
    if (parama == NOOP_HANDLE) {
      return false;
    }
    parama = (DefaultHandle)parama;
    if (parama.stack.parent != this) {
      return false;
    }
    parama.recycle(paramT);
    return true;
  }
  
  final int threadLocalCapacity()
  {
    return ((Stack)this.threadLocal.get()).elements.length;
  }
  
  final int threadLocalSize()
  {
    return ((Stack)this.threadLocal.get()).size;
  }
  
  private static final class DefaultHandle<T>
    implements Recycler.a<T>
  {
    boolean hasBeenRecycled;
    int lastRecycledId;
    int recycleId;
    Recycler.Stack<?> stack;
    Object value;
    
    DefaultHandle(Recycler.Stack<?> paramStack)
    {
      this.stack = paramStack;
    }
    
    public void recycle(Object paramObject)
    {
      if (paramObject == this.value)
      {
        paramObject = this.stack;
        if ((this.lastRecycledId == this.recycleId) && (paramObject != null))
        {
          ((Recycler.Stack)paramObject).push(this);
          return;
        }
        throw new IllegalStateException("recycled already");
      }
      throw new IllegalArgumentException("object does not belong to handle");
    }
  }
  
  private static final class Stack<T>
  {
    final AtomicInteger availableSharedCapacity;
    private Recycler.WeakOrderQueue cursor;
    private final int delayedQueueInterval;
    Recycler.DefaultHandle<?>[] elements;
    private int handleRecycleCount;
    private volatile Recycler.WeakOrderQueue head;
    private final int interval;
    private final int maxCapacity;
    private final int maxDelayedQueues;
    final Recycler<T> parent;
    private Recycler.WeakOrderQueue prev;
    int size;
    final WeakReference<Thread> threadRef;
    
    Stack(Recycler<T> paramRecycler, Thread paramThread, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.parent = paramRecycler;
      this.threadRef = new WeakReference(paramThread);
      this.maxCapacity = paramInt1;
      this.availableSharedCapacity = new AtomicInteger(Math.max(paramInt1 / paramInt2, Recycler.LINK_CAPACITY));
      this.elements = new Recycler.DefaultHandle[Math.min(Recycler.INITIAL_CAPACITY, paramInt1)];
      this.interval = paramInt3;
      this.delayedQueueInterval = paramInt5;
      this.handleRecycleCount = paramInt3;
      this.maxDelayedQueues = paramInt4;
    }
    
    private Recycler.WeakOrderQueue newWeakOrderQueue(Thread paramThread)
    {
      return Recycler.WeakOrderQueue.newQueue(this, paramThread);
    }
    
    private void pushLater(Recycler.DefaultHandle<?> paramDefaultHandle, Thread paramThread)
    {
      if (this.maxDelayedQueues == 0) {
        return;
      }
      Map localMap = (Map)Recycler.DELAYED_RECYCLED.get();
      Recycler.WeakOrderQueue localWeakOrderQueue = (Recycler.WeakOrderQueue)localMap.get(this);
      if (localWeakOrderQueue == null)
      {
        if (localMap.size() >= this.maxDelayedQueues)
        {
          localMap.put(this, Recycler.WeakOrderQueue.DUMMY);
          return;
        }
        paramThread = newWeakOrderQueue(paramThread);
        if (paramThread == null) {
          return;
        }
        localMap.put(this, paramThread);
      }
      else
      {
        paramThread = localWeakOrderQueue;
        if (localWeakOrderQueue == Recycler.WeakOrderQueue.DUMMY) {
          return;
        }
      }
      paramThread.add(paramDefaultHandle);
    }
    
    private void pushNow(Recycler.DefaultHandle<?> paramDefaultHandle)
    {
      if ((paramDefaultHandle.recycleId | paramDefaultHandle.lastRecycledId) == 0)
      {
        int i = Recycler.OWN_THREAD_ID;
        paramDefaultHandle.lastRecycledId = i;
        paramDefaultHandle.recycleId = i;
        i = this.size;
        if ((i < this.maxCapacity) && (!dropHandle(paramDefaultHandle)))
        {
          Recycler.DefaultHandle[] arrayOfDefaultHandle = this.elements;
          if (i == arrayOfDefaultHandle.length) {
            this.elements = ((Recycler.DefaultHandle[])Arrays.copyOf(arrayOfDefaultHandle, Math.min(i << 1, this.maxCapacity)));
          }
          this.elements[i] = paramDefaultHandle;
          this.size = (i + 1);
        }
        return;
      }
      throw new IllegalStateException("recycled already");
    }
    
    private boolean scavenge()
    {
      if (scavengeSome()) {
        return true;
      }
      this.prev = null;
      this.cursor = this.head;
      return false;
    }
    
    private boolean scavengeSome()
    {
      Object localObject1 = this.cursor;
      boolean bool1 = false;
      Object localObject3;
      if (localObject1 == null)
      {
        localObject2 = null;
        localObject3 = this.head;
        localObject1 = localObject3;
        if (localObject3 != null) {
          break label34;
        }
        return false;
      }
      label34:
      Recycler.WeakOrderQueue localWeakOrderQueue;
      for (Object localObject2 = this.prev;; localObject2 = localObject3)
      {
        boolean bool2 = ((Recycler.WeakOrderQueue)localObject1).transfer(this);
        boolean bool3 = true;
        if (bool2)
        {
          bool1 = bool3;
          break label153;
        }
        localWeakOrderQueue = ((Recycler.WeakOrderQueue)localObject1).getNext();
        if (((WeakReference)localObject1).get() == null)
        {
          bool3 = bool1;
          if (((Recycler.WeakOrderQueue)localObject1).hasFinalData()) {
            for (;;)
            {
              bool3 = bool1;
              if (!((Recycler.WeakOrderQueue)localObject1).transfer(this)) {
                break;
              }
              bool1 = true;
            }
          }
          localObject3 = localObject2;
          bool1 = bool3;
          if (localObject2 != null)
          {
            ((Recycler.WeakOrderQueue)localObject1).reclaimAllSpaceAndUnlink();
            ((Recycler.WeakOrderQueue)localObject2).setNext(localWeakOrderQueue);
            localObject3 = localObject2;
            bool1 = bool3;
          }
        }
        else
        {
          localObject3 = localObject1;
        }
        if ((localWeakOrderQueue == null) || (bool1)) {
          break;
        }
        localObject1 = localWeakOrderQueue;
      }
      localObject1 = localWeakOrderQueue;
      localObject2 = localObject3;
      label153:
      this.prev = ((Recycler.WeakOrderQueue)localObject2);
      this.cursor = ((Recycler.WeakOrderQueue)localObject1);
      return bool1;
    }
    
    boolean dropHandle(Recycler.DefaultHandle<?> paramDefaultHandle)
    {
      if (!paramDefaultHandle.hasBeenRecycled)
      {
        int i = this.handleRecycleCount;
        if (i < this.interval)
        {
          this.handleRecycleCount = (i + 1);
          return true;
        }
        this.handleRecycleCount = 0;
        paramDefaultHandle.hasBeenRecycled = true;
      }
      return false;
    }
    
    int increaseCapacity(int paramInt)
    {
      int i = this.elements.length;
      int j = this.maxCapacity;
      int k;
      do
      {
        k = i << 1;
        if (k >= paramInt) {
          break;
        }
        i = k;
      } while (k < j);
      paramInt = Math.min(k, j);
      Recycler.DefaultHandle[] arrayOfDefaultHandle = this.elements;
      if (paramInt != arrayOfDefaultHandle.length) {
        this.elements = ((Recycler.DefaultHandle[])Arrays.copyOf(arrayOfDefaultHandle, paramInt));
      }
      return paramInt;
    }
    
    Recycler.DefaultHandle<T> newHandle()
    {
      return new Recycler.DefaultHandle(this);
    }
    
    Recycler.DefaultHandle<T> pop()
    {
      int i = this.size;
      int j = i;
      if (i == 0)
      {
        if (!scavenge()) {
          return null;
        }
        i = this.size;
        j = i;
        if (i <= 0) {
          return null;
        }
      }
      j--;
      Recycler.DefaultHandle[] arrayOfDefaultHandle = this.elements;
      Recycler.DefaultHandle localDefaultHandle = arrayOfDefaultHandle[j];
      arrayOfDefaultHandle[j] = null;
      this.size = j;
      if (localDefaultHandle.lastRecycledId == localDefaultHandle.recycleId)
      {
        localDefaultHandle.recycleId = 0;
        localDefaultHandle.lastRecycledId = 0;
        return localDefaultHandle;
      }
      throw new IllegalStateException("recycled multiple times");
    }
    
    void push(Recycler.DefaultHandle<?> paramDefaultHandle)
    {
      Thread localThread = Thread.currentThread();
      if (this.threadRef.get() == localThread) {
        pushNow(paramDefaultHandle);
      } else {
        pushLater(paramDefaultHandle, localThread);
      }
    }
    
    void setHead(Recycler.WeakOrderQueue paramWeakOrderQueue)
    {
      try
      {
        paramWeakOrderQueue.setNext(this.head);
        this.head = paramWeakOrderQueue;
        return;
      }
      finally
      {
        paramWeakOrderQueue = finally;
        throw paramWeakOrderQueue;
      }
    }
  }
  
  private static final class WeakOrderQueue
    extends WeakReference<Thread>
  {
    static final WeakOrderQueue DUMMY = new WeakOrderQueue();
    private int handleRecycleCount;
    private final Head head;
    private final int id = Recycler.ID_GENERATOR.getAndIncrement();
    private final int interval;
    private WeakOrderQueue next;
    private Link tail;
    
    private WeakOrderQueue()
    {
      super();
      this.head = new Head(null);
      this.interval = 0;
    }
    
    private WeakOrderQueue(Recycler.Stack<?> paramStack, Thread paramThread)
    {
      super();
      this.tail = new Link();
      paramThread = new Head(paramStack.availableSharedCapacity);
      this.head = paramThread;
      paramThread.link = this.tail;
      int i = paramStack.delayedQueueInterval;
      this.interval = i;
      this.handleRecycleCount = i;
    }
    
    static WeakOrderQueue newQueue(Recycler.Stack<?> paramStack, Thread paramThread)
    {
      if (!Head.reserveSpaceForLink(paramStack.availableSharedCapacity)) {
        return null;
      }
      paramThread = new WeakOrderQueue(paramStack, paramThread);
      paramStack.setHead(paramThread);
      return paramThread;
    }
    
    void add(Recycler.DefaultHandle<?> paramDefaultHandle)
    {
      paramDefaultHandle.lastRecycledId = this.id;
      int i = this.handleRecycleCount;
      if (i < this.interval)
      {
        this.handleRecycleCount = (i + 1);
        return;
      }
      this.handleRecycleCount = 0;
      Link localLink1 = this.tail;
      int j = localLink1.get();
      Link localLink2 = localLink1;
      i = j;
      if (j == Recycler.LINK_CAPACITY)
      {
        localLink2 = this.head.newLink();
        if (localLink2 == null) {
          return;
        }
        localLink1.next = localLink2;
        this.tail = localLink2;
        i = localLink2.get();
      }
      localLink2.elements[i] = paramDefaultHandle;
      paramDefaultHandle.stack = null;
      localLink2.lazySet(i + 1);
    }
    
    WeakOrderQueue getNext()
    {
      return this.next;
    }
    
    boolean hasFinalData()
    {
      Link localLink = this.tail;
      boolean bool;
      if (localLink.readIndex != localLink.get()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    void reclaimAllSpaceAndUnlink()
    {
      this.head.reclaimAllSpaceAndUnlink();
      this.next = null;
    }
    
    void setNext(WeakOrderQueue paramWeakOrderQueue)
    {
      this.next = paramWeakOrderQueue;
    }
    
    boolean transfer(Recycler.Stack<?> paramStack)
    {
      Object localObject1 = this.head.link;
      if (localObject1 == null) {
        return false;
      }
      Object localObject2 = localObject1;
      if (((Link)localObject1).readIndex == Recycler.LINK_CAPACITY)
      {
        localObject2 = ((Link)localObject1).next;
        if (localObject2 == null) {
          return false;
        }
        this.head.relink((Link)localObject2);
      }
      int i = ((Link)localObject2).readIndex;
      int j = ((AtomicInteger)localObject2).get();
      int k = j - i;
      if (k == 0) {
        return false;
      }
      int m = paramStack.size;
      int n = k + m;
      k = j;
      if (n > paramStack.elements.length) {
        k = Math.min(paramStack.increaseCapacity(n) + i - m, j);
      }
      if (i != k)
      {
        localObject1 = ((Link)localObject2).elements;
        Recycler.DefaultHandle[] arrayOfDefaultHandle = paramStack.elements;
        while (i < k)
        {
          Recycler.DefaultHandle localDefaultHandle = localObject1[i];
          j = localDefaultHandle.recycleId;
          if (j == 0) {
            localDefaultHandle.recycleId = localDefaultHandle.lastRecycledId;
          } else {
            if (j != localDefaultHandle.lastRecycledId) {
              break label222;
            }
          }
          localObject1[i] = null;
          if (!paramStack.dropHandle(localDefaultHandle))
          {
            localDefaultHandle.stack = paramStack;
            arrayOfDefaultHandle[m] = localDefaultHandle;
            m++;
          }
          i++;
          continue;
          label222:
          throw new IllegalStateException("recycled already");
        }
        if (k == Recycler.LINK_CAPACITY)
        {
          localObject1 = ((Link)localObject2).next;
          if (localObject1 != null) {
            this.head.relink((Link)localObject1);
          }
        }
        ((Link)localObject2).readIndex = k;
        if (paramStack.size == m) {
          return false;
        }
        paramStack.size = m;
        return true;
      }
      return false;
    }
    
    private static final class Head
    {
      private final AtomicInteger availableSharedCapacity;
      Recycler.WeakOrderQueue.Link link;
      
      Head(AtomicInteger paramAtomicInteger)
      {
        this.availableSharedCapacity = paramAtomicInteger;
      }
      
      private void reclaimSpace(int paramInt)
      {
        this.availableSharedCapacity.addAndGet(paramInt);
      }
      
      static boolean reserveSpaceForLink(AtomicInteger paramAtomicInteger)
      {
        int i;
        do
        {
          i = paramAtomicInteger.get();
          if (i < Recycler.LINK_CAPACITY) {
            return false;
          }
        } while (!paramAtomicInteger.compareAndSet(i, i - Recycler.LINK_CAPACITY));
        return true;
      }
      
      Recycler.WeakOrderQueue.Link newLink()
      {
        Recycler.WeakOrderQueue.Link localLink;
        if (reserveSpaceForLink(this.availableSharedCapacity)) {
          localLink = new Recycler.WeakOrderQueue.Link();
        } else {
          localLink = null;
        }
        return localLink;
      }
      
      void reclaimAllSpaceAndUnlink()
      {
        Object localObject = this.link;
        this.link = null;
        int i = 0;
        while (localObject != null)
        {
          i += Recycler.LINK_CAPACITY;
          Recycler.WeakOrderQueue.Link localLink = ((Recycler.WeakOrderQueue.Link)localObject).next;
          ((Recycler.WeakOrderQueue.Link)localObject).next = null;
          localObject = localLink;
        }
        if (i > 0) {
          reclaimSpace(i);
        }
      }
      
      void relink(Recycler.WeakOrderQueue.Link paramLink)
      {
        reclaimSpace(Recycler.LINK_CAPACITY);
        this.link = paramLink;
      }
    }
    
    static final class Link
      extends AtomicInteger
    {
      final Recycler.DefaultHandle<?>[] elements = new Recycler.DefaultHandle[Recycler.LINK_CAPACITY];
      Link next;
      int readIndex;
    }
  }
  
  public static abstract interface a<T>
    extends ObjectPool.Handle<T>
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\Recycler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */