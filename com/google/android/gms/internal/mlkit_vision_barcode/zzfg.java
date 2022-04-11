package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

class zzfg
  extends zzfh
{
  protected final byte[] zzb;
  
  zzfg(byte[] paramArrayOfByte)
  {
    Objects.requireNonNull(paramArrayOfByte);
    this.zzb = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzew)) {
      return false;
    }
    if (zza() != ((zzew)paramObject).zza()) {
      return false;
    }
    if (zza() == 0) {
      return true;
    }
    if ((paramObject instanceof zzfg))
    {
      paramObject = (zzfg)paramObject;
      int i = zzd();
      int j = ((zzew)paramObject).zzd();
      if ((i != 0) && (j != 0) && (i != j)) {
        return false;
      }
      return zza((zzew)paramObject, 0, zza());
    }
    return paramObject.equals(this);
  }
  
  public byte zza(int paramInt)
  {
    return this.zzb[paramInt];
  }
  
  public int zza()
  {
    return this.zzb.length;
  }
  
  protected final int zza(int paramInt1, int paramInt2, int paramInt3)
  {
    return zzgc.zza(paramInt1, this.zzb, zze(), paramInt3);
  }
  
  public final zzew zza(int paramInt1, int paramInt2)
  {
    paramInt1 = zzew.zzb(0, paramInt2, zza());
    if (paramInt1 == 0) {
      return zzew.zza;
    }
    return new zzfd(this.zzb, zze(), paramInt1);
  }
  
  protected final String zza(Charset paramCharset)
  {
    return new String(this.zzb, zze(), zza(), paramCharset);
  }
  
  final void zza(zzex paramzzex)
    throws IOException
  {
    paramzzex.zza(this.zzb, zze(), zza());
  }
  
  final boolean zza(zzew paramzzew, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= paramzzew.zza())
    {
      if (paramInt2 <= paramzzew.zza())
      {
        if ((paramzzew instanceof zzfg))
        {
          zzfg localzzfg = (zzfg)paramzzew;
          paramzzew = this.zzb;
          byte[] arrayOfByte = localzzfg.zzb;
          int i = zze();
          int j = zze();
          for (paramInt1 = localzzfg.zze(); j < i + paramInt2; paramInt1++)
          {
            if (paramzzew[j] != arrayOfByte[paramInt1]) {
              return false;
            }
            j++;
          }
          return true;
        }
        return paramzzew.zza(0, paramInt2).equals(zza(0, paramInt2));
      }
      paramInt1 = paramzzew.zza();
      paramzzew = new StringBuilder(59);
      paramzzew.append("Ran off end of other: 0, ");
      paramzzew.append(paramInt2);
      paramzzew.append(", ");
      paramzzew.append(paramInt1);
      throw new IllegalArgumentException(paramzzew.toString());
    }
    paramInt1 = zza();
    paramzzew = new StringBuilder(40);
    paramzzew.append("Length too large: ");
    paramzzew.append(paramInt2);
    paramzzew.append(paramInt1);
    throw new IllegalArgumentException(paramzzew.toString());
  }
  
  byte zzb(int paramInt)
  {
    return this.zzb[paramInt];
  }
  
  public final boolean zzc()
  {
    int i = zze();
    return zzjb.zza(this.zzb, i, zza() + i);
  }
  
  protected int zze()
  {
    return 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */