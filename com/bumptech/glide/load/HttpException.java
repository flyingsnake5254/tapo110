package com.bumptech.glide.load;

import androidx.annotation.Nullable;
import java.io.IOException;

public final class HttpException
  extends IOException
{
  public static final int UNKNOWN = -1;
  private static final long serialVersionUID = 1L;
  private final int statusCode;
  
  public HttpException(int paramInt)
  {
    this("Http request failed", paramInt);
  }
  
  @Deprecated
  public HttpException(String paramString)
  {
    this(paramString, -1);
  }
  
  public HttpException(String paramString, int paramInt)
  {
    this(paramString, paramInt, null);
  }
  
  public HttpException(String paramString, int paramInt, @Nullable Throwable paramThrowable)
  {
    super(localStringBuilder.toString(), paramThrowable);
    this.statusCode = paramInt;
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\HttpException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */