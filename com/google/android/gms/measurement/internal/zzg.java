package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

final class zzg
{
  private long zzA;
  private long zzB;
  @Nullable
  private String zzC;
  private boolean zzD;
  private long zzE;
  private long zzF;
  private final zzfu zza;
  private final String zzb;
  @Nullable
  private String zzc;
  @Nullable
  private String zzd;
  @Nullable
  private String zze;
  @Nullable
  private String zzf;
  private long zzg;
  private long zzh;
  private long zzi;
  @Nullable
  private String zzj;
  private long zzk;
  @Nullable
  private String zzl;
  private long zzm;
  private long zzn;
  private boolean zzo;
  private long zzp;
  private boolean zzq;
  @Nullable
  private String zzr;
  @Nullable
  private Boolean zzs;
  private long zzt;
  @Nullable
  private List<String> zzu;
  @Nullable
  private String zzv;
  private long zzw;
  private long zzx;
  private long zzy;
  private long zzz;
  
  @WorkerThread
  zzg(zzfu paramzzfu, String paramString)
  {
    Preconditions.checkNotNull(paramzzfu);
    Preconditions.checkNotEmpty(paramString);
    this.zza = paramzzfu;
    this.zzb = paramString;
    paramzzfu.zzav().zzg();
  }
  
  @WorkerThread
  public final void zzA(long paramLong)
  {
    this.zza.zzav().zzg();
    boolean bool1 = this.zzD;
    boolean bool2;
    if (this.zzm != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.zzD = (bool1 | bool2);
    this.zzm = paramLong;
  }
  
  @WorkerThread
  public final long zzB()
  {
    this.zza.zzav().zzg();
    return this.zzn;
  }
  
  @WorkerThread
  public final void zzC(long paramLong)
  {
    this.zza.zzav().zzg();
    boolean bool1 = this.zzD;
    boolean bool2;
    if (this.zzn != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.zzD = (bool1 | bool2);
    this.zzn = paramLong;
  }
  
  @WorkerThread
  public final long zzD()
  {
    this.zza.zzav().zzg();
    return this.zzt;
  }
  
  @WorkerThread
  public final void zzE(long paramLong)
  {
    this.zza.zzav().zzg();
    boolean bool1 = this.zzD;
    boolean bool2;
    if (this.zzt != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.zzD = (bool1 | bool2);
    this.zzt = paramLong;
  }
  
  @WorkerThread
  public final boolean zzF()
  {
    this.zza.zzav().zzg();
    return this.zzo;
  }
  
  @WorkerThread
  public final void zzG(boolean paramBoolean)
  {
    this.zza.zzav().zzg();
    boolean bool1 = this.zzD;
    boolean bool2;
    if (this.zzo != paramBoolean) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.zzD = (bool1 | bool2);
    this.zzo = paramBoolean;
  }
  
  @WorkerThread
  public final void zzH(long paramLong)
  {
    boolean bool1 = true;
    if (paramLong >= 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    Preconditions.checkArgument(bool2);
    this.zza.zzav().zzg();
    boolean bool2 = this.zzD;
    if (this.zzg == paramLong) {
      bool1 = false;
    }
    this.zzD = (bool1 | bool2);
    this.zzg = paramLong;
  }
  
  @WorkerThread
  public final long zzI()
  {
    this.zza.zzav().zzg();
    return this.zzg;
  }
  
  @WorkerThread
  public final long zzJ()
  {
    this.zza.zzav().zzg();
    return this.zzE;
  }
  
  @WorkerThread
  public final void zzK(long paramLong)
  {
    this.zza.zzav().zzg();
    boolean bool1 = this.zzD;
    boolean bool2;
    if (this.zzE != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.zzD = (bool1 | bool2);
    this.zzE = paramLong;
  }
  
  @WorkerThread
  public final long zzL()
  {
    this.zza.zzav().zzg();
    return this.zzF;
  }
  
  @WorkerThread
  public final void zzM(long paramLong)
  {
    this.zza.zzav().zzg();
    boolean bool1 = this.zzD;
    boolean bool2;
    if (this.zzF != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.zzD = (bool1 | bool2);
    this.zzF = paramLong;
  }
  
  @WorkerThread
  public final void zzN()
  {
    this.zza.zzav().zzg();
    long l1 = this.zzg + 1L;
    long l2 = l1;
    if (l1 > 2147483647L)
    {
      this.zza.zzau().zze().zzb("Bundle index overflow. appId", zzem.zzl(this.zzb));
      l2 = 0L;
    }
    this.zzD = true;
    this.zzg = l2;
  }
  
  @WorkerThread
  public final long zzO()
  {
    this.zza.zzav().zzg();
    return this.zzw;
  }
  
  @WorkerThread
  public final void zzP(long paramLong)
  {
    this.zza.zzav().zzg();
    boolean bool1 = this.zzD;
    boolean bool2;
    if (this.zzw != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.zzD = (bool1 | bool2);
    this.zzw = paramLong;
  }
  
  @WorkerThread
  public final long zzQ()
  {
    this.zza.zzav().zzg();
    return this.zzx;
  }
  
  @WorkerThread
  public final void zzR(long paramLong)
  {
    this.zza.zzav().zzg();
    boolean bool1 = this.zzD;
    boolean bool2;
    if (this.zzx != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.zzD = (bool1 | bool2);
    this.zzx = paramLong;
  }
  
  @WorkerThread
  public final long zzS()
  {
    this.zza.zzav().zzg();
    return this.zzy;
  }
  
  @WorkerThread
  public final void zzT(long paramLong)
  {
    this.zza.zzav().zzg();
    boolean bool1 = this.zzD;
    boolean bool2;
    if (this.zzy != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.zzD = (bool1 | bool2);
    this.zzy = paramLong;
  }
  
  @WorkerThread
  public final long zzU()
  {
    this.zza.zzav().zzg();
    return this.zzz;
  }
  
  @WorkerThread
  public final void zzV(long paramLong)
  {
    this.zza.zzav().zzg();
    boolean bool1 = this.zzD;
    boolean bool2;
    if (this.zzz != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.zzD = (bool1 | bool2);
    this.zzz = paramLong;
  }
  
  @WorkerThread
  public final long zzW()
  {
    this.zza.zzav().zzg();
    return this.zzB;
  }
  
  @WorkerThread
  public final void zzX(long paramLong)
  {
    this.zza.zzav().zzg();
    boolean bool1 = this.zzD;
    boolean bool2;
    if (this.zzB != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.zzD = (bool1 | bool2);
    this.zzB = paramLong;
  }
  
  @WorkerThread
  public final long zzY()
  {
    this.zza.zzav().zzg();
    return this.zzA;
  }
  
  @WorkerThread
  public final void zzZ(long paramLong)
  {
    this.zza.zzav().zzg();
    boolean bool1 = this.zzD;
    boolean bool2;
    if (this.zzA != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.zzD = (bool1 | bool2);
    this.zzA = paramLong;
  }
  
  @WorkerThread
  public final boolean zza()
  {
    this.zza.zzav().zzg();
    return this.zzD;
  }
  
  @Nullable
  @WorkerThread
  public final String zzaa()
  {
    this.zza.zzav().zzg();
    return this.zzC;
  }
  
  @Nullable
  @WorkerThread
  public final String zzab()
  {
    this.zza.zzav().zzg();
    String str = this.zzC;
    zzac(null);
    return str;
  }
  
  @WorkerThread
  public final void zzac(@Nullable String paramString)
  {
    this.zza.zzav().zzg();
    this.zzD |= zzku.zzS(this.zzC, paramString) ^ true;
    this.zzC = paramString;
  }
  
  @WorkerThread
  public final long zzad()
  {
    this.zza.zzav().zzg();
    return this.zzp;
  }
  
  @WorkerThread
  public final void zzae(long paramLong)
  {
    this.zza.zzav().zzg();
    boolean bool1 = this.zzD;
    boolean bool2;
    if (this.zzp != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.zzD = (bool1 | bool2);
    this.zzp = paramLong;
  }
  
  @WorkerThread
  public final boolean zzaf()
  {
    this.zza.zzav().zzg();
    return this.zzq;
  }
  
  @WorkerThread
  public final void zzag(boolean paramBoolean)
  {
    this.zza.zzav().zzg();
    boolean bool1 = this.zzD;
    boolean bool2;
    if (this.zzq != paramBoolean) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.zzD = (bool1 | bool2);
    this.zzq = paramBoolean;
  }
  
  @Nullable
  @WorkerThread
  public final Boolean zzah()
  {
    this.zza.zzav().zzg();
    return this.zzs;
  }
  
  @WorkerThread
  public final void zzai(@Nullable Boolean paramBoolean)
  {
    this.zza.zzav().zzg();
    boolean bool1 = this.zzD;
    Boolean localBoolean = this.zzs;
    int i = zzku.zza;
    boolean bool2;
    if ((localBoolean == null) && (paramBoolean == null)) {
      bool2 = true;
    } else if (localBoolean == null) {
      bool2 = false;
    } else {
      bool2 = localBoolean.equals(paramBoolean);
    }
    this.zzD = (bool1 | bool2 ^ true);
    this.zzs = paramBoolean;
  }
  
  @Nullable
  @WorkerThread
  public final List<String> zzaj()
  {
    this.zza.zzav().zzg();
    return this.zzu;
  }
  
  @WorkerThread
  public final void zzak(@Nullable List<String> paramList)
  {
    this.zza.zzav().zzg();
    List localList = this.zzu;
    int i = zzku.zza;
    if (((localList == null) && (paramList == null)) || ((localList != null) && (localList.equals(paramList)))) {
      return;
    }
    this.zzD = true;
    if (paramList != null) {
      paramList = new ArrayList(paramList);
    } else {
      paramList = null;
    }
    this.zzu = paramList;
  }
  
  @WorkerThread
  public final void zzb()
  {
    this.zza.zzav().zzg();
    this.zzD = false;
  }
  
  @WorkerThread
  public final String zzc()
  {
    this.zza.zzav().zzg();
    return this.zzb;
  }
  
  @Nullable
  @WorkerThread
  public final String zzd()
  {
    this.zza.zzav().zzg();
    return this.zzc;
  }
  
  @WorkerThread
  public final void zze(@Nullable String paramString)
  {
    this.zza.zzav().zzg();
    this.zzD |= zzku.zzS(this.zzc, paramString) ^ true;
    this.zzc = paramString;
  }
  
  @Nullable
  @WorkerThread
  public final String zzf()
  {
    this.zza.zzav().zzg();
    return this.zzd;
  }
  
  @WorkerThread
  public final void zzg(@Nullable String paramString)
  {
    this.zza.zzav().zzg();
    String str = paramString;
    if (true == TextUtils.isEmpty(paramString)) {
      str = null;
    }
    this.zzD |= true ^ zzku.zzS(this.zzd, str);
    this.zzd = str;
  }
  
  @Nullable
  @WorkerThread
  public final String zzh()
  {
    this.zza.zzav().zzg();
    return this.zzr;
  }
  
  @WorkerThread
  public final void zzi(@Nullable String paramString)
  {
    this.zza.zzav().zzg();
    String str = paramString;
    if (true == TextUtils.isEmpty(paramString)) {
      str = null;
    }
    this.zzD |= true ^ zzku.zzS(this.zzr, str);
    this.zzr = str;
  }
  
  @Nullable
  @WorkerThread
  public final String zzj()
  {
    this.zza.zzav().zzg();
    return this.zzv;
  }
  
  @WorkerThread
  public final void zzk(@Nullable String paramString)
  {
    this.zza.zzav().zzg();
    String str = paramString;
    if (true == TextUtils.isEmpty(paramString)) {
      str = null;
    }
    this.zzD |= true ^ zzku.zzS(this.zzv, str);
    this.zzv = str;
  }
  
  @Nullable
  @WorkerThread
  public final String zzl()
  {
    this.zza.zzav().zzg();
    return this.zze;
  }
  
  @WorkerThread
  public final void zzm(@Nullable String paramString)
  {
    this.zza.zzav().zzg();
    this.zzD |= zzku.zzS(this.zze, paramString) ^ true;
    this.zze = paramString;
  }
  
  @Nullable
  @WorkerThread
  public final String zzn()
  {
    this.zza.zzav().zzg();
    return this.zzf;
  }
  
  @WorkerThread
  public final void zzo(@Nullable String paramString)
  {
    this.zza.zzav().zzg();
    this.zzD |= zzku.zzS(this.zzf, paramString) ^ true;
    this.zzf = paramString;
  }
  
  @WorkerThread
  public final long zzp()
  {
    this.zza.zzav().zzg();
    return this.zzh;
  }
  
  @WorkerThread
  public final void zzq(long paramLong)
  {
    this.zza.zzav().zzg();
    boolean bool1 = this.zzD;
    boolean bool2;
    if (this.zzh != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.zzD = (bool1 | bool2);
    this.zzh = paramLong;
  }
  
  @WorkerThread
  public final long zzr()
  {
    this.zza.zzav().zzg();
    return this.zzi;
  }
  
  @WorkerThread
  public final void zzs(long paramLong)
  {
    this.zza.zzav().zzg();
    boolean bool1 = this.zzD;
    boolean bool2;
    if (this.zzi != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.zzD = (bool1 | bool2);
    this.zzi = paramLong;
  }
  
  @Nullable
  @WorkerThread
  public final String zzt()
  {
    this.zza.zzav().zzg();
    return this.zzj;
  }
  
  @WorkerThread
  public final void zzu(@Nullable String paramString)
  {
    this.zza.zzav().zzg();
    this.zzD |= zzku.zzS(this.zzj, paramString) ^ true;
    this.zzj = paramString;
  }
  
  @WorkerThread
  public final long zzv()
  {
    this.zza.zzav().zzg();
    return this.zzk;
  }
  
  @WorkerThread
  public final void zzw(long paramLong)
  {
    this.zza.zzav().zzg();
    boolean bool1 = this.zzD;
    boolean bool2;
    if (this.zzk != paramLong) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.zzD = (bool1 | bool2);
    this.zzk = paramLong;
  }
  
  @Nullable
  @WorkerThread
  public final String zzx()
  {
    this.zza.zzav().zzg();
    return this.zzl;
  }
  
  @WorkerThread
  public final void zzy(@Nullable String paramString)
  {
    this.zza.zzav().zzg();
    this.zzD |= zzku.zzS(this.zzl, paramString) ^ true;
    this.zzl = paramString;
  }
  
  @WorkerThread
  public final long zzz()
  {
    this.zza.zzav().zzg();
    return this.zzm;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */