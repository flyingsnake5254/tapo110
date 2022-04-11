package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Arrays;

public final class zzjr
{
  private static final zzjr zzaay = new zzjr(0, new int[0], new Object[0], false);
  private int count;
  private int[] zzaaz;
  private boolean zzry;
  private int zzwt = -1;
  private Object[] zzzk;
  
  private zzjr()
  {
    this(0, new int[8], new Object[8], true);
  }
  
  private zzjr(int paramInt, int[] paramArrayOfInt, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    this.count = paramInt;
    this.zzaaz = paramArrayOfInt;
    this.zzzk = paramArrayOfObject;
    this.zzry = paramBoolean;
  }
  
  static zzjr zza(zzjr paramzzjr1, zzjr paramzzjr2)
  {
    int i = paramzzjr1.count + paramzzjr2.count;
    int[] arrayOfInt = Arrays.copyOf(paramzzjr1.zzaaz, i);
    System.arraycopy(paramzzjr2.zzaaz, 0, arrayOfInt, paramzzjr1.count, paramzzjr2.count);
    Object[] arrayOfObject = Arrays.copyOf(paramzzjr1.zzzk, i);
    System.arraycopy(paramzzjr2.zzzk, 0, arrayOfObject, paramzzjr1.count, paramzzjr2.count);
    return new zzjr(i, arrayOfInt, arrayOfObject, true);
  }
  
  private static void zzb(int paramInt, Object paramObject, zzkl paramzzkl)
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
              paramzzkl.zzk(i, ((Integer)paramObject).intValue());
              return;
            }
            throw new RuntimeException(zzhh.zzgs());
          }
          if (paramzzkl.zzfk() == zzgx.zzf.zzxl)
          {
            paramzzkl.zzbk(i);
            ((zzjr)paramObject).zzb(paramzzkl);
            paramzzkl.zzbl(i);
            return;
          }
          paramzzkl.zzbl(i);
          ((zzjr)paramObject).zzb(paramzzkl);
          paramzzkl.zzbk(i);
          return;
        }
        paramzzkl.zza(i, (zzfm)paramObject);
        return;
      }
      paramzzkl.zzc(i, ((Long)paramObject).longValue());
      return;
    }
    paramzzkl.zzi(i, ((Long)paramObject).longValue());
  }
  
  public static zzjr zzih()
  {
    return zzaay;
  }
  
  static zzjr zzii()
  {
    return new zzjr();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof zzjr)) {
      return false;
    }
    paramObject = (zzjr)paramObject;
    int i = this.count;
    if (i == ((zzjr)paramObject).count)
    {
      int[] arrayOfInt = this.zzaaz;
      Object localObject = ((zzjr)paramObject).zzaaz;
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
        localObject = this.zzzk;
        paramObject = ((zzjr)paramObject).zzzk;
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
    Object localObject = this.zzaaz;
    int j = 0;
    int k = 17;
    int m = 0;
    int n = 17;
    while (m < i)
    {
      n = n * 31 + localObject[m];
      m++;
    }
    localObject = this.zzzk;
    int i1 = this.count;
    for (m = j; m < i1; m++) {
      k = k * 31 + localObject[m].hashCode();
    }
    return ((i + 527) * 31 + n) * 31 + k;
  }
  
  final void zza(zzkl paramzzkl)
    throws IOException
  {
    if (paramzzkl.zzfk() == zzgx.zzf.zzxm)
    {
      for (i = this.count - 1; i >= 0; i--) {
        paramzzkl.zza(this.zzaaz[i] >>> 3, this.zzzk[i]);
      }
      return;
    }
    for (int i = 0; i < this.count; i++) {
      paramzzkl.zza(this.zzaaz[i] >>> 3, this.zzzk[i]);
    }
  }
  
  final void zza(StringBuilder paramStringBuilder, int paramInt)
  {
    for (int i = 0; i < this.count; i++) {
      zzii.zza(paramStringBuilder, paramInt, String.valueOf(this.zzaaz[i] >>> 3), this.zzzk[i]);
    }
  }
  
  final void zzb(int paramInt, Object paramObject)
  {
    if (this.zzry)
    {
      int i = this.count;
      int[] arrayOfInt = this.zzaaz;
      if (i == arrayOfInt.length)
      {
        if (i < 4) {
          j = 8;
        } else {
          j = i >> 1;
        }
        j = i + j;
        this.zzaaz = Arrays.copyOf(arrayOfInt, j);
        this.zzzk = Arrays.copyOf(this.zzzk, j);
      }
      arrayOfInt = this.zzaaz;
      int j = this.count;
      arrayOfInt[j] = paramInt;
      this.zzzk[j] = paramObject;
      this.count = (j + 1);
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public final void zzb(zzkl paramzzkl)
    throws IOException
  {
    if (this.count == 0) {
      return;
    }
    if (paramzzkl.zzfk() == zzgx.zzf.zzxl)
    {
      for (i = 0; i < this.count; i++) {
        zzb(this.zzaaz[i], this.zzzk[i], paramzzkl);
      }
      return;
    }
    for (int i = this.count - 1; i >= 0; i--) {
      zzb(this.zzaaz[i], this.zzzk[i], paramzzkl);
    }
  }
  
  public final void zzdq()
  {
    this.zzry = false;
  }
  
  public final int zzgg()
  {
    int i = this.zzwt;
    if (i != -1) {
      return i;
    }
    int j = 0;
    int k = 0;
    while (j < this.count)
    {
      int m = this.zzaaz[j];
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
                i = zzgf.zzo(i, ((Integer)this.zzzk[j]).intValue());
              } else {
                throw new IllegalStateException(zzhh.zzgs());
              }
            }
            else {
              i = (zzgf.zzbb(i) << 1) + ((zzjr)this.zzzk[j]).zzgg();
            }
          }
          else {
            i = zzgf.zzc(i, (zzfm)this.zzzk[j]);
          }
        }
        else {
          i = zzgf.zzg(i, ((Long)this.zzzk[j]).longValue());
        }
      }
      else {
        i = zzgf.zze(i, ((Long)this.zzzk[j]).longValue());
      }
      k += i;
      j++;
    }
    this.zzwt = k;
    return k;
  }
  
  public final int zzij()
  {
    int i = this.zzwt;
    if (i != -1) {
      return i;
    }
    int j = 0;
    i = 0;
    while (j < this.count)
    {
      i += zzgf.zzd(this.zzaaz[j] >>> 3, (zzfm)this.zzzk[j]);
      j++;
    }
    this.zzwt = i;
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzjr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */