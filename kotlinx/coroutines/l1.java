package kotlinx.coroutines;

import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlinx.coroutines.d2.a;

final class l1
  extends t1
{
  private kotlin.jvm.b.p<? super d0, ? super c<? super kotlin.p>, ? extends Object> q;
  
  public l1(f paramf, kotlin.jvm.b.p<? super d0, ? super c<? super kotlin.p>, ? extends Object> paramp)
  {
    super(paramf, false);
    this.q = paramp;
  }
  
  protected void t0()
  {
    kotlin.jvm.b.p localp = this.q;
    if (localp != null)
    {
      this.q = null;
      a.b(localp, this, this);
      return;
    }
    throw new IllegalStateException("Already started".toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\l1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */