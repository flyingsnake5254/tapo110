package org.bouncycastle.crypto.tls;

public class TlsFatalAlertReceived
  extends TlsException
{
  protected short alertDescription;
  
  public TlsFatalAlertReceived(short paramShort)
  {
    super(f.b(paramShort), null);
    this.alertDescription = paramShort;
  }
  
  public short getAlertDescription()
  {
    return this.alertDescription;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\TlsFatalAlertReceived.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */