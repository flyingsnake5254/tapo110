package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzgd
  extends zzev<Integer>
  implements zzgj, zzhx, RandomAccess
{
  private static final zzgd zza;
  private int[] zzb;
  private int zzc;
  
  static
  {
    zzgd localzzgd = new zzgd(new int[0], 0);
    zza = localzzgd;
    localzzgd.zzb();
  }
  
  zzgd()
  {
    this(new int[10], 0);
  }
  
  private zzgd(int[] paramArrayOfInt, int paramInt)
  {
    this.zzb = paramArrayOfInt;
    this.zzc = paramInt;
  }
  
  public static zzgd zzd()
  {
    return zza;
  }
  
  private final void zze(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.zzc)) {
      return;
    }
    throw new IndexOutOfBoundsException(zzf(paramInt));
  }
  
  private final String zzf(int paramInt)
  {
    int i = this.zzc;
    StringBuilder localStringBuilder = new StringBuilder(35);
    localStringBuilder.append("Index:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", Size:");
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  public final boolean addAll(Collection<? extends Integer> paramCollection)
  {
    zzc();
    zzgc.zza(paramCollection);
    if (!(paramCollection instanceof zzgd)) {
      return super.addAll(paramCollection);
    }
    zzgd localzzgd = (zzgd)paramCollection;
    int i = localzzgd.zzc;
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
      System.arraycopy(localzzgd.zzb, 0, this.zzb, this.zzc, localzzgd.zzc);
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
    if (!(paramObject instanceof zzgd)) {
      return super.equals(paramObject);
    }
    paramObject = (zzgd)paramObject;
    if (this.zzc != ((zzgd)paramObject).zzc) {
      return false;
    }
    paramObject = ((zzgd)paramObject).zzb;
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
      i = i * 31 + this.zzb[j];
    }
    return i;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (!(paramObject instanceof Integer)) {
      return -1;
    }
    int i = ((Integer)paramObject).intValue();
    int j = size();
    for (int k = 0; k < j; k++) {
      if (this.zzb[k] == i) {
        return k;
      }
    }
    return -1;
  }
  
  public final boolean remove(Object paramObject)
  {
    zzc();
    for (int i = 0; i < this.zzc; i++) {
      if (paramObject.equals(Integer.valueOf(this.zzb[i])))
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
      int[] arrayOfInt = this.zzb;
      System.arraycopy(arrayOfInt, paramInt2, arrayOfInt, paramInt1, this.zzc - paramInt2);
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
  
  public final zzgj zzb(int paramInt)
  {
    if (paramInt >= this.zzc) {
      return new zzgd(Arrays.copyOf(this.zzb, paramInt), this.zzc);
    }
    throw new IllegalArgumentException();
  }
  
  public final int zzc(int paramInt)
  {
    zze(paramInt);
    return this.zzb[paramInt];
  }
  
  public final void zzd(int paramInt)
  {
    zzc();
    int i = this.zzc;
    int[] arrayOfInt1 = this.zzb;
    if (i == arrayOfInt1.length)
    {
      int[] arrayOfInt2 = new int[i * 3 / 2 + 1];
      System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, i);
      this.zzb = arrayOfInt2;
    }
    arrayOfInt1 = this.zzb;
    i = this.zzc;
    this.zzc = (i + 1);
    arrayOfInt1[i] = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzgd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */