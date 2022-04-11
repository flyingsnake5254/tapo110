package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.Dependency;

public final class zzcz
  implements zzdb.zza
{
  public static final Component<?> zza = Component.builder(zzdb.zza.class).add(Dependency.required(zzcv.class)).add(Dependency.required(zzct.class)).factory(zzcy.zza).build();
  private final zzcv zzb;
  private final zzct zzc;
  
  public zzcz(zzcv paramzzcv, zzct paramzzct)
  {
    this.zzb = paramzzcv;
    this.zzc = paramzzct;
  }
  
  public final void zza(zzaa.zzad paramzzad)
  {
    this.zzc.zza((zzaa.zzad)zzaa.zzad.zza(paramzzad).zza(zzaa.zzbg.zza(paramzzad.zza()).zza(true)).zzh());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzcz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */