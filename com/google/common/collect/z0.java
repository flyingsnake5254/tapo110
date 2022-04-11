package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractCollection;

abstract class z0<E>
  extends ImmutableList<E>
{
  abstract ImmutableCollection<E> a();
  
  public boolean contains(Object paramObject)
  {
    return a().contains(paramObject);
  }
  
  public boolean isEmpty()
  {
    return a().isEmpty();
  }
  
  boolean isPartialView()
  {
    return a().isPartialView();
  }
  
  public int size()
  {
    return a().size();
  }
  
  Object writeReplace()
  {
    return new a(a());
  }
  
  static class a
    implements Serializable
  {
    final ImmutableCollection<?> c;
    
    a(ImmutableCollection<?> paramImmutableCollection)
    {
      this.c = paramImmutableCollection;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\z0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */