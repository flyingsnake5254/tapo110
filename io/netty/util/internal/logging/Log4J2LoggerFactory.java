package io.netty.util.internal.logging;

import org.apache.logging.log4j.LogManager;

public final class Log4J2LoggerFactory
  extends InternalLoggerFactory
{
  public static final InternalLoggerFactory INSTANCE = new Log4J2LoggerFactory();
  
  public InternalLogger newInstance(String paramString)
  {
    return new Log4J2Logger(LogManager.getLogger(paramString));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\logging\Log4J2LoggerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */