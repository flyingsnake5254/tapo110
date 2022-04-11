package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.List;

final class zzjv
  implements Iterator<String>
{
  private Iterator<String> zzaby;
  
  zzjv(zzjt paramzzjt)
  {
    this.zzaby = zzjt.zza(paramzzjt).iterator();
  }
  
  public final boolean hasNext()
  {
    return this.zzaby.hasNext();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzjv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */