package com.google.android.gms.internal.vision;

final class zzft
  extends zzfw
{
  private final int zzsq;
  private final int zzsr;
  
  zzft(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte);
    zzfm.zzc(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    this.zzsq = paramInt1;
    this.zzsr = paramInt2;
  }
  
  public final int size()
  {
    return this.zzsr;
  }
  
  protected final void zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.zzst, zzev(), paramArrayOfByte, 0, paramInt3);
  }
  
  public final byte zzao(int paramInt)
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
    return this.zzst[(this.zzsq + paramInt)];
  }
  
  final byte zzap(int paramInt)
  {
    return this.zzst[(this.zzsq + paramInt)];
  }
  
  protected final int zzev()
  {
    return this.zzsq;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */