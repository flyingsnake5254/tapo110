package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

class zzjb
  extends zzja
{
  protected final byte[] zza;
  
  zzjb(byte[] paramArrayOfByte)
  {
    Objects.requireNonNull(paramArrayOfByte);
    this.zza = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzjd)) {
      return false;
    }
    if (zzc() != ((zzjd)paramObject).zzc()) {
      return false;
    }
    if (zzc() == 0) {
      return true;
    }
    if ((paramObject instanceof zzjb))
    {
      paramObject = (zzjb)paramObject;
      int i = zzm();
      int j = ((zzjd)paramObject).zzm();
      if ((i != 0) && (j != 0) && (i != j)) {
        return false;
      }
      int k = zzc();
      if (k <= ((zzjd)paramObject).zzc())
      {
        if (k <= ((zzjd)paramObject).zzc())
        {
          byte[] arrayOfByte1 = this.zza;
          byte[] arrayOfByte2 = ((zzjb)paramObject).zza;
          ((zzjb)paramObject).zzd();
          i = 0;
          boolean bool2;
          for (j = 0;; j++)
          {
            bool2 = bool1;
            if (i >= k) {
              break;
            }
            if (arrayOfByte1[i] != arrayOfByte2[j])
            {
              bool2 = false;
              break;
            }
            i++;
          }
          return bool2;
        }
        j = ((zzjd)paramObject).zzc();
        paramObject = new StringBuilder(59);
        ((StringBuilder)paramObject).append("Ran off end of other: 0, ");
        ((StringBuilder)paramObject).append(k);
        ((StringBuilder)paramObject).append(", ");
        ((StringBuilder)paramObject).append(j);
        throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
      }
      j = zzc();
      paramObject = new StringBuilder(40);
      ((StringBuilder)paramObject).append("Length too large: ");
      ((StringBuilder)paramObject).append(k);
      ((StringBuilder)paramObject).append(j);
      throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
    }
    return paramObject.equals(this);
  }
  
  public byte zza(int paramInt)
  {
    return this.zza[paramInt];
  }
  
  byte zzb(int paramInt)
  {
    return this.zza[paramInt];
  }
  
  public int zzc()
  {
    return this.zza.length;
  }
  
  protected int zzd()
  {
    return 0;
  }
  
  public final zzjd zze(int paramInt1, int paramInt2)
  {
    paramInt1 = zzjd.zzn(0, paramInt2, zzc());
    if (paramInt1 == 0) {
      return zzjd.zzb;
    }
    return new zziy(this.zza, 0, paramInt1);
  }
  
  final void zzf(zziu paramzziu)
    throws IOException
  {
    byte[] arrayOfByte = this.zza;
    int i = zzc();
    ((zzji)paramzziu).zzp(arrayOfByte, 0, i);
  }
  
  protected final String zzg(Charset paramCharset)
  {
    return new String(this.zza, 0, zzc(), paramCharset);
  }
  
  public final boolean zzh()
  {
    return zzmw.zzb(this.zza, 0, zzc());
  }
  
  protected final int zzi(int paramInt1, int paramInt2, int paramInt3)
  {
    return zzkl.zzh(paramInt1, this.zza, 0, paramInt3);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzjb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */