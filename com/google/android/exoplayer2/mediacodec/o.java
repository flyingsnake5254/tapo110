package com.google.android.exoplayer2.mediacodec;

import androidx.annotation.IntRange;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.util.g;
import java.nio.ByteBuffer;

final class o
  extends DecoderInputBuffer
{
  private long p1;
  private int p2;
  private int p3 = 32;
  
  public o()
  {
    super(2);
  }
  
  private boolean u(DecoderInputBuffer paramDecoderInputBuffer)
  {
    if (!y()) {
      return true;
    }
    if (this.p2 >= this.p3) {
      return false;
    }
    if (paramDecoderInputBuffer.j() != j()) {
      return false;
    }
    ByteBuffer localByteBuffer = paramDecoderInputBuffer.f;
    if (localByteBuffer != null)
    {
      paramDecoderInputBuffer = this.f;
      if ((paramDecoderInputBuffer != null) && (paramDecoderInputBuffer.position() + localByteBuffer.remaining() > 3072000)) {
        return false;
      }
    }
    return true;
  }
  
  public void f()
  {
    super.f();
    this.p2 = 0;
  }
  
  public boolean t(DecoderInputBuffer paramDecoderInputBuffer)
  {
    g.a(paramDecoderInputBuffer.q() ^ true);
    g.a(paramDecoderInputBuffer.i() ^ true);
    g.a(paramDecoderInputBuffer.k() ^ true);
    if (!u(paramDecoderInputBuffer)) {
      return false;
    }
    int i = this.p2;
    this.p2 = (i + 1);
    if (i == 0)
    {
      this.x = paramDecoderInputBuffer.x;
      if (paramDecoderInputBuffer.l()) {
        m(1);
      }
    }
    if (paramDecoderInputBuffer.j()) {
      m(Integer.MIN_VALUE);
    }
    ByteBuffer localByteBuffer = paramDecoderInputBuffer.f;
    if (localByteBuffer != null)
    {
      o(localByteBuffer.remaining());
      this.f.put(localByteBuffer);
    }
    this.p1 = paramDecoderInputBuffer.x;
    return true;
  }
  
  public long v()
  {
    return this.x;
  }
  
  public long w()
  {
    return this.p1;
  }
  
  public int x()
  {
    return this.p2;
  }
  
  public boolean y()
  {
    boolean bool;
    if (this.p2 > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void z(@IntRange(from=1L) int paramInt)
  {
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    this.p3 = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\mediacodec\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */