package com.google.android.exoplayer2.audio;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.c2;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.decoder.c;
import com.google.android.exoplayer2.decoder.d;
import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.decoder.f;
import com.google.android.exoplayer2.decoder.h;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.d0;
import com.google.android.exoplayer2.e2;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.t1;
import com.google.android.exoplayer2.u0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.w;
import com.google.android.exoplayer2.util.y;

public abstract class a0<T extends c<DecoderInputBuffer, ? extends h, ? extends DecoderException>>
  extends u0
  implements w
{
  private final t.a I3;
  private final AudioSink J3;
  private final DecoderInputBuffer K3;
  private d L3;
  private Format M3;
  private int N3;
  private int O3;
  private boolean P3;
  @Nullable
  private T Q3;
  @Nullable
  private DecoderInputBuffer R3;
  @Nullable
  private h S3;
  @Nullable
  private DrmSession T3;
  @Nullable
  private DrmSession U3;
  private int V3;
  private boolean W3;
  private boolean X3;
  private long Y3;
  private boolean Z3;
  private boolean a4;
  private boolean b4;
  private boolean c4;
  
  public a0(@Nullable Handler paramHandler, @Nullable t paramt, AudioSink paramAudioSink)
  {
    super(1);
    this.I3 = new t.a(paramHandler, paramt);
    this.J3 = paramAudioSink;
    paramAudioSink.j(new b(null));
    this.K3 = DecoderInputBuffer.r();
    this.V3 = 0;
    this.X3 = true;
  }
  
  private boolean Q()
    throws ExoPlaybackException, DecoderException, AudioSink.ConfigurationException, AudioSink.InitializationException, AudioSink.WriteException
  {
    if (this.S3 == null)
    {
      Object localObject1 = (h)this.Q3.b();
      this.S3 = ((h)localObject1);
      if (localObject1 == null) {
        return false;
      }
      int i = ((f)localObject1).f;
      if (i > 0)
      {
        localObject1 = this.L3;
        ((d)localObject1).f += i;
        this.J3.p();
      }
    }
    if (this.S3.k())
    {
      if (this.V3 == 2)
      {
        Z();
        U();
        this.X3 = true;
      }
      else
      {
        this.S3.n();
        this.S3 = null;
      }
      try
      {
        Y();
        return false;
      }
      catch (AudioSink.WriteException localWriteException)
      {
        throw y(localWriteException, localWriteException.format, localWriteException.isRecoverable, 5002);
      }
    }
    if (this.X3)
    {
      localObject2 = T(this.Q3).a().M(this.N3).N(this.O3).E();
      this.J3.s((Format)localObject2, 0, null);
      this.X3 = false;
    }
    AudioSink localAudioSink = this.J3;
    Object localObject2 = this.S3;
    if (localAudioSink.i(((h)localObject2).x, ((f)localObject2).d, 1))
    {
      localObject2 = this.L3;
      ((d)localObject2).e += 1;
      this.S3.n();
      this.S3 = null;
      return true;
    }
    return false;
  }
  
  private boolean R()
    throws DecoderException, ExoPlaybackException
  {
    Object localObject = this.Q3;
    if ((localObject != null) && (this.V3 != 2) && (!this.b4))
    {
      if (this.R3 == null)
      {
        localObject = (DecoderInputBuffer)((c)localObject).d();
        this.R3 = ((DecoderInputBuffer)localObject);
        if (localObject == null) {
          return false;
        }
      }
      if (this.V3 == 1)
      {
        this.R3.m(4);
        this.Q3.c(this.R3);
        this.R3 = null;
        this.V3 = 2;
        return false;
      }
      localObject = A();
      int i = L((i1)localObject, this.R3, 0);
      if (i != -5)
      {
        if (i != -4)
        {
          if (i == -3) {
            return false;
          }
          throw new IllegalStateException();
        }
        if (this.R3.k())
        {
          this.b4 = true;
          this.Q3.c(this.R3);
          this.R3 = null;
          return false;
        }
        this.R3.p();
        X(this.R3);
        this.Q3.c(this.R3);
        this.W3 = true;
        localObject = this.L3;
        ((d)localObject).c += 1;
        this.R3 = null;
        return true;
      }
      V((i1)localObject);
      return true;
    }
    return false;
  }
  
  private void S()
    throws ExoPlaybackException
  {
    if (this.V3 != 0)
    {
      Z();
      U();
    }
    else
    {
      this.R3 = null;
      h localh = this.S3;
      if (localh != null)
      {
        localh.n();
        this.S3 = null;
      }
      this.Q3.flush();
      this.W3 = false;
    }
  }
  
  private void U()
    throws ExoPlaybackException
  {
    if (this.Q3 != null) {
      return;
    }
    a0(this.U3);
    Object localObject1 = null;
    Object localObject2 = this.T3;
    if (localObject2 != null)
    {
      localObject2 = ((DrmSession)localObject2).e();
      localObject1 = localObject2;
      if (localObject2 == null) {
        if (this.T3.f() != null) {
          localObject1 = localObject2;
        } else {
          return;
        }
      }
    }
    try
    {
      long l1 = SystemClock.elapsedRealtime();
      m0.a("createAudioDecoder");
      this.Q3 = P(this.M3, (d0)localObject1);
      m0.c();
      long l2 = SystemClock.elapsedRealtime();
      this.I3.c(this.Q3.getName(), l2, l2 - l1);
      localObject1 = this.L3;
      ((d)localObject1).a += 1;
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      throw x(localOutOfMemoryError, this.M3, 4001);
    }
    catch (DecoderException localDecoderException)
    {
      u.d("DecoderAudioRenderer", "Audio codec error", localDecoderException);
      this.I3.a(localDecoderException);
      throw x(localDecoderException, this.M3, 4001);
    }
  }
  
  private void V(i1 parami1)
    throws ExoPlaybackException
  {
    Format localFormat = (Format)g.e(parami1.b);
    b0(parami1.a);
    parami1 = this.M3;
    this.M3 = localFormat;
    this.N3 = localFormat.X3;
    this.O3 = localFormat.Y3;
    c localc = this.Q3;
    if (localc == null)
    {
      U();
      this.I3.g(this.M3, null);
      return;
    }
    if (this.U3 != this.T3) {
      parami1 = new e(localc.getName(), parami1, localFormat, 0, 128);
    } else {
      parami1 = O(localc.getName(), parami1, localFormat);
    }
    if (parami1.d == 0) {
      if (this.W3)
      {
        this.V3 = 1;
      }
      else
      {
        Z();
        U();
        this.X3 = true;
      }
    }
    this.I3.g(this.M3, parami1);
  }
  
  private void Y()
    throws AudioSink.WriteException
  {
    this.c4 = true;
    this.J3.n();
  }
  
  private void Z()
  {
    this.R3 = null;
    this.S3 = null;
    this.V3 = 0;
    this.W3 = false;
    c localc = this.Q3;
    if (localc != null)
    {
      d locald = this.L3;
      locald.b += 1;
      localc.release();
      this.I3.d(this.Q3.getName());
      this.Q3 = null;
    }
    a0(null);
  }
  
  private void a0(@Nullable DrmSession paramDrmSession)
  {
    com.google.android.exoplayer2.drm.t.a(this.T3, paramDrmSession);
    this.T3 = paramDrmSession;
  }
  
  private void b0(@Nullable DrmSession paramDrmSession)
  {
    com.google.android.exoplayer2.drm.t.a(this.U3, paramDrmSession);
    this.U3 = paramDrmSession;
  }
  
  private void d0()
  {
    long l = this.J3.o(d());
    if (l != Long.MIN_VALUE)
    {
      if (!this.a4) {
        l = Math.max(this.Y3, l);
      }
      this.Y3 = l;
      this.a4 = false;
    }
  }
  
  protected void E()
  {
    this.M3 = null;
    this.X3 = true;
    try
    {
      b0(null);
      Z();
      this.J3.reset();
      return;
    }
    finally
    {
      this.I3.e(this.L3);
    }
  }
  
  protected void F(boolean paramBoolean1, boolean paramBoolean2)
    throws ExoPlaybackException
  {
    d locald = new d();
    this.L3 = locald;
    this.I3.f(locald);
    if (z().b) {
      this.J3.r();
    } else {
      this.J3.g();
    }
  }
  
  protected void G(long paramLong, boolean paramBoolean)
    throws ExoPlaybackException
  {
    if (this.P3) {
      this.J3.l();
    } else {
      this.J3.flush();
    }
    this.Y3 = paramLong;
    this.Z3 = true;
    this.a4 = true;
    this.b4 = false;
    this.c4 = false;
    if (this.Q3 != null) {
      S();
    }
  }
  
  protected void I()
  {
    this.J3.play();
  }
  
  protected void J()
  {
    d0();
    this.J3.pause();
  }
  
  protected e O(String paramString, Format paramFormat1, Format paramFormat2)
  {
    return new e(paramString, paramFormat1, paramFormat2, 0, 1);
  }
  
  protected abstract T P(Format paramFormat, @Nullable d0 paramd0)
    throws DecoderException;
  
  protected abstract Format T(T paramT);
  
  @CallSuper
  protected void W()
  {
    this.a4 = true;
  }
  
  protected void X(DecoderInputBuffer paramDecoderInputBuffer)
  {
    if ((this.Z3) && (!paramDecoderInputBuffer.j()))
    {
      if (Math.abs(paramDecoderInputBuffer.x - this.Y3) > 500000L) {
        this.Y3 = paramDecoderInputBuffer.x;
      }
      this.Z3 = false;
    }
  }
  
  public final int a(Format paramFormat)
  {
    boolean bool = y.o(paramFormat.H3);
    int i = 0;
    if (!bool) {
      return c2.a(0);
    }
    int j = c0(paramFormat);
    if (j <= 2) {
      return c2.a(j);
    }
    if (o0.a >= 21) {
      i = 32;
    }
    return c2.b(j, 8, i);
  }
  
  public t1 c()
  {
    return this.J3.c();
  }
  
  protected abstract int c0(Format paramFormat);
  
  public boolean d()
  {
    boolean bool;
    if ((this.c4) && (this.J3.d())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void e(t1 paramt1)
  {
    this.J3.e(paramt1);
  }
  
  public boolean g()
  {
    boolean bool;
    if ((!this.J3.b()) && ((this.M3 == null) || ((!D()) && (this.S3 == null)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
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
          if (paramInt != 101)
          {
            if (paramInt != 102) {
              super.k(paramInt, paramObject);
            } else {
              this.J3.f(((Integer)paramObject).intValue());
            }
          }
          else {
            this.J3.t(((Boolean)paramObject).booleanValue());
          }
        }
        else
        {
          paramObject = (x)paramObject;
          this.J3.m((x)paramObject);
        }
      }
      else
      {
        paramObject = (p)paramObject;
        this.J3.h((p)paramObject);
      }
    }
    else {
      this.J3.q(((Float)paramObject).floatValue());
    }
  }
  
  public long p()
  {
    if (getState() == 2) {
      d0();
    }
    return this.Y3;
  }
  
  public void t(long paramLong1, long paramLong2)
    throws ExoPlaybackException
  {
    if (this.c4) {
      try
      {
        this.J3.n();
        return;
      }
      catch (AudioSink.WriteException localWriteException1)
      {
        throw y(localWriteException1, localWriteException1.format, localWriteException1.isRecoverable, 5002);
      }
    }
    if (this.M3 == null)
    {
      i1 locali1 = A();
      this.K3.f();
      int i = L(locali1, this.K3, 2);
      if (i == -5)
      {
        V(locali1);
      }
      else
      {
        if (i == -4)
        {
          g.g(this.K3.k());
          this.b4 = true;
          try
          {
            Y();
            return;
          }
          catch (AudioSink.WriteException localWriteException2)
          {
            throw x(localWriteException2, null, 5002);
          }
        }
        return;
      }
    }
    U();
    if (this.Q3 != null) {
      try
      {
        m0.a("drainAndFeed");
        while (Q()) {}
        while (R()) {}
        m0.c();
        this.L3.c();
      }
      catch (AudioSink.WriteException localWriteException3)
      {
        throw y(localWriteException3, localWriteException3.format, localWriteException3.isRecoverable, 5002);
      }
      catch (AudioSink.InitializationException localInitializationException)
      {
        throw y(localInitializationException, localInitializationException.format, localInitializationException.isRecoverable, 5001);
      }
      catch (AudioSink.ConfigurationException localConfigurationException)
      {
        throw x(localConfigurationException, localConfigurationException.format, 5001);
      }
      catch (DecoderException localDecoderException)
      {
        u.d("DecoderAudioRenderer", "Audio codec error", localDecoderException);
        this.I3.a(localDecoderException);
        throw x(localDecoderException, this.M3, 4003);
      }
    }
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
      a0.N(a0.this).C(paramBoolean);
    }
    
    public void b(Exception paramException)
    {
      u.d("DecoderAudioRenderer", "Audio sink error", paramException);
      a0.N(a0.this).b(paramException);
    }
    
    public void c(long paramLong)
    {
      a0.N(a0.this).B(paramLong);
    }
    
    public void e(int paramInt, long paramLong1, long paramLong2)
    {
      a0.N(a0.this).D(paramInt, paramLong1, paramLong2);
    }
    
    public void f()
    {
      a0.this.W();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\a0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */