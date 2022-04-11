package org.bouncycastle.util.encoders;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.bouncycastle.util.i;

public class d
{
  private static final c a = new e();
  
  public static byte[] a(String paramString)
  {
    Object localObject = new ByteArrayOutputStream();
    try
    {
      a.b(paramString, (OutputStream)localObject);
      return ((ByteArrayOutputStream)localObject).toByteArray();
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("exception decoding Hex string: ");
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
    Object localObject = new ByteArrayOutputStream();
    try
    {
      a.a(paramArrayOfByte, paramInt1, paramInt2, (OutputStream)localObject);
      return ((ByteArrayOutputStream)localObject).toByteArray();
    }
    catch (Exception paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("exception encoding Hex string: ");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      throw new EncoderException(((StringBuilder)localObject).toString(), paramArrayOfByte);
    }
  }
  
  public static String d(byte[] paramArrayOfByte)
  {
    return e(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static String e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return i.b(c(paramArrayOfByte, paramInt1, paramInt2));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\encoders\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */