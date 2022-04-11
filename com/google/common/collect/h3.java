package com.google.common.collect;

import com.google.common.base.n;
import java.util.Iterator;

abstract class h3<F, T>
  implements Iterator<T>
{
  final Iterator<? extends F> c;
  
  h3(Iterator<? extends F> paramIterator)
  {
    this.c = ((Iterator)n.o(paramIterator));
  }
  
  abstract T a(F paramF);
  
  public final boolean hasNext()
  {
    return this.c.hasNext();
  }
  
  public final T next()
  {
    return (T)a(this.c.next());
  }
  
  public final void remove()
  {
    this.c.remove();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\h3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */