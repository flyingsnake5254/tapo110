package io.netty.channel.kqueue;

import io.netty.channel.unix.Limits;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

final class NativeLongArray
{
  private int capacity;
  private ByteBuffer memory;
  private long memoryAddress;
  private int size;
  
  NativeLongArray(int paramInt)
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
    return paramInt * Limits.SIZEOF_JLONG;
  }
  
  private static int idx(int paramInt)
  {
    return paramInt * Limits.SIZEOF_JLONG;
  }
  
  private long memoryOffset(int paramInt)
  {
    return this.memoryAddress + idx(paramInt);
  }
  
  private void reallocIfNeeded()
  {
    int i = this.size;
    int j = this.capacity;
    if (i == j)
    {
      if (j <= 65536) {
        j <<= 1;
      } else {
        j = j + j >> 1;
      }
      ByteBuffer localByteBuffer = io.netty.channel.unix.Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(j));
      this.memory.position(0).limit(this.size);
      localByteBuffer.put(this.memory);
      localByteBuffer.position(0);
      io.netty.channel.unix.Buffer.free(this.memory);
      this.memory = localByteBuffer;
      this.memoryAddress = io.netty.channel.unix.Buffer.memoryAddress(localByteBuffer);
      this.capacity = j;
    }
  }
  
  void add(long paramLong)
  {
    reallocIfNeeded();
    if (PlatformDependent.hasUnsafe()) {
      PlatformDependent.putLong(memoryOffset(this.size), paramLong);
    } else {
      this.memory.putLong(idx(this.size), paramLong);
    }
    this.size += 1;
  }
  
  void clear()
  {
    this.size = 0;
  }
  
  void free()
  {
    io.netty.channel.unix.Buffer.free(this.memory);
    this.memoryAddress = 0L;
  }
  
  boolean isEmpty()
  {
    boolean bool;
    if (this.size == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  long memoryAddress()
  {
    return this.memoryAddress;
  }
  
  long memoryAddressEnd()
  {
    return memoryOffset(this.size);
  }
  
  int size()
  {
    return this.size;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("memoryAddress: ");
    localStringBuilder.append(this.memoryAddress);
    localStringBuilder.append(" capacity: ");
    localStringBuilder.append(this.capacity);
    localStringBuilder.append(" size: ");
    localStringBuilder.append(this.size);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\NativeLongArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */