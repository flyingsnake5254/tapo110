package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.b2.a;
import com.google.android.exoplayer2.c2;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.decoder.d;
import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.e2;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;
import com.google.android.exoplayer2.mediacodec.q;
import com.google.android.exoplayer2.mediacodec.q.a;
import com.google.android.exoplayer2.mediacodec.q.b;
import com.google.android.exoplayer2.mediacodec.r;
import com.google.android.exoplayer2.mediacodec.s;
import com.google.android.exoplayer2.t1;
import com.google.android.exoplayer2.u0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.w;
import com.google.android.exoplayer2.util.y;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class d0
  extends MediaCodecRenderer
  implements w
{
  private final Context e5;
  private final t.a f5;
  private final AudioSink g5;
  private int h5;
  private boolean i5;
  @Nullable
  private Format j5;
  private long k5;
  private boolean l5;
  private boolean m5;
  private boolean n5;
  private boolean o5;
  @Nullable
  private b2.a p5;
  
  public d0(Context paramContext, q.b paramb, s params, boolean paramBoolean, @Nullable Handler paramHandler, @Nullable t paramt, AudioSink paramAudioSink)
  {
    super(1, paramb, params, paramBoolean, 44100.0F);
    this.e5 = paramContext.getApplicationContext();
    this.g5 = paramAudioSink;
    this.f5 = new t.a(paramHandler, paramt);
    paramAudioSink.j(new b(null));
  }
  
  public d0(Context paramContext, s params, boolean paramBoolean, @Nullable Handler paramHandler, @Nullable t paramt, AudioSink paramAudioSink)
  {
    this(paramContext, q.b.a, params, paramBoolean, paramHandler, paramt, paramAudioSink);
  }
  
  private static boolean q1(String paramString)
  {
    if ((o0.a < 24) && ("OMX.SEC.aac.dec".equals(paramString)) && ("samsung".equals(o0.c)))
    {
      paramString = o0.b;
      if ((paramString.startsWith("zeroflte")) || (paramString.startsWith("herolte")) || (paramString.startsWith("heroqlte"))) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  private static boolean r1()
  {
    if (o0.a == 23)
    {
      String str = o0.d;
      if (("ZTE B2017G".equals(str)) || ("AXON 7 mini".equals(str))) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  private int s1(r paramr, Format paramFormat)
  {
    if ("OMX.google.raw.decoder".equals(paramr.a))
    {
      int i = o0.a;
      if ((i < 24) && ((i != 23) || (!o0.n0(this.e5)))) {
        return -1;
      }
    }
    return paramFormat.I3;
  }
  
  private void w1()
  {
    long l = this.g5.o(d());
    if (l != Long.MIN_VALUE)
    {
      if (!this.m5) {
        l = Math.max(this.k5, l);
      }
      this.k5 = l;
      this.m5 = false;
    }
  }
  
  /* Error */
  protected void E()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield 161	com/google/android/exoplayer2/audio/d0:n5	Z
    //   5: aload_0
    //   6: getfield 48	com/google/android/exoplayer2/audio/d0:g5	Lcom/google/android/exoplayer2/audio/AudioSink;
    //   9: invokeinterface 164 1 0
    //   14: aload_0
    //   15: invokespecial 166	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:E	()V
    //   18: aload_0
    //   19: getfield 55	com/google/android/exoplayer2/audio/d0:f5	Lcom/google/android/exoplayer2/audio/t$a;
    //   22: aload_0
    //   23: getfield 170	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:a5	Lcom/google/android/exoplayer2/decoder/d;
    //   26: invokevirtual 174	com/google/android/exoplayer2/audio/t$a:e	(Lcom/google/android/exoplayer2/decoder/d;)V
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 55	com/google/android/exoplayer2/audio/d0:f5	Lcom/google/android/exoplayer2/audio/t$a;
    //   35: aload_0
    //   36: getfield 170	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:a5	Lcom/google/android/exoplayer2/decoder/d;
    //   39: invokevirtual 174	com/google/android/exoplayer2/audio/t$a:e	(Lcom/google/android/exoplayer2/decoder/d;)V
    //   42: aload_1
    //   43: athrow
    //   44: astore_1
    //   45: aload_0
    //   46: invokespecial 166	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:E	()V
    //   49: aload_0
    //   50: getfield 55	com/google/android/exoplayer2/audio/d0:f5	Lcom/google/android/exoplayer2/audio/t$a;
    //   53: aload_0
    //   54: getfield 170	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:a5	Lcom/google/android/exoplayer2/decoder/d;
    //   57: invokevirtual 174	com/google/android/exoplayer2/audio/t$a:e	(Lcom/google/android/exoplayer2/decoder/d;)V
    //   60: aload_1
    //   61: athrow
    //   62: astore_1
    //   63: aload_0
    //   64: getfield 55	com/google/android/exoplayer2/audio/d0:f5	Lcom/google/android/exoplayer2/audio/t$a;
    //   67: aload_0
    //   68: getfield 170	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:a5	Lcom/google/android/exoplayer2/decoder/d;
    //   71: invokevirtual 174	com/google/android/exoplayer2/audio/t$a:e	(Lcom/google/android/exoplayer2/decoder/d;)V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	d0
    //   30	13	1	localObject1	Object
    //   44	17	1	localObject2	Object
    //   62	13	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   14	18	30	finally
    //   5	14	44	finally
    //   45	49	62	finally
  }
  
  protected void F(boolean paramBoolean1, boolean paramBoolean2)
    throws ExoPlaybackException
  {
    super.F(paramBoolean1, paramBoolean2);
    this.f5.f(this.a5);
    if (z().b) {
      this.g5.r();
    } else {
      this.g5.g();
    }
  }
  
  protected void G(long paramLong, boolean paramBoolean)
    throws ExoPlaybackException
  {
    super.G(paramLong, paramBoolean);
    if (this.o5) {
      this.g5.l();
    } else {
      this.g5.flush();
    }
    this.k5 = paramLong;
    this.l5 = true;
    this.m5 = true;
  }
  
  protected void H()
  {
    try
    {
      super.H();
      return;
    }
    finally
    {
      if (this.n5)
      {
        this.n5 = false;
        this.g5.reset();
      }
    }
  }
  
  protected void I()
  {
    super.I();
    this.g5.play();
  }
  
  protected void J()
  {
    w1();
    this.g5.pause();
    super.J();
  }
  
  protected void J0(Exception paramException)
  {
    u.d("MediaCodecAudioRenderer", "Audio codec error", paramException);
    this.f5.a(paramException);
  }
  
  protected void K0(String paramString, long paramLong1, long paramLong2)
  {
    this.f5.c(paramString, paramLong1, paramLong2);
  }
  
  protected void L0(String paramString)
  {
    this.f5.d(paramString);
  }
  
  @Nullable
  protected e M0(i1 parami1)
    throws ExoPlaybackException
  {
    e locale = super.M0(parami1);
    this.f5.g(parami1.b, locale);
    return locale;
  }
  
  protected void N0(Format paramFormat, @Nullable MediaFormat paramMediaFormat)
    throws ExoPlaybackException
  {
    Format localFormat1 = this.j5;
    Format localFormat2 = null;
    int[] arrayOfInt = null;
    if (localFormat1 != null)
    {
      paramFormat = localFormat1;
      paramMediaFormat = localFormat2;
    }
    else if (o0() == null)
    {
      paramMediaFormat = localFormat2;
    }
    else
    {
      int i;
      if ("audio/raw".equals(paramFormat.H3)) {
        i = paramFormat.W3;
      } else if ((o0.a >= 24) && (paramMediaFormat.containsKey("pcm-encoding"))) {
        i = paramMediaFormat.getInteger("pcm-encoding");
      } else if (paramMediaFormat.containsKey("v-bits-per-sample")) {
        i = o0.U(paramMediaFormat.getInteger("v-bits-per-sample"));
      } else if ("audio/raw".equals(paramFormat.H3)) {
        i = paramFormat.W3;
      } else {
        i = 2;
      }
      localFormat2 = new Format.b().e0("audio/raw").Y(i).M(paramFormat.X3).N(paramFormat.Y3).H(paramMediaFormat.getInteger("channel-count")).f0(paramMediaFormat.getInteger("sample-rate")).E();
      paramMediaFormat = arrayOfInt;
      if (this.i5)
      {
        paramMediaFormat = arrayOfInt;
        if (localFormat2.U3 == 6)
        {
          i = paramFormat.U3;
          paramMediaFormat = arrayOfInt;
          if (i < 6)
          {
            arrayOfInt = new int[i];
            for (i = 0;; i++)
            {
              paramMediaFormat = arrayOfInt;
              if (i >= paramFormat.U3) {
                break;
              }
              arrayOfInt[i] = i;
            }
          }
        }
      }
      paramFormat = localFormat2;
    }
    try
    {
      this.g5.s(paramFormat, 0, paramMediaFormat);
      return;
    }
    catch (AudioSink.ConfigurationException paramFormat)
    {
      throw x(paramFormat, paramFormat.format, 5001);
    }
  }
  
  protected e P(r paramr, Format paramFormat1, Format paramFormat2)
  {
    e locale = paramr.e(paramFormat1, paramFormat2);
    int i = locale.e;
    int j = i;
    if (s1(paramr, paramFormat2) > this.h5) {
      j = i | 0x40;
    }
    paramr = paramr.a;
    if (j != 0) {
      i = 0;
    } else {
      i = locale.d;
    }
    return new e(paramr, paramFormat1, paramFormat2, i, j);
  }
  
  protected void P0()
  {
    super.P0();
    this.g5.p();
  }
  
  protected void Q0(DecoderInputBuffer paramDecoderInputBuffer)
  {
    if ((this.l5) && (!paramDecoderInputBuffer.j()))
    {
      if (Math.abs(paramDecoderInputBuffer.x - this.k5) > 500000L) {
        this.k5 = paramDecoderInputBuffer.x;
      }
      this.l5 = false;
    }
  }
  
  protected boolean S0(long paramLong1, long paramLong2, @Nullable q paramq, @Nullable ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, long paramLong3, boolean paramBoolean1, boolean paramBoolean2, Format paramFormat)
    throws ExoPlaybackException
  {
    g.e(paramByteBuffer);
    if ((this.j5 != null) && ((paramInt2 & 0x2) != 0))
    {
      ((q)g.e(paramq)).m(paramInt1, false);
      return true;
    }
    if (paramBoolean1)
    {
      if (paramq != null) {
        paramq.m(paramInt1, false);
      }
      paramq = this.a5;
      paramq.f += paramInt3;
      this.g5.p();
      return true;
    }
    try
    {
      paramBoolean1 = this.g5.i(paramByteBuffer, paramLong3, paramInt3);
      if (paramBoolean1)
      {
        if (paramq != null) {
          paramq.m(paramInt1, false);
        }
        paramq = this.a5;
        paramq.e += paramInt3;
        return true;
      }
      return false;
    }
    catch (AudioSink.WriteException paramq)
    {
      throw y(paramq, paramFormat, paramq.isRecoverable, 5002);
    }
    catch (AudioSink.InitializationException paramq)
    {
      throw y(paramq, paramq.format, paramq.isRecoverable, 5001);
    }
  }
  
  protected void X0()
    throws ExoPlaybackException
  {
    try
    {
      this.g5.n();
      return;
    }
    catch (AudioSink.WriteException localWriteException)
    {
      throw y(localWriteException, localWriteException.format, localWriteException.isRecoverable, 5002);
    }
  }
  
  public t1 c()
  {
    return this.g5.c();
  }
  
  public boolean d()
  {
    boolean bool;
    if ((super.d()) && (this.g5.d())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void e(t1 paramt1)
  {
    this.g5.e(paramt1);
  }
  
  public boolean g()
  {
    boolean bool;
    if ((!this.g5.b()) && (!super.g())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public String getName()
  {
    return "MediaCodecAudioRenderer";
  }
  
  protected boolean i1(Format paramFormat)
  {
    return this.g5.a(paramFormat);
  }
  
  protected int j1(s params, Format paramFormat)
    throws MediaCodecUtil.DecoderQueryException
  {
    if (!y.o(paramFormat.H3)) {
      return c2.a(0);
    }
    int i;
    if (o0.a >= 21) {
      i = 32;
    } else {
      i = 0;
    }
    if (paramFormat.a4 != null) {
      j = 1;
    } else {
      j = 0;
    }
    boolean bool = MediaCodecRenderer.k1(paramFormat);
    int k = 8;
    int m = 4;
    if ((bool) && (this.g5.a(paramFormat)) && ((j == 0) || (MediaCodecUtil.q() != null))) {
      return c2.b(4, 8, i);
    }
    if (("audio/raw".equals(paramFormat.H3)) && (!this.g5.a(paramFormat))) {
      return c2.a(1);
    }
    if (!this.g5.a(o0.V(2, paramFormat.U3, paramFormat.V3))) {
      return c2.a(1);
    }
    params = t0(params, paramFormat, false);
    if (params.isEmpty()) {
      return c2.a(1);
    }
    if (!bool) {
      return c2.a(2);
    }
    params = (r)params.get(0);
    bool = params.m(paramFormat);
    int j = k;
    if (bool)
    {
      j = k;
      if (params.o(paramFormat)) {
        j = 16;
      }
    }
    if (!bool) {
      m = 3;
    }
    return c2.b(m, j, i);
  }
  
  public void k(int paramInt, @Nullable Object paramObject)
    throws ExoPlaybackException
  {
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 5)
        {
          switch (paramInt)
          {
          default: 
            super.k(paramInt, paramObject);
            break;
          case 103: 
            this.p5 = ((b2.a)paramObject);
            break;
          case 102: 
            this.g5.f(((Integer)paramObject).intValue());
            break;
          case 101: 
            this.g5.t(((Boolean)paramObject).booleanValue());
            break;
          }
        }
        else
        {
          paramObject = (x)paramObject;
          this.g5.m((x)paramObject);
        }
      }
      else
      {
        paramObject = (p)paramObject;
        this.g5.h((p)paramObject);
      }
    }
    else {
      this.g5.q(((Float)paramObject).floatValue());
    }
  }
  
  public long p()
  {
    if (getState() == 2) {
      w1();
    }
    return this.k5;
  }
  
  protected float r0(float paramFloat, Format paramFormat, Format[] paramArrayOfFormat)
  {
    int i = paramArrayOfFormat.length;
    int j = 0;
    int n;
    for (int k = -1; j < i; k = n)
    {
      int m = paramArrayOfFormat[j].V3;
      n = k;
      if (m != -1) {
        n = Math.max(k, m);
      }
      j++;
    }
    if (k == -1) {
      paramFloat = -1.0F;
    } else {
      paramFloat *= k;
    }
    return paramFloat;
  }
  
  protected List<r> t0(s params, Format paramFormat, boolean paramBoolean)
    throws MediaCodecUtil.DecoderQueryException
  {
    String str = paramFormat.H3;
    if (str == null) {
      return Collections.emptyList();
    }
    if (this.g5.a(paramFormat))
    {
      localObject = MediaCodecUtil.q();
      if (localObject != null) {
        return Collections.singletonList(localObject);
      }
    }
    Object localObject = MediaCodecUtil.p(params.a(str, paramBoolean, false), paramFormat);
    paramFormat = (Format)localObject;
    if ("audio/eac3-joc".equals(str))
    {
      paramFormat = new ArrayList((Collection)localObject);
      paramFormat.addAll(params.a("audio/eac3", paramBoolean, false));
    }
    return Collections.unmodifiableList(paramFormat);
  }
  
  protected int t1(r paramr, Format paramFormat, Format[] paramArrayOfFormat)
  {
    int i = s1(paramr, paramFormat);
    if (paramArrayOfFormat.length == 1) {
      return i;
    }
    int j = paramArrayOfFormat.length;
    int k = 0;
    while (k < j)
    {
      Format localFormat = paramArrayOfFormat[k];
      int m = i;
      if (paramr.e(paramFormat, localFormat).d != 0) {
        m = Math.max(i, s1(paramr, localFormat));
      }
      k++;
      i = m;
    }
    return i;
  }
  
  @SuppressLint({"InlinedApi"})
  protected MediaFormat u1(Format paramFormat, String paramString, int paramInt, float paramFloat)
  {
    MediaFormat localMediaFormat = new MediaFormat();
    localMediaFormat.setString("mime", paramString);
    localMediaFormat.setInteger("channel-count", paramFormat.U3);
    localMediaFormat.setInteger("sample-rate", paramFormat.V3);
    com.google.android.exoplayer2.util.x.e(localMediaFormat, paramFormat.J3);
    com.google.android.exoplayer2.util.x.d(localMediaFormat, "max-input-size", paramInt);
    paramInt = o0.a;
    if (paramInt >= 23)
    {
      localMediaFormat.setInteger("priority", 0);
      if ((paramFloat != -1.0F) && (!r1())) {
        localMediaFormat.setFloat("operating-rate", paramFloat);
      }
    }
    if ((paramInt <= 28) && ("audio/ac4".equals(paramFormat.H3))) {
      localMediaFormat.setInteger("ac4-is-sync", 1);
    }
    if ((paramInt >= 24) && (this.g5.k(o0.V(4, paramFormat.U3, paramFormat.V3)) == 2)) {
      localMediaFormat.setInteger("pcm-encoding", 4);
    }
    return localMediaFormat;
  }
  
  protected q.a v0(r paramr, Format paramFormat, @Nullable MediaCrypto paramMediaCrypto, float paramFloat)
  {
    this.h5 = t1(paramr, paramFormat, C());
    this.i5 = q1(paramr.a);
    MediaFormat localMediaFormat = u1(paramFormat, paramr.c, this.h5, paramFloat);
    int i;
    if (("audio/raw".equals(paramr.b)) && (!"audio/raw".equals(paramFormat.H3))) {
      i = 1;
    } else {
      i = 0;
    }
    Format localFormat;
    if (i != 0) {
      localFormat = paramFormat;
    } else {
      localFormat = null;
    }
    this.j5 = localFormat;
    return new q.a(paramr, localMediaFormat, paramFormat, null, paramMediaCrypto, 0);
  }
  
  @CallSuper
  protected void v1()
  {
    this.m5 = true;
  }
  
  @Nullable
  public w w()
  {
    return this;
  }
  
  private final class b
    implements AudioSink.a
  {
    private b() {}
    
    public void a(boolean paramBoolean)
    {
      d0.o1(d0.this).C(paramBoolean);
    }
    
    public void b(Exception paramException)
    {
      u.d("MediaCodecAudioRenderer", "Audio sink error", paramException);
      d0.o1(d0.this).b(paramException);
    }
    
    public void c(long paramLong)
    {
      d0.o1(d0.this).B(paramLong);
    }
    
    public void d(long paramLong)
    {
      if (d0.p1(d0.this) != null) {
        d0.p1(d0.this).b(paramLong);
      }
    }
    
    public void e(int paramInt, long paramLong1, long paramLong2)
    {
      d0.o1(d0.this).D(paramInt, paramLong1, paramLong2);
    }
    
    public void f()
    {
      d0.this.v1();
    }
    
    public void g()
    {
      if (d0.p1(d0.this) != null) {
        d0.p1(d0.this).a();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\d0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */