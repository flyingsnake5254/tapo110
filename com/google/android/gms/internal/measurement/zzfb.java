package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

public final class zzfb
  extends zzjz<zzfc, zzfb>
  implements zzlj
{
  private zzfb()
  {
    super(zzfc.zzo());
  }
  
  public final int zza()
  {
    return ((zzfc)this.zza).zzf();
  }
  
  public final zzfa zzb(int paramInt)
  {
    return ((zzfc)this.zza).zzg(paramInt);
  }
  
  public final zzfb zzc(int paramInt, zzez paramzzez)
  {
    if (this.zzb)
    {
      zzax();
      this.zzb = false;
    }
    zzfc.zzp((zzfc)this.zza, paramInt, (zzfa)paramzzez.zzaA());
    return this;
  }
  
  public final List<zzeh> zzd()
  {
    return Collections.unmodifiableList(((zzfc)this.zza).zzh());
  }
  
  public final zzfb zze()
  {
    if (this.zzb)
    {
      zzax();
      this.zzb = false;
    }
    zzfc.zzq((zzfc)this.zza);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzfb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */