package com.google.android.gms.internal.mlkit_vision_barcode;

public enum zzgm
{
  private final Class<?> zzk;
  private final Class<?> zzl;
  private final Object zzm;
  
  static
  {
    zzgm localzzgm1 = new zzgm("VOID", 0, Void.class, Void.class, null);
    zza = localzzgm1;
    Object localObject = Integer.TYPE;
    zzgm localzzgm2 = new zzgm("INT", 1, (Class)localObject, Integer.class, Integer.valueOf(0));
    zzb = localzzgm2;
    zzgm localzzgm3 = new zzgm("LONG", 2, Long.TYPE, Long.class, Long.valueOf(0L));
    zzc = localzzgm3;
    zzgm localzzgm4 = new zzgm("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0F));
    zzd = localzzgm4;
    zzgm localzzgm5 = new zzgm("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0D));
    zze = localzzgm5;
    zzgm localzzgm6 = new zzgm("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
    zzf = localzzgm6;
    zzgm localzzgm7 = new zzgm("STRING", 6, String.class, String.class, "");
    zzg = localzzgm7;
    zzgm localzzgm8 = new zzgm("BYTE_STRING", 7, zzew.class, zzew.class, zzew.zza);
    zzh = localzzgm8;
    zzgm localzzgm9 = new zzgm("ENUM", 8, (Class)localObject, Integer.class, null);
    zzi = localzzgm9;
    localObject = new zzgm("MESSAGE", 9, Object.class, Object.class, null);
    zzj = (zzgm)localObject;
    zzn = new zzgm[] { localzzgm1, localzzgm2, localzzgm3, localzzgm4, localzzgm5, localzzgm6, localzzgm7, localzzgm8, localzzgm9, localObject };
  }
  
  private zzgm(Class<?> paramClass1, Class<?> paramClass2, Object paramObject)
  {
    this.zzk = paramClass1;
    this.zzl = paramClass2;
    this.zzm = paramObject;
  }
  
  public final Class<?> zza()
  {
    return this.zzl;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzgm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */