package com.google.android.gms.internal.mlkit_common;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

class zzef
  extends zzeg
{
  protected final byte[] zzb;
  
  zzef(byte[] paramArrayOfByte)
  {
    Objects.requireNonNull(paramArrayOfByte);
    this.zzb = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzdv)) {
      return false;
    }
    if (zza() != ((zzdv)paramObject).zza()) {
      return false;
    }
    if (zza() == 0) {
      return true;
    }
    if ((paramObject instanceof zzef))
    {
      paramObject = (zzef)paramObject;
      int i = zzd();
      int j = ((zzdv)paramObject).zzd();
      if ((i != 0) && (j != 0) && (i != j)) {
        return false;
      }
      return zza((zzdv)paramObject, 0, zza());
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
    return zzfc.zza(paramInt1, this.zzb, zze(), paramInt3);
  }
  
  public final zzdv zza(int paramInt1, int paramInt2)
  {
    paramInt1 = zzdv.zzb(0, paramInt2, zza());
    if (paramInt1 == 0) {
      return zzdv.zza;
    }
    return new zzec(this.zzb, zze(), paramInt1);
  }
  
  protected final String zza(Charset paramCharset)
  {
    return new String(this.zzb, zze(), zza(), paramCharset);
  }
  
  final void zza(zzdw paramzzdw)
    throws IOException
  {
    paramzzdw.zza(this.zzb, zze(), zza());
  }
  
  final boolean zza(zzdv paramzzdv, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= paramzzdv.zza())
    {
      if (paramInt2 <= paramzzdv.zza())
      {
        if ((paramzzdv instanceof zzef))
        {
          zzef localzzef = (zzef)paramzzdv;
          byte[] arrayOfByte = this.zzb;
          paramzzdv = localzzef.zzb;
          int i = zze();
          paramInt1 = zze();
          for (int j = localzzef.zze(); paramInt1 < i + paramInt2; j++)
          {
            if (arrayOfByte[paramInt1] != paramzzdv[j]) {
              return false;
            }
            paramInt1++;
          }
          return true;
        }
        return paramzzdv.zza(0, paramInt2).equals(zza(0, paramInt2));
      }
      paramInt1 = paramzzdv.zza();
      paramzzdv = new StringBuilder(59);
      paramzzdv.append("Ran off end of other: 0, ");
      paramzzdv.append(paramInt2);
      paramzzdv.append(", ");
      paramzzdv.append(paramInt1);
      throw new IllegalArgumentException(paramzzdv.toString());
    }
    paramInt1 = zza();
    paramzzdv = new StringBuilder(40);
    paramzzdv.append("Length too large: ");
    paramzzdv.append(paramInt2);
    paramzzdv.append(paramInt1);
    throw new IllegalArgumentException(paramzzdv.toString());
  }
  
  byte zzb(int paramInt)
  {
    return this.zzb[paramInt];
  }
  
  public final boolean zzc()
  {
    int i = zze();
    return zzhy.zza(this.zzb, i, zza() + i);
  }
  
  protected int zze()
  {
    return 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */