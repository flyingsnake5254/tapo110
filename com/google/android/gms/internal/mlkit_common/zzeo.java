package com.google.android.gms.internal.mlkit_common;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzeo
  implements zzik
{
  private final zzem zza;
  
  private zzeo(zzem paramzzem)
  {
    paramzzem = (zzem)zzfc.zza(paramzzem, "output");
    this.zza = paramzzem;
    paramzzem.zza = this;
  }
  
  public static zzeo zza(zzem paramzzem)
  {
    zzeo localzzeo = paramzzem.zza;
    if (localzzeo != null) {
      return localzzeo;
    }
    return new zzeo(paramzzem);
  }
  
  public final int zza()
  {
    return zzez.zzf.zzj;
  }
  
  public final void zza(int paramInt)
    throws IOException
  {
    this.zza.zza(paramInt, 3);
  }
  
  public final void zza(int paramInt, double paramDouble)
    throws IOException
  {
    this.zza.zza(paramInt, paramDouble);
  }
  
  public final void zza(int paramInt, float paramFloat)
    throws IOException
  {
    this.zza.zza(paramInt, paramFloat);
  }
  
  public final void zza(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zza.zze(paramInt1, paramInt2);
  }
  
  public final void zza(int paramInt, long paramLong)
    throws IOException
  {
    this.zza.zza(paramInt, paramLong);
  }
  
  public final void zza(int paramInt, zzdv paramzzdv)
    throws IOException
  {
    this.zza.zza(paramInt, paramzzdv);
  }
  
  public final <K, V> void zza(int paramInt, zzgc<K, V> paramzzgc, Map<K, V> paramMap)
    throws IOException
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject1 = (Map.Entry)paramMap.next();
      this.zza.zza(paramInt, 2);
      zzem localzzem = this.zza;
      Object localObject2 = ((Map.Entry)localObject1).getKey();
      Object localObject3 = ((Map.Entry)localObject1).getValue();
      localzzem.zzb(zzer.zza(paramzzgc.zza, 1, localObject2) + zzer.zza(paramzzgc.zzb, 2, localObject3));
      localzzem = this.zza;
      localObject3 = ((Map.Entry)localObject1).getKey();
      localObject1 = ((Map.Entry)localObject1).getValue();
      zzer.zza(localzzem, paramzzgc.zza, 1, localObject3);
      zzer.zza(localzzem, paramzzgc.zzb, 2, localObject1);
    }
  }
  
  public final void zza(int paramInt, Object paramObject)
    throws IOException
  {
    if ((paramObject instanceof zzdv))
    {
      this.zza.zzb(paramInt, (zzdv)paramObject);
      return;
    }
    this.zza.zza(paramInt, (zzgh)paramObject);
  }
  
  public final void zza(int paramInt, Object paramObject, zzgy paramzzgy)
    throws IOException
  {
    this.zza.zza(paramInt, (zzgh)paramObject, paramzzgy);
  }
  
  public final void zza(int paramInt, String paramString)
    throws IOException
  {
    this.zza.zza(paramInt, paramString);
  }
  
  public final void zza(int paramInt, List<String> paramList)
    throws IOException
  {
    boolean bool = paramList instanceof zzfs;
    int i = 0;
    int j = 0;
    if (bool)
    {
      zzfs localzzfs = (zzfs)paramList;
      for (i = j; i < paramList.size(); i++)
      {
        Object localObject = localzzfs.zza(i);
        if ((localObject instanceof String)) {
          this.zza.zza(paramInt, (String)localObject);
        } else {
          this.zza.zza(paramInt, (zzdv)localObject);
        }
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zza(paramInt, (String)paramList.get(i));
      i++;
    }
  }
  
  public final void zza(int paramInt, List<?> paramList, zzgy paramzzgy)
    throws IOException
  {
    for (int i = 0; i < paramList.size(); i++) {
      zza(paramInt, paramList.get(i), paramzzgy);
    }
  }
  
  public final void zza(int paramInt, List<Integer> paramList, boolean paramBoolean)
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
        paramInt += zzem.zzf(((Integer)paramList.get(i)).intValue());
        i++;
      }
      this.zza.zzb(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zza(((Integer)paramList.get(paramInt)).intValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zzb(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }
  
  public final void zza(int paramInt, boolean paramBoolean)
    throws IOException
  {
    this.zza.zza(paramInt, paramBoolean);
  }
  
  public final void zzb(int paramInt)
    throws IOException
  {
    this.zza.zza(paramInt, 4);
  }
  
  public final void zzb(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zza.zzb(paramInt1, paramInt2);
  }
  
  public final void zzb(int paramInt, long paramLong)
    throws IOException
  {
    this.zza.zzc(paramInt, paramLong);
  }
  
  public final void zzb(int paramInt, Object paramObject, zzgy paramzzgy)
    throws IOException
  {
    zzem localzzem = this.zza;
    paramObject = (zzgh)paramObject;
    localzzem.zza(paramInt, 3);
    paramzzgy.zza(paramObject, localzzem.zza);
    localzzem.zza(paramInt, 4);
  }
  
  public final void zzb(int paramInt, List<zzdv> paramList)
    throws IOException
  {
    for (int i = 0; i < paramList.size(); i++) {
      this.zza.zza(paramInt, (zzdv)paramList.get(i));
    }
  }
  
  public final void zzb(int paramInt, List<?> paramList, zzgy paramzzgy)
    throws IOException
  {
    for (int i = 0; i < paramList.size(); i++) {
      zzb(paramInt, paramList.get(i), paramzzgy);
    }
  }
  
  public final void zzb(int paramInt, List<Integer> paramList, boolean paramBoolean)
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
        paramInt += zzem.zzi(((Integer)paramList.get(i)).intValue());
        i++;
      }
      this.zza.zzb(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zzd(((Integer)paramList.get(paramInt)).intValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zze(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }
  
  public final void zzc(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zza.zzb(paramInt1, paramInt2);
  }
  
  public final void zzc(int paramInt, long paramLong)
    throws IOException
  {
    this.zza.zza(paramInt, paramLong);
  }
  
  public final void zzc(int paramInt, List<Long> paramList, boolean paramBoolean)
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
        i += zzem.zzd(((Long)paramList.get(paramInt)).longValue());
        paramInt++;
      }
      this.zza.zzb(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zza(((Long)paramList.get(paramInt)).longValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zza(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }
  
  public final void zzd(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zza.zze(paramInt1, paramInt2);
  }
  
  public final void zzd(int paramInt, long paramLong)
    throws IOException
  {
    this.zza.zzc(paramInt, paramLong);
  }
  
  public final void zzd(int paramInt, List<Long> paramList, boolean paramBoolean)
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
        paramInt += zzem.zze(((Long)paramList.get(i)).longValue());
        i++;
      }
      this.zza.zzb(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zza(((Long)paramList.get(paramInt)).longValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zza(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }
  
  public final void zze(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zza.zzc(paramInt1, paramInt2);
  }
  
  public final void zze(int paramInt, long paramLong)
    throws IOException
  {
    this.zza.zzb(paramInt, paramLong);
  }
  
  public final void zze(int paramInt, List<Long> paramList, boolean paramBoolean)
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
        i += zzem.zzg(((Long)paramList.get(paramInt)).longValue());
        paramInt++;
      }
      this.zza.zzb(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zzc(((Long)paramList.get(paramInt)).longValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zzc(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }
  
  public final void zzf(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zza.zzd(paramInt1, paramInt2);
  }
  
  public final void zzf(int paramInt, List<Float> paramList, boolean paramBoolean)
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
        paramInt += zzem.zzb(((Float)paramList.get(i)).floatValue());
        i++;
      }
      this.zza.zzb(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zza(((Float)paramList.get(paramInt)).floatValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zza(paramInt, ((Float)paramList.get(i)).floatValue());
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
      this.zza.zza(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzem.zzb(((Double)paramList.get(i)).doubleValue());
        i++;
      }
      this.zza.zzb(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zza(((Double)paramList.get(paramInt)).doubleValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zza(paramInt, ((Double)paramList.get(i)).doubleValue());
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
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzem.zzk(((Integer)paramList.get(paramInt)).intValue());
        paramInt++;
      }
      this.zza.zzb(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zza(((Integer)paramList.get(paramInt)).intValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zzb(paramInt, ((Integer)paramList.get(i)).intValue());
      i++;
    }
  }
  
  public final void zzi(int paramInt, List<Boolean> paramList, boolean paramBoolean)
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
        i += zzem.zzb(((Boolean)paramList.get(paramInt)).booleanValue());
        paramInt++;
      }
      this.zza.zzb(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zza(((Boolean)paramList.get(paramInt)).booleanValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zza(paramInt, ((Boolean)paramList.get(i)).booleanValue());
      i++;
    }
  }
  
  public final void zzj(int paramInt, List<Integer> paramList, boolean paramBoolean)
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
        paramInt += zzem.zzg(((Integer)paramList.get(i)).intValue());
        i++;
      }
      this.zza.zzb(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zzb(((Integer)paramList.get(paramInt)).intValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zzc(paramInt, ((Integer)paramList.get(i)).intValue());
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
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzem.zzj(((Integer)paramList.get(paramInt)).intValue());
        paramInt++;
      }
      this.zza.zzb(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zzd(((Integer)paramList.get(paramInt)).intValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zze(paramInt, ((Integer)paramList.get(i)).intValue());
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
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzem.zzh(((Long)paramList.get(paramInt)).longValue());
        paramInt++;
      }
      this.zza.zzb(i);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zzc(((Long)paramList.get(paramInt)).longValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zzc(paramInt, ((Long)paramList.get(i)).longValue());
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
      this.zza.zza(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzem.zzh(((Integer)paramList.get(i)).intValue());
        i++;
      }
      this.zza.zzb(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zzc(((Integer)paramList.get(paramInt)).intValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zzd(paramInt, ((Integer)paramList.get(i)).intValue());
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
      this.zza.zza(paramInt, 2);
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzem.zzf(((Long)paramList.get(i)).longValue());
        i++;
      }
      this.zza.zzb(paramInt);
      for (paramInt = j; paramInt < paramList.size(); paramInt++) {
        this.zza.zzb(((Long)paramList.get(paramInt)).longValue());
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zzb(paramInt, ((Long)paramList.get(i)).longValue());
      i++;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzeo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */