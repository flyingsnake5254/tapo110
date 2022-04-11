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
public final class ImmutableLongArray
  implements Serializable
{
  private static final ImmutableLongArray EMPTY = new ImmutableLongArray(new long[0]);
  private final long[] array;
  private final int end;
  private final transient int start;
  
  private ImmutableLongArray(long[] paramArrayOfLong)
  {
    this(paramArrayOfLong, 0, paramArrayOfLong.length);
  }
  
  private ImmutableLongArray(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    this.array = paramArrayOfLong;
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
  
  public static ImmutableLongArray copyOf(Iterable<Long> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return copyOf((Collection)paramIterable);
    }
    return builder().b(paramIterable).d();
  }
  
  public static ImmutableLongArray copyOf(Collection<Long> paramCollection)
  {
    if (paramCollection.isEmpty()) {
      paramCollection = EMPTY;
    } else {
      paramCollection = new ImmutableLongArray(e.i(paramCollection));
    }
    return paramCollection;
  }
  
  public static ImmutableLongArray copyOf(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong.length == 0) {
      paramArrayOfLong = EMPTY;
    } else {
      paramArrayOfLong = new ImmutableLongArray(Arrays.copyOf(paramArrayOfLong, paramArrayOfLong.length));
    }
    return paramArrayOfLong;
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
  
  public static ImmutableLongArray of()
  {
    return EMPTY;
  }
  
  public static ImmutableLongArray of(long paramLong)
  {
    return new ImmutableLongArray(new long[] { paramLong });
  }
  
  public static ImmutableLongArray of(long paramLong1, long paramLong2)
  {
    return new ImmutableLongArray(new long[] { paramLong1, paramLong2 });
  }
  
  public static ImmutableLongArray of(long paramLong1, long paramLong2, long paramLong3)
  {
    return new ImmutableLongArray(new long[] { paramLong1, paramLong2, paramLong3 });
  }
  
  public static ImmutableLongArray of(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    return new ImmutableLongArray(new long[] { paramLong1, paramLong2, paramLong3, paramLong4 });
  }
  
  public static ImmutableLongArray of(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    return new ImmutableLongArray(new long[] { paramLong1, paramLong2, paramLong3, paramLong4, paramLong5 });
  }
  
  public static ImmutableLongArray of(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    return new ImmutableLongArray(new long[] { paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6 });
  }
  
  public static ImmutableLongArray of(long paramLong, long... paramVarArgs)
  {
    boolean bool;
    if (paramVarArgs.length <= 2147483646) {
      bool = true;
    } else {
      bool = false;
    }
    n.e(bool, "the total number of elements must fit in an int");
    long[] arrayOfLong = new long[paramVarArgs.length + 1];
    arrayOfLong[0] = paramLong;
    System.arraycopy(paramVarArgs, 0, arrayOfLong, 1, paramVarArgs.length);
    return new ImmutableLongArray(arrayOfLong);
  }
  
  public List<Long> asList()
  {
    return new b(this, null);
  }
  
  public boolean contains(long paramLong)
  {
    boolean bool;
    if (indexOf(paramLong) >= 0) {
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
    if (!(paramObject instanceof ImmutableLongArray)) {
      return false;
    }
    paramObject = (ImmutableLongArray)paramObject;
    if (length() != ((ImmutableLongArray)paramObject).length()) {
      return false;
    }
    for (int i = 0; i < length(); i++) {
      if (get(i) != ((ImmutableLongArray)paramObject).get(i)) {
        return false;
      }
    }
    return true;
  }
  
  public long get(int paramInt)
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
      j = j * 31 + e.e(this.array[i]);
      i++;
    }
    return j;
  }
  
  public int indexOf(long paramLong)
  {
    for (int i = this.start; i < this.end; i++) {
      if (this.array[i] == paramLong) {
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
  
  public int lastIndexOf(long paramLong)
  {
    for (int i = this.end - 1;; i--)
    {
      int j = this.start;
      if (i < j) {
        break;
      }
      if (this.array[i] == paramLong) {
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
    ImmutableLongArray localImmutableLongArray;
    if (isEmpty()) {
      localImmutableLongArray = EMPTY;
    } else {
      localImmutableLongArray = this;
    }
    return localImmutableLongArray;
  }
  
  public ImmutableLongArray subArray(int paramInt1, int paramInt2)
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
      localObject = new ImmutableLongArray((long[])localObject, paramInt1 + i, i + paramInt2);
    }
    return (ImmutableLongArray)localObject;
  }
  
  public long[] toArray()
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
  
  public ImmutableLongArray trimmed()
  {
    ImmutableLongArray localImmutableLongArray;
    if (isPartialView()) {
      localImmutableLongArray = new ImmutableLongArray(toArray());
    } else {
      localImmutableLongArray = this;
    }
    return localImmutableLongArray;
  }
  
  Object writeReplace()
  {
    return trimmed();
  }
  
  static class b
    extends AbstractList<Long>
    implements RandomAccess, Serializable
  {
    private final ImmutableLongArray c;
    
    private b(ImmutableLongArray paramImmutableLongArray)
    {
      this.c = paramImmutableLongArray;
    }
    
    public Long a(int paramInt)
    {
      return Long.valueOf(this.c.get(paramInt));
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
        if (((localObject instanceof Long)) && (this.c.array[i] == ((Long)localObject).longValue())) {
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
      if ((paramObject instanceof Long)) {
        i = this.c.indexOf(((Long)paramObject).longValue());
      } else {
        i = -1;
      }
      return i;
    }
    
    public int lastIndexOf(Object paramObject)
    {
      int i;
      if ((paramObject instanceof Long)) {
        i = this.c.lastIndexOf(((Long)paramObject).longValue());
      } else {
        i = -1;
      }
      return i;
    }
    
    public int size()
    {
      return this.c.length();
    }
    
    public List<Long> subList(int paramInt1, int paramInt2)
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
    private long[] a;
    private int b = 0;
    
    c(int paramInt)
    {
      this.a = new long[paramInt];
    }
    
    private void e(int paramInt)
    {
      paramInt = this.b + paramInt;
      long[] arrayOfLong = this.a;
      if (paramInt > arrayOfLong.length)
      {
        arrayOfLong = new long[f(arrayOfLong.length, paramInt)];
        System.arraycopy(this.a, 0, arrayOfLong, 0, this.b);
        this.a = arrayOfLong;
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
    
    public c a(long paramLong)
    {
      e(1);
      long[] arrayOfLong = this.a;
      int i = this.b;
      arrayOfLong[i] = paramLong;
      this.b = (i + 1);
      return this;
    }
    
    public c b(Iterable<Long> paramIterable)
    {
      if ((paramIterable instanceof Collection)) {
        return c((Collection)paramIterable);
      }
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        a(((Long)paramIterable.next()).longValue());
      }
      return this;
    }
    
    public c c(Collection<Long> paramCollection)
    {
      e(paramCollection.size());
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Long localLong = (Long)paramCollection.next();
        long[] arrayOfLong = this.a;
        int i = this.b;
        this.b = (i + 1);
        arrayOfLong[i] = localLong.longValue();
      }
      return this;
    }
    
    @CheckReturnValue
    public ImmutableLongArray d()
    {
      ImmutableLongArray localImmutableLongArray;
      if (this.b == 0) {
        localImmutableLongArray = ImmutableLongArray.EMPTY;
      } else {
        localImmutableLongArray = new ImmutableLongArray(this.a, 0, this.b, null);
      }
      return localImmutableLongArray;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\primitives\ImmutableLongArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */