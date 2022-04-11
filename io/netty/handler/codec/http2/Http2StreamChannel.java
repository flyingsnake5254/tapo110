package io.netty.handler.codec.http2;

import io.netty.channel.Channel;

public abstract interface Http2StreamChannel
  extends Channel
{
  public abstract Http2FrameStream stream();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2StreamChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */