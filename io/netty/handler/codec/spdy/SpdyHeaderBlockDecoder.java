package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

abstract class SpdyHeaderBlockDecoder
{
  static SpdyHeaderBlockDecoder newInstance(SpdyVersion paramSpdyVersion, int paramInt)
  {
    return new SpdyHeaderBlockZlibDecoder(paramSpdyVersion, paramInt);
  }
  
  abstract void decode(ByteBufAllocator paramByteBufAllocator, ByteBuf paramByteBuf, SpdyHeadersFrame paramSpdyHeadersFrame)
    throws Exception;
  
  abstract void end();
  
  abstract void endHeaderBlock(SpdyHeadersFrame paramSpdyHeadersFrame)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyHeaderBlockDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */