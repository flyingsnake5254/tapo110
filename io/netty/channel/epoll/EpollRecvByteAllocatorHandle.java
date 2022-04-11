package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator.DelegatingHandle;
import io.netty.channel.RecvByteBufAllocator.ExtendedHandle;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.unix.PreferredDirectByteBufAllocator;
import io.netty.util.UncheckedBooleanSupplier;

class EpollRecvByteAllocatorHandle
  extends RecvByteBufAllocator.DelegatingHandle
  implements RecvByteBufAllocator.ExtendedHandle
{
  private final UncheckedBooleanSupplier defaultMaybeMoreDataSupplier = new UncheckedBooleanSupplier()
  {
    public boolean get()
    {
      return EpollRecvByteAllocatorHandle.this.maybeMoreDataToRead();
    }
  };
  private boolean isEdgeTriggered;
  private final PreferredDirectByteBufAllocator preferredDirectByteBufAllocator = new PreferredDirectByteBufAllocator();
  private boolean receivedRdHup;
  
  EpollRecvByteAllocatorHandle(RecvByteBufAllocator.ExtendedHandle paramExtendedHandle)
  {
    super(paramExtendedHandle);
  }
  
  public final ByteBuf allocate(ByteBufAllocator paramByteBufAllocator)
  {
    this.preferredDirectByteBufAllocator.updateAllocator(paramByteBufAllocator);
    return delegate().allocate(this.preferredDirectByteBufAllocator);
  }
  
  public final boolean continueReading()
  {
    return continueReading(this.defaultMaybeMoreDataSupplier);
  }
  
  public final boolean continueReading(UncheckedBooleanSupplier paramUncheckedBooleanSupplier)
  {
    return ((RecvByteBufAllocator.ExtendedHandle)delegate()).continueReading(paramUncheckedBooleanSupplier);
  }
  
  final void edgeTriggered(boolean paramBoolean)
  {
    this.isEdgeTriggered = paramBoolean;
  }
  
  final boolean isEdgeTriggered()
  {
    return this.isEdgeTriggered;
  }
  
  final boolean isReceivedRdHup()
  {
    return this.receivedRdHup;
  }
  
  boolean maybeMoreDataToRead()
  {
    boolean bool;
    if (((this.isEdgeTriggered) && (lastBytesRead() > 0)) || ((!this.isEdgeTriggered) && (lastBytesRead() == attemptedBytesRead()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  final void receivedRdHup()
  {
    this.receivedRdHup = true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\EpollRecvByteAllocatorHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */