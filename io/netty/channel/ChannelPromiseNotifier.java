package io.netty.channel;

import io.netty.util.concurrent.PromiseNotifier;

public final class ChannelPromiseNotifier
  extends PromiseNotifier<Void, ChannelFuture>
  implements ChannelFutureListener
{
  public ChannelPromiseNotifier(boolean paramBoolean, ChannelPromise... paramVarArgs)
  {
    super(paramBoolean, paramVarArgs);
  }
  
  public ChannelPromiseNotifier(ChannelPromise... paramVarArgs)
  {
    super(paramVarArgs);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ChannelPromiseNotifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */