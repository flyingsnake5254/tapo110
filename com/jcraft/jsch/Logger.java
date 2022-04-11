package com.jcraft.jsch;

public abstract interface Logger
{
  public static final int DEBUG = 0;
  public static final int ERROR = 3;
  public static final int FATAL = 4;
  public static final int INFO = 1;
  public static final int WARN = 2;
  
  public abstract boolean isEnabled(int paramInt);
  
  public abstract void log(int paramInt, String paramString);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */