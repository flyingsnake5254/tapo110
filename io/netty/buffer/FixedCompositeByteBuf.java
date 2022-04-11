package io.netty.buffer;

import io.netty.util.ReferenceCounted;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.RecyclableArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Collections;

final class FixedCompositeByteBuf
  extends AbstractReferenceCountedByteBuf
{
  private static final ByteBuf[] EMPTY = { Unpooled.EMPTY_BUFFER };
  private final ByteBufAllocator allocator;
  private final ByteBuf[] buffers;
  private final int capacity;
  private final boolean direct;
  private final int nioBufferCount;
  private final ByteOrder order;
  
  FixedCompositeByteBuf(ByteBufAllocator paramByteBufAllocator, ByteBuf... paramVarArgs)
  {
    super(Integer.MAX_VALUE);
    int i = paramVarArgs.length;
    int j = 1;
    if (i == 0)
    {
      this.buffers = EMPTY;
      this.order = ByteOrder.BIG_ENDIAN;
      this.nioBufferCount = 1;
      this.capacity = 0;
      this.direct = Unpooled.EMPTY_BUFFER.isDirect();
    }
    else
    {
      ByteBuf localByteBuf = paramVarArgs[0];
      this.buffers = paramVarArgs;
      int k = localByteBuf.nioBufferCount();
      i = localByteBuf.readableBytes();
      this.order = localByteBuf.order();
      boolean bool = true;
      while (j < paramVarArgs.length)
      {
        localByteBuf = paramVarArgs[j];
        if (paramVarArgs[j].order() == this.order)
        {
          k += localByteBuf.nioBufferCount();
          i += localByteBuf.readableBytes();
          if (!localByteBuf.isDirect()) {
            bool = false;
          }
          j++;
        }
        else
        {
          throw new IllegalArgumentException("All ByteBufs need to have same ByteOrder");
        }
      }
      this.nioBufferCount = k;
      this.capacity = i;
      this.direct = bool;
    }
    setIndex(0, capacity());
    this.allocator = paramByteBufAllocator;
  }
  
  private ByteBuf buffer(int paramInt)
  {
    ByteBuf localByteBuf1 = this.buffers[paramInt];
    ByteBuf localByteBuf2 = localByteBuf1;
    if ((localByteBuf1 instanceof Component)) {
      localByteBuf2 = ((Component)localByteBuf1).buf;
    }
    return localByteBuf2;
  }
  
  private Component findComponent(int paramInt)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      Object localObject = this.buffers;
      if (i >= localObject.length) {
        break;
      }
      Component localComponent1 = null;
      Component localComponent2 = localObject[i];
      localObject = localComponent2;
      if ((localComponent2 instanceof Component))
      {
        localComponent1 = (Component)localComponent2;
        localObject = localComponent1.buf;
      }
      j += ((ByteBuf)localObject).readableBytes();
      if (paramInt < j)
      {
        localComponent2 = localComponent1;
        if (localComponent1 == null)
        {
          localComponent2 = new Component(i, j - ((ByteBuf)localObject).readableBytes(), (ByteBuf)localObject);
          this.buffers[i] = localComponent2;
        }
        return localComponent2;
      }
      i++;
    }
    throw new IllegalStateException();
  }
  
  protected byte _getByte(int paramInt)
  {
    Component localComponent = findComponent(paramInt);
    return localComponent.buf.getByte(paramInt - localComponent.offset);
  }
  
  protected int _getInt(int paramInt)
  {
    Component localComponent = findComponent(paramInt);
    if (paramInt + 4 <= localComponent.endOffset) {
      return localComponent.buf.getInt(paramInt - localComponent.offset);
    }
    if (order() == ByteOrder.BIG_ENDIAN)
    {
      i = _getShort(paramInt);
      return _getShort(paramInt + 2) & 0xFFFF | (i & 0xFFFF) << 16;
    }
    int i = _getShort(paramInt);
    return (_getShort(paramInt + 2) & 0xFFFF) << 16 | i & 0xFFFF;
  }
  
  protected int _getIntLE(int paramInt)
  {
    Component localComponent = findComponent(paramInt);
    if (paramInt + 4 <= localComponent.endOffset) {
      return localComponent.buf.getIntLE(paramInt - localComponent.offset);
    }
    if (order() == ByteOrder.BIG_ENDIAN)
    {
      i = _getShortLE(paramInt);
      return (_getShortLE(paramInt + 2) & 0xFFFF) << 16 | i & 0xFFFF;
    }
    int i = _getShortLE(paramInt);
    return _getShortLE(paramInt + 2) & 0xFFFF | (i & 0xFFFF) << 16;
  }
  
  protected long _getLong(int paramInt)
  {
    Component localComponent = findComponent(paramInt);
    if (paramInt + 8 <= localComponent.endOffset) {
      return localComponent.buf.getLong(paramInt - localComponent.offset);
    }
    if (order() == ByteOrder.BIG_ENDIAN) {
      return (_getInt(paramInt) & 0xFFFFFFFF) << 32 | _getInt(paramInt + 4) & 0xFFFFFFFF;
    }
    return _getInt(paramInt) & 0xFFFFFFFF | (0xFFFFFFFF & _getInt(paramInt + 4)) << 32;
  }
  
  protected long _getLongLE(int paramInt)
  {
    Component localComponent = findComponent(paramInt);
    if (paramInt + 8 <= localComponent.endOffset) {
      return localComponent.buf.getLongLE(paramInt - localComponent.offset);
    }
    if (order() == ByteOrder.BIG_ENDIAN) {
      return _getIntLE(paramInt) & 0xFFFFFFFF | (0xFFFFFFFF & _getIntLE(paramInt + 4)) << 32;
    }
    return (_getIntLE(paramInt) & 0xFFFFFFFF) << 32 | _getIntLE(paramInt + 4) & 0xFFFFFFFF;
  }
  
  protected short _getShort(int paramInt)
  {
    Component localComponent = findComponent(paramInt);
    if (paramInt + 2 <= localComponent.endOffset) {
      return localComponent.buf.getShort(paramInt - localComponent.offset);
    }
    if (order() == ByteOrder.BIG_ENDIAN)
    {
      i = _getByte(paramInt);
      return (short)(_getByte(paramInt + 1) & 0xFF | (i & 0xFF) << 8);
    }
    int i = _getByte(paramInt);
    return (short)((_getByte(paramInt + 1) & 0xFF) << 8 | i & 0xFF);
  }
  
  protected short _getShortLE(int paramInt)
  {
    Component localComponent = findComponent(paramInt);
    if (paramInt + 2 <= localComponent.endOffset) {
      return localComponent.buf.getShortLE(paramInt - localComponent.offset);
    }
    if (order() == ByteOrder.BIG_ENDIAN)
    {
      i = _getByte(paramInt);
      return (short)((_getByte(paramInt + 1) & 0xFF) << 8 | i & 0xFF);
    }
    int i = _getByte(paramInt);
    return (short)(_getByte(paramInt + 1) & 0xFF | (i & 0xFF) << 8);
  }
  
  protected int _getUnsignedMedium(int paramInt)
  {
    Component localComponent = findComponent(paramInt);
    if (paramInt + 3 <= localComponent.endOffset) {
      return localComponent.buf.getUnsignedMedium(paramInt - localComponent.offset);
    }
    if (order() == ByteOrder.BIG_ENDIAN)
    {
      i = _getShort(paramInt);
      return _getByte(paramInt + 2) & 0xFF | (i & 0xFFFF) << 8;
    }
    int i = _getShort(paramInt);
    return (_getByte(paramInt + 2) & 0xFF) << 16 | i & 0xFFFF;
  }
  
  protected int _getUnsignedMediumLE(int paramInt)
  {
    Component localComponent = findComponent(paramInt);
    if (paramInt + 3 <= localComponent.endOffset) {
      return localComponent.buf.getUnsignedMediumLE(paramInt - localComponent.offset);
    }
    if (order() == ByteOrder.BIG_ENDIAN)
    {
      i = _getShortLE(paramInt);
      return (_getByte(paramInt + 2) & 0xFF) << 16 | i & 0xFFFF;
    }
    int i = _getShortLE(paramInt);
    return _getByte(paramInt + 2) & 0xFF | (i & 0xFFFF) << 8;
  }
  
  protected void _setByte(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setInt(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setIntLE(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setLong(int paramInt, long paramLong)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setLongLE(int paramInt, long paramLong)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setMedium(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setMediumLE(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setShort(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  protected void _setShortLE(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBufAllocator alloc()
  {
    return this.allocator;
  }
  
  public byte[] array()
  {
    int i = this.buffers.length;
    if (i != 0)
    {
      if (i == 1) {
        return buffer(0).array();
      }
      throw new UnsupportedOperationException();
    }
    return EmptyArrays.EMPTY_BYTES;
  }
  
  public int arrayOffset()
  {
    int i = this.buffers.length;
    if (i != 0)
    {
      if (i == 1) {
        return buffer(0).arrayOffset();
      }
      throw new UnsupportedOperationException();
    }
    return 0;
  }
  
  public int capacity()
  {
    return this.capacity;
  }
  
  public ByteBuf capacity(int paramInt)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf copy(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    ByteBuf localByteBuf = alloc().buffer(paramInt2);
    try
    {
      return localByteBuf;
    }
    finally
    {
      localByteBuf.release();
    }
  }
  
  protected void deallocate()
  {
    for (int i = 0; i < this.buffers.length; i++) {
      buffer(i).release();
    }
  }
  
  public ByteBuf discardReadBytes()
  {
    throw new ReadOnlyBufferException();
  }
  
  public byte getByte(int paramInt)
  {
    return _getByte(paramInt);
  }
  
  public int getBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    if (nioBufferCount() == 1) {
      return paramFileChannel.write(internalNioBuffer(paramInt1, paramInt2), paramLong);
    }
    long l = 0L;
    ByteBuffer[] arrayOfByteBuffer = nioBuffers(paramInt1, paramInt2);
    paramInt2 = arrayOfByteBuffer.length;
    for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
      l += paramFileChannel.write(arrayOfByteBuffer[paramInt1], paramLong + l);
    }
    if (l > 2147483647L) {
      return Integer.MAX_VALUE;
    }
    return (int)l;
  }
  
  public int getBytes(int paramInt1, GatheringByteChannel paramGatheringByteChannel, int paramInt2)
    throws IOException
  {
    if (nioBufferCount() == 1) {
      return paramGatheringByteChannel.write(internalNioBuffer(paramInt1, paramInt2));
    }
    long l = paramGatheringByteChannel.write(nioBuffers(paramInt1, paramInt2));
    if (l > 2147483647L) {
      return Integer.MAX_VALUE;
    }
    return (int)l;
  }
  
  public ByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    checkDstIndex(paramInt1, paramInt3, paramInt2, paramByteBuf.capacity());
    if (paramInt3 == 0) {
      return this;
    }
    Object localObject = findComponent(paramInt1);
    int i = ((Component)localObject).index;
    int j = ((Component)localObject).offset;
    localObject = ((WrappedByteBuf)localObject).buf;
    int k = paramInt1;
    paramInt1 = i;
    for (;;)
    {
      i = ((ByteBuf)localObject).readableBytes();
      int m = k - j;
      i = Math.min(paramInt3, i - m);
      ((ByteBuf)localObject).getBytes(m, paramByteBuf, paramInt2, i);
      k += i;
      paramInt2 += i;
      paramInt3 -= i;
      j += ((ByteBuf)localObject).readableBytes();
      if (paramInt3 <= 0) {
        return this;
      }
      paramInt1++;
      localObject = buffer(paramInt1);
    }
  }
  
  public ByteBuf getBytes(int paramInt1, OutputStream paramOutputStream, int paramInt2)
    throws IOException
  {
    checkIndex(paramInt1, paramInt2);
    if (paramInt2 == 0) {
      return this;
    }
    Object localObject = findComponent(paramInt1);
    int i = ((Component)localObject).index;
    int j = ((Component)localObject).offset;
    localObject = ((WrappedByteBuf)localObject).buf;
    int k = paramInt1;
    paramInt1 = i;
    for (;;)
    {
      i = ((ByteBuf)localObject).readableBytes();
      int m = k - j;
      i = Math.min(paramInt2, i - m);
      ((ByteBuf)localObject).getBytes(m, paramOutputStream, i);
      k += i;
      paramInt2 -= i;
      j += ((ByteBuf)localObject).readableBytes();
      if (paramInt2 <= 0) {
        return this;
      }
      paramInt1++;
      localObject = buffer(paramInt1);
    }
  }
  
  /* Error */
  public ByteBuf getBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 274	java/nio/ByteBuffer:limit	()I
    //   4: istore_3
    //   5: aload_2
    //   6: invokevirtual 277	java/nio/ByteBuffer:remaining	()I
    //   9: istore 4
    //   11: aload_0
    //   12: iload_1
    //   13: iload 4
    //   15: invokevirtual 200	io/netty/buffer/AbstractByteBuf:checkIndex	(II)V
    //   18: iload 4
    //   20: ifne +5 -> 25
    //   23: aload_0
    //   24: areturn
    //   25: aload_0
    //   26: iload_1
    //   27: invokespecial 103	io/netty/buffer/FixedCompositeByteBuf:findComponent	(I)Lio/netty/buffer/FixedCompositeByteBuf$Component;
    //   30: astore 5
    //   32: aload 5
    //   34: invokestatic 257	io/netty/buffer/FixedCompositeByteBuf$Component:access$200	(Lio/netty/buffer/FixedCompositeByteBuf$Component;)I
    //   37: istore 6
    //   39: aload 5
    //   41: invokestatic 107	io/netty/buffer/FixedCompositeByteBuf$Component:access$000	(Lio/netty/buffer/FixedCompositeByteBuf$Component;)I
    //   44: istore 7
    //   46: aload 5
    //   48: getfield 90	io/netty/buffer/WrappedByteBuf:buf	Lio/netty/buffer/ByteBuf;
    //   51: astore 5
    //   53: iload_1
    //   54: istore 8
    //   56: iload 6
    //   58: istore_1
    //   59: aload 5
    //   61: invokevirtual 63	io/netty/buffer/ByteBuf:readableBytes	()I
    //   64: istore 6
    //   66: iload 8
    //   68: iload 7
    //   70: isub
    //   71: istore 9
    //   73: iload 4
    //   75: iload 6
    //   77: iload 9
    //   79: isub
    //   80: invokestatic 263	java/lang/Math:min	(II)I
    //   83: istore 6
    //   85: aload_2
    //   86: aload_2
    //   87: invokevirtual 280	java/nio/ByteBuffer:position	()I
    //   90: iload 6
    //   92: iadd
    //   93: invokevirtual 283	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   96: pop
    //   97: aload 5
    //   99: iload 9
    //   101: aload_2
    //   102: invokevirtual 285	io/netty/buffer/ByteBuf:getBytes	(ILjava/nio/ByteBuffer;)Lio/netty/buffer/ByteBuf;
    //   105: pop
    //   106: iload 8
    //   108: iload 6
    //   110: iadd
    //   111: istore 8
    //   113: iload 4
    //   115: iload 6
    //   117: isub
    //   118: istore 4
    //   120: aload 5
    //   122: invokevirtual 63	io/netty/buffer/ByteBuf:readableBytes	()I
    //   125: istore 6
    //   127: iload 7
    //   129: iload 6
    //   131: iadd
    //   132: istore 7
    //   134: iload 4
    //   136: ifgt +11 -> 147
    //   139: aload_2
    //   140: iload_3
    //   141: invokevirtual 283	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   144: pop
    //   145: aload_0
    //   146: areturn
    //   147: iinc 1 1
    //   150: aload_0
    //   151: iload_1
    //   152: invokespecial 182	io/netty/buffer/FixedCompositeByteBuf:buffer	(I)Lio/netty/buffer/ByteBuf;
    //   155: astore 5
    //   157: goto -98 -> 59
    //   160: astore 5
    //   162: aload_2
    //   163: iload_3
    //   164: invokevirtual 283	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   167: pop
    //   168: aload 5
    //   170: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	FixedCompositeByteBuf
    //   0	171	1	paramInt	int
    //   0	171	2	paramByteBuffer	ByteBuffer
    //   4	160	3	i	int
    //   9	126	4	j	int
    //   30	126	5	localObject1	Object
    //   160	9	5	localObject2	Object
    //   37	95	6	k	int
    //   44	89	7	m	int
    //   54	58	8	n	int
    //   71	29	9	i1	int
    // Exception table:
    //   from	to	target	type
    //   25	53	160	finally
    //   59	66	160	finally
    //   73	106	160	finally
    //   120	127	160	finally
    //   150	157	160	finally
  }
  
  public ByteBuf getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    checkDstIndex(paramInt1, paramInt3, paramInt2, paramArrayOfByte.length);
    if (paramInt3 == 0) {
      return this;
    }
    Object localObject = findComponent(paramInt1);
    int i = ((Component)localObject).index;
    int j = ((Component)localObject).offset;
    localObject = ((WrappedByteBuf)localObject).buf;
    int k = paramInt1;
    paramInt1 = j;
    for (;;)
    {
      j = ((ByteBuf)localObject).readableBytes();
      int m = k - paramInt1;
      j = Math.min(paramInt3, j - m);
      ((ByteBuf)localObject).getBytes(m, paramArrayOfByte, paramInt2, j);
      k += j;
      paramInt2 += j;
      paramInt3 -= j;
      paramInt1 += ((ByteBuf)localObject).readableBytes();
      if (paramInt3 <= 0) {
        return this;
      }
      i++;
      localObject = buffer(i);
    }
  }
  
  public boolean hasArray()
  {
    int i = this.buffers.length;
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      return buffer(0).hasArray();
    }
    return true;
  }
  
  public boolean hasMemoryAddress()
  {
    int i = this.buffers.length;
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      return buffer(0).hasMemoryAddress();
    }
    return Unpooled.EMPTY_BUFFER.hasMemoryAddress();
  }
  
  public ByteBuffer internalNioBuffer(int paramInt1, int paramInt2)
  {
    if (this.buffers.length == 1) {
      return buffer(0).internalNioBuffer(paramInt1, paramInt2);
    }
    throw new UnsupportedOperationException();
  }
  
  public boolean isDirect()
  {
    return this.direct;
  }
  
  public boolean isWritable()
  {
    return false;
  }
  
  public boolean isWritable(int paramInt)
  {
    return false;
  }
  
  public int maxCapacity()
  {
    return this.capacity;
  }
  
  public long memoryAddress()
  {
    int i = this.buffers.length;
    if (i != 0)
    {
      if (i == 1) {
        return buffer(0).memoryAddress();
      }
      throw new UnsupportedOperationException();
    }
    return Unpooled.EMPTY_BUFFER.memoryAddress();
  }
  
  public ByteBuffer nioBuffer(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    int i = this.buffers.length;
    int j = 0;
    if (i == 1)
    {
      localObject = buffer(0);
      if (((ByteBuf)localObject).nioBufferCount() == 1) {
        return ((ByteBuf)localObject).nioBuffer(paramInt1, paramInt2);
      }
    }
    Object localObject = ByteBuffer.allocate(paramInt2).order(order());
    ByteBuffer[] arrayOfByteBuffer = nioBuffers(paramInt1, paramInt2);
    for (paramInt1 = j; paramInt1 < arrayOfByteBuffer.length; paramInt1++) {
      ((ByteBuffer)localObject).put(arrayOfByteBuffer[paramInt1]);
    }
    ((ByteBuffer)localObject).flip();
    return (ByteBuffer)localObject;
  }
  
  public int nioBufferCount()
  {
    return this.nioBufferCount;
  }
  
  public ByteBuffer[] nioBuffers(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    if (paramInt2 == 0) {
      return EmptyArrays.EMPTY_BYTE_BUFFERS;
    }
    RecyclableArrayList localRecyclableArrayList = RecyclableArrayList.newInstance(this.buffers.length);
    try
    {
      Object localObject1 = findComponent(paramInt1);
      int i = ((Component)localObject1).index;
      int j = ((Component)localObject1).offset;
      for (localObject1 = ((WrappedByteBuf)localObject1).buf;; localObject1 = buffer(i))
      {
        int k = ((ByteBuf)localObject1).readableBytes();
        int m = paramInt1 - j;
        k = Math.min(paramInt2, k - m);
        int n = ((ByteBuf)localObject1).nioBufferCount();
        if (n == 0) {
          break;
        }
        if (n != 1) {
          Collections.addAll(localRecyclableArrayList, ((ByteBuf)localObject1).nioBuffers(m, k));
        } else {
          localRecyclableArrayList.add(((ByteBuf)localObject1).nioBuffer(m, k));
        }
        paramInt1 += k;
        paramInt2 -= k;
        j += ((ByteBuf)localObject1).readableBytes();
        if (paramInt2 <= 0)
        {
          localObject1 = (ByteBuffer[])localRecyclableArrayList.toArray(new ByteBuffer[0]);
          return (ByteBuffer[])localObject1;
        }
        i++;
      }
      localObject1 = new java/lang/UnsupportedOperationException;
      ((UnsupportedOperationException)localObject1).<init>();
      throw ((Throwable)localObject1);
    }
    finally
    {
      localRecyclableArrayList.recycle();
    }
  }
  
  public ByteOrder order()
  {
    return this.order;
  }
  
  public ByteBuf setByte(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public int setBytes(int paramInt1, InputStream paramInputStream, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public int setBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public int setBytes(int paramInt1, ScatteringByteChannel paramScatteringByteChannel, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setInt(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setLong(int paramInt, long paramLong)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setMedium(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public ByteBuf setShort(int paramInt1, int paramInt2)
  {
    throw new ReadOnlyBufferException();
  }
  
  public String toString()
  {
    String str = super.toString();
    str = str.substring(0, str.length() - 1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(", components=");
    localStringBuilder.append(this.buffers.length);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public ByteBuf unwrap()
  {
    return null;
  }
  
  private static final class Component
    extends WrappedByteBuf
  {
    private final int endOffset;
    private final int index;
    private final int offset;
    
    Component(int paramInt1, int paramInt2, ByteBuf paramByteBuf)
    {
      super();
      this.index = paramInt1;
      this.offset = paramInt2;
      this.endOffset = (paramInt2 + paramByteBuf.readableBytes());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\FixedCompositeByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */