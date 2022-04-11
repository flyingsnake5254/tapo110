package io.netty.channel;

import io.netty.util.concurrent.EventExecutor;

final class DefaultChannelHandlerContext
  extends AbstractChannelHandlerContext
{
  private final ChannelHandler handler;
  
  DefaultChannelHandlerContext(DefaultChannelPipeline paramDefaultChannelPipeline, EventExecutor paramEventExecutor, String paramString, ChannelHandler paramChannelHandler)
  {
    super(paramDefaultChannelPipeline, paramEventExecutor, paramString, paramChannelHandler.getClass());
    this.handler = paramChannelHandler;
  }
  
  public ChannelHandler handler()
  {
    return this.handler;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\DefaultChannelHandlerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */