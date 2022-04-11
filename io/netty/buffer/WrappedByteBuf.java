package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

class WrappedByteBuf
  extends ByteBuf
{
  protected final ByteBuf buf;
  
  protected WrappedByteBuf(ByteBuf paramByteBuf)
  {
    this.buf = ((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf, "buf"));
  }
  
  public final ByteBufAllocator alloc()
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
    return this.buf.asReadOnly();
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
  
  public final int capacity()
  {
    return this.buf.capacity();
  }
  
  public ByteBuf capacity(int paramInt)
  {
    this.buf.capacity(paramInt);
    return this;
  }
  
  public final ByteBuf clear()
  {
    this.buf.clear();
    return this;
  }
  
  public int compareTo(ByteBuf paramByteBuf)
  {
    return this.buf.compareTo(paramByteBuf);
  }
  
  public ByteBuf copy()
  {
    return this.buf.copy();
  }
  
  public ByteBuf copy(int paramInt1, int paramInt2)
  {
    return this.buf.copy(paramInt1, paramInt2);
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
    return this.buf.duplicate();
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
    return this.buf.equals(paramObject);
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
    return this.buf.getChar(paramInt);
  }
  
  public CharSequence getCharSequence(int paramInt1, int paramInt2, Charset paramCharset)
  {
    return this.buf.getCharSequence(paramInt1, paramInt2, paramCharset);
  }
  
  public double getDouble(int paramInt)
  {
    return this.buf.getDouble(paramInt);
  }
  
  public float getFloat(int paramInt)
  {
    return this.buf.getFloat(paramInt);
  }
  
  public int getInt(int paramInt)
  {
    return this.buf.getInt(paramInt);
  }
  
  public int getIntLE(int paramInt)
  {
    return this.buf.getIntLE(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    return this.buf.getLong(paramInt);
  }
  
  public long getLongLE(int paramInt)
  {
    return this.buf.getLongLE(paramInt);
  }
  
  public int getMedium(int paramInt)
  {
    return this.buf.getMedium(paramInt);
  }
  
  public int getMediumLE(int paramInt)
  {
    return this.buf.getMediumLE(paramInt);
  }
  
  public short getShort(int paramInt)
  {
    return this.buf.getShort(paramInt);
  }
  
  public short getShortLE(int paramInt)
  {
    return this.buf.getShortLE(paramInt);
  }
  
  public short getUnsignedByte(int paramInt)
  {
    return this.buf.getUnsignedByte(paramInt);
  }
  
  public long getUnsignedInt(int paramInt)
  {
    return this.buf.getUnsignedInt(paramInt);
  }
  
  public long getUnsignedIntLE(int paramInt)
  {
    return this.buf.getUnsignedIntLE(paramInt);
  }
  
  public int getUnsignedMedium(int paramInt)
  {
    return this.buf.getUnsignedMedium(paramInt);
  }
  
  public int getUnsignedMediumLE(int paramInt)
  {
    return this.buf.getUnsignedMediumLE(paramInt);
  }
  
  public int getUnsignedShort(int paramInt)
  {
    return this.buf.getUnsignedShort(paramInt);
  }
  
  public int getUnsignedShortLE(int paramInt)
  {
    return this.buf.getUnsignedShortLE(paramInt);
  }
  
  public boolean hasArray()
  {
    return this.buf.hasArray();
  }
  
  public final boolean hasMemoryAddress()
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
    return this.buf.internalNioBuffer(paramInt1, paramInt2);
  }
  
  final boolean isAccessible()
  {
    return this.buf.isAccessible();
  }
  
  public boolean isContiguous()
  {
    return this.buf.isContiguous();
  }
  
  public final boolean isDirect()
  {
    return this.buf.isDirect();
  }
  
  public boolean isReadOnly()
  {
    return this.buf.isReadOnly();
  }
  
  public final boolean isReadable()
  {
    return this.buf.isReadable();
  }
  
  public final boolean isReadable(int paramInt)
  {
    return this.buf.isReadable(paramInt);
  }
  
  public final boolean isWritable()
  {
    return this.buf.isWritable();
  }
  
  public final boolean isWritable(int paramInt)
  {
    return this.buf.isWritable(paramInt);
  }
  
  public final ByteBuf markReaderIndex()
  {
    this.buf.markReaderIndex();
    return this;
  }
  
  public final ByteBuf markWriterIndex()
  {
    this.buf.markWriterIndex();
    return this;
  }
  
  public final int maxCapacity()
  {
    return this.buf.maxCapacity();
  }
  
  public int maxFastWritableBytes()
  {
    return this.buf.maxFastWritableBytes();
  }
  
  public final int maxWritableBytes()
  {
    return this.buf.maxWritableBytes();
  }
  
  public final long memoryAddress()
  {
    return this.buf.memoryAddress();
  }
  
  public ByteBuffer nioBuffer()
  {
    return this.buf.nioBuffer();
  }
  
  public ByteBuffer nioBuffer(int paramInt1, int paramInt2)
  {
    return this.buf.nioBuffer(paramInt1, paramInt2);
  }
  
  public int nioBufferCount()
  {
    return this.buf.nioBufferCount();
  }
  
  public ByteBuffer[] nioBuffers()
  {
    return this.buf.nioBuffers();
  }
  
  public ByteBuffer[] nioBuffers(int paramInt1, int paramInt2)
  {
    return this.buf.nioBuffers(paramInt1, paramInt2);
  }
  
  public ByteBuf order(ByteOrder paramByteOrder)
  {
    return this.buf.order(paramByteOrder);
  }
  
  public final ByteOrder order()
  {
    return this.buf.order();
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
    return this.buf.readBytes(paramInt);
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
    return this.buf.readChar();
  }
  
  public CharSequence readCharSequence(int paramInt, Charset paramCharset)
  {
    return this.buf.readCharSequence(paramInt, paramCharset);
  }
  
  public double readDouble()
  {
    return this.buf.readDouble();
  }
  
  public float readFloat()
  {
    return this.buf.readFloat();
  }
  
  public int readInt()
  {
    return this.buf.readInt();
  }
  
  public int readIntLE()
  {
    return this.buf.readIntLE();
  }
  
  public long readLong()
  {
    return this.buf.readLong();
  }
  
  public long readLongLE()
  {
    return this.buf.readLongLE();
  }
  
  public int readMedium()
  {
    return this.buf.readMedium();
  }
  
  public int readMediumLE()
  {
    return this.buf.readMediumLE();
  }
  
  public ByteBuf readRetainedSlice(int paramInt)
  {
    return this.buf.readRetainedSlice(paramInt);
  }
  
  public short readShort()
  {
    return this.buf.readShort();
  }
  
  public short readShortLE()
  {
    return this.buf.readShortLE();
  }
  
  public ByteBuf readSlice(int paramInt)
  {
    return this.buf.readSlice(paramInt);
  }
  
  public short readUnsignedByte()
  {
    return this.buf.readUnsignedByte();
  }
  
  public long readUnsignedInt()
  {
    return this.buf.readUnsignedInt();
  }
  
  public long readUnsignedIntLE()
  {
    return this.buf.readUnsignedIntLE();
  }
  
  public int readUnsignedMedium()
  {
    return this.buf.readUnsignedMedium();
  }
  
  public int readUnsignedMediumLE()
  {
    return this.buf.readUnsignedMediumLE();
  }
  
  public int readUnsignedShort()
  {
    return this.buf.readUnsignedShort();
  }
  
  public int readUnsignedShortLE()
  {
    return this.buf.readUnsignedShortLE();
  }
  
  public final int readableBytes()
  {
    return this.buf.readableBytes();
  }
  
  public final int readerIndex()
  {
    return this.buf.readerIndex();
  }
  
  public final ByteBuf readerIndex(int paramInt)
  {
    this.buf.readerIndex(paramInt);
    return this;
  }
  
  public final int refCnt()
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
  
  public final ByteBuf resetReaderIndex()
  {
    this.buf.resetReaderIndex();
    return this;
  }
  
  public final ByteBuf resetWriterIndex()
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
    return this.buf.retainedDuplicate();
  }
  
  public ByteBuf retainedSlice()
  {
    return this.buf.retainedSlice();
  }
  
  public ByteBuf retainedSlice(int paramInt1, int paramInt2)
  {
    return this.buf.retainedSlice(paramInt1, paramInt2);
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
    this.buf.setChar(paramInt1, paramInt2);
    return this;
  }
  
  public int setCharSequence(int paramInt, CharSequence paramCharSequence, Charset paramCharset)
  {
    return this.buf.setCharSequence(paramInt, paramCharSequence, paramCharset);
  }
  
  public ByteBuf setDouble(int paramInt, double paramDouble)
  {
    this.buf.setDouble(paramInt, paramDouble);
    return this;
  }
  
  public ByteBuf setFloat(int paramInt, float paramFloat)
  {
    this.buf.setFloat(paramInt, paramFloat);
    return this;
  }
  
  public ByteBuf setIndex(int paramInt1, int paramInt2)
  {
    this.buf.setIndex(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setInt(int paramInt1, int paramInt2)
  {
    this.buf.setInt(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setIntLE(int paramInt1, int paramInt2)
  {
    this.buf.setIntLE(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setLong(int paramInt, long paramLong)
  {
    this.buf.setLong(paramInt, paramLong);
    return this;
  }
  
  public ByteBuf setLongLE(int paramInt, long paramLong)
  {
    this.buf.setLongLE(paramInt, paramLong);
    return this;
  }
  
  public ByteBuf setMedium(int paramInt1, int paramInt2)
  {
    this.buf.setMedium(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setMediumLE(int paramInt1, int paramInt2)
  {
    this.buf.setMediumLE(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setShort(int paramInt1, int paramInt2)
  {
    this.buf.setShort(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setShortLE(int paramInt1, int paramInt2)
  {
    this.buf.setShortLE(paramInt1, paramInt2);
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
    return this.buf.slice();
  }
  
  public ByteBuf slice(int paramInt1, int paramInt2)
  {
    return this.buf.slice(paramInt1, paramInt2);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append('(');
    localStringBuilder.append(this.buf.toString());
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
  
  public final ByteBuf unwrap()
  {
    return this.buf;
  }
  
  public final int writableBytes()
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
    this.buf.writeChar(paramInt);
    return this;
  }
  
  public int writeCharSequence(CharSequence paramCharSequence, Charset paramCharset)
  {
    return this.buf.writeCharSequence(paramCharSequence, paramCharset);
  }
  
  public ByteBuf writeDouble(double paramDouble)
  {
    this.buf.writeDouble(paramDouble);
    return this;
  }
  
  public ByteBuf writeFloat(float paramFloat)
  {
    this.buf.writeFloat(paramFloat);
    return this;
  }
  
  public ByteBuf writeInt(int paramInt)
  {
    this.buf.writeInt(paramInt);
    return this;
  }
  
  public ByteBuf writeIntLE(int paramInt)
  {
    this.buf.writeIntLE(paramInt);
    return this;
  }
  
  public ByteBuf writeLong(long paramLong)
  {
    this.buf.writeLong(paramLong);
    return this;
  }
  
  public ByteBuf writeLongLE(long paramLong)
  {
    this.buf.writeLongLE(paramLong);
    return this;
  }
  
  public ByteBuf writeMedium(int paramInt)
  {
    this.buf.writeMedium(paramInt);
    return this;
  }
  
  public ByteBuf writeMediumLE(int paramInt)
  {
    this.buf.writeMediumLE(paramInt);
    return this;
  }
  
  public ByteBuf writeShort(int paramInt)
  {
    this.buf.writeShort(paramInt);
    return this;
  }
  
  public ByteBuf writeShortLE(int paramInt)
  {
    this.buf.writeShortLE(paramInt);
    return this;
  }
  
  public ByteBuf writeZero(int paramInt)
  {
    this.buf.writeZero(paramInt);
    return this;
  }
  
  public final int writerIndex()
  {
    return this.buf.writerIndex();
  }
  
  public final ByteBuf writerIndex(int paramInt)
  {
    this.buf.writerIndex(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\WrappedByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */