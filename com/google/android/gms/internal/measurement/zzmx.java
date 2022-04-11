package com.google.android.gms.internal.measurement;

public enum zzmx
{
  private final zzmy zzs;
  
  static
  {
    zzmx localzzmx1 = new zzmx("DOUBLE", 0, zzmy.zzd, 1);
    zza = localzzmx1;
    zzmx localzzmx2 = new zzmx("FLOAT", 1, zzmy.zzc, 5);
    zzb = localzzmx2;
    Object localObject1 = zzmy.zzb;
    zzmx localzzmx3 = new zzmx("INT64", 2, (zzmy)localObject1, 0);
    zzc = localzzmx3;
    zzmx localzzmx4 = new zzmx("UINT64", 3, (zzmy)localObject1, 0);
    zzd = localzzmx4;
    Object localObject2 = zzmy.zza;
    zzmx localzzmx5 = new zzmx("INT32", 4, (zzmy)localObject2, 0);
    zze = localzzmx5;
    zzmx localzzmx6 = new zzmx("FIXED64", 5, (zzmy)localObject1, 1);
    zzf = localzzmx6;
    zzmx localzzmx7 = new zzmx("FIXED32", 6, (zzmy)localObject2, 5);
    zzg = localzzmx7;
    zzmx localzzmx8 = new zzmx("BOOL", 7, zzmy.zze, 0);
    zzh = localzzmx8;
    zzmx localzzmx9 = new zzmx("STRING", 8, zzmy.zzf, 2);
    zzi = localzzmx9;
    Object localObject3 = zzmy.zzi;
    zzmx localzzmx10 = new zzmx("GROUP", 9, (zzmy)localObject3, 3);
    zzj = localzzmx10;
    zzmx localzzmx11 = new zzmx("MESSAGE", 10, (zzmy)localObject3, 2);
    zzk = localzzmx11;
    zzmx localzzmx12 = new zzmx("BYTES", 11, zzmy.zzg, 2);
    zzl = localzzmx12;
    zzmx localzzmx13 = new zzmx("UINT32", 12, (zzmy)localObject2, 0);
    zzm = localzzmx13;
    zzmx localzzmx14 = new zzmx("ENUM", 13, zzmy.zzh, 0);
    zzn = localzzmx14;
    zzmx localzzmx15 = new zzmx("SFIXED32", 14, (zzmy)localObject2, 5);
    zzo = localzzmx15;
    localObject3 = new zzmx("SFIXED64", 15, (zzmy)localObject1, 1);
    zzp = (zzmx)localObject3;
    localObject2 = new zzmx("SINT32", 16, (zzmy)localObject2, 0);
    zzq = (zzmx)localObject2;
    localObject1 = new zzmx("SINT64", 17, (zzmy)localObject1, 0);
    zzr = (zzmx)localObject1;
    zzt = new zzmx[] { localzzmx1, localzzmx2, localzzmx3, localzzmx4, localzzmx5, localzzmx6, localzzmx7, localzzmx8, localzzmx9, localzzmx10, localzzmx11, localzzmx12, localzzmx13, localzzmx14, localzzmx15, localObject3, localObject2, localObject1 };
  }
  
  private zzmx(zzmy paramzzmy, int paramInt)
  {
    this.zzs = paramzzmy;
  }
  
  public final zzmy zza()
  {
    return this.zzs;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzmx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */