package io.netty.util.internal.logging;

import org.slf4j.Logger;

final class Slf4JLogger
  extends AbstractInternalLogger
{
  private static final long serialVersionUID = 108038972685130825L;
  private final transient Logger logger;
  
  Slf4JLogger(Logger paramLogger)
  {
    super(paramLogger.getName());
    this.logger = paramLogger;
  }
  
  public void debug(String paramString)
  {
    this.logger.debug(paramString);
  }
  
  public void debug(String paramString, Object paramObject)
  {
    this.logger.debug(paramString, paramObject);
  }
  
  public void debug(String paramString, Object paramObject1, Object paramObject2)
  {
    this.logger.debug(paramString, paramObject1, paramObject2);
  }
  
  public void debug(String paramString, Throwable paramThrowable)
  {
    this.logger.debug(paramString, paramThrowable);
  }
  
  public void debug(String paramString, Object... paramVarArgs)
  {
    this.logger.debug(paramString, paramVarArgs);
  }
  
  public void error(String paramString)
  {
    this.logger.error(paramString);
  }
  
  public void error(String paramString, Object paramObject)
  {
    this.logger.error(paramString, paramObject);
  }
  
  public void error(String paramString, Object paramObject1, Object paramObject2)
  {
    this.logger.error(paramString, paramObject1, paramObject2);
  }
  
  public void error(String paramString, Throwable paramThrowable)
  {
    this.logger.error(paramString, paramThrowable);
  }
  
  public void error(String paramString, Object... paramVarArgs)
  {
    this.logger.error(paramString, paramVarArgs);
  }
  
  public void info(String paramString)
  {
    this.logger.info(paramString);
  }
  
  public void info(String paramString, Object paramObject)
  {
    this.logger.info(paramString, paramObject);
  }
  
  public void info(String paramString, Object paramObject1, Object paramObject2)
  {
    this.logger.info(paramString, paramObject1, paramObject2);
  }
  
  public void info(String paramString, Throwable paramThrowable)
  {
    this.logger.info(paramString, paramThrowable);
  }
  
  public void info(String paramString, Object... paramVarArgs)
  {
    this.logger.info(paramString, paramVarArgs);
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
    this.logger.trace(paramString);
  }
  
  public void trace(String paramString, Object paramObject)
  {
    this.logger.trace(paramString, paramObject);
  }
  
  public void trace(String paramString, Object paramObject1, Object paramObject2)
  {
    this.logger.trace(paramString, paramObject1, paramObject2);
  }
  
  public void trace(String paramString, Throwable paramThrowable)
  {
    this.logger.trace(paramString, paramThrowable);
  }
  
  public void trace(String paramString, Object... paramVarArgs)
  {
    this.logger.trace(paramString, paramVarArgs);
  }
  
  public void warn(String paramString)
  {
    this.logger.warn(paramString);
  }
  
  public void warn(String paramString, Object paramObject)
  {
    this.logger.warn(paramString, paramObject);
  }
  
  public void warn(String paramString, Object paramObject1, Object paramObject2)
  {
    this.logger.warn(paramString, paramObject1, paramObject2);
  }
  
  public void warn(String paramString, Throwable paramThrowable)
  {
    this.logger.warn(paramString, paramThrowable);
  }
  
  public void warn(String paramString, Object... paramVarArgs)
  {
    this.logger.warn(paramString, paramVarArgs);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\logging\Slf4JLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */