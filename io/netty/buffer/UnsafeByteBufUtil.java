package io.netty.buffer;

import io.netty.util.ReferenceCounted;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;

final class UnsafeByteBufUtil
{
  private static final boolean UNALIGNED = ;
  private static final byte ZERO = 0;
  
  static ByteBuf copy(AbstractByteBuf paramAbstractByteBuf, long paramLong, int paramInt1, int paramInt2)
  {
    paramAbstractByteBuf.checkIndex(paramInt1, paramInt2);
    ByteBuf localByteBuf = paramAbstractByteBuf.alloc().directBuffer(paramInt2, paramAbstractByteBuf.maxCapacity());
    if (paramInt2 != 0) {
      if (localByteBuf.hasMemoryAddress())
      {
        PlatformDependent.copyMemory(paramLong, localByteBuf.memoryAddress(), paramInt2);
        localByteBuf.setIndex(0, paramInt2);
      }
      else
      {
        localByteBuf.writeBytes(paramAbstractByteBuf, paramInt1, paramInt2);
      }
    }
    return localByteBuf;
  }
  
  static byte getByte(long paramLong)
  {
    return PlatformDependent.getByte(paramLong);
  }
  
  static byte getByte(byte[] paramArrayOfByte, int paramInt)
  {
    return PlatformDependent.getByte(paramArrayOfByte, paramInt);
  }
  
  private static void getBytes(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, OutputStream paramOutputStream, int paramInt3)
    throws IOException
  {
    int i;
    do
    {
      i = Math.min(paramInt2, paramInt3);
      long l = i;
      PlatformDependent.copyMemory(paramLong, paramArrayOfByte, paramInt1, l);
      paramOutputStream.write(paramArrayOfByte, paramInt1, i);
      i = paramInt3 - i;
      paramLong += l;
      paramInt3 = i;
    } while (i > 0);
  }
  
  static void getBytes(AbstractByteBuf paramAbstractByteBuf, long paramLong, int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    paramAbstractByteBuf.checkIndex(paramInt1, paramInt3);
    ObjectUtil.checkNotNull(paramByteBuf, "dst");
    if (!MathUtil.isOutOfBounds(paramInt2, paramInt3, paramByteBuf.capacity()))
    {
      if (paramByteBuf.hasMemoryAddress()) {
        PlatformDependent.copyMemory(paramLong, paramByteBuf.memoryAddress() + paramInt2, paramInt3);
      } else if (paramByteBuf.hasArray()) {
        PlatformDependent.copyMemory(paramLong, paramByteBuf.array(), paramByteBuf.arrayOffset() + paramInt2, paramInt3);
      } else {
        paramByteBuf.setBytes(paramInt2, paramAbstractByteBuf, paramInt1, paramInt3);
      }
      return;
    }
    paramAbstractByteBuf = new StringBuilder();
    paramAbstractByteBuf.append("dstIndex: ");
    paramAbstractByteBuf.append(paramInt2);
    throw new IndexOutOfBoundsException(paramAbstractByteBuf.toString());
  }
  
  static void getBytes(AbstractByteBuf paramAbstractByteBuf, long paramLong, int paramInt1, OutputStream paramOutputStream, int paramInt2)
    throws IOException
  {
    paramAbstractByteBuf.checkIndex(paramInt1, paramInt2);
    if (paramInt2 != 0)
    {
      paramInt1 = Math.min(paramInt2, 8192);
      if ((paramInt1 > 1024) && (paramAbstractByteBuf.alloc().isDirectBufferPooled())) {
        paramAbstractByteBuf = paramAbstractByteBuf.alloc().heapBuffer(paramInt1);
      }
      try
      {
        getBytes(paramLong, paramAbstractByteBuf.array(), paramAbstractByteBuf.arrayOffset(), paramInt1, paramOutputStream, paramInt2);
        paramAbstractByteBuf.release();
      }
      finally
      {
        paramAbstractByteBuf.release();
      }
    }
  }
  
  static void getBytes(AbstractByteBuf paramAbstractByteBuf, long paramLong, int paramInt, ByteBuffer paramByteBuffer)
  {
    paramAbstractByteBuf.checkIndex(paramInt, paramByteBuffer.remaining());
    if (paramByteBuffer.remaining() == 0) {
      return;
    }
    if (paramByteBuffer.isDirect())
    {
      if (!paramByteBuffer.isReadOnly())
      {
        PlatformDependent.copyMemory(paramLong, PlatformDependent.directBufferAddress(paramByteBuffer) + paramByteBuffer.position(), paramByteBuffer.remaining());
        paramByteBuffer.position(paramByteBuffer.position() + paramByteBuffer.remaining());
      }
      else
      {
        throw new ReadOnlyBufferException();
      }
    }
    else if (paramByteBuffer.hasArray())
    {
      PlatformDependent.copyMemory(paramLong, paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining());
      paramByteBuffer.position(paramByteBuffer.position() + paramByteBuffer.remaining());
    }
    else
    {
      paramByteBuffer.put(paramAbstractByteBuf.nioBuffer());
    }
  }
  
  static void getBytes(AbstractByteBuf paramAbstractByteBuf, long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    paramAbstractByteBuf.checkIndex(paramInt1, paramInt3);
    ObjectUtil.checkNotNull(paramArrayOfByte, "dst");
    if (!MathUtil.isOutOfBounds(paramInt2, paramInt3, paramArrayOfByte.length))
    {
      if (paramInt3 != 0) {
        PlatformDependent.copyMemory(paramLong, paramArrayOfByte, paramInt2, paramInt3);
      }
      return;
    }
    paramAbstractByteBuf = new StringBuilder();
    paramAbstractByteBuf.append("dstIndex: ");
    paramAbstractByteBuf.append(paramInt2);
    throw new IndexOutOfBoundsException(paramAbstractByteBuf.toString());
  }
  
  static int getInt(long paramLong)
  {
    if (UNALIGNED)
    {
      i = PlatformDependent.getInt(paramLong);
      if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
        i = Integer.reverseBytes(i);
      }
      return i;
    }
    int j = PlatformDependent.getByte(paramLong);
    int k = PlatformDependent.getByte(1L + paramLong);
    int i = PlatformDependent.getByte(2L + paramLong);
    return PlatformDependent.getByte(paramLong + 3L) & 0xFF | j << 24 | (k & 0xFF) << 16 | (i & 0xFF) << 8;
  }
  
  static int getInt(byte[] paramArrayOfByte, int paramInt)
  {
    if (UNALIGNED)
    {
      paramInt = PlatformDependent.getInt(paramArrayOfByte, paramInt);
      if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
        paramInt = Integer.reverseBytes(paramInt);
      }
      return paramInt;
    }
    int i = PlatformDependent.getByte(paramArrayOfByte, paramInt);
    int j = PlatformDependent.getByte(paramArrayOfByte, paramInt + 1);
    int k = PlatformDependent.getByte(paramArrayOfByte, paramInt + 2);
    return PlatformDependent.getByte(paramArrayOfByte, paramInt + 3) & 0xFF | i << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  static int getIntLE(long paramLong)
  {
    if (UNALIGNED)
    {
      i = PlatformDependent.getInt(paramLong);
      j = i;
      if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
        j = Integer.reverseBytes(i);
      }
      return j;
    }
    int j = PlatformDependent.getByte(paramLong);
    int i = PlatformDependent.getByte(1L + paramLong);
    int k = PlatformDependent.getByte(2L + paramLong);
    return PlatformDependent.getByte(paramLong + 3L) << 24 | j & 0xFF | (i & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  static int getIntLE(byte[] paramArrayOfByte, int paramInt)
  {
    if (UNALIGNED)
    {
      i = PlatformDependent.getInt(paramArrayOfByte, paramInt);
      paramInt = i;
      if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
        paramInt = Integer.reverseBytes(i);
      }
      return paramInt;
    }
    int j = PlatformDependent.getByte(paramArrayOfByte, paramInt);
    int k = PlatformDependent.getByte(paramArrayOfByte, paramInt + 1);
    int i = PlatformDependent.getByte(paramArrayOfByte, paramInt + 2);
    return PlatformDependent.getByte(paramArrayOfByte, paramInt + 3) << 24 | j & 0xFF | (k & 0xFF) << 8 | (i & 0xFF) << 16;
  }
  
  static long getLong(long paramLong)
  {
    if (UNALIGNED)
    {
      paramLong = PlatformDependent.getLong(paramLong);
      if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
        paramLong = Long.reverseBytes(paramLong);
      }
      return paramLong;
    }
    long l1 = PlatformDependent.getByte(paramLong);
    long l2 = PlatformDependent.getByte(1L + paramLong);
    long l3 = PlatformDependent.getByte(2L + paramLong);
    long l4 = PlatformDependent.getByte(3L + paramLong);
    long l5 = PlatformDependent.getByte(4L + paramLong);
    long l6 = PlatformDependent.getByte(5L + paramLong);
    long l7 = PlatformDependent.getByte(6L + paramLong);
    return PlatformDependent.getByte(paramLong + 7L) & 0xFF | l1 << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8;
  }
  
  static long getLong(byte[] paramArrayOfByte, int paramInt)
  {
    if (UNALIGNED)
    {
      l1 = PlatformDependent.getLong(paramArrayOfByte, paramInt);
      if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
        l1 = Long.reverseBytes(l1);
      }
      return l1;
    }
    long l1 = PlatformDependent.getByte(paramArrayOfByte, paramInt);
    long l2 = PlatformDependent.getByte(paramArrayOfByte, paramInt + 1);
    long l3 = PlatformDependent.getByte(paramArrayOfByte, paramInt + 2);
    long l4 = PlatformDependent.getByte(paramArrayOfByte, paramInt + 3);
    long l5 = PlatformDependent.getByte(paramArrayOfByte, paramInt + 4);
    long l6 = PlatformDependent.getByte(paramArrayOfByte, paramInt + 5);
    long l7 = PlatformDependent.getByte(paramArrayOfByte, paramInt + 6);
    return PlatformDependent.getByte(paramArrayOfByte, paramInt + 7) & 0xFF | l1 << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8;
  }
  
  static long getLongLE(long paramLong)
  {
    if (UNALIGNED)
    {
      l1 = PlatformDependent.getLong(paramLong);
      paramLong = l1;
      if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
        paramLong = Long.reverseBytes(l1);
      }
      return paramLong;
    }
    long l1 = PlatformDependent.getByte(paramLong);
    long l2 = PlatformDependent.getByte(1L + paramLong);
    long l3 = PlatformDependent.getByte(2L + paramLong);
    long l4 = PlatformDependent.getByte(3L + paramLong);
    long l5 = PlatformDependent.getByte(4L + paramLong);
    long l6 = PlatformDependent.getByte(5L + paramLong);
    long l7 = PlatformDependent.getByte(6L + paramLong);
    return PlatformDependent.getByte(paramLong + 7L) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (0xFF & l7) << 48;
  }
  
  static long getLongLE(byte[] paramArrayOfByte, int paramInt)
  {
    if (UNALIGNED)
    {
      l1 = PlatformDependent.getLong(paramArrayOfByte, paramInt);
      l2 = l1;
      if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
        l2 = Long.reverseBytes(l1);
      }
      return l2;
    }
    long l3 = PlatformDependent.getByte(paramArrayOfByte, paramInt);
    long l4 = PlatformDependent.getByte(paramArrayOfByte, paramInt + 1);
    long l5 = PlatformDependent.getByte(paramArrayOfByte, paramInt + 2);
    long l1 = PlatformDependent.getByte(paramArrayOfByte, paramInt + 3);
    long l2 = PlatformDependent.getByte(paramArrayOfByte, paramInt + 4);
    long l6 = PlatformDependent.getByte(paramArrayOfByte, paramInt + 5);
    long l7 = PlatformDependent.getByte(paramArrayOfByte, paramInt + 6);
    return PlatformDependent.getByte(paramArrayOfByte, paramInt + 7) << 56 | l3 & 0xFF | (l4 & 0xFF) << 8 | (l5 & 0xFF) << 16 | (l1 & 0xFF) << 24 | (l2 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (0xFF & l7) << 48;
  }
  
  static short getShort(long paramLong)
  {
    if (UNALIGNED)
    {
      short s1 = PlatformDependent.getShort(paramLong);
      if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER)
      {
        s2 = Short.reverseBytes(s1);
        s1 = s2;
      }
      return s1;
    }
    short s2 = PlatformDependent.getByte(paramLong);
    return (short)(PlatformDependent.getByte(paramLong + 1L) & 0xFF | s2 << 8);
  }
  
  static short getShort(byte[] paramArrayOfByte, int paramInt)
  {
    if (UNALIGNED)
    {
      short s = PlatformDependent.getShort(paramArrayOfByte, paramInt);
      int i;
      if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER)
      {
        paramInt = Short.reverseBytes(s);
        i = paramInt;
      }
      return i;
    }
    int j = PlatformDependent.getByte(paramArrayOfByte, paramInt);
    return (short)(PlatformDependent.getByte(paramArrayOfByte, paramInt + 1) & 0xFF | j << 8);
  }
  
  static short getShortLE(long paramLong)
  {
    if (UNALIGNED)
    {
      short s1 = PlatformDependent.getShort(paramLong);
      short s2 = s1;
      if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER)
      {
        s3 = Short.reverseBytes(s1);
        s2 = s3;
      }
      return s2;
    }
    short s3 = PlatformDependent.getByte(paramLong);
    return (short)(PlatformDependent.getByte(paramLong + 1L) << 8 | s3 & 0xFF);
  }
  
  static short getShortLE(byte[] paramArrayOfByte, int paramInt)
  {
    if (UNALIGNED)
    {
      short s1 = PlatformDependent.getShort(paramArrayOfByte, paramInt);
      short s2 = s1;
      int i;
      if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER)
      {
        paramInt = Short.reverseBytes(s1);
        i = paramInt;
      }
      return i;
    }
    int j = PlatformDependent.getByte(paramArrayOfByte, paramInt);
    return (short)(PlatformDependent.getByte(paramArrayOfByte, paramInt + 1) << 8 | j & 0xFF);
  }
  
  static int getUnsignedMedium(long paramLong)
  {
    int j;
    int k;
    if (UNALIGNED)
    {
      int i = (PlatformDependent.getByte(paramLong) & 0xFF) << 16;
      if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
        j = PlatformDependent.getShort(paramLong + 1L);
      } else {
        j = Short.reverseBytes(PlatformDependent.getShort(paramLong + 1L));
      }
      k = j & 0xFFFF;
      j = i;
    }
    for (;;)
    {
      return k | j;
      j = (PlatformDependent.getByte(paramLong) & 0xFF) << 16 | (PlatformDependent.getByte(1L + paramLong) & 0xFF) << 8;
      k = PlatformDependent.getByte(paramLong + 2L) & 0xFF;
    }
  }
  
  static int getUnsignedMedium(byte[] paramArrayOfByte, int paramInt)
  {
    int i;
    int j;
    if (UNALIGNED)
    {
      i = (PlatformDependent.getByte(paramArrayOfByte, paramInt) & 0xFF) << 16;
      if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
        paramInt = PlatformDependent.getShort(paramArrayOfByte, paramInt + 1);
      } else {
        paramInt = Short.reverseBytes(PlatformDependent.getShort(paramArrayOfByte, paramInt + 1));
      }
      j = paramInt & 0xFFFF;
      paramInt = i;
    }
    for (;;)
    {
      return j | paramInt;
      j = (PlatformDependent.getByte(paramArrayOfByte, paramInt) & 0xFF) << 16 | (PlatformDependent.getByte(paramArrayOfByte, paramInt + 1) & 0xFF) << 8;
      i = PlatformDependent.getByte(paramArrayOfByte, paramInt + 2) & 0xFF;
      paramInt = j;
      j = i;
    }
  }
  
  static int getUnsignedMediumLE(long paramLong)
  {
    int i;
    if (UNALIGNED)
    {
      i = PlatformDependent.getByte(paramLong) & 0xFF;
      if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
        j = Short.reverseBytes(PlatformDependent.getShort(paramLong + 1L));
      } else {
        j = PlatformDependent.getShort(paramLong + 1L);
      }
    }
    for (int j = (j & 0xFFFF) << 8;; j = (PlatformDependent.getByte(paramLong + 2L) & 0xFF) << 16)
    {
      return j | i;
      i = PlatformDependent.getByte(paramLong) & 0xFF | (PlatformDependent.getByte(1L + paramLong) & 0xFF) << 8;
    }
  }
  
  static int getUnsignedMediumLE(byte[] paramArrayOfByte, int paramInt)
  {
    int i;
    int j;
    if (UNALIGNED)
    {
      i = PlatformDependent.getByte(paramArrayOfByte, paramInt) & 0xFF;
      if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
        paramInt = Short.reverseBytes(PlatformDependent.getShort(paramArrayOfByte, paramInt + 1));
      } else {
        paramInt = PlatformDependent.getShort(paramArrayOfByte, paramInt + 1);
      }
      j = (paramInt & 0xFFFF) << 8;
      paramInt = i;
    }
    for (;;)
    {
      return j | paramInt;
      j = PlatformDependent.getByte(paramArrayOfByte, paramInt) & 0xFF | (PlatformDependent.getByte(paramArrayOfByte, paramInt + 1) & 0xFF) << 8;
      i = (PlatformDependent.getByte(paramArrayOfByte, paramInt + 2) & 0xFF) << 16;
      paramInt = j;
      j = i;
    }
  }
  
  static UnpooledUnsafeDirectByteBuf newUnsafeDirectByteBuf(ByteBufAllocator paramByteBufAllocator, int paramInt1, int paramInt2)
  {
    if (PlatformDependent.useDirectBufferNoCleaner()) {
      return new UnpooledUnsafeNoCleanerDirectByteBuf(paramByteBufAllocator, paramInt1, paramInt2);
    }
    return new UnpooledUnsafeDirectByteBuf(paramByteBufAllocator, paramInt1, paramInt2);
  }
  
  static void setByte(long paramLong, int paramInt)
  {
    PlatformDependent.putByte(paramLong, (byte)paramInt);
  }
  
  static void setByte(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    PlatformDependent.putByte(paramArrayOfByte, paramInt1, (byte)paramInt2);
  }
  
  static int setBytes(AbstractByteBuf paramAbstractByteBuf, long paramLong, int paramInt1, InputStream paramInputStream, int paramInt2)
    throws IOException
  {
    paramAbstractByteBuf.checkIndex(paramInt1, paramInt2);
    paramAbstractByteBuf = paramAbstractByteBuf.alloc().heapBuffer(paramInt2);
    try
    {
      byte[] arrayOfByte = paramAbstractByteBuf.array();
      paramInt1 = paramAbstractByteBuf.arrayOffset();
      paramInt2 = paramInputStream.read(arrayOfByte, paramInt1, paramInt2);
      if (paramInt2 > 0) {
        PlatformDependent.copyMemory(arrayOfByte, paramInt1, paramLong, paramInt2);
      }
      return paramInt2;
    }
    finally
    {
      paramAbstractByteBuf.release();
    }
  }
  
  static void setBytes(AbstractByteBuf paramAbstractByteBuf, long paramLong, int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    paramAbstractByteBuf.checkIndex(paramInt1, paramInt3);
    ObjectUtil.checkNotNull(paramByteBuf, "src");
    if (!MathUtil.isOutOfBounds(paramInt2, paramInt3, paramByteBuf.capacity()))
    {
      if (paramInt3 != 0) {
        if (paramByteBuf.hasMemoryAddress()) {
          PlatformDependent.copyMemory(paramByteBuf.memoryAddress() + paramInt2, paramLong, paramInt3);
        } else if (paramByteBuf.hasArray()) {
          PlatformDependent.copyMemory(paramByteBuf.array(), paramByteBuf.arrayOffset() + paramInt2, paramLong, paramInt3);
        } else {
          paramByteBuf.getBytes(paramInt2, paramAbstractByteBuf, paramInt1, paramInt3);
        }
      }
      return;
    }
    paramAbstractByteBuf = new StringBuilder();
    paramAbstractByteBuf.append("srcIndex: ");
    paramAbstractByteBuf.append(paramInt2);
    throw new IndexOutOfBoundsException(paramAbstractByteBuf.toString());
  }
  
  static void setBytes(AbstractByteBuf paramAbstractByteBuf, long paramLong, int paramInt, ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.remaining();
    if (i == 0) {
      return;
    }
    if (paramByteBuffer.isDirect())
    {
      paramAbstractByteBuf.checkIndex(paramInt, i);
      PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(paramByteBuffer) + paramByteBuffer.position(), paramLong, i);
      paramByteBuffer.position(paramByteBuffer.position() + i);
    }
    else if (paramByteBuffer.hasArray())
    {
      paramAbstractByteBuf.checkIndex(paramInt, i);
      PlatformDependent.copyMemory(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramLong, i);
      paramByteBuffer.position(paramByteBuffer.position() + i);
    }
    else if (i < 8)
    {
      setSingleBytes(paramAbstractByteBuf, paramLong, paramInt, paramByteBuffer, i);
    }
    else
    {
      paramAbstractByteBuf.internalNioBuffer(paramInt, i).put(paramByteBuffer);
    }
  }
  
  static void setBytes(AbstractByteBuf paramAbstractByteBuf, long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    paramAbstractByteBuf.checkIndex(paramInt1, paramInt3);
    if (paramInt3 != 0) {
      PlatformDependent.copyMemory(paramArrayOfByte, paramInt2, paramLong, paramInt3);
    }
  }
  
  static void setInt(long paramLong, int paramInt)
  {
    if (UNALIGNED)
    {
      if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
        paramInt = Integer.reverseBytes(paramInt);
      }
      PlatformDependent.putInt(paramLong, paramInt);
    }
    else
    {
      PlatformDependent.putByte(paramLong, (byte)(paramInt >>> 24));
      PlatformDependent.putByte(1L + paramLong, (byte)(paramInt >>> 16));
      PlatformDependent.putByte(2L + paramLong, (byte)(paramInt >>> 8));
      PlatformDependent.putByte(paramLong + 3L, (byte)paramInt);
    }
  }
  
  static void setInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (UNALIGNED)
    {
      if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
        paramInt2 = Integer.reverseBytes(paramInt2);
      }
      PlatformDependent.putInt(paramArrayOfByte, paramInt1, paramInt2);
    }
    else
    {
      PlatformDependent.putByte(paramArrayOfByte, paramInt1, (byte)(paramInt2 >>> 24));
      PlatformDependent.putByte(paramArrayOfByte, paramInt1 + 1, (byte)(paramInt2 >>> 16));
      PlatformDependent.putByte(paramArrayOfByte, paramInt1 + 2, (byte)(paramInt2 >>> 8));
      PlatformDependent.putByte(paramArrayOfByte, paramInt1 + 3, (byte)paramInt2);
    }
  }
  
  static void setIntLE(long paramLong, int paramInt)
  {
    if (UNALIGNED)
    {
      int i = paramInt;
      if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
        i = Integer.reverseBytes(paramInt);
      }
      PlatformDependent.putInt(paramLong, i);
    }
    else
    {
      PlatformDependent.putByte(paramLong, (byte)paramInt);
      PlatformDependent.putByte(1L + paramLong, (byte)(paramInt >>> 8));
      PlatformDependent.putByte(2L + paramLong, (byte)(paramInt >>> 16));
      PlatformDependent.putByte(paramLong + 3L, (byte)(paramInt >>> 24));
    }
  }
  
  static void setIntLE(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (UNALIGNED)
    {
      int i = paramInt2;
      if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
        i = Integer.reverseBytes(paramInt2);
      }
      PlatformDependent.putInt(paramArrayOfByte, paramInt1, i);
    }
    else
    {
      PlatformDependent.putByte(paramArrayOfByte, paramInt1, (byte)paramInt2);
      PlatformDependent.putByte(paramArrayOfByte, paramInt1 + 1, (byte)(paramInt2 >>> 8));
      PlatformDependent.putByte(paramArrayOfByte, paramInt1 + 2, (byte)(paramInt2 >>> 16));
      PlatformDependent.putByte(paramArrayOfByte, paramInt1 + 3, (byte)(paramInt2 >>> 24));
    }
  }
  
  static void setLong(long paramLong1, long paramLong2)
  {
    if (UNALIGNED)
    {
      if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
        paramLong2 = Long.reverseBytes(paramLong2);
      }
      PlatformDependent.putLong(paramLong1, paramLong2);
    }
    else
    {
      PlatformDependent.putByte(paramLong1, (byte)(int)(paramLong2 >>> 56));
      PlatformDependent.putByte(1L + paramLong1, (byte)(int)(paramLong2 >>> 48));
      PlatformDependent.putByte(2L + paramLong1, (byte)(int)(paramLong2 >>> 40));
      PlatformDependent.putByte(3L + paramLong1, (byte)(int)(paramLong2 >>> 32));
      PlatformDependent.putByte(4L + paramLong1, (byte)(int)(paramLong2 >>> 24));
      PlatformDependent.putByte(5L + paramLong1, (byte)(int)(paramLong2 >>> 16));
      PlatformDependent.putByte(6L + paramLong1, (byte)(int)(paramLong2 >>> 8));
      PlatformDependent.putByte(paramLong1 + 7L, (byte)(int)paramLong2);
    }
  }
  
  static void setLong(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    if (UNALIGNED)
    {
      if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
        paramLong = Long.reverseBytes(paramLong);
      }
      PlatformDependent.putLong(paramArrayOfByte, paramInt, paramLong);
    }
    else
    {
      PlatformDependent.putByte(paramArrayOfByte, paramInt, (byte)(int)(paramLong >>> 56));
      PlatformDependent.putByte(paramArrayOfByte, paramInt + 1, (byte)(int)(paramLong >>> 48));
      PlatformDependent.putByte(paramArrayOfByte, paramInt + 2, (byte)(int)(paramLong >>> 40));
      PlatformDependent.putByte(paramArrayOfByte, paramInt + 3, (byte)(int)(paramLong >>> 32));
      PlatformDependent.putByte(paramArrayOfByte, paramInt + 4, (byte)(int)(paramLong >>> 24));
      PlatformDependent.putByte(paramArrayOfByte, paramInt + 5, (byte)(int)(paramLong >>> 16));
      PlatformDependent.putByte(paramArrayOfByte, paramInt + 6, (byte)(int)(paramLong >>> 8));
      PlatformDependent.putByte(paramArrayOfByte, paramInt + 7, (byte)(int)paramLong);
    }
  }
  
  static void setLongLE(long paramLong1, long paramLong2)
  {
    if (UNALIGNED)
    {
      long l = paramLong2;
      if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
        l = Long.reverseBytes(paramLong2);
      }
      PlatformDependent.putLong(paramLong1, l);
    }
    else
    {
      PlatformDependent.putByte(paramLong1, (byte)(int)paramLong2);
      PlatformDependent.putByte(1L + paramLong1, (byte)(int)(paramLong2 >>> 8));
      PlatformDependent.putByte(2L + paramLong1, (byte)(int)(paramLong2 >>> 16));
      PlatformDependent.putByte(3L + paramLong1, (byte)(int)(paramLong2 >>> 24));
      PlatformDependent.putByte(4L + paramLong1, (byte)(int)(paramLong2 >>> 32));
      PlatformDependent.putByte(5L + paramLong1, (byte)(int)(paramLong2 >>> 40));
      PlatformDependent.putByte(6L + paramLong1, (byte)(int)(paramLong2 >>> 48));
      PlatformDependent.putByte(paramLong1 + 7L, (byte)(int)(paramLong2 >>> 56));
    }
  }
  
  static void setLongLE(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    if (UNALIGNED)
    {
      long l = paramLong;
      if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
        l = Long.reverseBytes(paramLong);
      }
      PlatformDependent.putLong(paramArrayOfByte, paramInt, l);
    }
    else
    {
      PlatformDependent.putByte(paramArrayOfByte, paramInt, (byte)(int)paramLong);
      PlatformDependent.putByte(paramArrayOfByte, paramInt + 1, (byte)(int)(paramLong >>> 8));
      PlatformDependent.putByte(paramArrayOfByte, paramInt + 2, (byte)(int)(paramLong >>> 16));
      PlatformDependent.putByte(paramArrayOfByte, paramInt + 3, (byte)(int)(paramLong >>> 24));
      PlatformDependent.putByte(paramArrayOfByte, paramInt + 4, (byte)(int)(paramLong >>> 32));
      PlatformDependent.putByte(paramArrayOfByte, paramInt + 5, (byte)(int)(paramLong >>> 40));
      PlatformDependent.putByte(paramArrayOfByte, paramInt + 6, (byte)(int)(paramLong >>> 48));
      PlatformDependent.putByte(paramArrayOfByte, paramInt + 7, (byte)(int)(paramLong >>> 56));
    }
  }
  
  static void setMedium(long paramLong, int paramInt)
  {
    PlatformDependent.putByte(paramLong, (byte)(paramInt >>> 16));
    if (UNALIGNED)
    {
      boolean bool = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER;
      short s = (short)paramInt;
      int i;
      if (!bool)
      {
        paramInt = Short.reverseBytes(s);
        i = paramInt;
      }
      PlatformDependent.putShort(paramLong + 1L, i);
    }
    else
    {
      PlatformDependent.putByte(1L + paramLong, (byte)(paramInt >>> 8));
      PlatformDependent.putByte(paramLong + 2L, (byte)paramInt);
    }
  }
  
  static void setMedium(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    PlatformDependent.putByte(paramArrayOfByte, paramInt1, (byte)(paramInt2 >>> 16));
    if (UNALIGNED)
    {
      boolean bool = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER;
      short s = (short)paramInt2;
      int i;
      if (!bool)
      {
        paramInt2 = Short.reverseBytes(s);
        i = paramInt2;
      }
      PlatformDependent.putShort(paramArrayOfByte, paramInt1 + 1, i);
    }
    else
    {
      PlatformDependent.putByte(paramArrayOfByte, paramInt1 + 1, (byte)(paramInt2 >>> 8));
      PlatformDependent.putByte(paramArrayOfByte, paramInt1 + 2, (byte)paramInt2);
    }
  }
  
  static void setMediumLE(long paramLong, int paramInt)
  {
    PlatformDependent.putByte(paramLong, (byte)paramInt);
    if (UNALIGNED)
    {
      boolean bool = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER;
      short s1 = (short)(paramInt >>> 8);
      short s2 = s1;
      int i;
      if (bool)
      {
        paramInt = Short.reverseBytes(s1);
        i = paramInt;
      }
      PlatformDependent.putShort(paramLong + 1L, i);
    }
    else
    {
      PlatformDependent.putByte(1L + paramLong, (byte)(paramInt >>> 8));
      PlatformDependent.putByte(paramLong + 2L, (byte)(paramInt >>> 16));
    }
  }
  
  static void setMediumLE(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    PlatformDependent.putByte(paramArrayOfByte, paramInt1, (byte)paramInt2);
    if (UNALIGNED)
    {
      int i;
      if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER)
      {
        paramInt2 = Short.reverseBytes((short)(paramInt2 >>> 8));
        i = paramInt2;
      }
      else
      {
        paramInt2 = (short)(paramInt2 >>> 8);
        i = paramInt2;
      }
      PlatformDependent.putShort(paramArrayOfByte, paramInt1 + 1, i);
    }
    else
    {
      PlatformDependent.putByte(paramArrayOfByte, paramInt1 + 1, (byte)(paramInt2 >>> 8));
      PlatformDependent.putByte(paramArrayOfByte, paramInt1 + 2, (byte)(paramInt2 >>> 16));
    }
  }
  
  static void setShort(long paramLong, int paramInt)
  {
    if (UNALIGNED)
    {
      boolean bool = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER;
      short s = (short)paramInt;
      int i;
      if (!bool)
      {
        paramInt = Short.reverseBytes(s);
        i = paramInt;
      }
      PlatformDependent.putShort(paramLong, i);
    }
    else
    {
      PlatformDependent.putByte(paramLong, (byte)(paramInt >>> 8));
      PlatformDependent.putByte(paramLong + 1L, (byte)paramInt);
    }
  }
  
  static void setShort(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (UNALIGNED)
    {
      boolean bool = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER;
      short s = (short)paramInt2;
      int i;
      if (!bool)
      {
        paramInt2 = Short.reverseBytes(s);
        i = paramInt2;
      }
      PlatformDependent.putShort(paramArrayOfByte, paramInt1, i);
    }
    else
    {
      PlatformDependent.putByte(paramArrayOfByte, paramInt1, (byte)(paramInt2 >>> 8));
      PlatformDependent.putByte(paramArrayOfByte, paramInt1 + 1, (byte)paramInt2);
    }
  }
  
  static void setShortLE(long paramLong, int paramInt)
  {
    if (UNALIGNED)
    {
      int i;
      if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER)
      {
        paramInt = Short.reverseBytes((short)paramInt);
        i = paramInt;
      }
      else
      {
        paramInt = (short)paramInt;
        i = paramInt;
      }
      PlatformDependent.putShort(paramLong, i);
    }
    else
    {
      PlatformDependent.putByte(paramLong, (byte)paramInt);
      PlatformDependent.putByte(paramLong + 1L, (byte)(paramInt >>> 8));
    }
  }
  
  static void setShortLE(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (UNALIGNED)
    {
      int i;
      if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER)
      {
        paramInt2 = Short.reverseBytes((short)paramInt2);
        i = paramInt2;
      }
      else
      {
        paramInt2 = (short)paramInt2;
        i = paramInt2;
      }
      PlatformDependent.putShort(paramArrayOfByte, paramInt1, i);
    }
    else
    {
      PlatformDependent.putByte(paramArrayOfByte, paramInt1, (byte)paramInt2);
      PlatformDependent.putByte(paramArrayOfByte, paramInt1 + 1, (byte)(paramInt2 >>> 8));
    }
  }
  
  private static void setSingleBytes(AbstractByteBuf paramAbstractByteBuf, long paramLong, int paramInt1, ByteBuffer paramByteBuffer, int paramInt2)
  {
    paramAbstractByteBuf.checkIndex(paramInt1, paramInt2);
    paramInt1 = paramByteBuffer.position();
    paramInt2 = paramByteBuffer.limit();
    while (paramInt1 < paramInt2)
    {
      PlatformDependent.putByte(paramLong, paramByteBuffer.get(paramInt1));
      paramLong += 1L;
      paramInt1++;
    }
    paramByteBuffer.position(paramInt2);
  }
  
  static void setZero(long paramLong, int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    PlatformDependent.setMemory(paramLong, paramInt, (byte)0);
  }
  
  static void setZero(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return;
    }
    PlatformDependent.setMemory(paramArrayOfByte, paramInt1, paramInt2, (byte)0);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\UnsafeByteBufUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */