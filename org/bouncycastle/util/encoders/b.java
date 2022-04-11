package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;

public class b
  implements c
{
  protected final byte[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  protected byte b = (byte)61;
  protected final byte[] c = new byte[''];
  
  public b()
  {
    e();
  }
  
  private int c(OutputStream paramOutputStream, char paramChar1, char paramChar2, char paramChar3, char paramChar4)
    throws IOException
  {
    char c1 = this.b;
    if (paramChar3 == c1)
    {
      if (paramChar4 == c1)
      {
        arrayOfByte = this.c;
        paramChar1 = arrayOfByte[paramChar1];
        paramChar2 = arrayOfByte[paramChar2];
        if ((paramChar1 | paramChar2) >= 0)
        {
          paramOutputStream.write(paramChar1 << '\002' | paramChar2 >> '\004');
          return 1;
        }
        throw new IOException("invalid characters encountered at end of base64 data");
      }
      throw new IOException("invalid characters encountered at end of base64 data");
    }
    if (paramChar4 == c1)
    {
      arrayOfByte = this.c;
      paramChar1 = arrayOfByte[paramChar1];
      paramChar2 = arrayOfByte[paramChar2];
      paramChar3 = arrayOfByte[paramChar3];
      if ((paramChar1 | paramChar2 | paramChar3) >= 0)
      {
        paramOutputStream.write(paramChar1 << '\002' | paramChar2 >> '\004');
        paramOutputStream.write(paramChar2 << '\004' | paramChar3 >> '\002');
        return 2;
      }
      throw new IOException("invalid characters encountered at end of base64 data");
    }
    byte[] arrayOfByte = this.c;
    paramChar1 = arrayOfByte[paramChar1];
    paramChar2 = arrayOfByte[paramChar2];
    paramChar3 = arrayOfByte[paramChar3];
    paramChar4 = arrayOfByte[paramChar4];
    if ((paramChar1 | paramChar2 | paramChar3 | paramChar4) >= 0)
    {
      paramOutputStream.write(paramChar1 << '\002' | paramChar2 >> '\004');
      paramOutputStream.write(paramChar2 << '\004' | paramChar3 >> '\002');
      paramOutputStream.write(paramChar3 << '\006' | paramChar4);
      return 3;
    }
    throw new IOException("invalid characters encountered at end of base64 data");
  }
  
  private boolean d(char paramChar)
  {
    boolean bool;
    if ((paramChar != '\n') && (paramChar != '\r') && (paramChar != '\t') && (paramChar != ' ')) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private int f(String paramString, int paramInt1, int paramInt2)
  {
    while ((paramInt1 < paramInt2) && (d(paramString.charAt(paramInt1)))) {
      paramInt1++;
    }
    return paramInt1;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, OutputStream paramOutputStream)
    throws IOException
  {
    int i = paramInt2 % 3;
    int j = paramInt2 - i;
    int k;
    int m;
    for (paramInt2 = paramInt1;; paramInt2 += 3)
    {
      k = paramInt1 + j;
      m = 4;
      if (paramInt2 >= k) {
        break;
      }
      int n = paramArrayOfByte[paramInt2] & 0xFF;
      m = paramArrayOfByte[(paramInt2 + 1)] & 0xFF;
      k = paramArrayOfByte[(paramInt2 + 2)] & 0xFF;
      paramOutputStream.write(this.a[(n >>> 2 & 0x3F)]);
      paramOutputStream.write(this.a[((n << 4 | m >>> 4) & 0x3F)]);
      paramOutputStream.write(this.a[((m << 2 | k >>> 6) & 0x3F)]);
      paramOutputStream.write(this.a[(k & 0x3F)]);
    }
    if (i != 1)
    {
      if (i != 2) {
        break label289;
      }
      paramInt1 = paramArrayOfByte[k] & 0xFF;
      paramInt2 = paramArrayOfByte[(k + 1)] & 0xFF;
      paramOutputStream.write(this.a[(paramInt1 >>> 2 & 0x3F)]);
      paramOutputStream.write(this.a[((paramInt1 << 4 | paramInt2 >>> 4) & 0x3F)]);
      paramInt1 = this.a[(paramInt2 << 2 & 0x3F)];
    }
    else
    {
      paramInt1 = paramArrayOfByte[k] & 0xFF;
      paramOutputStream.write(this.a[(paramInt1 >>> 2 & 0x3F)]);
      paramOutputStream.write(this.a[(paramInt1 << 4 & 0x3F)]);
      paramInt1 = this.b;
    }
    paramOutputStream.write(paramInt1);
    paramOutputStream.write(this.b);
    label289:
    paramInt2 = j / 3;
    paramInt1 = m;
    if (i == 0) {
      paramInt1 = 0;
    }
    return paramInt2 * 4 + paramInt1;
  }
  
  public int b(String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    for (int i = paramString.length(); (i > 0) && (d(paramString.charAt(i - 1))); i--) {}
    int j = 0;
    if (i == 0) {
      return 0;
    }
    int k = i;
    for (int m = 0; (k > 0) && (m != 4); m = n)
    {
      n = m;
      if (!d(paramString.charAt(k - 1))) {
        n = m + 1;
      }
      k--;
    }
    int n = f(paramString, 0, k);
    m = j;
    while (n < k)
    {
      j = this.c[paramString.charAt(n)];
      int i1 = f(paramString, n + 1, k);
      n = this.c[paramString.charAt(i1)];
      int i2 = f(paramString, i1 + 1, k);
      i1 = this.c[paramString.charAt(i2)];
      i2 = f(paramString, i2 + 1, k);
      int i3 = this.c[paramString.charAt(i2)];
      if ((j | n | i1 | i3) >= 0)
      {
        paramOutputStream.write(j << 2 | n >> 4);
        paramOutputStream.write(n << 4 | i1 >> 2);
        paramOutputStream.write(i1 << 6 | i3);
        m += 3;
        n = f(paramString, i2 + 1, k);
      }
      else
      {
        throw new IOException("invalid characters encountered in base64 data");
      }
    }
    j = f(paramString, n, i);
    k = f(paramString, j + 1, i);
    n = f(paramString, k + 1, i);
    i = f(paramString, n + 1, i);
    return m + c(paramOutputStream, paramString.charAt(j), paramString.charAt(k), paramString.charAt(n), paramString.charAt(i));
  }
  
  protected void e()
  {
    int i = 0;
    byte[] arrayOfByte;
    int k;
    for (int j = 0;; j++)
    {
      arrayOfByte = this.c;
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
      this.c[arrayOfByte[k]] = ((byte)(byte)k);
      k++;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\encoders\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */