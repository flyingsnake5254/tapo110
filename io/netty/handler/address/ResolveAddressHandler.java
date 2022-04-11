package io.netty.handler.address;

import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.resolver.AddressResolver;
import io.netty.resolver.AddressResolverGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.a;
import io.netty.util.internal.ObjectUtil;
import java.net.SocketAddress;

@ChannelHandler.a
public class ResolveAddressHandler
  extends ChannelOutboundHandlerAdapter
{
  private final AddressResolverGroup<? extends SocketAddress> resolverGroup;
  
  public ResolveAddressHandler(AddressResolverGroup<? extends SocketAddress> paramAddressResolverGroup)
  {
    this.resolverGroup = ((AddressResolverGroup)ObjectUtil.checkNotNull(paramAddressResolverGroup, "resolverGroup"));
  }
  
  public void connect(final ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress1, final SocketAddress paramSocketAddress2, final ChannelPromise paramChannelPromise)
  {
    AddressResolver localAddressResolver = this.resolverGroup.getResolver(paramChannelHandlerContext.executor());
    if ((localAddressResolver.isSupported(paramSocketAddress1)) && (!localAddressResolver.isResolved(paramSocketAddress1)))
    {
      localAddressResolver.resolve(paramSocketAddress1).addListener(new a()
      {
        public void operationComplete(Future<SocketAddress> paramAnonymousFuture)
        {
          Throwable localThrowable = paramAnonymousFuture.cause();
          if (localThrowable != null) {
            paramChannelPromise.setFailure(localThrowable);
          } else {
            paramChannelHandlerContext.connect((SocketAddress)paramAnonymousFuture.getNow(), paramSocketAddress2, paramChannelPromise);
          }
          paramChannelHandlerContext.pipeline().remove(ResolveAddressHandler.this);
        }
      });
    }
    else
    {
      paramChannelHandlerContext.connect(paramSocketAddress1, paramSocketAddress2, paramChannelPromise);
      paramChannelHandlerContext.pipeline().remove(this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\address\ResolveAddressHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */