package kotlinx.coroutines.internal;

import a;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.sequences.g;
import kotlinx.coroutines.m1;

public final class l
{
  private static final boolean a;
  public static final m1 b;
  public static final l c;
  
  static
  {
    l locall = new l();
    c = locall;
    a = u.e("kotlinx.coroutines.fast.service.loader", true);
    b = locall.a();
  }
  
  private final m1 a()
  {
    n localn;
    try
    {
      Object localObject2;
      if (a)
      {
        localObject1 = f.a;
        localObject2 = MainDispatcherFactory.class.getClassLoader();
        j.b(localObject2, "clz.classLoader");
        localObject2 = ((f)localObject1).b(MainDispatcherFactory.class, (ClassLoader)localObject2);
      }
      else
      {
        localObject1 = a.b();
        j.b(localObject1, "ServiceLoader.load(\n    …             ).iterator()");
        localObject2 = g.i(g.a((Iterator)localObject1));
      }
      Iterator localIterator = ((Iterable)localObject2).iterator();
      if (!localIterator.hasNext())
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = localIterator.next();
        if (localIterator.hasNext())
        {
          int i = ((MainDispatcherFactory)localObject1).c();
          Object localObject3 = localObject1;
          do
          {
            Object localObject4 = localIterator.next();
            int j = ((MainDispatcherFactory)localObject4).c();
            localObject1 = localObject3;
            int k = i;
            if (i < j)
            {
              localObject1 = localObject4;
              k = j;
            }
            localObject3 = localObject1;
            i = k;
          } while (localIterator.hasNext());
        }
      }
      Object localObject1 = (MainDispatcherFactory)localObject1;
      if (localObject1 != null)
      {
        localObject1 = m.a((MainDispatcherFactory)localObject1, (List)localObject2);
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = new kotlinx/coroutines/internal/n;
        ((n)localObject1).<init>(null, null, 2, null);
      }
    }
    finally
    {
      localn = new n(localThrowable, null, 2, null);
    }
    return localn;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\internal\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */