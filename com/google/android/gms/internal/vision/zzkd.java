package com.google.android.gms.internal.vision;

final class zzkd
  extends zzjy
{
  private static int zza(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2) {
          return zzjx.zze(paramInt1, zzju.zza(paramArrayOfByte, paramLong), zzju.zza(paramArrayOfByte, paramLong + 1L));
        }
        throw new AssertionError();
      }
      return zzjx.zzw(paramInt1, zzju.zza(paramArrayOfByte, paramLong));
    }
    return zzjx.zzby(paramInt1);
  }
  
  final int zzb(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if ((paramInt2 | paramInt3 | paramArrayOfByte.length - paramInt3) >= 0)
    {
      long l1 = paramInt2;
      paramInt2 = (int)(paramInt3 - l1);
      if (paramInt2 < 16)
      {
        paramInt1 = 0;
      }
      else
      {
        l2 = l1;
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          if (zzju.zza(paramArrayOfByte, l2) < 0) {
            break label73;
          }
          paramInt1++;
          l2 += 1L;
        }
        paramInt1 = paramInt2;
      }
      label73:
      paramInt2 -= paramInt1;
      long l2 = l1 + paramInt1;
      paramInt1 = paramInt2;
      paramInt3 = 0;
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      for (;;)
      {
        l1 = l2;
        if (paramInt2 <= 0) {
          break;
        }
        l1 = l2 + 1L;
        paramInt1 = zzju.zza(paramArrayOfByte, l2);
        if (paramInt1 < 0) {
          break;
        }
        paramInt2--;
        l2 = l1;
      }
      if (paramInt2 == 0) {
        return 0;
      }
      paramInt2--;
      if (paramInt1 < -32)
      {
        if (paramInt2 == 0) {
          return paramInt1;
        }
        paramInt2--;
        if (paramInt1 >= -62)
        {
          l2 = l1 + 1L;
          paramInt1 = paramInt2;
          if (zzju.zza(paramArrayOfByte, l1) > -65) {}
        }
      }
      do
      {
        break;
        return -1;
        if (paramInt1 < -16)
        {
          if (paramInt2 < 2) {
            return zza(paramArrayOfByte, paramInt1, l1, paramInt2);
          }
          paramInt2 -= 2;
          long l3 = l1 + 1L;
          paramInt3 = zzju.zza(paramArrayOfByte, l1);
          if ((paramInt3 <= -65) && ((paramInt1 != -32) || (paramInt3 >= -96)) && ((paramInt1 != -19) || (paramInt3 < -96)))
          {
            l2 = l3 + 1L;
            paramInt1 = paramInt2;
            if (zzju.zza(paramArrayOfByte, l3) <= -65) {
              break;
            }
          }
          return -1;
        }
        if (paramInt2 < 3) {
          return zza(paramArrayOfByte, paramInt1, l1, paramInt2);
        }
        paramInt2 -= 3;
        l2 = l1 + 1L;
        paramInt3 = zzju.zza(paramArrayOfByte, l1);
        if ((paramInt3 > -65) || ((paramInt1 << 28) + (paramInt3 + 112) >> 30 != 0)) {
          break label367;
        }
        l1 = l2 + 1L;
        if (zzju.zza(paramArrayOfByte, l2) > -65) {
          break label367;
        }
        l2 = l1 + 1L;
        paramInt1 = paramInt2;
      } while (zzju.zza(paramArrayOfByte, l1) <= -65);
      label367:
      return -1;
    }
    throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
  }
  
  final int zzb(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l1 = paramInt1;
    long l2 = paramInt2 + l1;
    int i = paramCharSequence.length();
    if ((i <= paramInt2) && (paramArrayOfByte.length - paramInt2 >= paramInt1))
    {
      paramInt2 = 0;
      long l3;
      for (;;)
      {
        l3 = 1L;
        if (paramInt2 >= i) {
          break;
        }
        paramInt1 = paramCharSequence.charAt(paramInt2);
        if (paramInt1 >= 128) {
          break;
        }
        zzju.zza(paramArrayOfByte, l1, (byte)paramInt1);
        paramInt2++;
        l1 = 1L + l1;
      }
      paramInt1 = paramInt2;
      long l4 = l1;
      if (paramInt2 == i) {
        return (int)l1;
      }
      while (paramInt1 < i)
      {
        int j = paramCharSequence.charAt(paramInt1);
        if ((j < 128) && (l4 < l2))
        {
          zzju.zza(paramArrayOfByte, l4, (byte)j);
          long l5 = l3;
          l1 = l4 + l3;
          l3 = l5;
        }
        for (;;)
        {
          break;
          if ((j < 2048) && (l4 <= l2 - 2L))
          {
            l1 = l4 + l3;
            zzju.zza(paramArrayOfByte, l4, (byte)(j >>> 6 | 0x3C0));
            zzju.zza(paramArrayOfByte, l1, (byte)(j & 0x3F | 0x80));
            l1 += l3;
          }
          else if (((j < 55296) || (57343 < j)) && (l4 <= l2 - 3L))
          {
            l1 = l4 + l3;
            zzju.zza(paramArrayOfByte, l4, (byte)(j >>> 12 | 0x1E0));
            l3 = l1 + l3;
            zzju.zza(paramArrayOfByte, l1, (byte)(j >>> 6 & 0x3F | 0x80));
            zzju.zza(paramArrayOfByte, l3, (byte)(j & 0x3F | 0x80));
            l1 = l3 + 1L;
            l3 = 1L;
          }
          else
          {
            if (l4 > l2 - 4L) {
              break label507;
            }
            paramInt2 = paramInt1 + 1;
            if (paramInt2 == i) {
              break label494;
            }
            c = paramCharSequence.charAt(paramInt2);
            if (!Character.isSurrogatePair(j, c)) {
              break label491;
            }
            paramInt1 = Character.toCodePoint(j, c);
            l1 = l4 + 1L;
            zzju.zza(paramArrayOfByte, l4, (byte)(paramInt1 >>> 18 | 0xF0));
            l3 = l1 + 1L;
            zzju.zza(paramArrayOfByte, l1, (byte)(paramInt1 >>> 12 & 0x3F | 0x80));
            l4 = l3 + 1L;
            zzju.zza(paramArrayOfByte, l3, (byte)(paramInt1 >>> 6 & 0x3F | 0x80));
            l3 = 1L;
            l1 = l4 + 1L;
            zzju.zza(paramArrayOfByte, l4, (byte)(paramInt1 & 0x3F | 0x80));
            paramInt1 = paramInt2;
          }
        }
        paramInt1++;
        l4 = l1;
        continue;
        label491:
        paramInt1 = paramInt2;
        label494:
        throw new zzka(paramInt1 - 1, i);
        label507:
        if ((55296 <= j) && (j <= 57343))
        {
          paramInt2 = paramInt1 + 1;
          if ((paramInt2 == i) || (!Character.isSurrogatePair(j, paramCharSequence.charAt(paramInt2)))) {
            throw new zzka(paramInt1, i);
          }
        }
        paramCharSequence = new StringBuilder(46);
        paramCharSequence.append("Failed writing ");
        paramCharSequence.append(j);
        paramCharSequence.append(" at index ");
        paramCharSequence.append(l4);
        throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
      }
      return (int)l4;
    }
    char c = paramCharSequence.charAt(i - 1);
    paramCharSequence = new StringBuilder(37);
    paramCharSequence.append("Failed writing ");
    paramCharSequence.append(c);
    paramCharSequence.append(" at index ");
    paramCharSequence.append(paramInt1 + paramInt2);
    throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
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
        b1 = zzju.zza(paramArrayOfByte, paramInt1);
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
        b1 = zzju.zza(paramArrayOfByte, paramInt2);
        if (zzjz.zzh(b1))
        {
          paramInt2 = paramInt1 + 1;
          zzjz.zzb(b1, arrayOfChar, paramInt1);
          paramInt1 = paramInt2;
          paramInt2 = j;
          while (paramInt2 < i)
          {
            b1 = zzju.zza(paramArrayOfByte, paramInt2);
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
            zzjz.zzb(b1, zzju.zza(paramArrayOfByte, j), arrayOfChar, paramInt1);
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
            zzjz.zzb(b1, zzju.zza(paramArrayOfByte, j), zzju.zza(paramArrayOfByte, paramInt2), arrayOfChar, paramInt1);
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
          byte b2 = zzju.zza(paramArrayOfByte, j);
          j = paramInt2 + 1;
          zzjz.zzb(b1, b2, zzju.zza(paramArrayOfByte, paramInt2), zzju.zza(paramArrayOfByte, j), arrayOfChar, paramInt1);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzkd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */