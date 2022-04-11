package com.google.android.gms.internal.measurement;

public enum zzko
{
  private final Class<?> zzk;
  private final Class<?> zzl;
  private final Object zzm;
  
  static
  {
    zzko localzzko1 = new zzko("VOID", 0, Void.class, Void.class, null);
    zza = localzzko1;
    Object localObject = Integer.TYPE;
    zzko localzzko2 = new zzko("INT", 1, (Class)localObject, Integer.class, Integer.valueOf(0));
    zzb = localzzko2;
    zzko localzzko3 = new zzko("LONG", 2, Long.TYPE, Long.class, Long.valueOf(0L));
    zzc = localzzko3;
    zzko localzzko4 = new zzko("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0F));
    zzd = localzzko4;
    zzko localzzko5 = new zzko("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0D));
    zze = localzzko5;
    zzko localzzko6 = new zzko("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
    zzf = localzzko6;
    zzko localzzko7 = new zzko("STRING", 6, String.class, String.class, "");
    zzg = localzzko7;
    zzko localzzko8 = new zzko("BYTE_STRING", 7, zzjd.class, zzjd.class, zzjd.zzb);
    zzh = localzzko8;
    zzko localzzko9 = new zzko("ENUM", 8, (Class)localObject, Integer.class, null);
    zzi = localzzko9;
    localObject = new zzko("MESSAGE", 9, Object.class, Object.class, null);
    zzj = (zzko)localObject;
    zzn = new zzko[] { localzzko1, localzzko2, localzzko3, localzzko4, localzzko5, localzzko6, localzzko7, localzzko8, localzzko9, localObject };
  }
  
  private zzko(Class<?> paramClass1, Class<?> paramClass2, Object paramObject)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzko.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */