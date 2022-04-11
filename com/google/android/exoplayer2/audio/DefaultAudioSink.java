package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioFormat;
import android.media.AudioFormat.Builder;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.AudioTrack.Builder;
import android.media.AudioTrack.StreamEventCallback;
import android.media.PlaybackParams;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.t1;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public final class DefaultAudioSink
  implements AudioSink
{
  public static boolean a = false;
  private long A;
  private long B;
  private long C;
  private long D;
  private int E;
  private boolean F;
  private boolean G;
  private long H;
  private float I;
  private AudioProcessor[] J;
  private ByteBuffer[] K;
  @Nullable
  private ByteBuffer L;
  private int M;
  @Nullable
  private ByteBuffer N;
  private byte[] O;
  private int P;
  private int Q;
  private boolean R;
  private boolean S;
  private boolean T;
  private boolean U;
  private int V;
  private x W;
  private boolean X;
  private long Y;
  private boolean Z;
  private boolean a0;
  @Nullable
  private final q b;
  private final b c;
  private final boolean d;
  private final z e;
  private final k0 f;
  private final AudioProcessor[] g;
  private final AudioProcessor[] h;
  private final ConditionVariable i;
  private final w j;
  private final ArrayDeque<e> k;
  private final boolean l;
  private final int m;
  private h n;
  private final f<AudioSink.InitializationException> o;
  private final f<AudioSink.WriteException> p;
  @Nullable
  private AudioSink.a q;
  @Nullable
  private c r;
  private c s;
  @Nullable
  private AudioTrack t;
  private p u;
  @Nullable
  private e v;
  private e w;
  private t1 x;
  @Nullable
  private ByteBuffer y;
  private int z;
  
  public DefaultAudioSink(@Nullable q paramq, b paramb, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.b = paramq;
    this.c = ((b)g.e(paramb));
    int i1 = o0.a;
    if ((i1 >= 21) && (paramBoolean1)) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    this.d = paramBoolean1;
    if ((i1 >= 23) && (paramBoolean2)) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    this.l = paramBoolean1;
    if (i1 < 29) {
      paramInt = 0;
    }
    this.m = paramInt;
    this.i = new ConditionVariable(true);
    this.j = new w(new g(null));
    paramq = new z();
    this.e = paramq;
    k0 localk0 = new k0();
    this.f = localk0;
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, new y[] { new g0(), paramq, localk0 });
    Collections.addAll(localArrayList, paramb.b());
    this.g = ((AudioProcessor[])localArrayList.toArray(new AudioProcessor[0]));
    this.h = new AudioProcessor[] { new c0() };
    this.I = 1.0F;
    this.u = p.a;
    this.V = 0;
    this.W = new x(0, 0.0F);
    paramq = t1.a;
    this.w = new e(paramq, false, 0L, 0L, null);
    this.x = paramq;
    this.Q = -1;
    this.J = new AudioProcessor[0];
    this.K = new ByteBuffer[0];
    this.k = new ArrayDeque();
    this.o = new f(100L);
    this.p = new f(100L);
  }
  
  public DefaultAudioSink(@Nullable q paramq, AudioProcessor[] paramArrayOfAudioProcessor)
  {
    this(paramq, paramArrayOfAudioProcessor, false);
  }
  
  public DefaultAudioSink(@Nullable q paramq, AudioProcessor[] paramArrayOfAudioProcessor, boolean paramBoolean)
  {
    this(paramq, new d(paramArrayOfAudioProcessor), paramBoolean, false, 0);
  }
  
  private void D(long paramLong)
  {
    if (l0()) {
      localObject = this.c.c(K());
    } else {
      localObject = t1.a;
    }
    boolean bool;
    if (l0()) {
      bool = this.c.e(R());
    } else {
      bool = false;
    }
    this.k.add(new e((t1)localObject, bool, Math.max(0L, paramLong), this.s.i(T()), null));
    k0();
    Object localObject = this.q;
    if (localObject != null) {
      ((AudioSink.a)localObject).a(bool);
    }
  }
  
  private long E(long paramLong)
  {
    while ((!this.k.isEmpty()) && (paramLong >= ((e)this.k.getFirst()).d)) {
      this.w = ((e)this.k.remove());
    }
    e locale = this.w;
    long l1 = paramLong - locale.d;
    if (locale.a.equals(t1.a)) {
      return this.w.c + l1;
    }
    if (this.k.isEmpty())
    {
      paramLong = this.c.a(l1);
      return this.w.c + paramLong;
    }
    locale = (e)this.k.getFirst();
    paramLong = o0.S(locale.d - paramLong, this.w.a.c);
    return locale.c - paramLong;
  }
  
  private long F(long paramLong)
  {
    return paramLong + this.s.i(this.c.d());
  }
  
  private AudioTrack G()
    throws AudioSink.InitializationException
  {
    try
    {
      localObject = ((c)g.e(this.s)).a(this.X, this.u, this.V);
      return (AudioTrack)localObject;
    }
    catch (AudioSink.InitializationException localInitializationException)
    {
      a0();
      Object localObject = this.q;
      if (localObject != null) {
        ((AudioSink.a)localObject).b(localInitializationException);
      }
      throw localInitializationException;
    }
  }
  
  private boolean H()
    throws AudioSink.WriteException
  {
    if (this.Q == -1) {}
    for (this.Q = 0;; this.Q += 1)
    {
      int i1 = 1;
      break label20;
      i1 = 0;
      label20:
      int i2 = this.Q;
      localObject = this.J;
      if (i2 >= localObject.length) {
        break;
      }
      localObject = localObject[i2];
      if (i1 != 0) {
        ((AudioProcessor)localObject).e();
      }
      c0(-9223372036854775807L);
      if (!((AudioProcessor)localObject).d()) {
        return false;
      }
    }
    Object localObject = this.N;
    if (localObject != null)
    {
      o0((ByteBuffer)localObject, -9223372036854775807L);
      if (this.N != null) {
        return false;
      }
    }
    this.Q = -1;
    return true;
  }
  
  private void I()
  {
    for (int i1 = 0;; i1++)
    {
      Object localObject = this.J;
      if (i1 >= localObject.length) {
        break;
      }
      localObject = localObject[i1];
      ((AudioProcessor)localObject).flush();
      this.K[i1] = ((AudioProcessor)localObject).a();
    }
  }
  
  @RequiresApi(21)
  private static AudioFormat J(int paramInt1, int paramInt2, int paramInt3)
  {
    return new AudioFormat.Builder().setSampleRate(paramInt1).setChannelMask(paramInt2).setEncoding(paramInt3).build();
  }
  
  private t1 K()
  {
    return Q().a;
  }
  
  private static int L(int paramInt)
  {
    int i1 = o0.a;
    int i2 = paramInt;
    if (i1 <= 28) {
      if (paramInt == 7)
      {
        i2 = 8;
      }
      else if ((paramInt != 3) && (paramInt != 4))
      {
        i2 = paramInt;
        if (paramInt != 5) {}
      }
      else
      {
        i2 = 6;
      }
    }
    paramInt = i2;
    if (i1 <= 26)
    {
      paramInt = i2;
      if ("fugu".equals(o0.b))
      {
        paramInt = i2;
        if (i2 == 1) {
          paramInt = 2;
        }
      }
    }
    return o0.D(paramInt);
  }
  
  @Nullable
  private static Pair<Integer, Integer> M(Format paramFormat, @Nullable q paramq)
  {
    if (paramq == null) {
      return null;
    }
    int i1 = com.google.android.exoplayer2.util.y.f((String)g.e(paramFormat.H3), paramFormat.p1);
    int i2 = 6;
    int i3;
    if ((i1 != 5) && (i1 != 6) && (i1 != 18) && (i1 != 17) && (i1 != 7) && (i1 != 8) && (i1 != 14)) {
      i3 = 0;
    } else {
      i3 = 1;
    }
    if (i3 == 0) {
      return null;
    }
    if ((i1 == 18) && (!paramq.f(18)))
    {
      i3 = 6;
    }
    else
    {
      i3 = i1;
      if (i1 == 8)
      {
        i3 = i1;
        if (!paramq.f(8)) {
          i3 = 7;
        }
      }
    }
    if (!paramq.f(i3)) {
      return null;
    }
    if (i3 == 18)
    {
      if (o0.a >= 29)
      {
        i1 = O(18, paramFormat.V3);
        i2 = i1;
        if (i1 == 0)
        {
          u.h("DefaultAudioSink", "E-AC3 JOC encoding supported but no channel count supported");
          return null;
        }
      }
    }
    else
    {
      i1 = paramFormat.U3;
      i2 = i1;
      if (i1 > paramq.e()) {
        return null;
      }
    }
    i2 = L(i2);
    if (i2 == 0) {
      return null;
    }
    return Pair.create(Integer.valueOf(i3), Integer.valueOf(i2));
  }
  
  private static int N(int paramInt, ByteBuffer paramByteBuffer)
  {
    switch (paramInt)
    {
    case 13: 
    default: 
      paramByteBuffer = new StringBuilder(38);
      paramByteBuffer.append("Unexpected audio encoding: ");
      paramByteBuffer.append(paramInt);
      throw new IllegalStateException(paramByteBuffer.toString());
    case 17: 
      return o.c(paramByteBuffer);
    case 16: 
      return 1024;
    case 15: 
      return 512;
    case 14: 
      paramInt = n.a(paramByteBuffer);
      if (paramInt == -1) {
        paramInt = 0;
      } else {
        paramInt = n.h(paramByteBuffer, paramInt) * 16;
      }
      return paramInt;
    case 11: 
    case 12: 
      return 2048;
    case 10: 
      return 1024;
    case 9: 
      paramInt = e0.m(o0.E(paramByteBuffer, paramByteBuffer.position()));
      if (paramInt != -1) {
        return paramInt;
      }
      throw new IllegalArgumentException();
    case 7: 
    case 8: 
      return b0.e(paramByteBuffer);
    }
    return n.d(paramByteBuffer);
  }
  
  @RequiresApi(29)
  private static int O(int paramInt1, int paramInt2)
  {
    AudioAttributes localAudioAttributes = new AudioAttributes.Builder().setUsage(1).setContentType(3).build();
    for (int i1 = 8; i1 > 0; i1--) {
      if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(paramInt1).setSampleRate(paramInt2).setChannelMask(o0.D(i1)).build(), localAudioAttributes)) {
        return i1;
      }
    }
    return 0;
  }
  
  private static int P(int paramInt)
  {
    switch (paramInt)
    {
    case 13: 
    default: 
      throw new IllegalArgumentException();
    case 17: 
      return 336000;
    case 16: 
      return 256000;
    case 15: 
      return 8000;
    case 14: 
      return 3062500;
    case 12: 
      return 7000;
    case 11: 
      return 16000;
    case 10: 
      return 100000;
    case 9: 
      return 40000;
    case 8: 
      return 2250000;
    case 7: 
      return 192000;
    case 6: 
    case 18: 
      return 768000;
    }
    return 80000;
  }
  
  private e Q()
  {
    e locale = this.v;
    if (locale == null) {
      if (!this.k.isEmpty()) {
        locale = (e)this.k.getLast();
      } else {
        locale = this.w;
      }
    }
    return locale;
  }
  
  private long S()
  {
    c localc = this.s;
    long l1;
    if (localc.c == 0) {
      l1 = this.A / localc.b;
    } else {
      l1 = this.B;
    }
    return l1;
  }
  
  private long T()
  {
    c localc = this.s;
    long l1;
    if (localc.c == 0) {
      l1 = this.C / localc.d;
    } else {
      l1 = this.D;
    }
    return l1;
  }
  
  private void U()
    throws AudioSink.InitializationException
  {
    this.i.block();
    Object localObject1 = G();
    this.t = ((AudioTrack)localObject1);
    if (Y((AudioTrack)localObject1))
    {
      d0(this.t);
      if (this.m != 3)
      {
        localObject2 = this.t;
        localObject1 = this.s.a;
        ((AudioTrack)localObject2).setOffloadDelayPadding(((Format)localObject1).X3, ((Format)localObject1).Y3);
      }
    }
    this.V = this.t.getAudioSessionId();
    w localw = this.j;
    localObject1 = this.t;
    Object localObject2 = this.s;
    boolean bool;
    if (((c)localObject2).c == 2) {
      bool = true;
    } else {
      bool = false;
    }
    localw.t((AudioTrack)localObject1, bool, ((c)localObject2).g, ((c)localObject2).d, ((c)localObject2).h);
    h0();
    int i1 = this.W.a;
    if (i1 != 0)
    {
      this.t.attachAuxEffect(i1);
      this.t.setAuxEffectSendLevel(this.W.b);
    }
    this.G = true;
  }
  
  private static boolean V(int paramInt)
  {
    boolean bool;
    if (((o0.a >= 24) && (paramInt == -6)) || (paramInt == -32)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean W()
  {
    boolean bool;
    if (this.t != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean X()
  {
    boolean bool;
    if ((o0.a >= 30) && (o0.d.startsWith("Pixel"))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean Y(AudioTrack paramAudioTrack)
  {
    boolean bool;
    if ((o0.a >= 29) && (paramAudioTrack.isOffloadedPlayback())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean Z(Format paramFormat, @Nullable q paramq)
  {
    boolean bool;
    if (M(paramFormat, paramq) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void a0()
  {
    if (!this.s.o()) {
      return;
    }
    this.Z = true;
  }
  
  private void b0()
  {
    if (!this.S)
    {
      this.S = true;
      this.j.h(T());
      this.t.stop();
      this.z = 0;
    }
  }
  
  private void c0(long paramLong)
    throws AudioSink.WriteException
  {
    int i1 = this.J.length;
    int i2 = i1;
    while (i2 >= 0)
    {
      ByteBuffer localByteBuffer;
      if (i2 > 0)
      {
        localByteBuffer = this.K[(i2 - 1)];
      }
      else
      {
        localByteBuffer = this.L;
        if (localByteBuffer == null) {
          localByteBuffer = AudioProcessor.a;
        }
      }
      if (i2 == i1)
      {
        o0(localByteBuffer, paramLong);
      }
      else
      {
        Object localObject = this.J[i2];
        if (i2 > this.Q) {
          ((AudioProcessor)localObject).b(localByteBuffer);
        }
        localObject = ((AudioProcessor)localObject).a();
        this.K[i2] = localObject;
        if (((ByteBuffer)localObject).hasRemaining())
        {
          i2++;
          continue;
        }
      }
      if (localByteBuffer.hasRemaining()) {
        return;
      }
      i2--;
    }
  }
  
  @RequiresApi(29)
  private void d0(AudioTrack paramAudioTrack)
  {
    if (this.n == null) {
      this.n = new h();
    }
    this.n.a(paramAudioTrack);
  }
  
  private void e0()
  {
    this.A = 0L;
    this.B = 0L;
    this.C = 0L;
    this.D = 0L;
    this.a0 = false;
    this.E = 0;
    this.w = new e(K(), R(), 0L, 0L, null);
    this.H = 0L;
    this.v = null;
    this.k.clear();
    this.L = null;
    this.M = 0;
    this.N = null;
    this.S = false;
    this.R = false;
    this.Q = -1;
    this.y = null;
    this.z = 0;
    this.f.m();
    I();
  }
  
  private void f0(t1 paramt1, boolean paramBoolean)
  {
    e locale = Q();
    if ((!paramt1.equals(locale.a)) || (paramBoolean != locale.b))
    {
      paramt1 = new e(paramt1, paramBoolean, -9223372036854775807L, -9223372036854775807L, null);
      if (W()) {
        this.v = paramt1;
      } else {
        this.w = paramt1;
      }
    }
  }
  
  @RequiresApi(23)
  private void g0(t1 paramt1)
  {
    t1 localt1 = paramt1;
    if (W())
    {
      paramt1 = new PlaybackParams().allowDefaults().setSpeed(paramt1.c).setPitch(paramt1.d).setAudioFallbackMode(2);
      try
      {
        this.t.setPlaybackParams(paramt1);
      }
      catch (IllegalArgumentException paramt1)
      {
        u.i("DefaultAudioSink", "Failed to set playback params", paramt1);
      }
      localt1 = new t1(this.t.getPlaybackParams().getSpeed(), this.t.getPlaybackParams().getPitch());
      this.j.u(localt1.c);
    }
    this.x = localt1;
  }
  
  private void h0()
  {
    if (W()) {
      if (o0.a >= 21) {
        i0(this.t, this.I);
      } else {
        j0(this.t, this.I);
      }
    }
  }
  
  @RequiresApi(21)
  private static void i0(AudioTrack paramAudioTrack, float paramFloat)
  {
    paramAudioTrack.setVolume(paramFloat);
  }
  
  private static void j0(AudioTrack paramAudioTrack, float paramFloat)
  {
    paramAudioTrack.setStereoVolume(paramFloat, paramFloat);
  }
  
  private void k0()
  {
    AudioProcessor[] arrayOfAudioProcessor = this.s.i;
    ArrayList localArrayList = new ArrayList();
    int i1 = arrayOfAudioProcessor.length;
    for (int i2 = 0; i2 < i1; i2++)
    {
      AudioProcessor localAudioProcessor = arrayOfAudioProcessor[i2];
      if (localAudioProcessor.isActive()) {
        localArrayList.add(localAudioProcessor);
      } else {
        localAudioProcessor.flush();
      }
    }
    i2 = localArrayList.size();
    this.J = ((AudioProcessor[])localArrayList.toArray(new AudioProcessor[i2]));
    this.K = new ByteBuffer[i2];
    I();
  }
  
  private boolean l0()
  {
    boolean bool;
    if ((!this.X) && ("audio/raw".equals(this.s.a.H3)) && (!m0(this.s.a.W3))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean m0(int paramInt)
  {
    boolean bool;
    if ((this.d) && (o0.j0(paramInt))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean n0(Format paramFormat, p paramp)
  {
    if ((o0.a >= 29) && (this.m != 0))
    {
      int i1 = com.google.android.exoplayer2.util.y.f((String)g.e(paramFormat.H3), paramFormat.p1);
      if (i1 == 0) {
        return false;
      }
      int i2 = o0.D(paramFormat.U3);
      if (i2 == 0) {
        return false;
      }
      if (!AudioManager.isOffloadedPlaybackSupported(J(paramFormat.V3, i2, i1), paramp.a())) {
        return false;
      }
      if ((paramFormat.X3 == 0) && (paramFormat.Y3 == 0)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      if (this.m == 1) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      return (i1 == 0) || (i2 == 0) || (X());
    }
    return false;
  }
  
  private void o0(ByteBuffer paramByteBuffer, long paramLong)
    throws AudioSink.WriteException
  {
    if (!paramByteBuffer.hasRemaining()) {
      return;
    }
    Object localObject = this.N;
    boolean bool1 = true;
    boolean bool2;
    int i2;
    if (localObject != null)
    {
      if (localObject == paramByteBuffer) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      g.a(bool2);
    }
    else
    {
      this.N = paramByteBuffer;
      if (o0.a < 21)
      {
        i1 = paramByteBuffer.remaining();
        localObject = this.O;
        if ((localObject == null) || (localObject.length < i1)) {
          this.O = new byte[i1];
        }
        i2 = paramByteBuffer.position();
        paramByteBuffer.get(this.O, 0, i1);
        paramByteBuffer.position(i2);
        this.P = 0;
      }
    }
    int i3 = paramByteBuffer.remaining();
    if (o0.a < 21)
    {
      i2 = this.j.c(this.C);
      if (i2 > 0)
      {
        i2 = Math.min(i3, i2);
        i1 = this.t.write(this.O, this.P, i2);
        i2 = i1;
        if (i1 > 0)
        {
          this.P += i1;
          paramByteBuffer.position(paramByteBuffer.position() + i1);
          i2 = i1;
        }
      }
      else
      {
        i2 = 0;
      }
    }
    else if (this.X)
    {
      if (paramLong != -9223372036854775807L) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      g.g(bool2);
      i2 = q0(this.t, paramByteBuffer, i3, paramLong);
    }
    else
    {
      i2 = p0(this.t, paramByteBuffer, i3);
    }
    this.Y = SystemClock.elapsedRealtime();
    if (i2 < 0)
    {
      bool2 = V(i2);
      if (bool2) {
        a0();
      }
      paramByteBuffer = new AudioSink.WriteException(i2, this.s.a, bool2);
      localObject = this.q;
      if (localObject != null) {
        ((AudioSink.a)localObject).b(paramByteBuffer);
      }
      if (!paramByteBuffer.isRecoverable)
      {
        this.p.b(paramByteBuffer);
        return;
      }
      throw paramByteBuffer;
    }
    this.p.a();
    if (Y(this.t))
    {
      paramLong = this.D;
      if (paramLong > 0L) {
        this.a0 = false;
      }
      if ((this.T) && (this.q != null) && (i2 < i3) && (!this.a0))
      {
        paramLong = this.j.e(paramLong);
        this.q.d(paramLong);
      }
    }
    int i1 = this.s.c;
    if (i1 == 0) {
      this.C += i2;
    }
    if (i2 == i3)
    {
      if (i1 != 0)
      {
        if (paramByteBuffer == this.L) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
        g.g(bool2);
        this.D += this.E * this.M;
      }
      this.N = null;
    }
  }
  
  @RequiresApi(21)
  private static int p0(AudioTrack paramAudioTrack, ByteBuffer paramByteBuffer, int paramInt)
  {
    return paramAudioTrack.write(paramByteBuffer, paramInt, 1);
  }
  
  @RequiresApi(21)
  private int q0(AudioTrack paramAudioTrack, ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    if (o0.a >= 26) {
      return paramAudioTrack.write(paramByteBuffer, paramInt, 1, paramLong * 1000L);
    }
    if (this.y == null)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(16);
      this.y = localByteBuffer;
      localByteBuffer.order(ByteOrder.BIG_ENDIAN);
      this.y.putInt(1431633921);
    }
    if (this.z == 0)
    {
      this.y.putInt(4, paramInt);
      this.y.putLong(8, paramLong * 1000L);
      this.y.position(0);
      this.z = paramInt;
    }
    int i1 = this.y.remaining();
    if (i1 > 0)
    {
      int i2 = paramAudioTrack.write(this.y, i1, 1);
      if (i2 < 0)
      {
        this.z = 0;
        return i2;
      }
      if (i2 < i1) {
        return 0;
      }
    }
    paramInt = p0(paramAudioTrack, paramByteBuffer, paramInt);
    if (paramInt < 0)
    {
      this.z = 0;
      return paramInt;
    }
    this.z -= paramInt;
    return paramInt;
  }
  
  public boolean R()
  {
    return Q().b;
  }
  
  public boolean a(Format paramFormat)
  {
    boolean bool;
    if (k(paramFormat) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean b()
  {
    boolean bool;
    if ((W()) && (this.j.i(T()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public t1 c()
  {
    t1 localt1;
    if (this.l) {
      localt1 = this.x;
    } else {
      localt1 = K();
    }
    return localt1;
  }
  
  public boolean d()
  {
    boolean bool;
    if ((W()) && ((!this.R) || (b()))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void e(t1 paramt1)
  {
    paramt1 = new t1(o0.o(paramt1.c, 0.1F, 8.0F), o0.o(paramt1.d, 0.1F, 8.0F));
    if ((this.l) && (o0.a >= 23)) {
      g0(paramt1);
    } else {
      f0(paramt1, R());
    }
  }
  
  public void f(int paramInt)
  {
    if (this.V != paramInt)
    {
      this.V = paramInt;
      boolean bool;
      if (paramInt != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.U = bool;
      flush();
    }
  }
  
  public void flush()
  {
    if (W())
    {
      e0();
      if (this.j.j()) {
        this.t.pause();
      }
      if (Y(this.t)) {
        ((h)g.e(this.n)).b(this.t);
      }
      final AudioTrack localAudioTrack = this.t;
      this.t = null;
      if ((o0.a < 21) && (!this.U)) {
        this.V = 0;
      }
      c localc = this.r;
      if (localc != null)
      {
        this.s = localc;
        this.r = null;
      }
      this.j.r();
      this.i.close();
      new a("ExoPlayer:AudioTrackReleaseThread", localAudioTrack).start();
    }
    this.p.a();
    this.o.a();
  }
  
  public void g()
  {
    if (this.X)
    {
      this.X = false;
      flush();
    }
  }
  
  public void h(p paramp)
  {
    if (this.u.equals(paramp)) {
      return;
    }
    this.u = paramp;
    if (this.X) {
      return;
    }
    flush();
  }
  
  public boolean i(ByteBuffer paramByteBuffer, long paramLong, int paramInt)
    throws AudioSink.InitializationException, AudioSink.WriteException
  {
    Object localObject = this.L;
    boolean bool;
    if ((localObject != null) && (paramByteBuffer != localObject)) {
      bool = false;
    } else {
      bool = true;
    }
    g.a(bool);
    if (this.r != null)
    {
      if (!H()) {
        return false;
      }
      if (!this.r.b(this.s))
      {
        b0();
        if (b()) {
          return false;
        }
        flush();
      }
      else
      {
        this.s = this.r;
        this.r = null;
        if ((Y(this.t)) && (this.m != 3))
        {
          this.t.setOffloadEndOfStream();
          localObject = this.t;
          Format localFormat = this.s.a;
          ((AudioTrack)localObject).setOffloadDelayPadding(localFormat.X3, localFormat.Y3);
          this.a0 = true;
        }
      }
      D(paramLong);
    }
    if (!W()) {
      try
      {
        U();
      }
      catch (AudioSink.InitializationException paramByteBuffer)
      {
        if (!paramByteBuffer.isRecoverable)
        {
          this.o.b(paramByteBuffer);
          return false;
        }
        throw paramByteBuffer;
      }
    }
    this.o.a();
    if (this.G)
    {
      this.H = Math.max(0L, paramLong);
      this.F = false;
      this.G = false;
      if ((this.l) && (o0.a >= 23)) {
        g0(this.x);
      }
      D(paramLong);
      if (this.T) {
        play();
      }
    }
    if (!this.j.l(T())) {
      return false;
    }
    if (this.L == null)
    {
      if (paramByteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
        bool = true;
      } else {
        bool = false;
      }
      g.a(bool);
      if (!paramByteBuffer.hasRemaining()) {
        return true;
      }
      localObject = this.s;
      if ((((c)localObject).c != 0) && (this.E == 0))
      {
        int i1 = N(((c)localObject).g, paramByteBuffer);
        this.E = i1;
        if (i1 == 0) {
          return true;
        }
      }
      if (this.v != null)
      {
        if (!H()) {
          return false;
        }
        D(paramLong);
        this.v = null;
      }
      long l1 = this.H + this.s.n(S() - this.f.l());
      if ((!this.F) && (Math.abs(l1 - paramLong) > 200000L))
      {
        this.q.b(new AudioSink.UnexpectedDiscontinuityException(paramLong, l1));
        this.F = true;
      }
      if (this.F)
      {
        if (!H()) {
          return false;
        }
        l1 = paramLong - l1;
        this.H += l1;
        this.F = false;
        D(paramLong);
        localObject = this.q;
        if ((localObject != null) && (l1 != 0L)) {
          ((AudioSink.a)localObject).f();
        }
      }
      if (this.s.c == 0) {
        this.A += paramByteBuffer.remaining();
      } else {
        this.B += this.E * paramInt;
      }
      this.L = paramByteBuffer;
      this.M = paramInt;
    }
    c0(paramLong);
    if (!this.L.hasRemaining())
    {
      this.L = null;
      this.M = 0;
      return true;
    }
    if (this.j.k(T()))
    {
      u.h("DefaultAudioSink", "Resetting stalled audio track");
      flush();
      return true;
    }
    return false;
  }
  
  public void j(AudioSink.a parama)
  {
    this.q = parama;
  }
  
  public int k(Format paramFormat)
  {
    if ("audio/raw".equals(paramFormat.H3))
    {
      if (!o0.k0(paramFormat.W3))
      {
        i1 = paramFormat.W3;
        paramFormat = new StringBuilder(33);
        paramFormat.append("Invalid PCM encoding: ");
        paramFormat.append(i1);
        u.h("DefaultAudioSink", paramFormat.toString());
        return 0;
      }
      int i1 = paramFormat.W3;
      if ((i1 != 2) && ((!this.d) || (i1 != 4))) {
        return 1;
      }
      return 2;
    }
    if ((!this.Z) && (n0(paramFormat, this.u))) {
      return 2;
    }
    if (Z(paramFormat, this.b)) {
      return 2;
    }
    return 0;
  }
  
  public void l()
  {
    if (o0.a < 25)
    {
      flush();
      return;
    }
    this.p.a();
    this.o.a();
    if (!W()) {
      return;
    }
    e0();
    if (this.j.j()) {
      this.t.pause();
    }
    this.t.flush();
    this.j.r();
    w localw = this.j;
    AudioTrack localAudioTrack = this.t;
    c localc = this.s;
    boolean bool;
    if (localc.c == 2) {
      bool = true;
    } else {
      bool = false;
    }
    localw.t(localAudioTrack, bool, localc.g, localc.d, localc.h);
    this.G = true;
  }
  
  public void m(x paramx)
  {
    if (this.W.equals(paramx)) {
      return;
    }
    int i1 = paramx.a;
    float f1 = paramx.b;
    AudioTrack localAudioTrack = this.t;
    if (localAudioTrack != null)
    {
      if (this.W.a != i1) {
        localAudioTrack.attachAuxEffect(i1);
      }
      if (i1 != 0) {
        this.t.setAuxEffectSendLevel(f1);
      }
    }
    this.W = paramx;
  }
  
  public void n()
    throws AudioSink.WriteException
  {
    if ((!this.R) && (W()) && (H()))
    {
      b0();
      this.R = true;
    }
  }
  
  public long o(boolean paramBoolean)
  {
    if ((W()) && (!this.G)) {
      return F(E(Math.min(this.j.d(paramBoolean), this.s.i(T()))));
    }
    return Long.MIN_VALUE;
  }
  
  public void p()
  {
    this.F = true;
  }
  
  public void pause()
  {
    this.T = false;
    if ((W()) && (this.j.q())) {
      this.t.pause();
    }
  }
  
  public void play()
  {
    this.T = true;
    if (W())
    {
      this.j.v();
      this.t.play();
    }
  }
  
  public void q(float paramFloat)
  {
    if (this.I != paramFloat)
    {
      this.I = paramFloat;
      h0();
    }
  }
  
  public void r()
  {
    boolean bool;
    if (o0.a >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    g.g(this.U);
    if (!this.X)
    {
      this.X = true;
      flush();
    }
  }
  
  public void reset()
  {
    flush();
    AudioProcessor[] arrayOfAudioProcessor = this.g;
    int i1 = arrayOfAudioProcessor.length;
    for (int i2 = 0; i2 < i1; i2++) {
      arrayOfAudioProcessor[i2].reset();
    }
    arrayOfAudioProcessor = this.h;
    i1 = arrayOfAudioProcessor.length;
    for (i2 = 0; i2 < i1; i2++) {
      arrayOfAudioProcessor[i2].reset();
    }
    this.T = false;
    this.Z = false;
  }
  
  public void s(Format paramFormat, int paramInt, @Nullable int[] paramArrayOfInt)
    throws AudioSink.ConfigurationException
  {
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    if ("audio/raw".equals(paramFormat.H3))
    {
      g.a(o0.k0(paramFormat.W3));
      i1 = o0.W(paramFormat.W3, paramFormat.U3);
      if (m0(paramFormat.W3)) {
        localObject1 = this.h;
      } else {
        localObject1 = this.g;
      }
      this.f.n(paramFormat.X3, paramFormat.Y3);
      Object localObject2;
      if ((o0.a < 21) && (paramFormat.U3 == 8) && (paramArrayOfInt == null))
      {
        localObject2 = new int[6];
        for (i2 = 0;; i2++)
        {
          paramArrayOfInt = (int[])localObject2;
          if (i2 >= 6) {
            break;
          }
          localObject2[i2] = i2;
        }
      }
      this.e.l(paramArrayOfInt);
      paramArrayOfInt = new AudioProcessor.a(paramFormat.V3, paramFormat.U3, paramFormat.W3);
      i3 = localObject1.length;
      i2 = 0;
      while (i2 < i3)
      {
        Object localObject3 = localObject1[i2];
        try
        {
          localObject2 = ((AudioProcessor)localObject3).c(paramArrayOfInt);
          boolean bool = ((AudioProcessor)localObject3).isActive();
          if (bool) {
            paramArrayOfInt = (int[])localObject2;
          }
          i2++;
        }
        catch (AudioProcessor.UnhandledAudioFormatException paramArrayOfInt)
        {
          throw new AudioSink.ConfigurationException(paramArrayOfInt, paramFormat);
        }
      }
      i4 = paramArrayOfInt.d;
      i5 = paramArrayOfInt.b;
      i6 = o0.D(paramArrayOfInt.c);
      i3 = o0.W(i4, paramArrayOfInt.c);
      paramArrayOfInt = (int[])localObject1;
      i7 = 0;
      i2 = i1;
      i1 = i7;
    }
    else
    {
      paramArrayOfInt = new AudioProcessor[0];
      i2 = paramFormat.V3;
      if (n0(paramFormat, this.u))
      {
        i4 = com.google.android.exoplayer2.util.y.f((String)g.e(paramFormat.H3), paramFormat.p1);
        i6 = o0.D(paramFormat.U3);
        i1 = -1;
        i3 = -1;
        i5 = i2;
        i7 = 1;
        i2 = i1;
        i1 = i7;
      }
      else
      {
        localObject1 = M(paramFormat, this.b);
        if (localObject1 == null) {
          break label602;
        }
        i4 = ((Integer)((Pair)localObject1).first).intValue();
        i6 = ((Integer)((Pair)localObject1).second).intValue();
        i7 = -1;
        i3 = -1;
        i1 = 2;
        i5 = i2;
        i2 = i7;
      }
    }
    if (i4 != 0)
    {
      if (i6 != 0)
      {
        this.Z = false;
        paramFormat = new c(paramFormat, i2, i1, i3, i5, i6, i4, paramInt, this.l, paramArrayOfInt);
        if (W()) {
          this.r = paramFormat;
        } else {
          this.s = paramFormat;
        }
        return;
      }
      localObject1 = String.valueOf(paramFormat);
      paramArrayOfInt = new StringBuilder(((String)localObject1).length() + 54);
      paramArrayOfInt.append("Invalid output channel config (mode=");
      paramArrayOfInt.append(i1);
      paramArrayOfInt.append(") for: ");
      paramArrayOfInt.append((String)localObject1);
      throw new AudioSink.ConfigurationException(paramArrayOfInt.toString(), paramFormat);
    }
    paramArrayOfInt = String.valueOf(paramFormat);
    Object localObject1 = new StringBuilder(paramArrayOfInt.length() + 48);
    ((StringBuilder)localObject1).append("Invalid output encoding (mode=");
    ((StringBuilder)localObject1).append(i1);
    ((StringBuilder)localObject1).append(") for: ");
    ((StringBuilder)localObject1).append(paramArrayOfInt);
    throw new AudioSink.ConfigurationException(((StringBuilder)localObject1).toString(), paramFormat);
    label602:
    paramArrayOfInt = String.valueOf(paramFormat);
    localObject1 = new StringBuilder(paramArrayOfInt.length() + 37);
    ((StringBuilder)localObject1).append("Unable to configure passthrough for: ");
    ((StringBuilder)localObject1).append(paramArrayOfInt);
    throw new AudioSink.ConfigurationException(((StringBuilder)localObject1).toString(), paramFormat);
  }
  
  public void t(boolean paramBoolean)
  {
    f0(K(), paramBoolean);
  }
  
  public static final class InvalidAudioTrackTimestampException
    extends RuntimeException
  {
    private InvalidAudioTrackTimestampException(String paramString)
    {
      super();
    }
  }
  
  class a
    extends Thread
  {
    a(String paramString, AudioTrack paramAudioTrack)
    {
      super();
    }
    
    public void run()
    {
      try
      {
        localAudioTrack.flush();
        localAudioTrack.release();
        return;
      }
      finally
      {
        DefaultAudioSink.w(DefaultAudioSink.this).open();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract long a(long paramLong);
    
    public abstract AudioProcessor[] b();
    
    public abstract t1 c(t1 paramt1);
    
    public abstract long d();
    
    public abstract boolean e(boolean paramBoolean);
  }
  
  private static final class c
  {
    public final Format a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final AudioProcessor[] i;
    
    public c(Format paramFormat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean, AudioProcessor[] paramArrayOfAudioProcessor)
    {
      this.a = paramFormat;
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramInt3;
      this.e = paramInt4;
      this.f = paramInt5;
      this.g = paramInt6;
      this.i = paramArrayOfAudioProcessor;
      this.h = c(paramInt7, paramBoolean);
    }
    
    private int c(int paramInt, boolean paramBoolean)
    {
      if (paramInt != 0) {
        return paramInt;
      }
      paramInt = this.c;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt == 2) {
            return l(250000L);
          }
          throw new IllegalStateException();
        }
        return l(50000000L);
      }
      float f1;
      if (paramBoolean) {
        f1 = 8.0F;
      } else {
        f1 = 1.0F;
      }
      return m(f1);
    }
    
    private AudioTrack d(boolean paramBoolean, p paramp, int paramInt)
    {
      int j = o0.a;
      if (j >= 29) {
        return f(paramBoolean, paramp, paramInt);
      }
      if (j >= 21) {
        return e(paramBoolean, paramp, paramInt);
      }
      return g(paramp, paramInt);
    }
    
    @RequiresApi(21)
    private AudioTrack e(boolean paramBoolean, p paramp, int paramInt)
    {
      return new AudioTrack(j(paramp, paramBoolean), DefaultAudioSink.u(this.e, this.f, this.g), this.h, 1, paramInt);
    }
    
    @RequiresApi(29)
    private AudioTrack f(boolean paramBoolean, p paramp, int paramInt)
    {
      AudioFormat localAudioFormat = DefaultAudioSink.u(this.e, this.f, this.g);
      paramp = j(paramp, paramBoolean);
      paramp = new AudioTrack.Builder().setAudioAttributes(paramp).setAudioFormat(localAudioFormat);
      paramBoolean = true;
      paramp = paramp.setTransferMode(1).setBufferSizeInBytes(this.h).setSessionId(paramInt);
      if (this.c != 1) {
        paramBoolean = false;
      }
      return paramp.setOffloadedPlayback(paramBoolean).build();
    }
    
    private AudioTrack g(p paramp, int paramInt)
    {
      int j = o0.Y(paramp.e);
      if (paramInt == 0) {
        return new AudioTrack(j, this.e, this.f, this.g, this.h, 1);
      }
      return new AudioTrack(j, this.e, this.f, this.g, this.h, 1, paramInt);
    }
    
    @RequiresApi(21)
    private static AudioAttributes j(p paramp, boolean paramBoolean)
    {
      if (paramBoolean) {
        return k();
      }
      return paramp.a();
    }
    
    @RequiresApi(21)
    private static AudioAttributes k()
    {
      return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
    }
    
    private int l(long paramLong)
    {
      int j = DefaultAudioSink.v(this.g);
      int k = j;
      if (this.g == 5) {
        k = j * 2;
      }
      return (int)(paramLong * k / 1000000L);
    }
    
    private int m(float paramFloat)
    {
      int j = AudioTrack.getMinBufferSize(this.e, this.f, this.g);
      boolean bool;
      if (j != -2) {
        bool = true;
      } else {
        bool = false;
      }
      g.g(bool);
      int k = o0.p(j * 4, (int)h(250000L) * this.d, Math.max(j, (int)h(750000L) * this.d));
      j = k;
      if (paramFloat != 1.0F) {
        j = Math.round(k * paramFloat);
      }
      return j;
    }
    
    /* Error */
    public AudioTrack a(boolean paramBoolean, p paramp, int paramInt)
      throws AudioSink.InitializationException
    {
      // Byte code:
      //   0: aload_0
      //   1: iload_1
      //   2: aload_2
      //   3: iload_3
      //   4: invokespecial 195	com/google/android/exoplayer2/audio/DefaultAudioSink$c:d	(ZLcom/google/android/exoplayer2/audio/p;I)Landroid/media/AudioTrack;
      //   7: astore_2
      //   8: aload_2
      //   9: invokevirtual 199	android/media/AudioTrack:getState	()I
      //   12: istore_3
      //   13: iload_3
      //   14: iconst_1
      //   15: if_icmpne +5 -> 20
      //   18: aload_2
      //   19: areturn
      //   20: aload_2
      //   21: invokevirtual 202	android/media/AudioTrack:release	()V
      //   24: new 187	com/google/android/exoplayer2/audio/AudioSink$InitializationException
      //   27: dup
      //   28: iload_3
      //   29: aload_0
      //   30: getfield 33	com/google/android/exoplayer2/audio/DefaultAudioSink$c:e	I
      //   33: aload_0
      //   34: getfield 35	com/google/android/exoplayer2/audio/DefaultAudioSink$c:f	I
      //   37: aload_0
      //   38: getfield 44	com/google/android/exoplayer2/audio/DefaultAudioSink$c:h	I
      //   41: aload_0
      //   42: getfield 25	com/google/android/exoplayer2/audio/DefaultAudioSink$c:a	Lcom/google/android/exoplayer2/Format;
      //   45: aload_0
      //   46: invokevirtual 206	com/google/android/exoplayer2/audio/DefaultAudioSink$c:o	()Z
      //   49: aconst_null
      //   50: invokespecial 209	com/google/android/exoplayer2/audio/AudioSink$InitializationException:<init>	(IIIILcom/google/android/exoplayer2/Format;ZLjava/lang/Exception;)V
      //   53: athrow
      //   54: astore_2
      //   55: goto +4 -> 59
      //   58: astore_2
      //   59: new 187	com/google/android/exoplayer2/audio/AudioSink$InitializationException
      //   62: dup
      //   63: iconst_0
      //   64: aload_0
      //   65: getfield 33	com/google/android/exoplayer2/audio/DefaultAudioSink$c:e	I
      //   68: aload_0
      //   69: getfield 35	com/google/android/exoplayer2/audio/DefaultAudioSink$c:f	I
      //   72: aload_0
      //   73: getfield 44	com/google/android/exoplayer2/audio/DefaultAudioSink$c:h	I
      //   76: aload_0
      //   77: getfield 25	com/google/android/exoplayer2/audio/DefaultAudioSink$c:a	Lcom/google/android/exoplayer2/Format;
      //   80: aload_0
      //   81: invokevirtual 206	com/google/android/exoplayer2/audio/DefaultAudioSink$c:o	()Z
      //   84: aload_2
      //   85: invokespecial 209	com/google/android/exoplayer2/audio/AudioSink$InitializationException:<init>	(IIIILcom/google/android/exoplayer2/Format;ZLjava/lang/Exception;)V
      //   88: athrow
      //   89: astore_2
      //   90: goto -66 -> 24
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	93	0	this	c
      //   0	93	1	paramBoolean	boolean
      //   0	93	2	paramp	p
      //   0	93	3	paramInt	int
      // Exception table:
      //   from	to	target	type
      //   0	8	54	java/lang/IllegalArgumentException
      //   0	8	58	java/lang/UnsupportedOperationException
      //   20	24	89	java/lang/Exception
    }
    
    public boolean b(c paramc)
    {
      boolean bool;
      if ((paramc.c == this.c) && (paramc.g == this.g) && (paramc.e == this.e) && (paramc.f == this.f) && (paramc.d == this.d)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public long h(long paramLong)
    {
      return paramLong * this.e / 1000000L;
    }
    
    public long i(long paramLong)
    {
      return paramLong * 1000000L / this.e;
    }
    
    public long n(long paramLong)
    {
      return paramLong * 1000000L / this.a.V3;
    }
    
    public boolean o()
    {
      int j = this.c;
      boolean bool = true;
      if (j != 1) {
        bool = false;
      }
      return bool;
    }
  }
  
  public static class d
    implements DefaultAudioSink.b
  {
    private final AudioProcessor[] a;
    private final h0 b;
    private final j0 c;
    
    public d(AudioProcessor... paramVarArgs)
    {
      this(paramVarArgs, new h0(), new j0());
    }
    
    public d(AudioProcessor[] paramArrayOfAudioProcessor, h0 paramh0, j0 paramj0)
    {
      AudioProcessor[] arrayOfAudioProcessor = new AudioProcessor[paramArrayOfAudioProcessor.length + 2];
      this.a = arrayOfAudioProcessor;
      System.arraycopy(paramArrayOfAudioProcessor, 0, arrayOfAudioProcessor, 0, paramArrayOfAudioProcessor.length);
      this.b = paramh0;
      this.c = paramj0;
      arrayOfAudioProcessor[paramArrayOfAudioProcessor.length] = paramh0;
      arrayOfAudioProcessor[(paramArrayOfAudioProcessor.length + 1)] = paramj0;
    }
    
    public long a(long paramLong)
    {
      return this.c.f(paramLong);
    }
    
    public AudioProcessor[] b()
    {
      return this.a;
    }
    
    public t1 c(t1 paramt1)
    {
      this.c.h(paramt1.c);
      this.c.g(paramt1.d);
      return paramt1;
    }
    
    public long d()
    {
      return this.b.o();
    }
    
    public boolean e(boolean paramBoolean)
    {
      this.b.u(paramBoolean);
      return paramBoolean;
    }
  }
  
  private static final class e
  {
    public final t1 a;
    public final boolean b;
    public final long c;
    public final long d;
    
    private e(t1 paramt1, boolean paramBoolean, long paramLong1, long paramLong2)
    {
      this.a = paramt1;
      this.b = paramBoolean;
      this.c = paramLong1;
      this.d = paramLong2;
    }
  }
  
  private static final class f<T extends Exception>
  {
    private final long a;
    @Nullable
    private T b;
    private long c;
    
    public f(long paramLong)
    {
      this.a = paramLong;
    }
    
    public void a()
    {
      this.b = null;
    }
    
    public void b(T paramT)
      throws Exception
    {
      long l = SystemClock.elapsedRealtime();
      if (this.b == null)
      {
        this.b = paramT;
        this.c = (this.a + l);
      }
      if (l >= this.c)
      {
        Exception localException = this.b;
        if (localException != paramT) {
          localException.addSuppressed(paramT);
        }
        paramT = this.b;
        a();
        throw paramT;
      }
    }
  }
  
  private final class g
    implements w.a
  {
    private g() {}
    
    public void a(int paramInt, long paramLong)
    {
      if (DefaultAudioSink.y(DefaultAudioSink.this) != null)
      {
        long l1 = SystemClock.elapsedRealtime();
        long l2 = DefaultAudioSink.C(DefaultAudioSink.this);
        DefaultAudioSink.y(DefaultAudioSink.this).e(paramInt, paramLong, l1 - l2);
      }
    }
    
    public void b(long paramLong)
    {
      StringBuilder localStringBuilder = new StringBuilder(61);
      localStringBuilder.append("Ignoring impossibly large audio latency: ");
      localStringBuilder.append(paramLong);
      u.h("DefaultAudioSink", localStringBuilder.toString());
    }
    
    public void c(long paramLong)
    {
      if (DefaultAudioSink.y(DefaultAudioSink.this) != null) {
        DefaultAudioSink.y(DefaultAudioSink.this).c(paramLong);
      }
    }
    
    public void d(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
    {
      long l1 = DefaultAudioSink.A(DefaultAudioSink.this);
      long l2 = DefaultAudioSink.B(DefaultAudioSink.this);
      Object localObject = new StringBuilder(182);
      ((StringBuilder)localObject).append("Spurious audio timestamp (frame position mismatch): ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramLong3);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramLong4);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(l2);
      localObject = ((StringBuilder)localObject).toString();
      if (!DefaultAudioSink.a)
      {
        u.h("DefaultAudioSink", (String)localObject);
        return;
      }
      throw new DefaultAudioSink.InvalidAudioTrackTimestampException((String)localObject, null);
    }
    
    public void e(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
    {
      long l1 = DefaultAudioSink.A(DefaultAudioSink.this);
      long l2 = DefaultAudioSink.B(DefaultAudioSink.this);
      Object localObject = new StringBuilder(180);
      ((StringBuilder)localObject).append("Spurious audio timestamp (system clock mismatch): ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramLong3);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramLong4);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(l2);
      localObject = ((StringBuilder)localObject).toString();
      if (!DefaultAudioSink.a)
      {
        u.h("DefaultAudioSink", (String)localObject);
        return;
      }
      throw new DefaultAudioSink.InvalidAudioTrackTimestampException((String)localObject, null);
    }
  }
  
  @RequiresApi(29)
  private final class h
  {
    private final Handler a = new Handler();
    private final AudioTrack.StreamEventCallback b = new a(DefaultAudioSink.this);
    
    public h() {}
    
    public void a(AudioTrack paramAudioTrack)
    {
      Handler localHandler = this.a;
      Objects.requireNonNull(localHandler);
      paramAudioTrack.registerStreamEventCallback(new l(localHandler), this.b);
    }
    
    public void b(AudioTrack paramAudioTrack)
    {
      paramAudioTrack.unregisterStreamEventCallback(this.b);
      this.a.removeCallbacksAndMessages(null);
    }
    
    class a
      extends AudioTrack.StreamEventCallback
    {
      a(DefaultAudioSink paramDefaultAudioSink) {}
      
      public void onDataRequest(AudioTrack paramAudioTrack, int paramInt)
      {
        boolean bool;
        if (paramAudioTrack == DefaultAudioSink.x(DefaultAudioSink.this)) {
          bool = true;
        } else {
          bool = false;
        }
        g.g(bool);
        if ((DefaultAudioSink.y(DefaultAudioSink.this) != null) && (DefaultAudioSink.z(DefaultAudioSink.this))) {
          DefaultAudioSink.y(DefaultAudioSink.this).g();
        }
      }
      
      public void onTearDown(@NonNull AudioTrack paramAudioTrack)
      {
        boolean bool;
        if (paramAudioTrack == DefaultAudioSink.x(DefaultAudioSink.this)) {
          bool = true;
        } else {
          bool = false;
        }
        g.g(bool);
        if ((DefaultAudioSink.y(DefaultAudioSink.this) != null) && (DefaultAudioSink.z(DefaultAudioSink.this))) {
          DefaultAudioSink.y(DefaultAudioSink.this).g();
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\DefaultAudioSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */