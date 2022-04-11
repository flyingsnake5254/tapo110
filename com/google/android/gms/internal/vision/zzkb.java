package com.google.android.gms.internal.vision;

final class zzkb
  extends zzjy
{
  final int zzb(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    while ((paramInt2 < paramInt3) && (paramArrayOfByte[paramInt2] >= 0)) {
      paramInt2++;
    }
    paramInt1 = paramInt2;
    if (paramInt2 >= paramInt3) {
      return 0;
    }
    label241:
    for (;;)
    {
      if (paramInt1 >= paramInt3) {
        return 0;
      }
      paramInt2 = paramInt1 + 1;
      int i = paramArrayOfByte[paramInt1];
      paramInt1 = paramInt2;
      if (i < 0) {
        if (i < -32)
        {
          if (paramInt2 >= paramInt3) {
            return i;
          }
          if (i >= -62)
          {
            paramInt1 = paramInt2 + 1;
            if (paramArrayOfByte[paramInt2] <= -65) {}
          }
          else
          {
            return -1;
          }
        }
        else if (i < -16)
        {
          if (paramInt2 >= paramInt3 - 1) {
            return zzjx.zzi(paramArrayOfByte, paramInt2, paramInt3);
          }
          int j = paramInt2 + 1;
          paramInt1 = paramArrayOfByte[paramInt2];
          if ((paramInt1 <= -65) && ((i != -32) || (paramInt1 >= -96)) && ((i != -19) || (paramInt1 < -96)))
          {
            paramInt1 = j + 1;
            if (paramArrayOfByte[j] <= -65) {}
          }
          else
          {
            return -1;
          }
        }
        else
        {
          if (paramInt2 >= paramInt3 - 2) {
            return zzjx.zzi(paramArrayOfByte, paramInt2, paramInt3);
          }
          paramInt1 = paramInt2 + 1;
          paramInt2 = paramArrayOfByte[paramInt2];
          if ((paramInt2 <= -65) && ((i << 28) + (paramInt2 + 112) >> 30 == 0))
          {
            paramInt2 = paramInt1 + 1;
            if (paramArrayOfByte[paramInt1] <= -65)
            {
              paramInt1 = paramInt2 + 1;
              if (paramArrayOfByte[paramInt2] <= -65) {
                break label241;
              }
            }
          }
          return -1;
        }
      }
    }
  }
  
  final int zzb(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramCharSequence.length();
    int j = paramInt2 + paramInt1;
    int m;
    for (paramInt2 = 0; paramInt2 < i; paramInt2++)
    {
      k = paramInt2 + paramInt1;
      if (k >= j) {
        break;
      }
      m = paramCharSequence.charAt(paramInt2);
      if (m >= 128) {
        break;
      }
      paramArrayOfByte[k] = ((byte)(byte)m);
    }
    if (paramInt2 == i) {
      return paramInt1 + i;
    }
    int k = paramInt1 + paramInt2;
    paramInt1 = paramInt2;
    while (paramInt1 < i)
    {
      int n = paramCharSequence.charAt(paramInt1);
      if ((n < 128) && (k < j))
      {
        paramInt2 = k + 1;
        paramArrayOfByte[k] = ((byte)(byte)n);
      }
      for (;;)
      {
        break;
        if ((n < 2048) && (k <= j - 2))
        {
          m = k + 1;
          paramArrayOfByte[k] = ((byte)(byte)(n >>> 6 | 0x3C0));
          paramInt2 = m + 1;
          paramArrayOfByte[m] = ((byte)(byte)(n & 0x3F | 0x80));
        }
        else if (((n < 55296) || (57343 < n)) && (k <= j - 3))
        {
          paramInt2 = k + 1;
          paramArrayOfByte[k] = ((byte)(byte)(n >>> 12 | 0x1E0));
          k = paramInt2 + 1;
          paramArrayOfByte[paramInt2] = ((byte)(byte)(n >>> 6 & 0x3F | 0x80));
          paramInt2 = k + 1;
          paramArrayOfByte[k] = ((byte)(byte)(n & 0x3F | 0x80));
        }
        else
        {
          if (k > j - 4) {
            break label463;
          }
          paramInt2 = paramInt1 + 1;
          if (paramInt2 == paramCharSequence.length()) {
            break label450;
          }
          char c = paramCharSequence.charAt(paramInt2);
          if (!Character.isSurrogatePair(n, c)) {
            break label447;
          }
          paramInt1 = Character.toCodePoint(n, c);
          m = k + 1;
          paramArrayOfByte[k] = ((byte)(byte)(paramInt1 >>> 18 | 0xF0));
          k = m + 1;
          paramArrayOfByte[m] = ((byte)(byte)(paramInt1 >>> 12 & 0x3F | 0x80));
          m = k + 1;
          paramArrayOfByte[k] = ((byte)(byte)(paramInt1 >>> 6 & 0x3F | 0x80));
          k = m + 1;
          paramArrayOfByte[m] = ((byte)(byte)(paramInt1 & 0x3F | 0x80));
          paramInt1 = paramInt2;
          paramInt2 = k;
        }
      }
      paramInt1++;
      k = paramInt2;
      continue;
      label447:
      paramInt1 = paramInt2;
      label450:
      throw new zzka(paramInt1 - 1, i);
      label463:
      if ((55296 <= n) && (n <= 57343))
      {
        paramInt2 = paramInt1 + 1;
        if ((paramInt2 == paramCharSequence.length()) || (!Character.isSurrogatePair(n, paramCharSequence.charAt(paramInt2)))) {
          throw new zzka(paramInt1, i);
        }
      }
      paramCharSequence = new StringBuilder(37);
      paramCharSequence.append("Failed writing ");
      paramCharSequence.append(n);
      paramCharSequence.append(" at index ");
      paramCharSequence.append(k);
      throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
    }
    return k;
  }
  
  final String zzh(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zzhh
  {
    if ((paramInt1 | paramInt2 | paramArrayOfByte.length - paramInt1 - paramInt2) >= 0)
    {
      int i = paramInt1 + paramInt2;
      char[] arrayOfChar = new char[paramInt2];
      byte b1;
      for (paramInt2 = 0; paramInt1 < i; paramInt2++)
      {
        b1 = paramArrayOfByte[paramInt1];
        if (!zzjz.zzh(b1)) {
          break;
        }
        paramInt1++;
        zzjz.zzb(b1, arrayOfChar, paramInt2);
      }
      int j = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = j;
      while (paramInt2 < i)
      {
        j = paramInt2 + 1;
        b1 = paramArrayOfByte[paramInt2];
        if (zzjz.zzh(b1))
        {
          paramInt2 = paramInt1 + 1;
          zzjz.zzb(b1, arrayOfChar, paramInt1);
          paramInt1 = paramInt2;
          paramInt2 = j;
          while (paramInt2 < i)
          {
            b1 = paramArrayOfByte[paramInt2];
            if (!zzjz.zzh(b1)) {
              break;
            }
            paramInt2++;
            zzjz.zzb(b1, arrayOfChar, paramInt1);
            paramInt1++;
          }
        }
        else if (zzjz.zzi(b1))
        {
          if (j < i)
          {
            zzjz.zzb(b1, paramArrayOfByte[j], arrayOfChar, paramInt1);
            paramInt2 = j + 1;
            paramInt1++;
          }
          else
          {
            throw zzhh.zzgu();
          }
        }
        else if (zzjz.zzj(b1))
        {
          if (j < i - 1)
          {
            paramInt2 = j + 1;
            zzjz.zzb(b1, paramArrayOfByte[j], paramArrayOfByte[paramInt2], arrayOfChar, paramInt1);
            paramInt2++;
            paramInt1++;
          }
          else
          {
            throw zzhh.zzgu();
          }
        }
        else if (j < i - 2)
        {
          paramInt2 = j + 1;
          byte b2 = paramArrayOfByte[j];
          j = paramInt2 + 1;
          zzjz.zzb(b1, b2, paramArrayOfByte[paramInt2], paramArrayOfByte[j], arrayOfChar, paramInt1);
          paramInt2 = j + 1;
          paramInt1 = paramInt1 + 1 + 1;
        }
        else
        {
          throw zzhh.zzgu();
        }
      }
      return new String(arrayOfChar, 0, paramInt1);
    }
    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzkb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */