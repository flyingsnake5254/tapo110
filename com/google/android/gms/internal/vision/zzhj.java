package com.google.android.gms.internal.vision;

public enum zzhj
{
  private final Class<?> zzyh;
  private final Class<?> zzyi;
  private final Object zzyj;
  
  static
  {
    zzhj localzzhj1 = new zzhj("VOID", 0, Void.class, Void.class, null);
    zzxx = localzzhj1;
    Object localObject = Integer.TYPE;
    zzhj localzzhj2 = new zzhj("INT", 1, (Class)localObject, Integer.class, Integer.valueOf(0));
    zzxy = localzzhj2;
    zzhj localzzhj3 = new zzhj("LONG", 2, Long.TYPE, Long.class, Long.valueOf(0L));
    zzxz = localzzhj3;
    zzhj localzzhj4 = new zzhj("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0F));
    zzya = localzzhj4;
    zzhj localzzhj5 = new zzhj("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0D));
    zzyb = localzzhj5;
    zzhj localzzhj6 = new zzhj("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
    zzyc = localzzhj6;
    zzhj localzzhj7 = new zzhj("STRING", 6, String.class, String.class, "");
    zzyd = localzzhj7;
    zzhj localzzhj8 = new zzhj("BYTE_STRING", 7, zzfm.class, zzfm.class, zzfm.zzsm);
    zzye = localzzhj8;
    zzhj localzzhj9 = new zzhj("ENUM", 8, (Class)localObject, Integer.class, null);
    zzyf = localzzhj9;
    localObject = new zzhj("MESSAGE", 9, Object.class, Object.class, null);
    zzyg = (zzhj)localObject;
    zzyk = new zzhj[] { localzzhj1, localzzhj2, localzzhj3, localzzhj4, localzzhj5, localzzhj6, localzzhj7, localzzhj8, localzzhj9, localObject };
  }
  
  private zzhj(Class<?> paramClass1, Class<?> paramClass2, Object paramObject)
  {
    this.zzyh = paramClass1;
    this.zzyi = paramClass2;
    this.zzyj = paramObject;
  }
  
  public final Class<?> zzgw()
  {
    return this.zzyi;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzhj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */