package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.decoder.b;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.nio.ByteBuffer;

public class t
  implements q
{
  private final MediaCodec a;
  @Nullable
  private ByteBuffer[] b;
  @Nullable
  private ByteBuffer[] c;
  
  private t(MediaCodec paramMediaCodec)
  {
    this.a = paramMediaCodec;
    if (o0.a < 21)
    {
      this.b = paramMediaCodec.getInputBuffers();
      this.c = paramMediaCodec.getOutputBuffers();
    }
  }
  
  public void a(int paramInt1, int paramInt2, b paramb, long paramLong, int paramInt3)
  {
    this.a.queueSecureInputBuffer(paramInt1, paramInt2, paramb.a(), paramLong, paramInt3);
  }
  
  public MediaFormat b()
  {
    return this.a.getOutputFormat();
  }
  
  @RequiresApi(23)
  public void c(q.c paramc, Handler paramHandler)
  {
    this.a.setOnFrameRenderedListener(new i(this, paramc), paramHandler);
  }
  
  public void d(int paramInt)
  {
    this.a.setVideoScalingMode(paramInt);
  }
  
  @Nullable
  public ByteBuffer e(int paramInt)
  {
    if (o0.a >= 21) {
      return this.a.getInputBuffer(paramInt);
    }
    return ((ByteBuffer[])o0.i(this.b))[paramInt];
  }
  
  @RequiresApi(23)
  public void f(Surface paramSurface)
  {
    this.a.setOutputSurface(paramSurface);
  }
  
  public void flush()
  {
    this.a.flush();
  }
  
  public void g(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    this.a.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
  }
  
  public boolean h()
  {
    return false;
  }
  
  @RequiresApi(19)
  public void i(Bundle paramBundle)
  {
    this.a.setParameters(paramBundle);
  }
  
  @RequiresApi(21)
  public void j(int paramInt, long paramLong)
  {
    this.a.releaseOutputBuffer(paramInt, paramLong);
  }
  
  public int k()
  {
    return this.a.dequeueInputBuffer(0L);
  }
  
  public int l(MediaCodec.BufferInfo paramBufferInfo)
  {
    int i;
    do
    {
      i = this.a.dequeueOutputBuffer(paramBufferInfo, 0L);
      if ((i == -3) && (o0.a < 21)) {
        this.c = this.a.getOutputBuffers();
      }
    } while (i == -3);
    return i;
  }
  
  public void m(int paramInt, boolean paramBoolean)
  {
    this.a.releaseOutputBuffer(paramInt, paramBoolean);
  }
  
  @Nullable
  public ByteBuffer n(int paramInt)
  {
    if (o0.a >= 21) {
      return this.a.getOutputBuffer(paramInt);
    }
    return ((ByteBuffer[])o0.i(this.c))[paramInt];
  }
  
  public void release()
  {
    this.b = null;
    this.c = null;
    this.a.release();
  }
  
  public static class b
    implements q.b
  {
    public q a(q.a parama)
      throws IOException
    {
      Object localObject1 = null;
      Object localObject2;
      try
      {
        localObject2 = b(parama);
        try
        {
          m0.a("configureCodec");
          ((MediaCodec)localObject2).configure(parama.b, parama.d, parama.e, parama.f);
          m0.c();
          m0.a("startCodec");
          ((MediaCodec)localObject2).start();
          m0.c();
          parama = new t((MediaCodec)localObject2, null);
          return parama;
        }
        catch (RuntimeException parama) {}catch (IOException parama) {}
      }
      catch (RuntimeException parama)
      {
        localObject2 = localObject1;
      }
      catch (IOException parama)
      {
        localObject2 = localObject1;
      }
      if (localObject2 != null) {
        ((MediaCodec)localObject2).release();
      }
      throw parama;
    }
    
    protected MediaCodec b(q.a parama)
      throws IOException
    {
      g.e(parama.a);
      String str = parama.a.a;
      parama = String.valueOf(str);
      if (parama.length() != 0) {
        parama = "createCodec:".concat(parama);
      } else {
        parama = new String("createCodec:");
      }
      m0.a(parama);
      parama = MediaCodec.createByCodecName(str);
      m0.c();
      return parama;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\mediacodec\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */