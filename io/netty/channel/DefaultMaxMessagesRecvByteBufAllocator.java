package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.UncheckedBooleanSupplier;
import io.netty.util.internal.ObjectUtil;

public abstract class DefaultMaxMessagesRecvByteBufAllocator
  implements MaxMessagesRecvByteBufAllocator
{
  private volatile int maxMessagesPerRead;
  private volatile boolean respectMaybeMoreData = true;
  
  public DefaultMaxMessagesRecvByteBufAllocator()
  {
    this(1);
  }
  
  public DefaultMaxMessagesRecvByteBufAllocator(int paramInt)
  {
    maxMessagesPerRead(paramInt);
  }
  
  public int maxMessagesPerRead()
  {
    return this.maxMessagesPerRead;
  }
  
  public MaxMessagesRecvByteBufAllocator maxMessagesPerRead(int paramInt)
  {
    ObjectUtil.checkPositive(paramInt, "maxMessagesPerRead");
    this.maxMessagesPerRead = paramInt;
    return this;
  }
  
  public DefaultMaxMessagesRecvByteBufAllocator respectMaybeMoreData(boolean paramBoolean)
  {
    this.respectMaybeMoreData = paramBoolean;
    return this;
  }
  
  public final boolean respectMaybeMoreData()
  {
    return this.respectMaybeMoreData;
  }
  
  public abstract class MaxMessageHandle
    implements RecvByteBufAllocator.ExtendedHandle
  {
    private int attemptedBytesRead;
    private ChannelConfig config;
    private final UncheckedBooleanSupplier defaultMaybeMoreSupplier = new UncheckedBooleanSupplier()
    {
      public boolean get()
      {
        boolean bool;
        if (DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle.this.attemptedBytesRead == DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle.this.lastBytesRead) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
    };
    private int lastBytesRead;
    private int maxMessagePerRead;
    private final boolean respectMaybeMoreData = DefaultMaxMessagesRecvByteBufAllocator.this.respectMaybeMoreData;
    private int totalBytesRead;
    private int totalMessages;
    
    public MaxMessageHandle() {}
    
    public ByteBuf allocate(ByteBufAllocator paramByteBufAllocator)
    {
      return paramByteBufAllocator.ioBuffer(guess());
    }
    
    public int attemptedBytesRead()
    {
      return this.attemptedBytesRead;
    }
    
    public void attemptedBytesRead(int paramInt)
    {
      this.attemptedBytesRead = paramInt;
    }
    
    public boolean continueReading()
    {
      return continueReading(this.defaultMaybeMoreSupplier);
    }
    
    public boolean continueReading(UncheckedBooleanSupplier paramUncheckedBooleanSupplier)
    {
      boolean bool;
      if ((this.config.isAutoRead()) && ((!this.respectMaybeMoreData) || (paramUncheckedBooleanSupplier.get())) && (this.totalMessages < this.maxMessagePerRead) && (this.totalBytesRead > 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public final void incMessagesRead(int paramInt)
    {
      this.totalMessages += paramInt;
    }
    
    public final int lastBytesRead()
    {
      return this.lastBytesRead;
    }
    
    public void lastBytesRead(int paramInt)
    {
      this.lastBytesRead = paramInt;
      if (paramInt > 0) {
        this.totalBytesRead += paramInt;
      }
    }
    
    public void readComplete() {}
    
    public void reset(ChannelConfig paramChannelConfig)
    {
      this.config = paramChannelConfig;
      this.maxMessagePerRead = DefaultMaxMessagesRecvByteBufAllocator.this.maxMessagesPerRead();
      this.totalBytesRead = 0;
      this.totalMessages = 0;
    }
    
    protected final int totalBytesRead()
    {
      int i = this.totalBytesRead;
      int j = i;
      if (i < 0) {
        j = Integer.MAX_VALUE;
      }
      return j;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\DefaultMaxMessagesRecvByteBufAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */