package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.channel.ChannelHandler.a;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandler;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandshaker;

@ChannelHandler.a
public final class WebSocketClientCompressionHandler
  extends WebSocketClientExtensionHandler
{
  public static final WebSocketClientCompressionHandler INSTANCE = new WebSocketClientCompressionHandler();
  
  private WebSocketClientCompressionHandler()
  {
    super(new WebSocketClientExtensionHandshaker[] { new PerMessageDeflateClientExtensionHandshaker(), new DeflateFrameClientExtensionHandshaker(false), new DeflateFrameClientExtensionHandshaker(true) });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\extensions\compression\WebSocketClientCompressionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */