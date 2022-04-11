package org.bouncycastle.est;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ESTException
  extends IOException
{
  private static final long MAX_ERROR_BODY = 8192L;
  private InputStream body;
  private Throwable cause;
  private int statusCode;
  
  public ESTException(String paramString)
  {
    this(paramString, null);
  }
  
  public ESTException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
    this.body = null;
    this.statusCode = 0;
  }
  
  public ESTException(String paramString, Throwable paramThrowable, int paramInt, InputStream paramInputStream)
  {
    super(paramString);
    this.cause = paramThrowable;
    this.statusCode = paramInt;
    if (paramInputStream != null)
    {
      paramThrowable = new byte[' '];
      paramString = new ByteArrayOutputStream();
    }
    try
    {
      for (;;)
      {
        paramInt = paramInputStream.read(paramThrowable);
        if (paramInt < 0) {
          break;
        }
        if (paramString.size() + paramInt > 8192L)
        {
          paramString.write(paramThrowable, 0, 8192 - paramString.size());
          break;
        }
        paramString.write(paramThrowable, 0, paramInt);
      }
      paramString.flush();
      paramString.close();
      paramThrowable = new java/io/ByteArrayInputStream;
      paramThrowable.<init>(paramString.toByteArray());
      this.body = paramThrowable;
      paramInputStream.close();
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    this.body = null;
  }
  
  public InputStream getBody()
  {
    return this.body;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
  
  public String getMessage()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.getMessage());
    localStringBuilder.append(" HTTP Status Code: ");
    localStringBuilder.append(this.statusCode);
    return localStringBuilder.toString();
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\est\ESTException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */