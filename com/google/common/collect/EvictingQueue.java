package com.google.common.collect;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

public final class EvictingQueue<E>
  extends t0<E>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  private final Queue<E> delegate;
  final int maxSize;
  
  private EvictingQueue(int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    n.f(bool, "maxSize (%s) must >= 0", paramInt);
    this.delegate = new ArrayDeque(paramInt);
    this.maxSize = paramInt;
  }
  
  public static <E> EvictingQueue<E> create(int paramInt)
  {
    return new EvictingQueue(paramInt);
  }
  
  @CanIgnoreReturnValue
  public boolean add(E paramE)
  {
    n.o(paramE);
    if (this.maxSize == 0) {
      return true;
    }
    if (size() == this.maxSize) {
      this.delegate.remove();
    }
    this.delegate.add(paramE);
    return true;
  }
  
  @CanIgnoreReturnValue
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    int i = paramCollection.size();
    if (i >= this.maxSize)
    {
      clear();
      return j1.a(this, j1.k(paramCollection, i - this.maxSize));
    }
    return standardAddAll(paramCollection);
  }
  
  public boolean contains(Object paramObject)
  {
    return delegate().contains(n.o(paramObject));
  }
  
  protected Queue<E> delegate()
  {
    return this.delegate;
  }
  
  @CanIgnoreReturnValue
  public boolean offer(E paramE)
  {
    return add(paramE);
  }
  
  public int remainingCapacity()
  {
    return this.maxSize - size();
  }
  
  @CanIgnoreReturnValue
  public boolean remove(Object paramObject)
  {
    return delegate().remove(n.o(paramObject));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\EvictingQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */