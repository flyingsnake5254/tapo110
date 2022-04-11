package com.google.android.gms.internal.clearcut;

public final class zzap
{
  public static final class zza
    extends zzcg<zza, zza>
    implements zzdq
  {
    private static volatile zzdz<zza> zzbg;
    private static final zza zzes;
    private int zzbb;
    private int zzel;
    private int zzem;
    private int zzen;
    private int zzeo;
    private int zzep;
    private int zzeq;
    private int zzer;
    
    static
    {
      zza localzza = new zza();
      zzes = localzza;
      zzcg.zza(zza.class, localzza);
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzaq.zzba[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
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
              ((zzcg.zzb)paramObject1).<init>(zzes);
              zzbg = (zzdz)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzes;
      case 3: 
        paramObject1 = zzb.zzd();
        zzck localzzck1 = zzb.zzd();
        paramObject2 = zzb.zzd();
        zzck localzzck2 = zzb.zzd();
        zzck localzzck3 = zzb.zzd();
        zzck localzzck4 = zzb.zzd();
        zzck localzzck5 = zzb.zzd();
        return zzcg.zza(zzes, "\001\007\000\001\001\007\007\b\000\000\000\001\f\000\002\f\001\003\f\002\004\f\003\005\f\004\006\f\005\007\f\006", new Object[] { "zzbb", "zzel", paramObject1, "zzem", localzzck1, "zzen", paramObject2, "zzeo", localzzck2, "zzep", localzzck3, "zzeq", localzzck4, "zzer", localzzck5 });
      case 2: 
        return new zza(null);
      }
      return new zza();
    }
    
    public static final class zza
      extends zzcg.zza<zzap.zza, zza>
      implements zzdq
    {
      private zza()
      {
        super();
      }
    }
    
    public static enum zzb
      implements zzcj
    {
      private static final zzck<zzb> zzbq = new zzar();
      private final int value;
      
      static
      {
        zzb localzzb1 = new zzb("UNKNOWN", 0, 0);
        zzet = localzzb1;
        zzb localzzb2 = new zzb("ON", 1, 1);
        zzeu = localzzb2;
        zzb localzzb3 = new zzb("OFF", 2, 2);
        zzev = localzzb3;
        zzew = new zzb[] { localzzb1, localzzb2, localzzb3 };
      }
      
      private zzb(int paramInt)
      {
        this.value = paramInt;
      }
      
      public static zzck<zzb> zzd()
      {
        return zzbq;
      }
      
      public static zzb zze(int paramInt)
      {
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            if (paramInt != 2) {
              return null;
            }
            return zzev;
          }
          return zzeu;
        }
        return zzet;
      }
      
      public final int zzc()
      {
        return this.value;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */