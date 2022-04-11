package com.google.android.gms.internal.mlkit_vision_common;

public enum zzho
{
  private final zzhv zzs;
  private final int zzt;
  
  static
  {
    zzho localzzho1 = new zzho("DOUBLE", 0, zzhv.zzd, 1);
    zza = localzzho1;
    zzho localzzho2 = new zzho("FLOAT", 1, zzhv.zzc, 5);
    zzb = localzzho2;
    Object localObject1 = zzhv.zzb;
    zzho localzzho3 = new zzho("INT64", 2, (zzhv)localObject1, 0);
    zzc = localzzho3;
    zzho localzzho4 = new zzho("UINT64", 3, (zzhv)localObject1, 0);
    zzd = localzzho4;
    Object localObject2 = zzhv.zza;
    zzho localzzho5 = new zzho("INT32", 4, (zzhv)localObject2, 0);
    zze = localzzho5;
    zzho localzzho6 = new zzho("FIXED64", 5, (zzhv)localObject1, 1);
    zzf = localzzho6;
    zzho localzzho7 = new zzho("FIXED32", 6, (zzhv)localObject2, 5);
    zzg = localzzho7;
    zzho localzzho8 = new zzho("BOOL", 7, zzhv.zze, 0);
    zzh = localzzho8;
    zzhr localzzhr = new zzhr("STRING", 8, zzhv.zzf, 2);
    zzi = localzzhr;
    Object localObject3 = zzhv.zzi;
    zzhq localzzhq = new zzhq("GROUP", 9, (zzhv)localObject3, 3);
    zzj = localzzhq;
    localObject3 = new zzht("MESSAGE", 10, (zzhv)localObject3, 2);
    zzk = (zzho)localObject3;
    zzhs localzzhs = new zzhs("BYTES", 11, zzhv.zzg, 2);
    zzl = localzzhs;
    zzho localzzho9 = new zzho("UINT32", 12, (zzhv)localObject2, 0);
    zzm = localzzho9;
    zzho localzzho10 = new zzho("ENUM", 13, zzhv.zzh, 0);
    zzn = localzzho10;
    zzho localzzho11 = new zzho("SFIXED32", 14, (zzhv)localObject2, 5);
    zzo = localzzho11;
    zzho localzzho12 = new zzho("SFIXED64", 15, (zzhv)localObject1, 1);
    zzp = localzzho12;
    localObject2 = new zzho("SINT32", 16, (zzhv)localObject2, 0);
    zzq = (zzho)localObject2;
    localObject1 = new zzho("SINT64", 17, (zzhv)localObject1, 0);
    zzr = (zzho)localObject1;
    zzu = new zzho[] { localzzho1, localzzho2, localzzho3, localzzho4, localzzho5, localzzho6, localzzho7, localzzho8, localzzhr, localzzhq, localObject3, localzzhs, localzzho9, localzzho10, localzzho11, localzzho12, localObject2, localObject1 };
  }
  
  private zzho(zzhv paramzzhv, int paramInt)
  {
    this.zzs = paramzzhv;
    this.zzt = paramInt;
  }
  
  public final zzhv zza()
  {
    return this.zzs;
  }
  
  public final int zzb()
  {
    return this.zzt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */