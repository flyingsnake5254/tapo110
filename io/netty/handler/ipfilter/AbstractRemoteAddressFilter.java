package io.netty.handler.ipfilter;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import java.net.SocketAddress;

public abstract class AbstractRemoteAddressFilter<T extends SocketAddress>
  extends ChannelInboundHandlerAdapter
{
  private boolean handleNewChannel(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    Object localObject = paramChannelHandlerContext.channel().remoteAddress();
    if (localObject == null) {
      return false;
    }
    paramChannelHandlerContext.pipeline().remove(this);
    if (accept(paramChannelHandlerContext, (SocketAddress)localObject))
    {
      channelAccepted(paramChannelHandlerContext, (SocketAddress)localObject);
    }
    else
    {
      localObject = channelRejected(paramChannelHandlerContext, (SocketAddress)localObject);
      if (localObject != null) {
        ((ChannelFuture)localObject).addListener(ChannelFutureListener.CLOSE);
      } else {
        paramChannelHandlerContext.close();
      }
    }
    return true;
  }
  
  protected abstract boolean accept(ChannelHandlerContext paramChannelHandlerContext, T paramT)
    throws Exception;
  
  protected void channelAccepted(ChannelHandlerContext paramChannelHandlerContext, T paramT) {}
  
  public void channelActive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (handleNewChannel(paramChannelHandlerContext))
    {
      paramChannelHandlerContext.fireChannelActive();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cannot determine to accept or reject a channel: ");
    localStringBuilder.append(paramChannelHandlerContext.channel());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void channelRegistered(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    handleNewChannel(paramChannelHandlerContext);
    paramChannelHandlerContext.fireChannelRegistered();
  }
  
  protected ChannelFuture channelRejected(ChannelHandlerContext paramChannelHandlerContext, T paramT)
  {
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ipfilter\AbstractRemoteAddressFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */