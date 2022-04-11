package com.google.android.exoplayer2.decoder;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class h
  extends f
{
  private final f.a<h> q;
  @Nullable
  public ByteBuffer x;
  
  public h(f.a<h> parama)
  {
    this.q = parama;
  }
  
  public void f()
  {
    super.f();
    ByteBuffer localByteBuffer = this.x;
    if (localByteBuffer != null) {
      localByteBuffer.clear();
    }
  }
  
  public void n()
  {
    this.q.a(this);
  }
  
  public ByteBuffer o(long paramLong, int paramInt)
  {
    this.d = paramLong;
    ByteBuffer localByteBuffer = this.x;
    if ((localByteBuffer == null) || (localByteBuffer.capacity() < paramInt)) {
      this.x = ByteBuffer.allocateDirect(paramInt).order(ByteOrder.nativeOrder());
    }
    this.x.position(0);
    this.x.limit(paramInt);
    return this.x;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\decoder\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */