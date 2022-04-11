package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzmb
  implements Iterator<Map.Entry>
{
  private int zzb;
  private boolean zzc;
  private Iterator<Map.Entry> zzd;
  
  private final Iterator<Map.Entry> zza()
  {
    if (this.zzd == null) {
      this.zzd = zzmd.zzi(this.zza).entrySet().iterator();
    }
    return this.zzd;
  }
  
  public final boolean hasNext()
  {
    int i = this.zzb;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (i + 1 >= zzmd.zzh(this.zza).size()) {
      if (!zzmd.zzi(this.zza).isEmpty())
      {
        if (zza().hasNext()) {
          bool2 = bool1;
        } else {
          return false;
        }
      }
      else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  public final void remove()
  {
    if (this.zzc)
    {
      this.zzc = false;
      zzmd.zzg(this.zza);
      if (this.zzb < zzmd.zzh(this.zza).size())
      {
        zzmd localzzmd = this.zza;
        int i = this.zzb;
        this.zzb = (i - 1);
        zzmd.zzj(localzzmd, i);
        return;
      }
      zza().remove();
      return;
    }
    throw new IllegalStateException("remove() was called before next()");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzmb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */