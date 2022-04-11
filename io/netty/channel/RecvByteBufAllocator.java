package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.UncheckedBooleanSupplier;
import io.netty.util.internal.ObjectUtil;

public abstract interface RecvByteBufAllocator
{
  public abstract Handle newHandle();
  
  public static class DelegatingHandle
    implements RecvByteBufAllocator.Handle
  {
    private final RecvByteBufAllocator.Handle delegate;
    
    public DelegatingHandle(RecvByteBufAllocator.Handle paramHandle)
    {
      this.delegate = ((RecvByteBufAllocator.Handle)ObjectUtil.checkNotNull(paramHandle, "delegate"));
    }
    
    public ByteBuf allocate(ByteBufAllocator paramByteBufAllocator)
    {
      return this.delegate.allocate(paramByteBufAllocator);
    }
    
    public int attemptedBytesRead()
    {
      return this.delegate.attemptedBytesRead();
    }
    
    public void attemptedBytesRead(int paramInt)
    {
      this.delegate.attemptedBytesRead(paramInt);
    }
    
    public boolean continueReading()
    {
      return this.delegate.continueReading();
    }
    
    protected final RecvByteBufAllocator.Handle delegate()
    {
      return this.delegate;
    }
    
    public int guess()
    {
      return this.delegate.guess();
    }
    
    public void incMessagesRead(int paramInt)
    {
      this.delegate.incMessagesRead(paramInt);
    }
    
    public int lastBytesRead()
    {
      return this.delegate.lastBytesRead();
    }
    
    public void lastBytesRead(int paramInt)
    {
      this.delegate.lastBytesRead(paramInt);
    }
    
    public void readComplete()
    {
      this.delegate.readComplete();
    }
    
    public void reset(ChannelConfig paramChannelConfig)
    {
      this.delegate.reset(paramChannelConfig);
    }
  }
  
  public static abstract interface ExtendedHandle
    extends RecvByteBufAllocator.Handle
  {
    public abstract boolean continueReading(UncheckedBooleanSupplier paramUncheckedBooleanSupplier);
  }
  
  @Deprecated
  public static abstract interface Handle
  {
    public abstract ByteBuf allocate(ByteBufAllocator paramByteBufAllocator);
    
    public abstract int attemptedBytesRead();
    
    public abstract void attemptedBytesRead(int paramInt);
    
    public abstract boolean continueReading();
    
    public abstract int guess();
    
    public abstract void incMessagesRead(int paramInt);
    
    public abstract int lastBytesRead();
    
    public abstract void lastBytesRead(int paramInt);
    
    public abstract void readComplete();
    
    public abstract void reset(ChannelConfig paramChannelConfig);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\RecvByteBufAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */