package io.netty.util.internal.logging;

import org.apache.log4j.Logger;

public class Log4JLoggerFactory
  extends InternalLoggerFactory
{
  public static final InternalLoggerFactory INSTANCE = new Log4JLoggerFactory();
  
  public InternalLogger newInstance(String paramString)
  {
    return new Log4JLogger(Logger.getLogger(paramString));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\logging\Log4JLoggerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */