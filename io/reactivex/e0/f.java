package io.reactivex.e0;

import java.util.concurrent.atomic.AtomicReference;

final class f
  extends e<Runnable>
{
  f(Runnable paramRunnable)
  {
    super(paramRunnable);
  }
  
  protected void b(Runnable paramRunnable)
  {
    paramRunnable.run();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RunnableDisposable(disposed=");
    localStringBuilder.append(isDisposed());
    localStringBuilder.append(", ");
    localStringBuilder.append(get());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\e0\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */