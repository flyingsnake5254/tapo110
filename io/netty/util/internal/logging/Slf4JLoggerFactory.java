package io.netty.util.internal.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.NOPLoggerFactory;
import org.slf4j.spi.LocationAwareLogger;

public class Slf4JLoggerFactory
  extends InternalLoggerFactory
{
  public static final InternalLoggerFactory INSTANCE = new Slf4JLoggerFactory();
  
  @Deprecated
  public Slf4JLoggerFactory() {}
  
  Slf4JLoggerFactory(boolean paramBoolean)
  {
    if (!(LoggerFactory.getILoggerFactory() instanceof NOPLoggerFactory)) {
      return;
    }
    throw new NoClassDefFoundError("NOPLoggerFactory not supported");
  }
  
  static InternalLogger wrapLogger(Logger paramLogger)
  {
    if ((paramLogger instanceof LocationAwareLogger)) {
      paramLogger = new LocationAwareSlf4JLogger((LocationAwareLogger)paramLogger);
    } else {
      paramLogger = new Slf4JLogger(paramLogger);
    }
    return paramLogger;
  }
  
  public InternalLogger newInstance(String paramString)
  {
    return wrapLogger(LoggerFactory.getLogger(paramString));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\logging\Slf4JLoggerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */