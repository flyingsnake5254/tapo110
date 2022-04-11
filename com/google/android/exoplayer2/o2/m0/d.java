package com.google.android.exoplayer2.o2.m0;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import java.io.IOException;

final class d
{
  @Nullable
  public static c a(k paramk)
    throws IOException
  {
    g.e(paramk);
    d0 locald0 = new d0(16);
    if (a.a(paramk, locald0).a != 1380533830) {
      return null;
    }
    paramk.n(locald0.d(), 0, 4);
    locald0.P(0);
    int i = locald0.n();
    if (i != 1463899717)
    {
      paramk = new StringBuilder(36);
      paramk.append("Unsupported RIFF format: ");
      paramk.append(i);
      u.c("WavHeaderReader", paramk.toString());
      return null;
    }
    for (Object localObject = a.a(paramk, locald0); ((a)localObject).a != 1718449184; localObject = a.a(paramk, locald0)) {
      paramk.h((int)((a)localObject).b);
    }
    boolean bool;
    if (((a)localObject).b >= 16L) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    paramk.n(locald0.d(), 0, 16);
    locald0.P(0);
    int j = locald0.v();
    int k = locald0.v();
    i = locald0.u();
    int m = locald0.u();
    int n = locald0.v();
    int i1 = locald0.v();
    int i2 = (int)((a)localObject).b - 16;
    if (i2 > 0)
    {
      localObject = new byte[i2];
      paramk.n((byte[])localObject, 0, i2);
      paramk = (k)localObject;
    }
    else
    {
      paramk = o0.f;
    }
    return new c(j, k, i, m, n, i1, paramk);
  }
  
  public static Pair<Long, Long> b(k paramk)
    throws IOException
  {
    g.e(paramk);
    paramk.e();
    d0 locald0 = new d0(8);
    int i;
    for (a locala = a.a(paramk, locald0);; locala = a.a(paramk, locald0))
    {
      i = locala.a;
      if (i == 1684108385) {
        break label170;
      }
      if ((i != 1380533830) && (i != 1718449184))
      {
        StringBuilder localStringBuilder = new StringBuilder(39);
        localStringBuilder.append("Ignoring unknown WAV chunk: ");
        localStringBuilder.append(i);
        u.h("WavHeaderReader", localStringBuilder.toString());
      }
      l1 = locala.b + 8L;
      i = locala.a;
      if (i == 1380533830) {
        l1 = 12L;
      }
      if (l1 > 2147483647L) {
        break;
      }
      paramk.l((int)l1);
    }
    paramk = new StringBuilder(51);
    paramk.append("Chunk is too large (~2GB+) to skip; id: ");
    paramk.append(i);
    throw ParserException.createForUnsupportedContainerFeature(paramk.toString());
    label170:
    paramk.l(8);
    long l2 = paramk.getPosition();
    long l3 = locala.b + l2;
    long l4 = paramk.a();
    long l1 = l3;
    if (l4 != -1L)
    {
      l1 = l3;
      if (l3 > l4)
      {
        paramk = new StringBuilder(69);
        paramk.append("Data exceeds input length: ");
        paramk.append(l3);
        paramk.append(", ");
        paramk.append(l4);
        u.h("WavHeaderReader", paramk.toString());
        l1 = l4;
      }
    }
    return Pair.create(Long.valueOf(l2), Long.valueOf(l1));
  }
  
  private static final class a
  {
    public final int a;
    public final long b;
    
    private a(int paramInt, long paramLong)
    {
      this.a = paramInt;
      this.b = paramLong;
    }
    
    public static a a(k paramk, d0 paramd0)
      throws IOException
    {
      paramk.n(paramd0.d(), 0, 8);
      paramd0.P(0);
      return new a(paramd0.n(), paramd0.t());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\m0\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */