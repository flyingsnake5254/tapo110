package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zziy
{
  private static final Class<?> zzaag = ;
  private static final zzjo<?, ?> zzaah = zzn(false);
  private static final zzjo<?, ?> zzaai = zzn(true);
  private static final zzjo<?, ?> zzaaj = new zzjq();
  
  static <UT, UB> UB zza(int paramInt1, int paramInt2, UB paramUB, zzjo<UT, UB> paramzzjo)
  {
    Object localObject = paramUB;
    if (paramUB == null) {
      localObject = paramzzjo.zzig();
    }
    paramzzjo.zza(localObject, paramInt1, paramInt2);
    return (UB)localObject;
  }
  
  static <UT, UB> UB zza(int paramInt, List<Integer> paramList, zzha<?> paramzzha, UB paramUB, zzjo<UT, UB> paramzzjo)
  {
    if (paramzzha == null) {
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
        if (paramzzha.zzh(m) != null)
        {
          if (j != k) {
            paramList.set(k, Integer.valueOf(m));
          }
          k++;
        }
        else
        {
          paramUB = zza(paramInt, m, paramUB, paramzzjo);
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
        if (paramzzha.zzh(j) == null)
        {
          paramUB = zza(paramInt, j, paramUB, paramzzjo);
          paramList.remove();
        }
      }
    }
    return ?;
  }
  
  static <UT, UB> UB zza(int paramInt, List<Integer> paramList, zzhd paramzzhd, UB paramUB, zzjo<UT, UB> paramzzjo)
  {
    if (paramzzhd == null) {
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
        if (paramzzhd.zzg(m))
        {
          if (j != k) {
            paramList.set(k, Integer.valueOf(m));
          }
          k++;
        }
        else
        {
          paramUB = zza(paramInt, m, paramUB, paramzzjo);
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
        if (!paramzzhd.zzg(j))
        {
          paramUB = zza(paramInt, j, paramUB, paramzzjo);
          paramList.remove();
        }
      }
    }
    return ?;
  }
  
  public static void zza(int paramInt, List<String> paramList, zzkl paramzzkl)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzkl.zza(paramInt, paramList);
    }
  }
  
  public static void zza(int paramInt, List<?> paramList, zzkl paramzzkl, zziw paramzziw)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzkl.zza(paramInt, paramList, paramzziw);
    }
  }
  
  public static void zza(int paramInt, List<Double> paramList, zzkl paramzzkl, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzkl.zzg(paramInt, paramList, paramBoolean);
    }
  }
  
  static <T, FT extends zzgp<FT>> void zza(zzgk<FT> paramzzgk, T paramT1, T paramT2)
  {
    paramT2 = paramzzgk.zzf(paramT2);
    if (!paramT2.zztq.isEmpty()) {
      paramzzgk.zzg(paramT1).zza(paramT2);
    }
  }
  
  static <T> void zza(zzia paramzzia, T paramT1, T paramT2, long paramLong)
  {
    zzju.zza(paramT1, paramLong, paramzzia.zzc(zzju.zzp(paramT1, paramLong), zzju.zzp(paramT2, paramLong)));
  }
  
  static <T, UT, UB> void zza(zzjo<UT, UB> paramzzjo, T paramT1, T paramT2)
  {
    paramzzjo.zzf(paramT1, paramzzjo.zzh(paramzzjo.zzw(paramT1), paramzzjo.zzw(paramT2)));
  }
  
  public static void zzb(int paramInt, List<zzfm> paramList, zzkl paramzzkl)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzkl.zzb(paramInt, paramList);
    }
  }
  
  public static void zzb(int paramInt, List<?> paramList, zzkl paramzzkl, zziw paramzziw)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzkl.zzb(paramInt, paramList, paramzziw);
    }
  }
  
  public static void zzb(int paramInt, List<Float> paramList, zzkl paramzzkl, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzkl.zzf(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzc(int paramInt, Object paramObject, zziw paramzziw)
  {
    if ((paramObject instanceof zzhm)) {
      return zzgf.zza(paramInt, (zzhm)paramObject);
    }
    return zzgf.zzb(paramInt, (zzih)paramObject, paramzziw);
  }
  
  static int zzc(int paramInt, List<?> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    int m = zzgf.zzbb(paramInt) * i;
    paramInt = m;
    Object localObject;
    if ((paramList instanceof zzho))
    {
      paramList = (zzho)paramList;
      paramInt = m;
      for (j = k;; j++)
      {
        m = paramInt;
        if (j >= i) {
          break;
        }
        localObject = paramList.getRaw(j);
        if ((localObject instanceof zzfm)) {
          m = zzgf.zzb((zzfm)localObject);
        } else {
          m = zzgf.zzy((String)localObject);
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
      if ((localObject instanceof zzfm)) {
        m = zzgf.zzb((zzfm)localObject);
      } else {
        m = zzgf.zzy((String)localObject);
      }
      paramInt += m;
      j++;
    }
    return m;
  }
  
  static int zzc(int paramInt, List<?> paramList, zziw paramzziw)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0) {
      return 0;
    }
    paramInt = zzgf.zzbb(paramInt) * i;
    while (j < i)
    {
      Object localObject = paramList.get(j);
      int k;
      if ((localObject instanceof zzhm)) {
        k = zzgf.zza((zzhm)localObject);
      } else {
        k = zzgf.zza((zzih)localObject, paramzziw);
      }
      paramInt += k;
      j++;
    }
    return paramInt;
  }
  
  public static void zzc(int paramInt, List<Long> paramList, zzkl paramzzkl, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzkl.zzc(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzd(int paramInt, List<zzfm> paramList)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0) {
      return 0;
    }
    i *= zzgf.zzbb(paramInt);
    paramInt = j;
    j = i;
    while (paramInt < paramList.size())
    {
      j += zzgf.zzb((zzfm)paramList.get(paramInt));
      paramInt++;
    }
    return j;
  }
  
  static int zzd(int paramInt, List<zzih> paramList, zziw paramzziw)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0) {
      return 0;
    }
    int k = 0;
    while (j < i)
    {
      k += zzgf.zzc(paramInt, (zzih)paramList.get(j), paramzziw);
      j++;
    }
    return k;
  }
  
  public static void zzd(int paramInt, List<Long> paramList, zzkl paramzzkl, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzkl.zzd(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zze(int paramInt, List<Long> paramList, zzkl paramzzkl, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzkl.zzn(paramInt, paramList, paramBoolean);
    }
  }
  
  static boolean zze(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static void zzf(int paramInt, List<Long> paramList, zzkl paramzzkl, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzkl.zze(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzg(int paramInt, List<Long> paramList, zzkl paramzzkl, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzkl.zzl(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzg(Class<?> paramClass)
  {
    if (!zzgx.class.isAssignableFrom(paramClass))
    {
      Class localClass = zzaag;
      if ((localClass != null) && (!localClass.isAssignableFrom(paramClass))) {
        throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
      }
    }
  }
  
  public static void zzh(int paramInt, List<Integer> paramList, zzkl paramzzkl, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzkl.zza(paramInt, paramList, paramBoolean);
    }
  }
  
  public static zzjo<?, ?> zzht()
  {
    return zzaah;
  }
  
  public static zzjo<?, ?> zzhu()
  {
    return zzaai;
  }
  
  public static zzjo<?, ?> zzhv()
  {
    return zzaaj;
  }
  
  private static Class<?> zzhw()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.GeneratedMessage");
      return localClass;
    }
    finally {}
    return null;
  }
  
  private static Class<?> zzhx()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
      return localClass;
    }
    finally {}
    return null;
  }
  
  public static void zzi(int paramInt, List<Integer> paramList, zzkl paramzzkl, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzkl.zzj(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzj(int paramInt, List<Integer> paramList, zzkl paramzzkl, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzkl.zzm(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzk(int paramInt, List<Integer> paramList, zzkl paramzzkl, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzkl.zzb(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzl(int paramInt, List<Integer> paramList, zzkl paramzzkl, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzkl.zzk(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzm(int paramInt, List<Integer> paramList, zzkl paramzzkl, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzkl.zzh(paramInt, paramList, paramBoolean);
    }
  }
  
  private static zzjo<?, ?> zzn(boolean paramBoolean)
  {
    try
    {
      Object localObject1 = zzhx();
      if (localObject1 == null) {
        return null;
      }
      localObject1 = (zzjo)((Class)localObject1).getConstructor(new Class[] { Boolean.TYPE }).newInstance(new Object[] { Boolean.valueOf(paramBoolean) });
      return (zzjo<?, ?>)localObject1;
    }
    finally {}
    return null;
  }
  
  public static void zzn(int paramInt, List<Boolean> paramList, zzkl paramzzkl, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzkl.zzi(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzo(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    if (paramList.size() == 0) {
      return 0;
    }
    return zzq(paramList) + paramList.size() * zzgf.zzbb(paramInt);
  }
  
  static int zzp(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzr(paramList) + i * zzgf.zzbb(paramInt);
  }
  
  static int zzq(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzs(paramList) + i * zzgf.zzbb(paramInt);
  }
  
  static int zzq(List<Long> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzhv))
    {
      paramList = (zzhv)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzgf.zzv(paramList.getLong(k));
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
      m += zzgf.zzv(((Long)paramList.get(k)).longValue());
    }
    return j;
  }
  
  static int zzr(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzt(paramList) + i * zzgf.zzbb(paramInt);
  }
  
  static int zzr(List<Long> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzhv))
    {
      paramList = (zzhv)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzgf.zzw(paramList.getLong(k));
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
      m += zzgf.zzw(((Long)paramList.get(k)).longValue());
    }
    return j;
  }
  
  static int zzs(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzu(paramList) + i * zzgf.zzbb(paramInt);
  }
  
  static int zzs(List<Long> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzhv))
    {
      paramList = (zzhv)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzgf.zzx(paramList.getLong(k));
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
      m += zzgf.zzx(((Long)paramList.get(k)).longValue());
    }
    return j;
  }
  
  static int zzt(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzv(paramList) + i * zzgf.zzbb(paramInt);
  }
  
  static int zzt(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzgz))
    {
      paramList = (zzgz)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzgf.zzbh(paramList.getInt(k));
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
      m += zzgf.zzbh(((Integer)paramList.get(k)).intValue());
    }
    return j;
  }
  
  static int zzu(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzw(paramList) + i * zzgf.zzbb(paramInt);
  }
  
  static int zzu(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzgz))
    {
      paramList = (zzgz)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzgf.zzbc(paramList.getInt(k));
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
      m += zzgf.zzbc(((Integer)paramList.get(k)).intValue());
    }
    return j;
  }
  
  static int zzv(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * zzgf.zzo(paramInt, 0);
  }
  
  static int zzv(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzgz))
    {
      paramList = (zzgz)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzgf.zzbd(paramList.getInt(k));
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
      m += zzgf.zzbd(((Integer)paramList.get(k)).intValue());
    }
    return j;
  }
  
  static int zzw(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * zzgf.zzg(paramInt, 0L);
  }
  
  static int zzw(List<Integer> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0) {
      return 0;
    }
    if ((paramList instanceof zzgz))
    {
      paramList = (zzgz)paramList;
      m = 0;
      for (;;)
      {
        j = m;
        if (k >= i) {
          break;
        }
        m += zzgf.zzbe(paramList.getInt(k));
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
      m += zzgf.zzbe(((Integer)paramList.get(k)).intValue());
    }
    return j;
  }
  
  static int zzx(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * zzgf.zzb(paramInt, true);
  }
  
  static int zzx(List<?> paramList)
  {
    return paramList.size() << 2;
  }
  
  static int zzy(List<?> paramList)
  {
    return paramList.size() << 3;
  }
  
  static int zzz(List<?> paramList)
  {
    return paramList.size();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zziy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */