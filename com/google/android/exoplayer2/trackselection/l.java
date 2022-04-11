package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.upstream.x.a;

public final class l
{
  public static x.a a(g paramg)
  {
    long l = SystemClock.elapsedRealtime();
    int i = paramg.length();
    int j = 0;
    int m;
    for (int k = 0; j < i; k = m)
    {
      m = k;
      if (paramg.f(j, l)) {
        m = k + 1;
      }
      j++;
    }
    return new x.a(1, 0, i, k);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\trackselection\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */