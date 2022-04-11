package kotlinx.coroutines;

import kotlin.jvm.b.l;
import kotlin.p;

final class c1
  extends i1<d1>
{
  private final l<Throwable, p> x;
  
  public c1(d1 paramd1, l<? super Throwable, p> paraml)
  {
    super(paramd1);
    this.x = paraml;
  }
  
  public void L(Throwable paramThrowable)
  {
    this.x.invoke(paramThrowable);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InvokeOnCompletion[");
    localStringBuilder.append(h0.a(this));
    localStringBuilder.append('@');
    localStringBuilder.append(h0.b(this));
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\c1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */