package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.nio.ByteBuffer;

public final class h0
  extends y
{
  private final long i;
  private final long j;
  private final short k;
  private int l;
  private boolean m;
  private byte[] n;
  private byte[] o;
  private int p;
  private int q;
  private int r;
  private boolean s;
  private long t;
  
  public h0()
  {
    this(150000L, 20000L, (short)1024);
  }
  
  public h0(long paramLong1, long paramLong2, short paramShort)
  {
    boolean bool;
    if (paramLong2 <= paramLong1) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    this.i = paramLong1;
    this.j = paramLong2;
    this.k = ((short)paramShort);
    byte[] arrayOfByte = o0.f;
    this.n = arrayOfByte;
    this.o = arrayOfByte;
  }
  
  private int l(long paramLong)
  {
    return (int)(paramLong * this.b.b / 1000000L);
  }
  
  private int m(ByteBuffer paramByteBuffer)
  {
    for (int i1 = paramByteBuffer.limit() - 2; i1 >= paramByteBuffer.position(); i1 -= 2) {
      if (Math.abs(paramByteBuffer.getShort(i1)) > this.k)
      {
        int i2 = this.l;
        return i1 / i2 * i2 + i2;
      }
    }
    return paramByteBuffer.position();
  }
  
  private int n(ByteBuffer paramByteBuffer)
  {
    for (int i1 = paramByteBuffer.position(); i1 < paramByteBuffer.limit(); i1 += 2) {
      if (Math.abs(paramByteBuffer.getShort(i1)) > this.k)
      {
        int i2 = this.l;
        return i2 * (i1 / i2);
      }
    }
    return paramByteBuffer.limit();
  }
  
  private void p(ByteBuffer paramByteBuffer)
  {
    int i1 = paramByteBuffer.remaining();
    k(i1).put(paramByteBuffer).flip();
    if (i1 > 0) {
      this.s = true;
    }
  }
  
  private void q(byte[] paramArrayOfByte, int paramInt)
  {
    k(paramInt).put(paramArrayOfByte, 0, paramInt).flip();
    if (paramInt > 0) {
      this.s = true;
    }
  }
  
  private void r(ByteBuffer paramByteBuffer)
  {
    int i1 = paramByteBuffer.limit();
    int i2 = n(paramByteBuffer);
    int i3 = i2 - paramByteBuffer.position();
    byte[] arrayOfByte = this.n;
    int i4 = arrayOfByte.length;
    int i5 = this.q;
    i4 -= i5;
    if ((i2 < i1) && (i3 < i4))
    {
      q(arrayOfByte, i5);
      this.q = 0;
      this.p = 0;
    }
    else
    {
      i5 = Math.min(i3, i4);
      paramByteBuffer.limit(paramByteBuffer.position() + i5);
      paramByteBuffer.get(this.n, this.q, i5);
      i5 = this.q + i5;
      this.q = i5;
      arrayOfByte = this.n;
      if (i5 == arrayOfByte.length)
      {
        if (this.s)
        {
          q(arrayOfByte, this.r);
          this.t += (this.q - this.r * 2) / this.l;
        }
        else
        {
          this.t += (i5 - this.r) / this.l;
        }
        v(paramByteBuffer, this.n, this.q);
        this.q = 0;
        this.p = 2;
      }
      paramByteBuffer.limit(i1);
    }
  }
  
  private void s(ByteBuffer paramByteBuffer)
  {
    int i1 = paramByteBuffer.limit();
    paramByteBuffer.limit(Math.min(i1, paramByteBuffer.position() + this.n.length));
    int i2 = m(paramByteBuffer);
    if (i2 == paramByteBuffer.position())
    {
      this.p = 1;
    }
    else
    {
      paramByteBuffer.limit(i2);
      p(paramByteBuffer);
    }
    paramByteBuffer.limit(i1);
  }
  
  private void t(ByteBuffer paramByteBuffer)
  {
    int i1 = paramByteBuffer.limit();
    int i2 = n(paramByteBuffer);
    paramByteBuffer.limit(i2);
    this.t += paramByteBuffer.remaining() / this.l;
    v(paramByteBuffer, this.o, this.r);
    if (i2 < i1)
    {
      q(this.o, this.r);
      this.p = 0;
      paramByteBuffer.limit(i1);
    }
  }
  
  private void v(ByteBuffer paramByteBuffer, byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = Math.min(paramByteBuffer.remaining(), this.r);
    int i2 = this.r - i1;
    System.arraycopy(paramArrayOfByte, paramInt - i2, this.o, 0, i2);
    paramByteBuffer.position(paramByteBuffer.limit() - i1);
    paramByteBuffer.get(this.o, i2, i1);
  }
  
  public void b(ByteBuffer paramByteBuffer)
  {
    while ((paramByteBuffer.hasRemaining()) && (!f()))
    {
      int i1 = this.p;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 == 2) {
            t(paramByteBuffer);
          } else {
            throw new IllegalStateException();
          }
        }
        else {
          r(paramByteBuffer);
        }
      }
      else {
        s(paramByteBuffer);
      }
    }
  }
  
  public AudioProcessor.a g(AudioProcessor.a parama)
    throws AudioProcessor.UnhandledAudioFormatException
  {
    if (parama.d == 2)
    {
      if (!this.m) {
        parama = AudioProcessor.a.a;
      }
      return parama;
    }
    throw new AudioProcessor.UnhandledAudioFormatException(parama);
  }
  
  protected void h()
  {
    if (this.m)
    {
      this.l = this.b.e;
      int i1 = l(this.i) * this.l;
      if (this.n.length != i1) {
        this.n = new byte[i1];
      }
      i1 = l(this.j) * this.l;
      this.r = i1;
      if (this.o.length != i1) {
        this.o = new byte[i1];
      }
    }
    this.p = 0;
    this.t = 0L;
    this.q = 0;
    this.s = false;
  }
  
  protected void i()
  {
    int i1 = this.q;
    if (i1 > 0) {
      q(this.n, i1);
    }
    if (!this.s) {
      this.t += this.r / this.l;
    }
  }
  
  public boolean isActive()
  {
    return this.m;
  }
  
  protected void j()
  {
    this.m = false;
    this.r = 0;
    byte[] arrayOfByte = o0.f;
    this.n = arrayOfByte;
    this.o = arrayOfByte;
  }
  
  public long o()
  {
    return this.t;
  }
  
  public void u(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\h0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */