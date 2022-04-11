package com.google.firebase.crashlytics.internal.stacktrace;

public class MiddleOutFallbackStrategy
  implements StackTraceTrimmingStrategy
{
  private final int maximumStackSize;
  private final MiddleOutStrategy middleOutStrategy;
  private final StackTraceTrimmingStrategy[] trimmingStrategies;
  
  public MiddleOutFallbackStrategy(int paramInt, StackTraceTrimmingStrategy... paramVarArgs)
  {
    this.maximumStackSize = paramInt;
    this.trimmingStrategies = paramVarArgs;
    this.middleOutStrategy = new MiddleOutStrategy(paramInt);
  }
  
  public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    if (paramArrayOfStackTraceElement.length <= this.maximumStackSize) {
      return paramArrayOfStackTraceElement;
    }
    StackTraceTrimmingStrategy[] arrayOfStackTraceTrimmingStrategy = this.trimmingStrategies;
    int i = arrayOfStackTraceTrimmingStrategy.length;
    int j = 0;
    StackTraceElement[] arrayOfStackTraceElement = paramArrayOfStackTraceElement;
    while (j < i)
    {
      StackTraceTrimmingStrategy localStackTraceTrimmingStrategy = arrayOfStackTraceTrimmingStrategy[j];
      if (arrayOfStackTraceElement.length <= this.maximumStackSize) {
        break;
      }
      arrayOfStackTraceElement = localStackTraceTrimmingStrategy.getTrimmedStackTrace(paramArrayOfStackTraceElement);
      j++;
    }
    paramArrayOfStackTraceElement = arrayOfStackTraceElement;
    if (arrayOfStackTraceElement.length > this.maximumStackSize) {
      paramArrayOfStackTraceElement = this.middleOutStrategy.getTrimmedStackTrace(arrayOfStackTraceElement);
    }
    return paramArrayOfStackTraceElement;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\stacktrace\MiddleOutFallbackStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */