package io.netty.handler.timeout;

import io.netty.util.internal.PlatformDependent;

public final class WriteTimeoutException
  extends TimeoutException
{
  public static final WriteTimeoutException INSTANCE;
  private static final long serialVersionUID = -144786655770296065L;
  
  static
  {
    WriteTimeoutException localWriteTimeoutException;
    if (PlatformDependent.javaVersion() >= 7) {
      localWriteTimeoutException = new WriteTimeoutException(true);
    } else {
      localWriteTimeoutException = new WriteTimeoutException();
    }
    INSTANCE = localWriteTimeoutException;
  }
  
  private WriteTimeoutException() {}
  
  private WriteTimeoutException(boolean paramBoolean)
  {
    super(paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\timeout\WriteTimeoutException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */