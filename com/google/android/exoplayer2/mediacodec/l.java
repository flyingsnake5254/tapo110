package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.util.m0;
import com.google.common.base.t;
import java.nio.ByteBuffer;
import java.util.Objects;

@RequiresApi(23)
final class l
  implements q
{
  private final MediaCodec a;
  private final n b;
  private final m c;
  private final boolean d;
  private boolean e;
  private int f;
  
  private l(MediaCodec paramMediaCodec, HandlerThread paramHandlerThread1, HandlerThread paramHandlerThread2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramMediaCodec;
    this.b = new n(paramHandlerThread1);
    this.c = new m(paramMediaCodec, paramHandlerThread2, paramBoolean1);
    this.d = paramBoolean2;
    this.f = 0;
  }
  
  private static String r(int paramInt)
  {
    return t(paramInt, "ExoPlayer:MediaCodecAsyncAdapter:");
  }
  
  private static String s(int paramInt)
  {
    return t(paramInt, "ExoPlayer:MediaCodecQueueingThread:");
  }
  
  private static String t(int paramInt, String paramString)
  {
    paramString = new StringBuilder(paramString);
    if (paramInt == 1)
    {
      paramString.append("Audio");
    }
    else if (paramInt == 2)
    {
      paramString.append("Video");
    }
    else
    {
      paramString.append("Unknown(");
      paramString.append(paramInt);
      paramString.append(")");
    }
    return paramString.toString();
  }
  
  private void u(@Nullable MediaFormat paramMediaFormat, @Nullable Surface paramSurface, @Nullable MediaCrypto paramMediaCrypto, int paramInt)
  {
    this.b.g(this.a);
    m0.a("configureCodec");
    this.a.configure(paramMediaFormat, paramSurface, paramMediaCrypto, paramInt);
    m0.c();
    this.c.s();
    m0.a("startCodec");
    this.a.start();
    m0.c();
    this.f = 1;
  }
  
  private void x()
  {
    if (this.d) {
      try
      {
        this.c.t();
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        throw new IllegalStateException(localInterruptedException);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, com.google.android.exoplayer2.decoder.b paramb, long paramLong, int paramInt3)
  {
    this.c.o(paramInt1, paramInt2, paramb, paramLong, paramInt3);
  }
  
  public MediaFormat b()
  {
    return this.b.f();
  }
  
  public void c(q.c paramc, Handler paramHandler)
  {
    x();
    this.a.setOnFrameRenderedListener(new c(this, paramc), paramHandler);
  }
  
  public void d(int paramInt)
  {
    x();
    this.a.setVideoScalingMode(paramInt);
  }
  
  @Nullable
  public ByteBuffer e(int paramInt)
  {
    return this.a.getInputBuffer(paramInt);
  }
  
  public void f(Surface paramSurface)
  {
    x();
    this.a.setOutputSurface(paramSurface);
  }
  
  public void flush()
  {
    this.c.i();
    this.a.flush();
    n localn = this.b;
    MediaCodec localMediaCodec = this.a;
    Objects.requireNonNull(localMediaCodec);
    localn.d(new j(localMediaCodec));
  }
  
  public void g(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    this.c.n(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
  }
  
  public boolean h()
  {
    return false;
  }
  
  public void i(Bundle paramBundle)
  {
    x();
    this.a.setParameters(paramBundle);
  }
  
  public void j(int paramInt, long paramLong)
  {
    this.a.releaseOutputBuffer(paramInt, paramLong);
  }
  
  public int k()
  {
    return this.b.b();
  }
  
  public int l(MediaCodec.BufferInfo paramBufferInfo)
  {
    return this.b.c(paramBufferInfo);
  }
  
  public void m(int paramInt, boolean paramBoolean)
  {
    this.a.releaseOutputBuffer(paramInt, paramBoolean);
  }
  
  @Nullable
  public ByteBuffer n(int paramInt)
  {
    return this.a.getOutputBuffer(paramInt);
  }
  
  public void release()
  {
    try
    {
      if (this.f == 1)
      {
        this.c.r();
        this.b.q();
      }
      this.f = 2;
      return;
    }
    finally
    {
      if (!this.e)
      {
        this.a.release();
        this.e = true;
      }
    }
  }
  
  public static final class b
    implements q.b
  {
    private final t<HandlerThread> b;
    private final t<HandlerThread> c;
    private final boolean d;
    private final boolean e;
    
    public b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      this(new a(paramInt), new b(paramInt), paramBoolean1, paramBoolean2);
    }
    
    @VisibleForTesting
    b(t<HandlerThread> paramt1, t<HandlerThread> paramt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.b = paramt1;
      this.c = paramt2;
      this.d = paramBoolean1;
      this.e = paramBoolean2;
    }
    
    /* Error */
    public l b(q.a parama)
      throws java.io.IOException
    {
      // Byte code:
      //   0: aload_1
      //   1: getfield 72	com/google/android/exoplayer2/mediacodec/q$a:a	Lcom/google/android/exoplayer2/mediacodec/r;
      //   4: getfield 77	com/google/android/exoplayer2/mediacodec/r:a	Ljava/lang/String;
      //   7: astore_2
      //   8: aconst_null
      //   9: astore_3
      //   10: aload_2
      //   11: invokestatic 83	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   14: astore 4
      //   16: aload 4
      //   18: invokevirtual 87	java/lang/String:length	()I
      //   21: ifeq +15 -> 36
      //   24: ldc 89
      //   26: aload 4
      //   28: invokevirtual 93	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   31: astore 4
      //   33: goto +14 -> 47
      //   36: new 79	java/lang/String
      //   39: dup
      //   40: ldc 89
      //   42: invokespecial 94	java/lang/String:<init>	(Ljava/lang/String;)V
      //   45: astore 4
      //   47: aload 4
      //   49: invokestatic 98	com/google/android/exoplayer2/util/m0:a	(Ljava/lang/String;)V
      //   52: aload_2
      //   53: invokestatic 104	android/media/MediaCodec:createByCodecName	(Ljava/lang/String;)Landroid/media/MediaCodec;
      //   56: astore 4
      //   58: new 8	com/google/android/exoplayer2/mediacodec/l
      //   61: astore_2
      //   62: aload_2
      //   63: aload 4
      //   65: aload_0
      //   66: getfield 35	com/google/android/exoplayer2/mediacodec/l$b:b	Lcom/google/common/base/t;
      //   69: invokeinterface 110 1 0
      //   74: checkcast 47	android/os/HandlerThread
      //   77: aload_0
      //   78: getfield 37	com/google/android/exoplayer2/mediacodec/l$b:c	Lcom/google/common/base/t;
      //   81: invokeinterface 110 1 0
      //   86: checkcast 47	android/os/HandlerThread
      //   89: aload_0
      //   90: getfield 39	com/google/android/exoplayer2/mediacodec/l$b:d	Z
      //   93: aload_0
      //   94: getfield 41	com/google/android/exoplayer2/mediacodec/l$b:e	Z
      //   97: aconst_null
      //   98: invokespecial 113	com/google/android/exoplayer2/mediacodec/l:<init>	(Landroid/media/MediaCodec;Landroid/os/HandlerThread;Landroid/os/HandlerThread;ZZLcom/google/android/exoplayer2/mediacodec/l$a;)V
      //   101: invokestatic 115	com/google/android/exoplayer2/util/m0:c	()V
      //   104: aload_2
      //   105: aload_1
      //   106: getfield 118	com/google/android/exoplayer2/mediacodec/q$a:b	Landroid/media/MediaFormat;
      //   109: aload_1
      //   110: getfield 121	com/google/android/exoplayer2/mediacodec/q$a:d	Landroid/view/Surface;
      //   113: aload_1
      //   114: getfield 124	com/google/android/exoplayer2/mediacodec/q$a:e	Landroid/media/MediaCrypto;
      //   117: aload_1
      //   118: getfield 128	com/google/android/exoplayer2/mediacodec/q$a:f	I
      //   121: invokestatic 132	com/google/android/exoplayer2/mediacodec/l:o	(Lcom/google/android/exoplayer2/mediacodec/l;Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
      //   124: aload_2
      //   125: areturn
      //   126: astore_1
      //   127: aload_2
      //   128: astore_3
      //   129: goto +11 -> 140
      //   132: astore_1
      //   133: goto +7 -> 140
      //   136: astore_1
      //   137: aconst_null
      //   138: astore 4
      //   140: aload_3
      //   141: ifnonnull +16 -> 157
      //   144: aload 4
      //   146: ifnull +15 -> 161
      //   149: aload 4
      //   151: invokevirtual 135	android/media/MediaCodec:release	()V
      //   154: goto +7 -> 161
      //   157: aload_3
      //   158: invokevirtual 136	com/google/android/exoplayer2/mediacodec/l:release	()V
      //   161: aload_1
      //   162: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	163	0	this	b
      //   0	163	1	parama	q.a
      //   7	121	2	localObject1	Object
      //   9	149	3	localObject2	Object
      //   14	136	4	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   101	124	126	java/lang/Exception
      //   58	101	132	java/lang/Exception
      //   10	33	136	java/lang/Exception
      //   36	47	136	java/lang/Exception
      //   47	58	136	java/lang/Exception
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\mediacodec\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */