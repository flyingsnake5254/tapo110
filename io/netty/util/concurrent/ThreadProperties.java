package io.netty.util.concurrent;

public abstract interface ThreadProperties
{
  public abstract long id();
  
  public abstract boolean isAlive();
  
  public abstract boolean isDaemon();
  
  public abstract boolean isInterrupted();
  
  public abstract String name();
  
  public abstract int priority();
  
  public abstract StackTraceElement[] stackTrace();
  
  public abstract Thread.State state();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\ThreadProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */