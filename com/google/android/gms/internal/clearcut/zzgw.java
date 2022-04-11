package com.google.android.gms.internal.clearcut;

import java.util.List;
import java.util.Objects;

public final class zzgw
{
  public static final class zza
    extends zzcg<zza, zza>
    implements zzdq
  {
    private static volatile zzdz<zza> zzbg;
    private static final zza zzbir;
    private zzcn<zzb> zzbiq = zzcg.zzbb();
    
    static
    {
      zza localzza = new zza();
      zzbir = localzza;
      zzcg.zza(zza.class, localzza);
    }
    
    public static zza zzft()
    {
      return zzbir;
    }
    
    public static zza zzi(byte[] paramArrayOfByte)
      throws zzco
    {
      return (zza)zzcg.zzb(zzbir, paramArrayOfByte);
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzgx.zzba[(paramInt - 1)])
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
              ((zzcg.zzb)paramObject1).<init>(zzbir);
              zzbg = (zzdz)paramObject1;
            }
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzbir;
      case 3: 
        return zzcg.zza(zzbir, "\001\001\000\000\001\001\001\002\000\001\000\001\033", new Object[] { "zzbiq", zzb.class });
      case 2: 
        return new zza(null);
      }
      return new zza();
    }
    
    public final List<zzb> zzfs()
    {
      return this.zzbiq;
    }
    
    public static final class zza
      extends zzcg.zza<zzgw.zza, zza>
      implements zzdq
    {
      private zza()
      {
        super();
      }
    }
    
    public static final class zzb
      extends zzcg<zzb, zza>
      implements zzdq
    {
      private static volatile zzdz<zzb> zzbg;
      private static final zzb zzbiv;
      private int zzbb;
      private String zzbis = "";
      private long zzbit;
      private long zzbiu;
      private int zzya;
      
      static
      {
        zzb localzzb = new zzb();
        zzbiv = localzzb;
        zzcg.zza(zzb.class, localzzb);
      }
      
      public static zza zzfz()
      {
        return (zza)zzbiv.zza(zzcg.zzg.zzkh, null, null);
      }
      
      private final void zzm(String paramString)
      {
        Objects.requireNonNull(paramString);
        this.zzbb |= 0x2;
        this.zzbis = paramString;
      }
      
      private final void zzp(long paramLong)
      {
        this.zzbb |= 0x4;
        this.zzbit = paramLong;
      }
      
      private final void zzq(long paramLong)
      {
        this.zzbb |= 0x8;
        this.zzbiu = paramLong;
      }
      
      public final int getEventCode()
      {
        return this.zzya;
      }
      
      protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
      {
        switch (zzgx.zzba[(paramInt - 1)])
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
                ((zzcg.zzb)paramObject1).<init>(zzbiv);
                zzbg = (zzdz)paramObject1;
              }
            }
            finally {}
          }
          return paramObject1;
        case 4: 
          return zzbiv;
        case 3: 
          return zzcg.zza(zzbiv, "\001\004\000\001\001\004\004\005\000\000\000\001\004\000\002\b\001\003\002\002\004\002\003", new Object[] { "zzbb", "zzya", "zzbis", "zzbit", "zzbiu" });
        case 2: 
          return new zza(null);
        }
        return new zzb();
      }
      
      public final boolean zzfv()
      {
        return (this.zzbb & 0x1) == 1;
      }
      
      public final String zzfw()
      {
        return this.zzbis;
      }
      
      public final long zzfx()
      {
        return this.zzbit;
      }
      
      public final long zzfy()
      {
        return this.zzbiu;
      }
      
      public static final class zza
        extends zzcg.zza<zzgw.zza.zzb, zza>
        implements zzdq
      {
        private zza()
        {
          super();
        }
        
        public final zza zzn(String paramString)
        {
          zzbf();
          zzgw.zza.zzb.zza((zzgw.zza.zzb)this.zzjt, paramString);
          return this;
        }
        
        public final zza zzr(long paramLong)
        {
          zzbf();
          zzgw.zza.zzb.zza((zzgw.zza.zzb)this.zzjt, paramLong);
          return this;
        }
        
        public final zza zzs(long paramLong)
        {
          zzbf();
          zzgw.zza.zzb.zzb((zzgw.zza.zzb)this.zzjt, paramLong);
          return this;
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzgw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */