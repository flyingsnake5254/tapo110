package io.netty.channel.kqueue;

import io.netty.channel.unix.FileDescriptor;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

final class KQueueEventArray
{
  private static final int KQUEUE_DATA_OFFSET = Native.offsetofKeventData();
  private static final int KQUEUE_EVENT_SIZE = ;
  private static final int KQUEUE_FFLAGS_OFFSET;
  private static final int KQUEUE_FILTER_OFFSET;
  private static final int KQUEUE_FLAGS_OFFSET;
  private static final int KQUEUE_IDENT_OFFSET = Native.offsetofKEventIdent();
  private int capacity;
  private ByteBuffer memory;
  private long memoryAddress;
  private int size;
  
  static
  {
    KQUEUE_FILTER_OFFSET = Native.offsetofKEventFilter();
    KQUEUE_FFLAGS_OFFSET = Native.offsetofKEventFFlags();
    KQUEUE_FLAGS_OFFSET = Native.offsetofKEventFlags();
  }
  
  KQueueEventArray(int paramInt)
  {
    if (paramInt >= 1)
    {
      localObject = io.netty.channel.unix.Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(paramInt));
      this.memory = ((ByteBuffer)localObject);
      this.memoryAddress = io.netty.channel.unix.Buffer.memoryAddress((ByteBuffer)localObject);
      this.capacity = paramInt;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("capacity must be >= 1 but was ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private static int calculateBufferCapacity(int paramInt)
  {
    return paramInt * KQUEUE_EVENT_SIZE;
  }
  
  private static native void evSet(long paramLong, int paramInt1, short paramShort1, short paramShort2, int paramInt2);
  
  private static int getKEventOffset(int paramInt)
  {
    return paramInt * KQUEUE_EVENT_SIZE;
  }
  
  private long getKEventOffsetAddress(int paramInt)
  {
    return getKEventOffset(paramInt) + this.memoryAddress;
  }
  
  private short getShort(int paramInt1, int paramInt2)
  {
    if (PlatformDependent.hasUnsafe()) {
      return PlatformDependent.getShort(getKEventOffsetAddress(paramInt1) + paramInt2);
    }
    return this.memory.getShort(getKEventOffset(paramInt1) + paramInt2);
  }
  
  private void reallocIfNeeded()
  {
    if (this.size == this.capacity) {
      realloc(true);
    }
  }
  
  int capacity()
  {
    return this.capacity;
  }
  
  void clear()
  {
    this.size = 0;
  }
  
  long data(int paramInt)
  {
    if (PlatformDependent.hasUnsafe()) {
      return PlatformDependent.getLong(getKEventOffsetAddress(paramInt) + KQUEUE_DATA_OFFSET);
    }
    return this.memory.getLong(getKEventOffset(paramInt) + KQUEUE_DATA_OFFSET);
  }
  
  void evSet(AbstractKQueueChannel paramAbstractKQueueChannel, short paramShort1, short paramShort2, int paramInt)
  {
    reallocIfNeeded();
    int i = this.size;
    this.size = (i + 1);
    evSet(getKEventOffset(i) + this.memoryAddress, paramAbstractKQueueChannel.socket.intValue(), paramShort1, paramShort2, paramInt);
  }
  
  int fd(int paramInt)
  {
    if (PlatformDependent.hasUnsafe()) {
      return PlatformDependent.getInt(getKEventOffsetAddress(paramInt) + KQUEUE_IDENT_OFFSET);
    }
    return this.memory.getInt(getKEventOffset(paramInt) + KQUEUE_IDENT_OFFSET);
  }
  
  short fflags(int paramInt)
  {
    return getShort(paramInt, KQUEUE_FFLAGS_OFFSET);
  }
  
  short filter(int paramInt)
  {
    return getShort(paramInt, KQUEUE_FILTER_OFFSET);
  }
  
  short flags(int paramInt)
  {
    return getShort(paramInt, KQUEUE_FLAGS_OFFSET);
  }
  
  void free()
  {
    io.netty.channel.unix.Buffer.free(this.memory);
    this.capacity = 0;
    this.size = 0;
    this.memoryAddress = 0;
  }
  
  long memoryAddress()
  {
    return this.memoryAddress;
  }
  
  void realloc(boolean paramBoolean)
  {
    int i = this.capacity;
    if (i <= 65536) {
      i <<= 1;
    } else {
      i = i + i >> 1;
    }
    try
    {
      ByteBuffer localByteBuffer = io.netty.channel.unix.Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(i));
      this.memory.position(0).limit(this.size);
      localByteBuffer.put(this.memory);
      localByteBuffer.position(0);
      io.netty.channel.unix.Buffer.free(this.memory);
      this.memory = localByteBuffer;
      this.memoryAddress = io.netty.channel.unix.Buffer.memoryAddress(localByteBuffer);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (paramBoolean) {
        break label92;
      }
    }
    return;
    label92:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unable to allocate ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" new bytes! Existing capacity is: ");
    ((StringBuilder)localObject).append(this.capacity);
    localObject = new OutOfMemoryError(((StringBuilder)localObject).toString());
    ((OutOfMemoryError)localObject).initCause(localOutOfMemoryError);
    throw ((Throwable)localObject);
  }
  
  int size()
  {
    return this.size;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\KQueueEventArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */