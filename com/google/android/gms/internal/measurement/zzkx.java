package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzkx
  extends zzip<Long>
  implements RandomAccess, zzkj, zzlp
{
  private static final zzkx zza;
  private long[] zzb;
  private int zzc;
  
  static
  {
    zzkx localzzkx = new zzkx(new long[0], 0);
    zza = localzzkx;
    localzzkx.zzb();
  }
  
  zzkx()
  {
    this(new long[10], 0);
  }
  
  private zzkx(long[] paramArrayOfLong, int paramInt)
  {
    this.zzb = paramArrayOfLong;
    this.zzc = paramInt;
  }
  
  public static zzkx zzf()
  {
    return zza;
  }
  
  private final void zzh(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.zzc)) {
      return;
    }
    throw new IndexOutOfBoundsException(zzi(paramInt));
  }
  
  private final String zzi(int paramInt)
  {
    int i = this.zzc;
    StringBuilder localStringBuilder = new StringBuilder(35);
    localStringBuilder.append("Index:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", Size:");
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  public final boolean addAll(Collection<? extends Long> paramCollection)
  {
    zzbM();
    zzkl.zza(paramCollection);
    if (!(paramCollection instanceof zzkx)) {
      return super.addAll(paramCollection);
    }
    zzkx localzzkx = (zzkx)paramCollection;
    int i = localzzkx.zzc;
    if (i == 0) {
      return false;
    }
    int j = this.zzc;
    if (Integer.MAX_VALUE - j >= i)
    {
      i = j + i;
      paramCollection = this.zzb;
      if (i > paramCollection.length) {
        this.zzb = Arrays.copyOf(paramCollection, i);
      }
      System.arraycopy(localzzkx.zzb, 0, this.zzb, this.zzc, localzzkx.zzc);
      this.zzc = i;
      this.modCount += 1;
      return true;
    }
    throw new OutOfMemoryError();
  }
  
  public final boolean contains(Object paramObject)
  {
    return indexOf(paramObject) != -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzkx)) {
      return super.equals(paramObject);
    }
    paramObject = (zzkx)paramObject;
    if (this.zzc != ((zzkx)paramObject).zzc) {
      return false;
    }
    paramObject = ((zzkx)paramObject).zzb;
    for (int i = 0; i < this.zzc; i++) {
      if (this.zzb[i] != paramObject[i]) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i = 1;
    for (int j = 0; j < this.zzc; j++) {
      i = i * 31 + zzkl.zze(this.zzb[j]);
    }
    return i;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (!(paramObject instanceof Long)) {
      return -1;
    }
    long l = ((Long)paramObject).longValue();
    int i = this.zzc;
    for (int j = 0; j < i; j++) {
      if (this.zzb[j] == l) {
        return j;
      }
    }
    return -1;
  }
  
  protected final void removeRange(int paramInt1, int paramInt2)
  {
    zzbM();
    if (paramInt2 >= paramInt1)
    {
      long[] arrayOfLong = this.zzb;
      System.arraycopy(arrayOfLong, paramInt2, arrayOfLong, paramInt1, this.zzc - paramInt2);
      this.zzc -= paramInt2 - paramInt1;
      this.modCount += 1;
      return;
    }
    throw new IndexOutOfBoundsException("toIndex < fromIndex");
  }
  
  public final int size()
  {
    return this.zzc;
  }
  
  public final long zzc(int paramInt)
  {
    zzh(paramInt);
    return this.zzb[paramInt];
  }
  
  public final zzkj zzd(int paramInt)
  {
    if (paramInt >= this.zzc) {
      return new zzkx(Arrays.copyOf(this.zzb, paramInt), this.zzc);
    }
    throw new IllegalArgumentException();
  }
  
  public final void zzg(long paramLong)
  {
    zzbM();
    int i = this.zzc;
    long[] arrayOfLong1 = this.zzb;
    if (i == arrayOfLong1.length)
    {
      long[] arrayOfLong2 = new long[i * 3 / 2 + 1];
      System.arraycopy(arrayOfLong1, 0, arrayOfLong2, 0, i);
      this.zzb = arrayOfLong2;
    }
    arrayOfLong1 = this.zzb;
    i = this.zzc;
    this.zzc = (i + 1);
    arrayOfLong1[i] = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzkx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */