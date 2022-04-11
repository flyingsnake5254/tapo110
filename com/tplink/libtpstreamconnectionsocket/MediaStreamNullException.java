package com.tplink.libtpstreamconnectionsocket;

import java.io.IOException;

public class MediaStreamNullException
  extends IOException
{
  public static final String STREAM_EMPTY_EXCEPTION = "unexpected end of stream";
  
  public MediaStreamNullException(String paramString)
  {
    super(paramString);
  }
  
  public MediaStreamNullException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public MediaStreamNullException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpstreamconnectionsocket\MediaStreamNullException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */