package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Locale;

public abstract class zzfm
  implements Serializable, Iterable<Byte>
{
  public static final zzfm zzsm = new zzfw(zzgy.zzxr);
  private static final zzfs zzsn;
  private static final Comparator<zzfm> zzso = new zzfo();
  private int zzmv = 0;
  
  static
  {
    Object localObject;
    if (zzff.zzds()) {
      localObject = new zzfz(null);
    } else {
      localObject = new zzfq(null);
    }
    zzsn = (zzfs)localObject;
  }
  
  private static int zza(byte paramByte)
  {
    return paramByte & 0xFF;
  }
  
  public static zzfm zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    zzc(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    return new zzfw(zzsn.zzd(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  static zzfu zzaq(int paramInt)
  {
    return new zzfu(paramInt, null);
  }
  
  static zzfm zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzft(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  static int zzc(int paramInt1, int paramInt2, int paramInt3)
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
  
  static zzfm zzd(byte[] paramArrayOfByte)
  {
    return new zzfw(paramArrayOfByte);
  }
  
  public static zzfm zzw(String paramString)
  {
    return new zzfw(paramString.getBytes(zzgy.UTF_8));
  }
  
  public abstract boolean equals(Object paramObject);
  
  public final int hashCode()
  {
    int i = this.zzmv;
    int j = i;
    if (i == 0)
    {
      j = size();
      i = zzb(j, 0, j);
      j = i;
      if (i == 0) {
        j = 1;
      }
      this.zzmv = j;
    }
    return j;
  }
  
  public abstract int size();
  
  public final String toString()
  {
    Locale localLocale = Locale.ROOT;
    String str1 = Integer.toHexString(System.identityHashCode(this));
    int i = size();
    String str2;
    if (size() <= 50) {
      str2 = zzjk.zzd(this);
    } else {
      str2 = String.valueOf(zzjk.zzd(zzg(0, 47))).concat("...");
    }
    return String.format(localLocale, "<ByteString@%s size=%d contents=\"%s\">", new Object[] { str1, Integer.valueOf(i), str2 });
  }
  
  protected abstract String zza(Charset paramCharset);
  
  abstract void zza(zzfn paramzzfn)
    throws IOException;
  
  protected abstract void zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract byte zzao(int paramInt);
  
  abstract byte zzap(int paramInt);
  
  protected abstract int zzb(int paramInt1, int paramInt2, int paramInt3);
  
  public final String zzes()
  {
    Charset localCharset = zzgy.UTF_8;
    if (size() == 0) {
      return "";
    }
    return zza(localCharset);
  }
  
  public abstract boolean zzet();
  
  protected final int zzeu()
  {
    return this.zzmv;
  }
  
  public abstract zzfm zzg(int paramInt1, int paramInt2);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzfm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */