package com.google.android.gms.internal.mlkit_common;

public enum zzdm
  implements zzfb
{
  private static final zzfe<zzdm> zzq = new zzdo();
  private final int zzr;
  
  static
  {
    zzdm localzzdm1 = new zzdm("UNRECOGNIZED", 0, 0);
    zza = localzzdm1;
    zzdm localzzdm2 = new zzdm("CODE_128", 1, 1);
    zzb = localzzdm2;
    zzdm localzzdm3 = new zzdm("CODE_39", 2, 2);
    zzc = localzzdm3;
    zzdm localzzdm4 = new zzdm("CODE_93", 3, 3);
    zzd = localzzdm4;
    zzdm localzzdm5 = new zzdm("CODABAR", 4, 4);
    zze = localzzdm5;
    zzdm localzzdm6 = new zzdm("DATA_MATRIX", 5, 5);
    zzf = localzzdm6;
    zzdm localzzdm7 = new zzdm("EAN_13", 6, 6);
    zzg = localzzdm7;
    zzdm localzzdm8 = new zzdm("EAN_8", 7, 7);
    zzh = localzzdm8;
    zzdm localzzdm9 = new zzdm("ITF", 8, 8);
    zzi = localzzdm9;
    zzdm localzzdm10 = new zzdm("QR_CODE", 9, 9);
    zzj = localzzdm10;
    zzdm localzzdm11 = new zzdm("UPC_A", 10, 10);
    zzk = localzzdm11;
    zzdm localzzdm12 = new zzdm("UPC_E", 11, 11);
    zzl = localzzdm12;
    zzdm localzzdm13 = new zzdm("PDF417", 12, 12);
    zzm = localzzdm13;
    zzdm localzzdm14 = new zzdm("AZTEC", 13, 13);
    zzn = localzzdm14;
    zzdm localzzdm15 = new zzdm("DATABAR", 14, 14);
    zzo = localzzdm15;
    zzdm localzzdm16 = new zzdm("TEZ_CODE", 15, 16);
    zzp = localzzdm16;
    zzs = new zzdm[] { localzzdm1, localzzdm2, localzzdm3, localzzdm4, localzzdm5, localzzdm6, localzzdm7, localzzdm8, localzzdm9, localzzdm10, localzzdm11, localzzdm12, localzzdm13, localzzdm14, localzzdm15, localzzdm16 };
  }
  
  private zzdm(int paramInt)
  {
    this.zzr = paramInt;
  }
  
  public static zzfd zzb()
  {
    return zzdn.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzdm.class.getName());
    localStringBuilder.append('@');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" number=");
    localStringBuilder.append(this.zzr);
    localStringBuilder.append(" name=");
    localStringBuilder.append(name());
    localStringBuilder.append('>');
    return localStringBuilder.toString();
  }
  
  public final int zza()
  {
    return this.zzr;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzdm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */