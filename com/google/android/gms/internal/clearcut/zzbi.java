package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.nio.charset.Charset;

class zzbi
  extends zzbh
{
  protected final byte[] zzfp;
  
  zzbi(byte[] paramArrayOfByte)
  {
    this.zzfp = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzbb)) {
      return false;
    }
    if (size() != ((zzbb)paramObject).size()) {
      return false;
    }
    if (size() == 0) {
      return true;
    }
    if ((paramObject instanceof zzbi))
    {
      paramObject = (zzbi)paramObject;
      int i = zzab();
      int j = ((zzbb)paramObject).zzab();
      if ((i != 0) && (j != 0) && (i != j)) {
        return false;
      }
      return zza((zzbb)paramObject, 0, size());
    }
    return paramObject.equals(this);
  }
  
  public int size()
  {
    return this.zzfp.length;
  }
  
  protected final int zza(int paramInt1, int paramInt2, int paramInt3)
  {
    return zzci.zza(paramInt1, this.zzfp, zzac(), paramInt3);
  }
  
  public final zzbb zza(int paramInt1, int paramInt2)
  {
    paramInt1 = zzbb.zzb(0, paramInt2, size());
    if (paramInt1 == 0) {
      return zzbb.zzfi;
    }
    return new zzbe(this.zzfp, zzac(), paramInt1);
  }
  
  protected final String zza(Charset paramCharset)
  {
    return new String(this.zzfp, zzac(), size(), paramCharset);
  }
  
  final void zza(zzba paramzzba)
    throws IOException
  {
    paramzzba.zza(this.zzfp, zzac(), size());
  }
  
  final boolean zza(zzbb paramzzbb, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= paramzzbb.size())
    {
      if (paramInt2 <= paramzzbb.size())
      {
        if ((paramzzbb instanceof zzbi))
        {
          zzbi localzzbi = (zzbi)paramzzbb;
          byte[] arrayOfByte = this.zzfp;
          paramzzbb = localzzbi.zzfp;
          int i = zzac();
          paramInt1 = zzac();
          for (int j = localzzbi.zzac(); paramInt1 < i + paramInt2; j++)
          {
            if (arrayOfByte[paramInt1] != paramzzbb[j]) {
              return false;
            }
            paramInt1++;
          }
          return true;
        }
        return paramzzbb.zza(0, paramInt2).equals(zza(0, paramInt2));
      }
      paramInt1 = paramzzbb.size();
      paramzzbb = new StringBuilder(59);
      paramzzbb.append("Ran off end of other: 0, ");
      paramzzbb.append(paramInt2);
      paramzzbb.append(", ");
      paramzzbb.append(paramInt1);
      throw new IllegalArgumentException(paramzzbb.toString());
    }
    paramInt1 = size();
    paramzzbb = new StringBuilder(40);
    paramzzbb.append("Length too large: ");
    paramzzbb.append(paramInt2);
    paramzzbb.append(paramInt1);
    throw new IllegalArgumentException(paramzzbb.toString());
  }
  
  public final boolean zzaa()
  {
    int i = zzac();
    return zzff.zze(this.zzfp, i, size() + i);
  }
  
  protected int zzac()
  {
    return 0;
  }
  
  public byte zzj(int paramInt)
  {
    return this.zzfp[paramInt];
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */