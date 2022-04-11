package com.google.firebase.crashlytics.internal.stacktrace;

public abstract interface StackTraceTrimmingStrategy
{
  public abstract StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] paramArrayOfStackTraceElement);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\stacktrace\StackTraceTrimmingStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */