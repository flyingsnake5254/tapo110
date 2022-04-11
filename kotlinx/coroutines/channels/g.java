package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.TypeCastException;
import kotlin.p;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.a;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.j1;

public class g<E>
  extends a<p>
  implements f<E>
{
  private final f<E> q;
  
  public g(kotlin.coroutines.f paramf, f<E> paramf1, boolean paramBoolean)
  {
    super(paramf, paramBoolean);
    this.q = paramf1;
  }
  
  public final void a(CancellationException paramCancellationException)
  {
    x(paramCancellationException);
  }
  
  public kotlinx.coroutines.selects.c<E> e()
  {
    return this.q.e();
  }
  
  public h<E> iterator()
  {
    return this.q.iterator();
  }
  
  public boolean m(Throwable paramThrowable)
  {
    return this.q.m(paramThrowable);
  }
  
  public Object n(E paramE, kotlin.coroutines.c<? super p> paramc)
  {
    return x0(this, paramE, paramc);
  }
  
  public final f<E> v0()
  {
    return this;
  }
  
  protected final f<E> w0()
  {
    return this.q;
  }
  
  public boolean x(Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      paramThrowable = j1.h0(this, paramThrowable, null, 1, null);
      if (paramThrowable != null) {}
    }
    else
    {
      paramThrowable = new StringBuilder();
      paramThrowable.append(h0.a(this));
      paramThrowable.append(" was cancelled");
      paramThrowable = new JobCancellationException(paramThrowable.toString(), null, this);
    }
    this.q.a(paramThrowable);
    v(paramThrowable);
    return true;
  }
  
  public final Object y0(E paramE, kotlin.coroutines.c<? super p> paramc)
  {
    f localf = this.q;
    if (localf != null) {
      return ((c)localf).y(paramE, paramc);
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.AbstractSendChannel<E>");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\channels\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */