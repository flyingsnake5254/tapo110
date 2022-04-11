package com.google.common.primitives;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable
public final class ImmutableDoubleArray
  implements Serializable
{
  private static final ImmutableDoubleArray EMPTY = new ImmutableDoubleArray(new double[0]);
  private final double[] array;
  private final int end;
  private final transient int start;
  
  private ImmutableDoubleArray(double[] paramArrayOfDouble)
  {
    this(paramArrayOfDouble, 0, paramArrayOfDouble.length);
  }
  
  private ImmutableDoubleArray(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    this.array = paramArrayOfDouble;
    this.start = paramInt1;
    this.end = paramInt2;
  }
  
  private static boolean areEqual(double paramDouble1, double paramDouble2)
  {
    boolean bool;
    if (Double.doubleToLongBits(paramDouble1) == Double.doubleToLongBits(paramDouble2)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static c builder()
  {
    return new c(10);
  }
  
  public static c builder(int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    n.f(bool, "Invalid initialCapacity: %s", paramInt);
    return new c(paramInt);
  }
  
  public static ImmutableDoubleArray copyOf(Iterable<Double> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return copyOf((Collection)paramIterable);
    }
    return builder().b(paramIterable).d();
  }
  
  public static ImmutableDoubleArray copyOf(Collection<Double> paramCollection)
  {
    if (paramCollection.isEmpty()) {
      paramCollection = EMPTY;
    } else {
      paramCollection = new ImmutableDoubleArray(b.h(paramCollection));
    }
    return paramCollection;
  }
  
  public static ImmutableDoubleArray copyOf(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble.length == 0) {
      paramArrayOfDouble = EMPTY;
    } else {
      paramArrayOfDouble = new ImmutableDoubleArray(Arrays.copyOf(paramArrayOfDouble, paramArrayOfDouble.length));
    }
    return paramArrayOfDouble;
  }
  
  private boolean isPartialView()
  {
    boolean bool;
    if ((this.start <= 0) && (this.end >= this.array.length)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static ImmutableDoubleArray of()
  {
    return EMPTY;
  }
  
  public static ImmutableDoubleArray of(double paramDouble)
  {
    return new ImmutableDoubleArray(new double[] { paramDouble });
  }
  
  public static ImmutableDoubleArray of(double paramDouble1, double paramDouble2)
  {
    return new ImmutableDoubleArray(new double[] { paramDouble1, paramDouble2 });
  }
  
  public static ImmutableDoubleArray of(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return new ImmutableDoubleArray(new double[] { paramDouble1, paramDouble2, paramDouble3 });
  }
  
  public static ImmutableDoubleArray of(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return new ImmutableDoubleArray(new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4 });
  }
  
  public static ImmutableDoubleArray of(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5)
  {
    return new ImmutableDoubleArray(new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5 });
  }
  
  public static ImmutableDoubleArray of(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    return new ImmutableDoubleArray(new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6 });
  }
  
  public static ImmutableDoubleArray of(double paramDouble, double... paramVarArgs)
  {
    boolean bool;
    if (paramVarArgs.length <= 2147483646) {
      bool = true;
    } else {
      bool = false;
    }
    n.e(bool, "the total number of elements must fit in an int");
    double[] arrayOfDouble = new double[paramVarArgs.length + 1];
    arrayOfDouble[0] = paramDouble;
    System.arraycopy(paramVarArgs, 0, arrayOfDouble, 1, paramVarArgs.length);
    return new ImmutableDoubleArray(arrayOfDouble);
  }
  
  public List<Double> asList()
  {
    return new b(this, null);
  }
  
  public boolean contains(double paramDouble)
  {
    boolean bool;
    if (indexOf(paramDouble) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ImmutableDoubleArray)) {
      return false;
    }
    paramObject = (ImmutableDoubleArray)paramObject;
    if (length() != ((ImmutableDoubleArray)paramObject).length()) {
      return false;
    }
    for (int i = 0; i < length(); i++) {
      if (!areEqual(get(i), ((ImmutableDoubleArray)paramObject).get(i))) {
        return false;
      }
    }
    return true;
  }
  
  public double get(int paramInt)
  {
    n.m(paramInt, length());
    return this.array[(this.start + paramInt)];
  }
  
  public int hashCode()
  {
    int i = this.start;
    int j = 1;
    while (i < this.end)
    {
      j = j * 31 + b.d(this.array[i]);
      i++;
    }
    return j;
  }
  
  public int indexOf(double paramDouble)
  {
    for (int i = this.start; i < this.end; i++) {
      if (areEqual(this.array[i], paramDouble)) {
        return i - this.start;
      }
    }
    return -1;
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (this.end == this.start) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int lastIndexOf(double paramDouble)
  {
    for (int i = this.end - 1; i >= this.start; i--) {
      if (areEqual(this.array[i], paramDouble)) {
        return i - this.start;
      }
    }
    return -1;
  }
  
  public int length()
  {
    return this.end - this.start;
  }
  
  Object readResolve()
  {
    ImmutableDoubleArray localImmutableDoubleArray;
    if (isEmpty()) {
      localImmutableDoubleArray = EMPTY;
    } else {
      localImmutableDoubleArray = this;
    }
    return localImmutableDoubleArray;
  }
  
  public ImmutableDoubleArray subArray(int paramInt1, int paramInt2)
  {
    n.t(paramInt1, paramInt2, length());
    Object localObject;
    if (paramInt1 == paramInt2)
    {
      localObject = EMPTY;
    }
    else
    {
      localObject = this.array;
      int i = this.start;
      localObject = new ImmutableDoubleArray((double[])localObject, paramInt1 + i, i + paramInt2);
    }
    return (ImmutableDoubleArray)localObject;
  }
  
  public double[] toArray()
  {
    return Arrays.copyOfRange(this.array, this.start, this.end);
  }
  
  public String toString()
  {
    if (isEmpty()) {
      return "[]";
    }
    StringBuilder localStringBuilder = new StringBuilder(length() * 5);
    localStringBuilder.append('[');
    localStringBuilder.append(this.array[this.start]);
    int i = this.start;
    for (;;)
    {
      i++;
      if (i >= this.end) {
        break;
      }
      localStringBuilder.append(", ");
      localStringBuilder.append(this.array[i]);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public ImmutableDoubleArray trimmed()
  {
    ImmutableDoubleArray localImmutableDoubleArray;
    if (isPartialView()) {
      localImmutableDoubleArray = new ImmutableDoubleArray(toArray());
    } else {
      localImmutableDoubleArray = this;
    }
    return localImmutableDoubleArray;
  }
  
  Object writeReplace()
  {
    return trimmed();
  }
  
  static class b
    extends AbstractList<Double>
    implements RandomAccess, Serializable
  {
    private final ImmutableDoubleArray c;
    
    private b(ImmutableDoubleArray paramImmutableDoubleArray)
    {
      this.c = paramImmutableDoubleArray;
    }
    
    public Double a(int paramInt)
    {
      return Double.valueOf(this.c.get(paramInt));
    }
    
    public boolean contains(Object paramObject)
    {
      boolean bool;
      if (indexOf(paramObject) >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean equals(@NullableDecl Object paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        return this.c.equals(((b)paramObject).c);
      }
      if (!(paramObject instanceof List)) {
        return false;
      }
      paramObject = (List)paramObject;
      if (size() != ((List)paramObject).size()) {
        return false;
      }
      int i = this.c.start;
      Iterator localIterator = ((List)paramObject).iterator();
      while (localIterator.hasNext())
      {
        paramObject = localIterator.next();
        if (((paramObject instanceof Double)) && (ImmutableDoubleArray.areEqual(this.c.array[i], ((Double)paramObject).doubleValue()))) {
          i++;
        } else {
          return false;
        }
      }
      return true;
    }
    
    public int hashCode()
    {
      return this.c.hashCode();
    }
    
    public int indexOf(Object paramObject)
    {
      int i;
      if ((paramObject instanceof Double)) {
        i = this.c.indexOf(((Double)paramObject).doubleValue());
      } else {
        i = -1;
      }
      return i;
    }
    
    public int lastIndexOf(Object paramObject)
    {
      int i;
      if ((paramObject instanceof Double)) {
        i = this.c.lastIndexOf(((Double)paramObject).doubleValue());
      } else {
        i = -1;
      }
      return i;
    }
    
    public int size()
    {
      return this.c.length();
    }
    
    public List<Double> subList(int paramInt1, int paramInt2)
    {
      return this.c.subArray(paramInt1, paramInt2).asList();
    }
    
    public String toString()
    {
      return this.c.toString();
    }
  }
  
  @CanIgnoreReturnValue
  public static final class c
  {
    private double[] a;
    private int b = 0;
    
    c(int paramInt)
    {
      this.a = new double[paramInt];
    }
    
    private void e(int paramInt)
    {
      paramInt = this.b + paramInt;
      double[] arrayOfDouble = this.a;
      if (paramInt > arrayOfDouble.length)
      {
        arrayOfDouble = new double[f(arrayOfDouble.length, paramInt)];
        System.arraycopy(this.a, 0, arrayOfDouble, 0, this.b);
        this.a = arrayOfDouble;
      }
    }
    
    private static int f(int paramInt1, int paramInt2)
    {
      if (paramInt2 >= 0)
      {
        int i = paramInt1 + (paramInt1 >> 1) + 1;
        paramInt1 = i;
        if (i < paramInt2) {
          paramInt1 = Integer.highestOneBit(paramInt2 - 1) << 1;
        }
        paramInt2 = paramInt1;
        if (paramInt1 < 0) {
          paramInt2 = Integer.MAX_VALUE;
        }
        return paramInt2;
      }
      throw new AssertionError("cannot store more than MAX_VALUE elements");
    }
    
    public c a(double paramDouble)
    {
      e(1);
      double[] arrayOfDouble = this.a;
      int i = this.b;
      arrayOfDouble[i] = paramDouble;
      this.b = (i + 1);
      return this;
    }
    
    public c b(Iterable<Double> paramIterable)
    {
      if ((paramIterable instanceof Collection)) {
        return c((Collection)paramIterable);
      }
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        a(((Double)paramIterable.next()).doubleValue());
      }
      return this;
    }
    
    public c c(Collection<Double> paramCollection)
    {
      e(paramCollection.size());
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Double localDouble = (Double)paramCollection.next();
        double[] arrayOfDouble = this.a;
        int i = this.b;
        this.b = (i + 1);
        arrayOfDouble[i] = localDouble.doubleValue();
      }
      return this;
    }
    
    @CheckReturnValue
    public ImmutableDoubleArray d()
    {
      ImmutableDoubleArray localImmutableDoubleArray;
      if (this.b == 0) {
        localImmutableDoubleArray = ImmutableDoubleArray.EMPTY;
      } else {
        localImmutableDoubleArray = new ImmutableDoubleArray(this.a, 0, this.b, null);
      }
      return localImmutableDoubleArray;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\primitives\ImmutableDoubleArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */