package io.reactivex.internal.schedulers;

public final class ScheduledDirectPeriodicTask
  extends a
  implements Runnable
{
  private static final long serialVersionUID = 1811839108042568751L;
  
  public ScheduledDirectPeriodicTask(Runnable paramRunnable)
  {
    super(paramRunnable);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 27	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   4: putfield 31	io/reactivex/internal/schedulers/a:runner	Ljava/lang/Thread;
    //   7: aload_0
    //   8: getfield 35	io/reactivex/internal/schedulers/a:runnable	Ljava/lang/Runnable;
    //   11: invokeinterface 37 1 0
    //   16: aload_0
    //   17: aconst_null
    //   18: putfield 31	io/reactivex/internal/schedulers/a:runner	Ljava/lang/Thread;
    //   21: goto +20 -> 41
    //   24: astore_1
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 31	io/reactivex/internal/schedulers/a:runner	Ljava/lang/Thread;
    //   30: aload_0
    //   31: getstatic 41	io/reactivex/internal/schedulers/a:FINISHED	Ljava/util/concurrent/FutureTask;
    //   34: invokevirtual 47	java/util/concurrent/atomic/AtomicReference:lazySet	(Ljava/lang/Object;)V
    //   37: aload_1
    //   38: invokestatic 53	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   41: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	ScheduledDirectPeriodicTask
    //   24	14	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	21	24	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\schedulers\ScheduledDirectPeriodicTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */