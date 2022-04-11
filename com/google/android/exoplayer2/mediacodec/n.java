package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayDeque;

@RequiresApi(23)
final class n
  extends MediaCodec.Callback
{
  private final Object a = new Object();
  private final HandlerThread b;
  private Handler c;
  @GuardedBy("lock")
  private final s d;
  @GuardedBy("lock")
  private final s e;
  @GuardedBy("lock")
  private final ArrayDeque<MediaCodec.BufferInfo> f;
  @GuardedBy("lock")
  private final ArrayDeque<MediaFormat> g;
  @GuardedBy("lock")
  @Nullable
  private MediaFormat h;
  @GuardedBy("lock")
  @Nullable
  private MediaFormat i;
  @GuardedBy("lock")
  @Nullable
  private MediaCodec.CodecException j;
  @GuardedBy("lock")
  private long k;
  @GuardedBy("lock")
  private boolean l;
  @GuardedBy("lock")
  @Nullable
  private IllegalStateException m;
  
  n(HandlerThread paramHandlerThread)
  {
    this.b = paramHandlerThread;
    this.d = new s();
    this.e = new s();
    this.f = new ArrayDeque();
    this.g = new ArrayDeque();
  }
  
  @GuardedBy("lock")
  private void a(MediaFormat paramMediaFormat)
  {
    this.e.a(-2);
    this.g.add(paramMediaFormat);
  }
  
  @GuardedBy("lock")
  private void e()
  {
    if (!this.g.isEmpty()) {
      this.i = ((MediaFormat)this.g.getLast());
    }
    this.d.b();
    this.e.b();
    this.f.clear();
    this.g.clear();
    this.j = null;
  }
  
  @GuardedBy("lock")
  private boolean h()
  {
    boolean bool;
    if ((this.k <= 0L) && (!this.l)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @GuardedBy("lock")
  private void k()
  {
    l();
    m();
  }
  
  @GuardedBy("lock")
  private void l()
  {
    IllegalStateException localIllegalStateException = this.m;
    if (localIllegalStateException == null) {
      return;
    }
    this.m = null;
    throw localIllegalStateException;
  }
  
  @GuardedBy("lock")
  private void m()
  {
    MediaCodec.CodecException localCodecException = this.j;
    if (localCodecException == null) {
      return;
    }
    this.j = null;
    throw localCodecException;
  }
  
  private void n(Runnable paramRunnable)
  {
    synchronized (this.a)
    {
      o(paramRunnable);
      return;
    }
  }
  
  @GuardedBy("lock")
  private void o(Runnable paramRunnable)
  {
    if (this.l) {
      return;
    }
    long l1 = this.k - 1L;
    this.k = l1;
    if (l1 > 0L) {
      return;
    }
    if (l1 < 0L)
    {
      p(new IllegalStateException());
      return;
    }
    e();
    try
    {
      paramRunnable.run();
    }
    catch (Exception paramRunnable)
    {
      p(new IllegalStateException(paramRunnable));
    }
    catch (IllegalStateException paramRunnable)
    {
      p(paramRunnable);
    }
  }
  
  private void p(IllegalStateException paramIllegalStateException)
  {
    synchronized (this.a)
    {
      this.m = paramIllegalStateException;
      return;
    }
  }
  
  public int b()
  {
    synchronized (this.a)
    {
      boolean bool = h();
      int n = -1;
      if (bool) {
        return -1;
      }
      k();
      if (!this.d.d()) {
        n = this.d.e();
      }
      return n;
    }
  }
  
  public int c(MediaCodec.BufferInfo paramBufferInfo)
  {
    synchronized (this.a)
    {
      if (h()) {
        return -1;
      }
      k();
      if (this.e.d()) {
        return -1;
      }
      int n = this.e.e();
      if (n >= 0)
      {
        g.i(this.h);
        MediaCodec.BufferInfo localBufferInfo = (MediaCodec.BufferInfo)this.f.remove();
        paramBufferInfo.set(localBufferInfo.offset, localBufferInfo.size, localBufferInfo.presentationTimeUs, localBufferInfo.flags);
      }
      else if (n == -2)
      {
        this.h = ((MediaFormat)this.g.remove());
      }
      return n;
    }
  }
  
  public void d(Runnable paramRunnable)
  {
    synchronized (this.a)
    {
      this.k += 1L;
      Handler localHandler = (Handler)o0.i(this.c);
      d locald = new com/google/android/exoplayer2/mediacodec/d;
      locald.<init>(this, paramRunnable);
      localHandler.post(locald);
      return;
    }
  }
  
  public MediaFormat f()
  {
    synchronized (this.a)
    {
      Object localObject2 = this.h;
      if (localObject2 != null) {
        return (MediaFormat)localObject2;
      }
      localObject2 = new java/lang/IllegalStateException;
      ((IllegalStateException)localObject2).<init>();
      throw ((Throwable)localObject2);
    }
  }
  
  public void g(MediaCodec paramMediaCodec)
  {
    boolean bool;
    if (this.c == null) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    this.b.start();
    Handler localHandler = new Handler(this.b.getLooper());
    paramMediaCodec.setCallback(this, localHandler);
    this.c = localHandler;
  }
  
  public void onError(@NonNull MediaCodec arg1, @NonNull MediaCodec.CodecException paramCodecException)
  {
    synchronized (this.a)
    {
      this.j = paramCodecException;
      return;
    }
  }
  
  public void onInputBufferAvailable(@NonNull MediaCodec paramMediaCodec, int paramInt)
  {
    synchronized (this.a)
    {
      this.d.a(paramInt);
      return;
    }
  }
  
  public void onOutputBufferAvailable(@NonNull MediaCodec arg1, int paramInt, @NonNull MediaCodec.BufferInfo paramBufferInfo)
  {
    synchronized (this.a)
    {
      MediaFormat localMediaFormat = this.i;
      if (localMediaFormat != null)
      {
        a(localMediaFormat);
        this.i = null;
      }
      this.e.a(paramInt);
      this.f.add(paramBufferInfo);
      return;
    }
  }
  
  public void onOutputFormatChanged(@NonNull MediaCodec arg1, @NonNull MediaFormat paramMediaFormat)
  {
    synchronized (this.a)
    {
      a(paramMediaFormat);
      this.i = null;
      return;
    }
  }
  
  public void q()
  {
    synchronized (this.a)
    {
      this.l = true;
      this.b.quit();
      e();
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\mediacodec\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */