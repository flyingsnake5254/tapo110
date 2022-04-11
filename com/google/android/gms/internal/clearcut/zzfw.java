package com.google.android.gms.internal.clearcut;

public final class zzfw
  implements Cloneable
{
  private static final zzfx zzrl = new zzfx();
  private int mSize;
  private boolean zzrm = false;
  private int[] zzrn;
  private zzfx[] zzro;
  
  zzfw()
  {
    this(10);
  }
  
  private zzfw(int paramInt)
  {
    int i = paramInt << 2;
    int j;
    for (paramInt = 4;; paramInt++)
    {
      j = i;
      if (paramInt >= 32) {
        break;
      }
      j = (1 << paramInt) - 12;
      if (i <= j) {
        break;
      }
    }
    paramInt = j / 4;
    this.zzrn = new int[paramInt];
    this.zzro = new zzfx[paramInt];
    this.mSize = 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzfw)) {
      return false;
    }
    paramObject = (zzfw)paramObject;
    int i = this.mSize;
    if (i != ((zzfw)paramObject).mSize) {
      return false;
    }
    int[] arrayOfInt = this.zzrn;
    Object localObject = ((zzfw)paramObject).zzrn;
    for (int j = 0; j < i; j++) {
      if (arrayOfInt[j] != localObject[j])
      {
        j = 0;
        break label83;
      }
    }
    j = 1;
    label83:
    if (j != 0)
    {
      localObject = this.zzro;
      paramObject = ((zzfw)paramObject).zzro;
      i = this.mSize;
      for (j = 0; j < i; j++) {
        if (!localObject[j].equals(paramObject[j]))
        {
          j = 0;
          break label143;
        }
      }
      j = 1;
      label143:
      if (j != 0) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    int i = 17;
    for (int j = 0; j < this.mSize; j++) {
      i = (i * 31 + this.zzrn[j]) * 31 + this.zzro[j].hashCode();
    }
    return i;
  }
  
  public final boolean isEmpty()
  {
    return this.mSize == 0;
  }
  
  final int size()
  {
    return this.mSize;
  }
  
  final zzfx zzaq(int paramInt)
  {
    return this.zzro[paramInt];
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzfw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */