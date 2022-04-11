package io.netty.util.internal.logging;

public enum InternalLogLevel
{
  static
  {
    InternalLogLevel localInternalLogLevel1 = new InternalLogLevel("TRACE", 0);
    TRACE = localInternalLogLevel1;
    InternalLogLevel localInternalLogLevel2 = new InternalLogLevel("DEBUG", 1);
    DEBUG = localInternalLogLevel2;
    InternalLogLevel localInternalLogLevel3 = new InternalLogLevel("INFO", 2);
    INFO = localInternalLogLevel3;
    InternalLogLevel localInternalLogLevel4 = new InternalLogLevel("WARN", 3);
    WARN = localInternalLogLevel4;
    InternalLogLevel localInternalLogLevel5 = new InternalLogLevel("ERROR", 4);
    ERROR = localInternalLogLevel5;
    $VALUES = new InternalLogLevel[] { localInternalLogLevel1, localInternalLogLevel2, localInternalLogLevel3, localInternalLogLevel4, localInternalLogLevel5 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\logging\InternalLogLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */