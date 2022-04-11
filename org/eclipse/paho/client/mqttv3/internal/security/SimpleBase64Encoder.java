package org.eclipse.paho.client.mqttv3.internal.security;

public class SimpleBase64Encoder
{
  private static final char[] PWDCHARS_ARRAY = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
  private static final String PWDCHARS_STRING = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  
  public static byte[] decode(String paramString)
  {
    paramString = paramString.getBytes();
    int i = paramString.length;
    byte[] arrayOfByte = new byte[i * 3 / 4];
    int j = 0;
    int k = 0;
    int m = 2;
    if (i < 4)
    {
      if (i == 3)
      {
        l = from64(paramString, j, 3);
        for (n = 1; n >= 0; n--)
        {
          arrayOfByte[(k + n)] = ((byte)(byte)(int)(l & 0xFF));
          l >>= 8;
        }
      }
      if (i == 2) {
        arrayOfByte[k] = ((byte)(byte)(int)(from64(paramString, j, 2) & 0xFF));
      }
      return arrayOfByte;
    }
    long l = from64(paramString, j, 4);
    i -= 4;
    int n = j + 4;
    for (j = m;; j--)
    {
      if (j < 0)
      {
        k += 3;
        j = n;
        break;
      }
      arrayOfByte[(k + j)] = ((byte)(byte)(int)(l & 0xFF));
      l >>= 8;
    }
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    StringBuffer localStringBuffer = new StringBuffer((i + 2) / 3 * 4);
    int j = 0;
    for (;;)
    {
      if (i < 3)
      {
        if (i == 2) {
          localStringBuffer.append(to64((paramArrayOfByte[j] & 0xFF) << 8 | paramArrayOfByte[(j + 1)] & 0xFF, 3));
        }
        if (i == 1) {
          localStringBuffer.append(to64(paramArrayOfByte[j] & 0xFF, 2));
        }
        return localStringBuffer.toString();
      }
      localStringBuffer.append(to64((paramArrayOfByte[j] & 0xFF) << 16 | (paramArrayOfByte[(j + 1)] & 0xFF) << 8 | paramArrayOfByte[(j + 2)] & 0xFF, 4));
      j += 3;
      i -= 3;
    }
  }
  
  private static final long from64(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    long l1 = 0L;
    int j = paramInt2;
    paramInt2 = i;
    for (;;)
    {
      if (j <= 0) {
        return l1;
      }
      j--;
      i = paramArrayOfByte[paramInt1];
      if (i == 47) {
        l2 = 1L;
      } else {
        l2 = 0L;
      }
      long l3 = l2;
      if (i >= 48)
      {
        l3 = l2;
        if (i <= 57) {
          l3 = i + 2 - 48;
        }
      }
      long l2 = l3;
      if (i >= 65)
      {
        l2 = l3;
        if (i <= 90) {
          l2 = i + 12 - 65;
        }
      }
      l3 = l2;
      if (i >= 97)
      {
        l3 = l2;
        if (i <= 122) {
          l3 = i + 38 - 97;
        }
      }
      l1 += (l3 << paramInt2);
      paramInt2 += 6;
      paramInt1++;
    }
  }
  
  private static final String to64(long paramLong, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt);
    for (;;)
    {
      if (paramInt <= 0) {
        return localStringBuffer.toString();
      }
      paramInt--;
      localStringBuffer.append(PWDCHARS_ARRAY[((int)(0x3F & paramLong))]);
      paramLong >>= 6;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\security\SimpleBase64Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */