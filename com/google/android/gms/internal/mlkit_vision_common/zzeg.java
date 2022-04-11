package com.google.android.gms.internal.mlkit_vision_common;

import java.lang.reflect.Type;

public enum zzeg
{
  private static final zzeg[] zzbe;
  private static final Type[] zzbf;
  private final zzex zzaz;
  private final int zzba;
  private final zzei zzbb;
  private final Class<?> zzbc;
  private final boolean zzbd;
  
  static
  {
    zzei localzzei = zzei.zza;
    zzex localzzex1 = zzex.zze;
    zzc = new zzeg("DOUBLE", 0, 0, localzzei, localzzex1);
    zzex localzzex2 = zzex.zzd;
    zzd = new zzeg("FLOAT", 1, 1, localzzei, localzzex2);
    Object localObject1 = zzex.zzc;
    zze = new zzeg("INT64", 2, 2, localzzei, (zzex)localObject1);
    zzf = new zzeg("UINT64", 3, 3, localzzei, (zzex)localObject1);
    zzex localzzex3 = zzex.zzb;
    zzg = new zzeg("INT32", 4, 4, localzzei, localzzex3);
    zzh = new zzeg("FIXED64", 5, 5, localzzei, (zzex)localObject1);
    zzi = new zzeg("FIXED32", 6, 6, localzzei, localzzex3);
    zzex localzzex4 = zzex.zzf;
    zzj = new zzeg("BOOL", 7, 7, localzzei, localzzex4);
    zzex localzzex5 = zzex.zzg;
    zzk = new zzeg("STRING", 8, 8, localzzei, localzzex5);
    Object localObject2 = zzex.zzj;
    zzl = new zzeg("MESSAGE", 9, 9, localzzei, (zzex)localObject2);
    Object localObject3 = zzex.zzh;
    zzm = new zzeg("BYTES", 10, 10, localzzei, (zzex)localObject3);
    zzn = new zzeg("UINT32", 11, 11, localzzei, localzzex3);
    zzex localzzex6 = zzex.zzi;
    zzo = new zzeg("ENUM", 12, 12, localzzei, localzzex6);
    zzp = new zzeg("SFIXED32", 13, 13, localzzei, localzzex3);
    zzq = new zzeg("SFIXED64", 14, 14, localzzei, (zzex)localObject1);
    zzr = new zzeg("SINT32", 15, 15, localzzei, localzzex3);
    zzs = new zzeg("SINT64", 16, 16, localzzei, (zzex)localObject1);
    zzt = new zzeg("GROUP", 17, 17, localzzei, (zzex)localObject2);
    localzzei = zzei.zzb;
    zzu = new zzeg("DOUBLE_LIST", 18, 18, localzzei, localzzex1);
    zzv = new zzeg("FLOAT_LIST", 19, 19, localzzei, localzzex2);
    zzw = new zzeg("INT64_LIST", 20, 20, localzzei, (zzex)localObject1);
    zzx = new zzeg("UINT64_LIST", 21, 21, localzzei, (zzex)localObject1);
    zzy = new zzeg("INT32_LIST", 22, 22, localzzei, localzzex3);
    zzz = new zzeg("FIXED64_LIST", 23, 23, localzzei, (zzex)localObject1);
    zzaa = new zzeg("FIXED32_LIST", 24, 24, localzzei, localzzex3);
    zzab = new zzeg("BOOL_LIST", 25, 25, localzzei, localzzex4);
    zzac = new zzeg("STRING_LIST", 26, 26, localzzei, localzzex5);
    zzad = new zzeg("MESSAGE_LIST", 27, 27, localzzei, (zzex)localObject2);
    zzae = new zzeg("BYTES_LIST", 28, 28, localzzei, (zzex)localObject3);
    zzaf = new zzeg("UINT32_LIST", 29, 29, localzzei, localzzex3);
    zzag = new zzeg("ENUM_LIST", 30, 30, localzzei, localzzex6);
    zzah = new zzeg("SFIXED32_LIST", 31, 31, localzzei, localzzex3);
    zzai = new zzeg("SFIXED64_LIST", 32, 32, localzzei, (zzex)localObject1);
    zzaj = new zzeg("SINT32_LIST", 33, 33, localzzei, localzzex3);
    zzak = new zzeg("SINT64_LIST", 34, 34, localzzei, (zzex)localObject1);
    localObject3 = zzei.zzc;
    zza = new zzeg("DOUBLE_LIST_PACKED", 35, 35, (zzei)localObject3, localzzex1);
    zzal = new zzeg("FLOAT_LIST_PACKED", 36, 36, (zzei)localObject3, localzzex2);
    zzam = new zzeg("INT64_LIST_PACKED", 37, 37, (zzei)localObject3, (zzex)localObject1);
    zzan = new zzeg("UINT64_LIST_PACKED", 38, 38, (zzei)localObject3, (zzex)localObject1);
    zzao = new zzeg("INT32_LIST_PACKED", 39, 39, (zzei)localObject3, localzzex3);
    zzap = new zzeg("FIXED64_LIST_PACKED", 40, 40, (zzei)localObject3, (zzex)localObject1);
    zzaq = new zzeg("FIXED32_LIST_PACKED", 41, 41, (zzei)localObject3, localzzex3);
    zzar = new zzeg("BOOL_LIST_PACKED", 42, 42, (zzei)localObject3, localzzex4);
    zzas = new zzeg("UINT32_LIST_PACKED", 43, 43, (zzei)localObject3, localzzex3);
    zzat = new zzeg("ENUM_LIST_PACKED", 44, 44, (zzei)localObject3, localzzex6);
    zzau = new zzeg("SFIXED32_LIST_PACKED", 45, 45, (zzei)localObject3, localzzex3);
    localObject1 = zzex.zzc;
    zzav = new zzeg("SFIXED64_LIST_PACKED", 46, 46, (zzei)localObject3, (zzex)localObject1);
    zzaw = new zzeg("SINT32_LIST_PACKED", 47, 47, (zzei)localObject3, zzex.zzb);
    zzb = new zzeg("SINT64_LIST_PACKED", 48, 48, (zzei)localObject3, (zzex)localObject1);
    zzax = new zzeg("GROUP_LIST", 49, 49, localzzei, (zzex)localObject2);
    zzay = new zzeg("MAP", 50, 50, zzei.zzd, zzex.zza);
    localObject2 = zzc;
    int i = 0;
    zzbg = new zzeg[] { localObject2, zzd, zze, zzf, zzg, zzh, zzi, zzj, zzk, zzl, zzm, zzn, zzo, zzp, zzq, zzr, zzs, zzt, zzu, zzv, zzw, zzx, zzy, zzz, zzaa, zzab, zzac, zzad, zzae, zzaf, zzag, zzah, zzai, zzaj, zzak, zza, zzal, zzam, zzan, zzao, zzap, zzaq, zzar, zzas, zzat, zzau, zzav, zzaw, zzb, zzax, zzay };
    zzbf = new Type[0];
    localObject1 = values();
    zzbe = new zzeg[localObject1.length];
    int j = localObject1.length;
    while (i < j)
    {
      localObject2 = localObject1[i];
      zzbe[localObject2.zzba] = localObject2;
      i++;
    }
  }
  
  private zzeg(int paramInt, zzei paramzzei, zzex paramzzex)
  {
    this.zzba = paramInt;
    this.zzbb = paramzzei;
    this.zzaz = paramzzex;
    ??? = zzej.zza[paramzzei.ordinal()];
    boolean bool = true;
    if (??? != 1)
    {
      if (??? != 2) {
        this.zzbc = null;
      } else {
        this.zzbc = paramzzex.zza();
      }
    }
    else {
      this.zzbc = paramzzex.zza();
    }
    if (paramzzei == zzei.zza)
    {
      ??? = zzej.zzb[paramzzex.ordinal()];
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzeg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */