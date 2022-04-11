package com.google.android.gms.internal.measurement;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

public final class zzah
  implements zzap
{
  private final Double zza;
  
  public zzah(Double paramDouble)
  {
    if (paramDouble == null)
    {
      this.zza = Double.valueOf(NaN.0D);
      return;
    }
    this.zza = paramDouble;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzah)) {
      return false;
    }
    paramObject = (zzah)paramObject;
    return this.zza.equals(((zzah)paramObject).zza);
  }
  
  public final int hashCode()
  {
    return this.zza.hashCode();
  }
  
  public final String toString()
  {
    return zzc();
  }
  
  public final zzap zzbK(String paramString, zzg paramzzg, List<zzap> paramList)
  {
    if ("toString".equals(paramString)) {
      return new zzat(zzc());
    }
    throw new IllegalArgumentException(String.format("%s.%s is not a function.", new Object[] { zzc(), paramString }));
  }
  
  public final String zzc()
  {
    if (Double.isNaN(this.zza.doubleValue())) {
      return "NaN";
    }
    if (Double.isInfinite(this.zza.doubleValue()))
    {
      if (this.zza.doubleValue() > 0.0D) {
        return "Infinity";
      }
      return "-Infinity";
    }
    BigDecimal localBigDecimal = BigDecimal.valueOf(this.zza.doubleValue()).stripTrailingZeros();
    Object localObject = new DecimalFormat("0E0");
    ((NumberFormat)localObject).setRoundingMode(RoundingMode.HALF_UP);
    if (localBigDecimal.scale() > 0) {
      i = localBigDecimal.precision();
    } else {
      i = localBigDecimal.scale();
    }
    ((NumberFormat)localObject).setMinimumFractionDigits(i - 1);
    String str = ((NumberFormat)localObject).format(localBigDecimal);
    int i = str.indexOf("E");
    localObject = str;
    if (i > 0)
    {
      i = Integer.parseInt(str.substring(i + 1));
      if (((i < 0) && (i > -7)) || ((i >= 0) && (i < 21))) {
        localObject = localBigDecimal.toPlainString();
      } else {
        localObject = str.replace("E-", "e-").replace("E", "e+");
      }
    }
    return (String)localObject;
  }
  
  public final Double zzd()
  {
    return this.zza;
  }
  
  public final Boolean zze()
  {
    boolean bool1 = Double.isNaN(this.zza.doubleValue());
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (!bool1)
    {
      bool3 = bool2;
      if (this.zza.doubleValue() != 0.0D) {
        bool3 = true;
      }
    }
    return Boolean.valueOf(bool3);
  }
  
  public final Iterator<zzap> zzf()
  {
    return null;
  }
  
  public final zzap zzt()
  {
    return new zzah(this.zza);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */