package org.apache.commons.lang.exception;

public class CloneFailedException
  extends NestableRuntimeException
{
  private static final long serialVersionUID = 20091223L;
  
  public CloneFailedException(String paramString)
  {
    super(paramString);
  }
  
  public CloneFailedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public CloneFailedException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\exception\CloneFailedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */