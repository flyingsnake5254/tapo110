package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.CallSuper;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer.InsufficientCapacityException;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.decoder.b;
import com.google.android.exoplayer2.decoder.d;
import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSession.DrmSessionException;
import com.google.android.exoplayer2.drm.f0;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.u0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.k0;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.z;
import com.google.android.exoplayer2.w0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public abstract class MediaCodecRenderer
  extends u0
{
  private static final byte[] I3 = { 0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120 };
  private long A4;
  private int B4;
  private int C4;
  @Nullable
  private ByteBuffer D4;
  private boolean E4;
  private boolean F4;
  private boolean G4;
  private boolean H4;
  private boolean I4;
  private final q.b J3;
  private boolean J4;
  private final s K3;
  private int K4;
  private final boolean L3;
  private int L4;
  private final float M3;
  private int M4;
  private final DecoderInputBuffer N3;
  private boolean N4;
  private final DecoderInputBuffer O3;
  private boolean O4;
  private final DecoderInputBuffer P3;
  private boolean P4;
  private final o Q3;
  private long Q4;
  private final k0<Format> R3;
  private long R4;
  private final ArrayList<Long> S3;
  private boolean S4;
  private final MediaCodec.BufferInfo T3;
  private boolean T4;
  private final long[] U3;
  private boolean U4;
  private final long[] V3;
  private boolean V4;
  private final long[] W3;
  private boolean W4;
  @Nullable
  private Format X3;
  private boolean X4;
  @Nullable
  private Format Y3;
  private boolean Y4;
  @Nullable
  private DrmSession Z3;
  @Nullable
  private ExoPlaybackException Z4;
  @Nullable
  private DrmSession a4;
  protected d a5;
  @Nullable
  private MediaCrypto b4;
  private long b5;
  private boolean c4;
  private long c5;
  private long d4;
  private int d5;
  private float e4;
  private float f4;
  @Nullable
  private q g4;
  @Nullable
  private Format h4;
  @Nullable
  private MediaFormat i4;
  private boolean j4;
  private float k4;
  @Nullable
  private ArrayDeque<r> l4;
  @Nullable
  private DecoderInitializationException m4;
  @Nullable
  private r n4;
  private int o4;
  private boolean p4;
  private boolean q4;
  private boolean r4;
  private boolean s4;
  private boolean t4;
  private boolean u4;
  private boolean v4;
  private boolean w4;
  private boolean x4;
  private boolean y4;
  @Nullable
  private p z4;
  
  public MediaCodecRenderer(int paramInt, q.b paramb, s params, boolean paramBoolean, float paramFloat)
  {
    super(paramInt);
    this.J3 = paramb;
    this.K3 = ((s)g.e(params));
    this.L3 = paramBoolean;
    this.M3 = paramFloat;
    this.N3 = DecoderInputBuffer.r();
    this.O3 = new DecoderInputBuffer(0);
    this.P3 = new DecoderInputBuffer(2);
    paramb = new o();
    this.Q3 = paramb;
    this.R3 = new k0();
    this.S3 = new ArrayList();
    this.T3 = new MediaCodec.BufferInfo();
    this.e4 = 1.0F;
    this.f4 = 1.0F;
    this.d4 = -9223372036854775807L;
    this.U3 = new long[10];
    this.V3 = new long[10];
    this.W3 = new long[10];
    this.b5 = -9223372036854775807L;
    this.c5 = -9223372036854775807L;
    paramb.o(0);
    paramb.f.order(ByteOrder.nativeOrder());
    this.k4 = -1.0F;
    this.o4 = 0;
    this.K4 = 0;
    this.B4 = -1;
    this.C4 = -1;
    this.A4 = -9223372036854775807L;
    this.Q4 = -9223372036854775807L;
    this.R4 = -9223372036854775807L;
    this.L4 = 0;
    this.M4 = 0;
  }
  
  private void A0(Format paramFormat)
  {
    a0();
    paramFormat = paramFormat.H3;
    if ((!"audio/mp4a-latm".equals(paramFormat)) && (!"audio/mpeg".equals(paramFormat)) && (!"audio/opus".equals(paramFormat))) {
      this.Q3.z(1);
    } else {
      this.Q3.z(32);
    }
    this.G4 = true;
  }
  
  private void B0(r paramr, MediaCrypto paramMediaCrypto)
    throws Exception
  {
    String str1 = paramr.a;
    int i = o0.a;
    float f1 = -1.0F;
    float f2;
    if (i < 23) {
      f2 = -1.0F;
    } else {
      f2 = r0(this.f4, this.X3, C());
    }
    if (f2 <= this.M3) {
      f2 = f1;
    }
    long l1 = SystemClock.elapsedRealtime();
    String str2 = String.valueOf(str1);
    if (str2.length() != 0) {
      str2 = "createCodec:".concat(str2);
    } else {
      str2 = new String("createCodec:");
    }
    m0.a(str2);
    paramMediaCrypto = v0(paramr, this.X3, paramMediaCrypto, f2);
    if ((this.W4) && (i >= 23)) {
      paramMediaCrypto = new l.b(f(), this.X4, this.Y4).b(paramMediaCrypto);
    } else {
      paramMediaCrypto = this.J3.a(paramMediaCrypto);
    }
    long l2 = SystemClock.elapsedRealtime();
    this.g4 = paramMediaCrypto;
    this.n4 = paramr;
    this.k4 = f2;
    this.h4 = this.X3;
    this.o4 = Q(str1);
    this.p4 = R(str1, this.h4);
    this.q4 = W(str1);
    this.r4 = Y(str1);
    this.s4 = T(str1);
    this.t4 = U(str1);
    this.u4 = S(str1);
    this.v4 = X(str1, this.h4);
    boolean bool1 = V(paramr);
    boolean bool2 = false;
    if ((!bool1) && (!q0())) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    this.y4 = bool1;
    if (paramMediaCrypto.h())
    {
      this.J4 = true;
      this.K4 = 1;
      bool1 = bool2;
      if (this.o4 != 0) {
        bool1 = true;
      }
      this.w4 = bool1;
    }
    if ("c2.android.mp3.decoder".equals(paramr.a)) {
      this.z4 = new p();
    }
    if (getState() == 2) {
      this.A4 = (SystemClock.elapsedRealtime() + 1000L);
    }
    paramr = this.a5;
    paramr.a += 1;
    K0(str1, l2, l2 - l1);
  }
  
  private boolean C0(long paramLong)
  {
    int i = this.S3.size();
    for (int j = 0; j < i; j++) {
      if (((Long)this.S3.get(j)).longValue() == paramLong)
      {
        this.S3.remove(j);
        return true;
      }
    }
    return false;
  }
  
  private static boolean D0(IllegalStateException paramIllegalStateException)
  {
    int i = o0.a;
    boolean bool = true;
    if ((i >= 21) && (E0(paramIllegalStateException))) {
      return true;
    }
    paramIllegalStateException = paramIllegalStateException.getStackTrace();
    if ((paramIllegalStateException.length <= 0) || (!paramIllegalStateException[0].getClassName().equals("android.media.MediaCodec"))) {
      bool = false;
    }
    return bool;
  }
  
  @RequiresApi(21)
  private static boolean E0(IllegalStateException paramIllegalStateException)
  {
    return paramIllegalStateException instanceof MediaCodec.CodecException;
  }
  
  @RequiresApi(21)
  private static boolean F0(IllegalStateException paramIllegalStateException)
  {
    if ((paramIllegalStateException instanceof MediaCodec.CodecException)) {
      return ((MediaCodec.CodecException)paramIllegalStateException).isRecoverable();
    }
    return false;
  }
  
  private void H0(MediaCrypto paramMediaCrypto, boolean paramBoolean)
    throws MediaCodecRenderer.DecoderInitializationException
  {
    Object localObject1;
    Object localObject2;
    if (this.l4 == null) {
      try
      {
        localObject1 = n0(paramBoolean);
        localObject2 = new java/util/ArrayDeque;
        ((ArrayDeque)localObject2).<init>();
        this.l4 = ((ArrayDeque)localObject2);
        if (this.L3) {
          ((ArrayDeque)localObject2).addAll((Collection)localObject1);
        } else if (!((List)localObject1).isEmpty()) {
          this.l4.add((r)((List)localObject1).get(0));
        }
        this.m4 = null;
      }
      catch (MediaCodecUtil.DecoderQueryException paramMediaCrypto)
      {
        throw new DecoderInitializationException(this.X3, paramMediaCrypto, paramBoolean, -49998);
      }
    }
    if (!this.l4.isEmpty())
    {
      while (this.g4 == null)
      {
        localObject2 = (r)this.l4.peekFirst();
        if (!h1((r)localObject2)) {
          return;
        }
        try
        {
          B0((r)localObject2, paramMediaCrypto);
        }
        catch (Exception localException)
        {
          localObject1 = String.valueOf(localObject2);
          StringBuilder localStringBuilder = new StringBuilder(((String)localObject1).length() + 30);
          localStringBuilder.append("Failed to initialize decoder: ");
          localStringBuilder.append((String)localObject1);
          u.i("MediaCodecRenderer", localStringBuilder.toString(), localException);
          this.l4.removeFirst();
          localObject1 = new DecoderInitializationException(this.X3, localException, paramBoolean, (r)localObject2);
          J0((Exception)localObject1);
          if (this.m4 == null) {
            this.m4 = ((DecoderInitializationException)localObject1);
          } else {
            this.m4 = this.m4.copyWithFallbackException((DecoderInitializationException)localObject1);
          }
        }
        if (this.l4.isEmpty()) {
          throw this.m4;
        }
      }
      this.l4 = null;
      return;
    }
    throw new DecoderInitializationException(this.X3, null, paramBoolean, -49999);
  }
  
  private boolean I0(f0 paramf0, Format paramFormat)
  {
    if (paramf0.d) {
      return false;
    }
    try
    {
      paramf0 = new MediaCrypto(paramf0.b, paramf0.c);
      try
      {
        boolean bool = paramf0.requiresSecureDecoderComponent(paramFormat.H3);
        return bool;
      }
      finally
      {
        paramf0.release();
      }
      return true;
    }
    catch (MediaCryptoException paramf0) {}
  }
  
  private void N()
    throws ExoPlaybackException
  {
    g.g(this.S4 ^ true);
    i1 locali1 = A();
    this.P3.f();
    do
    {
      this.P3.f();
      int i = L(locali1, this.P3, 0);
      if (i == -5) {
        break;
      }
      if (i != -4)
      {
        if (i == -3) {
          return;
        }
        throw new IllegalStateException();
      }
      if (this.P3.k())
      {
        this.S4 = true;
        return;
      }
      if (this.U4)
      {
        Format localFormat = (Format)g.e(this.X3);
        this.Y3 = localFormat;
        N0(localFormat, null);
        this.U4 = false;
      }
      this.P3.p();
    } while (this.Q3.t(this.P3));
    this.H4 = true;
    return;
    M0(locali1);
  }
  
  private boolean O(long paramLong1, long paramLong2)
    throws ExoPlaybackException
  {
    g.g(this.T4 ^ true);
    if (this.Q3.y())
    {
      o localo = this.Q3;
      if (S0(paramLong1, paramLong2, null, localo.f, this.C4, 0, localo.x(), this.Q3.v(), this.Q3.j(), this.Q3.k(), this.Y3))
      {
        O0(this.Q3.w());
        this.Q3.f();
      }
      else
      {
        return false;
      }
    }
    if (this.S4)
    {
      this.T4 = true;
      return false;
    }
    if (this.H4)
    {
      g.g(this.Q3.t(this.P3));
      this.H4 = false;
    }
    if (this.I4)
    {
      if (this.Q3.y()) {
        return true;
      }
      a0();
      this.I4 = false;
      G0();
      if (!this.G4) {
        return false;
      }
    }
    N();
    if (this.Q3.y()) {
      this.Q3.p();
    }
    boolean bool;
    if ((!this.Q3.y()) && (!this.S4) && (!this.I4)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private int Q(String paramString)
  {
    int i = o0.a;
    if ((i <= 25) && ("OMX.Exynos.avc.dec.secure".equals(paramString)))
    {
      String str = o0.d;
      if ((str.startsWith("SM-T585")) || (str.startsWith("SM-A510")) || (str.startsWith("SM-A520")) || (str.startsWith("SM-J700"))) {
        return 2;
      }
    }
    if ((i < 24) && (("OMX.Nvidia.h264.decode".equals(paramString)) || ("OMX.Nvidia.h264.decode.secure".equals(paramString))))
    {
      paramString = o0.b;
      if (("flounder".equals(paramString)) || ("flounder_lte".equals(paramString)) || ("grouper".equals(paramString)) || ("tilapia".equals(paramString))) {
        return 1;
      }
    }
    return 0;
  }
  
  private static boolean R(String paramString, Format paramFormat)
  {
    boolean bool;
    if ((o0.a < 21) && (paramFormat.J3.isEmpty()) && ("OMX.MTK.VIDEO.DECODER.AVC".equals(paramString))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @TargetApi(23)
  private void R0()
    throws ExoPlaybackException
  {
    int i = this.M4;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          this.T4 = true;
          X0();
        }
        else
        {
          V0();
        }
      }
      else
      {
        k0();
        m1();
      }
    }
    else {
      k0();
    }
  }
  
  private static boolean S(String paramString)
  {
    if ((o0.a < 21) && ("OMX.SEC.mp3.dec".equals(paramString)) && ("samsung".equals(o0.c)))
    {
      paramString = o0.b;
      if ((paramString.startsWith("baffin")) || (paramString.startsWith("grand")) || (paramString.startsWith("fortuna")) || (paramString.startsWith("gprimelte")) || (paramString.startsWith("j2y18lte")) || (paramString.startsWith("ms01"))) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  private static boolean T(String paramString)
  {
    int i = o0.a;
    if ((i > 23) || (!"OMX.google.vorbis.decoder".equals(paramString)))
    {
      if (i <= 19)
      {
        String str = o0.b;
        if (((!"hb2000".equals(str)) && (!"stvm8".equals(str))) || ((!"OMX.amlogic.avc.decoder.awesome".equals(paramString)) && (!"OMX.amlogic.avc.decoder.awesome.secure".equals(paramString)))) {}
      }
    }
    else {
      return true;
    }
    boolean bool = false;
    return bool;
  }
  
  private void T0()
  {
    this.P4 = true;
    MediaFormat localMediaFormat = this.g4.b();
    if ((this.o4 != 0) && (localMediaFormat.getInteger("width") == 32) && (localMediaFormat.getInteger("height") == 32))
    {
      this.x4 = true;
      return;
    }
    if (this.v4) {
      localMediaFormat.setInteger("channel-count", 1);
    }
    this.i4 = localMediaFormat;
    this.j4 = true;
  }
  
  private static boolean U(String paramString)
  {
    boolean bool;
    if ((o0.a == 21) && ("OMX.google.aac.decoder".equals(paramString))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean U0(int paramInt)
    throws ExoPlaybackException
  {
    i1 locali1 = A();
    this.N3.f();
    paramInt = L(locali1, this.N3, paramInt | 0x4);
    if (paramInt == -5)
    {
      M0(locali1);
      return true;
    }
    if ((paramInt == -4) && (this.N3.k()))
    {
      this.S4 = true;
      R0();
    }
    return false;
  }
  
  private static boolean V(r paramr)
  {
    String str = paramr.a;
    int i = o0.a;
    boolean bool;
    if (((i <= 25) && ("OMX.rk.video_decoder.avc".equals(str))) || ((i <= 17) && ("OMX.allwinner.video.decoder.avc".equals(str))) || ((i <= 29) && (("OMX.broadcom.video_decoder.tunnel".equals(str)) || ("OMX.broadcom.video_decoder.tunnel.secure".equals(str)))) || (("Amazon".equals(o0.c)) && ("AFTS".equals(o0.d)) && (paramr.g))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void V0()
    throws ExoPlaybackException
  {
    W0();
    G0();
  }
  
  private static boolean W(String paramString)
  {
    int i = o0.a;
    boolean bool;
    if ((i >= 18) && ((i != 18) || ((!"OMX.SEC.avc.dec".equals(paramString)) && (!"OMX.SEC.avc.dec.secure".equals(paramString)))) && ((i != 19) || (!o0.d.startsWith("SM-G800")) || ((!"OMX.Exynos.avc.dec".equals(paramString)) && (!"OMX.Exynos.avc.dec.secure".equals(paramString))))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private static boolean X(String paramString, Format paramFormat)
  {
    int i = o0.a;
    boolean bool = true;
    if ((i > 18) || (paramFormat.U3 != 1) || (!"OMX.MTK.AUDIO.DECODER.MP3".equals(paramString))) {
      bool = false;
    }
    return bool;
  }
  
  private static boolean Y(String paramString)
  {
    boolean bool;
    if ((o0.a == 29) && ("c2.android.aac.decoder".equals(paramString))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void a0()
  {
    this.I4 = false;
    this.Q3.f();
    this.P3.f();
    this.H4 = false;
    this.G4 = false;
  }
  
  private void a1()
  {
    this.B4 = -1;
    this.O3.f = null;
  }
  
  private boolean b0()
  {
    if (this.N4)
    {
      this.L4 = 1;
      if ((!this.q4) && (!this.s4))
      {
        this.M4 = 1;
      }
      else
      {
        this.M4 = 3;
        return false;
      }
    }
    return true;
  }
  
  private void b1()
  {
    this.C4 = -1;
    this.D4 = null;
  }
  
  private void c0()
    throws ExoPlaybackException
  {
    if (this.N4)
    {
      this.L4 = 1;
      this.M4 = 3;
    }
    else
    {
      V0();
    }
  }
  
  private void c1(@Nullable DrmSession paramDrmSession)
  {
    t.a(this.Z3, paramDrmSession);
    this.Z3 = paramDrmSession;
  }
  
  @TargetApi(23)
  private boolean d0()
    throws ExoPlaybackException
  {
    if (this.N4)
    {
      this.L4 = 1;
      if ((!this.q4) && (!this.s4))
      {
        this.M4 = 2;
      }
      else
      {
        this.M4 = 3;
        return false;
      }
    }
    else
    {
      m1();
    }
    return true;
  }
  
  private boolean e0(long paramLong1, long paramLong2)
    throws ExoPlaybackException
  {
    Object localObject1;
    long l1;
    if (!z0())
    {
      if ((this.t4) && (this.O4)) {
        try
        {
          i = this.g4.l(this.T3);
        }
        catch (IllegalStateException localIllegalStateException1)
        {
          R0();
          if (this.T4) {
            W0();
          }
          return false;
        }
      } else {
        i = this.g4.l(this.T3);
      }
      if (i < 0)
      {
        if (i == -2)
        {
          T0();
          return true;
        }
        if ((this.y4) && ((this.S4) || (this.L4 == 2))) {
          R0();
        }
        return false;
      }
      if (this.x4)
      {
        this.x4 = false;
        this.g4.m(i, false);
        return true;
      }
      localObject1 = this.T3;
      if ((((MediaCodec.BufferInfo)localObject1).size == 0) && ((((MediaCodec.BufferInfo)localObject1).flags & 0x4) != 0))
      {
        R0();
        return false;
      }
      this.C4 = i;
      localObject1 = this.g4.n(i);
      this.D4 = ((ByteBuffer)localObject1);
      if (localObject1 != null)
      {
        ((ByteBuffer)localObject1).position(this.T3.offset);
        localObject1 = this.D4;
        localObject2 = this.T3;
        ((ByteBuffer)localObject1).limit(((MediaCodec.BufferInfo)localObject2).offset + ((MediaCodec.BufferInfo)localObject2).size);
      }
      if (this.u4)
      {
        localObject1 = this.T3;
        if ((((MediaCodec.BufferInfo)localObject1).presentationTimeUs == 0L) && ((((MediaCodec.BufferInfo)localObject1).flags & 0x4) != 0))
        {
          l1 = this.Q4;
          if (l1 != -9223372036854775807L) {
            ((MediaCodec.BufferInfo)localObject1).presentationTimeUs = l1;
          }
        }
      }
      this.E4 = C0(this.T3.presentationTimeUs);
      long l2 = this.R4;
      l1 = this.T3.presentationTimeUs;
      if (l2 == l1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.F4 = bool1;
      n1(l1);
    }
    if ((this.t4) && (this.O4))
    {
      try
      {
        localObject1 = this.g4;
        localObject2 = this.D4;
        i = this.C4;
        localObject3 = this.T3;
        int j = ((MediaCodec.BufferInfo)localObject3).flags;
        l1 = ((MediaCodec.BufferInfo)localObject3).presentationTimeUs;
        boolean bool2 = this.E4;
        bool1 = this.F4;
        localObject3 = this.Y3;
        try
        {
          bool1 = S0(paramLong1, paramLong2, (q)localObject1, (ByteBuffer)localObject2, i, j, 1, l1, bool2, bool1, (Format)localObject3);
        }
        catch (IllegalStateException localIllegalStateException2) {}
        R0();
      }
      catch (IllegalStateException localIllegalStateException3) {}
      if (this.T4) {
        W0();
      }
      return false;
    }
    q localq = this.g4;
    Object localObject3 = this.D4;
    int i = this.C4;
    Object localObject2 = this.T3;
    boolean bool1 = S0(paramLong1, paramLong2, localq, (ByteBuffer)localObject3, i, ((MediaCodec.BufferInfo)localObject2).flags, 1, ((MediaCodec.BufferInfo)localObject2).presentationTimeUs, this.E4, this.F4, this.Y3);
    if (bool1)
    {
      O0(this.T3.presentationTimeUs);
      if ((this.T3.flags & 0x4) != 0) {
        i = 1;
      } else {
        i = 0;
      }
      b1();
      if (i == 0) {
        return true;
      }
      R0();
    }
    return false;
  }
  
  private boolean f0(r paramr, Format paramFormat, @Nullable DrmSession paramDrmSession1, @Nullable DrmSession paramDrmSession2)
    throws ExoPlaybackException
  {
    if (paramDrmSession1 == paramDrmSession2) {
      return false;
    }
    if ((paramDrmSession2 != null) && (paramDrmSession1 != null))
    {
      if (o0.a < 23) {
        return true;
      }
      UUID localUUID = w0.e;
      if ((!localUUID.equals(paramDrmSession1.c())) && (!localUUID.equals(paramDrmSession2.c())))
      {
        paramDrmSession1 = u0(paramDrmSession2);
        if (paramDrmSession1 == null) {
          return true;
        }
        return (!paramr.g) && (I0(paramDrmSession1, paramFormat));
      }
    }
    return true;
  }
  
  private void f1(@Nullable DrmSession paramDrmSession)
  {
    t.a(this.a4, paramDrmSession);
    this.a4 = paramDrmSession;
  }
  
  private boolean g1(long paramLong)
  {
    boolean bool;
    if ((this.d4 != -9223372036854775807L) && (SystemClock.elapsedRealtime() - paramLong >= this.d4)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private boolean j0()
    throws ExoPlaybackException
  {
    Object localObject1 = this.g4;
    if ((localObject1 != null) && (this.L4 != 2) && (!this.S4))
    {
      if (this.B4 < 0)
      {
        i = ((q)localObject1).k();
        this.B4 = i;
        if (i < 0) {
          return false;
        }
        this.O3.f = this.g4.e(i);
        this.O3.f();
      }
      if (this.L4 == 1)
      {
        if (!this.y4)
        {
          this.O4 = true;
          this.g4.g(this.B4, 0, 0, 0L, 4);
          a1();
        }
        this.L4 = 2;
        return false;
      }
      Object localObject3;
      if (this.w4)
      {
        this.w4 = false;
        localObject1 = this.O3.f;
        localObject3 = I3;
        ((ByteBuffer)localObject1).put((byte[])localObject3);
        this.g4.g(this.B4, 0, localObject3.length, 0L, 0);
        a1();
        this.N4 = true;
        return true;
      }
      if (this.K4 == 1)
      {
        for (i = 0; i < this.h4.J3.size(); i++)
        {
          localObject1 = (byte[])this.h4.J3.get(i);
          this.O3.f.put((byte[])localObject1);
        }
        this.K4 = 2;
      }
      int i = this.O3.f.position();
      localObject1 = A();
      try
      {
        int j = L((i1)localObject1, this.O3, 0);
        if (i()) {
          this.R4 = this.Q4;
        }
        if (j == -3) {
          return false;
        }
        if (j == -5)
        {
          if (this.K4 == 2)
          {
            this.O3.f();
            this.K4 = 1;
          }
          M0((i1)localObject1);
          return true;
        }
        if (this.O3.k())
        {
          if (this.K4 == 2)
          {
            this.O3.f();
            this.K4 = 1;
          }
          this.S4 = true;
          if (!this.N4)
          {
            R0();
            return false;
          }
          try
          {
            if (!this.y4)
            {
              this.O4 = true;
              this.g4.g(this.B4, 0, 0, 0L, 4);
              a1();
            }
            return false;
          }
          catch (MediaCodec.CryptoException localCryptoException1)
          {
            throw x(localCryptoException1, this.X3, w0.b(localCryptoException1.getErrorCode()));
          }
        }
        if ((!this.N4) && (!this.O3.l()))
        {
          this.O3.f();
          if (this.K4 == 2) {
            this.K4 = 1;
          }
          return true;
        }
        boolean bool = this.O3.q();
        if (bool) {
          this.O3.d.b(i);
        }
        if ((this.p4) && (!bool))
        {
          z.b(this.O3.f);
          if (this.O3.f.position() == 0) {
            return true;
          }
          this.p4 = false;
        }
        Object localObject2 = this.O3;
        long l = ((DecoderInputBuffer)localObject2).x;
        localObject3 = this.z4;
        if (localObject3 != null) {
          l = ((p)localObject3).c(this.X3, (DecoderInputBuffer)localObject2);
        }
        if (this.O3.j()) {
          this.S3.add(Long.valueOf(l));
        }
        if (this.U4)
        {
          this.R3.a(l, this.X3);
          this.U4 = false;
        }
        if (this.z4 != null) {
          this.Q4 = Math.max(this.Q4, this.O3.x);
        } else {
          this.Q4 = Math.max(this.Q4, l);
        }
        this.O3.p();
        if (this.O3.i()) {
          y0(this.O3);
        }
        Q0(this.O3);
        if (bool) {}
        try
        {
          this.g4.a(this.B4, 0, this.O3.d, l, 0);
          break label761;
          this.g4.g(this.B4, 0, this.O3.f.limit(), l, 0);
          label761:
          a1();
          this.N4 = true;
          this.K4 = 0;
          localObject2 = this.a5;
          ((d)localObject2).c += 1;
          return true;
        }
        catch (MediaCodec.CryptoException localCryptoException2)
        {
          throw x(localCryptoException2, this.X3, w0.b(localCryptoException2.getErrorCode()));
        }
        return false;
      }
      catch (DecoderInputBuffer.InsufficientCapacityException localInsufficientCapacityException)
      {
        J0(localInsufficientCapacityException);
        U0(0);
        k0();
        return true;
      }
    }
  }
  
  private void k0()
  {
    try
    {
      this.g4.flush();
      return;
    }
    finally
    {
      Y0();
    }
  }
  
  protected static boolean k1(Format paramFormat)
  {
    paramFormat = paramFormat.a4;
    boolean bool;
    if ((paramFormat != null) && (!f0.class.equals(paramFormat))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private boolean l1(Format paramFormat)
    throws ExoPlaybackException
  {
    if (o0.a < 23) {
      return true;
    }
    if ((this.g4 != null) && (this.M4 != 3) && (getState() != 0))
    {
      float f1 = r0(this.f4, paramFormat, C());
      float f2 = this.k4;
      if (f2 == f1) {
        return true;
      }
      if (f1 == -1.0F)
      {
        c0();
        return false;
      }
      if ((f2 == -1.0F) && (f1 <= this.M3)) {
        return true;
      }
      paramFormat = new Bundle();
      paramFormat.putFloat("operating-rate", f1);
      this.g4.i(paramFormat);
      this.k4 = f1;
    }
    return true;
  }
  
  @RequiresApi(23)
  private void m1()
    throws ExoPlaybackException
  {
    try
    {
      this.b4.setMediaDrmSession(u0(this.a4).c);
      c1(this.a4);
      this.L4 = 0;
      this.M4 = 0;
      return;
    }
    catch (MediaCryptoException localMediaCryptoException)
    {
      throw x(localMediaCryptoException, this.X3, 6006);
    }
  }
  
  private List<r> n0(boolean paramBoolean)
    throws MediaCodecUtil.DecoderQueryException
  {
    List localList = t0(this.K3, this.X3, paramBoolean);
    Object localObject = localList;
    if (localList.isEmpty())
    {
      localObject = localList;
      if (paramBoolean)
      {
        localList = t0(this.K3, this.X3, false);
        localObject = localList;
        if (!localList.isEmpty())
        {
          String str1 = this.X3.H3;
          String str2 = String.valueOf(localList);
          localObject = new StringBuilder(String.valueOf(str1).length() + 99 + str2.length());
          ((StringBuilder)localObject).append("Drm session requires secure decoder for ");
          ((StringBuilder)localObject).append(str1);
          ((StringBuilder)localObject).append(", but no secure decoder available. Trying to proceed with ");
          ((StringBuilder)localObject).append(str2);
          ((StringBuilder)localObject).append(".");
          u.h("MediaCodecRenderer", ((StringBuilder)localObject).toString());
          localObject = localList;
        }
      }
    }
    return (List<r>)localObject;
  }
  
  @Nullable
  private f0 u0(DrmSession paramDrmSession)
    throws ExoPlaybackException
  {
    paramDrmSession = paramDrmSession.e();
    if ((paramDrmSession != null) && (!(paramDrmSession instanceof f0)))
    {
      String str = String.valueOf(paramDrmSession);
      paramDrmSession = new StringBuilder(str.length() + 42);
      paramDrmSession.append("Expecting FrameworkMediaCrypto but found: ");
      paramDrmSession.append(str);
      throw x(new IllegalArgumentException(paramDrmSession.toString()), this.X3, 6001);
    }
    return (f0)paramDrmSession;
  }
  
  private boolean z0()
  {
    boolean bool;
    if (this.C4 >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void E()
  {
    this.X3 = null;
    this.b5 = -9223372036854775807L;
    this.c5 = -9223372036854775807L;
    this.d5 = 0;
    m0();
  }
  
  protected void F(boolean paramBoolean1, boolean paramBoolean2)
    throws ExoPlaybackException
  {
    this.a5 = new d();
  }
  
  protected void G(long paramLong, boolean paramBoolean)
    throws ExoPlaybackException
  {
    this.S4 = false;
    this.T4 = false;
    this.V4 = false;
    if (this.G4)
    {
      this.Q3.f();
      this.P3.f();
      this.H4 = false;
    }
    else
    {
      l0();
    }
    if (this.R3.l() > 0) {
      this.U4 = true;
    }
    this.R3.c();
    int i = this.d5;
    if (i != 0)
    {
      this.c5 = this.V3[(i - 1)];
      this.b5 = this.U3[(i - 1)];
      this.d5 = 0;
    }
  }
  
  protected final void G0()
    throws ExoPlaybackException
  {
    if ((this.g4 == null) && (!this.G4))
    {
      Object localObject1 = this.X3;
      if (localObject1 != null)
      {
        if ((this.a4 == null) && (i1((Format)localObject1)))
        {
          A0(this.X3);
          return;
        }
        c1(this.a4);
        localObject1 = this.X3.H3;
        Object localObject2 = this.Z3;
        if (localObject2 != null)
        {
          if (this.b4 == null)
          {
            localObject2 = u0((DrmSession)localObject2);
            if (localObject2 == null)
            {
              if (this.Z3.f() != null) {}
            }
            else {
              try
              {
                MediaCrypto localMediaCrypto = new android/media/MediaCrypto;
                localMediaCrypto.<init>(((f0)localObject2).b, ((f0)localObject2).c);
                this.b4 = localMediaCrypto;
                boolean bool;
                if ((!((f0)localObject2).d) && (localMediaCrypto.requiresSecureDecoderComponent((String)localObject1))) {
                  bool = true;
                } else {
                  bool = false;
                }
                this.c4 = bool;
              }
              catch (MediaCryptoException localMediaCryptoException)
              {
                throw x(localMediaCryptoException, this.X3, 6006);
              }
            }
          }
          if (f0.a)
          {
            int i = this.Z3.getState();
            if (i != 1)
            {
              if (i == 4) {}
            }
            else
            {
              DrmSession.DrmSessionException localDrmSessionException = (DrmSession.DrmSessionException)g.e(this.Z3.f());
              throw x(localDrmSessionException, this.X3, localDrmSessionException.errorCode);
            }
          }
        }
        try
        {
          H0(this.b4, this.c4);
          return;
        }
        catch (DecoderInitializationException localDecoderInitializationException)
        {
          throw x(localDecoderInitializationException, this.X3, 4001);
        }
      }
    }
  }
  
  protected void H()
  {
    try
    {
      a0();
      W0();
      return;
    }
    finally
    {
      f1(null);
    }
  }
  
  protected void I() {}
  
  protected void J() {}
  
  protected abstract void J0(Exception paramException);
  
  protected void K(Format[] paramArrayOfFormat, long paramLong1, long paramLong2)
    throws ExoPlaybackException
  {
    long l = this.c5;
    boolean bool = true;
    if (l == -9223372036854775807L)
    {
      if (this.b5 != -9223372036854775807L) {
        bool = false;
      }
      g.g(bool);
      this.b5 = paramLong1;
      this.c5 = paramLong2;
    }
    else
    {
      int i = this.d5;
      paramArrayOfFormat = this.V3;
      if (i == paramArrayOfFormat.length)
      {
        l = paramArrayOfFormat[(i - 1)];
        paramArrayOfFormat = new StringBuilder(65);
        paramArrayOfFormat.append("Too many stream changes, so dropping offset: ");
        paramArrayOfFormat.append(l);
        u.h("MediaCodecRenderer", paramArrayOfFormat.toString());
      }
      else
      {
        this.d5 = (i + 1);
      }
      paramArrayOfFormat = this.U3;
      i = this.d5;
      paramArrayOfFormat[(i - 1)] = paramLong1;
      this.V3[(i - 1)] = paramLong2;
      this.W3[(i - 1)] = this.Q4;
    }
  }
  
  protected abstract void K0(String paramString, long paramLong1, long paramLong2);
  
  protected abstract void L0(String paramString);
  
  @CallSuper
  @Nullable
  protected e M0(i1 parami1)
    throws ExoPlaybackException
  {
    boolean bool1 = true;
    this.U4 = true;
    Format localFormat1 = (Format)g.e(parami1.b);
    if (localFormat1.H3 != null)
    {
      f1(parami1.a);
      this.X3 = localFormat1;
      if (this.G4)
      {
        this.I4 = true;
        return null;
      }
      parami1 = this.g4;
      if (parami1 == null)
      {
        this.l4 = null;
        G0();
        return null;
      }
      r localr = this.n4;
      Format localFormat2 = this.h4;
      if (f0(localr, localFormat1, this.Z3, this.a4))
      {
        c0();
        return new e(localr.a, localFormat2, localFormat1, 0, 128);
      }
      if (this.a4 != this.Z3) {
        i = 1;
      } else {
        i = 0;
      }
      boolean bool2;
      if ((i != 0) && (o0.a < 23)) {
        bool2 = false;
      } else {
        bool2 = true;
      }
      g.g(bool2);
      e locale = P(localr, localFormat2, localFormat1);
      int j = locale.d;
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2)
          {
            if (j == 3)
            {
              if (l1(localFormat1))
              {
                this.h4 = localFormat1;
                if ((i == 0) || (d0())) {
                  break label409;
                }
                break label399;
              }
            }
            else {
              throw new IllegalStateException();
            }
          }
          else if (l1(localFormat1))
          {
            this.J4 = true;
            this.K4 = 1;
            j = this.o4;
            bool2 = bool1;
            if (j != 2) {
              if ((j == 1) && (localFormat1.M3 == localFormat2.M3) && (localFormat1.N3 == localFormat2.N3)) {
                bool2 = bool1;
              } else {
                bool2 = false;
              }
            }
            this.w4 = bool2;
            this.h4 = localFormat1;
            if ((i == 0) || (d0())) {
              break label409;
            }
            break label399;
          }
        }
        else {
          if (l1(localFormat1)) {
            break label372;
          }
        }
        i = 16;
        break label412;
        label372:
        this.h4 = localFormat1;
        if (i != 0 ? !d0() : !b0())
        {
          label399:
          i = 2;
          break label412;
        }
      }
      else
      {
        c0();
      }
      label409:
      int i = 0;
      label412:
      if ((locale.d != 0) && ((this.g4 != parami1) || (this.M4 == 3))) {
        return new e(localr.a, localFormat2, localFormat1, 0, i);
      }
      return locale;
    }
    throw x(new IllegalArgumentException(), localFormat1, 4005);
  }
  
  protected abstract void N0(Format paramFormat, @Nullable MediaFormat paramMediaFormat)
    throws ExoPlaybackException;
  
  @CallSuper
  protected void O0(long paramLong)
  {
    for (;;)
    {
      int i = this.d5;
      if ((i == 0) || (paramLong < this.W3[0])) {
        break;
      }
      long[] arrayOfLong = this.U3;
      this.b5 = arrayOfLong[0];
      this.c5 = this.V3[0];
      i--;
      this.d5 = i;
      System.arraycopy(arrayOfLong, 1, arrayOfLong, 0, i);
      arrayOfLong = this.V3;
      System.arraycopy(arrayOfLong, 1, arrayOfLong, 0, this.d5);
      arrayOfLong = this.W3;
      System.arraycopy(arrayOfLong, 1, arrayOfLong, 0, this.d5);
      P0();
    }
  }
  
  protected abstract e P(r paramr, Format paramFormat1, Format paramFormat2);
  
  protected void P0() {}
  
  protected abstract void Q0(DecoderInputBuffer paramDecoderInputBuffer)
    throws ExoPlaybackException;
  
  protected abstract boolean S0(long paramLong1, long paramLong2, @Nullable q paramq, @Nullable ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, long paramLong3, boolean paramBoolean1, boolean paramBoolean2, Format paramFormat)
    throws ExoPlaybackException;
  
  /* Error */
  protected void W0()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 362	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:g4	Lcom/google/android/exoplayer2/mediacodec/q;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +35 -> 41
    //   9: aload_1
    //   10: invokeinterface 1147 1 0
    //   15: aload_0
    //   16: getfield 440	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:a5	Lcom/google/android/exoplayer2/decoder/d;
    //   19: astore_1
    //   20: aload_1
    //   21: aload_1
    //   22: getfield 1149	com/google/android/exoplayer2/decoder/d:b	I
    //   25: iconst_1
    //   26: iadd
    //   27: putfield 1149	com/google/android/exoplayer2/decoder/d:b	I
    //   30: aload_0
    //   31: aload_0
    //   32: getfield 364	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:n4	Lcom/google/android/exoplayer2/mediacodec/r;
    //   35: getfield 293	com/google/android/exoplayer2/mediacodec/r:a	Ljava/lang/String;
    //   38: invokevirtual 1151	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:L0	(Ljava/lang/String;)V
    //   41: aload_0
    //   42: aconst_null
    //   43: putfield 362	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:g4	Lcom/google/android/exoplayer2/mediacodec/q;
    //   46: aload_0
    //   47: getfield 1027	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:b4	Landroid/media/MediaCrypto;
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull +7 -> 59
    //   55: aload_1
    //   56: invokevirtual 597	android/media/MediaCrypto:release	()V
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 1027	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:b4	Landroid/media/MediaCrypto;
    //   64: aload_0
    //   65: aconst_null
    //   66: invokespecial 1033	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:c1	(Lcom/google/android/exoplayer2/drm/DrmSession;)V
    //   69: aload_0
    //   70: invokevirtual 1154	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:Z0	()V
    //   73: return
    //   74: astore_1
    //   75: aload_0
    //   76: aconst_null
    //   77: putfield 1027	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:b4	Landroid/media/MediaCrypto;
    //   80: aload_0
    //   81: aconst_null
    //   82: invokespecial 1033	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:c1	(Lcom/google/android/exoplayer2/drm/DrmSession;)V
    //   85: aload_0
    //   86: invokevirtual 1154	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:Z0	()V
    //   89: aload_1
    //   90: athrow
    //   91: astore_2
    //   92: aload_0
    //   93: aconst_null
    //   94: putfield 362	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:g4	Lcom/google/android/exoplayer2/mediacodec/q;
    //   97: aload_0
    //   98: getfield 1027	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:b4	Landroid/media/MediaCrypto;
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +7 -> 110
    //   106: aload_1
    //   107: invokevirtual 597	android/media/MediaCrypto:release	()V
    //   110: aload_0
    //   111: aconst_null
    //   112: putfield 1027	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:b4	Landroid/media/MediaCrypto;
    //   115: aload_0
    //   116: aconst_null
    //   117: invokespecial 1033	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:c1	(Lcom/google/android/exoplayer2/drm/DrmSession;)V
    //   120: aload_0
    //   121: invokevirtual 1154	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:Z0	()V
    //   124: aload_2
    //   125: athrow
    //   126: astore_1
    //   127: aload_0
    //   128: aconst_null
    //   129: putfield 1027	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:b4	Landroid/media/MediaCrypto;
    //   132: aload_0
    //   133: aconst_null
    //   134: invokespecial 1033	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:c1	(Lcom/google/android/exoplayer2/drm/DrmSession;)V
    //   137: aload_0
    //   138: invokevirtual 1154	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:Z0	()V
    //   141: aload_1
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	MediaCodecRenderer
    //   4	52	1	localObject1	Object
    //   74	16	1	localObject2	Object
    //   101	6	1	localMediaCrypto	MediaCrypto
    //   126	16	1	localObject3	Object
    //   91	34	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   46	51	74	finally
    //   55	59	74	finally
    //   0	5	91	finally
    //   9	41	91	finally
    //   97	102	126	finally
    //   106	110	126	finally
  }
  
  protected void X0()
    throws ExoPlaybackException
  {}
  
  @CallSuper
  protected void Y0()
  {
    a1();
    b1();
    this.A4 = -9223372036854775807L;
    this.O4 = false;
    this.N4 = false;
    this.w4 = false;
    this.x4 = false;
    this.E4 = false;
    this.F4 = false;
    this.S3.clear();
    this.Q4 = -9223372036854775807L;
    this.R4 = -9223372036854775807L;
    p localp = this.z4;
    if (localp != null) {
      localp.b();
    }
    this.L4 = 0;
    this.M4 = 0;
    this.K4 = this.J4;
  }
  
  protected MediaCodecDecoderException Z(Throwable paramThrowable, @Nullable r paramr)
  {
    return new MediaCodecDecoderException(paramThrowable, paramr);
  }
  
  @CallSuper
  protected void Z0()
  {
    Y0();
    this.Z4 = null;
    this.z4 = null;
    this.l4 = null;
    this.n4 = null;
    this.h4 = null;
    this.i4 = null;
    this.j4 = false;
    this.P4 = false;
    this.k4 = -1.0F;
    this.o4 = 0;
    this.p4 = false;
    this.q4 = false;
    this.r4 = false;
    this.s4 = false;
    this.t4 = false;
    this.u4 = false;
    this.v4 = false;
    this.y4 = false;
    this.J4 = false;
    this.K4 = 0;
    this.c4 = false;
  }
  
  public final int a(Format paramFormat)
    throws ExoPlaybackException
  {
    try
    {
      int i = j1(this.K3, paramFormat);
      return i;
    }
    catch (MediaCodecUtil.DecoderQueryException localDecoderQueryException)
    {
      throw x(localDecoderQueryException, paramFormat, 4002);
    }
  }
  
  public boolean d()
  {
    return this.T4;
  }
  
  protected final void d1()
  {
    this.V4 = true;
  }
  
  protected final void e1(ExoPlaybackException paramExoPlaybackException)
  {
    this.Z4 = paramExoPlaybackException;
  }
  
  public boolean g()
  {
    boolean bool;
    if ((this.X3 != null) && ((D()) || (z0()) || ((this.A4 != -9223372036854775807L) && (SystemClock.elapsedRealtime() < this.A4)))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void g0(boolean paramBoolean)
  {
    this.W4 = paramBoolean;
  }
  
  public void h0(boolean paramBoolean)
  {
    this.X4 = paramBoolean;
  }
  
  protected boolean h1(r paramr)
  {
    return true;
  }
  
  public void i0(boolean paramBoolean)
  {
    this.Y4 = paramBoolean;
  }
  
  protected boolean i1(Format paramFormat)
  {
    return false;
  }
  
  protected abstract int j1(s params, Format paramFormat)
    throws MediaCodecUtil.DecoderQueryException;
  
  protected final boolean l0()
    throws ExoPlaybackException
  {
    boolean bool = m0();
    if (bool) {
      G0();
    }
    return bool;
  }
  
  protected boolean m0()
  {
    if (this.g4 == null) {
      return false;
    }
    if ((this.M4 != 3) && (!this.q4) && ((!this.r4) || (this.P4)) && ((!this.s4) || (!this.O4)))
    {
      k0();
      return false;
    }
    W0();
    return true;
  }
  
  protected final void n1(long paramLong)
    throws ExoPlaybackException
  {
    Format localFormat1 = (Format)this.R3.j(paramLong);
    Format localFormat2 = localFormat1;
    if (localFormat1 == null)
    {
      localFormat2 = localFormat1;
      if (this.j4) {
        localFormat2 = (Format)this.R3.i();
      }
    }
    int i;
    if (localFormat2 != null)
    {
      this.Y3 = localFormat2;
      i = 1;
    }
    else
    {
      i = 0;
    }
    if ((i != 0) || ((this.j4) && (this.Y3 != null)))
    {
      N0(this.Y3, this.i4);
      this.j4 = false;
    }
  }
  
  @Nullable
  protected final q o0()
  {
    return this.g4;
  }
  
  @Nullable
  protected final r p0()
  {
    return this.n4;
  }
  
  public void q(float paramFloat1, float paramFloat2)
    throws ExoPlaybackException
  {
    this.e4 = paramFloat1;
    this.f4 = paramFloat2;
    l1(this.h4);
  }
  
  protected boolean q0()
  {
    return false;
  }
  
  protected abstract float r0(float paramFloat, Format paramFormat, Format[] paramArrayOfFormat);
  
  public final int s()
  {
    return 8;
  }
  
  @Nullable
  protected final MediaFormat s0()
  {
    return this.i4;
  }
  
  public void t(long paramLong1, long paramLong2)
    throws ExoPlaybackException
  {
    boolean bool1 = this.V4;
    boolean bool2 = false;
    if (bool1)
    {
      this.V4 = false;
      R0();
    }
    Object localObject = this.Z4;
    if (localObject == null) {
      try
      {
        if (this.T4)
        {
          X0();
          return;
        }
        if ((this.X3 == null) && (!U0(2))) {
          return;
        }
        G0();
        if (this.G4)
        {
          m0.a("bypassRender");
          while (O(paramLong1, paramLong2)) {}
          m0.c();
        }
        else if (this.g4 != null)
        {
          long l = SystemClock.elapsedRealtime();
          m0.a("drainAndFeed");
          while ((e0(paramLong1, paramLong2)) && (g1(l))) {}
          while ((j0()) && (g1(l))) {}
          m0.c();
        }
        else
        {
          localObject = this.a5;
          ((d)localObject).d += M(paramLong1);
          U0(1);
        }
        this.a5.c();
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        if (D0(localIllegalStateException))
        {
          J0(localIllegalStateException);
          bool1 = bool2;
          if (o0.a >= 21)
          {
            bool1 = bool2;
            if (F0(localIllegalStateException)) {
              bool1 = true;
            }
          }
          if (bool1) {
            W0();
          }
          throw y(Z(localIllegalStateException, p0()), this.X3, bool1, 4003);
        }
        throw localIllegalStateException;
      }
    }
    this.Z4 = null;
    throw localIllegalStateException;
  }
  
  protected abstract List<r> t0(s params, Format paramFormat, boolean paramBoolean)
    throws MediaCodecUtil.DecoderQueryException;
  
  @Nullable
  protected abstract q.a v0(r paramr, Format paramFormat, @Nullable MediaCrypto paramMediaCrypto, float paramFloat);
  
  protected final long w0()
  {
    return this.c5;
  }
  
  protected float x0()
  {
    return this.e4;
  }
  
  protected void y0(DecoderInputBuffer paramDecoderInputBuffer)
    throws ExoPlaybackException
  {}
  
  public static class DecoderInitializationException
    extends Exception
  {
    private static final int CUSTOM_ERROR_CODE_BASE = -50000;
    private static final int DECODER_QUERY_ERROR = -49998;
    private static final int NO_SUITABLE_DECODER_ERROR = -49999;
    @Nullable
    public final r codecInfo;
    @Nullable
    public final String diagnosticInfo;
    @Nullable
    public final DecoderInitializationException fallbackDecoderInitializationException;
    public final String mimeType;
    public final boolean secureDecoderRequired;
    
    public DecoderInitializationException(Format paramFormat, @Nullable Throwable paramThrowable, boolean paramBoolean, int paramInt)
    {
      this(localStringBuilder.toString(), paramThrowable, paramFormat.H3, paramBoolean, null, buildCustomDiagnosticInfo(paramInt), null);
    }
    
    public DecoderInitializationException(Format paramFormat, @Nullable Throwable paramThrowable, boolean paramBoolean, r paramr)
    {
      this(str2, paramThrowable, str1, paramBoolean, paramr, paramFormat, null);
    }
    
    private DecoderInitializationException(String paramString1, @Nullable Throwable paramThrowable, String paramString2, boolean paramBoolean, @Nullable r paramr, @Nullable String paramString3, @Nullable DecoderInitializationException paramDecoderInitializationException)
    {
      super(paramThrowable);
      this.mimeType = paramString2;
      this.secureDecoderRequired = paramBoolean;
      this.codecInfo = paramr;
      this.diagnosticInfo = paramString3;
      this.fallbackDecoderInitializationException = paramDecoderInitializationException;
    }
    
    private static String buildCustomDiagnosticInfo(int paramInt)
    {
      String str;
      if (paramInt < 0) {
        str = "neg_";
      } else {
        str = "";
      }
      paramInt = Math.abs(paramInt);
      StringBuilder localStringBuilder = new StringBuilder(str.length() + 71);
      localStringBuilder.append("com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_");
      localStringBuilder.append(str);
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    }
    
    @CheckResult
    private DecoderInitializationException copyWithFallbackException(DecoderInitializationException paramDecoderInitializationException)
    {
      return new DecoderInitializationException(getMessage(), getCause(), this.mimeType, this.secureDecoderRequired, this.codecInfo, this.diagnosticInfo, paramDecoderInitializationException);
    }
    
    @Nullable
    @RequiresApi(21)
    private static String getDiagnosticInfoV21(@Nullable Throwable paramThrowable)
    {
      if ((paramThrowable instanceof MediaCodec.CodecException)) {
        return ((MediaCodec.CodecException)paramThrowable).getDiagnosticInfo();
      }
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\mediacodec\MediaCodecRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */