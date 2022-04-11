package io.netty.buffer;

import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import io.netty.util.internal.PlatformDependent;

final class PooledUnsafeHeapByteBuf
  extends PooledHeapByteBuf
{
  private static final ObjectPool<PooledUnsafeHeapByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator()
  {
    public PooledUnsafeHeapByteBuf newObject(ObjectPool.Handle<PooledUnsafeHeapByteBuf> paramAnonymousHandle)
    {
      return new PooledUnsafeHeapByteBuf(paramAnonymousHandle, 0, null);
    }
  });
  
  private PooledUnsafeHeapByteBuf(ObjectPool.Handle<PooledUnsafeHeapByteBuf> paramHandle, int paramInt)
  {
    super(paramHandle, paramInt);
  }
  
  static PooledUnsafeHeapByteBuf newUnsafeInstance(int paramInt)
  {
    PooledUnsafeHeapByteBuf localPooledUnsafeHeapByteBuf = (PooledUnsafeHeapByteBuf)RECYCLER.get();
    localPooledUnsafeHeapByteBuf.reuse(paramInt);
    return localPooledUnsafeHeapByteBuf;
  }
  
  protected byte _getByte(int paramInt)
  {
    return UnsafeByteBufUtil.getByte((byte[])this.memory, idx(paramInt));
  }
  
  protected int _getInt(int paramInt)
  {
    return UnsafeByteBufUtil.getInt((byte[])this.memory, idx(paramInt));
  }
  
  protected int _getIntLE(int paramInt)
  {
    return UnsafeByteBufUtil.getIntLE((byte[])this.memory, idx(paramInt));
  }
  
  protected long _getLong(int paramInt)
  {
    return UnsafeByteBufUtil.getLong((byte[])this.memory, idx(paramInt));
  }
  
  protected long _getLongLE(int paramInt)
  {
    return UnsafeByteBufUtil.getLongLE((byte[])this.memory, idx(paramInt));
  }
  
  protected short _getShort(int paramInt)
  {
    return UnsafeByteBufUtil.getShort((byte[])this.memory, idx(paramInt));
  }
  
  protected short _getShortLE(int paramInt)
  {
    return UnsafeByteBufUtil.getShortLE((byte[])this.memory, idx(paramInt));
  }
  
  protected int _getUnsignedMedium(int paramInt)
  {
    return UnsafeByteBufUtil.getUnsignedMedium((byte[])this.memory, idx(paramInt));
  }
  
  protected int _getUnsignedMediumLE(int paramInt)
  {
    return UnsafeByteBufUtil.getUnsignedMediumLE((byte[])this.memory, idx(paramInt));
  }
  
  protected void _setByte(int paramInt1, int paramInt2)
  {
    UnsafeByteBufUtil.setByte((byte[])this.memory, idx(paramInt1), paramInt2);
  }
  
  protected void _setInt(int paramInt1, int paramInt2)
  {
    UnsafeByteBufUtil.setInt((byte[])this.memory, idx(paramInt1), paramInt2);
  }
  
  protected void _setIntLE(int paramInt1, int paramInt2)
  {
    UnsafeByteBufUtil.setIntLE((byte[])this.memory, idx(paramInt1), paramInt2);
  }
  
  protected void _setLong(int paramInt, long paramLong)
  {
    UnsafeByteBufUtil.setLong((byte[])this.memory, idx(paramInt), paramLong);
  }
  
  protected void _setLongLE(int paramInt, long paramLong)
  {
    UnsafeByteBufUtil.setLongLE((byte[])this.memory, idx(paramInt), paramLong);
  }
  
  protected void _setMedium(int paramInt1, int paramInt2)
  {
    UnsafeByteBufUtil.setMedium((byte[])this.memory, idx(paramInt1), paramInt2);
  }
  
  protected void _setMediumLE(int paramInt1, int paramInt2)
  {
    UnsafeByteBufUtil.setMediumLE((byte[])this.memory, idx(paramInt1), paramInt2);
  }
  
  protected void _setShort(int paramInt1, int paramInt2)
  {
    UnsafeByteBufUtil.setShort((byte[])this.memory, idx(paramInt1), paramInt2);
  }
  
  protected void _setShortLE(int paramInt1, int paramInt2)
  {
    UnsafeByteBufUtil.setShortLE((byte[])this.memory, idx(paramInt1), paramInt2);
  }
  
  @Deprecated
  protected SwappedByteBuf newSwappedByteBuf()
  {
    if (PlatformDependent.isUnaligned()) {
      return new UnsafeHeapSwappedByteBuf(this);
    }
    return super.newSwappedByteBuf();
  }
  
  public ByteBuf setZero(int paramInt1, int paramInt2)
  {
    if (PlatformDependent.javaVersion() >= 7)
    {
      checkIndex(paramInt1, paramInt2);
      UnsafeByteBufUtil.setZero((byte[])this.memory, idx(paramInt1), paramInt2);
      return this;
    }
    return super.setZero(paramInt1, paramInt2);
  }
  
  public ByteBuf writeZero(int paramInt)
  {
    if (PlatformDependent.javaVersion() >= 7)
    {
      ensureWritable(paramInt);
      int i = this.writerIndex;
      UnsafeByteBufUtil.setZero((byte[])this.memory, idx(i), paramInt);
      this.writerIndex = (i + paramInt);
      return this;
    }
    return super.writeZero(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\PooledUnsafeHeapByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */