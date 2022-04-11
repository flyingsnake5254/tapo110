package io.netty.channel.epoll;

import io.netty.channel.RecvByteBufAllocator.DelegatingHandle;
import io.netty.channel.RecvByteBufAllocator.ExtendedHandle;

final class EpollRecvByteAllocatorStreamingHandle
  extends EpollRecvByteAllocatorHandle
{
  EpollRecvByteAllocatorStreamingHandle(RecvByteBufAllocator.ExtendedHandle paramExtendedHandle)
  {
    super(paramExtendedHandle);
  }
  
  boolean maybeMoreDataToRead()
  {
    boolean bool;
    if ((lastBytesRead() != attemptedBytesRead()) && (!isReceivedRdHup())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\EpollRecvByteAllocatorStreamingHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */