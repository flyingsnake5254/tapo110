package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.SwappedByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.ByteProcessor;
import io.netty.util.ReferenceCounted;
import io.netty.util.Signal;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

final class ReplayingDecoderByteBuf
  extends ByteBuf
{
  static final ReplayingDecoderByteBuf EMPTY_BUFFER;
  private static final Signal REPLAY = ReplayingDecoder.REPLAY;
  private ByteBuf buffer;
  private SwappedByteBuf swapped;
  private boolean terminated;
  
  static
  {
    ReplayingDecoderByteBuf localReplayingDecoderByteBuf = new ReplayingDecoderByteBuf(Unpooled.EMPTY_BUFFER);
    EMPTY_BUFFER = localReplayingDecoderByteBuf;
    localReplayingDecoderByteBuf.terminate();
  }
  
  ReplayingDecoderByteBuf() {}
  
  ReplayingDecoderByteBuf(ByteBuf paramByteBuf)
  {
    setCumulation(paramByteBuf);
  }
  
  private void checkIndex(int paramInt1, int paramInt2)
  {
    if (paramInt1 + paramInt2 <= this.buffer.writerIndex()) {
      return;
    }
    throw REPLAY;
  }
  
  private void checkReadableBytes(int paramInt)
  {
    if (this.buffer.readableBytes() >= paramInt) {
      return;
    }
    throw REPLAY;
  }
  
  private static UnsupportedOperationException reject()
  {
    return new UnsupportedOperationException("not a replayable operation");
  }
  
  public ByteBufAllocator alloc()
  {
    return this.buffer.alloc();
  }
  
  public byte[] array()
  {
    throw new UnsupportedOperationException();
  }
  
  public int arrayOffset()
  {
    throw new UnsupportedOperationException();
  }
  
  public ByteBuf asReadOnly()
  {
    return Unpooled.unmodifiableBuffer(this);
  }
  
  public int bytesBefore(byte paramByte)
  {
    int i = this.buffer.bytesBefore(paramByte);
    if (i >= 0) {
      return i;
    }
    throw REPLAY;
  }
  
  public int bytesBefore(int paramInt, byte paramByte)
  {
    return bytesBefore(this.buffer.readerIndex(), paramInt, paramByte);
  }
  
  public int bytesBefore(int paramInt1, int paramInt2, byte paramByte)
  {
    int i = this.buffer.writerIndex();
    if (paramInt1 < i)
    {
      if (paramInt1 <= i - paramInt2) {
        return this.buffer.bytesBefore(paramInt1, paramInt2, paramByte);
      }
      paramInt1 = this.buffer.bytesBefore(paramInt1, i - paramInt1, paramByte);
      if (paramInt1 >= 0) {
        return paramInt1;
      }
      throw REPLAY;
    }
    throw REPLAY;
  }
  
  public int capacity()
  {
    if (this.terminated) {
      return this.buffer.capacity();
    }
    return Integer.MAX_VALUE;
  }
  
  public ByteBuf capacity(int paramInt)
  {
    throw reject();
  }
  
  public ByteBuf clear()
  {
    throw reject();
  }
  
  public int compareTo(ByteBuf paramByteBuf)
  {
    throw reject();
  }
  
  public ByteBuf copy()
  {
    throw reject();
  }
  
  public ByteBuf copy(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return this.buffer.copy(paramInt1, paramInt2);
  }
  
  public ByteBuf discardReadBytes()
  {
    throw reject();
  }
  
  public ByteBuf discardSomeReadBytes()
  {
    throw reject();
  }
  
  public ByteBuf duplicate()
  {
    throw reject();
  }
  
  public int ensureWritable(int paramInt, boolean paramBoolean)
  {
    throw reject();
  }
  
  public ByteBuf ensureWritable(int paramInt)
  {
    throw reject();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int forEachByte(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
  {
    int i = this.buffer.writerIndex();
    if (paramInt1 < i)
    {
      if (paramInt1 <= i - paramInt2) {
        return this.buffer.forEachByte(paramInt1, paramInt2, paramByteProcessor);
      }
      paramInt1 = this.buffer.forEachByte(paramInt1, i - paramInt1, paramByteProcessor);
      if (paramInt1 >= 0) {
        return paramInt1;
      }
      throw REPLAY;
    }
    throw REPLAY;
  }
  
  public int forEachByte(ByteProcessor paramByteProcessor)
  {
    int i = this.buffer.forEachByte(paramByteProcessor);
    if (i >= 0) {
      return i;
    }
    throw REPLAY;
  }
  
  public int forEachByteDesc(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
  {
    if (paramInt1 + paramInt2 <= this.buffer.writerIndex()) {
      return this.buffer.forEachByteDesc(paramInt1, paramInt2, paramByteProcessor);
    }
    throw REPLAY;
  }
  
  public int forEachByteDesc(ByteProcessor paramByteProcessor)
  {
    if (this.terminated) {
      return this.buffer.forEachByteDesc(paramByteProcessor);
    }
    throw reject();
  }
  
  public boolean getBoolean(int paramInt)
  {
    checkIndex(paramInt, 1);
    return this.buffer.getBoolean(paramInt);
  }
  
  public byte getByte(int paramInt)
  {
    checkIndex(paramInt, 1);
    return this.buffer.getByte(paramInt);
  }
  
  public int getBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
  {
    throw reject();
  }
  
  public int getBytes(int paramInt1, GatheringByteChannel paramGatheringByteChannel, int paramInt2)
  {
    throw reject();
  }
  
  public ByteBuf getBytes(int paramInt, ByteBuf paramByteBuf)
  {
    throw reject();
  }
  
  public ByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2)
  {
    throw reject();
  }
  
  public ByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    checkIndex(paramInt1, paramInt3);
    this.buffer.getBytes(paramInt1, paramByteBuf, paramInt2, paramInt3);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt1, OutputStream paramOutputStream, int paramInt2)
  {
    throw reject();
  }
  
  public ByteBuf getBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    throw reject();
  }
  
  public ByteBuf getBytes(int paramInt, byte[] paramArrayOfByte)
  {
    checkIndex(paramInt, paramArrayOfByte.length);
    this.buffer.getBytes(paramInt, paramArrayOfByte);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    checkIndex(paramInt1, paramInt3);
    this.buffer.getBytes(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    return this;
  }
  
  public char getChar(int paramInt)
  {
    checkIndex(paramInt, 2);
    return this.buffer.getChar(paramInt);
  }
  
  public CharSequence getCharSequence(int paramInt1, int paramInt2, Charset paramCharset)
  {
    checkIndex(paramInt1, paramInt2);
    return this.buffer.getCharSequence(paramInt1, paramInt2, paramCharset);
  }
  
  public double getDouble(int paramInt)
  {
    checkIndex(paramInt, 8);
    return this.buffer.getDouble(paramInt);
  }
  
  public float getFloat(int paramInt)
  {
    checkIndex(paramInt, 4);
    return this.buffer.getFloat(paramInt);
  }
  
  public int getInt(int paramInt)
  {
    checkIndex(paramInt, 4);
    return this.buffer.getInt(paramInt);
  }
  
  public int getIntLE(int paramInt)
  {
    checkIndex(paramInt, 4);
    return this.buffer.getIntLE(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    checkIndex(paramInt, 8);
    return this.buffer.getLong(paramInt);
  }
  
  public long getLongLE(int paramInt)
  {
    checkIndex(paramInt, 8);
    return this.buffer.getLongLE(paramInt);
  }
  
  public int getMedium(int paramInt)
  {
    checkIndex(paramInt, 3);
    return this.buffer.getMedium(paramInt);
  }
  
  public int getMediumLE(int paramInt)
  {
    checkIndex(paramInt, 3);
    return this.buffer.getMediumLE(paramInt);
  }
  
  public short getShort(int paramInt)
  {
    checkIndex(paramInt, 2);
    return this.buffer.getShort(paramInt);
  }
  
  public short getShortLE(int paramInt)
  {
    checkIndex(paramInt, 2);
    return this.buffer.getShortLE(paramInt);
  }
  
  public short getUnsignedByte(int paramInt)
  {
    checkIndex(paramInt, 1);
    return this.buffer.getUnsignedByte(paramInt);
  }
  
  public long getUnsignedInt(int paramInt)
  {
    checkIndex(paramInt, 4);
    return this.buffer.getUnsignedInt(paramInt);
  }
  
  public long getUnsignedIntLE(int paramInt)
  {
    checkIndex(paramInt, 4);
    return this.buffer.getUnsignedIntLE(paramInt);
  }
  
  public int getUnsignedMedium(int paramInt)
  {
    checkIndex(paramInt, 3);
    return this.buffer.getUnsignedMedium(paramInt);
  }
  
  public int getUnsignedMediumLE(int paramInt)
  {
    checkIndex(paramInt, 3);
    return this.buffer.getUnsignedMediumLE(paramInt);
  }
  
  public int getUnsignedShort(int paramInt)
  {
    checkIndex(paramInt, 2);
    return this.buffer.getUnsignedShort(paramInt);
  }
  
  public int getUnsignedShortLE(int paramInt)
  {
    checkIndex(paramInt, 2);
    return this.buffer.getUnsignedShortLE(paramInt);
  }
  
  public boolean hasArray()
  {
    return false;
  }
  
  public boolean hasMemoryAddress()
  {
    return false;
  }
  
  public int hashCode()
  {
    throw reject();
  }
  
  public int indexOf(int paramInt1, int paramInt2, byte paramByte)
  {
    if (paramInt1 == paramInt2) {
      return -1;
    }
    if (Math.max(paramInt1, paramInt2) <= this.buffer.writerIndex()) {
      return this.buffer.indexOf(paramInt1, paramInt2, paramByte);
    }
    throw REPLAY;
  }
  
  public ByteBuffer internalNioBuffer(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return this.buffer.internalNioBuffer(paramInt1, paramInt2);
  }
  
  public boolean isDirect()
  {
    return this.buffer.isDirect();
  }
  
  public boolean isReadOnly()
  {
    return false;
  }
  
  public boolean isReadable()
  {
    boolean bool;
    if ((this.terminated) && (!this.buffer.isReadable())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isReadable(int paramInt)
  {
    boolean bool;
    if ((this.terminated) && (!this.buffer.isReadable(paramInt))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
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
    this.buffer.markReaderIndex();
    return this;
  }
  
  public ByteBuf markWriterIndex()
  {
    throw reject();
  }
  
  public int maxCapacity()
  {
    return capacity();
  }
  
  public int maxWritableBytes()
  {
    return 0;
  }
  
  public long memoryAddress()
  {
    throw new UnsupportedOperationException();
  }
  
  public ByteBuffer nioBuffer()
  {
    throw reject();
  }
  
  public ByteBuffer nioBuffer(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return this.buffer.nioBuffer(paramInt1, paramInt2);
  }
  
  public int nioBufferCount()
  {
    return this.buffer.nioBufferCount();
  }
  
  public ByteBuffer[] nioBuffers()
  {
    throw reject();
  }
  
  public ByteBuffer[] nioBuffers(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return this.buffer.nioBuffers(paramInt1, paramInt2);
  }
  
  public ByteBuf order(ByteOrder paramByteOrder)
  {
    if (ObjectUtil.checkNotNull(paramByteOrder, "endianness") == order()) {
      return this;
    }
    SwappedByteBuf localSwappedByteBuf = this.swapped;
    paramByteOrder = localSwappedByteBuf;
    if (localSwappedByteBuf == null)
    {
      paramByteOrder = new SwappedByteBuf(this);
      this.swapped = paramByteOrder;
    }
    return paramByteOrder;
  }
  
  public ByteOrder order()
  {
    return this.buffer.order();
  }
  
  public boolean readBoolean()
  {
    checkReadableBytes(1);
    return this.buffer.readBoolean();
  }
  
  public byte readByte()
  {
    checkReadableBytes(1);
    return this.buffer.readByte();
  }
  
  public int readBytes(FileChannel paramFileChannel, long paramLong, int paramInt)
  {
    throw reject();
  }
  
  public int readBytes(GatheringByteChannel paramGatheringByteChannel, int paramInt)
  {
    throw reject();
  }
  
  public ByteBuf readBytes(int paramInt)
  {
    checkReadableBytes(paramInt);
    return this.buffer.readBytes(paramInt);
  }
  
  public ByteBuf readBytes(ByteBuf paramByteBuf)
  {
    checkReadableBytes(paramByteBuf.writableBytes());
    this.buffer.readBytes(paramByteBuf);
    return this;
  }
  
  public ByteBuf readBytes(ByteBuf paramByteBuf, int paramInt)
  {
    throw reject();
  }
  
  public ByteBuf readBytes(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    checkReadableBytes(paramInt2);
    this.buffer.readBytes(paramByteBuf, paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf readBytes(OutputStream paramOutputStream, int paramInt)
  {
    throw reject();
  }
  
  public ByteBuf readBytes(ByteBuffer paramByteBuffer)
  {
    throw reject();
  }
  
  public ByteBuf readBytes(byte[] paramArrayOfByte)
  {
    checkReadableBytes(paramArrayOfByte.length);
    this.buffer.readBytes(paramArrayOfByte);
    return this;
  }
  
  public ByteBuf readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    checkReadableBytes(paramInt2);
    this.buffer.readBytes(paramArrayOfByte, paramInt1, paramInt2);
    return this;
  }
  
  public char readChar()
  {
    checkReadableBytes(2);
    return this.buffer.readChar();
  }
  
  public CharSequence readCharSequence(int paramInt, Charset paramCharset)
  {
    checkReadableBytes(paramInt);
    return this.buffer.readCharSequence(paramInt, paramCharset);
  }
  
  public double readDouble()
  {
    checkReadableBytes(8);
    return this.buffer.readDouble();
  }
  
  public float readFloat()
  {
    checkReadableBytes(4);
    return this.buffer.readFloat();
  }
  
  public int readInt()
  {
    checkReadableBytes(4);
    return this.buffer.readInt();
  }
  
  public int readIntLE()
  {
    checkReadableBytes(4);
    return this.buffer.readIntLE();
  }
  
  public long readLong()
  {
    checkReadableBytes(8);
    return this.buffer.readLong();
  }
  
  public long readLongLE()
  {
    checkReadableBytes(8);
    return this.buffer.readLongLE();
  }
  
  public int readMedium()
  {
    checkReadableBytes(3);
    return this.buffer.readMedium();
  }
  
  public int readMediumLE()
  {
    checkReadableBytes(3);
    return this.buffer.readMediumLE();
  }
  
  public ByteBuf readRetainedSlice(int paramInt)
  {
    checkReadableBytes(paramInt);
    return this.buffer.readRetainedSlice(paramInt);
  }
  
  public short readShort()
  {
    checkReadableBytes(2);
    return this.buffer.readShort();
  }
  
  public short readShortLE()
  {
    checkReadableBytes(2);
    return this.buffer.readShortLE();
  }
  
  public ByteBuf readSlice(int paramInt)
  {
    checkReadableBytes(paramInt);
    return this.buffer.readSlice(paramInt);
  }
  
  public short readUnsignedByte()
  {
    checkReadableBytes(1);
    return this.buffer.readUnsignedByte();
  }
  
  public long readUnsignedInt()
  {
    checkReadableBytes(4);
    return this.buffer.readUnsignedInt();
  }
  
  public long readUnsignedIntLE()
  {
    checkReadableBytes(4);
    return this.buffer.readUnsignedIntLE();
  }
  
  public int readUnsignedMedium()
  {
    checkReadableBytes(3);
    return this.buffer.readUnsignedMedium();
  }
  
  public int readUnsignedMediumLE()
  {
    checkReadableBytes(3);
    return this.buffer.readUnsignedMediumLE();
  }
  
  public int readUnsignedShort()
  {
    checkReadableBytes(2);
    return this.buffer.readUnsignedShort();
  }
  
  public int readUnsignedShortLE()
  {
    checkReadableBytes(2);
    return this.buffer.readUnsignedShortLE();
  }
  
  public int readableBytes()
  {
    if (this.terminated) {
      return this.buffer.readableBytes();
    }
    return Integer.MAX_VALUE - this.buffer.readerIndex();
  }
  
  public int readerIndex()
  {
    return this.buffer.readerIndex();
  }
  
  public ByteBuf readerIndex(int paramInt)
  {
    this.buffer.readerIndex(paramInt);
    return this;
  }
  
  public int refCnt()
  {
    return this.buffer.refCnt();
  }
  
  public boolean release()
  {
    throw reject();
  }
  
  public boolean release(int paramInt)
  {
    throw reject();
  }
  
  public ByteBuf resetReaderIndex()
  {
    this.buffer.resetReaderIndex();
    return this;
  }
  
  public ByteBuf resetWriterIndex()
  {
    throw reject();
  }
  
  public ByteBuf retain()
  {
    throw reject();
  }
  
  public ByteBuf retain(int paramInt)
  {
    throw reject();
  }
  
  public ByteBuf retainedDuplicate()
  {
    throw reject();
  }
  
  public ByteBuf retainedSlice()
  {
    throw reject();
  }
  
  public ByteBuf retainedSlice(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return this.buffer.slice(paramInt1, paramInt2);
  }
  
  public ByteBuf setBoolean(int paramInt, boolean paramBoolean)
  {
    throw reject();
  }
  
  public ByteBuf setByte(int paramInt1, int paramInt2)
  {
    throw reject();
  }
  
  public int setBytes(int paramInt1, InputStream paramInputStream, int paramInt2)
  {
    throw reject();
  }
  
  public int setBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
  {
    throw reject();
  }
  
  public int setBytes(int paramInt1, ScatteringByteChannel paramScatteringByteChannel, int paramInt2)
  {
    throw reject();
  }
  
  public ByteBuf setBytes(int paramInt, ByteBuf paramByteBuf)
  {
    throw reject();
  }
  
  public ByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2)
  {
    throw reject();
  }
  
  public ByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    throw reject();
  }
  
  public ByteBuf setBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    throw reject();
  }
  
  public ByteBuf setBytes(int paramInt, byte[] paramArrayOfByte)
  {
    throw reject();
  }
  
  public ByteBuf setBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    throw reject();
  }
  
  public ByteBuf setChar(int paramInt1, int paramInt2)
  {
    throw reject();
  }
  
  public int setCharSequence(int paramInt, CharSequence paramCharSequence, Charset paramCharset)
  {
    throw reject();
  }
  
  void setCumulation(ByteBuf paramByteBuf)
  {
    this.buffer = paramByteBuf;
  }
  
  public ByteBuf setDouble(int paramInt, double paramDouble)
  {
    throw reject();
  }
  
  public ByteBuf setFloat(int paramInt, float paramFloat)
  {
    throw reject();
  }
  
  public ByteBuf setIndex(int paramInt1, int paramInt2)
  {
    throw reject();
  }
  
  public ByteBuf setInt(int paramInt1, int paramInt2)
  {
    throw reject();
  }
  
  public ByteBuf setIntLE(int paramInt1, int paramInt2)
  {
    throw reject();
  }
  
  public ByteBuf setLong(int paramInt, long paramLong)
  {
    throw reject();
  }
  
  public ByteBuf setLongLE(int paramInt, long paramLong)
  {
    throw reject();
  }
  
  public ByteBuf setMedium(int paramInt1, int paramInt2)
  {
    throw reject();
  }
  
  public ByteBuf setMediumLE(int paramInt1, int paramInt2)
  {
    throw reject();
  }
  
  public ByteBuf setShort(int paramInt1, int paramInt2)
  {
    throw reject();
  }
  
  public ByteBuf setShortLE(int paramInt1, int paramInt2)
  {
    throw reject();
  }
  
  public ByteBuf setZero(int paramInt1, int paramInt2)
  {
    throw reject();
  }
  
  public ByteBuf skipBytes(int paramInt)
  {
    checkReadableBytes(paramInt);
    this.buffer.skipBytes(paramInt);
    return this;
  }
  
  public ByteBuf slice()
  {
    throw reject();
  }
  
  public ByteBuf slice(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return this.buffer.slice(paramInt1, paramInt2);
  }
  
  void terminate()
  {
    this.terminated = true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append('(');
    localStringBuilder.append("ridx=");
    localStringBuilder.append(readerIndex());
    localStringBuilder.append(", widx=");
    localStringBuilder.append(writerIndex());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public String toString(int paramInt1, int paramInt2, Charset paramCharset)
  {
    checkIndex(paramInt1, paramInt2);
    return this.buffer.toString(paramInt1, paramInt2, paramCharset);
  }
  
  public String toString(Charset paramCharset)
  {
    throw reject();
  }
  
  public ByteBuf touch()
  {
    this.buffer.touch();
    return this;
  }
  
  public ByteBuf touch(Object paramObject)
  {
    this.buffer.touch(paramObject);
    return this;
  }
  
  public ByteBuf unwrap()
  {
    throw reject();
  }
  
  public int writableBytes()
  {
    return 0;
  }
  
  public ByteBuf writeBoolean(boolean paramBoolean)
  {
    throw reject();
  }
  
  public ByteBuf writeByte(int paramInt)
  {
    throw reject();
  }
  
  public int writeBytes(InputStream paramInputStream, int paramInt)
  {
    throw reject();
  }
  
  public int writeBytes(FileChannel paramFileChannel, long paramLong, int paramInt)
  {
    throw reject();
  }
  
  public int writeBytes(ScatteringByteChannel paramScatteringByteChannel, int paramInt)
  {
    throw reject();
  }
  
  public ByteBuf writeBytes(ByteBuf paramByteBuf)
  {
    throw reject();
  }
  
  public ByteBuf writeBytes(ByteBuf paramByteBuf, int paramInt)
  {
    throw reject();
  }
  
  public ByteBuf writeBytes(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    throw reject();
  }
  
  public ByteBuf writeBytes(ByteBuffer paramByteBuffer)
  {
    throw reject();
  }
  
  public ByteBuf writeBytes(byte[] paramArrayOfByte)
  {
    throw reject();
  }
  
  public ByteBuf writeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    throw reject();
  }
  
  public ByteBuf writeChar(int paramInt)
  {
    throw reject();
  }
  
  public int writeCharSequence(CharSequence paramCharSequence, Charset paramCharset)
  {
    throw reject();
  }
  
  public ByteBuf writeDouble(double paramDouble)
  {
    throw reject();
  }
  
  public ByteBuf writeFloat(float paramFloat)
  {
    throw reject();
  }
  
  public ByteBuf writeInt(int paramInt)
  {
    throw reject();
  }
  
  public ByteBuf writeIntLE(int paramInt)
  {
    throw reject();
  }
  
  public ByteBuf writeLong(long paramLong)
  {
    throw reject();
  }
  
  public ByteBuf writeLongLE(long paramLong)
  {
    throw reject();
  }
  
  public ByteBuf writeMedium(int paramInt)
  {
    throw reject();
  }
  
  public ByteBuf writeMediumLE(int paramInt)
  {
    throw reject();
  }
  
  public ByteBuf writeShort(int paramInt)
  {
    throw reject();
  }
  
  public ByteBuf writeShortLE(int paramInt)
  {
    throw reject();
  }
  
  public ByteBuf writeZero(int paramInt)
  {
    throw reject();
  }
  
  public int writerIndex()
  {
    return this.buffer.writerIndex();
  }
  
  public ByteBuf writerIndex(int paramInt)
  {
    throw reject();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\ReplayingDecoderByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */