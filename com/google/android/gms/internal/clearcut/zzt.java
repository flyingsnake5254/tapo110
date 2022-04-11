package com.google.android.gms.internal.clearcut;

public final class zzt
{
  public static final class zza
    extends zzcg<zza, zza>
    implements zzdq
  {
    private static final zza zzbf;
    private static volatile zzdz<zza> zzbg;
    private int zzbb;
    private int zzbc;
    private int zzbd;
    private int zzbe;
    
    static
    {
      zza localzza = new zza();
      zzbf = localzza;
      zzcg.zza(zza.class, localzza);
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzu.zzba[(paramInt - 1)])
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
              ((zzcg.zzb)paramObject1).<init>(zzbf);
              zzbg = (zzdz)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzbf;
      case 3: 
        paramObject1 = zzc.zzd();
        zzck localzzck = zzb.zzd();
        paramObject2 = zzd.zzd();
        return zzcg.zza(zzbf, "\001\003\000\001\001\003\003\004\000\000\000\001\f\000\002\f\001\003\f\002", new Object[] { "zzbb", "zzbc", paramObject1, "zzbd", localzzck, "zzbe", paramObject2 });
      case 2: 
        return new zza(null);
      }
      return new zza();
    }
    
    public static final class zza
      extends zzcg.zza<zzt.zza, zza>
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
      private static final zzck<zzb> zzbq = new zzv();
      private final int value;
      
      static
      {
        zzb localzzb1 = new zzb("ARCH_UNKNOWN", 0, 0);
        zzbh = localzzb1;
        zzb localzzb2 = new zzb("ARCH_NON_NATIVE", 1, 1);
        zzbi = localzzb2;
        zzb localzzb3 = new zzb("ARCH_ARMV5", 2, 2);
        zzbj = localzzb3;
        zzb localzzb4 = new zzb("ARCH_ARMV7", 3, 4);
        zzbk = localzzb4;
        zzb localzzb5 = new zzb("ARCH_ARM64", 4, 5);
        zzbl = localzzb5;
        zzb localzzb6 = new zzb("ARCH_MIPS", 5, 6);
        zzbm = localzzb6;
        zzb localzzb7 = new zzb("ARCH_MIPS_64", 6, 7);
        zzbn = localzzb7;
        zzb localzzb8 = new zzb("ARCH_X86", 7, 8);
        zzbo = localzzb8;
        zzb localzzb9 = new zzb("ARCH_X86_64", 8, 9);
        zzbp = localzzb9;
        zzbr = new zzb[] { localzzb1, localzzb2, localzzb3, localzzb4, localzzb5, localzzb6, localzzb7, localzzb8, localzzb9 };
      }
      
      private zzb(int paramInt)
      {
        this.value = paramInt;
      }
      
      public static zzb zza(int paramInt)
      {
        switch (paramInt)
        {
        case 3: 
        default: 
          return null;
        case 9: 
          return zzbp;
        case 8: 
          return zzbo;
        case 7: 
          return zzbn;
        case 6: 
          return zzbm;
        case 5: 
          return zzbl;
        case 4: 
          return zzbk;
        case 2: 
          return zzbj;
        case 1: 
          return zzbi;
        }
        return zzbh;
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
    
    public static enum zzc
      implements zzcj
    {
      private static final zzck<zzc> zzbq = new zzw();
      private final int value;
      
      static
      {
        zzc localzzc1 = new zzc("BUILD_TYPE_UNKNOWN", 0, 0);
        zzbs = localzzc1;
        zzc localzzc2 = new zzc("BUILD_TYPE_PROD", 1, 1);
        zzbt = localzzc2;
        zzc localzzc3 = new zzc("BUILD_TYPE_INTERNAL", 2, 2);
        zzbu = localzzc3;
        zzc localzzc4 = new zzc("BUILD_TYPE_PRODLMP", 3, 3);
        zzbv = localzzc4;
        zzc localzzc5 = new zzc("BUILD_TYPE_THINGS", 4, 4);
        zzbw = localzzc5;
        zzc localzzc6 = new zzc("BUILD_TYPE_PRODMNC", 5, 5);
        zzbx = localzzc6;
        zzc localzzc7 = new zzc("BUILD_TYPE_WEARABLE", 6, 6);
        zzby = localzzc7;
        zzc localzzc8 = new zzc("BUILD_TYPE_AUTO", 7, 7);
        zzbz = localzzc8;
        zzc localzzc9 = new zzc("BUILD_TYPE_SIDEWINDERMNC", 8, 8);
        zzca = localzzc9;
        zzc localzzc10 = new zzc("BUILD_TYPE_ATV", 9, 9);
        zzcb = localzzc10;
        zzc localzzc11 = new zzc("BUILD_TYPE_PRODPIX", 10, 10);
        zzcc = localzzc11;
        zzc localzzc12 = new zzc("BUILD_TYPE_PRODPI", 11, 11);
        zzcd = localzzc12;
        zzce = new zzc[] { localzzc1, localzzc2, localzzc3, localzzc4, localzzc5, localzzc6, localzzc7, localzzc8, localzzc9, localzzc10, localzzc11, localzzc12 };
      }
      
      private zzc(int paramInt)
      {
        this.value = paramInt;
      }
      
      public static zzc zzc(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return null;
        case 11: 
          return zzcd;
        case 10: 
          return zzcc;
        case 9: 
          return zzcb;
        case 8: 
          return zzca;
        case 7: 
          return zzbz;
        case 6: 
          return zzby;
        case 5: 
          return zzbx;
        case 4: 
          return zzbw;
        case 3: 
          return zzbv;
        case 2: 
          return zzbu;
        case 1: 
          return zzbt;
        }
        return zzbs;
      }
      
      public static zzck<zzc> zzd()
      {
        return zzbq;
      }
      
      public final int zzc()
      {
        return this.value;
      }
    }
    
    public static enum zzd
      implements zzcj
    {
      private static final zzck<zzd> zzbq = new zzx();
      private final int value;
      
      static
      {
        zzd localzzd1 = new zzd("DENSITY_UNKNOWN", 0, 0);
        zzcf = localzzd1;
        zzd localzzd2 = new zzd("DENSITY_ALLDPI", 1, 1);
        zzcg = localzzd2;
        zzd localzzd3 = new zzd("DENSITY_LDPI", 2, 2);
        zzch = localzzd3;
        zzd localzzd4 = new zzd("DENSITY_MDPI", 3, 3);
        zzci = localzzd4;
        zzd localzzd5 = new zzd("DENSITY_TVDPI", 4, 4);
        zzcj = localzzd5;
        zzd localzzd6 = new zzd("DENSITY_HDPI", 5, 5);
        zzck = localzzd6;
        zzd localzzd7 = new zzd("DENSITY_XHDPI", 6, 7);
        zzcl = localzzd7;
        zzd localzzd8 = new zzd("DENSITY_DPI400", 7, 8);
        zzcm = localzzd8;
        zzd localzzd9 = new zzd("DENSITY_XXHDPI", 8, 9);
        zzcn = localzzd9;
        zzd localzzd10 = new zzd("DENSITY_XXXHDPI", 9, 10);
        zzco = localzzd10;
        zzcp = new zzd[] { localzzd1, localzzd2, localzzd3, localzzd4, localzzd5, localzzd6, localzzd7, localzzd8, localzzd9, localzzd10 };
      }
      
      private zzd(int paramInt)
      {
        this.value = paramInt;
      }
      
      public static zzck<zzd> zzd()
      {
        return zzbq;
      }
      
      public static zzd zzd(int paramInt)
      {
        switch (paramInt)
        {
        case 6: 
        default: 
          return null;
        case 10: 
          return zzco;
        case 9: 
          return zzcn;
        case 8: 
          return zzcm;
        case 7: 
          return zzcl;
        case 5: 
          return zzck;
        case 4: 
          return zzcj;
        case 3: 
          return zzci;
        case 2: 
          return zzch;
        case 1: 
          return zzcg;
        }
        return zzcf;
      }
      
      public final int zzc()
      {
        return this.value;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */