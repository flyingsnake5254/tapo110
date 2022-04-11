package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

class zzfw
  extends zzfx
{
  protected final byte[] zzst;
  
  zzfw(byte[] paramArrayOfByte)
  {
    Objects.requireNonNull(paramArrayOfByte);
    this.zzst = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzfm)) {
      return false;
    }
    if (size() != ((zzfm)paramObject).size()) {
      return false;
    }
    if (size() == 0) {
      return true;
    }
    if ((paramObject instanceof zzfw))
    {
      paramObject = (zzfw)paramObject;
      int i = zzeu();
      int j = ((zzfm)paramObject).zzeu();
      if ((i != 0) && (j != 0) && (i != j)) {
        return false;
      }
      return zza((zzfm)paramObject, 0, size());
    }
    return paramObject.equals(this);
  }
  
  public int size()
  {
    return this.zzst.length;
  }
  
  protected final String zza(Charset paramCharset)
  {
    return new String(this.zzst, zzev(), size(), paramCharset);
  }
  
  final void zza(zzfn paramzzfn)
    throws IOException
  {
    paramzzfn.zzc(this.zzst, zzev(), size());
  }
  
  protected void zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.zzst, 0, paramArrayOfByte, 0, paramInt3);
  }
  
  final boolean zza(zzfm paramzzfm, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= paramzzfm.size())
    {
      if (paramInt2 <= paramzzfm.size())
      {
        if ((paramzzfm instanceof zzfw))
        {
          zzfw localzzfw = (zzfw)paramzzfm;
          paramzzfm = this.zzst;
          byte[] arrayOfByte = localzzfw.zzst;
          int i = zzev();
          paramInt1 = zzev();
          for (int j = localzzfw.zzev(); paramInt1 < i + paramInt2; j++)
          {
            if (paramzzfm[paramInt1] != arrayOfByte[j]) {
              return false;
            }
            paramInt1++;
          }
          return true;
        }
        return paramzzfm.zzg(0, paramInt2).equals(zzg(0, paramInt2));
      }
      paramInt1 = paramzzfm.size();
      paramzzfm = new StringBuilder(59);
      paramzzfm.append("Ran off end of other: 0, ");
      paramzzfm.append(paramInt2);
      paramzzfm.append(", ");
      paramzzfm.append(paramInt1);
      throw new IllegalArgumentException(paramzzfm.toString());
    }
    paramInt1 = size();
    paramzzfm = new StringBuilder(40);
    paramzzfm.append("Length too large: ");
    paramzzfm.append(paramInt2);
    paramzzfm.append(paramInt1);
    throw new IllegalArgumentException(paramzzfm.toString());
  }
  
  public byte zzao(int paramInt)
  {
    return this.zzst[paramInt];
  }
  
  byte zzap(int paramInt)
  {
    return this.zzst[paramInt];
  }
  
  protected final int zzb(int paramInt1, int paramInt2, int paramInt3)
  {
    return zzgy.zza(paramInt1, this.zzst, zzev(), paramInt3);
  }
  
  public final boolean zzet()
  {
    int i = zzev();
    return zzjx.zzf(this.zzst, i, size() + i);
  }
  
  protected int zzev()
  {
    return 0;
  }
  
  public final zzfm zzg(int paramInt1, int paramInt2)
  {
    paramInt1 = zzfm.zzc(0, paramInt2, size());
    if (paramInt1 == 0) {
      return zzfm.zzsm;
    }
    return new zzft(this.zzst, zzev(), paramInt1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzfw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */