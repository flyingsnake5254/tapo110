package io.netty.handler.logging;

import io.netty.util.internal.logging.InternalLogLevel;

public enum LogLevel
{
  private final InternalLogLevel internalLevel;
  
  static
  {
    LogLevel localLogLevel1 = new LogLevel("TRACE", 0, InternalLogLevel.TRACE);
    TRACE = localLogLevel1;
    LogLevel localLogLevel2 = new LogLevel("DEBUG", 1, InternalLogLevel.DEBUG);
    DEBUG = localLogLevel2;
    LogLevel localLogLevel3 = new LogLevel("INFO", 2, InternalLogLevel.INFO);
    INFO = localLogLevel3;
    LogLevel localLogLevel4 = new LogLevel("WARN", 3, InternalLogLevel.WARN);
    WARN = localLogLevel4;
    LogLevel localLogLevel5 = new LogLevel("ERROR", 4, InternalLogLevel.ERROR);
    ERROR = localLogLevel5;
    $VALUES = new LogLevel[] { localLogLevel1, localLogLevel2, localLogLevel3, localLogLevel4, localLogLevel5 };
  }
  
  private LogLevel(InternalLogLevel paramInternalLogLevel)
  {
    this.internalLevel = paramInternalLogLevel;
  }
  
  public InternalLogLevel toInternalLevel()
  {
    return this.internalLevel;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\logging\LogLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */