package kotlinx.coroutines.channels;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlinx.coroutines.h;

public final class w
  extends u
{
  private final Object q;
  public final h<p> x;
  
  public w(Object paramObject, h<? super p> paramh)
  {
    this.q = paramObject;
    this.x = paramh;
  }
  
  public void L(Object paramObject)
  {
    j.f(paramObject, "token");
    this.x.p(paramObject);
  }
  
  public Object M()
  {
    return this.q;
  }
  
  public void N(k<?> paramk)
  {
    j.f(paramk, "closed");
    h localh = this.x;
    Throwable localThrowable = paramk.S();
    paramk = Result.Companion;
    localh.resumeWith(Result.constructor-impl(kotlin.k.a(localThrowable)));
  }
  
  public Object O(Object paramObject)
  {
    return this.x.b(p.a, paramObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SendElement(");
    localStringBuilder.append(M());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\channels\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */