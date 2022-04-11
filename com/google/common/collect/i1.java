package com.google.common.collect;

import java.util.AbstractCollection;

abstract class i1<E>
  extends ImmutableSet<E>
{
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
  {
    return asList().copyIntoArray(paramArrayOfObject, paramInt);
  }
  
  ImmutableList<E> createAsList()
  {
    return new a();
  }
  
  abstract E get(int paramInt);
  
  public j3<E> iterator()
  {
    return asList().iterator();
  }
  
  class a
    extends ImmutableList<E>
  {
    a() {}
    
    public E get(int paramInt)
    {
      return (E)i1.this.get(paramInt);
    }
    
    boolean isPartialView()
    {
      return i1.this.isPartialView();
    }
    
    public int size()
    {
      return i1.this.size();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\i1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */