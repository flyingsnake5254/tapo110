package io.netty.util.internal;

import java.util.Iterator;

public final class ReadOnlyIterator<T>
  implements Iterator<T>
{
  private final Iterator<? extends T> iterator;
  
  public ReadOnlyIterator(Iterator<? extends T> paramIterator)
  {
    this.iterator = ((Iterator)ObjectUtil.checkNotNull(paramIterator, "iterator"));
  }
  
  public boolean hasNext()
  {
    return this.iterator.hasNext();
  }
  
  public T next()
  {
    return (T)this.iterator.next();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("read-only");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\ReadOnlyIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */