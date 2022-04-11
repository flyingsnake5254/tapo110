package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzgy
  extends zzev<Long>
  implements zzgl<Long>, zzhx, RandomAccess
{
  private static final zzgy zza;
  private long[] zzb;
  private int zzc;
  
  static
  {
    zzgy localzzgy = new zzgy(new long[0], 0);
    zza = localzzgy;
    localzzgy.zzb();
  }
  
  zzgy()
  {
    this(new long[10], 0);
  }
  
  private zzgy(long[] paramArrayOfLong, int paramInt)
  {
    this.zzb = paramArrayOfLong;
    this.zzc = paramInt;
  }
  
  private final void zzc(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.zzc)) {
      return;
    }
    throw new IndexOutOfBoundsException(zzd(paramInt));
  }
  
  private final String zzd(int paramInt)
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
    zzc();
    zzgc.zza(paramCollection);
    if (!(paramCollection instanceof zzgy)) {
      return super.addAll(paramCollection);
    }
    zzgy localzzgy = (zzgy)paramCollection;
    int i = localzzgy.zzc;
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
      System.arraycopy(localzzgy.zzb, 0, this.zzb, this.zzc, localzzgy.zzc);
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
    if (!(paramObject instanceof zzgy)) {
      return super.equals(paramObject);
    }
    paramObject = (zzgy)paramObject;
    if (this.zzc != ((zzgy)paramObject).zzc) {
      return false;
    }
    paramObject = ((zzgy)paramObject).zzb;
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
      i = i * 31 + zzgc.zza(this.zzb[j]);
    }
    return i;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (!(paramObject instanceof Long)) {
      return -1;
    }
    long l = ((Long)paramObject).longValue();
    int i = size();
    for (int j = 0; j < i; j++) {
      if (this.zzb[j] == l) {
        return j;
      }
    }
    return -1;
  }
  
  public final boolean remove(Object paramObject)
  {
    zzc();
    for (int i = 0; i < this.zzc; i++) {
      if (paramObject.equals(Long.valueOf(this.zzb[i])))
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
  
  public final long zzb(int paramInt)
  {
    zzc(paramInt);
    return this.zzb[paramInt];
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzgy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */