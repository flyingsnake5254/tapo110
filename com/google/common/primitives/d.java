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

public final class d
{
  public static int c(long paramLong)
  {
    int i = (int)paramLong;
    boolean bool;
    if (i == paramLong) {
      bool = true;
    } else {
      bool = false;
    }
    n.h(bool, "Out of range: %s", paramLong);
    return i;
  }
  
  public static int d(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      paramInt1 = -1;
    } else if (paramInt1 > paramInt2) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    return paramInt1;
  }
  
  public static int e(int paramInt)
  {
    return paramInt;
  }
  
  public static int f(int[] paramArrayOfInt, int paramInt)
  {
    return g(paramArrayOfInt, paramInt, 0, paramArrayOfInt.length);
  }
  
  private static int g(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    while (paramInt2 < paramInt3)
    {
      if (paramArrayOfInt[paramInt2] == paramInt1) {
        return paramInt2;
      }
      paramInt2++;
    }
    return -1;
  }
  
  private static int h(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    
    while (paramInt3 >= paramInt2)
    {
      if (paramArrayOfInt[paramInt3] == paramInt1) {
        return paramInt3;
      }
      paramInt3--;
    }
    return -1;
  }
  
  public static int i(long paramLong)
  {
    if (paramLong > 2147483647L) {
      return Integer.MAX_VALUE;
    }
    if (paramLong < -2147483648L) {
      return Integer.MIN_VALUE;
    }
    return (int)paramLong;
  }
  
  public static int[] j(Collection<? extends Number> paramCollection)
  {
    if ((paramCollection instanceof a)) {
      return ((a)paramCollection).d();
    }
    paramCollection = paramCollection.toArray();
    int i = paramCollection.length;
    int[] arrayOfInt = new int[i];
    for (int j = 0; j < i; j++) {
      arrayOfInt[j] = ((Number)n.o(paramCollection[j])).intValue();
    }
    return arrayOfInt;
  }
  
  private static class a
    extends AbstractList<Integer>
    implements RandomAccess, Serializable
  {
    final int[] c;
    final int d;
    final int f;
    
    a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      this.c = paramArrayOfInt;
      this.d = paramInt1;
      this.f = paramInt2;
    }
    
    public Integer a(int paramInt)
    {
      n.m(paramInt, size());
      return Integer.valueOf(this.c[(this.d + paramInt)]);
    }
    
    public Integer b(int paramInt, Integer paramInteger)
    {
      n.m(paramInt, size());
      int[] arrayOfInt = this.c;
      int i = this.d;
      int j = arrayOfInt[(i + paramInt)];
      arrayOfInt[(i + paramInt)] = ((Integer)n.o(paramInteger)).intValue();
      return Integer.valueOf(j);
    }
    
    public boolean contains(Object paramObject)
    {
      boolean bool;
      if (((paramObject instanceof Integer)) && (d.a(this.c, ((Integer)paramObject).intValue(), this.d, this.f) != -1)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    int[] d()
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
        j = j * 31 + d.e(this.c[i]);
        i++;
      }
      return j;
    }
    
    public int indexOf(Object paramObject)
    {
      if ((paramObject instanceof Integer))
      {
        int i = d.a(this.c, ((Integer)paramObject).intValue(), this.d, this.f);
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
      if ((paramObject instanceof Integer))
      {
        int i = d.b(this.c, ((Integer)paramObject).intValue(), this.d, this.f);
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
    
    public List<Integer> subList(int paramInt1, int paramInt2)
    {
      n.t(paramInt1, paramInt2, size());
      if (paramInt1 == paramInt2) {
        return Collections.emptyList();
      }
      int[] arrayOfInt = this.c;
      int i = this.d;
      return new a(arrayOfInt, paramInt1 + i, i + paramInt2);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(size() * 5);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\primitives\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */