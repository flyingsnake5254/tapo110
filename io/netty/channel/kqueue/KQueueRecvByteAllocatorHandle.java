package io.netty.channel.kqueue;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.RecvByteBufAllocator.DelegatingHandle;
import io.netty.channel.RecvByteBufAllocator.ExtendedHandle;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.unix.PreferredDirectByteBufAllocator;
import io.netty.util.UncheckedBooleanSupplier;

final class KQueueRecvByteAllocatorHandle
  extends RecvByteBufAllocator.DelegatingHandle
  implements RecvByteBufAllocator.ExtendedHandle
{
  private final UncheckedBooleanSupplier defaultMaybeMoreDataSupplier = new UncheckedBooleanSupplier()
  {
    public boolean get()
    {
      return KQueueRecvByteAllocatorHandle.this.maybeMoreDataToRead();
    }
  };
  private long numberBytesPending;
  private boolean overrideGuess;
  private final PreferredDirectByteBufAllocator preferredDirectByteBufAllocator = new PreferredDirectByteBufAllocator();
  private boolean readEOF;
  
  KQueueRecvByteAllocatorHandle(RecvByteBufAllocator.ExtendedHandle paramExtendedHandle)
  {
    super(paramExtendedHandle);
  }
  
  private int guess0()
  {
    return (int)Math.min(this.numberBytesPending, 2147483647L);
  }
  
  public ByteBuf allocate(ByteBufAllocator paramByteBufAllocator)
  {
    this.preferredDirectByteBufAllocator.updateAllocator(paramByteBufAllocator);
    if (this.overrideGuess) {
      paramByteBufAllocator = this.preferredDirectByteBufAllocator.ioBuffer(guess0());
    } else {
      paramByteBufAllocator = delegate().allocate(this.preferredDirectByteBufAllocator);
    }
    return paramByteBufAllocator;
  }
  
  public boolean continueReading()
  {
    return continueReading(this.defaultMaybeMoreDataSupplier);
  }
  
  public boolean continueReading(UncheckedBooleanSupplier paramUncheckedBooleanSupplier)
  {
    return ((RecvByteBufAllocator.ExtendedHandle)delegate()).continueReading(paramUncheckedBooleanSupplier);
  }
  
  public int guess()
  {
    int i;
    if (this.overrideGuess) {
      i = guess0();
    } else {
      i = delegate().guess();
    }
    return i;
  }
  
  boolean isReadEOF()
  {
    return this.readEOF;
  }
  
  public void lastBytesRead(int paramInt)
  {
    long l = 0L;
    if (paramInt >= 0) {
      l = Math.max(0L, this.numberBytesPending - paramInt);
    }
    this.numberBytesPending = l;
    delegate().lastBytesRead(paramInt);
  }
  
  boolean maybeMoreDataToRead()
  {
    boolean bool;
    if (this.numberBytesPending != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  void numberBytesPending(long paramLong)
  {
    this.numberBytesPending = paramLong;
  }
  
  void readEOF()
  {
    this.readEOF = true;
  }
  
  public void reset(ChannelConfig paramChannelConfig)
  {
    this.overrideGuess = ((KQueueChannelConfig)paramChannelConfig).getRcvAllocTransportProvidesGuess();
    delegate().reset(paramChannelConfig);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\KQueueRecvByteAllocatorHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */