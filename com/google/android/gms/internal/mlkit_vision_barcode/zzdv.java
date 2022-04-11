package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;

public final class zzdv
{
  public static final class zza
    extends zzga<zza, zza>
    implements zzhm
  {
    private static final zzgi<Integer, zzen> zzd = new zzdw();
    private static final zza zze;
    private static volatile zzhu<zza> zzf;
    private zzgj zzc = zzga.zzk();
    
    static
    {
      zza localzza = new zza();
      zze = localzza;
      zzga.zza(zza.class, localzza);
    }
    
    public static zza zza()
    {
      return (zza)zze.zzh();
    }
    
    private final void zza(Iterable<? extends zzen> paramIterable)
    {
      Object localObject = this.zzc;
      if (!((zzgl)localObject).zza()) {
        this.zzc = zzga.zza((zzgj)localObject);
      }
      localObject = paramIterable.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramIterable = (zzen)((Iterator)localObject).next();
        this.zzc.zzd(paramIterable.zza());
      }
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzdu.zza[(paramInt - 1)])
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
              paramObject1 = new com/google/android/gms/internal/mlkit_vision_barcode/zzga$zza;
              ((zzga.zza)paramObject1).<init>(zze);
              zzf = (zzhu)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zze;
      case 3: 
        paramObject1 = zzen.zzb();
        return zzga.zza(zze, "\001\001\000\000\001\001\001\000\001\000\001\036", new Object[] { "zzc", paramObject1 });
      case 2: 
        return new zza(null);
      }
      return new zza();
    }
    
    public static final class zza
      extends zzga.zzb<zzdv.zza, zza>
      implements zzhm
    {
      private zza()
      {
        super();
      }
      
      public final zza zza(Iterable<? extends zzen> paramIterable)
      {
        if (this.zzb)
        {
          zzc();
          this.zzb = false;
        }
        zzdv.zza.zza((zzdv.zza)this.zza, paramIterable);
        return this;
      }
    }
  }
  
  public static final class zzb
    extends zzga<zzb, zzb>
    implements zzhm
  {
    private static final zzb zzj;
    private static volatile zzhu<zzb> zzk;
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
      zzga.zza(zzb.class, localzzb);
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzdu.zza[(paramInt - 1)])
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
              paramObject1 = new com/google/android/gms/internal/mlkit_vision_barcode/zzga$zza;
              ((zzga.zza)paramObject1).<init>(zzj);
              zzk = (zzhu)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzj;
      case 3: 
        zzgh localzzgh = zzd.zzb();
        paramObject1 = zzc.zzb();
        paramObject2 = zza.zzb();
        return zzga.zza(zzj, "\001\006\000\001\001\006\006\000\000\000\001ဌ\000\002ဌ\001\003ဌ\002\004ဇ\003\005ဇ\004\006ခ\005", new Object[] { "zzc", "zzd", localzzgh, "zze", paramObject1, "zzf", paramObject2, "zzg", "zzh", "zzi" });
      case 2: 
        return new zzb(null);
      }
      return new zzb();
    }
    
    public static enum zza
      implements zzgf
    {
      private static final zzge<zza> zzd = new zzdy();
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
      
      public static zzgh zzb()
      {
        return zzdx.zza;
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
      extends zzga.zzb<zzdv.zzb, zzb>
      implements zzhm
    {
      private zzb()
      {
        super();
      }
    }
    
    public static enum zzc
      implements zzgf
    {
      private static final zzge<zzc> zze = new zzdz();
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
      
      public static zzgh zzb()
      {
        return zzea.zza;
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
      implements zzgf
    {
      private static final zzge<zzd> zze = new zzec();
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
      
      public static zzgh zzb()
      {
        return zzeb.zza;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzdv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */