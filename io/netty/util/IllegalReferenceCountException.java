package io.netty.util;

public class IllegalReferenceCountException
  extends IllegalStateException
{
  private static final long serialVersionUID = -2507492394288153468L;
  
  public IllegalReferenceCountException() {}
  
  public IllegalReferenceCountException(int paramInt)
  {
    this(localStringBuilder.toString());
  }
  
  public IllegalReferenceCountException(int paramInt1, int paramInt2)
  {
    this(localStringBuilder1.toString());
  }
  
  public IllegalReferenceCountException(String paramString)
  {
    super(paramString);
  }
  
  public IllegalReferenceCountException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public IllegalReferenceCountException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\IllegalReferenceCountException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */