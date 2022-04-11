package com.google.common.primitives;

import com.google.common.base.n;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class e
{
  public static int c(long paramLong1, long paramLong2)
  {
    boolean bool = paramLong1 < paramLong2;
    int i;
    if (bool) {
      i = -1;
    } else if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    return i;
  }
  
  public static long d(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8)
  {
    long l = paramByte1;
    return (paramByte2 & 0xFF) << 48 | (l & 0xFF) << 56 | (paramByte3 & 0xFF) << 40 | (paramByte4 & 0xFF) << 32 | (paramByte5 & 0xFF) << 24 | (paramByte6 & 0xFF) << 16 | (paramByte7 & 0xFF) << 8 | paramByte8 & 0xFF;
  }
  
  public static int e(long paramLong)
  {
    return (int)(paramLong ^ paramLong >>> 32);
  }
  
  private static int f(long[] paramArrayOfLong, long paramLong, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramArrayOfLong[paramInt1] == paramLong) {
        return paramInt1;
      }
      paramInt1++;
    }
    return -1;
  }
  
  private static int g(long[] paramArrayOfLong, long paramLong, int paramInt1, int paramInt2)
  {
    
    while (paramInt2 >= paramInt1)
    {
      if (paramArrayOfLong[paramInt2] == paramLong) {
        return paramInt2;
      }
      paramInt2--;
    }
    return -1;
  }
  
  public static long h(long... paramVarArgs)
  {
    int i = paramVarArgs.length;
    int j = 1;
    boolean bool;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    }
    n.d(bool);
    long l2;
    for (long l1 = paramVarArgs[0]; j < paramVarArgs.length; l1 = l2)
    {
      l2 = l1;
      if (paramVarArgs[j] > l1) {
        l2 = paramVarArgs[j];
      }
      j++;
    }
    return l1;
  }
  
  public static long[] i(Collection<? extends Number> paramCollection)
  {
    if ((paramCollection instanceof a)) {
      return ((a)paramCollection).d();
    }
    paramCollection = paramCollection.toArray();
    int i = paramCollection.length;
    long[] arrayOfLong = new long[i];
    for (int j = 0; j < i; j++) {
      arrayOfLong[j] = ((Number)n.o(paramCollection[j])).longValue();
    }
    return arrayOfLong;
  }
  
  private static class a
    extends AbstractList<Long>
    implements RandomAccess, Serializable
  {
    final long[] c;
    final int d;
    final int f;
    
    a(long[] paramArrayOfLong, int paramInt1, int paramInt2)
    {
      this.c = paramArrayOfLong;
      this.d = paramInt1;
      this.f = paramInt2;
    }
    
    public Long a(int paramInt)
    {
      n.m(paramInt, size());
      return Long.valueOf(this.c[(this.d + paramInt)]);
    }
    
    public Long b(int paramInt, Long paramLong)
    {
      n.m(paramInt, size());
      long[] arrayOfLong = this.c;
      int i = this.d;
      long l = arrayOfLong[(i + paramInt)];
      arrayOfLong[(i + paramInt)] = ((Long)n.o(paramLong)).longValue();
      return Long.valueOf(l);
    }
    
    public boolean contains(Object paramObject)
    {
      boolean bool;
      if (((paramObject instanceof Long)) && (e.a(this.c, ((Long)paramObject).longValue(), this.d, this.f) != -1)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    long[] d()
    {
      return Arrays.copyOfRange(this.c, this.d, this.f);
    }
    
    public boolean equals(@NullableDecl Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        int i = size();
        if (((a)paramObject).size() != i) {
          return false;
        }
        for (int j = 0; j < i; j++) {
          if (this.c[(this.d + j)] != paramObject.c[(paramObject.d + j)]) {
            return false;
          }
        }
        return true;
      }
      return super.equals(paramObject);
    }
    
    public int hashCode()
    {
      int i = this.d;
      int j = 1;
      while (i < this.f)
      {
        j = j * 31 + e.e(this.c[i]);
        i++;
      }
      return j;
    }
    
    public int indexOf(Object paramObject)
    {
      if ((paramObject instanceof Long))
      {
        int i = e.a(this.c, ((Long)paramObject).longValue(), this.d, this.f);
        if (i >= 0) {
          return i - this.d;
        }
      }
      return -1;
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public int lastIndexOf(Object paramObject)
    {
      if ((paramObject instanceof Long))
      {
        int i = e.b(this.c, ((Long)paramObject).longValue(), this.d, this.f);
        if (i >= 0) {
          return i - this.d;
        }
      }
      return -1;
    }
    
    public int size()
    {
      return this.f - this.d;
    }
    
    public List<Long> subList(int paramInt1, int paramInt2)
    {
      n.t(paramInt1, paramInt2, size());
      if (paramInt1 == paramInt2) {
        return Collections.emptyList();
      }
      long[] arrayOfLong = this.c;
      int i = this.d;
      return new a(arrayOfLong, paramInt1 + i, i + paramInt2);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(size() * 10);
      localStringBuilder.append('[');
      localStringBuilder.append(this.c[this.d]);
      int i = this.d;
      for (;;)
      {
        i++;
        if (i >= this.f) {
          break;
        }
        localStringBuilder.append(", ");
        localStringBuilder.append(this.c[i]);
      }
      localStringBuilder.append(']');
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\primitives\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */