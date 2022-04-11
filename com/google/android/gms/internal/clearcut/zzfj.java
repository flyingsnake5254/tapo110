package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;

final class zzfj
  extends zzfg
{
  private static int zza(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2) {
          return zzff.zze(paramInt1, zzfd.zza(paramArrayOfByte, paramLong), zzfd.zza(paramArrayOfByte, paramLong + 1L));
        }
        throw new AssertionError();
      }
      return zzff.zzq(paramInt1, zzfd.zza(paramArrayOfByte, paramLong));
    }
    return zzff.zzan(paramInt1);
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
          if (zzfd.zza(paramArrayOfByte, l2) < 0) {
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
        paramInt1 = zzfd.zza(paramArrayOfByte, l2);
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
          if (zzfd.zza(paramArrayOfByte, l1) > -65) {}
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
          paramInt3 = zzfd.zza(paramArrayOfByte, l1);
          if ((paramInt3 <= -65) && ((paramInt1 != -32) || (paramInt3 >= -96)) && ((paramInt1 != -19) || (paramInt3 < -96)))
          {
            l2 = l3 + 1L;
            paramInt1 = paramInt2;
            if (zzfd.zza(paramArrayOfByte, l3) <= -65) {
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
        paramInt3 = zzfd.zza(paramArrayOfByte, l1);
        if ((paramInt3 > -65) || ((paramInt1 << 28) + (paramInt3 + 112) >> 30 != 0)) {
          break label367;
        }
        l1 = l2 + 1L;
        if (zzfd.zza(paramArrayOfByte, l2) > -65) {
          break label367;
        }
        l2 = l1 + 1L;
        paramInt1 = paramInt2;
      } while (zzfd.zza(paramArrayOfByte, l1) <= -65);
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
        zzfd.zza(paramArrayOfByte, l1, (byte)paramInt1);
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
          zzfd.zza(paramArrayOfByte, l4, (byte)j);
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
            zzfd.zza(paramArrayOfByte, l4, (byte)(j >>> 6 | 0x3C0));
            zzfd.zza(paramArrayOfByte, l1, (byte)(j & 0x3F | 0x80));
            l1 += l3;
          }
          else if (((j < 55296) || (57343 < j)) && (l4 <= l2 - 3L))
          {
            l1 = l4 + l3;
            zzfd.zza(paramArrayOfByte, l4, (byte)(j >>> 12 | 0x1E0));
            l3 = l1 + l3;
            zzfd.zza(paramArrayOfByte, l1, (byte)(j >>> 6 & 0x3F | 0x80));
            zzfd.zza(paramArrayOfByte, l3, (byte)(j & 0x3F | 0x80));
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
            zzfd.zza(paramArrayOfByte, l4, (byte)(paramInt1 >>> 18 | 0xF0));
            l3 = l1 + 1L;
            zzfd.zza(paramArrayOfByte, l1, (byte)(paramInt1 >>> 12 & 0x3F | 0x80));
            l4 = l3 + 1L;
            zzfd.zza(paramArrayOfByte, l3, (byte)(paramInt1 >>> 6 & 0x3F | 0x80));
            l3 = 1L;
            l1 = l4 + 1L;
            zzfd.zza(paramArrayOfByte, l4, (byte)(paramInt1 & 0x3F | 0x80));
            paramInt1 = paramInt2;
          }
        }
        paramInt1++;
        l4 = l1;
        continue;
        label491:
        paramInt1 = paramInt2;
        label494:
        throw new zzfi(paramInt1 - 1, i);
        label507:
        if ((55296 <= j) && (j <= 57343))
        {
          paramInt2 = paramInt1 + 1;
          if ((paramInt2 == i) || (!Character.isSurrogatePair(j, paramCharSequence.charAt(paramInt2)))) {
            throw new zzfi(paramInt1, i);
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
  
  final void zzb(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    long l1 = zzfd.zzb(paramByteBuffer);
    long l2 = paramByteBuffer.position() + l1;
    long l3 = paramByteBuffer.limit() + l1;
    int i = paramCharSequence.length();
    if (i <= l3 - l2)
    {
      int j = 0;
      while (j < i)
      {
        k = paramCharSequence.charAt(j);
        if (k >= 128) {
          break;
        }
        zzfd.zza(l2, (byte)k);
        j++;
        l2 += 1L;
      }
      long l4 = l1;
      long l5 = l2;
      k = j;
      if (j == i) {}
      for (k = (int)(l2 - l1);; k = (int)(l5 - l4))
      {
        paramByteBuffer.position(k);
        return;
        while (k < i)
        {
          int m = paramCharSequence.charAt(k);
          if ((m < 128) && (l5 < l3))
          {
            zzfd.zza(l5, (byte)m);
            l2 = l5 + 1L;
          }
          else
          {
            if ((m < 2048) && (l5 <= l3 - 2L))
            {
              l2 = l5 + 1L;
              zzfd.zza(l5, (byte)(m >>> 6 | 0x3C0));
              zzfd.zza(l2, (byte)(m & 0x3F | 0x80));
              l2 += 1L;
            }
            for (;;)
            {
              break;
              if (((m < 55296) || (57343 < m)) && (l5 <= l3 - 3L))
              {
                l2 = l5 + 1L;
                zzfd.zza(l5, (byte)(m >>> 12 | 0x1E0));
                l5 = l2 + 1L;
                zzfd.zza(l2, (byte)(m >>> 6 & 0x3F | 0x80));
                zzfd.zza(l5, (byte)(m & 0x3F | 0x80));
                l2 = l5 + 1L;
              }
              else
              {
                if (l5 > l3 - 4L) {
                  break label507;
                }
                j = k + 1;
                if (j == i) {
                  break label493;
                }
                c = paramCharSequence.charAt(j);
                if (!Character.isSurrogatePair(m, c)) {
                  break label489;
                }
                k = Character.toCodePoint(m, c);
                l1 = l5 + 1L;
                zzfd.zza(l5, (byte)(k >>> 18 | 0xF0));
                l2 = l1 + 1L;
                zzfd.zza(l1, (byte)(k >>> 12 & 0x3F | 0x80));
                l5 = l2 + 1L;
                zzfd.zza(l2, (byte)(k >>> 6 & 0x3F | 0x80));
                zzfd.zza(l5, (byte)(k & 0x3F | 0x80));
                l2 = l5 + 1L;
                k = j;
              }
            }
          }
          k++;
          l5 = l2;
          continue;
          label489:
          k = j;
          label493:
          throw new zzfi(k - 1, i);
          label507:
          if ((55296 <= m) && (m <= 57343))
          {
            j = k + 1;
            if ((j == i) || (!Character.isSurrogatePair(m, paramCharSequence.charAt(j)))) {
              throw new zzfi(k, i);
            }
          }
          paramCharSequence = new StringBuilder(46);
          paramCharSequence.append("Failed writing ");
          paramCharSequence.append(m);
          paramCharSequence.append(" at index ");
          paramCharSequence.append(l5);
          throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
        }
      }
    }
    char c = paramCharSequence.charAt(i - 1);
    int k = paramByteBuffer.limit();
    paramCharSequence = new StringBuilder(37);
    paramCharSequence.append("Failed writing ");
    paramCharSequence.append(c);
    paramCharSequence.append(" at index ");
    paramCharSequence.append(k);
    throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzfj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */