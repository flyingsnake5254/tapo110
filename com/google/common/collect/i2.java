package com.google.common.collect;

import com.google.common.base.n;

class i2<E>
  extends ImmutableList<E>
{
  static final ImmutableList<Object> c = new i2(new Object[0], 0);
  final transient Object[] d;
  private final transient int f;
  
  i2(Object[] paramArrayOfObject, int paramInt)
  {
    this.d = paramArrayOfObject;
    this.f = paramInt;
  }
  
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
  {
    System.arraycopy(this.d, 0, paramArrayOfObject, paramInt, this.f);
    return paramInt + this.f;
  }
  
  public E get(int paramInt)
  {
    n.m(paramInt, this.f);
    return (E)this.d[paramInt];
  }
  
  Object[] internalArray()
  {
    return this.d;
  }
  
  int internalArrayEnd()
  {
    return this.f;
  }
  
  int internalArrayStart()
  {
    return 0;
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public int size()
  {
    return this.f;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\i2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */