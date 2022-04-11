package io.netty.util.internal.logging;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

class JdkLogger
  extends AbstractInternalLogger
{
  static final String SELF = JdkLogger.class.getName();
  static final String SUPER = AbstractInternalLogger.class.getName();
  private static final long serialVersionUID = -1767272577989225979L;
  final transient Logger logger;
  
  JdkLogger(Logger paramLogger)
  {
    super(paramLogger.getName());
    this.logger = paramLogger;
  }
  
  private static void fillCallerData(String paramString, LogRecord paramLogRecord)
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    String str;
    for (int i = 0; i < arrayOfStackTraceElement.length; i++)
    {
      str = arrayOfStackTraceElement[i].getClassName();
      j = i;
      if (str.equals(paramString)) {
        break label65;
      }
      if (str.equals(SUPER))
      {
        j = i;
        break label65;
      }
    }
    int j = -1;
    label65:
    do
    {
      do
      {
        i = j + 1;
        if (i >= arrayOfStackTraceElement.length) {
          break;
        }
        str = arrayOfStackTraceElement[i].getClassName();
        j = i;
      } while (str.equals(paramString));
      j = i;
    } while (str.equals(SUPER));
    break label115;
    i = -1;
    label115:
    if (i != -1)
    {
      paramString = arrayOfStackTraceElement[i];
      paramLogRecord.setSourceClassName(paramString.getClassName());
      paramLogRecord.setSourceMethodName(paramString.getMethodName());
    }
  }
  
  private void log(String paramString1, Level paramLevel, String paramString2, Throwable paramThrowable)
  {
    paramLevel = new LogRecord(paramLevel, paramString2);
    paramLevel.setLoggerName(name());
    paramLevel.setThrown(paramThrowable);
    fillCallerData(paramString1, paramLevel);
    this.logger.log(paramLevel);
  }
  
  public void debug(String paramString)
  {
    Logger localLogger = this.logger;
    Level localLevel = Level.FINE;
    if (localLogger.isLoggable(localLevel)) {
      log(SELF, localLevel, paramString, null);
    }
  }
  
  public void debug(String paramString, Object paramObject)
  {
    Logger localLogger = this.logger;
    Level localLevel = Level.FINE;
    if (localLogger.isLoggable(localLevel))
    {
      paramString = MessageFormatter.format(paramString, paramObject);
      log(SELF, localLevel, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void debug(String paramString, Object paramObject1, Object paramObject2)
  {
    Logger localLogger = this.logger;
    Level localLevel = Level.FINE;
    if (localLogger.isLoggable(localLevel))
    {
      paramString = MessageFormatter.format(paramString, paramObject1, paramObject2);
      log(SELF, localLevel, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void debug(String paramString, Throwable paramThrowable)
  {
    Logger localLogger = this.logger;
    Level localLevel = Level.FINE;
    if (localLogger.isLoggable(localLevel)) {
      log(SELF, localLevel, paramString, paramThrowable);
    }
  }
  
  public void debug(String paramString, Object... paramVarArgs)
  {
    Logger localLogger = this.logger;
    Level localLevel = Level.FINE;
    if (localLogger.isLoggable(localLevel))
    {
      paramString = MessageFormatter.arrayFormat(paramString, paramVarArgs);
      log(SELF, localLevel, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void error(String paramString)
  {
    Logger localLogger = this.logger;
    Level localLevel = Level.SEVERE;
    if (localLogger.isLoggable(localLevel)) {
      log(SELF, localLevel, paramString, null);
    }
  }
  
  public void error(String paramString, Object paramObject)
  {
    Logger localLogger = this.logger;
    Level localLevel = Level.SEVERE;
    if (localLogger.isLoggable(localLevel))
    {
      paramString = MessageFormatter.format(paramString, paramObject);
      log(SELF, localLevel, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void error(String paramString, Object paramObject1, Object paramObject2)
  {
    Logger localLogger = this.logger;
    Level localLevel = Level.SEVERE;
    if (localLogger.isLoggable(localLevel))
    {
      paramString = MessageFormatter.format(paramString, paramObject1, paramObject2);
      log(SELF, localLevel, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void error(String paramString, Throwable paramThrowable)
  {
    Logger localLogger = this.logger;
    Level localLevel = Level.SEVERE;
    if (localLogger.isLoggable(localLevel)) {
      log(SELF, localLevel, paramString, paramThrowable);
    }
  }
  
  public void error(String paramString, Object... paramVarArgs)
  {
    Logger localLogger = this.logger;
    Level localLevel = Level.SEVERE;
    if (localLogger.isLoggable(localLevel))
    {
      paramString = MessageFormatter.arrayFormat(paramString, paramVarArgs);
      log(SELF, localLevel, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void info(String paramString)
  {
    if (this.logger.isLoggable(Level.INFO)) {
      log(SELF, Level.INFO, paramString, null);
    }
  }
  
  public void info(String paramString, Object paramObject)
  {
    if (this.logger.isLoggable(Level.INFO))
    {
      paramString = MessageFormatter.format(paramString, paramObject);
      log(SELF, Level.INFO, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void info(String paramString, Object paramObject1, Object paramObject2)
  {
    if (this.logger.isLoggable(Level.INFO))
    {
      paramString = MessageFormatter.format(paramString, paramObject1, paramObject2);
      log(SELF, Level.INFO, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void info(String paramString, Throwable paramThrowable)
  {
    if (this.logger.isLoggable(Level.INFO)) {
      log(SELF, Level.INFO, paramString, paramThrowable);
    }
  }
  
  public void info(String paramString, Object... paramVarArgs)
  {
    if (this.logger.isLoggable(Level.INFO))
    {
      paramString = MessageFormatter.arrayFormat(paramString, paramVarArgs);
      log(SELF, Level.INFO, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public boolean isDebugEnabled()
  {
    return this.logger.isLoggable(Level.FINE);
  }
  
  public boolean isErrorEnabled()
  {
    return this.logger.isLoggable(Level.SEVERE);
  }
  
  public boolean isInfoEnabled()
  {
    return this.logger.isLoggable(Level.INFO);
  }
  
  public boolean isTraceEnabled()
  {
    return this.logger.isLoggable(Level.FINEST);
  }
  
  public boolean isWarnEnabled()
  {
    return this.logger.isLoggable(Level.WARNING);
  }
  
  public void trace(String paramString)
  {
    Logger localLogger = this.logger;
    Level localLevel = Level.FINEST;
    if (localLogger.isLoggable(localLevel)) {
      log(SELF, localLevel, paramString, null);
    }
  }
  
  public void trace(String paramString, Object paramObject)
  {
    Logger localLogger = this.logger;
    Level localLevel = Level.FINEST;
    if (localLogger.isLoggable(localLevel))
    {
      paramString = MessageFormatter.format(paramString, paramObject);
      log(SELF, localLevel, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void trace(String paramString, Object paramObject1, Object paramObject2)
  {
    Logger localLogger = this.logger;
    Level localLevel = Level.FINEST;
    if (localLogger.isLoggable(localLevel))
    {
      paramString = MessageFormatter.format(paramString, paramObject1, paramObject2);
      log(SELF, localLevel, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void trace(String paramString, Throwable paramThrowable)
  {
    Logger localLogger = this.logger;
    Level localLevel = Level.FINEST;
    if (localLogger.isLoggable(localLevel)) {
      log(SELF, localLevel, paramString, paramThrowable);
    }
  }
  
  public void trace(String paramString, Object... paramVarArgs)
  {
    Logger localLogger = this.logger;
    Level localLevel = Level.FINEST;
    if (localLogger.isLoggable(localLevel))
    {
      paramString = MessageFormatter.arrayFormat(paramString, paramVarArgs);
      log(SELF, localLevel, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void warn(String paramString)
  {
    Logger localLogger = this.logger;
    Level localLevel = Level.WARNING;
    if (localLogger.isLoggable(localLevel)) {
      log(SELF, localLevel, paramString, null);
    }
  }
  
  public void warn(String paramString, Object paramObject)
  {
    Logger localLogger = this.logger;
    Level localLevel = Level.WARNING;
    if (localLogger.isLoggable(localLevel))
    {
      paramString = MessageFormatter.format(paramString, paramObject);
      log(SELF, localLevel, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void warn(String paramString, Object paramObject1, Object paramObject2)
  {
    Logger localLogger = this.logger;
    Level localLevel = Level.WARNING;
    if (localLogger.isLoggable(localLevel))
    {
      paramString = MessageFormatter.format(paramString, paramObject1, paramObject2);
      log(SELF, localLevel, paramString.getMessage(), paramString.getThrowable());
    }
  }
  
  public void warn(String paramString, Throwable paramThrowable)
  {
    Logger localLogger = this.logger;
    Level localLevel = Level.WARNING;
    if (localLogger.isLoggable(localLevel)) {
      log(SELF, localLevel, paramString, paramThrowable);
    }
  }
  
  public void warn(String paramString, Object... paramVarArgs)
  {
    Logger localLogger = this.logger;
    Level localLevel = Level.WARNING;
    if (localLogger.isLoggable(localLevel))
    {
      paramString = MessageFormatter.arrayFormat(paramString, paramVarArgs);
      log(SELF, localLevel, paramString.getMessage(), paramString.getThrowable());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\logging\JdkLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */