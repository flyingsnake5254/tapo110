package kotlinx.coroutines;

import kotlin.coroutines.f;
import kotlin.jvm.internal.j;
import kotlin.p;

class t1
  extends a<p>
{
  public t1(f paramf, boolean paramBoolean)
  {
    super(paramf, paramBoolean);
  }
  
  protected boolean M(Throwable paramThrowable)
  {
    j.f(paramThrowable, "exception");
    a0.a(getContext(), paramThrowable);
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\t1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */