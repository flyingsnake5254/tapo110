package com.google.android.exoplayer2;

import java.util.Collections;
import java.util.List;

public abstract class t0
  implements u1
{
  protected final j2.c a = new j2.c();
  
  private int a0()
  {
    int i = getRepeatMode();
    int j = i;
    if (i == 1) {
      j = 0;
    }
    return j;
  }
  
  private void i0(long paramLong)
  {
    long l1 = V() + paramLong;
    long l2 = v();
    paramLong = l1;
    if (l2 != -9223372036854775807L) {
      paramLong = Math.min(l1, l2);
    }
    seekTo(Math.max(paramLong, 0L));
  }
  
  public final void D(l1 paraml1)
  {
    k0(Collections.singletonList(paraml1));
  }
  
  public final boolean O()
  {
    boolean bool;
    if ((getPlaybackState() == 3) && (E()) && (t() == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void S()
  {
    i0(L());
  }
  
  public final void T()
  {
    i0(-W());
  }
  
  public final long X()
  {
    j2 localj2 = w();
    long l;
    if (localj2.q()) {
      l = -9223372036854775807L;
    } else {
      l = localj2.n(m(), this.a).d();
    }
    return l;
  }
  
  public final int Y()
  {
    j2 localj2 = w();
    int i;
    if (localj2.q()) {
      i = -1;
    } else {
      i = localj2.e(m(), a0(), Q());
    }
    return i;
  }
  
  public final int Z()
  {
    j2 localj2 = w();
    int i;
    if (localj2.q()) {
      i = -1;
    } else {
      i = localj2.l(m(), a0(), Q());
    }
    return i;
  }
  
  public final void b()
  {
    l(0, Integer.MAX_VALUE);
  }
  
  public final boolean b0()
  {
    boolean bool;
    if (Y() != -1) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean c0()
  {
    boolean bool;
    if (Z() != -1) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected u1.b d(u1.b paramb)
  {
    paramb = new u1.b.a().b(paramb);
    boolean bool1 = f();
    boolean bool2 = true;
    paramb = paramb.d(3, bool1 ^ true);
    if ((h()) && (!f())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramb = paramb.d(4, bool1);
    if ((c0()) && (!f())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramb = paramb.d(5, bool1);
    if ((!w().q()) && ((c0()) || (!e0()) || (h())) && (!f())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramb = paramb.d(6, bool1);
    if ((b0()) && (!f())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramb = paramb.d(7, bool1);
    if ((!w().q()) && ((b0()) || ((e0()) && (d0()))) && (!f())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramb = paramb.d(8, bool1).d(9, f() ^ true);
    if ((h()) && (!f())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramb = paramb.d(10, bool1);
    if ((h()) && (!f())) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    return paramb.d(11, bool1).e();
  }
  
  public final boolean d0()
  {
    j2 localj2 = w();
    boolean bool;
    if ((!localj2.q()) && (localj2.n(m(), this.a).m)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean e0()
  {
    j2 localj2 = w();
    boolean bool;
    if ((!localj2.q()) && (localj2.n(m(), this.a).f())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void f0()
  {
    g0(m());
  }
  
  public final void g0(int paramInt)
  {
    B(paramInt, -9223372036854775807L);
  }
  
  public final boolean h()
  {
    j2 localj2 = w();
    boolean bool;
    if ((!localj2.q()) && (localj2.n(m(), this.a).l)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void h0()
  {
    int i = Y();
    if (i != -1) {
      g0(i);
    }
  }
  
  public final void j0()
  {
    int i = Z();
    if (i != -1) {
      g0(i);
    }
  }
  
  public final void k0(List<l1> paramList)
  {
    j(paramList, true);
  }
  
  public final void n()
  {
    if ((!w().q()) && (!f()))
    {
      boolean bool = c0();
      if ((e0()) && (!h()))
      {
        if (bool) {
          j0();
        }
      }
      else if ((bool) && (V() <= G())) {
        j0();
      } else {
        seekTo(0L);
      }
    }
  }
  
  public final void play()
  {
    p(true);
  }
  
  public final boolean s(int paramInt)
  {
    return C().b(paramInt);
  }
  
  public final void seekTo(long paramLong)
  {
    B(m(), paramLong);
  }
  
  public final void y()
  {
    if ((!w().q()) && (!f())) {
      if (b0()) {
        h0();
      } else if ((e0()) && (d0())) {
        f0();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\t0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */