package org.bouncycastle.crypto.tls;

public class TlsFatalAlert
  extends TlsException
{
  protected short alertDescription;
  
  public TlsFatalAlert(short paramShort)
  {
    this(paramShort, null);
  }
  
  public TlsFatalAlert(short paramShort, Throwable paramThrowable)
  {
    super(f.b(paramShort), paramThrowable);
    this.alertDescription = paramShort;
  }
  
  public short getAlertDescription()
  {
    return this.alertDescription;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\TlsFatalAlert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */