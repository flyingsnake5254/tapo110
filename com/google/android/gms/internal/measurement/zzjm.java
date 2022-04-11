package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzjm
  extends zzip<Double>
  implements RandomAccess, zzkk, zzlp
{
  private static final zzjm zza;
  private double[] zzb;
  private int zzc;
  
  static
  {
    zzjm localzzjm = new zzjm(new double[0], 0);
    zza = localzzjm;
    localzzjm.zzb();
  }
  
  zzjm()
  {
    this(new double[10], 0);
  }
  
  private zzjm(double[] paramArrayOfDouble, int paramInt)
  {
    this.zzb = paramArrayOfDouble;
    this.zzc = paramInt;
  }
  
  private final void zzf(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.zzc)) {
      return;
    }
    throw new IndexOutOfBoundsException(zzg(paramInt));
  }
  
  private final String zzg(int paramInt)
  {
    int i = this.zzc;
    StringBuilder localStringBuilder = new StringBuilder(35);
    localStringBuilder.append("Index:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", Size:");
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  public final boolean addAll(Collection<? extends Double> paramCollection)
  {
    zzbM();
    zzkl.zza(paramCollection);
    if (!(paramCollection instanceof zzjm)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (zzjm)paramCollection;
    int i = paramCollection.zzc;
    if (i == 0) {
      return false;
    }
    int j = this.zzc;
    if (Integer.MAX_VALUE - j >= i)
    {
      i = j + i;
      double[] arrayOfDouble = this.zzb;
      if (i > arrayOfDouble.length) {
        this.zzb = Arrays.copyOf(arrayOfDouble, i);
      }
      System.arraycopy(paramCollection.zzb, 0, this.zzb, this.zzc, paramCollection.zzc);
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
    if (!(paramObject instanceof zzjm)) {
      return super.equals(paramObject);
    }
    paramObject = (zzjm)paramObject;
    if (this.zzc != ((zzjm)paramObject).zzc) {
      return false;
    }
    paramObject = ((zzjm)paramObject).zzb;
    for (int i = 0; i < this.zzc; i++) {
      if (Double.doubleToLongBits(this.zzb[i]) != Double.doubleToLongBits(paramObject[i])) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i = 1;
    for (int j = 0; j < this.zzc; j++) {
      i = i * 31 + zzkl.zze(Double.doubleToLongBits(this.zzb[j]));
    }
    return i;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (!(paramObject instanceof Double)) {
      return -1;
    }
    double d = ((Double)paramObject).doubleValue();
    int i = this.zzc;
    for (int j = 0; j < i; j++) {
      if (this.zzb[j] == d) {
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
      double[] arrayOfDouble = this.zzb;
      System.arraycopy(arrayOfDouble, paramInt2, arrayOfDouble, paramInt1, this.zzc - paramInt2);
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
  
  public final void zzd(double paramDouble)
  {
    zzbM();
    int i = this.zzc;
    double[] arrayOfDouble1 = this.zzb;
    if (i == arrayOfDouble1.length)
    {
      arrayOfDouble2 = new double[i * 3 / 2 + 1];
      System.arraycopy(arrayOfDouble1, 0, arrayOfDouble2, 0, i);
      this.zzb = arrayOfDouble2;
    }
    double[] arrayOfDouble2 = this.zzb;
    i = this.zzc;
    this.zzc = (i + 1);
    arrayOfDouble2[i] = paramDouble;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzjm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */