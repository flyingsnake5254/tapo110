package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.r.a;

public abstract class c<T>
  implements Iterator<T>, a
{
  private i0 c = i0.d;
  private T d;
  
  private final boolean d()
  {
    this.c = i0.q;
    a();
    boolean bool;
    if (this.c == i0.c) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected abstract void a();
  
  protected final void b()
  {
    this.c = i0.f;
  }
  
  protected final void c(T paramT)
  {
    this.d = paramT;
    this.c = i0.c;
  }
  
  public boolean hasNext()
  {
    i0 locali01 = this.c;
    i0 locali02 = i0.q;
    boolean bool = false;
    int i;
    if (locali01 != locali02) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      i = b.a[locali01.ordinal()];
      if (i != 1) {
        if (i != 2) {
          bool = d();
        } else {
          bool = true;
        }
      }
      return bool;
    }
    throw new IllegalArgumentException("Failed requirement.".toString());
  }
  
  public T next()
  {
    if (hasNext())
    {
      this.c = i0.d;
      return (T)this.d;
    }
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */