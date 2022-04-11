package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

public abstract class o0<T>
  extends s0
  implements Iterator<T>
{
  protected abstract Iterator<T> a();
  
  public boolean hasNext()
  {
    return a().hasNext();
  }
  
  @CanIgnoreReturnValue
  public T next()
  {
    return (T)a().next();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\o0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */