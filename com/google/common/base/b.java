package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class b<T>
  implements Iterator<T>
{
  private b c = b.d;
  @NullableDecl
  private T d;
  
  private boolean c()
  {
    this.c = b.q;
    this.d = a();
    if (this.c != b.f)
    {
      this.c = b.c;
      return true;
    }
    return false;
  }
  
  protected abstract T a();
  
  @NullableDecl
  @CanIgnoreReturnValue
  protected final T b()
  {
    this.c = b.f;
    return null;
  }
  
  public final boolean hasNext()
  {
    boolean bool;
    if (this.c != b.q) {
      bool = true;
    } else {
      bool = false;
    }
    n.u(bool);
    int i = a.a[this.c.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return c();
      }
      return false;
    }
    return true;
  }
  
  public final T next()
  {
    if (hasNext())
    {
      this.c = b.d;
      Object localObject = this.d;
      this.d = null;
      return (T)localObject;
    }
    throw new NoSuchElementException();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
  
  private static enum b
  {
    static
    {
      b localb1 = new b("READY", 0);
      c = localb1;
      b localb2 = new b("NOT_READY", 1);
      d = localb2;
      b localb3 = new b("DONE", 2);
      f = localb3;
      b localb4 = new b("FAILED", 3);
      q = localb4;
      x = new b[] { localb1, localb2, localb3, localb4 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\base\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */