package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.decoder.b;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.o0;
import com.google.common.base.c;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

@RequiresApi(23)
class m
{
  @GuardedBy("MESSAGE_PARAMS_INSTANCE_POOL")
  private static final ArrayDeque<b> a = new ArrayDeque();
  private static final Object b = new Object();
  private final MediaCodec c;
  private final HandlerThread d;
  private Handler e;
  private final AtomicReference<RuntimeException> f;
  private final k g;
  private final boolean h;
  private boolean i;
  
  public m(MediaCodec paramMediaCodec, HandlerThread paramHandlerThread, boolean paramBoolean)
  {
    this(paramMediaCodec, paramHandlerThread, paramBoolean, new k());
  }
  
  @VisibleForTesting
  m(MediaCodec paramMediaCodec, HandlerThread paramHandlerThread, boolean paramBoolean, k paramk)
  {
    this.c = paramMediaCodec;
    this.d = paramHandlerThread;
    this.g = paramk;
    this.f = new AtomicReference();
    if ((!paramBoolean) && (!m())) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    this.h = paramBoolean;
  }
  
  private void b()
    throws InterruptedException
  {
    this.g.c();
    ((Handler)o0.i(this.e)).obtainMessage(2).sendToTarget();
    this.g.a();
  }
  
  private static void c(b paramb, MediaCodec.CryptoInfo paramCryptoInfo)
  {
    paramCryptoInfo.numSubSamples = paramb.f;
    paramCryptoInfo.numBytesOfClearData = e(paramb.d, paramCryptoInfo.numBytesOfClearData);
    paramCryptoInfo.numBytesOfEncryptedData = e(paramb.e, paramCryptoInfo.numBytesOfEncryptedData);
    paramCryptoInfo.key = ((byte[])g.e(d(paramb.b, paramCryptoInfo.key)));
    paramCryptoInfo.iv = ((byte[])g.e(d(paramb.a, paramCryptoInfo.iv)));
    paramCryptoInfo.mode = paramb.c;
    if (o0.a >= 24) {
      paramCryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(paramb.g, paramb.h));
    }
  }
  
  @Nullable
  private static byte[] d(@Nullable byte[] paramArrayOfByte1, @Nullable byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == null) {
      return paramArrayOfByte2;
    }
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length >= paramArrayOfByte1.length))
    {
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte1.length);
      return paramArrayOfByte2;
    }
    return Arrays.copyOf(paramArrayOfByte1, paramArrayOfByte1.length);
  }
  
  @Nullable
  private static int[] e(@Nullable int[] paramArrayOfInt1, @Nullable int[] paramArrayOfInt2)
  {
    if (paramArrayOfInt1 == null) {
      return paramArrayOfInt2;
    }
    if ((paramArrayOfInt2 != null) && (paramArrayOfInt2.length >= paramArrayOfInt1.length))
    {
      System.arraycopy(paramArrayOfInt1, 0, paramArrayOfInt2, 0, paramArrayOfInt1.length);
      return paramArrayOfInt2;
    }
    return Arrays.copyOf(paramArrayOfInt1, paramArrayOfInt1.length);
  }
  
  private void f(Message paramMessage)
  {
    int j = paramMessage.what;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2) {
          q(new IllegalStateException(String.valueOf(paramMessage.what)));
        } else {
          this.g.e();
        }
        paramMessage = null;
      }
      else
      {
        paramMessage = (b)paramMessage.obj;
        h(paramMessage.a, paramMessage.b, paramMessage.d, paramMessage.e, paramMessage.f);
      }
    }
    else
    {
      paramMessage = (b)paramMessage.obj;
      g(paramMessage.a, paramMessage.b, paramMessage.c, paramMessage.e, paramMessage.f);
    }
    if (paramMessage != null) {
      p(paramMessage);
    }
  }
  
  private void g(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    try
    {
      this.c.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
    }
    catch (RuntimeException localRuntimeException)
    {
      q(localRuntimeException);
    }
  }
  
  private void h(int paramInt1, int paramInt2, MediaCodec.CryptoInfo paramCryptoInfo, long paramLong, int paramInt3)
  {
    try
    {
      if (this.h) {
        synchronized (b)
        {
          this.c.queueSecureInputBuffer(paramInt1, paramInt2, paramCryptoInfo, paramLong, paramInt3);
        }
      }
      this.c.queueSecureInputBuffer(paramInt1, paramInt2, paramCryptoInfo, paramLong, paramInt3);
    }
    catch (RuntimeException paramCryptoInfo)
    {
      q(paramCryptoInfo);
    }
  }
  
  private void j()
    throws InterruptedException
  {
    ((Handler)o0.i(this.e)).removeCallbacksAndMessages(null);
    b();
    l();
  }
  
  private static b k()
  {
    synchronized (a)
    {
      if (???.isEmpty())
      {
        localb = new com/google/android/exoplayer2/mediacodec/m$b;
        localb.<init>();
        return localb;
      }
      b localb = (b)???.removeFirst();
      return localb;
    }
  }
  
  private void l()
  {
    RuntimeException localRuntimeException = (RuntimeException)this.f.getAndSet(null);
    if (localRuntimeException == null) {
      return;
    }
    throw localRuntimeException;
  }
  
  private static boolean m()
  {
    String str = c.e(o0.c);
    boolean bool;
    if ((!str.contains("samsung")) && (!str.contains("motorola"))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private static void p(b paramb)
  {
    synchronized (a)
    {
      ???.add(paramb);
      return;
    }
  }
  
  public void i()
  {
    if (this.i) {
      try
      {
        j();
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        throw new IllegalStateException(localInterruptedException);
      }
    }
  }
  
  public void n(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    l();
    b localb = k();
    localb.a(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
    ((Handler)o0.i(this.e)).obtainMessage(0, localb).sendToTarget();
  }
  
  public void o(int paramInt1, int paramInt2, b paramb, long paramLong, int paramInt3)
  {
    l();
    b localb = k();
    localb.a(paramInt1, paramInt2, 0, paramLong, paramInt3);
    c(paramb, localb.d);
    ((Handler)o0.i(this.e)).obtainMessage(1, localb).sendToTarget();
  }
  
  @VisibleForTesting
  void q(RuntimeException paramRuntimeException)
  {
    this.f.set(paramRuntimeException);
  }
  
  public void r()
  {
    if (this.i)
    {
      i();
      this.d.quit();
    }
    this.i = false;
  }
  
  public void s()
  {
    if (!this.i)
    {
      this.d.start();
      this.e = new a(this.d.getLooper());
      this.i = true;
    }
  }
  
  public void t()
    throws InterruptedException
  {
    b();
  }
  
  class a
    extends Handler
  {
    a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      m.a(m.this, paramMessage);
    }
  }
  
  private static class b
  {
    public int a;
    public int b;
    public int c;
    public final MediaCodec.CryptoInfo d = new MediaCodec.CryptoInfo();
    public long e;
    public int f;
    
    public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.e = paramLong;
      this.f = paramInt4;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\mediacodec\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */