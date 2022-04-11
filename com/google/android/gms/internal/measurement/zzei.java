package com.google.android.gms.internal.measurement;

public final class zzei
  extends zzjz<zzej, zzei>
  implements zzlj
{
  private zzei()
  {
    super(zzej.zzo());
  }
  
  public final String zza()
  {
    return ((zzej)this.zza).zzc();
  }
  
  public final zzei zzb(String paramString)
  {
    if (this.zzb)
    {
      zzax();
      this.zzb = false;
    }
    zzej.zzp((zzej)this.zza, paramString);
    return this;
  }
  
  public final int zzc()
  {
    return ((zzej)this.zza).zze();
  }
  
  public final zzel zzd(int paramInt)
  {
    return ((zzej)this.zza).zzf(paramInt);
  }
  
  public final zzei zze(int paramInt, zzel paramzzel)
  {
    if (this.zzb)
    {
      zzax();
      this.zzb = false;
    }
    zzej.zzq((zzej)this.zza, paramInt, paramzzel);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */