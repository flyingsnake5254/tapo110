package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzbc
  implements Iterator
{
  private final int limit;
  private int position = 0;
  
  zzbc(zzbb paramzzbb)
  {
    this.limit = paramzzbb.size();
  }
  
  private final byte nextByte()
  {
    try
    {
      zzbb localzzbb = this.zzfl;
      int i = this.position;
      this.position = (i + 1);
      byte b = localzzbb.zzj(i);
      return b;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new NoSuchElementException(localIndexOutOfBoundsException.getMessage());
    }
  }
  
  public final boolean hasNext()
  {
    return this.position < this.limit;
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */