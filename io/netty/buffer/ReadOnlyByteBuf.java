package io.netty.buffer;

import io.netty.util.ByteProcessor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

@Deprecated
public class ReadOnlyByteBuf
  extends AbstractDerivedByteBuf
{
  private final ByteBuf buffer;
  
  public ReadOnlyByteBuf(ByteBuf paramByteBuf)
  {
    super(paramByteBuf.maxCapacity());
    if ((!(paramByteBuf instanceof ReadOnlyByteBuf)) && (!(paramByteBuf instanceof DuplicatedByteBuf))) {
      this.buffer = paramByteBuf;
    } else {
      this.buffer = paramByteBuf.unwrap();
    }
    setIndex(paramByteBuf.readerIndex(), paramByteBuf.writerIndex());
  }
  
  protected byte _getByte(int paramInt)
  {
    return unwrap().getByte(paramInt);
  }
  
  protected int _getInt(int paramInt)
  {
    return unwrap().getInt(paramInt);
  }
  
  protected int _getIntLE(int paramInt)
  {
    return unwrap().getIntLE(paramInt);
  }
  
  protected long _getLong(int paramInt)
  {
    return unwrap().getLong(paramInt);
  }
  
  protected long _getLongLE(int paramInt)
  {
    return unwrap().getLongLE(paramInt);
  }
  
  protected short _getShort(int paramInt)
  {
    return unwrap().getShort(paramInt);
  }
  
  protected short _getShortLE(int paramInt)
  {
    return unwrap().getShortLE(paramInt);
  }
  
  protected int _getUnsignedMedium(int paramInt)
  {
    return unwrap().getUnsignedMedium(paramInt);
  }
  
  protected int _getUnsignedMediumLE(int paramInt)
  {
    return unwrap().getUnsignedMediumLE(paramInt);
  }
  
  protected void _setByte(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setInt(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setIntLE(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setLong(int paramInt, long paramLong)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setLongLE(int paramInt, long paramLong)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setMedium(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setMediumLE(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setShort(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setShortLE(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBufAllocator alloc()
  {
    return unwrap().alloc();
  }
  
  public byte[] array()
  {
    throw new ReadOnlyBufferException();
  }
  
  public int arrayOffset()
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf asReadOnly()
  {
    return this;
  }
  
  public int capacity()
  {
    return unwrap().capacity();
  }
  
  public ByteBuf capacity(int paramInt)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf copy(int paramInt1, int paramInt2)
  {
    return unwrap().copy(paramInt1, paramInt2);
  }
  
  public ByteBuf discardReadBytes()
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf duplicate()
  {
    return new ReadOnlyByteBuf(this);
  }
  
  public int ensureWritable(int paramInt, boolean paramBoolean)
  {
    return 1;
  }
  
  public ByteBuf ensureWritable(int paramInt)
  {
    throw new ReadOnlyBufferException();
  }
  
  public int forEachByte(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
  {
    return unwrap().forEachByte(paramInt1, paramInt2, paramByteProcessor);
  }
  
  public int forEachByteDesc(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
  {
    return unwrap().forEachByteDesc(paramInt1, paramInt2, paramByteProcessor);
  }
  
  public byte getByte(int paramInt)
  {
    return unwrap().getByte(paramInt);
  }
  
  public int getBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    return unwrap().getBytes(paramInt1, paramFileChannel, paramLong, paramInt2);
  }
  
  public int getBytes(int paramInt1, GatheringByteChannel paramGatheringByteChannel, int paramInt2)
    throws IOException
  {
    return unwrap().getBytes(paramInt1, paramGatheringByteChannel, paramInt2);
  }
  
  public ByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    unwrap().getBytes(paramInt1, paramByteBuf, paramInt2, paramInt3);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt1, OutputStream paramOutputStream, int paramInt2)
    throws IOException
  {
    unwrap().getBytes(paramInt1, paramOutputStream, paramInt2);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    unwrap().getBytes(paramInt, paramByteBuffer);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    unwrap().getBytes(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    return this;
  }
  
  public int getInt(int paramInt)
  {
    return unwrap().getInt(paramInt);
  }
  
  public int getIntLE(int paramInt)
  {
    return unwrap().getIntLE(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    return unwrap().getLong(paramInt);
  }
  
  public long getLongLE(int paramInt)
  {
    return unwrap().getLongLE(paramInt);
  }
  
  public short getShort(int paramInt)
  {
    return unwrap().getShort(paramInt);
  }
  
  public short getShortLE(int paramInt)
  {
    return unwrap().getShortLE(paramInt);
  }
  
  public int getUnsignedMedium(int paramInt)
  {
    return unwrap().getUnsignedMedium(paramInt);
  }
  
  public int getUnsignedMediumLE(int paramInt)
  {
    return unwrap().getUnsignedMediumLE(paramInt);
  }
  
  public boolean hasArray()
  {
    return false;
  }
  
  public boolean hasMemoryAddress()
  {
    return unwrap().hasMemoryAddress();
  }
  
  public boolean isDirect()
  {
    return unwrap().isDirect();
  }
  
  public boolean isReadOnly()
  {
    return true;
  }
  
  public boolean isWritable()
  {
    return false;
  }
  
  public boolean isWritable(int paramInt)
  {
    return false;
  }
  
  public long memoryAddress()
  {
    return unwrap().memoryAddress();
  }
  
  public ByteBuffer nioBuffer(int paramInt1, int paramInt2)
  {
    return unwrap().nioBuffer(paramInt1, paramInt2).asReadOnlyBuffer();
  }
  
  public int nioBufferCount()
  {
    return unwrap().nioBufferCount();
  }
  
  public ByteBuffer[] nioBuffers(int paramInt1, int paramInt2)
  {
    return unwrap().nioBuffers(paramInt1, paramInt2);
  }
  
  @Deprecated
  public ByteOrder order()
  {
    return unwrap().order();
  }
  
  public ByteBuf setByte(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public int setBytes(int paramInt1, InputStream paramInputStream, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public int setBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public int setBytes(int paramInt1, ScatteringByteChannel paramScatteringByteChannel, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setInt(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setIntLE(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setLong(int paramInt, long paramLong)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setLongLE(int paramInt, long paramLong)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setMedium(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setMediumLE(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setShort(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setShortLE(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf slice(int paramInt1, int paramInt2)
  {
    return Unpooled.unmodifiableBuffer(unwrap().slice(paramInt1, paramInt2));
  }
  
  public ByteBuf unwrap()
  {
    return this.buffer;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\ReadOnlyByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */