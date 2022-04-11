package kotlinx.coroutines;

import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.a;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class c2
{
  public static final void a(kotlin.coroutines.f paramf)
  {
    j.f(paramf, "$this$checkCompletion");
    paramf = (d1)paramf.get(d1.h);
    if ((paramf != null) && (!paramf.isActive())) {
      throw paramf.i();
    }
  }
  
  public static final Object b(c<? super p> paramc)
  {
    kotlin.coroutines.f localf = paramc.getContext();
    a(localf);
    c localc = a.c(paramc);
    Object localObject = localc;
    if (!(localc instanceof j0)) {
      localObject = null;
    }
    localObject = (j0)localObject;
    if (localObject != null)
    {
      if (!((j0)localObject).z.isDispatchNeeded(localf))
      {
        if (l0.i((j0)localObject)) {
          localObject = a.d();
        } else {
          localObject = p.a;
        }
      }
      else
      {
        ((j0)localObject).k(p.a);
        localObject = a.d();
      }
    }
    else {
      localObject = p.a;
    }
    if (localObject == a.d()) {
      kotlin.coroutines.jvm.internal.f.c(paramc);
    }
    return localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\c2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */