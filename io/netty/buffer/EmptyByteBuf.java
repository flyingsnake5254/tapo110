package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

public final class EmptyByteBuf
  extends ByteBuf
{
  private static final ByteBuffer EMPTY_BYTE_BUFFER;
  private static final long EMPTY_BYTE_BUFFER_ADDRESS;
  static final int EMPTY_BYTE_BUF_HASH_CODE = 1;
  private final ByteBufAllocator alloc;
  private final ByteOrder order;
  private final String str;
  private EmptyByteBuf swapped;
  
  static
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(0);
    EMPTY_BYTE_BUFFER = localByteBuffer;
    long l1 = 0L;
    long l2 = l1;
    try
    {
      if (PlatformDependent.hasUnsafe()) {
        l2 = PlatformDependent.directBufferAddress(localByteBuffer);
      }
      EMPTY_BYTE_BUFFER_ADDRESS = l2;
      return;
    }
    finally
    {
      for (;;)
      {
        l2 = l1;
      }
    }
  }
  
  public EmptyByteBuf(ByteBufAllocator paramByteBufAllocator)
  {
    this(paramByteBufAllocator, ByteOrder.BIG_ENDIAN);
  }
  
  private EmptyByteBuf(ByteBufAllocator paramByteBufAllocator, ByteOrder paramByteOrder)
  {
    this.alloc = ((ByteBufAllocator)ObjectUtil.checkNotNull(paramByteBufAllocator, "alloc"));
    this.order = paramByteOrder;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    if (paramByteOrder == ByteOrder.BIG_ENDIAN) {
      paramByteBufAllocator = "BE";
    } else {
      paramByteBufAllocator = "LE";
    }
    localStringBuilder.append(paramByteBufAllocator);
    this.str = localStringBuilder.toString();
  }
  
  private ByteBuf checkIndex(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    throw new IndexOutOfBoundsException();
  }
  
  private ByteBuf checkIndex(int paramInt1, int paramInt2)
  {
    ObjectUtil.checkPositiveOrZero(paramInt2, "length");
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return this;
    }
    throw new IndexOutOfBoundsException();
  }
  
  private ByteBuf checkLength(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "length");
    if (paramInt == 0) {
      return this;
    }
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBufAllocator alloc()
  {
    return this.alloc;
  }
  
  public byte[] array()
  {
    return EmptyArrays.EMPTY_BYTES;
  }
  
  public int arrayOffset()
  {
    return 0;
  }
  
  public ByteBuf asReadOnly()
  {
    return Unpooled.unmodifiableBuffer(this);
  }
  
  public int bytesBefore(byte paramByte)
  {
    return -1;
  }
  
  public int bytesBefore(int paramInt, byte paramByte)
  {
    checkLength(paramInt);
    return -1;
  }
  
  public int bytesBefore(int paramInt1, int paramInt2, byte paramByte)
  {
    checkIndex(paramInt1, paramInt2);
    return -1;
  }
  
  public int capacity()
  {
    return 0;
  }
  
  public ByteBuf capacity(int paramInt)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf clear()
  {
    return this;
  }
  
  public int compareTo(ByteBuf paramByteBuf)
  {
    int i;
    if (paramByteBuf.isReadable()) {
      i = -1;
    } else {
      i = 0;
    }
    return i;
  }
  
  public ByteBuf copy()
  {
    return this;
  }
  
  public ByteBuf copy(int paramInt1, int paramInt2)
  {
    return checkIndex(paramInt1, paramInt2);
  }
  
  public ByteBuf discardReadBytes()
  {
    return this;
  }
  
  public ByteBuf discardSomeReadBytes()
  {
    return this;
  }
  
  public ByteBuf duplicate()
  {
    return this;
  }
  
  public int ensureWritable(int paramInt, boolean paramBoolean)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "minWritableBytes");
    if (paramInt == 0) {
      return 0;
    }
    return 1;
  }
  
  public ByteBuf ensureWritable(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "minWritableBytes");
    if (paramInt == 0) {
      return this;
    }
    throw new IndexOutOfBoundsException();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof ByteBuf)) && (!((ByteBuf)paramObject).isReadable())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int forEachByte(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
  {
    checkIndex(paramInt1, paramInt2);
    return -1;
  }
  
  public int forEachByte(ByteProcessor paramByteProcessor)
  {
    return -1;
  }
  
  public int forEachByteDesc(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
  {
    checkIndex(paramInt1, paramInt2);
    return -1;
  }
  
  public int forEachByteDesc(ByteProcessor paramByteProcessor)
  {
    return -1;
  }
  
  public boolean getBoolean(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public byte getByte(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int getBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return 0;
  }
  
  public int getBytes(int paramInt1, GatheringByteChannel paramGatheringByteChannel, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return 0;
  }
  
  public ByteBuf getBytes(int paramInt, ByteBuf paramByteBuf)
  {
    return checkIndex(paramInt, paramByteBuf.writableBytes());
  }
  
  public ByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2)
  {
    return checkIndex(paramInt1, paramInt2);
  }
  
  public ByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    return checkIndex(paramInt1, paramInt3);
  }
  
  public ByteBuf getBytes(int paramInt1, OutputStream paramOutputStream, int paramInt2)
  {
    return checkIndex(paramInt1, paramInt2);
  }
  
  public ByteBuf getBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    return checkIndex(paramInt, paramByteBuffer.remaining());
  }
  
  public ByteBuf getBytes(int paramInt, byte[] paramArrayOfByte)
  {
    return checkIndex(paramInt, paramArrayOfByte.length);
  }
  
  public ByteBuf getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return checkIndex(paramInt1, paramInt3);
  }
  
  public char getChar(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public CharSequence getCharSequence(int paramInt1, int paramInt2, Charset paramCharset)
  {
    checkIndex(paramInt1, paramInt2);
    return null;
  }
  
  public double getDouble(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public float getFloat(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int getInt(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int getIntLE(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public long getLong(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public long getLongLE(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int getMedium(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int getMediumLE(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public short getShort(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public short getShortLE(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public short getUnsignedByte(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public long getUnsignedInt(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public long getUnsignedIntLE(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int getUnsignedMedium(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int getUnsignedMediumLE(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int getUnsignedShort(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int getUnsignedShortLE(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public boolean hasArray()
  {
    return true;
  }
  
  public boolean hasMemoryAddress()
  {
    boolean bool;
    if (EMPTY_BYTE_BUFFER_ADDRESS != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public int indexOf(int paramInt1, int paramInt2, byte paramByte)
  {
    checkIndex(paramInt1);
    checkIndex(paramInt2);
    return -1;
  }
  
  public ByteBuffer internalNioBuffer(int paramInt1, int paramInt2)
  {
    return EMPTY_BYTE_BUFFER;
  }
  
  public boolean isContiguous()
  {
    return true;
  }
  
  public boolean isDirect()
  {
    return true;
  }
  
  public boolean isReadOnly()
  {
    return false;
  }
  
  public boolean isReadable()
  {
    return false;
  }
  
  public boolean isReadable(int paramInt)
  {
    return false;
  }
  
  public boolean isWritable()
  {
    return false;
  }
  
  public boolean isWritable(int paramInt)
  {
    return false;
  }
  
  public ByteBuf markReaderIndex()
  {
    return this;
  }
  
  public ByteBuf markWriterIndex()
  {
    return this;
  }
  
  public int maxCapacity()
  {
    return 0;
  }
  
  public int maxWritableBytes()
  {
    return 0;
  }
  
  public long memoryAddress()
  {
    if (hasMemoryAddress()) {
      return EMPTY_BYTE_BUFFER_ADDRESS;
    }
    throw new UnsupportedOperationException();
  }
  
  public ByteBuffer nioBuffer()
  {
    return EMPTY_BYTE_BUFFER;
  }
  
  public ByteBuffer nioBuffer(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return nioBuffer();
  }
  
  public int nioBufferCount()
  {
    return 1;
  }
  
  public ByteBuffer[] nioBuffers()
  {
    return new ByteBuffer[] { EMPTY_BYTE_BUFFER };
  }
  
  public ByteBuffer[] nioBuffers(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return nioBuffers();
  }
  
  public ByteBuf order(ByteOrder paramByteOrder)
  {
    if (ObjectUtil.checkNotNull(paramByteOrder, "endianness") == order()) {
      return this;
    }
    EmptyByteBuf localEmptyByteBuf = this.swapped;
    if (localEmptyByteBuf != null) {
      return localEmptyByteBuf;
    }
    paramByteOrder = new EmptyByteBuf(alloc(), paramByteOrder);
    this.swapped = paramByteOrder;
    return paramByteOrder;
  }
  
  public ByteOrder order()
  {
    return this.order;
  }
  
  public boolean readBoolean()
  {
    throw new IndexOutOfBoundsException();
  }
  
  public byte readByte()
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int readBytes(FileChannel paramFileChannel, long paramLong, int paramInt)
  {
    checkLength(paramInt);
    return 0;
  }
  
  public int readBytes(GatheringByteChannel paramGatheringByteChannel, int paramInt)
  {
    checkLength(paramInt);
    return 0;
  }
  
  public ByteBuf readBytes(int paramInt)
  {
    return checkLength(paramInt);
  }
  
  public ByteBuf readBytes(ByteBuf paramByteBuf)
  {
    return checkLength(paramByteBuf.writableBytes());
  }
  
  public ByteBuf readBytes(ByteBuf paramByteBuf, int paramInt)
  {
    return checkLength(paramInt);
  }
  
  public ByteBuf readBytes(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    return checkLength(paramInt2);
  }
  
  public ByteBuf readBytes(OutputStream paramOutputStream, int paramInt)
  {
    return checkLength(paramInt);
  }
  
  public ByteBuf readBytes(ByteBuffer paramByteBuffer)
  {
    return checkLength(paramByteBuffer.remaining());
  }
  
  public ByteBuf readBytes(byte[] paramArrayOfByte)
  {
    return checkLength(paramArrayOfByte.length);
  }
  
  public ByteBuf readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return checkLength(paramInt2);
  }
  
  public char readChar()
  {
    throw new IndexOutOfBoundsException();
  }
  
  public CharSequence readCharSequence(int paramInt, Charset paramCharset)
  {
    checkLength(paramInt);
    return "";
  }
  
  public double readDouble()
  {
    throw new IndexOutOfBoundsException();
  }
  
  public float readFloat()
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int readInt()
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int readIntLE()
  {
    throw new IndexOutOfBoundsException();
  }
  
  public long readLong()
  {
    throw new IndexOutOfBoundsException();
  }
  
  public long readLongLE()
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int readMedium()
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int readMediumLE()
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf readRetainedSlice(int paramInt)
  {
    return checkLength(paramInt);
  }
  
  public short readShort()
  {
    throw new IndexOutOfBoundsException();
  }
  
  public short readShortLE()
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf readSlice(int paramInt)
  {
    return checkLength(paramInt);
  }
  
  public short readUnsignedByte()
  {
    throw new IndexOutOfBoundsException();
  }
  
  public long readUnsignedInt()
  {
    throw new IndexOutOfBoundsException();
  }
  
  public long readUnsignedIntLE()
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int readUnsignedMedium()
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int readUnsignedMediumLE()
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int readUnsignedShort()
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int readUnsignedShortLE()
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int readableBytes()
  {
    return 0;
  }
  
  public int readerIndex()
  {
    return 0;
  }
  
  public ByteBuf readerIndex(int paramInt)
  {
    return checkIndex(paramInt);
  }
  
  public int refCnt()
  {
    return 1;
  }
  
  public boolean release()
  {
    return false;
  }
  
  public boolean release(int paramInt)
  {
    return false;
  }
  
  public ByteBuf resetReaderIndex()
  {
    return this;
  }
  
  public ByteBuf resetWriterIndex()
  {
    return this;
  }
  
  public ByteBuf retain()
  {
    return this;
  }
  
  public ByteBuf retain(int paramInt)
  {
    return this;
  }
  
  public ByteBuf retainedDuplicate()
  {
    return this;
  }
  
  public ByteBuf retainedSlice()
  {
    return this;
  }
  
  public ByteBuf retainedSlice(int paramInt1, int paramInt2)
  {
    return checkIndex(paramInt1, paramInt2);
  }
  
  public ByteBuf setBoolean(int paramInt, boolean paramBoolean)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf setByte(int paramInt1, int paramInt2)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int setBytes(int paramInt1, InputStream paramInputStream, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return 0;
  }
  
  public int setBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return 0;
  }
  
  public int setBytes(int paramInt1, ScatteringByteChannel paramScatteringByteChannel, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return 0;
  }
  
  public ByteBuf setBytes(int paramInt, ByteBuf paramByteBuf)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2)
  {
    return checkIndex(paramInt1, paramInt2);
  }
  
  public ByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    return checkIndex(paramInt1, paramInt3);
  }
  
  public ByteBuf setBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    return checkIndex(paramInt, paramByteBuffer.remaining());
  }
  
  public ByteBuf setBytes(int paramInt, byte[] paramArrayOfByte)
  {
    return checkIndex(paramInt, paramArrayOfByte.length);
  }
  
  public ByteBuf setBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return checkIndex(paramInt1, paramInt3);
  }
  
  public ByteBuf setChar(int paramInt1, int paramInt2)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int setCharSequence(int paramInt, CharSequence paramCharSequence, Charset paramCharset)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf setDouble(int paramInt, double paramDouble)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf setFloat(int paramInt, float paramFloat)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf setIndex(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1);
    checkIndex(paramInt2);
    return this;
  }
  
  public ByteBuf setInt(int paramInt1, int paramInt2)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf setIntLE(int paramInt1, int paramInt2)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf setLong(int paramInt, long paramLong)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf setLongLE(int paramInt, long paramLong)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf setMedium(int paramInt1, int paramInt2)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf setMediumLE(int paramInt1, int paramInt2)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf setShort(int paramInt1, int paramInt2)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf setShortLE(int paramInt1, int paramInt2)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf setZero(int paramInt1, int paramInt2)
  {
    return checkIndex(paramInt1, paramInt2);
  }
  
  public ByteBuf skipBytes(int paramInt)
  {
    return checkLength(paramInt);
  }
  
  public ByteBuf slice()
  {
    return this;
  }
  
  public ByteBuf slice(int paramInt1, int paramInt2)
  {
    return checkIndex(paramInt1, paramInt2);
  }
  
  public String toString()
  {
    return this.str;
  }
  
  public String toString(int paramInt1, int paramInt2, Charset paramCharset)
  {
    checkIndex(paramInt1, paramInt2);
    return toString(paramCharset);
  }
  
  public String toString(Charset paramCharset)
  {
    return "";
  }
  
  public ByteBuf touch()
  {
    return this;
  }
  
  public ByteBuf touch(Object paramObject)
  {
    return this;
  }
  
  public ByteBuf unwrap()
  {
    return null;
  }
  
  public int writableBytes()
  {
    return 0;
  }
  
  public ByteBuf writeBoolean(boolean paramBoolean)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf writeByte(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int writeBytes(InputStream paramInputStream, int paramInt)
  {
    checkLength(paramInt);
    return 0;
  }
  
  public int writeBytes(FileChannel paramFileChannel, long paramLong, int paramInt)
  {
    checkLength(paramInt);
    return 0;
  }
  
  public int writeBytes(ScatteringByteChannel paramScatteringByteChannel, int paramInt)
  {
    checkLength(paramInt);
    return 0;
  }
  
  public ByteBuf writeBytes(ByteBuf paramByteBuf)
  {
    return checkLength(paramByteBuf.readableBytes());
  }
  
  public ByteBuf writeBytes(ByteBuf paramByteBuf, int paramInt)
  {
    return checkLength(paramInt);
  }
  
  public ByteBuf writeBytes(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    return checkLength(paramInt2);
  }
  
  public ByteBuf writeBytes(ByteBuffer paramByteBuffer)
  {
    return checkLength(paramByteBuffer.remaining());
  }
  
  public ByteBuf writeBytes(byte[] paramArrayOfByte)
  {
    return checkLength(paramArrayOfByte.length);
  }
  
  public ByteBuf writeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return checkLength(paramInt2);
  }
  
  public ByteBuf writeChar(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public int writeCharSequence(CharSequence paramCharSequence, Charset paramCharset)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf writeDouble(double paramDouble)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf writeFloat(float paramFloat)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf writeInt(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf writeIntLE(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf writeLong(long paramLong)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf writeLongLE(long paramLong)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf writeMedium(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf writeMediumLE(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf writeShort(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf writeShortLE(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }
  
  public ByteBuf writeZero(int paramInt)
  {
    return checkLength(paramInt);
  }
  
  public int writerIndex()
  {
    return 0;
  }
  
  public ByteBuf writerIndex(int paramInt)
  {
    return checkIndex(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\EmptyByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */