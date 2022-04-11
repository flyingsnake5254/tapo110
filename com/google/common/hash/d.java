package com.google.common.hash;

import com.google.common.base.n;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

 enum d
  implements BloomFilter.c
{
  static
  {
    a locala = new a("MURMUR128_MITZ_32", 0);
    c = locala;
    b localb = new b("MURMUR128_MITZ_64", 1);
    d = localb;
    f = new d[] { locala, localb };
  }
  
  static enum a
  {
    a()
    {
      super(paramInt, null);
    }
    
    public <T> boolean c(T paramT, Funnel<? super T> paramFunnel, int paramInt, d.c paramc)
    {
      long l1 = paramc.b();
      long l2 = h.a().b(paramT, paramFunnel).d();
      int i = (int)l2;
      int j = (int)(l2 >>> 32);
      for (int k = 1; k <= paramInt; k++)
      {
        int m = k * j + i;
        int n = m;
        if (m < 0) {
          n = m ^ 0xFFFFFFFF;
        }
        if (!paramc.d(n % l1)) {
          return false;
        }
      }
      return true;
    }
    
    public <T> boolean e(T paramT, Funnel<? super T> paramFunnel, int paramInt, d.c paramc)
    {
      long l1 = paramc.b();
      long l2 = h.a().b(paramT, paramFunnel).d();
      int i = (int)l2;
      int j = (int)(l2 >>> 32);
      int k = 1;
      boolean bool = false;
      while (k <= paramInt)
      {
        int m = k * j + i;
        int n = m;
        if (m < 0) {
          n = m ^ 0xFFFFFFFF;
        }
        bool |= paramc.f(n % l1);
        k++;
      }
      return bool;
    }
  }
  
  static enum b
  {
    b()
    {
      super(paramInt, null);
    }
    
    private long a(byte[] paramArrayOfByte)
    {
      return com.google.common.primitives.e.d(paramArrayOfByte[7], paramArrayOfByte[6], paramArrayOfByte[5], paramArrayOfByte[4], paramArrayOfByte[3], paramArrayOfByte[2], paramArrayOfByte[1], paramArrayOfByte[0]);
    }
    
    private long b(byte[] paramArrayOfByte)
    {
      return com.google.common.primitives.e.d(paramArrayOfByte[15], paramArrayOfByte[14], paramArrayOfByte[13], paramArrayOfByte[12], paramArrayOfByte[11], paramArrayOfByte[10], paramArrayOfByte[9], paramArrayOfByte[8]);
    }
    
    public <T> boolean c(T paramT, Funnel<? super T> paramFunnel, int paramInt, d.c paramc)
    {
      long l1 = paramc.b();
      paramT = h.a().b(paramT, paramFunnel).i();
      long l2 = a(paramT);
      long l3 = b(paramT);
      for (int i = 0; i < paramInt; i++)
      {
        if (!paramc.d((0x7FFFFFFFFFFFFFFF & l2) % l1)) {
          return false;
        }
        l2 += l3;
      }
      return true;
    }
    
    public <T> boolean e(T paramT, Funnel<? super T> paramFunnel, int paramInt, d.c paramc)
    {
      long l1 = paramc.b();
      paramT = h.a().b(paramT, paramFunnel).i();
      long l2 = a(paramT);
      long l3 = b(paramT);
      int i = 0;
      boolean bool = false;
      while (i < paramInt)
      {
        bool |= paramc.f((0x7FFFFFFFFFFFFFFF & l2) % l1);
        l2 += l3;
        i++;
      }
      return bool;
    }
  }
  
  static final class c
  {
    final AtomicLongArray a;
    private final i b;
    
    c(long paramLong)
    {
      this(new long[com.google.common.primitives.d.c(com.google.common.math.e.a(paramLong, 64L, RoundingMode.CEILING))]);
    }
    
    c(long[] paramArrayOfLong)
    {
      int i = paramArrayOfLong.length;
      int j = 0;
      boolean bool;
      if (i > 0) {
        bool = true;
      } else {
        bool = false;
      }
      n.e(bool, "data length is zero!");
      this.a = new AtomicLongArray(paramArrayOfLong);
      this.b = j.a();
      long l = 0L;
      i = paramArrayOfLong.length;
      while (j < i)
      {
        l += Long.bitCount(paramArrayOfLong[j]);
        j++;
      }
      this.b.add(l);
    }
    
    public static long[] g(AtomicLongArray paramAtomicLongArray)
    {
      int i = paramAtomicLongArray.length();
      long[] arrayOfLong = new long[i];
      for (int j = 0; j < i; j++) {
        arrayOfLong[j] = paramAtomicLongArray.get(j);
      }
      return arrayOfLong;
    }
    
    long a()
    {
      return this.b.a();
    }
    
    long b()
    {
      return this.a.length() * 64L;
    }
    
    c c()
    {
      return new c(g(this.a));
    }
    
    boolean d(long paramLong)
    {
      long l = this.a.get((int)(paramLong >>> 6));
      boolean bool;
      if ((1L << (int)paramLong & l) != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    void e(c paramc)
    {
      boolean bool;
      if (this.a.length() == paramc.a.length()) {
        bool = true;
      } else {
        bool = false;
      }
      n.g(bool, "BitArrays must be of equal length (%s != %s)", this.a.length(), paramc.a.length());
      for (int i = 0; i < this.a.length(); i++)
      {
        long l1 = paramc.a.get(i);
        long l2;
        long l3;
        do
        {
          l2 = this.a.get(i);
          l3 = l2 | l1;
          if (l2 == l3)
          {
            j = 0;
            break;
          }
        } while (!this.a.compareAndSet(i, l2, l3));
        int j = 1;
        if (j != 0)
        {
          j = Long.bitCount(l3);
          int k = Long.bitCount(l2);
          this.b.add(j - k);
        }
      }
    }
    
    public boolean equals(@NullableDecl Object paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        return Arrays.equals(g(this.a), g(((c)paramObject).a));
      }
      return false;
    }
    
    boolean f(long paramLong)
    {
      if (d(paramLong)) {
        return false;
      }
      int i = (int)(paramLong >>> 6);
      int j = (int)paramLong;
      long l;
      do
      {
        l = this.a.get(i);
        paramLong = l | 1L << j;
        if (l == paramLong) {
          return false;
        }
      } while (!this.a.compareAndSet(i, l, paramLong));
      this.b.increment();
      return true;
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(g(this.a));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\hash\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */