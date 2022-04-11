package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.primitives.d;
import java.util.AbstractCollection;
import java.util.Comparator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class m2<E>
  extends ImmutableSortedMultiset<E>
{
  private static final long[] c = { 0L };
  static final ImmutableSortedMultiset<Comparable> d = new m2(a2.g());
  final transient n2<E> f;
  private final transient long[] q;
  private final transient int x;
  private final transient int y;
  
  m2(n2<E> paramn2, long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    this.f = paramn2;
    this.q = paramArrayOfLong;
    this.x = paramInt1;
    this.y = paramInt2;
  }
  
  m2(Comparator<? super E> paramComparator)
  {
    this.f = ImmutableSortedSet.emptySet(paramComparator);
    this.q = c;
    this.x = 0;
    this.y = 0;
  }
  
  private int a(int paramInt)
  {
    long[] arrayOfLong = this.q;
    int i = this.x;
    return (int)(arrayOfLong[(i + paramInt + 1)] - arrayOfLong[(i + paramInt)]);
  }
  
  ImmutableSortedMultiset<E> b(int paramInt1, int paramInt2)
  {
    n.t(paramInt1, paramInt2, this.y);
    if (paramInt1 == paramInt2) {
      return ImmutableSortedMultiset.emptyMultiset(comparator());
    }
    if ((paramInt1 == 0) && (paramInt2 == this.y)) {
      return this;
    }
    return new m2(this.f.a(paramInt1, paramInt2), this.q, this.x + paramInt1, paramInt2 - paramInt1);
  }
  
  public int count(@NullableDecl Object paramObject)
  {
    int i = this.f.indexOf(paramObject);
    if (i >= 0) {
      i = a(i);
    } else {
      i = 0;
    }
    return i;
  }
  
  public ImmutableSortedSet<E> elementSet()
  {
    return this.f;
  }
  
  public u1.a<E> firstEntry()
  {
    u1.a locala;
    if (isEmpty()) {
      locala = null;
    } else {
      locala = getEntry(0);
    }
    return locala;
  }
  
  u1.a<E> getEntry(int paramInt)
  {
    return v1.g(this.f.asList().get(paramInt), a(paramInt));
  }
  
  public ImmutableSortedMultiset<E> headMultiset(E paramE, BoundType paramBoundType)
  {
    n2 localn2 = this.f;
    boolean bool;
    if (n.o(paramBoundType) == BoundType.CLOSED) {
      bool = true;
    } else {
      bool = false;
    }
    return b(0, localn2.b(paramE, bool));
  }
  
  boolean isPartialView()
  {
    int i = this.x;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (i <= 0) {
      if (this.y < this.q.length - 1) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  public u1.a<E> lastEntry()
  {
    u1.a locala;
    if (isEmpty()) {
      locala = null;
    } else {
      locala = getEntry(this.y - 1);
    }
    return locala;
  }
  
  public int size()
  {
    long[] arrayOfLong = this.q;
    int i = this.x;
    return d.i(arrayOfLong[(this.y + i)] - arrayOfLong[i]);
  }
  
  public ImmutableSortedMultiset<E> tailMultiset(E paramE, BoundType paramBoundType)
  {
    n2 localn2 = this.f;
    boolean bool;
    if (n.o(paramBoundType) == BoundType.CLOSED) {
      bool = true;
    } else {
      bool = false;
    }
    return b(localn2.d(paramE, bool), this.y);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\m2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */