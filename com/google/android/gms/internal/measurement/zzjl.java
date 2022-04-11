package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

final class zzjl
{
  private final zzjk zza;
  
  private zzjl(zzjk paramzzjk)
  {
    zzkl.zzb(paramzzjk, "output");
    this.zza = paramzzjk;
    paramzzjk.zza = this;
  }
  
  public static zzjl zza(zzjk paramzzjk)
  {
    zzjl localzzjl = paramzzjk.zza;
    if (localzzjl != null) {
      return localzzjl;
    }
    return new zzjl(paramzzjk);
  }
  
  public final void zzA(int paramInt, List<Float> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        ((Float)paramList.get(i)).floatValue();
        paramInt += 4;
        i++;
      }
      this.zza.zzl(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zzm(Float.floatToRawIntBits(((Float)paramList.get(paramInt)).floatValue()));
      }
    }
    while (i < paramList.size())
    {
      this.zza.zzd(paramInt, Float.floatToRawIntBits(((Float)paramList.get(i)).floatValue()));
      i++;
    }
  }
  
  public final void zzB(int paramInt, List<Double> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        ((Double)paramList.get(paramInt)).doubleValue();
        i += 8;
        paramInt++;
      }
      this.zza.zzl(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zzo(Double.doubleToRawLongBits(((Double)paramList.get(paramInt)).doubleValue()));
      }
    }
    while (i < paramList.size())
    {
      this.zza.zzf(paramInt, Double.doubleToRawLongBits(((Double)paramList.get(i)).doubleValue()));
      i++;
    }
  }
  
  public final void zzC(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzjk.zzv(((Integer)paramList.get(i)).intValue());
        i++;
      }
      this.zza.zzl(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zzk(((Integer)paramList.get(paramInt)).intValue());
      }
    }
    while (i < paramList.size())
    {
      this.zza.zzb(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }
  
  public final void zzD(int paramInt, List<Boolean> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        ((Boolean)paramList.get(i)).booleanValue();
        paramInt++;
        i++;
      }
      this.zza.zzl(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zzj(((Boolean)paramList.get(paramInt)).booleanValue());
      }
    }
    while (i < paramList.size())
    {
      this.zza.zzg(paramInt, ((Boolean)paramList.get(i)).booleanValue());
      i++;
    }
  }
  
  public final void zzE(int paramInt, List<String> paramList)
    throws IOException
  {
    boolean bool = paramList instanceof zzks;
    int i = 0;
    int j = 0;
    if (bool)
    {
      zzks localzzks = (zzks)paramList;
      for (i = j; i < paramList.size(); i++)
      {
        Object localObject = localzzks.zzg(i);
        if ((localObject instanceof String)) {
          this.zza.zzh(paramInt, (String)localObject);
        } else {
          this.zza.zzi(paramInt, (zzjd)localObject);
        }
      }
    }
    while (i < paramList.size())
    {
      this.zza.zzh(paramInt, (String)paramList.get(i));
      i++;
    }
  }
  
  public final void zzF(int paramInt, List<zzjd> paramList)
    throws IOException
  {
    for (int i = 0; i < paramList.size(); i++) {
      this.zza.zzi(paramInt, (zzjd)paramList.get(i));
    }
  }
  
  public final void zzG(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzjk.zzw(((Integer)paramList.get(paramInt)).intValue());
        paramInt++;
      }
      this.zza.zzl(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zzl(((Integer)paramList.get(paramInt)).intValue());
      }
    }
    while (i < paramList.size())
    {
      this.zza.zzc(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }
  
  public final void zzH(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        ((Integer)paramList.get(i)).intValue();
        paramInt += 4;
        i++;
      }
      this.zza.zzl(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zzm(((Integer)paramList.get(paramInt)).intValue());
      }
    }
    while (i < paramList.size())
    {
      this.zza.zzd(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }
  
  public final void zzI(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        ((Long)paramList.get(paramInt)).longValue();
        i += 8;
        paramInt++;
      }
      this.zza.zzl(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zzo(((Long)paramList.get(paramInt)).longValue());
      }
    }
    while (i < paramList.size())
    {
      this.zza.zzf(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }
  
  public final void zzJ(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    zzjk localzzjk;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        int k = ((Integer)paramList.get(i)).intValue();
        paramInt += zzjk.zzw(k >> 31 ^ k + k);
        i++;
      }
      this.zza.zzl(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++)
      {
        localzzjk = this.zza;
        i = ((Integer)paramList.get(paramInt)).intValue();
        localzzjk.zzl(i >> 31 ^ i + i);
      }
    }
    while (i < paramList.size())
    {
      localzzjk = this.zza;
      j = ((Integer)paramList.get(i)).intValue();
      localzzjk.zzc(paramInt, j >> 31 ^ j + j);
      i++;
    }
  }
  
  public final void zzK(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    long l;
    zzjk localzzjk;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        l = ((Long)paramList.get(paramInt)).longValue();
        i += zzjk.zzx(l >> 63 ^ l + l);
        paramInt++;
      }
      this.zza.zzl(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++)
      {
        localzzjk = this.zza;
        l = ((Long)paramList.get(paramInt)).longValue();
        localzzjk.zzn(l >> 63 ^ l + l);
      }
    }
    while (i < paramList.size())
    {
      localzzjk = this.zza;
      l = ((Long)paramList.get(i)).longValue();
      localzzjk.zze(paramInt, l >> 63 ^ l + l);
      i++;
    }
  }
  
  public final void zzb(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zza.zzd(paramInt1, paramInt2);
  }
  
  public final void zzc(int paramInt, long paramLong)
    throws IOException
  {
    this.zza.zze(paramInt, paramLong);
  }
  
  public final void zzd(int paramInt, long paramLong)
    throws IOException
  {
    this.zza.zzf(paramInt, paramLong);
  }
  
  public final void zze(int paramInt, float paramFloat)
    throws IOException
  {
    this.zza.zzd(paramInt, Float.floatToRawIntBits(paramFloat));
  }
  
  public final void zzf(int paramInt, double paramDouble)
    throws IOException
  {
    this.zza.zzf(paramInt, Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void zzg(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zza.zzb(paramInt1, paramInt2);
  }
  
  public final void zzh(int paramInt, long paramLong)
    throws IOException
  {
    this.zza.zze(paramInt, paramLong);
  }
  
  public final void zzi(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zza.zzb(paramInt1, paramInt2);
  }
  
  public final void zzj(int paramInt, long paramLong)
    throws IOException
  {
    this.zza.zzf(paramInt, paramLong);
  }
  
  public final void zzk(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zza.zzd(paramInt1, paramInt2);
  }
  
  public final void zzl(int paramInt, boolean paramBoolean)
    throws IOException
  {
    this.zza.zzg(paramInt, paramBoolean);
  }
  
  public final void zzm(int paramInt, String paramString)
    throws IOException
  {
    this.zza.zzh(paramInt, paramString);
  }
  
  public final void zzn(int paramInt, zzjd paramzzjd)
    throws IOException
  {
    this.zza.zzi(paramInt, paramzzjd);
  }
  
  public final void zzo(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zza.zzc(paramInt1, paramInt2);
  }
  
  public final void zzp(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zza.zzc(paramInt1, paramInt2 >> 31 ^ paramInt2 + paramInt2);
  }
  
  public final void zzq(int paramInt, long paramLong)
    throws IOException
  {
    this.zza.zze(paramInt, paramLong >> 63 ^ paramLong + paramLong);
  }
  
  public final void zzr(int paramInt, Object paramObject, zzlt paramzzlt)
    throws IOException
  {
    Object localObject = this.zza;
    paramObject = (zzli)paramObject;
    zzji localzzji = (zzji)localObject;
    localzzji.zzl(paramInt << 3 | 0x2);
    localObject = (zzio)paramObject;
    int i = ((zzio)localObject).zzbq();
    paramInt = i;
    if (i == -1)
    {
      paramInt = paramzzlt.zze(localObject);
      ((zzio)localObject).zzbr(paramInt);
    }
    localzzji.zzl(paramInt);
    paramzzlt.zzm(paramObject, localzzji.zza);
  }
  
  public final void zzs(int paramInt, Object paramObject, zzlt paramzzlt)
    throws IOException
  {
    zzjk localzzjk = this.zza;
    paramObject = (zzli)paramObject;
    localzzjk.zza(paramInt, 3);
    paramzzlt.zzm(paramObject, localzzjk.zza);
    localzzjk.zza(paramInt, 4);
  }
  
  public final void zzt(int paramInt)
    throws IOException
  {
    this.zza.zza(paramInt, 3);
  }
  
  public final void zzu(int paramInt)
    throws IOException
  {
    this.zza.zza(paramInt, 4);
  }
  
  public final void zzv(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzjk.zzv(((Integer)paramList.get(i)).intValue());
        i++;
      }
      this.zza.zzl(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zzk(((Integer)paramList.get(paramInt)).intValue());
      }
    }
    while (i < paramList.size())
    {
      this.zza.zzb(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }
  
  public final void zzw(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        ((Integer)paramList.get(paramInt)).intValue();
        i += 4;
        paramInt++;
      }
      this.zza.zzl(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zzm(((Integer)paramList.get(paramInt)).intValue());
      }
    }
    while (i < paramList.size())
    {
      this.zza.zzd(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }
  
  public final void zzx(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzjk.zzx(((Long)paramList.get(i)).longValue());
        i++;
      }
      this.zza.zzl(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zzn(((Long)paramList.get(paramInt)).longValue());
      }
    }
    while (i < paramList.size())
    {
      this.zza.zze(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }
  
  public final void zzy(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzjk.zzx(((Long)paramList.get(i)).longValue());
        i++;
      }
      this.zza.zzl(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zzn(((Long)paramList.get(paramInt)).longValue());
      }
    }
    while (i < paramList.size())
    {
      this.zza.zze(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }
  
  public final void zzz(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        ((Long)paramList.get(paramInt)).longValue();
        i += 8;
        paramInt++;
      }
      this.zza.zzl(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zzo(((Long)paramList.get(paramInt)).longValue());
      }
    }
    while (i < paramList.size())
    {
      this.zza.zzf(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzjl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */