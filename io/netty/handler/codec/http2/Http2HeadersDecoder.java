package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;

public abstract interface Http2HeadersDecoder
{
  public abstract Configuration configuration();
  
  public abstract Http2Headers decodeHeaders(int paramInt, ByteBuf paramByteBuf)
    throws Http2Exception;
  
  public static abstract interface Configuration
  {
    public abstract long maxHeaderListSize();
    
    public abstract void maxHeaderListSize(long paramLong1, long paramLong2)
      throws Http2Exception;
    
    public abstract long maxHeaderListSizeGoAway();
    
    public abstract long maxHeaderTableSize();
    
    public abstract void maxHeaderTableSize(long paramLong)
      throws Http2Exception;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2HeadersDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */