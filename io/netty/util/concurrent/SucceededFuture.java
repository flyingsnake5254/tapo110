package io.netty.util.concurrent;

public final class SucceededFuture<V>
  extends CompleteFuture<V>
{
  private final V result;
  
  public SucceededFuture(EventExecutor paramEventExecutor, V paramV)
  {
    super(paramEventExecutor);
    this.result = paramV;
  }
  
  public Throwable cause()
  {
    return null;
  }
  
  public V getNow()
  {
    return (V)this.result;
  }
  
  public boolean isSuccess()
  {
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\SucceededFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */