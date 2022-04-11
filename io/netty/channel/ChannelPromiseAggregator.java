package io.netty.channel;

import io.netty.util.concurrent.PromiseAggregator;

@Deprecated
public final class ChannelPromiseAggregator
  extends PromiseAggregator<Void, ChannelFuture>
  implements ChannelFutureListener
{
  public ChannelPromiseAggregator(ChannelPromise paramChannelPromise)
  {
    super(paramChannelPromise);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ChannelPromiseAggregator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */