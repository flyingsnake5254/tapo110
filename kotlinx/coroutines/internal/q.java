package kotlinx.coroutines.internal;

import kotlin.coroutines.f;
import kotlinx.coroutines.a;
import kotlinx.coroutines.r;
import kotlinx.coroutines.s1;

public class q<T>
  extends a<T>
  implements kotlin.coroutines.jvm.internal.c
{
  public final kotlin.coroutines.c<T> q;
  
  public q(f paramf, kotlin.coroutines.c<? super T> paramc)
  {
    super(paramf, true);
    this.q = paramc;
  }
  
  protected final boolean Q()
  {
    return true;
  }
  
  public final kotlin.coroutines.jvm.internal.c getCallerFrame()
  {
    return (kotlin.coroutines.jvm.internal.c)this.q;
  }
  
  public final StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  public int p0()
  {
    return 2;
  }
  
  protected void u(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof r))
    {
      paramObject = ((r)paramObject).b;
      if (paramInt != 4) {
        paramObject = s.k((Throwable)paramObject, this.q);
      }
      s1.e(this.q, (Throwable)paramObject, paramInt);
    }
    else
    {
      s1.d(this.q, paramObject, paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\internal\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */