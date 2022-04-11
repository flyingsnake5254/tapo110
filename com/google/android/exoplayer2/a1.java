package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.upstream.o;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;

public class a1
  implements k1
{
  private final o a;
  private final long b;
  private final long c;
  private final long d;
  private final long e;
  private final int f;
  private final boolean g;
  private final long h;
  private final boolean i;
  private int j;
  private boolean k;
  
  public a1()
  {
    this(new o(true, 65536), 50000, 50000, 2500, 5000, -1, false, 0, false);
  }
  
  protected a1(o paramo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, int paramInt6, boolean paramBoolean2)
  {
    a(paramInt3, 0, "bufferForPlaybackMs", "0");
    a(paramInt4, 0, "bufferForPlaybackAfterRebufferMs", "0");
    a(paramInt1, paramInt3, "minBufferMs", "bufferForPlaybackMs");
    a(paramInt1, paramInt4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
    a(paramInt2, paramInt1, "maxBufferMs", "minBufferMs");
    a(paramInt6, 0, "backBufferDurationMs", "0");
    this.a = paramo;
    this.b = w0.d(paramInt1);
    this.c = w0.d(paramInt2);
    this.d = w0.d(paramInt3);
    this.e = w0.d(paramInt4);
    this.f = paramInt5;
    if (paramInt5 == -1) {
      paramInt5 = 13107200;
    }
    this.j = paramInt5;
    this.g = paramBoolean1;
    this.h = w0.d(paramInt6);
    this.i = paramBoolean2;
  }
  
  private static void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    boolean bool;
    if (paramInt1 >= paramInt2) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString1).length() + 21 + String.valueOf(paramString2).length());
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" cannot be less than ");
    localStringBuilder.append(paramString2);
    com.google.android.exoplayer2.util.g.b(bool, localStringBuilder.toString());
  }
  
  private static int k(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if ((paramInt != 3) && (paramInt != 5) && (paramInt != 6))
          {
            if (paramInt == 7) {
              return 0;
            }
            throw new IllegalArgumentException();
          }
          return 131072;
        }
        return 131072000;
      }
      return 13107200;
    }
    return 144310272;
  }
  
  private void l(boolean paramBoolean)
  {
    int m = this.f;
    int n = m;
    if (m == -1) {
      n = 13107200;
    }
    this.j = n;
    this.k = false;
    if (paramBoolean) {
      this.a.g();
    }
  }
  
  public void b()
  {
    l(false);
  }
  
  public boolean c()
  {
    return this.i;
  }
  
  public long d()
  {
    return this.h;
  }
  
  public void e(b2[] paramArrayOfb2, TrackGroupArray paramTrackGroupArray, com.google.android.exoplayer2.trackselection.g[] paramArrayOfg)
  {
    int m = this.f;
    int n = m;
    if (m == -1) {
      n = j(paramArrayOfb2, paramArrayOfg);
    }
    this.j = n;
    this.a.h(n);
  }
  
  public boolean f(long paramLong1, float paramFloat, boolean paramBoolean, long paramLong2)
  {
    long l1 = o0.X(paramLong1, paramFloat);
    if (paramBoolean) {
      paramLong1 = this.e;
    } else {
      paramLong1 = this.d;
    }
    long l2 = paramLong1;
    if (paramLong2 != -9223372036854775807L) {
      l2 = Math.min(paramLong2 / 2L, paramLong1);
    }
    if ((l2 > 0L) && (l1 < l2) && ((this.g) || (this.a.f() < this.j))) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public void g()
  {
    l(true);
  }
  
  public e getAllocator()
  {
    return this.a;
  }
  
  public void h()
  {
    l(true);
  }
  
  public boolean i(long paramLong1, long paramLong2, float paramFloat)
  {
    int m = this.a.f();
    int n = this.j;
    boolean bool1 = true;
    if (m >= n) {
      n = 1;
    } else {
      n = 0;
    }
    long l = this.b;
    paramLong1 = l;
    if (paramFloat > 1.0F) {
      paramLong1 = Math.min(o0.S(l, paramFloat), this.c);
    }
    if (paramLong2 < Math.max(paramLong1, 500000L))
    {
      boolean bool2 = bool1;
      if (!this.g) {
        if (n == 0) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
      }
      this.k = bool2;
      if ((!bool2) && (paramLong2 < 500000L)) {
        u.h("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
      }
    }
    else if ((paramLong2 >= this.c) || (n != 0))
    {
      this.k = false;
    }
    return this.k;
  }
  
  protected int j(b2[] paramArrayOfb2, com.google.android.exoplayer2.trackselection.g[] paramArrayOfg)
  {
    int m = 0;
    int i1;
    for (int n = 0; m < paramArrayOfb2.length; n = i1)
    {
      i1 = n;
      if (paramArrayOfg[m] != null) {
        i1 = n + k(paramArrayOfb2[m].f());
      }
      m++;
    }
    return Math.max(13107200, n);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\a1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */