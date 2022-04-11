package io.netty.handler.codec.http2;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.util.internal.StringUtil;

public abstract class Http2ChannelDuplexHandler
  extends ChannelDuplexHandler
{
  private volatile Http2FrameCodec frameCodec;
  
  private static Http2FrameCodec requireHttp2FrameCodec(ChannelHandlerContext paramChannelHandlerContext)
  {
    paramChannelHandlerContext = paramChannelHandlerContext.pipeline().context(Http2FrameCodec.class);
    if (paramChannelHandlerContext != null) {
      return (Http2FrameCodec)paramChannelHandlerContext.handler();
    }
    paramChannelHandlerContext = new StringBuilder();
    paramChannelHandlerContext.append(Http2FrameCodec.class.getSimpleName());
    paramChannelHandlerContext.append(" was not found in the channel pipeline.");
    throw new IllegalArgumentException(paramChannelHandlerContext.toString());
  }
  
  protected final void forEachActiveStream(Http2FrameStreamVisitor paramHttp2FrameStreamVisitor)
    throws Http2Exception
  {
    this.frameCodec.forEachActiveStream(paramHttp2FrameStreamVisitor);
  }
  
  public final void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.frameCodec = requireHttp2FrameCodec(paramChannelHandlerContext);
    handlerAdded0(paramChannelHandlerContext);
  }
  
  protected void handlerAdded0(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {}
  
  public final void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    try
    {
      handlerRemoved0(paramChannelHandlerContext);
      return;
    }
    finally
    {
      this.frameCodec = null;
    }
  }
  
  protected void handlerRemoved0(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {}
  
  public final Http2FrameStream newStream()
  {
    Object localObject = this.frameCodec;
    if (localObject != null) {
      return ((Http2FrameCodec)localObject).newStream();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(StringUtil.simpleClassName(Http2FrameCodec.class));
    ((StringBuilder)localObject).append(" not found. Has the handler been added to a pipeline?");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2ChannelDuplexHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */