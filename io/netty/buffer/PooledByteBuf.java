package io.netty.buffer;

import io.netty.util.internal.ObjectPool.Handle;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

abstract class PooledByteBuf<T>
  extends AbstractReferenceCountedByteBuf
{
  private ByteBufAllocator allocator;
  PoolThreadCache cache;
  protected PoolChunk<T> chunk;
  protected long handle;
  protected int length;
  int maxLength;
  protected T memory;
  protected int offset;
  private final ObjectPool.Handle<PooledByteBuf<T>> recyclerHandle;
  ByteBuffer tmpNioBuf;
  
  protected PooledByteBuf(ObjectPool.Handle<? extends PooledByteBuf<T>> paramHandle, int paramInt)
  {
    super(paramInt);
    this.recyclerHandle = paramHandle;
  }
  
  private void init0(PoolChunk<T> paramPoolChunk, ByteBuffer paramByteBuffer, long paramLong, int paramInt1, int paramInt2, int paramInt3, PoolThreadCache paramPoolThreadCache)
  {
    this.chunk = paramPoolChunk;
    this.memory = paramPoolChunk.memory;
    this.tmpNioBuf = paramByteBuffer;
    this.allocator = paramPoolChunk.arena.parent;
    this.cache = paramPoolThreadCache;
    this.handle = paramLong;
    this.offset = paramInt1;
    this.length = paramInt2;
    this.maxLength = paramInt3;
  }
  
  private void recycle()
  {
    this.recyclerHandle.recycle(this);
  }
  
  final ByteBuffer _internalNioBuffer(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramInt1 = idx(paramInt1);
    ByteBuffer localByteBuffer;
    if (paramBoolean) {
      localByteBuffer = newInternalNioBuffer(this.memory);
    } else {
      localByteBuffer = internalNioBuffer();
    }
    localByteBuffer.limit(paramInt2 + paramInt1).position(paramInt1);
    return localByteBuffer;
  }
  
  public final ByteBufAllocator alloc()
  {
    return this.allocator;
  }
  
  public final int capacity()
  {
    return this.length;
  }
  
  public final ByteBuf capacity(int paramInt)
  {
    if (paramInt == this.length)
    {
      ensureAccessible();
      return this;
    }
    checkNewCapacity(paramInt);
    PoolChunk localPoolChunk = this.chunk;
    if (!localPoolChunk.unpooled) {
      if (paramInt > this.length)
      {
        if (paramInt <= this.maxLength)
        {
          this.length = paramInt;
          return this;
        }
      }
      else
      {
        int i = this.maxLength;
        if ((paramInt > i >>> 1) && ((i > 512) || (paramInt > i - 16)))
        {
          this.length = paramInt;
          trimIndicesToCapacity(paramInt);
          return this;
        }
      }
    }
    localPoolChunk.arena.reallocate(this, paramInt, true);
    return this;
  }
  
  protected final void deallocate()
  {
    long l = this.handle;
    if (l >= 0L)
    {
      this.handle = -1L;
      this.memory = null;
      PoolChunk localPoolChunk = this.chunk;
      localPoolChunk.arena.free(localPoolChunk, this.tmpNioBuf, l, this.maxLength, this.cache);
      this.tmpNioBuf = null;
      this.chunk = null;
      recycle();
    }
  }
  
  ByteBuffer duplicateInternalNioBuffer(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return _internalNioBuffer(paramInt1, paramInt2, true);
  }
  
  public final int getBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    return paramFileChannel.write(duplicateInternalNioBuffer(paramInt1, paramInt2), paramLong);
  }
  
  public final int getBytes(int paramInt1, GatheringByteChannel paramGatheringByteChannel, int paramInt2)
    throws IOException
  {
    return paramGatheringByteChannel.write(duplicateInternalNioBuffer(paramInt1, paramInt2));
  }
  
  protected final int idx(int paramInt)
  {
    return this.offset + paramInt;
  }
  
  void init(PoolChunk<T> paramPoolChunk, ByteBuffer paramByteBuffer, long paramLong, int paramInt1, int paramInt2, int paramInt3, PoolThreadCache paramPoolThreadCache)
  {
    init0(paramPoolChunk, paramByteBuffer, paramLong, paramInt1, paramInt2, paramInt3, paramPoolThreadCache);
  }
  
  void initUnpooled(PoolChunk<T> paramPoolChunk, int paramInt)
  {
    init0(paramPoolChunk, null, 0L, paramPoolChunk.offset, paramInt, paramInt, null);
  }
  
  protected final ByteBuffer internalNioBuffer()
  {
    ByteBuffer localByteBuffer = this.tmpNioBuf;
    if (localByteBuffer == null)
    {
      localByteBuffer = newInternalNioBuffer(this.memory);
      this.tmpNioBuf = localByteBuffer;
    }
    else
    {
      localByteBuffer.clear();
    }
    return localByteBuffer;
  }
  
  public final ByteBuffer internalNioBuffer(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return _internalNioBuffer(paramInt1, paramInt2, false);
  }
  
  public final boolean isContiguous()
  {
    return true;
  }
  
  public int maxFastWritableBytes()
  {
    return Math.min(this.maxLength, maxCapacity()) - this.writerIndex;
  }
  
  protected abstract ByteBuffer newInternalNioBuffer(T paramT);
  
  public final ByteBuffer nioBuffer(int paramInt1, int paramInt2)
  {
    return duplicateInternalNioBuffer(paramInt1, paramInt2).slice();
  }
  
  public final int nioBufferCount()
  {
    return 1;
  }
  
  public final ByteBuffer[] nioBuffers(int paramInt1, int paramInt2)
  {
    return new ByteBuffer[] { nioBuffer(paramInt1, paramInt2) };
  }
  
  public final ByteOrder order()
  {
    return ByteOrder.BIG_ENDIAN;
  }
  
  public final int readBytes(FileChannel paramFileChannel, long paramLong, int paramInt)
    throws IOException
  {
    checkReadableBytes(paramInt);
    paramInt = paramFileChannel.write(_internalNioBuffer(this.readerIndex, paramInt, false), paramLong);
    this.readerIndex += paramInt;
    return paramInt;
  }
  
  public final int readBytes(GatheringByteChannel paramGatheringByteChannel, int paramInt)
    throws IOException
  {
    checkReadableBytes(paramInt);
    paramInt = paramGatheringByteChannel.write(_internalNioBuffer(this.readerIndex, paramInt, false));
    this.readerIndex += paramInt;
    return paramInt;
  }
  
  public final ByteBuf retainedDuplicate()
  {
    return PooledDuplicatedByteBuf.newInstance(this, this, readerIndex(), writerIndex());
  }
  
  public final ByteBuf retainedSlice()
  {
    int i = readerIndex();
    return retainedSlice(i, writerIndex() - i);
  }
  
  public final ByteBuf retainedSlice(int paramInt1, int paramInt2)
  {
    return PooledSlicedByteBuf.newInstance(this, this, paramInt1, paramInt2);
  }
  
  final void reuse(int paramInt)
  {
    maxCapacity(paramInt);
    resetRefCnt();
    setIndex0(0, 0);
    discardMarks();
  }
  
  public final int setBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    try
    {
      paramInt1 = paramFileChannel.read(internalNioBuffer(paramInt1, paramInt2), paramLong);
      return paramInt1;
    }
    catch (ClosedChannelException paramFileChannel) {}
    return -1;
  }
  
  public final int setBytes(int paramInt1, ScatteringByteChannel paramScatteringByteChannel, int paramInt2)
    throws IOException
  {
    try
    {
      paramInt1 = paramScatteringByteChannel.read(internalNioBuffer(paramInt1, paramInt2));
      return paramInt1;
    }
    catch (ClosedChannelException paramScatteringByteChannel) {}
    return -1;
  }
  
  public final ByteBuf unwrap()
  {
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\PooledByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */