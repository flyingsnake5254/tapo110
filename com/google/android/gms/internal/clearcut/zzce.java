package com.google.android.gms.internal.clearcut;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzce
  extends zzav<Float>
  implements zzcn<Float>, RandomAccess
{
  private static final zzce zzjm;
  private int size;
  private float[] zzjn;
  
  static
  {
    zzce localzzce = new zzce();
    zzjm = localzzce;
    localzzce.zzv();
  }
  
  zzce()
  {
    this(new float[10], 0);
  }
  
  private zzce(float[] paramArrayOfFloat, int paramInt)
  {
    this.zzjn = paramArrayOfFloat;
    this.size = paramInt;
  }
  
  private final void zzc(int paramInt, float paramFloat)
  {
    zzw();
    if (paramInt >= 0)
    {
      int i = this.size;
      if (paramInt <= i)
      {
        float[] arrayOfFloat1 = this.zzjn;
        if (i < arrayOfFloat1.length)
        {
          System.arraycopy(arrayOfFloat1, paramInt, arrayOfFloat1, paramInt + 1, i - paramInt);
        }
        else
        {
          float[] arrayOfFloat2 = new float[i * 3 / 2 + 1];
          System.arraycopy(arrayOfFloat1, 0, arrayOfFloat2, 0, paramInt);
          System.arraycopy(this.zzjn, paramInt, arrayOfFloat2, paramInt + 1, this.size - paramInt);
          this.zzjn = arrayOfFloat2;
        }
        this.zzjn[paramInt] = paramFloat;
        this.size += 1;
        this.modCount += 1;
        return;
      }
    }
    throw new IndexOutOfBoundsException(zzh(paramInt));
  }
  
  private final void zzg(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.size)) {
      return;
    }
    throw new IndexOutOfBoundsException(zzh(paramInt));
  }
  
  private final String zzh(int paramInt)
  {
    int i = this.size;
    StringBuilder localStringBuilder = new StringBuilder(35);
    localStringBuilder.append("Index:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", Size:");
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  public final boolean addAll(Collection<? extends Float> paramCollection)
  {
    zzw();
    zzci.checkNotNull(paramCollection);
    if (!(paramCollection instanceof zzce)) {
      return super.addAll(paramCollection);
    }
    zzce localzzce = (zzce)paramCollection;
    int i = localzzce.size;
    if (i == 0) {
      return false;
    }
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i)
    {
      i = j + i;
      paramCollection = this.zzjn;
      if (i > paramCollection.length) {
        this.zzjn = Arrays.copyOf(paramCollection, i);
      }
      System.arraycopy(localzzce.zzjn, 0, this.zzjn, this.size, localzzce.size);
      this.size = i;
      this.modCount += 1;
      return true;
    }
    throw new OutOfMemoryError();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzce)) {
      return super.equals(paramObject);
    }
    paramObject = (zzce)paramObject;
    if (this.size != ((zzce)paramObject).size) {
      return false;
    }
    paramObject = ((zzce)paramObject).zzjn;
    for (int i = 0; i < this.size; i++) {
      if (this.zzjn[i] != paramObject[i]) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i = 1;
    for (int j = 0; j < this.size; j++) {
      i = i * 31 + Float.floatToIntBits(this.zzjn[j]);
    }
    return i;
  }
  
  public final boolean remove(Object paramObject)
  {
    zzw();
    for (int i = 0; i < this.size; i++) {
      if (paramObject.equals(Float.valueOf(this.zzjn[i])))
      {
        paramObject = this.zzjn;
        System.arraycopy(paramObject, i + 1, paramObject, i, this.size - i);
        this.size -= 1;
        this.modCount += 1;
        return true;
      }
    }
    return false;
  }
  
  protected final void removeRange(int paramInt1, int paramInt2)
  {
    zzw();
    if (paramInt2 >= paramInt1)
    {
      float[] arrayOfFloat = this.zzjn;
      System.arraycopy(arrayOfFloat, paramInt2, arrayOfFloat, paramInt1, this.size - paramInt2);
      this.size -= paramInt2 - paramInt1;
      this.modCount += 1;
      return;
    }
    throw new IndexOutOfBoundsException("toIndex < fromIndex");
  }
  
  public final int size()
  {
    return this.size;
  }
  
  public final void zzc(float paramFloat)
  {
    zzc(this.size, paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */