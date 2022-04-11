package com.google.android.gms.internal.mlkit_common;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzfa
  extends zzdu<Integer>
  implements zzfi<Integer>, zzgu, RandomAccess
{
  private static final zzfa zza;
  private int[] zzb;
  private int zzc;
  
  static
  {
    zzfa localzzfa = new zzfa(new int[0], 0);
    zza = localzzfa;
    localzzfa.zzb();
  }
  
  zzfa()
  {
    this(new int[10], 0);
  }
  
  private zzfa(int[] paramArrayOfInt, int paramInt)
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
  
  public static zzfa zzd()
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
    zzfc.zza(paramCollection);
    if (!(paramCollection instanceof zzfa)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (zzfa)paramCollection;
    int i = paramCollection.zzc;
    if (i == 0) {
      return false;
    }
    int j = this.zzc;
    if (Integer.MAX_VALUE - j >= i)
    {
      j += i;
      int[] arrayOfInt = this.zzb;
      if (j > arrayOfInt.length) {
        this.zzb = Arrays.copyOf(arrayOfInt, j);
      }
      System.arraycopy(paramCollection.zzb, 0, this.zzb, this.zzc, paramCollection.zzc);
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
    if (!(paramObject instanceof zzfa)) {
      return super.equals(paramObject);
    }
    paramObject = (zzfa)paramObject;
    if (this.zzc != ((zzfa)paramObject).zzc) {
      return false;
    }
    paramObject = ((zzfa)paramObject).zzb;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */