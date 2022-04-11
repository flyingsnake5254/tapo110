package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzfw
  extends zzkd<zzfw, zzfv>
  implements zzlj
{
  private static final zzfw zzaa;
  private String zzA = "";
  private long zzB;
  private int zzC;
  private String zzD = "";
  private String zzE = "";
  private boolean zzF;
  private zzkk<zzfk> zzG = zzkd.zzbE();
  private String zzH = "";
  private int zzI;
  private int zzJ;
  private int zzK;
  private String zzL = "";
  private long zzM;
  private long zzN;
  private String zzO = "";
  private String zzP = "";
  private int zzQ;
  private String zzR = "";
  private zzgb zzS;
  private zzki zzT = zzkd.zzbB();
  private long zzU;
  private long zzV;
  private String zzW = "";
  private String zzX = "";
  private int zzY;
  private boolean zzZ;
  private int zze;
  private int zzf;
  private int zzg;
  private zzkk<zzfo> zzh = zzkd.zzbE();
  private zzkk<zzgh> zzi = zzkd.zzbE();
  private long zzj;
  private long zzk;
  private long zzl;
  private long zzm;
  private long zzn;
  private String zzo = "";
  private String zzp = "";
  private String zzq = "";
  private String zzr = "";
  private int zzs;
  private String zzt = "";
  private String zzu = "";
  private String zzv = "";
  private long zzw;
  private long zzx;
  private String zzy = "";
  private boolean zzz;
  
  static
  {
    zzfw localzzfw = new zzfw();
    zzaa = localzzfw;
    zzkd.zzby(zzfw.class, localzzfw);
  }
  
  public static zzfv zzaj()
  {
    return (zzfv)zzaa.zzbt();
  }
  
  private final void zzbI()
  {
    zzkk localzzkk = this.zzh;
    if (!localzzkk.zza()) {
      this.zzh = zzkd.zzbF(localzzkk);
    }
  }
  
  private final void zzbJ()
  {
    zzkk localzzkk = this.zzi;
    if (!localzzkk.zza()) {
      this.zzi = zzkd.zzbF(localzzkk);
    }
  }
  
  public final String zzA()
  {
    return this.zzu;
  }
  
  public final String zzB()
  {
    return this.zzv;
  }
  
  public final boolean zzC()
  {
    return (this.zze & 0x4000) != 0;
  }
  
  public final long zzD()
  {
    return this.zzw;
  }
  
  public final boolean zzE()
  {
    return (this.zze & 0x8000) != 0;
  }
  
  public final long zzF()
  {
    return this.zzx;
  }
  
  public final String zzG()
  {
    return this.zzy;
  }
  
  public final boolean zzH()
  {
    return (this.zze & 0x20000) != 0;
  }
  
  public final boolean zzI()
  {
    return this.zzz;
  }
  
  public final String zzJ()
  {
    return this.zzA;
  }
  
  public final boolean zzK()
  {
    return (this.zze & 0x80000) != 0;
  }
  
  public final long zzL()
  {
    return this.zzB;
  }
  
  public final boolean zzM()
  {
    return (this.zze & 0x100000) != 0;
  }
  
  public final int zzN()
  {
    return this.zzC;
  }
  
  public final String zzO()
  {
    return this.zzD;
  }
  
  public final String zzP()
  {
    return this.zzE;
  }
  
  public final boolean zzQ()
  {
    return (this.zze & 0x800000) != 0;
  }
  
  public final boolean zzR()
  {
    return this.zzF;
  }
  
  public final List<zzfk> zzS()
  {
    return this.zzG;
  }
  
  public final String zzT()
  {
    return this.zzH;
  }
  
  public final boolean zzU()
  {
    return (this.zze & 0x2000000) != 0;
  }
  
  public final int zzV()
  {
    return this.zzI;
  }
  
  public final boolean zzW()
  {
    return (this.zze & 0x20000000) != 0;
  }
  
  public final long zzX()
  {
    return this.zzM;
  }
  
  public final boolean zzY()
  {
    return (this.zze & 0x40000000) != 0;
  }
  
  public final long zzZ()
  {
    return this.zzN;
  }
  
  public final boolean zza()
  {
    return (this.zze & 0x1) != 0;
  }
  
  public final String zzaa()
  {
    return this.zzO;
  }
  
  public final boolean zzab()
  {
    return (this.zzf & 0x2) != 0;
  }
  
  public final int zzac()
  {
    return this.zzQ;
  }
  
  public final String zzad()
  {
    return this.zzR;
  }
  
  public final boolean zzae()
  {
    return (this.zzf & 0x10) != 0;
  }
  
  public final long zzaf()
  {
    return this.zzU;
  }
  
  public final String zzag()
  {
    return this.zzW;
  }
  
  public final boolean zzah()
  {
    return (this.zzf & 0x80) != 0;
  }
  
  public final String zzai()
  {
    return this.zzX;
  }
  
  public final int zzb()
  {
    return this.zzg;
  }
  
  public final List<zzfo> zzc()
  {
    return this.zzh;
  }
  
  public final int zzd()
  {
    return this.zzh.size();
  }
  
  public final zzfo zze(int paramInt)
  {
    return (zzfo)this.zzh.get(paramInt);
  }
  
  public final List<zzgh> zzf()
  {
    return this.zzi;
  }
  
  public final int zzg()
  {
    return this.zzi.size();
  }
  
  public final zzgh zzh(int paramInt)
  {
    return (zzgh)this.zzi.get(paramInt);
  }
  
  public final boolean zzi()
  {
    return (this.zze & 0x2) != 0;
  }
  
  public final long zzj()
  {
    return this.zzj;
  }
  
  public final boolean zzk()
  {
    return (this.zze & 0x4) != 0;
  }
  
  protected final Object zzl(int paramInt, Object paramObject1, Object paramObject2)
  {
    
    if (paramInt != 0)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return null;
            }
            return zzaa;
          }
          return new zzfv(null);
        }
        return new zzfw();
      }
      paramObject1 = zzfi.zzb();
      return zzkd.zzbz(zzaa, "\001.\000\002\0017.\000\004\000\001င\000\002\033\003\033\004ဂ\001\005ဂ\002\006ဂ\003\007ဂ\005\bဈ\006\tဈ\007\nဈ\b\013ဈ\t\fင\n\rဈ\013\016ဈ\f\020ဈ\r\021ဂ\016\022ဂ\017\023ဈ\020\024ဇ\021\025ဈ\022\026ဂ\023\027င\024\030ဈ\025\031ဈ\026\032ဂ\004\034ဇ\027\035\033\036ဈ\030\037င\031 င\032!င\033\"ဈ\034#ဂ\035$ဂ\036%ဈ\037&ဈ 'င!)ဈ\",ဉ#-\035.ဂ$/ဂ%2ဈ&4ဈ'5ဌ(7ဇ)", new Object[] { "zze", "zzf", "zzg", "zzh", zzfo.class, "zzi", zzgh.class, "zzj", "zzk", "zzl", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE", "zzm", "zzF", "zzG", zzfk.class, "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzU", "zzV", "zzW", "zzX", "zzY", paramObject1, "zzZ" });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final long zzm()
  {
    return this.zzk;
  }
  
  public final boolean zzn()
  {
    return (this.zze & 0x8) != 0;
  }
  
  public final long zzo()
  {
    return this.zzl;
  }
  
  public final boolean zzp()
  {
    return (this.zze & 0x10) != 0;
  }
  
  public final long zzq()
  {
    return this.zzm;
  }
  
  public final boolean zzr()
  {
    return (this.zze & 0x20) != 0;
  }
  
  public final long zzs()
  {
    return this.zzn;
  }
  
  public final String zzt()
  {
    return this.zzo;
  }
  
  public final String zzu()
  {
    return this.zzp;
  }
  
  public final String zzv()
  {
    return this.zzq;
  }
  
  public final String zzw()
  {
    return this.zzr;
  }
  
  public final boolean zzx()
  {
    return (this.zze & 0x400) != 0;
  }
  
  public final int zzy()
  {
    return this.zzs;
  }
  
  public final String zzz()
  {
    return this.zzt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzfw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */