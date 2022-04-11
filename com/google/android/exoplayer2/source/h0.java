package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.trackselection.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;

final class h0
  implements b0, b0.a
{
  private final b0[] c;
  private final IdentityHashMap<n0, Integer> d;
  private final r f;
  private o0 p0;
  private final ArrayList<b0> q;
  @Nullable
  private b0.a x;
  @Nullable
  private TrackGroupArray y;
  private b0[] z;
  
  public h0(r paramr, long[] paramArrayOfLong, b0... paramVarArgs)
  {
    this.f = paramr;
    this.c = paramVarArgs;
    this.q = new ArrayList();
    int i = 0;
    this.p0 = paramr.a(new o0[0]);
    this.d = new IdentityHashMap();
    this.z = new b0[0];
    while (i < paramVarArgs.length)
    {
      if (paramArrayOfLong[i] != 0L) {
        this.c[i] = new a(paramVarArgs[i], paramArrayOfLong[i]);
      }
      i++;
    }
  }
  
  public long a()
  {
    return this.p0.a();
  }
  
  public boolean c()
  {
    return this.p0.c();
  }
  
  public boolean d(long paramLong)
  {
    if (!this.q.isEmpty())
    {
      int i = this.q.size();
      for (int j = 0; j < i; j++) {
        ((b0)this.q.get(j)).d(paramLong);
      }
      return false;
    }
    return this.p0.d(paramLong);
  }
  
  public long e()
  {
    return this.p0.e();
  }
  
  public void f(long paramLong)
  {
    this.p0.f(paramLong);
  }
  
  public b0 g(int paramInt)
  {
    Object localObject = this.c;
    if ((localObject[paramInt] instanceof a)) {
      localObject = a.g((a)localObject[paramInt]);
    } else {
      localObject = localObject[paramInt];
    }
    return (b0)localObject;
  }
  
  public void h(b0 paramb0)
  {
    ((b0.a)com.google.android.exoplayer2.util.g.e(this.x)).n(this);
  }
  
  public long i(long paramLong)
  {
    paramLong = this.z[0].i(paramLong);
    for (int i = 1;; i++)
    {
      b0[] arrayOfb0 = this.z;
      if (i >= arrayOfb0.length) {
        return paramLong;
      }
      if (arrayOfb0[i].i(paramLong) != paramLong) {
        break;
      }
    }
    throw new IllegalStateException("Unexpected child seekToUs result.");
    return paramLong;
  }
  
  public long j(long paramLong, g2 paramg2)
  {
    Object localObject = this.z;
    if (localObject.length > 0) {
      localObject = localObject[0];
    } else {
      localObject = this.c[0];
    }
    return ((b0)localObject).j(paramLong, paramg2);
  }
  
  public long k()
  {
    b0[] arrayOfb01 = this.z;
    int i = arrayOfb01.length;
    long l1 = -9223372036854775807L;
    int j = 0;
    while (j < i)
    {
      b0 localb01 = arrayOfb01[j];
      long l2 = localb01.k();
      if (l2 != -9223372036854775807L)
      {
        if (l1 == -9223372036854775807L)
        {
          b0[] arrayOfb02 = this.z;
          int k = arrayOfb02.length;
          int m = 0;
          while (m < k)
          {
            b0 localb02 = arrayOfb02[m];
            if (localb02 != localb01) {
              if (localb02.i(l2) == l2) {
                m++;
              } else {
                throw new IllegalStateException("Unexpected child seekToUs result.");
              }
            }
          }
        }
        else if (l2 == l1)
        {
          l2 = l1;
        }
        else
        {
          throw new IllegalStateException("Conflicting discontinuities.");
        }
      }
      else
      {
        l2 = l1;
        if (l1 != -9223372036854775807L) {
          if (localb01.i(l1) == l1) {
            l2 = l1;
          } else {
            throw new IllegalStateException("Unexpected child seekToUs result.");
          }
        }
      }
      j++;
      l1 = l2;
    }
    return l1;
  }
  
  public void l(b0.a parama, long paramLong)
  {
    this.x = parama;
    Collections.addAll(this.q, this.c);
    parama = this.c;
    int i = parama.length;
    for (int j = 0; j < i; j++) {
      parama[j].l(this, paramLong);
    }
  }
  
  public long m(com.google.android.exoplayer2.trackselection.g[] paramArrayOfg, boolean[] paramArrayOfBoolean1, n0[] paramArrayOfn0, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    int[] arrayOfInt1 = new int[paramArrayOfg.length];
    int[] arrayOfInt2 = new int[paramArrayOfg.length];
    int j;
    for (int i = 0; i < paramArrayOfg.length; i++)
    {
      if (paramArrayOfn0[i] == null) {
        localObject1 = null;
      } else {
        localObject1 = (Integer)this.d.get(paramArrayOfn0[i]);
      }
      if (localObject1 == null) {
        j = -1;
      } else {
        j = ((Integer)localObject1).intValue();
      }
      arrayOfInt1[i] = j;
      arrayOfInt2[i] = -1;
      if (paramArrayOfg[i] != null)
      {
        localObject2 = paramArrayOfg[i].m();
        for (j = 0;; j++)
        {
          localObject1 = this.c;
          if (j >= localObject1.length) {
            break;
          }
          if (localObject1[j].s().b((TrackGroup)localObject2) != -1)
          {
            arrayOfInt2[i] = j;
            break;
          }
        }
      }
    }
    this.d.clear();
    int k = paramArrayOfg.length;
    n0[] arrayOfn01 = new n0[k];
    n0[] arrayOfn02 = new n0[paramArrayOfg.length];
    Object localObject1 = new com.google.android.exoplayer2.trackselection.g[paramArrayOfg.length];
    Object localObject2 = new ArrayList(this.c.length);
    i = 0;
    while (i < this.c.length)
    {
      Object localObject3;
      for (j = 0; j < paramArrayOfg.length; j++)
      {
        if (arrayOfInt1[j] == i) {
          localObject3 = paramArrayOfn0[j];
        } else {
          localObject3 = null;
        }
        arrayOfn02[j] = localObject3;
        if (arrayOfInt2[j] == i) {
          localObject3 = paramArrayOfg[j];
        } else {
          localObject3 = null;
        }
        localObject1[j] = localObject3;
      }
      long l = this.c[i].m((com.google.android.exoplayer2.trackselection.g[])localObject1, paramArrayOfBoolean1, arrayOfn02, paramArrayOfBoolean2, paramLong);
      if (i == 0) {
        paramLong = l;
      } else {
        if (l != paramLong) {
          break label479;
        }
      }
      int m = 0;
      int n;
      for (j = 0; m < paramArrayOfg.length; j = n)
      {
        n = arrayOfInt2[m];
        boolean bool = true;
        if (n == i)
        {
          localObject3 = (n0)com.google.android.exoplayer2.util.g.e(arrayOfn02[m]);
          arrayOfn01[m] = arrayOfn02[m];
          this.d.put(localObject3, Integer.valueOf(i));
          n = 1;
        }
        else
        {
          n = j;
          if (arrayOfInt1[m] == i)
          {
            if (arrayOfn02[m] != null) {
              bool = false;
            }
            com.google.android.exoplayer2.util.g.g(bool);
            n = j;
          }
        }
        m++;
      }
      if (j != 0) {
        ((ArrayList)localObject2).add(this.c[i]);
      }
      i++;
      continue;
      label479:
      throw new IllegalStateException("Children enabled at different positions.");
    }
    System.arraycopy(arrayOfn01, 0, paramArrayOfn0, 0, k);
    paramArrayOfg = (b0[])((ArrayList)localObject2).toArray(new b0[0]);
    this.z = paramArrayOfg;
    this.p0 = this.f.a(paramArrayOfg);
    return paramLong;
  }
  
  public void p(b0 paramb0)
  {
    this.q.remove(paramb0);
    if (!this.q.isEmpty()) {
      return;
    }
    paramb0 = this.c;
    int i = paramb0.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += paramb0[j].s().d;
      j++;
    }
    TrackGroup[] arrayOfTrackGroup = new TrackGroup[k];
    paramb0 = this.c;
    int m = paramb0.length;
    j = 0;
    k = 0;
    while (j < m)
    {
      TrackGroupArray localTrackGroupArray = paramb0[j].s();
      int n = localTrackGroupArray.d;
      i = 0;
      while (i < n)
      {
        arrayOfTrackGroup[k] = localTrackGroupArray.a(i);
        i++;
        k++;
      }
      j++;
    }
    this.y = new TrackGroupArray(arrayOfTrackGroup);
    ((b0.a)com.google.android.exoplayer2.util.g.e(this.x)).p(this);
  }
  
  public void q()
    throws IOException
  {
    b0[] arrayOfb0 = this.c;
    int i = arrayOfb0.length;
    for (int j = 0; j < i; j++) {
      arrayOfb0[j].q();
    }
  }
  
  public TrackGroupArray s()
  {
    return (TrackGroupArray)com.google.android.exoplayer2.util.g.e(this.y);
  }
  
  public void u(long paramLong, boolean paramBoolean)
  {
    b0[] arrayOfb0 = this.z;
    int i = arrayOfb0.length;
    for (int j = 0; j < i; j++) {
      arrayOfb0[j].u(paramLong, paramBoolean);
    }
  }
  
  private static final class a
    implements b0, b0.a
  {
    private final b0 c;
    private final long d;
    private b0.a f;
    
    public a(b0 paramb0, long paramLong)
    {
      this.c = paramb0;
      this.d = paramLong;
    }
    
    public long a()
    {
      long l1 = this.c.a();
      long l2 = Long.MIN_VALUE;
      if (l1 != Long.MIN_VALUE) {
        l2 = this.d + l1;
      }
      return l2;
    }
    
    public boolean c()
    {
      return this.c.c();
    }
    
    public boolean d(long paramLong)
    {
      return this.c.d(paramLong - this.d);
    }
    
    public long e()
    {
      long l1 = this.c.e();
      long l2 = Long.MIN_VALUE;
      if (l1 != Long.MIN_VALUE) {
        l2 = this.d + l1;
      }
      return l2;
    }
    
    public void f(long paramLong)
    {
      this.c.f(paramLong - this.d);
    }
    
    public void h(b0 paramb0)
    {
      ((b0.a)com.google.android.exoplayer2.util.g.e(this.f)).n(this);
    }
    
    public long i(long paramLong)
    {
      return this.c.i(paramLong - this.d) + this.d;
    }
    
    public long j(long paramLong, g2 paramg2)
    {
      return this.c.j(paramLong - this.d, paramg2) + this.d;
    }
    
    public long k()
    {
      long l1 = this.c.k();
      long l2 = -9223372036854775807L;
      if (l1 != -9223372036854775807L) {
        l2 = this.d + l1;
      }
      return l2;
    }
    
    public void l(b0.a parama, long paramLong)
    {
      this.f = parama;
      this.c.l(this, paramLong - this.d);
    }
    
    public long m(com.google.android.exoplayer2.trackselection.g[] paramArrayOfg, boolean[] paramArrayOfBoolean1, n0[] paramArrayOfn0, boolean[] paramArrayOfBoolean2, long paramLong)
    {
      n0[] arrayOfn0 = new n0[paramArrayOfn0.length];
      int i = 0;
      for (int j = 0;; j++)
      {
        int k = paramArrayOfn0.length;
        n0 localn0 = null;
        if (j >= k) {
          break;
        }
        h0.b localb = (h0.b)paramArrayOfn0[j];
        if (localb != null) {
          localn0 = localb.d();
        }
        arrayOfn0[j] = localn0;
      }
      paramLong = this.c.m(paramArrayOfg, paramArrayOfBoolean1, arrayOfn0, paramArrayOfBoolean2, paramLong - this.d);
      for (j = i; j < paramArrayOfn0.length; j++)
      {
        paramArrayOfg = arrayOfn0[j];
        if (paramArrayOfg == null) {
          paramArrayOfn0[j] = null;
        } else if ((paramArrayOfn0[j] == null) || (((h0.b)paramArrayOfn0[j]).d() != paramArrayOfg)) {
          paramArrayOfn0[j] = new h0.b(paramArrayOfg, this.d);
        }
      }
      return paramLong + this.d;
    }
    
    public void p(b0 paramb0)
    {
      ((b0.a)com.google.android.exoplayer2.util.g.e(this.f)).p(this);
    }
    
    public void q()
      throws IOException
    {
      this.c.q();
    }
    
    public TrackGroupArray s()
    {
      return this.c.s();
    }
    
    public void u(long paramLong, boolean paramBoolean)
    {
      this.c.u(paramLong - this.d, paramBoolean);
    }
  }
  
  private static final class b
    implements n0
  {
    private final n0 a;
    private final long b;
    
    public b(n0 paramn0, long paramLong)
    {
      this.a = paramn0;
      this.b = paramLong;
    }
    
    public void a()
      throws IOException
    {
      this.a.a();
    }
    
    public int b(i1 parami1, DecoderInputBuffer paramDecoderInputBuffer, int paramInt)
    {
      paramInt = this.a.b(parami1, paramDecoderInputBuffer, paramInt);
      if (paramInt == -4) {
        paramDecoderInputBuffer.x = Math.max(0L, paramDecoderInputBuffer.x + this.b);
      }
      return paramInt;
    }
    
    public int c(long paramLong)
    {
      return this.a.c(paramLong - this.b);
    }
    
    public n0 d()
    {
      return this.a;
    }
    
    public boolean g()
    {
      return this.a.g();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\h0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */