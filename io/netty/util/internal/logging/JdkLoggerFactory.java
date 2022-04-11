package io.netty.util.internal.logging;

import java.util.logging.Logger;

public class JdkLoggerFactory
  extends InternalLoggerFactory
{
  public static final InternalLoggerFactory INSTANCE = new JdkLoggerFactory();
  
  public InternalLogger newInstance(String paramString)
  {
    return new JdkLogger(Logger.getLogger(paramString));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\logging\JdkLoggerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */