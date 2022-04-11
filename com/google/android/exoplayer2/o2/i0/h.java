package com.google.android.exoplayer2.o2.i0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.e0.a;
import com.google.android.exoplayer2.o2.y.a;
import com.google.android.exoplayer2.o2.z;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;

final class h
  implements g
{
  private final long[] a;
  private final long[] b;
  private final long c;
  private final long d;
  
  private h(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long paramLong1, long paramLong2)
  {
    this.a = paramArrayOfLong1;
    this.b = paramArrayOfLong2;
    this.c = paramLong1;
    this.d = paramLong2;
  }
  
  @Nullable
  public static h b(long paramLong1, long paramLong2, e0.a parama, d0 paramd0)
  {
    paramd0.Q(10);
    int i = paramd0.n();
    if (i <= 0) {
      return null;
    }
    int j = parama.d;
    long l1 = i;
    if (j >= 32000) {
      i = 1152;
    } else {
      i = 576;
    }
    long l2 = o0.C0(l1, 1000000L * i, j);
    int k = paramd0.J();
    j = paramd0.J();
    int m = paramd0.J();
    paramd0.Q(2);
    long l3 = paramLong2 + parama.c;
    parama = new long[k];
    long[] arrayOfLong = new long[k];
    int n = 0;
    l1 = paramLong2;
    paramLong2 = l3;
    while (n < k)
    {
      parama[n] = (n * l2 / k);
      arrayOfLong[n] = Math.max(l1, paramLong2);
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3)
          {
            if (m != 4) {
              return null;
            }
            i = paramd0.H();
          }
          else
          {
            i = paramd0.G();
          }
        }
        else {
          i = paramd0.J();
        }
      }
      else {
        i = paramd0.D();
      }
      l1 += i * j;
      n++;
    }
    if ((paramLong1 != -1L) && (paramLong1 != l1))
    {
      paramd0 = new StringBuilder(67);
      paramd0.append("VBRI data size mismatch: ");
      paramd0.append(paramLong1);
      paramd0.append(", ");
      paramd0.append(l1);
      u.h("VbriSeeker", paramd0.toString());
    }
    return new h(parama, arrayOfLong, l2, l1);
  }
  
  public y.a a(long paramLong)
  {
    int i = o0.h(this.a, paramLong, true, true);
    z localz = new z(this.a[i], this.b[i]);
    if ((localz.b < paramLong) && (i != this.a.length - 1))
    {
      long[] arrayOfLong = this.a;
      i++;
      return new y.a(localz, new z(arrayOfLong[i], this.b[i]));
    }
    return new y.a(localz);
  }
  
  public long f()
  {
    return this.d;
  }
  
  public boolean g()
  {
    return true;
  }
  
  public long h(long paramLong)
  {
    return this.a[o0.h(this.b, paramLong, true, true)];
  }
  
  public long i()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\i0\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */