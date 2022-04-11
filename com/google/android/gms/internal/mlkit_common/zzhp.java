package com.google.android.gms.internal.mlkit_common;

import java.io.IOException;
import java.util.Arrays;

public final class zzhp
{
  private static final zzhp zza = new zzhp(0, new int[0], new Object[0], false);
  private int zzb;
  private int[] zzc;
  private Object[] zzd;
  private int zze = -1;
  private boolean zzf;
  
  private zzhp()
  {
    this(0, new int[8], new Object[8], true);
  }
  
  private zzhp(int paramInt, int[] paramArrayOfInt, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    this.zzb = paramInt;
    this.zzc = paramArrayOfInt;
    this.zzd = paramArrayOfObject;
    this.zzf = paramBoolean;
  }
  
  public static zzhp zza()
  {
    return zza;
  }
  
  static zzhp zza(zzhp paramzzhp1, zzhp paramzzhp2)
  {
    int i = paramzzhp1.zzb + paramzzhp2.zzb;
    int[] arrayOfInt = Arrays.copyOf(paramzzhp1.zzc, i);
    System.arraycopy(paramzzhp2.zzc, 0, arrayOfInt, paramzzhp1.zzb, paramzzhp2.zzb);
    Object[] arrayOfObject = Arrays.copyOf(paramzzhp1.zzd, i);
    System.arraycopy(paramzzhp2.zzd, 0, arrayOfObject, paramzzhp1.zzb, paramzzhp2.zzb);
    return new zzhp(i, arrayOfInt, arrayOfObject, true);
  }
  
  private static void zza(int paramInt, Object paramObject, zzik paramzzik)
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
              paramzzik.zzd(i, ((Integer)paramObject).intValue());
              return;
            }
            throw new RuntimeException(zzfh.zza());
          }
          if (paramzzik.zza() == zzez.zzf.zzj)
          {
            paramzzik.zza(i);
            ((zzhp)paramObject).zzb(paramzzik);
            paramzzik.zzb(i);
            return;
          }
          paramzzik.zzb(i);
          ((zzhp)paramObject).zzb(paramzzik);
          paramzzik.zza(i);
          return;
        }
        paramzzik.zza(i, (zzdv)paramObject);
        return;
      }
      paramzzik.zzd(i, ((Long)paramObject).longValue());
      return;
    }
    paramzzik.zza(i, ((Long)paramObject).longValue());
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof zzhp)) {
      return false;
    }
    paramObject = (zzhp)paramObject;
    int i = this.zzb;
    if (i == ((zzhp)paramObject).zzb)
    {
      int[] arrayOfInt = this.zzc;
      Object localObject = ((zzhp)paramObject).zzc;
      for (int j = 0; j < i; j++) {
        if (arrayOfInt[j] != localObject[j])
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
        paramObject = ((zzhp)paramObject).zzd;
        i = this.zzb;
        for (j = 0; j < i; j++) {
          if (!localObject[j].equals(paramObject[j]))
          {
            j = 0;
            break label147;
          }
        }
        j = 1;
        label147:
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
    for (m = j; m < i1; m++) {
      k = k * 31 + localObject[m].hashCode();
    }
    return ((i + 527) * 31 + n) * 31 + k;
  }
  
  final void zza(zzik paramzzik)
    throws IOException
  {
    if (paramzzik.zza() == zzez.zzf.zzk)
    {
      for (i = this.zzb - 1; i >= 0; i--) {
        paramzzik.zza(this.zzc[i] >>> 3, this.zzd[i]);
      }
      return;
    }
    for (int i = 0; i < this.zzb; i++) {
      paramzzik.zza(this.zzc[i] >>> 3, this.zzd[i]);
    }
  }
  
  final void zza(StringBuilder paramStringBuilder, int paramInt)
  {
    for (int i = 0; i < this.zzb; i++) {
      zzgm.zza(paramStringBuilder, paramInt, String.valueOf(this.zzc[i] >>> 3), this.zzd[i]);
    }
  }
  
  public final void zzb()
  {
    this.zzf = false;
  }
  
  public final void zzb(zzik paramzzik)
    throws IOException
  {
    if (this.zzb == 0) {
      return;
    }
    if (paramzzik.zza() == zzez.zzf.zzj)
    {
      for (i = 0; i < this.zzb; i++) {
        zza(this.zzc[i], this.zzd[i], paramzzik);
      }
      return;
    }
    for (int i = this.zzb - 1; i >= 0; i--) {
      zza(this.zzc[i], this.zzd[i], paramzzik);
    }
  }
  
  public final int zzc()
  {
    int i = this.zze;
    if (i != -1) {
      return i;
    }
    i = 0;
    int j = 0;
    while (i < this.zzb)
    {
      j += zzem.zzd(this.zzc[i] >>> 3, (zzdv)this.zzd[i]);
      i++;
    }
    this.zze = j;
    return j;
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
                i = zzem.zzi(i, ((Integer)this.zzd[j]).intValue());
              } else {
                throw new IllegalStateException(zzfh.zza());
              }
            }
            else {
              i = (zzem.zze(i) << 1) + ((zzhp)this.zzd[j]).zzd();
            }
          }
          else {
            i = zzem.zzc(i, (zzdv)this.zzd[j]);
          }
        }
        else {
          i = zzem.zzg(i, ((Long)this.zzd[j]).longValue());
        }
      }
      else {
        i = zzem.zze(i, ((Long)this.zzd[j]).longValue());
      }
      k += i;
      j++;
    }
    this.zze = k;
    return k;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzhp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */