package kotlinx.coroutines;

import kotlin.jvm.b.l;
import kotlin.p;

final class a1
  extends f
{
  private final l<Throwable, p> c;
  
  public a1(l<? super Throwable, p> paraml)
  {
    this.c = paraml;
  }
  
  public void a(Throwable paramThrowable)
  {
    this.c.invoke(paramThrowable);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InvokeOnCancel[");
    localStringBuilder.append(h0.a(this.c));
    localStringBuilder.append('@');
    localStringBuilder.append(h0.b(this));
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\a1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */