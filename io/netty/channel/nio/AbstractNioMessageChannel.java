package io.netty.channel.nio;

import io.netty.channel.AbstractChannel;
import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.Channel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.a;
import java.io.IOException;
import java.net.PortUnreachableException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNioMessageChannel
  extends AbstractNioChannel
{
  boolean inputShutdown;
  
  protected AbstractNioMessageChannel(Channel paramChannel, SelectableChannel paramSelectableChannel, int paramInt)
  {
    super(paramChannel, paramSelectableChannel, paramInt);
  }
  
  protected boolean closeOnReadError(Throwable paramThrowable)
  {
    if (!isActive()) {
      return true;
    }
    if ((paramThrowable instanceof PortUnreachableException)) {
      return false;
    }
    if ((paramThrowable instanceof IOException)) {
      return this instanceof a ^ true;
    }
    return true;
  }
  
  protected boolean continueOnWriteError()
  {
    return false;
  }
  
  protected void doBeginRead()
    throws Exception
  {
    if (this.inputShutdown) {
      return;
    }
    super.doBeginRead();
  }
  
  protected abstract int doReadMessages(List<Object> paramList)
    throws Exception;
  
  protected void doWrite(ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    SelectionKey localSelectionKey = selectionKey();
    int i = localSelectionKey.interestOps();
    for (;;)
    {
      Object localObject = paramChannelOutboundBuffer.current();
      int j;
      if (localObject == null)
      {
        if ((i & 0x4) != 0) {
          localSelectionKey.interestOps(i & 0xFFFFFFFB);
        }
      }
      else {
        j = 0;
      }
      try
      {
        int m;
        for (int k = config().getWriteSpinCount() - 1;; k--)
        {
          m = j;
          if (k < 0) {
            break;
          }
          if (doWriteMessage(localObject, paramChannelOutboundBuffer))
          {
            m = 1;
            break;
          }
        }
        if (m != 0)
        {
          paramChannelOutboundBuffer.remove();
          continue;
        }
        if ((i & 0x4) == 0) {
          localSelectionKey.interestOps(i | 0x4);
        }
        return;
      }
      catch (Exception localException)
      {
        if (continueOnWriteError())
        {
          paramChannelOutboundBuffer.remove(localException);
          continue;
        }
        throw localException;
      }
    }
  }
  
  protected abstract boolean doWriteMessage(Object paramObject, ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception;
  
  protected AbstractNioChannel.AbstractNioUnsafe newUnsafe()
  {
    return new NioMessageUnsafe(null);
  }
  
  private final class NioMessageUnsafe
    extends AbstractNioChannel.AbstractNioUnsafe
  {
    private final List<Object> readBuf = new ArrayList();
    
    private NioMessageUnsafe()
    {
      super();
    }
    
    public void read()
    {
      ChannelConfig localChannelConfig = AbstractNioMessageChannel.this.config();
      ChannelPipeline localChannelPipeline = AbstractNioMessageChannel.this.pipeline();
      RecvByteBufAllocator.Handle localHandle = AbstractNioMessageChannel.this.unsafe().recvBufAllocHandle();
      localHandle.reset(localChannelConfig);
      Object localObject1 = null;
      Object localObject2 = null;
      int i;
      try
      {
        for (;;)
        {
          i = AbstractNioMessageChannel.this.doReadMessages(this.readBuf);
          if (i != 0)
          {
            if (i < 0)
            {
              bool = true;
              localObject2 = localObject1;
              break label109;
            }
            localHandle.incMessagesRead(i);
            bool = localHandle.continueReading();
            if (bool) {}
          }
          else
          {
            break;
          }
        }
      }
      finally {}
      boolean bool = false;
      try
      {
        label109:
        int j = this.readBuf.size();
        for (i = 0; i < j; i++)
        {
          AbstractNioMessageChannel.this.readPending = false;
          localChannelPipeline.fireChannelRead(this.readBuf.get(i));
        }
        this.readBuf.clear();
        localHandle.readComplete();
        localChannelPipeline.fireChannelReadComplete();
        if (localThrowable != null)
        {
          bool = AbstractNioMessageChannel.this.closeOnReadError(localThrowable);
          localChannelPipeline.fireExceptionCaught(localThrowable);
        }
        if (bool)
        {
          AbstractNioMessageChannel localAbstractNioMessageChannel = AbstractNioMessageChannel.this;
          localAbstractNioMessageChannel.inputShutdown = true;
          if (localAbstractNioMessageChannel.isOpen()) {
            close(voidPromise());
          }
        }
        return;
      }
      finally
      {
        if ((!AbstractNioMessageChannel.this.readPending) && (!localChannelConfig.isAutoRead())) {
          removeReadOp();
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\nio\AbstractNioMessageChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */