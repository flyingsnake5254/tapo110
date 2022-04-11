package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;

public class e
  implements c
{
  protected final byte[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  protected final byte[] b = new byte[''];
  
  public e()
  {
    d();
  }
  
  private static boolean c(char paramChar)
  {
    boolean bool;
    if ((paramChar != '\n') && (paramChar != '\r') && (paramChar != '\t') && (paramChar != ' ')) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, OutputStream paramOutputStream)
    throws IOException
  {
    for (int i = paramInt1; i < paramInt1 + paramInt2; i++)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      paramOutputStream.write(this.a[(j >>> 4)]);
      paramOutputStream.write(this.a[(j & 0xF)]);
    }
    return paramInt2 * 2;
  }
  
  public int b(String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    for (int i = paramString.length(); (i > 0) && (c(paramString.charAt(i - 1))); i--) {}
    int j = 0;
    int k = 0;
    while (j < i)
    {
      while ((j < i) && (c(paramString.charAt(j)))) {
        j++;
      }
      byte[] arrayOfByte = this.b;
      int m = j + 1;
      int n = arrayOfByte[paramString.charAt(j)];
      for (j = m; (j < i) && (c(paramString.charAt(j))); j++) {}
      m = this.b[paramString.charAt(j)];
      if ((n | m) >= 0)
      {
        paramOutputStream.write(n << 4 | m);
        k++;
        j++;
      }
      else
      {
        throw new IOException("invalid characters encountered in Hex string");
      }
    }
    return k;
  }
  
  protected void d()
  {
    int i = 0;
    int k;
    for (int j = 0;; j++)
    {
      arrayOfByte = this.b;
      k = i;
      if (j >= arrayOfByte.length) {
        break;
      }
      arrayOfByte[j] = ((byte)-1);
    }
    for (;;)
    {
      arrayOfByte = this.a;
      if (k >= arrayOfByte.length) {
        break;
      }
      this.b[arrayOfByte[k]] = ((byte)(byte)k);
      k++;
    }
    byte[] arrayOfByte = this.b;
    arrayOfByte[65] = ((byte)arrayOfByte[97]);
    arrayOfByte[66] = ((byte)arrayOfByte[98]);
    arrayOfByte[67] = ((byte)arrayOfByte[99]);
    arrayOfByte[68] = ((byte)arrayOfByte[100]);
    arrayOfByte[69] = ((byte)arrayOfByte[101]);
    arrayOfByte[70] = ((byte)arrayOfByte[102]);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\encoders\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */