package com.google.android.gms.internal.mlkit_vision_common;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.AbstractMap;
import java.util.List;

final class zzgk
{
  private static final Class<?> zza = ;
  private static final zzha<?, ?> zzb = zza(false);
  private static final zzha<?, ?> zzc = zza(true);
  private static final zzha<?, ?> zzd = new zzhc();
  
  static int zza(int paramInt, Object paramObject, zzgi paramzzgi)
  {
    if ((paramObject instanceof zzfa)) {
      return zzdw.zza(paramInt, (zzfa)paramObject);
    }
    return zzdw.zzb(paramInt, (zzfv)paramObject, paramzzgi);
  }
  
  static int zza(int paramInt, List<?> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    int m = zzdw.zze(paramInt) * i;
    paramInt = m;
    Object localObject;
    if ((paramList instanceof zzfc))
    {
      paramList = (zzfc)paramList;
      paramInt = m;
      for (j = k;; j++)
      {
        m = paramInt;
        if (j >= i) {
          break;
        }
        localObject = paramList.zza(j);
        if ((localObject instanceof zzdj)) {
          m = zzdw.zzb((zzdj)localObject);
        } else {
          m = zzdw.zzb((String)localObject);
        }
        paramInt += m;
      }
    }
    for (;;)
    {
      m = paramInt;
      if (j >= i) {
        break;
      }
      localObject = paramList.get(j);
      if ((localObject instanceof zzdj)) {
        m = zzdw.zzb((zzdj)localObject);
      } else {
        m = zzdw.zzb((String)localObject);
      }
      paramInt += m;
      j++;
    }
    return m;
  }
  
  static int zza(int paramInt, List<?> paramList, zzgi paramzzgi)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0) {
      return 0;
    }
    int k = zzdw.zze(paramInt) * i;
    for (paramInt = j; paramInt < i; paramInt++)
    {
      Object localObject = paramList.get(paramInt);
      if ((localObject instanceof zzfa)) {
        j = zzdw.zza((zzfa)localObject);
      } else {
        j = zzdw.zza((zzfv)localObject, paramzzgi);
      }
      k += j;
    }
    return k;
  }
  
  static int zza(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    if (paramList.size() == 0) {
      return 0;
    }
    return zza(paramList) + paramList.size() * zzdw.zze(paramInt);
  }
  
  static int zza(List<Long> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzfj))
    {
      paramList = (zzfj)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzdw.zzd(paramList.zza(k));
        k++;
      }
    }
    int m = 0;
    for (k = j;; k++)
    {
      j = m;
      if (k >= i) {
        break;
      }
      m += zzdw.zzd(((Long)paramList.get(k)).longValue());
    }
    return j;
  }
  
  public static zzha<?, ?> zza()
  {
    return zzb;
  }
  
  private static zzha<?, ?> zza(boolean paramBoolean)
  {
    try
    {
      Object localObject1 = zze();
      if (localObject1 == null) {
        return null;
      }
      localObject1 = (zzha)((Class)localObject1).getConstructor(new Class[] { Boolean.TYPE }).newInstance(new Object[] { Boolean.valueOf(paramBoolean) });
      return (zzha<?, ?>)localObject1;
    }
    finally {}
    return null;
  }
  
  public static void zza(int paramInt, List<String> paramList, zzhu paramzzhu)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzhu.zza(paramInt, paramList);
    }
  }
  
  public static void zza(int paramInt, List<?> paramList, zzhu paramzzhu, zzgi paramzzgi)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzhu.zza(paramInt, paramList, paramzzgi);
    }
  }
  
  public static void zza(int paramInt, List<Double> paramList, zzhu paramzzhu, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzhu.zzg(paramInt, paramList, paramBoolean);
    }
  }
  
  static <T, FT extends zzeh<FT>> void zza(zzea<FT> paramzzea, T paramT1, T paramT2)
  {
    paramT2 = paramzzea.zza(paramT2);
    if (!paramT2.zza.isEmpty()) {
      paramzzea.zzb(paramT1).zza(paramT2);
    }
  }
  
  static <T> void zza(zzfo paramzzfo, T paramT1, T paramT2, long paramLong)
  {
    zzhg.zza(paramT1, paramLong, paramzzfo.zza(zzhg.zzf(paramT1, paramLong), zzhg.zzf(paramT2, paramLong)));
  }
  
  static <T, UT, UB> void zza(zzha<UT, UB> paramzzha, T paramT1, T paramT2)
  {
    paramzzha.zza(paramT1, paramzzha.zzb(paramzzha.zza(paramT1), paramzzha.zza(paramT2)));
  }
  
  public static void zza(Class<?> paramClass)
  {
    if (!zzek.class.isAssignableFrom(paramClass))
    {
      Class localClass = zza;
      if ((localClass != null) && (!localClass.isAssignableFrom(paramClass))) {
        throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
      }
    }
  }
  
  static boolean zza(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  static int zzb(int paramInt, List<zzdj> paramList)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0) {
      return 0;
    }
    i *= zzdw.zze(paramInt);
    paramInt = j;
    j = i;
    while (paramInt < paramList.size())
    {
      j += zzdw.zzb((zzdj)paramList.get(paramInt));
      paramInt++;
    }
    return j;
  }
  
  static int zzb(int paramInt, List<zzfv> paramList, zzgi paramzzgi)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0) {
      return 0;
    }
    int k = 0;
    while (j < i)
    {
      k += zzdw.zzc(paramInt, (zzfv)paramList.get(j), paramzzgi);
      j++;
    }
    return k;
  }
  
  static int zzb(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzb(paramList) + i * zzdw.zze(paramInt);
  }
  
  static int zzb(List<Long> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzfj))
    {
      paramList = (zzfj)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzdw.zze(paramList.zza(k));
        k++;
      }
    }
    int m = 0;
    for (k = j;; k++)
    {
      j = m;
      if (k >= i) {
        break;
      }
      m += zzdw.zze(((Long)paramList.get(k)).longValue());
    }
    return j;
  }
  
  public static zzha<?, ?> zzb()
  {
    return zzc;
  }
  
  public static void zzb(int paramInt, List<zzdj> paramList, zzhu paramzzhu)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzhu.zzb(paramInt, paramList);
    }
  }
  
  public static void zzb(int paramInt, List<?> paramList, zzhu paramzzhu, zzgi paramzzgi)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzhu.zzb(paramInt, paramList, paramzzgi);
    }
  }
  
  public static void zzb(int paramInt, List<Float> paramList, zzhu paramzzhu, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzhu.zzf(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzc(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzc(paramList) + i * zzdw.zze(paramInt);
  }
  
  static int zzc(List<Long> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzfj))
    {
      paramList = (zzfj)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzdw.zzf(paramList.zza(k));
        k++;
      }
    }
    int m = 0;
    for (k = j;; k++)
    {
      j = m;
      if (k >= i) {
        break;
      }
      m += zzdw.zzf(((Long)paramList.get(k)).longValue());
    }
    return j;
  }
  
  public static zzha<?, ?> zzc()
  {
    return zzd;
  }
  
  public static void zzc(int paramInt, List<Long> paramList, zzhu paramzzhu, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzhu.zzc(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzd(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzd(paramList) + i * zzdw.zze(paramInt);
  }
  
  static int zzd(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzen))
    {
      paramList = (zzen)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzdw.zzk(paramList.zza(k));
        k++;
      }
    }
    int m = 0;
    for (k = j;; k++)
    {
      j = m;
      if (k >= i) {
        break;
      }
      m += zzdw.zzk(((Integer)paramList.get(k)).intValue());
    }
    return j;
  }
  
  private static Class<?> zzd()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.GeneratedMessage");
      return localClass;
    }
    finally {}
    return null;
  }
  
  public static void zzd(int paramInt, List<Long> paramList, zzhu paramzzhu, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzhu.zzd(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zze(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zze(paramList) + i * zzdw.zze(paramInt);
  }
  
  static int zze(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzen))
    {
      paramList = (zzen)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzdw.zzf(paramList.zza(k));
        k++;
      }
    }
    int m = 0;
    for (k = j;; k++)
    {
      j = m;
      if (k >= i) {
        break;
      }
      m += zzdw.zzf(((Integer)paramList.get(k)).intValue());
    }
    return j;
  }
  
  private static Class<?> zze()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
      return localClass;
    }
    finally {}
    return null;
  }
  
  public static void zze(int paramInt, List<Long> paramList, zzhu paramzzhu, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzhu.zzn(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzf(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzf(paramList) + i * zzdw.zze(paramInt);
  }
  
  static int zzf(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzen))
    {
      paramList = (zzen)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzdw.zzg(paramList.zza(k));
        k++;
      }
    }
    int m = 0;
    for (k = j;; k++)
    {
      j = m;
      if (k >= i) {
        break;
      }
      m += zzdw.zzg(((Integer)paramList.get(k)).intValue());
    }
    return j;
  }
  
  public static void zzf(int paramInt, List<Long> paramList, zzhu paramzzhu, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzhu.zze(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzg(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzg(paramList) + i * zzdw.zze(paramInt);
  }
  
  static int zzg(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzen))
    {
      paramList = (zzen)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzdw.zzh(paramList.zza(k));
        k++;
      }
    }
    int m = 0;
    for (k = j;; k++)
    {
      j = m;
      if (k >= i) {
        break;
      }
      m += zzdw.zzh(((Integer)paramList.get(k)).intValue());
    }
    return j;
  }
  
  public static void zzg(int paramInt, List<Long> paramList, zzhu paramzzhu, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzhu.zzl(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzh(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * zzdw.zzi(paramInt, 0);
  }
  
  static int zzh(List<?> paramList)
  {
    return paramList.size() << 2;
  }
  
  public static void zzh(int paramInt, List<Integer> paramList, zzhu paramzzhu, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzhu.zza(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzi(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * zzdw.zzg(paramInt, 0L);
  }
  
  static int zzi(List<?> paramList)
  {
    return paramList.size() << 3;
  }
  
  public static void zzi(int paramInt, List<Integer> paramList, zzhu paramzzhu, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzhu.zzj(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzj(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * zzdw.zzb(paramInt, true);
  }
  
  static int zzj(List<?> paramList)
  {
    return paramList.size();
  }
  
  public static void zzj(int paramInt, List<Integer> paramList, zzhu paramzzhu, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzhu.zzm(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzk(int paramInt, List<Integer> paramList, zzhu paramzzhu, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzhu.zzb(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzl(int paramInt, List<Integer> paramList, zzhu paramzzhu, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzhu.zzk(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzm(int paramInt, List<Integer> paramList, zzhu paramzzhu, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzhu.zzh(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzn(int paramInt, List<Boolean> paramList, zzhu paramzzhu, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzhu.zzi(paramInt, paramList, paramBoolean);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzgk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */