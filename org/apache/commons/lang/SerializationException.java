package org.apache.commons.lang;

import org.apache.commons.lang.exception.NestableRuntimeException;

public class SerializationException
  extends NestableRuntimeException
{
  private static final long serialVersionUID = 4029025366392702726L;
  
  public SerializationException() {}
  
  public SerializationException(String paramString)
  {
    super(paramString);
  }
  
  public SerializationException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public SerializationException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\SerializationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */