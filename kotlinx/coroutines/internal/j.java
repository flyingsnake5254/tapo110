package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class j<E>
{
  public j(boolean paramBoolean)
  {
    this._cur$internal = new k(8, paramBoolean);
  }
  
  public final boolean a(E paramE)
  {
    kotlin.jvm.internal.j.f(paramE, "element");
    for (;;)
    {
      k localk = (k)this._cur$internal;
      int i = localk.d(paramE);
      if (i == 0) {
        break;
      }
      if (i != 1)
      {
        if (i == 2) {
          return false;
        }
      }
      else {
        a.compareAndSet(this, localk, localk.l());
      }
    }
    return true;
  }
  
  public final void b()
  {
    for (;;)
    {
      k localk = (k)this._cur$internal;
      if (localk.g()) {
        return;
      }
      a.compareAndSet(this, localk, localk.l());
    }
  }
  
  public final int c()
  {
    return ((k)this._cur$internal).i();
  }
  
  public final E d()
  {
    for (;;)
    {
      k localk = (k)this._cur$internal;
      int i;
      Object localObject2;
      int j;
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
            break label200;
          }
          locala = k.d;
          i = (int)((0x3FFFFFFF & l) >> 0);
          if (((int)((0xFFFFFFFC0000000 & l) >> 30) & k.a(localk)) == (k.a(localk) & i)) {
            break label200;
          }
          localObject2 = localk.f.get(k.a(localk) & i);
          if (localObject2 != null) {
            break;
          }
        } while (!k.b(localk));
        break label200;
        if ((localObject2 instanceof k.b)) {
          break label200;
        }
        j = i + 1 & 0x3FFFFFFF;
        if (k.b.compareAndSet(localk, l, locala.b(l, j)))
        {
          localk.f.set(k.a(localk) & i, null);
          break;
        }
      } while (!k.b(localk));
      Object localObject1 = localk;
      do
      {
        localObject1 = k.c((k)localObject1, i, j);
      } while (localObject1 != null);
      localObject1 = localObject2;
      label200:
      if (localObject1 != k.c) {
        return (E)localObject1;
      }
      a.compareAndSet(this, localk, localk.l());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\internal\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */