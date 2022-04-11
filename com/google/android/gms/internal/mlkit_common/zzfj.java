package com.google.android.gms.internal.mlkit_common;

public enum zzfj
{
  private final Class<?> zzk;
  private final Class<?> zzl;
  private final Object zzm;
  
  static
  {
    zzfj localzzfj1 = new zzfj("VOID", 0, Void.class, Void.class, null);
    zza = localzzfj1;
    Object localObject = Integer.TYPE;
    zzfj localzzfj2 = new zzfj("INT", 1, (Class)localObject, Integer.class, Integer.valueOf(0));
    zzb = localzzfj2;
    zzfj localzzfj3 = new zzfj("LONG", 2, Long.TYPE, Long.class, Long.valueOf(0L));
    zzc = localzzfj3;
    zzfj localzzfj4 = new zzfj("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0F));
    zzd = localzzfj4;
    zzfj localzzfj5 = new zzfj("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0D));
    zze = localzzfj5;
    zzfj localzzfj6 = new zzfj("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
    zzf = localzzfj6;
    zzfj localzzfj7 = new zzfj("STRING", 6, String.class, String.class, "");
    zzg = localzzfj7;
    zzfj localzzfj8 = new zzfj("BYTE_STRING", 7, zzdv.class, zzdv.class, zzdv.zza);
    zzh = localzzfj8;
    zzfj localzzfj9 = new zzfj("ENUM", 8, (Class)localObject, Integer.class, null);
    zzi = localzzfj9;
    localObject = new zzfj("MESSAGE", 9, Object.class, Object.class, null);
    zzj = (zzfj)localObject;
    zzn = new zzfj[] { localzzfj1, localzzfj2, localzzfj3, localzzfj4, localzzfj5, localzzfj6, localzzfj7, localzzfj8, localzzfj9, localObject };
  }
  
  private zzfj(Class<?> paramClass1, Class<?> paramClass2, Object paramObject)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzfj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */