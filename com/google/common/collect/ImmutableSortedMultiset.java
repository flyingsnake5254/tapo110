package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.math.c;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

public abstract class ImmutableSortedMultiset<E>
  extends g1<E>
  implements a3<E>
{
  @LazyInit
  transient ImmutableSortedMultiset<E> descendingMultiset;
  
  public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> paramIterable)
  {
    return copyOf(a2.g(), paramIterable);
  }
  
  public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> paramComparator, Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof ImmutableSortedMultiset))
    {
      ImmutableSortedMultiset localImmutableSortedMultiset = (ImmutableSortedMultiset)paramIterable;
      if (paramComparator.equals(localImmutableSortedMultiset.comparator()))
      {
        if (localImmutableSortedMultiset.isPartialView()) {
          return copyOfSortedEntries(paramComparator, localImmutableSortedMultiset.entrySet().asList());
        }
        return localImmutableSortedMultiset;
      }
    }
    return new a(paramComparator).o(paramIterable).r();
  }
  
  public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> paramComparator, Iterator<? extends E> paramIterator)
  {
    n.o(paramComparator);
    return new a(paramComparator).p(paramIterator).r();
  }
  
  public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> paramIterator)
  {
    return copyOf(a2.g(), paramIterator);
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> copyOf(E[] paramArrayOfE)
  {
    return copyOf(a2.g(), Arrays.asList(paramArrayOfE));
  }
  
  public static <E> ImmutableSortedMultiset<E> copyOfSorted(a3<E> parama3)
  {
    return copyOfSortedEntries(parama3.comparator(), n1.i(parama3.entrySet()));
  }
  
  private static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> paramComparator, Collection<u1.a<E>> paramCollection)
  {
    if (paramCollection.isEmpty()) {
      return emptyMultiset(paramComparator);
    }
    ImmutableList.a locala = new ImmutableList.a(paramCollection.size());
    long[] arrayOfLong = new long[paramCollection.size() + 1];
    Iterator localIterator = paramCollection.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      u1.a locala1 = (u1.a)localIterator.next();
      locala.h(locala1.a());
      j = i + 1;
      arrayOfLong[i] += locala1.getCount();
    }
    return new m2(new n2(locala.j(), paramComparator), arrayOfLong, 0, paramCollection.size());
  }
  
  static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> paramComparator)
  {
    if (a2.g().equals(paramComparator)) {
      return m2.d;
    }
    return new m2(paramComparator);
  }
  
  public static <E extends Comparable<?>> a<E> naturalOrder()
  {
    return new a(a2.g());
  }
  
  public static <E> ImmutableSortedMultiset<E> of()
  {
    return m2.d;
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E paramE)
  {
    return new m2((n2)ImmutableSortedSet.of(paramE), new long[] { 0L, 1L }, 0, 1);
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E paramE1, E paramE2)
  {
    return copyOf(a2.g(), Arrays.asList(new Comparable[] { paramE1, paramE2 }));
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E paramE1, E paramE2, E paramE3)
  {
    return copyOf(a2.g(), Arrays.asList(new Comparable[] { paramE1, paramE2, paramE3 }));
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4)
  {
    return copyOf(a2.g(), Arrays.asList(new Comparable[] { paramE1, paramE2, paramE3, paramE4 }));
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5)
  {
    return copyOf(a2.g(), Arrays.asList(new Comparable[] { paramE1, paramE2, paramE3, paramE4, paramE5 }));
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E... paramVarArgs)
  {
    ArrayList localArrayList = n1.k(paramVarArgs.length + 6);
    Collections.addAll(localArrayList, new Comparable[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6 });
    Collections.addAll(localArrayList, paramVarArgs);
    return copyOf(a2.g(), localArrayList);
  }
  
  public static <E> a<E> orderedBy(Comparator<E> paramComparator)
  {
    return new a(paramComparator);
  }
  
  public static <E extends Comparable<?>> a<E> reverseOrder()
  {
    return new a(a2.g().j());
  }
  
  public final Comparator<? super E> comparator()
  {
    return elementSet().comparator();
  }
  
  public ImmutableSortedMultiset<E> descendingMultiset()
  {
    ImmutableSortedMultiset localImmutableSortedMultiset = this.descendingMultiset;
    Object localObject = localImmutableSortedMultiset;
    if (localImmutableSortedMultiset == null)
    {
      if (isEmpty()) {
        localObject = emptyMultiset(a2.a(comparator()).j());
      } else {
        localObject = new f0(this);
      }
      this.descendingMultiset = ((ImmutableSortedMultiset)localObject);
    }
    return (ImmutableSortedMultiset<E>)localObject;
  }
  
  public abstract ImmutableSortedSet<E> elementSet();
  
  public abstract ImmutableSortedMultiset<E> headMultiset(E paramE, BoundType paramBoundType);
  
  @Deprecated
  @CanIgnoreReturnValue
  public final u1.a<E> pollFirstEntry()
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final u1.a<E> pollLastEntry()
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableSortedMultiset<E> subMultiset(E paramE1, BoundType paramBoundType1, E paramE2, BoundType paramBoundType2)
  {
    boolean bool;
    if (comparator().compare(paramE1, paramE2) <= 0) {
      bool = true;
    } else {
      bool = false;
    }
    n.k(bool, "Expected lowerBound <= upperBound but %s > %s", paramE1, paramE2);
    return tailMultiset(paramE1, paramBoundType1).headMultiset(paramE2, paramBoundType2);
  }
  
  public abstract ImmutableSortedMultiset<E> tailMultiset(E paramE, BoundType paramBoundType);
  
  Object writeReplace()
  {
    return new b(this);
  }
  
  public static class a<E>
    extends ImmutableMultiset.b<E>
  {
    private final Comparator<? super E> d;
    E[] e;
    private int[] f;
    private int g;
    private boolean h;
    
    public a(Comparator<? super E> paramComparator)
    {
      super();
      this.d = ((Comparator)n.o(paramComparator));
      this.e = new Object[4];
      this.f = new int[4];
    }
    
    private void s(boolean paramBoolean)
    {
      int i = this.g;
      if (i == 0) {
        return;
      }
      Object localObject1 = Arrays.copyOf(this.e, i);
      Arrays.sort((Object[])localObject1, this.d);
      int j = 1;
      for (i = 1; j < localObject1.length; i = k)
      {
        k = i;
        if (this.d.compare(localObject1[(i - 1)], localObject1[j]) < 0)
        {
          localObject1[i] = localObject1[j];
          k = i + 1;
        }
        j++;
      }
      Arrays.fill((Object[])localObject1, i, this.g, null);
      Object localObject2 = localObject1;
      if (paramBoolean)
      {
        k = this.g;
        localObject2 = localObject1;
        if (i * 4 > k * 3) {
          localObject2 = Arrays.copyOf((Object[])localObject1, c.b(k, k / 2 + 1));
        }
      }
      int[] arrayOfInt = new int[localObject2.length];
      for (int k = 0; k < this.g; k++)
      {
        j = Arrays.binarySearch((Object[])localObject2, 0, i, this.e[k], this.d);
        localObject1 = this.f;
        if (localObject1[k] >= 0) {
          arrayOfInt[j] += localObject1[k];
        } else {
          localObject1[k] ^= 0xFFFFFFFF;
        }
      }
      this.e = ((Object[])localObject2);
      this.f = arrayOfInt;
      this.g = i;
    }
    
    private void t()
    {
      s(false);
      int i = 0;
      int k;
      for (int j = 0;; j = k)
      {
        k = this.g;
        if (i >= k) {
          break;
        }
        int[] arrayOfInt = this.f;
        k = j;
        if (arrayOfInt[i] > 0)
        {
          Object[] arrayOfObject = this.e;
          arrayOfObject[j] = arrayOfObject[i];
          arrayOfInt[j] = arrayOfInt[i];
          k = j + 1;
        }
        i++;
      }
      Arrays.fill(this.e, j, k, null);
      Arrays.fill(this.f, j, this.g, 0);
      this.g = j;
    }
    
    private void u()
    {
      int i = this.g;
      Object[] arrayOfObject = this.e;
      if (i == arrayOfObject.length) {
        s(true);
      } else if (this.h) {
        this.e = Arrays.copyOf(arrayOfObject, arrayOfObject.length);
      }
      this.h = false;
    }
    
    @CanIgnoreReturnValue
    public a<E> m(E paramE)
    {
      return q(paramE, 1);
    }
    
    @CanIgnoreReturnValue
    public a<E> n(E... paramVarArgs)
    {
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++) {
        m(paramVarArgs[j]);
      }
      return this;
    }
    
    @CanIgnoreReturnValue
    public a<E> o(Iterable<? extends E> paramIterable)
    {
      if ((paramIterable instanceof u1))
      {
        Iterator localIterator = ((u1)paramIterable).entrySet().iterator();
        while (localIterator.hasNext())
        {
          paramIterable = (u1.a)localIterator.next();
          q(paramIterable.a(), paramIterable.getCount());
        }
      }
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        m(paramIterable.next());
      }
      return this;
    }
    
    @CanIgnoreReturnValue
    public a<E> p(Iterator<? extends E> paramIterator)
    {
      while (paramIterator.hasNext()) {
        m(paramIterator.next());
      }
      return this;
    }
    
    @CanIgnoreReturnValue
    public a<E> q(E paramE, int paramInt)
    {
      n.o(paramE);
      v.b(paramInt, "occurrences");
      if (paramInt == 0) {
        return this;
      }
      u();
      Object[] arrayOfObject = this.e;
      int i = this.g;
      arrayOfObject[i] = paramE;
      this.f[i] = paramInt;
      this.g = (i + 1);
      return this;
    }
    
    public ImmutableSortedMultiset<E> r()
    {
      t();
      int i = this.g;
      if (i == 0) {
        return ImmutableSortedMultiset.emptyMultiset(this.d);
      }
      n2 localn2 = (n2)ImmutableSortedSet.construct(this.d, i, this.e);
      long[] arrayOfLong = new long[this.g + 1];
      int j;
      for (i = 0; i < this.g; i = j)
      {
        j = i + 1;
        arrayOfLong[i] += this.f[i];
      }
      this.h = true;
      return new m2(localn2, arrayOfLong, 0, this.g);
    }
  }
  
  private static final class b<E>
    implements Serializable
  {
    final Comparator<? super E> c;
    final E[] d;
    final int[] f;
    
    b(a3<E> parama3)
    {
      this.c = parama3.comparator();
      int i = parama3.entrySet().size();
      this.d = new Object[i];
      this.f = new int[i];
      parama3 = parama3.entrySet().iterator();
      for (i = 0; parama3.hasNext(); i++)
      {
        u1.a locala = (u1.a)parama3.next();
        this.d[i] = locala.a();
        this.f[i] = locala.getCount();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\ImmutableSortedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */