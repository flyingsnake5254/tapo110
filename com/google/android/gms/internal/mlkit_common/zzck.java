package com.google.android.gms.internal.mlkit_common;

public final class zzck
{
  public static final class zza
    extends zzez<zza, zza>
    implements zzgj
  {
    private static final zzff<Integer, zzdm> zzd = new zzcl();
    private static final zza zze;
    private static volatile zzgr<zza> zzf;
    private zzfg zzc = zzez.zzk();
    
    static
    {
      zza localzza = new zza();
      zze = localzza;
      zzez.zza(zza.class, localzza);
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzcj.zza[(paramInt - 1)])
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
              paramObject1 = new com/google/android/gms/internal/mlkit_common/zzez$zzc;
              ((zzez.zzc)paramObject1).<init>(zze);
              zzf = (zzgr)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zze;
      case 3: 
        paramObject1 = zzdm.zzb();
        return zzez.zza(zze, "\001\001\000\000\001\001\001\000\001\000\001\036", new Object[] { "zzc", paramObject1 });
      case 2: 
        return new zza(null);
      }
      return new zza();
    }
    
    public static final class zza
      extends zzez.zza<zzck.zza, zza>
      implements zzgj
    {
      private zza()
      {
        super();
      }
    }
  }
  
  public static final class zzb
    extends zzez<zzb, zzb>
    implements zzgj
  {
    private static final zzb zzj;
    private static volatile zzgr<zzb> zzk;
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
      zzez.zza(zzb.class, localzzb);
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzcj.zza[(paramInt - 1)])
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
              paramObject1 = new com/google/android/gms/internal/mlkit_common/zzez$zzc;
              ((zzez.zzc)paramObject1).<init>(zzj);
              zzk = (zzgr)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzj;
      case 3: 
        zzfd localzzfd = zzd.zzb();
        paramObject1 = zzc.zzb();
        paramObject2 = zza.zzb();
        return zzez.zza(zzj, "\001\006\000\001\001\006\006\000\000\000\001ဌ\000\002ဌ\001\003ဌ\002\004ဇ\003\005ဇ\004\006ခ\005", new Object[] { "zzc", "zzd", localzzfd, "zze", paramObject1, "zzf", paramObject2, "zzg", "zzh", "zzi" });
      case 2: 
        return new zzb(null);
      }
      return new zzb();
    }
    
    public static enum zza
      implements zzfb
    {
      private static final zzfe<zza> zzd = new zzcn();
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
      
      public static zzfd zzb()
      {
        return zzcm.zza;
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
      extends zzez.zza<zzck.zzb, zzb>
      implements zzgj
    {
      private zzb()
      {
        super();
      }
    }
    
    public static enum zzc
      implements zzfb
    {
      private static final zzfe<zzc> zze = new zzco();
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
      
      public static zzfd zzb()
      {
        return zzcp.zza;
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
      implements zzfb
    {
      private static final zzfe<zzd> zze = new zzcr();
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
      
      public static zzfd zzb()
      {
        return zzcq.zza;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */