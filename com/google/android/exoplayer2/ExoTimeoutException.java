package com.google.android.exoplayer2;

public final class ExoTimeoutException
  extends RuntimeException
{
  public static final int TIMEOUT_OPERATION_DETACH_SURFACE = 3;
  public static final int TIMEOUT_OPERATION_RELEASE = 1;
  public static final int TIMEOUT_OPERATION_SET_FOREGROUND_MODE = 2;
  public static final int TIMEOUT_OPERATION_UNDEFINED = 0;
  public final int timeoutOperation;
  
  public ExoTimeoutException(int paramInt)
  {
    super(getErrorMessage(paramInt));
    this.timeoutOperation = paramInt;
  }
  
  private static String getErrorMessage(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return "Undefined timeout.";
        }
        return "Detaching surface timed out.";
      }
      return "Setting foreground mode timed out.";
    }
    return "Player release timed out.";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\ExoTimeoutException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */