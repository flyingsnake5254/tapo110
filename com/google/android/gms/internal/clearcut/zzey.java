package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Arrays;

public final class zzey
{
  private static final zzey zzoz = new zzey(0, new int[0], new Object[0], false);
  private int count;
  private boolean zzfa;
  private int zzjq = -1;
  private Object[] zzmj;
  private int[] zzpa;
  
  private zzey()
  {
    this(0, new int[8], new Object[8], true);
  }
  
  private zzey(int paramInt, int[] paramArrayOfInt, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    this.count = paramInt;
    this.zzpa = paramArrayOfInt;
    this.zzmj = paramArrayOfObject;
    this.zzfa = paramBoolean;
  }
  
  static zzey zza(zzey paramzzey1, zzey paramzzey2)
  {
    int i = paramzzey1.count + paramzzey2.count;
    int[] arrayOfInt = Arrays.copyOf(paramzzey1.zzpa, i);
    System.arraycopy(paramzzey2.zzpa, 0, arrayOfInt, paramzzey1.count, paramzzey2.count);
    Object[] arrayOfObject = Arrays.copyOf(paramzzey1.zzmj, i);
    System.arraycopy(paramzzey2.zzmj, 0, arrayOfObject, paramzzey1.count, paramzzey2.count);
    return new zzey(i, arrayOfInt, arrayOfObject, true);
  }
  
  private static void zzb(int paramInt, Object paramObject, zzfr paramzzfr)
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
              paramzzfr.zzf(i, ((Integer)paramObject).intValue());
              return;
            }
            throw new RuntimeException(zzco.zzbn());
          }
          if (paramzzfr.zzaj() == zzcg.zzg.zzko)
          {
            paramzzfr.zzaa(i);
            ((zzey)paramObject).zzb(paramzzfr);
            paramzzfr.zzab(i);
            return;
          }
          paramzzfr.zzab(i);
          ((zzey)paramObject).zzb(paramzzfr);
          paramzzfr.zzaa(i);
          return;
        }
        paramzzfr.zza(i, (zzbb)paramObject);
        return;
      }
      paramzzfr.zzc(i, ((Long)paramObject).longValue());
      return;
    }
    paramzzfr.zzi(i, ((Long)paramObject).longValue());
  }
  
  public static zzey zzea()
  {
    return zzoz;
  }
  
  static zzey zzeb()
  {
    return new zzey();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof zzey)) {
      return false;
    }
    paramObject = (zzey)paramObject;
    int i = this.count;
    if (i == ((zzey)paramObject).count)
    {
      int[] arrayOfInt = this.zzpa;
      Object localObject = ((zzey)paramObject).zzpa;
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
        localObject = this.zzmj;
        paramObject = ((zzey)paramObject).zzmj;
        i = this.count;
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
    int i = this.count;
    Object localObject = this.zzpa;
    int j = 0;
    int k = 17;
    int m = 0;
    int n = 17;
    while (m < i)
    {
      n = n * 31 + localObject[m];
      m++;
    }
    localObject = this.zzmj;
    int i1 = this.count;
    for (m = j; m < i1; m++) {
      k = k * 31 + localObject[m].hashCode();
    }
    return ((i + 527) * 31 + n) * 31 + k;
  }
  
  final void zza(zzfr paramzzfr)
    throws IOException
  {
    if (paramzzfr.zzaj() == zzcg.zzg.zzkp)
    {
      for (i = this.count - 1; i >= 0; i--) {
        paramzzfr.zza(this.zzpa[i] >>> 3, this.zzmj[i]);
      }
      return;
    }
    for (int i = 0; i < this.count; i++) {
      paramzzfr.zza(this.zzpa[i] >>> 3, this.zzmj[i]);
    }
  }
  
  final void zza(StringBuilder paramStringBuilder, int paramInt)
  {
    for (int i = 0; i < this.count; i++) {
      zzdr.zza(paramStringBuilder, paramInt, String.valueOf(this.zzpa[i] >>> 3), this.zzmj[i]);
    }
  }
  
  public final int zzas()
  {
    int i = this.zzjq;
    if (i != -1) {
      return i;
    }
    int j = 0;
    int k = 0;
    while (j < this.count)
    {
      int m = this.zzpa[j];
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
                i = zzbn.zzj(i, ((Integer)this.zzmj[j]).intValue());
              } else {
                throw new IllegalStateException(zzco.zzbn());
              }
            }
            else {
              i = (zzbn.zzr(i) << 1) + ((zzey)this.zzmj[j]).zzas();
            }
          }
          else {
            i = zzbn.zzc(i, (zzbb)this.zzmj[j]);
          }
        }
        else {
          i = zzbn.zzg(i, ((Long)this.zzmj[j]).longValue());
        }
      }
      else {
        i = zzbn.zze(i, ((Long)this.zzmj[j]).longValue());
      }
      k += i;
      j++;
    }
    this.zzjq = k;
    return k;
  }
  
  final void zzb(int paramInt, Object paramObject)
  {
    if (this.zzfa)
    {
      int i = this.count;
      int[] arrayOfInt = this.zzpa;
      if (i == arrayOfInt.length)
      {
        if (i < 4) {
          j = 8;
        } else {
          j = i >> 1;
        }
        j = i + j;
        this.zzpa = Arrays.copyOf(arrayOfInt, j);
        this.zzmj = Arrays.copyOf(this.zzmj, j);
      }
      arrayOfInt = this.zzpa;
      int j = this.count;
      arrayOfInt[j] = paramInt;
      this.zzmj[j] = paramObject;
      this.count = (j + 1);
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public final void zzb(zzfr paramzzfr)
    throws IOException
  {
    if (this.count == 0) {
      return;
    }
    if (paramzzfr.zzaj() == zzcg.zzg.zzko)
    {
      for (i = 0; i < this.count; i++) {
        zzb(this.zzpa[i], this.zzmj[i], paramzzfr);
      }
      return;
    }
    for (int i = this.count - 1; i >= 0; i--) {
      zzb(this.zzpa[i], this.zzmj[i], paramzzfr);
    }
  }
  
  public final int zzec()
  {
    int i = this.zzjq;
    if (i != -1) {
      return i;
    }
    int j = 0;
    i = 0;
    while (j < this.count)
    {
      i += zzbn.zzd(this.zzpa[j] >>> 3, (zzbb)this.zzmj[j]);
      j++;
    }
    this.zzjq = i;
    return i;
  }
  
  public final void zzv()
  {
    this.zzfa = false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */