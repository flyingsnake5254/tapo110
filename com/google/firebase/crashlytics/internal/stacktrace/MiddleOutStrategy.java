package com.google.firebase.crashlytics.internal.stacktrace;

public class MiddleOutStrategy
  implements StackTraceTrimmingStrategy
{
  private final int trimmedSize;
  
  public MiddleOutStrategy(int paramInt)
  {
    this.trimmedSize = paramInt;
  }
  
  public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    int i = paramArrayOfStackTraceElement.length;
    int j = this.trimmedSize;
    if (i <= j) {
      return paramArrayOfStackTraceElement;
    }
    i = j / 2;
    int k = j - i;
    StackTraceElement[] arrayOfStackTraceElement = new StackTraceElement[j];
    System.arraycopy(paramArrayOfStackTraceElement, 0, arrayOfStackTraceElement, 0, k);
    System.arraycopy(paramArrayOfStackTraceElement, paramArrayOfStackTraceElement.length - i, arrayOfStackTraceElement, k, i);
    return arrayOfStackTraceElement;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\stacktrace\MiddleOutStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */