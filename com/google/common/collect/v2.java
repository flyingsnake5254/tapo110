package com.google.common.collect;

import com.google.common.base.n;
import com.google.errorprone.annotations.concurrent.LazyInit;

final class v2<E>
  extends ImmutableSet<E>
{
  final transient E c;
  @LazyInit
  private transient int d;
  
  v2(E paramE)
  {
    this.c = n.o(paramE);
  }
  
  v2(E paramE, int paramInt)
  {
    this.c = paramE;
    this.d = paramInt;
  }
  
  public boolean contains(Object paramObject)
  {
    return this.c.equals(paramObject);
  }
  
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
  {
    paramArrayOfObject[paramInt] = this.c;
    return paramInt + 1;
  }
  
  ImmutableList<E> createAsList()
  {
    return ImmutableList.of(this.c);
  }
  
  public final int hashCode()
  {
    int i = this.d;
    int j = i;
    if (i == 0)
    {
      j = this.c.hashCode();
      this.d = j;
    }
    return j;
  }
  
  boolean isHashCodeFast()
  {
    boolean bool;
    if (this.d != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public j3<E> iterator()
  {
    return k1.u(this.c);
  }
  
  public int size()
  {
    return 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    localStringBuilder.append(this.c.toString());
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\v2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */