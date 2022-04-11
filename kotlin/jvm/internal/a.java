package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class a<T>
  implements Iterator<T>, kotlin.jvm.internal.r.a
{
  private int c;
  private final T[] d;
  
  public a(T[] paramArrayOfT)
  {
    this.d = paramArrayOfT;
  }
  
  public boolean hasNext()
  {
    boolean bool;
    if (this.c < this.d.length) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public T next()
  {
    try
    {
      Object localObject = this.d;
      int i = this.c;
      this.c = (i + 1);
      localObject = localObject[i];
      return (T)localObject;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      this.c -= 1;
      throw new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage());
    }
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */