package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public final class Delimiters
{
  public static ByteBuf[] lineDelimiter()
  {
    return new ByteBuf[] { Unpooled.wrappedBuffer(new byte[] { 13, 10 }), Unpooled.wrappedBuffer(new byte[] { 10 }) };
  }
  
  public static ByteBuf[] nulDelimiter()
  {
    return new ByteBuf[] { Unpooled.wrappedBuffer(new byte[] { 0 }) };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\Delimiters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */