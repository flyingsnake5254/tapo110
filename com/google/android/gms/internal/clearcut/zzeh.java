package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzeh
{
  private static final Class<?> zzoh = ;
  private static final zzex<?, ?> zzoi = zzd(false);
  private static final zzex<?, ?> zzoj = zzd(true);
  private static final zzex<?, ?> zzok = new zzez();
  
  static int zza(List<Long> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzdc))
    {
      paramList = (zzdc)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzbn.zze(paramList.getLong(k));
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
      m += zzbn.zze(((Long)paramList.get(k)).longValue());
    }
    return j;
  }
  
  private static <UT, UB> UB zza(int paramInt1, int paramInt2, UB paramUB, zzex<UT, UB> paramzzex)
  {
    Object localObject = paramUB;
    if (paramUB == null) {
      localObject = paramzzex.zzdz();
    }
    paramzzex.zza(localObject, paramInt1, paramInt2);
    return (UB)localObject;
  }
  
  static <UT, UB> UB zza(int paramInt, List<Integer> paramList, zzck<?> paramzzck, UB paramUB, zzex<UT, UB> paramzzex)
  {
    if (paramzzck == null) {
      return paramUB;
    }
    int j;
    UB ?;
    if ((paramList instanceof RandomAccess))
    {
      int i = paramList.size();
      j = 0;
      int k = 0;
      while (j < i)
      {
        int m = ((Integer)paramList.get(j)).intValue();
        if (paramzzck.zzb(m) != null)
        {
          if (j != k) {
            paramList.set(k, Integer.valueOf(m));
          }
          k++;
        }
        else
        {
          paramUB = zza(paramInt, m, paramUB, paramzzex);
        }
        j++;
      }
      ? = paramUB;
      if (k != i)
      {
        paramList.subList(k, i).clear();
        ? = paramUB;
      }
    }
    else
    {
      paramList = paramList.iterator();
      for (;;)
      {
        ? = paramUB;
        if (!paramList.hasNext()) {
          break;
        }
        j = ((Integer)paramList.next()).intValue();
        if (paramzzck.zzb(j) == null)
        {
          paramUB = zza(paramInt, j, paramUB, paramzzex);
          paramList.remove();
        }
      }
    }
    return ?;
  }
  
  public static void zza(int paramInt, List<String> paramList, zzfr paramzzfr)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzfr.zza(paramInt, paramList);
    }
  }
  
  public static void zza(int paramInt, List<?> paramList, zzfr paramzzfr, zzef paramzzef)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzfr.zza(paramInt, paramList, paramzzef);
    }
  }
  
  public static void zza(int paramInt, List<Double> paramList, zzfr paramzzfr, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzfr.zzg(paramInt, paramList, paramBoolean);
    }
  }
  
  static <T, FT extends zzca<FT>> void zza(zzbu<FT> paramzzbu, T paramT1, T paramT2)
  {
    paramT2 = paramzzbu.zza(paramT2);
    if (!paramT2.isEmpty()) {
      paramzzbu.zzb(paramT1).zza(paramT2);
    }
  }
  
  static <T> void zza(zzdj paramzzdj, T paramT1, T paramT2, long paramLong)
  {
    zzfd.zza(paramT1, paramLong, paramzzdj.zzb(zzfd.zzo(paramT1, paramLong), zzfd.zzo(paramT2, paramLong)));
  }
  
  static <T, UT, UB> void zza(zzex<UT, UB> paramzzex, T paramT1, T paramT2)
  {
    paramzzex.zze(paramT1, paramzzex.zzg(paramzzex.zzq(paramT1), paramzzex.zzq(paramT2)));
  }
  
  static int zzb(List<Long> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzdc))
    {
      paramList = (zzdc)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzbn.zzf(paramList.getLong(k));
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
      m += zzbn.zzf(((Long)paramList.get(k)).longValue());
    }
    return j;
  }
  
  public static void zzb(int paramInt, List<zzbb> paramList, zzfr paramzzfr)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzfr.zzb(paramInt, paramList);
    }
  }
  
  public static void zzb(int paramInt, List<?> paramList, zzfr paramzzfr, zzef paramzzef)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzfr.zzb(paramInt, paramList, paramzzef);
    }
  }
  
  public static void zzb(int paramInt, List<Float> paramList, zzfr paramzzfr, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzfr.zzf(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzc(int paramInt, Object paramObject, zzef paramzzef)
  {
    if ((paramObject instanceof zzcv)) {
      return zzbn.zza(paramInt, (zzcv)paramObject);
    }
    return zzbn.zzb(paramInt, (zzdo)paramObject, paramzzef);
  }
  
  static int zzc(int paramInt, List<?> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    int m = zzbn.zzr(paramInt) * i;
    paramInt = m;
    Object localObject;
    if ((paramList instanceof zzcx))
    {
      localObject = (zzcx)paramList;
      paramInt = m;
      for (j = k;; j++)
      {
        m = paramInt;
        if (j >= i) {
          break;
        }
        paramList = ((zzcx)localObject).getRaw(j);
        if ((paramList instanceof zzbb)) {
          m = zzbn.zzb((zzbb)paramList);
        } else {
          m = zzbn.zzh((String)paramList);
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
      if ((localObject instanceof zzbb)) {
        m = zzbn.zzb((zzbb)localObject);
      } else {
        m = zzbn.zzh((String)localObject);
      }
      paramInt += m;
      j++;
    }
    return m;
  }
  
  static int zzc(int paramInt, List<?> paramList, zzef paramzzef)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0) {
      return 0;
    }
    paramInt = zzbn.zzr(paramInt) * i;
    while (j < i)
    {
      Object localObject = paramList.get(j);
      int k;
      if ((localObject instanceof zzcv)) {
        k = zzbn.zza((zzcv)localObject);
      } else {
        k = zzbn.zzb((zzdo)localObject, paramzzef);
      }
      paramInt += k;
      j++;
    }
    return paramInt;
  }
  
  static int zzc(List<Long> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzdc))
    {
      paramList = (zzdc)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzbn.zzg(paramList.getLong(k));
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
      m += zzbn.zzg(((Long)paramList.get(k)).longValue());
    }
    return j;
  }
  
  public static void zzc(int paramInt, List<Long> paramList, zzfr paramzzfr, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzfr.zzc(paramInt, paramList, paramBoolean);
    }
  }
  
  public static boolean zzc(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 < 40) {
      return true;
    }
    long l1 = paramInt2;
    long l2 = paramInt1;
    long l3 = paramInt3;
    return l1 - l2 + 1L + 9L <= 2L * l3 + 3L + (l3 + 3L) * 3L;
  }
  
  static int zzd(int paramInt, List<zzbb> paramList)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0) {
      return 0;
    }
    i *= zzbn.zzr(paramInt);
    paramInt = j;
    j = i;
    while (paramInt < paramList.size())
    {
      j += zzbn.zzb((zzbb)paramList.get(paramInt));
      paramInt++;
    }
    return j;
  }
  
  static int zzd(int paramInt, List<zzdo> paramList, zzef paramzzef)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0) {
      return 0;
    }
    int k = 0;
    while (j < i)
    {
      k += zzbn.zzc(paramInt, (zzdo)paramList.get(j), paramzzef);
      j++;
    }
    return k;
  }
  
  static int zzd(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzch))
    {
      paramList = (zzch)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzbn.zzx(paramList.getInt(k));
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
      m += zzbn.zzx(((Integer)paramList.get(k)).intValue());
    }
    return j;
  }
  
  private static zzex<?, ?> zzd(boolean paramBoolean)
  {
    try
    {
      Object localObject1 = zzdq();
      if (localObject1 == null) {
        return null;
      }
      localObject1 = (zzex)((Class)localObject1).getConstructor(new Class[] { Boolean.TYPE }).newInstance(new Object[] { Boolean.valueOf(paramBoolean) });
      return (zzex<?, ?>)localObject1;
    }
    finally {}
    return null;
  }
  
  public static void zzd(int paramInt, List<Long> paramList, zzfr paramzzfr, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzfr.zzd(paramInt, paramList, paramBoolean);
    }
  }
  
  static boolean zzd(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static zzex<?, ?> zzdm()
  {
    return zzoi;
  }
  
  public static zzex<?, ?> zzdn()
  {
    return zzoj;
  }
  
  public static zzex<?, ?> zzdo()
  {
    return zzok;
  }
  
  private static Class<?> zzdp()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.GeneratedMessage");
      return localClass;
    }
    finally {}
    return null;
  }
  
  private static Class<?> zzdq()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
      return localClass;
    }
    finally {}
    return null;
  }
  
  static int zze(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzch))
    {
      paramList = (zzch)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzbn.zzs(paramList.getInt(k));
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
      m += zzbn.zzs(((Integer)paramList.get(k)).intValue());
    }
    return j;
  }
  
  public static void zze(int paramInt, List<Long> paramList, zzfr paramzzfr, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzfr.zzn(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzf(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzch))
    {
      paramList = (zzch)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzbn.zzt(paramList.getInt(k));
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
      m += zzbn.zzt(((Integer)paramList.get(k)).intValue());
    }
    return j;
  }
  
  public static void zzf(int paramInt, List<Long> paramList, zzfr paramzzfr, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzfr.zze(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzf(Class<?> paramClass)
  {
    if (!zzcg.class.isAssignableFrom(paramClass))
    {
      Class localClass = zzoh;
      if ((localClass != null) && (!localClass.isAssignableFrom(paramClass))) {
        throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
      }
    }
  }
  
  static int zzg(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzch))
    {
      paramList = (zzch)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzbn.zzu(paramList.getInt(k));
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
      m += zzbn.zzu(((Integer)paramList.get(k)).intValue());
    }
    return j;
  }
  
  public static void zzg(int paramInt, List<Long> paramList, zzfr paramzzfr, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzfr.zzl(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzh(List<?> paramList)
  {
    return paramList.size() << 2;
  }
  
  public static void zzh(int paramInt, List<Integer> paramList, zzfr paramzzfr, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzfr.zza(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzi(List<?> paramList)
  {
    return paramList.size() << 3;
  }
  
  public static void zzi(int paramInt, List<Integer> paramList, zzfr paramzzfr, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzfr.zzj(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzj(List<?> paramList)
  {
    return paramList.size();
  }
  
  public static void zzj(int paramInt, List<Integer> paramList, zzfr paramzzfr, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzfr.zzm(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzk(int paramInt, List<Integer> paramList, zzfr paramzzfr, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzfr.zzb(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzl(int paramInt, List<Integer> paramList, zzfr paramzzfr, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzfr.zzk(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzm(int paramInt, List<Integer> paramList, zzfr paramzzfr, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzfr.zzh(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzn(int paramInt, List<Boolean> paramList, zzfr paramzzfr, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzfr.zzi(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzo(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    if (paramList.size() == 0) {
      return 0;
    }
    return zza(paramList) + paramList.size() * zzbn.zzr(paramInt);
  }
  
  static int zzp(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzb(paramList) + i * zzbn.zzr(paramInt);
  }
  
  static int zzq(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzc(paramList) + i * zzbn.zzr(paramInt);
  }
  
  static int zzr(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzd(paramList) + i * zzbn.zzr(paramInt);
  }
  
  static int zzs(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zze(paramList) + i * zzbn.zzr(paramInt);
  }
  
  static int zzt(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzf(paramList) + i * zzbn.zzr(paramInt);
  }
  
  static int zzu(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzg(paramList) + i * zzbn.zzr(paramInt);
  }
  
  static int zzv(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * zzbn.zzj(paramInt, 0);
  }
  
  static int zzw(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * zzbn.zzg(paramInt, 0L);
  }
  
  static int zzx(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * zzbn.zzc(paramInt, true);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzeh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */