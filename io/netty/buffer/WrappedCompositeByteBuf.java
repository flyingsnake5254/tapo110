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
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

class WrappedCompositeByteBuf
  extends CompositeByteBuf
{
  private final CompositeByteBuf wrapped;
  
  WrappedCompositeByteBuf(CompositeByteBuf paramCompositeByteBuf)
  {
    super(paramCompositeByteBuf.alloc());
    this.wrapped = paramCompositeByteBuf;
  }
  
  protected final byte _getByte(int paramInt)
  {
    return this.wrapped._getByte(paramInt);
  }
  
  protected final int _getInt(int paramInt)
  {
    return this.wrapped._getInt(paramInt);
  }
  
  protected final int _getIntLE(int paramInt)
  {
    return this.wrapped._getIntLE(paramInt);
  }
  
  protected final long _getLong(int paramInt)
  {
    return this.wrapped._getLong(paramInt);
  }
  
  protected final long _getLongLE(int paramInt)
  {
    return this.wrapped._getLongLE(paramInt);
  }
  
  protected final short _getShort(int paramInt)
  {
    return this.wrapped._getShort(paramInt);
  }
  
  protected final short _getShortLE(int paramInt)
  {
    return this.wrapped._getShortLE(paramInt);
  }
  
  protected final int _getUnsignedMedium(int paramInt)
  {
    return this.wrapped._getUnsignedMedium(paramInt);
  }
  
  protected final int _getUnsignedMediumLE(int paramInt)
  {
    return this.wrapped._getUnsignedMediumLE(paramInt);
  }
  
  protected final void _setByte(int paramInt1, int paramInt2)
  {
    this.wrapped._setByte(paramInt1, paramInt2);
  }
  
  protected final void _setInt(int paramInt1, int paramInt2)
  {
    this.wrapped._setInt(paramInt1, paramInt2);
  }
  
  protected final void _setIntLE(int paramInt1, int paramInt2)
  {
    this.wrapped._setIntLE(paramInt1, paramInt2);
  }
  
  protected final void _setLong(int paramInt, long paramLong)
  {
    this.wrapped._setLong(paramInt, paramLong);
  }
  
  protected final void _setLongLE(int paramInt, long paramLong)
  {
    this.wrapped._setLongLE(paramInt, paramLong);
  }
  
  protected final void _setMedium(int paramInt1, int paramInt2)
  {
    this.wrapped._setMedium(paramInt1, paramInt2);
  }
  
  protected final void _setMediumLE(int paramInt1, int paramInt2)
  {
    this.wrapped._setMediumLE(paramInt1, paramInt2);
  }
  
  protected final void _setShort(int paramInt1, int paramInt2)
  {
    this.wrapped._setShort(paramInt1, paramInt2);
  }
  
  protected final void _setShortLE(int paramInt1, int paramInt2)
  {
    this.wrapped._setShortLE(paramInt1, paramInt2);
  }
  
  public CompositeByteBuf addComponent(int paramInt, ByteBuf paramByteBuf)
  {
    this.wrapped.addComponent(paramInt, paramByteBuf);
    return this;
  }
  
  public CompositeByteBuf addComponent(ByteBuf paramByteBuf)
  {
    this.wrapped.addComponent(paramByteBuf);
    return this;
  }
  
  public CompositeByteBuf addComponent(boolean paramBoolean, int paramInt, ByteBuf paramByteBuf)
  {
    this.wrapped.addComponent(paramBoolean, paramInt, paramByteBuf);
    return this;
  }
  
  public CompositeByteBuf addComponent(boolean paramBoolean, ByteBuf paramByteBuf)
  {
    this.wrapped.addComponent(paramBoolean, paramByteBuf);
    return this;
  }
  
  public CompositeByteBuf addComponents(int paramInt, Iterable<ByteBuf> paramIterable)
  {
    this.wrapped.addComponents(paramInt, paramIterable);
    return this;
  }
  
  public CompositeByteBuf addComponents(int paramInt, ByteBuf... paramVarArgs)
  {
    this.wrapped.addComponents(paramInt, paramVarArgs);
    return this;
  }
  
  public CompositeByteBuf addComponents(Iterable<ByteBuf> paramIterable)
  {
    this.wrapped.addComponents(paramIterable);
    return this;
  }
  
  public CompositeByteBuf addComponents(boolean paramBoolean, Iterable<ByteBuf> paramIterable)
  {
    this.wrapped.addComponents(paramBoolean, paramIterable);
    return this;
  }
  
  public CompositeByteBuf addComponents(boolean paramBoolean, ByteBuf... paramVarArgs)
  {
    this.wrapped.addComponents(paramBoolean, paramVarArgs);
    return this;
  }
  
  public CompositeByteBuf addComponents(ByteBuf... paramVarArgs)
  {
    this.wrapped.addComponents(paramVarArgs);
    return this;
  }
  
  public CompositeByteBuf addFlattenedComponents(boolean paramBoolean, ByteBuf paramByteBuf)
  {
    this.wrapped.addFlattenedComponents(paramBoolean, paramByteBuf);
    return this;
  }
  
  public final ByteBufAllocator alloc()
  {
    return this.wrapped.alloc();
  }
  
  public final byte[] array()
  {
    return this.wrapped.array();
  }
  
  public final int arrayOffset()
  {
    return this.wrapped.arrayOffset();
  }
  
  public ByteBuf asReadOnly()
  {
    return this.wrapped.asReadOnly();
  }
  
  public int bytesBefore(byte paramByte)
  {
    return this.wrapped.bytesBefore(paramByte);
  }
  
  public int bytesBefore(int paramInt, byte paramByte)
  {
    return this.wrapped.bytesBefore(paramInt, paramByte);
  }
  
  public int bytesBefore(int paramInt1, int paramInt2, byte paramByte)
  {
    return this.wrapped.bytesBefore(paramInt1, paramInt2, paramByte);
  }
  
  public final int capacity()
  {
    return this.wrapped.capacity();
  }
  
  public CompositeByteBuf capacity(int paramInt)
  {
    this.wrapped.capacity(paramInt);
    return this;
  }
  
  public final CompositeByteBuf clear()
  {
    this.wrapped.clear();
    return this;
  }
  
  public final int compareTo(ByteBuf paramByteBuf)
  {
    return this.wrapped.compareTo(paramByteBuf);
  }
  
  public final ByteBuf component(int paramInt)
  {
    return this.wrapped.component(paramInt);
  }
  
  public final ByteBuf componentAtOffset(int paramInt)
  {
    return this.wrapped.componentAtOffset(paramInt);
  }
  
  public CompositeByteBuf consolidate()
  {
    this.wrapped.consolidate();
    return this;
  }
  
  public CompositeByteBuf consolidate(int paramInt1, int paramInt2)
  {
    this.wrapped.consolidate(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf copy()
  {
    return this.wrapped.copy();
  }
  
  public ByteBuf copy(int paramInt1, int paramInt2)
  {
    return this.wrapped.copy(paramInt1, paramInt2);
  }
  
  public final void deallocate()
  {
    this.wrapped.deallocate();
  }
  
  public List<ByteBuf> decompose(int paramInt1, int paramInt2)
  {
    return this.wrapped.decompose(paramInt1, paramInt2);
  }
  
  public CompositeByteBuf discardReadBytes()
  {
    this.wrapped.discardReadBytes();
    return this;
  }
  
  public CompositeByteBuf discardReadComponents()
  {
    this.wrapped.discardReadComponents();
    return this;
  }
  
  public CompositeByteBuf discardSomeReadBytes()
  {
    this.wrapped.discardSomeReadBytes();
    return this;
  }
  
  public ByteBuf duplicate()
  {
    return this.wrapped.duplicate();
  }
  
  public int ensureWritable(int paramInt, boolean paramBoolean)
  {
    return this.wrapped.ensureWritable(paramInt, paramBoolean);
  }
  
  public CompositeByteBuf ensureWritable(int paramInt)
  {
    this.wrapped.ensureWritable(paramInt);
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    return this.wrapped.equals(paramObject);
  }
  
  public int forEachByte(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
  {
    return this.wrapped.forEachByte(paramInt1, paramInt2, paramByteProcessor);
  }
  
  public int forEachByte(ByteProcessor paramByteProcessor)
  {
    return this.wrapped.forEachByte(paramByteProcessor);
  }
  
  public int forEachByteDesc(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
  {
    return this.wrapped.forEachByteDesc(paramInt1, paramInt2, paramByteProcessor);
  }
  
  public int forEachByteDesc(ByteProcessor paramByteProcessor)
  {
    return this.wrapped.forEachByteDesc(paramByteProcessor);
  }
  
  public boolean getBoolean(int paramInt)
  {
    return this.wrapped.getBoolean(paramInt);
  }
  
  public byte getByte(int paramInt)
  {
    return this.wrapped.getByte(paramInt);
  }
  
  public int getBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    return this.wrapped.getBytes(paramInt1, paramFileChannel, paramLong, paramInt2);
  }
  
  public int getBytes(int paramInt1, GatheringByteChannel paramGatheringByteChannel, int paramInt2)
    throws IOException
  {
    return this.wrapped.getBytes(paramInt1, paramGatheringByteChannel, paramInt2);
  }
  
  public CompositeByteBuf getBytes(int paramInt, ByteBuf paramByteBuf)
  {
    this.wrapped.getBytes(paramInt, paramByteBuf);
    return this;
  }
  
  public CompositeByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2)
  {
    this.wrapped.getBytes(paramInt1, paramByteBuf, paramInt2);
    return this;
  }
  
  public CompositeByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    this.wrapped.getBytes(paramInt1, paramByteBuf, paramInt2, paramInt3);
    return this;
  }
  
  public CompositeByteBuf getBytes(int paramInt1, OutputStream paramOutputStream, int paramInt2)
    throws IOException
  {
    this.wrapped.getBytes(paramInt1, paramOutputStream, paramInt2);
    return this;
  }
  
  public CompositeByteBuf getBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    this.wrapped.getBytes(paramInt, paramByteBuffer);
    return this;
  }
  
  public CompositeByteBuf getBytes(int paramInt, byte[] paramArrayOfByte)
  {
    this.wrapped.getBytes(paramInt, paramArrayOfByte);
    return this;
  }
  
  public CompositeByteBuf getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    this.wrapped.getBytes(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    return this;
  }
  
  public char getChar(int paramInt)
  {
    return this.wrapped.getChar(paramInt);
  }
  
  public CharSequence getCharSequence(int paramInt1, int paramInt2, Charset paramCharset)
  {
    return this.wrapped.getCharSequence(paramInt1, paramInt2, paramCharset);
  }
  
  public double getDouble(int paramInt)
  {
    return this.wrapped.getDouble(paramInt);
  }
  
  public float getFloat(int paramInt)
  {
    return this.wrapped.getFloat(paramInt);
  }
  
  public int getInt(int paramInt)
  {
    return this.wrapped.getInt(paramInt);
  }
  
  public int getIntLE(int paramInt)
  {
    return this.wrapped.getIntLE(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    return this.wrapped.getLong(paramInt);
  }
  
  public long getLongLE(int paramInt)
  {
    return this.wrapped.getLongLE(paramInt);
  }
  
  public int getMedium(int paramInt)
  {
    return this.wrapped.getMedium(paramInt);
  }
  
  public int getMediumLE(int paramInt)
  {
    return this.wrapped.getMediumLE(paramInt);
  }
  
  public short getShort(int paramInt)
  {
    return this.wrapped.getShort(paramInt);
  }
  
  public short getShortLE(int paramInt)
  {
    return this.wrapped.getShortLE(paramInt);
  }
  
  public short getUnsignedByte(int paramInt)
  {
    return this.wrapped.getUnsignedByte(paramInt);
  }
  
  public long getUnsignedInt(int paramInt)
  {
    return this.wrapped.getUnsignedInt(paramInt);
  }
  
  public long getUnsignedIntLE(int paramInt)
  {
    return this.wrapped.getUnsignedIntLE(paramInt);
  }
  
  public int getUnsignedMedium(int paramInt)
  {
    return this.wrapped.getUnsignedMedium(paramInt);
  }
  
  public int getUnsignedMediumLE(int paramInt)
  {
    return this.wrapped.getUnsignedMediumLE(paramInt);
  }
  
  public int getUnsignedShort(int paramInt)
  {
    return this.wrapped.getUnsignedShort(paramInt);
  }
  
  public int getUnsignedShortLE(int paramInt)
  {
    return this.wrapped.getUnsignedShortLE(paramInt);
  }
  
  public final boolean hasArray()
  {
    return this.wrapped.hasArray();
  }
  
  public final boolean hasMemoryAddress()
  {
    return this.wrapped.hasMemoryAddress();
  }
  
  public final int hashCode()
  {
    return this.wrapped.hashCode();
  }
  
  public int indexOf(int paramInt1, int paramInt2, byte paramByte)
  {
    return this.wrapped.indexOf(paramInt1, paramInt2, paramByte);
  }
  
  public final ByteBuf internalComponent(int paramInt)
  {
    return this.wrapped.internalComponent(paramInt);
  }
  
  public final ByteBuf internalComponentAtOffset(int paramInt)
  {
    return this.wrapped.internalComponentAtOffset(paramInt);
  }
  
  public ByteBuffer internalNioBuffer(int paramInt1, int paramInt2)
  {
    return this.wrapped.internalNioBuffer(paramInt1, paramInt2);
  }
  
  final boolean isAccessible()
  {
    return this.wrapped.isAccessible();
  }
  
  public final boolean isDirect()
  {
    return this.wrapped.isDirect();
  }
  
  public boolean isReadOnly()
  {
    return this.wrapped.isReadOnly();
  }
  
  public final boolean isReadable()
  {
    return this.wrapped.isReadable();
  }
  
  public final boolean isReadable(int paramInt)
  {
    return this.wrapped.isReadable(paramInt);
  }
  
  public final boolean isWritable()
  {
    return this.wrapped.isWritable();
  }
  
  public final boolean isWritable(int paramInt)
  {
    return this.wrapped.isWritable(paramInt);
  }
  
  public Iterator<ByteBuf> iterator()
  {
    return this.wrapped.iterator();
  }
  
  public final CompositeByteBuf markReaderIndex()
  {
    this.wrapped.markReaderIndex();
    return this;
  }
  
  public final CompositeByteBuf markWriterIndex()
  {
    this.wrapped.markWriterIndex();
    return this;
  }
  
  public final int maxCapacity()
  {
    return this.wrapped.maxCapacity();
  }
  
  public int maxFastWritableBytes()
  {
    return this.wrapped.maxFastWritableBytes();
  }
  
  public final int maxNumComponents()
  {
    return this.wrapped.maxNumComponents();
  }
  
  public final int maxWritableBytes()
  {
    return this.wrapped.maxWritableBytes();
  }
  
  public final long memoryAddress()
  {
    return this.wrapped.memoryAddress();
  }
  
  protected SwappedByteBuf newSwappedByteBuf()
  {
    return this.wrapped.newSwappedByteBuf();
  }
  
  public ByteBuffer nioBuffer()
  {
    return this.wrapped.nioBuffer();
  }
  
  public ByteBuffer nioBuffer(int paramInt1, int paramInt2)
  {
    return this.wrapped.nioBuffer(paramInt1, paramInt2);
  }
  
  public int nioBufferCount()
  {
    return this.wrapped.nioBufferCount();
  }
  
  public ByteBuffer[] nioBuffers()
  {
    return this.wrapped.nioBuffers();
  }
  
  public ByteBuffer[] nioBuffers(int paramInt1, int paramInt2)
  {
    return this.wrapped.nioBuffers(paramInt1, paramInt2);
  }
  
  public final int numComponents()
  {
    return this.wrapped.numComponents();
  }
  
  public ByteBuf order(ByteOrder paramByteOrder)
  {
    return this.wrapped.order(paramByteOrder);
  }
  
  public final ByteOrder order()
  {
    return this.wrapped.order();
  }
  
  public boolean readBoolean()
  {
    return this.wrapped.readBoolean();
  }
  
  public byte readByte()
  {
    return this.wrapped.readByte();
  }
  
  public int readBytes(FileChannel paramFileChannel, long paramLong, int paramInt)
    throws IOException
  {
    return this.wrapped.readBytes(paramFileChannel, paramLong, paramInt);
  }
  
  public int readBytes(GatheringByteChannel paramGatheringByteChannel, int paramInt)
    throws IOException
  {
    return this.wrapped.readBytes(paramGatheringByteChannel, paramInt);
  }
  
  public ByteBuf readBytes(int paramInt)
  {
    return this.wrapped.readBytes(paramInt);
  }
  
  public CompositeByteBuf readBytes(ByteBuf paramByteBuf)
  {
    this.wrapped.readBytes(paramByteBuf);
    return this;
  }
  
  public CompositeByteBuf readBytes(ByteBuf paramByteBuf, int paramInt)
  {
    this.wrapped.readBytes(paramByteBuf, paramInt);
    return this;
  }
  
  public CompositeByteBuf readBytes(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    this.wrapped.readBytes(paramByteBuf, paramInt1, paramInt2);
    return this;
  }
  
  public CompositeByteBuf readBytes(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    this.wrapped.readBytes(paramOutputStream, paramInt);
    return this;
  }
  
  public CompositeByteBuf readBytes(ByteBuffer paramByteBuffer)
  {
    this.wrapped.readBytes(paramByteBuffer);
    return this;
  }
  
  public CompositeByteBuf readBytes(byte[] paramArrayOfByte)
  {
    this.wrapped.readBytes(paramArrayOfByte);
    return this;
  }
  
  public CompositeByteBuf readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.wrapped.readBytes(paramArrayOfByte, paramInt1, paramInt2);
    return this;
  }
  
  public char readChar()
  {
    return this.wrapped.readChar();
  }
  
  public CharSequence readCharSequence(int paramInt, Charset paramCharset)
  {
    return this.wrapped.readCharSequence(paramInt, paramCharset);
  }
  
  public double readDouble()
  {
    return this.wrapped.readDouble();
  }
  
  public float readFloat()
  {
    return this.wrapped.readFloat();
  }
  
  public int readInt()
  {
    return this.wrapped.readInt();
  }
  
  public int readIntLE()
  {
    return this.wrapped.readIntLE();
  }
  
  public long readLong()
  {
    return this.wrapped.readLong();
  }
  
  public long readLongLE()
  {
    return this.wrapped.readLongLE();
  }
  
  public int readMedium()
  {
    return this.wrapped.readMedium();
  }
  
  public int readMediumLE()
  {
    return this.wrapped.readMediumLE();
  }
  
  public ByteBuf readRetainedSlice(int paramInt)
  {
    return this.wrapped.readRetainedSlice(paramInt);
  }
  
  public short readShort()
  {
    return this.wrapped.readShort();
  }
  
  public short readShortLE()
  {
    return this.wrapped.readShortLE();
  }
  
  public ByteBuf readSlice(int paramInt)
  {
    return this.wrapped.readSlice(paramInt);
  }
  
  public short readUnsignedByte()
  {
    return this.wrapped.readUnsignedByte();
  }
  
  public long readUnsignedInt()
  {
    return this.wrapped.readUnsignedInt();
  }
  
  public long readUnsignedIntLE()
  {
    return this.wrapped.readUnsignedIntLE();
  }
  
  public int readUnsignedMedium()
  {
    return this.wrapped.readUnsignedMedium();
  }
  
  public int readUnsignedMediumLE()
  {
    return this.wrapped.readUnsignedMediumLE();
  }
  
  public int readUnsignedShort()
  {
    return this.wrapped.readUnsignedShort();
  }
  
  public int readUnsignedShortLE()
  {
    return this.wrapped.readUnsignedShortLE();
  }
  
  public final int readableBytes()
  {
    return this.wrapped.readableBytes();
  }
  
  public final int readerIndex()
  {
    return this.wrapped.readerIndex();
  }
  
  public final CompositeByteBuf readerIndex(int paramInt)
  {
    this.wrapped.readerIndex(paramInt);
    return this;
  }
  
  public final int refCnt()
  {
    return this.wrapped.refCnt();
  }
  
  public boolean release()
  {
    return this.wrapped.release();
  }
  
  public boolean release(int paramInt)
  {
    return this.wrapped.release(paramInt);
  }
  
  public CompositeByteBuf removeComponent(int paramInt)
  {
    this.wrapped.removeComponent(paramInt);
    return this;
  }
  
  public CompositeByteBuf removeComponents(int paramInt1, int paramInt2)
  {
    this.wrapped.removeComponents(paramInt1, paramInt2);
    return this;
  }
  
  public final CompositeByteBuf resetReaderIndex()
  {
    this.wrapped.resetReaderIndex();
    return this;
  }
  
  public final CompositeByteBuf resetWriterIndex()
  {
    this.wrapped.resetWriterIndex();
    return this;
  }
  
  public CompositeByteBuf retain()
  {
    this.wrapped.retain();
    return this;
  }
  
  public CompositeByteBuf retain(int paramInt)
  {
    this.wrapped.retain(paramInt);
    return this;
  }
  
  public ByteBuf retainedDuplicate()
  {
    return this.wrapped.retainedDuplicate();
  }
  
  public ByteBuf retainedSlice()
  {
    return this.wrapped.retainedSlice();
  }
  
  public ByteBuf retainedSlice(int paramInt1, int paramInt2)
  {
    return this.wrapped.retainedSlice(paramInt1, paramInt2);
  }
  
  public CompositeByteBuf setBoolean(int paramInt, boolean paramBoolean)
  {
    this.wrapped.setBoolean(paramInt, paramBoolean);
    return this;
  }
  
  public CompositeByteBuf setByte(int paramInt1, int paramInt2)
  {
    this.wrapped.setByte(paramInt1, paramInt2);
    return this;
  }
  
  public int setBytes(int paramInt1, InputStream paramInputStream, int paramInt2)
    throws IOException
  {
    return this.wrapped.setBytes(paramInt1, paramInputStream, paramInt2);
  }
  
  public int setBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    return this.wrapped.setBytes(paramInt1, paramFileChannel, paramLong, paramInt2);
  }
  
  public int setBytes(int paramInt1, ScatteringByteChannel paramScatteringByteChannel, int paramInt2)
    throws IOException
  {
    return this.wrapped.setBytes(paramInt1, paramScatteringByteChannel, paramInt2);
  }
  
  public CompositeByteBuf setBytes(int paramInt, ByteBuf paramByteBuf)
  {
    this.wrapped.setBytes(paramInt, paramByteBuf);
    return this;
  }
  
  public CompositeByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2)
  {
    this.wrapped.setBytes(paramInt1, paramByteBuf, paramInt2);
    return this;
  }
  
  public CompositeByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    this.wrapped.setBytes(paramInt1, paramByteBuf, paramInt2, paramInt3);
    return this;
  }
  
  public CompositeByteBuf setBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    this.wrapped.setBytes(paramInt, paramByteBuffer);
    return this;
  }
  
  public CompositeByteBuf setBytes(int paramInt, byte[] paramArrayOfByte)
  {
    this.wrapped.setBytes(paramInt, paramArrayOfByte);
    return this;
  }
  
  public CompositeByteBuf setBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    this.wrapped.setBytes(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    return this;
  }
  
  public CompositeByteBuf setChar(int paramInt1, int paramInt2)
  {
    this.wrapped.setChar(paramInt1, paramInt2);
    return this;
  }
  
  public int setCharSequence(int paramInt, CharSequence paramCharSequence, Charset paramCharset)
  {
    return this.wrapped.setCharSequence(paramInt, paramCharSequence, paramCharset);
  }
  
  public CompositeByteBuf setDouble(int paramInt, double paramDouble)
  {
    this.wrapped.setDouble(paramInt, paramDouble);
    return this;
  }
  
  public CompositeByteBuf setFloat(int paramInt, float paramFloat)
  {
    this.wrapped.setFloat(paramInt, paramFloat);
    return this;
  }
  
  public final CompositeByteBuf setIndex(int paramInt1, int paramInt2)
  {
    this.wrapped.setIndex(paramInt1, paramInt2);
    return this;
  }
  
  public CompositeByteBuf setInt(int paramInt1, int paramInt2)
  {
    this.wrapped.setInt(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setIntLE(int paramInt1, int paramInt2)
  {
    return this.wrapped.setIntLE(paramInt1, paramInt2);
  }
  
  public CompositeByteBuf setLong(int paramInt, long paramLong)
  {
    this.wrapped.setLong(paramInt, paramLong);
    return this;
  }
  
  public ByteBuf setLongLE(int paramInt, long paramLong)
  {
    return this.wrapped.setLongLE(paramInt, paramLong);
  }
  
  public CompositeByteBuf setMedium(int paramInt1, int paramInt2)
  {
    this.wrapped.setMedium(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setMediumLE(int paramInt1, int paramInt2)
  {
    return this.wrapped.setMediumLE(paramInt1, paramInt2);
  }
  
  public CompositeByteBuf setShort(int paramInt1, int paramInt2)
  {
    this.wrapped.setShort(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setShortLE(int paramInt1, int paramInt2)
  {
    return this.wrapped.setShortLE(paramInt1, paramInt2);
  }
  
  public CompositeByteBuf setZero(int paramInt1, int paramInt2)
  {
    this.wrapped.setZero(paramInt1, paramInt2);
    return this;
  }
  
  public CompositeByteBuf skipBytes(int paramInt)
  {
    this.wrapped.skipBytes(paramInt);
    return this;
  }
  
  public ByteBuf slice()
  {
    return this.wrapped.slice();
  }
  
  public ByteBuf slice(int paramInt1, int paramInt2)
  {
    return this.wrapped.slice(paramInt1, paramInt2);
  }
  
  public final int toByteIndex(int paramInt)
  {
    return this.wrapped.toByteIndex(paramInt);
  }
  
  public final int toComponentIndex(int paramInt)
  {
    return this.wrapped.toComponentIndex(paramInt);
  }
  
  public final String toString()
  {
    return this.wrapped.toString();
  }
  
  public String toString(int paramInt1, int paramInt2, Charset paramCharset)
  {
    return this.wrapped.toString(paramInt1, paramInt2, paramCharset);
  }
  
  public String toString(Charset paramCharset)
  {
    return this.wrapped.toString(paramCharset);
  }
  
  public CompositeByteBuf touch()
  {
    this.wrapped.touch();
    return this;
  }
  
  public CompositeByteBuf touch(Object paramObject)
  {
    this.wrapped.touch(paramObject);
    return this;
  }
  
  public final ByteBuf unwrap()
  {
    return this.wrapped;
  }
  
  public final int writableBytes()
  {
    return this.wrapped.writableBytes();
  }
  
  public CompositeByteBuf writeBoolean(boolean paramBoolean)
  {
    this.wrapped.writeBoolean(paramBoolean);
    return this;
  }
  
  public CompositeByteBuf writeByte(int paramInt)
  {
    this.wrapped.writeByte(paramInt);
    return this;
  }
  
  public int writeBytes(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    return this.wrapped.writeBytes(paramInputStream, paramInt);
  }
  
  public int writeBytes(FileChannel paramFileChannel, long paramLong, int paramInt)
    throws IOException
  {
    return this.wrapped.writeBytes(paramFileChannel, paramLong, paramInt);
  }
  
  public int writeBytes(ScatteringByteChannel paramScatteringByteChannel, int paramInt)
    throws IOException
  {
    return this.wrapped.writeBytes(paramScatteringByteChannel, paramInt);
  }
  
  public CompositeByteBuf writeBytes(ByteBuf paramByteBuf)
  {
    this.wrapped.writeBytes(paramByteBuf);
    return this;
  }
  
  public CompositeByteBuf writeBytes(ByteBuf paramByteBuf, int paramInt)
  {
    this.wrapped.writeBytes(paramByteBuf, paramInt);
    return this;
  }
  
  public CompositeByteBuf writeBytes(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    this.wrapped.writeBytes(paramByteBuf, paramInt1, paramInt2);
    return this;
  }
  
  public CompositeByteBuf writeBytes(ByteBuffer paramByteBuffer)
  {
    this.wrapped.writeBytes(paramByteBuffer);
    return this;
  }
  
  public CompositeByteBuf writeBytes(byte[] paramArrayOfByte)
  {
    this.wrapped.writeBytes(paramArrayOfByte);
    return this;
  }
  
  public CompositeByteBuf writeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.wrapped.writeBytes(paramArrayOfByte, paramInt1, paramInt2);
    return this;
  }
  
  public CompositeByteBuf writeChar(int paramInt)
  {
    this.wrapped.writeChar(paramInt);
    return this;
  }
  
  public int writeCharSequence(CharSequence paramCharSequence, Charset paramCharset)
  {
    return this.wrapped.writeCharSequence(paramCharSequence, paramCharset);
  }
  
  public CompositeByteBuf writeDouble(double paramDouble)
  {
    this.wrapped.writeDouble(paramDouble);
    return this;
  }
  
  public CompositeByteBuf writeFloat(float paramFloat)
  {
    this.wrapped.writeFloat(paramFloat);
    return this;
  }
  
  public CompositeByteBuf writeInt(int paramInt)
  {
    this.wrapped.writeInt(paramInt);
    return this;
  }
  
  public ByteBuf writeIntLE(int paramInt)
  {
    return this.wrapped.writeIntLE(paramInt);
  }
  
  public CompositeByteBuf writeLong(long paramLong)
  {
    this.wrapped.writeLong(paramLong);
    return this;
  }
  
  public ByteBuf writeLongLE(long paramLong)
  {
    return this.wrapped.writeLongLE(paramLong);
  }
  
  public CompositeByteBuf writeMedium(int paramInt)
  {
    this.wrapped.writeMedium(paramInt);
    return this;
  }
  
  public ByteBuf writeMediumLE(int paramInt)
  {
    return this.wrapped.writeMediumLE(paramInt);
  }
  
  public CompositeByteBuf writeShort(int paramInt)
  {
    this.wrapped.writeShort(paramInt);
    return this;
  }
  
  public ByteBuf writeShortLE(int paramInt)
  {
    return this.wrapped.writeShortLE(paramInt);
  }
  
  public CompositeByteBuf writeZero(int paramInt)
  {
    this.wrapped.writeZero(paramInt);
    return this;
  }
  
  public final int writerIndex()
  {
    return this.wrapped.writerIndex();
  }
  
  public final CompositeByteBuf writerIndex(int paramInt)
  {
    this.wrapped.writerIndex(paramInt);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\WrappedCompositeByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */