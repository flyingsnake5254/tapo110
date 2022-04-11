package com.google.android.gms.internal.vision;

import java.lang.reflect.Type;

public enum zzgs
{
  private static final zzgs[] zzwc;
  private static final Type[] zzwd;
  private final int id;
  private final zzhj zzvy;
  private final zzgu zzvz;
  private final Class<?> zzwa;
  private final boolean zzwb;
  
  static
  {
    Object localObject1 = zzgu.zzwh;
    zzhj localzzhj1 = zzhj.zzyb;
    zztz = new zzgs("DOUBLE", 0, 0, (zzgu)localObject1, localzzhj1);
    zzhj localzzhj2 = zzhj.zzya;
    zzua = new zzgs("FLOAT", 1, 1, (zzgu)localObject1, localzzhj2);
    zzhj localzzhj3 = zzhj.zzxz;
    zzub = new zzgs("INT64", 2, 2, (zzgu)localObject1, localzzhj3);
    zzuc = new zzgs("UINT64", 3, 3, (zzgu)localObject1, localzzhj3);
    zzhj localzzhj4 = zzhj.zzxy;
    zzud = new zzgs("INT32", 4, 4, (zzgu)localObject1, localzzhj4);
    zzue = new zzgs("FIXED64", 5, 5, (zzgu)localObject1, localzzhj3);
    zzuf = new zzgs("FIXED32", 6, 6, (zzgu)localObject1, localzzhj4);
    zzhj localzzhj5 = zzhj.zzyc;
    zzug = new zzgs("BOOL", 7, 7, (zzgu)localObject1, localzzhj5);
    Object localObject2 = zzhj.zzyd;
    zzuh = new zzgs("STRING", 8, 8, (zzgu)localObject1, (zzhj)localObject2);
    Object localObject3 = zzhj.zzyg;
    zzui = new zzgs("MESSAGE", 9, 9, (zzgu)localObject1, (zzhj)localObject3);
    zzhj localzzhj6 = zzhj.zzye;
    zzuj = new zzgs("BYTES", 10, 10, (zzgu)localObject1, localzzhj6);
    zzuk = new zzgs("UINT32", 11, 11, (zzgu)localObject1, localzzhj4);
    zzhj localzzhj7 = zzhj.zzyf;
    zzul = new zzgs("ENUM", 12, 12, (zzgu)localObject1, localzzhj7);
    zzum = new zzgs("SFIXED32", 13, 13, (zzgu)localObject1, localzzhj4);
    zzun = new zzgs("SFIXED64", 14, 14, (zzgu)localObject1, localzzhj3);
    zzuo = new zzgs("SINT32", 15, 15, (zzgu)localObject1, localzzhj4);
    zzup = new zzgs("SINT64", 16, 16, (zzgu)localObject1, localzzhj3);
    zzuq = new zzgs("GROUP", 17, 17, (zzgu)localObject1, (zzhj)localObject3);
    localObject1 = zzgu.zzwi;
    zzur = new zzgs("DOUBLE_LIST", 18, 18, (zzgu)localObject1, localzzhj1);
    zzus = new zzgs("FLOAT_LIST", 19, 19, (zzgu)localObject1, localzzhj2);
    zzut = new zzgs("INT64_LIST", 20, 20, (zzgu)localObject1, localzzhj3);
    zzuu = new zzgs("UINT64_LIST", 21, 21, (zzgu)localObject1, localzzhj3);
    zzuv = new zzgs("INT32_LIST", 22, 22, (zzgu)localObject1, localzzhj4);
    zzuw = new zzgs("FIXED64_LIST", 23, 23, (zzgu)localObject1, localzzhj3);
    zzux = new zzgs("FIXED32_LIST", 24, 24, (zzgu)localObject1, localzzhj4);
    zzuy = new zzgs("BOOL_LIST", 25, 25, (zzgu)localObject1, localzzhj5);
    zzuz = new zzgs("STRING_LIST", 26, 26, (zzgu)localObject1, (zzhj)localObject2);
    zzva = new zzgs("MESSAGE_LIST", 27, 27, (zzgu)localObject1, (zzhj)localObject3);
    zzvb = new zzgs("BYTES_LIST", 28, 28, (zzgu)localObject1, localzzhj6);
    zzvc = new zzgs("UINT32_LIST", 29, 29, (zzgu)localObject1, localzzhj4);
    zzvd = new zzgs("ENUM_LIST", 30, 30, (zzgu)localObject1, localzzhj7);
    zzve = new zzgs("SFIXED32_LIST", 31, 31, (zzgu)localObject1, localzzhj4);
    zzvf = new zzgs("SFIXED64_LIST", 32, 32, (zzgu)localObject1, localzzhj3);
    zzvg = new zzgs("SINT32_LIST", 33, 33, (zzgu)localObject1, localzzhj4);
    zzvh = new zzgs("SINT64_LIST", 34, 34, (zzgu)localObject1, localzzhj3);
    localObject2 = zzgu.zzwj;
    zzvi = new zzgs("DOUBLE_LIST_PACKED", 35, 35, (zzgu)localObject2, localzzhj1);
    zzvj = new zzgs("FLOAT_LIST_PACKED", 36, 36, (zzgu)localObject2, localzzhj2);
    zzvk = new zzgs("INT64_LIST_PACKED", 37, 37, (zzgu)localObject2, localzzhj3);
    zzvl = new zzgs("UINT64_LIST_PACKED", 38, 38, (zzgu)localObject2, localzzhj3);
    zzvm = new zzgs("INT32_LIST_PACKED", 39, 39, (zzgu)localObject2, localzzhj4);
    zzvn = new zzgs("FIXED64_LIST_PACKED", 40, 40, (zzgu)localObject2, localzzhj3);
    zzvo = new zzgs("FIXED32_LIST_PACKED", 41, 41, (zzgu)localObject2, localzzhj4);
    zzvp = new zzgs("BOOL_LIST_PACKED", 42, 42, (zzgu)localObject2, localzzhj5);
    zzvq = new zzgs("UINT32_LIST_PACKED", 43, 43, (zzgu)localObject2, localzzhj4);
    zzvr = new zzgs("ENUM_LIST_PACKED", 44, 44, (zzgu)localObject2, localzzhj7);
    zzvs = new zzgs("SFIXED32_LIST_PACKED", 45, 45, (zzgu)localObject2, localzzhj4);
    localzzhj2 = zzhj.zzxz;
    zzvt = new zzgs("SFIXED64_LIST_PACKED", 46, 46, (zzgu)localObject2, localzzhj2);
    zzvu = new zzgs("SINT32_LIST_PACKED", 47, 47, (zzgu)localObject2, zzhj.zzxy);
    zzvv = new zzgs("SINT64_LIST_PACKED", 48, 48, (zzgu)localObject2, localzzhj2);
    zzvw = new zzgs("GROUP_LIST", 49, 49, (zzgu)localObject1, (zzhj)localObject3);
    zzvx = new zzgs("MAP", 50, 50, zzgu.zzwk, zzhj.zzxx);
    localObject3 = zztz;
    int i = 0;
    zzwe = new zzgs[] { localObject3, zzua, zzub, zzuc, zzud, zzue, zzuf, zzug, zzuh, zzui, zzuj, zzuk, zzul, zzum, zzun, zzuo, zzup, zzuq, zzur, zzus, zzut, zzuu, zzuv, zzuw, zzux, zzuy, zzuz, zzva, zzvb, zzvc, zzvd, zzve, zzvf, zzvg, zzvh, zzvi, zzvj, zzvk, zzvl, zzvm, zzvn, zzvo, zzvp, zzvq, zzvr, zzvs, zzvt, zzvu, zzvv, zzvw, zzvx };
    zzwd = new Type[0];
    localObject1 = values();
    zzwc = new zzgs[localObject1.length];
    int j = localObject1.length;
    while (i < j)
    {
      localObject3 = localObject1[i];
      zzwc[localObject3.id] = localObject3;
      i++;
    }
  }
  
  private zzgs(int paramInt, zzgu paramzzgu, zzhj paramzzhj)
  {
    this.id = paramInt;
    this.zzvz = paramzzgu;
    this.zzvy = paramzzhj;
    ??? = zzgr.zztx[paramzzgu.ordinal()];
    boolean bool = true;
    if (??? != 1)
    {
      if (??? != 2) {
        this.zzwa = null;
      } else {
        this.zzwa = paramzzhj.zzgw();
      }
    }
    else {
      this.zzwa = paramzzhj.zzgw();
    }
    if (paramzzgu == zzgu.zzwh)
    {
      ??? = zzgr.zzty[paramzzhj.ordinal()];
      if ((??? != 1) && (??? != 2) && (??? != 3)) {}
    }
    else
    {
      bool = false;
    }
    this.zzwb = bool;
  }
  
  public final int id()
  {
    return this.id;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */