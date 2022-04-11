package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Type;

public enum zzcb
{
  private static final zzcb[] zzjb;
  private static final Type[] zzjc;
  private final int id;
  private final zzcq zzix;
  private final zzcd zziy;
  private final Class<?> zziz;
  private final boolean zzja;
  
  static
  {
    zzcd localzzcd = zzcd.zzjg;
    zzcq localzzcq1 = zzcq.zzlb;
    zzgy = new zzcb("DOUBLE", 0, 0, localzzcd, localzzcq1);
    zzcq localzzcq2 = zzcq.zzla;
    zzgz = new zzcb("FLOAT", 1, 1, localzzcd, localzzcq2);
    Object localObject1 = zzcq.zzkz;
    zzha = new zzcb("INT64", 2, 2, localzzcd, (zzcq)localObject1);
    zzhb = new zzcb("UINT64", 3, 3, localzzcd, (zzcq)localObject1);
    zzcq localzzcq3 = zzcq.zzky;
    zzhc = new zzcb("INT32", 4, 4, localzzcd, localzzcq3);
    zzhd = new zzcb("FIXED64", 5, 5, localzzcd, (zzcq)localObject1);
    zzhe = new zzcb("FIXED32", 6, 6, localzzcd, localzzcq3);
    zzcq localzzcq4 = zzcq.zzlc;
    zzhf = new zzcb("BOOL", 7, 7, localzzcd, localzzcq4);
    Object localObject2 = zzcq.zzld;
    zzhg = new zzcb("STRING", 8, 8, localzzcd, (zzcq)localObject2);
    Object localObject3 = zzcq.zzlg;
    zzhh = new zzcb("MESSAGE", 9, 9, localzzcd, (zzcq)localObject3);
    zzcq localzzcq5 = zzcq.zzle;
    zzhi = new zzcb("BYTES", 10, 10, localzzcd, localzzcq5);
    zzhj = new zzcb("UINT32", 11, 11, localzzcd, localzzcq3);
    zzcq localzzcq6 = zzcq.zzlf;
    zzhk = new zzcb("ENUM", 12, 12, localzzcd, localzzcq6);
    zzhl = new zzcb("SFIXED32", 13, 13, localzzcd, localzzcq3);
    zzhm = new zzcb("SFIXED64", 14, 14, localzzcd, (zzcq)localObject1);
    zzhn = new zzcb("SINT32", 15, 15, localzzcd, localzzcq3);
    zzho = new zzcb("SINT64", 16, 16, localzzcd, (zzcq)localObject1);
    zzhp = new zzcb("GROUP", 17, 17, localzzcd, (zzcq)localObject3);
    localzzcd = zzcd.zzjh;
    zzhq = new zzcb("DOUBLE_LIST", 18, 18, localzzcd, localzzcq1);
    zzhr = new zzcb("FLOAT_LIST", 19, 19, localzzcd, localzzcq2);
    zzhs = new zzcb("INT64_LIST", 20, 20, localzzcd, (zzcq)localObject1);
    zzht = new zzcb("UINT64_LIST", 21, 21, localzzcd, (zzcq)localObject1);
    zzhu = new zzcb("INT32_LIST", 22, 22, localzzcd, localzzcq3);
    zzhv = new zzcb("FIXED64_LIST", 23, 23, localzzcd, (zzcq)localObject1);
    zzhw = new zzcb("FIXED32_LIST", 24, 24, localzzcd, localzzcq3);
    zzhx = new zzcb("BOOL_LIST", 25, 25, localzzcd, localzzcq4);
    zzhy = new zzcb("STRING_LIST", 26, 26, localzzcd, (zzcq)localObject2);
    zzhz = new zzcb("MESSAGE_LIST", 27, 27, localzzcd, (zzcq)localObject3);
    zzia = new zzcb("BYTES_LIST", 28, 28, localzzcd, localzzcq5);
    zzib = new zzcb("UINT32_LIST", 29, 29, localzzcd, localzzcq3);
    zzic = new zzcb("ENUM_LIST", 30, 30, localzzcd, localzzcq6);
    zzid = new zzcb("SFIXED32_LIST", 31, 31, localzzcd, localzzcq3);
    zzie = new zzcb("SFIXED64_LIST", 32, 32, localzzcd, (zzcq)localObject1);
    zzif = new zzcb("SINT32_LIST", 33, 33, localzzcd, localzzcq3);
    zzig = new zzcb("SINT64_LIST", 34, 34, localzzcd, (zzcq)localObject1);
    localObject2 = zzcd.zzji;
    zzih = new zzcb("DOUBLE_LIST_PACKED", 35, 35, (zzcd)localObject2, localzzcq1);
    zzii = new zzcb("FLOAT_LIST_PACKED", 36, 36, (zzcd)localObject2, localzzcq2);
    zzij = new zzcb("INT64_LIST_PACKED", 37, 37, (zzcd)localObject2, (zzcq)localObject1);
    zzik = new zzcb("UINT64_LIST_PACKED", 38, 38, (zzcd)localObject2, (zzcq)localObject1);
    zzil = new zzcb("INT32_LIST_PACKED", 39, 39, (zzcd)localObject2, localzzcq3);
    zzim = new zzcb("FIXED64_LIST_PACKED", 40, 40, (zzcd)localObject2, (zzcq)localObject1);
    zzin = new zzcb("FIXED32_LIST_PACKED", 41, 41, (zzcd)localObject2, localzzcq3);
    zzio = new zzcb("BOOL_LIST_PACKED", 42, 42, (zzcd)localObject2, localzzcq4);
    zzip = new zzcb("UINT32_LIST_PACKED", 43, 43, (zzcd)localObject2, localzzcq3);
    zziq = new zzcb("ENUM_LIST_PACKED", 44, 44, (zzcd)localObject2, localzzcq6);
    zzir = new zzcb("SFIXED32_LIST_PACKED", 45, 45, (zzcd)localObject2, localzzcq3);
    localObject1 = zzcq.zzkz;
    zzis = new zzcb("SFIXED64_LIST_PACKED", 46, 46, (zzcd)localObject2, (zzcq)localObject1);
    zzit = new zzcb("SINT32_LIST_PACKED", 47, 47, (zzcd)localObject2, zzcq.zzky);
    zziu = new zzcb("SINT64_LIST_PACKED", 48, 48, (zzcd)localObject2, (zzcq)localObject1);
    zziv = new zzcb("GROUP_LIST", 49, 49, localzzcd, (zzcq)localObject3);
    zziw = new zzcb("MAP", 50, 50, zzcd.zzjj, zzcq.zzkx);
    localObject3 = zzgy;
    int i = 0;
    zzjd = new zzcb[] { localObject3, zzgz, zzha, zzhb, zzhc, zzhd, zzhe, zzhf, zzhg, zzhh, zzhi, zzhj, zzhk, zzhl, zzhm, zzhn, zzho, zzhp, zzhq, zzhr, zzhs, zzht, zzhu, zzhv, zzhw, zzhx, zzhy, zzhz, zzia, zzib, zzic, zzid, zzie, zzif, zzig, zzih, zzii, zzij, zzik, zzil, zzim, zzin, zzio, zzip, zziq, zzir, zzis, zzit, zziu, zziv, zziw };
    zzjc = new Type[0];
    localObject1 = values();
    zzjb = new zzcb[localObject1.length];
    int j = localObject1.length;
    while (i < j)
    {
      localObject3 = localObject1[i];
      zzjb[localObject3.id] = localObject3;
      i++;
    }
  }
  
  private zzcb(int paramInt, zzcd paramzzcd, zzcq paramzzcq)
  {
    this.id = paramInt;
    this.zziy = paramzzcd;
    this.zzix = paramzzcq;
    ??? = zzcc.zzje[paramzzcd.ordinal()];
    boolean bool = true;
    if ((??? != 1) && (??? != 2)) {
      ??? = null;
    } else {
      ??? = paramzzcq.zzbq();
    }
    this.zziz = ((Class)???);
    if (paramzzcd == zzcd.zzjg)
    {
      ??? = zzcc.zzjf[paramzzcq.ordinal()];
      if ((??? != 1) && (??? != 2) && (??? != 3)) {}
    }
    else
    {
      bool = false;
    }
    this.zzja = bool;
  }
  
  public final int id()
  {
    return this.id;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzcb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */