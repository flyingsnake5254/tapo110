package io.netty.util;

public abstract interface Constant<T extends Constant<T>>
  extends Comparable<T>
{
  public abstract int id();
  
  public abstract String name();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\Constant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */