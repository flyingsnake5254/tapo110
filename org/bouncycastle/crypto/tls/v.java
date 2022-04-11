package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;

public class v
{
  protected long a;
  protected byte[] b;
  
  public v(long paramLong, byte[] paramArrayOfByte)
  {
    this.a = paramLong;
    this.b = paramArrayOfByte;
  }
  
  public static v a(InputStream paramInputStream)
    throws IOException
  {
    return new v(m1.i0(paramInputStream), m1.a0(paramInputStream));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */