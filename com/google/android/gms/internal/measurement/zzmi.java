package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

public final class zzmi
{
  private static final zzmi zza = new zzmi(0, new int[0], new Object[0], false);
  private int zzb;
  private int[] zzc;
  private Object[] zzd;
  private int zze = -1;
  private boolean zzf;
  
  private zzmi()
  {
    this(0, new int[8], new Object[8], true);
  }
  
  private zzmi(int paramInt, int[] paramArrayOfInt, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    this.zzb = paramInt;
    this.zzc = paramArrayOfInt;
    this.zzd = paramArrayOfObject;
    this.zzf = paramBoolean;
  }
  
  public static zzmi zza()
  {
    return zza;
  }
  
  static zzmi zzb()
  {
    return new zzmi(0, new int[8], new Object[8], true);
  }
  
  static zzmi zzc(zzmi paramzzmi1, zzmi paramzzmi2)
  {
    int i = paramzzmi1.zzb + paramzzmi2.zzb;
    int[] arrayOfInt = Arrays.copyOf(paramzzmi1.zzc, i);
    System.arraycopy(paramzzmi2.zzc, 0, arrayOfInt, paramzzmi1.zzb, paramzzmi2.zzb);
    Object[] arrayOfObject = Arrays.copyOf(paramzzmi1.zzd, i);
    System.arraycopy(paramzzmi2.zzd, 0, arrayOfObject, paramzzmi1.zzb, paramzzmi2.zzb);
    return new zzmi(i, arrayOfInt, arrayOfObject, true);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof zzmi)) {
      return false;
    }
    paramObject = (zzmi)paramObject;
    int i = this.zzb;
    if (i == ((zzmi)paramObject).zzb)
    {
      Object localObject = this.zzc;
      int[] arrayOfInt = ((zzmi)paramObject).zzc;
      for (int j = 0; j < i; j++) {
        if (localObject[j] != arrayOfInt[j]) {
          break label127;
        }
      }
      localObject = this.zzd;
      paramObject = ((zzmi)paramObject).zzd;
      i = this.zzb;
      for (j = 0; j < i; j++) {
        if (!localObject[j].equals(paramObject[j])) {
          break label127;
        }
      }
      return true;
    }
    label127:
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
  
  public final void zzd()
  {
    this.zzf = false;
  }
  
  public final int zze()
  {
    int i = this.zze;
    if (i == -1)
    {
      i = 0;
      int j = 0;
      while (i < this.zzb)
      {
        int k = this.zzc[i];
        zzjd localzzjd = (zzjd)this.zzd[i];
        int m = zzjk.zzw(8);
        int n = localzzjd.zzc();
        j += m + m + (zzjk.zzw(16) + zzjk.zzw(k >>> 3)) + (zzjk.zzw(24) + (zzjk.zzw(n) + n));
        i++;
      }
      this.zze = j;
      return j;
    }
    return i;
  }
  
  public final int zzf()
  {
    int i = this.zze;
    if (i == -1)
    {
      int j = 0;
      for (int k = 0; j < this.zzb; k = i)
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
                if (m == 5)
                {
                  ((Integer)this.zzd[j]).intValue();
                  i = zzjk.zzw(i << 3) + 4;
                  break label233;
                }
                throw new IllegalStateException(zzkn.zzd());
              }
              i = zzjk.zzu(i);
              m = i + i;
              i = ((zzmi)this.zzd[j]).zzf();
            }
            else
            {
              zzjd localzzjd = (zzjd)this.zzd[j];
              i = zzjk.zzw(i << 3);
              m = localzzjd.zzc();
              i = k + (i + (zzjk.zzw(m) + m));
              break label237;
            }
          }
          else
          {
            ((Long)this.zzd[j]).longValue();
            i = zzjk.zzw(i << 3) + 8;
            break label233;
          }
        }
        else
        {
          long l = ((Long)this.zzd[j]).longValue();
          m = zzjk.zzw(i << 3);
          i = zzjk.zzx(l);
        }
        i = m + i;
        label233:
        i = k + i;
        label237:
        j++;
      }
      this.zze = k;
      return k;
    }
    return i;
  }
  
  final void zzg(StringBuilder paramStringBuilder, int paramInt)
  {
    for (int i = 0; i < this.zzb; i++) {
      zzlk.zzb(paramStringBuilder, paramInt, String.valueOf(this.zzc[i] >>> 3), this.zzd[i]);
    }
  }
  
  final void zzh(int paramInt, Object paramObject)
  {
    if (this.zzf)
    {
      int i = this.zzb;
      int[] arrayOfInt = this.zzc;
      if (i == arrayOfInt.length)
      {
        if (i < 4) {
          j = 8;
        } else {
          j = i >> 1;
        }
        j = i + j;
        this.zzc = Arrays.copyOf(arrayOfInt, j);
        this.zzd = Arrays.copyOf(this.zzd, j);
      }
      arrayOfInt = this.zzc;
      int j = this.zzb;
      arrayOfInt[j] = paramInt;
      this.zzd[j] = paramObject;
      this.zzb = (j + 1);
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public final void zzi(zzjl paramzzjl)
    throws IOException
  {
    if (this.zzb != 0) {
      for (int i = 0; i < this.zzb; i++)
      {
        int j = this.zzc[i];
        Object localObject = this.zzd[i];
        int k = j >>> 3;
        j &= 0x7;
        if (j != 0)
        {
          if (j != 1)
          {
            if (j != 2)
            {
              if (j != 3)
              {
                if (j == 5) {
                  paramzzjl.zzk(k, ((Integer)localObject).intValue());
                } else {
                  throw new RuntimeException(zzkn.zzd());
                }
              }
              else
              {
                paramzzjl.zzt(k);
                ((zzmi)localObject).zzi(paramzzjl);
                paramzzjl.zzu(k);
              }
            }
            else {
              paramzzjl.zzn(k, (zzjd)localObject);
            }
          }
          else {
            paramzzjl.zzj(k, ((Long)localObject).longValue());
          }
        }
        else {
          paramzzjl.zzc(k, ((Long)localObject).longValue());
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzmi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */