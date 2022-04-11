package io.netty.handler.codec.compression;

final class FastLz
{
  static final byte BLOCK_TYPE_COMPRESSED = 1;
  static final byte BLOCK_TYPE_NON_COMPRESSED = 0;
  static final byte BLOCK_WITHOUT_CHECKSUM = 0;
  static final byte BLOCK_WITH_CHECKSUM = 16;
  static final int CHECKSUM_OFFSET = 4;
  private static final int HASH_LOG = 13;
  private static final int HASH_MASK = 8191;
  private static final int HASH_SIZE = 8192;
  static final int LEVEL_1 = 1;
  static final int LEVEL_2 = 2;
  static final int LEVEL_AUTO = 0;
  static final int MAGIC_NUMBER = 4607066;
  static final int MAX_CHUNK_LENGTH = 65535;
  private static final int MAX_COPY = 32;
  private static final int MAX_DISTANCE = 8191;
  private static final int MAX_FARDISTANCE = 73725;
  private static final int MAX_LEN = 264;
  static final int MIN_LENGTH_TO_COMPRESSION = 32;
  private static final int MIN_RECOMENDED_LENGTH_FOR_LEVEL_2 = 65536;
  static final int OPTIONS_OFFSET = 3;
  
  static int calculateOutputBufferLength(int paramInt)
  {
    return Math.max((int)(paramInt * 1.06D), 66);
  }
  
  static int compress(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    int i;
    if (paramInt4 == 0)
    {
      if (paramInt2 < 65536) {
        i = 1;
      } else {
        i = 2;
      }
    }
    else {
      i = paramInt4;
    }
    int j = paramInt2 + 0;
    int k = j - 2;
    int[] arrayOfInt = new int[' '];
    paramInt4 = 0;
    if (paramInt2 < 4)
    {
      if (paramInt2 != 0)
      {
        paramArrayOfByte2[(paramInt3 + 0)] = ((byte)(byte)(paramInt2 - 1));
        m = 1;
        while (paramInt4 <= k + 1)
        {
          paramArrayOfByte2[(paramInt3 + m)] = ((byte)paramArrayOfByte1[(paramInt1 + paramInt4)]);
          m++;
          paramInt4++;
        }
        return paramInt2 + 1;
      }
      return 0;
    }
    for (paramInt2 = 0; paramInt2 < 8192; paramInt2++) {
      arrayOfInt[paramInt2] = 0;
    }
    paramArrayOfByte2[(paramInt3 + 0)] = ((byte)31);
    paramArrayOfByte2[(paramInt3 + 1)] = ((byte)paramArrayOfByte1[(paramInt1 + 0)]);
    paramArrayOfByte2[(paramInt3 + 2)] = ((byte)paramArrayOfByte1[(paramInt1 + 1)]);
    paramInt4 = 2;
    int m = 3;
    int n = 2;
    int i1;
    if (paramInt4 < j - 12)
    {
      if (i == 2)
      {
        paramInt2 = paramInt1 + paramInt4;
        i1 = paramArrayOfByte1[paramInt2];
        i2 = paramInt2 - 1;
        if ((i1 == paramArrayOfByte1[i2]) && (readU16(paramArrayOfByte1, i2) == readU16(paramArrayOfByte1, paramInt2 + 1)))
        {
          i1 = paramInt4 + 3;
          paramInt2 = paramInt4 + 2;
          i2 = 1;
          l = 1L;
          break label259;
        }
      }
      i1 = paramInt4;
      long l = 0L;
      paramInt2 = 0;
      int i2 = 0;
      label259:
      int i3;
      if (i2 == 0)
      {
        i2 = paramInt1 + i1;
        i3 = hashFunction(paramArrayOfByte1, i2);
        paramInt2 = arrayOfInt[i3];
        l = paramInt4 - paramInt2;
        arrayOfInt[i3] = paramInt4;
        if ((l != 0L) && (i == 1 ? l < 8191L : l < 73725L))
        {
          i3 = paramInt2 + 1;
          int i4 = paramArrayOfByte1[(paramInt1 + paramInt2)];
          paramInt2 = i1 + 1;
          if (i4 == paramArrayOfByte1[i2])
          {
            i2 = i3 + 1;
            i3 = paramArrayOfByte1[(paramInt1 + i3)];
            i1 = paramInt2 + 1;
            if (i3 == paramArrayOfByte1[(paramInt1 + paramInt2)])
            {
              paramInt2 = i2 + 1;
              i3 = paramArrayOfByte1[(paramInt1 + i2)];
              i2 = i1 + 1;
              if (i3 == paramArrayOfByte1[(paramInt1 + i1)])
              {
                if ((i == 2) && (l >= 8191L))
                {
                  i3 = paramArrayOfByte1[(paramInt1 + i2)];
                  i1 = paramInt2 + 1;
                  if (i3 == paramArrayOfByte1[(paramInt1 + paramInt2)])
                  {
                    i2 = paramArrayOfByte1[(paramInt1 + (i2 + 1))];
                    paramInt2 = i1 + 1;
                    if (i2 == paramArrayOfByte1[(paramInt1 + i1)])
                    {
                      i1 = 5;
                      break label659;
                    }
                  }
                  i2 = m + 1;
                  i1 = paramInt4 + 1;
                  paramArrayOfByte2[(paramInt3 + m)] = ((byte)paramArrayOfByte1[(paramInt1 + paramInt4)]);
                  m = n + 1;
                  paramInt4 = i2;
                  paramInt2 = i1;
                  n = m;
                  if (m != 32) {
                    break label646;
                  }
                  m = i2 + 1;
                  paramArrayOfByte2[(paramInt3 + i2)] = ((byte)31);
                  paramInt2 = i1;
                  break label637;
                }
                break label656;
              }
            }
          }
        }
        i2 = m + 1;
        i1 = paramInt4 + 1;
        paramArrayOfByte2[(paramInt3 + m)] = ((byte)paramArrayOfByte1[(paramInt1 + paramInt4)]);
        m = n + 1;
        paramInt4 = i2;
        paramInt2 = i1;
        n = m;
        if (m == 32)
        {
          m = i2 + 1;
          paramArrayOfByte2[(paramInt3 + i2)] = ((byte)31);
          paramInt2 = i1;
          label637:
          paramInt4 = paramInt2;
        }
      }
      for (;;)
      {
        n = 0;
        break;
        label646:
        m = paramInt4;
        paramInt4 = paramInt2;
        break;
        label656:
        i1 = 3;
        label659:
        i1 += paramInt4;
        l -= 1L;
        if (l == 0L)
        {
          i3 = paramArrayOfByte1[(paramInt1 + i1 - 1)];
          for (i2 = paramInt2;; i2++)
          {
            paramInt2 = i1;
            if (i1 >= k) {
              break;
            }
            if (paramArrayOfByte1[(paramInt1 + i2)] != i3)
            {
              paramInt2 = i1;
              break;
            }
            i1++;
          }
        }
        i3 = paramInt2 + 1;
        paramInt2 = paramArrayOfByte1[(paramInt1 + paramInt2)];
        i2 = i1 + 1;
        if (paramInt2 != paramArrayOfByte1[(paramInt1 + i1)])
        {
          paramInt2 = i2;
        }
        else
        {
          i1 = i3 + 1;
          i3 = paramArrayOfByte1[(paramInt1 + i3)];
          paramInt2 = i2 + 1;
          if (i3 == paramArrayOfByte1[(paramInt1 + i2)])
          {
            do
            {
              do
              {
                do
                {
                  i2 = i1 + 1;
                  i3 = paramArrayOfByte1[(paramInt1 + i1)];
                  i1 = paramInt2 + 1;
                  if (i3 != paramArrayOfByte1[(paramInt1 + paramInt2)])
                  {
                    paramInt2 = i1;
                    break;
                  }
                  i3 = i2 + 1;
                  i2 = paramArrayOfByte1[(paramInt1 + i2)];
                  paramInt2 = i1 + 1;
                } while (i2 != paramArrayOfByte1[(paramInt1 + i1)]);
                i2 = i3 + 1;
                i3 = paramArrayOfByte1[(paramInt1 + i3)];
                i1 = paramInt2 + 1;
                if (i3 != paramArrayOfByte1[(paramInt1 + paramInt2)])
                {
                  paramInt2 = i1;
                  break;
                }
                i3 = i2 + 1;
                i2 = paramArrayOfByte1[(paramInt1 + i2)];
                paramInt2 = i1 + 1;
              } while (i2 != paramArrayOfByte1[(paramInt1 + i1)]);
              i2 = i3 + 1;
              i3 = paramArrayOfByte1[(paramInt1 + i3)];
              i1 = paramInt2 + 1;
              if (i3 != paramArrayOfByte1[(paramInt1 + paramInt2)])
              {
                paramInt2 = i1;
                break;
              }
              i3 = paramArrayOfByte1[(paramInt1 + i2)];
              paramInt2 = i1 + 1;
            } while (i3 != paramArrayOfByte1[(paramInt1 + i1)]);
            i2++;
            for (i1 = paramInt2;; i1 = paramInt2)
            {
              paramInt2 = i1;
              if (i1 >= k) {
                break;
              }
              i3 = paramArrayOfByte1[(paramInt1 + i2)];
              paramInt2 = i1 + 1;
              if (i3 != paramArrayOfByte1[(paramInt1 + i1)]) {
                break;
              }
              i2++;
            }
          }
        }
        if (n != 0) {
          paramArrayOfByte2[(paramInt3 + m - n - 1)] = ((byte)(byte)(n - 1));
        } else {
          m--;
        }
        i1 = paramInt2 - 3;
        paramInt2 = i1 - paramInt4;
        if (i == 2)
        {
          if (l < 8191L)
          {
            if (paramInt2 < 7)
            {
              paramInt4 = m + 1;
              paramArrayOfByte2[(paramInt3 + m)] = ((byte)(byte)(int)((paramInt2 << 5) + (l >>> 8)));
              paramInt2 = paramInt4 + 1;
              paramArrayOfByte2[(paramInt3 + paramInt4)] = ((byte)(byte)(int)(l & 0xFF));
            }
            else
            {
              paramInt4 = m + 1;
              paramArrayOfByte2[(paramInt3 + m)] = ((byte)(byte)(int)((l >>> 8) + 224L));
              m = paramInt2 - 7;
              paramInt2 = paramInt4;
              paramInt4 = m;
              while (paramInt4 >= 255)
              {
                paramArrayOfByte2[(paramInt3 + paramInt2)] = ((byte)-1);
                paramInt4 -= 255;
                paramInt2++;
              }
              m = paramInt2 + 1;
              paramArrayOfByte2[(paramInt3 + paramInt2)] = ((byte)(byte)paramInt4);
              paramInt2 = m + 1;
              paramArrayOfByte2[(paramInt3 + m)] = ((byte)(byte)(int)(l & 0xFF));
            }
          }
          else if (paramInt2 < 7)
          {
            l -= 8191L;
            paramInt4 = m + 1;
            paramArrayOfByte2[(paramInt3 + m)] = ((byte)(byte)((paramInt2 << 5) + 31));
            paramInt2 = paramInt4 + 1;
            paramArrayOfByte2[(paramInt3 + paramInt4)] = ((byte)-1);
            paramInt4 = paramInt2 + 1;
            paramArrayOfByte2[(paramInt3 + paramInt2)] = ((byte)(byte)(int)(l >>> 8));
            paramInt2 = paramInt4 + 1;
            paramArrayOfByte2[(paramInt3 + paramInt4)] = ((byte)(byte)(int)(l & 0xFF));
          }
          else
          {
            l -= 8191L;
            paramInt4 = m + 1;
            paramArrayOfByte2[(paramInt3 + m)] = ((byte)-1);
            m = paramInt2 - 7;
            paramInt2 = paramInt4;
            paramInt4 = m;
            while (paramInt4 >= 255)
            {
              paramArrayOfByte2[(paramInt3 + paramInt2)] = ((byte)-1);
              paramInt4 -= 255;
              paramInt2++;
            }
            m = paramInt2 + 1;
            paramArrayOfByte2[(paramInt3 + paramInt2)] = ((byte)(byte)paramInt4);
            paramInt2 = m + 1;
            paramArrayOfByte2[(paramInt3 + m)] = ((byte)-1);
            paramInt4 = paramInt2 + 1;
            paramArrayOfByte2[(paramInt3 + paramInt2)] = ((byte)(byte)(int)(l >>> 8));
            paramInt2 = paramInt4 + 1;
            paramArrayOfByte2[(paramInt3 + paramInt4)] = ((byte)(byte)(int)(l & 0xFF));
          }
        }
        else
        {
          paramInt4 = paramInt2;
          n = m;
          if (paramInt2 > 262) {
            for (;;)
            {
              paramInt4 = paramInt2;
              n = m;
              if (paramInt2 <= 262) {
                break;
              }
              n = m + 1;
              paramArrayOfByte2[(paramInt3 + m)] = ((byte)(byte)(int)((l >>> 8) + 224L));
              paramInt4 = n + 1;
              paramArrayOfByte2[(paramInt3 + n)] = ((byte)-3);
              paramArrayOfByte2[(paramInt3 + paramInt4)] = ((byte)(byte)(int)(l & 0xFF));
              paramInt2 -= 262;
              m = paramInt4 + 1;
            }
          }
          if (paramInt4 < 7)
          {
            m = n + 1;
            paramArrayOfByte2[(paramInt3 + n)] = ((byte)(byte)(int)((paramInt4 << 5) + (l >>> 8)));
            paramInt2 = m + 1;
            paramArrayOfByte2[(paramInt3 + m)] = ((byte)(byte)(int)(l & 0xFF));
          }
          else
          {
            paramInt2 = n + 1;
            paramArrayOfByte2[(paramInt3 + n)] = ((byte)(byte)(int)((l >>> 8) + 224L));
            m = paramInt2 + 1;
            paramArrayOfByte2[(paramInt3 + paramInt2)] = ((byte)(byte)(paramInt4 - 7));
            paramInt2 = m + 1;
            paramArrayOfByte2[(paramInt3 + m)] = ((byte)(byte)(int)(l & 0xFF));
          }
        }
        paramInt4 = hashFunction(paramArrayOfByte1, paramInt1 + i1);
        m = i1 + 1;
        arrayOfInt[paramInt4] = i1;
        n = hashFunction(paramArrayOfByte1, paramInt1 + m);
        paramInt4 = m + 1;
        arrayOfInt[n] = m;
        m = paramInt2 + 1;
        paramArrayOfByte2[(paramInt3 + paramInt2)] = ((byte)31);
      }
    }
    while (paramInt4 <= k + 1)
    {
      i1 = m + 1;
      paramInt2 = paramInt4 + 1;
      paramArrayOfByte2[(paramInt3 + m)] = ((byte)paramArrayOfByte1[(paramInt1 + paramInt4)]);
      n++;
      if (n == 32)
      {
        m = i1 + 1;
        paramArrayOfByte2[(paramInt3 + i1)] = ((byte)31);
        n = 0;
        paramInt4 = paramInt2;
      }
      else
      {
        m = i1;
        paramInt4 = paramInt2;
      }
    }
    if (n != 0) {
      paramArrayOfByte2[(paramInt3 + m - n - 1)] = ((byte)(byte)(n - 1));
    } else {
      m--;
    }
    if (i == 2) {
      paramArrayOfByte2[paramInt3] = ((byte)(byte)(paramArrayOfByte2[paramInt3] | 0x20));
    }
    return m;
  }
  
  static int decompress(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    int i = (paramArrayOfByte1[paramInt1] >> 5) + 1;
    if ((i != 1) && (i != 2)) {
      throw new DecompressionException(String.format("invalid level: %d (expected: %d or %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(2) }));
    }
    long l1 = paramArrayOfByte1[(paramInt1 + 0)] & 0x1F;
    int j = 0;
    int k = 1;
    int i1;
    for (int m = 1;; m = i1)
    {
      long l2 = (0x1F & l1) << 8;
      long l3;
      if (l1 >= 32L)
      {
        l3 = (l1 >> 5) - 1L;
        long l4 = j;
        int n = (int)(l4 - l2);
        if (l3 == 6L)
        {
          if (i == 1)
          {
            l3 += (paramArrayOfByte1[(paramInt1 + k)] & 0xFF);
            i1 = k + 1;
            k = m;
          }
          else
          {
            for (;;)
            {
              i1 = paramArrayOfByte1[(paramInt1 + k)] & 0xFF;
              l3 += i1;
              k++;
              if (i1 != 255)
              {
                i1 = k;
                break;
              }
            }
          }
        }
        else
        {
          i1 = k;
          k = m;
        }
        int i2 = j;
        int i3;
        if (i == 1)
        {
          m = i1 + 1;
          j = n - (paramArrayOfByte1[(paramInt1 + i1)] & 0xFF);
        }
        else
        {
          i3 = i1 + 1;
          int i4 = paramArrayOfByte1[(paramInt1 + i1)] & 0xFF;
          i1 = n - i4;
          j = i1;
          m = i3;
          if (i4 == 255)
          {
            j = i1;
            m = i3;
            if (l2 == 7936L)
            {
              i1 = i3 + 1;
              l2 = (paramArrayOfByte1[(paramInt1 + i3)] & 0xFF) << 8;
              m = i1 + 1;
              j = (int)(l4 - (l2 + (paramArrayOfByte1[(paramInt1 + i1)] & 0xFF)) - 8191L);
            }
          }
        }
        if (l4 + l3 + 3L > paramInt4) {
          return 0;
        }
        if (j - 1 < 0) {
          return 0;
        }
        if (m < paramInt2)
        {
          i1 = m + 1;
          l1 = paramArrayOfByte1[(paramInt1 + m)] & 0xFF;
          m = i1;
          i1 = k;
        }
        else
        {
          i1 = 0;
        }
        if (j == i2)
        {
          j = paramArrayOfByte2[(paramInt3 + j - 1)];
          k = i2 + 1;
          paramArrayOfByte2[(paramInt3 + i2)] = ((byte)j);
          i2 = k + 1;
          paramArrayOfByte2[(paramInt3 + k)] = ((byte)j);
          k = i2 + 1;
          paramArrayOfByte2[(paramInt3 + i2)] = ((byte)j);
          while (l3 != 0L)
          {
            paramArrayOfByte2[(paramInt3 + k)] = ((byte)j);
            l3 -= 1L;
            k++;
          }
          j = k;
          k = m;
          l3 = l1;
          m = j;
        }
        else
        {
          i3 = j - 1;
          k = i2 + 1;
          j = i3 + 1;
          paramArrayOfByte2[(paramInt3 + i2)] = ((byte)paramArrayOfByte2[(paramInt3 + i3)]);
          i3 = k + 1;
          i2 = j + 1;
          paramArrayOfByte2[(paramInt3 + k)] = ((byte)paramArrayOfByte2[(paramInt3 + j)]);
          k = i3 + 1;
          j = i2 + 1;
          paramArrayOfByte2[(paramInt3 + i3)] = ((byte)paramArrayOfByte2[(paramInt3 + i2)]);
          while (l3 != 0L)
          {
            paramArrayOfByte2[(paramInt3 + k)] = ((byte)paramArrayOfByte2[(paramInt3 + j)]);
            l3 -= 1L;
            k++;
            j++;
          }
          j = m;
          l3 = l1;
          m = k;
          k = j;
        }
      }
      else
      {
        l3 = l1 + 1L;
        if (j + l3 > paramInt4) {
          return 0;
        }
        if (k + l3 > paramInt2) {
          return 0;
        }
        m = j + 1;
        i1 = k + 1;
        paramArrayOfByte2[(paramInt3 + j)] = ((byte)paramArrayOfByte1[(paramInt1 + k)]);
        l3 -= 1L;
        while (l3 != 0L)
        {
          paramArrayOfByte2[(paramInt3 + m)] = ((byte)paramArrayOfByte1[(paramInt1 + i1)]);
          l3 -= 1L;
          m++;
          i1++;
        }
        if (i1 < paramInt2) {
          k = 1;
        } else {
          k = 0;
        }
        if (k != 0)
        {
          l3 = paramArrayOfByte1[(paramInt1 + i1)] & 0xFF;
          j = i1 + 1;
          i1 = k;
          k = j;
        }
        else
        {
          j = i1;
          i1 = k;
          k = j;
        }
      }
      if (i1 == 0) {
        return m;
      }
      l1 = l3;
      j = m;
    }
  }
  
  private static int hashFunction(byte[] paramArrayOfByte, int paramInt)
  {
    int i = readU16(paramArrayOfByte, paramInt);
    return (readU16(paramArrayOfByte, paramInt + 1) ^ i >> 3 ^ i) & 0x1FFF;
  }
  
  private static int readU16(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt + 1;
    if (i >= paramArrayOfByte.length) {
      return paramArrayOfByte[paramInt] & 0xFF;
    }
    i = paramArrayOfByte[i];
    return paramArrayOfByte[paramInt] & 0xFF | (i & 0xFF) << 8;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\FastLz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */