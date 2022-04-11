package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzfp
  implements zzjn
{
  private final zzfn zza;
  
  private zzfp(zzfn paramzzfn)
  {
    paramzzfn = (zzfn)zzgc.zza(paramzzfn, "output");
    this.zza = paramzzfn;
    paramzzfn.zza = this;
  }
  
  public static zzfp zza(zzfn paramzzfn)
  {
    zzfp localzzfp = paramzzfn.zza;
    if (localzzfp != null) {
      return localzzfp;
    }
    return new zzfp(paramzzfn);
  }
  
  public final int zza()
  {
    return zzga.zze.zzj;
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
  
  public final void zza(int paramInt, zzew paramzzew)
    throws IOException
  {
    this.zza.zza(paramInt, paramzzew);
  }
  
  public final <K, V> void zza(int paramInt, zzhf<K, V> paramzzhf, Map<K, V> paramMap)
    throws IOException
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject1 = (Map.Entry)paramMap.next();
      this.zza.zza(paramInt, 2);
      zzfn localzzfn = this.zza;
      Object localObject2 = ((Map.Entry)localObject1).getKey();
      Object localObject3 = ((Map.Entry)localObject1).getValue();
      localzzfn.zzb(zzfs.zza(paramzzhf.zza, 1, localObject2) + zzfs.zza(paramzzhf.zzb, 2, localObject3));
      localObject2 = this.zza;
      localObject3 = ((Map.Entry)localObject1).getKey();
      localObject1 = ((Map.Entry)localObject1).getValue();
      zzfs.zza((zzfn)localObject2, paramzzhf.zza, 1, localObject3);
      zzfs.zza((zzfn)localObject2, paramzzhf.zzb, 2, localObject1);
    }
  }
  
  public final void zza(int paramInt, Object paramObject)
    throws IOException
  {
    if ((paramObject instanceof zzew))
    {
      this.zza.zzb(paramInt, (zzew)paramObject);
      return;
    }
    this.zza.zza(paramInt, (zzhk)paramObject);
  }
  
  public final void zza(int paramInt, Object paramObject, zzib paramzzib)
    throws IOException
  {
    this.zza.zza(paramInt, (zzhk)paramObject, paramzzib);
  }
  
  public final void zza(int paramInt, String paramString)
    throws IOException
  {
    this.zza.zza(paramInt, paramString);
  }
  
  public final void zza(int paramInt, List<String> paramList)
    throws IOException
  {
    boolean bool = paramList instanceof zzgv;
    int i = 0;
    int j = 0;
    if (bool)
    {
      zzgv localzzgv = (zzgv)paramList;
      for (i = j; i < paramList.size(); i++)
      {
        Object localObject = localzzgv.zzb(i);
        if ((localObject instanceof String)) {
          this.zza.zza(paramInt, (String)localObject);
        } else {
          this.zza.zza(paramInt, (zzew)localObject);
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
  
  public final void zza(int paramInt, List<?> paramList, zzib paramzzib)
    throws IOException
  {
    for (int i = 0; i < paramList.size(); i++) {
      zza(paramInt, paramList.get(i), paramzzib);
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
        paramInt += zzfn.zzf(((Integer)paramList.get(i)).intValue());
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
  
  public final void zzb(int paramInt, Object paramObject, zzib paramzzib)
    throws IOException
  {
    zzfn localzzfn = this.zza;
    paramObject = (zzhk)paramObject;
    localzzfn.zza(paramInt, 3);
    paramzzib.zza(paramObject, localzzfn.zza);
    localzzfn.zza(paramInt, 4);
  }
  
  public final void zzb(int paramInt, List<zzew> paramList)
    throws IOException
  {
    for (int i = 0; i < paramList.size(); i++) {
      this.zza.zza(paramInt, (zzew)paramList.get(i));
    }
  }
  
  public final void zzb(int paramInt, List<?> paramList, zzib paramzzib)
    throws IOException
  {
    for (int i = 0; i < paramList.size(); i++) {
      zzb(paramInt, paramList.get(i), paramzzib);
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
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzfn.zzi(((Integer)paramList.get(paramInt)).intValue());
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
        i += zzfn.zzd(((Long)paramList.get(paramInt)).longValue());
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
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzfn.zze(((Long)paramList.get(paramInt)).longValue());
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
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzfn.zzg(((Long)paramList.get(i)).longValue());
        i++;
      }
      this.zza.zzb(paramInt);
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
        paramInt += zzfn.zzb(((Float)paramList.get(i)).floatValue());
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
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzfn.zzb(((Double)paramList.get(paramInt)).doubleValue());
        paramInt++;
      }
      this.zza.zzb(i);
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
        i += zzfn.zzk(((Integer)paramList.get(paramInt)).intValue());
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
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzfn.zzb(((Boolean)paramList.get(i)).booleanValue());
        i++;
      }
      this.zza.zzb(paramInt);
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
        paramInt += zzfn.zzg(((Integer)paramList.get(i)).intValue());
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
        i += zzfn.zzj(((Integer)paramList.get(paramInt)).intValue());
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
      i = 0;
      paramInt = 0;
      while (i < paramList.size())
      {
        paramInt += zzfn.zzh(((Long)paramList.get(i)).longValue());
        i++;
      }
      this.zza.zzb(paramInt);
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
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzfn.zzh(((Integer)paramList.get(paramInt)).intValue());
        paramInt++;
      }
      this.zza.zzb(i);
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
        paramInt += zzfn.zzf(((Long)paramList.get(i)).longValue());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzfp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */