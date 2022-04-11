package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzie
  implements Iterator<Map.Entry<K, V>>
{
  private int zza;
  private Iterator<Map.Entry<K, V>> zzb;
  
  private zzie(zzic paramzzic)
  {
    this.zza = zzic.zzb(paramzzic).size();
  }
  
  private final Iterator<Map.Entry<K, V>> zza()
  {
    if (this.zzb == null) {
      this.zzb = zzic.zzd(this.zzc).entrySet().iterator();
    }
    return this.zzb;
  }
  
  public final boolean hasNext()
  {
    int i = this.zza;
    return ((i > 0) && (i <= zzic.zzb(this.zzc).size())) || (zza().hasNext());
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */