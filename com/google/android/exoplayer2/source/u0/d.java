package com.google.android.exoplayer2.source.u0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.util.g;

public abstract class d
  extends b
{
  public final long j;
  
  public d(l paraml, n paramn, Format paramFormat, int paramInt, @Nullable Object paramObject, long paramLong1, long paramLong2, long paramLong3)
  {
    super(paraml, paramn, 1, paramFormat, paramInt, paramObject, paramLong1, paramLong2);
    g.e(paramFormat);
    this.j = paramLong3;
  }
  
  public long g()
  {
    long l1 = this.j;
    long l2 = -1L;
    if (l1 != -1L) {
      l2 = 1L + l1;
    }
    return l2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\u0\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */