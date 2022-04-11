package io.netty.handler.codec.http;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;
import io.netty.util.AsciiString;

public class HttpContentDecompressor
  extends HttpContentDecoder
{
  private final boolean strict;
  
  public HttpContentDecompressor()
  {
    this(false);
  }
  
  public HttpContentDecompressor(boolean paramBoolean)
  {
    this.strict = paramBoolean;
  }
  
  protected EmbeddedChannel newContentDecoder(String paramString)
    throws Exception
  {
    if ((!HttpHeaderValues.GZIP.contentEqualsIgnoreCase(paramString)) && (!HttpHeaderValues.X_GZIP.contentEqualsIgnoreCase(paramString)))
    {
      if ((!HttpHeaderValues.DEFLATE.contentEqualsIgnoreCase(paramString)) && (!HttpHeaderValues.X_DEFLATE.contentEqualsIgnoreCase(paramString))) {
        return null;
      }
      if (this.strict) {
        paramString = ZlibWrapper.ZLIB;
      } else {
        paramString = ZlibWrapper.ZLIB_OR_NONE;
      }
      return new EmbeddedChannel(this.ctx.channel().id(), this.ctx.channel().metadata().hasDisconnect(), this.ctx.channel().config(), new ChannelHandler[] { ZlibCodecFactory.newZlibDecoder(paramString) });
    }
    return new EmbeddedChannel(this.ctx.channel().id(), this.ctx.channel().metadata().hasDisconnect(), this.ctx.channel().config(), new ChannelHandler[] { ZlibCodecFactory.newZlibDecoder(ZlibWrapper.GZIP) });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpContentDecompressor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */