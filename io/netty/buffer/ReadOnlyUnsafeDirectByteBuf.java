package io.netty.buffer;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

final class ReadOnlyUnsafeDirectByteBuf
  extends ReadOnlyByteBufferBuf
{
  private final long memoryAddress = PlatformDependent.directBufferAddress(this.buffer);
  
  ReadOnlyUnsafeDirectByteBuf(ByteBufAllocator paramByteBufAllocator, ByteBuffer paramByteBuffer)
  {
    super(paramByteBufAllocator, paramByteBuffer);
  }
  
  private long addr(int paramInt)
  {
    return this.memoryAddress + paramInt;
  }
  
  protected byte _getByte(int paramInt)
  {
    return UnsafeByteBufUtil.getByte(addr(paramInt));
  }
  
  protected int _getInt(int paramInt)
  {
    return UnsafeByteBufUtil.getInt(addr(paramInt));
  }
  
  protected long _getLong(int paramInt)
  {
    return UnsafeByteBufUtil.getLong(addr(paramInt));
  }
  
  protected short _getShort(int paramInt)
  {
    return UnsafeByteBufUtil.getShort(addr(paramInt));
  }
  
  protected int _getUnsignedMedium(int paramInt)
  {
    return UnsafeByteBufUtil.getUnsignedMedium(addr(paramInt));
  }
  
  public ByteBuf copy(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    ByteBuf localByteBuf = alloc().directBuffer(paramInt2, maxCapacity());
    if (paramInt2 != 0) {
      if (localByteBuf.hasMemoryAddress())
      {
        PlatformDependent.copyMemory(addr(paramInt1), localByteBuf.memoryAddress(), paramInt2);
        localByteBuf.setIndex(0, paramInt2);
      }
      else
      {
        localByteBuf.writeBytes(this, paramInt1, paramInt2);
      }
    }
    return localByteBuf;
  }
  
  public ByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    checkIndex(paramInt1, paramInt3);
    ObjectUtil.checkNotNull(paramByteBuf, "dst");
    if ((paramInt2 >= 0) && (paramInt2 <= paramByteBuf.capacity() - paramInt3))
    {
      if (paramByteBuf.hasMemoryAddress())
      {
        long l1 = addr(paramInt1);
        long l2 = paramByteBuf.memoryAddress();
        PlatformDependent.copyMemory(l1, paramInt2 + l2, paramInt3);
      }
      else if (paramByteBuf.hasArray())
      {
        PlatformDependent.copyMemory(addr(paramInt1), paramByteBuf.array(), paramByteBuf.arrayOffset() + paramInt2, paramInt3);
      }
      else
      {
        paramByteBuf.setBytes(paramInt2, this, paramInt1, paramInt3);
      }
      return this;
    }
    paramByteBuf = new StringBuilder();
    paramByteBuf.append("dstIndex: ");
    paramByteBuf.append(paramInt2);
    throw new IndexOutOfBoundsException(paramByteBuf.toString());
  }
  
  public ByteBuf getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    checkIndex(paramInt1, paramInt3);
    ObjectUtil.checkNotNull(paramArrayOfByte, "dst");
    if ((paramInt2 >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt3))
    {
      if (paramInt3 != 0) {
        PlatformDependent.copyMemory(addr(paramInt1), paramArrayOfByte, paramInt2, paramInt3);
      }
      return this;
    }
    throw new IndexOutOfBoundsException(String.format("dstIndex: %d, length: %d (expected: range(0, %d))", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramArrayOfByte.length) }));
  }
  
  public boolean hasMemoryAddress()
  {
    return true;
  }
  
  public long memoryAddress()
  {
    return this.memoryAddress;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\ReadOnlyUnsafeDirectByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */