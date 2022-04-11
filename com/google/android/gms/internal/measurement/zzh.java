package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzh
{
  public static void zza(String paramString, int paramInt, List<zzap> paramList)
  {
    if (paramList.size() == paramInt) {
      return;
    }
    throw new IllegalArgumentException(String.format("%s operation requires %s parameters found %s", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(paramList.size()) }));
  }
  
  public static void zzb(String paramString, int paramInt, List<zzap> paramList)
  {
    if (paramList.size() >= paramInt) {
      return;
    }
    throw new IllegalArgumentException(String.format("%s operation requires at least %s parameters found %s", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(paramList.size()) }));
  }
  
  public static void zzc(String paramString, int paramInt, List<zzap> paramList)
  {
    if (paramList.size() <= paramInt) {
      return;
    }
    throw new IllegalArgumentException(String.format("%s operation requires at most %s parameters found %s", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(paramList.size()) }));
  }
  
  public static boolean zzd(zzap paramzzap)
  {
    if (paramzzap == null) {
      return false;
    }
    paramzzap = paramzzap.zzd();
    return (!paramzzap.isNaN()) && (paramzzap.doubleValue() >= 0.0D) && (paramzzap.equals(Double.valueOf(Math.floor(paramzzap.doubleValue()))));
  }
  
  public static zzbl zze(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (paramString != null)
    {
      localObject2 = localObject1;
      if (!paramString.isEmpty()) {
        localObject2 = zzbl.zza(Integer.parseInt(paramString));
      }
    }
    if (localObject2 != null) {
      return (zzbl)localObject2;
    }
    throw new IllegalArgumentException(String.format("Unsupported commandId %s", new Object[] { paramString }));
  }
  
  public static boolean zzf(zzap paramzzap1, zzap paramzzap2)
  {
    if (!paramzzap1.getClass().equals(paramzzap2.getClass())) {
      return false;
    }
    if ((!(paramzzap1 instanceof zzau)) && (!(paramzzap1 instanceof zzan)))
    {
      if ((paramzzap1 instanceof zzah))
      {
        if ((!Double.isNaN(paramzzap1.zzd().doubleValue())) && (!Double.isNaN(paramzzap2.zzd().doubleValue()))) {
          return paramzzap1.zzd().equals(paramzzap2.zzd());
        }
        return false;
      }
      if ((paramzzap1 instanceof zzat)) {
        return paramzzap1.zzc().equals(paramzzap2.zzc());
      }
      if ((paramzzap1 instanceof zzaf)) {
        return paramzzap1.zze().equals(paramzzap2.zze());
      }
      return paramzzap1 == paramzzap2;
    }
    return true;
  }
  
  public static int zzg(double paramDouble)
  {
    if ((!Double.isNaN(paramDouble)) && (!Double.isInfinite(paramDouble)))
    {
      boolean bool = paramDouble < 0.0D;
      if (bool)
      {
        int i;
        if (bool) {
          bool = true;
        } else {
          i = -1;
        }
        return (int)(i * Math.floor(Math.abs(paramDouble)) % 4.294967296E9D);
      }
    }
    return 0;
  }
  
  public static long zzh(double paramDouble)
  {
    return zzg(paramDouble) & 0xFFFFFFFF;
  }
  
  public static double zzi(double paramDouble)
  {
    if (Double.isNaN(paramDouble)) {
      return 0.0D;
    }
    if (!Double.isInfinite(paramDouble))
    {
      boolean bool = paramDouble < 0.0D;
      if ((bool) && (bool))
      {
        int i;
        if (bool) {
          bool = true;
        } else {
          i = -1;
        }
        return i * Math.floor(Math.abs(paramDouble));
      }
    }
    return paramDouble;
  }
  
  public static Object zzj(zzap paramzzap)
  {
    if (zzap.zzg.equals(paramzzap)) {
      return null;
    }
    if (zzap.zzf.equals(paramzzap)) {
      return "";
    }
    if (!paramzzap.zzd().isNaN()) {
      return paramzzap.zzd();
    }
    return paramzzap.zzc();
  }
  
  public static int zzk(zzg paramzzg)
  {
    int i = zzg(paramzzg.zzh("runtime.counter").zzd().doubleValue() + 1.0D);
    if (i <= 1000000)
    {
      paramzzg.zze("runtime.counter", new zzah(Double.valueOf(i)));
      return i;
    }
    throw new IllegalStateException("Instructions allowed exceeded");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */