package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.o0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract interface AudioProcessor
{
  public static final ByteBuffer a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());
  
  public abstract ByteBuffer a();
  
  public abstract void b(ByteBuffer paramByteBuffer);
  
  public abstract a c(a parama)
    throws AudioProcessor.UnhandledAudioFormatException;
  
  public abstract boolean d();
  
  public abstract void e();
  
  public abstract void flush();
  
  public abstract boolean isActive();
  
  public abstract void reset();
  
  public static final class UnhandledAudioFormatException
    extends Exception
  {
    public UnhandledAudioFormatException(AudioProcessor.a parama)
    {
      super();
    }
  }
  
  public static final class a
  {
    public static final a a = new a(-1, -1, -1);
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramInt3;
      if (o0.k0(paramInt3)) {
        paramInt1 = o0.W(paramInt3, paramInt2);
      } else {
        paramInt1 = -1;
      }
      this.e = paramInt1;
    }
    
    public String toString()
    {
      int i = this.b;
      int j = this.c;
      int k = this.d;
      StringBuilder localStringBuilder = new StringBuilder(83);
      localStringBuilder.append("AudioFormat[sampleRate=");
      localStringBuilder.append(i);
      localStringBuilder.append(", channelCount=");
      localStringBuilder.append(j);
      localStringBuilder.append(", encoding=");
      localStringBuilder.append(k);
      localStringBuilder.append(']');
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\AudioProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */