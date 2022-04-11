package io.netty.handler.address;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.Future;
import java.net.SocketAddress;

public abstract class DynamicAddressConnectHandler
  extends ChannelOutboundHandlerAdapter
{
  public final void connect(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
  {
    try
    {
      SocketAddress localSocketAddress = remoteAddress(paramSocketAddress1, paramSocketAddress2);
      paramSocketAddress1 = localAddress(paramSocketAddress1, paramSocketAddress2);
      paramChannelHandlerContext.connect(localSocketAddress, paramSocketAddress1, paramChannelPromise).addListener(new ChannelFutureListener()
      {
        public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
        {
          if (paramAnonymousChannelFuture.isSuccess()) {
            paramAnonymousChannelFuture.channel().pipeline().remove(DynamicAddressConnectHandler.this);
          }
        }
      });
      return;
    }
    catch (Exception paramChannelHandlerContext)
    {
      paramChannelPromise.setFailure(paramChannelHandlerContext);
    }
  }
  
  protected SocketAddress localAddress(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
    throws Exception
  {
    return paramSocketAddress2;
  }
  
  protected SocketAddress remoteAddress(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
    throws Exception
  {
    return paramSocketAddress1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\address\DynamicAddressConnectHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */