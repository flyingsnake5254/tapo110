package com.google.android.gms.internal.clearcut;

final class zzbe
  extends zzbi
{
  private final int zzfm;
  private final int zzfn;
  
  zzbe(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte);
    zzbb.zzb(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    this.zzfm = paramInt1;
    this.zzfn = paramInt2;
  }
  
  public final int size()
  {
    return this.zzfn;
  }
  
  protected final int zzac()
  {
    return this.zzfm;
  }
  
  public final byte zzj(int paramInt)
  {
    int i = size();
    if ((i - (paramInt + 1) | paramInt) < 0)
    {
      if (paramInt < 0)
      {
        localStringBuilder = new StringBuilder(22);
        localStringBuilder.append("Index < 0: ");
        localStringBuilder.append(paramInt);
        throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder(40);
      localStringBuilder.append("Index > length: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", ");
      localStringBuilder.append(i);
      throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
    }
    return this.zzfp[(this.zzfm + paramInt)];
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzbe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */