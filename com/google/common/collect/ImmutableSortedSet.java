package com.google.common.collect;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ImmutableSortedSet<E>
  extends h1<E>
  implements NavigableSet<E>, x2<E>
{
  final transient Comparator<? super E> comparator;
  @LazyInit
  transient ImmutableSortedSet<E> descendingSet;
  
  ImmutableSortedSet(Comparator<? super E> paramComparator)
  {
    this.comparator = paramComparator;
  }
  
  static <E> ImmutableSortedSet<E> construct(Comparator<? super E> paramComparator, int paramInt, E... paramVarArgs)
  {
    if (paramInt == 0) {
      return emptySet(paramComparator);
    }
    x1.c(paramVarArgs, paramInt);
    Arrays.sort(paramVarArgs, 0, paramInt, paramComparator);
    int i = 1;
    int k;
    for (int j = 1; i < paramInt; j = k)
    {
      localObject = paramVarArgs[i];
      k = j;
      if (paramComparator.compare(localObject, paramVarArgs[(j - 1)]) != 0)
      {
        paramVarArgs[j] = localObject;
        k = j + 1;
      }
      i++;
    }
    Arrays.fill(paramVarArgs, j, paramInt, null);
    Object localObject = paramVarArgs;
    if (j < paramVarArgs.length / 2) {
      localObject = Arrays.copyOf(paramVarArgs, j);
    }
    return new n2(ImmutableList.asImmutableList((Object[])localObject, j), paramComparator);
  }
  
  public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> paramIterable)
  {
    return copyOf(a2.g(), paramIterable);
  }
  
  public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> paramCollection)
  {
    return copyOf(a2.g(), paramCollection);
  }
  
  public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> paramComparator, Iterable<? extends E> paramIterable)
  {
    n.o(paramComparator);
    if ((y2.b(paramComparator, paramIterable)) && ((paramIterable instanceof ImmutableSortedSet)))
    {
      ImmutableSortedSet localImmutableSortedSet = (ImmutableSortedSet)paramIterable;
      if (!localImmutableSortedSet.isPartialView()) {
        return localImmutableSortedSet;
      }
    }
    paramIterable = j1.l(paramIterable);
    return construct(paramComparator, paramIterable.length, paramIterable);
  }
  
  public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> paramComparator, Collection<? extends E> paramCollection)
  {
    return copyOf(paramComparator, paramCollection);
  }
  
  public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> paramComparator, Iterator<? extends E> paramIterator)
  {
    return new a(paramComparator).m(paramIterator).n();
  }
  
  public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> paramIterator)
  {
    return copyOf(a2.g(), paramIterator);
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedSet<E> copyOf(E[] paramArrayOfE)
  {
    return construct(a2.g(), paramArrayOfE.length, (Object[])paramArrayOfE.clone());
  }
  
  public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> paramSortedSet)
  {
    Comparator localComparator = y2.a(paramSortedSet);
    paramSortedSet = ImmutableList.copyOf(paramSortedSet);
    if (paramSortedSet.isEmpty()) {
      return emptySet(localComparator);
    }
    return new n2(paramSortedSet, localComparator);
  }
  
  static <E> n2<E> emptySet(Comparator<? super E> paramComparator)
  {
    if (a2.g().equals(paramComparator)) {
      return n2.c;
    }
    return new n2(ImmutableList.of(), paramComparator);
  }
  
  public static <E extends Comparable<?>> a<E> naturalOrder()
  {
    return new a(a2.g());
  }
  
  public static <E> ImmutableSortedSet<E> of()
  {
    return n2.c;
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E paramE)
  {
    return new n2(ImmutableList.of(paramE), a2.g());
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E paramE1, E paramE2)
  {
    return construct(a2.g(), 2, new Comparable[] { paramE1, paramE2 });
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E paramE1, E paramE2, E paramE3)
  {
    return construct(a2.g(), 3, new Comparable[] { paramE1, paramE2, paramE3 });
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4)
  {
    return construct(a2.g(), 4, new Comparable[] { paramE1, paramE2, paramE3, paramE4 });
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5)
  {
    return construct(a2.g(), 5, new Comparable[] { paramE1, paramE2, paramE3, paramE4, paramE5 });
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E... paramVarArgs)
  {
    int i = paramVarArgs.length + 6;
    Comparable[] arrayOfComparable = new Comparable[i];
    arrayOfComparable[0] = paramE1;
    arrayOfComparable[1] = paramE2;
    arrayOfComparable[2] = paramE3;
    arrayOfComparable[3] = paramE4;
    arrayOfComparable[4] = paramE5;
    arrayOfComparable[5] = paramE6;
    System.arraycopy(paramVarArgs, 0, arrayOfComparable, 6, paramVarArgs.length);
    return construct(a2.g(), i, arrayOfComparable);
  }
  
  public static <E> a<E> orderedBy(Comparator<E> paramComparator)
  {
    return new a(paramComparator);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws InvalidObjectException
  {
    throw new InvalidObjectException("Use SerializedForm");
  }
  
  public static <E extends Comparable<?>> a<E> reverseOrder()
  {
    return new a(Collections.reverseOrder());
  }
  
  static int unsafeCompare(Comparator<?> paramComparator, Object paramObject1, Object paramObject2)
  {
    return paramComparator.compare(paramObject1, paramObject2);
  }
  
  public E ceiling(E paramE)
  {
    return (E)j1.e(tailSet(paramE, true), null);
  }
  
  public Comparator<? super E> comparator()
  {
    return this.comparator;
  }
  
  abstract ImmutableSortedSet<E> createDescendingSet();
  
  public abstract j3<E> descendingIterator();
  
  public ImmutableSortedSet<E> descendingSet()
  {
    ImmutableSortedSet localImmutableSortedSet1 = this.descendingSet;
    ImmutableSortedSet localImmutableSortedSet2 = localImmutableSortedSet1;
    if (localImmutableSortedSet1 == null)
    {
      localImmutableSortedSet2 = createDescendingSet();
      this.descendingSet = localImmutableSortedSet2;
      localImmutableSortedSet2.descendingSet = this;
    }
    return localImmutableSortedSet2;
  }
  
  public E first()
  {
    return (E)iterator().next();
  }
  
  public E floor(E paramE)
  {
    return (E)k1.n(headSet(paramE, true).descendingIterator(), null);
  }
  
  public ImmutableSortedSet<E> headSet(E paramE)
  {
    return headSet(paramE, false);
  }
  
  public ImmutableSortedSet<E> headSet(E paramE, boolean paramBoolean)
  {
    return headSetImpl(n.o(paramE), paramBoolean);
  }
  
  abstract ImmutableSortedSet<E> headSetImpl(E paramE, boolean paramBoolean);
  
  public E higher(E paramE)
  {
    return (E)j1.e(tailSet(paramE, false), null);
  }
  
  abstract int indexOf(@NullableDecl Object paramObject);
  
  public abstract j3<E> iterator();
  
  public E last()
  {
    return (E)descendingIterator().next();
  }
  
  public E lower(E paramE)
  {
    return (E)k1.n(headSet(paramE, false).descendingIterator(), null);
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final E pollFirst()
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final E pollLast()
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableSortedSet<E> subSet(E paramE1, E paramE2)
  {
    return subSet(paramE1, true, paramE2, false);
  }
  
  public ImmutableSortedSet<E> subSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
  {
    n.o(paramE1);
    n.o(paramE2);
    boolean bool;
    if (this.comparator.compare(paramE1, paramE2) <= 0) {
      bool = true;
    } else {
      bool = false;
    }
    n.d(bool);
    return subSetImpl(paramE1, paramBoolean1, paramE2, paramBoolean2);
  }
  
  abstract ImmutableSortedSet<E> subSetImpl(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2);
  
  public ImmutableSortedSet<E> tailSet(E paramE)
  {
    return tailSet(paramE, true);
  }
  
  public ImmutableSortedSet<E> tailSet(E paramE, boolean paramBoolean)
  {
    return tailSetImpl(n.o(paramE), paramBoolean);
  }
  
  abstract ImmutableSortedSet<E> tailSetImpl(E paramE, boolean paramBoolean);
  
  int unsafeCompare(Object paramObject1, Object paramObject2)
  {
    return unsafeCompare(this.comparator, paramObject1, paramObject2);
  }
  
  Object writeReplace()
  {
    return new b(this.comparator, toArray());
  }
  
  public static final class a<E>
    extends ImmutableSet.a<E>
  {
    private final Comparator<? super E> f;
    
    public a(Comparator<? super E> paramComparator)
    {
      this.f = ((Comparator)n.o(paramComparator));
    }
    
    @CanIgnoreReturnValue
    public a<E> l(E paramE)
    {
      super.h(paramE);
      return this;
    }
    
    @CanIgnoreReturnValue
    public a<E> m(Iterator<? extends E> paramIterator)
    {
      super.i(paramIterator);
      return this;
    }
    
    public ImmutableSortedSet<E> n()
    {
      Object localObject = this.a;
      localObject = ImmutableSortedSet.construct(this.f, this.b, (Object[])localObject);
      this.b = ((AbstractCollection)localObject).size();
      this.c = true;
      return (ImmutableSortedSet<E>)localObject;
    }
  }
  
  private static class b<E>
    implements Serializable
  {
    final Comparator<? super E> c;
    final Object[] d;
    
    public b(Comparator<? super E> paramComparator, Object[] paramArrayOfObject)
    {
      this.c = paramComparator;
      this.d = paramArrayOfObject;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\ImmutableSortedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */