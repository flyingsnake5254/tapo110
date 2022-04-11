package io.netty.handler.ssl;

import javax.net.ssl.SSLException;

public class NotSslRecordException
  extends SSLException
{
  private static final long serialVersionUID = -4316784434770656841L;
  
  public NotSslRecordException()
  {
    super("");
  }
  
  public NotSslRecordException(String paramString)
  {
    super(paramString);
  }
  
  public NotSslRecordException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public NotSslRecordException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\NotSslRecordException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */