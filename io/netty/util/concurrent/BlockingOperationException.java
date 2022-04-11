package io.netty.util.concurrent;

public class BlockingOperationException
  extends IllegalStateException
{
  private static final long serialVersionUID = 2462223247762460301L;
  
  public BlockingOperationException() {}
  
  public BlockingOperationException(String paramString)
  {
    super(paramString);
  }
  
  public BlockingOperationException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public BlockingOperationException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\BlockingOperationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */