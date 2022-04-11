package com.google.android.gms.internal.mlkit_common;

final class zzej
  extends zzeh
{
  private final byte[] zza;
  private final boolean zzb;
  private int zzc;
  private int zzd;
  private int zze;
  private int zzf;
  private int zzg = Integer.MAX_VALUE;
  
  private zzej(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(null);
    this.zza = paramArrayOfByte;
    this.zzc = (paramInt2 + paramInt1);
    this.zze = paramInt1;
    this.zzf = paramInt1;
    this.zzb = paramBoolean;
  }
  
  public final int zza()
  {
    return this.zze - this.zzf;
  }
  
  public final int zza(int paramInt)
    throws zzfh
  {
    if (paramInt >= 0)
    {
      int i = paramInt + zza();
      paramInt = this.zzg;
      if (i <= paramInt)
      {
        this.zzg = i;
        int j = this.zzc + this.zzd;
        this.zzc = j;
        int k = j - this.zzf;
        if (k > i)
        {
          k -= i;
          this.zzd = k;
          this.zzc = (j - k);
        }
        else
        {
          this.zzd = 0;
        }
        return paramInt;
      }
      throw new zzfh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
    throw new zzfh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */