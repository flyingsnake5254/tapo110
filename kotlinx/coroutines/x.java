package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.coroutines.d;
import kotlin.coroutines.f;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.scheduling.b;

public final class x
{
  private static final boolean a;
  
  static
  {
    String str = u.d("kotlinx.coroutines.scheduler");
    if (str != null)
    {
      int i = str.hashCode();
      if (i != 0)
      {
        if (i != 3551)
        {
          if ((i != 109935) || (!str.equals("off"))) {
            break label77;
          }
          bool = false;
          break label72;
        }
        if (!str.equals("on")) {
          break label77;
        }
      }
      else
      {
        if (!str.equals("")) {
          break label77;
        }
      }
    }
    boolean bool = true;
    label72:
    a = bool;
    return;
    label77:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("System property 'kotlinx.coroutines.scheduler' has unrecognized value '");
    localStringBuilder.append(str);
    localStringBuilder.append('\'');
    throw new IllegalStateException(localStringBuilder.toString().toString());
  }
  
  public static final y a()
  {
    Object localObject;
    if (a) {
      localObject = b.z;
    } else {
      localObject = p.f;
    }
    return (y)localObject;
  }
  
  public static final String b(f paramf)
  {
    j.f(paramf, "$this$coroutineName");
    if (!g0.c()) {
      return null;
    }
    b0 localb0 = (b0)paramf.get(b0.c);
    if (localb0 != null)
    {
      paramf = (c0)paramf.get(c0.c);
      if (paramf != null)
      {
        paramf = paramf.u();
        if (paramf != null) {}
      }
      else
      {
        paramf = "coroutine";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramf);
      localStringBuilder.append('#');
      localStringBuilder.append(localb0.u());
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static final f c(d0 paramd0, f paramf)
  {
    j.f(paramd0, "$this$newCoroutineContext");
    j.f(paramf, "context");
    f localf = paramd0.getCoroutineContext().plus(paramf);
    if (g0.c()) {
      paramd0 = localf.plus(new b0(g0.b().incrementAndGet()));
    } else {
      paramd0 = localf;
    }
    paramf = paramd0;
    if (localf != n0.a())
    {
      paramf = paramd0;
      if (localf.get(d.e) == null) {
        paramf = paramd0.plus(n0.a());
      }
    }
    return paramf;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */