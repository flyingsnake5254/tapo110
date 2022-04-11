package io.netty.handler.codec.rtsp;

import io.netty.channel.ChannelHandler.a;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpObjectEncoder;

@ChannelHandler.a
@Deprecated
public abstract class RtspObjectEncoder<H extends HttpMessage>
  extends HttpObjectEncoder<H>
{
  public boolean acceptOutboundMessage(Object paramObject)
    throws Exception
  {
    return paramObject instanceof FullHttpMessage;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\rtsp\RtspObjectEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */