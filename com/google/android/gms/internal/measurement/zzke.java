package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzke
  extends zzip<Integer>
  implements RandomAccess, zzki, zzlp
{
  private static final zzke zza;
  private int[] zzb;
  private int zzc;
  
  static
  {
    zzke localzzke = new zzke(new int[0], 0);
    zza = localzzke;
    localzzke.zzb();
  }
  
  zzke()
  {
    this(new int[10], 0);
  }
  
  private zzke(int[] paramArrayOfInt, int paramInt)
  {
    this.zzb = paramArrayOfInt;
    this.zzc = paramInt;
  }
  
  public static zzke zzd()
  {
    return zza;
  }
  
  private final void zzi(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.zzc)) {
      return;
    }
    throw new IndexOutOfBoundsException(zzj(paramInt));
  }
  
  private final String zzj(int paramInt)
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
    zzbM();
    zzkl.zza(paramCollection);
    if (!(paramCollection instanceof zzke)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (zzke)paramCollection;
    int i = paramCollection.zzc;
    if (i == 0) {
      return false;
    }
    int j = this.zzc;
    if (Integer.MAX_VALUE - j >= i)
    {
      i = j + i;
      int[] arrayOfInt = this.zzb;
      if (i > arrayOfInt.length) {
        this.zzb = Arrays.copyOf(arrayOfInt, i);
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
    if (!(paramObject instanceof zzke)) {
      return super.equals(paramObject);
    }
    paramObject = (zzke)paramObject;
    if (this.zzc != ((zzke)paramObject).zzc) {
      return false;
    }
    paramObject = ((zzke)paramObject).zzb;
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
    int j = this.zzc;
    for (int k = 0; k < j; k++) {
      if (this.zzb[k] == i) {
        return k;
      }
    }
    return -1;
  }
  
  protected final void removeRange(int paramInt1, int paramInt2)
  {
    zzbM();
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
  
  public final zzki zzf(int paramInt)
  {
    if (paramInt >= this.zzc) {
      return new zzke(Arrays.copyOf(this.zzb, paramInt), this.zzc);
    }
    throw new IllegalArgumentException();
  }
  
  public final int zzg(int paramInt)
  {
    zzi(paramInt);
    return this.zzb[paramInt];
  }
  
  public final void zzh(int paramInt)
  {
    zzbM();
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */