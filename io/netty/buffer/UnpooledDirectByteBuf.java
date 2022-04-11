package io.netty.buffer;

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

public class UnpooledDirectByteBuf
  extends AbstractReferenceCountedByteBuf
{
  private final ByteBufAllocator alloc;
  ByteBuffer buffer;
  private int capacity;
  private boolean doNotFree;
  private ByteBuffer tmpNioBuf;
  
  public UnpooledDirectByteBuf(ByteBufAllocator paramByteBufAllocator, int paramInt1, int paramInt2)
  {
    super(paramInt2);
    ObjectUtil.checkNotNull(paramByteBufAllocator, "alloc");
    ObjectUtil.checkPositiveOrZero(paramInt1, "initialCapacity");
    ObjectUtil.checkPositiveOrZero(paramInt2, "maxCapacity");
    if (paramInt1 <= paramInt2)
    {
      this.alloc = paramByteBufAllocator;
      setByteBuffer(allocateDirect(paramInt1), false);
      return;
    }
    throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  protected UnpooledDirectByteBuf(ByteBufAllocator paramByteBufAllocator, ByteBuffer paramByteBuffer, int paramInt)
  {
    this(paramByteBufAllocator, paramByteBuffer, paramInt, false, true);
  }
  
  UnpooledDirectByteBuf(ByteBufAllocator paramByteBufAllocator, ByteBuffer paramByteBuffer, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramInt);
    ObjectUtil.checkNotNull(paramByteBufAllocator, "alloc");
    ObjectUtil.checkNotNull(paramByteBuffer, "initialBuffer");
    if (paramByteBuffer.isDirect())
    {
      if (!paramByteBuffer.isReadOnly())
      {
        int i = paramByteBuffer.remaining();
        if (i <= paramInt)
        {
          this.alloc = paramByteBufAllocator;
          this.doNotFree = (paramBoolean1 ^ true);
          paramByteBufAllocator = paramByteBuffer;
          if (paramBoolean2) {
            paramByteBufAllocator = paramByteBuffer.slice();
          }
          setByteBuffer(paramByteBufAllocator.order(ByteOrder.BIG_ENDIAN), false);
          writerIndex(i);
          return;
        }
        throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) }));
      }
      throw new IllegalArgumentException("initialBuffer is a read-only buffer.");
    }
    throw new IllegalArgumentException("initialBuffer is not a direct buffer.");
  }
  
  private int getBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    ensureAccessible();
    if (paramInt2 == 0) {
      return 0;
    }
    ByteBuffer localByteBuffer;
    if (paramBoolean) {
      localByteBuffer = internalNioBuffer();
    } else {
      localByteBuffer = this.buffer.duplicate();
    }
    localByteBuffer.clear().position(paramInt1).limit(paramInt1 + paramInt2);
    return paramFileChannel.write(localByteBuffer, paramLong);
  }
  
  private int getBytes(int paramInt1, GatheringByteChannel paramGatheringByteChannel, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    ensureAccessible();
    if (paramInt2 == 0) {
      return 0;
    }
    ByteBuffer localByteBuffer;
    if (paramBoolean) {
      localByteBuffer = internalNioBuffer();
    } else {
      localByteBuffer = this.buffer.duplicate();
    }
    localByteBuffer.clear().position(paramInt1).limit(paramInt1 + paramInt2);
    return paramGatheringByteChannel.write(localByteBuffer);
  }
  
  private ByteBuffer internalNioBuffer()
  {
    ByteBuffer localByteBuffer1 = this.tmpNioBuf;
    ByteBuffer localByteBuffer2 = localByteBuffer1;
    if (localByteBuffer1 == null)
    {
      localByteBuffer2 = this.buffer.duplicate();
      this.tmpNioBuf = localByteBuffer2;
    }
    return localByteBuffer2;
  }
  
  protected byte _getByte(int paramInt)
  {
    return this.buffer.get(paramInt);
  }
  
  protected int _getInt(int paramInt)
  {
    return this.buffer.getInt(paramInt);
  }
  
  protected int _getIntLE(int paramInt)
  {
    return ByteBufUtil.swapInt(this.buffer.getInt(paramInt));
  }
  
  protected long _getLong(int paramInt)
  {
    return this.buffer.getLong(paramInt);
  }
  
  protected long _getLongLE(int paramInt)
  {
    return ByteBufUtil.swapLong(this.buffer.getLong(paramInt));
  }
  
  protected short _getShort(int paramInt)
  {
    return this.buffer.getShort(paramInt);
  }
  
  protected short _getShortLE(int paramInt)
  {
    return ByteBufUtil.swapShort(this.buffer.getShort(paramInt));
  }
  
  protected int _getUnsignedMedium(int paramInt)
  {
    int i = getByte(paramInt);
    int j = getByte(paramInt + 1);
    return getByte(paramInt + 2) & 0xFF | (i & 0xFF) << 16 | (j & 0xFF) << 8;
  }
  
  protected int _getUnsignedMediumLE(int paramInt)
  {
    int i = getByte(paramInt);
    int j = getByte(paramInt + 1);
    return (getByte(paramInt + 2) & 0xFF) << 16 | i & 0xFF | (j & 0xFF) << 8;
  }
  
  protected void _setByte(int paramInt1, int paramInt2)
  {
    this.buffer.put(paramInt1, (byte)paramInt2);
  }
  
  protected void _setInt(int paramInt1, int paramInt2)
  {
    this.buffer.putInt(paramInt1, paramInt2);
  }
  
  protected void _setIntLE(int paramInt1, int paramInt2)
  {
    this.buffer.putInt(paramInt1, ByteBufUtil.swapInt(paramInt2));
  }
  
  protected void _setLong(int paramInt, long paramLong)
  {
    this.buffer.putLong(paramInt, paramLong);
  }
  
  protected void _setLongLE(int paramInt, long paramLong)
  {
    this.buffer.putLong(paramInt, ByteBufUtil.swapLong(paramLong));
  }
  
  protected void _setMedium(int paramInt1, int paramInt2)
  {
    setByte(paramInt1, (byte)(paramInt2 >>> 16));
    setByte(paramInt1 + 1, (byte)(paramInt2 >>> 8));
    setByte(paramInt1 + 2, (byte)paramInt2);
  }
  
  protected void _setMediumLE(int paramInt1, int paramInt2)
  {
    setByte(paramInt1, (byte)paramInt2);
    setByte(paramInt1 + 1, (byte)(paramInt2 >>> 8));
    setByte(paramInt1 + 2, (byte)(paramInt2 >>> 16));
  }
  
  protected void _setShort(int paramInt1, int paramInt2)
  {
    this.buffer.putShort(paramInt1, (short)paramInt2);
  }
  
  protected void _setShortLE(int paramInt1, int paramInt2)
  {
    this.buffer.putShort(paramInt1, ByteBufUtil.swapShort((short)paramInt2));
  }
  
  public ByteBufAllocator alloc()
  {
    return this.alloc;
  }
  
  protected ByteBuffer allocateDirect(int paramInt)
  {
    return ByteBuffer.allocateDirect(paramInt);
  }
  
  public byte[] array()
  {
    throw new UnsupportedOperationException("direct buffer");
  }
  
  public int arrayOffset()
  {
    throw new UnsupportedOperationException("direct buffer");
  }
  
  public int capacity()
  {
    return this.capacity;
  }
  
  public ByteBuf capacity(int paramInt)
  {
    checkNewCapacity(paramInt);
    int i = this.capacity;
    if (paramInt == i) {
      return this;
    }
    if (paramInt <= i)
    {
      trimIndicesToCapacity(paramInt);
      i = paramInt;
    }
    ByteBuffer localByteBuffer1 = this.buffer;
    ByteBuffer localByteBuffer2 = allocateDirect(paramInt);
    localByteBuffer1.position(0).limit(i);
    localByteBuffer2.position(0).limit(i);
    localByteBuffer2.put(localByteBuffer1).clear();
    setByteBuffer(localByteBuffer2, true);
    return this;
  }
  
  public ByteBuf copy(int paramInt1, int paramInt2)
  {
    ensureAccessible();
    try
    {
      ByteBuffer localByteBuffer = (ByteBuffer)this.buffer.duplicate().clear().position(paramInt1).limit(paramInt1 + paramInt2);
      return alloc().directBuffer(paramInt2, maxCapacity()).writeBytes(localByteBuffer);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Too many bytes to read - Need ");
      localStringBuilder.append(paramInt1 + paramInt2);
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
  }
  
  protected void deallocate()
  {
    ByteBuffer localByteBuffer = this.buffer;
    if (localByteBuffer == null) {
      return;
    }
    this.buffer = null;
    if (!this.doNotFree) {
      freeDirect(localByteBuffer);
    }
  }
  
  protected void freeDirect(ByteBuffer paramByteBuffer)
  {
    PlatformDependent.freeDirectBuffer(paramByteBuffer);
  }
  
  public byte getByte(int paramInt)
  {
    ensureAccessible();
    return _getByte(paramInt);
  }
  
  public int getBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    return getBytes(paramInt1, paramFileChannel, paramLong, paramInt2, false);
  }
  
  public int getBytes(int paramInt1, GatheringByteChannel paramGatheringByteChannel, int paramInt2)
    throws IOException
  {
    return getBytes(paramInt1, paramGatheringByteChannel, paramInt2, false);
  }
  
  public ByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    checkDstIndex(paramInt1, paramInt3, paramInt2, paramByteBuf.capacity());
    if (paramByteBuf.hasArray())
    {
      getBytes(paramInt1, paramByteBuf.array(), paramByteBuf.arrayOffset() + paramInt2, paramInt3);
    }
    else
    {
      if (paramByteBuf.nioBufferCount() > 0) {
        for (ByteBuffer localByteBuffer : paramByteBuf.nioBuffers(paramInt2, paramInt3))
        {
          int i = localByteBuffer.remaining();
          getBytes(paramInt1, localByteBuffer);
          paramInt1 += i;
        }
      }
      paramByteBuf.setBytes(paramInt2, this, paramInt1, paramInt3);
    }
    return this;
  }
  
  public ByteBuf getBytes(int paramInt1, OutputStream paramOutputStream, int paramInt2)
    throws IOException
  {
    getBytes(paramInt1, paramOutputStream, paramInt2, false);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    getBytes(paramInt, paramByteBuffer, false);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    getBytes(paramInt1, paramArrayOfByte, paramInt2, paramInt3, false);
    return this;
  }
  
  void getBytes(int paramInt1, OutputStream paramOutputStream, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    ensureAccessible();
    if (paramInt2 == 0) {
      return;
    }
    ByteBufAllocator localByteBufAllocator = alloc();
    ByteBuffer localByteBuffer;
    if (paramBoolean) {
      localByteBuffer = internalNioBuffer();
    } else {
      localByteBuffer = this.buffer.duplicate();
    }
    ByteBufUtil.readBytes(localByteBufAllocator, localByteBuffer, paramInt1, paramInt2, paramOutputStream);
  }
  
  void getBytes(int paramInt, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    checkIndex(paramInt, paramByteBuffer.remaining());
    ByteBuffer localByteBuffer;
    if (paramBoolean) {
      localByteBuffer = internalNioBuffer();
    } else {
      localByteBuffer = this.buffer.duplicate();
    }
    localByteBuffer.clear().position(paramInt).limit(paramInt + paramByteBuffer.remaining());
    paramByteBuffer.put(localByteBuffer);
  }
  
  void getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    checkDstIndex(paramInt1, paramInt3, paramInt2, paramArrayOfByte.length);
    ByteBuffer localByteBuffer;
    if (paramBoolean) {
      localByteBuffer = internalNioBuffer();
    } else {
      localByteBuffer = this.buffer.duplicate();
    }
    localByteBuffer.clear().position(paramInt1).limit(paramInt1 + paramInt3);
    localByteBuffer.get(paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public int getInt(int paramInt)
  {
    ensureAccessible();
    return _getInt(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    ensureAccessible();
    return _getLong(paramInt);
  }
  
  public short getShort(int paramInt)
  {
    ensureAccessible();
    return _getShort(paramInt);
  }
  
  public int getUnsignedMedium(int paramInt)
  {
    ensureAccessible();
    return _getUnsignedMedium(paramInt);
  }
  
  public boolean hasArray()
  {
    return false;
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
    return true;
  }
  
  public long memoryAddress()
  {
    throw new UnsupportedOperationException();
  }
  
  public ByteBuffer nioBuffer(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return ((ByteBuffer)this.buffer.duplicate().position(paramInt1).limit(paramInt1 + paramInt2)).slice();
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
  
  public ByteBuf readBytes(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    checkReadableBytes(paramInt);
    getBytes(this.readerIndex, paramOutputStream, paramInt, true);
    this.readerIndex += paramInt;
    return this;
  }
  
  public ByteBuf readBytes(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.remaining();
    checkReadableBytes(i);
    getBytes(this.readerIndex, paramByteBuffer, true);
    this.readerIndex += i;
    return this;
  }
  
  public ByteBuf readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    checkReadableBytes(paramInt2);
    getBytes(this.readerIndex, paramArrayOfByte, paramInt1, paramInt2, true);
    this.readerIndex += paramInt2;
    return this;
  }
  
  public ByteBuf setByte(int paramInt1, int paramInt2)
  {
    ensureAccessible();
    _setByte(paramInt1, paramInt2);
    return this;
  }
  
  void setByteBuffer(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ByteBuffer localByteBuffer = this.buffer;
      if (localByteBuffer != null) {
        if (this.doNotFree) {
          this.doNotFree = false;
        } else {
          freeDirect(localByteBuffer);
        }
      }
    }
    this.buffer = paramByteBuffer;
    this.tmpNioBuf = null;
    this.capacity = paramByteBuffer.remaining();
  }
  
  public int setBytes(int paramInt1, InputStream paramInputStream, int paramInt2)
    throws IOException
  {
    ensureAccessible();
    if (this.buffer.hasArray()) {
      return paramInputStream.read(this.buffer.array(), this.buffer.arrayOffset() + paramInt1, paramInt2);
    }
    byte[] arrayOfByte = ByteBufUtil.threadLocalTempArray(paramInt2);
    paramInt2 = paramInputStream.read(arrayOfByte, 0, paramInt2);
    if (paramInt2 <= 0) {
      return paramInt2;
    }
    paramInputStream = internalNioBuffer();
    paramInputStream.clear().position(paramInt1);
    paramInputStream.put(arrayOfByte, 0, paramInt2);
    return paramInt2;
  }
  
  public int setBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    ensureAccessible();
    ByteBuffer localByteBuffer = internalNioBuffer();
    localByteBuffer.clear().position(paramInt1).limit(paramInt1 + paramInt2);
    try
    {
      paramInt1 = paramFileChannel.read(localByteBuffer, paramLong);
      return paramInt1;
    }
    catch (ClosedChannelException paramFileChannel) {}
    return -1;
  }
  
  public int setBytes(int paramInt1, ScatteringByteChannel paramScatteringByteChannel, int paramInt2)
    throws IOException
  {
    ensureAccessible();
    ByteBuffer localByteBuffer = internalNioBuffer();
    localByteBuffer.clear().position(paramInt1).limit(paramInt1 + paramInt2);
    try
    {
      paramInt1 = paramScatteringByteChannel.read(localByteBuffer);
      return paramInt1;
    }
    catch (ClosedChannelException paramScatteringByteChannel) {}
    return -1;
  }
  
  public ByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    checkSrcIndex(paramInt1, paramInt3, paramInt2, paramByteBuf.capacity());
    if (paramByteBuf.nioBufferCount() > 0) {
      for (ByteBuffer localByteBuffer : paramByteBuf.nioBuffers(paramInt2, paramInt3))
      {
        int i = localByteBuffer.remaining();
        setBytes(paramInt1, localByteBuffer);
        paramInt1 += i;
      }
    }
    paramByteBuf.getBytes(paramInt2, this, paramInt1, paramInt3);
    return this;
  }
  
  public ByteBuf setBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    ensureAccessible();
    ByteBuffer localByteBuffer1 = internalNioBuffer();
    ByteBuffer localByteBuffer2 = paramByteBuffer;
    if (paramByteBuffer == localByteBuffer1) {
      localByteBuffer2 = paramByteBuffer.duplicate();
    }
    localByteBuffer1.clear().position(paramInt).limit(paramInt + localByteBuffer2.remaining());
    localByteBuffer1.put(localByteBuffer2);
    return this;
  }
  
  public ByteBuf setBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    checkSrcIndex(paramInt1, paramInt3, paramInt2, paramArrayOfByte.length);
    ByteBuffer localByteBuffer = internalNioBuffer();
    localByteBuffer.clear().position(paramInt1).limit(paramInt1 + paramInt3);
    localByteBuffer.put(paramArrayOfByte, paramInt2, paramInt3);
    return this;
  }
  
  public ByteBuf setInt(int paramInt1, int paramInt2)
  {
    ensureAccessible();
    _setInt(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setLong(int paramInt, long paramLong)
  {
    ensureAccessible();
    _setLong(paramInt, paramLong);
    return this;
  }
  
  public ByteBuf setMedium(int paramInt1, int paramInt2)
  {
    ensureAccessible();
    _setMedium(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setShort(int paramInt1, int paramInt2)
  {
    ensureAccessible();
    _setShort(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf unwrap()
  {
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\UnpooledDirectByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */