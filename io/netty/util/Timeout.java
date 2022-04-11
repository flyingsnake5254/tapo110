package io.netty.util;

public abstract interface Timeout
{
  public abstract boolean cancel();
  
  public abstract boolean isCancelled();
  
  public abstract boolean isExpired();
  
  public abstract TimerTask task();
  
  public abstract Timer timer();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\Timeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */