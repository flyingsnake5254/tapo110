package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.b.l;
import kotlin.p;

final class b1
  extends e1<d1>
{
  private static final AtomicIntegerFieldUpdater x = AtomicIntegerFieldUpdater.newUpdater(b1.class, "_invoked");
  private volatile int _invoked;
  private final l<Throwable, p> y;
  
  public b1(d1 paramd1, l<? super Throwable, p> paraml)
  {
    super(paramd1);
    this.y = paraml;
    this._invoked = 0;
  }
  
  public void L(Throwable paramThrowable)
  {
    if (x.compareAndSet(this, 0, 1)) {
      this.y.invoke(paramThrowable);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InvokeOnCancelling[");
    localStringBuilder.append(h0.a(this));
    localStringBuilder.append('@');
    localStringBuilder.append(h0.b(this));
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\b1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */