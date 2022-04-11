package kotlin.internal;

import java.lang.reflect.Method;
import kotlin.collections.e;
import kotlin.jvm.internal.j;
import kotlin.u.b;
import kotlin.u.c;

public class a
{
  public void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    j.e(paramThrowable1, "cause");
    j.e(paramThrowable2, "exception");
    Method localMethod = a.a;
    if (localMethod != null) {
      localMethod.invoke(paramThrowable1, new Object[] { paramThrowable2 });
    }
  }
  
  public c b()
  {
    return new b();
  }
  
  private static final class a
  {
    public static final Method a;
    public static final Method b;
    public static final a c = new a();
    
    static
    {
      Method[] arrayOfMethod = Throwable.class.getMethods();
      j.d(arrayOfMethod, "throwableMethods");
      int i = arrayOfMethod.length;
      int j = 0;
      Object localObject1;
      for (int k = 0;; k++)
      {
        localObject1 = null;
        if (k >= i) {
          break;
        }
        localObject2 = arrayOfMethod[k];
        j.d(localObject2, "it");
        if (j.a(((Method)localObject2).getName(), "addSuppressed"))
        {
          Class[] arrayOfClass = ((Method)localObject2).getParameterTypes();
          j.d(arrayOfClass, "it.parameterTypes");
          if (j.a((Class)e.s(arrayOfClass), Throwable.class))
          {
            m = 1;
            break label101;
          }
        }
        m = 0;
        label101:
        if (m != 0) {
          break label118;
        }
      }
      Object localObject2 = null;
      label118:
      a = (Method)localObject2;
      int m = arrayOfMethod.length;
      for (k = j;; k++)
      {
        localObject2 = localObject1;
        if (k >= m) {
          break;
        }
        localObject2 = arrayOfMethod[k];
        j.d(localObject2, "it");
        if (j.a(((Method)localObject2).getName(), "getSuppressed")) {
          break;
        }
      }
      b = (Method)localObject2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\internal\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */