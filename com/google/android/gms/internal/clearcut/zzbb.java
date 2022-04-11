package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;

public abstract class zzbb
  implements Serializable, Iterable<Byte>
{
  public static final zzbb zzfi = new zzbi(zzci.zzkt);
  private static final zzbf zzfj;
  private int zzfk = 0;
  
  static
  {
    Object localObject;
    if (zzaw.zzx()) {
      localObject = new zzbj(null);
    } else {
      localObject = new zzbd(null);
    }
    zzfj = (zzbf)localObject;
  }
  
  static int zzb(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2 - paramInt1;
    if ((paramInt1 | paramInt2 | i | paramInt3 - paramInt2) < 0)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 < paramInt1)
        {
          localStringBuilder = new StringBuilder(66);
          localStringBuilder.append("Beginning index larger than ending index: ");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append(", ");
          localStringBuilder.append(paramInt2);
          throw new IndexOutOfBoundsException(localStringBuilder.toString());
        }
        localStringBuilder = new StringBuilder(37);
        localStringBuilder.append("End index: ");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(" >= ");
        localStringBuilder.append(paramInt3);
        throw new IndexOutOfBoundsException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder(32);
      localStringBuilder.append("Beginning index: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" < 0");
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    return i;
  }
  
  public static zzbb zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzbi(zzfj.zzc(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public static zzbb zzf(String paramString)
  {
    return new zzbi(paramString.getBytes(zzci.UTF_8));
  }
  
  static zzbg zzk(int paramInt)
  {
    return new zzbg(paramInt, null);
  }
  
  public abstract boolean equals(Object paramObject);
  
  public final int hashCode()
  {
    int i = this.zzfk;
    int j = i;
    if (i == 0)
    {
      j = size();
      i = zza(j, 0, j);
      j = i;
      if (i == 0) {
        j = 1;
      }
      this.zzfk = j;
    }
    return j;
  }
  
  public abstract int size();
  
  public final String toString()
  {
    return String.format("<ByteString@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
  }
  
  protected abstract int zza(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract zzbb zza(int paramInt1, int paramInt2);
  
  protected abstract String zza(Charset paramCharset);
  
  abstract void zza(zzba paramzzba)
    throws IOException;
  
  public abstract boolean zzaa();
  
  protected final int zzab()
  {
    return this.zzfk;
  }
  
  public abstract byte zzj(int paramInt);
  
  public final String zzz()
  {
    Charset localCharset = zzci.UTF_8;
    if (size() == 0) {
      return "";
    }
    return zza(localCharset);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzbb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */