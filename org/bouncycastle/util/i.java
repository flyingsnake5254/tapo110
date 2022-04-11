package org.bouncycastle.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;

public final class i
{
  private static String a;
  
  static
  {
    try
    {
      a locala = new org/bouncycastle/util/i$a;
      locala.<init>();
      a = (String)AccessController.doPrivileged(locala);
    }
    catch (Exception localException1)
    {
      try
      {
        a = String.format("%n", new Object[0]);
      }
      catch (Exception localException2)
      {
        a = "\n";
      }
    }
  }
  
  public static char[] a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    char[] arrayOfChar = new char[i];
    for (int j = 0; j != i; j++) {
      arrayOfChar[j] = ((char)(char)(paramArrayOfByte[j] & 0xFF));
    }
    return arrayOfChar;
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    return new String(a(paramArrayOfByte));
  }
  
  public static String c(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    while (j < paramArrayOfByte.length)
    {
      k++;
      if ((paramArrayOfByte[j] & 0xF0) == 240)
      {
        k++;
        j += 4;
      }
      else if ((paramArrayOfByte[j] & 0xE0) == 224)
      {
        j += 3;
      }
      else if ((paramArrayOfByte[j] & 0xC0) == 192)
      {
        j += 2;
      }
      else
      {
        j++;
      }
    }
    char[] arrayOfChar = new char[k];
    int m = 0;
    j = i;
    while (j < paramArrayOfByte.length)
    {
      if ((paramArrayOfByte[j] & 0xF0) == 240)
      {
        k = ((paramArrayOfByte[j] & 0x3) << 18 | (paramArrayOfByte[(j + 1)] & 0x3F) << 12 | (paramArrayOfByte[(j + 2)] & 0x3F) << 6 | paramArrayOfByte[(j + 3)] & 0x3F) - 65536;
        i = (char)(0xD800 | k >> 10);
        k = (char)(k & 0x3FF | 0xDC00);
        arrayOfChar[m] = ((char)i);
        j += 4;
        m++;
      }
      else if ((paramArrayOfByte[j] & 0xE0) == 224)
      {
        k = (char)((paramArrayOfByte[j] & 0xF) << 12 | (paramArrayOfByte[(j + 1)] & 0x3F) << 6 | paramArrayOfByte[(j + 2)] & 0x3F);
        j += 3;
      }
      else
      {
        if ((paramArrayOfByte[j] & 0xD0) == 208) {
          i = (paramArrayOfByte[j] & 0x1F) << 6;
        }
        for (k = paramArrayOfByte[(j + 1)];; k = paramArrayOfByte[(j + 1)])
        {
          k = (char)(i | k & 0x3F);
          j += 2;
          break label328;
          if ((paramArrayOfByte[j] & 0xC0) != 192) {
            break;
          }
          i = (paramArrayOfByte[j] & 0x1F) << 6;
        }
        k = (char)(paramArrayOfByte[j] & 0xFF);
        j++;
      }
      label328:
      arrayOfChar[m] = ((char)k);
      m++;
    }
    return new String(arrayOfChar);
  }
  
  public static String d()
  {
    return a;
  }
  
  public static byte[] e(String paramString)
  {
    int i = paramString.length();
    byte[] arrayOfByte = new byte[i];
    for (int j = 0; j != i; j++) {
      arrayOfByte[j] = ((byte)(byte)paramString.charAt(j));
    }
    return arrayOfByte;
  }
  
  public static String f(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    int m;
    for (int j = 0; i != arrayOfChar.length; j = m)
    {
      int k = arrayOfChar[i];
      m = j;
      if (65 <= k)
      {
        m = j;
        if (90 >= k)
        {
          arrayOfChar[i] = ((char)(char)(k - 65 + 97));
          m = 1;
        }
      }
      i++;
    }
    if (j != 0) {
      paramString = new String(arrayOfChar);
    }
    return paramString;
  }
  
  public static void g(char[] paramArrayOfChar, OutputStream paramOutputStream)
    throws IOException
  {
    for (int i = 0; i < paramArrayOfChar.length; i++)
    {
      int j = paramArrayOfChar[i];
      if (j >= 128) {
        if (j >= 2048) {}
      }
      for (int k = j >> 6 | 0xC0;; k = j >> 6 & 0x3F | 0x80)
      {
        paramOutputStream.write(k);
        if ((j >= 55296) && (j <= 57343))
        {
          i++;
          if (i < paramArrayOfChar.length)
          {
            k = paramArrayOfChar[i];
            if (j <= 56319)
            {
              j = ((j & 0x3FF) << 10 | k & 0x3FF) + 65536;
              paramOutputStream.write(j >> 18 | 0xF0);
              paramOutputStream.write(j >> 12 & 0x3F | 0x80);
              paramOutputStream.write(j >> 6 & 0x3F | 0x80);
              j = j & 0x3F | 0x80;
              paramOutputStream.write(j);
              break;
            }
            throw new IllegalStateException("invalid UTF-16 codepoint");
          }
          throw new IllegalStateException("invalid UTF-16 codepoint");
        }
        paramOutputStream.write(j >> 12 | 0xE0);
      }
    }
  }
  
  public static byte[] h(String paramString)
  {
    return i(paramString.toCharArray());
  }
  
  public static byte[] i(char[] paramArrayOfChar)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      g(paramArrayOfChar, localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramArrayOfChar)
    {
      throw new IllegalStateException("cannot encode string to byte array!");
    }
  }
  
  public static String j(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    int m;
    for (int j = 0; i != arrayOfChar.length; j = m)
    {
      int k = arrayOfChar[i];
      m = j;
      if (97 <= k)
      {
        m = j;
        if (122 >= k)
        {
          arrayOfChar[i] = ((char)(char)(k - 97 + 65));
          m = 1;
        }
      }
      i++;
    }
    if (j != 0) {
      paramString = new String(arrayOfChar);
    }
    return paramString;
  }
  
  static final class a
    implements PrivilegedAction<String>
  {
    public String a()
    {
      return System.getProperty("line.separator");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */