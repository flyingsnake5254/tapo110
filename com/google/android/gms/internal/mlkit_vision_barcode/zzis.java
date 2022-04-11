package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.IOException;
import java.util.Arrays;

public final class zzis
{
  private static final zzis zza = new zzis(0, new int[0], new Object[0], false);
  private int zzb;
  private int[] zzc;
  private Object[] zzd;
  private int zze = -1;
  private boolean zzf;
  
  private zzis()
  {
    this(0, new int[8], new Object[8], true);
  }
  
  private zzis(int paramInt, int[] paramArrayOfInt, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    this.zzb = paramInt;
    this.zzc = paramArrayOfInt;
    this.zzd = paramArrayOfObject;
    this.zzf = paramBoolean;
  }
  
  public static zzis zza()
  {
    return zza;
  }
  
  static zzis zza(zzis paramzzis1, zzis paramzzis2)
  {
    int i = paramzzis1.zzb + paramzzis2.zzb;
    int[] arrayOfInt = Arrays.copyOf(paramzzis1.zzc, i);
    System.arraycopy(paramzzis2.zzc, 0, arrayOfInt, paramzzis1.zzb, paramzzis2.zzb);
    Object[] arrayOfObject = Arrays.copyOf(paramzzis1.zzd, i);
    System.arraycopy(paramzzis2.zzd, 0, arrayOfObject, paramzzis1.zzb, paramzzis2.zzb);
    return new zzis(i, arrayOfInt, arrayOfObject, true);
  }
  
  private static void zza(int paramInt, Object paramObject, zzjn paramzzjn)
    throws IOException
  {
    int i = paramInt >>> 3;
    paramInt &= 0x7;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt == 5)
            {
              paramzzjn.zzd(i, ((Integer)paramObject).intValue());
              return;
            }
            throw new RuntimeException(zzgk.zza());
          }
          if (paramzzjn.zza() == zzga.zze.zzj)
          {
            paramzzjn.zza(i);
            ((zzis)paramObject).zzb(paramzzjn);
            paramzzjn.zzb(i);
            return;
          }
          paramzzjn.zzb(i);
          ((zzis)paramObject).zzb(paramzzjn);
          paramzzjn.zza(i);
          return;
        }
        paramzzjn.zza(i, (zzew)paramObject);
        return;
      }
      paramzzjn.zzd(i, ((Long)paramObject).longValue());
      return;
    }
    paramzzjn.zza(i, ((Long)paramObject).longValue());
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof zzis)) {
      return false;
    }
    paramObject = (zzis)paramObject;
    int i = this.zzb;
    if (i == ((zzis)paramObject).zzb)
    {
      Object localObject = this.zzc;
      int[] arrayOfInt = ((zzis)paramObject).zzc;
      for (int j = 0; j < i; j++) {
        if (localObject[j] != arrayOfInt[j])
        {
          j = 0;
          break label87;
        }
      }
      j = 1;
      label87:
      if (j != 0)
      {
        localObject = this.zzd;
        paramObject = ((zzis)paramObject).zzd;
        i = this.zzb;
        for (j = 0; j < i; j++) {
          if (!localObject[j].equals(paramObject[j]))
          {
            j = 0;
            break label145;
          }
        }
        j = 1;
        label145:
        if (j != 0) {
          return true;
        }
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    int i = this.zzb;
    Object localObject = this.zzc;
    int j = 0;
    int k = 17;
    int m = 0;
    int n = 17;
    while (m < i)
    {
      n = n * 31 + localObject[m];
      m++;
    }
    localObject = this.zzd;
    int i1 = this.zzb;
    m = k;
    while (j < i1)
    {
      m = m * 31 + localObject[j].hashCode();
      j++;
    }
    return ((i + 527) * 31 + n) * 31 + m;
  }
  
  final void zza(zzjn paramzzjn)
    throws IOException
  {
    if (paramzzjn.zza() == zzga.zze.zzk)
    {
      for (i = this.zzb - 1; i >= 0; i--) {
        paramzzjn.zza(this.zzc[i] >>> 3, this.zzd[i]);
      }
      return;
    }
    for (int i = 0; i < this.zzb; i++) {
      paramzzjn.zza(this.zzc[i] >>> 3, this.zzd[i]);
    }
  }
  
  final void zza(StringBuilder paramStringBuilder, int paramInt)
  {
    for (int i = 0; i < this.zzb; i++) {
      zzhp.zza(paramStringBuilder, paramInt, String.valueOf(this.zzc[i] >>> 3), this.zzd[i]);
    }
  }
  
  public final void zzb()
  {
    this.zzf = false;
  }
  
  public final void zzb(zzjn paramzzjn)
    throws IOException
  {
    if (this.zzb == 0) {
      return;
    }
    if (paramzzjn.zza() == zzga.zze.zzj)
    {
      for (i = 0; i < this.zzb; i++) {
        zza(this.zzc[i], this.zzd[i], paramzzjn);
      }
      return;
    }
    for (int i = this.zzb - 1; i >= 0; i--) {
      zza(this.zzc[i], this.zzd[i], paramzzjn);
    }
  }
  
  public final int zzc()
  {
    int i = this.zze;
    if (i != -1) {
      return i;
    }
    int j = 0;
    i = 0;
    while (j < this.zzb)
    {
      i += zzfn.zzd(this.zzc[j] >>> 3, (zzew)this.zzd[j]);
      j++;
    }
    this.zze = i;
    return i;
  }
  
  public final int zzd()
  {
    int i = this.zze;
    if (i != -1) {
      return i;
    }
    int j = 0;
    int k = 0;
    while (j < this.zzb)
    {
      int m = this.zzc[j];
      i = m >>> 3;
      m &= 0x7;
      if (m != 0)
      {
        if (m != 1)
        {
          if (m != 2)
          {
            if (m != 3)
            {
              if (m == 5) {
                i = zzfn.zzi(i, ((Integer)this.zzd[j]).intValue());
              } else {
                throw new IllegalStateException(zzgk.zza());
              }
            }
            else {
              i = (zzfn.zze(i) << 1) + ((zzis)this.zzd[j]).zzd();
            }
          }
          else {
            i = zzfn.zzc(i, (zzew)this.zzd[j]);
          }
        }
        else {
          i = zzfn.zzg(i, ((Long)this.zzd[j]).longValue());
        }
      }
      else {
        i = zzfn.zze(i, ((Long)this.zzd[j]).longValue());
      }
      k += i;
      j++;
    }
    this.zze = k;
    return k;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */