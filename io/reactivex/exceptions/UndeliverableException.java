package io.reactivex.exceptions;

public final class UndeliverableException
  extends IllegalStateException
{
  private static final long serialVersionUID = 1644750035281290266L;
  
  public UndeliverableException(Throwable paramThrowable)
  {
    super(localStringBuilder.toString(), paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\exceptions\UndeliverableException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */