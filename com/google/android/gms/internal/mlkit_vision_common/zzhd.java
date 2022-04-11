package com.google.android.gms.internal.mlkit_vision_common;

import java.io.IOException;
import java.util.Arrays;

public final class zzhd
{
  private static final zzhd zza = new zzhd(0, new int[0], new Object[0], false);
  private int zzb;
  private int[] zzc;
  private Object[] zzd;
  private int zze = -1;
  private boolean zzf;
  
  private zzhd()
  {
    this(0, new int[8], new Object[8], true);
  }
  
  private zzhd(int paramInt, int[] paramArrayOfInt, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    this.zzb = paramInt;
    this.zzc = paramArrayOfInt;
    this.zzd = paramArrayOfObject;
    this.zzf = paramBoolean;
  }
  
  public static zzhd zza()
  {
    return zza;
  }
  
  static zzhd zza(zzhd paramzzhd1, zzhd paramzzhd2)
  {
    int i = paramzzhd1.zzb + paramzzhd2.zzb;
    int[] arrayOfInt = Arrays.copyOf(paramzzhd1.zzc, i);
    System.arraycopy(paramzzhd2.zzc, 0, arrayOfInt, paramzzhd1.zzb, paramzzhd2.zzb);
    Object[] arrayOfObject = Arrays.copyOf(paramzzhd1.zzd, i);
    System.arraycopy(paramzzhd2.zzd, 0, arrayOfObject, paramzzhd1.zzb, paramzzhd2.zzb);
    return new zzhd(i, arrayOfInt, arrayOfObject, true);
  }
  
  private static void zza(int paramInt, Object paramObject, zzhu paramzzhu)
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
              paramzzhu.zzd(i, ((Integer)paramObject).intValue());
              return;
            }
            throw new RuntimeException(zzev.zza());
          }
          if (paramzzhu.zza() == zzek.zze.zzj)
          {
            paramzzhu.zza(i);
            ((zzhd)paramObject).zzb(paramzzhu);
            paramzzhu.zzb(i);
            return;
          }
          paramzzhu.zzb(i);
          ((zzhd)paramObject).zzb(paramzzhu);
          paramzzhu.zza(i);
          return;
        }
        paramzzhu.zza(i, (zzdj)paramObject);
        return;
      }
      paramzzhu.zzd(i, ((Long)paramObject).longValue());
      return;
    }
    paramzzhu.zza(i, ((Long)paramObject).longValue());
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof zzhd)) {
      return false;
    }
    paramObject = (zzhd)paramObject;
    int i = this.zzb;
    if (i == ((zzhd)paramObject).zzb)
    {
      Object localObject = this.zzc;
      int[] arrayOfInt = ((zzhd)paramObject).zzc;
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
        paramObject = ((zzhd)paramObject).zzd;
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
    for (m = j; m < i1; m++) {
      k = k * 31 + localObject[m].hashCode();
    }
    return ((i + 527) * 31 + n) * 31 + k;
  }
  
  final void zza(zzhu paramzzhu)
    throws IOException
  {
    if (paramzzhu.zza() == zzek.zze.zzk)
    {
      for (i = this.zzb - 1; i >= 0; i--) {
        paramzzhu.zza(this.zzc[i] >>> 3, this.zzd[i]);
      }
      return;
    }
    for (int i = 0; i < this.zzb; i++) {
      paramzzhu.zza(this.zzc[i] >>> 3, this.zzd[i]);
    }
  }
  
  final void zza(StringBuilder paramStringBuilder, int paramInt)
  {
    for (int i = 0; i < this.zzb; i++) {
      zzfw.zza(paramStringBuilder, paramInt, String.valueOf(this.zzc[i] >>> 3), this.zzd[i]);
    }
  }
  
  public final void zzb()
  {
    this.zzf = false;
  }
  
  public final void zzb(zzhu paramzzhu)
    throws IOException
  {
    if (this.zzb == 0) {
      return;
    }
    if (paramzzhu.zza() == zzek.zze.zzj)
    {
      for (i = 0; i < this.zzb; i++) {
        zza(this.zzc[i], this.zzd[i], paramzzhu);
      }
      return;
    }
    for (int i = this.zzb - 1; i >= 0; i--) {
      zza(this.zzc[i], this.zzd[i], paramzzhu);
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
      j += zzdw.zzd(this.zzc[i] >>> 3, (zzdj)this.zzd[i]);
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
                i = zzdw.zzi(i, ((Integer)this.zzd[j]).intValue());
              } else {
                throw new IllegalStateException(zzev.zza());
              }
            }
            else {
              i = (zzdw.zze(i) << 1) + ((zzhd)this.zzd[j]).zzd();
            }
          }
          else {
            i = zzdw.zzc(i, (zzdj)this.zzd[j]);
          }
        }
        else {
          i = zzdw.zzg(i, ((Long)this.zzd[j]).longValue());
        }
      }
      else {
        i = zzdw.zze(i, ((Long)this.zzd[j]).longValue());
      }
      k += i;
      j++;
    }
    this.zze = k;
    return k;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzhd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */