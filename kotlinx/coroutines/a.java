package kotlinx.coroutines;

import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;

public abstract class a<T>
  extends j1
  implements d1, c<T>, d0
{
  private final f d;
  protected final f f;
  
  public a(f paramf, boolean paramBoolean)
  {
    super(paramBoolean);
    this.f = paramf;
    this.d = paramf.plus(this);
  }
  
  public final void N(Throwable paramThrowable)
  {
    j.f(paramThrowable, "exception");
    a0.a(this.d, paramThrowable);
  }
  
  public String U()
  {
    String str = x.b(this.d);
    if (str != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('"');
      localStringBuilder.append(str);
      localStringBuilder.append("\":");
      localStringBuilder.append(super.U());
      return localStringBuilder.toString();
    }
    return super.U();
  }
  
  protected final void Z(Object paramObject)
  {
    if ((paramObject instanceof r))
    {
      paramObject = (r)paramObject;
      r0(((r)paramObject).b, ((r)paramObject).a());
    }
    else
    {
      s0(paramObject);
    }
  }
  
  public final void a0()
  {
    t0();
  }
  
  public final f getContext()
  {
    return this.d;
  }
  
  public f getCoroutineContext()
  {
    return this.d;
  }
  
  public boolean isActive()
  {
    return super.isActive();
  }
  
  public int p0()
  {
    return 0;
  }
  
  public final void q0()
  {
    O((d1)this.f.get(d1.h));
  }
  
  protected void r0(Throwable paramThrowable, boolean paramBoolean)
  {
    j.f(paramThrowable, "cause");
  }
  
  public final void resumeWith(Object paramObject)
  {
    S(s.a(paramObject), p0());
  }
  
  protected void s0(T paramT) {}
  
  protected void t0() {}
  
  public final <R> void u0(CoroutineStart paramCoroutineStart, R paramR, p<? super R, ? super c<? super T>, ? extends Object> paramp)
  {
    j.f(paramCoroutineStart, "start");
    j.f(paramp, "block");
    q0();
    paramCoroutineStart.invoke(paramp, paramR, this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */