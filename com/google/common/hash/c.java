package com.google.common.hash;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@CanIgnoreReturnValue
abstract class c
  extends b
{
  private final ByteBuffer a;
  private final int b;
  private final int c;
  
  protected c(int paramInt)
  {
    this(paramInt, paramInt);
  }
  
  protected c(int paramInt1, int paramInt2)
  {
    boolean bool;
    if (paramInt2 % paramInt1 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    n.d(bool);
    this.a = ByteBuffer.allocate(paramInt2 + 7).order(ByteOrder.LITTLE_ENDIAN);
    this.b = paramInt2;
    this.c = paramInt1;
  }
  
  private void c()
  {
    this.a.flip();
    while (this.a.remaining() >= this.c) {
      d(this.a);
    }
    this.a.compact();
  }
  
  protected abstract e b();
  
  protected abstract void d(ByteBuffer paramByteBuffer);
  
  protected abstract void e(ByteBuffer paramByteBuffer);
  
  public final e hash()
  {
    c();
    this.a.flip();
    if (this.a.remaining() > 0)
    {
      e(this.a);
      ByteBuffer localByteBuffer = this.a;
      localByteBuffer.position(localByteBuffer.limit());
    }
    return b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\hash\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */