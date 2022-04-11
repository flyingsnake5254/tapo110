package io.netty.util;

public abstract interface Attribute<T>
{
  public abstract boolean compareAndSet(T paramT1, T paramT2);
  
  public abstract T get();
  
  @Deprecated
  public abstract T getAndRemove();
  
  public abstract T getAndSet(T paramT);
  
  public abstract AttributeKey<T> key();
  
  @Deprecated
  public abstract void remove();
  
  public abstract void set(T paramT);
  
  public abstract T setIfAbsent(T paramT);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\Attribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */