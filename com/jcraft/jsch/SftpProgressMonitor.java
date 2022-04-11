package com.jcraft.jsch;

public abstract interface SftpProgressMonitor
{
  public static final int GET = 1;
  public static final int PUT = 0;
  public static final long UNKNOWN_SIZE = -1L;
  
  public abstract boolean count(long paramLong);
  
  public abstract void end();
  
  public abstract void init(int paramInt, String paramString1, String paramString2, long paramLong);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\SftpProgressMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */