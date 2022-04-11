package com.google.common.primitives;

import com.google.common.base.n;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class b
{
  static final Pattern a = ;
  
  private static Pattern c()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)");
    ((StringBuilder)localObject1).append("(?:[eE][+-]?\\d+#)?[fFdD]?");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("0[xX]");
    ((StringBuilder)localObject2).append("(?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)");
    ((StringBuilder)localObject2).append("[pP][+-]?\\d+#[fFdD]?");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[+-]?(?:NaN|Infinity|");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("|");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(")");
    return Pattern.compile(localStringBuilder.toString().replace("#", "+"));
  }
  
  public static int d(double paramDouble)
  {
    return Double.valueOf(paramDouble).hashCode();
  }
  
  private static int e(double[] paramArrayOfDouble, double paramDouble, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramArrayOfDouble[paramInt1] == paramDouble) {
        return paramInt1;
      }
      paramInt1++;
    }
    return -1;
  }
  
  public static boolean f(double paramDouble)
  {
    boolean bool;
    if ((Double.NEGATIVE_INFINITY < paramDouble) && (paramDouble < Double.POSITIVE_INFINITY)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static int g(double[] paramArrayOfDouble, double paramDouble, int paramInt1, int paramInt2)
  {
    
    while (paramInt2 >= paramInt1)
    {
      if (paramArrayOfDouble[paramInt2] == paramDouble) {
        return paramInt2;
      }
      paramInt2--;
    }
    return -1;
  }
  
  public static double[] h(Collection<? extends Number> paramCollection)
  {
    if ((paramCollection instanceof a)) {
      return ((a)paramCollection).d();
    }
    paramCollection = paramCollection.toArray();
    int i = paramCollection.length;
    double[] arrayOfDouble = new double[i];
    for (int j = 0; j < i; j++) {
      arrayOfDouble[j] = ((Number)n.o(paramCollection[j])).doubleValue();
    }
    return arrayOfDouble;
  }
  
  private static class a
    extends AbstractList<Double>
    implements RandomAccess, Serializable
  {
    final double[] c;
    final int d;
    final int f;
    
    a(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
    {
      this.c = paramArrayOfDouble;
      this.d = paramInt1;
      this.f = paramInt2;
    }
    
    public Double a(int paramInt)
    {
      n.m(paramInt, size());
      return Double.valueOf(this.c[(this.d + paramInt)]);
    }
    
    public Double b(int paramInt, Double paramDouble)
    {
      n.m(paramInt, size());
      double[] arrayOfDouble = this.c;
      int i = this.d;
      double d1 = arrayOfDouble[(i + paramInt)];
      arrayOfDouble[(i + paramInt)] = ((Double)n.o(paramDouble)).doubleValue();
      return Double.valueOf(d1);
    }
    
    public boolean contains(Object paramObject)
    {
      boolean bool;
      if (((paramObject instanceof Double)) && (b.a(this.c, ((Double)paramObject).doubleValue(), this.d, this.f) != -1)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    double[] d()
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
        j = j * 31 + b.d(this.c[i]);
        i++;
      }
      return j;
    }
    
    public int indexOf(Object paramObject)
    {
      if ((paramObject instanceof Double))
      {
        int i = b.a(this.c, ((Double)paramObject).doubleValue(), this.d, this.f);
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
      if ((paramObject instanceof Double))
      {
        int i = b.b(this.c, ((Double)paramObject).doubleValue(), this.d, this.f);
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
    
    public List<Double> subList(int paramInt1, int paramInt2)
    {
      n.t(paramInt1, paramInt2, size());
      if (paramInt1 == paramInt2) {
        return Collections.emptyList();
      }
      double[] arrayOfDouble = this.c;
      int i = this.d;
      return new a(arrayOfDouble, paramInt1 + i, i + paramInt2);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(size() * 12);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\primitives\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */