package com.google.common.collect;

import java.util.Iterator;

public abstract class j3<E>
  implements Iterator<E>
{
  @Deprecated
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\j3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */