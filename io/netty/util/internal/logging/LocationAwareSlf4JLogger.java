package io.netty.util.internal.logging;

import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.spi.LocationAwareLogger;

final class LocationAwareSlf4JLogger
  extends AbstractInternalLogger
{
  static final String FQCN = LocationAwareSlf4JLogger.class.getName();
  private static final long serialVersionUID = -8292030083201538180L;
  private final transient LocationAwareLogger logger;
  
  LocationAwareSlf4JLogger(LocationAwareLogger paramLocationAwareLogger)
  {
    super(paramLocationAwareLogger.getName());
    this.logger = paramLocationAwareLogger;
  }
  
  private void log(int paramInt, String paramString)
  {
    this.logger.log(null, FQCN, paramInt, paramString, null, null);
  }
  
  private void log(int paramInt, String paramString, Throwable paramThrowable)
  {
    this.logger.log(null, FQCN, paramInt, paramString, null, paramThrowable);
  }
  
  private void log(int paramInt, FormattingTuple paramFormattingTuple)
  {
    this.logger.log(null, FQCN, paramInt, paramFormattingTuple.getMessage(), paramFormattingTuple.getArgArray(), paramFormattingTuple.getThrowable());
  }
  
  public void debug(String paramString)
  {
    if (isDebugEnabled()) {
      log(10, paramString);
    }
  }
  
  public void debug(String paramString, Object paramObject)
  {
    if (isDebugEnabled()) {
      log(10, MessageFormatter.format(paramString, paramObject));
    }
  }
  
  public void debug(String paramString, Object paramObject1, Object paramObject2)
  {
    if (isDebugEnabled()) {
      log(10, MessageFormatter.format(paramString, paramObject1, paramObject2));
    }
  }
  
  public void debug(String paramString, Throwable paramThrowable)
  {
    if (isDebugEnabled()) {
      log(10, paramString, paramThrowable);
    }
  }
  
  public void debug(String paramString, Object... paramVarArgs)
  {
    if (isDebugEnabled()) {
      log(10, MessageFormatter.arrayFormat(paramString, paramVarArgs));
    }
  }
  
  public void error(String paramString)
  {
    if (isErrorEnabled()) {
      log(40, paramString);
    }
  }
  
  public void error(String paramString, Object paramObject)
  {
    if (isErrorEnabled()) {
      log(40, MessageFormatter.format(paramString, paramObject));
    }
  }
  
  public void error(String paramString, Object paramObject1, Object paramObject2)
  {
    if (isErrorEnabled()) {
      log(40, MessageFormatter.format(paramString, paramObject1, paramObject2));
    }
  }
  
  public void error(String paramString, Throwable paramThrowable)
  {
    if (isErrorEnabled()) {
      log(40, paramString, paramThrowable);
    }
  }
  
  public void error(String paramString, Object... paramVarArgs)
  {
    if (isErrorEnabled()) {
      log(40, MessageFormatter.arrayFormat(paramString, paramVarArgs));
    }
  }
  
  public void info(String paramString)
  {
    if (isInfoEnabled()) {
      log(20, paramString);
    }
  }
  
  public void info(String paramString, Object paramObject)
  {
    if (isInfoEnabled()) {
      log(20, MessageFormatter.format(paramString, paramObject));
    }
  }
  
  public void info(String paramString, Object paramObject1, Object paramObject2)
  {
    if (isInfoEnabled()) {
      log(20, MessageFormatter.format(paramString, paramObject1, paramObject2));
    }
  }
  
  public void info(String paramString, Throwable paramThrowable)
  {
    if (isInfoEnabled()) {
      log(20, paramString, paramThrowable);
    }
  }
  
  public void info(String paramString, Object... paramVarArgs)
  {
    if (isInfoEnabled()) {
      log(20, MessageFormatter.arrayFormat(paramString, paramVarArgs));
    }
  }
  
  public boolean isDebugEnabled()
  {
    return this.logger.isDebugEnabled();
  }
  
  public boolean isErrorEnabled()
  {
    return this.logger.isErrorEnabled();
  }
  
  public boolean isInfoEnabled()
  {
    return this.logger.isInfoEnabled();
  }
  
  public boolean isTraceEnabled()
  {
    return this.logger.isTraceEnabled();
  }
  
  public boolean isWarnEnabled()
  {
    return this.logger.isWarnEnabled();
  }
  
  public void trace(String paramString)
  {
    if (isTraceEnabled()) {
      log(0, paramString);
    }
  }
  
  public void trace(String paramString, Object paramObject)
  {
    if (isTraceEnabled()) {
      log(0, MessageFormatter.format(paramString, paramObject));
    }
  }
  
  public void trace(String paramString, Object paramObject1, Object paramObject2)
  {
    if (isTraceEnabled()) {
      log(0, MessageFormatter.format(paramString, paramObject1, paramObject2));
    }
  }
  
  public void trace(String paramString, Throwable paramThrowable)
  {
    if (isTraceEnabled()) {
      log(0, paramString, paramThrowable);
    }
  }
  
  public void trace(String paramString, Object... paramVarArgs)
  {
    if (isTraceEnabled()) {
      log(0, MessageFormatter.arrayFormat(paramString, paramVarArgs));
    }
  }
  
  public void warn(String paramString)
  {
    if (isWarnEnabled()) {
      log(30, paramString);
    }
  }
  
  public void warn(String paramString, Object paramObject)
  {
    if (isWarnEnabled()) {
      log(30, MessageFormatter.format(paramString, paramObject));
    }
  }
  
  public void warn(String paramString, Object paramObject1, Object paramObject2)
  {
    if (isWarnEnabled()) {
      log(30, MessageFormatter.format(paramString, paramObject1, paramObject2));
    }
  }
  
  public void warn(String paramString, Throwable paramThrowable)
  {
    if (isWarnEnabled()) {
      log(30, paramString, paramThrowable);
    }
  }
  
  public void warn(String paramString, Object... paramVarArgs)
  {
    if (isWarnEnabled()) {
      log(30, MessageFormatter.arrayFormat(paramString, paramVarArgs));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\logging\LocationAwareSlf4JLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */