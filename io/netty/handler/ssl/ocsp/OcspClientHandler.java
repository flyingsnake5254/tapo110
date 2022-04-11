package io.netty.handler.ssl.ocsp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.ssl.ReferenceCountedOpenSslEngine;
import io.netty.handler.ssl.SslCompletionEvent;
import io.netty.handler.ssl.SslHandshakeCompletionEvent;
import io.netty.util.internal.ObjectUtil;
import javax.net.ssl.SSLHandshakeException;

public abstract class OcspClientHandler
  extends ChannelInboundHandlerAdapter
{
  private final ReferenceCountedOpenSslEngine engine;
  
  protected OcspClientHandler(ReferenceCountedOpenSslEngine paramReferenceCountedOpenSslEngine)
  {
    this.engine = ((ReferenceCountedOpenSslEngine)ObjectUtil.checkNotNull(paramReferenceCountedOpenSslEngine, "engine"));
  }
  
  public void userEventTriggered(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    if ((paramObject instanceof SslHandshakeCompletionEvent))
    {
      paramChannelHandlerContext.pipeline().remove(this);
      if ((((SslHandshakeCompletionEvent)paramObject).isSuccess()) && (!verify(paramChannelHandlerContext, this.engine))) {
        throw new SSLHandshakeException("Bad OCSP response");
      }
    }
    paramChannelHandlerContext.fireUserEventTriggered(paramObject);
  }
  
  protected abstract boolean verify(ChannelHandlerContext paramChannelHandlerContext, ReferenceCountedOpenSslEngine paramReferenceCountedOpenSslEngine)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\ocsp\OcspClientHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */