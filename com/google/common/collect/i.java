package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class i<E>
  extends AbstractCollection<E>
  implements u1<E>
{
  @MonotonicNonNullDecl
  private transient Set<E> elementSet;
  @MonotonicNonNullDecl
  private transient Set<u1.a<E>> entrySet;
  
  @CanIgnoreReturnValue
  public int add(@NullableDecl E paramE, int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  @CanIgnoreReturnValue
  public final boolean add(@NullableDecl E paramE)
  {
    add(paramE, 1);
    return true;
  }
  
  @CanIgnoreReturnValue
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    return v1.c(this, paramCollection);
  }
  
  public abstract void clear();
  
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
  
  Set<E> createElementSet()
  {
    return new a();
  }
  
  Set<u1.a<E>> createEntrySet()
  {
    return new b();
  }
  
  abstract int distinctElements();
  
  abstract Iterator<E> elementIterator();
  
  public Set<E> elementSet()
  {
    Set localSet1 = this.elementSet;
    Set localSet2 = localSet1;
    if (localSet1 == null)
    {
      localSet2 = createElementSet();
      this.elementSet = localSet2;
    }
    return localSet2;
  }
  
  abstract Iterator<u1.a<E>> entryIterator();
  
  public Set<u1.a<E>> entrySet()
  {
    Set localSet1 = this.entrySet;
    Set localSet2 = localSet1;
    if (localSet1 == null)
    {
      localSet2 = createEntrySet();
      this.entrySet = localSet2;
    }
    return localSet2;
  }
  
  public final boolean equals(@NullableDecl Object paramObject)
  {
    return v1.f(this, paramObject);
  }
  
  public final int hashCode()
  {
    return entrySet().hashCode();
  }
  
  public boolean isEmpty()
  {
    return entrySet().isEmpty();
  }
  
  @CanIgnoreReturnValue
  public int remove(@NullableDecl Object paramObject, int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  @CanIgnoreReturnValue
  public final boolean remove(@NullableDecl Object paramObject)
  {
    boolean bool = true;
    if (remove(paramObject, 1) <= 0) {
      bool = false;
    }
    return bool;
  }
  
  @CanIgnoreReturnValue
  public final boolean removeAll(Collection<?> paramCollection)
  {
    return v1.j(this, paramCollection);
  }
  
  @CanIgnoreReturnValue
  public final boolean retainAll(Collection<?> paramCollection)
  {
    return v1.k(this, paramCollection);
  }
  
  @CanIgnoreReturnValue
  public int setCount(@NullableDecl E paramE, int paramInt)
  {
    return v1.l(this, paramE, paramInt);
  }
  
  @CanIgnoreReturnValue
  public boolean setCount(@NullableDecl E paramE, int paramInt1, int paramInt2)
  {
    return v1.m(this, paramE, paramInt1, paramInt2);
  }
  
  public final String toString()
  {
    return entrySet().toString();
  }
  
  class a
    extends v1.c<E>
  {
    a() {}
    
    u1<E> c()
    {
      return i.this;
    }
    
    public Iterator<E> iterator()
    {
      return i.this.elementIterator();
    }
  }
  
  class b
    extends v1.d<E>
  {
    b() {}
    
    u1<E> c()
    {
      return i.this;
    }
    
    public Iterator<u1.a<E>> iterator()
    {
      return i.this.entryIterator();
    }
    
    public int size()
    {
      return i.this.distinctElements();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */