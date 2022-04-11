package io.netty.channel.epoll;

import io.netty.channel.unix.Buffer;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

final class EpollEventArray
{
  private static final int EPOLL_DATA_OFFSET = Native.offsetofEpollData();
  private static final int EPOLL_EVENT_SIZE = ;
  private int length;
  private ByteBuffer memory;
  private long memoryAddress;
  
  EpollEventArray(int paramInt)
  {
    if (paramInt >= 1)
    {
      this.length = paramInt;
      localObject = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(paramInt));
      this.memory = ((ByteBuffer)localObject);
      this.memoryAddress = Buffer.memoryAddress((ByteBuffer)localObject);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("length must be >= 1 but was ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private static int calculateBufferCapacity(int paramInt)
  {
    return paramInt * EPOLL_EVENT_SIZE;
  }
  
  private int getInt(int paramInt1, int paramInt2)
  {
    if (PlatformDependent.hasUnsafe()) {
      return PlatformDependent.getInt(this.memoryAddress + paramInt1 * EPOLL_EVENT_SIZE + paramInt2);
    }
    return this.memory.getInt(paramInt1 * EPOLL_EVENT_SIZE + paramInt2);
  }
  
  int events(int paramInt)
  {
    return getInt(paramInt, 0);
  }
  
  int fd(int paramInt)
  {
    return getInt(paramInt, EPOLL_DATA_OFFSET);
  }
  
  void free()
  {
    Buffer.free(this.memory);
    this.memoryAddress = 0L;
  }
  
  void increase()
  {
    int i = this.length << 1;
    this.length = i;
    ByteBuffer localByteBuffer = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(i));
    Buffer.free(this.memory);
    this.memory = localByteBuffer;
    this.memoryAddress = Buffer.memoryAddress(localByteBuffer);
  }
  
  int length()
  {
    return this.length;
  }
  
  long memoryAddress()
  {
    return this.memoryAddress;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\EpollEventArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */