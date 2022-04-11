package io.netty.channel.oio;

import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.RecvByteBufAllocator.Handle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public abstract class AbstractOioMessageChannel
  extends AbstractOioChannel
{
  private final List<Object> readBuf = new ArrayList();
  
  protected AbstractOioMessageChannel(Channel paramChannel)
  {
    super(paramChannel);
  }
  
  protected void doRead()
  {
    if (!this.readPending) {
      return;
    }
    int i = 0;
    this.readPending = false;
    ChannelConfig localChannelConfig = config();
    ChannelPipeline localChannelPipeline = pipeline();
    RecvByteBufAllocator.Handle localHandle = unsafe().recvBufAllocHandle();
    localHandle.reset(localChannelConfig);
    Object localObject1 = null;
    Object localObject2 = null;
    int j;
    for (;;)
    {
      j = 1;
      try
      {
        k = doReadMessages(this.readBuf);
        if (k != 0)
        {
          if (k < 0)
          {
            k = 1;
            localObject2 = localObject1;
            break label119;
          }
          localHandle.incMessagesRead(k);
          boolean bool = localHandle.continueReading();
          if (bool) {}
        }
        else {}
      }
      finally {}
    }
    int k = 0;
    label119:
    int m = this.readBuf.size();
    if (m > 0)
    {
      for (i = 0; i < m; i++)
      {
        this.readPending = false;
        localChannelPipeline.fireChannelRead(this.readBuf.get(i));
      }
      this.readBuf.clear();
      localHandle.readComplete();
      localChannelPipeline.fireChannelReadComplete();
      i = 1;
    }
    m = k;
    if (localThrowable != null)
    {
      if ((localThrowable instanceof IOException)) {
        k = j;
      }
      localChannelPipeline.fireExceptionCaught(localThrowable);
      m = k;
    }
    if (m != 0)
    {
      if (isOpen()) {
        unsafe().close(unsafe().voidPromise());
      }
    }
    else if ((this.readPending) || (localChannelConfig.isAutoRead()) || ((i == 0) && (isActive()))) {
      read();
    }
  }
  
  protected abstract int doReadMessages(List<Object> paramList)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\oio\AbstractOioMessageChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */