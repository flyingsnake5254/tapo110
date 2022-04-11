package com.google.android.gms.internal.measurement;

final class zzmw
{
  private static final zzmt zza = new zzmu();
  
  static
  {
    if ((zzmr.zza()) && (zzmr.zzb())) {
      int i = zziq.zza;
    }
  }
  
  public static boolean zza(byte[] paramArrayOfByte)
  {
    return zza.zza(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static boolean zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return zza.zza(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  static int zzc(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    int j = 0;
    for (int k = 0; (k < i) && (paramCharSequence.charAt(k) < ''); k++) {}
    int m = i;
    for (;;)
    {
      n = m;
      if (k >= i) {
        break label213;
      }
      n = paramCharSequence.charAt(k);
      if (n >= 2048) {
        break;
      }
      m += (127 - n >>> 31);
      k++;
    }
    int i1 = paramCharSequence.length();
    int n = j;
    while (k < i1)
    {
      int i2 = paramCharSequence.charAt(k);
      if (i2 < 2048)
      {
        n += (127 - i2 >>> 31);
        j = k;
      }
      else
      {
        int i3 = n + 2;
        n = i3;
        j = k;
        if (i2 >= 55296)
        {
          n = i3;
          j = k;
          if (i2 <= 57343) {
            if (Character.codePointAt(paramCharSequence, k) >= 65536)
            {
              j = k + 1;
              n = i3;
            }
            else
            {
              throw new zzmv(k, i1);
            }
          }
        }
      }
      k = j + 1;
    }
    n = m + n;
    label213:
    if (n >= i) {
      return n;
    }
    paramCharSequence = new StringBuilder(54);
    paramCharSequence.append("UTF-8 length does not fit in int: ");
    paramCharSequence.append(n + 4294967296L);
    throw new IllegalArgumentException(paramCharSequence.toString());
  }
  
  static int zzd(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramCharSequence.length();
    int j = paramInt2 + paramInt1;
    int m;
    for (int k = 0; k < i; k++)
    {
      paramInt2 = k + paramInt1;
      if (paramInt2 >= j) {
        break;
      }
      m = paramCharSequence.charAt(k);
      if (m >= 128) {
        break;
      }
      paramArrayOfByte[paramInt2] = ((byte)(byte)m);
    }
    if (k == i)
    {
      k = paramInt1 + i;
    }
    else
    {
      paramInt2 = paramInt1 + k;
      int n;
      for (paramInt1 = k;; paramInt1++)
      {
        k = paramInt2;
        if (paramInt1 >= i) {
          break label548;
        }
        n = paramCharSequence.charAt(paramInt1);
        if ((n < 128) && (paramInt2 < j))
        {
          k = paramInt2 + 1;
          paramArrayOfByte[paramInt2] = ((byte)(byte)n);
          paramInt2 = k;
        }
        for (;;)
        {
          break;
          if ((n < 2048) && (paramInt2 <= j - 2))
          {
            k = paramInt2 + 1;
            paramArrayOfByte[paramInt2] = ((byte)(byte)(n >>> 6 | 0x3C0));
            paramInt2 = k + 1;
            paramArrayOfByte[k] = ((byte)(byte)(n & 0x3F | 0x80));
          }
          else if (((n < 55296) || (n > 57343)) && (paramInt2 <= j - 3))
          {
            m = paramInt2 + 1;
            paramArrayOfByte[paramInt2] = ((byte)(byte)(n >>> 12 | 0x1E0));
            k = m + 1;
            paramArrayOfByte[m] = ((byte)(byte)(n >>> 6 & 0x3F | 0x80));
            paramInt2 = k + 1;
            paramArrayOfByte[k] = ((byte)(byte)(n & 0x3F | 0x80));
          }
          else
          {
            if (paramInt2 > j - 4) {
              break label442;
            }
            k = paramInt1 + 1;
            if (k == paramCharSequence.length()) {
              break label429;
            }
            char c = paramCharSequence.charAt(k);
            if (!Character.isSurrogatePair(n, c)) {
              break label426;
            }
            paramInt1 = Character.toCodePoint(n, c);
            m = paramInt2 + 1;
            paramArrayOfByte[paramInt2] = ((byte)(byte)(paramInt1 >>> 18 | 0xF0));
            paramInt2 = m + 1;
            paramArrayOfByte[m] = ((byte)(byte)(paramInt1 >>> 12 & 0x3F | 0x80));
            m = paramInt2 + 1;
            paramArrayOfByte[paramInt2] = ((byte)(byte)(paramInt1 >>> 6 & 0x3F | 0x80));
            paramInt2 = m + 1;
            paramArrayOfByte[m] = ((byte)(byte)(paramInt1 & 0x3F | 0x80));
            paramInt1 = k;
          }
        }
      }
      label426:
      paramInt1 = k;
      label429:
      throw new zzmv(paramInt1 - 1, i);
      label442:
      if ((n >= 55296) && (n <= 57343))
      {
        k = paramInt1 + 1;
        if ((k == paramCharSequence.length()) || (!Character.isSurrogatePair(n, paramCharSequence.charAt(k)))) {
          throw new zzmv(paramInt1, i);
        }
      }
      paramCharSequence = new StringBuilder(37);
      paramCharSequence.append("Failed writing ");
      paramCharSequence.append(n);
      paramCharSequence.append(" at index ");
      paramCharSequence.append(paramInt2);
      throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
    }
    label548:
    return k;
  }
  
  static String zze(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zzkn
  {
    int i = paramArrayOfByte.length;
    if ((paramInt1 | paramInt2 | i - paramInt1 - paramInt2) >= 0)
    {
      int j = paramInt1 + paramInt2;
      char[] arrayOfChar = new char[paramInt2];
      i = 0;
      int k = paramInt1;
      byte b;
      for (;;)
      {
        paramInt1 = i;
        paramInt2 = k;
        if (k >= j) {
          break;
        }
        b = paramArrayOfByte[k];
        if (!zzms.zza(b))
        {
          paramInt1 = i;
          paramInt2 = k;
          break;
        }
        k++;
        arrayOfChar[i] = ((char)(char)b);
        i++;
      }
      while (paramInt2 < j)
      {
        i = paramInt2 + 1;
        b = paramArrayOfByte[paramInt2];
        if (zzms.zza(b))
        {
          paramInt2 = paramInt1 + 1;
          arrayOfChar[paramInt1] = ((char)(char)b);
          paramInt1 = paramInt2;
          for (;;)
          {
            k = paramInt1;
            paramInt1 = k;
            paramInt2 = i;
            if (i >= j) {
              break;
            }
            b = paramArrayOfByte[i];
            if (!zzms.zza(b))
            {
              paramInt1 = k;
              paramInt2 = i;
              break;
            }
            i++;
            paramInt1 = k + 1;
            arrayOfChar[k] = ((char)(char)b);
          }
        }
        if (b < -32)
        {
          if (i < j)
          {
            zzms.zzb(b, paramArrayOfByte[i], arrayOfChar, paramInt1);
            paramInt2 = i + 1;
            paramInt1++;
          }
          else
          {
            throw zzkn.zzf();
          }
        }
        else if (b < -16)
        {
          if (i < j - 1)
          {
            paramInt2 = i + 1;
            zzms.zzc(b, paramArrayOfByte[i], paramArrayOfByte[paramInt2], arrayOfChar, paramInt1);
            paramInt2++;
            paramInt1++;
          }
          else
          {
            throw zzkn.zzf();
          }
        }
        else if (i < j - 2)
        {
          k = i + 1;
          paramInt2 = k + 1;
          zzms.zzd(b, paramArrayOfByte[i], paramArrayOfByte[k], paramArrayOfByte[paramInt2], arrayOfChar, paramInt1);
          paramInt1 += 2;
          paramInt2++;
        }
        else
        {
          throw zzkn.zzf();
        }
      }
      return new String(arrayOfChar, 0, paramInt1);
    }
    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzmw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */