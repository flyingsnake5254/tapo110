package com.google.android.gms.internal.mlkit_vision_common;

final class zzdm
  extends zzdt
{
  private final int zzc;
  private final int zzd;
  
  zzdm(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte);
    zzdj.zzb(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    this.zzc = paramInt1;
    this.zzd = paramInt2;
  }
  
  public final byte zza(int paramInt)
  {
    int i = zza();
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
    return this.zzb[(this.zzc + paramInt)];
  }
  
  public final int zza()
  {
    return this.zzd;
  }
  
  final byte zzb(int paramInt)
  {
    return this.zzb[(this.zzc + paramInt)];
  }
  
  protected final int zze()
  {
    return this.zzc;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzdm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */