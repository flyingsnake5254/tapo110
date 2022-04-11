package com.google.android.gms.internal.mlkit_vision_barcode;

import java.lang.reflect.Type;

public enum zzfx
{
  private static final zzfx[] zzbe;
  private static final Type[] zzbf;
  private final zzgm zzaz;
  private final int zzba;
  private final zzfz zzbb;
  private final Class<?> zzbc;
  private final boolean zzbd;
  
  static
  {
    zzfz localzzfz = zzfz.zza;
    zzgm localzzgm1 = zzgm.zze;
    zzc = new zzfx("DOUBLE", 0, 0, localzzfz, localzzgm1);
    zzgm localzzgm2 = zzgm.zzd;
    zzd = new zzfx("FLOAT", 1, 1, localzzfz, localzzgm2);
    zzgm localzzgm3 = zzgm.zzc;
    zze = new zzfx("INT64", 2, 2, localzzfz, localzzgm3);
    zzf = new zzfx("UINT64", 3, 3, localzzfz, localzzgm3);
    zzgm localzzgm4 = zzgm.zzb;
    zzg = new zzfx("INT32", 4, 4, localzzfz, localzzgm4);
    zzh = new zzfx("FIXED64", 5, 5, localzzfz, localzzgm3);
    zzi = new zzfx("FIXED32", 6, 6, localzzfz, localzzgm4);
    zzgm localzzgm5 = zzgm.zzf;
    zzj = new zzfx("BOOL", 7, 7, localzzfz, localzzgm5);
    Object localObject1 = zzgm.zzg;
    zzk = new zzfx("STRING", 8, 8, localzzfz, (zzgm)localObject1);
    Object localObject2 = zzgm.zzj;
    zzl = new zzfx("MESSAGE", 9, 9, localzzfz, (zzgm)localObject2);
    zzgm localzzgm6 = zzgm.zzh;
    zzm = new zzfx("BYTES", 10, 10, localzzfz, localzzgm6);
    zzn = new zzfx("UINT32", 11, 11, localzzfz, localzzgm4);
    zzgm localzzgm7 = zzgm.zzi;
    zzo = new zzfx("ENUM", 12, 12, localzzfz, localzzgm7);
    zzp = new zzfx("SFIXED32", 13, 13, localzzfz, localzzgm4);
    zzq = new zzfx("SFIXED64", 14, 14, localzzfz, localzzgm3);
    zzr = new zzfx("SINT32", 15, 15, localzzfz, localzzgm4);
    zzs = new zzfx("SINT64", 16, 16, localzzfz, localzzgm3);
    zzt = new zzfx("GROUP", 17, 17, localzzfz, (zzgm)localObject2);
    localzzfz = zzfz.zzb;
    zzu = new zzfx("DOUBLE_LIST", 18, 18, localzzfz, localzzgm1);
    zzv = new zzfx("FLOAT_LIST", 19, 19, localzzfz, localzzgm2);
    zzw = new zzfx("INT64_LIST", 20, 20, localzzfz, localzzgm3);
    zzx = new zzfx("UINT64_LIST", 21, 21, localzzfz, localzzgm3);
    zzy = new zzfx("INT32_LIST", 22, 22, localzzfz, localzzgm4);
    zzz = new zzfx("FIXED64_LIST", 23, 23, localzzfz, localzzgm3);
    zzaa = new zzfx("FIXED32_LIST", 24, 24, localzzfz, localzzgm4);
    zzab = new zzfx("BOOL_LIST", 25, 25, localzzfz, localzzgm5);
    zzac = new zzfx("STRING_LIST", 26, 26, localzzfz, (zzgm)localObject1);
    zzad = new zzfx("MESSAGE_LIST", 27, 27, localzzfz, (zzgm)localObject2);
    zzae = new zzfx("BYTES_LIST", 28, 28, localzzfz, localzzgm6);
    zzaf = new zzfx("UINT32_LIST", 29, 29, localzzfz, localzzgm4);
    zzag = new zzfx("ENUM_LIST", 30, 30, localzzfz, localzzgm7);
    zzah = new zzfx("SFIXED32_LIST", 31, 31, localzzfz, localzzgm4);
    zzai = new zzfx("SFIXED64_LIST", 32, 32, localzzfz, localzzgm3);
    zzaj = new zzfx("SINT32_LIST", 33, 33, localzzfz, localzzgm4);
    zzak = new zzfx("SINT64_LIST", 34, 34, localzzfz, localzzgm3);
    localObject1 = zzfz.zzc;
    zza = new zzfx("DOUBLE_LIST_PACKED", 35, 35, (zzfz)localObject1, localzzgm1);
    zzal = new zzfx("FLOAT_LIST_PACKED", 36, 36, (zzfz)localObject1, localzzgm2);
    zzam = new zzfx("INT64_LIST_PACKED", 37, 37, (zzfz)localObject1, localzzgm3);
    zzan = new zzfx("UINT64_LIST_PACKED", 38, 38, (zzfz)localObject1, localzzgm3);
    zzao = new zzfx("INT32_LIST_PACKED", 39, 39, (zzfz)localObject1, localzzgm4);
    zzap = new zzfx("FIXED64_LIST_PACKED", 40, 40, (zzfz)localObject1, localzzgm3);
    zzaq = new zzfx("FIXED32_LIST_PACKED", 41, 41, (zzfz)localObject1, localzzgm4);
    zzar = new zzfx("BOOL_LIST_PACKED", 42, 42, (zzfz)localObject1, localzzgm5);
    zzas = new zzfx("UINT32_LIST_PACKED", 43, 43, (zzfz)localObject1, localzzgm4);
    zzat = new zzfx("ENUM_LIST_PACKED", 44, 44, (zzfz)localObject1, localzzgm7);
    zzau = new zzfx("SFIXED32_LIST_PACKED", 45, 45, (zzfz)localObject1, localzzgm4);
    localzzgm1 = zzgm.zzc;
    zzav = new zzfx("SFIXED64_LIST_PACKED", 46, 46, (zzfz)localObject1, localzzgm1);
    zzaw = new zzfx("SINT32_LIST_PACKED", 47, 47, (zzfz)localObject1, zzgm.zzb);
    zzb = new zzfx("SINT64_LIST_PACKED", 48, 48, (zzfz)localObject1, localzzgm1);
    zzax = new zzfx("GROUP_LIST", 49, 49, localzzfz, (zzgm)localObject2);
    zzay = new zzfx("MAP", 50, 50, zzfz.zzd, zzgm.zza);
    localObject2 = zzc;
    int i = 0;
    zzbg = new zzfx[] { localObject2, zzd, zze, zzf, zzg, zzh, zzi, zzj, zzk, zzl, zzm, zzn, zzo, zzp, zzq, zzr, zzs, zzt, zzu, zzv, zzw, zzx, zzy, zzz, zzaa, zzab, zzac, zzad, zzae, zzaf, zzag, zzah, zzai, zzaj, zzak, zza, zzal, zzam, zzan, zzao, zzap, zzaq, zzar, zzas, zzat, zzau, zzav, zzaw, zzb, zzax, zzay };
    zzbf = new Type[0];
    localObject2 = values();
    zzbe = new zzfx[localObject2.length];
    int j = localObject2.length;
    while (i < j)
    {
      localzzgm1 = localObject2[i];
      zzbe[localzzgm1.zzba] = localzzgm1;
      i++;
    }
  }
  
  private zzfx(int paramInt, zzfz paramzzfz, zzgm paramzzgm)
  {
    this.zzba = paramInt;
    this.zzbb = paramzzfz;
    this.zzaz = paramzzgm;
    ??? = zzfw.zza[paramzzfz.ordinal()];
    boolean bool = true;
    if (??? != 1)
    {
      if (??? != 2) {
        this.zzbc = null;
      } else {
        this.zzbc = paramzzgm.zza();
      }
    }
    else {
      this.zzbc = paramzzgm.zza();
    }
    if (paramzzfz == zzfz.zza)
    {
      ??? = zzfw.zzb[paramzzgm.ordinal()];
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzfx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */