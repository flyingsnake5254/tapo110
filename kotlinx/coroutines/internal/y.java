package kotlinx.coroutines.internal;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.g0;

public class y<T extends z,  extends Comparable<? super T>>
{
  private static final AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(y.class, "_size");
  private volatile int _size = 0;
  private T[] b;
  
  private final T[] f()
  {
    z[] arrayOfz = this.b;
    Object localObject;
    if (arrayOfz == null)
    {
      localObject = new z[4];
      this.b = ((z[])localObject);
    }
    else
    {
      localObject = arrayOfz;
      if (c() >= arrayOfz.length)
      {
        localObject = Arrays.copyOf(arrayOfz, c() * 2);
        j.b(localObject, "java.util.Arrays.copyOf(this, newSize)");
        localObject = (z[])localObject;
        this.b = ((z[])localObject);
      }
    }
    return (T[])localObject;
  }
  
  private final void j(int paramInt)
  {
    this._size = paramInt;
  }
  
  private final void k(int paramInt)
  {
    for (int i = paramInt;; i = paramInt)
    {
      int j = i * 2 + 1;
      if (j >= c()) {
        return;
      }
      Object localObject1 = this.b;
      if (localObject1 == null) {
        j.n();
      }
      int k = j + 1;
      paramInt = j;
      if (k < c())
      {
        localComparable = localObject1[k];
        if (localComparable == null) {
          j.n();
        }
        localComparable = (Comparable)localComparable;
        Object localObject2 = localObject1[j];
        if (localObject2 == null) {
          j.n();
        }
        paramInt = j;
        if (localComparable.compareTo(localObject2) < 0) {
          paramInt = k;
        }
      }
      Comparable localComparable = localObject1[i];
      if (localComparable == null) {
        j.n();
      }
      localComparable = (Comparable)localComparable;
      localObject1 = localObject1[paramInt];
      if (localObject1 == null) {
        j.n();
      }
      if (localComparable.compareTo(localObject1) <= 0) {
        return;
      }
      m(i, paramInt);
    }
  }
  
  private final void l(int paramInt)
  {
    for (;;)
    {
      if (paramInt <= 0) {
        return;
      }
      Object localObject = this.b;
      if (localObject == null) {
        j.n();
      }
      int i = (paramInt - 1) / 2;
      Comparable localComparable = localObject[i];
      if (localComparable == null) {
        j.n();
      }
      localComparable = (Comparable)localComparable;
      localObject = localObject[paramInt];
      if (localObject == null) {
        j.n();
      }
      if (localComparable.compareTo(localObject) <= 0) {
        return;
      }
      m(paramInt, i);
      paramInt = i;
    }
  }
  
  private final void m(int paramInt1, int paramInt2)
  {
    z[] arrayOfz = this.b;
    if (arrayOfz == null) {
      j.n();
    }
    z localz1 = arrayOfz[paramInt2];
    if (localz1 == null) {
      j.n();
    }
    z localz2 = arrayOfz[paramInt1];
    if (localz2 == null) {
      j.n();
    }
    arrayOfz[paramInt1] = localz1;
    arrayOfz[paramInt2] = localz2;
    localz1.h(paramInt1);
    localz2.h(paramInt2);
  }
  
  public final void a(T paramT)
  {
    j.f(paramT, "node");
    if (g0.a())
    {
      if (paramT.b() == null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw new AssertionError();
      }
    }
    paramT.a(this);
    z[] arrayOfz = f();
    int i = c();
    j(i + 1);
    arrayOfz[i] = paramT;
    paramT.h(i);
    l(i);
  }
  
  public final T b()
  {
    Object localObject = this.b;
    if (localObject != null) {
      localObject = localObject[0];
    } else {
      localObject = null;
    }
    return (T)localObject;
  }
  
  public final int c()
  {
    return this._size;
  }
  
  public final boolean d()
  {
    boolean bool;
    if (c() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final T e()
  {
    try
    {
      z localz = b();
      return localz;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean g(T paramT)
  {
    j.f(paramT, "node");
    try
    {
      y localy = paramT.b();
      boolean bool = true;
      int i = 0;
      if (localy == null)
      {
        bool = false;
      }
      else
      {
        int j = paramT.d();
        if (g0.a())
        {
          if (j >= 0) {
            i = 1;
          }
          if (i == 0)
          {
            paramT = new java/lang/AssertionError;
            paramT.<init>();
            throw paramT;
          }
        }
        h(j);
      }
      return bool;
    }
    finally {}
  }
  
  public final T h(int paramInt)
  {
    boolean bool = g0.a();
    int i = 0;
    int j;
    if (bool)
    {
      if (c() > 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (j == 0) {
        throw new AssertionError();
      }
    }
    z[] arrayOfz = this.b;
    if (arrayOfz == null) {
      j.n();
    }
    j(c() - 1);
    if (paramInt < c())
    {
      m(paramInt, c());
      j = (paramInt - 1) / 2;
      if (paramInt > 0)
      {
        localObject = arrayOfz[paramInt];
        if (localObject == null) {
          j.n();
        }
        localObject = (Comparable)localObject;
        z localz = arrayOfz[j];
        if (localz == null) {
          j.n();
        }
        if (((Comparable)localObject).compareTo(localz) < 0)
        {
          m(paramInt, j);
          l(j);
          break label163;
        }
      }
      k(paramInt);
    }
    label163:
    Object localObject = arrayOfz[c()];
    if (localObject == null) {
      j.n();
    }
    if (g0.a())
    {
      paramInt = i;
      if (((z)localObject).b() == this) {
        paramInt = 1;
      }
      if (paramInt == 0) {
        throw new AssertionError();
      }
    }
    ((z)localObject).a(null);
    ((z)localObject).h(-1);
    arrayOfz[c()] = null;
    return (T)localObject;
  }
  
  public final T i()
  {
    try
    {
      z localz;
      if (c() > 0) {
        localz = h(0);
      } else {
        localz = null;
      }
      return localz;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\internal\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */