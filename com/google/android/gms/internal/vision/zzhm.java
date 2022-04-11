package com.google.android.gms.internal.vision;

public class zzhm
{
  private static final zzgi zzsa = ;
  private zzfm zzym;
  private volatile zzih zzyn;
  private volatile zzfm zzyo;
  
  private final zzih zzh(zzih paramzzih)
  {
    if (this.zzyn == null) {
      try
      {
        if (this.zzyn != null) {
          break label59;
        }
        try
        {
          this.zzyn = paramzzih;
          this.zzyo = zzfm.zzsm;
        }
        catch (zzhh localzzhh)
        {
          this.zzyn = paramzzih;
          this.zzyo = zzfm.zzsm;
        }
      }
      finally {}
    }
    label59:
    return this.zzyn;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzhm)) {
      return false;
    }
    zzhm localzzhm = (zzhm)paramObject;
    zzih localzzih = this.zzyn;
    paramObject = localzzhm.zzyn;
    if ((localzzih == null) && (paramObject == null)) {
      return zzdl().equals(localzzhm.zzdl());
    }
    if ((localzzih != null) && (paramObject != null)) {
      return localzzih.equals(paramObject);
    }
    if (localzzih != null) {
      return localzzih.equals(localzzhm.zzh(localzzih.zzge()));
    }
    return zzh(((zzij)paramObject).zzge()).equals(paramObject);
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public final zzfm zzdl()
  {
    if (this.zzyo != null) {
      return this.zzyo;
    }
    try
    {
      if (this.zzyo != null)
      {
        localzzfm = this.zzyo;
        return localzzfm;
      }
      if (this.zzyn == null) {
        this.zzyo = zzfm.zzsm;
      } else {
        this.zzyo = this.zzyn.zzdl();
      }
      zzfm localzzfm = this.zzyo;
      return localzzfm;
    }
    finally {}
  }
  
  public final int zzgg()
  {
    if (this.zzyo != null) {
      return this.zzyo.size();
    }
    if (this.zzyn != null) {
      return this.zzyn.zzgg();
    }
    return 0;
  }
  
  public final zzih zzi(zzih paramzzih)
  {
    zzih localzzih = this.zzyn;
    this.zzym = null;
    this.zzyo = null;
    this.zzyn = paramzzih;
    return localzzih;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzhm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */