package com.google.android.gms.internal.mlkit_vision_common;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzen
  extends zzde<Integer>
  implements zzes<Integer>, zzge, RandomAccess
{
  private static final zzen zza;
  private int[] zzb;
  private int zzc;
  
  static
  {
    zzen localzzen = new zzen(new int[0], 0);
    zza = localzzen;
    localzzen.b_();
  }
  
  zzen()
  {
    this(new int[10], 0);
  }
  
  private zzen(int[] paramArrayOfInt, int paramInt)
  {
    this.zzb = paramArrayOfInt;
    this.zzc = paramInt;
  }
  
  private final void zzc(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.zzc)) {
      return;
    }
    throw new IndexOutOfBoundsException(zzd(paramInt));
  }
  
  public static zzen zzd()
  {
    return zza;
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
  
  public final boolean addAll(Collection<? extends Integer> paramCollection)
  {
    zzc();
    zzem.zza(paramCollection);
    if (!(paramCollection instanceof zzen)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (zzen)paramCollection;
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
    if (!(paramObject instanceof zzen)) {
      return super.equals(paramObject);
    }
    paramObject = (zzen)paramObject;
    if (this.zzc != ((zzen)paramObject).zzc) {
      return false;
    }
    paramObject = ((zzen)paramObject).zzb;
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
  
  public final int zza(int paramInt)
  {
    zzc(paramInt);
    return this.zzb[paramInt];
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */