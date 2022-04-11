package com.google.android.gms.internal.vision;

import android.content.Context;
import android.net.Uri;
import javax.annotation.Nullable;

public final class zzbp
{
  final String zzgu;
  final Uri zzgv;
  final String zzgw;
  final String zzgx;
  final boolean zzgy;
  final boolean zzgz;
  final boolean zzha;
  final boolean zzhb;
  @Nullable
  final zzcq<Context, Boolean> zzhc;
  
  public zzbp(Uri paramUri)
  {
    this(null, paramUri, "", "", false, false, false, false, null);
  }
  
  private zzbp(String paramString1, Uri paramUri, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, @Nullable zzcq<Context, Boolean> paramzzcq)
  {
    this.zzgu = paramString1;
    this.zzgv = paramUri;
    this.zzgw = paramString2;
    this.zzgx = paramString3;
    this.zzgy = paramBoolean1;
    this.zzgz = paramBoolean2;
    this.zzha = paramBoolean3;
    this.zzhb = paramBoolean4;
    this.zzhc = paramzzcq;
  }
  
  public final zzbj<Long> zza(String paramString, long paramLong)
  {
    return zzbj.zzb(this, paramString, paramLong, true);
  }
  
  public final <T> zzbj<T> zza(String paramString, T paramT, zzbm<T> paramzzbm)
  {
    return zzbj.zzb(this, paramString, paramT, paramzzbm, true);
  }
  
  public final zzbj<Boolean> zza(String paramString, boolean paramBoolean)
  {
    return zzbj.zzb(this, paramString, paramBoolean, true);
  }
  
  public final zzbp zzf(String paramString)
  {
    boolean bool = this.zzgy;
    if (!bool) {
      return new zzbp(this.zzgu, this.zzgv, paramString, this.zzgx, bool, this.zzgz, this.zzha, this.zzhb, this.zzhc);
    }
    throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzbp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */