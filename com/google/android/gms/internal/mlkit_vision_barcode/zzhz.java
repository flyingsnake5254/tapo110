package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

final class zzhz<E>
  extends zzev<E>
  implements RandomAccess
{
  private static final zzhz<Object> zza;
  private E[] zzb;
  private int zzc;
  
  static
  {
    zzhz localzzhz = new zzhz(new Object[0], 0);
    zza = localzzhz;
    localzzhz.zzb();
  }
  
  zzhz()
  {
    this(new Object[10], 0);
  }
  
  private zzhz(E[] paramArrayOfE, int paramInt)
  {
    this.zzb = paramArrayOfE;
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
  
  public static <E> zzhz<E> zzd()
  {
    return zza;
  }
  
  public final void add(int paramInt, E paramE)
  {
    zzc();
    if (paramInt >= 0)
    {
      int i = this.zzc;
      if (paramInt <= i)
      {
        Object[] arrayOfObject1 = this.zzb;
        if (i < arrayOfObject1.length)
        {
          System.arraycopy(arrayOfObject1, paramInt, arrayOfObject1, paramInt + 1, i - paramInt);
        }
        else
        {
          Object[] arrayOfObject2 = new Object[i * 3 / 2 + 1];
          System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, paramInt);
          System.arraycopy(this.zzb, paramInt, arrayOfObject2, paramInt + 1, this.zzc - paramInt);
          this.zzb = arrayOfObject2;
        }
        this.zzb[paramInt] = paramE;
        this.zzc += 1;
        this.modCount += 1;
        return;
      }
    }
    throw new IndexOutOfBoundsException(zzc(paramInt));
  }
  
  public final boolean add(E paramE)
  {
    zzc();
    int i = this.zzc;
    Object[] arrayOfObject = this.zzb;
    if (i == arrayOfObject.length) {
      this.zzb = Arrays.copyOf(arrayOfObject, i * 3 / 2 + 1);
    }
    arrayOfObject = this.zzb;
    i = this.zzc;
    this.zzc = (i + 1);
    arrayOfObject[i] = paramE;
    this.modCount += 1;
    return true;
  }
  
  public final E get(int paramInt)
  {
    zzb(paramInt);
    return (E)this.zzb[paramInt];
  }
  
  public final E remove(int paramInt)
  {
    zzc();
    zzb(paramInt);
    Object[] arrayOfObject = this.zzb;
    Object localObject = arrayOfObject[paramInt];
    int i = this.zzc;
    if (paramInt < i - 1) {
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, i - paramInt - 1);
    }
    this.zzc -= 1;
    this.modCount += 1;
    return (E)localObject;
  }
  
  public final E set(int paramInt, E paramE)
  {
    zzc();
    zzb(paramInt);
    Object[] arrayOfObject = this.zzb;
    Object localObject = arrayOfObject[paramInt];
    arrayOfObject[paramInt] = paramE;
    this.modCount += 1;
    return (E)localObject;
  }
  
  public final int size()
  {
    return this.zzc;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzhz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */