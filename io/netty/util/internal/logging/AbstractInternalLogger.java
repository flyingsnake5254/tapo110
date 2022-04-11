package io.netty.util.internal.logging;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.io.ObjectStreamException;
import java.io.Serializable;

public abstract class AbstractInternalLogger
  implements InternalLogger, Serializable
{
  static final String EXCEPTION_MESSAGE = "Unexpected exception:";
  private static final long serialVersionUID = -6382972526573193470L;
  private final String name;
  
  protected AbstractInternalLogger(String paramString)
  {
    this.name = ((String)ObjectUtil.checkNotNull(paramString, "name"));
  }
  
  public void debug(Throwable paramThrowable)
  {
    debug("Unexpected exception:", paramThrowable);
  }
  
  public void error(Throwable paramThrowable)
  {
    error("Unexpected exception:", paramThrowable);
  }
  
  public void info(Throwable paramThrowable)
  {
    info("Unexpected exception:", paramThrowable);
  }
  
  public boolean isEnabled(InternalLogLevel paramInternalLogLevel)
  {
    int i = 1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[paramInternalLogLevel.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5) {
              return isErrorEnabled();
            }
            throw new Error();
          }
          return isWarnEnabled();
        }
        return isInfoEnabled();
      }
      return isDebugEnabled();
    }
    return isTraceEnabled();
  }
  
  public void log(InternalLogLevel paramInternalLogLevel, String paramString)
  {
    int i = 1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[paramInternalLogLevel.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5) {
              error(paramString);
            } else {
              throw new Error();
            }
          }
          else {
            warn(paramString);
          }
        }
        else {
          info(paramString);
        }
      }
      else {
        debug(paramString);
      }
    }
    else {
      trace(paramString);
    }
  }
  
  public void log(InternalLogLevel paramInternalLogLevel, String paramString, Object paramObject)
  {
    int i = 1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[paramInternalLogLevel.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5) {
              error(paramString, paramObject);
            } else {
              throw new Error();
            }
          }
          else {
            warn(paramString, paramObject);
          }
        }
        else {
          info(paramString, paramObject);
        }
      }
      else {
        debug(paramString, paramObject);
      }
    }
    else {
      trace(paramString, paramObject);
    }
  }
  
  public void log(InternalLogLevel paramInternalLogLevel, String paramString, Object paramObject1, Object paramObject2)
  {
    int i = 1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[paramInternalLogLevel.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5) {
              error(paramString, paramObject1, paramObject2);
            } else {
              throw new Error();
            }
          }
          else {
            warn(paramString, paramObject1, paramObject2);
          }
        }
        else {
          info(paramString, paramObject1, paramObject2);
        }
      }
      else {
        debug(paramString, paramObject1, paramObject2);
      }
    }
    else {
      trace(paramString, paramObject1, paramObject2);
    }
  }
  
  public void log(InternalLogLevel paramInternalLogLevel, String paramString, Throwable paramThrowable)
  {
    int i = 1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[paramInternalLogLevel.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5) {
              error(paramString, paramThrowable);
            } else {
              throw new Error();
            }
          }
          else {
            warn(paramString, paramThrowable);
          }
        }
        else {
          info(paramString, paramThrowable);
        }
      }
      else {
        debug(paramString, paramThrowable);
      }
    }
    else {
      trace(paramString, paramThrowable);
    }
  }
  
  public void log(InternalLogLevel paramInternalLogLevel, String paramString, Object... paramVarArgs)
  {
    int i = 1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[paramInternalLogLevel.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5) {
              error(paramString, paramVarArgs);
            } else {
              throw new Error();
            }
          }
          else {
            warn(paramString, paramVarArgs);
          }
        }
        else {
          info(paramString, paramVarArgs);
        }
      }
      else {
        debug(paramString, paramVarArgs);
      }
    }
    else {
      trace(paramString, paramVarArgs);
    }
  }
  
  public void log(InternalLogLevel paramInternalLogLevel, Throwable paramThrowable)
  {
    int i = 1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[paramInternalLogLevel.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5) {
              error(paramThrowable);
            } else {
              throw new Error();
            }
          }
          else {
            warn(paramThrowable);
          }
        }
        else {
          info(paramThrowable);
        }
      }
      else {
        debug(paramThrowable);
      }
    }
    else {
      trace(paramThrowable);
    }
  }
  
  public String name()
  {
    return this.name;
  }
  
  protected Object readResolve()
    throws ObjectStreamException
  {
    return InternalLoggerFactory.getInstance(name());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append('(');
    localStringBuilder.append(name());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public void trace(Throwable paramThrowable)
  {
    trace("Unexpected exception:", paramThrowable);
  }
  
  public void warn(Throwable paramThrowable)
  {
    warn("Unexpected exception:", paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\logging\AbstractInternalLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */