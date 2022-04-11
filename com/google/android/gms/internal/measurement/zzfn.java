package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

public final class zzfn
  extends zzjz<zzfo, zzfn>
  implements zzlj
{
  private zzfn()
  {
    super(zzfo.zzm());
  }
  
  public final List<zzfs> zza()
  {
    return Collections.unmodifiableList(((zzfo)this.zza).zza());
  }
  
  public final int zzb()
  {
    return ((zzfo)this.zza).zzb();
  }
  
  public final zzfs zzc(int paramInt)
  {
    return ((zzfo)this.zza).zzc(paramInt);
  }
  
  public final zzfn zzd(int paramInt, zzfs paramzzfs)
  {
    if (this.zzb)
    {
      zzax();
      this.zzb = false;
    }
    zzfo.zzn((zzfo)this.zza, paramInt, paramzzfs);
    return this;
  }
  
  public final zzfn zze(int paramInt, zzfr paramzzfr)
  {
    if (this.zzb)
    {
      zzax();
      this.zzb = false;
    }
    zzfo.zzn((zzfo)this.zza, paramInt, (zzfs)paramzzfr.zzaA());
    return this;
  }
  
  public final zzfn zzf(zzfs paramzzfs)
  {
    if (this.zzb)
    {
      zzax();
      this.zzb = false;
    }
    zzfo.zzo((zzfo)this.zza, paramzzfs);
    return this;
  }
  
  public final zzfn zzg(zzfr paramzzfr)
  {
    if (this.zzb)
    {
      zzax();
      this.zzb = false;
    }
    zzfo.zzo((zzfo)this.zza, (zzfs)paramzzfr.zzaA());
    return this;
  }
  
  public final zzfn zzh(Iterable<? extends zzfs> paramIterable)
  {
    if (this.zzb)
    {
      zzax();
      this.zzb = false;
    }
    zzfo.zzp((zzfo)this.zza, paramIterable);
    return this;
  }
  
  public final zzfn zzi()
  {
    if (this.zzb)
    {
      zzax();
      this.zzb = false;
    }
    zzfo.zzq((zzfo)this.zza);
    return this;
  }
  
  public final zzfn zzj(int paramInt)
  {
    if (this.zzb)
    {
      zzax();
      this.zzb = false;
    }
    zzfo.zzr((zzfo)this.zza, paramInt);
    return this;
  }
  
  public final String zzk()
  {
    return ((zzfo)this.zza).zzd();
  }
  
  public final zzfn zzl(String paramString)
  {
    if (this.zzb)
    {
      zzax();
      this.zzb = false;
    }
    zzfo.zzs((zzfo)this.zza, paramString);
    return this;
  }
  
  public final boolean zzm()
  {
    return ((zzfo)this.zza).zze();
  }
  
  public final long zzn()
  {
    return ((zzfo)this.zza).zzf();
  }
  
  public final zzfn zzo(long paramLong)
  {
    if (this.zzb)
    {
      zzax();
      this.zzb = false;
    }
    zzfo.zzt((zzfo)this.zza, paramLong);
    return this;
  }
  
  public final long zzp()
  {
    return ((zzfo)this.zza).zzh();
  }
  
  public final zzfn zzq(long paramLong)
  {
    if (this.zzb)
    {
      zzax();
      this.zzb = false;
    }
    zzfo.zzu((zzfo)this.zza, paramLong);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzfn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */