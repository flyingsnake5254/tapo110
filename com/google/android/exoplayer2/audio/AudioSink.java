package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.t1;
import java.nio.ByteBuffer;

public abstract interface AudioSink
{
  public abstract boolean a(Format paramFormat);
  
  public abstract boolean b();
  
  public abstract t1 c();
  
  public abstract boolean d();
  
  public abstract void e(t1 paramt1);
  
  public abstract void f(int paramInt);
  
  public abstract void flush();
  
  public abstract void g();
  
  public abstract void h(p paramp);
  
  public abstract boolean i(ByteBuffer paramByteBuffer, long paramLong, int paramInt)
    throws AudioSink.InitializationException, AudioSink.WriteException;
  
  public abstract void j(a parama);
  
  public abstract int k(Format paramFormat);
  
  public abstract void l();
  
  public abstract void m(x paramx);
  
  public abstract void n()
    throws AudioSink.WriteException;
  
  public abstract long o(boolean paramBoolean);
  
  public abstract void p();
  
  public abstract void pause();
  
  public abstract void play();
  
  public abstract void q(float paramFloat);
  
  public abstract void r();
  
  public abstract void reset();
  
  public abstract void s(Format paramFormat, int paramInt, @Nullable int[] paramArrayOfInt)
    throws AudioSink.ConfigurationException;
  
  public abstract void t(boolean paramBoolean);
  
  public static final class ConfigurationException
    extends Exception
  {
    public final Format format;
    
    public ConfigurationException(String paramString, Format paramFormat)
    {
      super();
      this.format = paramFormat;
    }
    
    public ConfigurationException(Throwable paramThrowable, Format paramFormat)
    {
      super();
      this.format = paramFormat;
    }
  }
  
  public static final class InitializationException
    extends Exception
  {
    public final int audioTrackState;
    public final Format format;
    public final boolean isRecoverable;
    
    public InitializationException(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Format paramFormat, boolean paramBoolean, @Nullable Exception paramException)
    {
      super(paramException);
      this.audioTrackState = paramInt1;
      this.isRecoverable = paramBoolean;
      this.format = paramFormat;
    }
  }
  
  public static final class UnexpectedDiscontinuityException
    extends Exception
  {
    public final long actualPresentationTimeUs;
    public final long expectedPresentationTimeUs;
    
    public UnexpectedDiscontinuityException(long paramLong1, long paramLong2)
    {
      super();
      this.actualPresentationTimeUs = paramLong1;
      this.expectedPresentationTimeUs = paramLong2;
    }
  }
  
  public static final class WriteException
    extends Exception
  {
    public final int errorCode;
    public final Format format;
    public final boolean isRecoverable;
    
    public WriteException(int paramInt, Format paramFormat, boolean paramBoolean)
    {
      super();
      this.isRecoverable = paramBoolean;
      this.errorCode = paramInt;
      this.format = paramFormat;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
    
    public abstract void b(Exception paramException);
    
    public abstract void c(long paramLong);
    
    public abstract void d(long paramLong);
    
    public abstract void e(int paramInt, long paramLong1, long paramLong2);
    
    public abstract void f();
    
    public abstract void g();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\AudioSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */