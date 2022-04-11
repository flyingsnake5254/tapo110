package io.netty.buffer;

import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
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

public abstract class AbstractByteBuf
  extends ByteBuf
{
  private static final String LEGACY_PROP_CHECK_ACCESSIBLE = "io.netty.buffer.bytebuf.checkAccessible";
  private static final String PROP_CHECK_ACCESSIBLE = "io.netty.buffer.checkAccessible";
  private static final String PROP_CHECK_BOUNDS = "io.netty.buffer.checkBounds";
  static final boolean checkAccessible;
  private static final boolean checkBounds;
  static final ResourceLeakDetector<ByteBuf> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ByteBuf.class);
  private static final InternalLogger logger;
  private int markedReaderIndex;
  private int markedWriterIndex;
  private int maxCapacity;
  int readerIndex;
  int writerIndex;
  
  static
  {
    InternalLogger localInternalLogger = InternalLoggerFactory.getInstance(AbstractByteBuf.class);
    logger = localInternalLogger;
    if (SystemPropertyUtil.contains("io.netty.buffer.checkAccessible")) {
      checkAccessible = SystemPropertyUtil.getBoolean("io.netty.buffer.checkAccessible", true);
    } else {
      checkAccessible = SystemPropertyUtil.getBoolean("io.netty.buffer.bytebuf.checkAccessible", true);
    }
    boolean bool = SystemPropertyUtil.getBoolean("io.netty.buffer.checkBounds", true);
    checkBounds = bool;
    if (localInternalLogger.isDebugEnabled())
    {
      localInternalLogger.debug("-D{}: {}", "io.netty.buffer.checkAccessible", Boolean.valueOf(checkAccessible));
      localInternalLogger.debug("-D{}: {}", "io.netty.buffer.checkBounds", Boolean.valueOf(bool));
    }
  }
  
  protected AbstractByteBuf(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "maxCapacity");
    this.maxCapacity = paramInt;
  }
  
  private static void checkIndexBounds(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= paramInt2) && (paramInt2 <= paramInt3)) {
      return;
    }
    throw new IndexOutOfBoundsException(String.format("readerIndex: %d, writerIndex: %d (expected: 0 <= readerIndex <= writerIndex <= capacity(%d))", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
  }
  
  private static void checkRangeBounds(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!MathUtil.isOutOfBounds(paramInt1, paramInt2, paramInt3)) {
      return;
    }
    throw new IndexOutOfBoundsException(String.format("%s: %d, length: %d (expected: range(0, %d))", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
  }
  
  private static void checkReadableBounds(ByteBuf paramByteBuf, int paramInt)
  {
    if (paramInt <= paramByteBuf.readableBytes()) {
      return;
    }
    throw new IndexOutOfBoundsException(String.format("length(%d) exceeds src.readableBytes(%d) where src is: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramByteBuf.readableBytes()), paramByteBuf }));
  }
  
  private void checkReadableBytes0(int paramInt)
  {
    ensureAccessible();
    if ((checkBounds) && (this.readerIndex > this.writerIndex - paramInt)) {
      throw new IndexOutOfBoundsException(String.format("readerIndex(%d) + length(%d) exceeds writerIndex(%d): %s", new Object[] { Integer.valueOf(this.readerIndex), Integer.valueOf(paramInt), Integer.valueOf(this.writerIndex), this }));
    }
  }
  
  private int firstIndexOf(int paramInt1, int paramInt2, byte paramByte)
  {
    paramInt1 = Math.max(paramInt1, 0);
    if ((paramInt1 < paramInt2) && (capacity() != 0))
    {
      checkIndex(paramInt1, paramInt2 - paramInt1);
      while (paramInt1 < paramInt2)
      {
        if (_getByte(paramInt1) == paramByte) {
          return paramInt1;
        }
        paramInt1++;
      }
    }
    return -1;
  }
  
  private int lastIndexOf(int paramInt1, int paramInt2, byte paramByte)
  {
    paramInt1 = Math.min(paramInt1, capacity());
    if ((paramInt1 >= 0) && (capacity() != 0))
    {
      checkIndex(paramInt2, paramInt1 - paramInt2);
      paramInt1--;
      while (paramInt1 >= paramInt2)
      {
        if (_getByte(paramInt1) == paramByte) {
          return paramInt1;
        }
        paramInt1--;
      }
    }
    return -1;
  }
  
  private int setCharSequence0(int paramInt, CharSequence paramCharSequence, Charset paramCharset, boolean paramBoolean)
  {
    if (paramCharset.equals(CharsetUtil.UTF_8))
    {
      i = ByteBufUtil.utf8MaxBytes(paramCharSequence);
      if (paramBoolean)
      {
        ensureWritable0(i);
        checkIndex0(paramInt, i);
      }
      else
      {
        checkIndex(paramInt, i);
      }
      return ByteBufUtil.writeUtf8(this, paramInt, paramCharSequence, paramCharSequence.length());
    }
    if ((!paramCharset.equals(CharsetUtil.US_ASCII)) && (!paramCharset.equals(CharsetUtil.ISO_8859_1)))
    {
      paramCharSequence = paramCharSequence.toString().getBytes(paramCharset);
      if (paramBoolean) {
        ensureWritable0(paramCharSequence.length);
      }
      setBytes(paramInt, paramCharSequence);
      return paramCharSequence.length;
    }
    int i = paramCharSequence.length();
    if (paramBoolean)
    {
      ensureWritable0(i);
      checkIndex0(paramInt, i);
    }
    else
    {
      checkIndex(paramInt, i);
    }
    return ByteBufUtil.writeAscii(this, paramInt, paramCharSequence, i);
  }
  
  protected abstract byte _getByte(int paramInt);
  
  protected abstract int _getInt(int paramInt);
  
  protected abstract int _getIntLE(int paramInt);
  
  protected abstract long _getLong(int paramInt);
  
  protected abstract long _getLongLE(int paramInt);
  
  protected abstract short _getShort(int paramInt);
  
  protected abstract short _getShortLE(int paramInt);
  
  protected abstract int _getUnsignedMedium(int paramInt);
  
  protected abstract int _getUnsignedMediumLE(int paramInt);
  
  protected abstract void _setByte(int paramInt1, int paramInt2);
  
  protected abstract void _setInt(int paramInt1, int paramInt2);
  
  protected abstract void _setIntLE(int paramInt1, int paramInt2);
  
  protected abstract void _setLong(int paramInt, long paramLong);
  
  protected abstract void _setLongLE(int paramInt, long paramLong);
  
  protected abstract void _setMedium(int paramInt1, int paramInt2);
  
  protected abstract void _setMediumLE(int paramInt1, int paramInt2);
  
  protected abstract void _setShort(int paramInt1, int paramInt2);
  
  protected abstract void _setShortLE(int paramInt1, int paramInt2);
  
  protected final void adjustMarkers(int paramInt)
  {
    int i = this.markedReaderIndex;
    if (i <= paramInt)
    {
      this.markedReaderIndex = 0;
      i = this.markedWriterIndex;
      if (i <= paramInt) {
        this.markedWriterIndex = 0;
      } else {
        this.markedWriterIndex = (i - paramInt);
      }
    }
    else
    {
      this.markedReaderIndex = (i - paramInt);
      this.markedWriterIndex -= paramInt;
    }
  }
  
  public ByteBuf asReadOnly()
  {
    if (isReadOnly()) {
      return this;
    }
    return Unpooled.unmodifiableBuffer(this);
  }
  
  public int bytesBefore(byte paramByte)
  {
    return bytesBefore(readerIndex(), readableBytes(), paramByte);
  }
  
  public int bytesBefore(int paramInt, byte paramByte)
  {
    checkReadableBytes(paramInt);
    return bytesBefore(readerIndex(), paramInt, paramByte);
  }
  
  public int bytesBefore(int paramInt1, int paramInt2, byte paramByte)
  {
    paramInt2 = indexOf(paramInt1, paramInt2 + paramInt1, paramByte);
    if (paramInt2 < 0) {
      return -1;
    }
    return paramInt2 - paramInt1;
  }
  
  protected final void checkDstIndex(int paramInt1, int paramInt2, int paramInt3)
  {
    checkReadableBytes(paramInt1);
    if (checkBounds) {
      checkRangeBounds("dstIndex", paramInt2, paramInt1, paramInt3);
    }
  }
  
  protected final void checkDstIndex(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    checkIndex(paramInt1, paramInt2);
    if (checkBounds) {
      checkRangeBounds("dstIndex", paramInt3, paramInt2, paramInt4);
    }
  }
  
  protected final void checkIndex(int paramInt)
  {
    checkIndex(paramInt, 1);
  }
  
  protected final void checkIndex(int paramInt1, int paramInt2)
  {
    ensureAccessible();
    checkIndex0(paramInt1, paramInt2);
  }
  
  final void checkIndex0(int paramInt1, int paramInt2)
  {
    if (checkBounds) {
      checkRangeBounds("index", paramInt1, paramInt2, capacity());
    }
  }
  
  protected final void checkNewCapacity(int paramInt)
  {
    ensureAccessible();
    if ((checkBounds) && ((paramInt < 0) || (paramInt > maxCapacity())))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("newCapacity: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" (expected: 0-");
      localStringBuilder.append(maxCapacity());
      localStringBuilder.append(')');
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  protected final void checkReadableBytes(int paramInt)
  {
    checkReadableBytes0(ObjectUtil.checkPositiveOrZero(paramInt, "minimumReadableBytes"));
  }
  
  protected final void checkSrcIndex(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    checkIndex(paramInt1, paramInt2);
    if (checkBounds) {
      checkRangeBounds("srcIndex", paramInt3, paramInt2, paramInt4);
    }
  }
  
  public ByteBuf clear()
  {
    this.writerIndex = 0;
    this.readerIndex = 0;
    return this;
  }
  
  public int compareTo(ByteBuf paramByteBuf)
  {
    return ByteBufUtil.compare(this, paramByteBuf);
  }
  
  public ByteBuf copy()
  {
    return copy(this.readerIndex, readableBytes());
  }
  
  final void discardMarks()
  {
    this.markedWriterIndex = 0;
    this.markedReaderIndex = 0;
  }
  
  public ByteBuf discardReadBytes()
  {
    int i = this.readerIndex;
    if (i == 0)
    {
      ensureAccessible();
      return this;
    }
    int j = this.writerIndex;
    if (i != j)
    {
      setBytes(0, this, i, j - i);
      j = this.writerIndex;
      i = this.readerIndex;
      this.writerIndex = (j - i);
      adjustMarkers(i);
      this.readerIndex = 0;
    }
    else
    {
      ensureAccessible();
      adjustMarkers(this.readerIndex);
      this.readerIndex = 0;
      this.writerIndex = 0;
    }
    return this;
  }
  
  public ByteBuf discardSomeReadBytes()
  {
    int i = this.readerIndex;
    if (i > 0)
    {
      if (i == this.writerIndex)
      {
        ensureAccessible();
        adjustMarkers(this.readerIndex);
        this.readerIndex = 0;
        this.writerIndex = 0;
        return this;
      }
      if (i >= capacity() >>> 1)
      {
        i = this.readerIndex;
        setBytes(0, this, i, this.writerIndex - i);
        int j = this.writerIndex;
        i = this.readerIndex;
        this.writerIndex = (j - i);
        adjustMarkers(i);
        this.readerIndex = 0;
        return this;
      }
    }
    ensureAccessible();
    return this;
  }
  
  public ByteBuf duplicate()
  {
    ensureAccessible();
    return new UnpooledDuplicatedByteBuf(this);
  }
  
  protected final void ensureAccessible()
  {
    if ((checkAccessible) && (!isAccessible())) {
      throw new IllegalReferenceCountException(0);
    }
  }
  
  public int ensureWritable(int paramInt, boolean paramBoolean)
  {
    ensureAccessible();
    ObjectUtil.checkPositiveOrZero(paramInt, "minWritableBytes");
    if (paramInt <= writableBytes()) {
      return 0;
    }
    int i = maxCapacity();
    int j = writerIndex();
    if (paramInt > i - j)
    {
      if ((paramBoolean) && (capacity() != i))
      {
        capacity(i);
        return 3;
      }
      return 1;
    }
    int k = maxFastWritableBytes();
    if (k >= paramInt) {
      paramInt = j + k;
    } else {
      paramInt = alloc().calculateNewCapacity(j + paramInt, i);
    }
    capacity(paramInt);
    return 2;
  }
  
  public ByteBuf ensureWritable(int paramInt)
  {
    ensureWritable0(ObjectUtil.checkPositiveOrZero(paramInt, "minWritableBytes"));
    return this;
  }
  
  final void ensureWritable0(int paramInt)
  {
    int i = writerIndex();
    int j = i + paramInt;
    if (j <= capacity())
    {
      ensureAccessible();
      return;
    }
    if ((checkBounds) && (j > this.maxCapacity))
    {
      ensureAccessible();
      throw new IndexOutOfBoundsException(String.format("writerIndex(%d) + minWritableBytes(%d) exceeds maxCapacity(%d): %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(this.maxCapacity), this }));
    }
    int k = maxFastWritableBytes();
    if (k >= paramInt) {
      paramInt = i + k;
    } else {
      paramInt = alloc().calculateNewCapacity(j, this.maxCapacity);
    }
    capacity(paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if ((this != paramObject) && ((!(paramObject instanceof ByteBuf)) || (!ByteBufUtil.equals(this, (ByteBuf)paramObject)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int forEachByte(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
  {
    checkIndex(paramInt1, paramInt2);
    try
    {
      paramInt1 = forEachByteAsc0(paramInt1, paramInt2 + paramInt1, paramByteProcessor);
      return paramInt1;
    }
    catch (Exception paramByteProcessor)
    {
      PlatformDependent.throwException(paramByteProcessor);
    }
    return -1;
  }
  
  public int forEachByte(ByteProcessor paramByteProcessor)
  {
    ensureAccessible();
    try
    {
      int i = forEachByteAsc0(this.readerIndex, this.writerIndex, paramByteProcessor);
      return i;
    }
    catch (Exception paramByteProcessor)
    {
      PlatformDependent.throwException(paramByteProcessor);
    }
    return -1;
  }
  
  int forEachByteAsc0(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
    throws Exception
  {
    while (paramInt1 < paramInt2)
    {
      if (!paramByteProcessor.process(_getByte(paramInt1))) {
        return paramInt1;
      }
      paramInt1++;
    }
    return -1;
  }
  
  public int forEachByteDesc(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
  {
    checkIndex(paramInt1, paramInt2);
    try
    {
      paramInt1 = forEachByteDesc0(paramInt2 + paramInt1 - 1, paramInt1, paramByteProcessor);
      return paramInt1;
    }
    catch (Exception paramByteProcessor)
    {
      PlatformDependent.throwException(paramByteProcessor);
    }
    return -1;
  }
  
  public int forEachByteDesc(ByteProcessor paramByteProcessor)
  {
    ensureAccessible();
    try
    {
      int i = forEachByteDesc0(this.writerIndex - 1, this.readerIndex, paramByteProcessor);
      return i;
    }
    catch (Exception paramByteProcessor)
    {
      PlatformDependent.throwException(paramByteProcessor);
    }
    return -1;
  }
  
  int forEachByteDesc0(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
    throws Exception
  {
    while (paramInt1 >= paramInt2)
    {
      if (!paramByteProcessor.process(_getByte(paramInt1))) {
        return paramInt1;
      }
      paramInt1--;
    }
    return -1;
  }
  
  public boolean getBoolean(int paramInt)
  {
    boolean bool;
    if (getByte(paramInt) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public byte getByte(int paramInt)
  {
    checkIndex(paramInt);
    return _getByte(paramInt);
  }
  
  public ByteBuf getBytes(int paramInt, ByteBuf paramByteBuf)
  {
    getBytes(paramInt, paramByteBuf, paramByteBuf.writableBytes());
    return this;
  }
  
  public ByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2)
  {
    getBytes(paramInt1, paramByteBuf, paramByteBuf.writerIndex(), paramInt2);
    paramByteBuf.writerIndex(paramByteBuf.writerIndex() + paramInt2);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt, byte[] paramArrayOfByte)
  {
    getBytes(paramInt, paramArrayOfByte, 0, paramArrayOfByte.length);
    return this;
  }
  
  public char getChar(int paramInt)
  {
    return (char)getShort(paramInt);
  }
  
  public CharSequence getCharSequence(int paramInt1, int paramInt2, Charset paramCharset)
  {
    if ((!CharsetUtil.US_ASCII.equals(paramCharset)) && (!CharsetUtil.ISO_8859_1.equals(paramCharset))) {
      return toString(paramInt1, paramInt2, paramCharset);
    }
    return new AsciiString(ByteBufUtil.getBytes(this, paramInt1, paramInt2, true), false);
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
    checkIndex(paramInt, 4);
    return _getInt(paramInt);
  }
  
  public int getIntLE(int paramInt)
  {
    checkIndex(paramInt, 4);
    return _getIntLE(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    checkIndex(paramInt, 8);
    return _getLong(paramInt);
  }
  
  public long getLongLE(int paramInt)
  {
    checkIndex(paramInt, 8);
    return _getLongLE(paramInt);
  }
  
  public int getMedium(int paramInt)
  {
    int i = getUnsignedMedium(paramInt);
    paramInt = i;
    if ((0x800000 & i) != 0) {
      paramInt = i | 0xFF000000;
    }
    return paramInt;
  }
  
  public int getMediumLE(int paramInt)
  {
    int i = getUnsignedMediumLE(paramInt);
    paramInt = i;
    if ((0x800000 & i) != 0) {
      paramInt = i | 0xFF000000;
    }
    return paramInt;
  }
  
  public short getShort(int paramInt)
  {
    checkIndex(paramInt, 2);
    return _getShort(paramInt);
  }
  
  public short getShortLE(int paramInt)
  {
    checkIndex(paramInt, 2);
    return _getShortLE(paramInt);
  }
  
  public short getUnsignedByte(int paramInt)
  {
    return (short)(getByte(paramInt) & 0xFF);
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
    checkIndex(paramInt, 3);
    return _getUnsignedMedium(paramInt);
  }
  
  public int getUnsignedMediumLE(int paramInt)
  {
    checkIndex(paramInt, 3);
    return _getUnsignedMediumLE(paramInt);
  }
  
  public int getUnsignedShort(int paramInt)
  {
    return getShort(paramInt) & 0xFFFF;
  }
  
  public int getUnsignedShortLE(int paramInt)
  {
    return getShortLE(paramInt) & 0xFFFF;
  }
  
  public int hashCode()
  {
    return ByteBufUtil.hashCode(this);
  }
  
  public int indexOf(int paramInt1, int paramInt2, byte paramByte)
  {
    if (paramInt1 <= paramInt2) {
      return firstIndexOf(paramInt1, paramInt2, paramByte);
    }
    return lastIndexOf(paramInt1, paramInt2, paramByte);
  }
  
  public boolean isReadOnly()
  {
    return false;
  }
  
  public boolean isReadable()
  {
    boolean bool;
    if (this.writerIndex > this.readerIndex) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isReadable(int paramInt)
  {
    boolean bool;
    if (this.writerIndex - this.readerIndex >= paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isWritable()
  {
    boolean bool;
    if (capacity() > this.writerIndex) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isWritable(int paramInt)
  {
    boolean bool;
    if (capacity() - this.writerIndex >= paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public ByteBuf markReaderIndex()
  {
    this.markedReaderIndex = this.readerIndex;
    return this;
  }
  
  public ByteBuf markWriterIndex()
  {
    this.markedWriterIndex = this.writerIndex;
    return this;
  }
  
  public int maxCapacity()
  {
    return this.maxCapacity;
  }
  
  protected final void maxCapacity(int paramInt)
  {
    this.maxCapacity = paramInt;
  }
  
  public int maxWritableBytes()
  {
    return maxCapacity() - this.writerIndex;
  }
  
  protected SwappedByteBuf newSwappedByteBuf()
  {
    return new SwappedByteBuf(this);
  }
  
  public ByteBuffer nioBuffer()
  {
    return nioBuffer(this.readerIndex, readableBytes());
  }
  
  public ByteBuffer[] nioBuffers()
  {
    return nioBuffers(this.readerIndex, readableBytes());
  }
  
  public ByteBuf order(ByteOrder paramByteOrder)
  {
    if (paramByteOrder == order()) {
      return this;
    }
    ObjectUtil.checkNotNull(paramByteOrder, "endianness");
    return newSwappedByteBuf();
  }
  
  public boolean readBoolean()
  {
    boolean bool;
    if (readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public byte readByte()
  {
    checkReadableBytes0(1);
    int i = this.readerIndex;
    byte b = _getByte(i);
    this.readerIndex = (i + 1);
    return b;
  }
  
  public int readBytes(FileChannel paramFileChannel, long paramLong, int paramInt)
    throws IOException
  {
    checkReadableBytes(paramInt);
    paramInt = getBytes(this.readerIndex, paramFileChannel, paramLong, paramInt);
    this.readerIndex += paramInt;
    return paramInt;
  }
  
  public int readBytes(GatheringByteChannel paramGatheringByteChannel, int paramInt)
    throws IOException
  {
    checkReadableBytes(paramInt);
    paramInt = getBytes(this.readerIndex, paramGatheringByteChannel, paramInt);
    this.readerIndex += paramInt;
    return paramInt;
  }
  
  public ByteBuf readBytes(int paramInt)
  {
    checkReadableBytes(paramInt);
    if (paramInt == 0) {
      return Unpooled.EMPTY_BUFFER;
    }
    ByteBuf localByteBuf = alloc().buffer(paramInt, this.maxCapacity);
    localByteBuf.writeBytes(this, this.readerIndex, paramInt);
    this.readerIndex += paramInt;
    return localByteBuf;
  }
  
  public ByteBuf readBytes(ByteBuf paramByteBuf)
  {
    readBytes(paramByteBuf, paramByteBuf.writableBytes());
    return this;
  }
  
  public ByteBuf readBytes(ByteBuf paramByteBuf, int paramInt)
  {
    if ((checkBounds) && (paramInt > paramByteBuf.writableBytes())) {
      throw new IndexOutOfBoundsException(String.format("length(%d) exceeds dst.writableBytes(%d) where dst is: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramByteBuf.writableBytes()), paramByteBuf }));
    }
    readBytes(paramByteBuf, paramByteBuf.writerIndex(), paramInt);
    paramByteBuf.writerIndex(paramByteBuf.writerIndex() + paramInt);
    return this;
  }
  
  public ByteBuf readBytes(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    checkReadableBytes(paramInt2);
    getBytes(this.readerIndex, paramByteBuf, paramInt1, paramInt2);
    this.readerIndex += paramInt2;
    return this;
  }
  
  public ByteBuf readBytes(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    checkReadableBytes(paramInt);
    getBytes(this.readerIndex, paramOutputStream, paramInt);
    this.readerIndex += paramInt;
    return this;
  }
  
  public ByteBuf readBytes(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.remaining();
    checkReadableBytes(i);
    getBytes(this.readerIndex, paramByteBuffer);
    this.readerIndex += i;
    return this;
  }
  
  public ByteBuf readBytes(byte[] paramArrayOfByte)
  {
    readBytes(paramArrayOfByte, 0, paramArrayOfByte.length);
    return this;
  }
  
  public ByteBuf readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    checkReadableBytes(paramInt2);
    getBytes(this.readerIndex, paramArrayOfByte, paramInt1, paramInt2);
    this.readerIndex += paramInt2;
    return this;
  }
  
  public char readChar()
  {
    return (char)readShort();
  }
  
  public CharSequence readCharSequence(int paramInt, Charset paramCharset)
  {
    paramCharset = getCharSequence(this.readerIndex, paramInt, paramCharset);
    this.readerIndex += paramInt;
    return paramCharset;
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
    checkReadableBytes0(4);
    int i = _getInt(this.readerIndex);
    this.readerIndex += 4;
    return i;
  }
  
  public int readIntLE()
  {
    checkReadableBytes0(4);
    int i = _getIntLE(this.readerIndex);
    this.readerIndex += 4;
    return i;
  }
  
  public long readLong()
  {
    checkReadableBytes0(8);
    long l = _getLong(this.readerIndex);
    this.readerIndex += 8;
    return l;
  }
  
  public long readLongLE()
  {
    checkReadableBytes0(8);
    long l = _getLongLE(this.readerIndex);
    this.readerIndex += 8;
    return l;
  }
  
  public int readMedium()
  {
    int i = readUnsignedMedium();
    int j = i;
    if ((0x800000 & i) != 0) {
      j = i | 0xFF000000;
    }
    return j;
  }
  
  public int readMediumLE()
  {
    int i = readUnsignedMediumLE();
    int j = i;
    if ((0x800000 & i) != 0) {
      j = i | 0xFF000000;
    }
    return j;
  }
  
  public ByteBuf readRetainedSlice(int paramInt)
  {
    checkReadableBytes(paramInt);
    ByteBuf localByteBuf = retainedSlice(this.readerIndex, paramInt);
    this.readerIndex += paramInt;
    return localByteBuf;
  }
  
  public short readShort()
  {
    checkReadableBytes0(2);
    short s = _getShort(this.readerIndex);
    this.readerIndex += 2;
    return s;
  }
  
  public short readShortLE()
  {
    checkReadableBytes0(2);
    short s = _getShortLE(this.readerIndex);
    this.readerIndex += 2;
    return s;
  }
  
  public ByteBuf readSlice(int paramInt)
  {
    checkReadableBytes(paramInt);
    ByteBuf localByteBuf = slice(this.readerIndex, paramInt);
    this.readerIndex += paramInt;
    return localByteBuf;
  }
  
  public short readUnsignedByte()
  {
    return (short)(readByte() & 0xFF);
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
    checkReadableBytes0(3);
    int i = _getUnsignedMedium(this.readerIndex);
    this.readerIndex += 3;
    return i;
  }
  
  public int readUnsignedMediumLE()
  {
    checkReadableBytes0(3);
    int i = _getUnsignedMediumLE(this.readerIndex);
    this.readerIndex += 3;
    return i;
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
    return this.writerIndex - this.readerIndex;
  }
  
  public int readerIndex()
  {
    return this.readerIndex;
  }
  
  public ByteBuf readerIndex(int paramInt)
  {
    if (checkBounds) {
      checkIndexBounds(paramInt, this.writerIndex, capacity());
    }
    this.readerIndex = paramInt;
    return this;
  }
  
  public ByteBuf resetReaderIndex()
  {
    readerIndex(this.markedReaderIndex);
    return this;
  }
  
  public ByteBuf resetWriterIndex()
  {
    writerIndex(this.markedWriterIndex);
    return this;
  }
  
  public ByteBuf retainedDuplicate()
  {
    return duplicate().retain();
  }
  
  public ByteBuf retainedSlice()
  {
    return slice().retain();
  }
  
  public ByteBuf retainedSlice(int paramInt1, int paramInt2)
  {
    return slice(paramInt1, paramInt2).retain();
  }
  
  public ByteBuf setBoolean(int paramInt, boolean paramBoolean)
  {
    setByte(paramInt, paramBoolean);
    return this;
  }
  
  public ByteBuf setByte(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1);
    _setByte(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setBytes(int paramInt, ByteBuf paramByteBuf)
  {
    setBytes(paramInt, paramByteBuf, paramByteBuf.readableBytes());
    return this;
  }
  
  public ByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    ObjectUtil.checkNotNull(paramByteBuf, "src");
    if (checkBounds) {
      checkReadableBounds(paramByteBuf, paramInt2);
    }
    setBytes(paramInt1, paramByteBuf, paramByteBuf.readerIndex(), paramInt2);
    paramByteBuf.readerIndex(paramByteBuf.readerIndex() + paramInt2);
    return this;
  }
  
  public ByteBuf setBytes(int paramInt, byte[] paramArrayOfByte)
  {
    setBytes(paramInt, paramArrayOfByte, 0, paramArrayOfByte.length);
    return this;
  }
  
  public ByteBuf setChar(int paramInt1, int paramInt2)
  {
    setShort(paramInt1, paramInt2);
    return this;
  }
  
  public int setCharSequence(int paramInt, CharSequence paramCharSequence, Charset paramCharset)
  {
    return setCharSequence0(paramInt, paramCharSequence, paramCharset, false);
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
    if (checkBounds) {
      checkIndexBounds(paramInt1, paramInt2, capacity());
    }
    setIndex0(paramInt1, paramInt2);
    return this;
  }
  
  final void setIndex0(int paramInt1, int paramInt2)
  {
    this.readerIndex = paramInt1;
    this.writerIndex = paramInt2;
  }
  
  public ByteBuf setInt(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, 4);
    _setInt(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setIntLE(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, 4);
    _setIntLE(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setLong(int paramInt, long paramLong)
  {
    checkIndex(paramInt, 8);
    _setLong(paramInt, paramLong);
    return this;
  }
  
  public ByteBuf setLongLE(int paramInt, long paramLong)
  {
    checkIndex(paramInt, 8);
    _setLongLE(paramInt, paramLong);
    return this;
  }
  
  public ByteBuf setMedium(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, 3);
    _setMedium(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setMediumLE(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, 3);
    _setMediumLE(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setShort(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, 2);
    _setShort(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setShortLE(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, 2);
    _setShortLE(paramInt1, paramInt2);
    return this;
  }
  
  public ByteBuf setZero(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return this;
    }
    checkIndex(paramInt1, paramInt2);
    int i = paramInt2 >>> 3;
    int j = paramInt2 & 0x7;
    for (paramInt2 = i; paramInt2 > 0; paramInt2--)
    {
      _setLong(paramInt1, 0L);
      paramInt1 += 8;
    }
    if (j == 4)
    {
      _setInt(paramInt1, 0);
    }
    else
    {
      if (j < 4) {
        for (paramInt2 = j; paramInt2 > 0; paramInt2--)
        {
          _setByte(paramInt1, 0);
          paramInt1++;
        }
      }
      _setInt(paramInt1, 0);
      paramInt2 = paramInt1 + 4;
      for (paramInt1 = j - 4; paramInt1 > 0; paramInt1--)
      {
        _setByte(paramInt2, 0);
        paramInt2++;
      }
    }
    return this;
  }
  
  public ByteBuf skipBytes(int paramInt)
  {
    checkReadableBytes(paramInt);
    this.readerIndex += paramInt;
    return this;
  }
  
  public ByteBuf slice()
  {
    return slice(this.readerIndex, readableBytes());
  }
  
  public ByteBuf slice(int paramInt1, int paramInt2)
  {
    ensureAccessible();
    return new UnpooledSlicedByteBuf(this, paramInt1, paramInt2);
  }
  
  public String toString()
  {
    if (refCnt() == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(StringUtil.simpleClassName(this));
      localStringBuilder.append("(freed)");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append("(ridx: ");
    localStringBuilder.append(this.readerIndex);
    localStringBuilder.append(", widx: ");
    localStringBuilder.append(this.writerIndex);
    localStringBuilder.append(", cap: ");
    localStringBuilder.append(capacity());
    if (this.maxCapacity != Integer.MAX_VALUE)
    {
      localStringBuilder.append('/');
      localStringBuilder.append(this.maxCapacity);
    }
    ByteBuf localByteBuf = unwrap();
    if (localByteBuf != null)
    {
      localStringBuilder.append(", unwrapped: ");
      localStringBuilder.append(localByteBuf);
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public String toString(int paramInt1, int paramInt2, Charset paramCharset)
  {
    return ByteBufUtil.decodeString(this, paramInt1, paramInt2, paramCharset);
  }
  
  public String toString(Charset paramCharset)
  {
    return toString(this.readerIndex, readableBytes(), paramCharset);
  }
  
  protected final void trimIndicesToCapacity(int paramInt)
  {
    if (writerIndex() > paramInt) {
      setIndex0(Math.min(readerIndex(), paramInt), paramInt);
    }
  }
  
  public int writableBytes()
  {
    return capacity() - this.writerIndex;
  }
  
  public ByteBuf writeBoolean(boolean paramBoolean)
  {
    writeByte(paramBoolean);
    return this;
  }
  
  public ByteBuf writeByte(int paramInt)
  {
    ensureWritable0(1);
    int i = this.writerIndex;
    this.writerIndex = (i + 1);
    _setByte(i, paramInt);
    return this;
  }
  
  public int writeBytes(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    ensureWritable(paramInt);
    paramInt = setBytes(this.writerIndex, paramInputStream, paramInt);
    if (paramInt > 0) {
      this.writerIndex += paramInt;
    }
    return paramInt;
  }
  
  public int writeBytes(FileChannel paramFileChannel, long paramLong, int paramInt)
    throws IOException
  {
    ensureWritable(paramInt);
    paramInt = setBytes(this.writerIndex, paramFileChannel, paramLong, paramInt);
    if (paramInt > 0) {
      this.writerIndex += paramInt;
    }
    return paramInt;
  }
  
  public int writeBytes(ScatteringByteChannel paramScatteringByteChannel, int paramInt)
    throws IOException
  {
    ensureWritable(paramInt);
    paramInt = setBytes(this.writerIndex, paramScatteringByteChannel, paramInt);
    if (paramInt > 0) {
      this.writerIndex += paramInt;
    }
    return paramInt;
  }
  
  public ByteBuf writeBytes(ByteBuf paramByteBuf)
  {
    writeBytes(paramByteBuf, paramByteBuf.readableBytes());
    return this;
  }
  
  public ByteBuf writeBytes(ByteBuf paramByteBuf, int paramInt)
  {
    if (checkBounds) {
      checkReadableBounds(paramByteBuf, paramInt);
    }
    writeBytes(paramByteBuf, paramByteBuf.readerIndex(), paramInt);
    paramByteBuf.readerIndex(paramByteBuf.readerIndex() + paramInt);
    return this;
  }
  
  public ByteBuf writeBytes(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    ensureWritable(paramInt2);
    setBytes(this.writerIndex, paramByteBuf, paramInt1, paramInt2);
    this.writerIndex += paramInt2;
    return this;
  }
  
  public ByteBuf writeBytes(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.remaining();
    ensureWritable0(i);
    setBytes(this.writerIndex, paramByteBuffer);
    this.writerIndex += i;
    return this;
  }
  
  public ByteBuf writeBytes(byte[] paramArrayOfByte)
  {
    writeBytes(paramArrayOfByte, 0, paramArrayOfByte.length);
    return this;
  }
  
  public ByteBuf writeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ensureWritable(paramInt2);
    setBytes(this.writerIndex, paramArrayOfByte, paramInt1, paramInt2);
    this.writerIndex += paramInt2;
    return this;
  }
  
  public ByteBuf writeChar(int paramInt)
  {
    writeShort(paramInt);
    return this;
  }
  
  public int writeCharSequence(CharSequence paramCharSequence, Charset paramCharset)
  {
    int i = setCharSequence0(this.writerIndex, paramCharSequence, paramCharset, true);
    this.writerIndex += i;
    return i;
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
    ensureWritable0(4);
    _setInt(this.writerIndex, paramInt);
    this.writerIndex += 4;
    return this;
  }
  
  public ByteBuf writeIntLE(int paramInt)
  {
    ensureWritable0(4);
    _setIntLE(this.writerIndex, paramInt);
    this.writerIndex += 4;
    return this;
  }
  
  public ByteBuf writeLong(long paramLong)
  {
    ensureWritable0(8);
    _setLong(this.writerIndex, paramLong);
    this.writerIndex += 8;
    return this;
  }
  
  public ByteBuf writeLongLE(long paramLong)
  {
    ensureWritable0(8);
    _setLongLE(this.writerIndex, paramLong);
    this.writerIndex += 8;
    return this;
  }
  
  public ByteBuf writeMedium(int paramInt)
  {
    ensureWritable0(3);
    _setMedium(this.writerIndex, paramInt);
    this.writerIndex += 3;
    return this;
  }
  
  public ByteBuf writeMediumLE(int paramInt)
  {
    ensureWritable0(3);
    _setMediumLE(this.writerIndex, paramInt);
    this.writerIndex += 3;
    return this;
  }
  
  public ByteBuf writeShort(int paramInt)
  {
    ensureWritable0(2);
    _setShort(this.writerIndex, paramInt);
    this.writerIndex += 2;
    return this;
  }
  
  public ByteBuf writeShortLE(int paramInt)
  {
    ensureWritable0(2);
    _setShortLE(this.writerIndex, paramInt);
    this.writerIndex += 2;
    return this;
  }
  
  public ByteBuf writeZero(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    ensureWritable(paramInt);
    int i = this.writerIndex;
    checkIndex0(i, paramInt);
    int j = paramInt >>> 3;
    int k = paramInt & 0x7;
    paramInt = i;
    while (j > 0)
    {
      _setLong(paramInt, 0L);
      paramInt += 8;
      j--;
    }
    if (k == 4)
    {
      _setInt(paramInt, 0);
      paramInt += 4;
    }
    else
    {
      if (k < 4)
      {
        j = paramInt;
        for (;;)
        {
          paramInt = j;
          if (k <= 0) {
            break;
          }
          _setByte(j, 0);
          j++;
          k--;
        }
      }
      _setInt(paramInt, 0);
      j = paramInt + 4;
      k -= 4;
      for (;;)
      {
        paramInt = j;
        if (k <= 0) {
          break;
        }
        _setByte(j, 0);
        j++;
        k--;
      }
    }
    this.writerIndex = paramInt;
    return this;
  }
  
  public int writerIndex()
  {
    return this.writerIndex;
  }
  
  public ByteBuf writerIndex(int paramInt)
  {
    if (checkBounds) {
      checkIndexBounds(this.readerIndex, paramInt, capacity());
    }
    this.writerIndex = paramInt;
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\AbstractByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */