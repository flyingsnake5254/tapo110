package io.netty.handler.ipfilter;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ConcurrentSet;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Set;

@ChannelHandler.a
public class UniqueIpFilter
  extends AbstractRemoteAddressFilter<InetSocketAddress>
{
  private final Set<InetAddress> connected = new ConcurrentSet();
  
  protected boolean accept(ChannelHandlerContext paramChannelHandlerContext, final InetSocketAddress paramInetSocketAddress)
    throws Exception
  {
    paramInetSocketAddress = paramInetSocketAddress.getAddress();
    if (!this.connected.add(paramInetSocketAddress)) {
      return false;
    }
    paramChannelHandlerContext.channel().closeFuture().addListener(new ChannelFutureListener()
    {
      public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
        throws Exception
      {
        UniqueIpFilter.this.connected.remove(paramInetSocketAddress);
      }
    });
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ipfilter\UniqueIpFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */