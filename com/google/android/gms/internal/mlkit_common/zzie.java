package com.google.android.gms.internal.mlkit_common;

public enum zzie
{
  private final zzih zzs;
  private final int zzt;
  
  static
  {
    zzie localzzie1 = new zzie("DOUBLE", 0, zzih.zzd, 1);
    zza = localzzie1;
    zzie localzzie2 = new zzie("FLOAT", 1, zzih.zzc, 5);
    zzb = localzzie2;
    Object localObject1 = zzih.zzb;
    zzie localzzie3 = new zzie("INT64", 2, (zzih)localObject1, 0);
    zzc = localzzie3;
    zzie localzzie4 = new zzie("UINT64", 3, (zzih)localObject1, 0);
    zzd = localzzie4;
    Object localObject2 = zzih.zza;
    zzie localzzie5 = new zzie("INT32", 4, (zzih)localObject2, 0);
    zze = localzzie5;
    zzie localzzie6 = new zzie("FIXED64", 5, (zzih)localObject1, 1);
    zzf = localzzie6;
    zzie localzzie7 = new zzie("FIXED32", 6, (zzih)localObject2, 5);
    zzg = localzzie7;
    zzie localzzie8 = new zzie("BOOL", 7, zzih.zze, 0);
    zzh = localzzie8;
    zzid localzzid = new zzid("STRING", 8, zzih.zzf, 2);
    zzi = localzzid;
    Object localObject3 = zzih.zzi;
    zzig localzzig = new zzig("GROUP", 9, (zzih)localObject3, 3);
    zzj = localzzig;
    localObject3 = new zzif("MESSAGE", 10, (zzih)localObject3, 2);
    zzk = (zzie)localObject3;
    zzii localzzii = new zzii("BYTES", 11, zzih.zzg, 2);
    zzl = localzzii;
    zzie localzzie9 = new zzie("UINT32", 12, (zzih)localObject2, 0);
    zzm = localzzie9;
    zzie localzzie10 = new zzie("ENUM", 13, zzih.zzh, 0);
    zzn = localzzie10;
    zzie localzzie11 = new zzie("SFIXED32", 14, (zzih)localObject2, 5);
    zzo = localzzie11;
    zzie localzzie12 = new zzie("SFIXED64", 15, (zzih)localObject1, 1);
    zzp = localzzie12;
    localObject2 = new zzie("SINT32", 16, (zzih)localObject2, 0);
    zzq = (zzie)localObject2;
    localObject1 = new zzie("SINT64", 17, (zzih)localObject1, 0);
    zzr = (zzie)localObject1;
    zzu = new zzie[] { localzzie1, localzzie2, localzzie3, localzzie4, localzzie5, localzzie6, localzzie7, localzzie8, localzzid, localzzig, localObject3, localzzii, localzzie9, localzzie10, localzzie11, localzzie12, localObject2, localObject1 };
  }
  
  private zzie(zzih paramzzih, int paramInt)
  {
    this.zzs = paramzzih;
    this.zzt = paramInt;
  }
  
  public final zzih zza()
  {
    return this.zzs;
  }
  
  public final int zzb()
  {
    return this.zzt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */