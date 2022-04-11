package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;
import java.util.List;

final class zzht
  implements Iterator<String>
{
  private Iterator<String> zza;
  
  zzht(zzhr paramzzhr)
  {
    this.zza = zzhr.zza(paramzzhr).iterator();
  }
  
  public final boolean hasNext()
  {
    return this.zza.hasNext();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */