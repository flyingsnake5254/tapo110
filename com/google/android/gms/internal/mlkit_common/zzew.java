package com.google.android.gms.internal.mlkit_common;

import java.lang.reflect.Type;

public enum zzew
{
  private static final zzew[] zzbe;
  private static final Type[] zzbf;
  private final zzfj zzaz;
  private final int zzba;
  private final zzey zzbb;
  private final Class<?> zzbc;
  private final boolean zzbd;
  
  static
  {
    zzey localzzey = zzey.zza;
    zzfj localzzfj1 = zzfj.zze;
    zzc = new zzew("DOUBLE", 0, 0, localzzey, localzzfj1);
    zzfj localzzfj2 = zzfj.zzd;
    zzd = new zzew("FLOAT", 1, 1, localzzey, localzzfj2);
    zzfj localzzfj3 = zzfj.zzc;
    zze = new zzew("INT64", 2, 2, localzzey, localzzfj3);
    zzf = new zzew("UINT64", 3, 3, localzzey, localzzfj3);
    zzfj localzzfj4 = zzfj.zzb;
    zzg = new zzew("INT32", 4, 4, localzzey, localzzfj4);
    zzh = new zzew("FIXED64", 5, 5, localzzey, localzzfj3);
    zzi = new zzew("FIXED32", 6, 6, localzzey, localzzfj4);
    zzfj localzzfj5 = zzfj.zzf;
    zzj = new zzew("BOOL", 7, 7, localzzey, localzzfj5);
    zzfj localzzfj6 = zzfj.zzg;
    zzk = new zzew("STRING", 8, 8, localzzey, localzzfj6);
    Object localObject1 = zzfj.zzj;
    zzl = new zzew("MESSAGE", 9, 9, localzzey, (zzfj)localObject1);
    Object localObject2 = zzfj.zzh;
    zzm = new zzew("BYTES", 10, 10, localzzey, (zzfj)localObject2);
    zzn = new zzew("UINT32", 11, 11, localzzey, localzzfj4);
    zzfj localzzfj7 = zzfj.zzi;
    zzo = new zzew("ENUM", 12, 12, localzzey, localzzfj7);
    zzp = new zzew("SFIXED32", 13, 13, localzzey, localzzfj4);
    zzq = new zzew("SFIXED64", 14, 14, localzzey, localzzfj3);
    zzr = new zzew("SINT32", 15, 15, localzzey, localzzfj4);
    zzs = new zzew("SINT64", 16, 16, localzzey, localzzfj3);
    zzt = new zzew("GROUP", 17, 17, localzzey, (zzfj)localObject1);
    localzzey = zzey.zzb;
    zzu = new zzew("DOUBLE_LIST", 18, 18, localzzey, localzzfj1);
    zzv = new zzew("FLOAT_LIST", 19, 19, localzzey, localzzfj2);
    zzw = new zzew("INT64_LIST", 20, 20, localzzey, localzzfj3);
    zzx = new zzew("UINT64_LIST", 21, 21, localzzey, localzzfj3);
    zzy = new zzew("INT32_LIST", 22, 22, localzzey, localzzfj4);
    zzz = new zzew("FIXED64_LIST", 23, 23, localzzey, localzzfj3);
    zzaa = new zzew("FIXED32_LIST", 24, 24, localzzey, localzzfj4);
    zzab = new zzew("BOOL_LIST", 25, 25, localzzey, localzzfj5);
    zzac = new zzew("STRING_LIST", 26, 26, localzzey, localzzfj6);
    zzad = new zzew("MESSAGE_LIST", 27, 27, localzzey, (zzfj)localObject1);
    zzae = new zzew("BYTES_LIST", 28, 28, localzzey, (zzfj)localObject2);
    zzaf = new zzew("UINT32_LIST", 29, 29, localzzey, localzzfj4);
    zzag = new zzew("ENUM_LIST", 30, 30, localzzey, localzzfj7);
    zzah = new zzew("SFIXED32_LIST", 31, 31, localzzey, localzzfj4);
    zzai = new zzew("SFIXED64_LIST", 32, 32, localzzey, localzzfj3);
    zzaj = new zzew("SINT32_LIST", 33, 33, localzzey, localzzfj4);
    zzak = new zzew("SINT64_LIST", 34, 34, localzzey, localzzfj3);
    localObject2 = zzey.zzc;
    zza = new zzew("DOUBLE_LIST_PACKED", 35, 35, (zzey)localObject2, localzzfj1);
    zzal = new zzew("FLOAT_LIST_PACKED", 36, 36, (zzey)localObject2, localzzfj2);
    zzam = new zzew("INT64_LIST_PACKED", 37, 37, (zzey)localObject2, localzzfj3);
    zzan = new zzew("UINT64_LIST_PACKED", 38, 38, (zzey)localObject2, localzzfj3);
    zzao = new zzew("INT32_LIST_PACKED", 39, 39, (zzey)localObject2, localzzfj4);
    zzap = new zzew("FIXED64_LIST_PACKED", 40, 40, (zzey)localObject2, localzzfj3);
    zzaq = new zzew("FIXED32_LIST_PACKED", 41, 41, (zzey)localObject2, localzzfj4);
    zzar = new zzew("BOOL_LIST_PACKED", 42, 42, (zzey)localObject2, localzzfj5);
    zzas = new zzew("UINT32_LIST_PACKED", 43, 43, (zzey)localObject2, localzzfj4);
    zzat = new zzew("ENUM_LIST_PACKED", 44, 44, (zzey)localObject2, localzzfj7);
    zzau = new zzew("SFIXED32_LIST_PACKED", 45, 45, (zzey)localObject2, localzzfj4);
    localzzfj1 = zzfj.zzc;
    zzav = new zzew("SFIXED64_LIST_PACKED", 46, 46, (zzey)localObject2, localzzfj1);
    zzaw = new zzew("SINT32_LIST_PACKED", 47, 47, (zzey)localObject2, zzfj.zzb);
    zzb = new zzew("SINT64_LIST_PACKED", 48, 48, (zzey)localObject2, localzzfj1);
    zzax = new zzew("GROUP_LIST", 49, 49, localzzey, (zzfj)localObject1);
    zzay = new zzew("MAP", 50, 50, zzey.zzd, zzfj.zza);
    localObject1 = zzc;
    int i = 0;
    zzbg = new zzew[] { localObject1, zzd, zze, zzf, zzg, zzh, zzi, zzj, zzk, zzl, zzm, zzn, zzo, zzp, zzq, zzr, zzs, zzt, zzu, zzv, zzw, zzx, zzy, zzz, zzaa, zzab, zzac, zzad, zzae, zzaf, zzag, zzah, zzai, zzaj, zzak, zza, zzal, zzam, zzan, zzao, zzap, zzaq, zzar, zzas, zzat, zzau, zzav, zzaw, zzb, zzax, zzay };
    zzbf = new Type[0];
    localObject1 = values();
    zzbe = new zzew[localObject1.length];
    int j = localObject1.length;
    while (i < j)
    {
      localzzfj1 = localObject1[i];
      zzbe[localzzfj1.zzba] = localzzfj1;
      i++;
    }
  }
  
  private zzew(int paramInt, zzey paramzzey, zzfj paramzzfj)
  {
    this.zzba = paramInt;
    this.zzbb = paramzzey;
    this.zzaz = paramzzfj;
    ??? = zzev.zza[paramzzey.ordinal()];
    boolean bool = true;
    if (??? != 1)
    {
      if (??? != 2) {
        this.zzbc = null;
      } else {
        this.zzbc = paramzzfj.zza();
      }
    }
    else {
      this.zzbc = paramzzfj.zza();
    }
    if (paramzzey == zzey.zza)
    {
      ??? = zzev.zzb[paramzzfj.ordinal()];
      if ((??? != 1) && (??? != 2) && (??? != 3)) {}
    }
    else
    {
      bool = false;
    }
    this.zzbd = bool;
  }
  
  public final int zza()
  {
    return this.zzba;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */