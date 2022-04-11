package io.netty.handler.codec.haproxy;

import io.netty.handler.codec.DecoderException;

public class HAProxyProtocolException
  extends DecoderException
{
  private static final long serialVersionUID = 713710864325167351L;
  
  public HAProxyProtocolException() {}
  
  public HAProxyProtocolException(String paramString)
  {
    super(paramString);
  }
  
  public HAProxyProtocolException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public HAProxyProtocolException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\haproxy\HAProxyProtocolException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */