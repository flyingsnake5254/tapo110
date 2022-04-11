package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzgt
  extends zzfc<Float>
  implements zzhe<Float>, zzit, RandomAccess
{
  private static final zzgt zzwf;
  private int size;
  private float[] zzwg;
  
  static
  {
    zzgt localzzgt = new zzgt(new float[0], 0);
    zzwf = localzzgt;
    localzzgt.zzdq();
  }
  
  zzgt()
  {
    this(new float[10], 0);
  }
  
  private zzgt(float[] paramArrayOfFloat, int paramInt)
  {
    this.zzwg = paramArrayOfFloat;
    this.size = paramInt;
  }
  
  private final void zzaf(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.size)) {
      return;
    }
    throw new IndexOutOfBoundsException(zzag(paramInt));
  }
  
  private final String zzag(int paramInt)
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
    zzdr();
    zzgy.checkNotNull(paramCollection);
    if (!(paramCollection instanceof zzgt)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (zzgt)paramCollection;
    int i = paramCollection.size;
    if (i == 0) {
      return false;
    }
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i)
    {
      j += i;
      float[] arrayOfFloat = this.zzwg;
      if (j > arrayOfFloat.length) {
        this.zzwg = Arrays.copyOf(arrayOfFloat, j);
      }
      System.arraycopy(paramCollection.zzwg, 0, this.zzwg, this.size, paramCollection.size);
      this.size = j;
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
    if (!(paramObject instanceof zzgt)) {
      return super.equals(paramObject);
    }
    paramObject = (zzgt)paramObject;
    if (this.size != ((zzgt)paramObject).size) {
      return false;
    }
    paramObject = ((zzgt)paramObject).zzwg;
    for (int i = 0; i < this.size; i++) {
      if (Float.floatToIntBits(this.zzwg[i]) != Float.floatToIntBits(paramObject[i])) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i = 1;
    for (int j = 0; j < this.size; j++) {
      i = i * 31 + Float.floatToIntBits(this.zzwg[j]);
    }
    return i;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (!(paramObject instanceof Float)) {
      return -1;
    }
    float f = ((Float)paramObject).floatValue();
    int i = size();
    for (int j = 0; j < i; j++) {
      if (this.zzwg[j] == f) {
        return j;
      }
    }
    return -1;
  }
  
  public final boolean remove(Object paramObject)
  {
    zzdr();
    for (int i = 0; i < this.size; i++) {
      if (paramObject.equals(Float.valueOf(this.zzwg[i])))
      {
        paramObject = this.zzwg;
        System.arraycopy(paramObject, i + 1, paramObject, i, this.size - i - 1);
        this.size -= 1;
        this.modCount += 1;
        return true;
      }
    }
    return false;
  }
  
  protected final void removeRange(int paramInt1, int paramInt2)
  {
    zzdr();
    if (paramInt2 >= paramInt1)
    {
      float[] arrayOfFloat = this.zzwg;
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
  
  public final void zzu(float paramFloat)
  {
    zzdr();
    int i = this.size;
    float[] arrayOfFloat1 = this.zzwg;
    if (i == arrayOfFloat1.length)
    {
      float[] arrayOfFloat2 = new float[i * 3 / 2 + 1];
      System.arraycopy(arrayOfFloat1, 0, arrayOfFloat2, 0, i);
      this.zzwg = arrayOfFloat2;
    }
    arrayOfFloat1 = this.zzwg;
    i = this.size;
    this.size = (i + 1);
    arrayOfFloat1[i] = paramFloat;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzgt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */