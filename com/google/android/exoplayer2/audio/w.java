package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.w0;
import java.lang.reflect.Method;

final class w
{
  private long A;
  private long B;
  private long C;
  private boolean D;
  private long E;
  private long F;
  private final a a;
  private final long[] b;
  @Nullable
  private AudioTrack c;
  private int d;
  private int e;
  @Nullable
  private v f;
  private int g;
  private boolean h;
  private long i;
  private float j;
  private boolean k;
  private long l;
  private long m;
  @Nullable
  private Method n;
  private long o;
  private boolean p;
  private boolean q;
  private long r;
  private long s;
  private long t;
  private long u;
  private int v;
  private int w;
  private long x;
  private long y;
  private long z;
  
  public w(a parama)
  {
    this.a = ((a)g.e(parama));
    if (o0.a >= 18) {}
    try
    {
      this.n = AudioTrack.class.getMethod("getLatency", null);
      this.b = new long[10];
      return;
    }
    catch (NoSuchMethodException parama)
    {
      for (;;) {}
    }
  }
  
  private boolean a()
  {
    boolean bool;
    if ((this.h) && (((AudioTrack)g.e(this.c)).getPlayState() == 2) && (f() == 0L)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private long b(long paramLong)
  {
    return paramLong * 1000000L / this.g;
  }
  
  private long f()
  {
    AudioTrack localAudioTrack = (AudioTrack)g.e(this.c);
    if (this.x != -9223372036854775807L)
    {
      l1 = (SystemClock.elapsedRealtime() * 1000L - this.x) * this.g / 1000000L;
      return Math.min(this.A, this.z + l1);
    }
    int i1 = localAudioTrack.getPlayState();
    if (i1 == 1) {
      return 0L;
    }
    long l2 = 0xFFFFFFFF & localAudioTrack.getPlaybackHeadPosition();
    long l1 = l2;
    if (this.h)
    {
      if ((i1 == 2) && (l2 == 0L)) {
        this.u = this.s;
      }
      l1 = l2 + this.u;
    }
    if (o0.a <= 29)
    {
      if ((l1 == 0L) && (this.s > 0L) && (i1 == 3))
      {
        if (this.y == -9223372036854775807L) {
          this.y = SystemClock.elapsedRealtime();
        }
        return this.s;
      }
      this.y = -9223372036854775807L;
    }
    if (this.s > l1) {
      this.t += 1L;
    }
    this.s = l1;
    return l1 + (this.t << 32);
  }
  
  private long g()
  {
    return b(f());
  }
  
  private void m(long paramLong1, long paramLong2)
  {
    v localv = (v)g.e(this.f);
    if (!localv.e(paramLong1)) {
      return;
    }
    long l1 = localv.c();
    long l2 = localv.b();
    if (Math.abs(l1 - paramLong1) > 5000000L)
    {
      this.a.e(l2, l1, paramLong1, paramLong2);
      localv.f();
    }
    else if (Math.abs(b(l2) - paramLong2) > 5000000L)
    {
      this.a.d(l2, l1, paramLong1, paramLong2);
      localv.f();
    }
    else
    {
      localv.a();
    }
  }
  
  private void n()
  {
    long l1 = g();
    if (l1 == 0L) {
      return;
    }
    long l2 = System.nanoTime() / 1000L;
    if (l2 - this.m >= 30000L)
    {
      long[] arrayOfLong = this.b;
      int i1 = this.v;
      arrayOfLong[i1] = (l1 - l2);
      this.v = ((i1 + 1) % 10);
      i1 = this.w;
      if (i1 < 10) {
        this.w = (i1 + 1);
      }
      this.m = l2;
      this.l = 0L;
      for (i1 = 0;; i1++)
      {
        int i2 = this.w;
        if (i1 >= i2) {
          break;
        }
        this.l += this.b[i1] / i2;
      }
    }
    if (this.h) {
      return;
    }
    m(l2, l1);
    o(l2);
  }
  
  private void o(long paramLong)
  {
    if (this.q)
    {
      Method localMethod = this.n;
      if ((localMethod != null) && (paramLong - this.r >= 500000L))
      {
        try
        {
          long l1 = ((Integer)o0.i((Integer)localMethod.invoke(g.e(this.c), new Object[0]))).intValue() * 1000L - this.i;
          this.o = l1;
          l1 = Math.max(l1, 0L);
          this.o = l1;
          if (l1 > 5000000L)
          {
            this.a.b(l1);
            this.o = 0L;
          }
        }
        catch (Exception localException)
        {
          this.n = null;
        }
        this.r = paramLong;
      }
    }
  }
  
  private static boolean p(int paramInt)
  {
    boolean bool;
    if ((o0.a < 23) && ((paramInt == 5) || (paramInt == 6))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void s()
  {
    this.l = 0L;
    this.w = 0;
    this.v = 0;
    this.m = 0L;
    this.C = 0L;
    this.F = 0L;
    this.k = false;
  }
  
  public int c(long paramLong)
  {
    int i1 = (int)(paramLong - f() * this.d);
    return this.e - i1;
  }
  
  public long d(boolean paramBoolean)
  {
    if (((AudioTrack)g.e(this.c)).getPlayState() == 3) {
      n();
    }
    long l1 = System.nanoTime() / 1000L;
    v localv = (v)g.e(this.f);
    boolean bool = localv.d();
    long l2;
    if (bool)
    {
      l2 = b(localv.b()) + o0.S(l1 - localv.c(), this.j);
    }
    else
    {
      if (this.w == 0) {
        l3 = g();
      } else {
        l3 = this.l + l1;
      }
      l2 = l3;
      if (!paramBoolean) {
        l2 = Math.max(0L, l3 - this.o);
      }
    }
    if (this.D != bool)
    {
      this.F = this.C;
      this.E = this.B;
    }
    long l4 = l1 - this.F;
    long l3 = l2;
    long l5;
    if (l4 < 1000000L)
    {
      l5 = this.E;
      l3 = o0.S(l4, this.j);
      l4 = l4 * 1000L / 1000000L;
      l3 = (l2 * l4 + (1000L - l4) * (l5 + l3)) / 1000L;
    }
    if (!this.k)
    {
      l2 = this.B;
      if (l3 > l2)
      {
        this.k = true;
        l5 = o0.X(w0.e(l3 - l2), this.j);
        l2 = System.currentTimeMillis();
        l5 = w0.e(l5);
        this.a.c(l2 - l5);
      }
    }
    this.C = l1;
    this.B = l3;
    this.D = bool;
    return l3;
  }
  
  public long e(long paramLong)
  {
    return w0.e(b(paramLong - f()));
  }
  
  public void h(long paramLong)
  {
    this.z = f();
    this.x = (SystemClock.elapsedRealtime() * 1000L);
    this.A = paramLong;
  }
  
  public boolean i(long paramLong)
  {
    boolean bool;
    if ((paramLong <= f()) && (!a())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean j()
  {
    boolean bool;
    if (((AudioTrack)g.e(this.c)).getPlayState() == 3) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean k(long paramLong)
  {
    boolean bool;
    if ((this.y != -9223372036854775807L) && (paramLong > 0L) && (SystemClock.elapsedRealtime() - this.y >= 200L)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean l(long paramLong)
  {
    int i1 = ((AudioTrack)g.e(this.c)).getPlayState();
    if (this.h)
    {
      if (i1 == 2)
      {
        this.p = false;
        return false;
      }
      if ((i1 == 1) && (f() == 0L)) {
        return false;
      }
    }
    boolean bool1 = this.p;
    boolean bool2 = i(paramLong);
    this.p = bool2;
    if ((bool1) && (!bool2) && (i1 != 1)) {
      this.a.a(this.e, w0.e(this.i));
    }
    return true;
  }
  
  public boolean q()
  {
    s();
    if (this.x == -9223372036854775807L)
    {
      ((v)g.e(this.f)).g();
      return true;
    }
    return false;
  }
  
  public void r()
  {
    s();
    this.c = null;
    this.f = null;
  }
  
  public void t(AudioTrack paramAudioTrack, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramAudioTrack;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = new v(paramAudioTrack);
    this.g = paramAudioTrack.getSampleRate();
    if ((paramBoolean) && (p(paramInt1))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.h = paramBoolean;
    paramBoolean = o0.k0(paramInt1);
    this.q = paramBoolean;
    long l1;
    if (paramBoolean) {
      l1 = b(paramInt3 / paramInt2);
    } else {
      l1 = -9223372036854775807L;
    }
    this.i = l1;
    this.s = 0L;
    this.t = 0L;
    this.u = 0L;
    this.p = false;
    this.x = -9223372036854775807L;
    this.y = -9223372036854775807L;
    this.r = 0L;
    this.o = 0L;
    this.j = 1.0F;
  }
  
  public void u(float paramFloat)
  {
    this.j = paramFloat;
    v localv = this.f;
    if (localv != null) {
      localv.g();
    }
  }
  
  public void v()
  {
    ((v)g.e(this.f)).g();
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, long paramLong);
    
    public abstract void b(long paramLong);
    
    public abstract void c(long paramLong);
    
    public abstract void d(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
    
    public abstract void e(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */