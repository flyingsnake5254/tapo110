package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.Dependency;

public final class zzco
  implements zzcq.zza
{
  public static final Component<?> zza = Component.builder(zzcq.zza.class).add(Dependency.required(zzck.class)).add(Dependency.required(zzcj.class)).factory(zzcr.zza).build();
  private final zzck zzb;
  private final zzcj zzc;
  
  public zzco(zzck paramzzck, zzcj paramzzcj)
  {
    this.zzb = paramzzck;
    this.zzc = paramzzcj;
  }
  
  public final void zza(zzr.zzad paramzzad)
  {
    this.zzc.zza((zzr.zzad)zzr.zzad.zza(paramzzad).zza(zzr.zzbg.zza(paramzzad.zza()).zza(true)).zzg());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzco.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */