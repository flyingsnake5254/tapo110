package com.google.common.collect;

import com.google.common.base.n;
import java.util.NoSuchElementException;

abstract class b<E>
  extends k3<E>
{
  private final int c;
  private int d;
  
  protected b(int paramInt)
  {
    this(paramInt, 0);
  }
  
  protected b(int paramInt1, int paramInt2)
  {
    n.r(paramInt2, paramInt1);
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  protected abstract E a(int paramInt);
  
  public final boolean hasNext()
  {
    boolean bool;
    if (this.d < this.c) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean hasPrevious()
  {
    boolean bool;
    if (this.d > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final E next()
  {
    if (hasNext())
    {
      int i = this.d;
      this.d = (i + 1);
      return (E)a(i);
    }
    throw new NoSuchElementException();
  }
  
  public final int nextIndex()
  {
    return this.d;
  }
  
  public final E previous()
  {
    if (hasPrevious())
    {
      int i = this.d - 1;
      this.d = i;
      return (E)a(i);
    }
    throw new NoSuchElementException();
  }
  
  public final int previousIndex()
  {
    return this.d - 1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */