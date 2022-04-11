package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class RxThreadFactory
  extends AtomicLong
  implements ThreadFactory
{
  private static final long serialVersionUID = -7789753024099756196L;
  final boolean nonBlocking;
  final String prefix;
  final int priority;
  
  public RxThreadFactory(String paramString)
  {
    this(paramString, 5, false);
  }
  
  public RxThreadFactory(String paramString, int paramInt)
  {
    this(paramString, paramInt, false);
  }
  
  public RxThreadFactory(String paramString, int paramInt, boolean paramBoolean)
  {
    this.prefix = paramString;
    this.priority = paramInt;
    this.nonBlocking = paramBoolean;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    Object localObject = new StringBuilder(this.prefix);
    ((StringBuilder)localObject).append('-');
    ((StringBuilder)localObject).append(incrementAndGet());
    localObject = ((StringBuilder)localObject).toString();
    if (this.nonBlocking) {
      paramRunnable = new a(paramRunnable, (String)localObject);
    } else {
      paramRunnable = new Thread(paramRunnable, (String)localObject);
    }
    paramRunnable.setPriority(this.priority);
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RxThreadFactory[");
    localStringBuilder.append(this.prefix);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  static final class a
    extends Thread
    implements i
  {
    a(Runnable paramRunnable, String paramString)
    {
      super(paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\schedulers\RxThreadFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */