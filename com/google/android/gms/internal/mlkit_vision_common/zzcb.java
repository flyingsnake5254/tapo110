package com.google.android.gms.internal.mlkit_vision_common;

public final class zzcb
{
  public static final class zza
    extends zzek<zza, zza>
    implements zzfx
  {
    private static final zzet<Integer, zzcz> zzd = new zzcc();
    private static final zza zze;
    private static volatile zzgf<zza> zzf;
    private zzeq zzc = zzek.zzk();
    
    static
    {
      zza localzza = new zza();
      zze = localzza;
      zzek.zza(zza.class, localzza);
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzca.zza[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject2 = zzf;
        paramObject1 = paramObject2;
        if (paramObject2 == null) {
          try
          {
            paramObject2 = zzf;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new com/google/android/gms/internal/mlkit_vision_common/zzek$zza;
              ((zzek.zza)paramObject1).<init>(zze);
              zzf = (zzgf)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zze;
      case 3: 
        paramObject1 = zzcz.zzb();
        return zzek.zza(zze, "\001\001\000\000\001\001\001\000\001\000\001\036", new Object[] { "zzc", paramObject1 });
      case 2: 
        return new zza(null);
      }
      return new zza();
    }
    
    public static final class zza
      extends zzek.zzb<zzcb.zza, zza>
      implements zzfx
    {
      private zza()
      {
        super();
      }
    }
  }
  
  public static final class zzb
    extends zzek<zzb, zzb>
    implements zzfx
  {
    private static final zzb zzj;
    private static volatile zzgf<zzb> zzk;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private float zzi;
    
    static
    {
      zzb localzzb = new zzb();
      zzj = localzzb;
      zzek.zza(zzb.class, localzzb);
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzca.zza[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject2 = zzk;
        paramObject1 = paramObject2;
        if (paramObject2 == null) {
          try
          {
            paramObject2 = zzk;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new com/google/android/gms/internal/mlkit_vision_common/zzek$zza;
              ((zzek.zza)paramObject1).<init>(zzj);
              zzk = (zzgf)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzj;
      case 3: 
        zzer localzzer = zzd.zzb();
        paramObject1 = zzc.zzb();
        paramObject2 = zza.zzb();
        return zzek.zza(zzj, "\001\006\000\001\001\006\006\000\000\000\001ဌ\000\002ဌ\001\003ဌ\002\004ဇ\003\005ဇ\004\006ခ\005", new Object[] { "zzc", "zzd", localzzer, "zze", paramObject1, "zzf", paramObject2, "zzg", "zzh", "zzi" });
      case 2: 
        return new zzb(null);
      }
      return new zzb();
    }
    
    public static enum zza
      implements zzep
    {
      private static final zzeo<zza> zzd = new zzce();
      private final int zze;
      
      static
      {
        zza localzza1 = new zza("CLASSIFICATION_UNKNOWN", 0, 0);
        zza = localzza1;
        zza localzza2 = new zza("CLASSIFICATION_NONE", 1, 1);
        zzb = localzza2;
        zza localzza3 = new zza("CLASSIFICATION_ALL", 2, 2);
        zzc = localzza3;
        zzf = new zza[] { localzza1, localzza2, localzza3 };
      }
      
      private zza(int paramInt)
      {
        this.zze = paramInt;
      }
      
      public static zzer zzb()
      {
        return zzcd.zza;
      }
      
      public final String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder("<");
        localStringBuilder.append(zza.class.getName());
        localStringBuilder.append('@');
        localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        localStringBuilder.append(" number=");
        localStringBuilder.append(this.zze);
        localStringBuilder.append(" name=");
        localStringBuilder.append(name());
        localStringBuilder.append('>');
        return localStringBuilder.toString();
      }
      
      public final int zza()
      {
        return this.zze;
      }
    }
    
    public static final class zzb
      extends zzek.zzb<zzcb.zzb, zzb>
      implements zzfx
    {
      private zzb()
      {
        super();
      }
    }
    
    public static enum zzc
      implements zzep
    {
      private static final zzeo<zzc> zze = new zzcf();
      private final int zzf;
      
      static
      {
        zzc localzzc1 = new zzc("LANDMARK_UNKNOWN", 0, 0);
        zza = localzzc1;
        zzc localzzc2 = new zzc("LANDMARK_NONE", 1, 1);
        zzb = localzzc2;
        zzc localzzc3 = new zzc("LANDMARK_ALL", 2, 2);
        zzc = localzzc3;
        zzc localzzc4 = new zzc("LANDMARK_CONTOUR", 3, 3);
        zzd = localzzc4;
        zzg = new zzc[] { localzzc1, localzzc2, localzzc3, localzzc4 };
      }
      
      private zzc(int paramInt)
      {
        this.zzf = paramInt;
      }
      
      public static zzer zzb()
      {
        return zzcg.zza;
      }
      
      public final String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder("<");
        localStringBuilder.append(zzc.class.getName());
        localStringBuilder.append('@');
        localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        localStringBuilder.append(" number=");
        localStringBuilder.append(this.zzf);
        localStringBuilder.append(" name=");
        localStringBuilder.append(name());
        localStringBuilder.append('>');
        return localStringBuilder.toString();
      }
      
      public final int zza()
      {
        return this.zzf;
      }
    }
    
    public static enum zzd
      implements zzep
    {
      private static final zzeo<zzd> zze = new zzci();
      private final int zzf;
      
      static
      {
        zzd localzzd1 = new zzd("MODE_UNKNOWN", 0, 0);
        zza = localzzd1;
        zzd localzzd2 = new zzd("MODE_ACCURATE", 1, 1);
        zzb = localzzd2;
        zzd localzzd3 = new zzd("MODE_FAST", 2, 2);
        zzc = localzzd3;
        zzd localzzd4 = new zzd("MODE_SELFIE", 3, 3);
        zzd = localzzd4;
        zzg = new zzd[] { localzzd1, localzzd2, localzzd3, localzzd4 };
      }
      
      private zzd(int paramInt)
      {
        this.zzf = paramInt;
      }
      
      public static zzer zzb()
      {
        return zzch.zza;
      }
      
      public final String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder("<");
        localStringBuilder.append(zzd.class.getName());
        localStringBuilder.append('@');
        localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        localStringBuilder.append(" number=");
        localStringBuilder.append(this.zzf);
        localStringBuilder.append(" name=");
        localStringBuilder.append(name());
        localStringBuilder.append('>');
        return localStringBuilder.toString();
      }
      
      public final int zza()
      {
        return this.zzf;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzcb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */