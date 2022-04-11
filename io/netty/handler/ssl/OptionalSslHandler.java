package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

public class OptionalSslHandler
  extends ByteToMessageDecoder
{
  private final SslContext sslContext;
  
  public OptionalSslHandler(SslContext paramSslContext)
  {
    this.sslContext = ((SslContext)ObjectUtil.checkNotNull(paramSslContext, "sslContext"));
  }
  
  private void handleNonSsl(ChannelHandlerContext paramChannelHandlerContext)
  {
    ChannelHandler localChannelHandler = newNonSslHandler(paramChannelHandlerContext);
    if (localChannelHandler != null) {
      paramChannelHandlerContext.pipeline().replace(this, newNonSslHandlerName(), localChannelHandler);
    } else {
      paramChannelHandlerContext.pipeline().remove(this);
    }
  }
  
  private void handleSsl(ChannelHandlerContext paramChannelHandlerContext)
  {
    Object localObject = null;
    try
    {
      SslHandler localSslHandler = newSslHandler(paramChannelHandlerContext, this.sslContext);
      localObject = localSslHandler;
      paramChannelHandlerContext.pipeline().replace(this, newSslHandlerName(), localSslHandler);
      return;
    }
    finally
    {
      if (localObject != null) {
        ReferenceCountUtil.safeRelease(((SslHandler)localObject).engine());
      }
    }
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    if (paramByteBuf.readableBytes() < 5) {
      return;
    }
    if (SslHandler.isEncrypted(paramByteBuf)) {
      handleSsl(paramChannelHandlerContext);
    } else {
      handleNonSsl(paramChannelHandlerContext);
    }
  }
  
  protected ChannelHandler newNonSslHandler(ChannelHandlerContext paramChannelHandlerContext)
  {
    return null;
  }
  
  protected String newNonSslHandlerName()
  {
    return null;
  }
  
  protected SslHandler newSslHandler(ChannelHandlerContext paramChannelHandlerContext, SslContext paramSslContext)
  {
    return paramSslContext.newHandler(paramChannelHandlerContext.alloc());
  }
  
  protected String newSslHandlerName()
  {
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OptionalSslHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */