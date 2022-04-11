package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

final class AdvancedLeakAwareByteBuf
  extends SimpleLeakAwareByteBuf
{
  private static final boolean ACQUIRE_AND_RELEASE_ONLY;
  private static final String PROP_ACQUIRE_AND_RELEASE_ONLY = "io.netty.leakDetection.acquireAndReleaseOnly";
  private static final InternalLogger logger;
  
  static
  {
    InternalLogger localInternalLogger = InternalLoggerFactory.getInstance(AdvancedLeakAwareByteBuf.class);
    logger = localInternalLogger;
    boolean bool = SystemPropertyUtil.getBoolean("io.netty.leakDetection.acquireAndReleaseOnly", false);
    ACQUIRE_AND_RELEASE_ONLY = bool;
    if (localInternalLogger.isDebugEnabled()) {
      localInternalLogger.debug("-D{}: {}", "io.netty.leakDetection.acquireAndReleaseOnly", Boolean.valueOf(bool));
    }
    ResourceLeakDetector.addExclusions(AdvancedLeakAwareByteBuf.class, new String[] { "touch", "recordLeakNonRefCountingOperation" });
  }
  
  AdvancedLeakAwareByteBuf(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2, ResourceLeakTracker<ByteBuf> paramResourceLeakTracker)
  {
    super(paramByteBuf1, paramByteBuf2, paramResourceLeakTracker);
  }
  
  AdvancedLeakAwareByteBuf(ByteBuf paramByteBuf, ResourceLeakTracker<ByteBuf> paramResourceLeakTracker)
  {
    super(paramByteBuf, paramResourceLeakTracker);
  }
  
  static void recordLeakNonRefCountingOperation(ResourceLeakTracker<ByteBuf> paramResourceLeakTracker)
  {
    if (!ACQUIRE_AND_RELEASE_ONLY) {
      paramResourceLeakTracker.record();
    }
  }
  
  public ByteBuf asReadOnly()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.asReadOnly();
  }
  
  public int bytesBefore(byte paramByte)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.bytesBefore(paramByte);
  }
  
  public int bytesBefore(int paramInt, byte paramByte)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.bytesBefore(paramInt, paramByte);
  }
  
  public int bytesBefore(int paramInt1, int paramInt2, byte paramByte)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.bytesBefore(paramInt1, paramInt2, paramByte);
  }
  
  public ByteBuf capacity(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.capacity(paramInt);
  }
  
  public ByteBuf copy()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.copy();
  }
  
  public ByteBuf copy(int paramInt1, int paramInt2)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.copy(paramInt1, paramInt2);
  }
  
  public ByteBuf discardReadBytes()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.discardReadBytes();
  }
  
  public ByteBuf discardSomeReadBytes()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.discardSomeReadBytes();
  }
  
  public ByteBuf duplicate()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.duplicate();
  }
  
  public int ensureWritable(int paramInt, boolean paramBoolean)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.ensureWritable(paramInt, paramBoolean);
  }
  
  public ByteBuf ensureWritable(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.ensureWritable(paramInt);
  }
  
  public int forEachByte(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.forEachByte(paramInt1, paramInt2, paramByteProcessor);
  }
  
  public int forEachByte(ByteProcessor paramByteProcessor)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.forEachByte(paramByteProcessor);
  }
  
  public int forEachByteDesc(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.forEachByteDesc(paramInt1, paramInt2, paramByteProcessor);
  }
  
  public int forEachByteDesc(ByteProcessor paramByteProcessor)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.forEachByteDesc(paramByteProcessor);
  }
  
  public boolean getBoolean(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getBoolean(paramInt);
  }
  
  public byte getByte(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getByte(paramInt);
  }
  
  public int getBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getBytes(paramInt1, paramFileChannel, paramLong, paramInt2);
  }
  
  public int getBytes(int paramInt1, GatheringByteChannel paramGatheringByteChannel, int paramInt2)
    throws IOException
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getBytes(paramInt1, paramGatheringByteChannel, paramInt2);
  }
  
  public ByteBuf getBytes(int paramInt, ByteBuf paramByteBuf)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getBytes(paramInt, paramByteBuf);
  }
  
  public ByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getBytes(paramInt1, paramByteBuf, paramInt2);
  }
  
  public ByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getBytes(paramInt1, paramByteBuf, paramInt2, paramInt3);
  }
  
  public ByteBuf getBytes(int paramInt1, OutputStream paramOutputStream, int paramInt2)
    throws IOException
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getBytes(paramInt1, paramOutputStream, paramInt2);
  }
  
  public ByteBuf getBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getBytes(paramInt, paramByteBuffer);
  }
  
  public ByteBuf getBytes(int paramInt, byte[] paramArrayOfByte)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getBytes(paramInt, paramArrayOfByte);
  }
  
  public ByteBuf getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getBytes(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public char getChar(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getChar(paramInt);
  }
  
  public CharSequence getCharSequence(int paramInt1, int paramInt2, Charset paramCharset)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getCharSequence(paramInt1, paramInt2, paramCharset);
  }
  
  public double getDouble(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getDouble(paramInt);
  }
  
  public float getFloat(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getFloat(paramInt);
  }
  
  public int getInt(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getInt(paramInt);
  }
  
  public int getIntLE(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getIntLE(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getLong(paramInt);
  }
  
  public long getLongLE(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getLongLE(paramInt);
  }
  
  public int getMedium(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getMedium(paramInt);
  }
  
  public int getMediumLE(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getMediumLE(paramInt);
  }
  
  public short getShort(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getShort(paramInt);
  }
  
  public short getShortLE(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getShortLE(paramInt);
  }
  
  public short getUnsignedByte(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getUnsignedByte(paramInt);
  }
  
  public long getUnsignedInt(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getUnsignedInt(paramInt);
  }
  
  public long getUnsignedIntLE(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getUnsignedIntLE(paramInt);
  }
  
  public int getUnsignedMedium(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getUnsignedMedium(paramInt);
  }
  
  public int getUnsignedMediumLE(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getUnsignedMediumLE(paramInt);
  }
  
  public int getUnsignedShort(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getUnsignedShort(paramInt);
  }
  
  public int getUnsignedShortLE(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.getUnsignedShortLE(paramInt);
  }
  
  public int indexOf(int paramInt1, int paramInt2, byte paramByte)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.indexOf(paramInt1, paramInt2, paramByte);
  }
  
  public ByteBuffer internalNioBuffer(int paramInt1, int paramInt2)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.internalNioBuffer(paramInt1, paramInt2);
  }
  
  protected AdvancedLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2, ResourceLeakTracker<ByteBuf> paramResourceLeakTracker)
  {
    return new AdvancedLeakAwareByteBuf(paramByteBuf1, paramByteBuf2, paramResourceLeakTracker);
  }
  
  public ByteBuffer nioBuffer()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.nioBuffer();
  }
  
  public ByteBuffer nioBuffer(int paramInt1, int paramInt2)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.nioBuffer(paramInt1, paramInt2);
  }
  
  public int nioBufferCount()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.nioBufferCount();
  }
  
  public ByteBuffer[] nioBuffers()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.nioBuffers();
  }
  
  public ByteBuffer[] nioBuffers(int paramInt1, int paramInt2)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.nioBuffers(paramInt1, paramInt2);
  }
  
  public ByteBuf order(ByteOrder paramByteOrder)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.order(paramByteOrder);
  }
  
  public boolean readBoolean()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readBoolean();
  }
  
  public byte readByte()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readByte();
  }
  
  public int readBytes(FileChannel paramFileChannel, long paramLong, int paramInt)
    throws IOException
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readBytes(paramFileChannel, paramLong, paramInt);
  }
  
  public int readBytes(GatheringByteChannel paramGatheringByteChannel, int paramInt)
    throws IOException
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readBytes(paramGatheringByteChannel, paramInt);
  }
  
  public ByteBuf readBytes(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readBytes(paramInt);
  }
  
  public ByteBuf readBytes(ByteBuf paramByteBuf)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readBytes(paramByteBuf);
  }
  
  public ByteBuf readBytes(ByteBuf paramByteBuf, int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readBytes(paramByteBuf, paramInt);
  }
  
  public ByteBuf readBytes(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readBytes(paramByteBuf, paramInt1, paramInt2);
  }
  
  public ByteBuf readBytes(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readBytes(paramOutputStream, paramInt);
  }
  
  public ByteBuf readBytes(ByteBuffer paramByteBuffer)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readBytes(paramByteBuffer);
  }
  
  public ByteBuf readBytes(byte[] paramArrayOfByte)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readBytes(paramArrayOfByte);
  }
  
  public ByteBuf readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readBytes(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public char readChar()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readChar();
  }
  
  public CharSequence readCharSequence(int paramInt, Charset paramCharset)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readCharSequence(paramInt, paramCharset);
  }
  
  public double readDouble()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readDouble();
  }
  
  public float readFloat()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readFloat();
  }
  
  public int readInt()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readInt();
  }
  
  public int readIntLE()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readIntLE();
  }
  
  public long readLong()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readLong();
  }
  
  public long readLongLE()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readLongLE();
  }
  
  public int readMedium()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readMedium();
  }
  
  public int readMediumLE()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readMediumLE();
  }
  
  public ByteBuf readRetainedSlice(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readRetainedSlice(paramInt);
  }
  
  public short readShort()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readShort();
  }
  
  public short readShortLE()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readShortLE();
  }
  
  public ByteBuf readSlice(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readSlice(paramInt);
  }
  
  public short readUnsignedByte()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readUnsignedByte();
  }
  
  public long readUnsignedInt()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readUnsignedInt();
  }
  
  public long readUnsignedIntLE()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readUnsignedIntLE();
  }
  
  public int readUnsignedMedium()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readUnsignedMedium();
  }
  
  public int readUnsignedMediumLE()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readUnsignedMediumLE();
  }
  
  public int readUnsignedShort()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.readUnsignedShort();
  }
  
  public int readUnsignedShortLE()
  {
    recordLeakNonRefCountingOperation(this.leak);
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
  
  public ByteBuf retain()
  {
    this.leak.record();
    return super.retain();
  }
  
  public ByteBuf retain(int paramInt)
  {
    this.leak.record();
    return super.retain(paramInt);
  }
  
  public ByteBuf retainedDuplicate()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.retainedDuplicate();
  }
  
  public ByteBuf retainedSlice()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.retainedSlice();
  }
  
  public ByteBuf retainedSlice(int paramInt1, int paramInt2)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.retainedSlice(paramInt1, paramInt2);
  }
  
  public ByteBuf setBoolean(int paramInt, boolean paramBoolean)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setBoolean(paramInt, paramBoolean);
  }
  
  public ByteBuf setByte(int paramInt1, int paramInt2)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setByte(paramInt1, paramInt2);
  }
  
  public int setBytes(int paramInt1, InputStream paramInputStream, int paramInt2)
    throws IOException
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setBytes(paramInt1, paramInputStream, paramInt2);
  }
  
  public int setBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setBytes(paramInt1, paramFileChannel, paramLong, paramInt2);
  }
  
  public int setBytes(int paramInt1, ScatteringByteChannel paramScatteringByteChannel, int paramInt2)
    throws IOException
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setBytes(paramInt1, paramScatteringByteChannel, paramInt2);
  }
  
  public ByteBuf setBytes(int paramInt, ByteBuf paramByteBuf)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setBytes(paramInt, paramByteBuf);
  }
  
  public ByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setBytes(paramInt1, paramByteBuf, paramInt2);
  }
  
  public ByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setBytes(paramInt1, paramByteBuf, paramInt2, paramInt3);
  }
  
  public ByteBuf setBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setBytes(paramInt, paramByteBuffer);
  }
  
  public ByteBuf setBytes(int paramInt, byte[] paramArrayOfByte)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setBytes(paramInt, paramArrayOfByte);
  }
  
  public ByteBuf setBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setBytes(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public ByteBuf setChar(int paramInt1, int paramInt2)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setChar(paramInt1, paramInt2);
  }
  
  public int setCharSequence(int paramInt, CharSequence paramCharSequence, Charset paramCharset)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setCharSequence(paramInt, paramCharSequence, paramCharset);
  }
  
  public ByteBuf setDouble(int paramInt, double paramDouble)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setDouble(paramInt, paramDouble);
  }
  
  public ByteBuf setFloat(int paramInt, float paramFloat)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setFloat(paramInt, paramFloat);
  }
  
  public ByteBuf setInt(int paramInt1, int paramInt2)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setInt(paramInt1, paramInt2);
  }
  
  public ByteBuf setIntLE(int paramInt1, int paramInt2)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setIntLE(paramInt1, paramInt2);
  }
  
  public ByteBuf setLong(int paramInt, long paramLong)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setLong(paramInt, paramLong);
  }
  
  public ByteBuf setLongLE(int paramInt, long paramLong)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setLongLE(paramInt, paramLong);
  }
  
  public ByteBuf setMedium(int paramInt1, int paramInt2)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setMedium(paramInt1, paramInt2);
  }
  
  public ByteBuf setMediumLE(int paramInt1, int paramInt2)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setMediumLE(paramInt1, paramInt2);
  }
  
  public ByteBuf setShort(int paramInt1, int paramInt2)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setShort(paramInt1, paramInt2);
  }
  
  public ByteBuf setShortLE(int paramInt1, int paramInt2)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setShortLE(paramInt1, paramInt2);
  }
  
  public ByteBuf setZero(int paramInt1, int paramInt2)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.setZero(paramInt1, paramInt2);
  }
  
  public ByteBuf skipBytes(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.skipBytes(paramInt);
  }
  
  public ByteBuf slice()
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.slice();
  }
  
  public ByteBuf slice(int paramInt1, int paramInt2)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.slice(paramInt1, paramInt2);
  }
  
  public String toString(int paramInt1, int paramInt2, Charset paramCharset)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.toString(paramInt1, paramInt2, paramCharset);
  }
  
  public String toString(Charset paramCharset)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.toString(paramCharset);
  }
  
  public ByteBuf touch()
  {
    this.leak.record();
    return this;
  }
  
  public ByteBuf touch(Object paramObject)
  {
    this.leak.record(paramObject);
    return this;
  }
  
  public ByteBuf writeBoolean(boolean paramBoolean)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeBoolean(paramBoolean);
  }
  
  public ByteBuf writeByte(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeByte(paramInt);
  }
  
  public int writeBytes(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeBytes(paramInputStream, paramInt);
  }
  
  public int writeBytes(FileChannel paramFileChannel, long paramLong, int paramInt)
    throws IOException
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeBytes(paramFileChannel, paramLong, paramInt);
  }
  
  public int writeBytes(ScatteringByteChannel paramScatteringByteChannel, int paramInt)
    throws IOException
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeBytes(paramScatteringByteChannel, paramInt);
  }
  
  public ByteBuf writeBytes(ByteBuf paramByteBuf)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeBytes(paramByteBuf);
  }
  
  public ByteBuf writeBytes(ByteBuf paramByteBuf, int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeBytes(paramByteBuf, paramInt);
  }
  
  public ByteBuf writeBytes(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeBytes(paramByteBuf, paramInt1, paramInt2);
  }
  
  public ByteBuf writeBytes(ByteBuffer paramByteBuffer)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeBytes(paramByteBuffer);
  }
  
  public ByteBuf writeBytes(byte[] paramArrayOfByte)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeBytes(paramArrayOfByte);
  }
  
  public ByteBuf writeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeBytes(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public ByteBuf writeChar(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeChar(paramInt);
  }
  
  public int writeCharSequence(CharSequence paramCharSequence, Charset paramCharset)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeCharSequence(paramCharSequence, paramCharset);
  }
  
  public ByteBuf writeDouble(double paramDouble)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeDouble(paramDouble);
  }
  
  public ByteBuf writeFloat(float paramFloat)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeFloat(paramFloat);
  }
  
  public ByteBuf writeInt(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeInt(paramInt);
  }
  
  public ByteBuf writeIntLE(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeIntLE(paramInt);
  }
  
  public ByteBuf writeLong(long paramLong)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeLong(paramLong);
  }
  
  public ByteBuf writeLongLE(long paramLong)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeLongLE(paramLong);
  }
  
  public ByteBuf writeMedium(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeMedium(paramInt);
  }
  
  public ByteBuf writeMediumLE(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeMediumLE(paramInt);
  }
  
  public ByteBuf writeShort(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeShort(paramInt);
  }
  
  public ByteBuf writeShortLE(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeShortLE(paramInt);
  }
  
  public ByteBuf writeZero(int paramInt)
  {
    recordLeakNonRefCountingOperation(this.leak);
    return super.writeZero(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\AdvancedLeakAwareByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */