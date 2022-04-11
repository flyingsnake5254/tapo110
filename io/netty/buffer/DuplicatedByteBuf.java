package io.netty.buffer;

import io.netty.util.ByteProcessor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

@Deprecated
public class DuplicatedByteBuf
  extends AbstractDerivedByteBuf
{
  private final ByteBuf buffer;
  
  public DuplicatedByteBuf(ByteBuf paramByteBuf)
  {
    this(paramByteBuf, paramByteBuf.readerIndex(), paramByteBuf.writerIndex());
  }
  
  DuplicatedByteBuf(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    super(paramByteBuf.maxCapacity());
    if ((paramByteBuf instanceof DuplicatedByteBuf)) {
      this.buffer = ((DuplicatedByteBuf)paramByteBuf).buffer;
    } else if ((paramByteBuf instanceof AbstractPooledDerivedByteBuf)) {
      this.buffer = paramByteBuf.unwrap();
    } else {
      this.buffer = paramByteBuf;
    }
    setIndex(paramInt1, paramInt2);
    markReaderIndex();
    markWriterIndex();
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
    unwrap().setByte(paramInt1, paramInt2);
  }
  
  protected void _setInt(int paramInt1, int paramInt2)
  {
    unwrap().setInt(paramInt1, paramInt2);
  }
  
  protected void _setIntLE(int paramInt1, int paramInt2)
  {
    unwrap().setIntLE(paramInt1, paramInt2);
  }
  
  protected void _setLong(int paramInt, long paramLong)
  {
    unwrap().setLong(paramInt, paramLong);
  }
  
  protected void _setLongLE(int paramInt, long paramLong)
  {
    unwrap().setLongLE(paramInt, paramLong);
  }
  
  protected void _setMedium(int paramInt1, int paramInt2)
  {
    unwrap().setMedium(paramInt1, paramInt2);
  }
  
  protected void _setMediumLE(int paramInt1, int paramInt2)
  {
    unwrap().setMediumLE(paramInt1, paramInt2);
  }
  
  protected void _setShort(int paramInt1, int paramInt2)
  {
    unwrap().setShort(paramInt1, paramInt2);
  }
  
  protected void _setShortLE(int paramInt1, int paramInt2)
  {
    unwrap().setShortLE(paramInt1, paramInt2);
  }
  
  public ByteBufAllocator alloc()
  {
    return unwrap().alloc();
  }
  
  public byte[] array()
  {
    return unwrap().array();
  }
  
  public int arrayOffset()
  {
    return unwrap().arrayOffset();
  }
  
  public int capacity()
  {
    return unwrap().capacity();
  }
  
  public ByteBuf capacity(int paramInt)
  {
    unwrap().capacity(paramInt);
    return this;
  }
  
  public ByteBuf copy(int paramInt1, int paramInt2)
  {
    return unwrap().copy(paramInt1, paramInt2);
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
    return unwrap().hasArray();
  }
  
  public boolean hasMemoryAddress()
  {
    return unwrap().hasMemoryAddress();
  }
  
  public boolean isDirect()
  {
    return unwrap().isDirect();
  }
  
  public long memoryAddress()
  {
    return unwrap().memoryAddress();
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
    unwrap().setByte(paramInt1, paramInt2);
    return this;
  }
  
  public int setBytes(int paramInt1, InputStream paramInputStream, int paramInt2)
    throws IOException
  {
    return unwrap().setBytes(paramInt1, paramInputStream, paramInt2);
  }
  
  public int setBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    return unwrap().setBytes(paramInt1, paramFileChannel, paramLong, paramInt2);
  }
  
  public int setBytes(int paramInt1, ScatteringByteChannel paramScatteringByteChannel, int paramInt2)
    throws IOException
  {
    return unwrap().setBytes(paramInt1, paramScatteringByteChannel, paramInt2);
  }
  
  public ByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    unwrap().setBytes(paramInt1, paramByteBuf, paramInt2, paramInt3);
    return this;
  }
  
  public ByteBuf setBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    unwrap().setBytes(paramInt, paramByteBuffer);
    return this;
  }
  
  public ByteBuf setBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    unwrap().setBytes(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    return this;
  }
  
  public ByteBuf setInt(int paramInt1, int paramInt2)
  {
    unwrap().setInt(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setIntLE(int paramInt1, int paramInt2)
  {
    unwrap().setIntLE(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setLong(int paramInt, long paramLong)
  {
    unwrap().setLong(paramInt, paramLong);
    return this;
  }
  
  public ByteBuf setLongLE(int paramInt, long paramLong)
  {
    unwrap().setLongLE(paramInt, paramLong);
    return this;
  }
  
  public ByteBuf setMedium(int paramInt1, int paramInt2)
  {
    unwrap().setMedium(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setMediumLE(int paramInt1, int paramInt2)
  {
    unwrap().setMediumLE(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setShort(int paramInt1, int paramInt2)
  {
    unwrap().setShort(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setShortLE(int paramInt1, int paramInt2)
  {
    unwrap().setShortLE(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf slice(int paramInt1, int paramInt2)
  {
    return unwrap().slice(paramInt1, paramInt2);
  }
  
  public ByteBuf unwrap()
  {
    return this.buffer;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\DuplicatedByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */