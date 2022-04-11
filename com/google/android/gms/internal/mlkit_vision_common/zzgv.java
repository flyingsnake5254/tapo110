package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzgv
  implements Iterator<Map.Entry<K, V>>
{
  private int zza = -1;
  private boolean zzb;
  private Iterator<Map.Entry<K, V>> zzc;
  
  private zzgv(zzgn paramzzgn) {}
  
  private final Iterator<Map.Entry<K, V>> zza()
  {
    if (this.zzc == null) {
      this.zzc = zzgn.zzc(this.zzd).entrySet().iterator();
    }
    return this.zzc;
  }
  
  public final boolean hasNext()
  {
    return (this.zza + 1 < zzgn.zzb(this.zzd).size()) || ((!zzgn.zzc(this.zzd).isEmpty()) && (zza().hasNext()));
  }
  
  public final void remove()
  {
    if (this.zzb)
    {
      this.zzb = false;
      zzgn.zza(this.zzd);
      if (this.zza < zzgn.zzb(this.zzd).size())
      {
        zzgn localzzgn = this.zzd;
        int i = this.zza;
        this.zza = (i - 1);
        zzgn.zza(localzzgn, i);
        return;
      }
      zza().remove();
      return;
    }
    throw new IllegalStateException("remove() was called before next()");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzgv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */