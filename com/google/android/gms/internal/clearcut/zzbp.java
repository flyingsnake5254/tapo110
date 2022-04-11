package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzbp
  implements zzfr
{
  private final zzbn zzfo;
  
  private zzbp(zzbn paramzzbn)
  {
    paramzzbn = (zzbn)zzci.zza(paramzzbn, "output");
    this.zzfo = paramzzbn;
    paramzzbn.zzfz = this;
  }
  
  public static zzbp zza(zzbn paramzzbn)
  {
    zzbp localzzbp = paramzzbn.zzfz;
    if (localzzbp != null) {
      return localzzbp;
    }
    return new zzbp(paramzzbn);
  }
  
  public final void zza(int paramInt, double paramDouble)
    throws IOException
  {
    this.zzfo.zza(paramInt, paramDouble);
  }
  
  public final void zza(int paramInt, float paramFloat)
    throws IOException
  {
    this.zzfo.zza(paramInt, paramFloat);
  }
  
  public final void zza(int paramInt, long paramLong)
    throws IOException
  {
    this.zzfo.zza(paramInt, paramLong);
  }
  
  public final void zza(int paramInt, zzbb paramzzbb)
    throws IOException
  {
    this.zzfo.zza(paramInt, paramzzbb);
  }
  
  public final <K, V> void zza(int paramInt, zzdh<K, V> paramzzdh, Map<K, V> paramMap)
    throws IOException
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      this.zzfo.zzb(paramInt, 2);
      this.zzfo.zzo(zzdg.zza(paramzzdh, localEntry.getKey(), localEntry.getValue()));
      zzdg.zza(this.zzfo, paramzzdh, localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public final void zza(int paramInt, Object paramObject)
    throws IOException
  {
    if ((paramObject instanceof zzbb))
    {
      this.zzfo.zzb(paramInt, (zzbb)paramObject);
      return;
    }
    this.zzfo.zzb(paramInt, (zzdo)paramObject);
  }
  
  public final void zza(int paramInt, Object paramObject, zzef paramzzef)
    throws IOException
  {
    this.zzfo.zza(paramInt, (zzdo)paramObject, paramzzef);
  }
  
  public final void zza(int paramInt, String paramString)
    throws IOException
  {
    this.zzfo.zza(paramInt, paramString);
  }
  
  public final void zza(int paramInt, List<String> paramList)
    throws IOException
  {
    boolean bool = paramList instanceof zzcx;
    int i = 0;
    int j = 0;
    if (bool)
    {
      zzcx localzzcx = (zzcx)paramList;
      for (i = j; i < paramList.size(); i++)
      {
        Object localObject = localzzcx.getRaw(i);
        if ((localObject instanceof String)) {
          this.zzfo.zza(paramInt, (String)localObject);
        } else {
          this.zzfo.zza(paramInt, (zzbb)localObject);
        }
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzfo.zza(paramInt, (String)paramList.get(i));
      i++;
    }
  }
  
  public final void zza(int paramInt, List<?> paramList, zzef paramzzef)
    throws IOException
  {
    for (int i = 0; i < paramList.size(); i++) {
      zza(paramInt, paramList.get(i), paramzzef);
    }
  }
  
  public final void zza(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzfo.zzb(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzbn.zzs(((Integer)paramList.get(paramInt)).intValue());
        paramInt++;
      }
      this.zzfo.zzo(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzfo.zzn(((Integer)paramList.get(paramInt)).intValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzfo.zzc(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }
  
  public final void zzaa(int paramInt)
    throws IOException
  {
    this.zzfo.zzb(paramInt, 3);
  }
  
  public final void zzab(int paramInt)
    throws IOException
  {
    this.zzfo.zzb(paramInt, 4);
  }
  
  public final int zzaj()
  {
    return zzcg.zzg.zzko;
  }
  
  public final void zzb(int paramInt, long paramLong)
    throws IOException
  {
    this.zzfo.zzb(paramInt, paramLong);
  }
  
  public final void zzb(int paramInt, Object paramObject, zzef paramzzef)
    throws IOException
  {
    zzbn localzzbn = this.zzfo;
    paramObject = (zzdo)paramObject;
    localzzbn.zzb(paramInt, 3);
    paramzzef.zza(paramObject, localzzbn.zzfz);
    localzzbn.zzb(paramInt, 4);
  }
  
  public final void zzb(int paramInt, List<zzbb> paramList)
    throws IOException
  {
    for (int i = 0; i < paramList.size(); i++) {
      this.zzfo.zza(paramInt, (zzbb)paramList.get(i));
    }
  }
  
  public final void zzb(int paramInt, List<?> paramList, zzef paramzzef)
    throws IOException
  {
    for (int i = 0; i < paramList.size(); i++) {
      zzb(paramInt, paramList.get(i), paramzzef);
    }
  }
  
  public final void zzb(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzfo.zzb(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzbn.zzv(((Integer)paramList.get(i)).intValue());
        i++;
      }
      this.zzfo.zzo(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzfo.zzq(((Integer)paramList.get(paramInt)).intValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzfo.zzf(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }
  
  public final void zzb(int paramInt, boolean paramBoolean)
    throws IOException
  {
    this.zzfo.zzb(paramInt, paramBoolean);
  }
  
  public final void zzc(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzfo.zzc(paramInt1, paramInt2);
  }
  
  public final void zzc(int paramInt, long paramLong)
    throws IOException
  {
    this.zzfo.zzc(paramInt, paramLong);
  }
  
  public final void zzc(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzfo.zzb(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzbn.zze(((Long)paramList.get(paramInt)).longValue());
        paramInt++;
      }
      this.zzfo.zzo(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzfo.zzb(((Long)paramList.get(paramInt)).longValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzfo.zza(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }
  
  public final void zzd(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzfo.zzd(paramInt1, paramInt2);
  }
  
  public final void zzd(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzfo.zzb(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzbn.zzf(((Long)paramList.get(paramInt)).longValue());
        paramInt++;
      }
      this.zzfo.zzo(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzfo.zzb(((Long)paramList.get(paramInt)).longValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzfo.zza(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }
  
  public final void zze(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzfo.zze(paramInt1, paramInt2);
  }
  
  public final void zze(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzfo.zzb(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzbn.zzh(((Long)paramList.get(paramInt)).longValue());
        paramInt++;
      }
      this.zzfo.zzo(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzfo.zzd(((Long)paramList.get(paramInt)).longValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzfo.zzc(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }
  
  public final void zzf(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzfo.zzf(paramInt1, paramInt2);
  }
  
  public final void zzf(int paramInt, List<Float> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzfo.zzb(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzbn.zzb(((Float)paramList.get(paramInt)).floatValue());
        paramInt++;
      }
      this.zzfo.zzo(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzfo.zza(((Float)paramList.get(paramInt)).floatValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzfo.zza(paramInt, ((Float)paramList.get(i)).floatValue());
      i++;
    }
  }
  
  public final void zzg(int paramInt, List<Double> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzfo.zzb(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzbn.zzb(((Double)paramList.get(i)).doubleValue());
        i++;
      }
      this.zzfo.zzo(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzfo.zza(((Double)paramList.get(paramInt)).doubleValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzfo.zza(paramInt, ((Double)paramList.get(i)).doubleValue());
      i++;
    }
  }
  
  public final void zzh(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzfo.zzb(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzbn.zzx(((Integer)paramList.get(i)).intValue());
        i++;
      }
      this.zzfo.zzo(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzfo.zzn(((Integer)paramList.get(paramInt)).intValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzfo.zzc(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }
  
  public final void zzi(int paramInt, long paramLong)
    throws IOException
  {
    this.zzfo.zza(paramInt, paramLong);
  }
  
  public final void zzi(int paramInt, List<Boolean> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzfo.zzb(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzbn.zzb(((Boolean)paramList.get(paramInt)).booleanValue());
        paramInt++;
      }
      this.zzfo.zzo(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzfo.zza(((Boolean)paramList.get(paramInt)).booleanValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzfo.zzb(paramInt, ((Boolean)paramList.get(i)).booleanValue());
      i++;
    }
  }
  
  public final void zzj(int paramInt, long paramLong)
    throws IOException
  {
    this.zzfo.zzc(paramInt, paramLong);
  }
  
  public final void zzj(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzfo.zzb(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzbn.zzt(((Integer)paramList.get(i)).intValue());
        i++;
      }
      this.zzfo.zzo(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzfo.zzo(((Integer)paramList.get(paramInt)).intValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzfo.zzd(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }
  
  public final void zzk(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzfo.zzb(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzbn.zzw(((Integer)paramList.get(i)).intValue());
        i++;
      }
      this.zzfo.zzo(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzfo.zzq(((Integer)paramList.get(paramInt)).intValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzfo.zzf(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }
  
  public final void zzl(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzfo.zzb(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzbn.zzi(((Long)paramList.get(i)).longValue());
        i++;
      }
      this.zzfo.zzo(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzfo.zzd(((Long)paramList.get(paramInt)).longValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzfo.zzc(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }
  
  public final void zzm(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzfo.zzf(paramInt1, paramInt2);
  }
  
  public final void zzm(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzfo.zzb(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzbn.zzu(((Integer)paramList.get(i)).intValue());
        i++;
      }
      this.zzfo.zzo(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzfo.zzp(((Integer)paramList.get(paramInt)).intValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzfo.zze(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }
  
  public final void zzn(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzfo.zzc(paramInt1, paramInt2);
  }
  
  public final void zzn(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzfo.zzb(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzbn.zzg(((Long)paramList.get(i)).longValue());
        i++;
      }
      this.zzfo.zzo(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzfo.zzc(((Long)paramList.get(paramInt)).longValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzfo.zzb(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzbp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */