package io.netty.util;

import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@Deprecated
public final class ThreadDeathWatcher
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(ThreadDeathWatcher.class);
  private static final Queue<Entry> pendingEntries = new ConcurrentLinkedQueue();
  private static final AtomicBoolean started;
  static final ThreadFactory threadFactory;
  private static final Watcher watcher = new Watcher(null);
  private static volatile Thread watcherThread;
  
  static
  {
    started = new AtomicBoolean();
    String str = SystemPropertyUtil.get("io.netty.serviceThreadPrefix");
    boolean bool = StringUtil.isNullOrEmpty(str);
    Object localObject = "threadDeathWatcher";
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("threadDeathWatcher");
      localObject = ((StringBuilder)localObject).toString();
    }
    threadFactory = new DefaultThreadFactory((String)localObject, true, 1, null);
  }
  
  public static boolean awaitInactivity(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    ObjectUtil.checkNotNull(paramTimeUnit, "unit");
    Thread localThread = watcherThread;
    if (localThread != null)
    {
      localThread.join(paramTimeUnit.toMillis(paramLong));
      return localThread.isAlive() ^ true;
    }
    return true;
  }
  
  private static void schedule(Thread paramThread, Runnable paramRunnable, boolean paramBoolean)
  {
    pendingEntries.add(new Entry(paramThread, paramRunnable, paramBoolean));
    if (started.compareAndSet(false, true))
    {
      paramThread = threadFactory.newThread(watcher);
      AccessController.doPrivileged(new PrivilegedAction()
      {
        public Void run()
        {
          this.val$watcherThread.setContextClassLoader(null);
          return null;
        }
      });
      paramThread.start();
      watcherThread = paramThread;
    }
  }
  
  public static void unwatch(Thread paramThread, Runnable paramRunnable)
  {
    schedule((Thread)ObjectUtil.checkNotNull(paramThread, "thread"), (Runnable)ObjectUtil.checkNotNull(paramRunnable, "task"), false);
  }
  
  public static void watch(Thread paramThread, Runnable paramRunnable)
  {
    ObjectUtil.checkNotNull(paramThread, "thread");
    ObjectUtil.checkNotNull(paramRunnable, "task");
    if (paramThread.isAlive())
    {
      schedule(paramThread, paramRunnable, true);
      return;
    }
    throw new IllegalArgumentException("thread must be alive.");
  }
  
  private static final class Entry
  {
    final boolean isWatch;
    final Runnable task;
    final Thread thread;
    
    Entry(Thread paramThread, Runnable paramRunnable, boolean paramBoolean)
    {
      this.thread = paramThread;
      this.task = paramRunnable;
      this.isWatch = paramBoolean;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof Entry)) {
        return false;
      }
      paramObject = (Entry)paramObject;
      if ((this.thread != ((Entry)paramObject).thread) || (this.task != ((Entry)paramObject).task)) {
        bool = false;
      }
      return bool;
    }
    
    public int hashCode()
    {
      return this.thread.hashCode() ^ this.task.hashCode();
    }
  }
  
  private static final class Watcher
    implements Runnable
  {
    private final List<ThreadDeathWatcher.Entry> watchees = new ArrayList();
    
    private void fetchWatchees()
    {
      for (;;)
      {
        ThreadDeathWatcher.Entry localEntry = (ThreadDeathWatcher.Entry)ThreadDeathWatcher.pendingEntries.poll();
        if (localEntry == null) {
          return;
        }
        if (localEntry.isWatch) {
          this.watchees.add(localEntry);
        } else {
          this.watchees.remove(localEntry);
        }
      }
    }
    
    /* Error */
    private void notifyWatchees()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 26	io/netty/util/ThreadDeathWatcher$Watcher:watchees	Ljava/util/List;
      //   4: astore_1
      //   5: iconst_0
      //   6: istore_2
      //   7: iload_2
      //   8: aload_1
      //   9: invokeinterface 58 1 0
      //   14: if_icmpge +65 -> 79
      //   17: aload_1
      //   18: iload_2
      //   19: invokeinterface 62 2 0
      //   24: checkcast 41	io/netty/util/ThreadDeathWatcher$Entry
      //   27: astore_3
      //   28: aload_3
      //   29: getfield 66	io/netty/util/ThreadDeathWatcher$Entry:thread	Ljava/lang/Thread;
      //   32: invokevirtual 72	java/lang/Thread:isAlive	()Z
      //   35: ifne +38 -> 73
      //   38: aload_1
      //   39: iload_2
      //   40: invokeinterface 74 2 0
      //   45: pop
      //   46: aload_3
      //   47: getfield 78	io/netty/util/ThreadDeathWatcher$Entry:task	Ljava/lang/Runnable;
      //   50: invokeinterface 81 1 0
      //   55: goto -48 -> 7
      //   58: astore_3
      //   59: invokestatic 85	io/netty/util/ThreadDeathWatcher:access$300	()Lio/netty/util/internal/logging/InternalLogger;
      //   62: ldc 87
      //   64: aload_3
      //   65: invokeinterface 93 3 0
      //   70: goto -63 -> 7
      //   73: iinc 2 1
      //   76: goto -69 -> 7
      //   79: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	80	0	this	Watcher
      //   4	35	1	localList	List
      //   6	68	2	i	int
      //   27	20	3	localEntry	ThreadDeathWatcher.Entry
      //   58	7	3	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   46	55	58	finally
    }
    
    public void run()
    {
      do
      {
        do
        {
          fetchWatchees();
          notifyWatchees();
          fetchWatchees();
          notifyWatchees();
          try
          {
            Thread.sleep(1000L);
          }
          catch (InterruptedException localInterruptedException) {}
        } while ((!this.watchees.isEmpty()) || (!ThreadDeathWatcher.pendingEntries.isEmpty()));
        ThreadDeathWatcher.started.compareAndSet(true, false);
      } while ((!ThreadDeathWatcher.pendingEntries.isEmpty()) && (ThreadDeathWatcher.started.compareAndSet(false, true)));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\ThreadDeathWatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */