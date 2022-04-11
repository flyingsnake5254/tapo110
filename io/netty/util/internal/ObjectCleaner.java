package io.netty.util.internal;

import io.netty.util.concurrent.FastThreadLocalThread;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObjectCleaner
{
  private static final AtomicBoolean CLEANER_RUNNING = new AtomicBoolean(false);
  private static final Runnable CLEANER_TASK = new Runnable()
  {
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: invokestatic 20	io/netty/util/internal/ObjectCleaner:access$000	()Ljava/util/Set;
      //   5: invokeinterface 26 1 0
      //   10: ifne +44 -> 54
      //   13: invokestatic 30	io/netty/util/internal/ObjectCleaner:access$200	()Ljava/lang/ref/ReferenceQueue;
      //   16: invokestatic 34	io/netty/util/internal/ObjectCleaner:access$100	()I
      //   19: i2l
      //   20: invokevirtual 40	java/lang/ref/ReferenceQueue:remove	(J)Ljava/lang/ref/Reference;
      //   23: checkcast 42	io/netty/util/internal/ObjectCleaner$AutomaticCleanerReference
      //   26: astore_2
      //   27: aload_2
      //   28: ifnull -26 -> 2
      //   31: aload_2
      //   32: invokevirtual 45	io/netty/util/internal/ObjectCleaner$AutomaticCleanerReference:cleanup	()V
      //   35: invokestatic 20	io/netty/util/internal/ObjectCleaner:access$000	()Ljava/util/Set;
      //   38: aload_2
      //   39: invokeinterface 48 2 0
      //   44: pop
      //   45: goto -43 -> 2
      //   48: astore_3
      //   49: iconst_1
      //   50: istore_1
      //   51: goto -49 -> 2
      //   54: invokestatic 52	io/netty/util/internal/ObjectCleaner:access$300	()Ljava/util/concurrent/atomic/AtomicBoolean;
      //   57: iconst_0
      //   58: invokevirtual 58	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   61: invokestatic 20	io/netty/util/internal/ObjectCleaner:access$000	()Ljava/util/Set;
      //   64: invokeinterface 26 1 0
      //   69: ifne +14 -> 83
      //   72: invokestatic 52	io/netty/util/internal/ObjectCleaner:access$300	()Ljava/util/concurrent/atomic/AtomicBoolean;
      //   75: iconst_0
      //   76: iconst_1
      //   77: invokevirtual 62	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
      //   80: ifne -78 -> 2
      //   83: iload_1
      //   84: ifeq +9 -> 93
      //   87: invokestatic 68	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   90: invokevirtual 71	java/lang/Thread:interrupt	()V
      //   93: return
      //   94: astore_3
      //   95: goto -60 -> 35
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	98	0	this	1
      //   1	83	1	i	int
      //   26	13	2	localAutomaticCleanerReference	ObjectCleaner.AutomaticCleanerReference
      //   48	1	3	localInterruptedException	InterruptedException
      //   94	1	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   13	27	48	java/lang/InterruptedException
      //   31	35	94	finally
    }
  };
  static final String CLEANER_THREAD_NAME;
  private static final Set<AutomaticCleanerReference> LIVE_SET;
  private static final ReferenceQueue<Object> REFERENCE_QUEUE;
  private static final int REFERENCE_QUEUE_POLL_TIMEOUT_MS = Math.max(500, SystemPropertyUtil.getInt("io.netty.util.internal.ObjectCleaner.refQueuePollTimeout", 10000));
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ObjectCleaner.class.getSimpleName());
    localStringBuilder.append("Thread");
    CLEANER_THREAD_NAME = localStringBuilder.toString();
    LIVE_SET = new ConcurrentSet();
    REFERENCE_QUEUE = new ReferenceQueue();
  }
  
  public static int getLiveSetCount()
  {
    return LIVE_SET.size();
  }
  
  public static void register(Object paramObject, Runnable paramRunnable)
  {
    paramObject = new AutomaticCleanerReference(paramObject, (Runnable)ObjectUtil.checkNotNull(paramRunnable, "cleanupTask"));
    LIVE_SET.add(paramObject);
    if (CLEANER_RUNNING.compareAndSet(false, true))
    {
      paramObject = new FastThreadLocalThread(CLEANER_TASK);
      ((Thread)paramObject).setPriority(1);
      AccessController.doPrivileged(new PrivilegedAction()
      {
        public Void run()
        {
          this.val$cleanupThread.setContextClassLoader(null);
          return null;
        }
      });
      ((Thread)paramObject).setName(CLEANER_THREAD_NAME);
      ((Thread)paramObject).setDaemon(true);
      ((Thread)paramObject).start();
    }
  }
  
  private static final class AutomaticCleanerReference
    extends WeakReference<Object>
  {
    private final Runnable cleanupTask;
    
    AutomaticCleanerReference(Object paramObject, Runnable paramRunnable)
    {
      super(ObjectCleaner.REFERENCE_QUEUE);
      this.cleanupTask = paramRunnable;
    }
    
    void cleanup()
    {
      this.cleanupTask.run();
    }
    
    public void clear()
    {
      ObjectCleaner.LIVE_SET.remove(this);
      super.clear();
    }
    
    public Thread get()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\ObjectCleaner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */