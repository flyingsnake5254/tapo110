package io.netty.buffer;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

public class UnpooledHeapByteBuf
  extends AbstractReferenceCountedByteBuf
{
  private final ByteBufAllocator alloc;
  byte[] array;
  private ByteBuffer tmpNioBuf;
  
  public UnpooledHeapByteBuf(ByteBufAllocator paramByteBufAllocator, int paramInt1, int paramInt2)
  {
    super(paramInt2);
    if (paramInt1 <= paramInt2)
    {
      this.alloc = ((ByteBufAllocator)ObjectUtil.checkNotNull(paramByteBufAllocator, "alloc"));
      setArray(allocateArray(paramInt1));
      setIndex(0, 0);
      return;
    }
    throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  protected UnpooledHeapByteBuf(ByteBufAllocator paramByteBufAllocator, byte[] paramArrayOfByte, int paramInt)
  {
    super(paramInt);
    ObjectUtil.checkNotNull(paramByteBufAllocator, "alloc");
    ObjectUtil.checkNotNull(paramArrayOfByte, "initialArray");
    if (paramArrayOfByte.length <= paramInt)
    {
      this.alloc = paramByteBufAllocator;
      setArray(paramArrayOfByte);
      setIndex(0, paramArrayOfByte.length);
      return;
    }
    throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) }));
  }
  
  private int getBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    ensureAccessible();
    ByteBuffer localByteBuffer;
    if (paramBoolean) {
      localByteBuffer = internalNioBuffer();
    } else {
      localByteBuffer = ByteBuffer.wrap(this.array);
    }
    return paramFileChannel.write((ByteBuffer)localByteBuffer.clear().position(paramInt1).limit(paramInt1 + paramInt2), paramLong);
  }
  
  private int getBytes(int paramInt1, GatheringByteChannel paramGatheringByteChannel, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    ensureAccessible();
    ByteBuffer localByteBuffer;
    if (paramBoolean) {
      localByteBuffer = internalNioBuffer();
    } else {
      localByteBuffer = ByteBuffer.wrap(this.array);
    }
    return paramGatheringByteChannel.write((ByteBuffer)localByteBuffer.clear().position(paramInt1).limit(paramInt1 + paramInt2));
  }
  
  private ByteBuffer internalNioBuffer()
  {
    ByteBuffer localByteBuffer1 = this.tmpNioBuf;
    ByteBuffer localByteBuffer2 = localByteBuffer1;
    if (localByteBuffer1 == null)
    {
      localByteBuffer2 = ByteBuffer.wrap(this.array);
      this.tmpNioBuf = localByteBuffer2;
    }
    return localByteBuffer2;
  }
  
  private void setArray(byte[] paramArrayOfByte)
  {
    this.array = paramArrayOfByte;
    this.tmpNioBuf = null;
  }
  
  protected byte _getByte(int paramInt)
  {
    return HeapByteBufUtil.getByte(this.array, paramInt);
  }
  
  protected int _getInt(int paramInt)
  {
    return HeapByteBufUtil.getInt(this.array, paramInt);
  }
  
  protected int _getIntLE(int paramInt)
  {
    return HeapByteBufUtil.getIntLE(this.array, paramInt);
  }
  
  protected long _getLong(int paramInt)
  {
    return HeapByteBufUtil.getLong(this.array, paramInt);
  }
  
  protected long _getLongLE(int paramInt)
  {
    return HeapByteBufUtil.getLongLE(this.array, paramInt);
  }
  
  protected short _getShort(int paramInt)
  {
    return HeapByteBufUtil.getShort(this.array, paramInt);
  }
  
  protected short _getShortLE(int paramInt)
  {
    return HeapByteBufUtil.getShortLE(this.array, paramInt);
  }
  
  protected int _getUnsignedMedium(int paramInt)
  {
    return HeapByteBufUtil.getUnsignedMedium(this.array, paramInt);
  }
  
  protected int _getUnsignedMediumLE(int paramInt)
  {
    return HeapByteBufUtil.getUnsignedMediumLE(this.array, paramInt);
  }
  
  protected void _setByte(int paramInt1, int paramInt2)
  {
    HeapByteBufUtil.setByte(this.array, paramInt1, paramInt2);
  }
  
  protected void _setInt(int paramInt1, int paramInt2)
  {
    HeapByteBufUtil.setInt(this.array, paramInt1, paramInt2);
  }
  
  protected void _setIntLE(int paramInt1, int paramInt2)
  {
    HeapByteBufUtil.setIntLE(this.array, paramInt1, paramInt2);
  }
  
  protected void _setLong(int paramInt, long paramLong)
  {
    HeapByteBufUtil.setLong(this.array, paramInt, paramLong);
  }
  
  protected void _setLongLE(int paramInt, long paramLong)
  {
    HeapByteBufUtil.setLongLE(this.array, paramInt, paramLong);
  }
  
  protected void _setMedium(int paramInt1, int paramInt2)
  {
    HeapByteBufUtil.setMedium(this.array, paramInt1, paramInt2);
  }
  
  protected void _setMediumLE(int paramInt1, int paramInt2)
  {
    HeapByteBufUtil.setMediumLE(this.array, paramInt1, paramInt2);
  }
  
  protected void _setShort(int paramInt1, int paramInt2)
  {
    HeapByteBufUtil.setShort(this.array, paramInt1, paramInt2);
  }
  
  protected void _setShortLE(int paramInt1, int paramInt2)
  {
    HeapByteBufUtil.setShortLE(this.array, paramInt1, paramInt2);
  }
  
  public ByteBufAllocator alloc()
  {
    return this.alloc;
  }
  
  protected byte[] allocateArray(int paramInt)
  {
    return new byte[paramInt];
  }
  
  public byte[] array()
  {
    ensureAccessible();
    return this.array;
  }
  
  public int arrayOffset()
  {
    return 0;
  }
  
  public int capacity()
  {
    return this.array.length;
  }
  
  public ByteBuf capacity(int paramInt)
  {
    checkNewCapacity(paramInt);
    byte[] arrayOfByte1 = this.array;
    int i = arrayOfByte1.length;
    if (paramInt == i) {
      return this;
    }
    if (paramInt <= i)
    {
      trimIndicesToCapacity(paramInt);
      i = paramInt;
    }
    byte[] arrayOfByte2 = allocateArray(paramInt);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
    setArray(arrayOfByte2);
    freeArray(arrayOfByte1);
    return this;
  }
  
  public ByteBuf copy(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return alloc().heapBuffer(paramInt2, maxCapacity()).writeBytes(this.array, paramInt1, paramInt2);
  }
  
  protected void deallocate()
  {
    freeArray(this.array);
    this.array = EmptyArrays.EMPTY_BYTES;
  }
  
  protected void freeArray(byte[] paramArrayOfByte) {}
  
  public byte getByte(int paramInt)
  {
    ensureAccessible();
    return _getByte(paramInt);
  }
  
  public int getBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    ensureAccessible();
    return getBytes(paramInt1, paramFileChannel, paramLong, paramInt2, false);
  }
  
  public int getBytes(int paramInt1, GatheringByteChannel paramGatheringByteChannel, int paramInt2)
    throws IOException
  {
    ensureAccessible();
    return getBytes(paramInt1, paramGatheringByteChannel, paramInt2, false);
  }
  
  public ByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    checkDstIndex(paramInt1, paramInt3, paramInt2, paramByteBuf.capacity());
    if (paramByteBuf.hasMemoryAddress()) {
      PlatformDependent.copyMemory(this.array, paramInt1, paramByteBuf.memoryAddress() + paramInt2, paramInt3);
    } else if (paramByteBuf.hasArray()) {
      getBytes(paramInt1, paramByteBuf.array(), paramByteBuf.arrayOffset() + paramInt2, paramInt3);
    } else {
      paramByteBuf.setBytes(paramInt2, this.array, paramInt1, paramInt3);
    }
    return this;
  }
  
  public ByteBuf getBytes(int paramInt1, OutputStream paramOutputStream, int paramInt2)
    throws IOException
  {
    ensureAccessible();
    paramOutputStream.write(this.array, paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    ensureAccessible();
    paramByteBuffer.put(this.array, paramInt, paramByteBuffer.remaining());
    return this;
  }
  
  public ByteBuf getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    checkDstIndex(paramInt1, paramInt3, paramInt2, paramArrayOfByte.length);
    System.arraycopy(this.array, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    return this;
  }
  
  public int getInt(int paramInt)
  {
    ensureAccessible();
    return _getInt(paramInt);
  }
  
  public int getIntLE(int paramInt)
  {
    ensureAccessible();
    return _getIntLE(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    ensureAccessible();
    return _getLong(paramInt);
  }
  
  public long getLongLE(int paramInt)
  {
    ensureAccessible();
    return _getLongLE(paramInt);
  }
  
  public short getShort(int paramInt)
  {
    ensureAccessible();
    return _getShort(paramInt);
  }
  
  public short getShortLE(int paramInt)
  {
    ensureAccessible();
    return _getShortLE(paramInt);
  }
  
  public int getUnsignedMedium(int paramInt)
  {
    ensureAccessible();
    return _getUnsignedMedium(paramInt);
  }
  
  public int getUnsignedMediumLE(int paramInt)
  {
    ensureAccessible();
    return _getUnsignedMediumLE(paramInt);
  }
  
  public boolean hasArray()
  {
    return true;
  }
  
  public boolean hasMemoryAddress()
  {
    return false;
  }
  
  public ByteBuffer internalNioBuffer(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return (ByteBuffer)internalNioBuffer().clear().position(paramInt1).limit(paramInt1 + paramInt2);
  }
  
  public final boolean isContiguous()
  {
    return true;
  }
  
  public boolean isDirect()
  {
    return false;
  }
  
  public long memoryAddress()
  {
    throw new UnsupportedOperationException();
  }
  
  public ByteBuffer nioBuffer(int paramInt1, int paramInt2)
  {
    ensureAccessible();
    return ByteBuffer.wrap(this.array, paramInt1, paramInt2).slice();
  }
  
  public int nioBufferCount()
  {
    return 1;
  }
  
  public ByteBuffer[] nioBuffers(int paramInt1, int paramInt2)
  {
    return new ByteBuffer[] { nioBuffer(paramInt1, paramInt2) };
  }
  
  public ByteOrder order()
  {
    return ByteOrder.BIG_ENDIAN;
  }
  
  public int readBytes(FileChannel paramFileChannel, long paramLong, int paramInt)
    throws IOException
  {
    checkReadableBytes(paramInt);
    paramInt = getBytes(this.readerIndex, paramFileChannel, paramLong, paramInt, true);
    this.readerIndex += paramInt;
    return paramInt;
  }
  
  public int readBytes(GatheringByteChannel paramGatheringByteChannel, int paramInt)
    throws IOException
  {
    checkReadableBytes(paramInt);
    paramInt = getBytes(this.readerIndex, paramGatheringByteChannel, paramInt, true);
    this.readerIndex += paramInt;
    return paramInt;
  }
  
  public ByteBuf setByte(int paramInt1, int paramInt2)
  {
    ensureAccessible();
    _setByte(paramInt1, paramInt2);
    return this;
  }
  
  public int setBytes(int paramInt1, InputStream paramInputStream, int paramInt2)
    throws IOException
  {
    ensureAccessible();
    return paramInputStream.read(this.array, paramInt1, paramInt2);
  }
  
  public int setBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    ensureAccessible();
    try
    {
      paramInt1 = paramFileChannel.read((ByteBuffer)internalNioBuffer().clear().position(paramInt1).limit(paramInt1 + paramInt2), paramLong);
      return paramInt1;
    }
    catch (ClosedChannelException paramFileChannel) {}
    return -1;
  }
  
  public int setBytes(int paramInt1, ScatteringByteChannel paramScatteringByteChannel, int paramInt2)
    throws IOException
  {
    ensureAccessible();
    try
    {
      paramInt1 = paramScatteringByteChannel.read((ByteBuffer)internalNioBuffer().clear().position(paramInt1).limit(paramInt1 + paramInt2));
      return paramInt1;
    }
    catch (ClosedChannelException paramScatteringByteChannel) {}
    return -1;
  }
  
  public ByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    checkSrcIndex(paramInt1, paramInt3, paramInt2, paramByteBuf.capacity());
    if (paramByteBuf.hasMemoryAddress()) {
      PlatformDependent.copyMemory(paramByteBuf.memoryAddress() + paramInt2, this.array, paramInt1, paramInt3);
    } else if (paramByteBuf.hasArray()) {
      setBytes(paramInt1, paramByteBuf.array(), paramByteBuf.arrayOffset() + paramInt2, paramInt3);
    } else {
      paramByteBuf.getBytes(paramInt2, this.array, paramInt1, paramInt3);
    }
    return this;
  }
  
  public ByteBuf setBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    ensureAccessible();
    paramByteBuffer.get(this.array, paramInt, paramByteBuffer.remaining());
    return this;
  }
  
  public ByteBuf setBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    checkSrcIndex(paramInt1, paramInt3, paramInt2, paramArrayOfByte.length);
    System.arraycopy(paramArrayOfByte, paramInt2, this.array, paramInt1, paramInt3);
    return this;
  }
  
  public ByteBuf setInt(int paramInt1, int paramInt2)
  {
    ensureAccessible();
    _setInt(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setIntLE(int paramInt1, int paramInt2)
  {
    ensureAccessible();
    _setIntLE(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setLong(int paramInt, long paramLong)
  {
    ensureAccessible();
    _setLong(paramInt, paramLong);
    return this;
  }
  
  public ByteBuf setLongLE(int paramInt, long paramLong)
  {
    ensureAccessible();
    _setLongLE(paramInt, paramLong);
    return this;
  }
  
  public ByteBuf setMedium(int paramInt1, int paramInt2)
  {
    ensureAccessible();
    _setMedium(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setMediumLE(int paramInt1, int paramInt2)
  {
    ensureAccessible();
    _setMediumLE(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setShort(int paramInt1, int paramInt2)
  {
    ensureAccessible();
    _setShort(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setShortLE(int paramInt1, int paramInt2)
  {
    ensureAccessible();
    _setShortLE(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf unwrap()
  {
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\UnpooledHeapByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */