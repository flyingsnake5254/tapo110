package io.netty.handler.timeout;

import io.netty.util.internal.PlatformDependent;

public final class ReadTimeoutException
  extends TimeoutException
{
  public static final ReadTimeoutException INSTANCE;
  private static final long serialVersionUID = 169287984113283421L;
  
  static
  {
    ReadTimeoutException localReadTimeoutException;
    if (PlatformDependent.javaVersion() >= 7) {
      localReadTimeoutException = new ReadTimeoutException(true);
    } else {
      localReadTimeoutException = new ReadTimeoutException();
    }
    INSTANCE = localReadTimeoutException;
  }
  
  ReadTimeoutException() {}
  
  private ReadTimeoutException(boolean paramBoolean)
  {
    super(paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\timeout\ReadTimeoutException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */