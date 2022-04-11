package com.google.android.exoplayer2.audio;

import androidx.annotation.CallSuper;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class y
  implements AudioProcessor
{
  protected AudioProcessor.a b;
  protected AudioProcessor.a c;
  private AudioProcessor.a d;
  private AudioProcessor.a e;
  private ByteBuffer f;
  private ByteBuffer g;
  private boolean h;
  
  public y()
  {
    Object localObject = AudioProcessor.a;
    this.f = ((ByteBuffer)localObject);
    this.g = ((ByteBuffer)localObject);
    localObject = AudioProcessor.a.a;
    this.d = ((AudioProcessor.a)localObject);
    this.e = ((AudioProcessor.a)localObject);
    this.b = ((AudioProcessor.a)localObject);
    this.c = ((AudioProcessor.a)localObject);
  }
  
  @CallSuper
  public ByteBuffer a()
  {
    ByteBuffer localByteBuffer = this.g;
    this.g = AudioProcessor.a;
    return localByteBuffer;
  }
  
  public final AudioProcessor.a c(AudioProcessor.a parama)
    throws AudioProcessor.UnhandledAudioFormatException
  {
    this.d = parama;
    this.e = g(parama);
    if (isActive()) {
      parama = this.e;
    } else {
      parama = AudioProcessor.a.a;
    }
    return parama;
  }
  
  @CallSuper
  public boolean d()
  {
    boolean bool;
    if ((this.h) && (this.g == AudioProcessor.a)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void e()
  {
    this.h = true;
    i();
  }
  
  protected final boolean f()
  {
    return this.g.hasRemaining();
  }
  
  public final void flush()
  {
    this.g = AudioProcessor.a;
    this.h = false;
    this.b = this.d;
    this.c = this.e;
    h();
  }
  
  protected abstract AudioProcessor.a g(AudioProcessor.a parama)
    throws AudioProcessor.UnhandledAudioFormatException;
  
  protected void h() {}
  
  protected void i() {}
  
  public boolean isActive()
  {
    boolean bool;
    if (this.e != AudioProcessor.a.a) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void j() {}
  
  protected final ByteBuffer k(int paramInt)
  {
    if (this.f.capacity() < paramInt) {
      this.f = ByteBuffer.allocateDirect(paramInt).order(ByteOrder.nativeOrder());
    } else {
      this.f.clear();
    }
    ByteBuffer localByteBuffer = this.f;
    this.g = localByteBuffer;
    return localByteBuffer;
  }
  
  public final void reset()
  {
    flush();
    this.f = AudioProcessor.a;
    AudioProcessor.a locala = AudioProcessor.a.a;
    this.d = locala;
    this.e = locala;
    this.b = locala;
    this.c = locala;
    j();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */