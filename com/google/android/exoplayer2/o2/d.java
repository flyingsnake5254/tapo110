package com.google.android.exoplayer2.o2;

import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.u;

public final class d
{
  public static void a(long paramLong, d0 paramd0, b0[] paramArrayOfb0)
  {
    for (;;)
    {
      int i = paramd0.a();
      int j = 1;
      if (i <= 1) {
        break;
      }
      int k = c(paramd0);
      int m = c(paramd0);
      int n = paramd0.e() + m;
      if ((m != -1) && (m <= paramd0.a()))
      {
        i = n;
        if (k == 4)
        {
          i = n;
          if (m >= 8)
          {
            i = paramd0.D();
            int i1 = paramd0.J();
            if (i1 == 49) {
              k = paramd0.n();
            } else {
              k = 0;
            }
            m = paramd0.D();
            if (i1 == 47) {
              paramd0.Q(1);
            }
            if ((i == 181) && ((i1 == 49) || (i1 == 47)) && (m == 3)) {
              i = 1;
            } else {
              i = 0;
            }
            m = i;
            if (i1 == 49)
            {
              if (k == 1195456820) {
                k = j;
              } else {
                k = 0;
              }
              m = i & k;
            }
            i = n;
            if (m != 0)
            {
              b(paramLong, paramd0, paramArrayOfb0);
              i = n;
            }
          }
        }
      }
      else
      {
        u.h("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
        i = paramd0.f();
      }
      paramd0.P(i);
    }
  }
  
  public static void b(long paramLong, d0 paramd0, b0[] paramArrayOfb0)
  {
    int i = paramd0.D();
    int j = 0;
    if ((i & 0x40) != 0) {
      k = 1;
    } else {
      k = 0;
    }
    if (k == 0) {
      return;
    }
    paramd0.Q(1);
    int m = (i & 0x1F) * 3;
    int n = paramd0.e();
    i = paramArrayOfb0.length;
    for (int k = j; k < i; k++)
    {
      b0 localb0 = paramArrayOfb0[k];
      paramd0.P(n);
      localb0.c(paramd0, m);
      localb0.e(paramLong, 1, m, 0, null);
    }
  }
  
  private static int c(d0 paramd0)
  {
    int i = 0;
    int j;
    int k;
    do
    {
      if (paramd0.a() == 0) {
        return -1;
      }
      j = paramd0.D();
      k = i + j;
      i = k;
    } while (j == 255);
    return k;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */