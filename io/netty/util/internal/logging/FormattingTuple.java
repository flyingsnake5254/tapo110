package io.netty.util.internal.logging;

final class FormattingTuple
{
  private final String message;
  private final Throwable throwable;
  
  FormattingTuple(String paramString, Throwable paramThrowable)
  {
    this.message = paramString;
    this.throwable = paramThrowable;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public Throwable getThrowable()
  {
    return this.throwable;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\logging\FormattingTuple.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */