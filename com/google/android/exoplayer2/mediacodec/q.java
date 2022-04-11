package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.b;
import java.io.IOException;
import java.nio.ByteBuffer;

public abstract interface q
{
  public abstract void a(int paramInt1, int paramInt2, b paramb, long paramLong, int paramInt3);
  
  public abstract MediaFormat b();
  
  @RequiresApi(23)
  public abstract void c(c paramc, Handler paramHandler);
  
  public abstract void d(int paramInt);
  
  @Nullable
  public abstract ByteBuffer e(int paramInt);
  
  @RequiresApi(23)
  public abstract void f(Surface paramSurface);
  
  public abstract void flush();
  
  public abstract void g(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4);
  
  public abstract boolean h();
  
  @RequiresApi(19)
  public abstract void i(Bundle paramBundle);
  
  @RequiresApi(21)
  public abstract void j(int paramInt, long paramLong);
  
  public abstract int k();
  
  public abstract int l(MediaCodec.BufferInfo paramBufferInfo);
  
  public abstract void m(int paramInt, boolean paramBoolean);
  
  @Nullable
  public abstract ByteBuffer n(int paramInt);
  
  public abstract void release();
  
  public static final class a
  {
    public final r a;
    public final MediaFormat b;
    public final Format c;
    @Nullable
    public final Surface d;
    @Nullable
    public final MediaCrypto e;
    public final int f;
    
    public a(r paramr, MediaFormat paramMediaFormat, Format paramFormat, @Nullable Surface paramSurface, @Nullable MediaCrypto paramMediaCrypto, int paramInt)
    {
      this.a = paramr;
      this.b = paramMediaFormat;
      this.c = paramFormat;
      this.d = paramSurface;
      this.e = paramMediaCrypto;
      this.f = paramInt;
    }
  }
  
  public static abstract interface b
  {
    public static final b a = new t.b();
    
    public abstract q a(q.a parama)
      throws IOException;
  }
  
  public static abstract interface c
  {
    public abstract void a(q paramq, long paramLong1, long paramLong2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\mediacodec\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */