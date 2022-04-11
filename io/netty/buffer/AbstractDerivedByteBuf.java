package io.netty.buffer;

import io.netty.util.ReferenceCounted;
import java.nio.ByteBuffer;

@Deprecated
public abstract class AbstractDerivedByteBuf
  extends AbstractByteBuf
{
  protected AbstractDerivedByteBuf(int paramInt)
  {
    super(paramInt);
  }
  
  public ByteBuffer internalNioBuffer(int paramInt1, int paramInt2)
  {
    return nioBuffer(paramInt1, paramInt2);
  }
  
  final boolean isAccessible()
  {
    return unwrap().isAccessible();
  }
  
  public boolean isContiguous()
  {
    return unwrap().isContiguous();
  }
  
  public boolean isReadOnly()
  {
    return unwrap().isReadOnly();
  }
  
  public ByteBuffer nioBuffer(int paramInt1, int paramInt2)
  {
    return unwrap().nioBuffer(paramInt1, paramInt2);
  }
  
  public final int refCnt()
  {
    return refCnt0();
  }
  
  int refCnt0()
  {
    return unwrap().refCnt();
  }
  
  public final boolean release()
  {
    return release0();
  }
  
  public final boolean release(int paramInt)
  {
    return release0(paramInt);
  }
  
  boolean release0()
  {
    return unwrap().release();
  }
  
  boolean release0(int paramInt)
  {
    return unwrap().release(paramInt);
  }
  
  public final ByteBuf retain()
  {
    return retain0();
  }
  
  public final ByteBuf retain(int paramInt)
  {
    return retain0(paramInt);
  }
  
  ByteBuf retain0()
  {
    unwrap().retain();
    return this;
  }
  
  ByteBuf retain0(int paramInt)
  {
    unwrap().retain(paramInt);
    return this;
  }
  
  public final ByteBuf touch()
  {
    return touch0();
  }
  
  public final ByteBuf touch(Object paramObject)
  {
    return touch0(paramObject);
  }
  
  ByteBuf touch0()
  {
    unwrap().touch();
    return this;
  }
  
  ByteBuf touch0(Object paramObject)
  {
    unwrap().touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\AbstractDerivedByteBuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */