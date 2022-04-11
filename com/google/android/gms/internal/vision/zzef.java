package com.google.android.gms.internal.vision;

import java.util.List;

public final class zzef
{
  public static final class zza
    extends zzgx<zza, zza>
    implements zzij
  {
    private static volatile zziq<zza> zzbk;
    private static final zza zzmy;
    private int zzbm;
    private String zzmw = "";
    private String zzmx = "";
    
    static
    {
      zza localzza = new zza();
      zzmy = localzza;
      zzgx.zza(zza.class, localzza);
    }
    
    public static zza zzck()
    {
      return (zza)zzmy.zzgf();
    }
    
    private final void zzn(String paramString)
    {
      paramString.getClass();
      this.zzbm |= 0x1;
      this.zzmw = paramString;
    }
    
    private final void zzo(String paramString)
    {
      paramString.getClass();
      this.zzbm |= 0x2;
      this.zzmx = paramString;
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzee.zzbl[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject2 = zzbk;
        paramObject1 = paramObject2;
        if (paramObject2 == null) {
          try
          {
            paramObject2 = zzbk;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new com/google/android/gms/internal/vision/zzgx$zzc;
              ((zzgx.zzc)paramObject1).<init>(zzmy);
              zzbk = (zziq)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzmy;
      case 3: 
        return zzgx.zza(zzmy, "\001\002\000\001\001\002\002\000\000\000\001ဈ\000\002ဈ\001", new Object[] { "zzbm", "zzmw", "zzmx" });
      case 2: 
        return new zza(null);
      }
      return new zza();
    }
    
    public static final class zza
      extends zzgx.zza<zzef.zza, zza>
      implements zzij
    {
      private zza()
      {
        super();
      }
      
      public final zza zzl(String paramString)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zza.zza((zzef.zza)this.zzwq, paramString);
        return this;
      }
      
      public final zza zzm(String paramString)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zza.zzb((zzef.zza)this.zzwq, paramString);
        return this;
      }
    }
  }
  
  public static final class zzb
    extends zzgx<zzb, zza>
    implements zzij
  {
    private static volatile zziq<zzb> zzbk;
    private static final zzhf<Integer, zzet> zzna = new zzeg();
    private static final zzb zznb;
    private zzhc zzmz = zzgx.zzgh();
    
    static
    {
      zzb localzzb = new zzb();
      zznb = localzzb;
      zzgx.zza(zzb.class, localzzb);
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzee.zzbl[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject2 = zzbk;
        paramObject1 = paramObject2;
        if (paramObject2 == null) {
          try
          {
            paramObject2 = zzbk;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new com/google/android/gms/internal/vision/zzgx$zzc;
              ((zzgx.zzc)paramObject1).<init>(zznb);
              zzbk = (zziq)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zznb;
      case 3: 
        paramObject1 = zzet.zzai();
        return zzgx.zza(zznb, "\001\001\000\000\001\001\001\000\001\000\001\036", new Object[] { "zzmz", paramObject1 });
      case 2: 
        return new zza(null);
      }
      return new zzb();
    }
    
    public static final class zza
      extends zzgx.zza<zzef.zzb, zza>
      implements zzij
    {
      private zza()
      {
        super();
      }
    }
  }
  
  public static final class zzc
    extends zzgx<zzc, zza>
    implements zzij
  {
    private static volatile zziq<zzc> zzbk;
    private static final zzc zznf;
    private int zzbm;
    private int zznc;
    private int zznd;
    private String zzne = "";
    
    static
    {
      zzc localzzc = new zzc();
      zznf = localzzc;
      zzgx.zza(zzc.class, localzzc);
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzee.zzbl[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject2 = zzbk;
        paramObject1 = paramObject2;
        if (paramObject2 == null) {
          try
          {
            paramObject2 = zzbk;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new com/google/android/gms/internal/vision/zzgx$zzc;
              ((zzgx.zzc)paramObject1).<init>(zznf);
              zzbk = (zziq)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zznf;
      case 3: 
        paramObject2 = zzet.zzai();
        paramObject1 = zzex.zzai();
        return zzgx.zza(zznf, "\001\003\000\001\001\003\003\000\000\000\001ဌ\000\002ဌ\001\003ဈ\002", new Object[] { "zzbm", "zznc", paramObject2, "zznd", paramObject1, "zzne" });
      case 2: 
        return new zza(null);
      }
      return new zzc();
    }
    
    public static final class zza
      extends zzgx.zza<zzef.zzc, zza>
      implements zzij
    {
      private zza()
      {
        super();
      }
    }
  }
  
  public static final class zzd
    extends zzgx<zzd, zza>
    implements zzij
  {
    private static volatile zziq<zzd> zzbk;
    private static final zzd zznh;
    private zzhe<zzef.zzm> zzng = zzgx.zzgi();
    
    static
    {
      zzd localzzd = new zzd();
      zznh = localzzd;
      zzgx.zza(zzd.class, localzzd);
    }
    
    private final void zza(zzef.zzm paramzzm)
    {
      paramzzm.getClass();
      zzhe localzzhe = this.zzng;
      if (!localzzhe.zzdp()) {
        this.zzng = zzgx.zza(localzzhe);
      }
      this.zzng.add(paramzzm);
    }
    
    public static zza zzco()
    {
      return (zza)zznh.zzgf();
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzee.zzbl[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject2 = zzbk;
        paramObject1 = paramObject2;
        if (paramObject2 == null) {
          try
          {
            paramObject2 = zzbk;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new com/google/android/gms/internal/vision/zzgx$zzc;
              ((zzgx.zzc)paramObject1).<init>(zznh);
              zzbk = (zziq)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zznh;
      case 3: 
        return zzgx.zza(zznh, "\001\001\000\000\001\001\001\000\001\000\001\033", new Object[] { "zzng", zzef.zzm.class });
      case 2: 
        return new zza(null);
      }
      return new zzd();
    }
    
    public static final class zza
      extends zzgx.zza<zzef.zzd, zza>
      implements zzij
    {
      private zza()
      {
        super();
      }
      
      public final zza zzb(zzef.zzm paramzzm)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzd.zza((zzef.zzd)this.zzwq, paramzzm);
        return this;
      }
    }
  }
  
  public static final class zze
    extends zzgx<zze, zzb>
    implements zzij
  {
    private static volatile zziq<zze> zzbk;
    private static final zze zznq;
    private int zzbm;
    private String zzni = "";
    private boolean zznj;
    private int zznk;
    private long zznl;
    private long zznm;
    private long zznn;
    private String zzno = "";
    private boolean zznp;
    
    static
    {
      zze localzze = new zze();
      zznq = localzze;
      zzgx.zza(zze.class, localzze);
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzee.zzbl[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject2 = zzbk;
        paramObject1 = paramObject2;
        if (paramObject2 == null) {
          try
          {
            paramObject2 = zzbk;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new com/google/android/gms/internal/vision/zzgx$zzc;
              ((zzgx.zzc)paramObject1).<init>(zznq);
              zzbk = (zziq)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zznq;
      case 3: 
        paramObject1 = zza.zzai();
        return zzgx.zza(zznq, "\001\b\000\001\001\b\b\000\000\000\001ဈ\000\002ဇ\001\003ဌ\002\004ဂ\003\005ဂ\004\006ဂ\005\007ဈ\006\bဇ\007", new Object[] { "zzbm", "zzni", "zznj", "zznk", paramObject1, "zznl", "zznm", "zznn", "zzno", "zznp" });
      case 2: 
        return new zzb(null);
      }
      return new zze();
    }
    
    public static enum zza
      implements zzhb
    {
      private static final zzha<zza> zzhl = new zzei();
      private final int value;
      
      static
      {
        zza localzza1 = new zza("REASON_UNKNOWN", 0, 0);
        zznr = localzza1;
        zza localzza2 = new zza("REASON_MISSING", 1, 1);
        zzns = localzza2;
        zza localzza3 = new zza("REASON_UPGRADE", 2, 2);
        zznt = localzza3;
        zza localzza4 = new zza("REASON_INVALID", 3, 3);
        zznu = localzza4;
        zznv = new zza[] { localzza1, localzza2, localzza3, localzza4 };
      }
      
      private zza(int paramInt)
      {
        this.value = paramInt;
      }
      
      public static zzhd zzai()
      {
        return zzeh.zzho;
      }
      
      public static zza zzt(int paramInt)
      {
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            if (paramInt != 2)
            {
              if (paramInt != 3) {
                return null;
              }
              return zznu;
            }
            return zznt;
          }
          return zzns;
        }
        return zznr;
      }
      
      public final String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder("<");
        localStringBuilder.append(zza.class.getName());
        localStringBuilder.append('@');
        localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        localStringBuilder.append(" number=");
        localStringBuilder.append(this.value);
        localStringBuilder.append(" name=");
        localStringBuilder.append(name());
        localStringBuilder.append('>');
        return localStringBuilder.toString();
      }
      
      public final int zzah()
      {
        return this.value;
      }
    }
    
    public static final class zzb
      extends zzgx.zza<zzef.zze, zzb>
      implements zzij
    {
      private zzb()
      {
        super();
      }
    }
  }
  
  public static final class zzf
    extends zzgx<zzf, zza>
    implements zzij
  {
    private static volatile zziq<zzf> zzbk;
    private static final zzf zzoe;
    private int zzbm;
    private String zznw = "";
    private String zznx = "";
    private zzhe<String> zzny = zzgx.zzgi();
    private int zznz;
    private String zzoa = "";
    private long zzob;
    private long zzoc;
    private zzhe<zzef.zzn> zzod = zzgx.zzgi();
    
    static
    {
      zzf localzzf = new zzf();
      zzoe = localzzf;
      zzgx.zza(zzf.class, localzzf);
    }
    
    private final void setName(String paramString)
    {
      paramString.getClass();
      this.zzbm |= 0x1;
      this.zznw = paramString;
    }
    
    public static zza zzcr()
    {
      return (zza)zzoe.zzgf();
    }
    
    private final void zzd(Iterable<? extends zzef.zzn> paramIterable)
    {
      zzhe localzzhe = this.zzod;
      if (!localzzhe.zzdp()) {
        this.zzod = zzgx.zza(localzzhe);
      }
      zzey.zza(paramIterable, this.zzod);
    }
    
    private final void zzf(long paramLong)
    {
      this.zzbm |= 0x10;
      this.zzob = paramLong;
    }
    
    private final void zzg(long paramLong)
    {
      this.zzbm |= 0x20;
      this.zzoc = paramLong;
    }
    
    private final void zzr(String paramString)
    {
      paramString.getClass();
      this.zzbm |= 0x8;
      this.zzoa = paramString;
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzee.zzbl[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject2 = zzbk;
        paramObject1 = paramObject2;
        if (paramObject2 == null) {
          try
          {
            paramObject2 = zzbk;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new com/google/android/gms/internal/vision/zzgx$zzc;
              ((zzgx.zzc)paramObject1).<init>(zzoe);
              zzbk = (zziq)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzoe;
      case 3: 
        paramObject1 = zzb.zzai();
        return zzgx.zza(zzoe, "\001\b\000\001\001\b\b\000\002\000\001ဈ\000\002ဈ\001\003\032\004ဌ\002\005ဈ\003\006ဂ\004\007ဂ\005\b\033", new Object[] { "zzbm", "zznw", "zznx", "zzny", "zznz", paramObject1, "zzoa", "zzob", "zzoc", "zzod", zzef.zzn.class });
      case 2: 
        return new zza(null);
      }
      return new zzf();
    }
    
    public static final class zza
      extends zzgx.zza<zzef.zzf, zza>
      implements zzij
    {
      private zza()
      {
        super();
      }
      
      public final zza zzc(Iterable<? extends zzef.zzn> paramIterable)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzf.zza((zzef.zzf)this.zzwq, paramIterable);
        return this;
      }
      
      public final zza zzd(long paramLong)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzf.zza((zzef.zzf)this.zzwq, paramLong);
        return this;
      }
      
      public final zza zze(long paramLong)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzf.zzb((zzef.zzf)this.zzwq, paramLong);
        return this;
      }
      
      public final zza zzp(String paramString)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzf.zza((zzef.zzf)this.zzwq, paramString);
        return this;
      }
      
      public final zza zzq(String paramString)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzf.zzb((zzef.zzf)this.zzwq, paramString);
        return this;
      }
    }
    
    public static enum zzb
      implements zzhb
    {
      private static final zzha<zzb> zzhl = new zzej();
      private final int value;
      
      static
      {
        zzb localzzb1 = new zzb("RESULT_UNKNOWN", 0, 0);
        zzof = localzzb1;
        zzb localzzb2 = new zzb("RESULT_SUCCESS", 1, 1);
        zzog = localzzb2;
        zzb localzzb3 = new zzb("RESULT_FAIL", 2, 2);
        zzoh = localzzb3;
        zzb localzzb4 = new zzb("RESULT_SKIPPED", 3, 3);
        zzoi = localzzb4;
        zzoj = new zzb[] { localzzb1, localzzb2, localzzb3, localzzb4 };
      }
      
      private zzb(int paramInt)
      {
        this.value = paramInt;
      }
      
      public static zzhd zzai()
      {
        return zzek.zzho;
      }
      
      public static zzb zzu(int paramInt)
      {
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            if (paramInt != 2)
            {
              if (paramInt != 3) {
                return null;
              }
              return zzoi;
            }
            return zzoh;
          }
          return zzog;
        }
        return zzof;
      }
      
      public final String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder("<");
        localStringBuilder.append(zzb.class.getName());
        localStringBuilder.append('@');
        localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        localStringBuilder.append(" number=");
        localStringBuilder.append(this.value);
        localStringBuilder.append(" name=");
        localStringBuilder.append(name());
        localStringBuilder.append('>');
        return localStringBuilder.toString();
      }
      
      public final int zzah()
      {
        return this.value;
      }
    }
  }
  
  public static final class zzg
    extends zzgx<zzg, zzb>
    implements zzij
  {
    private static volatile zziq<zzg> zzbk;
    private static final zzg zzoo;
    private int zzbm;
    private float zzkj;
    private boolean zzkn;
    private int zzok;
    private int zzol;
    private int zzom;
    private boolean zzon;
    
    static
    {
      zzg localzzg = new zzg();
      zzoo = localzzg;
      zzgx.zza(zzg.class, localzzg);
    }
    
    private final void zza(zza paramzza)
    {
      this.zzom = paramzza.zzah();
      this.zzbm |= 0x4;
    }
    
    private final void zza(zzc paramzzc)
    {
      this.zzol = paramzzc.zzah();
      this.zzbm |= 0x2;
    }
    
    private final void zza(zzd paramzzd)
    {
      this.zzok = paramzzd.zzah();
      this.zzbm |= 0x1;
    }
    
    private final void zza(boolean paramBoolean)
    {
      this.zzbm |= 0x8;
      this.zzkn = paramBoolean;
    }
    
    public static zzb zzct()
    {
      return (zzb)zzoo.zzgf();
    }
    
    private final void zzd(float paramFloat)
    {
      this.zzbm |= 0x20;
      this.zzkj = paramFloat;
    }
    
    private final void zzg(boolean paramBoolean)
    {
      this.zzbm |= 0x10;
      this.zzon = paramBoolean;
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzee.zzbl[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject2 = zzbk;
        paramObject1 = paramObject2;
        if (paramObject2 == null) {
          try
          {
            paramObject2 = zzbk;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new com/google/android/gms/internal/vision/zzgx$zzc;
              ((zzgx.zzc)paramObject1).<init>(zzoo);
              zzbk = (zziq)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzoo;
      case 3: 
        paramObject1 = zzd.zzai();
        paramObject2 = zzc.zzai();
        zzhd localzzhd = zza.zzai();
        return zzgx.zza(zzoo, "\001\006\000\001\001\006\006\000\000\000\001ဌ\000\002ဌ\001\003ဌ\002\004ဇ\003\005ဇ\004\006ခ\005", new Object[] { "zzbm", "zzok", paramObject1, "zzol", paramObject2, "zzom", localzzhd, "zzkn", "zzon", "zzkj" });
      case 2: 
        return new zzb(null);
      }
      return new zzg();
    }
    
    public static enum zza
      implements zzhb
    {
      private static final zzha<zza> zzhl = new zzem();
      private final int value;
      
      static
      {
        zza localzza1 = new zza("CLASSIFICATION_UNKNOWN", 0, 0);
        zzop = localzza1;
        zza localzza2 = new zza("CLASSIFICATION_NONE", 1, 1);
        zzoq = localzza2;
        zza localzza3 = new zza("CLASSIFICATION_ALL", 2, 2);
        zzor = localzza3;
        zzos = new zza[] { localzza1, localzza2, localzza3 };
      }
      
      private zza(int paramInt)
      {
        this.value = paramInt;
      }
      
      public static zzhd zzai()
      {
        return zzel.zzho;
      }
      
      public static zza zzv(int paramInt)
      {
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            if (paramInt != 2) {
              return null;
            }
            return zzor;
          }
          return zzoq;
        }
        return zzop;
      }
      
      public final String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder("<");
        localStringBuilder.append(zza.class.getName());
        localStringBuilder.append('@');
        localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        localStringBuilder.append(" number=");
        localStringBuilder.append(this.value);
        localStringBuilder.append(" name=");
        localStringBuilder.append(name());
        localStringBuilder.append('>');
        return localStringBuilder.toString();
      }
      
      public final int zzah()
      {
        return this.value;
      }
    }
    
    public static final class zzb
      extends zzgx.zza<zzef.zzg, zzb>
      implements zzij
    {
      private zzb()
      {
        super();
      }
      
      public final zzb zzb(zzef.zzg.zza paramzza)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzg.zza((zzef.zzg)this.zzwq, paramzza);
        return this;
      }
      
      public final zzb zzb(zzef.zzg.zzc paramzzc)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzg.zza((zzef.zzg)this.zzwq, paramzzc);
        return this;
      }
      
      public final zzb zzb(zzef.zzg.zzd paramzzd)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzg.zza((zzef.zzg)this.zzwq, paramzzd);
        return this;
      }
      
      public final zzb zzf(float paramFloat)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzg.zza((zzef.zzg)this.zzwq, paramFloat);
        return this;
      }
      
      public final zzb zzh(boolean paramBoolean)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzg.zza((zzef.zzg)this.zzwq, paramBoolean);
        return this;
      }
      
      public final zzb zzi(boolean paramBoolean)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzg.zzb((zzef.zzg)this.zzwq, paramBoolean);
        return this;
      }
    }
    
    public static enum zzc
      implements zzhb
    {
      private static final zzha<zzc> zzhl = new zzen();
      private final int value;
      
      static
      {
        zzc localzzc1 = new zzc("LANDMARK_UNKNOWN", 0, 0);
        zzot = localzzc1;
        zzc localzzc2 = new zzc("LANDMARK_NONE", 1, 1);
        zzou = localzzc2;
        zzc localzzc3 = new zzc("LANDMARK_ALL", 2, 2);
        zzov = localzzc3;
        zzc localzzc4 = new zzc("LANDMARK_CONTOUR", 3, 3);
        zzow = localzzc4;
        zzox = new zzc[] { localzzc1, localzzc2, localzzc3, localzzc4 };
      }
      
      private zzc(int paramInt)
      {
        this.value = paramInt;
      }
      
      public static zzhd zzai()
      {
        return zzeo.zzho;
      }
      
      public static zzc zzw(int paramInt)
      {
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            if (paramInt != 2)
            {
              if (paramInt != 3) {
                return null;
              }
              return zzow;
            }
            return zzov;
          }
          return zzou;
        }
        return zzot;
      }
      
      public final String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder("<");
        localStringBuilder.append(zzc.class.getName());
        localStringBuilder.append('@');
        localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        localStringBuilder.append(" number=");
        localStringBuilder.append(this.value);
        localStringBuilder.append(" name=");
        localStringBuilder.append(name());
        localStringBuilder.append('>');
        return localStringBuilder.toString();
      }
      
      public final int zzah()
      {
        return this.value;
      }
    }
    
    public static enum zzd
      implements zzhb
    {
      private static final zzha<zzd> zzhl = new zzeq();
      private final int value;
      
      static
      {
        zzd localzzd1 = new zzd("MODE_UNKNOWN", 0, 0);
        zzoy = localzzd1;
        zzd localzzd2 = new zzd("MODE_ACCURATE", 1, 1);
        zzoz = localzzd2;
        zzd localzzd3 = new zzd("MODE_FAST", 2, 2);
        zzpa = localzzd3;
        zzd localzzd4 = new zzd("MODE_SELFIE", 3, 3);
        zzpb = localzzd4;
        zzpc = new zzd[] { localzzd1, localzzd2, localzzd3, localzzd4 };
      }
      
      private zzd(int paramInt)
      {
        this.value = paramInt;
      }
      
      public static zzhd zzai()
      {
        return zzep.zzho;
      }
      
      public static zzd zzx(int paramInt)
      {
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            if (paramInt != 2)
            {
              if (paramInt != 3) {
                return null;
              }
              return zzpb;
            }
            return zzpa;
          }
          return zzoz;
        }
        return zzoy;
      }
      
      public final String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder("<");
        localStringBuilder.append(zzd.class.getName());
        localStringBuilder.append('@');
        localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        localStringBuilder.append(" number=");
        localStringBuilder.append(this.value);
        localStringBuilder.append(" name=");
        localStringBuilder.append(name());
        localStringBuilder.append('>');
        return localStringBuilder.toString();
      }
      
      public final int zzah()
      {
        return this.value;
      }
    }
  }
  
  public static final class zzh
    extends zzgx<zzh, zza>
    implements zzij
  {
    private static volatile zziq<zzh> zzbk;
    private static final zzh zzpj;
    private int zzbm;
    private float zzpd;
    private float zzpe;
    private float zzpf;
    private float zzpg;
    private float zzph;
    private float zzpi;
    
    static
    {
      zzh localzzh = new zzh();
      zzpj = localzzh;
      zzgx.zza(zzh.class, localzzh);
    }
    
    public static zza zzcv()
    {
      return (zza)zzpj.zzgf();
    }
    
    private final void zzm(float paramFloat)
    {
      this.zzbm |= 0x1;
      this.zzpd = paramFloat;
    }
    
    private final void zzn(float paramFloat)
    {
      this.zzbm |= 0x2;
      this.zzpe = paramFloat;
    }
    
    private final void zzo(float paramFloat)
    {
      this.zzbm |= 0x4;
      this.zzpf = paramFloat;
    }
    
    private final void zzp(float paramFloat)
    {
      this.zzbm |= 0x8;
      this.zzpg = paramFloat;
    }
    
    private final void zzq(float paramFloat)
    {
      this.zzbm |= 0x10;
      this.zzph = paramFloat;
    }
    
    private final void zzr(float paramFloat)
    {
      this.zzbm |= 0x20;
      this.zzpi = paramFloat;
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzee.zzbl[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject2 = zzbk;
        paramObject1 = paramObject2;
        if (paramObject2 == null) {
          try
          {
            paramObject2 = zzbk;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new com/google/android/gms/internal/vision/zzgx$zzc;
              ((zzgx.zzc)paramObject1).<init>(zzpj);
              zzbk = (zziq)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzpj;
      case 3: 
        return zzgx.zza(zzpj, "\001\006\000\001\001\006\006\000\000\000\001ခ\000\002ခ\001\003ခ\002\004ခ\003\005ခ\004\006ခ\005", new Object[] { "zzbm", "zzpd", "zzpe", "zzpf", "zzpg", "zzph", "zzpi" });
      case 2: 
        return new zza(null);
      }
      return new zzh();
    }
    
    public static final class zza
      extends zzgx.zza<zzef.zzh, zza>
      implements zzij
    {
      private zza()
      {
        super();
      }
      
      public final zza zzg(float paramFloat)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzh.zza((zzef.zzh)this.zzwq, paramFloat);
        return this;
      }
      
      public final zza zzh(float paramFloat)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzh.zzb((zzef.zzh)this.zzwq, paramFloat);
        return this;
      }
      
      public final zza zzi(float paramFloat)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzh.zzc((zzef.zzh)this.zzwq, paramFloat);
        return this;
      }
      
      public final zza zzj(float paramFloat)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzh.zzd((zzef.zzh)this.zzwq, paramFloat);
        return this;
      }
      
      public final zza zzk(float paramFloat)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzh.zze((zzef.zzh)this.zzwq, paramFloat);
        return this;
      }
      
      public final zza zzl(float paramFloat)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzh.zzf((zzef.zzh)this.zzwq, paramFloat);
        return this;
      }
    }
  }
  
  public static final class zzi
    extends zzgx<zzi, zza>
    implements zzij
  {
    private static volatile zziq<zzi> zzbk;
    private static final zzi zzpn;
    private int zzbm;
    private zzef.zzj zzpk;
    private zzef.zzl zzpl;
    private zzhe<zzef.zzf> zzpm = zzgx.zzgi();
    
    static
    {
      zzi localzzi = new zzi();
      zzpn = localzzi;
      zzgx.zza(zzi.class, localzzi);
    }
    
    private final void zza(zzef.zzf paramzzf)
    {
      paramzzf.getClass();
      zzcx();
      this.zzpm.add(paramzzf);
    }
    
    private final void zzb(zzef.zzj paramzzj)
    {
      paramzzj.getClass();
      this.zzpk = paramzzj;
      this.zzbm |= 0x1;
    }
    
    private final void zzcx()
    {
      zzhe localzzhe = this.zzpm;
      if (!localzzhe.zzdp()) {
        this.zzpm = zzgx.zza(localzzhe);
      }
    }
    
    public static zza zzcy()
    {
      return (zza)zzpn.zzgf();
    }
    
    private final void zzf(Iterable<? extends zzef.zzf> paramIterable)
    {
      zzcx();
      zzey.zza(paramIterable, this.zzpm);
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzee.zzbl[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject2 = zzbk;
        paramObject1 = paramObject2;
        if (paramObject2 == null) {
          try
          {
            paramObject2 = zzbk;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new com/google/android/gms/internal/vision/zzgx$zzc;
              ((zzgx.zzc)paramObject1).<init>(zzpn);
              zzbk = (zziq)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzpn;
      case 3: 
        return zzgx.zza(zzpn, "\001\003\000\001\001\003\003\000\001\000\001ဉ\000\002ဉ\001\003\033", new Object[] { "zzbm", "zzpk", "zzpl", "zzpm", zzef.zzf.class });
      case 2: 
        return new zza(null);
      }
      return new zzi();
    }
    
    public static final class zza
      extends zzgx.zza<zzef.zzi, zza>
      implements zzij
    {
      private zza()
      {
        super();
      }
      
      public final zza zza(zzef.zzf.zza paramzza)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzi.zza((zzef.zzi)this.zzwq, (zzef.zzf)paramzza.zzgd());
        return this;
      }
      
      public final zza zza(zzef.zzj paramzzj)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzi.zza((zzef.zzi)this.zzwq, paramzzj);
        return this;
      }
      
      public final zza zze(Iterable<? extends zzef.zzf> paramIterable)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzi.zza((zzef.zzi)this.zzwq, paramIterable);
        return this;
      }
    }
  }
  
  public static final class zzj
    extends zzgx<zzj, zza>
    implements zzij
  {
    private static volatile zziq<zzj> zzbk;
    private static final zzj zzps;
    private int zzbm;
    private int zznc;
    private long zzpo;
    private long zzpp;
    private long zzpq;
    private long zzpr;
    
    static
    {
      zzj localzzj = new zzj();
      zzps = localzzj;
      zzgx.zza(zzj.class, localzzj);
    }
    
    public static zza zzda()
    {
      return (zza)zzps.zzgf();
    }
    
    private final void zzl(long paramLong)
    {
      this.zzbm |= 0x2;
      this.zzpo = paramLong;
    }
    
    private final void zzm(long paramLong)
    {
      this.zzbm |= 0x4;
      this.zzpp = paramLong;
    }
    
    private final void zzn(long paramLong)
    {
      this.zzbm |= 0x8;
      this.zzpq = paramLong;
    }
    
    private final void zzo(long paramLong)
    {
      this.zzbm |= 0x10;
      this.zzpr = paramLong;
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzee.zzbl[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject2 = zzbk;
        paramObject1 = paramObject2;
        if (paramObject2 == null) {
          try
          {
            paramObject2 = zzbk;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new com/google/android/gms/internal/vision/zzgx$zzc;
              ((zzgx.zzc)paramObject1).<init>(zzps);
              zzbk = (zziq)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzps;
      case 3: 
        paramObject1 = zzb.zzai();
        return zzgx.zza(zzps, "\001\005\000\001\001\005\005\000\000\000\001ဌ\000\002ဂ\001\003ဂ\002\004ဂ\004\005ဂ\003", new Object[] { "zzbm", "zznc", paramObject1, "zzpo", "zzpp", "zzpr", "zzpq" });
      case 2: 
        return new zza(null);
      }
      return new zzj();
    }
    
    public static final class zza
      extends zzgx.zza<zzef.zzj, zza>
      implements zzij
    {
      private zza()
      {
        super();
      }
      
      public final zza zzh(long paramLong)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzj.zza((zzef.zzj)this.zzwq, paramLong);
        return this;
      }
      
      public final zza zzi(long paramLong)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzj.zzb((zzef.zzj)this.zzwq, paramLong);
        return this;
      }
      
      public final zza zzj(long paramLong)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzj.zzc((zzef.zzj)this.zzwq, paramLong);
        return this;
      }
      
      public final zza zzk(long paramLong)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzj.zzd((zzef.zzj)this.zzwq, paramLong);
        return this;
      }
    }
    
    public static enum zzb
      implements zzhb
    {
      private static final zzha<zzb> zzhl = new zzer();
      private final int value;
      
      static
      {
        zzb localzzb1 = new zzb("FORMAT_UNKNOWN", 0, 0);
        zzpt = localzzb1;
        zzb localzzb2 = new zzb("FORMAT_LUMINANCE", 1, 1);
        zzpu = localzzb2;
        zzb localzzb3 = new zzb("FORMAT_RGB8", 2, 2);
        zzpv = localzzb3;
        zzb localzzb4 = new zzb("FORMAT_MONOCHROME", 3, 3);
        zzpw = localzzb4;
        zzpx = new zzb[] { localzzb1, localzzb2, localzzb3, localzzb4 };
      }
      
      private zzb(int paramInt)
      {
        this.value = paramInt;
      }
      
      public static zzhd zzai()
      {
        return zzes.zzho;
      }
      
      public static zzb zzy(int paramInt)
      {
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            if (paramInt != 2)
            {
              if (paramInt != 3) {
                return null;
              }
              return zzpw;
            }
            return zzpv;
          }
          return zzpu;
        }
        return zzpt;
      }
      
      public final String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder("<");
        localStringBuilder.append(zzb.class.getName());
        localStringBuilder.append('@');
        localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        localStringBuilder.append(" number=");
        localStringBuilder.append(this.value);
        localStringBuilder.append(" name=");
        localStringBuilder.append(name());
        localStringBuilder.append('>');
        return localStringBuilder.toString();
      }
      
      public final int zzah()
      {
        return this.value;
      }
    }
  }
  
  public static final class zzk
    extends zzgx<zzk, zza>
    implements zzij
  {
    private static volatile zziq<zzk> zzbk;
    private static final zzk zzqc;
    private int zzbm;
    private String zzno = "";
    private String zznw = "";
    private long zzpy;
    private zzef.zza zzpz;
    private zzef.zzg zzqa;
    private zzef.zzb zzqb;
    
    static
    {
      zzk localzzk = new zzk();
      zzqc = localzzk;
      zzgx.zza(zzk.class, localzzk);
    }
    
    private final void setName(String paramString)
    {
      paramString.getClass();
      this.zzbm |= 0x1;
      this.zznw = paramString;
    }
    
    private final void zza(zzef.zza paramzza)
    {
      paramzza.getClass();
      this.zzpz = paramzza;
      this.zzbm |= 0x4;
    }
    
    private final void zza(zzef.zzg paramzzg)
    {
      paramzzg.getClass();
      this.zzqa = paramzzg;
      this.zzbm |= 0x10;
    }
    
    public static zza zzdc()
    {
      return (zza)zzqc.zzgf();
    }
    
    private final void zzp(long paramLong)
    {
      this.zzbm |= 0x2;
      this.zzpy = paramLong;
    }
    
    private final void zzs(String paramString)
    {
      paramString.getClass();
      this.zzbm |= 0x8;
      this.zzno = paramString;
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzee.zzbl[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject2 = zzbk;
        paramObject1 = paramObject2;
        if (paramObject2 == null) {
          try
          {
            paramObject2 = zzbk;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new com/google/android/gms/internal/vision/zzgx$zzc;
              ((zzgx.zzc)paramObject1).<init>(zzqc);
              zzbk = (zziq)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzqc;
      case 3: 
        return zzgx.zza(zzqc, "\001\006\000\001\001\021\006\000\000\000\001ဈ\000\002ဂ\001\003ဉ\002\006ဈ\003\020ဉ\004\021ဉ\005", new Object[] { "zzbm", "zznw", "zzpy", "zzpz", "zzno", "zzqa", "zzqb" });
      case 2: 
        return new zza(null);
      }
      return new zzk();
    }
    
    public static final class zza
      extends zzgx.zza<zzef.zzk, zza>
      implements zzij
    {
      private zza()
      {
        super();
      }
      
      public final zza zza(zzef.zzg.zzb paramzzb)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzk.zza((zzef.zzk)this.zzwq, (zzef.zzg)paramzzb.zzgd());
        return this;
      }
      
      public final zza zzb(zzef.zza paramzza)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzk.zza((zzef.zzk)this.zzwq, paramzza);
        return this;
      }
      
      public final zza zzq(long paramLong)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzk.zza((zzef.zzk)this.zzwq, paramLong);
        return this;
      }
      
      public final zza zzt(String paramString)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzk.zza((zzef.zzk)this.zzwq, paramString);
        return this;
      }
      
      public final zza zzu(String paramString)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzk.zzb((zzef.zzk)this.zzwq, paramString);
        return this;
      }
    }
  }
  
  public static final class zzl
    extends zzgx<zzl, zza>
    implements zzij
  {
    private static volatile zziq<zzl> zzbk;
    private static final zzl zzqd;
    private int zzbm;
    private long zzob;
    private long zzoc;
    
    static
    {
      zzl localzzl = new zzl();
      zzqd = localzzl;
      zzgx.zza(zzl.class, localzzl);
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzee.zzbl[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject2 = zzbk;
        paramObject1 = paramObject2;
        if (paramObject2 == null) {
          try
          {
            paramObject2 = zzbk;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new com/google/android/gms/internal/vision/zzgx$zzc;
              ((zzgx.zzc)paramObject1).<init>(zzqd);
              zzbk = (zziq)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzqd;
      case 3: 
        return zzgx.zza(zzqd, "\001\002\000\001\001\002\002\000\000\000\001ဂ\000\002ဂ\001", new Object[] { "zzbm", "zzob", "zzoc" });
      case 2: 
        return new zza(null);
      }
      return new zzl();
    }
    
    public static final class zza
      extends zzgx.zza<zzef.zzl, zza>
      implements zzij
    {
      private zza()
      {
        super();
      }
    }
  }
  
  public static final class zzm
    extends zzgx<zzm, zza>
    implements zzij
  {
    private static volatile zziq<zzm> zzbk;
    private static final zzm zzqg;
    private int zzbm;
    private int zzqe;
    private int zzqf;
    
    static
    {
      zzm localzzm = new zzm();
      zzqg = localzzm;
      zzgx.zza(zzm.class, localzzm);
    }
    
    private final void setX(int paramInt)
    {
      this.zzbm |= 0x1;
      this.zzqe = paramInt;
    }
    
    private final void setY(int paramInt)
    {
      this.zzbm |= 0x2;
      this.zzqf = paramInt;
    }
    
    public static zza zzdf()
    {
      return (zza)zzqg.zzgf();
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzee.zzbl[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject2 = zzbk;
        paramObject1 = paramObject2;
        if (paramObject2 == null) {
          try
          {
            paramObject2 = zzbk;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new com/google/android/gms/internal/vision/zzgx$zzc;
              ((zzgx.zzc)paramObject1).<init>(zzqg);
              zzbk = (zziq)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzqg;
      case 3: 
        return zzgx.zza(zzqg, "\001\002\000\001\001\002\002\000\000\000\001င\000\002င\001", new Object[] { "zzbm", "zzqe", "zzqf" });
      case 2: 
        return new zza(null);
      }
      return new zzm();
    }
    
    public static final class zza
      extends zzgx.zza<zzef.zzm, zza>
      implements zzij
    {
      private zza()
      {
        super();
      }
      
      public final zza zzaa(int paramInt)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzm.zzb((zzef.zzm)this.zzwq, paramInt);
        return this;
      }
      
      public final zza zzz(int paramInt)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzm.zza((zzef.zzm)this.zzwq, paramInt);
        return this;
      }
    }
  }
  
  public static final class zzn
    extends zzgx<zzn, zza>
    implements zzij
  {
    private static volatile zziq<zzn> zzbk;
    private static final zzn zzql;
    private int zzbm;
    private zzef.zzd zzqh;
    private int zzqi;
    private zzef.zzh zzqj;
    private zzef.zzc zzqk;
    
    static
    {
      zzn localzzn = new zzn();
      zzql = localzzn;
      zzgx.zza(zzn.class, localzzn);
    }
    
    private final void setId(int paramInt)
    {
      this.zzbm |= 0x2;
      this.zzqi = paramInt;
    }
    
    private final void zza(zzef.zzd paramzzd)
    {
      paramzzd.getClass();
      this.zzqh = paramzzd;
      this.zzbm |= 0x1;
    }
    
    private final void zza(zzef.zzh paramzzh)
    {
      paramzzh.getClass();
      this.zzqj = paramzzh;
      this.zzbm |= 0x4;
    }
    
    public static zza zzdh()
    {
      return (zza)zzql.zzgf();
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzee.zzbl[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject2 = zzbk;
        paramObject1 = paramObject2;
        if (paramObject2 == null) {
          try
          {
            paramObject2 = zzbk;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new com/google/android/gms/internal/vision/zzgx$zzc;
              ((zzgx.zzc)paramObject1).<init>(zzql);
              zzbk = (zziq)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzql;
      case 3: 
        return zzgx.zza(zzql, "\001\004\000\001\001\021\004\000\000\000\001ဉ\000\002င\001\020ဉ\002\021ဉ\003", new Object[] { "zzbm", "zzqh", "zzqi", "zzqj", "zzqk" });
      case 2: 
        return new zza(null);
      }
      return new zzn();
    }
    
    public static final class zza
      extends zzgx.zza<zzef.zzn, zza>
      implements zzij
    {
      private zza()
      {
        super();
      }
      
      public final zza zza(zzef.zzd.zza paramzza)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzn.zza((zzef.zzn)this.zzwq, (zzef.zzd)paramzza.zzgd());
        return this;
      }
      
      public final zza zzab(int paramInt)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzn.zza((zzef.zzn)this.zzwq, paramInt);
        return this;
      }
      
      public final zza zzb(zzef.zzh paramzzh)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzn.zza((zzef.zzn)this.zzwq, paramzzh);
        return this;
      }
    }
  }
  
  public static final class zzo
    extends zzgx<zzo, zza>
    implements zzij
  {
    private static volatile zziq<zzo> zzbk;
    private static final zzo zzqq;
    private int zzbm;
    private zzef.zze zzqm;
    private zzef.zzk zzqn;
    private zzef.zzi zzqo;
    private int zzqp;
    
    static
    {
      zzo localzzo = new zzo();
      zzqq = localzzo;
      zzgx.zza(zzo.class, localzzo);
    }
    
    private final void zza(zzef.zzi paramzzi)
    {
      paramzzi.getClass();
      this.zzqo = paramzzi;
      this.zzbm |= 0x4;
    }
    
    private final void zza(zzef.zzk paramzzk)
    {
      paramzzk.getClass();
      this.zzqn = paramzzk;
      this.zzbm |= 0x2;
    }
    
    public static zza zzdj()
    {
      return (zza)zzqq.zzgf();
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzee.zzbl[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject2 = zzbk;
        paramObject1 = paramObject2;
        if (paramObject2 == null) {
          try
          {
            paramObject2 = zzbk;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new com/google/android/gms/internal/vision/zzgx$zzc;
              ((zzgx.zzc)paramObject1).<init>(zzqq);
              zzbk = (zziq)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzqq;
      case 3: 
        return zzgx.zza(zzqq, "\001\004\000\001\001\004\004\000\000\000\001ဉ\000\002ဉ\001\003ဉ\002\004င\003", new Object[] { "zzbm", "zzqm", "zzqn", "zzqo", "zzqp" });
      case 2: 
        return new zza(null);
      }
      return new zzo();
    }
    
    public static final class zza
      extends zzgx.zza<zzef.zzo, zza>
      implements zzij
    {
      private zza()
      {
        super();
      }
      
      public final zza zza(zzef.zzk.zza paramzza)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzo.zza((zzef.zzo)this.zzwq, (zzef.zzk)paramzza.zzgd());
        return this;
      }
      
      public final zza zzb(zzef.zzi paramzzi)
      {
        if (this.zzwr)
        {
          zzfz();
          this.zzwr = false;
        }
        zzef.zzo.zza((zzef.zzo)this.zzwq, paramzzi);
        return this;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */