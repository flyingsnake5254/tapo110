package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.k;
import kotlinx.coroutines.internal.k.a;
import kotlinx.coroutines.internal.k.b;

public class d
  extends kotlinx.coroutines.internal.j<h>
{
  public d()
  {
    super(false);
  }
  
  public final h e(TaskMode paramTaskMode)
  {
    kotlin.jvm.internal.j.f(paramTaskMode, "mode");
    for (;;)
    {
      k localk = (k)this._cur$internal;
      int i;
      int j;
      Object localObject2;
      do
      {
        long l;
        k.a locala;
        do
        {
          l = localk._state$internal;
          localObject1 = null;
          if ((0x1000000000000000 & l) != 0L)
          {
            localObject1 = k.c;
            break label236;
          }
          locala = k.d;
          i = 0;
          j = (int)((0x3FFFFFFF & l) >> 0);
          int k = (int)((0xFFFFFFFC0000000 & l) >> 30);
          if ((k.a(localk) & k) == (k.a(localk) & j)) {
            break label236;
          }
          localObject2 = localk.f.get(k.a(localk) & j);
          if (localObject2 != null) {
            break;
          }
        } while (!k.b(localk));
        break label236;
        if ((localObject2 instanceof k.b)) {
          break label236;
        }
        if (((h)localObject2).a() == paramTaskMode) {
          i = 1;
        }
        if (i == 0) {
          break label236;
        }
        i = j + 1 & 0x3FFFFFFF;
        if (k.b.compareAndSet(localk, l, locala.b(l, i)))
        {
          localk.f.set(k.a(localk) & j, null);
          break;
        }
      } while (!k.b(localk));
      Object localObject1 = localk;
      do
      {
        localObject1 = k.c((k)localObject1, j, i);
      } while (localObject1 != null);
      localObject1 = localObject2;
      label236:
      if (localObject1 != k.c) {
        return (h)localObject1;
      }
      kotlinx.coroutines.internal.j.a.compareAndSet(this, localk, localk.l());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\scheduling\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */