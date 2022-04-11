package com.google.android.gms.internal.mlkit_common;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.AbstractMap;
import java.util.List;

final class zzha
{
  private static final Class<?> zza = ;
  private static final zzhq<?, ?> zzb = zza(false);
  private static final zzhq<?, ?> zzc = zza(true);
  private static final zzhq<?, ?> zzd = new zzhs();
  
  static int zza(int paramInt, Object paramObject, zzgy paramzzgy)
  {
    if ((paramObject instanceof zzfq)) {
      return zzem.zza(paramInt, (zzfq)paramObject);
    }
    return zzem.zzb(paramInt, (zzgh)paramObject, paramzzgy);
  }
  
  static int zza(int paramInt, List<?> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    int m = zzem.zze(paramInt) * i;
    paramInt = m;
    Object localObject;
    if ((paramList instanceof zzfs))
    {
      paramList = (zzfs)paramList;
      paramInt = m;
      for (j = k;; j++)
      {
        m = paramInt;
        if (j >= i) {
          break;
        }
        localObject = paramList.zza(j);
        if ((localObject instanceof zzdv)) {
          m = zzem.zzb((zzdv)localObject);
        } else {
          m = zzem.zzb((String)localObject);
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
      if ((localObject instanceof zzdv)) {
        m = zzem.zzb((zzdv)localObject);
      } else {
        m = zzem.zzb((String)localObject);
      }
      paramInt += m;
      j++;
    }
    return m;
  }
  
  static int zza(int paramInt, List<?> paramList, zzgy paramzzgy)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0) {
      return 0;
    }
    int k = zzem.zze(paramInt) * i;
    for (paramInt = j; paramInt < i; paramInt++)
    {
      Object localObject = paramList.get(paramInt);
      if ((localObject instanceof zzfq)) {
        j = zzem.zza((zzfq)localObject);
      } else {
        j = zzem.zza((zzgh)localObject, paramzzgy);
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
    return zza(paramList) + paramList.size() * zzem.zze(paramInt);
  }
  
  static int zza(List<Long> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzfv))
    {
      paramList = (zzfv)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzem.zzd(paramList.zza(k));
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
      m += zzem.zzd(((Long)paramList.get(k)).longValue());
    }
    return j;
  }
  
  public static zzhq<?, ?> zza()
  {
    return zzb;
  }
  
  private static zzhq<?, ?> zza(boolean paramBoolean)
  {
    try
    {
      Object localObject1 = zze();
      if (localObject1 == null) {
        return null;
      }
      localObject1 = (zzhq)((Class)localObject1).getConstructor(new Class[] { Boolean.TYPE }).newInstance(new Object[] { Boolean.valueOf(paramBoolean) });
      return (zzhq<?, ?>)localObject1;
    }
    finally {}
    return null;
  }
  
  public static void zza(int paramInt, List<String> paramList, zzik paramzzik)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzik.zza(paramInt, paramList);
    }
  }
  
  public static void zza(int paramInt, List<?> paramList, zzik paramzzik, zzgy paramzzgy)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzik.zza(paramInt, paramList, paramzzgy);
    }
  }
  
  public static void zza(int paramInt, List<Double> paramList, zzik paramzzik, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzik.zzg(paramInt, paramList, paramBoolean);
    }
  }
  
  static <T, FT extends zzet<FT>> void zza(zzeq<FT> paramzzeq, T paramT1, T paramT2)
  {
    paramT2 = paramzzeq.zza(paramT2);
    if (!paramT2.zza.isEmpty()) {
      paramzzeq.zzb(paramT1).zza(paramT2);
    }
  }
  
  static <T> void zza(zzge paramzzge, T paramT1, T paramT2, long paramLong)
  {
    zzhw.zza(paramT1, paramLong, paramzzge.zza(zzhw.zzf(paramT1, paramLong), zzhw.zzf(paramT2, paramLong)));
  }
  
  static <T, UT, UB> void zza(zzhq<UT, UB> paramzzhq, T paramT1, T paramT2)
  {
    paramzzhq.zza(paramT1, paramzzhq.zzb(paramzzhq.zza(paramT1), paramzzhq.zza(paramT2)));
  }
  
  public static void zza(Class<?> paramClass)
  {
    if (!zzez.class.isAssignableFrom(paramClass))
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
  
  static int zzb(int paramInt, List<zzdv> paramList)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0) {
      return 0;
    }
    i *= zzem.zze(paramInt);
    paramInt = j;
    j = i;
    while (paramInt < paramList.size())
    {
      j += zzem.zzb((zzdv)paramList.get(paramInt));
      paramInt++;
    }
    return j;
  }
  
  static int zzb(int paramInt, List<zzgh> paramList, zzgy paramzzgy)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0) {
      return 0;
    }
    int k = 0;
    while (j < i)
    {
      k += zzem.zzc(paramInt, (zzgh)paramList.get(j), paramzzgy);
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
    return zzb(paramList) + i * zzem.zze(paramInt);
  }
  
  static int zzb(List<Long> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzfv))
    {
      paramList = (zzfv)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzem.zze(paramList.zza(k));
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
      m += zzem.zze(((Long)paramList.get(k)).longValue());
    }
    return j;
  }
  
  public static zzhq<?, ?> zzb()
  {
    return zzc;
  }
  
  public static void zzb(int paramInt, List<zzdv> paramList, zzik paramzzik)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzik.zzb(paramInt, paramList);
    }
  }
  
  public static void zzb(int paramInt, List<?> paramList, zzik paramzzik, zzgy paramzzgy)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzik.zzb(paramInt, paramList, paramzzgy);
    }
  }
  
  public static void zzb(int paramInt, List<Float> paramList, zzik paramzzik, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzik.zzf(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzc(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzc(paramList) + i * zzem.zze(paramInt);
  }
  
  static int zzc(List<Long> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzfv))
    {
      paramList = (zzfv)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzem.zzf(paramList.zza(k));
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
      m += zzem.zzf(((Long)paramList.get(k)).longValue());
    }
    return j;
  }
  
  public static zzhq<?, ?> zzc()
  {
    return zzd;
  }
  
  public static void zzc(int paramInt, List<Long> paramList, zzik paramzzik, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzik.zzc(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzd(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzd(paramList) + i * zzem.zze(paramInt);
  }
  
  static int zzd(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzfa))
    {
      paramList = (zzfa)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzem.zzk(paramList.zza(k));
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
      m += zzem.zzk(((Integer)paramList.get(k)).intValue());
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
  
  public static void zzd(int paramInt, List<Long> paramList, zzik paramzzik, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzik.zzd(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zze(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zze(paramList) + i * zzem.zze(paramInt);
  }
  
  static int zze(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzfa))
    {
      paramList = (zzfa)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzem.zzf(paramList.zza(k));
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
      m += zzem.zzf(((Integer)paramList.get(k)).intValue());
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
  
  public static void zze(int paramInt, List<Long> paramList, zzik paramzzik, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzik.zzn(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzf(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzf(paramList) + i * zzem.zze(paramInt);
  }
  
  static int zzf(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzfa))
    {
      paramList = (zzfa)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzem.zzg(paramList.zza(k));
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
      m += zzem.zzg(((Integer)paramList.get(k)).intValue());
    }
    return j;
  }
  
  public static void zzf(int paramInt, List<Long> paramList, zzik paramzzik, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzik.zze(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzg(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzg(paramList) + i * zzem.zze(paramInt);
  }
  
  static int zzg(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzfa))
    {
      paramList = (zzfa)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzem.zzh(paramList.zza(k));
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
      m += zzem.zzh(((Integer)paramList.get(k)).intValue());
    }
    return j;
  }
  
  public static void zzg(int paramInt, List<Long> paramList, zzik paramzzik, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzik.zzl(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzh(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * zzem.zzi(paramInt, 0);
  }
  
  static int zzh(List<?> paramList)
  {
    return paramList.size() << 2;
  }
  
  public static void zzh(int paramInt, List<Integer> paramList, zzik paramzzik, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzik.zza(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzi(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * zzem.zzg(paramInt, 0L);
  }
  
  static int zzi(List<?> paramList)
  {
    return paramList.size() << 3;
  }
  
  public static void zzi(int paramInt, List<Integer> paramList, zzik paramzzik, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzik.zzj(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzj(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * zzem.zzb(paramInt, true);
  }
  
  static int zzj(List<?> paramList)
  {
    return paramList.size();
  }
  
  public static void zzj(int paramInt, List<Integer> paramList, zzik paramzzik, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzik.zzm(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzk(int paramInt, List<Integer> paramList, zzik paramzzik, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzik.zzb(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzl(int paramInt, List<Integer> paramList, zzik paramzzik, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzik.zzk(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzm(int paramInt, List<Integer> paramList, zzik paramzzik, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzik.zzh(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzn(int paramInt, List<Boolean> paramList, zzik paramzzik, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzik.zzi(paramInt, paramList, paramBoolean);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */