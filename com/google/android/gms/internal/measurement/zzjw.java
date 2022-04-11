package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzjw
  extends zzip<Float>
  implements RandomAccess, zzkk, zzlp
{
  private static final zzjw zza;
  private float[] zzb;
  private int zzc;
  
  static
  {
    zzjw localzzjw = new zzjw(new float[0], 0);
    zza = localzzjw;
    localzzjw.zzb();
  }
  
  zzjw()
  {
    this(new float[10], 0);
  }
  
  private zzjw(float[] paramArrayOfFloat, int paramInt)
  {
    this.zzb = paramArrayOfFloat;
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
  
  public final boolean addAll(Collection<? extends Float> paramCollection)
  {
    zzbM();
    zzkl.zza(paramCollection);
    if (!(paramCollection instanceof zzjw)) {
      return super.addAll(paramCollection);
    }
    zzjw localzzjw = (zzjw)paramCollection;
    int i = localzzjw.zzc;
    if (i == 0) {
      return false;
    }
    int j = this.zzc;
    if (Integer.MAX_VALUE - j >= i)
    {
      j += i;
      paramCollection = this.zzb;
      if (j > paramCollection.length) {
        this.zzb = Arrays.copyOf(paramCollection, j);
      }
      System.arraycopy(localzzjw.zzb, 0, this.zzb, this.zzc, localzzjw.zzc);
      this.zzc = j;
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
    if (!(paramObject instanceof zzjw)) {
      return super.equals(paramObject);
    }
    paramObject = (zzjw)paramObject;
    if (this.zzc != ((zzjw)paramObject).zzc) {
      return false;
    }
    paramObject = ((zzjw)paramObject).zzb;
    for (int i = 0; i < this.zzc; i++) {
      if (Float.floatToIntBits(this.zzb[i]) != Float.floatToIntBits(paramObject[i])) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i = 1;
    for (int j = 0; j < this.zzc; j++) {
      i = i * 31 + Float.floatToIntBits(this.zzb[j]);
    }
    return i;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (!(paramObject instanceof Float)) {
      return -1;
    }
    float f = ((Float)paramObject).floatValue();
    int i = this.zzc;
    for (int j = 0; j < i; j++) {
      if (this.zzb[j] == f) {
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
      float[] arrayOfFloat = this.zzb;
      System.arraycopy(arrayOfFloat, paramInt2, arrayOfFloat, paramInt1, this.zzc - paramInt2);
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
  
  public final void zzd(float paramFloat)
  {
    zzbM();
    int i = this.zzc;
    float[] arrayOfFloat1 = this.zzb;
    if (i == arrayOfFloat1.length)
    {
      float[] arrayOfFloat2 = new float[i * 3 / 2 + 1];
      System.arraycopy(arrayOfFloat1, 0, arrayOfFloat2, 0, i);
      this.zzb = arrayOfFloat2;
    }
    arrayOfFloat1 = this.zzb;
    i = this.zzc;
    this.zzc = (i + 1);
    arrayOfFloat1[i] = paramFloat;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzjw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */