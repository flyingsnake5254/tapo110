package com.google.common.collect;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ImmutableList<E>
  extends ImmutableCollection<E>
  implements List<E>, RandomAccess
{
  private static final k3<Object> EMPTY_ITR = new b(i2.c, 0);
  
  static <E> ImmutableList<E> asImmutableList(Object[] paramArrayOfObject)
  {
    return asImmutableList(paramArrayOfObject, paramArrayOfObject.length);
  }
  
  static <E> ImmutableList<E> asImmutableList(Object[] paramArrayOfObject, int paramInt)
  {
    if (paramInt == 0) {
      return of();
    }
    return new i2(paramArrayOfObject, paramInt);
  }
  
  public static <E> a<E> builder()
  {
    return new a();
  }
  
  public static <E> a<E> builderWithExpectedSize(int paramInt)
  {
    v.b(paramInt, "expectedSize");
    return new a(paramInt);
  }
  
  private static <E> ImmutableList<E> construct(Object... paramVarArgs)
  {
    return asImmutableList(x1.b(paramVarArgs));
  }
  
  public static <E> ImmutableList<E> copyOf(Iterable<? extends E> paramIterable)
  {
    n.o(paramIterable);
    if ((paramIterable instanceof Collection)) {
      paramIterable = copyOf((Collection)paramIterable);
    } else {
      paramIterable = copyOf(paramIterable.iterator());
    }
    return paramIterable;
  }
  
  public static <E> ImmutableList<E> copyOf(Collection<? extends E> paramCollection)
  {
    if ((paramCollection instanceof ImmutableCollection))
    {
      ImmutableList localImmutableList = ((ImmutableCollection)paramCollection).asList();
      paramCollection = localImmutableList;
      if (localImmutableList.isPartialView()) {
        paramCollection = asImmutableList(localImmutableList.toArray());
      }
      return paramCollection;
    }
    return construct(paramCollection.toArray());
  }
  
  public static <E> ImmutableList<E> copyOf(Iterator<? extends E> paramIterator)
  {
    if (!paramIterator.hasNext()) {
      return of();
    }
    Object localObject = paramIterator.next();
    if (!paramIterator.hasNext()) {
      return of(localObject);
    }
    return new a().h(localObject).i(paramIterator).j();
  }
  
  public static <E> ImmutableList<E> copyOf(E[] paramArrayOfE)
  {
    if (paramArrayOfE.length == 0) {
      paramArrayOfE = of();
    } else {
      paramArrayOfE = construct((Object[])paramArrayOfE.clone());
    }
    return paramArrayOfE;
  }
  
  public static <E> ImmutableList<E> of()
  {
    return i2.c;
  }
  
  public static <E> ImmutableList<E> of(E paramE)
  {
    return construct(new Object[] { paramE });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2)
  {
    return construct(new Object[] { paramE1, paramE2 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3)
  {
    return construct(new Object[] { paramE1, paramE2, paramE3 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4)
  {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5)
  {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6)
  {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7)
  {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8)
  {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7, paramE8 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8, E paramE9)
  {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7, paramE8, paramE9 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8, E paramE9, E paramE10)
  {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7, paramE8, paramE9, paramE10 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8, E paramE9, E paramE10, E paramE11)
  {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7, paramE8, paramE9, paramE10, paramE11 });
  }
  
  @SafeVarargs
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8, E paramE9, E paramE10, E paramE11, E paramE12, E... paramVarArgs)
  {
    boolean bool;
    if (paramVarArgs.length <= 2147483635) {
      bool = true;
    } else {
      bool = false;
    }
    n.e(bool, "the total number of elements must fit in an int");
    Object[] arrayOfObject = new Object[paramVarArgs.length + 12];
    arrayOfObject[0] = paramE1;
    arrayOfObject[1] = paramE2;
    arrayOfObject[2] = paramE3;
    arrayOfObject[3] = paramE4;
    arrayOfObject[4] = paramE5;
    arrayOfObject[5] = paramE6;
    arrayOfObject[6] = paramE7;
    arrayOfObject[7] = paramE8;
    arrayOfObject[8] = paramE9;
    arrayOfObject[9] = paramE10;
    arrayOfObject[10] = paramE11;
    arrayOfObject[11] = paramE12;
    System.arraycopy(paramVarArgs, 0, arrayOfObject, 12, paramVarArgs.length);
    return construct(arrayOfObject);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws InvalidObjectException
  {
    throw new InvalidObjectException("Use SerializedForm");
  }
  
  public static <E extends Comparable<? super E>> ImmutableList<E> sortedCopyOf(Iterable<? extends E> paramIterable)
  {
    paramIterable = (Comparable[])j1.m(paramIterable, new Comparable[0]);
    x1.b(paramIterable);
    Arrays.sort(paramIterable);
    return asImmutableList(paramIterable);
  }
  
  public static <E> ImmutableList<E> sortedCopyOf(Comparator<? super E> paramComparator, Iterable<? extends E> paramIterable)
  {
    n.o(paramComparator);
    paramIterable = j1.l(paramIterable);
    x1.b(paramIterable);
    Arrays.sort(paramIterable, paramComparator);
    return asImmutableList(paramIterable);
  }
  
  @Deprecated
  public final void add(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final ImmutableList<E> asList()
  {
    return this;
  }
  
  public boolean contains(@NullableDecl Object paramObject)
  {
    boolean bool;
    if (indexOf(paramObject) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
  {
    int i = size();
    for (int j = 0; j < i; j++) {
      paramArrayOfObject[(paramInt + j)] = get(j);
    }
    return paramInt + i;
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    return n1.c(this, paramObject);
  }
  
  public int hashCode()
  {
    int i = size();
    int j = 1;
    for (int k = 0; k < i; k++) {
      j = j * 31 + get(k).hashCode() ^ 0xFFFFFFFF ^ 0xFFFFFFFF;
    }
    return j;
  }
  
  public int indexOf(@NullableDecl Object paramObject)
  {
    int i;
    if (paramObject == null) {
      i = -1;
    } else {
      i = n1.d(this, paramObject);
    }
    return i;
  }
  
  public j3<E> iterator()
  {
    return listIterator();
  }
  
  public int lastIndexOf(@NullableDecl Object paramObject)
  {
    int i;
    if (paramObject == null) {
      i = -1;
    } else {
      i = n1.f(this, paramObject);
    }
    return i;
  }
  
  public k3<E> listIterator()
  {
    return listIterator(0);
  }
  
  public k3<E> listIterator(int paramInt)
  {
    n.r(paramInt, size());
    if (isEmpty()) {
      return EMPTY_ITR;
    }
    return new b(this, paramInt);
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final E remove(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableList<E> reverse()
  {
    Object localObject;
    if (size() <= 1) {
      localObject = this;
    } else {
      localObject = new c(this);
    }
    return (ImmutableList<E>)localObject;
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final E set(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableList<E> subList(int paramInt1, int paramInt2)
  {
    n.t(paramInt1, paramInt2, size());
    int i = paramInt2 - paramInt1;
    if (i == size()) {
      return this;
    }
    if (i == 0) {
      return of();
    }
    return subListUnchecked(paramInt1, paramInt2);
  }
  
  ImmutableList<E> subListUnchecked(int paramInt1, int paramInt2)
  {
    return new e(paramInt1, paramInt2 - paramInt1);
  }
  
  Object writeReplace()
  {
    return new d(toArray());
  }
  
  public static final class a<E>
    extends ImmutableCollection.a<E>
  {
    public a()
    {
      this(4);
    }
    
    a(int paramInt)
    {
      super();
    }
    
    @CanIgnoreReturnValue
    public a<E> h(E paramE)
    {
      super.f(paramE);
      return this;
    }
    
    @CanIgnoreReturnValue
    public a<E> i(Iterator<? extends E> paramIterator)
    {
      super.d(paramIterator);
      return this;
    }
    
    public ImmutableList<E> j()
    {
      this.c = true;
      return ImmutableList.asImmutableList(this.a, this.b);
    }
  }
  
  static class b<E>
    extends b<E>
  {
    private final ImmutableList<E> f;
    
    b(ImmutableList<E> paramImmutableList, int paramInt)
    {
      super(paramInt);
      this.f = paramImmutableList;
    }
    
    protected E a(int paramInt)
    {
      return (E)this.f.get(paramInt);
    }
  }
  
  private static class c<E>
    extends ImmutableList<E>
  {
    private final transient ImmutableList<E> c;
    
    c(ImmutableList<E> paramImmutableList)
    {
      this.c = paramImmutableList;
    }
    
    private int a(int paramInt)
    {
      return size() - 1 - paramInt;
    }
    
    private int b(int paramInt)
    {
      return size() - paramInt;
    }
    
    public boolean contains(@NullableDecl Object paramObject)
    {
      return this.c.contains(paramObject);
    }
    
    public E get(int paramInt)
    {
      n.m(paramInt, size());
      return (E)this.c.get(a(paramInt));
    }
    
    public int indexOf(@NullableDecl Object paramObject)
    {
      int i = this.c.lastIndexOf(paramObject);
      if (i >= 0) {
        i = a(i);
      } else {
        i = -1;
      }
      return i;
    }
    
    boolean isPartialView()
    {
      return this.c.isPartialView();
    }
    
    public int lastIndexOf(@NullableDecl Object paramObject)
    {
      int i = this.c.indexOf(paramObject);
      if (i >= 0) {
        i = a(i);
      } else {
        i = -1;
      }
      return i;
    }
    
    public ImmutableList<E> reverse()
    {
      return this.c;
    }
    
    public int size()
    {
      return this.c.size();
    }
    
    public ImmutableList<E> subList(int paramInt1, int paramInt2)
    {
      n.t(paramInt1, paramInt2, size());
      return this.c.subList(b(paramInt2), b(paramInt1)).reverse();
    }
  }
  
  static class d
    implements Serializable
  {
    final Object[] c;
    
    d(Object[] paramArrayOfObject)
    {
      this.c = paramArrayOfObject;
    }
  }
  
  class e
    extends ImmutableList<E>
  {
    final transient int c;
    final transient int d;
    
    e(int paramInt1, int paramInt2)
    {
      this.c = paramInt1;
      this.d = paramInt2;
    }
    
    public E get(int paramInt)
    {
      n.m(paramInt, this.d);
      return (E)ImmutableList.this.get(paramInt + this.c);
    }
    
    Object[] internalArray()
    {
      return ImmutableList.this.internalArray();
    }
    
    int internalArrayEnd()
    {
      return ImmutableList.this.internalArrayStart() + this.c + this.d;
    }
    
    int internalArrayStart()
    {
      return ImmutableList.this.internalArrayStart() + this.c;
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    public int size()
    {
      return this.d;
    }
    
    public ImmutableList<E> subList(int paramInt1, int paramInt2)
    {
      n.t(paramInt1, paramInt2, this.d);
      ImmutableList localImmutableList = ImmutableList.this;
      int i = this.c;
      return localImmutableList.subList(paramInt1 + i, paramInt2 + i);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\ImmutableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */