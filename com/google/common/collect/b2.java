package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

public abstract interface b2<E>
  extends Iterator<E>
{
  @CanIgnoreReturnValue
  public abstract E next();
  
  public abstract E peek();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\b2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */