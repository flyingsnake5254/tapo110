package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.ResourceLeakTracker;
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

final class AdvancedLeakAwareCompositeByteBuf
  extends SimpleLeakAwareCompositeByteBuf
{
  AdvancedLeakAwareCompositeByteBuf(CompositeByteBuf paramCompositeByteBuf, ResourceLeakTracker<ByteBuf> paramResourceLeakTracker)
  {
    super(paramCompositeByteBuf, paramResourceLeakTracker);
  }
  
  public CompositeByteBuf addComponent(int paramInt, ByteBuf paramByteBuf)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.addComponent(paramInt, paramByteBuf);
  }
  
  public CompositeByteBuf addComponent(ByteBuf paramByteBuf)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.addComponent(paramByteBuf);
  }
  
  public CompositeByteBuf addComponent(boolean paramBoolean, int paramInt, ByteBuf paramByteBuf)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.addComponent(paramBoolean, paramInt, paramByteBuf);
  }
  
  public CompositeByteBuf addComponent(boolean paramBoolean, ByteBuf paramByteBuf)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.addComponent(paramBoolean, paramByteBuf);
  }
  
  public CompositeByteBuf addComponents(int paramInt, Iterable<ByteBuf> paramIterable)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.addComponents(paramInt, paramIterable);
  }
  
  public CompositeByteBuf addComponents(int paramInt, ByteBuf... paramVarArgs)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.addComponents(paramInt, paramVarArgs);
  }
  
  public CompositeByteBuf addComponents(Iterable<ByteBuf> paramIterable)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.addComponents(paramIterable);
  }
  
  public CompositeByteBuf addComponents(boolean paramBoolean, Iterable<ByteBuf> paramIterable)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.addComponents(paramBoolean, paramIterable);
  }
  
  public CompositeByteBuf addComponents(boolean paramBoolean, ByteBuf... paramVarArgs)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.addComponents(paramBoolean, paramVarArgs);
  }
  
  public CompositeByteBuf addComponents(ByteBuf... paramVarArgs)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.addComponents(paramVarArgs);
  }
  
  public CompositeByteBuf addFlattenedComponents(boolean paramBoolean, ByteBuf paramByteBuf)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.addFlattenedComponents(paramBoolean, paramByteBuf);
  }
  
  public ByteBuf asReadOnly()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.asReadOnly();
  }
  
  public int bytesBefore(byte paramByte)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.bytesBefore(paramByte);
  }
  
  public int bytesBefore(int paramInt, byte paramByte)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.bytesBefore(paramInt, paramByte);
  }
  
  public int bytesBefore(int paramInt1, int paramInt2, byte paramByte)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.bytesBefore(paramInt1, paramInt2, paramByte);
  }
  
  public CompositeByteBuf capacity(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.capacity(paramInt);
  }
  
  public CompositeByteBuf consolidate()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.consolidate();
  }
  
  public CompositeByteBuf consolidate(int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.consolidate(paramInt1, paramInt2);
  }
  
  public ByteBuf copy()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.copy();
  }
  
  public ByteBuf copy(int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.copy(paramInt1, paramInt2);
  }
  
  public List<ByteBuf> decompose(int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.decompose(paramInt1, paramInt2);
  }
  
  public CompositeByteBuf discardReadBytes()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.discardReadBytes();
  }
  
  public CompositeByteBuf discardReadComponents()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.discardReadComponents();
  }
  
  public CompositeByteBuf discardSomeReadBytes()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.discardSomeReadBytes();
  }
  
  public ByteBuf duplicate()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.duplicate();
  }
  
  public int ensureWritable(int paramInt, boolean paramBoolean)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.ensureWritable(paramInt, paramBoolean);
  }
  
  public CompositeByteBuf ensureWritable(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.ensureWritable(paramInt);
  }
  
  public int forEachByte(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.forEachByte(paramInt1, paramInt2, paramByteProcessor);
  }
  
  public int forEachByte(ByteProcessor paramByteProcessor)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.forEachByte(paramByteProcessor);
  }
  
  public int forEachByteDesc(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.forEachByteDesc(paramInt1, paramInt2, paramByteProcessor);
  }
  
  public int forEachByteDesc(ByteProcessor paramByteProcessor)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.forEachByteDesc(paramByteProcessor);
  }
  
  public boolean getBoolean(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getBoolean(paramInt);
  }
  
  public byte getByte(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getByte(paramInt);
  }
  
  public int getBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getBytes(paramInt1, paramFileChannel, paramLong, paramInt2);
  }
  
  public int getBytes(int paramInt1, GatheringByteChannel paramGatheringByteChannel, int paramInt2)
    throws IOException
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getBytes(paramInt1, paramGatheringByteChannel, paramInt2);
  }
  
  public CompositeByteBuf getBytes(int paramInt, ByteBuf paramByteBuf)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getBytes(paramInt, paramByteBuf);
  }
  
  public CompositeByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getBytes(paramInt1, paramByteBuf, paramInt2);
  }
  
  public CompositeByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getBytes(paramInt1, paramByteBuf, paramInt2, paramInt3);
  }
  
  public CompositeByteBuf getBytes(int paramInt1, OutputStream paramOutputStream, int paramInt2)
    throws IOException
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getBytes(paramInt1, paramOutputStream, paramInt2);
  }
  
  public CompositeByteBuf getBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getBytes(paramInt, paramByteBuffer);
  }
  
  public CompositeByteBuf getBytes(int paramInt, byte[] paramArrayOfByte)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getBytes(paramInt, paramArrayOfByte);
  }
  
  public CompositeByteBuf getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getBytes(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public char getChar(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getChar(paramInt);
  }
  
  public CharSequence getCharSequence(int paramInt1, int paramInt2, Charset paramCharset)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getCharSequence(paramInt1, paramInt2, paramCharset);
  }
  
  public double getDouble(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getDouble(paramInt);
  }
  
  public float getFloat(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getFloat(paramInt);
  }
  
  public int getInt(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getInt(paramInt);
  }
  
  public int getIntLE(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getIntLE(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getLong(paramInt);
  }
  
  public long getLongLE(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getLongLE(paramInt);
  }
  
  public int getMedium(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getMedium(paramInt);
  }
  
  public int getMediumLE(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getMediumLE(paramInt);
  }
  
  public short getShort(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getShort(paramInt);
  }
  
  public short getShortLE(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getShortLE(paramInt);
  }
  
  public short getUnsignedByte(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getUnsignedByte(paramInt);
  }
  
  public long getUnsignedInt(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getUnsignedInt(paramInt);
  }
  
  public long getUnsignedIntLE(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getUnsignedIntLE(paramInt);
  }
  
  public int getUnsignedMedium(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getUnsignedMedium(paramInt);
  }
  
  public int getUnsignedMediumLE(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getUnsignedMediumLE(paramInt);
  }
  
  public int getUnsignedShort(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getUnsignedShort(paramInt);
  }
  
  public int getUnsignedShortLE(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.getUnsignedShortLE(paramInt);
  }
  
  public int indexOf(int paramInt1, int paramInt2, byte paramByte)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.indexOf(paramInt1, paramInt2, paramByte);
  }
  
  public ByteBuffer internalNioBuffer(int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.internalNioBuffer(paramInt1, paramInt2);
  }
  
  public boolean isReadOnly()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.isReadOnly();
  }
  
  public Iterator<ByteBuf> iterator()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.iterator();
  }
  
  protected AdvancedLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2, ResourceLeakTracker<ByteBuf> paramResourceLeakTracker)
  {
    return new AdvancedLeakAwareByteBuf(paramByteBuf1, paramByteBuf2, paramResourceLeakTracker);
  }
  
  public ByteBuffer nioBuffer()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.nioBuffer();
  }
  
  public ByteBuffer nioBuffer(int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.nioBuffer(paramInt1, paramInt2);
  }
  
  public int nioBufferCount()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.nioBufferCount();
  }
  
  public ByteBuffer[] nioBuffers()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.nioBuffers();
  }
  
  public ByteBuffer[] nioBuffers(int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.nioBuffers(paramInt1, paramInt2);
  }
  
  public ByteBuf order(ByteOrder paramByteOrder)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.order(paramByteOrder);
  }
  
  public boolean readBoolean()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readBoolean();
  }
  
  public byte readByte()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readByte();
  }
  
  public int readBytes(FileChannel paramFileChannel, long paramLong, int paramInt)
    throws IOException
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readBytes(paramFileChannel, paramLong, paramInt);
  }
  
  public int readBytes(GatheringByteChannel paramGatheringByteChannel, int paramInt)
    throws IOException
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readBytes(paramGatheringByteChannel, paramInt);
  }
  
  public ByteBuf readBytes(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readBytes(paramInt);
  }
  
  public CompositeByteBuf readBytes(ByteBuf paramByteBuf)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readBytes(paramByteBuf);
  }
  
  public CompositeByteBuf readBytes(ByteBuf paramByteBuf, int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readBytes(paramByteBuf, paramInt);
  }
  
  public CompositeByteBuf readBytes(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readBytes(paramByteBuf, paramInt1, paramInt2);
  }
  
  public CompositeByteBuf readBytes(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readBytes(paramOutputStream, paramInt);
  }
  
  public CompositeByteBuf readBytes(ByteBuffer paramByteBuffer)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readBytes(paramByteBuffer);
  }
  
  public CompositeByteBuf readBytes(byte[] paramArrayOfByte)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readBytes(paramArrayOfByte);
  }
  
  public CompositeByteBuf readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readBytes(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public char readChar()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readChar();
  }
  
  public CharSequence readCharSequence(int paramInt, Charset paramCharset)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readCharSequence(paramInt, paramCharset);
  }
  
  public double readDouble()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readDouble();
  }
  
  public float readFloat()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readFloat();
  }
  
  public int readInt()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readInt();
  }
  
  public int readIntLE()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readIntLE();
  }
  
  public long readLong()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readLong();
  }
  
  public long readLongLE()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readLongLE();
  }
  
  public int readMedium()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readMedium();
  }
  
  public int readMediumLE()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readMediumLE();
  }
  
  public ByteBuf readRetainedSlice(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readRetainedSlice(paramInt);
  }
  
  public short readShort()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readShort();
  }
  
  public short readShortLE()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readShortLE();
  }
  
  public ByteBuf readSlice(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readSlice(paramInt);
  }
  
  public short readUnsignedByte()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readUnsignedByte();
  }
  
  public long readUnsignedInt()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readUnsignedInt();
  }
  
  public long readUnsignedIntLE()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readUnsignedIntLE();
  }
  
  public int readUnsignedMedium()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readUnsignedMedium();
  }
  
  public int readUnsignedMediumLE()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readUnsignedMediumLE();
  }
  
  public int readUnsignedShort()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readUnsignedShort();
  }
  
  public int readUnsignedShortLE()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.readUnsignedShortLE();
  }
  
  public boolean release()
  {
    this.leak.record();
    return super.release();
  }
  
  public boolean release(int paramInt)
  {
    this.leak.record();
    return super.release(paramInt);
  }
  
  public CompositeByteBuf removeComponent(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.removeComponent(paramInt);
  }
  
  public CompositeByteBuf removeComponents(int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.removeComponents(paramInt1, paramInt2);
  }
  
  public CompositeByteBuf retain()
  {
    this.leak.record();
    return super.retain();
  }
  
  public CompositeByteBuf retain(int paramInt)
  {
    this.leak.record();
    return super.retain(paramInt);
  }
  
  public ByteBuf retainedDuplicate()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.retainedDuplicate();
  }
  
  public ByteBuf retainedSlice()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.retainedSlice();
  }
  
  public ByteBuf retainedSlice(int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.retainedSlice(paramInt1, paramInt2);
  }
  
  public CompositeByteBuf setBoolean(int paramInt, boolean paramBoolean)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setBoolean(paramInt, paramBoolean);
  }
  
  public CompositeByteBuf setByte(int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setByte(paramInt1, paramInt2);
  }
  
  public int setBytes(int paramInt1, InputStream paramInputStream, int paramInt2)
    throws IOException
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setBytes(paramInt1, paramInputStream, paramInt2);
  }
  
  public int setBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setBytes(paramInt1, paramFileChannel, paramLong, paramInt2);
  }
  
  public int setBytes(int paramInt1, ScatteringByteChannel paramScatteringByteChannel, int paramInt2)
    throws IOException
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setBytes(paramInt1, paramScatteringByteChannel, paramInt2);
  }
  
  public CompositeByteBuf setBytes(int paramInt, ByteBuf paramByteBuf)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setBytes(paramInt, paramByteBuf);
  }
  
  public CompositeByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setBytes(paramInt1, paramByteBuf, paramInt2);
  }
  
  public CompositeByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setBytes(paramInt1, paramByteBuf, paramInt2, paramInt3);
  }
  
  public CompositeByteBuf setBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setBytes(paramInt, paramByteBuffer);
  }
  
  public CompositeByteBuf setBytes(int paramInt, byte[] paramArrayOfByte)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setBytes(paramInt, paramArrayOfByte);
  }
  
  public CompositeByteBuf setBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setBytes(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public CompositeByteBuf setChar(int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setChar(paramInt1, paramInt2);
  }
  
  public int setCharSequence(int paramInt, CharSequence paramCharSequence, Charset paramCharset)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setCharSequence(paramInt, paramCharSequence, paramCharset);
  }
  
  public CompositeByteBuf setDouble(int paramInt, double paramDouble)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setDouble(paramInt, paramDouble);
  }
  
  public CompositeByteBuf setFloat(int paramInt, float paramFloat)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setFloat(paramInt, paramFloat);
  }
  
  public CompositeByteBuf setInt(int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setInt(paramInt1, paramInt2);
  }
  
  public ByteBuf setIntLE(int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setIntLE(paramInt1, paramInt2);
  }
  
  public CompositeByteBuf setLong(int paramInt, long paramLong)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setLong(paramInt, paramLong);
  }
  
  public ByteBuf setLongLE(int paramInt, long paramLong)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setLongLE(paramInt, paramLong);
  }
  
  public CompositeByteBuf setMedium(int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setMedium(paramInt1, paramInt2);
  }
  
  public ByteBuf setMediumLE(int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setMediumLE(paramInt1, paramInt2);
  }
  
  public CompositeByteBuf setShort(int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setShort(paramInt1, paramInt2);
  }
  
  public ByteBuf setShortLE(int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setShortLE(paramInt1, paramInt2);
  }
  
  public CompositeByteBuf setZero(int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.setZero(paramInt1, paramInt2);
  }
  
  public CompositeByteBuf skipBytes(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.skipBytes(paramInt);
  }
  
  public ByteBuf slice()
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.slice();
  }
  
  public ByteBuf slice(int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.slice(paramInt1, paramInt2);
  }
  
  public String toString(int paramInt1, int paramInt2, Charset paramCharset)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.toString(paramInt1, paramInt2, paramCharset);
  }
  
  public String toString(Charset paramCharset)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.toString(paramCharset);
  }
  
  public CompositeByteBuf touch()
  {
    this.leak.record();
    return this;
  }
  
  public CompositeByteBuf touch(Object paramObject)
  {
    this.leak.record(paramObject);
    return this;
  }
  
  public CompositeByteBuf writeBoolean(boolean paramBoolean)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeBoolean(paramBoolean);
  }
  
  public CompositeByteBuf writeByte(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeByte(paramInt);
  }
  
  public int writeBytes(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeBytes(paramInputStream, paramInt);
  }
  
  public int writeBytes(FileChannel paramFileChannel, long paramLong, int paramInt)
    throws IOException
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeBytes(paramFileChannel, paramLong, paramInt);
  }
  
  public int writeBytes(ScatteringByteChannel paramScatteringByteChannel, int paramInt)
    throws IOException
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeBytes(paramScatteringByteChannel, paramInt);
  }
  
  public CompositeByteBuf writeBytes(ByteBuf paramByteBuf)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeBytes(paramByteBuf);
  }
  
  public CompositeByteBuf writeBytes(ByteBuf paramByteBuf, int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeBytes(paramByteBuf, paramInt);
  }
  
  public CompositeByteBuf writeBytes(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeBytes(paramByteBuf, paramInt1, paramInt2);
  }
  
  public CompositeByteBuf writeBytes(ByteBuffer paramByteBuffer)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeBytes(paramByteBuffer);
  }
  
  public CompositeByteBuf writeBytes(byte[] paramArrayOfByte)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeBytes(paramArrayOfByte);
  }
  
  public CompositeByteBuf writeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeBytes(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public CompositeByteBuf writeChar(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeChar(paramInt);
  }
  
  public int writeCharSequence(CharSequence paramCharSequence, Charset paramCharset)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeCharSequence(paramCharSequence, paramCharset);
  }
  
  public CompositeByteBuf writeDouble(double paramDouble)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeDouble(paramDouble);
  }
  
  public CompositeByteBuf writeFloat(float paramFloat)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeFloat(paramFloat);
  }
  
  public CompositeByteBuf writeInt(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeInt(paramInt);
  }
  
  public ByteBuf writeIntLE(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeIntLE(paramInt);
  }
  
  public CompositeByteBuf writeLong(long paramLong)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeLong(paramLong);
  }
  
  public ByteBuf writeLongLE(long paramLong)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeLongLE(paramLong);
  }
  
  public CompositeByteBuf writeMedium(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeMedium(paramInt);
  }
  
  public ByteBuf writeMediumLE(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeMediumLE(paramInt);
  }
  
  public CompositeByteBuf writeShort(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeShort(paramInt);
  }
  
  public ByteBuf writeShortLE(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeShortLE(paramInt);
  }
  
  public CompositeByteBuf writeZero(int paramInt)
  {
    AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
    return super.writeZero(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\AdvancedLeakAwareCompositeByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */