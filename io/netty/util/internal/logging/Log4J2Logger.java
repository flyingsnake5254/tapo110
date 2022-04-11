package io.netty.util.internal.logging;

import java.security.AccessController;
import java.security.PrivilegedAction;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.ExtendedLogger;
import org.apache.logging.log4j.spi.ExtendedLoggerWrapper;

class Log4J2Logger
  extends ExtendedLoggerWrapper
  implements InternalLogger
{
  private static final boolean VARARGS_ONLY = ((Boolean)AccessController.doPrivileged(new PrivilegedAction()
  {
    public Boolean run()
    {
      try
      {
        Logger.class.getMethod("debug", new Class[] { String.class, Object.class });
        Boolean localBoolean = Boolean.FALSE;
        return localBoolean;
      }
      catch (SecurityException localSecurityException)
      {
        return Boolean.FALSE;
      }
      catch (NoSuchMethodException localNoSuchMethodException) {}
      return Boolean.TRUE;
    }
  })).booleanValue();
  private static final long serialVersionUID = 5485418394879791397L;
  
  Log4J2Logger(Logger paramLogger)
  {
    super((ExtendedLogger)paramLogger, paramLogger.getName(), paramLogger.getMessageFactory());
    if (!VARARGS_ONLY) {
      return;
    }
    throw new UnsupportedOperationException("Log4J2 version mismatch");
  }
  
  private static Level toLevel(InternalLogLevel paramInternalLogLevel)
  {
    int i = 2.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[paramInternalLogLevel.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5) {
              return Level.TRACE;
            }
            throw new Error();
          }
          return Level.ERROR;
        }
        return Level.WARN;
      }
      return Level.DEBUG;
    }
    return Level.INFO;
  }
  
  public void debug(Throwable paramThrowable)
  {
    log(Level.DEBUG, "Unexpected exception:", paramThrowable);
  }
  
  public void error(Throwable paramThrowable)
  {
    log(Level.ERROR, "Unexpected exception:", paramThrowable);
  }
  
  public void info(Throwable paramThrowable)
  {
    log(Level.INFO, "Unexpected exception:", paramThrowable);
  }
  
  public boolean isEnabled(InternalLogLevel paramInternalLogLevel)
  {
    return isEnabled(toLevel(paramInternalLogLevel));
  }
  
  public void log(InternalLogLevel paramInternalLogLevel, String paramString)
  {
    log(toLevel(paramInternalLogLevel), paramString);
  }
  
  public void log(InternalLogLevel paramInternalLogLevel, String paramString, Object paramObject)
  {
    log(toLevel(paramInternalLogLevel), paramString, paramObject);
  }
  
  public void log(InternalLogLevel paramInternalLogLevel, String paramString, Object paramObject1, Object paramObject2)
  {
    log(toLevel(paramInternalLogLevel), paramString, paramObject1, paramObject2);
  }
  
  public void log(InternalLogLevel paramInternalLogLevel, String paramString, Throwable paramThrowable)
  {
    log(toLevel(paramInternalLogLevel), paramString, paramThrowable);
  }
  
  public void log(InternalLogLevel paramInternalLogLevel, String paramString, Object... paramVarArgs)
  {
    log(toLevel(paramInternalLogLevel), paramString, paramVarArgs);
  }
  
  public void log(InternalLogLevel paramInternalLogLevel, Throwable paramThrowable)
  {
    log(toLevel(paramInternalLogLevel), "Unexpected exception:", paramThrowable);
  }
  
  public String name()
  {
    return getName();
  }
  
  public void trace(Throwable paramThrowable)
  {
    log(Level.TRACE, "Unexpected exception:", paramThrowable);
  }
  
  public void warn(Throwable paramThrowable)
  {
    log(Level.WARN, "Unexpected exception:", paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\logging\Log4J2Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */