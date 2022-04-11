package com.google.android.gms.internal.measurement;

import java.io.IOException;

final class zzlm<T>
  implements zzlt<T>
{
  private final zzli zza;
  private final zzmh<?, ?> zzb;
  private final boolean zzc;
  private final zzjq<?> zzd;
  
  private zzlm(zzmh<?, ?> paramzzmh, zzjq<?> paramzzjq, zzli paramzzli)
  {
    this.zzb = paramzzmh;
    this.zzc = paramzzjq.zza(paramzzli);
    this.zzd = paramzzjq;
    this.zza = paramzzli;
  }
  
  static <T> zzlm<T> zzf(zzmh<?, ?> paramzzmh, zzjq<?> paramzzjq, zzli paramzzli)
  {
    return new zzlm(paramzzmh, paramzzjq, paramzzli);
  }
  
  public final T zza()
  {
    return this.zza.zzbH().zzaD();
  }
  
  public final boolean zzb(T paramT1, T paramT2)
  {
    if (!this.zzb.zzd(paramT1).equals(this.zzb.zzd(paramT2))) {
      return false;
    }
    if (!this.zzc) {
      return true;
    }
    this.zzd.zzb(paramT1);
    this.zzd.zzb(paramT2);
    throw null;
  }
  
  public final int zzc(T paramT)
  {
    int i = this.zzb.zzd(paramT).hashCode();
    if (!this.zzc) {
      return i;
    }
    this.zzd.zzb(paramT);
    throw null;
  }
  
  public final void zzd(T paramT1, T paramT2)
  {
    zzlv.zzF(this.zzb, paramT1, paramT2);
    if (this.zzc) {
      zzlv.zzE(this.zzd, paramT1, paramT2);
    }
  }
  
  public final int zze(T paramT)
  {
    zzmh localzzmh = this.zzb;
    int i = localzzmh.zzg(localzzmh.zzd(paramT));
    if (!this.zzc) {
      return i;
    }
    this.zzd.zzb(paramT);
    throw null;
  }
  
  public final void zzh(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzir paramzzir)
    throws IOException
  {
    paramArrayOfByte = (zzkd)paramT;
    if (paramArrayOfByte.zzc == zzmi.zza()) {
      paramArrayOfByte.zzc = zzmi.zzb();
    }
    paramT = (zzka)paramT;
    throw null;
  }
  
  public final void zzi(T paramT)
  {
    this.zzb.zze(paramT);
    this.zzd.zzc(paramT);
  }
  
  public final boolean zzj(T paramT)
  {
    this.zzd.zzb(paramT);
    throw null;
  }
  
  public final void zzm(T paramT, zzjl paramzzjl)
    throws IOException
  {
    this.zzd.zzb(paramT);
    throw null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzlm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */