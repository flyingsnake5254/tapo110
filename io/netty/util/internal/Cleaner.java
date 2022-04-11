package io.netty.util.internal;

import java.nio.ByteBuffer;

abstract interface Cleaner
{
  public abstract void freeDirectBuffer(ByteBuffer paramByteBuffer);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\Cleaner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */