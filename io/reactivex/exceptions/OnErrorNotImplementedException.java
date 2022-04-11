package io.reactivex.exceptions;

public final class OnErrorNotImplementedException
  extends RuntimeException
{
  private static final long serialVersionUID = -6298857009889503852L;
  
  public OnErrorNotImplementedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public OnErrorNotImplementedException(Throwable paramThrowable)
  {
    this(localStringBuilder.toString(), paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\exceptions\OnErrorNotImplementedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */