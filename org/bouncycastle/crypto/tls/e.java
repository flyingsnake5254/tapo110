package org.bouncycastle.crypto.tls;

import java.io.IOException;

public abstract class e
  implements f1
{
  public void k(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {
      return;
    }
    throw new TlsFatalAlert((short)40);
  }
  
  public void n(short paramShort1, short paramShort2, String paramString, Throwable paramThrowable) {}
  
  public void p(short paramShort1, short paramShort2) {}
  
  public void t()
    throws IOException
  {}
  
  public boolean w()
  {
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */