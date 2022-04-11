package com.google.android.gms.internal.clearcut;

public final class zzgt
{
  public static final class zza
    extends zzcg<zza, zza>
    implements zzdq
  {
    private static volatile zzdz<zza> zzbg;
    private static final zza zzbil;
    
    static
    {
      zza localzza = new zza();
      zzbil = localzza;
      zzcg.zza(zza.class, localzza);
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzgu.zzba[(paramInt - 1)])
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
              ((zzcg.zzb)paramObject1).<init>(zzbil);
              zzbg = (zzdz)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzbil;
      case 3: 
        return zzcg.zza(zzbil, "\001\000", null);
      case 2: 
        return new zza(null);
      }
      return new zza();
    }
    
    public static final class zza
      extends zzcg.zza<zzgt.zza, zza>
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
      private static final zzck<zzb> zzbq = new zzgv();
      private final int value;
      
      static
      {
        zzb localzzb1 = new zzb("NO_RESTRICTION", 0, 0);
        zzbim = localzzb1;
        zzb localzzb2 = new zzb("SIDEWINDER_DEVICE", 1, 1);
        zzbin = localzzb2;
        zzb localzzb3 = new zzb("LATCHSKY_DEVICE", 2, 2);
        zzbio = localzzb3;
        zzbip = new zzb[] { localzzb1, localzzb2, localzzb3 };
      }
      
      private zzb(int paramInt)
      {
        this.value = paramInt;
      }
      
      public static zzb zzbe(int paramInt)
      {
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            if (paramInt != 2) {
              return null;
            }
            return zzbio;
          }
          return zzbin;
        }
        return zzbim;
      }
      
      public static zzck<zzb> zzd()
      {
        return zzbq;
      }
      
      public final int zzc()
      {
        return this.value;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzgt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */