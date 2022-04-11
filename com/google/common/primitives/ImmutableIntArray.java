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
public final class ImmutableIntArray
  implements Serializable
{
  private static final ImmutableIntArray EMPTY = new ImmutableIntArray(new int[0]);
  private final int[] array;
  private final int end;
  private final transient int start;
  
  private ImmutableIntArray(int[] paramArrayOfInt)
  {
    this(paramArrayOfInt, 0, paramArrayOfInt.length);
  }
  
  private ImmutableIntArray(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    this.array = paramArrayOfInt;
    this.start = paramInt1;
    this.end = paramInt2;
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
  
  public static ImmutableIntArray copyOf(Iterable<Integer> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return copyOf((Collection)paramIterable);
    }
    return builder().b(paramIterable).d();
  }
  
  public static ImmutableIntArray copyOf(Collection<Integer> paramCollection)
  {
    if (paramCollection.isEmpty()) {
      paramCollection = EMPTY;
    } else {
      paramCollection = new ImmutableIntArray(d.j(paramCollection));
    }
    return paramCollection;
  }
  
  public static ImmutableIntArray copyOf(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 0) {
      paramArrayOfInt = EMPTY;
    } else {
      paramArrayOfInt = new ImmutableIntArray(Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length));
    }
    return paramArrayOfInt;
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
  
  public static ImmutableIntArray of()
  {
    return EMPTY;
  }
  
  public static ImmutableIntArray of(int paramInt)
  {
    return new ImmutableIntArray(new int[] { paramInt });
  }
  
  public static ImmutableIntArray of(int paramInt1, int paramInt2)
  {
    return new ImmutableIntArray(new int[] { paramInt1, paramInt2 });
  }
  
  public static ImmutableIntArray of(int paramInt1, int paramInt2, int paramInt3)
  {
    return new ImmutableIntArray(new int[] { paramInt1, paramInt2, paramInt3 });
  }
  
  public static ImmutableIntArray of(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new ImmutableIntArray(new int[] { paramInt1, paramInt2, paramInt3, paramInt4 });
  }
  
  public static ImmutableIntArray of(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return new ImmutableIntArray(new int[] { paramInt1, paramInt2, paramInt3, paramInt4, paramInt5 });
  }
  
  public static ImmutableIntArray of(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return new ImmutableIntArray(new int[] { paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6 });
  }
  
  public static ImmutableIntArray of(int paramInt, int... paramVarArgs)
  {
    boolean bool;
    if (paramVarArgs.length <= 2147483646) {
      bool = true;
    } else {
      bool = false;
    }
    n.e(bool, "the total number of elements must fit in an int");
    int[] arrayOfInt = new int[paramVarArgs.length + 1];
    arrayOfInt[0] = paramInt;
    System.arraycopy(paramVarArgs, 0, arrayOfInt, 1, paramVarArgs.length);
    return new ImmutableIntArray(arrayOfInt);
  }
  
  public List<Integer> asList()
  {
    return new b(this, null);
  }
  
  public boolean contains(int paramInt)
  {
    boolean bool;
    if (indexOf(paramInt) >= 0) {
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
    if (!(paramObject instanceof ImmutableIntArray)) {
      return false;
    }
    paramObject = (ImmutableIntArray)paramObject;
    if (length() != ((ImmutableIntArray)paramObject).length()) {
      return false;
    }
    for (int i = 0; i < length(); i++) {
      if (get(i) != ((ImmutableIntArray)paramObject).get(i)) {
        return false;
      }
    }
    return true;
  }
  
  public int get(int paramInt)
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
      j = j * 31 + d.e(this.array[i]);
      i++;
    }
    return j;
  }
  
  public int indexOf(int paramInt)
  {
    for (int i = this.start; i < this.end; i++) {
      if (this.array[i] == paramInt) {
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
  
  public int lastIndexOf(int paramInt)
  {
    for (int i = this.end - 1;; i--)
    {
      int j = this.start;
      if (i < j) {
        break;
      }
      if (this.array[i] == paramInt) {
        return i - j;
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
    ImmutableIntArray localImmutableIntArray;
    if (isEmpty()) {
      localImmutableIntArray = EMPTY;
    } else {
      localImmutableIntArray = this;
    }
    return localImmutableIntArray;
  }
  
  public ImmutableIntArray subArray(int paramInt1, int paramInt2)
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
      localObject = new ImmutableIntArray((int[])localObject, paramInt1 + i, i + paramInt2);
    }
    return (ImmutableIntArray)localObject;
  }
  
  public int[] toArray()
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
  
  public ImmutableIntArray trimmed()
  {
    ImmutableIntArray localImmutableIntArray;
    if (isPartialView()) {
      localImmutableIntArray = new ImmutableIntArray(toArray());
    } else {
      localImmutableIntArray = this;
    }
    return localImmutableIntArray;
  }
  
  Object writeReplace()
  {
    return trimmed();
  }
  
  static class b
    extends AbstractList<Integer>
    implements RandomAccess, Serializable
  {
    private final ImmutableIntArray c;
    
    private b(ImmutableIntArray paramImmutableIntArray)
    {
      this.c = paramImmutableIntArray;
    }
    
    public Integer a(int paramInt)
    {
      return Integer.valueOf(this.c.get(paramInt));
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
      paramObject = ((List)paramObject).iterator();
      while (((Iterator)paramObject).hasNext())
      {
        Object localObject = ((Iterator)paramObject).next();
        if (((localObject instanceof Integer)) && (this.c.array[i] == ((Integer)localObject).intValue())) {
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
      if ((paramObject instanceof Integer)) {
        i = this.c.indexOf(((Integer)paramObject).intValue());
      } else {
        i = -1;
      }
      return i;
    }
    
    public int lastIndexOf(Object paramObject)
    {
      int i;
      if ((paramObject instanceof Integer)) {
        i = this.c.lastIndexOf(((Integer)paramObject).intValue());
      } else {
        i = -1;
      }
      return i;
    }
    
    public int size()
    {
      return this.c.length();
    }
    
    public List<Integer> subList(int paramInt1, int paramInt2)
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
    private int[] a;
    private int b = 0;
    
    c(int paramInt)
    {
      this.a = new int[paramInt];
    }
    
    private void e(int paramInt)
    {
      paramInt = this.b + paramInt;
      int[] arrayOfInt = this.a;
      if (paramInt > arrayOfInt.length)
      {
        arrayOfInt = new int[f(arrayOfInt.length, paramInt)];
        System.arraycopy(this.a, 0, arrayOfInt, 0, this.b);
        this.a = arrayOfInt;
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
    
    public c a(int paramInt)
    {
      e(1);
      int[] arrayOfInt = this.a;
      int i = this.b;
      arrayOfInt[i] = paramInt;
      this.b = (i + 1);
      return this;
    }
    
    public c b(Iterable<Integer> paramIterable)
    {
      if ((paramIterable instanceof Collection)) {
        return c((Collection)paramIterable);
      }
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        a(((Integer)paramIterable.next()).intValue());
      }
      return this;
    }
    
    public c c(Collection<Integer> paramCollection)
    {
      e(paramCollection.size());
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Integer localInteger = (Integer)paramCollection.next();
        int[] arrayOfInt = this.a;
        int i = this.b;
        this.b = (i + 1);
        arrayOfInt[i] = localInteger.intValue();
      }
      return this;
    }
    
    @CheckReturnValue
    public ImmutableIntArray d()
    {
      ImmutableIntArray localImmutableIntArray;
      if (this.b == 0) {
        localImmutableIntArray = ImmutableIntArray.EMPTY;
      } else {
        localImmutableIntArray = new ImmutableIntArray(this.a, 0, this.b, null);
      }
      return localImmutableIntArray;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\primitives\ImmutableIntArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */