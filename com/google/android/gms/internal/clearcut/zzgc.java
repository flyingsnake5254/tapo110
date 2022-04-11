package com.google.android.gms.internal.clearcut;

public final class zzgc
  extends zzcg.zzd<zzgc, zza>
  implements zzdq
{
  private static volatile zzdz<zzgc> zzbg;
  private static final zzgc zzsg;
  private byte zzsf = (byte)2;
  
  static
  {
    zzgc localzzgc = new zzgc();
    zzsg = localzzgc;
    zzcg.zza(zzgc.class, localzzgc);
  }
  
  public static zzgc zzer()
  {
    return zzsg;
  }
  
  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    paramObject2 = zzgd.zzba;
    int i = 1;
    switch (paramObject2[(paramInt - 1)])
    {
    default: 
      throw new UnsupportedOperationException();
    case 7: 
      paramInt = i;
      if (paramObject1 == null) {
        paramInt = 0;
      }
      this.zzsf = ((byte)(byte)paramInt);
      return null;
    case 6: 
      return Byte.valueOf(this.zzsf);
    case 5: 
      paramObject2 = zzbg;
      paramObject1 = paramObject2;
      if (paramObject2 == null) {
        try
        {
          paramObject2 = zzbg;
          paramObject1 = paramObject2;
          if (paramObject2 == null)
          {
            paramObject1 = new com/google/android/gms/internal/clearcut/zzcg$zzb;
            ((zzcg.zzb)paramObject1).<init>(zzsg);
            zzbg = (zzdz)paramObject1;
          }
        }
        finally {}
      }
      return paramObject1;
    case 4: 
      return zzsg;
    case 3: 
      return zzcg.zza(zzsg, "\003\000", null);
    case 2: 
      return new zza(null);
    }
    return new zzgc();
  }
  
  public static final class zza
    extends zzcg.zzc<zzgc, zza>
    implements zzdq
  {
    private zza()
    {
      super();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzgc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */