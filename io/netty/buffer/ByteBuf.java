package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.ReferenceCounted;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

public abstract class ByteBuf
  implements ReferenceCounted, Comparable<ByteBuf>
{
  public abstract ByteBufAllocator alloc();
  
  public abstract byte[] array();
  
  public abstract int arrayOffset();
  
  public abstract ByteBuf asReadOnly();
  
  public abstract int bytesBefore(byte paramByte);
  
  public abstract int bytesBefore(int paramInt, byte paramByte);
  
  public abstract int bytesBefore(int paramInt1, int paramInt2, byte paramByte);
  
  public abstract int capacity();
  
  public abstract ByteBuf capacity(int paramInt);
  
  public abstract ByteBuf clear();
  
  public abstract int compareTo(ByteBuf paramByteBuf);
  
  public abstract ByteBuf copy();
  
  public abstract ByteBuf copy(int paramInt1, int paramInt2);
  
  public abstract ByteBuf discardReadBytes();
  
  public abstract ByteBuf discardSomeReadBytes();
  
  public abstract ByteBuf duplicate();
  
  public abstract int ensureWritable(int paramInt, boolean paramBoolean);
  
  public abstract ByteBuf ensureWritable(int paramInt);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract int forEachByte(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor);
  
  public abstract int forEachByte(ByteProcessor paramByteProcessor);
  
  public abstract int forEachByteDesc(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor);
  
  public abstract int forEachByteDesc(ByteProcessor paramByteProcessor);
  
  public abstract boolean getBoolean(int paramInt);
  
  public abstract byte getByte(int paramInt);
  
  public abstract int getBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException;
  
  public abstract int getBytes(int paramInt1, GatheringByteChannel paramGatheringByteChannel, int paramInt2)
    throws IOException;
  
  public abstract ByteBuf getBytes(int paramInt, ByteBuf paramByteBuf);
  
  public abstract ByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2);
  
  public abstract ByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3);
  
  public abstract ByteBuf getBytes(int paramInt1, OutputStream paramOutputStream, int paramInt2)
    throws IOException;
  
  public abstract ByteBuf getBytes(int paramInt, ByteBuffer paramByteBuffer);
  
  public abstract ByteBuf getBytes(int paramInt, byte[] paramArrayOfByte);
  
  public abstract ByteBuf getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  public abstract char getChar(int paramInt);
  
  public abstract CharSequence getCharSequence(int paramInt1, int paramInt2, Charset paramCharset);
  
  public abstract double getDouble(int paramInt);
  
  public double getDoubleLE(int paramInt)
  {
    return Double.longBitsToDouble(getLongLE(paramInt));
  }
  
  public abstract float getFloat(int paramInt);
  
  public float getFloatLE(int paramInt)
  {
    return Float.intBitsToFloat(getIntLE(paramInt));
  }
  
  public abstract int getInt(int paramInt);
  
  public abstract int getIntLE(int paramInt);
  
  public abstract long getLong(int paramInt);
  
  public abstract long getLongLE(int paramInt);
  
  public abstract int getMedium(int paramInt);
  
  public abstract int getMediumLE(int paramInt);
  
  public abstract short getShort(int paramInt);
  
  public abstract short getShortLE(int paramInt);
  
  public abstract short getUnsignedByte(int paramInt);
  
  public abstract long getUnsignedInt(int paramInt);
  
  public abstract long getUnsignedIntLE(int paramInt);
  
  public abstract int getUnsignedMedium(int paramInt);
  
  public abstract int getUnsignedMediumLE(int paramInt);
  
  public abstract int getUnsignedShort(int paramInt);
  
  public abstract int getUnsignedShortLE(int paramInt);
  
  public abstract boolean hasArray();
  
  public abstract boolean hasMemoryAddress();
  
  public abstract int hashCode();
  
  public abstract int indexOf(int paramInt1, int paramInt2, byte paramByte);
  
  public abstract ByteBuffer internalNioBuffer(int paramInt1, int paramInt2);
  
  boolean isAccessible()
  {
    boolean bool;
    if (refCnt() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isContiguous()
  {
    return false;
  }
  
  public abstract boolean isDirect();
  
  public abstract boolean isReadOnly();
  
  public abstract boolean isReadable();
  
  public abstract boolean isReadable(int paramInt);
  
  public abstract boolean isWritable();
  
  public abstract boolean isWritable(int paramInt);
  
  public abstract ByteBuf markReaderIndex();
  
  public abstract ByteBuf markWriterIndex();
  
  public abstract int maxCapacity();
  
  public int maxFastWritableBytes()
  {
    return writableBytes();
  }
  
  public abstract int maxWritableBytes();
  
  public abstract long memoryAddress();
  
  public abstract ByteBuffer nioBuffer();
  
  public abstract ByteBuffer nioBuffer(int paramInt1, int paramInt2);
  
  public abstract int nioBufferCount();
  
  public abstract ByteBuffer[] nioBuffers();
  
  public abstract ByteBuffer[] nioBuffers(int paramInt1, int paramInt2);
  
  @Deprecated
  public abstract ByteBuf order(ByteOrder paramByteOrder);
  
  @Deprecated
  public abstract ByteOrder order();
  
  public abstract boolean readBoolean();
  
  public abstract byte readByte();
  
  public abstract int readBytes(FileChannel paramFileChannel, long paramLong, int paramInt)
    throws IOException;
  
  public abstract int readBytes(GatheringByteChannel paramGatheringByteChannel, int paramInt)
    throws IOException;
  
  public abstract ByteBuf readBytes(int paramInt);
  
  public abstract ByteBuf readBytes(ByteBuf paramByteBuf);
  
  public abstract ByteBuf readBytes(ByteBuf paramByteBuf, int paramInt);
  
  public abstract ByteBuf readBytes(ByteBuf paramByteBuf, int paramInt1, int paramInt2);
  
  public abstract ByteBuf readBytes(OutputStream paramOutputStream, int paramInt)
    throws IOException;
  
  public abstract ByteBuf readBytes(ByteBuffer paramByteBuffer);
  
  public abstract ByteBuf readBytes(byte[] paramArrayOfByte);
  
  public abstract ByteBuf readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract char readChar();
  
  public abstract CharSequence readCharSequence(int paramInt, Charset paramCharset);
  
  public abstract double readDouble();
  
  public double readDoubleLE()
  {
    return Double.longBitsToDouble(readLongLE());
  }
  
  public abstract float readFloat();
  
  public float readFloatLE()
  {
    return Float.intBitsToFloat(readIntLE());
  }
  
  public abstract int readInt();
  
  public abstract int readIntLE();
  
  public abstract long readLong();
  
  public abstract long readLongLE();
  
  public abstract int readMedium();
  
  public abstract int readMediumLE();
  
  public abstract ByteBuf readRetainedSlice(int paramInt);
  
  public abstract short readShort();
  
  public abstract short readShortLE();
  
  public abstract ByteBuf readSlice(int paramInt);
  
  public abstract short readUnsignedByte();
  
  public abstract long readUnsignedInt();
  
  public abstract long readUnsignedIntLE();
  
  public abstract int readUnsignedMedium();
  
  public abstract int readUnsignedMediumLE();
  
  public abstract int readUnsignedShort();
  
  public abstract int readUnsignedShortLE();
  
  public abstract int readableBytes();
  
  public abstract int readerIndex();
  
  public abstract ByteBuf readerIndex(int paramInt);
  
  public abstract ByteBuf resetReaderIndex();
  
  public abstract ByteBuf resetWriterIndex();
  
  public abstract ByteBuf retain();
  
  public abstract ByteBuf retain(int paramInt);
  
  public abstract ByteBuf retainedDuplicate();
  
  public abstract ByteBuf retainedSlice();
  
  public abstract ByteBuf retainedSlice(int paramInt1, int paramInt2);
  
  public abstract ByteBuf setBoolean(int paramInt, boolean paramBoolean);
  
  public abstract ByteBuf setByte(int paramInt1, int paramInt2);
  
  public abstract int setBytes(int paramInt1, InputStream paramInputStream, int paramInt2)
    throws IOException;
  
  public abstract int setBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException;
  
  public abstract int setBytes(int paramInt1, ScatteringByteChannel paramScatteringByteChannel, int paramInt2)
    throws IOException;
  
  public abstract ByteBuf setBytes(int paramInt, ByteBuf paramByteBuf);
  
  public abstract ByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2);
  
  public abstract ByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3);
  
  public abstract ByteBuf setBytes(int paramInt, ByteBuffer paramByteBuffer);
  
  public abstract ByteBuf setBytes(int paramInt, byte[] paramArrayOfByte);
  
  public abstract ByteBuf setBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  public abstract ByteBuf setChar(int paramInt1, int paramInt2);
  
  public abstract int setCharSequence(int paramInt, CharSequence paramCharSequence, Charset paramCharset);
  
  public abstract ByteBuf setDouble(int paramInt, double paramDouble);
  
  public ByteBuf setDoubleLE(int paramInt, double paramDouble)
  {
    return setLongLE(paramInt, Double.doubleToRawLongBits(paramDouble));
  }
  
  public abstract ByteBuf setFloat(int paramInt, float paramFloat);
  
  public ByteBuf setFloatLE(int paramInt, float paramFloat)
  {
    return setIntLE(paramInt, Float.floatToRawIntBits(paramFloat));
  }
  
  public abstract ByteBuf setIndex(int paramInt1, int paramInt2);
  
  public abstract ByteBuf setInt(int paramInt1, int paramInt2);
  
  public abstract ByteBuf setIntLE(int paramInt1, int paramInt2);
  
  public abstract ByteBuf setLong(int paramInt, long paramLong);
  
  public abstract ByteBuf setLongLE(int paramInt, long paramLong);
  
  public abstract ByteBuf setMedium(int paramInt1, int paramInt2);
  
  public abstract ByteBuf setMediumLE(int paramInt1, int paramInt2);
  
  public abstract ByteBuf setShort(int paramInt1, int paramInt2);
  
  public abstract ByteBuf setShortLE(int paramInt1, int paramInt2);
  
  public abstract ByteBuf setZero(int paramInt1, int paramInt2);
  
  public abstract ByteBuf skipBytes(int paramInt);
  
  public abstract ByteBuf slice();
  
  public abstract ByteBuf slice(int paramInt1, int paramInt2);
  
  public abstract String toString();
  
  public abstract String toString(int paramInt1, int paramInt2, Charset paramCharset);
  
  public abstract String toString(Charset paramCharset);
  
  public abstract ByteBuf touch();
  
  public abstract ByteBuf touch(Object paramObject);
  
  public abstract ByteBuf unwrap();
  
  public abstract int writableBytes();
  
  public abstract ByteBuf writeBoolean(boolean paramBoolean);
  
  public abstract ByteBuf writeByte(int paramInt);
  
  public abstract int writeBytes(InputStream paramInputStream, int paramInt)
    throws IOException;
  
  public abstract int writeBytes(FileChannel paramFileChannel, long paramLong, int paramInt)
    throws IOException;
  
  public abstract int writeBytes(ScatteringByteChannel paramScatteringByteChannel, int paramInt)
    throws IOException;
  
  public abstract ByteBuf writeBytes(ByteBuf paramByteBuf);
  
  public abstract ByteBuf writeBytes(ByteBuf paramByteBuf, int paramInt);
  
  public abstract ByteBuf writeBytes(ByteBuf paramByteBuf, int paramInt1, int paramInt2);
  
  public abstract ByteBuf writeBytes(ByteBuffer paramByteBuffer);
  
  public abstract ByteBuf writeBytes(byte[] paramArrayOfByte);
  
  public abstract ByteBuf writeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract ByteBuf writeChar(int paramInt);
  
  public abstract int writeCharSequence(CharSequence paramCharSequence, Charset paramCharset);
  
  public abstract ByteBuf writeDouble(double paramDouble);
  
  public ByteBuf writeDoubleLE(double paramDouble)
  {
    return writeLongLE(Double.doubleToRawLongBits(paramDouble));
  }
  
  public abstract ByteBuf writeFloat(float paramFloat);
  
  public ByteBuf writeFloatLE(float paramFloat)
  {
    return writeIntLE(Float.floatToRawIntBits(paramFloat));
  }
  
  public abstract ByteBuf writeInt(int paramInt);
  
  public abstract ByteBuf writeIntLE(int paramInt);
  
  public abstract ByteBuf writeLong(long paramLong);
  
  public abstract ByteBuf writeLongLE(long paramLong);
  
  public abstract ByteBuf writeMedium(int paramInt);
  
  public abstract ByteBuf writeMediumLE(int paramInt);
  
  public abstract ByteBuf writeShort(int paramInt);
  
  public abstract ByteBuf writeShortLE(int paramInt);
  
  public abstract ByteBuf writeZero(int paramInt);
  
  public abstract int writerIndex();
  
  public abstract ByteBuf writerIndex(int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\ByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */