package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.g0;

public final class k<E>
{
  private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_next");
  public static final t c;
  public static final a d = new a(null);
  private volatile Object _next;
  private final int e;
  private final int g;
  private final boolean h;
  
  static
  {
    c = new t("REMOVE_FROZEN");
  }
  
  public k(int paramInt, boolean paramBoolean)
  {
    this.g = paramInt;
    this.h = paramBoolean;
    int i = paramInt - 1;
    this.e = i;
    this._next = null;
    this._state$internal = 0L;
    this.f = new AtomicReferenceArray(paramInt);
    int j = 0;
    int k;
    if (i <= 1073741823) {
      k = 1;
    } else {
      k = 0;
    }
    if (k != 0)
    {
      k = j;
      if ((paramInt & i) == 0) {
        k = 1;
      }
      if (k != 0) {
        return;
      }
      throw new IllegalStateException("Check failed.".toString());
    }
    throw new IllegalStateException("Check failed.".toString());
  }
  
  private final k<E> e(long paramLong)
  {
    k localk = new k(this.g * 2, this.h);
    int i = (int)((0x3FFFFFFF & paramLong) >> 0);
    int j = (int)((0xFFFFFFFC0000000 & paramLong) >> 30);
    for (;;)
    {
      int k = this.e;
      if ((i & k) == (j & k)) {
        break;
      }
      Object localObject = this.f.get(k & i);
      if (localObject == null) {
        localObject = new b(i);
      }
      localk.f.set(localk.e & i, localObject);
      i++;
    }
    localk._state$internal = d.d(paramLong, 1152921504606846976L);
    return localk;
  }
  
  private final k<E> f(long paramLong)
  {
    for (;;)
    {
      k localk = (k)this._next;
      if (localk != null) {
        return localk;
      }
      a.compareAndSet(this, null, e(paramLong));
    }
  }
  
  private final k<E> h(int paramInt, E paramE)
  {
    Object localObject = this.f.get(this.e & paramInt);
    if (((localObject instanceof b)) && (((b)localObject).a == paramInt))
    {
      this.f.set(paramInt & this.e, paramE);
      return this;
    }
    return null;
  }
  
  private final long k()
  {
    long l1;
    long l2;
    do
    {
      l1 = this._state$internal;
      if ((l1 & 0x1000000000000000) != 0L) {
        return l1;
      }
      l2 = l1 | 0x1000000000000000;
    } while (!b.compareAndSet(this, l1, l2));
    return l2;
  }
  
  private final k<E> n(int paramInt1, int paramInt2)
  {
    long l;
    a locala;
    int j;
    do
    {
      l = this._state$internal;
      locala = d;
      int i = 0;
      j = (int)((0x3FFFFFFF & l) >> 0);
      if (g0.a())
      {
        if (j == paramInt1) {
          i = 1;
        }
        if (i == 0) {
          throw new AssertionError();
        }
      }
      if ((0x1000000000000000 & l) != 0L) {
        return l();
      }
    } while (!b.compareAndSet(this, l, locala.b(l, paramInt2)));
    this.f.set(this.e & j, null);
    return null;
  }
  
  public final int d(E paramE)
  {
    j.f(paramE, "element");
    long l;
    int j;
    int k;
    do
    {
      int i;
      do
      {
        l = this._state$internal;
        if ((0x3000000000000000 & l) != 0L) {
          return d.a(l);
        }
        localObject = d;
        i = (int)((0x3FFFFFFF & l) >> 0);
        j = (int)((0xFFFFFFFC0000000 & l) >> 30);
        k = this.e;
        if ((j + 2 & k) == (i & k)) {
          return 1;
        }
        if ((this.h) || (this.f.get(j & k) == null)) {
          break;
        }
        k = this.g;
      } while ((k >= 1024) && ((j - i & 0x3FFFFFFF) <= k >> 1));
      return 1;
    } while (!b.compareAndSet(this, l, ((a)localObject).c(l, j + 1 & 0x3FFFFFFF)));
    this.f.set(j & k, paramE);
    Object localObject = this;
    do
    {
      if ((((k)localObject)._state$internal & 0x1000000000000000) == 0L) {
        break;
      }
      localObject = ((k)localObject).l().h(j, paramE);
    } while (localObject != null);
    return 0;
  }
  
  public final boolean g()
  {
    long l;
    do
    {
      l = this._state$internal;
      if ((l & 0x2000000000000000) != 0L) {
        return true;
      }
      if ((0x1000000000000000 & l) != 0L) {
        return false;
      }
    } while (!b.compareAndSet(this, l, l | 0x2000000000000000));
    return true;
  }
  
  public final int i()
  {
    long l = this._state$internal;
    int i = (int)((0x3FFFFFFF & l) >> 0);
    return 0x3FFFFFFF & (int)((l & 0xFFFFFFFC0000000) >> 30) - i;
  }
  
  public final boolean j()
  {
    long l = this._state$internal;
    boolean bool = false;
    if ((int)((0x3FFFFFFF & l) >> 0) == (int)((l & 0xFFFFFFFC0000000) >> 30)) {
      bool = true;
    }
    return bool;
  }
  
  public final k<E> l()
  {
    return f(k());
  }
  
  public final Object m()
  {
    int i;
    Object localObject2;
    int j;
    do
    {
      long l;
      a locala;
      do
      {
        l = this._state$internal;
        localObject1 = null;
        if ((0x1000000000000000 & l) != 0L) {
          return c;
        }
        locala = d;
        i = (int)((0x3FFFFFFF & l) >> 0);
        if (((int)((0xFFFFFFFC0000000 & l) >> 30) & a(this)) == (a(this) & i)) {
          return localObject1;
        }
        localObject2 = this.f.get(a(this) & i);
        if (localObject2 != null) {
          break;
        }
      } while (!b(this));
      return localObject1;
      if ((localObject2 instanceof b)) {
        return localObject1;
      }
      j = i + 1 & 0x3FFFFFFF;
      if (b.compareAndSet(this, l, locala.b(l, j)))
      {
        this.f.set(a(this) & i, null);
        break;
      }
    } while (!b(this));
    Object localObject1 = this;
    do
    {
      localObject1 = c((k)localObject1, i, j);
    } while (localObject1 != null);
    localObject1 = localObject2;
    return localObject1;
  }
  
  public static final class a
  {
    public final int a(long paramLong)
    {
      int i;
      if ((paramLong & 0x2000000000000000) != 0L) {
        i = 2;
      } else {
        i = 1;
      }
      return i;
    }
    
    public final long b(long paramLong, int paramInt)
    {
      return d(paramLong, 1073741823L) | paramInt << 0;
    }
    
    public final long c(long paramLong, int paramInt)
    {
      return d(paramLong, 1152921503533105152L) | paramInt << 30;
    }
    
    public final long d(long paramLong1, long paramLong2)
    {
      return paramLong1 & (paramLong2 ^ 0xFFFFFFFFFFFFFFFF);
    }
  }
  
  public static final class b
  {
    public final int a;
    
    public b(int paramInt)
    {
      this.a = paramInt;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\internal\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */