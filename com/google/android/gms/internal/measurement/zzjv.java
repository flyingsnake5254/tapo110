package com.google.android.gms.internal.measurement;

public enum zzjv
{
  private static final zzjv[] zzac;
  private final zzko zzZ;
  private final int zzaa;
  private final Class<?> zzab;
  
  static
  {
    zzko localzzko1 = zzko.zze;
    zza = new zzjv("DOUBLE", 0, 0, 1, localzzko1);
    zzko localzzko2 = zzko.zzd;
    zzb = new zzjv("FLOAT", 1, 1, 1, localzzko2);
    zzko localzzko3 = zzko.zzc;
    zzc = new zzjv("INT64", 2, 2, 1, localzzko3);
    zzd = new zzjv("UINT64", 3, 3, 1, localzzko3);
    Object localObject1 = zzko.zzb;
    zze = new zzjv("INT32", 4, 4, 1, (zzko)localObject1);
    zzf = new zzjv("FIXED64", 5, 5, 1, localzzko3);
    zzg = new zzjv("FIXED32", 6, 6, 1, (zzko)localObject1);
    zzko localzzko4 = zzko.zzf;
    zzh = new zzjv("BOOL", 7, 7, 1, localzzko4);
    zzko localzzko5 = zzko.zzg;
    zzi = new zzjv("STRING", 8, 8, 1, localzzko5);
    Object localObject2 = zzko.zzj;
    zzj = new zzjv("MESSAGE", 9, 9, 1, (zzko)localObject2);
    zzko localzzko6 = zzko.zzh;
    zzk = new zzjv("BYTES", 10, 10, 1, localzzko6);
    zzl = new zzjv("UINT32", 11, 11, 1, (zzko)localObject1);
    zzko localzzko7 = zzko.zzi;
    zzm = new zzjv("ENUM", 12, 12, 1, localzzko7);
    zzn = new zzjv("SFIXED32", 13, 13, 1, (zzko)localObject1);
    zzo = new zzjv("SFIXED64", 14, 14, 1, localzzko3);
    zzp = new zzjv("SINT32", 15, 15, 1, (zzko)localObject1);
    zzq = new zzjv("SINT64", 16, 16, 1, localzzko3);
    zzr = new zzjv("GROUP", 17, 17, 1, (zzko)localObject2);
    zzs = new zzjv("DOUBLE_LIST", 18, 18, 2, localzzko1);
    zzt = new zzjv("FLOAT_LIST", 19, 19, 2, localzzko2);
    zzu = new zzjv("INT64_LIST", 20, 20, 2, localzzko3);
    zzv = new zzjv("UINT64_LIST", 21, 21, 2, localzzko3);
    zzw = new zzjv("INT32_LIST", 22, 22, 2, (zzko)localObject1);
    zzx = new zzjv("FIXED64_LIST", 23, 23, 2, localzzko3);
    zzy = new zzjv("FIXED32_LIST", 24, 24, 2, (zzko)localObject1);
    zzz = new zzjv("BOOL_LIST", 25, 25, 2, localzzko4);
    zzA = new zzjv("STRING_LIST", 26, 26, 2, localzzko5);
    zzB = new zzjv("MESSAGE_LIST", 27, 27, 2, (zzko)localObject2);
    zzC = new zzjv("BYTES_LIST", 28, 28, 2, localzzko6);
    zzD = new zzjv("UINT32_LIST", 29, 29, 2, (zzko)localObject1);
    zzE = new zzjv("ENUM_LIST", 30, 30, 2, localzzko7);
    zzF = new zzjv("SFIXED32_LIST", 31, 31, 2, (zzko)localObject1);
    zzG = new zzjv("SFIXED64_LIST", 32, 32, 2, localzzko3);
    zzH = new zzjv("SINT32_LIST", 33, 33, 2, (zzko)localObject1);
    zzI = new zzjv("SINT64_LIST", 34, 34, 2, localzzko3);
    zzJ = new zzjv("DOUBLE_LIST_PACKED", 35, 35, 3, localzzko1);
    zzK = new zzjv("FLOAT_LIST_PACKED", 36, 36, 3, localzzko2);
    zzL = new zzjv("INT64_LIST_PACKED", 37, 37, 3, localzzko3);
    zzM = new zzjv("UINT64_LIST_PACKED", 38, 38, 3, localzzko3);
    zzN = new zzjv("INT32_LIST_PACKED", 39, 39, 3, (zzko)localObject1);
    zzO = new zzjv("FIXED64_LIST_PACKED", 40, 40, 3, localzzko3);
    zzP = new zzjv("FIXED32_LIST_PACKED", 41, 41, 3, (zzko)localObject1);
    zzQ = new zzjv("BOOL_LIST_PACKED", 42, 42, 3, localzzko4);
    zzR = new zzjv("UINT32_LIST_PACKED", 43, 43, 3, (zzko)localObject1);
    zzS = new zzjv("ENUM_LIST_PACKED", 44, 44, 3, localzzko7);
    zzT = new zzjv("SFIXED32_LIST_PACKED", 45, 45, 3, (zzko)localObject1);
    localzzko6 = zzko.zzc;
    zzU = new zzjv("SFIXED64_LIST_PACKED", 46, 46, 3, localzzko6);
    zzV = new zzjv("SINT32_LIST_PACKED", 47, 47, 3, (zzko)localObject1);
    zzW = new zzjv("SINT64_LIST_PACKED", 48, 48, 3, localzzko6);
    zzX = new zzjv("GROUP_LIST", 49, 49, 2, (zzko)localObject2);
    zzY = new zzjv("MAP", 50, 50, 4, zzko.zza);
    localObject2 = zza;
    int i = 0;
    zzad = new zzjv[] { localObject2, zzb, zzc, zzd, zze, zzf, zzg, zzh, zzi, zzj, zzk, zzl, zzm, zzn, zzo, zzp, zzq, zzr, zzs, zzt, zzu, zzv, zzw, zzx, zzy, zzz, zzA, zzB, zzC, zzD, zzE, zzF, zzG, zzH, zzI, zzJ, zzK, zzL, zzM, zzN, zzO, zzP, zzQ, zzR, zzS, zzT, zzU, zzV, zzW, zzX, zzY };
    localObject1 = values();
    int j = localObject1.length;
    zzac = new zzjv[j];
    while (i < j)
    {
      localObject2 = localObject1[i];
      zzac[localObject2.zzaa] = localObject2;
      i++;
    }
  }
  
  private zzjv(int paramInt1, int paramInt2, zzko paramzzko)
  {
    this.zzaa = paramInt1;
    this.zzZ = paramzzko;
    ??? = zzko.zza;
    ??? = paramInt2 - 1;
    if (??? != 1)
    {
      if (??? != 3) {
        this.zzab = null;
      } else {
        this.zzab = paramzzko.zza();
      }
    }
    else {
      this.zzab = paramzzko.zza();
    }
    if (paramInt2 == 1) {
      paramzzko.ordinal();
    }
  }
  
  public final int zza()
  {
    return this.zzaa;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzjv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */