package com.google.common.collect;

import com.google.common.base.k;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class n0<E>
  extends s0
  implements Collection<E>
{
  @CanIgnoreReturnValue
  public boolean add(E paramE)
  {
    return delegate().add(paramE);
  }
  
  @CanIgnoreReturnValue
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    return delegate().addAll(paramCollection);
  }
  
  public void clear()
  {
    delegate().clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return delegate().contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return delegate().containsAll(paramCollection);
  }
  
  protected abstract Collection<E> delegate();
  
  public boolean isEmpty()
  {
    return delegate().isEmpty();
  }
  
  public Iterator<E> iterator()
  {
    return delegate().iterator();
  }
  
  @CanIgnoreReturnValue
  public boolean remove(Object paramObject)
  {
    return delegate().remove(paramObject);
  }
  
  @CanIgnoreReturnValue
  public boolean removeAll(Collection<?> paramCollection)
  {
    return delegate().removeAll(paramCollection);
  }
  
  @CanIgnoreReturnValue
  public boolean retainAll(Collection<?> paramCollection)
  {
    return delegate().retainAll(paramCollection);
  }
  
  public int size()
  {
    return delegate().size();
  }
  
  protected boolean standardAddAll(Collection<? extends E> paramCollection)
  {
    return k1.a(this, paramCollection.iterator());
  }
  
  protected void standardClear()
  {
    k1.d(iterator());
  }
  
  protected boolean standardContains(@NullableDecl Object paramObject)
  {
    return k1.f(iterator(), paramObject);
  }
  
  protected boolean standardContainsAll(Collection<?> paramCollection)
  {
    return w.b(this, paramCollection);
  }
  
  protected boolean standardIsEmpty()
  {
    return iterator().hasNext() ^ true;
  }
  
  protected boolean standardRemove(@NullableDecl Object paramObject)
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      if (k.a(localIterator.next(), paramObject))
      {
        localIterator.remove();
        return true;
      }
    }
    return false;
  }
  
  protected boolean standardRemoveAll(Collection<?> paramCollection)
  {
    return k1.s(iterator(), paramCollection);
  }
  
  protected boolean standardRetainAll(Collection<?> paramCollection)
  {
    return k1.t(iterator(), paramCollection);
  }
  
  protected Object[] standardToArray()
  {
    return toArray(new Object[size()]);
  }
  
  protected <T> T[] standardToArray(T[] paramArrayOfT)
  {
    return x1.g(this, paramArrayOfT);
  }
  
  protected String standardToString()
  {
    return w.f(this);
  }
  
  public Object[] toArray()
  {
    return delegate().toArray();
  }
  
  @CanIgnoreReturnValue
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return delegate().toArray(paramArrayOfT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\n0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */