package io.netty.channel;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;

public class ChannelException
  extends RuntimeException
{
  private static final long serialVersionUID = 2908618315971075004L;
  
  public ChannelException() {}
  
  public ChannelException(String paramString)
  {
    super(paramString);
  }
  
  public ChannelException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  @SuppressJava6Requirement(reason="uses Java 7+ RuntimeException.<init>(String, Throwable, boolean, boolean) but is guarded by version checks")
  protected ChannelException(String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    super(paramString, paramThrowable, false, true);
  }
  
  public ChannelException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  static ChannelException newStatic(String paramString, Throwable paramThrowable)
  {
    if (PlatformDependent.javaVersion() >= 7) {
      return new ChannelException(paramString, paramThrowable, true);
    }
    return new ChannelException(paramString, paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ChannelException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */