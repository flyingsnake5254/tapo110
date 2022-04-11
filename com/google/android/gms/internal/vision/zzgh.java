package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzgh
  implements zzkl
{
  private final zzgf zzss;
  
  private zzgh(zzgf paramzzgf)
  {
    paramzzgf = (zzgf)zzgy.zza(paramzzgf, "output");
    this.zzss = paramzzgf;
    paramzzgf.zzth = this;
  }
  
  public static zzgh zza(zzgf paramzzgf)
  {
    zzgh localzzgh = paramzzgf.zzth;
    if (localzzgh != null) {
      return localzzgh;
    }
    return new zzgh(paramzzgf);
  }
  
  public final void zza(int paramInt, double paramDouble)
    throws IOException
  {
    this.zzss.zza(paramInt, paramDouble);
  }
  
  public final void zza(int paramInt, float paramFloat)
    throws IOException
  {
    this.zzss.zza(paramInt, paramFloat);
  }
  
  public final void zza(int paramInt, long paramLong)
    throws IOException
  {
    this.zzss.zza(paramInt, paramLong);
  }
  
  public final void zza(int paramInt, zzfm paramzzfm)
    throws IOException
  {
    this.zzss.zza(paramInt, paramzzfm);
  }
  
  public final <K, V> void zza(int paramInt, zzhy<K, V> paramzzhy, Map<K, V> paramMap)
    throws IOException
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      this.zzss.writeTag(paramInt, 2);
      this.zzss.zzay(zzhz.zza(paramzzhy, localEntry.getKey(), localEntry.getValue()));
      zzhz.zza(this.zzss, paramzzhy, localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public final void zza(int paramInt, Object paramObject)
    throws IOException
  {
    if ((paramObject instanceof zzfm))
    {
      this.zzss.zzb(paramInt, (zzfm)paramObject);
      return;
    }
    this.zzss.zza(paramInt, (zzih)paramObject);
  }
  
  public final void zza(int paramInt, Object paramObject, zziw paramzziw)
    throws IOException
  {
    this.zzss.zza(paramInt, (zzih)paramObject, paramzziw);
  }
  
  public final void zza(int paramInt, String paramString)
    throws IOException
  {
    this.zzss.zza(paramInt, paramString);
  }
  
  public final void zza(int paramInt, List<String> paramList)
    throws IOException
  {
    boolean bool = paramList instanceof zzho;
    int i = 0;
    int j = 0;
    if (bool)
    {
      zzho localzzho = (zzho)paramList;
      for (i = j; i < paramList.size(); i++)
      {
        Object localObject = localzzho.getRaw(i);
        if ((localObject instanceof String)) {
          this.zzss.zza(paramInt, (String)localObject);
        } else {
          this.zzss.zza(paramInt, (zzfm)localObject);
        }
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzss.zza(paramInt, (String)paramList.get(i));
      i++;
    }
  }
  
  public final void zza(int paramInt, List<?> paramList, zziw paramzziw)
    throws IOException
  {
    for (int i = 0; i < paramList.size(); i++) {
      zza(paramInt, paramList.get(i), paramzziw);
    }
  }
  
  public final void zza(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzss.writeTag(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzgf.zzbc(((Integer)paramList.get(i)).intValue());
        i++;
      }
      this.zzss.zzay(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzss.zzax(((Integer)paramList.get(paramInt)).intValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzss.zzh(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }
  
  public final void zza(int paramInt, boolean paramBoolean)
    throws IOException
  {
    this.zzss.zza(paramInt, paramBoolean);
  }
  
  public final void zzb(int paramInt, long paramLong)
    throws IOException
  {
    this.zzss.zzb(paramInt, paramLong);
  }
  
  public final void zzb(int paramInt, Object paramObject, zziw paramzziw)
    throws IOException
  {
    zzgf localzzgf = this.zzss;
    paramObject = (zzih)paramObject;
    localzzgf.writeTag(paramInt, 3);
    paramzziw.zza(paramObject, localzzgf.zzth);
    localzzgf.writeTag(paramInt, 4);
  }
  
  public final void zzb(int paramInt, List<zzfm> paramList)
    throws IOException
  {
    for (int i = 0; i < paramList.size(); i++) {
      this.zzss.zza(paramInt, (zzfm)paramList.get(i));
    }
  }
  
  public final void zzb(int paramInt, List<?> paramList, zziw paramzziw)
    throws IOException
  {
    for (int i = 0; i < paramList.size(); i++) {
      zzb(paramInt, paramList.get(i), paramzziw);
    }
  }
  
  public final void zzb(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzss.writeTag(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzgf.zzbf(((Integer)paramList.get(i)).intValue());
        i++;
      }
      this.zzss.zzay(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzss.zzba(((Integer)paramList.get(paramInt)).intValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzss.zzk(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }
  
  public final void zzbk(int paramInt)
    throws IOException
  {
    this.zzss.writeTag(paramInt, 3);
  }
  
  public final void zzbl(int paramInt)
    throws IOException
  {
    this.zzss.writeTag(paramInt, 4);
  }
  
  public final void zzc(int paramInt, long paramLong)
    throws IOException
  {
    this.zzss.zzc(paramInt, paramLong);
  }
  
  public final void zzc(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzss.writeTag(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzgf.zzv(((Long)paramList.get(i)).longValue());
        i++;
      }
      this.zzss.zzay(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzss.zzs(((Long)paramList.get(paramInt)).longValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzss.zza(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }
  
  public final void zzd(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzss.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzgf.zzw(((Long)paramList.get(paramInt)).longValue());
        paramInt++;
      }
      this.zzss.zzay(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzss.zzs(((Long)paramList.get(paramInt)).longValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzss.zza(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }
  
  public final void zze(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzss.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzgf.zzy(((Long)paramList.get(paramInt)).longValue());
        paramInt++;
      }
      this.zzss.zzay(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzss.zzu(((Long)paramList.get(paramInt)).longValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzss.zzc(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }
  
  public final void zzf(int paramInt, List<Float> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzss.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzgf.zzt(((Float)paramList.get(paramInt)).floatValue());
        paramInt++;
      }
      this.zzss.zzay(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzss.zzs(((Float)paramList.get(paramInt)).floatValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzss.zza(paramInt, ((Float)paramList.get(i)).floatValue());
      i++;
    }
  }
  
  public final int zzfk()
  {
    return zzgx.zzf.zzxl;
  }
  
  public final void zzg(int paramInt, List<Double> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzss.writeTag(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzgf.zzb(((Double)paramList.get(i)).doubleValue());
        i++;
      }
      this.zzss.zzay(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzss.zza(((Double)paramList.get(paramInt)).doubleValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzss.zza(paramInt, ((Double)paramList.get(i)).doubleValue());
      i++;
    }
  }
  
  public final void zzh(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzss.zzh(paramInt1, paramInt2);
  }
  
  public final void zzh(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzss.writeTag(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzgf.zzbh(((Integer)paramList.get(i)).intValue());
        i++;
      }
      this.zzss.zzay(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzss.zzax(((Integer)paramList.get(paramInt)).intValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzss.zzh(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }
  
  public final void zzi(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzss.zzi(paramInt1, paramInt2);
  }
  
  public final void zzi(int paramInt, long paramLong)
    throws IOException
  {
    this.zzss.zza(paramInt, paramLong);
  }
  
  public final void zzi(int paramInt, List<Boolean> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzss.writeTag(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzgf.zzl(((Boolean)paramList.get(i)).booleanValue());
        i++;
      }
      this.zzss.zzay(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzss.zzk(((Boolean)paramList.get(paramInt)).booleanValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzss.zza(paramInt, ((Boolean)paramList.get(i)).booleanValue());
      i++;
    }
  }
  
  public final void zzj(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzss.zzj(paramInt1, paramInt2);
  }
  
  public final void zzj(int paramInt, long paramLong)
    throws IOException
  {
    this.zzss.zzc(paramInt, paramLong);
  }
  
  public final void zzj(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzss.writeTag(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzgf.zzbd(((Integer)paramList.get(i)).intValue());
        i++;
      }
      this.zzss.zzay(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzss.zzay(((Integer)paramList.get(paramInt)).intValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzss.zzi(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }
  
  public final void zzk(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzss.zzk(paramInt1, paramInt2);
  }
  
  public final void zzk(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzss.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzgf.zzbg(((Integer)paramList.get(paramInt)).intValue());
        paramInt++;
      }
      this.zzss.zzay(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzss.zzba(((Integer)paramList.get(paramInt)).intValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzss.zzk(paramInt, ((Integer)paramList.get(i)).intValue());
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
      this.zzss.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzgf.zzz(((Long)paramList.get(paramInt)).longValue());
        paramInt++;
      }
      this.zzss.zzay(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzss.zzu(((Long)paramList.get(paramInt)).longValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzss.zzc(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }
  
  public final void zzm(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzss.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzgf.zzbe(((Integer)paramList.get(paramInt)).intValue());
        paramInt++;
      }
      this.zzss.zzay(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzss.zzaz(((Integer)paramList.get(paramInt)).intValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzss.zzj(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }
  
  public final void zzn(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zzss.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzgf.zzx(((Long)paramList.get(paramInt)).longValue());
        paramInt++;
      }
      this.zzss.zzay(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zzss.zzt(((Long)paramList.get(paramInt)).longValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zzss.zzb(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }
  
  public final void zzr(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzss.zzk(paramInt1, paramInt2);
  }
  
  public final void zzs(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zzss.zzh(paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzgh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */