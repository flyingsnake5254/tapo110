package com.google.android.gms.internal.mlkit_vision_barcode;

public enum zzjh
{
  private final zzjk zzs;
  private final int zzt;
  
  static
  {
    zzjh localzzjh1 = new zzjh("DOUBLE", 0, zzjk.zzd, 1);
    zza = localzzjh1;
    zzjh localzzjh2 = new zzjh("FLOAT", 1, zzjk.zzc, 5);
    zzb = localzzjh2;
    Object localObject1 = zzjk.zzb;
    zzjh localzzjh3 = new zzjh("INT64", 2, (zzjk)localObject1, 0);
    zzc = localzzjh3;
    zzjh localzzjh4 = new zzjh("UINT64", 3, (zzjk)localObject1, 0);
    zzd = localzzjh4;
    Object localObject2 = zzjk.zza;
    zzjh localzzjh5 = new zzjh("INT32", 4, (zzjk)localObject2, 0);
    zze = localzzjh5;
    zzjh localzzjh6 = new zzjh("FIXED64", 5, (zzjk)localObject1, 1);
    zzf = localzzjh6;
    zzjh localzzjh7 = new zzjh("FIXED32", 6, (zzjk)localObject2, 5);
    zzg = localzzjh7;
    zzjh localzzjh8 = new zzjh("BOOL", 7, zzjk.zze, 0);
    zzh = localzzjh8;
    zzjg localzzjg = new zzjg("STRING", 8, zzjk.zzf, 2);
    zzi = localzzjg;
    Object localObject3 = zzjk.zzi;
    zzjj localzzjj = new zzjj("GROUP", 9, (zzjk)localObject3, 3);
    zzj = localzzjj;
    zzji localzzji = new zzji("MESSAGE", 10, (zzjk)localObject3, 2);
    zzk = localzzji;
    zzjl localzzjl = new zzjl("BYTES", 11, zzjk.zzg, 2);
    zzl = localzzjl;
    zzjh localzzjh9 = new zzjh("UINT32", 12, (zzjk)localObject2, 0);
    zzm = localzzjh9;
    zzjh localzzjh10 = new zzjh("ENUM", 13, zzjk.zzh, 0);
    zzn = localzzjh10;
    localObject3 = new zzjh("SFIXED32", 14, (zzjk)localObject2, 5);
    zzo = (zzjh)localObject3;
    zzjh localzzjh11 = new zzjh("SFIXED64", 15, (zzjk)localObject1, 1);
    zzp = localzzjh11;
    localObject2 = new zzjh("SINT32", 16, (zzjk)localObject2, 0);
    zzq = (zzjh)localObject2;
    localObject1 = new zzjh("SINT64", 17, (zzjk)localObject1, 0);
    zzr = (zzjh)localObject1;
    zzu = new zzjh[] { localzzjh1, localzzjh2, localzzjh3, localzzjh4, localzzjh5, localzzjh6, localzzjh7, localzzjh8, localzzjg, localzzjj, localzzji, localzzjl, localzzjh9, localzzjh10, localObject3, localzzjh11, localObject2, localObject1 };
  }
  
  private zzjh(zzjk paramzzjk, int paramInt)
  {
    this.zzs = paramzzjk;
    this.zzt = paramInt;
  }
  
  public final zzjk zza()
  {
    return this.zzs;
  }
  
  public final int zzb()
  {
    return this.zzt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzjh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */