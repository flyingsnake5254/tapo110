package io.netty.channel;

public class ChannelInboundHandlerAdapter
  extends ChannelHandlerAdapter
  implements ChannelInboundHandler
{
  @ChannelHandlerMask.a
  public void channelActive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext.fireChannelActive();
  }
  
  @ChannelHandlerMask.a
  public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext.fireChannelInactive();
  }
  
  @ChannelHandlerMask.a
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    paramChannelHandlerContext.fireChannelRead(paramObject);
  }
  
  @ChannelHandlerMask.a
  public void channelReadComplete(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext.fireChannelReadComplete();
  }
  
  @ChannelHandlerMask.a
  public void channelRegistered(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext.fireChannelRegistered();
  }
  
  @ChannelHandlerMask.a
  public void channelUnregistered(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext.fireChannelUnregistered();
  }
  
  @ChannelHandlerMask.a
  public void channelWritabilityChanged(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext.fireChannelWritabilityChanged();
  }
  
  @ChannelHandlerMask.a
  public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    throws Exception
  {
    paramChannelHandlerContext.fireExceptionCaught(paramThrowable);
  }
  
  @ChannelHandlerMask.a
  public void userEventTriggered(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    paramChannelHandlerContext.fireUserEventTriggered(paramObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ChannelInboundHandlerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */