package org.bouncycastle.crypto.tls;

import java.io.EOFException;

public class TlsNoCloseNotifyException
  extends EOFException
{
  public TlsNoCloseNotifyException()
  {
    super("No close_notify alert received before connection closed");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\TlsNoCloseNotifyException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */