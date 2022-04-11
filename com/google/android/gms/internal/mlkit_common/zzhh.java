package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzhh
  implements Iterator<Map.Entry<K, V>>
{
  private int zza = -1;
  private boolean zzb;
  private Iterator<Map.Entry<K, V>> zzc;
  
  private zzhh(zzgz paramzzgz) {}
  
  private final Iterator<Map.Entry<K, V>> zza()
  {
    if (this.zzc == null) {
      this.zzc = zzgz.zzc(this.zzd).entrySet().iterator();
    }
    return this.zzc;
  }
  
  public final boolean hasNext()
  {
    return (this.zza + 1 < zzgz.zzb(this.zzd).size()) || ((!zzgz.zzc(this.zzd).isEmpty()) && (zza().hasNext()));
  }
  
  public final void remove()
  {
    if (this.zzb)
    {
      this.zzb = false;
      zzgz.zza(this.zzd);
      if (this.zza < zzgz.zzb(this.zzd).size())
      {
        zzgz localzzgz = this.zzd;
        int i = this.zza;
        this.zza = (i - 1);
        zzgz.zza(localzzgz, i);
        return;
      }
      zza().remove();
      return;
    }
    throw new IllegalStateException("remove() was called before next()");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzhh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */