package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.o0;
import java.nio.ByteBuffer;

final class k0
  extends y
{
  private int i;
  private int j;
  private boolean k;
  private int l;
  private byte[] m = o0.f;
  private int n;
  private long o;
  
  public ByteBuffer a()
  {
    if (super.d())
    {
      int i1 = this.n;
      if (i1 > 0)
      {
        k(i1).put(this.m, 0, this.n).flip();
        this.n = 0;
      }
    }
    return super.a();
  }
  
  public void b(ByteBuffer paramByteBuffer)
  {
    int i1 = paramByteBuffer.position();
    int i2 = paramByteBuffer.limit();
    int i3 = i2 - i1;
    if (i3 == 0) {
      return;
    }
    int i4 = Math.min(i3, this.l);
    this.o += i4 / this.b.e;
    this.l -= i4;
    paramByteBuffer.position(i1 + i4);
    if (this.l > 0) {
      return;
    }
    i3 -= i4;
    i4 = this.n + i3 - this.m.length;
    ByteBuffer localByteBuffer = k(i4);
    i1 = o0.p(i4, 0, this.n);
    localByteBuffer.put(this.m, 0, i1);
    i4 = o0.p(i4 - i1, 0, i3);
    paramByteBuffer.limit(paramByteBuffer.position() + i4);
    localByteBuffer.put(paramByteBuffer);
    paramByteBuffer.limit(i2);
    i3 -= i4;
    i2 = this.n - i1;
    this.n = i2;
    byte[] arrayOfByte = this.m;
    System.arraycopy(arrayOfByte, i1, arrayOfByte, 0, i2);
    paramByteBuffer.get(this.m, this.n, i3);
    this.n += i3;
    localByteBuffer.flip();
  }
  
  public boolean d()
  {
    boolean bool;
    if ((super.d()) && (this.n == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public AudioProcessor.a g(AudioProcessor.a parama)
    throws AudioProcessor.UnhandledAudioFormatException
  {
    if (parama.d == 2)
    {
      this.k = true;
      AudioProcessor.a locala = parama;
      if (this.i == 0) {
        if (this.j != 0) {
          locala = parama;
        } else {
          locala = AudioProcessor.a.a;
        }
      }
      return locala;
    }
    throw new AudioProcessor.UnhandledAudioFormatException(parama);
  }
  
  protected void h()
  {
    if (this.k)
    {
      this.k = false;
      int i1 = this.j;
      int i2 = this.b.e;
      this.m = new byte[i1 * i2];
      this.l = (this.i * i2);
    }
    this.n = 0;
  }
  
  protected void i()
  {
    if (this.k)
    {
      int i1 = this.n;
      if (i1 > 0) {
        this.o += i1 / this.b.e;
      }
      this.n = 0;
    }
  }
  
  protected void j()
  {
    this.m = o0.f;
  }
  
  public long l()
  {
    return this.o;
  }
  
  public void m()
  {
    this.o = 0L;
  }
  
  public void n(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    this.j = paramInt2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\k0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */