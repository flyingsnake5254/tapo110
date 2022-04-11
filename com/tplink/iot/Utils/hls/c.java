package com.tplink.iot.Utils.hls;

import androidx.annotation.Nullable;
import b.d.d.m.e;
import b.d.e.d;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.g;
import com.google.android.exoplayer2.decoder.h;
import java.nio.ByteBuffer;

public class c
  extends g<DecoderInputBuffer, h, DecoderException>
{
  public static final String n = "c";
  private final String o;
  private d p;
  private final e q = new e();
  private volatile int r;
  private volatile int s;
  private final int t;
  
  protected c(String paramString)
  {
    super(new DecoderInputBuffer[100], new h[100]);
    this.o = paramString;
    this.p = new d(65536);
    this.t = 2;
  }
  
  protected DecoderInputBuffer g()
  {
    return new DecoderInputBuffer(1);
  }
  
  public String getName()
  {
    return this.o;
  }
  
  protected DecoderException i(Throwable paramThrowable)
  {
    return new Mp3DecoderException("Unexpected decode error", paramThrowable);
  }
  
  public void release()
  {
    super.release();
    d locald = this.p;
    if (locald != null) {
      locald.f();
    }
  }
  
  protected h v()
  {
    return new h(new a(this));
  }
  
  @Nullable
  protected DecoderException w(DecoderInputBuffer paramDecoderInputBuffer, h paramh, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.p.f();
      this.p = new d(65536);
    }
    byte[] arrayOfByte = new byte[paramDecoderInputBuffer.f.remaining()];
    paramDecoderInputBuffer.f.get(arrayOfByte);
    if (!this.p.b())
    {
      i = this.q.d(arrayOfByte, 0);
      this.s = this.q.f(arrayOfByte, 0);
      this.r = this.q.k(arrayOfByte, 0);
      this.p.e(this.r, i, this.s);
    }
    arrayOfByte = this.p.a(arrayOfByte);
    if (arrayOfByte == null)
    {
      paramh.m(Integer.MIN_VALUE);
      return null;
    }
    int i = arrayOfByte.length;
    paramh.o(paramDecoderInputBuffer.x, i).put(arrayOfByte);
    paramh.x.position(0);
    paramh.x.limit(i);
    return null;
  }
  
  public int x()
  {
    return this.s;
  }
  
  public int y()
  {
    return this.t;
  }
  
  public int z()
  {
    return this.r;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\hls\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */