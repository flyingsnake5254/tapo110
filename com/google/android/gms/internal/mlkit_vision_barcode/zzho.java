package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import sun.misc.Unsafe;

final class zzho<T>
  implements zzib<T>
{
  private static final int[] zza = new int[0];
  private static final Unsafe zzb = zziz.zzc();
  private final int[] zzc;
  private final Object[] zzd;
  private final int zze;
  private final int zzf;
  private final zzhk zzg;
  private final boolean zzh;
  private final boolean zzi;
  private final boolean zzj;
  private final boolean zzk;
  private final int[] zzl;
  private final int zzm;
  private final int zzn;
  private final zzht zzo;
  private final zzgu zzp;
  private final zzit<?, ?> zzq;
  private final zzfr<?> zzr;
  private final zzhh zzs;
  
  private zzho(int[] paramArrayOfInt1, Object[] paramArrayOfObject, int paramInt1, int paramInt2, zzhk paramzzhk, boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfInt2, int paramInt3, int paramInt4, zzht paramzzht, zzgu paramzzgu, zzit<?, ?> paramzzit, zzfr<?> paramzzfr, zzhh paramzzhh)
  {
    this.zzc = paramArrayOfInt1;
    this.zzd = paramArrayOfObject;
    this.zze = paramInt1;
    this.zzf = paramInt2;
    this.zzi = (paramzzhk instanceof zzga);
    this.zzj = paramBoolean1;
    if ((paramzzfr != null) && (paramzzfr.zza(paramzzhk))) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    this.zzh = paramBoolean1;
    this.zzk = false;
    this.zzl = paramArrayOfInt2;
    this.zzm = paramInt3;
    this.zzn = paramInt4;
    this.zzo = paramzzht;
    this.zzp = paramzzgu;
    this.zzq = paramzzit;
    this.zzr = paramzzfr;
    this.zzg = paramzzhk;
    this.zzs = paramzzhh;
  }
  
  private static <UT, UB> int zza(zzit<UT, UB> paramzzit, T paramT)
  {
    return paramzzit.zzd(paramzzit.zza(paramT));
  }
  
  static <T> zzho<T> zza(Class<T> paramClass, zzhi paramzzhi, zzht paramzzht, zzgu paramzzgu, zzit<?, ?> paramzzit, zzfr<?> paramzzfr, zzhh paramzzhh)
  {
    if ((paramzzhi instanceof zzhy))
    {
      zzhy localzzhy = (zzhy)paramzzhi;
      i = localzzhy.zza();
      int j = zzga.zze.zzi;
      int k = 0;
      boolean bool;
      if (i == j) {
        bool = true;
      } else {
        bool = false;
      }
      String str = localzzhy.zzd();
      int m = str.length();
      if (str.charAt(0) >= 55296) {
        for (n = 1;; n = j)
        {
          j = n + 1;
          i = j;
          if (str.charAt(n) < 55296) {
            break;
          }
        }
      }
      i = 1;
      j = i + 1;
      int i1 = str.charAt(i);
      i = j;
      int n = i1;
      if (i1 >= 55296)
      {
        i1 &= 0x1FFF;
        n = 13;
        for (;;)
        {
          i = j + 1;
          j = str.charAt(j);
          if (j < 55296) {
            break;
          }
          i1 |= (j & 0x1FFF) << n;
          n += 13;
          j = i;
        }
        n = i1 | j << n;
      }
      int i3;
      if (n == 0)
      {
        paramClass = zza;
        i1 = 0;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        i5 = 0;
        j = 0;
        n = k;
        k = i2;
      }
      else
      {
        j = i + 1;
        i1 = str.charAt(i);
        i = i1;
        n = j;
        if (i1 >= 55296)
        {
          i = i1 & 0x1FFF;
          n = 13;
          i1 = j;
          j = i;
          for (;;)
          {
            i = i1 + 1;
            i1 = str.charAt(i1);
            if (i1 < 55296) {
              break;
            }
            j |= (i1 & 0x1FFF) << n;
            n += 13;
            i1 = i;
          }
          j |= i1 << n;
          n = i;
          i = j;
        }
        j = n + 1;
        i1 = str.charAt(n);
        i2 = i1;
        n = j;
        if (i1 >= 55296)
        {
          i1 &= 0x1FFF;
          n = 13;
          for (k = j;; k = j)
          {
            j = k + 1;
            k = str.charAt(k);
            if (k < 55296) {
              break;
            }
            i1 |= (k & 0x1FFF) << n;
            n += 13;
          }
          i2 = i1 | k << n;
          n = j;
        }
        i1 = n + 1;
        k = str.charAt(n);
        n = k;
        j = i1;
        if (k >= 55296)
        {
          n = k & 0x1FFF;
          j = 13;
          k = i1;
          i1 = n;
          for (;;)
          {
            n = k + 1;
            k = str.charAt(k);
            if (k < 55296) {
              break;
            }
            i1 |= (k & 0x1FFF) << j;
            j += 13;
            k = n;
          }
          i1 |= k << j;
          j = n;
          n = i1;
        }
        k = j + 1;
        i4 = str.charAt(j);
        i1 = i4;
        j = k;
        if (i4 >= 55296)
        {
          i1 = i4 & 0x1FFF;
          j = 13;
          i4 = k;
          k = i1;
          for (;;)
          {
            i1 = i4 + 1;
            i4 = str.charAt(i4);
            if (i4 < 55296) {
              break;
            }
            k |= (i4 & 0x1FFF) << j;
            j += 13;
            i4 = i1;
          }
          k |= i4 << j;
          j = i1;
          i1 = k;
        }
        i4 = j + 1;
        j = str.charAt(j);
        k = j;
        i3 = i4;
        if (j >= 55296)
        {
          k = j & 0x1FFF;
          j = 13;
          i3 = i4;
          i4 = k;
          for (;;)
          {
            k = i3 + 1;
            i3 = str.charAt(i3);
            if (i3 < 55296) {
              break;
            }
            i4 |= (i3 & 0x1FFF) << j;
            j += 13;
            i3 = k;
          }
          j = i4 | i3 << j;
          i3 = k;
          k = j;
        }
        j = i3 + 1;
        i5 = str.charAt(i3);
        i4 = i5;
        i3 = j;
        if (i5 >= 55296)
        {
          i3 = i5 & 0x1FFF;
          i4 = 13;
          for (i5 = j;; i5 = j)
          {
            j = i5 + 1;
            i5 = str.charAt(i5);
            if (i5 < 55296) {
              break;
            }
            i3 |= (i5 & 0x1FFF) << i4;
            i4 += 13;
          }
          i4 = i3 | i5 << i4;
          i3 = j;
        }
        j = i3 + 1;
        i6 = str.charAt(i3);
        i5 = i6;
        i3 = j;
        if (i6 >= 55296)
        {
          i5 = i6 & 0x1FFF;
          i3 = 13;
          for (i6 = j;; i6 = j)
          {
            j = i6 + 1;
            i6 = str.charAt(i6);
            if (i6 < 55296) {
              break;
            }
            i5 |= (i6 & 0x1FFF) << i3;
            i3 += 13;
          }
          i5 |= i6 << i3;
          i3 = j;
        }
        i6 = i3 + 1;
        i7 = str.charAt(i3);
        j = i7;
        i3 = i6;
        if (i7 >= 55296)
        {
          j = i7 & 0x1FFF;
          i7 = i6;
          i3 = 13;
          i6 = j;
          for (;;)
          {
            j = i7 + 1;
            i7 = str.charAt(i7);
            if (i7 < 55296) {
              break;
            }
            i6 |= (i7 & 0x1FFF) << i3;
            i3 += 13;
            i7 = j;
          }
          i6 |= i7 << i3;
          i3 = j;
          j = i6;
        }
        paramClass = new int[j + i4 + i5];
        i6 = (i << 1) + i2;
        i2 = i;
        i = i3;
        i5 = i4;
        i4 = k;
        i3 = i1;
        k = n;
        i1 = i6;
        n = i2;
      }
      Unsafe localUnsafe = zzb;
      Object[] arrayOfObject = localzzhy.zze();
      Class localClass = localzzhy.zzc().getClass();
      int[] arrayOfInt = new int[i4 * 3];
      paramzzhi = new Object[i4 << 1];
      int i8 = j + i5;
      int i4 = i1;
      int i2 = j;
      int i5 = i;
      i1 = i8;
      int i6 = 0;
      int i9 = 0;
      i = i2;
      i2 = i6;
      int i7 = i3;
      i6 = k;
      k = i5;
      int i10 = n;
      n = m;
      while (k < n)
      {
        m = k + 1;
        k = str.charAt(k);
        if (k >= 55296)
        {
          i3 = k & 0x1FFF;
          k = 13;
          for (;;)
          {
            i5 = m + 1;
            m = str.charAt(m);
            if (m < 55296) {
              break;
            }
            i3 |= (m & 0x1FFF) << k;
            k += 13;
            m = i5;
          }
          m = i3 | m << k;
          i3 = i5;
        }
        else
        {
          i3 = m;
          m = k;
        }
        k = i3 + 1;
        int i11 = str.charAt(i3);
        if (i11 >= 55296)
        {
          i12 = i11 & 0x1FFF;
          i3 = 13;
          for (;;)
          {
            i5 = k + 1;
            i11 = str.charAt(k);
            k = j;
            if (i11 < 55296) {
              break;
            }
            i12 |= (i11 & 0x1FFF) << i3;
            i3 += 13;
            j = k;
            k = i5;
          }
          i11 = i12 | i11 << i3;
          i3 = i5;
        }
        else
        {
          i3 = k;
          k = j;
        }
        int i13 = i11 & 0xFF;
        int i12 = i2;
        if ((i11 & 0x400) != 0)
        {
          paramClass[i2] = i9;
          i12 = i2 + 1;
        }
        Object localObject;
        if (i13 >= 51)
        {
          i5 = i3 + 1;
          i3 = str.charAt(i3);
          i2 = i3;
          j = i5;
          if (i3 >= 55296)
          {
            i2 = i3 & 0x1FFF;
            j = 13;
            for (;;)
            {
              i3 = i5 + 1;
              i5 = str.charAt(i5);
              if (i5 < 55296) {
                break;
              }
              i2 |= (i5 & 0x1FFF) << j;
              j += 13;
              i5 = i3;
            }
            i2 |= i5 << j;
            j = i3;
          }
          i5 = i13 - 51;
          if ((i5 != 9) && (i5 != 17))
          {
            i3 = i4;
            if (i5 == 12)
            {
              i3 = i4;
              if (!bool)
              {
                paramzzhi[((i9 / 3 << 1) + 1)] = arrayOfObject[i4];
                i3 = i4 + 1;
              }
            }
            i4 = i3;
          }
          else
          {
            paramzzhi[((i9 / 3 << 1) + 1)] = arrayOfObject[i4];
            i4++;
          }
          i3 = i2 << 1;
          localObject = arrayOfObject[i3];
          if ((localObject instanceof Field))
          {
            localObject = (Field)localObject;
          }
          else
          {
            localObject = zza(localClass, (String)localObject);
            arrayOfObject[i3] = localObject;
          }
          i5 = (int)localUnsafe.objectFieldOffset((Field)localObject);
          i3++;
          localObject = arrayOfObject[i3];
          if ((localObject instanceof Field))
          {
            localObject = (Field)localObject;
          }
          else
          {
            localObject = zza(localClass, (String)localObject);
            arrayOfObject[i3] = localObject;
          }
          i2 = (int)localUnsafe.objectFieldOffset((Field)localObject);
          i3 = 0;
        }
        else
        {
          i2 = i4 + 1;
          localObject = zza(localClass, (String)arrayOfObject[i4]);
          if ((i13 != 9) && (i13 != 17))
          {
            if ((i13 != 27) && (i13 != 49))
            {
              if ((i13 != 12) && (i13 != 30) && (i13 != 44))
              {
                j = i2;
                i4 = i;
                if (i13 != 50) {
                  break label2127;
                }
                j = i + 1;
                paramClass[i] = i9;
                i5 = i9 / 3 << 1;
                i4 = i2 + 1;
                paramzzhi[i5] = arrayOfObject[i2];
                if ((i11 & 0x800) != 0)
                {
                  i = i4 + 1;
                  paramzzhi[(i5 + 1)] = arrayOfObject[i4];
                  i4 = j;
                  j = i;
                  break label2127;
                }
                i = j;
                j = i4;
              }
              else if (!bool)
              {
                i4 = i9 / 3;
                j = i2 + 1;
                paramzzhi[((i4 << 1) + 1)] = arrayOfObject[i2];
              }
              else
              {
                j = i2;
                i4 = i;
                break label2127;
              }
            }
            else
            {
              i4 = i9 / 3;
              j = i2 + 1;
              paramzzhi[((i4 << 1) + 1)] = arrayOfObject[i2];
            }
            break label2131;
          }
          else
          {
            paramzzhi[((i9 / 3 << 1) + 1)] = ((Field)localObject).getType();
            i4 = i;
            j = i2;
          }
          label2127:
          i = i4;
          label2131:
          i14 = (int)localUnsafe.objectFieldOffset((Field)localObject);
          if (((i11 & 0x1000) == 4096) && (i13 <= 17))
          {
            i2 = i3 + 1;
            i5 = str.charAt(i3);
            i3 = i5;
            i4 = i2;
            if (i5 >= 55296)
            {
              i4 = i5 & 0x1FFF;
              i3 = 13;
              i5 = i2;
              i2 = i4;
              for (;;)
              {
                i4 = i5 + 1;
                i5 = str.charAt(i5);
                if (i5 < 55296) {
                  break;
                }
                i2 |= (i5 & 0x1FFF) << i3;
                i3 += 13;
                i5 = i4;
              }
              i3 = i2 | i5 << i3;
            }
            i2 = (i10 << 1) + i3 / 32;
            localObject = arrayOfObject[i2];
            if ((localObject instanceof Field))
            {
              localObject = (Field)localObject;
            }
            else
            {
              localObject = zza(localClass, (String)localObject);
              arrayOfObject[i2] = localObject;
            }
            i2 = (int)localUnsafe.objectFieldOffset((Field)localObject);
            i3 %= 32;
            i5 = i4;
          }
          else
          {
            i2 = 1048575;
            i4 = 0;
            i5 = i3;
            i3 = i4;
          }
          i4 = i1;
          if (i13 >= 18)
          {
            i4 = i1;
            if (i13 <= 49)
            {
              paramClass[i1] = i14;
              i4 = i1 + 1;
            }
          }
          i1 = i4;
          i4 = j;
          j = i5;
          i5 = i14;
        }
        int i15 = i9 + 1;
        arrayOfInt[i9] = m;
        int i14 = i15 + 1;
        if ((i11 & 0x200) != 0) {
          i9 = 536870912;
        } else {
          i9 = 0;
        }
        if ((i11 & 0x100) != 0) {
          m = 268435456;
        } else {
          m = 0;
        }
        arrayOfInt[i15] = (m | i9 | i13 << 20 | i5);
        arrayOfInt[i14] = (i3 << 20 | i2);
        i3 = j;
        j = k;
        i9 = i14 + 1;
        k = i3;
        i2 = i12;
      }
      return new zzho(arrayOfInt, paramzzhi, i6, i7, localzzhy.zzc(), bool, false, paramClass, j, i8, paramzzht, paramzzgu, paramzzit, paramzzfr, paramzzhh);
    }
    ((zzim)paramzzhi).zza();
    int i = zzga.zze.zzi;
    throw new NoSuchMethodError();
  }
  
  private final zzib zza(int paramInt)
  {
    paramInt = paramInt / 3 << 1;
    zzib localzzib = (zzib)this.zzd[paramInt];
    if (localzzib != null) {
      return localzzib;
    }
    localzzib = zzhw.zza().zza((Class)this.zzd[(paramInt + 1)]);
    this.zzd[paramInt] = localzzib;
    return localzzib;
  }
  
  private static Field zza(Class<?> paramClass, String paramString)
  {
    try
    {
      Field localField = paramClass.getDeclaredField(paramString);
      return localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (localObject2 : paramClass.getDeclaredFields()) {
        if (paramString.equals(((Field)localObject2).getName())) {
          return (Field)localObject2;
        }
      }
      paramClass = paramClass.getName();
      Object localObject2 = Arrays.toString((Object[])???);
      ??? = new StringBuilder(String.valueOf(paramString).length() + 40 + paramClass.length() + String.valueOf(localObject2).length());
      ((StringBuilder)???).append("Field ");
      ((StringBuilder)???).append(paramString);
      ((StringBuilder)???).append(" for ");
      ((StringBuilder)???).append(paramClass);
      ((StringBuilder)???).append(" not found. Known fields are ");
      ((StringBuilder)???).append((String)localObject2);
      throw new RuntimeException(((StringBuilder)???).toString());
    }
  }
  
  private static List<?> zza(Object paramObject, long paramLong)
  {
    return (List)zziz.zzf(paramObject, paramLong);
  }
  
  private static void zza(int paramInt, Object paramObject, zzjn paramzzjn)
    throws IOException
  {
    if ((paramObject instanceof String))
    {
      paramzzjn.zza(paramInt, (String)paramObject);
      return;
    }
    paramzzjn.zza(paramInt, (zzew)paramObject);
  }
  
  private static <UT, UB> void zza(zzit<UT, UB> paramzzit, T paramT, zzjn paramzzjn)
    throws IOException
  {
    paramzzit.zza(paramzzit.zza(paramT), paramzzjn);
  }
  
  private final <K, V> void zza(zzjn paramzzjn, int paramInt1, Object paramObject, int paramInt2)
    throws IOException
  {
    if (paramObject != null) {
      paramzzjn.zza(paramInt1, this.zzs.zza(zzb(paramInt2)), this.zzs.zzb(paramObject));
    }
  }
  
  private final void zza(T paramT1, T paramT2, int paramInt)
  {
    long l = zzc(paramInt) & 0xFFFFF;
    if (!zza(paramT2, paramInt)) {
      return;
    }
    Object localObject = zziz.zzf(paramT1, l);
    paramT2 = zziz.zzf(paramT2, l);
    if ((localObject != null) && (paramT2 != null))
    {
      zziz.zza(paramT1, l, zzgc.zza(localObject, paramT2));
      zzb(paramT1, paramInt);
      return;
    }
    if (paramT2 != null)
    {
      zziz.zza(paramT1, l, paramT2);
      zzb(paramT1, paramInt);
    }
  }
  
  private final boolean zza(T paramT, int paramInt)
  {
    int i = zzd(paramInt);
    long l = i & 0xFFFFF;
    if (l == 1048575L)
    {
      paramInt = zzc(paramInt);
      l = paramInt & 0xFFFFF;
      switch ((paramInt & 0xFF00000) >>> 20)
      {
      default: 
        throw new IllegalArgumentException();
      case 17: 
        return zziz.zzf(paramT, l) != null;
      case 16: 
        return zziz.zzb(paramT, l) != 0L;
      case 15: 
        return zziz.zza(paramT, l) != 0;
      case 14: 
        return zziz.zzb(paramT, l) != 0L;
      case 13: 
        return zziz.zza(paramT, l) != 0;
      case 12: 
        return zziz.zza(paramT, l) != 0;
      case 11: 
        return zziz.zza(paramT, l) != 0;
      case 10: 
        return !zzew.zza.equals(zziz.zzf(paramT, l));
      case 9: 
        return zziz.zzf(paramT, l) != null;
      case 8: 
        paramT = zziz.zzf(paramT, l);
        if ((paramT instanceof String)) {
          return !((String)paramT).isEmpty();
        }
        if ((paramT instanceof zzew)) {
          return !zzew.zza.equals(paramT);
        }
        throw new IllegalArgumentException();
      case 7: 
        return zziz.zzc(paramT, l);
      case 6: 
        return zziz.zza(paramT, l) != 0;
      case 5: 
        return zziz.zzb(paramT, l) != 0L;
      case 4: 
        return zziz.zza(paramT, l) != 0;
      case 3: 
        return zziz.zzb(paramT, l) != 0L;
      case 2: 
        return zziz.zzb(paramT, l) != 0L;
      case 1: 
        return zziz.zzd(paramT, l) != 0.0F;
      }
      return zziz.zze(paramT, l) != 0.0D;
    }
    return (zziz.zza(paramT, l) & 1 << (i >>> 20)) != 0;
  }
  
  private final boolean zza(T paramT, int paramInt1, int paramInt2)
  {
    return zziz.zza(paramT, zzd(paramInt2) & 0xFFFFF) == paramInt1;
  }
  
  private final boolean zza(T paramT, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 == 1048575) {
      return zza(paramT, paramInt1);
    }
    return (paramInt3 & paramInt4) != 0;
  }
  
  private static boolean zza(Object paramObject, int paramInt, zzib paramzzib)
  {
    return paramzzib.zzd(zziz.zzf(paramObject, paramInt & 0xFFFFF));
  }
  
  private static <T> double zzb(T paramT, long paramLong)
  {
    return ((Double)zziz.zzf(paramT, paramLong)).doubleValue();
  }
  
  private final Object zzb(int paramInt)
  {
    return this.zzd[(paramInt / 3 << 1)];
  }
  
  private final void zzb(T paramT, int paramInt)
  {
    paramInt = zzd(paramInt);
    long l = 0xFFFFF & paramInt;
    if (l == 1048575L) {
      return;
    }
    zziz.zza(paramT, l, 1 << (paramInt >>> 20) | zziz.zza(paramT, l));
  }
  
  private final void zzb(T paramT, int paramInt1, int paramInt2)
  {
    zziz.zza(paramT, zzd(paramInt2) & 0xFFFFF, paramInt1);
  }
  
  private final void zzb(T paramT, zzjn paramzzjn)
    throws IOException
  {
    if (this.zzh)
    {
      localObject1 = this.zzr.zza(paramT);
      if (!((zzfs)localObject1).zza.isEmpty())
      {
        localIterator = ((zzfs)localObject1).zzd();
        localObject1 = (Map.Entry)localIterator.next();
        break label51;
      }
    }
    Iterator localIterator = null;
    Object localObject1 = null;
    label51:
    int i = this.zzc.length;
    Unsafe localUnsafe = zzb;
    int j = 0;
    int k = 1048575;
    int m = 0;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      if (j >= i) {
        break;
      }
      int n = zzc(j);
      localObject2 = this.zzc;
      int i1 = localObject2[j];
      int i2 = (n & 0xFF00000) >>> 20;
      int i4;
      if ((!this.zzj) && (i2 <= 17))
      {
        int i3 = localObject2[(j + 2)];
        i4 = i3 & 0xFFFFF;
        int i5 = k;
        if (i4 != k)
        {
          m = localUnsafe.getInt(paramT, i4);
          i5 = i4;
        }
        i4 = 1 << (i3 >>> 20);
        k = i5;
      }
      else
      {
        i4 = 0;
      }
      while ((localObject1 != null) && (this.zzr.zza((Map.Entry)localObject1) <= i1))
      {
        this.zzr.zza(paramzzjn, (Map.Entry)localObject1);
        if (localIterator.hasNext()) {
          localObject1 = (Map.Entry)localIterator.next();
        } else {
          localObject1 = null;
        }
      }
      long l = n & 0xFFFFF;
      switch (i2)
      {
      }
      for (;;)
      {
        break;
        if (zza(paramT, i1, j))
        {
          paramzzjn.zzb(i1, localUnsafe.getObject(paramT, l), zza(j));
          continue;
          if (zza(paramT, i1, j))
          {
            paramzzjn.zze(i1, zze(paramT, l));
            continue;
            if (zza(paramT, i1, j))
            {
              paramzzjn.zzf(i1, zzd(paramT, l));
              continue;
              if (zza(paramT, i1, j))
              {
                paramzzjn.zzb(i1, zze(paramT, l));
                continue;
                if (zza(paramT, i1, j))
                {
                  paramzzjn.zza(i1, zzd(paramT, l));
                  continue;
                  if (zza(paramT, i1, j))
                  {
                    paramzzjn.zzb(i1, zzd(paramT, l));
                    continue;
                    if (zza(paramT, i1, j))
                    {
                      paramzzjn.zze(i1, zzd(paramT, l));
                      continue;
                      if (zza(paramT, i1, j))
                      {
                        paramzzjn.zza(i1, (zzew)localUnsafe.getObject(paramT, l));
                        continue;
                        if (zza(paramT, i1, j))
                        {
                          paramzzjn.zza(i1, localUnsafe.getObject(paramT, l), zza(j));
                          continue;
                          if (zza(paramT, i1, j))
                          {
                            zza(i1, localUnsafe.getObject(paramT, l), paramzzjn);
                            continue;
                            if (zza(paramT, i1, j))
                            {
                              paramzzjn.zza(i1, zzf(paramT, l));
                              continue;
                              if (zza(paramT, i1, j))
                              {
                                paramzzjn.zzd(i1, zzd(paramT, l));
                                continue;
                                if (zza(paramT, i1, j))
                                {
                                  paramzzjn.zzd(i1, zze(paramT, l));
                                  continue;
                                  if (zza(paramT, i1, j))
                                  {
                                    paramzzjn.zzc(i1, zzd(paramT, l));
                                    continue;
                                    if (zza(paramT, i1, j))
                                    {
                                      paramzzjn.zzc(i1, zze(paramT, l));
                                      continue;
                                      if (zza(paramT, i1, j))
                                      {
                                        paramzzjn.zza(i1, zze(paramT, l));
                                        continue;
                                        if (zza(paramT, i1, j))
                                        {
                                          paramzzjn.zza(i1, zzc(paramT, l));
                                          continue;
                                          if (zza(paramT, i1, j))
                                          {
                                            paramzzjn.zza(i1, zzb(paramT, l));
                                            continue;
                                            zza(paramzzjn, i1, localUnsafe.getObject(paramT, l), j);
                                            continue;
                                            zzid.zzb(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, zza(j));
                                            continue;
                                            zzid.zze(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, true);
                                            continue;
                                            zzid.zzj(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, true);
                                            continue;
                                            zzid.zzg(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, true);
                                            continue;
                                            zzid.zzl(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, true);
                                            continue;
                                            zzid.zzm(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, true);
                                            continue;
                                            zzid.zzi(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, true);
                                            continue;
                                            zzid.zzn(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, true);
                                            continue;
                                            zzid.zzk(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, true);
                                            continue;
                                            zzid.zzf(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, true);
                                            continue;
                                            zzid.zzh(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, true);
                                            continue;
                                            zzid.zzd(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, true);
                                            continue;
                                            zzid.zzc(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, true);
                                            continue;
                                            zzid.zzb(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, true);
                                            continue;
                                            zzid.zza(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, true);
                                            continue;
                                            zzid.zze(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, false);
                                            continue;
                                            zzid.zzj(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, false);
                                            continue;
                                            zzid.zzg(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, false);
                                            continue;
                                            zzid.zzl(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, false);
                                            continue;
                                            zzid.zzm(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, false);
                                            continue;
                                            zzid.zzi(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, false);
                                            continue;
                                            zzid.zzb(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn);
                                            continue;
                                            zzid.zza(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, zza(j));
                                            continue;
                                            zzid.zza(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn);
                                            continue;
                                            zzid.zzn(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, false);
                                            continue;
                                            zzid.zzk(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, false);
                                            continue;
                                            zzid.zzf(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, false);
                                            continue;
                                            zzid.zzh(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, false);
                                            continue;
                                            zzid.zzd(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, false);
                                            continue;
                                            zzid.zzc(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, false);
                                            continue;
                                            zzid.zzb(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, false);
                                            continue;
                                            zzid.zza(this.zzc[j], (List)localUnsafe.getObject(paramT, l), paramzzjn, false);
                                            continue;
                                            if ((i4 & m) != 0)
                                            {
                                              paramzzjn.zzb(i1, localUnsafe.getObject(paramT, l), zza(j));
                                              break;
                                              if ((i4 & m) != 0)
                                              {
                                                paramzzjn.zze(i1, localUnsafe.getLong(paramT, l));
                                                break;
                                                if ((i4 & m) != 0)
                                                {
                                                  paramzzjn.zzf(i1, localUnsafe.getInt(paramT, l));
                                                  break;
                                                  if ((i4 & m) != 0)
                                                  {
                                                    paramzzjn.zzb(i1, localUnsafe.getLong(paramT, l));
                                                    break;
                                                    if ((i4 & m) != 0)
                                                    {
                                                      paramzzjn.zza(i1, localUnsafe.getInt(paramT, l));
                                                      break;
                                                      if ((i4 & m) != 0)
                                                      {
                                                        paramzzjn.zzb(i1, localUnsafe.getInt(paramT, l));
                                                        break;
                                                        if ((i4 & m) != 0)
                                                        {
                                                          paramzzjn.zze(i1, localUnsafe.getInt(paramT, l));
                                                          break;
                                                          if ((i4 & m) != 0)
                                                          {
                                                            paramzzjn.zza(i1, (zzew)localUnsafe.getObject(paramT, l));
                                                            break;
                                                            if ((i4 & m) != 0)
                                                            {
                                                              paramzzjn.zza(i1, localUnsafe.getObject(paramT, l), zza(j));
                                                              break;
                                                              if ((i4 & m) != 0)
                                                              {
                                                                zza(i1, localUnsafe.getObject(paramT, l), paramzzjn);
                                                                break;
                                                                if ((i4 & m) != 0)
                                                                {
                                                                  paramzzjn.zza(i1, zziz.zzc(paramT, l));
                                                                  break;
                                                                  if ((i4 & m) != 0)
                                                                  {
                                                                    paramzzjn.zzd(i1, localUnsafe.getInt(paramT, l));
                                                                    break;
                                                                    if ((i4 & m) != 0)
                                                                    {
                                                                      paramzzjn.zzd(i1, localUnsafe.getLong(paramT, l));
                                                                      break;
                                                                      if ((i4 & m) != 0)
                                                                      {
                                                                        paramzzjn.zzc(i1, localUnsafe.getInt(paramT, l));
                                                                        break;
                                                                        if ((i4 & m) != 0)
                                                                        {
                                                                          paramzzjn.zzc(i1, localUnsafe.getLong(paramT, l));
                                                                          break;
                                                                          if ((i4 & m) != 0)
                                                                          {
                                                                            paramzzjn.zza(i1, localUnsafe.getLong(paramT, l));
                                                                            break;
                                                                            if ((i4 & m) != 0)
                                                                            {
                                                                              paramzzjn.zza(i1, zziz.zzd(paramT, l));
                                                                              break;
                                                                              if ((i4 & m) != 0) {
                                                                                paramzzjn.zza(i1, zziz.zze(paramT, l));
                                                                              }
                                                                            }
                                                                          }
                                                                        }
                                                                      }
                                                                    }
                                                                  }
                                                                }
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      j += 3;
    }
    while (localObject2 != null)
    {
      this.zzr.zza(paramzzjn, (Map.Entry)localObject2);
      if (localIterator.hasNext()) {
        localObject2 = (Map.Entry)localIterator.next();
      } else {
        localObject2 = null;
      }
    }
    zza(this.zzq, paramT, paramzzjn);
  }
  
  private final void zzb(T paramT1, T paramT2, int paramInt)
  {
    int i = zzc(paramInt);
    int j = this.zzc[paramInt];
    long l = i & 0xFFFFF;
    if (!zza(paramT2, j, paramInt)) {
      return;
    }
    Object localObject = zziz.zzf(paramT1, l);
    paramT2 = zziz.zzf(paramT2, l);
    if ((localObject != null) && (paramT2 != null))
    {
      zziz.zza(paramT1, l, zzgc.zza(localObject, paramT2));
      zzb(paramT1, j, paramInt);
      return;
    }
    if (paramT2 != null)
    {
      zziz.zza(paramT1, l, paramT2);
      zzb(paramT1, j, paramInt);
    }
  }
  
  private static <T> float zzc(T paramT, long paramLong)
  {
    return ((Float)zziz.zzf(paramT, paramLong)).floatValue();
  }
  
  private final int zzc(int paramInt)
  {
    return this.zzc[(paramInt + 1)];
  }
  
  private final boolean zzc(T paramT1, T paramT2, int paramInt)
  {
    return zza(paramT1, paramInt) == zza(paramT2, paramInt);
  }
  
  private final int zzd(int paramInt)
  {
    return this.zzc[(paramInt + 2)];
  }
  
  private static <T> int zzd(T paramT, long paramLong)
  {
    return ((Integer)zziz.zzf(paramT, paramLong)).intValue();
  }
  
  private static <T> long zze(T paramT, long paramLong)
  {
    return ((Long)zziz.zzf(paramT, paramLong)).longValue();
  }
  
  private static <T> boolean zzf(T paramT, long paramLong)
  {
    return ((Boolean)zziz.zzf(paramT, paramLong)).booleanValue();
  }
  
  public final int zza(T paramT)
  {
    int i = this.zzc.length;
    int j = 0;
    for (int k = 0; j < i; k = i1)
    {
      int m = zzc(j);
      int n = this.zzc[j];
      long l = 0xFFFFF & m;
      i1 = 37;
      Object localObject;
      switch ((m & 0xFF00000) >>> 20)
      {
      default: 
        i1 = k;
        break;
      case 68: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        localObject = zziz.zzf(paramT, l);
        i1 = k * 53;
        k = localObject.hashCode();
        break;
      case 67: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzgc.zza(zze(paramT, l));
        break;
      case 66: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzd(paramT, l);
        break;
      case 65: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzgc.zza(zze(paramT, l));
        break;
      case 64: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzd(paramT, l);
        break;
      case 63: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzd(paramT, l);
        break;
      case 62: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzd(paramT, l);
        break;
      case 61: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zziz.zzf(paramT, l).hashCode();
        break;
      case 60: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        localObject = zziz.zzf(paramT, l);
        i1 = k * 53;
        k = localObject.hashCode();
        break;
      case 59: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = ((String)zziz.zzf(paramT, l)).hashCode();
        break;
      case 58: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzgc.zza(zzf(paramT, l));
        break;
      case 57: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzd(paramT, l);
        break;
      case 56: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzgc.zza(zze(paramT, l));
        break;
      case 55: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzd(paramT, l);
        break;
      case 54: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzgc.zza(zze(paramT, l));
        break;
      case 53: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzgc.zza(zze(paramT, l));
        break;
      case 52: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = Float.floatToIntBits(zzc(paramT, l));
        break;
      case 51: 
        i1 = k;
        if (!zza(paramT, n, j)) {
          break label1421;
        }
        i1 = k * 53;
        k = zzgc.zza(Double.doubleToLongBits(zzb(paramT, l)));
        break;
      case 50: 
        i1 = k * 53;
        k = zziz.zzf(paramT, l).hashCode();
        break;
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      case 24: 
      case 25: 
      case 26: 
      case 27: 
      case 28: 
      case 29: 
      case 30: 
      case 31: 
      case 32: 
      case 33: 
      case 34: 
      case 35: 
      case 36: 
      case 37: 
      case 38: 
      case 39: 
      case 40: 
      case 41: 
      case 42: 
      case 43: 
      case 44: 
      case 45: 
      case 46: 
      case 47: 
      case 48: 
      case 49: 
        i1 = k * 53;
        k = zziz.zzf(paramT, l).hashCode();
        break;
      case 17: 
        localObject = zziz.zzf(paramT, l);
        if (localObject != null) {
          i1 = localObject.hashCode();
        }
        break;
      case 16: 
        i1 = k * 53;
        k = zzgc.zza(zziz.zzb(paramT, l));
        break;
      case 15: 
        i1 = k * 53;
        k = zziz.zza(paramT, l);
        break;
      case 14: 
        i1 = k * 53;
        k = zzgc.zza(zziz.zzb(paramT, l));
        break;
      case 13: 
        i1 = k * 53;
        k = zziz.zza(paramT, l);
        break;
      case 12: 
        i1 = k * 53;
        k = zziz.zza(paramT, l);
        break;
      case 11: 
        i1 = k * 53;
        k = zziz.zza(paramT, l);
        break;
      case 10: 
        i1 = k * 53;
        k = zziz.zzf(paramT, l).hashCode();
        break;
      case 9: 
        localObject = zziz.zzf(paramT, l);
        if (localObject != null) {
          i1 = localObject.hashCode();
        }
        i1 = k * 53 + i1;
        break;
      case 8: 
        i1 = k * 53;
        k = ((String)zziz.zzf(paramT, l)).hashCode();
        break;
      case 7: 
        i1 = k * 53;
        k = zzgc.zza(zziz.zzc(paramT, l));
        break;
      case 6: 
        i1 = k * 53;
        k = zziz.zza(paramT, l);
        break;
      case 5: 
        i1 = k * 53;
        k = zzgc.zza(zziz.zzb(paramT, l));
        break;
      case 4: 
        i1 = k * 53;
        k = zziz.zza(paramT, l);
        break;
      case 3: 
        i1 = k * 53;
        k = zzgc.zza(zziz.zzb(paramT, l));
        break;
      case 2: 
        i1 = k * 53;
        k = zzgc.zza(zziz.zzb(paramT, l));
        break;
      case 1: 
        i1 = k * 53;
        k = Float.floatToIntBits(zziz.zzd(paramT, l));
        break;
      }
      i1 = k * 53;
      k = zzgc.zza(Double.doubleToLongBits(zziz.zze(paramT, l)));
      i1 += k;
      label1421:
      j += 3;
    }
    k = k * 53 + this.zzq.zza(paramT).hashCode();
    int i1 = k;
    if (this.zzh) {
      i1 = k * 53 + this.zzr.zza(paramT).hashCode();
    }
    return i1;
  }
  
  public final void zza(T paramT, zzjn paramzzjn)
    throws IOException
  {
    Object localObject1;
    Iterator localIterator;
    Object localObject2;
    label75:
    int i;
    int j;
    int k;
    if (paramzzjn.zza() == zzga.zze.zzk)
    {
      zza(this.zzq, paramT, paramzzjn);
      if (this.zzh)
      {
        localObject1 = this.zzr.zza(paramT);
        if (!((zzfs)localObject1).zza.isEmpty())
        {
          localIterator = ((zzfs)localObject1).zze();
          localObject2 = (Map.Entry)localIterator.next();
          break label75;
        }
      }
      localIterator = null;
      localObject2 = localIterator;
      for (i = this.zzc.length - 3;; i -= 3)
      {
        localObject1 = localObject2;
        if (i < 0) {
          break;
        }
        j = zzc(i);
        k = this.zzc[i];
        while ((localObject2 != null) && (this.zzr.zza((Map.Entry)localObject2) > k))
        {
          this.zzr.zza(paramzzjn, (Map.Entry)localObject2);
          if (localIterator.hasNext()) {
            localObject2 = (Map.Entry)localIterator.next();
          } else {
            localObject2 = null;
          }
        }
        switch ((j & 0xFF00000) >>> 20)
        {
        default: 
          break;
        case 68: 
          if (zza(paramT, k, i)) {
            paramzzjn.zzb(k, zziz.zzf(paramT, j & 0xFFFFF), zza(i));
          }
          break;
        case 67: 
          if (zza(paramT, k, i)) {
            paramzzjn.zze(k, zze(paramT, j & 0xFFFFF));
          }
          break;
        case 66: 
          if (zza(paramT, k, i)) {
            paramzzjn.zzf(k, zzd(paramT, j & 0xFFFFF));
          }
          break;
        case 65: 
          if (zza(paramT, k, i)) {
            paramzzjn.zzb(k, zze(paramT, j & 0xFFFFF));
          }
          break;
        case 64: 
          if (zza(paramT, k, i)) {
            paramzzjn.zza(k, zzd(paramT, j & 0xFFFFF));
          }
          break;
        case 63: 
          if (zza(paramT, k, i)) {
            paramzzjn.zzb(k, zzd(paramT, j & 0xFFFFF));
          }
          break;
        case 62: 
          if (zza(paramT, k, i)) {
            paramzzjn.zze(k, zzd(paramT, j & 0xFFFFF));
          }
          break;
        case 61: 
          if (zza(paramT, k, i)) {
            paramzzjn.zza(k, (zzew)zziz.zzf(paramT, j & 0xFFFFF));
          }
          break;
        case 60: 
          if (zza(paramT, k, i)) {
            paramzzjn.zza(k, zziz.zzf(paramT, j & 0xFFFFF), zza(i));
          }
          break;
        case 59: 
          if (zza(paramT, k, i)) {
            zza(k, zziz.zzf(paramT, j & 0xFFFFF), paramzzjn);
          }
          break;
        case 58: 
          if (zza(paramT, k, i)) {
            paramzzjn.zza(k, zzf(paramT, j & 0xFFFFF));
          }
          break;
        case 57: 
          if (zza(paramT, k, i)) {
            paramzzjn.zzd(k, zzd(paramT, j & 0xFFFFF));
          }
          break;
        case 56: 
          if (zza(paramT, k, i)) {
            paramzzjn.zzd(k, zze(paramT, j & 0xFFFFF));
          }
          break;
        case 55: 
          if (zza(paramT, k, i)) {
            paramzzjn.zzc(k, zzd(paramT, j & 0xFFFFF));
          }
          break;
        case 54: 
          if (zza(paramT, k, i)) {
            paramzzjn.zzc(k, zze(paramT, j & 0xFFFFF));
          }
          break;
        case 53: 
          if (zza(paramT, k, i)) {
            paramzzjn.zza(k, zze(paramT, j & 0xFFFFF));
          }
          break;
        case 52: 
          if (zza(paramT, k, i)) {
            paramzzjn.zza(k, zzc(paramT, j & 0xFFFFF));
          }
          break;
        case 51: 
          if (zza(paramT, k, i)) {
            paramzzjn.zza(k, zzb(paramT, j & 0xFFFFF));
          }
          break;
        case 50: 
          zza(paramzzjn, k, zziz.zzf(paramT, j & 0xFFFFF), i);
          break;
        case 49: 
          zzid.zzb(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, zza(i));
          break;
        case 48: 
          zzid.zze(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, true);
          break;
        case 47: 
          zzid.zzj(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, true);
          break;
        case 46: 
          zzid.zzg(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, true);
          break;
        case 45: 
          zzid.zzl(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, true);
          break;
        case 44: 
          zzid.zzm(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, true);
          break;
        case 43: 
          zzid.zzi(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, true);
          break;
        case 42: 
          zzid.zzn(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, true);
          break;
        case 41: 
          zzid.zzk(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, true);
          break;
        case 40: 
          zzid.zzf(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, true);
          break;
        case 39: 
          zzid.zzh(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, true);
          break;
        case 38: 
          zzid.zzd(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, true);
          break;
        case 37: 
          zzid.zzc(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, true);
          break;
        case 36: 
          zzid.zzb(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, true);
          break;
        case 35: 
          zzid.zza(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, true);
          break;
        case 34: 
          zzid.zze(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, false);
          break;
        case 33: 
          zzid.zzj(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, false);
          break;
        case 32: 
          zzid.zzg(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, false);
          break;
        case 31: 
          zzid.zzl(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, false);
          break;
        case 30: 
          zzid.zzm(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, false);
          break;
        case 29: 
          zzid.zzi(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, false);
          break;
        case 28: 
          zzid.zzb(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn);
          break;
        case 27: 
          zzid.zza(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, zza(i));
          break;
        case 26: 
          zzid.zza(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn);
          break;
        case 25: 
          zzid.zzn(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, false);
          break;
        case 24: 
          zzid.zzk(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, false);
          break;
        case 23: 
          zzid.zzf(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, false);
          break;
        case 22: 
          zzid.zzh(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, false);
          break;
        case 21: 
          zzid.zzd(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, false);
          break;
        case 20: 
          zzid.zzc(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, false);
          break;
        case 19: 
          zzid.zzb(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, false);
          break;
        case 18: 
          zzid.zza(this.zzc[i], (List)zziz.zzf(paramT, j & 0xFFFFF), paramzzjn, false);
          break;
        case 17: 
          if (zza(paramT, i)) {
            paramzzjn.zzb(k, zziz.zzf(paramT, j & 0xFFFFF), zza(i));
          }
          break;
        case 16: 
          if (zza(paramT, i)) {
            paramzzjn.zze(k, zziz.zzb(paramT, j & 0xFFFFF));
          }
          break;
        case 15: 
          if (zza(paramT, i)) {
            paramzzjn.zzf(k, zziz.zza(paramT, j & 0xFFFFF));
          }
          break;
        case 14: 
          if (zza(paramT, i)) {
            paramzzjn.zzb(k, zziz.zzb(paramT, j & 0xFFFFF));
          }
          break;
        case 13: 
          if (zza(paramT, i)) {
            paramzzjn.zza(k, zziz.zza(paramT, j & 0xFFFFF));
          }
          break;
        case 12: 
          if (zza(paramT, i)) {
            paramzzjn.zzb(k, zziz.zza(paramT, j & 0xFFFFF));
          }
          break;
        case 11: 
          if (zza(paramT, i)) {
            paramzzjn.zze(k, zziz.zza(paramT, j & 0xFFFFF));
          }
          break;
        case 10: 
          if (zza(paramT, i)) {
            paramzzjn.zza(k, (zzew)zziz.zzf(paramT, j & 0xFFFFF));
          }
          break;
        case 9: 
          if (zza(paramT, i)) {
            paramzzjn.zza(k, zziz.zzf(paramT, j & 0xFFFFF), zza(i));
          }
          break;
        case 8: 
          if (zza(paramT, i)) {
            zza(k, zziz.zzf(paramT, j & 0xFFFFF), paramzzjn);
          }
          break;
        case 7: 
          if (zza(paramT, i)) {
            paramzzjn.zza(k, zziz.zzc(paramT, j & 0xFFFFF));
          }
          break;
        case 6: 
          if (zza(paramT, i)) {
            paramzzjn.zzd(k, zziz.zza(paramT, j & 0xFFFFF));
          }
          break;
        case 5: 
          if (zza(paramT, i)) {
            paramzzjn.zzd(k, zziz.zzb(paramT, j & 0xFFFFF));
          }
          break;
        case 4: 
          if (zza(paramT, i)) {
            paramzzjn.zzc(k, zziz.zza(paramT, j & 0xFFFFF));
          }
          break;
        case 3: 
          if (zza(paramT, i)) {
            paramzzjn.zzc(k, zziz.zzb(paramT, j & 0xFFFFF));
          }
          break;
        case 2: 
          if (zza(paramT, i)) {
            paramzzjn.zza(k, zziz.zzb(paramT, j & 0xFFFFF));
          }
          break;
        case 1: 
          if (zza(paramT, i)) {
            paramzzjn.zza(k, zziz.zzd(paramT, j & 0xFFFFF));
          }
          break;
        case 0: 
          if (zza(paramT, i)) {
            paramzzjn.zza(k, zziz.zze(paramT, j & 0xFFFFF));
          }
          break;
        }
      }
      while (localObject1 != null)
      {
        this.zzr.zza(paramzzjn, (Map.Entry)localObject1);
        if (localIterator.hasNext()) {
          localObject1 = (Map.Entry)localIterator.next();
        } else {
          localObject1 = null;
        }
      }
      return;
    }
    if (this.zzj)
    {
      if (this.zzh)
      {
        localObject1 = this.zzr.zza(paramT);
        if (!((zzfs)localObject1).zza.isEmpty())
        {
          localIterator = ((zzfs)localObject1).zzd();
          localObject1 = (Map.Entry)localIterator.next();
          break label2680;
        }
      }
      localIterator = null;
      localObject1 = localIterator;
      label2680:
      j = this.zzc.length;
      for (i = 0;; i += 3)
      {
        localObject2 = localObject1;
        if (i >= j) {
          break;
        }
        int m = zzc(i);
        k = this.zzc[i];
        while ((localObject1 != null) && (this.zzr.zza((Map.Entry)localObject1) <= k))
        {
          this.zzr.zza(paramzzjn, (Map.Entry)localObject1);
          if (localIterator.hasNext()) {
            localObject1 = (Map.Entry)localIterator.next();
          } else {
            localObject1 = null;
          }
        }
        switch ((m & 0xFF00000) >>> 20)
        {
        default: 
          break;
        case 68: 
          if (zza(paramT, k, i)) {
            paramzzjn.zzb(k, zziz.zzf(paramT, m & 0xFFFFF), zza(i));
          }
          break;
        case 67: 
          if (zza(paramT, k, i)) {
            paramzzjn.zze(k, zze(paramT, m & 0xFFFFF));
          }
          break;
        case 66: 
          if (zza(paramT, k, i)) {
            paramzzjn.zzf(k, zzd(paramT, m & 0xFFFFF));
          }
          break;
        case 65: 
          if (zza(paramT, k, i)) {
            paramzzjn.zzb(k, zze(paramT, m & 0xFFFFF));
          }
          break;
        case 64: 
          if (zza(paramT, k, i)) {
            paramzzjn.zza(k, zzd(paramT, m & 0xFFFFF));
          }
          break;
        case 63: 
          if (zza(paramT, k, i)) {
            paramzzjn.zzb(k, zzd(paramT, m & 0xFFFFF));
          }
          break;
        case 62: 
          if (zza(paramT, k, i)) {
            paramzzjn.zze(k, zzd(paramT, m & 0xFFFFF));
          }
          break;
        case 61: 
          if (zza(paramT, k, i)) {
            paramzzjn.zza(k, (zzew)zziz.zzf(paramT, m & 0xFFFFF));
          }
          break;
        case 60: 
          if (zza(paramT, k, i)) {
            paramzzjn.zza(k, zziz.zzf(paramT, m & 0xFFFFF), zza(i));
          }
          break;
        case 59: 
          if (zza(paramT, k, i)) {
            zza(k, zziz.zzf(paramT, m & 0xFFFFF), paramzzjn);
          }
          break;
        case 58: 
          if (zza(paramT, k, i)) {
            paramzzjn.zza(k, zzf(paramT, m & 0xFFFFF));
          }
          break;
        case 57: 
          if (zza(paramT, k, i)) {
            paramzzjn.zzd(k, zzd(paramT, m & 0xFFFFF));
          }
          break;
        case 56: 
          if (zza(paramT, k, i)) {
            paramzzjn.zzd(k, zze(paramT, m & 0xFFFFF));
          }
          break;
        case 55: 
          if (zza(paramT, k, i)) {
            paramzzjn.zzc(k, zzd(paramT, m & 0xFFFFF));
          }
          break;
        case 54: 
          if (zza(paramT, k, i)) {
            paramzzjn.zzc(k, zze(paramT, m & 0xFFFFF));
          }
          break;
        case 53: 
          if (zza(paramT, k, i)) {
            paramzzjn.zza(k, zze(paramT, m & 0xFFFFF));
          }
          break;
        case 52: 
          if (zza(paramT, k, i)) {
            paramzzjn.zza(k, zzc(paramT, m & 0xFFFFF));
          }
          break;
        case 51: 
          if (zza(paramT, k, i)) {
            paramzzjn.zza(k, zzb(paramT, m & 0xFFFFF));
          }
          break;
        case 50: 
          zza(paramzzjn, k, zziz.zzf(paramT, m & 0xFFFFF), i);
          break;
        case 49: 
          zzid.zzb(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, zza(i));
          break;
        case 48: 
          zzid.zze(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, true);
          break;
        case 47: 
          zzid.zzj(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, true);
          break;
        case 46: 
          zzid.zzg(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, true);
          break;
        case 45: 
          zzid.zzl(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, true);
          break;
        case 44: 
          zzid.zzm(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, true);
          break;
        case 43: 
          zzid.zzi(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, true);
          break;
        case 42: 
          zzid.zzn(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, true);
          break;
        case 41: 
          zzid.zzk(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, true);
          break;
        case 40: 
          zzid.zzf(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, true);
          break;
        case 39: 
          zzid.zzh(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, true);
          break;
        case 38: 
          zzid.zzd(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, true);
          break;
        case 37: 
          zzid.zzc(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, true);
          break;
        case 36: 
          zzid.zzb(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, true);
          break;
        case 35: 
          zzid.zza(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, true);
          break;
        case 34: 
          zzid.zze(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, false);
          break;
        case 33: 
          zzid.zzj(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, false);
          break;
        case 32: 
          zzid.zzg(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, false);
          break;
        case 31: 
          zzid.zzl(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, false);
          break;
        case 30: 
          zzid.zzm(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, false);
          break;
        case 29: 
          zzid.zzi(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, false);
          break;
        case 28: 
          zzid.zzb(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn);
          break;
        case 27: 
          zzid.zza(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, zza(i));
          break;
        case 26: 
          zzid.zza(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn);
          break;
        case 25: 
          zzid.zzn(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, false);
          break;
        case 24: 
          zzid.zzk(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, false);
          break;
        case 23: 
          zzid.zzf(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, false);
          break;
        case 22: 
          zzid.zzh(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, false);
          break;
        case 21: 
          zzid.zzd(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, false);
          break;
        case 20: 
          zzid.zzc(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, false);
          break;
        case 19: 
          zzid.zzb(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, false);
          break;
        case 18: 
          zzid.zza(this.zzc[i], (List)zziz.zzf(paramT, m & 0xFFFFF), paramzzjn, false);
          break;
        case 17: 
          if (zza(paramT, i)) {
            paramzzjn.zzb(k, zziz.zzf(paramT, m & 0xFFFFF), zza(i));
          }
          break;
        case 16: 
          if (zza(paramT, i)) {
            paramzzjn.zze(k, zziz.zzb(paramT, m & 0xFFFFF));
          }
          break;
        case 15: 
          if (zza(paramT, i)) {
            paramzzjn.zzf(k, zziz.zza(paramT, m & 0xFFFFF));
          }
          break;
        case 14: 
          if (zza(paramT, i)) {
            paramzzjn.zzb(k, zziz.zzb(paramT, m & 0xFFFFF));
          }
          break;
        case 13: 
          if (zza(paramT, i)) {
            paramzzjn.zza(k, zziz.zza(paramT, m & 0xFFFFF));
          }
          break;
        case 12: 
          if (zza(paramT, i)) {
            paramzzjn.zzb(k, zziz.zza(paramT, m & 0xFFFFF));
          }
          break;
        case 11: 
          if (zza(paramT, i)) {
            paramzzjn.zze(k, zziz.zza(paramT, m & 0xFFFFF));
          }
          break;
        case 10: 
          if (zza(paramT, i)) {
            paramzzjn.zza(k, (zzew)zziz.zzf(paramT, m & 0xFFFFF));
          }
          break;
        case 9: 
          if (zza(paramT, i)) {
            paramzzjn.zza(k, zziz.zzf(paramT, m & 0xFFFFF), zza(i));
          }
          break;
        case 8: 
          if (zza(paramT, i)) {
            zza(k, zziz.zzf(paramT, m & 0xFFFFF), paramzzjn);
          }
          break;
        case 7: 
          if (zza(paramT, i)) {
            paramzzjn.zza(k, zziz.zzc(paramT, m & 0xFFFFF));
          }
          break;
        case 6: 
          if (zza(paramT, i)) {
            paramzzjn.zzd(k, zziz.zza(paramT, m & 0xFFFFF));
          }
          break;
        case 5: 
          if (zza(paramT, i)) {
            paramzzjn.zzd(k, zziz.zzb(paramT, m & 0xFFFFF));
          }
          break;
        case 4: 
          if (zza(paramT, i)) {
            paramzzjn.zzc(k, zziz.zza(paramT, m & 0xFFFFF));
          }
          break;
        case 3: 
          if (zza(paramT, i)) {
            paramzzjn.zzc(k, zziz.zzb(paramT, m & 0xFFFFF));
          }
          break;
        case 2: 
          if (zza(paramT, i)) {
            paramzzjn.zza(k, zziz.zzb(paramT, m & 0xFFFFF));
          }
          break;
        case 1: 
          if (zza(paramT, i)) {
            paramzzjn.zza(k, zziz.zzd(paramT, m & 0xFFFFF));
          }
          break;
        case 0: 
          if (zza(paramT, i)) {
            paramzzjn.zza(k, zziz.zze(paramT, m & 0xFFFFF));
          }
          break;
        }
      }
      while (localObject2 != null)
      {
        this.zzr.zza(paramzzjn, (Map.Entry)localObject2);
        if (localIterator.hasNext()) {
          localObject2 = (Map.Entry)localIterator.next();
        } else {
          localObject2 = null;
        }
      }
      zza(this.zzq, paramT, paramzzjn);
      return;
    }
    zzb(paramT, paramzzjn);
  }
  
  /* Error */
  public final boolean zza(T paramT1, T paramT2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 57	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzc	[I
    //   4: arraylength
    //   5: istore_3
    //   6: iconst_0
    //   7: istore 4
    //   9: iconst_1
    //   10: istore 5
    //   12: iload 4
    //   14: iload_3
    //   15: if_icmpge +973 -> 988
    //   18: aload_0
    //   19: iload 4
    //   21: invokespecial 275	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzc	(I)I
    //   24: istore 6
    //   26: iload 6
    //   28: ldc -100
    //   30: iand
    //   31: i2l
    //   32: lstore 7
    //   34: iload 6
    //   36: ldc_w 295
    //   39: iand
    //   40: bipush 20
    //   42: iushr
    //   43: tableswitch	default:+289->332, 0:+896->939, 1:+861->904, 2:+831->874, 3:+801->844, 4:+772->815, 5:+742->785, 6:+713->756, 7:+684->727, 8:+652->695, 9:+620->663, 10:+588->631, 11:+559->602, 12:+530->573, 13:+501->544, 14:+471->514, 15:+442->485, 16:+412->455, 17:+380->423, 18:+360->403, 19:+360->403, 20:+360->403, 21:+360->403, 22:+360->403, 23:+360->403, 24:+360->403, 25:+360->403, 26:+360->403, 27:+360->403, 28:+360->403, 29:+360->403, 30:+360->403, 31:+360->403, 32:+360->403, 33:+360->403, 34:+360->403, 35:+360->403, 36:+360->403, 37:+360->403, 38:+360->403, 39:+360->403, 40:+360->403, 41:+360->403, 42:+360->403, 43:+360->403, 44:+360->403, 45:+360->403, 46:+360->403, 47:+360->403, 48:+360->403, 49:+360->403, 50:+340->383, 51:+292->335, 52:+292->335, 53:+292->335, 54:+292->335, 55:+292->335, 56:+292->335, 57:+292->335, 58:+292->335, 59:+292->335, 60:+292->335, 61:+292->335, 62:+292->335, 63:+292->335, 64:+292->335, 65:+292->335, 66:+292->335, 67:+292->335, 68:+292->335
    //   332: goto +643 -> 975
    //   335: aload_0
    //   336: iload 4
    //   338: invokespecial 292	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzd	(I)I
    //   341: ldc -100
    //   343: iand
    //   344: i2l
    //   345: lstore 9
    //   347: aload_1
    //   348: lload 9
    //   350: invokestatic 304	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zza	(Ljava/lang/Object;J)I
    //   353: aload_2
    //   354: lload 9
    //   356: invokestatic 304	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zza	(Ljava/lang/Object;J)I
    //   359: if_icmpne +613 -> 972
    //   362: aload_1
    //   363: lload 7
    //   365: invokestatic 233	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   368: aload_2
    //   369: lload 7
    //   371: invokestatic 233	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   374: invokestatic 542	com/google/android/gms/internal/mlkit_vision_barcode/zzid:zza	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   377: ifne +598 -> 975
    //   380: goto +592 -> 972
    //   383: aload_1
    //   384: lload 7
    //   386: invokestatic 233	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   389: aload_2
    //   390: lload 7
    //   392: invokestatic 233	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   395: invokestatic 542	com/google/android/gms/internal/mlkit_vision_barcode/zzid:zza	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   398: istore 5
    //   400: goto +575 -> 975
    //   403: aload_1
    //   404: lload 7
    //   406: invokestatic 233	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   409: aload_2
    //   410: lload 7
    //   412: invokestatic 233	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   415: invokestatic 542	com/google/android/gms/internal/mlkit_vision_barcode/zzid:zza	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   418: istore 5
    //   420: goto +555 -> 975
    //   423: aload_0
    //   424: aload_1
    //   425: aload_2
    //   426: iload 4
    //   428: invokespecial 544	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   431: ifeq +541 -> 972
    //   434: aload_1
    //   435: lload 7
    //   437: invokestatic 233	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   440: aload_2
    //   441: lload 7
    //   443: invokestatic 233	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   446: invokestatic 542	com/google/android/gms/internal/mlkit_vision_barcode/zzid:zza	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   449: ifne +526 -> 975
    //   452: goto +520 -> 972
    //   455: aload_0
    //   456: aload_1
    //   457: aload_2
    //   458: iload 4
    //   460: invokespecial 544	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   463: ifeq +509 -> 972
    //   466: aload_1
    //   467: lload 7
    //   469: invokestatic 301	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzb	(Ljava/lang/Object;J)J
    //   472: aload_2
    //   473: lload 7
    //   475: invokestatic 301	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzb	(Ljava/lang/Object;J)J
    //   478: lcmp
    //   479: ifeq +496 -> 975
    //   482: goto +490 -> 972
    //   485: aload_0
    //   486: aload_1
    //   487: aload_2
    //   488: iload 4
    //   490: invokespecial 544	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   493: ifeq +479 -> 972
    //   496: aload_1
    //   497: lload 7
    //   499: invokestatic 304	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zza	(Ljava/lang/Object;J)I
    //   502: aload_2
    //   503: lload 7
    //   505: invokestatic 304	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zza	(Ljava/lang/Object;J)I
    //   508: if_icmpeq +467 -> 975
    //   511: goto +461 -> 972
    //   514: aload_0
    //   515: aload_1
    //   516: aload_2
    //   517: iload 4
    //   519: invokespecial 544	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   522: ifeq +450 -> 972
    //   525: aload_1
    //   526: lload 7
    //   528: invokestatic 301	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzb	(Ljava/lang/Object;J)J
    //   531: aload_2
    //   532: lload 7
    //   534: invokestatic 301	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzb	(Ljava/lang/Object;J)J
    //   537: lcmp
    //   538: ifeq +437 -> 975
    //   541: goto +431 -> 972
    //   544: aload_0
    //   545: aload_1
    //   546: aload_2
    //   547: iload 4
    //   549: invokespecial 544	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   552: ifeq +420 -> 972
    //   555: aload_1
    //   556: lload 7
    //   558: invokestatic 304	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zza	(Ljava/lang/Object;J)I
    //   561: aload_2
    //   562: lload 7
    //   564: invokestatic 304	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zza	(Ljava/lang/Object;J)I
    //   567: if_icmpeq +408 -> 975
    //   570: goto +402 -> 972
    //   573: aload_0
    //   574: aload_1
    //   575: aload_2
    //   576: iload 4
    //   578: invokespecial 544	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   581: ifeq +391 -> 972
    //   584: aload_1
    //   585: lload 7
    //   587: invokestatic 304	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zza	(Ljava/lang/Object;J)I
    //   590: aload_2
    //   591: lload 7
    //   593: invokestatic 304	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zza	(Ljava/lang/Object;J)I
    //   596: if_icmpeq +379 -> 975
    //   599: goto +373 -> 972
    //   602: aload_0
    //   603: aload_1
    //   604: aload_2
    //   605: iload 4
    //   607: invokespecial 544	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   610: ifeq +362 -> 972
    //   613: aload_1
    //   614: lload 7
    //   616: invokestatic 304	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zza	(Ljava/lang/Object;J)I
    //   619: aload_2
    //   620: lload 7
    //   622: invokestatic 304	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zza	(Ljava/lang/Object;J)I
    //   625: if_icmpeq +350 -> 975
    //   628: goto +344 -> 972
    //   631: aload_0
    //   632: aload_1
    //   633: aload_2
    //   634: iload 4
    //   636: invokespecial 544	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   639: ifeq +333 -> 972
    //   642: aload_1
    //   643: lload 7
    //   645: invokestatic 233	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   648: aload_2
    //   649: lload 7
    //   651: invokestatic 233	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   654: invokestatic 542	com/google/android/gms/internal/mlkit_vision_barcode/zzid:zza	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   657: ifne +318 -> 975
    //   660: goto +312 -> 972
    //   663: aload_0
    //   664: aload_1
    //   665: aload_2
    //   666: iload 4
    //   668: invokespecial 544	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   671: ifeq +301 -> 972
    //   674: aload_1
    //   675: lload 7
    //   677: invokestatic 233	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   680: aload_2
    //   681: lload 7
    //   683: invokestatic 233	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   686: invokestatic 542	com/google/android/gms/internal/mlkit_vision_barcode/zzid:zza	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   689: ifne +286 -> 975
    //   692: goto +280 -> 972
    //   695: aload_0
    //   696: aload_1
    //   697: aload_2
    //   698: iload 4
    //   700: invokespecial 544	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   703: ifeq +269 -> 972
    //   706: aload_1
    //   707: lload 7
    //   709: invokestatic 233	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   712: aload_2
    //   713: lload 7
    //   715: invokestatic 233	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   718: invokestatic 542	com/google/android/gms/internal/mlkit_vision_barcode/zzid:zza	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   721: ifne +254 -> 975
    //   724: goto +248 -> 972
    //   727: aload_0
    //   728: aload_1
    //   729: aload_2
    //   730: iload 4
    //   732: invokespecial 544	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   735: ifeq +237 -> 972
    //   738: aload_1
    //   739: lload 7
    //   741: invokestatic 315	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzc	(Ljava/lang/Object;J)Z
    //   744: aload_2
    //   745: lload 7
    //   747: invokestatic 315	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzc	(Ljava/lang/Object;J)Z
    //   750: if_icmpeq +225 -> 975
    //   753: goto +219 -> 972
    //   756: aload_0
    //   757: aload_1
    //   758: aload_2
    //   759: iload 4
    //   761: invokespecial 544	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   764: ifeq +208 -> 972
    //   767: aload_1
    //   768: lload 7
    //   770: invokestatic 304	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zza	(Ljava/lang/Object;J)I
    //   773: aload_2
    //   774: lload 7
    //   776: invokestatic 304	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zza	(Ljava/lang/Object;J)I
    //   779: if_icmpeq +196 -> 975
    //   782: goto +190 -> 972
    //   785: aload_0
    //   786: aload_1
    //   787: aload_2
    //   788: iload 4
    //   790: invokespecial 544	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   793: ifeq +179 -> 972
    //   796: aload_1
    //   797: lload 7
    //   799: invokestatic 301	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzb	(Ljava/lang/Object;J)J
    //   802: aload_2
    //   803: lload 7
    //   805: invokestatic 301	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzb	(Ljava/lang/Object;J)J
    //   808: lcmp
    //   809: ifeq +166 -> 975
    //   812: goto +160 -> 972
    //   815: aload_0
    //   816: aload_1
    //   817: aload_2
    //   818: iload 4
    //   820: invokespecial 544	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   823: ifeq +149 -> 972
    //   826: aload_1
    //   827: lload 7
    //   829: invokestatic 304	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zza	(Ljava/lang/Object;J)I
    //   832: aload_2
    //   833: lload 7
    //   835: invokestatic 304	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zza	(Ljava/lang/Object;J)I
    //   838: if_icmpeq +137 -> 975
    //   841: goto +131 -> 972
    //   844: aload_0
    //   845: aload_1
    //   846: aload_2
    //   847: iload 4
    //   849: invokespecial 544	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   852: ifeq +120 -> 972
    //   855: aload_1
    //   856: lload 7
    //   858: invokestatic 301	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzb	(Ljava/lang/Object;J)J
    //   861: aload_2
    //   862: lload 7
    //   864: invokestatic 301	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzb	(Ljava/lang/Object;J)J
    //   867: lcmp
    //   868: ifeq +107 -> 975
    //   871: goto +101 -> 972
    //   874: aload_0
    //   875: aload_1
    //   876: aload_2
    //   877: iload 4
    //   879: invokespecial 544	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   882: ifeq +90 -> 972
    //   885: aload_1
    //   886: lload 7
    //   888: invokestatic 301	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzb	(Ljava/lang/Object;J)J
    //   891: aload_2
    //   892: lload 7
    //   894: invokestatic 301	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzb	(Ljava/lang/Object;J)J
    //   897: lcmp
    //   898: ifeq +77 -> 975
    //   901: goto +71 -> 972
    //   904: aload_0
    //   905: aload_1
    //   906: aload_2
    //   907: iload 4
    //   909: invokespecial 544	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   912: ifeq +60 -> 972
    //   915: aload_1
    //   916: lload 7
    //   918: invokestatic 318	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzd	(Ljava/lang/Object;J)F
    //   921: invokestatic 526	java/lang/Float:floatToIntBits	(F)I
    //   924: aload_2
    //   925: lload 7
    //   927: invokestatic 318	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zzd	(Ljava/lang/Object;J)F
    //   930: invokestatic 526	java/lang/Float:floatToIntBits	(F)I
    //   933: if_icmpeq +42 -> 975
    //   936: goto +36 -> 972
    //   939: aload_0
    //   940: aload_1
    //   941: aload_2
    //   942: iload 4
    //   944: invokespecial 544	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   947: ifeq +25 -> 972
    //   950: aload_1
    //   951: lload 7
    //   953: invokestatic 321	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zze	(Ljava/lang/Object;J)D
    //   956: invokestatic 530	java/lang/Double:doubleToLongBits	(D)J
    //   959: aload_2
    //   960: lload 7
    //   962: invokestatic 321	com/google/android/gms/internal/mlkit_vision_barcode/zziz:zze	(Ljava/lang/Object;J)D
    //   965: invokestatic 530	java/lang/Double:doubleToLongBits	(D)J
    //   968: lcmp
    //   969: ifeq +6 -> 975
    //   972: iconst_0
    //   973: istore 5
    //   975: iload 5
    //   977: ifne +5 -> 982
    //   980: iconst_0
    //   981: ireturn
    //   982: iinc 4 3
    //   985: goto -976 -> 9
    //   988: aload_0
    //   989: getfield 90	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzq	Lcom/google/android/gms/internal/mlkit_vision_barcode/zzit;
    //   992: aload_1
    //   993: invokevirtual 104	com/google/android/gms/internal/mlkit_vision_barcode/zzit:zza	(Ljava/lang/Object;)Ljava/lang/Object;
    //   996: aload_0
    //   997: getfield 90	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzq	Lcom/google/android/gms/internal/mlkit_vision_barcode/zzit;
    //   1000: aload_2
    //   1001: invokevirtual 104	com/google/android/gms/internal/mlkit_vision_barcode/zzit:zza	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1004: invokevirtual 545	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   1007: ifne +5 -> 1012
    //   1010: iconst_0
    //   1011: ireturn
    //   1012: aload_0
    //   1013: getfield 76	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzh	Z
    //   1016: ifeq +23 -> 1039
    //   1019: aload_0
    //   1020: getfield 92	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzr	Lcom/google/android/gms/internal/mlkit_vision_barcode/zzfr;
    //   1023: aload_1
    //   1024: invokevirtual 345	com/google/android/gms/internal/mlkit_vision_barcode/zzfr:zza	(Ljava/lang/Object;)Lcom/google/android/gms/internal/mlkit_vision_barcode/zzfs;
    //   1027: aload_0
    //   1028: getfield 92	com/google/android/gms/internal/mlkit_vision_barcode/zzho:zzr	Lcom/google/android/gms/internal/mlkit_vision_barcode/zzfr;
    //   1031: aload_2
    //   1032: invokevirtual 345	com/google/android/gms/internal/mlkit_vision_barcode/zzfr:zza	(Ljava/lang/Object;)Lcom/google/android/gms/internal/mlkit_vision_barcode/zzfs;
    //   1035: invokevirtual 546	com/google/android/gms/internal/mlkit_vision_barcode/zzfs:equals	(Ljava/lang/Object;)Z
    //   1038: ireturn
    //   1039: iconst_1
    //   1040: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1041	0	this	zzho
    //   0	1041	1	paramT1	T
    //   0	1041	2	paramT2	T
    //   5	11	3	i	int
    //   7	976	4	j	int
    //   10	966	5	bool	boolean
    //   24	16	6	k	int
    //   32	929	7	l1	long
    //   345	10	9	l2	long
  }
  
  public final int zzb(T paramT)
  {
    int n;
    long l;
    Object localObject2;
    int i2;
    if (this.zzj)
    {
      localObject1 = zzb;
      i = 0;
      for (j = 0; i < this.zzc.length; j = m)
      {
        k = zzc(i);
        m = (k & 0xFF00000) >>> 20;
        n = this.zzc[i];
        l = k & 0xFFFFF;
        if ((m >= zzfx.zza.zza()) && (m <= zzfx.zzb.zza())) {
          k = this.zzc[(i + 2)] & 0xFFFFF;
        } else {
          k = 0;
        }
        switch (m)
        {
        default: 
          m = j;
          break;
        case 68: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzfn.zzc(n, (zzhk)zziz.zzf(paramT, l), zza(i));
          break;
        case 67: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzfn.zzf(n, zze(paramT, l));
          break;
        case 66: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzfn.zzh(n, zzd(paramT, l));
          break;
        case 65: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzfn.zzh(n, 0L);
          break;
        case 64: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzfn.zzj(n, 0);
          break;
        case 63: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzfn.zzk(n, zzd(paramT, l));
          break;
        case 62: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzfn.zzg(n, zzd(paramT, l));
          break;
        case 61: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzfn.zzc(n, (zzew)zziz.zzf(paramT, l));
          break;
        case 60: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzid.zza(n, zziz.zzf(paramT, l), zza(i));
          break;
        case 59: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          localObject2 = zziz.zzf(paramT, l);
          if ((localObject2 instanceof zzew)) {
            k = zzfn.zzc(n, (zzew)localObject2);
          } else {
            k = zzfn.zzb(n, (String)localObject2);
          }
          break;
        case 58: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzfn.zzb(n, true);
          break;
        case 57: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzfn.zzi(n, 0);
          break;
        case 56: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzfn.zzg(n, 0L);
          break;
        case 55: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzfn.zzf(n, zzd(paramT, l));
          break;
        case 54: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzfn.zze(n, zze(paramT, l));
          break;
        case 53: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzfn.zzd(n, zze(paramT, l));
          break;
        case 52: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzfn.zzb(n, 0.0F);
          break;
        case 51: 
          m = j;
          if (!zza(paramT, n, i)) {
            break label2777;
          }
          k = zzfn.zzb(n, 0.0D);
          break;
        case 50: 
          k = this.zzs.zza(n, zziz.zzf(paramT, l), zzb(i));
          break;
        case 49: 
          k = zzid.zzb(n, zza(paramT, l), zza(i));
          break;
        case 48: 
          i1 = zzid.zzc((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzfn.zze(n);
          i2 = zzfn.zzg(i1);
          m = i1;
          i1 = i2;
          break;
        case 47: 
          i1 = zzid.zzg((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzfn.zze(n);
          i2 = zzfn.zzg(i1);
          m = i1;
          i1 = i2;
          break;
        case 46: 
          i1 = zzid.zzi((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzfn.zze(n);
          i2 = zzfn.zzg(i1);
          m = i1;
          i1 = i2;
          break;
        case 45: 
          i1 = zzid.zzh((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzfn.zze(n);
          i2 = zzfn.zzg(i1);
          m = i1;
          i1 = i2;
          break;
        case 44: 
          i1 = zzid.zzd((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzfn.zze(n);
          i2 = zzfn.zzg(i1);
          m = i1;
          i1 = i2;
          break;
        case 43: 
          i1 = zzid.zzf((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzfn.zze(n);
          i2 = zzfn.zzg(i1);
          m = i1;
          i1 = i2;
          break;
        case 42: 
          i1 = zzid.zzj((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzfn.zze(n);
          i2 = zzfn.zzg(i1);
          m = i1;
          i1 = i2;
          break;
        case 41: 
          i1 = zzid.zzh((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzfn.zze(n);
          i2 = zzfn.zzg(i1);
          m = i1;
          i1 = i2;
          break;
        case 40: 
          i1 = zzid.zzi((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzfn.zze(n);
          i2 = zzfn.zzg(i1);
          m = i1;
          i1 = i2;
          break;
        case 39: 
          i1 = zzid.zze((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzfn.zze(n);
          i2 = zzfn.zzg(i1);
          m = i1;
          i1 = i2;
          break;
        case 38: 
          i1 = zzid.zzb((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzfn.zze(n);
          i2 = zzfn.zzg(i1);
          m = i1;
          i1 = i2;
          break;
        case 37: 
          i1 = zzid.zza((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzfn.zze(n);
          i2 = zzfn.zzg(i1);
          m = i1;
          i1 = i2;
          break;
        case 36: 
          i1 = zzid.zzh((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i1 <= 0) {
            break label2777;
          }
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, k, i1);
          }
          k = zzfn.zze(n);
          i2 = zzfn.zzg(i1);
          m = i1;
          i1 = i2;
          break;
        case 35: 
          i2 = zzid.zzi((List)((Unsafe)localObject1).getObject(paramT, l));
          m = j;
          if (i2 <= 0) {
            break label2777;
          }
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, k, i2);
          }
          k = zzfn.zze(n);
          i1 = zzfn.zzg(i2);
          m = i2;
          k = k + i1 + m;
          break;
        case 34: 
          k = zzid.zzc(n, zza(paramT, l), false);
          break;
        case 33: 
          k = zzid.zzg(n, zza(paramT, l), false);
          break;
        case 32: 
          k = zzid.zzi(n, zza(paramT, l), false);
          break;
        case 31: 
          k = zzid.zzh(n, zza(paramT, l), false);
          break;
        case 30: 
          k = zzid.zzd(n, zza(paramT, l), false);
          break;
        case 29: 
          k = zzid.zzf(n, zza(paramT, l), false);
          break;
        case 28: 
          k = zzid.zzb(n, zza(paramT, l));
          break;
        case 27: 
          k = zzid.zza(n, zza(paramT, l), zza(i));
          break;
        case 26: 
          k = zzid.zza(n, zza(paramT, l));
          break;
        case 25: 
          k = zzid.zzj(n, zza(paramT, l), false);
          break;
        case 24: 
          k = zzid.zzh(n, zza(paramT, l), false);
          break;
        case 23: 
          k = zzid.zzi(n, zza(paramT, l), false);
          break;
        case 22: 
          k = zzid.zze(n, zza(paramT, l), false);
          break;
        case 21: 
          k = zzid.zzb(n, zza(paramT, l), false);
          break;
        case 20: 
          k = zzid.zza(n, zza(paramT, l), false);
          break;
        case 19: 
          k = zzid.zzh(n, zza(paramT, l), false);
          break;
        case 18: 
          k = zzid.zzi(n, zza(paramT, l), false);
        }
        for (;;)
        {
          m = j + k;
          break;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          k = zzfn.zzc(n, (zzhk)zziz.zzf(paramT, l), zza(i));
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          k = zzfn.zzf(n, zziz.zzb(paramT, l));
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          k = zzfn.zzh(n, zziz.zza(paramT, l));
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          k = zzfn.zzh(n, 0L);
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          k = zzfn.zzj(n, 0);
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          k = zzfn.zzk(n, zziz.zza(paramT, l));
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          k = zzfn.zzg(n, zziz.zza(paramT, l));
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          k = zzfn.zzc(n, (zzew)zziz.zzf(paramT, l));
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          k = zzid.zza(n, zziz.zzf(paramT, l), zza(i));
          continue;
          m = j;
          if (!zza(paramT, i)) {
            break;
          }
          localObject2 = zziz.zzf(paramT, l);
          if ((localObject2 instanceof zzew))
          {
            k = zzfn.zzc(n, (zzew)localObject2);
          }
          else
          {
            k = zzfn.zzb(n, (String)localObject2);
            continue;
            m = j;
            if (!zza(paramT, i)) {
              break;
            }
            k = zzfn.zzb(n, true);
            continue;
            m = j;
            if (!zza(paramT, i)) {
              break;
            }
            k = zzfn.zzi(n, 0);
            continue;
            m = j;
            if (!zza(paramT, i)) {
              break;
            }
            k = zzfn.zzg(n, 0L);
            continue;
            m = j;
            if (!zza(paramT, i)) {
              break;
            }
            k = zzfn.zzf(n, zziz.zza(paramT, l));
            continue;
            m = j;
            if (!zza(paramT, i)) {
              break;
            }
            k = zzfn.zze(n, zziz.zzb(paramT, l));
            continue;
            m = j;
            if (!zza(paramT, i)) {
              break;
            }
            k = zzfn.zzd(n, zziz.zzb(paramT, l));
            continue;
            m = j;
            if (!zza(paramT, i)) {
              break;
            }
            k = zzfn.zzb(n, 0.0F);
            continue;
            m = j;
            if (!zza(paramT, i)) {
              break;
            }
            k = zzfn.zzb(n, 0.0D);
          }
        }
        label2777:
        i += 3;
      }
      return j + zza(this.zzq, paramT);
    }
    Object localObject1 = zzb;
    int j = 0;
    int i = 0;
    int k = 1048575;
    for (int m = 0; j < this.zzc.length; m = n)
    {
      int i3 = zzc(j);
      localObject2 = this.zzc;
      int i4 = localObject2[j];
      int i5 = (i3 & 0xFF00000) >>> 20;
      int i6;
      if (i5 <= 17)
      {
        i2 = localObject2[(j + 2)];
        n = i2 & 0xFFFFF;
        i6 = 1 << (i2 >>> 20);
        i1 = k;
        if (n != k)
        {
          m = ((Unsafe)localObject1).getInt(paramT, n);
          i1 = n;
        }
        k = i2;
        i2 = i1;
        i1 = k;
        n = m;
      }
      else
      {
        if ((this.zzk) && (i5 >= zzfx.zza.zza()) && (i5 <= zzfx.zzb.zza())) {
          i1 = this.zzc[(j + 2)] & 0xFFFFF;
        } else {
          i1 = 0;
        }
        i6 = 0;
        n = m;
        i2 = k;
      }
      l = i3 & 0xFFFFF;
      switch (i5)
      {
      default: 
        k = i;
        break;
      case 68: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzfn.zzc(i4, (zzhk)((Unsafe)localObject1).getObject(paramT, l), zza(j));
        }
        break;
      case 67: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzfn.zzf(i4, zze(paramT, l));
        }
        break;
      case 66: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzfn.zzh(i4, zzd(paramT, l));
        }
        break;
      case 65: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzfn.zzh(i4, 0L);
        }
        break;
      case 64: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzfn.zzj(i4, 0);
        }
        break;
      case 63: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzfn.zzk(i4, zzd(paramT, l));
        }
        break;
      case 62: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzfn.zzg(i4, zzd(paramT, l));
        }
        break;
      case 61: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzfn.zzc(i4, (zzew)((Unsafe)localObject1).getObject(paramT, l));
        }
        break;
      case 60: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzid.zza(i4, ((Unsafe)localObject1).getObject(paramT, l), zza(j));
        }
        break;
      case 59: 
        k = i;
        if (zza(paramT, i4, j))
        {
          localObject2 = ((Unsafe)localObject1).getObject(paramT, l);
          if ((localObject2 instanceof zzew)) {
            k = zzfn.zzc(i4, (zzew)localObject2);
          } else {
            k = zzfn.zzb(i4, (String)localObject2);
          }
        }
        break;
      case 58: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzfn.zzb(i4, true);
        }
        break;
      case 57: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzfn.zzi(i4, 0);
        }
        break;
      case 56: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzfn.zzg(i4, 0L);
        }
        break;
      case 55: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzfn.zzf(i4, zzd(paramT, l));
        }
        break;
      case 54: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzfn.zze(i4, zze(paramT, l));
        }
        break;
      case 53: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzfn.zzd(i4, zze(paramT, l));
        }
        break;
      case 52: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzfn.zzb(i4, 0.0F);
        }
        break;
      case 51: 
        k = i;
        if (zza(paramT, i4, j)) {
          k = zzfn.zzb(i4, 0.0D);
        }
        break;
      case 50: 
        k = this.zzs.zza(i4, ((Unsafe)localObject1).getObject(paramT, l), zzb(j));
        break;
      case 49: 
        k = zzid.zzb(i4, (List)((Unsafe)localObject1).getObject(paramT, l), zza(j));
        break;
      case 48: 
        m = zzid.zzc((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzfn.zze(i4);
          i1 = zzfn.zzg(m);
          k = m;
          m = i6;
        }
        break;
      case 47: 
        m = zzid.zzg((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzfn.zze(i4);
          i1 = zzfn.zzg(m);
          k = m;
          m = i6;
        }
        break;
      case 46: 
        m = zzid.zzi((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzfn.zze(i4);
          i1 = zzfn.zzg(m);
          k = m;
          m = i6;
        }
        break;
      case 45: 
        m = zzid.zzh((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzfn.zze(i4);
          i1 = zzfn.zzg(m);
          k = m;
          m = i6;
        }
        break;
      case 44: 
        m = zzid.zzd((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzfn.zze(i4);
          i1 = zzfn.zzg(m);
          k = m;
          m = i6;
        }
        break;
      case 43: 
        m = zzid.zzf((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzfn.zze(i4);
          i1 = zzfn.zzg(m);
          k = m;
          m = i6;
        }
        break;
      case 42: 
        m = zzid.zzj((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzfn.zze(i4);
          i1 = zzfn.zzg(m);
          k = m;
          m = i6;
        }
        break;
      case 41: 
        m = zzid.zzh((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzfn.zze(i4);
          i1 = zzfn.zzg(m);
          k = m;
          m = i6;
        }
        break;
      case 40: 
        m = zzid.zzi((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzfn.zze(i4);
          i1 = zzfn.zzg(m);
          k = m;
          m = i6;
        }
        break;
      case 39: 
        m = zzid.zze((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzfn.zze(i4);
          i1 = zzfn.zzg(m);
          k = m;
          m = i6;
        }
        break;
      case 38: 
        m = zzid.zzb((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzfn.zze(i4);
          i1 = zzfn.zzg(m);
          k = m;
          m = i6;
        }
        break;
      case 37: 
        m = zzid.zza((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzfn.zze(i4);
          i1 = zzfn.zzg(m);
          k = m;
          m = i6;
        }
        break;
      case 36: 
        m = zzid.zzh((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (m > 0)
        {
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, i1, m);
          }
          i6 = zzfn.zze(i4);
          i1 = zzfn.zzg(m);
          k = m;
          m = i6;
        }
        break;
      case 35: 
        i6 = zzid.zzi((List)((Unsafe)localObject1).getObject(paramT, l));
        k = i;
        if (i6 > 0)
        {
          if (this.zzk) {
            ((Unsafe)localObject1).putInt(paramT, i1, i6);
          }
          m = zzfn.zze(i4);
          i1 = zzfn.zzg(i6);
          k = i6;
          k = m + i1 + k;
        }
        break;
      case 34: 
        k = zzid.zzc(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 33: 
        k = zzid.zzg(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 32: 
        k = zzid.zzi(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 31: 
        k = zzid.zzh(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 30: 
        k = zzid.zzd(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 29: 
        k = zzid.zzf(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 28: 
        k = zzid.zzb(i4, (List)((Unsafe)localObject1).getObject(paramT, l));
        break;
      case 27: 
        k = zzid.zza(i4, (List)((Unsafe)localObject1).getObject(paramT, l), zza(j));
        break;
      case 26: 
        k = zzid.zza(i4, (List)((Unsafe)localObject1).getObject(paramT, l));
        break;
      case 25: 
        k = zzid.zzj(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 24: 
        k = zzid.zzh(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 23: 
        k = zzid.zzi(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 22: 
        k = zzid.zze(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 21: 
        k = zzid.zzb(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 20: 
        k = zzid.zza(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 19: 
        k = zzid.zzh(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 18: 
        k = zzid.zzi(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        k = i + k;
      }
      for (;;)
      {
        break label5735;
        k = i;
        if ((n & i6) != 0)
        {
          k = zzfn.zzc(i4, (zzhk)((Unsafe)localObject1).getObject(paramT, l), zza(j));
          break;
          k = i;
          if ((n & i6) != 0)
          {
            k = zzfn.zzf(i4, ((Unsafe)localObject1).getLong(paramT, l));
            break;
            k = i;
            if ((n & i6) != 0)
            {
              k = zzfn.zzh(i4, ((Unsafe)localObject1).getInt(paramT, l));
              break;
              k = i;
              if ((n & i6) != 0)
              {
                k = zzfn.zzh(i4, 0L);
                break;
                k = i;
                if ((n & i6) != 0)
                {
                  k = zzfn.zzj(i4, 0);
                  k = i + k;
                  continue;
                  k = i;
                  if ((n & i6) != 0)
                  {
                    k = zzfn.zzk(i4, ((Unsafe)localObject1).getInt(paramT, l));
                    break;
                    k = i;
                    if ((n & i6) != 0)
                    {
                      k = zzfn.zzg(i4, ((Unsafe)localObject1).getInt(paramT, l));
                      break;
                      k = i;
                      if ((n & i6) != 0)
                      {
                        k = zzfn.zzc(i4, (zzew)((Unsafe)localObject1).getObject(paramT, l));
                        break;
                        k = i;
                        if ((n & i6) != 0)
                        {
                          k = zzid.zza(i4, ((Unsafe)localObject1).getObject(paramT, l), zza(j));
                          break;
                          k = i;
                          if ((n & i6) != 0)
                          {
                            localObject2 = ((Unsafe)localObject1).getObject(paramT, l);
                            if ((localObject2 instanceof zzew))
                            {
                              k = zzfn.zzc(i4, (zzew)localObject2);
                              break;
                            }
                            k = zzfn.zzb(i4, (String)localObject2);
                            break;
                            k = i;
                            if ((n & i6) != 0)
                            {
                              k = zzfn.zzb(i4, true);
                              break;
                              k = i;
                              if ((n & i6) != 0)
                              {
                                k = i + zzfn.zzi(i4, 0);
                                continue;
                                k = i;
                                if ((n & i6) != 0)
                                {
                                  k = zzfn.zzg(i4, 0L);
                                  break label5681;
                                  k = i;
                                  if ((n & i6) != 0)
                                  {
                                    k = zzfn.zzf(i4, ((Unsafe)localObject1).getInt(paramT, l));
                                    break label5681;
                                    k = i;
                                    if ((n & i6) != 0)
                                    {
                                      k = zzfn.zze(i4, ((Unsafe)localObject1).getLong(paramT, l));
                                      break label5681;
                                      k = i;
                                      if ((n & i6) != 0)
                                      {
                                        k = zzfn.zzd(i4, ((Unsafe)localObject1).getLong(paramT, l));
                                        label5681:
                                        k = i + k;
                                      }
                                    }
                                  }
                                }
                                for (;;)
                                {
                                  break;
                                  k = i;
                                  if ((n & i6) != 0) {
                                    k = i + zzfn.zzb(i4, 0.0F);
                                  }
                                }
                                for (;;)
                                {
                                  break;
                                  k = i;
                                  if ((n & i6) != 0) {
                                    k = i + zzfn.zzb(i4, 0.0D);
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label5735:
      j += 3;
      i = k;
      k = i2;
    }
    j = 0;
    int i1 = i + zza(this.zzq, paramT);
    k = i1;
    if (this.zzh)
    {
      paramT = this.zzr.zza(paramT);
      m = 0;
      k = j;
      while (m < paramT.zza.zzc())
      {
        localObject1 = paramT.zza.zzb(m);
        k += zzfs.zza((zzfu)((Map.Entry)localObject1).getKey(), ((Map.Entry)localObject1).getValue());
        m++;
      }
      localObject1 = paramT.zza.zzd().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramT = (Map.Entry)((Iterator)localObject1).next();
        k += zzfs.zza((zzfu)paramT.getKey(), paramT.getValue());
      }
      k = i1 + k;
    }
    return k;
  }
  
  public final void zzb(T paramT1, T paramT2)
  {
    Objects.requireNonNull(paramT2);
    for (int i = 0; i < this.zzc.length; i += 3)
    {
      int j = zzc(i);
      long l = 0xFFFFF & j;
      int k = this.zzc[i];
      switch ((j & 0xFF00000) >>> 20)
      {
      default: 
        break;
      case 68: 
        zzb(paramT1, paramT2, i);
        break;
      case 61: 
      case 62: 
      case 63: 
      case 64: 
      case 65: 
      case 66: 
      case 67: 
        if (zza(paramT2, k, i))
        {
          zziz.zza(paramT1, l, zziz.zzf(paramT2, l));
          zzb(paramT1, k, i);
        }
        break;
      case 60: 
        zzb(paramT1, paramT2, i);
        break;
      case 51: 
      case 52: 
      case 53: 
      case 54: 
      case 55: 
      case 56: 
      case 57: 
      case 58: 
      case 59: 
        if (zza(paramT2, k, i))
        {
          zziz.zza(paramT1, l, zziz.zzf(paramT2, l));
          zzb(paramT1, k, i);
        }
        break;
      case 50: 
        zzid.zza(this.zzs, paramT1, paramT2, l);
        break;
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      case 24: 
      case 25: 
      case 26: 
      case 27: 
      case 28: 
      case 29: 
      case 30: 
      case 31: 
      case 32: 
      case 33: 
      case 34: 
      case 35: 
      case 36: 
      case 37: 
      case 38: 
      case 39: 
      case 40: 
      case 41: 
      case 42: 
      case 43: 
      case 44: 
      case 45: 
      case 46: 
      case 47: 
      case 48: 
      case 49: 
        this.zzp.zza(paramT1, paramT2, l);
        break;
      case 17: 
        zza(paramT1, paramT2, i);
        break;
      case 16: 
        if (zza(paramT2, i))
        {
          zziz.zza(paramT1, l, zziz.zzb(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 15: 
        if (zza(paramT2, i))
        {
          zziz.zza(paramT1, l, zziz.zza(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 14: 
        if (zza(paramT2, i))
        {
          zziz.zza(paramT1, l, zziz.zzb(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 13: 
        if (zza(paramT2, i))
        {
          zziz.zza(paramT1, l, zziz.zza(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 12: 
        if (zza(paramT2, i))
        {
          zziz.zza(paramT1, l, zziz.zza(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 11: 
        if (zza(paramT2, i))
        {
          zziz.zza(paramT1, l, zziz.zza(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 10: 
        if (zza(paramT2, i))
        {
          zziz.zza(paramT1, l, zziz.zzf(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 9: 
        zza(paramT1, paramT2, i);
        break;
      case 8: 
        if (zza(paramT2, i))
        {
          zziz.zza(paramT1, l, zziz.zzf(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 7: 
        if (zza(paramT2, i))
        {
          zziz.zza(paramT1, l, zziz.zzc(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 6: 
        if (zza(paramT2, i))
        {
          zziz.zza(paramT1, l, zziz.zza(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 5: 
        if (zza(paramT2, i))
        {
          zziz.zza(paramT1, l, zziz.zzb(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 4: 
        if (zza(paramT2, i))
        {
          zziz.zza(paramT1, l, zziz.zza(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 3: 
        if (zza(paramT2, i))
        {
          zziz.zza(paramT1, l, zziz.zzb(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 2: 
        if (zza(paramT2, i))
        {
          zziz.zza(paramT1, l, zziz.zzb(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 1: 
        if (zza(paramT2, i))
        {
          zziz.zza(paramT1, l, zziz.zzd(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      case 0: 
        if (zza(paramT2, i))
        {
          zziz.zza(paramT1, l, zziz.zze(paramT2, l));
          zzb(paramT1, i);
        }
        break;
      }
    }
    zzid.zza(this.zzq, paramT1, paramT2);
    if (this.zzh) {
      zzid.zza(this.zzr, paramT1, paramT2);
    }
  }
  
  public final void zzc(T paramT)
  {
    int j;
    for (int i = this.zzm;; i++)
    {
      j = this.zzn;
      if (i >= j) {
        break;
      }
      long l = zzc(this.zzl[i]) & 0xFFFFF;
      Object localObject = zziz.zzf(paramT, l);
      if (localObject != null) {
        zziz.zza(paramT, l, this.zzs.zzc(localObject));
      }
    }
    int k = this.zzl.length;
    for (i = j; i < k; i++) {
      this.zzp.zza(paramT, this.zzl[i]);
    }
    this.zzq.zzb(paramT);
    if (this.zzh) {
      this.zzr.zzc(paramT);
    }
  }
  
  public final boolean zzd(T paramT)
  {
    int i = 1048575;
    int j = 0;
    for (int k = 0;; k++)
    {
      int m = this.zzm;
      int n = 1;
      int i1 = 1;
      if (k >= m) {
        break;
      }
      int i2 = this.zzl[k];
      int i3 = this.zzc[i2];
      int i4 = zzc(i2);
      int i5 = this.zzc[(i2 + 2)];
      m = i5 & 0xFFFFF;
      i5 = 1 << (i5 >>> 20);
      if (m != i)
      {
        if (m != 1048575) {
          j = zzb.getInt(paramT, m);
        }
        i = m;
      }
      if ((0x10000000 & i4) != 0) {
        m = 1;
      } else {
        m = 0;
      }
      if ((m != 0) && (!zza(paramT, i2, i, j, i5))) {
        return false;
      }
      m = (0xFF00000 & i4) >>> 20;
      if ((m != 9) && (m != 17))
      {
        Object localObject1;
        if (m != 27) {
          if ((m != 60) && (m != 68))
          {
            if (m != 49)
            {
              if (m != 50) {
                continue;
              }
              localObject1 = this.zzs.zzb(zziz.zzf(paramT, i4 & 0xFFFFF));
              m = i1;
              if (!((Map)localObject1).isEmpty())
              {
                localObject2 = zzb(i2);
                m = i1;
                if (this.zzs.zza(localObject2).zzb.zza() == zzjk.zzi)
                {
                  localObject2 = null;
                  Iterator localIterator = ((Map)localObject1).values().iterator();
                  Object localObject3;
                  do
                  {
                    m = i1;
                    if (!localIterator.hasNext()) {
                      break;
                    }
                    localObject3 = localIterator.next();
                    localObject1 = localObject2;
                    if (localObject2 == null) {
                      localObject1 = zzhw.zza().zza(localObject3.getClass());
                    }
                    localObject2 = localObject1;
                  } while (((zzib)localObject1).zzd(localObject3));
                  m = 0;
                }
              }
              if (m != 0) {
                continue;
              }
              return false;
            }
          }
          else
          {
            if ((!zza(paramT, i3, i2)) || (zza(paramT, i4, zza(i2)))) {
              continue;
            }
            return false;
          }
        }
        Object localObject2 = (List)zziz.zzf(paramT, i4 & 0xFFFFF);
        m = n;
        if (!((List)localObject2).isEmpty())
        {
          localObject1 = zza(i2);
          for (i1 = 0;; i1++)
          {
            m = n;
            if (i1 >= ((List)localObject2).size()) {
              break;
            }
            if (!((zzib)localObject1).zzd(((List)localObject2).get(i1)))
            {
              m = 0;
              break;
            }
          }
        }
        if (m == 0) {
          return false;
        }
      }
      else if ((zza(paramT, i2, i, j, i5)) && (!zza(paramT, i4, zza(i2))))
      {
        return false;
      }
    }
    return (!this.zzh) || (this.zzr.zza(paramT).zzf());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */