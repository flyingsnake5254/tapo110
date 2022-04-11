package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Locale;

public abstract class zzjd
  implements Iterable<Byte>, Serializable
{
  public static final zzjd zzb = new zzjb(zzkl.zzc);
  private static final Comparator<zzjd> zzc = new zziw();
  private static final zzjc zzd;
  private int zza = 0;
  
  static
  {
    int i = zziq.zza;
    zzd = new zzjc(null);
  }
  
  public static zzjd zzj(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    zzn(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new zzjb(arrayOfByte);
  }
  
  public static zzjd zzk(String paramString)
  {
    return new zzjb(paramString.getBytes(zzkl.zza));
  }
  
  static int zzn(int paramInt1, int paramInt2, int paramInt3)
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
  
  public abstract boolean equals(Object paramObject);
  
  public final int hashCode()
  {
    int i = this.zza;
    int j = i;
    if (i == 0)
    {
      j = zzc();
      i = zzi(j, 0, j);
      j = i;
      if (i == 0) {
        j = 1;
      }
      this.zza = j;
    }
    return j;
  }
  
  public final String toString()
  {
    Locale localLocale = Locale.ROOT;
    String str1 = Integer.toHexString(System.identityHashCode(this));
    int i = zzc();
    String str2;
    if (zzc() <= 50) {
      str2 = zzmf.zza(this);
    } else {
      str2 = String.valueOf(zzmf.zza(zze(0, 47))).concat("...");
    }
    return String.format(localLocale, "<ByteString@%s size=%d contents=\"%s\">", new Object[] { str1, Integer.valueOf(i), str2 });
  }
  
  public abstract byte zza(int paramInt);
  
  abstract byte zzb(int paramInt);
  
  public abstract int zzc();
  
  public abstract zzjd zze(int paramInt1, int paramInt2);
  
  abstract void zzf(zziu paramzziu)
    throws IOException;
  
  protected abstract String zzg(Charset paramCharset);
  
  public abstract boolean zzh();
  
  protected abstract int zzi(int paramInt1, int paramInt2, int paramInt3);
  
  public final String zzl(Charset paramCharset)
  {
    if (zzc() == 0) {
      paramCharset = "";
    } else {
      paramCharset = zzg(paramCharset);
    }
    return paramCharset;
  }
  
  protected final int zzm()
  {
    return this.zza;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzjd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */