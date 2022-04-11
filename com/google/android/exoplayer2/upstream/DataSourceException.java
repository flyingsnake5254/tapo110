package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import java.io.IOException;

public class DataSourceException
  extends IOException
{
  @Deprecated
  public static final int POSITION_OUT_OF_RANGE = 2008;
  public final int reason;
  
  public DataSourceException(int paramInt)
  {
    this.reason = paramInt;
  }
  
  public DataSourceException(@Nullable String paramString, int paramInt)
  {
    super(paramString);
    this.reason = paramInt;
  }
  
  public DataSourceException(@Nullable String paramString, @Nullable Throwable paramThrowable, int paramInt)
  {
    super(paramString, paramThrowable);
    this.reason = paramInt;
  }
  
  public DataSourceException(@Nullable Throwable paramThrowable, int paramInt)
  {
    super(paramThrowable);
    this.reason = paramInt;
  }
  
  public static boolean isCausedByPositionOutOfRange(IOException paramIOException)
  {
    while (paramIOException != null)
    {
      if (((paramIOException instanceof DataSourceException)) && (((DataSourceException)paramIOException).reason == 2008)) {
        return true;
      }
      paramIOException = paramIOException.getCause();
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\DataSourceException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */