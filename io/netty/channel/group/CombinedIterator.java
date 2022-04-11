package io.netty.channel.group;

import io.netty.util.internal.ObjectUtil;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class CombinedIterator<E>
  implements Iterator<E>
{
  private Iterator<E> currentIterator;
  private final Iterator<E> i1;
  private final Iterator<E> i2;
  
  CombinedIterator(Iterator<E> paramIterator1, Iterator<E> paramIterator2)
  {
    this.i1 = ((Iterator)ObjectUtil.checkNotNull(paramIterator1, "i1"));
    this.i2 = ((Iterator)ObjectUtil.checkNotNull(paramIterator2, "i2"));
    this.currentIterator = paramIterator1;
  }
  
  public boolean hasNext()
  {
    for (;;)
    {
      if (this.currentIterator.hasNext()) {
        return true;
      }
      if (this.currentIterator != this.i1) {
        break;
      }
      this.currentIterator = this.i2;
    }
    return false;
  }
  
  public E next()
  {
    try
    {
      Object localObject = this.currentIterator.next();
      return (E)localObject;
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      while (this.currentIterator == this.i1) {
        this.currentIterator = this.i2;
      }
      throw localNoSuchElementException;
    }
  }
  
  public void remove()
  {
    this.currentIterator.remove();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\group\CombinedIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */