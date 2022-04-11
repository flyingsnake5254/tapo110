package com.google.android.gms.internal.mlkit_vision_common;

public enum zzex
{
  private final Class<?> zzk;
  private final Class<?> zzl;
  private final Object zzm;
  
  static
  {
    zzex localzzex1 = new zzex("VOID", 0, Void.class, Void.class, null);
    zza = localzzex1;
    Object localObject = Integer.TYPE;
    zzex localzzex2 = new zzex("INT", 1, (Class)localObject, Integer.class, Integer.valueOf(0));
    zzb = localzzex2;
    zzex localzzex3 = new zzex("LONG", 2, Long.TYPE, Long.class, Long.valueOf(0L));
    zzc = localzzex3;
    zzex localzzex4 = new zzex("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0F));
    zzd = localzzex4;
    zzex localzzex5 = new zzex("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0D));
    zze = localzzex5;
    zzex localzzex6 = new zzex("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
    zzf = localzzex6;
    zzex localzzex7 = new zzex("STRING", 6, String.class, String.class, "");
    zzg = localzzex7;
    zzex localzzex8 = new zzex("BYTE_STRING", 7, zzdj.class, zzdj.class, zzdj.zza);
    zzh = localzzex8;
    localObject = new zzex("ENUM", 8, (Class)localObject, Integer.class, null);
    zzi = (zzex)localObject;
    zzex localzzex9 = new zzex("MESSAGE", 9, Object.class, Object.class, null);
    zzj = localzzex9;
    zzn = new zzex[] { localzzex1, localzzex2, localzzex3, localzzex4, localzzex5, localzzex6, localzzex7, localzzex8, localObject, localzzex9 };
  }
  
  private zzex(Class<?> paramClass1, Class<?> paramClass2, Object paramObject)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */