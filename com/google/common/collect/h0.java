package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

abstract class h0<E>
  extends r0<E>
  implements a3<E>
{
  @MonotonicNonNullDecl
  private transient Comparator<? super E> c;
  @MonotonicNonNullDecl
  private transient NavigableSet<E> d;
  @MonotonicNonNullDecl
  private transient Set<u1.a<E>> f;
  
  protected u1<E> a()
  {
    return f();
  }
  
  Set<u1.a<E>> b()
  {
    return new a();
  }
  
  public Comparator<? super E> comparator()
  {
    Comparator localComparator = this.c;
    Object localObject = localComparator;
    if (localComparator == null)
    {
      localObject = a2.a(f().comparator()).j();
      this.c = ((Comparator)localObject);
    }
    return (Comparator<? super E>)localObject;
  }
  
  abstract Iterator<u1.a<E>> d();
  
  public a3<E> descendingMultiset()
  {
    return f();
  }
  
  public NavigableSet<E> elementSet()
  {
    NavigableSet localNavigableSet = this.d;
    Object localObject = localNavigableSet;
    if (localNavigableSet == null)
    {
      localObject = new b3.b(this);
      this.d = ((NavigableSet)localObject);
    }
    return (NavigableSet<E>)localObject;
  }
  
  public Set<u1.a<E>> entrySet()
  {
    Set localSet1 = this.f;
    Set localSet2 = localSet1;
    if (localSet1 == null)
    {
      localSet2 = b();
      this.f = localSet2;
    }
    return localSet2;
  }
  
  abstract a3<E> f();
  
  public u1.a<E> firstEntry()
  {
    return f().lastEntry();
  }
  
  public a3<E> headMultiset(E paramE, BoundType paramBoundType)
  {
    return f().tailMultiset(paramE, paramBoundType).descendingMultiset();
  }
  
  public u1.a<E> lastEntry()
  {
    return f().firstEntry();
  }
  
  public u1.a<E> pollFirstEntry()
  {
    return f().pollLastEntry();
  }
  
  public u1.a<E> pollLastEntry()
  {
    return f().pollFirstEntry();
  }
  
  public a3<E> subMultiset(E paramE1, BoundType paramBoundType1, E paramE2, BoundType paramBoundType2)
  {
    return f().subMultiset(paramE2, paramBoundType2, paramE1, paramBoundType1).descendingMultiset();
  }
  
  public a3<E> tailMultiset(E paramE, BoundType paramBoundType)
  {
    return f().headMultiset(paramE, paramBoundType).descendingMultiset();
  }
  
  public Object[] toArray()
  {
    return standardToArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return standardToArray(paramArrayOfT);
  }
  
  public String toString()
  {
    return entrySet().toString();
  }
  
  class a
    extends v1.d<E>
  {
    a() {}
    
    u1<E> c()
    {
      return h0.this;
    }
    
    public Iterator<u1.a<E>> iterator()
    {
      return h0.this.d();
    }
    
    public int size()
    {
      return h0.this.f().entrySet().size();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\h0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */