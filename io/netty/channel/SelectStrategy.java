package io.netty.channel;

import io.netty.util.IntSupplier;

public abstract interface SelectStrategy
{
  public static final int BUSY_WAIT = -3;
  public static final int CONTINUE = -2;
  public static final int SELECT = -1;
  
  public abstract int calculateStrategy(IntSupplier paramIntSupplier, boolean paramBoolean)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\SelectStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */