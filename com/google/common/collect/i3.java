package com.google.common.collect;

import java.util.ListIterator;

abstract class i3<F, T>
  extends h3<F, T>
  implements ListIterator<T>
{
  i3(ListIterator<? extends F> paramListIterator)
  {
    super(paramListIterator);
  }
  
  private ListIterator<? extends F> b()
  {
    return k1.c(this.c);
  }
  
  public void add(T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean hasPrevious()
  {
    return b().hasPrevious();
  }
  
  public final int nextIndex()
  {
    return b().nextIndex();
  }
  
  public final T previous()
  {
    return (T)a(b().previous());
  }
  
  public final int previousIndex()
  {
    return b().previousIndex();
  }
  
  public void set(T paramT)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\i3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */