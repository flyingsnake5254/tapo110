package org.bouncycastle.util.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class b
{
  private static int a = 4096;
  
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    int i = a;
    byte[] arrayOfByte = new byte[i];
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte, 0, i);
      if (j < 0) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, j);
    }
  }
  
  public static byte[] b(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static int c(InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    return d(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int d(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = 0;
    while (i < paramInt2)
    {
      int j = paramInputStream.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
      if (j < 0) {
        break;
      }
      i += j;
    }
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\io\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */