package com.google.android.gms.internal.vision;

import java.util.NoSuchElementException;

final class zzfp
  extends zzfr
{
  private final int limit;
  private int position = 0;
  
  zzfp(zzfm paramzzfm)
  {
    this.limit = paramzzfm.size();
  }
  
  public final boolean hasNext()
  {
    return this.position < this.limit;
  }
  
  public final byte nextByte()
  {
    int i = this.position;
    if (i < this.limit)
    {
      this.position = (i + 1);
      return this.zzsp.zzap(i);
    }
    throw new NoSuchElementException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzfp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */