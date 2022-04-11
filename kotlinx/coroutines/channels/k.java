package kotlinx.coroutines.channels;

import kotlin.jvm.internal.j;
import kotlinx.coroutines.g0;

public final class k<E>
  extends u
  implements s<E>
{
  public final Throwable q;
  
  public k(Throwable paramThrowable)
  {
    this.q = paramThrowable;
  }
  
  public void L(Object paramObject)
  {
    j.f(paramObject, "token");
    if (g0.a())
    {
      int i;
      if (paramObject == b.g) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw new AssertionError();
      }
    }
  }
  
  public void N(k<?> paramk)
  {
    j.f(paramk, "closed");
    if (g0.a()) {
      throw new AssertionError();
    }
  }
  
  public Object O(Object paramObject)
  {
    return b.g;
  }
  
  public k<E> P()
  {
    return this;
  }
  
  public k<E> Q()
  {
    return this;
  }
  
  public final Throwable R()
  {
    Object localObject = this.q;
    if (localObject == null) {
      localObject = new ClosedReceiveChannelException("Channel was closed");
    }
    return (Throwable)localObject;
  }
  
  public final Throwable S()
  {
    Object localObject = this.q;
    if (localObject == null) {
      localObject = new ClosedSendChannelException("Channel was closed");
    }
    return (Throwable)localObject;
  }
  
  public void j(Object paramObject)
  {
    j.f(paramObject, "token");
    if (g0.a())
    {
      int i;
      if (paramObject == b.g) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw new AssertionError();
      }
    }
  }
  
  public Object m(E paramE, Object paramObject)
  {
    return b.g;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Closed[");
    localStringBuilder.append(this.q);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\channels\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */