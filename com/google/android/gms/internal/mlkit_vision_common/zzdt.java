package com.google.android.gms.internal.mlkit_vision_common;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

class zzdt
  extends zzdq
{
  protected final byte[] zzb;
  
  zzdt(byte[] paramArrayOfByte)
  {
    Objects.requireNonNull(paramArrayOfByte);
    this.zzb = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzdj)) {
      return false;
    }
    if (zza() != ((zzdj)paramObject).zza()) {
      return false;
    }
    if (zza() == 0) {
      return true;
    }
    if ((paramObject instanceof zzdt))
    {
      paramObject = (zzdt)paramObject;
      int i = zzd();
      int j = ((zzdj)paramObject).zzd();
      if ((i != 0) && (j != 0) && (i != j)) {
        return false;
      }
      return zza((zzdj)paramObject, 0, zza());
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
    return zzem.zza(paramInt1, this.zzb, zze(), paramInt3);
  }
  
  public final zzdj zza(int paramInt1, int paramInt2)
  {
    paramInt1 = zzdj.zzb(0, paramInt2, zza());
    if (paramInt1 == 0) {
      return zzdj.zza;
    }
    return new zzdm(this.zzb, zze(), paramInt1);
  }
  
  protected final String zza(Charset paramCharset)
  {
    return new String(this.zzb, zze(), zza(), paramCharset);
  }
  
  final void zza(zzdg paramzzdg)
    throws IOException
  {
    paramzzdg.zza(this.zzb, zze(), zza());
  }
  
  final boolean zza(zzdj paramzzdj, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= paramzzdj.zza())
    {
      if (paramInt2 <= paramzzdj.zza())
      {
        if ((paramzzdj instanceof zzdt))
        {
          paramzzdj = (zzdt)paramzzdj;
          byte[] arrayOfByte1 = this.zzb;
          byte[] arrayOfByte2 = paramzzdj.zzb;
          int i = zze();
          paramInt1 = zze();
          for (int j = paramzzdj.zze(); paramInt1 < i + paramInt2; j++)
          {
            if (arrayOfByte1[paramInt1] != arrayOfByte2[j]) {
              return false;
            }
            paramInt1++;
          }
          return true;
        }
        return paramzzdj.zza(0, paramInt2).equals(zza(0, paramInt2));
      }
      paramInt1 = paramzzdj.zza();
      paramzzdj = new StringBuilder(59);
      paramzzdj.append("Ran off end of other: 0, ");
      paramzzdj.append(paramInt2);
      paramzzdj.append(", ");
      paramzzdj.append(paramInt1);
      throw new IllegalArgumentException(paramzzdj.toString());
    }
    paramInt1 = zza();
    paramzzdj = new StringBuilder(40);
    paramzzdj.append("Length too large: ");
    paramzzdj.append(paramInt2);
    paramzzdj.append(paramInt1);
    throw new IllegalArgumentException(paramzzdj.toString());
  }
  
  byte zzb(int paramInt)
  {
    return this.zzb[paramInt];
  }
  
  public final boolean zzc()
  {
    int i = zze();
    return zzhj.zza(this.zzb, i, zza() + i);
  }
  
  protected int zze()
  {
    return 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzdt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */