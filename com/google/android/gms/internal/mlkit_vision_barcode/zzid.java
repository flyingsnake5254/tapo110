package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.AbstractMap;
import java.util.List;

final class zzid
{
  private static final Class<?> zza = ;
  private static final zzit<?, ?> zzb = zza(false);
  private static final zzit<?, ?> zzc = zza(true);
  private static final zzit<?, ?> zzd = new zziv();
  
  static int zza(int paramInt, Object paramObject, zzib paramzzib)
  {
    if ((paramObject instanceof zzgt)) {
      return zzfn.zza(paramInt, (zzgt)paramObject);
    }
    return zzfn.zzb(paramInt, (zzhk)paramObject, paramzzib);
  }
  
  static int zza(int paramInt, List<?> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    int m = zzfn.zze(paramInt) * i;
    paramInt = m;
    Object localObject;
    if ((paramList instanceof zzgv))
    {
      paramList = (zzgv)paramList;
      paramInt = m;
      for (j = k;; j++)
      {
        m = paramInt;
        if (j >= i) {
          break;
        }
        localObject = paramList.zzb(j);
        if ((localObject instanceof zzew)) {
          m = zzfn.zzb((zzew)localObject);
        } else {
          m = zzfn.zzb((String)localObject);
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
      if ((localObject instanceof zzew)) {
        m = zzfn.zzb((zzew)localObject);
      } else {
        m = zzfn.zzb((String)localObject);
      }
      paramInt += m;
      j++;
    }
    return m;
  }
  
  static int zza(int paramInt, List<?> paramList, zzib paramzzib)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0) {
      return 0;
    }
    int k = zzfn.zze(paramInt) * i;
    for (paramInt = j; paramInt < i; paramInt++)
    {
      Object localObject = paramList.get(paramInt);
      if ((localObject instanceof zzgt)) {
        j = zzfn.zza((zzgt)localObject);
      } else {
        j = zzfn.zza((zzhk)localObject, paramzzib);
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
    return zza(paramList) + paramList.size() * zzfn.zze(paramInt);
  }
  
  static int zza(List<Long> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzgy))
    {
      paramList = (zzgy)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzfn.zzd(paramList.zzb(k));
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
      m += zzfn.zzd(((Long)paramList.get(k)).longValue());
    }
    return j;
  }
  
  public static zzit<?, ?> zza()
  {
    return zzb;
  }
  
  private static zzit<?, ?> zza(boolean paramBoolean)
  {
    try
    {
      Object localObject1 = zze();
      if (localObject1 == null) {
        return null;
      }
      localObject1 = (zzit)((Class)localObject1).getConstructor(new Class[] { Boolean.TYPE }).newInstance(new Object[] { Boolean.valueOf(paramBoolean) });
      return (zzit<?, ?>)localObject1;
    }
    finally {}
    return null;
  }
  
  public static void zza(int paramInt, List<String> paramList, zzjn paramzzjn)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzjn.zza(paramInt, paramList);
    }
  }
  
  public static void zza(int paramInt, List<?> paramList, zzjn paramzzjn, zzib paramzzib)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzjn.zza(paramInt, paramList, paramzzib);
    }
  }
  
  public static void zza(int paramInt, List<Double> paramList, zzjn paramzzjn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzjn.zzg(paramInt, paramList, paramBoolean);
    }
  }
  
  static <T, FT extends zzfu<FT>> void zza(zzfr<FT> paramzzfr, T paramT1, T paramT2)
  {
    paramT2 = paramzzfr.zza(paramT2);
    if (!paramT2.zza.isEmpty()) {
      paramzzfr.zzb(paramT1).zza(paramT2);
    }
  }
  
  static <T> void zza(zzhh paramzzhh, T paramT1, T paramT2, long paramLong)
  {
    zziz.zza(paramT1, paramLong, paramzzhh.zza(zziz.zzf(paramT1, paramLong), zziz.zzf(paramT2, paramLong)));
  }
  
  static <T, UT, UB> void zza(zzit<UT, UB> paramzzit, T paramT1, T paramT2)
  {
    paramzzit.zza(paramT1, paramzzit.zzb(paramzzit.zza(paramT1), paramzzit.zza(paramT2)));
  }
  
  public static void zza(Class<?> paramClass)
  {
    if (!zzga.class.isAssignableFrom(paramClass))
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
  
  static int zzb(int paramInt, List<zzew> paramList)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0) {
      return 0;
    }
    i *= zzfn.zze(paramInt);
    paramInt = j;
    j = i;
    while (paramInt < paramList.size())
    {
      j += zzfn.zzb((zzew)paramList.get(paramInt));
      paramInt++;
    }
    return j;
  }
  
  static int zzb(int paramInt, List<zzhk> paramList, zzib paramzzib)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0) {
      return 0;
    }
    int k = 0;
    while (j < i)
    {
      k += zzfn.zzc(paramInt, (zzhk)paramList.get(j), paramzzib);
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
    return zzb(paramList) + i * zzfn.zze(paramInt);
  }
  
  static int zzb(List<Long> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzgy))
    {
      paramList = (zzgy)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzfn.zze(paramList.zzb(k));
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
      m += zzfn.zze(((Long)paramList.get(k)).longValue());
    }
    return j;
  }
  
  public static zzit<?, ?> zzb()
  {
    return zzc;
  }
  
  public static void zzb(int paramInt, List<zzew> paramList, zzjn paramzzjn)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzjn.zzb(paramInt, paramList);
    }
  }
  
  public static void zzb(int paramInt, List<?> paramList, zzjn paramzzjn, zzib paramzzib)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzjn.zzb(paramInt, paramList, paramzzib);
    }
  }
  
  public static void zzb(int paramInt, List<Float> paramList, zzjn paramzzjn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzjn.zzf(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzc(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzc(paramList) + i * zzfn.zze(paramInt);
  }
  
  static int zzc(List<Long> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzgy))
    {
      paramList = (zzgy)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzfn.zzf(paramList.zzb(k));
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
      m += zzfn.zzf(((Long)paramList.get(k)).longValue());
    }
    return j;
  }
  
  public static zzit<?, ?> zzc()
  {
    return zzd;
  }
  
  public static void zzc(int paramInt, List<Long> paramList, zzjn paramzzjn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzjn.zzc(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzd(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzd(paramList) + i * zzfn.zze(paramInt);
  }
  
  static int zzd(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzgd))
    {
      paramList = (zzgd)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzfn.zzk(paramList.zzc(k));
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
      m += zzfn.zzk(((Integer)paramList.get(k)).intValue());
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
  
  public static void zzd(int paramInt, List<Long> paramList, zzjn paramzzjn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzjn.zzd(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zze(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zze(paramList) + i * zzfn.zze(paramInt);
  }
  
  static int zze(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzgd))
    {
      paramList = (zzgd)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzfn.zzf(paramList.zzc(k));
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
      m += zzfn.zzf(((Integer)paramList.get(k)).intValue());
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
  
  public static void zze(int paramInt, List<Long> paramList, zzjn paramzzjn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzjn.zzn(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzf(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzf(paramList) + i * zzfn.zze(paramInt);
  }
  
  static int zzf(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzgd))
    {
      paramList = (zzgd)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzfn.zzg(paramList.zzc(k));
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
      m += zzfn.zzg(((Integer)paramList.get(k)).intValue());
    }
    return j;
  }
  
  public static void zzf(int paramInt, List<Long> paramList, zzjn paramzzjn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzjn.zze(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzg(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzg(paramList) + i * zzfn.zze(paramInt);
  }
  
  static int zzg(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzgd))
    {
      paramList = (zzgd)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzfn.zzh(paramList.zzc(k));
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
      m += zzfn.zzh(((Integer)paramList.get(k)).intValue());
    }
    return j;
  }
  
  public static void zzg(int paramInt, List<Long> paramList, zzjn paramzzjn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzjn.zzl(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzh(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * zzfn.zzi(paramInt, 0);
  }
  
  static int zzh(List<?> paramList)
  {
    return paramList.size() << 2;
  }
  
  public static void zzh(int paramInt, List<Integer> paramList, zzjn paramzzjn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzjn.zza(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzi(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * zzfn.zzg(paramInt, 0L);
  }
  
  static int zzi(List<?> paramList)
  {
    return paramList.size() << 3;
  }
  
  public static void zzi(int paramInt, List<Integer> paramList, zzjn paramzzjn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzjn.zzj(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzj(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * zzfn.zzb(paramInt, true);
  }
  
  static int zzj(List<?> paramList)
  {
    return paramList.size();
  }
  
  public static void zzj(int paramInt, List<Integer> paramList, zzjn paramzzjn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzjn.zzm(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzk(int paramInt, List<Integer> paramList, zzjn paramzzjn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzjn.zzb(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzl(int paramInt, List<Integer> paramList, zzjn paramzzjn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzjn.zzk(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzm(int paramInt, List<Integer> paramList, zzjn paramzzjn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzjn.zzh(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzn(int paramInt, List<Boolean> paramList, zzjn paramzzjn, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzjn.zzi(paramInt, paramList, paramBoolean);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */