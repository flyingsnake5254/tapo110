package io.netty.handler.codec.spdy;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;

public class SpdyProtocolException
  extends Exception
{
  private static final long serialVersionUID = 7870000537743847264L;
  
  public SpdyProtocolException() {}
  
  public SpdyProtocolException(String paramString)
  {
    super(paramString);
  }
  
  public SpdyProtocolException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  @SuppressJava6Requirement(reason="uses Java 7+ Exception.<init>(String, Throwable, boolean, boolean) but is guarded by version checks")
  private SpdyProtocolException(String paramString, boolean paramBoolean)
  {
    super(paramString, null, false, true);
  }
  
  public SpdyProtocolException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  static SpdyProtocolException newStatic(String paramString)
  {
    if (PlatformDependent.javaVersion() >= 7) {
      return new SpdyProtocolException(paramString, true);
    }
    return new SpdyProtocolException(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyProtocolException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */