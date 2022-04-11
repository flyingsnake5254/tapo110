package io.netty.handler.proxy;

import java.net.ConnectException;

public class ProxyConnectException
  extends ConnectException
{
  private static final long serialVersionUID = 5211364632246265538L;
  
  public ProxyConnectException() {}
  
  public ProxyConnectException(String paramString)
  {
    super(paramString);
  }
  
  public ProxyConnectException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    initCause(paramThrowable);
  }
  
  public ProxyConnectException(Throwable paramThrowable)
  {
    initCause(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\proxy\ProxyConnectException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */