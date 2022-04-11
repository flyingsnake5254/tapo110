package io.netty.util.internal.logging;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

class Log4JLogger
  extends AbstractInternalLogger
{
  static final String FQCN = Log4JLogger.class.getName();
  private static final long serialVersionUID = 2851357342488183058L;
  final transient Logger logger;
  final boolean traceCapable;
  
  Log4JLogger(Logger paramLogger)
  {
    super(paramLogger.getName());
    this.logger = paramLogger;
    this.traceCapable = isTraceCapable();
  }
  
  private boolean isTraceCapable()
  {
    try
    {
      this.logger.isTraceEnabled();
      return true;
    }
    catch (NoSuchMethodError localNoSuchMethodError) {}
    return false;
  }
  
  public void debug(String paramString)
  {
    this.logger.log(FQCN, Level.DEBUG, paramString, null);
  }
  
  public void debug(String paramString, Object paramObject)
  {
    if (this.logger.isDebugEnabled())
    {
      paramString = MessageFormatter.format(paramString, paramObject);
      this.logger.log(FQCN, Level.DEBUG, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void debug(String paramString, Object paramObject1, Object paramObject2)
  {
    if (this.logger.isDebugEnabled())
    {
      paramString = MessageFormatter.format(paramString, paramObject1, paramObject2);
      this.logger.log(FQCN, Level.DEBUG, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void debug(String paramString, Throwable paramThrowable)
  {
    this.logger.log(FQCN, Level.DEBUG, paramString, paramThrowable);
  }
  
  public void debug(String paramString, Object... paramVarArgs)
  {
    if (this.logger.isDebugEnabled())
    {
      paramString = MessageFormatter.arrayFormat(paramString, paramVarArgs);
      this.logger.log(FQCN, Level.DEBUG, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void error(String paramString)
  {
    this.logger.log(FQCN, Level.ERROR, paramString, null);
  }
  
  public void error(String paramString, Object paramObject)
  {
    if (this.logger.isEnabledFor(Level.ERROR))
    {
      paramString = MessageFormatter.format(paramString, paramObject);
      this.logger.log(FQCN, Level.ERROR, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void error(String paramString, Object paramObject1, Object paramObject2)
  {
    if (this.logger.isEnabledFor(Level.ERROR))
    {
      paramString = MessageFormatter.format(paramString, paramObject1, paramObject2);
      this.logger.log(FQCN, Level.ERROR, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void error(String paramString, Throwable paramThrowable)
  {
    this.logger.log(FQCN, Level.ERROR, paramString, paramThrowable);
  }
  
  public void error(String paramString, Object... paramVarArgs)
  {
    if (this.logger.isEnabledFor(Level.ERROR))
    {
      paramString = MessageFormatter.arrayFormat(paramString, paramVarArgs);
      this.logger.log(FQCN, Level.ERROR, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void info(String paramString)
  {
    this.logger.log(FQCN, Level.INFO, paramString, null);
  }
  
  public void info(String paramString, Object paramObject)
  {
    if (this.logger.isInfoEnabled())
    {
      paramString = MessageFormatter.format(paramString, paramObject);
      this.logger.log(FQCN, Level.INFO, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void info(String paramString, Object paramObject1, Object paramObject2)
  {
    if (this.logger.isInfoEnabled())
    {
      paramString = MessageFormatter.format(paramString, paramObject1, paramObject2);
      this.logger.log(FQCN, Level.INFO, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void info(String paramString, Throwable paramThrowable)
  {
    this.logger.log(FQCN, Level.INFO, paramString, paramThrowable);
  }
  
  public void info(String paramString, Object... paramVarArgs)
  {
    if (this.logger.isInfoEnabled())
    {
      paramString = MessageFormatter.arrayFormat(paramString, paramVarArgs);
      this.logger.log(FQCN, Level.INFO, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public boolean isDebugEnabled()
  {
    return this.logger.isDebugEnabled();
  }
  
  public boolean isErrorEnabled()
  {
    return this.logger.isEnabledFor(Level.ERROR);
  }
  
  public boolean isInfoEnabled()
  {
    return this.logger.isInfoEnabled();
  }
  
  public boolean isTraceEnabled()
  {
    if (this.traceCapable) {
      return this.logger.isTraceEnabled();
    }
    return this.logger.isDebugEnabled();
  }
  
  public boolean isWarnEnabled()
  {
    return this.logger.isEnabledFor(Level.WARN);
  }
  
  public void trace(String paramString)
  {
    Logger localLogger = this.logger;
    String str = FQCN;
    Level localLevel;
    if (this.traceCapable) {
      localLevel = Level.TRACE;
    } else {
      localLevel = Level.DEBUG;
    }
    localLogger.log(str, localLevel, paramString, null);
  }
  
  public void trace(String paramString, Object paramObject)
  {
    if (isTraceEnabled())
    {
      FormattingTuple localFormattingTuple = MessageFormatter.format(paramString, paramObject);
      paramObject = this.logger;
      String str = FQCN;
      if (this.traceCapable) {
        paramString = Level.TRACE;
      } else {
        paramString = Level.DEBUG;
      }
      ((Logger)paramObject).log(str, paramString, localFormattingTuple.getMessage(), localFormattingTuple.getThrowable());
    }
  }
  
  public void trace(String paramString, Object paramObject1, Object paramObject2)
  {
    if (isTraceEnabled())
    {
      paramObject2 = MessageFormatter.format(paramString, paramObject1, paramObject2);
      paramObject1 = this.logger;
      String str = FQCN;
      if (this.traceCapable) {
        paramString = Level.TRACE;
      } else {
        paramString = Level.DEBUG;
      }
      ((Logger)paramObject1).log(str, paramString, ((FormattingTuple)paramObject2).getMessage(), ((FormattingTuple)paramObject2).getThrowable());
    }
  }
  
  public void trace(String paramString, Throwable paramThrowable)
  {
    Logger localLogger = this.logger;
    String str = FQCN;
    Level localLevel;
    if (this.traceCapable) {
      localLevel = Level.TRACE;
    } else {
      localLevel = Level.DEBUG;
    }
    localLogger.log(str, localLevel, paramString, paramThrowable);
  }
  
  public void trace(String paramString, Object... paramVarArgs)
  {
    if (isTraceEnabled())
    {
      FormattingTuple localFormattingTuple = MessageFormatter.arrayFormat(paramString, paramVarArgs);
      paramVarArgs = this.logger;
      String str = FQCN;
      if (this.traceCapable) {
        paramString = Level.TRACE;
      } else {
        paramString = Level.DEBUG;
      }
      paramVarArgs.log(str, paramString, localFormattingTuple.getMessage(), localFormattingTuple.getThrowable());
    }
  }
  
  public void warn(String paramString)
  {
    this.logger.log(FQCN, Level.WARN, paramString, null);
  }
  
  public void warn(String paramString, Object paramObject)
  {
    if (this.logger.isEnabledFor(Level.WARN))
    {
      paramString = MessageFormatter.format(paramString, paramObject);
      this.logger.log(FQCN, Level.WARN, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void warn(String paramString, Object paramObject1, Object paramObject2)
  {
    if (this.logger.isEnabledFor(Level.WARN))
    {
      paramString = MessageFormatter.format(paramString, paramObject1, paramObject2);
      this.logger.log(FQCN, Level.WARN, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void warn(String paramString, Throwable paramThrowable)
  {
    this.logger.log(FQCN, Level.WARN, paramString, paramThrowable);
  }
  
  public void warn(String paramString, Object... paramVarArgs)
  {
    if (this.logger.isEnabledFor(Level.WARN))
    {
      paramString = MessageFormatter.arrayFormat(paramString, paramVarArgs);
      this.logger.log(FQCN, Level.WARN, paramString.getMessage(), paramString.getThrowable());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\logging\Log4JLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */