package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Locale;

public abstract class zzew
  implements Serializable, Iterable<Byte>
{
  public static final zzew zza = new zzfg(zzgc.zzb);
  private static final zzfc zzb;
  private static final Comparator<zzew> zzd = new zzey();
  private int zzc = 0;
  
  static
  {
    Object localObject;
    if (zzeu.zza()) {
      localObject = new zzfj(null);
    } else {
      localObject = new zzfa(null);
    }
    zzb = (zzfc)localObject;
  }
  
  public static zzew zza(String paramString)
  {
    return new zzfg(paramString.getBytes(zzgc.zza));
  }
  
  private static int zzb(byte paramByte)
  {
    return paramByte & 0xFF;
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
  
  static zzfe zzc(int paramInt)
  {
    return new zzfe(paramInt, null);
  }
  
  public abstract boolean equals(Object paramObject);
  
  public final int hashCode()
  {
    int i = this.zzc;
    int j = i;
    if (i == 0)
    {
      j = zza();
      i = zza(j, 0, j);
      j = i;
      if (i == 0) {
        j = 1;
      }
      this.zzc = j;
    }
    return j;
  }
  
  public final String toString()
  {
    Locale localLocale = Locale.ROOT;
    String str1 = Integer.toHexString(System.identityHashCode(this));
    int i = zza();
    String str2;
    if (zza() <= 50) {
      str2 = zzip.zza(this);
    } else {
      str2 = String.valueOf(zzip.zza(zza(0, 47))).concat("...");
    }
    return String.format(localLocale, "<ByteString@%s size=%d contents=\"%s\">", new Object[] { str1, Integer.valueOf(i), str2 });
  }
  
  public abstract byte zza(int paramInt);
  
  public abstract int zza();
  
  protected abstract int zza(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract zzew zza(int paramInt1, int paramInt2);
  
  protected abstract String zza(Charset paramCharset);
  
  abstract void zza(zzex paramzzex)
    throws IOException;
  
  abstract byte zzb(int paramInt);
  
  public final String zzb()
  {
    Charset localCharset = zzgc.zza;
    if (zza() == 0) {
      return "";
    }
    return zza(localCharset);
  }
  
  public abstract boolean zzc();
  
  protected final int zzd()
  {
    return this.zzc;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */