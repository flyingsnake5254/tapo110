package io.netty.util.internal.logging;

import io.netty.util.internal.ObjectUtil;
import org.apache.commons.logging.Log;

@Deprecated
class CommonsLogger
  extends AbstractInternalLogger
{
  private static final long serialVersionUID = 8647838678388394885L;
  private final transient Log logger;
  
  CommonsLogger(Log paramLog, String paramString)
  {
    super(paramString);
    this.logger = ((Log)ObjectUtil.checkNotNull(paramLog, "logger"));
  }
  
  public void debug(String paramString)
  {
    this.logger.debug(paramString);
  }
  
  public void debug(String paramString, Object paramObject)
  {
    if (this.logger.isDebugEnabled())
    {
      paramString = MessageFormatter.format(paramString, paramObject);
      this.logger.debug(paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void debug(String paramString, Object paramObject1, Object paramObject2)
  {
    if (this.logger.isDebugEnabled())
    {
      paramString = MessageFormatter.format(paramString, paramObject1, paramObject2);
      this.logger.debug(paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void debug(String paramString, Throwable paramThrowable)
  {
    this.logger.debug(paramString, paramThrowable);
  }
  
  public void debug(String paramString, Object... paramVarArgs)
  {
    if (this.logger.isDebugEnabled())
    {
      paramString = MessageFormatter.arrayFormat(paramString, paramVarArgs);
      this.logger.debug(paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void error(String paramString)
  {
    this.logger.error(paramString);
  }
  
  public void error(String paramString, Object paramObject)
  {
    if (this.logger.isErrorEnabled())
    {
      paramString = MessageFormatter.format(paramString, paramObject);
      this.logger.error(paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void error(String paramString, Object paramObject1, Object paramObject2)
  {
    if (this.logger.isErrorEnabled())
    {
      paramString = MessageFormatter.format(paramString, paramObject1, paramObject2);
      this.logger.error(paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void error(String paramString, Throwable paramThrowable)
  {
    this.logger.error(paramString, paramThrowable);
  }
  
  public void error(String paramString, Object... paramVarArgs)
  {
    if (this.logger.isErrorEnabled())
    {
      paramString = MessageFormatter.arrayFormat(paramString, paramVarArgs);
      this.logger.error(paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void info(String paramString)
  {
    this.logger.info(paramString);
  }
  
  public void info(String paramString, Object paramObject)
  {
    if (this.logger.isInfoEnabled())
    {
      paramString = MessageFormatter.format(paramString, paramObject);
      this.logger.info(paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void info(String paramString, Object paramObject1, Object paramObject2)
  {
    if (this.logger.isInfoEnabled())
    {
      paramString = MessageFormatter.format(paramString, paramObject1, paramObject2);
      this.logger.info(paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void info(String paramString, Throwable paramThrowable)
  {
    this.logger.info(paramString, paramThrowable);
  }
  
  public void info(String paramString, Object... paramVarArgs)
  {
    if (this.logger.isInfoEnabled())
    {
      paramString = MessageFormatter.arrayFormat(paramString, paramVarArgs);
      this.logger.info(paramString.getMessage(), paramString.getThrowable());
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
    this.logger.trace(paramString);
  }
  
  public void trace(String paramString, Object paramObject)
  {
    if (this.logger.isTraceEnabled())
    {
      paramString = MessageFormatter.format(paramString, paramObject);
      this.logger.trace(paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void trace(String paramString, Object paramObject1, Object paramObject2)
  {
    if (this.logger.isTraceEnabled())
    {
      paramString = MessageFormatter.format(paramString, paramObject1, paramObject2);
      this.logger.trace(paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void trace(String paramString, Throwable paramThrowable)
  {
    this.logger.trace(paramString, paramThrowable);
  }
  
  public void trace(String paramString, Object... paramVarArgs)
  {
    if (this.logger.isTraceEnabled())
    {
      paramString = MessageFormatter.arrayFormat(paramString, paramVarArgs);
      this.logger.trace(paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void warn(String paramString)
  {
    this.logger.warn(paramString);
  }
  
  public void warn(String paramString, Object paramObject)
  {
    if (this.logger.isWarnEnabled())
    {
      paramString = MessageFormatter.format(paramString, paramObject);
      this.logger.warn(paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void warn(String paramString, Object paramObject1, Object paramObject2)
  {
    if (this.logger.isWarnEnabled())
    {
      paramString = MessageFormatter.format(paramString, paramObject1, paramObject2);
      this.logger.warn(paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void warn(String paramString, Throwable paramThrowable)
  {
    this.logger.warn(paramString, paramThrowable);
  }
  
  public void warn(String paramString, Object... paramVarArgs)
  {
    if (this.logger.isWarnEnabled())
    {
      paramString = MessageFormatter.arrayFormat(paramString, paramVarArgs);
      this.logger.warn(paramString.getMessage(), paramString.getThrowable());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\logging\CommonsLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */