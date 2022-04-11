package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzit
  extends zzip<Boolean>
  implements RandomAccess, zzkk, zzlp
{
  private static final zzit zza;
  private boolean[] zzb;
  private int zzc;
  
  static
  {
    zzit localzzit = new zzit(new boolean[0], 0);
    zza = localzzit;
    localzzit.zzb();
  }
  
  zzit()
  {
    this(new boolean[10], 0);
  }
  
  private zzit(boolean[] paramArrayOfBoolean, int paramInt)
  {
    this.zzb = paramArrayOfBoolean;
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
  
  public final boolean addAll(Collection<? extends Boolean> paramCollection)
  {
    zzbM();
    zzkl.zza(paramCollection);
    if (!(paramCollection instanceof zzit)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (zzit)paramCollection;
    int i = paramCollection.zzc;
    if (i == 0) {
      return false;
    }
    int j = this.zzc;
    if (Integer.MAX_VALUE - j >= i)
    {
      j += i;
      boolean[] arrayOfBoolean = this.zzb;
      if (j > arrayOfBoolean.length) {
        this.zzb = Arrays.copyOf(arrayOfBoolean, j);
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
    if (!(paramObject instanceof zzit)) {
      return super.equals(paramObject);
    }
    paramObject = (zzit)paramObject;
    if (this.zzc != ((zzit)paramObject).zzc) {
      return false;
    }
    paramObject = ((zzit)paramObject).zzb;
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
      i = i * 31 + zzkl.zzf(this.zzb[j]);
    }
    return i;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (!(paramObject instanceof Boolean)) {
      return -1;
    }
    int i = ((Boolean)paramObject).booleanValue();
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
      boolean[] arrayOfBoolean = this.zzb;
      System.arraycopy(arrayOfBoolean, paramInt2, arrayOfBoolean, paramInt1, this.zzc - paramInt2);
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
  
  public final void zzd(boolean paramBoolean)
  {
    zzbM();
    int i = this.zzc;
    boolean[] arrayOfBoolean1 = this.zzb;
    if (i == arrayOfBoolean1.length)
    {
      arrayOfBoolean2 = new boolean[i * 3 / 2 + 1];
      System.arraycopy(arrayOfBoolean1, 0, arrayOfBoolean2, 0, i);
      this.zzb = arrayOfBoolean2;
    }
    boolean[] arrayOfBoolean2 = this.zzb;
    i = this.zzc;
    this.zzc = (i + 1);
    arrayOfBoolean2[i] = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */