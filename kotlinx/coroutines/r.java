package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class r
{
  private static final AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(r.class, "_handled");
  private volatile int _handled;
  public final Throwable b;
  
  public r(Throwable paramThrowable, boolean paramBoolean)
  {
    this.b = paramThrowable;
    this._handled = paramBoolean;
  }
  
  public final boolean a()
  {
    return this._handled;
  }
  
  public final boolean b()
  {
    return a.compareAndSet(this, 0, 1);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(h0.a(this));
    localStringBuilder.append('[');
    localStringBuilder.append(this.b);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */