package com.google.common.hash;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

abstract class n
  extends Number
{
  static final ThreadLocal<int[]> c = new ThreadLocal();
  static final Random d = new Random();
  static final int f = Runtime.getRuntime().availableProcessors();
  private static final Unsafe q;
  private static final long x;
  private static final long y;
  volatile transient long p0;
  volatile transient int p1;
  @NullableDecl
  volatile transient b[] z;
  
  static
  {
    try
    {
      Unsafe localUnsafe = h();
      q = localUnsafe;
      x = localUnsafe.objectFieldOffset(n.class.getDeclaredField("p0"));
      y = localUnsafe.objectFieldOffset(n.class.getDeclaredField("p1"));
      return;
    }
    catch (Exception localException)
    {
      throw new Error(localException);
    }
  }
  
  private static Unsafe h()
  {
    try
    {
      Unsafe localUnsafe = Unsafe.getUnsafe();
      return localUnsafe;
    }
    catch (SecurityException localSecurityException)
    {
      try
      {
        Object localObject = new com/google/common/hash/n$a;
        ((a)localObject).<init>();
        localObject = (Unsafe)AccessController.doPrivileged((PrivilegedExceptionAction)localObject);
        return (Unsafe)localObject;
      }
      catch (PrivilegedActionException localPrivilegedActionException)
      {
        throw new RuntimeException("Could not initialize intrinsics", localPrivilegedActionException.getCause());
      }
    }
  }
  
  final boolean d(long paramLong1, long paramLong2)
  {
    return q.compareAndSwapLong(this, x, paramLong1, paramLong2);
  }
  
  final boolean f()
  {
    return q.compareAndSwapInt(this, y, 0, 1);
  }
  
  abstract long g(long paramLong1, long paramLong2);
  
  final void i(long paramLong, @NullableDecl int[] paramArrayOfInt, boolean paramBoolean)
  {
    Object localObject1;
    int i;
    if (paramArrayOfInt == null)
    {
      localObject1 = c;
      paramArrayOfInt = new int[1];
      ((ThreadLocal)localObject1).set(paramArrayOfInt);
      i = d.nextInt();
      j = i;
      if (i == 0) {
        j = 1;
      }
      paramArrayOfInt[0] = j;
    }
    else
    {
      j = paramArrayOfInt[0];
    }
    int k = j;
    int j = 0;
    label182:
    long l;
    do
    {
      for (;;)
      {
        localObject1 = this.z;
        Object localObject2;
        if (localObject1 != null)
        {
          int m = localObject1.length;
          if (m > 0)
          {
            localObject2 = localObject1[(m - 1 & k)];
            if (localObject2 == null) {
              if (this.p1 == 0)
              {
                localObject2 = new b(paramLong);
                if ((this.p1 == 0) && (f())) {
                  try
                  {
                    localObject1 = this.z;
                    if (localObject1 != null)
                    {
                      i = localObject1.length;
                      if (i > 0)
                      {
                        i = i - 1 & k;
                        if (localObject1[i] == null)
                        {
                          localObject1[i] = localObject2;
                          i = 1;
                          break label182;
                        }
                      }
                    }
                    i = 0;
                    this.p1 = 0;
                    if (i == 0) {
                      continue;
                    }
                  }
                  finally
                  {
                    this.p1 = 0;
                  }
                }
              }
            }
            boolean bool;
            do
            {
              i = 0;
              bool = paramBoolean;
              break;
              if (!paramBoolean)
              {
                bool = true;
                i = j;
                break;
              }
              l = ((b)localObject2).c;
              if (((b)localObject2).a(l, g(l, paramLong))) {
                return;
              }
            } while ((m >= f) || (this.z != localObject1));
            if (j == 0)
            {
              i = 1;
              bool = paramBoolean;
            }
            else
            {
              bool = paramBoolean;
              i = j;
              if (this.p1 == 0)
              {
                bool = paramBoolean;
                i = j;
                if (f()) {
                  try
                  {
                    if (this.z == localObject1)
                    {
                      localObject2 = new b[m << 1];
                      for (j = 0; j < m; j++) {
                        localObject2[j] = localObject1[j];
                      }
                      this.z = ((b[])localObject2);
                    }
                    this.p1 = 0;
                    j = 0;
                    continue;
                  }
                  finally
                  {
                    this.p1 = 0;
                  }
                }
              }
            }
            j = k ^ k << 13;
            j ^= j >>> 17;
            k = j ^ j << 5;
            paramArrayOfInt[0] = k;
            paramBoolean = bool;
            j = i;
            continue;
          }
        }
        if ((this.p1 == 0) && (this.z == localObject1) && (f())) {
          try
          {
            if (this.z == localObject1)
            {
              localObject1 = new b[2];
              localObject2 = new com/google/common/hash/n$b;
              ((b)localObject2).<init>(paramLong);
              localObject1[(k & 0x1)] = localObject2;
              this.z = ((b[])localObject1);
              i = 1;
            }
            else
            {
              i = 0;
            }
            this.p1 = 0;
            if (i == 0) {}
          }
          finally
          {
            this.p1 = 0;
          }
        }
      }
      l = this.p0;
    } while (!d(l, g(l, paramLong)));
  }
  
  static final class a
    implements PrivilegedExceptionAction<Unsafe>
  {
    public Unsafe a()
      throws Exception
    {
      for (Object localObject : Unsafe.class.getDeclaredFields())
      {
        ((Field)localObject).setAccessible(true);
        localObject = ((Field)localObject).get(null);
        if (Unsafe.class.isInstance(localObject)) {
          return (Unsafe)Unsafe.class.cast(localObject);
        }
      }
      throw new NoSuchFieldError("the Unsafe");
    }
  }
  
  static final class b
  {
    private static final Unsafe a;
    private static final long b;
    volatile long c;
    
    static
    {
      try
      {
        Unsafe localUnsafe = n.b();
        a = localUnsafe;
        b = localUnsafe.objectFieldOffset(b.class.getDeclaredField("c"));
        return;
      }
      catch (Exception localException)
      {
        throw new Error(localException);
      }
    }
    
    b(long paramLong)
    {
      this.c = paramLong;
    }
    
    final boolean a(long paramLong1, long paramLong2)
    {
      return a.compareAndSwapLong(this, b, paramLong1, paramLong2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\hash\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */