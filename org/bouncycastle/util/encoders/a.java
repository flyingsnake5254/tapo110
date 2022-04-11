package org.bouncycastle.util.encoders;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class a
{
  private static final c a = new b();
  
  public static byte[] a(String paramString)
  {
    Object localObject = new ByteArrayOutputStream(paramString.length() / 4 * 3);
    try
    {
      a.b(paramString, (OutputStream)localObject);
      return ((ByteArrayOutputStream)localObject).toByteArray();
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unable to decode base64 string: ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      throw new DecoderException(((StringBuilder)localObject).toString(), paramString);
    }
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    return c(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static byte[] c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject = new ByteArrayOutputStream((paramInt2 + 2) / 3 * 4);
    try
    {
      a.a(paramArrayOfByte, paramInt1, paramInt2, (OutputStream)localObject);
      return ((ByteArrayOutputStream)localObject).toByteArray();
    }
    catch (Exception paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("exception encoding base64 string: ");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      throw new EncoderException(((StringBuilder)localObject).toString(), paramArrayOfByte);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\encoders\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */