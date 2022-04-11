package com.google.android.gms.internal.vision;

public enum zzkf
{
  private final zzki zzact;
  private final int zzacu;
  
  static
  {
    zzkf localzzkf1 = new zzkf("DOUBLE", 0, zzki.zzacz, 1);
    zzacb = localzzkf1;
    zzkf localzzkf2 = new zzkf("FLOAT", 1, zzki.zzacy, 5);
    zzacc = localzzkf2;
    Object localObject1 = zzki.zzacx;
    zzkf localzzkf3 = new zzkf("INT64", 2, (zzki)localObject1, 0);
    zzacd = localzzkf3;
    zzkf localzzkf4 = new zzkf("UINT64", 3, (zzki)localObject1, 0);
    zzace = localzzkf4;
    Object localObject2 = zzki.zzacw;
    zzkf localzzkf5 = new zzkf("INT32", 4, (zzki)localObject2, 0);
    zzacf = localzzkf5;
    zzkf localzzkf6 = new zzkf("FIXED64", 5, (zzki)localObject1, 1);
    zzacg = localzzkf6;
    zzkf localzzkf7 = new zzkf("FIXED32", 6, (zzki)localObject2, 5);
    zzach = localzzkf7;
    zzkf localzzkf8 = new zzkf("BOOL", 7, zzki.zzada, 0);
    zzaci = localzzkf8;
    zzke localzzke = new zzke("STRING", 8, zzki.zzadb, 2);
    zzacj = localzzke;
    Object localObject3 = zzki.zzade;
    zzkh localzzkh = new zzkh("GROUP", 9, (zzki)localObject3, 3);
    zzack = localzzkh;
    zzkg localzzkg = new zzkg("MESSAGE", 10, (zzki)localObject3, 2);
    zzacl = localzzkg;
    zzkj localzzkj = new zzkj("BYTES", 11, zzki.zzadc, 2);
    zzacm = localzzkj;
    zzkf localzzkf9 = new zzkf("UINT32", 12, (zzki)localObject2, 0);
    zzacn = localzzkf9;
    zzkf localzzkf10 = new zzkf("ENUM", 13, zzki.zzadd, 0);
    zzaco = localzzkf10;
    localObject3 = new zzkf("SFIXED32", 14, (zzki)localObject2, 5);
    zzacp = (zzkf)localObject3;
    zzkf localzzkf11 = new zzkf("SFIXED64", 15, (zzki)localObject1, 1);
    zzacq = localzzkf11;
    localObject2 = new zzkf("SINT32", 16, (zzki)localObject2, 0);
    zzacr = (zzkf)localObject2;
    localObject1 = new zzkf("SINT64", 17, (zzki)localObject1, 0);
    zzacs = (zzkf)localObject1;
    zzacv = new zzkf[] { localzzkf1, localzzkf2, localzzkf3, localzzkf4, localzzkf5, localzzkf6, localzzkf7, localzzkf8, localzzke, localzzkh, localzzkg, localzzkj, localzzkf9, localzzkf10, localObject3, localzzkf11, localObject2, localObject1 };
  }
  
  private zzkf(zzki paramzzki, int paramInt)
  {
    this.zzact = paramzzki;
    this.zzacu = paramInt;
  }
  
  public final zzki zziq()
  {
    return this.zzact;
  }
  
  public final int zzir()
  {
    return this.zzacu;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzkf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */