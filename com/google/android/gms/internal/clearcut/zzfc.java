package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.List;

final class zzfc
  implements Iterator<String>
{
  private Iterator<String> zzpf;
  
  zzfc(zzfa paramzzfa)
  {
    this.zzpf = zzfa.zza(paramzzfa).iterator();
  }
  
  public final boolean hasNext()
  {
    return this.zzpf.hasNext();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzfc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */