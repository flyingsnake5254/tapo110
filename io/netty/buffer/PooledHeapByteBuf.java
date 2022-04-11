package io.netty.buffer;

import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

class PooledHeapByteBuf
  extends PooledByteBuf<byte[]>
{
  private static final ObjectPool<PooledHeapByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator()
  {
    public PooledHeapByteBuf newObject(ObjectPool.Handle<PooledHeapByteBuf> paramAnonymousHandle)
    {
      return new PooledHeapByteBuf(paramAnonymousHandle, 0);
    }
  });
  
  PooledHeapByteBuf(ObjectPool.Handle<? extends PooledHeapByteBuf> paramHandle, int paramInt)
  {
    super(paramHandle, paramInt);
  }
  
  static PooledHeapByteBuf newInstance(int paramInt)
  {
    PooledHeapByteBuf localPooledHeapByteBuf = (PooledHeapByteBuf)RECYCLER.get();
    localPooledHeapByteBuf.reuse(paramInt);
    return localPooledHeapByteBuf;
  }
  
  protected byte _getByte(int paramInt)
  {
    return HeapByteBufUtil.getByte((byte[])this.memory, idx(paramInt));
  }
  
  protected int _getInt(int paramInt)
  {
    return HeapByteBufUtil.getInt((byte[])this.memory, idx(paramInt));
  }
  
  protected int _getIntLE(int paramInt)
  {
    return HeapByteBufUtil.getIntLE((byte[])this.memory, idx(paramInt));
  }
  
  protected long _getLong(int paramInt)
  {
    return HeapByteBufUtil.getLong((byte[])this.memory, idx(paramInt));
  }
  
  protected long _getLongLE(int paramInt)
  {
    return HeapByteBufUtil.getLongLE((byte[])this.memory, idx(paramInt));
  }
  
  protected short _getShort(int paramInt)
  {
    return HeapByteBufUtil.getShort((byte[])this.memory, idx(paramInt));
  }
  
  protected short _getShortLE(int paramInt)
  {
    return HeapByteBufUtil.getShortLE((byte[])this.memory, idx(paramInt));
  }
  
  protected int _getUnsignedMedium(int paramInt)
  {
    return HeapByteBufUtil.getUnsignedMedium((byte[])this.memory, idx(paramInt));
  }
  
  protected int _getUnsignedMediumLE(int paramInt)
  {
    return HeapByteBufUtil.getUnsignedMediumLE((byte[])this.memory, idx(paramInt));
  }
  
  protected void _setByte(int paramInt1, int paramInt2)
  {
    HeapByteBufUtil.setByte((byte[])this.memory, idx(paramInt1), paramInt2);
  }
  
  protected void _setInt(int paramInt1, int paramInt2)
  {
    HeapByteBufUtil.setInt((byte[])this.memory, idx(paramInt1), paramInt2);
  }
  
  protected void _setIntLE(int paramInt1, int paramInt2)
  {
    HeapByteBufUtil.setIntLE((byte[])this.memory, idx(paramInt1), paramInt2);
  }
  
  protected void _setLong(int paramInt, long paramLong)
  {
    HeapByteBufUtil.setLong((byte[])this.memory, idx(paramInt), paramLong);
  }
  
  protected void _setLongLE(int paramInt, long paramLong)
  {
    HeapByteBufUtil.setLongLE((byte[])this.memory, idx(paramInt), paramLong);
  }
  
  protected void _setMedium(int paramInt1, int paramInt2)
  {
    HeapByteBufUtil.setMedium((byte[])this.memory, idx(paramInt1), paramInt2);
  }
  
  protected void _setMediumLE(int paramInt1, int paramInt2)
  {
    HeapByteBufUtil.setMediumLE((byte[])this.memory, idx(paramInt1), paramInt2);
  }
  
  protected void _setShort(int paramInt1, int paramInt2)
  {
    HeapByteBufUtil.setShort((byte[])this.memory, idx(paramInt1), paramInt2);
  }
  
  protected void _setShortLE(int paramInt1, int paramInt2)
  {
    HeapByteBufUtil.setShortLE((byte[])this.memory, idx(paramInt1), paramInt2);
  }
  
  public final byte[] array()
  {
    ensureAccessible();
    return (byte[])this.memory;
  }
  
  public final int arrayOffset()
  {
    return this.offset;
  }
  
  public final ByteBuf copy(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return alloc().heapBuffer(paramInt2, maxCapacity()).writeBytes((byte[])this.memory, idx(paramInt1), paramInt2);
  }
  
  final ByteBuffer duplicateInternalNioBuffer(int paramInt1, int paramInt2)
  {
    checkIndex(paramInt1, paramInt2);
    return ByteBuffer.wrap((byte[])this.memory, idx(paramInt1), paramInt2).slice();
  }
  
  public final ByteBuf getBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    checkDstIndex(paramInt1, paramInt3, paramInt2, paramByteBuf.capacity());
    if (paramByteBuf.hasMemoryAddress())
    {
      byte[] arrayOfByte = (byte[])this.memory;
      paramInt1 = idx(paramInt1);
      long l = paramByteBuf.memoryAddress();
      PlatformDependent.copyMemory(arrayOfByte, paramInt1, paramInt2 + l, paramInt3);
    }
    else if (paramByteBuf.hasArray())
    {
      getBytes(paramInt1, paramByteBuf.array(), paramByteBuf.arrayOffset() + paramInt2, paramInt3);
    }
    else
    {
      paramByteBuf.setBytes(paramInt2, (byte[])this.memory, idx(paramInt1), paramInt3);
    }
    return this;
  }
  
  public final ByteBuf getBytes(int paramInt1, OutputStream paramOutputStream, int paramInt2)
    throws IOException
  {
    checkIndex(paramInt1, paramInt2);
    paramOutputStream.write((byte[])this.memory, idx(paramInt1), paramInt2);
    return this;
  }
  
  public final ByteBuf getBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.remaining();
    checkIndex(paramInt, i);
    paramByteBuffer.put((byte[])this.memory, idx(paramInt), i);
    return this;
  }
  
  public final ByteBuf getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    checkDstIndex(paramInt1, paramInt3, paramInt2, paramArrayOfByte.length);
    System.arraycopy(this.memory, idx(paramInt1), paramArrayOfByte, paramInt2, paramInt3);
    return this;
  }
  
  public final boolean hasArray()
  {
    return true;
  }
  
  public final boolean hasMemoryAddress()
  {
    return false;
  }
  
  public final boolean isDirect()
  {
    return false;
  }
  
  public final long memoryAddress()
  {
    throw new UnsupportedOperationException();
  }
  
  protected final ByteBuffer newInternalNioBuffer(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public final int setBytes(int paramInt1, InputStream paramInputStream, int paramInt2)
    throws IOException
  {
    checkIndex(paramInt1, paramInt2);
    return paramInputStream.read((byte[])this.memory, idx(paramInt1), paramInt2);
  }
  
  public final ByteBuf setBytes(int paramInt1, ByteBuf paramByteBuf, int paramInt2, int paramInt3)
  {
    checkSrcIndex(paramInt1, paramInt3, paramInt2, paramByteBuf.capacity());
    if (paramByteBuf.hasMemoryAddress()) {
      PlatformDependent.copyMemory(paramByteBuf.memoryAddress() + paramInt2, (byte[])this.memory, idx(paramInt1), paramInt3);
    } else if (paramByteBuf.hasArray()) {
      setBytes(paramInt1, paramByteBuf.array(), paramByteBuf.arrayOffset() + paramInt2, paramInt3);
    } else {
      paramByteBuf.getBytes(paramInt2, (byte[])this.memory, idx(paramInt1), paramInt3);
    }
    return this;
  }
  
  public final ByteBuf setBytes(int paramInt, ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.remaining();
    checkIndex(paramInt, i);
    paramByteBuffer.get((byte[])this.memory, idx(paramInt), i);
    return this;
  }
  
  public final ByteBuf setBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    checkSrcIndex(paramInt1, paramInt3, paramInt2, paramArrayOfByte.length);
    System.arraycopy(paramArrayOfByte, paramInt2, this.memory, idx(paramInt1), paramInt3);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\PooledHeapByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */