package io.netty.channel;

import java.net.SocketAddress;

public class ChannelDuplexHandler
  extends ChannelInboundHandlerAdapter
  implements ChannelOutboundHandler
{
  @ChannelHandlerMask.a
  public void bind(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.bind(paramSocketAddress, paramChannelPromise);
  }
  
  @ChannelHandlerMask.a
  public void close(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.close(paramChannelPromise);
  }
  
  @ChannelHandlerMask.a
  public void connect(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.connect(paramSocketAddress1, paramSocketAddress2, paramChannelPromise);
  }
  
  @ChannelHandlerMask.a
  public void deregister(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.deregister(paramChannelPromise);
  }
  
  @ChannelHandlerMask.a
  public void disconnect(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.disconnect(paramChannelPromise);
  }
  
  @ChannelHandlerMask.a
  public void flush(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext.flush();
  }
  
  @ChannelHandlerMask.a
  public void read(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext.read();
  }
  
  @ChannelHandlerMask.a
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.write(paramObject, paramChannelPromise);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ChannelDuplexHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */