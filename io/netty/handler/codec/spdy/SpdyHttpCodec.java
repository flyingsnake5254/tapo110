package io.netty.handler.codec.spdy;

import io.netty.channel.CombinedChannelDuplexHandler;

public final class SpdyHttpCodec
  extends CombinedChannelDuplexHandler<SpdyHttpDecoder, SpdyHttpEncoder>
{
  public SpdyHttpCodec(SpdyVersion paramSpdyVersion, int paramInt)
  {
    super(new SpdyHttpDecoder(paramSpdyVersion, paramInt), new SpdyHttpEncoder(paramSpdyVersion));
  }
  
  public SpdyHttpCodec(SpdyVersion paramSpdyVersion, int paramInt, boolean paramBoolean)
  {
    super(new SpdyHttpDecoder(paramSpdyVersion, paramInt, paramBoolean), new SpdyHttpEncoder(paramSpdyVersion));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyHttpCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */