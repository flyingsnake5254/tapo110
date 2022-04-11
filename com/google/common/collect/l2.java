package com.google.common.collect;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class l2<E>
  extends ImmutableSet<E>
{
  static final l2<Object> c = new l2(new Object[0], 0, null, 0, 0);
  final transient Object[] d;
  final transient Object[] f;
  private final transient int q;
  private final transient int x;
  private final transient int y;
  
  l2(Object[] paramArrayOfObject1, int paramInt1, Object[] paramArrayOfObject2, int paramInt2, int paramInt3)
  {
    this.d = paramArrayOfObject1;
    this.f = paramArrayOfObject2;
    this.q = paramInt2;
    this.x = paramInt1;
    this.y = paramInt3;
  }
  
  public boolean contains(@NullableDecl Object paramObject)
  {
    Object[] arrayOfObject = this.f;
    if ((paramObject != null) && (arrayOfObject != null)) {
      for (int i = y0.d(paramObject);; i++)
      {
        i &= this.q;
        Object localObject = arrayOfObject[i];
        if (localObject == null) {
          return false;
        }
        if (localObject.equals(paramObject)) {
          return true;
        }
      }
    }
    return false;
  }
  
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
  {
    System.arraycopy(this.d, 0, paramArrayOfObject, paramInt, this.y);
    return paramInt + this.y;
  }
  
  ImmutableList<E> createAsList()
  {
    return ImmutableList.asImmutableList(this.d, this.y);
  }
  
  public int hashCode()
  {
    return this.x;
  }
  
  Object[] internalArray()
  {
    return this.d;
  }
  
  int internalArrayEnd()
  {
    return this.y;
  }
  
  int internalArrayStart()
  {
    return 0;
  }
  
  boolean isHashCodeFast()
  {
    return true;
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public j3<E> iterator()
  {
    return asList().iterator();
  }
  
  public int size()
  {
    return this.y;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\l2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */