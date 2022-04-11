package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzaj
  extends zzu<K, V>
{
  @NullableDecl
  private final K zza = paramzzaa.zzb[paramInt];
  private int zzb;
  
  zzaj(zzaa paramzzaa, int paramInt)
  {
    this.zzb = paramInt;
  }
  
  private final void zza()
  {
    int i = this.zzb;
    if ((i == -1) || (i >= this.zzc.size()) || (!zze.zza(this.zza, this.zzc.zzb[this.zzb]))) {
      this.zzb = zzaa.zzb(this.zzc, this.zza);
    }
  }
  
  @NullableDecl
  public final K getKey()
  {
    return (K)this.zza;
  }
  
  @NullableDecl
  public final V getValue()
  {
    Map localMap = this.zzc.zzb();
    if (localMap != null) {
      return (V)localMap.get(this.zza);
    }
    zza();
    int i = this.zzb;
    if (i == -1) {
      return null;
    }
    return (V)this.zzc.zzc[i];
  }
  
  public final V setValue(V paramV)
  {
    Object localObject = this.zzc.zzb();
    if (localObject != null) {
      return (V)((Map)localObject).put(this.zza, paramV);
    }
    zza();
    int i = this.zzb;
    if (i == -1)
    {
      this.zzc.put(this.zza, paramV);
      return null;
    }
    localObject = this.zzc.zzc;
    V ? = localObject[i];
    localObject[i] = paramV;
    return ?;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */