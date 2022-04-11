package io.netty.buffer;

import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;

final class UnreleasableByteBuf
  extends WrappedByteBuf
{
  private SwappedByteBuf swappedBuf;
  
  UnreleasableByteBuf(ByteBuf paramByteBuf)
  {
    super(localByteBuf);
  }
  
  public ByteBuf asReadOnly()
  {
    UnreleasableByteBuf localUnreleasableByteBuf;
    if (this.buf.isReadOnly()) {
      localUnreleasableByteBuf = this;
    } else {
      localUnreleasableByteBuf = new UnreleasableByteBuf(this.buf.asReadOnly());
    }
    return localUnreleasableByteBuf;
  }
  
  public ByteBuf duplicate()
  {
    return new UnreleasableByteBuf(this.buf.duplicate());
  }
  
  public ByteBuf order(ByteOrder paramByteOrder)
  {
    if (ObjectUtil.checkNotNull(paramByteOrder, "endianness") == order()) {
      return this;
    }
    SwappedByteBuf localSwappedByteBuf = this.swappedBuf;
    paramByteOrder = localSwappedByteBuf;
    if (localSwappedByteBuf == null)
    {
      paramByteOrder = new SwappedByteBuf(this);
      this.swappedBuf = paramByteOrder;
    }
    return paramByteOrder;
  }
  
  public ByteBuf readRetainedSlice(int paramInt)
  {
    return readSlice(paramInt);
  }
  
  public ByteBuf readSlice(int paramInt)
  {
    return new UnreleasableByteBuf(this.buf.readSlice(paramInt));
  }
  
  public boolean release()
  {
    return false;
  }
  
  public boolean release(int paramInt)
  {
    return false;
  }
  
  public ByteBuf retain()
  {
    return this;
  }
  
  public ByteBuf retain(int paramInt)
  {
    return this;
  }
  
  public ByteBuf retainedDuplicate()
  {
    return duplicate();
  }
  
  public ByteBuf retainedSlice()
  {
    return slice();
  }
  
  public ByteBuf retainedSlice(int paramInt1, int paramInt2)
  {
    return slice(paramInt1, paramInt2);
  }
  
  public ByteBuf slice()
  {
    return new UnreleasableByteBuf(this.buf.slice());
  }
  
  public ByteBuf slice(int paramInt1, int paramInt2)
  {
    return new UnreleasableByteBuf(this.buf.slice(paramInt1, paramInt2));
  }
  
  public ByteBuf touch()
  {
    return this;
  }
  
  public ByteBuf touch(Object paramObject)
  {
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\UnreleasableByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */