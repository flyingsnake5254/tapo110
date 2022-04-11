package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzep;
import com.google.android.gms.internal.measurement.zzeq;
import com.google.android.gms.internal.measurement.zzew;
import com.google.android.gms.internal.measurement.zzex;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

abstract class zzw
{
  final String zzb;
  final int zzc;
  Boolean zzd;
  Boolean zze;
  Long zzf;
  Long zzg;
  
  zzw(String paramString, int paramInt)
  {
    this.zzb = paramString;
    this.zzc = paramInt;
  }
  
  private static Boolean zzd(String paramString1, zzew paramzzew, boolean paramBoolean, String paramString2, List<String> paramList, String paramString3, zzem paramzzem)
  {
    if (paramzzew == zzew.zzg)
    {
      if ((paramList == null) || (paramList.size() == 0)) {
        return null;
      }
    }
    else if (paramString2 == null) {
      return null;
    }
    String str = paramString1;
    if (!paramBoolean)
    {
      str = paramString1;
      if (paramzzew != zzew.zzb) {
        str = paramString1.toUpperCase(Locale.ENGLISH);
      }
    }
    paramString1 = zzep.zza;
    switch (paramzzew.ordinal())
    {
    default: 
      return null;
    case 6: 
      if (paramList == null) {
        return null;
      }
      return Boolean.valueOf(paramList.contains(str));
    case 5: 
      return Boolean.valueOf(str.equals(paramString2));
    case 4: 
      return Boolean.valueOf(str.contains(paramString2));
    case 3: 
      return Boolean.valueOf(str.endsWith(paramString2));
    case 2: 
      return Boolean.valueOf(str.startsWith(paramString2));
    }
    if (paramString3 == null) {
      return null;
    }
    int i;
    if (true != paramBoolean) {
      i = 66;
    } else {
      i = 0;
    }
    try
    {
      paramBoolean = Pattern.compile(paramString3, i).matcher(str).matches();
      return Boolean.valueOf(paramBoolean);
    }
    catch (PatternSyntaxException paramString1)
    {
      if (paramzzem != null) {
        paramzzem.zze().zzb("Invalid regular expression in REGEXP audience filter. expression", paramString3);
      }
    }
    return null;
  }
  
  @VisibleForTesting
  static Boolean zze(Boolean paramBoolean, boolean paramBoolean1)
  {
    if (paramBoolean == null) {
      return null;
    }
    if (paramBoolean.booleanValue() != paramBoolean1) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    return Boolean.valueOf(paramBoolean1);
  }
  
  @VisibleForTesting
  static Boolean zzf(String paramString, zzex paramzzex, zzem paramzzem)
  {
    Preconditions.checkNotNull(paramzzex);
    if (paramString == null) {
      return null;
    }
    if ((paramzzex.zza()) && (paramzzex.zzb() != zzew.zza))
    {
      Object localObject1 = paramzzex.zzb();
      Object localObject2 = zzew.zzg;
      if (localObject1 == localObject2)
      {
        if (paramzzex.zzh() == 0) {
          return null;
        }
      }
      else if (!paramzzex.zzc()) {
        return null;
      }
      zzew localzzew = paramzzex.zzb();
      boolean bool = paramzzex.zzf();
      if ((!bool) && (localzzew != zzew.zzb) && (localzzew != localObject2)) {
        localObject2 = paramzzex.zzd().toUpperCase(Locale.ENGLISH);
      } else {
        localObject2 = paramzzex.zzd();
      }
      if (paramzzex.zzh() == 0)
      {
        paramzzex = null;
      }
      else
      {
        localObject1 = paramzzex.zzg();
        paramzzex = (zzex)localObject1;
        if (!bool)
        {
          paramzzex = new ArrayList(((List)localObject1).size());
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            paramzzex.add(((String)((Iterator)localObject1).next()).toUpperCase(Locale.ENGLISH));
          }
          paramzzex = Collections.unmodifiableList(paramzzex);
        }
      }
      if (localzzew == zzew.zzb) {
        localObject1 = localObject2;
      } else {
        localObject1 = null;
      }
      return zzd(paramString, localzzew, bool, (String)localObject2, paramzzex, (String)localObject1, paramzzem);
    }
    return null;
  }
  
  static Boolean zzg(long paramLong, zzeq paramzzeq)
  {
    try
    {
      BigDecimal localBigDecimal = new java/math/BigDecimal;
      localBigDecimal.<init>(paramLong);
      paramzzeq = zzj(localBigDecimal, paramzzeq, 0.0D);
      return paramzzeq;
    }
    catch (NumberFormatException paramzzeq) {}
    return null;
  }
  
  static Boolean zzh(double paramDouble, zzeq paramzzeq)
  {
    try
    {
      BigDecimal localBigDecimal = new java/math/BigDecimal;
      localBigDecimal.<init>(paramDouble);
      paramzzeq = zzj(localBigDecimal, paramzzeq, Math.ulp(paramDouble));
      return paramzzeq;
    }
    catch (NumberFormatException paramzzeq) {}
    return null;
  }
  
  static Boolean zzi(String paramString, zzeq paramzzeq)
  {
    if (!zzkp.zzl(paramString)) {
      return null;
    }
    try
    {
      BigDecimal localBigDecimal = new java/math/BigDecimal;
      localBigDecimal.<init>(paramString);
      paramString = zzj(localBigDecimal, paramzzeq, 0.0D);
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  @VisibleForTesting
  static Boolean zzj(BigDecimal paramBigDecimal, zzeq paramzzeq, double paramDouble)
  {
    Preconditions.checkNotNull(paramzzeq);
    boolean bool1 = paramzzeq.zza();
    Object localObject1 = null;
    Object localObject2;
    zzep localzzep1;
    zzep localzzep2;
    if ((bool1) && (paramzzeq.zzb() != zzep.zza))
    {
      localObject2 = paramzzeq.zzb();
      localzzep1 = zzep.zze;
      if (localObject2 == localzzep1)
      {
        if ((!paramzzeq.zzg()) || (!paramzzeq.zzi())) {
          return null;
        }
      }
      else if (!paramzzeq.zze()) {
        return null;
      }
      localzzep2 = paramzzeq.zzb();
      if ((paramzzeq.zzb() == localzzep1) && ((!zzkp.zzl(paramzzeq.zzh())) || (!zzkp.zzl(paramzzeq.zzj())))) {}
    }
    try
    {
      localBigDecimal1 = new java/math/BigDecimal;
      localBigDecimal1.<init>(paramzzeq.zzh());
      localBigDecimal2 = new BigDecimal(paramzzeq.zzj());
      localObject2 = null;
    }
    catch (NumberFormatException paramBigDecimal)
    {
      BigDecimal localBigDecimal1;
      BigDecimal localBigDecimal2;
      for (;;) {}
    }
    return null;
    if (!zzkp.zzl(paramzzeq.zzf())) {
      return null;
    }
    try
    {
      localObject2 = new BigDecimal(paramzzeq.zzf());
      localBigDecimal1 = null;
      localBigDecimal2 = localBigDecimal1;
      if (localzzep2 == localzzep1)
      {
        paramzzeq = (zzeq)localObject1;
        if (localBigDecimal1 == null) {
          break label479;
        }
      }
      else if (localObject2 == null)
      {
        paramzzeq = (zzeq)localObject1;
        break label479;
      }
      paramzzeq = zzew.zza;
      int i = localzzep2.ordinal();
      boolean bool2 = true;
      boolean bool3 = true;
      boolean bool4 = true;
      boolean bool5 = true;
      bool1 = true;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              paramzzeq = (zzeq)localObject1;
            }
            else
            {
              paramzzeq = (zzeq)localObject1;
              if (localBigDecimal1 != null)
              {
                if ((paramBigDecimal.compareTo(localBigDecimal1) < 0) || (paramBigDecimal.compareTo(localBigDecimal2) > 0)) {
                  bool1 = false;
                }
                paramzzeq = Boolean.valueOf(bool1);
              }
            }
          }
          else if (localObject2 == null)
          {
            paramzzeq = (zzeq)localObject1;
          }
          else if (paramDouble != 0.0D)
          {
            if ((paramBigDecimal.compareTo(((BigDecimal)localObject2).subtract(new BigDecimal(paramDouble).multiply(new BigDecimal(2)))) > 0) && (paramBigDecimal.compareTo(((BigDecimal)localObject2).add(new BigDecimal(paramDouble).multiply(new BigDecimal(2)))) < 0)) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
            paramzzeq = Boolean.valueOf(bool1);
          }
          else
          {
            if (paramBigDecimal.compareTo((BigDecimal)localObject2) == 0) {
              bool1 = bool3;
            } else {
              bool1 = false;
            }
            paramzzeq = Boolean.valueOf(bool1);
          }
        }
        else if (localObject2 == null)
        {
          paramzzeq = (zzeq)localObject1;
        }
        else
        {
          if (paramBigDecimal.compareTo((BigDecimal)localObject2) > 0) {
            bool1 = bool4;
          } else {
            bool1 = false;
          }
          return Boolean.valueOf(bool1);
        }
      }
      else
      {
        if (localObject2 != null) {
          break label481;
        }
        paramzzeq = (zzeq)localObject1;
      }
      label479:
      return paramzzeq;
      label481:
      if (paramBigDecimal.compareTo((BigDecimal)localObject2) < 0) {
        bool1 = bool5;
      } else {
        bool1 = false;
      }
      return Boolean.valueOf(bool1);
    }
    catch (NumberFormatException paramBigDecimal)
    {
      for (;;) {}
    }
    return null;
  }
  
  abstract int zza();
  
  abstract boolean zzb();
  
  abstract boolean zzc();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */