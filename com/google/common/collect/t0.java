package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.NoSuchElementException;
import java.util.Queue;

public abstract class t0<E>
  extends n0<E>
  implements Queue<E>
{
  protected abstract Queue<E> delegate();
  
  public E element()
  {
    return (E)delegate().element();
  }
  
  @CanIgnoreReturnValue
  public abstract boolean offer(E paramE);
  
  public E peek()
  {
    return (E)delegate().peek();
  }
  
  @CanIgnoreReturnValue
  public E poll()
  {
    return (E)delegate().poll();
  }
  
  @CanIgnoreReturnValue
  public E remove()
  {
    return (E)delegate().remove();
  }
  
  protected boolean standardOffer(E paramE)
  {
    try
    {
      boolean bool = add(paramE);
      return bool;
    }
    catch (IllegalStateException paramE) {}
    return false;
  }
  
  protected E standardPeek()
  {
    try
    {
      Object localObject = element();
      return (E)localObject;
    }
    catch (NoSuchElementException localNoSuchElementException) {}
    return null;
  }
  
  protected E standardPoll()
  {
    try
    {
      Object localObject = remove();
      return (E)localObject;
    }
    catch (NoSuchElementException localNoSuchElementException) {}
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\t0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */