package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class j0
  implements AudioProcessor
{
  private int b;
  private float c = 1.0F;
  private float d = 1.0F;
  private AudioProcessor.a e;
  private AudioProcessor.a f;
  private AudioProcessor.a g;
  private AudioProcessor.a h;
  private boolean i;
  @Nullable
  private i0 j;
  private ByteBuffer k;
  private ShortBuffer l;
  private ByteBuffer m;
  private long n;
  private long o;
  private boolean p;
  
  public j0()
  {
    Object localObject = AudioProcessor.a.a;
    this.e = ((AudioProcessor.a)localObject);
    this.f = ((AudioProcessor.a)localObject);
    this.g = ((AudioProcessor.a)localObject);
    this.h = ((AudioProcessor.a)localObject);
    localObject = AudioProcessor.a;
    this.k = ((ByteBuffer)localObject);
    this.l = ((ByteBuffer)localObject).asShortBuffer();
    this.m = ((ByteBuffer)localObject);
    this.b = -1;
  }
  
  public ByteBuffer a()
  {
    i0 locali0 = this.j;
    if (locali0 != null)
    {
      int i1 = locali0.k();
      if (i1 > 0)
      {
        if (this.k.capacity() < i1)
        {
          localByteBuffer = ByteBuffer.allocateDirect(i1).order(ByteOrder.nativeOrder());
          this.k = localByteBuffer;
          this.l = localByteBuffer.asShortBuffer();
        }
        else
        {
          this.k.clear();
          this.l.clear();
        }
        locali0.j(this.l);
        this.o += i1;
        this.k.limit(i1);
        this.m = this.k;
      }
    }
    ByteBuffer localByteBuffer = this.m;
    this.m = AudioProcessor.a;
    return localByteBuffer;
  }
  
  public void b(ByteBuffer paramByteBuffer)
  {
    if (!paramByteBuffer.hasRemaining()) {
      return;
    }
    i0 locali0 = (i0)g.e(this.j);
    ShortBuffer localShortBuffer = paramByteBuffer.asShortBuffer();
    int i1 = paramByteBuffer.remaining();
    this.n += i1;
    locali0.t(localShortBuffer);
    paramByteBuffer.position(paramByteBuffer.position() + i1);
  }
  
  public AudioProcessor.a c(AudioProcessor.a parama)
    throws AudioProcessor.UnhandledAudioFormatException
  {
    if (parama.d == 2)
    {
      int i1 = this.b;
      int i2 = i1;
      if (i1 == -1) {
        i2 = parama.b;
      }
      this.e = parama;
      parama = new AudioProcessor.a(i2, parama.c, 2);
      this.f = parama;
      this.i = true;
      return parama;
    }
    throw new AudioProcessor.UnhandledAudioFormatException(parama);
  }
  
  public boolean d()
  {
    if (this.p)
    {
      i0 locali0 = this.j;
      if ((locali0 == null) || (locali0.k() == 0)) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public void e()
  {
    i0 locali0 = this.j;
    if (locali0 != null) {
      locali0.s();
    }
    this.p = true;
  }
  
  public long f(long paramLong)
  {
    if (this.o >= 1024L)
    {
      long l1 = this.n - ((i0)g.e(this.j)).l();
      int i1 = this.h.b;
      int i2 = this.g.b;
      if (i1 == i2) {
        paramLong = o0.C0(paramLong, l1, this.o);
      } else {
        paramLong = o0.C0(paramLong, l1 * i1, this.o * i2);
      }
      return paramLong;
    }
    return (this.c * paramLong);
  }
  
  public void flush()
  {
    if (isActive())
    {
      Object localObject = this.e;
      this.g = ((AudioProcessor.a)localObject);
      AudioProcessor.a locala = this.f;
      this.h = locala;
      if (this.i)
      {
        this.j = new i0(((AudioProcessor.a)localObject).b, ((AudioProcessor.a)localObject).c, this.c, this.d, locala.b);
      }
      else
      {
        localObject = this.j;
        if (localObject != null) {
          ((i0)localObject).i();
        }
      }
    }
    this.m = AudioProcessor.a;
    this.n = 0L;
    this.o = 0L;
    this.p = false;
  }
  
  public void g(float paramFloat)
  {
    if (this.d != paramFloat)
    {
      this.d = paramFloat;
      this.i = true;
    }
  }
  
  public void h(float paramFloat)
  {
    if (this.c != paramFloat)
    {
      this.c = paramFloat;
      this.i = true;
    }
  }
  
  public boolean isActive()
  {
    boolean bool;
    if ((this.f.b != -1) && ((Math.abs(this.c - 1.0F) >= 1.0E-4F) || (Math.abs(this.d - 1.0F) >= 1.0E-4F) || (this.f.b != this.e.b))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void reset()
  {
    this.c = 1.0F;
    this.d = 1.0F;
    Object localObject = AudioProcessor.a.a;
    this.e = ((AudioProcessor.a)localObject);
    this.f = ((AudioProcessor.a)localObject);
    this.g = ((AudioProcessor.a)localObject);
    this.h = ((AudioProcessor.a)localObject);
    localObject = AudioProcessor.a;
    this.k = ((ByteBuffer)localObject);
    this.l = ((ByteBuffer)localObject).asShortBuffer();
    this.m = ((ByteBuffer)localObject);
    this.b = -1;
    this.i = false;
    this.j = null;
    this.n = 0L;
    this.o = 0L;
    this.p = false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\j0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */