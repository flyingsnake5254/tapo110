package kotlin.coroutines;

import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;

public abstract class a
  implements f.b
{
  private final f.c<?> key;
  
  public a(f.c<?> paramc)
  {
    this.key = paramc;
  }
  
  public <R> R fold(R paramR, p<? super R, ? super f.b, ? extends R> paramp)
  {
    j.e(paramp, "operation");
    return (R)f.b.a.a(this, paramR, paramp);
  }
  
  public <E extends f.b> E get(f.c<E> paramc)
  {
    j.e(paramc, "key");
    return f.b.a.b(this, paramc);
  }
  
  public f.c<?> getKey()
  {
    return this.key;
  }
  
  public f minusKey(f.c<?> paramc)
  {
    j.e(paramc, "key");
    return f.b.a.c(this, paramc);
  }
  
  public f plus(f paramf)
  {
    j.e(paramf, "context");
    return f.b.a.d(this, paramf);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\coroutines\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */