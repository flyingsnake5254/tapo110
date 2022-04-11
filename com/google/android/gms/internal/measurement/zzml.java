package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

final class zzml
  implements Iterator<String>
{
  final Iterator<String> zza;
  
  zzml(zzmm paramzzmm)
  {
    this.zza = zzmm.zza(paramzzmm).iterator();
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzml.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */