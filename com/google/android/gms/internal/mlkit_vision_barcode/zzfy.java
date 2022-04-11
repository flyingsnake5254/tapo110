package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzfy
  extends zzev<Float>
  implements zzgl<Float>, zzhx, RandomAccess
{
  private static final zzfy zza;
  private float[] zzb;
  private int zzc;
  
  static
  {
    zzfy localzzfy = new zzfy(new float[0], 0);
    zza = localzzfy;
    localzzfy.zzb();
  }
  
  zzfy()
  {
    this(new float[10], 0);
  }
  
  private zzfy(float[] paramArrayOfFloat, int paramInt)
  {
    this.zzb = paramArrayOfFloat;
    this.zzc = paramInt;
  }
  
  private final void zzb(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.zzc)) {
      return;
    }
    throw new IndexOutOfBoundsException(zzc(paramInt));
  }
  
  private final String zzc(int paramInt)
  {
    int i = this.zzc;
    StringBuilder localStringBuilder = new StringBuilder(35);
    localStringBuilder.append("Index:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", Size:");
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  public static zzfy zzd()
  {
    return zza;
  }
  
  public final boolean addAll(Collection<? extends Float> paramCollection)
  {
    zzc();
    zzgc.zza(paramCollection);
    if (!(paramCollection instanceof zzfy)) {
      return super.addAll(paramCollection);
    }
    zzfy localzzfy = (zzfy)paramCollection;
    int i = localzzfy.zzc;
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
      System.arraycopy(localzzfy.zzb, 0, this.zzb, this.zzc, localzzfy.zzc);
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
    if (!(paramObject instanceof zzfy)) {
      return super.equals(paramObject);
    }
    paramObject = (zzfy)paramObject;
    if (this.zzc != ((zzfy)paramObject).zzc) {
      return false;
    }
    paramObject = ((zzfy)paramObject).zzb;
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
    int i = size();
    for (int j = 0; j < i; j++) {
      if (this.zzb[j] == f) {
        return j;
      }
    }
    return -1;
  }
  
  public final boolean remove(Object paramObject)
  {
    zzc();
    for (int i = 0; i < this.zzc; i++) {
      if (paramObject.equals(Float.valueOf(this.zzb[i])))
      {
        paramObject = this.zzb;
        System.arraycopy(paramObject, i + 1, paramObject, i, this.zzc - i - 1);
        this.zzc -= 1;
        this.modCount += 1;
        return true;
      }
    }
    return false;
  }
  
  protected final void removeRange(int paramInt1, int paramInt2)
  {
    zzc();
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzfy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */