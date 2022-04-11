package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzje
  implements Iterator<Object>
{
  public final boolean hasNext()
  {
    return false;
  }
  
  public final Object next()
  {
    throw new NoSuchElementException();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzje.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */