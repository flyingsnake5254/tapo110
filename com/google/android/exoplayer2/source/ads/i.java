package com.google.android.exoplayer2.source.ads;

import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.j2.b;
import com.google.android.exoplayer2.source.v;

@VisibleForTesting(otherwise=3)
public final class i
  extends v
{
  private final g d;
  
  public i(j2 paramj2, g paramg)
  {
    super(paramj2);
    int i = paramj2.i();
    boolean bool1 = false;
    if (i == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    com.google.android.exoplayer2.util.g.g(bool2);
    boolean bool2 = bool1;
    if (paramj2.p() == 1) {
      bool2 = true;
    }
    com.google.android.exoplayer2.util.g.g(bool2);
    this.d = paramg;
  }
  
  public j2.b g(int paramInt, j2.b paramb, boolean paramBoolean)
  {
    this.c.g(paramInt, paramb, paramBoolean);
    long l1 = paramb.e;
    long l2 = l1;
    if (l1 == -9223372036854775807L) {
      l2 = this.d.g;
    }
    paramb.r(paramb.b, paramb.c, paramb.d, l2, paramb.m(), this.d, paramb.g);
    return paramb;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\ads\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */