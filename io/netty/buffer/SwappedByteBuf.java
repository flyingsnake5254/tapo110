package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

@Deprecated
public class SwappedByteBuf
  extends ByteBuf
{
  private final ByteBuf buf;
  private final ByteOrder order;
  
  public SwappedByteBuf(ByteBuf paramByteBuf)
  {
    this.buf = ((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf, "buf"));
    paramByteBuf = paramByteBuf.order();
    ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;
    if (paramByteBuf == localByteOrder) {
      this.order = ByteOrder.LITTLE_ENDIAN;
    } else {
      this.order = localByteOrder;
    }
  }
  
  public ByteBufAllocator alloc()
  {
    return this.buf.alloc();
  }
  
  public byte[] array()
  {
    return this.buf.array();
  }
  
  public int arrayOffset()
  {
    return this.buf.arrayOffset();
  }
  
  public ByteBuf asReadOnly()
  {
    return Unpooled.unmodifiableBuffer(this);
  }
  
  public int bytesBefore(byte paramByte)
  {
    return this.buf.bytesBefore(paramByte);
  }
  
  public int bytesBefore(int paramInt, byte paramByte)
  {
    return this.buf.bytesBefore(paramInt, paramByte);
  }
  
  public int bytesBefore(int paramInt1, int paramInt2, byte paramByte)
  {
    return this.buf.bytesBefore(paramInt1, paramInt2, paramByte);
  }
  
  public int capacity()
  {
    return this.buf.capacity();
  }
  
  public ByteBuf capacity(int paramInt)
  {
    this.buf.capacity(paramInt);
    return this;
  }
  
  public ByteBuf clear()
  {
    this.buf.clear();
    return this;
  }
  
  public int compareTo(ByteBuf paramByteBuf)
  {
    return ByteBufUtil.compare(this, paramByteBuf);
  }
  
  public ByteBuf copy()
  {
    return this.buf.copy().order(this.order);
  }
  
  public ByteBuf copy(int paramInt1, int paramInt2)
  {
    return this.buf.copy(paramInt1, paramInt2).order(this.order);
  }
  
  public ByteBuf discardReadBytes()
  {
    this.buf.discardReadBytes();
    return this;
  }
  
  public ByteBuf discardSomeReadBytes()
  {
    this.buf.discardSomeReadBytes();
    return this;
  }
  
  public ByteBuf duplicate()
  {
    return this.buf.duplicate().order(this.order);
  }
  
  public int ensureWritable(int paramInt, boolean paramBoolean)
  {
    return this.buf.ensureWritable(paramInt, paramBoolean);
  }
  
  public ByteBuf ensureWritable(int paramInt)
  {
    this.buf.ensureWritable(paramInt);
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof ByteBuf)) {
      return ByteBufUtil.equals(this, (ByteBuf)paramObject);
    }
    return false;
  }
  
  public int forEachByte(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
  {
    return this.buf.forEachByte(paramInt1, paramInt2, paramByteProcessor);
  }
  
  public int forEachByte(ByteProcessor paramByteProcessor)
  {
    return this.buf.forEachByte(paramByteProcessor);
  }
  
  public int forEachByteDesc(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
  {
    return this.buf.forEachByteDesc(paramInt1, paramInt2, paramByteProcessor);
  }
  
  public int forEachByteDesc(ByteProcessor paramByteProcessor)
  {
    return this.buf.forEachByteDesc(paramByteProcessor);
  }
  
  public boolean getBoolean(int paramInt)
  {
    return this.buf.getBoolean(paramInt);
  }
  
  public byte getByte(int paramInt)
  {
    return this.buf.getByte(paramInt);
  }
  
  public int getBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    return this.buf.getBytes(paramInt1, paramFileChannel, paramLong, paramInt2);
  }
  
  public int getBytes(int paramInt1, GatheringByteChannel paramGatheringByteChannel, int paramInt2)
    throws IOException
  {
    return this.buf.getBytes(paramInt1, paramGatheringByteChannel, paramInt2);
  }
  
  public ByteBuf getBytes(int paramInt, ByteBuf paramByteBuf)
  {
    this.buf.getBytes(paramInt, paramByteBuf);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2)
  {
    this.buf.getBytes(paramInt1, paramByteBuf, paramInt2);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    this.buf.getBytes(paramInt1, paramByteBuf, paramInt2, paramInt3);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt1, OutputStream paramOutputStream, int paramInt2)
    throws IOException
  {
    this.buf.getBytes(paramInt1, paramOutputStream, paramInt2);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    this.buf.getBytes(paramInt, paramByteBuffer);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt, byte[] paramArrayOfByte)
  {
    this.buf.getBytes(paramInt, paramArrayOfByte);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    this.buf.getBytes(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    return this;
  }
  
  public char getChar(int paramInt)
  {
    return (char)getShort(paramInt);
  }
  
  public CharSequence getCharSequence(int paramInt1, int paramInt2, Charset paramCharset)
  {
    return this.buf.getCharSequence(paramInt1, paramInt2, paramCharset);
  }
  
  public double getDouble(int paramInt)
  {
    return Double.longBitsToDouble(getLong(paramInt));
  }
  
  public float getFloat(int paramInt)
  {
    return Float.intBitsToFloat(getInt(paramInt));
  }
  
  public int getInt(int paramInt)
  {
    return ByteBufUtil.swapInt(this.buf.getInt(paramInt));
  }
  
  public int getIntLE(int paramInt)
  {
    return this.buf.getInt(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    return ByteBufUtil.swapLong(this.buf.getLong(paramInt));
  }
  
  public long getLongLE(int paramInt)
  {
    return this.buf.getLong(paramInt);
  }
  
  public int getMedium(int paramInt)
  {
    return ByteBufUtil.swapMedium(this.buf.getMedium(paramInt));
  }
  
  public int getMediumLE(int paramInt)
  {
    return this.buf.getMedium(paramInt);
  }
  
  public short getShort(int paramInt)
  {
    return ByteBufUtil.swapShort(this.buf.getShort(paramInt));
  }
  
  public short getShortLE(int paramInt)
  {
    return this.buf.getShort(paramInt);
  }
  
  public short getUnsignedByte(int paramInt)
  {
    return this.buf.getUnsignedByte(paramInt);
  }
  
  public long getUnsignedInt(int paramInt)
  {
    return getInt(paramInt) & 0xFFFFFFFF;
  }
  
  public long getUnsignedIntLE(int paramInt)
  {
    return getIntLE(paramInt) & 0xFFFFFFFF;
  }
  
  public int getUnsignedMedium(int paramInt)
  {
    return getMedium(paramInt) & 0xFFFFFF;
  }
  
  public int getUnsignedMediumLE(int paramInt)
  {
    return getMediumLE(paramInt) & 0xFFFFFF;
  }
  
  public int getUnsignedShort(int paramInt)
  {
    return getShort(paramInt) & 0xFFFF;
  }
  
  public int getUnsignedShortLE(int paramInt)
  {
    return getShortLE(paramInt) & 0xFFFF;
  }
  
  public boolean hasArray()
  {
    return this.buf.hasArray();
  }
  
  public boolean hasMemoryAddress()
  {
    return this.buf.hasMemoryAddress();
  }
  
  public int hashCode()
  {
    return this.buf.hashCode();
  }
  
  public int indexOf(int paramInt1, int paramInt2, byte paramByte)
  {
    return this.buf.indexOf(paramInt1, paramInt2, paramByte);
  }
  
  public ByteBuffer internalNioBuffer(int paramInt1, int paramInt2)
  {
    return nioBuffer(paramInt1, paramInt2);
  }
  
  final boolean isAccessible()
  {
    return this.buf.isAccessible();
  }
  
  public boolean isContiguous()
  {
    return this.buf.isContiguous();
  }
  
  public boolean isDirect()
  {
    return this.buf.isDirect();
  }
  
  public boolean isReadOnly()
  {
    return this.buf.isReadOnly();
  }
  
  public boolean isReadable()
  {
    return this.buf.isReadable();
  }
  
  public boolean isReadable(int paramInt)
  {
    return this.buf.isReadable(paramInt);
  }
  
  public boolean isWritable()
  {
    return this.buf.isWritable();
  }
  
  public boolean isWritable(int paramInt)
  {
    return this.buf.isWritable(paramInt);
  }
  
  public ByteBuf markReaderIndex()
  {
    this.buf.markReaderIndex();
    return this;
  }
  
  public ByteBuf markWriterIndex()
  {
    this.buf.markWriterIndex();
    return this;
  }
  
  public int maxCapacity()
  {
    return this.buf.maxCapacity();
  }
  
  public int maxFastWritableBytes()
  {
    return this.buf.maxFastWritableBytes();
  }
  
  public int maxWritableBytes()
  {
    return this.buf.maxWritableBytes();
  }
  
  public long memoryAddress()
  {
    return this.buf.memoryAddress();
  }
  
  public ByteBuffer nioBuffer()
  {
    return this.buf.nioBuffer().order(this.order);
  }
  
  public ByteBuffer nioBuffer(int paramInt1, int paramInt2)
  {
    return this.buf.nioBuffer(paramInt1, paramInt2).order(this.order);
  }
  
  public int nioBufferCount()
  {
    return this.buf.nioBufferCount();
  }
  
  public ByteBuffer[] nioBuffers()
  {
    ByteBuffer[] arrayOfByteBuffer = this.buf.nioBuffers();
    for (int i = 0; i < arrayOfByteBuffer.length; i++) {
      arrayOfByteBuffer[i] = arrayOfByteBuffer[i].order(this.order);
    }
    return arrayOfByteBuffer;
  }
  
  public ByteBuffer[] nioBuffers(int paramInt1, int paramInt2)
  {
    ByteBuffer[] arrayOfByteBuffer = this.buf.nioBuffers(paramInt1, paramInt2);
    for (paramInt1 = 0; paramInt1 < arrayOfByteBuffer.length; paramInt1++) {
      arrayOfByteBuffer[paramInt1] = arrayOfByteBuffer[paramInt1].order(this.order);
    }
    return arrayOfByteBuffer;
  }
  
  public ByteBuf order(ByteOrder paramByteOrder)
  {
    if (ObjectUtil.checkNotNull(paramByteOrder, "endianness") == this.order) {
      return this;
    }
    return this.buf;
  }
  
  public ByteOrder order()
  {
    return this.order;
  }
  
  public boolean readBoolean()
  {
    return this.buf.readBoolean();
  }
  
  public byte readByte()
  {
    return this.buf.readByte();
  }
  
  public int readBytes(FileChannel paramFileChannel, long paramLong, int paramInt)
    throws IOException
  {
    return this.buf.readBytes(paramFileChannel, paramLong, paramInt);
  }
  
  public int readBytes(GatheringByteChannel paramGatheringByteChannel, int paramInt)
    throws IOException
  {
    return this.buf.readBytes(paramGatheringByteChannel, paramInt);
  }
  
  public ByteBuf readBytes(int paramInt)
  {
    return this.buf.readBytes(paramInt).order(order());
  }
  
  public ByteBuf readBytes(ByteBuf paramByteBuf)
  {
    this.buf.readBytes(paramByteBuf);
    return this;
  }
  
  public ByteBuf readBytes(ByteBuf paramByteBuf, int paramInt)
  {
    this.buf.readBytes(paramByteBuf, paramInt);
    return this;
  }
  
  public ByteBuf readBytes(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    this.buf.readBytes(paramByteBuf, paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf readBytes(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    this.buf.readBytes(paramOutputStream, paramInt);
    return this;
  }
  
  public ByteBuf readBytes(ByteBuffer paramByteBuffer)
  {
    this.buf.readBytes(paramByteBuffer);
    return this;
  }
  
  public ByteBuf readBytes(byte[] paramArrayOfByte)
  {
    this.buf.readBytes(paramArrayOfByte);
    return this;
  }
  
  public ByteBuf readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buf.readBytes(paramArrayOfByte, paramInt1, paramInt2);
    return this;
  }
  
  public char readChar()
  {
    return (char)readShort();
  }
  
  public CharSequence readCharSequence(int paramInt, Charset paramCharset)
  {
    return this.buf.readCharSequence(paramInt, paramCharset);
  }
  
  public double readDouble()
  {
    return Double.longBitsToDouble(readLong());
  }
  
  public float readFloat()
  {
    return Float.intBitsToFloat(readInt());
  }
  
  public int readInt()
  {
    return ByteBufUtil.swapInt(this.buf.readInt());
  }
  
  public int readIntLE()
  {
    return this.buf.readInt();
  }
  
  public long readLong()
  {
    return ByteBufUtil.swapLong(this.buf.readLong());
  }
  
  public long readLongLE()
  {
    return this.buf.readLong();
  }
  
  public int readMedium()
  {
    return ByteBufUtil.swapMedium(this.buf.readMedium());
  }
  
  public int readMediumLE()
  {
    return this.buf.readMedium();
  }
  
  public ByteBuf readRetainedSlice(int paramInt)
  {
    return this.buf.readRetainedSlice(paramInt).order(this.order);
  }
  
  public short readShort()
  {
    return ByteBufUtil.swapShort(this.buf.readShort());
  }
  
  public short readShortLE()
  {
    return this.buf.readShort();
  }
  
  public ByteBuf readSlice(int paramInt)
  {
    return this.buf.readSlice(paramInt).order(this.order);
  }
  
  public short readUnsignedByte()
  {
    return this.buf.readUnsignedByte();
  }
  
  public long readUnsignedInt()
  {
    return readInt() & 0xFFFFFFFF;
  }
  
  public long readUnsignedIntLE()
  {
    return readIntLE() & 0xFFFFFFFF;
  }
  
  public int readUnsignedMedium()
  {
    return readMedium() & 0xFFFFFF;
  }
  
  public int readUnsignedMediumLE()
  {
    return readMediumLE() & 0xFFFFFF;
  }
  
  public int readUnsignedShort()
  {
    return readShort() & 0xFFFF;
  }
  
  public int readUnsignedShortLE()
  {
    return readShortLE() & 0xFFFF;
  }
  
  public int readableBytes()
  {
    return this.buf.readableBytes();
  }
  
  public int readerIndex()
  {
    return this.buf.readerIndex();
  }
  
  public ByteBuf readerIndex(int paramInt)
  {
    this.buf.readerIndex(paramInt);
    return this;
  }
  
  public int refCnt()
  {
    return this.buf.refCnt();
  }
  
  public boolean release()
  {
    return this.buf.release();
  }
  
  public boolean release(int paramInt)
  {
    return this.buf.release(paramInt);
  }
  
  public ByteBuf resetReaderIndex()
  {
    this.buf.resetReaderIndex();
    return this;
  }
  
  public ByteBuf resetWriterIndex()
  {
    this.buf.resetWriterIndex();
    return this;
  }
  
  public ByteBuf retain()
  {
    this.buf.retain();
    return this;
  }
  
  public ByteBuf retain(int paramInt)
  {
    this.buf.retain(paramInt);
    return this;
  }
  
  public ByteBuf retainedDuplicate()
  {
    return this.buf.retainedDuplicate().order(this.order);
  }
  
  public ByteBuf retainedSlice()
  {
    return this.buf.retainedSlice().order(this.order);
  }
  
  public ByteBuf retainedSlice(int paramInt1, int paramInt2)
  {
    return this.buf.retainedSlice(paramInt1, paramInt2).order(this.order);
  }
  
  public ByteBuf setBoolean(int paramInt, boolean paramBoolean)
  {
    this.buf.setBoolean(paramInt, paramBoolean);
    return this;
  }
  
  public ByteBuf setByte(int paramInt1, int paramInt2)
  {
    this.buf.setByte(paramInt1, paramInt2);
    return this;
  }
  
  public int setBytes(int paramInt1, InputStream paramInputStream, int paramInt2)
    throws IOException
  {
    return this.buf.setBytes(paramInt1, paramInputStream, paramInt2);
  }
  
  public int setBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    return this.buf.setBytes(paramInt1, paramFileChannel, paramLong, paramInt2);
  }
  
  public int setBytes(int paramInt1, ScatteringByteChannel paramScatteringByteChannel, int paramInt2)
    throws IOException
  {
    return this.buf.setBytes(paramInt1, paramScatteringByteChannel, paramInt2);
  }
  
  public ByteBuf setBytes(int paramInt, ByteBuf paramByteBuf)
  {
    this.buf.setBytes(paramInt, paramByteBuf);
    return this;
  }
  
  public ByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2)
  {
    this.buf.setBytes(paramInt1, paramByteBuf, paramInt2);
    return this;
  }
  
  public ByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    this.buf.setBytes(paramInt1, paramByteBuf, paramInt2, paramInt3);
    return this;
  }
  
  public ByteBuf setBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    this.buf.setBytes(paramInt, paramByteBuffer);
    return this;
  }
  
  public ByteBuf setBytes(int paramInt, byte[] paramArrayOfByte)
  {
    this.buf.setBytes(paramInt, paramArrayOfByte);
    return this;
  }
  
  public ByteBuf setBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    this.buf.setBytes(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    return this;
  }
  
  public ByteBuf setChar(int paramInt1, int paramInt2)
  {
    setShort(paramInt1, paramInt2);
    return this;
  }
  
  public int setCharSequence(int paramInt, CharSequence paramCharSequence, Charset paramCharset)
  {
    return this.buf.setCharSequence(paramInt, paramCharSequence, paramCharset);
  }
  
  public ByteBuf setDouble(int paramInt, double paramDouble)
  {
    setLong(paramInt, Double.doubleToRawLongBits(paramDouble));
    return this;
  }
  
  public ByteBuf setFloat(int paramInt, float paramFloat)
  {
    setInt(paramInt, Float.floatToRawIntBits(paramFloat));
    return this;
  }
  
  public ByteBuf setIndex(int paramInt1, int paramInt2)
  {
    this.buf.setIndex(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setInt(int paramInt1, int paramInt2)
  {
    this.buf.setInt(paramInt1, ByteBufUtil.swapInt(paramInt2));
    return this;
  }
  
  public ByteBuf setIntLE(int paramInt1, int paramInt2)
  {
    this.buf.setInt(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setLong(int paramInt, long paramLong)
  {
    this.buf.setLong(paramInt, ByteBufUtil.swapLong(paramLong));
    return this;
  }
  
  public ByteBuf setLongLE(int paramInt, long paramLong)
  {
    this.buf.setLong(paramInt, paramLong);
    return this;
  }
  
  public ByteBuf setMedium(int paramInt1, int paramInt2)
  {
    this.buf.setMedium(paramInt1, ByteBufUtil.swapMedium(paramInt2));
    return this;
  }
  
  public ByteBuf setMediumLE(int paramInt1, int paramInt2)
  {
    this.buf.setMedium(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setShort(int paramInt1, int paramInt2)
  {
    this.buf.setShort(paramInt1, ByteBufUtil.swapShort((short)paramInt2));
    return this;
  }
  
  public ByteBuf setShortLE(int paramInt1, int paramInt2)
  {
    this.buf.setShort(paramInt1, (short)paramInt2);
    return this;
  }
  
  public ByteBuf setZero(int paramInt1, int paramInt2)
  {
    this.buf.setZero(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf skipBytes(int paramInt)
  {
    this.buf.skipBytes(paramInt);
    return this;
  }
  
  public ByteBuf slice()
  {
    return this.buf.slice().order(this.order);
  }
  
  public ByteBuf slice(int paramInt1, int paramInt2)
  {
    return this.buf.slice(paramInt1, paramInt2).order(this.order);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Swapped(");
    localStringBuilder.append(this.buf);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public String toString(int paramInt1, int paramInt2, Charset paramCharset)
  {
    return this.buf.toString(paramInt1, paramInt2, paramCharset);
  }
  
  public String toString(Charset paramCharset)
  {
    return this.buf.toString(paramCharset);
  }
  
  public ByteBuf touch()
  {
    this.buf.touch();
    return this;
  }
  
  public ByteBuf touch(Object paramObject)
  {
    this.buf.touch(paramObject);
    return this;
  }
  
  public ByteBuf unwrap()
  {
    return this.buf;
  }
  
  public int writableBytes()
  {
    return this.buf.writableBytes();
  }
  
  public ByteBuf writeBoolean(boolean paramBoolean)
  {
    this.buf.writeBoolean(paramBoolean);
    return this;
  }
  
  public ByteBuf writeByte(int paramInt)
  {
    this.buf.writeByte(paramInt);
    return this;
  }
  
  public int writeBytes(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    return this.buf.writeBytes(paramInputStream, paramInt);
  }
  
  public int writeBytes(FileChannel paramFileChannel, long paramLong, int paramInt)
    throws IOException
  {
    return this.buf.writeBytes(paramFileChannel, paramLong, paramInt);
  }
  
  public int writeBytes(ScatteringByteChannel paramScatteringByteChannel, int paramInt)
    throws IOException
  {
    return this.buf.writeBytes(paramScatteringByteChannel, paramInt);
  }
  
  public ByteBuf writeBytes(ByteBuf paramByteBuf)
  {
    this.buf.writeBytes(paramByteBuf);
    return this;
  }
  
  public ByteBuf writeBytes(ByteBuf paramByteBuf, int paramInt)
  {
    this.buf.writeBytes(paramByteBuf, paramInt);
    return this;
  }
  
  public ByteBuf writeBytes(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    this.buf.writeBytes(paramByteBuf, paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf writeBytes(ByteBuffer paramByteBuffer)
  {
    this.buf.writeBytes(paramByteBuffer);
    return this;
  }
  
  public ByteBuf writeBytes(byte[] paramArrayOfByte)
  {
    this.buf.writeBytes(paramArrayOfByte);
    return this;
  }
  
  public ByteBuf writeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buf.writeBytes(paramArrayOfByte, paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf writeChar(int paramInt)
  {
    writeShort(paramInt);
    return this;
  }
  
  public int writeCharSequence(CharSequence paramCharSequence, Charset paramCharset)
  {
    return this.buf.writeCharSequence(paramCharSequence, paramCharset);
  }
  
  public ByteBuf writeDouble(double paramDouble)
  {
    writeLong(Double.doubleToRawLongBits(paramDouble));
    return this;
  }
  
  public ByteBuf writeFloat(float paramFloat)
  {
    writeInt(Float.floatToRawIntBits(paramFloat));
    return this;
  }
  
  public ByteBuf writeInt(int paramInt)
  {
    this.buf.writeInt(ByteBufUtil.swapInt(paramInt));
    return this;
  }
  
  public ByteBuf writeIntLE(int paramInt)
  {
    this.buf.writeInt(paramInt);
    return this;
  }
  
  public ByteBuf writeLong(long paramLong)
  {
    this.buf.writeLong(ByteBufUtil.swapLong(paramLong));
    return this;
  }
  
  public ByteBuf writeLongLE(long paramLong)
  {
    this.buf.writeLong(paramLong);
    return this;
  }
  
  public ByteBuf writeMedium(int paramInt)
  {
    this.buf.writeMedium(ByteBufUtil.swapMedium(paramInt));
    return this;
  }
  
  public ByteBuf writeMediumLE(int paramInt)
  {
    this.buf.writeMedium(paramInt);
    return this;
  }
  
  public ByteBuf writeShort(int paramInt)
  {
    this.buf.writeShort(ByteBufUtil.swapShort((short)paramInt));
    return this;
  }
  
  public ByteBuf writeShortLE(int paramInt)
  {
    this.buf.writeShort((short)paramInt);
    return this;
  }
  
  public ByteBuf writeZero(int paramInt)
  {
    this.buf.writeZero(paramInt);
    return this;
  }
  
  public int writerIndex()
  {
    return this.buf.writerIndex();
  }
  
  public ByteBuf writerIndex(int paramInt)
  {
    this.buf.writerIndex(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\SwappedByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */