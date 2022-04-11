package okio;

import java.io.UnsupportedEncodingException;

final class Base64
{
  private static final byte[] MAP = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] URL_MAP = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  
  public static byte[] decode(String paramString)
  {
    int j;
    for (int i = paramString.length(); i > 0; i--)
    {
      j = paramString.charAt(i - 1);
      if ((j != 61) && (j != 10) && (j != 13) && (j != 32) && (j != 9)) {
        break;
      }
    }
    int k = (int)(i * 6L / 8L);
    byte[] arrayOfByte = new byte[k];
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i5;
    for (int i2 = 0; m < i; i2 = i5)
    {
      int i3 = paramString.charAt(m);
      if ((i3 >= 65) && (i3 <= 90))
      {
        j = i3 - 65;
      }
      else if ((i3 >= 97) && (i3 <= 122))
      {
        j = i3 - 71;
      }
      else if ((i3 >= 48) && (i3 <= 57))
      {
        j = i3 + 4;
      }
      else if ((i3 != 43) && (i3 != 45))
      {
        if ((i3 != 47) && (i3 != 95))
        {
          j = n;
          i4 = i1;
          i5 = i2;
          if (i3 == 10) {
            break label373;
          }
          j = n;
          i4 = i1;
          i5 = i2;
          if (i3 == 13) {
            break label373;
          }
          j = n;
          i4 = i1;
          i5 = i2;
          if (i3 == 32) {
            break label373;
          }
          if (i3 == 9)
          {
            j = n;
            i4 = i1;
            i5 = i2;
            break label373;
          }
          return null;
        }
        j = 63;
      }
      else
      {
        j = 62;
      }
      i1 = i1 << 6 | (byte)j;
      n++;
      j = n;
      int i4 = i1;
      i5 = i2;
      if (n % 4 == 0)
      {
        j = i2 + 1;
        arrayOfByte[i2] = ((byte)(byte)(i1 >> 16));
        i2 = j + 1;
        arrayOfByte[j] = ((byte)(byte)(i1 >> 8));
        arrayOfByte[i2] = ((byte)(byte)i1);
        i5 = i2 + 1;
        i4 = i1;
        j = n;
      }
      label373:
      m++;
      n = j;
      i1 = i4;
    }
    i = n % 4;
    if (i == 1) {
      return null;
    }
    if (i == 2)
    {
      arrayOfByte[i2] = ((byte)(byte)(i1 << 12 >> 16));
      j = i2 + 1;
    }
    else
    {
      j = i2;
      if (i == 3)
      {
        m = i1 << 6;
        i = i2 + 1;
        arrayOfByte[i2] = ((byte)(byte)(m >> 16));
        j = i + 1;
        arrayOfByte[i] = ((byte)(byte)(m >> 8));
      }
    }
    if (j == k) {
      return arrayOfByte;
    }
    paramString = new byte[j];
    System.arraycopy(arrayOfByte, 0, paramString, 0, j);
    return paramString;
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, MAP);
  }
  
  private static String encode(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[(paramArrayOfByte1.length + 2) / 3 * 4];
    int i = paramArrayOfByte1.length - paramArrayOfByte1.length % 3;
    int j = 0;
    int k = 0;
    int m;
    while (j < i)
    {
      m = k + 1;
      arrayOfByte[k] = ((byte)paramArrayOfByte2[((paramArrayOfByte1[j] & 0xFF) >> 2)]);
      k = m + 1;
      int n = paramArrayOfByte1[j];
      int i1 = j + 1;
      arrayOfByte[m] = ((byte)paramArrayOfByte2[((n & 0x3) << 4 | (paramArrayOfByte1[i1] & 0xFF) >> 4)]);
      m = k + 1;
      n = paramArrayOfByte1[i1];
      i1 = j + 2;
      arrayOfByte[k] = ((byte)paramArrayOfByte2[((n & 0xF) << 2 | (paramArrayOfByte1[i1] & 0xFF) >> 6)]);
      k = m + 1;
      arrayOfByte[m] = ((byte)paramArrayOfByte2[(paramArrayOfByte1[i1] & 0x3F)]);
      j += 3;
    }
    j = paramArrayOfByte1.length % 3;
    if (j != 1)
    {
      if (j == 2)
      {
        j = k + 1;
        arrayOfByte[k] = ((byte)paramArrayOfByte2[((paramArrayOfByte1[i] & 0xFF) >> 2)]);
        m = j + 1;
        k = paramArrayOfByte1[i];
        i++;
        arrayOfByte[j] = ((byte)paramArrayOfByte2[((paramArrayOfByte1[i] & 0xFF) >> 4 | (k & 0x3) << 4)]);
        arrayOfByte[m] = ((byte)paramArrayOfByte2[((paramArrayOfByte1[i] & 0xF) << 2)]);
        arrayOfByte[(m + 1)] = ((byte)61);
      }
    }
    else
    {
      j = k + 1;
      arrayOfByte[k] = ((byte)paramArrayOfByte2[((paramArrayOfByte1[i] & 0xFF) >> 2)]);
      k = j + 1;
      arrayOfByte[j] = ((byte)paramArrayOfByte2[((paramArrayOfByte1[i] & 0x3) << 4)]);
      arrayOfByte[k] = ((byte)61);
      arrayOfByte[(k + 1)] = ((byte)61);
    }
    try
    {
      paramArrayOfByte1 = new String(arrayOfByte, "US-ASCII");
      return paramArrayOfByte1;
    }
    catch (UnsupportedEncodingException paramArrayOfByte1)
    {
      throw new AssertionError(paramArrayOfByte1);
    }
  }
  
  public static String encodeUrl(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, URL_MAP);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okio\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */