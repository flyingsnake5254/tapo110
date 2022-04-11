package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

final class PooledSlicedByteBuf
  extends AbstractPooledDerivedByteBuf
{
  private static final ObjectPool<PooledSlicedByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator()
  {
    public PooledSlicedByteBuf newObject(ObjectPool.Handle<PooledSlicedByteBuf> paramAnonymousHandle)
    {
      return new PooledSlicedByteBuf(paramAnonymousHandle, null);
    }
  });
  int adjustment;
  
  private PooledSlicedByteBuf(ObjectPool.Handle<PooledSlicedByteBuf> paramHandle)
  {
    super(paramHandle);
  }
  
  private int idx(int paramInt)
  {
    return paramInt + this.adjustment;
  }
  
  static PooledSlicedByteBuf newInstance(AbstractByteBuf paramAbstractByteBuf, ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    AbstractUnpooledSlicedByteBuf.checkSliceOutOfBounds(paramInt1, paramInt2, paramAbstractByteBuf);
    return newInstance0(paramAbstractByteBuf, paramByteBuf, paramInt1, paramInt2);
  }
  
  private static PooledSlicedByteBuf newInstance0(AbstractByteBuf paramAbstractByteBuf, ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    PooledSlicedByteBuf localPooledSlicedByteBuf = (PooledSlicedByteBuf)RECYCLER.get();
    localPooledSlicedByteBuf.init(paramAbstractByteBuf, paramByteBuf, 0, paramInt2, paramInt2);
    localPooledSlicedByteBuf.discardMarks();
    localPooledSlicedByteBuf.adjustment = paramInt1;
    return localPooledSlicedByteBuf;
  }
  
  protected byte _getByte(int paramInt)
  {
    return unwrap()._getByte(idx(paramInt));
  }
  
  protected int _getInt(int paramInt)
  {
    return unwrap()._getInt(idx(paramInt));
  }
  
  protected int _getIntLE(int paramInt)
  {
    return unwrap()._getIntLE(idx(paramInt));
  }
  
  protected long _getLong(int paramInt)
  {
    return unwrap()._getLong(idx(paramInt));
  }
  
  protected long _getLongLE(int paramInt)
  {
    return unwrap()._getLongLE(idx(paramInt));
  }
  
  protected short _getShort(int paramInt)
  {
    return unwrap()._getShort(idx(paramInt));
  }
  
  protected short _getShortLE(int paramInt)
  {
    return unwrap()._getShortLE(idx(paramInt));
  }
  
  protected int _getUnsignedMedium(int paramInt)
  {
    return unwrap()._getUnsignedMedium(idx(paramInt));
  }
  
  protected int _getUnsignedMediumLE(int paramInt)
  {
    return unwrap()._getUnsignedMediumLE(idx(paramInt));
  }
  
  protected void _setByte(int paramInt1, int paramInt2)
  {
    unwrap()._setByte(idx(paramInt1), paramInt2);
  }
  
  protected void _setInt(int paramInt1, int paramInt2)
  {
    unwrap()._setInt(idx(paramInt1), paramInt2);
  }
  
  protected void _setIntLE(int paramInt1, int paramInt2)
  {
    unwrap()._setIntLE(idx(paramInt1), paramInt2);
  }
  
  protected void _setLong(int paramInt, long paramLong)
  {
    unwrap()._setLong(idx(paramInt), paramLong);
  }
  
  protected void _setLongLE(int paramInt, long paramLong)
  {
    unwrap().setLongLE(idx(paramInt), paramLong);
  }
  
  protected void _setMedium(int paramInt1, int paramInt2)
  {
    unwrap()._setMedium(idx(paramInt1), paramInt2);
  }
  
  protected void _setMediumLE(int paramInt1, int paramInt2)
  {
    unwrap()._setMediumLE(idx(paramInt1), paramInt2);
  }
  
  protected void _setShort(int paramInt1, int paramInt2)
  {
    unwrap()._setShort(idx(paramInt1), paramInt2);
  }
  
  protected void _setShortLE(int paramInt1, int paramInt2)
  {
    unwrap()._setShortLE(idx(paramInt1), paramInt2);
  }
  
  public int arrayOffset()
  {
    return idx(unwrap().arrayOffset());
  }
  
  public int capacity()
  {
    return maxCapacity();
  }
  
  public ByteBuf capacity(int paramInt)
  {
    throw new UnsupportedOperationException("sliced buffer");
  }
  
  public ByteBuf copy(int paramInt1, int paramInt2)
  {
    checkIndex0(paramInt1, paramInt2);
    return unwrap().copy(idx(paramInt1), paramInt2);
  }
  
  public ByteBuf duplicate()
  {
    return duplicate0().setIndex(idx(readerIndex()), idx(writerIndex()));
  }
  
  public int forEachByte(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
  {
    checkIndex0(paramInt1, paramInt2);
    paramInt2 = unwrap().forEachByte(idx(paramInt1), paramInt2, paramByteProcessor);
    paramInt1 = this.adjustment;
    if (paramInt2 < paramInt1) {
      return -1;
    }
    return paramInt2 - paramInt1;
  }
  
  public int forEachByteDesc(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
  {
    checkIndex0(paramInt1, paramInt2);
    paramInt2 = unwrap().forEachByteDesc(idx(paramInt1), paramInt2, paramByteProcessor);
    paramInt1 = this.adjustment;
    if (paramInt2 < paramInt1) {
      return -1;
    }
    return paramInt2 - paramInt1;
  }
  
  public byte getByte(int paramInt)
  {
    checkIndex0(paramInt, 1);
    return unwrap().getByte(idx(paramInt));
  }
  
  public int getBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    checkIndex0(paramInt1, paramInt2);
    return unwrap().getBytes(idx(paramInt1), paramFileChannel, paramLong, paramInt2);
  }
  
  public int getBytes(int paramInt1, GatheringByteChannel paramGatheringByteChannel, int paramInt2)
    throws IOException
  {
    checkIndex0(paramInt1, paramInt2);
    return unwrap().getBytes(idx(paramInt1), paramGatheringByteChannel, paramInt2);
  }
  
  public ByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    checkIndex0(paramInt1, paramInt3);
    unwrap().getBytes(idx(paramInt1), paramByteBuf, paramInt2, paramInt3);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt1, OutputStream paramOutputStream, int paramInt2)
    throws IOException
  {
    checkIndex0(paramInt1, paramInt2);
    unwrap().getBytes(idx(paramInt1), paramOutputStream, paramInt2);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    checkIndex0(paramInt, paramByteBuffer.remaining());
    unwrap().getBytes(idx(paramInt), paramByteBuffer);
    return this;
  }
  
  public ByteBuf getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    checkIndex0(paramInt1, paramInt3);
    unwrap().getBytes(idx(paramInt1), paramArrayOfByte, paramInt2, paramInt3);
    return this;
  }
  
  public int getInt(int paramInt)
  {
    checkIndex0(paramInt, 4);
    return unwrap().getInt(idx(paramInt));
  }
  
  public int getIntLE(int paramInt)
  {
    checkIndex0(paramInt, 4);
    return unwrap().getIntLE(idx(paramInt));
  }
  
  public long getLong(int paramInt)
  {
    checkIndex0(paramInt, 8);
    return unwrap().getLong(idx(paramInt));
  }
  
  public long getLongLE(int paramInt)
  {
    checkIndex0(paramInt, 8);
    return unwrap().getLongLE(idx(paramInt));
  }
  
  public short getShort(int paramInt)
  {
    checkIndex0(paramInt, 2);
    return unwrap().getShort(idx(paramInt));
  }
  
  public short getShortLE(int paramInt)
  {
    checkIndex0(paramInt, 2);
    return unwrap().getShortLE(idx(paramInt));
  }
  
  public int getUnsignedMedium(int paramInt)
  {
    checkIndex0(paramInt, 3);
    return unwrap().getUnsignedMedium(idx(paramInt));
  }
  
  public int getUnsignedMediumLE(int paramInt)
  {
    checkIndex0(paramInt, 3);
    return unwrap().getUnsignedMediumLE(idx(paramInt));
  }
  
  public long memoryAddress()
  {
    return unwrap().memoryAddress() + this.adjustment;
  }
  
  public ByteBuffer nioBuffer(int paramInt1, int paramInt2)
  {
    checkIndex0(paramInt1, paramInt2);
    return unwrap().nioBuffer(idx(paramInt1), paramInt2);
  }
  
  public ByteBuffer[] nioBuffers(int paramInt1, int paramInt2)
  {
    checkIndex0(paramInt1, paramInt2);
    return unwrap().nioBuffers(idx(paramInt1), paramInt2);
  }
  
  public ByteBuf retainedDuplicate()
  {
    return PooledDuplicatedByteBuf.newInstance(unwrap(), this, idx(readerIndex()), idx(writerIndex()));
  }
  
  public ByteBuf retainedSlice(int paramInt1, int paramInt2)
  {
    checkIndex0(paramInt1, paramInt2);
    return newInstance0(unwrap(), this, idx(paramInt1), paramInt2);
  }
  
  public ByteBuf setByte(int paramInt1, int paramInt2)
  {
    checkIndex0(paramInt1, 1);
    unwrap().setByte(idx(paramInt1), paramInt2);
    return this;
  }
  
  public int setBytes(int paramInt1, InputStream paramInputStream, int paramInt2)
    throws IOException
  {
    checkIndex0(paramInt1, paramInt2);
    return unwrap().setBytes(idx(paramInt1), paramInputStream, paramInt2);
  }
  
  public int setBytes(int paramInt1, FileChannel paramFileChannel, long paramLong, int paramInt2)
    throws IOException
  {
    checkIndex0(paramInt1, paramInt2);
    return unwrap().setBytes(idx(paramInt1), paramFileChannel, paramLong, paramInt2);
  }
  
  public int setBytes(int paramInt1, ScatteringByteChannel paramScatteringByteChannel, int paramInt2)
    throws IOException
  {
    checkIndex0(paramInt1, paramInt2);
    return unwrap().setBytes(idx(paramInt1), paramScatteringByteChannel, paramInt2);
  }
  
  public ByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    checkIndex0(paramInt1, paramInt3);
    unwrap().setBytes(idx(paramInt1), paramByteBuf, paramInt2, paramInt3);
    return this;
  }
  
  public ByteBuf setBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    checkIndex0(paramInt, paramByteBuffer.remaining());
    unwrap().setBytes(idx(paramInt), paramByteBuffer);
    return this;
  }
  
  public ByteBuf setBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    checkIndex0(paramInt1, paramInt3);
    unwrap().setBytes(idx(paramInt1), paramArrayOfByte, paramInt2, paramInt3);
    return this;
  }
  
  public ByteBuf setInt(int paramInt1, int paramInt2)
  {
    checkIndex0(paramInt1, 4);
    unwrap().setInt(idx(paramInt1), paramInt2);
    return this;
  }
  
  public ByteBuf setIntLE(int paramInt1, int paramInt2)
  {
    checkIndex0(paramInt1, 4);
    unwrap().setIntLE(idx(paramInt1), paramInt2);
    return this;
  }
  
  public ByteBuf setLong(int paramInt, long paramLong)
  {
    checkIndex0(paramInt, 8);
    unwrap().setLong(idx(paramInt), paramLong);
    return this;
  }
  
  public ByteBuf setLongLE(int paramInt, long paramLong)
  {
    checkIndex0(paramInt, 8);
    unwrap().setLongLE(idx(paramInt), paramLong);
    return this;
  }
  
  public ByteBuf setMedium(int paramInt1, int paramInt2)
  {
    checkIndex0(paramInt1, 3);
    unwrap().setMedium(idx(paramInt1), paramInt2);
    return this;
  }
  
  public ByteBuf setMediumLE(int paramInt1, int paramInt2)
  {
    checkIndex0(paramInt1, 3);
    unwrap().setMediumLE(idx(paramInt1), paramInt2);
    return this;
  }
  
  public ByteBuf setShort(int paramInt1, int paramInt2)
  {
    checkIndex0(paramInt1, 2);
    unwrap().setShort(idx(paramInt1), paramInt2);
    return this;
  }
  
  public ByteBuf setShortLE(int paramInt1, int paramInt2)
  {
    checkIndex0(paramInt1, 2);
    unwrap().setShortLE(idx(paramInt1), paramInt2);
    return this;
  }
  
  public ByteBuf slice(int paramInt1, int paramInt2)
  {
    checkIndex0(paramInt1, paramInt2);
    return super.slice(idx(paramInt1), paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\PooledSlicedByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */