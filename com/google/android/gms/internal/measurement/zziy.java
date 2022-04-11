package com.google.android.gms.internal.measurement;

final class zziy
  extends zzjb
{
  private final int zzc;
  
  zziy(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte);
    zzjd.zzn(0, paramInt2, paramArrayOfByte.length);
    this.zzc = paramInt2;
  }
  
  public final byte zza(int paramInt)
  {
    int i = this.zzc;
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
    return this.zza[paramInt];
  }
  
  final byte zzb(int paramInt)
  {
    return this.zza[paramInt];
  }
  
  public final int zzc()
  {
    return this.zzc;
  }
  
  protected final int zzd()
  {
    return 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zziy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */