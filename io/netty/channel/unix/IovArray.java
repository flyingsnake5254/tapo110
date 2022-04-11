package io.netty.channel.unix;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelOutboundBuffer.MessageProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

public final class IovArray
  implements ChannelOutboundBuffer.MessageProcessor
{
  private static final int ADDRESS_SIZE;
  private static final int CAPACITY;
  private static final int IOV_SIZE;
  private int count;
  private long maxBytes = Limits.SSIZE_MAX;
  private final ByteBuffer memory;
  private final long memoryAddress;
  private long size;
  
  static
  {
    int i = Buffer.addressSize();
    ADDRESS_SIZE = i;
    i *= 2;
    IOV_SIZE = i;
    CAPACITY = Limits.IOV_MAX * i;
  }
  
  public IovArray()
  {
    ByteBuffer localByteBuffer = Buffer.allocateDirectWithNativeOrder(CAPACITY);
    this.memory = localByteBuffer;
    this.memoryAddress = Buffer.memoryAddress(localByteBuffer);
  }
  
  private boolean add(long paramLong, int paramInt)
  {
    long l1 = this.maxBytes;
    long l2 = paramInt;
    if ((l1 - l2 < this.size) && (this.count > 0)) {
      return false;
    }
    int i = idx(this.count);
    int j = ADDRESS_SIZE;
    int k = i + j;
    this.size += l2;
    this.count += 1;
    if (j == 8)
    {
      if (PlatformDependent.hasUnsafe())
      {
        PlatformDependent.putLong(i + this.memoryAddress, paramLong);
        PlatformDependent.putLong(k + this.memoryAddress, l2);
      }
      else
      {
        this.memory.putLong(i, paramLong);
        this.memory.putLong(k, l2);
      }
    }
    else if (PlatformDependent.hasUnsafe())
    {
      PlatformDependent.putInt(i + this.memoryAddress, (int)paramLong);
      PlatformDependent.putInt(k + this.memoryAddress, paramInt);
    }
    else
    {
      this.memory.putInt(i, (int)paramLong);
      this.memory.putInt(k, paramInt);
    }
    return true;
  }
  
  private static int idx(int paramInt)
  {
    return IOV_SIZE * paramInt;
  }
  
  @Deprecated
  public boolean add(ByteBuf paramByteBuf)
  {
    return add(paramByteBuf, paramByteBuf.readerIndex(), paramByteBuf.readableBytes());
  }
  
  public boolean add(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    if (this.count == Limits.IOV_MAX) {
      return false;
    }
    if (paramByteBuf.nioBufferCount() == 1)
    {
      if (paramInt2 == 0) {
        return true;
      }
      if (paramByteBuf.hasMemoryAddress()) {
        return add(paramByteBuf.memoryAddress() + paramInt1, paramInt2);
      }
      paramByteBuf = paramByteBuf.internalNioBuffer(paramInt1, paramInt2);
      return add(Buffer.memoryAddress(paramByteBuf) + paramByteBuf.position(), paramInt2);
    }
    for (paramByteBuf : paramByteBuf.nioBuffers(paramInt1, paramInt2))
    {
      int i = paramByteBuf.remaining();
      if ((i != 0) && ((!add(Buffer.memoryAddress(paramByteBuf) + paramByteBuf.position(), i)) || (this.count == Limits.IOV_MAX))) {
        return false;
      }
    }
    return true;
  }
  
  public void clear()
  {
    this.count = 0;
    this.size = 0L;
  }
  
  public int count()
  {
    return this.count;
  }
  
  public long maxBytes()
  {
    return this.maxBytes;
  }
  
  public void maxBytes(long paramLong)
  {
    this.maxBytes = Math.min(Limits.SSIZE_MAX, ObjectUtil.checkPositive(paramLong, "maxBytes"));
  }
  
  public long memoryAddress(int paramInt)
  {
    return this.memoryAddress + idx(paramInt);
  }
  
  public boolean processMessage(Object paramObject)
    throws Exception
  {
    if ((paramObject instanceof ByteBuf))
    {
      paramObject = (ByteBuf)paramObject;
      return add((ByteBuf)paramObject, ((ByteBuf)paramObject).readerIndex(), ((ByteBuf)paramObject).readableBytes());
    }
    return false;
  }
  
  public void release()
  {
    Buffer.free(this.memory);
  }
  
  public long size()
  {
    return this.size;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\unix\IovArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */