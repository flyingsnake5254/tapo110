package com.google.common.collect;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ImmutableMultiset<E>
  extends e1<E>
  implements u1<E>
{
  @LazyInit
  private transient ImmutableList<E> asList;
  @LazyInit
  private transient ImmutableSet<u1.a<E>> entrySet;
  
  public static <E> b<E> builder()
  {
    return new b();
  }
  
  private static <E> ImmutableMultiset<E> copyFromElements(E... paramVarArgs)
  {
    return new b().g(paramVarArgs).k();
  }
  
  static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends u1.a<? extends E>> paramCollection)
  {
    b localb = new b(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      u1.a locala = (u1.a)paramCollection.next();
      localb.j(locala.a(), locala.getCount());
    }
    return localb.k();
  }
  
  public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof ImmutableMultiset))
    {
      localObject = (ImmutableMultiset)paramIterable;
      if (!((ImmutableCollection)localObject).isPartialView()) {
        return (ImmutableMultiset<E>)localObject;
      }
    }
    Object localObject = new b(v1.h(paramIterable));
    ((b)localObject).h(paramIterable);
    return ((b)localObject).k();
  }
  
  public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> paramIterator)
  {
    return new b().i(paramIterator).k();
  }
  
  public static <E> ImmutableMultiset<E> copyOf(E[] paramArrayOfE)
  {
    return copyFromElements(paramArrayOfE);
  }
  
  private ImmutableSet<u1.a<E>> createEntrySet()
  {
    Object localObject;
    if (isEmpty()) {
      localObject = ImmutableSet.of();
    } else {
      localObject = new c(null);
    }
    return (ImmutableSet<u1.a<E>>)localObject;
  }
  
  public static <E> ImmutableMultiset<E> of()
  {
    return k2.c;
  }
  
  public static <E> ImmutableMultiset<E> of(E paramE)
  {
    return copyFromElements(new Object[] { paramE });
  }
  
  public static <E> ImmutableMultiset<E> of(E paramE1, E paramE2)
  {
    return copyFromElements(new Object[] { paramE1, paramE2 });
  }
  
  public static <E> ImmutableMultiset<E> of(E paramE1, E paramE2, E paramE3)
  {
    return copyFromElements(new Object[] { paramE1, paramE2, paramE3 });
  }
  
  public static <E> ImmutableMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4)
  {
    return copyFromElements(new Object[] { paramE1, paramE2, paramE3, paramE4 });
  }
  
  public static <E> ImmutableMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5)
  {
    return copyFromElements(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5 });
  }
  
  public static <E> ImmutableMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E... paramVarArgs)
  {
    return new b().f(paramE1).f(paramE2).f(paramE3).f(paramE4).f(paramE5).f(paramE6).g(paramVarArgs).k();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final int add(E paramE, int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableList<E> asList()
  {
    ImmutableList localImmutableList1 = this.asList;
    ImmutableList localImmutableList2 = localImmutableList1;
    if (localImmutableList1 == null)
    {
      localImmutableList2 = super.asList();
      this.asList = localImmutableList2;
    }
    return localImmutableList2;
  }
  
  public boolean contains(@NullableDecl Object paramObject)
  {
    boolean bool;
    if (count(paramObject) > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
  {
    j3 localj3 = entrySet().iterator();
    while (localj3.hasNext())
    {
      u1.a locala = (u1.a)localj3.next();
      Arrays.fill(paramArrayOfObject, paramInt, locala.getCount() + paramInt, locala.a());
      paramInt += locala.getCount();
    }
    return paramInt;
  }
  
  public abstract ImmutableSet<E> elementSet();
  
  public ImmutableSet<u1.a<E>> entrySet()
  {
    ImmutableSet localImmutableSet1 = this.entrySet;
    ImmutableSet localImmutableSet2 = localImmutableSet1;
    if (localImmutableSet1 == null)
    {
      localImmutableSet2 = createEntrySet();
      this.entrySet = localImmutableSet2;
    }
    return localImmutableSet2;
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    return v1.f(this, paramObject);
  }
  
  abstract u1.a<E> getEntry(int paramInt);
  
  public int hashCode()
  {
    return u2.b(entrySet());
  }
  
  public j3<E> iterator()
  {
    return new a(entrySet().iterator());
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final int remove(Object paramObject, int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final int setCount(E paramE, int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final boolean setCount(E paramE, int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    return entrySet().toString();
  }
  
  abstract Object writeReplace();
  
  class a
    extends j3<E>
  {
    int c;
    @MonotonicNonNullDecl
    E d;
    
    a(Iterator paramIterator) {}
    
    public boolean hasNext()
    {
      boolean bool;
      if ((this.c <= 0) && (!this.f.hasNext())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public E next()
    {
      if (this.c <= 0)
      {
        u1.a locala = (u1.a)this.f.next();
        this.d = locala.a();
        this.c = locala.getCount();
      }
      this.c -= 1;
      return (E)this.d;
    }
  }
  
  public static class b<E>
    extends ImmutableCollection.b<E>
  {
    y1<E> a;
    boolean b = false;
    boolean c = false;
    
    public b()
    {
      this(4);
    }
    
    b(int paramInt)
    {
      this.a = y1.c(paramInt);
    }
    
    b(boolean paramBoolean)
    {
      this.a = null;
    }
    
    @NullableDecl
    static <T> y1<T> l(Iterable<T> paramIterable)
    {
      if ((paramIterable instanceof k2)) {
        return ((k2)paramIterable).d;
      }
      if ((paramIterable instanceof f)) {
        return ((f)paramIterable).backingMap;
      }
      return null;
    }
    
    @CanIgnoreReturnValue
    public b<E> f(E paramE)
    {
      return j(paramE, 1);
    }
    
    @CanIgnoreReturnValue
    public b<E> g(E... paramVarArgs)
    {
      super.b(paramVarArgs);
      return this;
    }
    
    @CanIgnoreReturnValue
    public b<E> h(Iterable<? extends E> paramIterable)
    {
      if ((paramIterable instanceof u1))
      {
        paramIterable = v1.d(paramIterable);
        Object localObject = l(paramIterable);
        if (localObject != null)
        {
          paramIterable = this.a;
          paramIterable.d(Math.max(paramIterable.C(), ((y1)localObject).C()));
          for (int i = ((y1)localObject).e(); i >= 0; i = ((y1)localObject).s(i)) {
            j(((y1)localObject).i(i), ((y1)localObject).k(i));
          }
        }
        Set localSet = paramIterable.entrySet();
        localObject = this.a;
        ((y1)localObject).d(Math.max(((y1)localObject).C(), localSet.size()));
        localObject = paramIterable.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramIterable = (u1.a)((Iterator)localObject).next();
          j(paramIterable.a(), paramIterable.getCount());
        }
      }
      super.c(paramIterable);
      return this;
    }
    
    @CanIgnoreReturnValue
    public b<E> i(Iterator<? extends E> paramIterator)
    {
      super.d(paramIterator);
      return this;
    }
    
    @CanIgnoreReturnValue
    public b<E> j(E paramE, int paramInt)
    {
      if (paramInt == 0) {
        return this;
      }
      if (this.b)
      {
        this.a = new y1(this.a);
        this.c = false;
      }
      this.b = false;
      n.o(paramE);
      y1 localy1 = this.a;
      localy1.u(paramE, paramInt + localy1.f(paramE));
      return this;
    }
    
    public ImmutableMultiset<E> k()
    {
      if (this.a.C() == 0) {
        return ImmutableMultiset.of();
      }
      if (this.c)
      {
        this.a = new y1(this.a);
        this.c = false;
      }
      this.b = true;
      return new k2(this.a);
    }
  }
  
  private final class c
    extends i1<u1.a<E>>
  {
    private c() {}
    
    u1.a<E> a(int paramInt)
    {
      return ImmutableMultiset.this.getEntry(paramInt);
    }
    
    public boolean contains(Object paramObject)
    {
      boolean bool1 = paramObject instanceof u1.a;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        paramObject = (u1.a)paramObject;
        if (((u1.a)paramObject).getCount() <= 0) {
          return false;
        }
        bool3 = bool2;
        if (ImmutableMultiset.this.count(((u1.a)paramObject).a()) == ((u1.a)paramObject).getCount()) {
          bool3 = true;
        }
      }
      return bool3;
    }
    
    public int hashCode()
    {
      return ImmutableMultiset.this.hashCode();
    }
    
    boolean isPartialView()
    {
      return ImmutableMultiset.this.isPartialView();
    }
    
    public int size()
    {
      return ImmutableMultiset.this.elementSet().size();
    }
    
    Object writeReplace()
    {
      return new ImmutableMultiset.d(ImmutableMultiset.this);
    }
  }
  
  static class d<E>
    implements Serializable
  {
    final ImmutableMultiset<E> c;
    
    d(ImmutableMultiset<E> paramImmutableMultiset)
    {
      this.c = paramImmutableMultiset;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\ImmutableMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */