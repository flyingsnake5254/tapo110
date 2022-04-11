package com.google.android.gms.internal.clearcut;

public enum zzcq
{
  private final Class<?> zzlh;
  private final Class<?> zzli;
  private final Object zzlj;
  
  static
  {
    zzcq localzzcq1 = new zzcq("VOID", 0, Void.class, Void.class, null);
    zzkx = localzzcq1;
    Object localObject = Integer.TYPE;
    zzcq localzzcq2 = new zzcq("INT", 1, (Class)localObject, Integer.class, Integer.valueOf(0));
    zzky = localzzcq2;
    zzcq localzzcq3 = new zzcq("LONG", 2, Long.TYPE, Long.class, Long.valueOf(0L));
    zzkz = localzzcq3;
    zzcq localzzcq4 = new zzcq("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0F));
    zzla = localzzcq4;
    zzcq localzzcq5 = new zzcq("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0D));
    zzlb = localzzcq5;
    zzcq localzzcq6 = new zzcq("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
    zzlc = localzzcq6;
    zzcq localzzcq7 = new zzcq("STRING", 6, String.class, String.class, "");
    zzld = localzzcq7;
    zzcq localzzcq8 = new zzcq("BYTE_STRING", 7, zzbb.class, zzbb.class, zzbb.zzfi);
    zzle = localzzcq8;
    zzcq localzzcq9 = new zzcq("ENUM", 8, (Class)localObject, Integer.class, null);
    zzlf = localzzcq9;
    localObject = new zzcq("MESSAGE", 9, Object.class, Object.class, null);
    zzlg = (zzcq)localObject;
    zzlk = new zzcq[] { localzzcq1, localzzcq2, localzzcq3, localzzcq4, localzzcq5, localzzcq6, localzzcq7, localzzcq8, localzzcq9, localObject };
  }
  
  private zzcq(Class<?> paramClass1, Class<?> paramClass2, Object paramObject)
  {
    this.zzlh = paramClass1;
    this.zzli = paramClass2;
    this.zzlj = paramObject;
  }
  
  public final Class<?> zzbq()
  {
    return this.zzli;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzcq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */