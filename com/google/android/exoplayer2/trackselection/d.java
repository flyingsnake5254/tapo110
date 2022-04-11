package com.google.android.exoplayer2.trackselection;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.e0.a;
import com.google.android.exoplayer2.source.u0.b;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.a;
import com.google.common.collect.j1;
import com.google.common.collect.m1;
import com.google.common.collect.r1;
import com.google.common.collect.s1;
import com.google.common.collect.s1.d;
import com.google.common.collect.s1.e;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class d
  extends e
{
  private final com.google.android.exoplayer2.upstream.g h;
  private final long i;
  private final long j;
  private final long k;
  private final float l;
  private final float m;
  private final ImmutableList<a> n;
  private final com.google.android.exoplayer2.util.h o;
  private float p;
  private int q;
  private int r;
  private long s;
  @Nullable
  private com.google.android.exoplayer2.source.u0.d t;
  
  protected d(TrackGroup paramTrackGroup, int[] paramArrayOfInt, int paramInt, com.google.android.exoplayer2.upstream.g paramg, long paramLong1, long paramLong2, long paramLong3, float paramFloat1, float paramFloat2, List<a> paramList, com.google.android.exoplayer2.util.h paramh)
  {
    super(paramTrackGroup, paramArrayOfInt, paramInt);
    long l1 = paramLong3;
    if (paramLong3 < paramLong1)
    {
      u.h("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
      l1 = paramLong1;
    }
    this.h = paramg;
    this.i = (paramLong1 * 1000L);
    this.j = (paramLong2 * 1000L);
    this.k = (l1 * 1000L);
    this.l = paramFloat1;
    this.m = paramFloat2;
    this.n = ImmutableList.copyOf(paramList);
    this.o = paramh;
    this.p = 1.0F;
    this.r = 0;
    this.s = -9223372036854775807L;
  }
  
  private static ImmutableList<ImmutableList<a>> A(g.a[] paramArrayOfa)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    for (int i2 = 0; i2 < paramArrayOfa.length; i2++) {
      if ((paramArrayOfa[i2] != null) && (paramArrayOfa[i2].b.length > 1))
      {
        localObject = ImmutableList.builder();
        ((ImmutableList.a)localObject).h(new a(0L, 0L));
        localArrayList.add(localObject);
      }
      else
      {
        localArrayList.add(null);
      }
    }
    long[][] arrayOfLong = F(paramArrayOfa);
    int[] arrayOfInt = new int[arrayOfLong.length];
    long[] arrayOfLong1 = new long[arrayOfLong.length];
    for (i2 = 0; i2 < arrayOfLong.length; i2++)
    {
      long l1;
      if (arrayOfLong[i2].length == 0) {
        l1 = 0L;
      } else {
        l1 = arrayOfLong[i2][0];
      }
      arrayOfLong1[i2] = l1;
    }
    x(localArrayList, arrayOfLong1);
    Object localObject = G(arrayOfLong);
    for (i2 = 0; i2 < ((AbstractCollection)localObject).size(); i2++)
    {
      int i3 = ((Integer)((List)localObject).get(i2)).intValue();
      int i4 = arrayOfInt[i3] + 1;
      arrayOfInt[i3] = i4;
      arrayOfLong1[i3] = arrayOfLong[i3][i4];
      x(localArrayList, arrayOfLong1);
    }
    for (i2 = 0; i2 < paramArrayOfa.length; i2++) {
      if (localArrayList.get(i2) != null) {
        arrayOfLong1[i2] *= 2L;
      }
    }
    x(localArrayList, arrayOfLong1);
    localObject = ImmutableList.builder();
    for (i2 = i1; i2 < localArrayList.size(); i2++)
    {
      paramArrayOfa = (ImmutableList.a)localArrayList.get(i2);
      if (paramArrayOfa == null) {
        paramArrayOfa = ImmutableList.of();
      } else {
        paramArrayOfa = paramArrayOfa.j();
      }
      ((ImmutableList.a)localObject).h(paramArrayOfa);
    }
    return ((ImmutableList.a)localObject).j();
  }
  
  private long B(long paramLong)
  {
    long l1 = H(paramLong);
    if (this.n.isEmpty()) {
      return l1;
    }
    for (int i1 = 1; (i1 < this.n.size() - 1) && (((a)this.n.get(i1)).a < l1); i1++) {}
    a locala1 = (a)this.n.get(i1 - 1);
    a locala2 = (a)this.n.get(i1);
    paramLong = locala1.a;
    float f = (float)(l1 - paramLong) / (float)(locala2.a - paramLong);
    paramLong = locala1.b;
    return paramLong + (f * (float)(locala2.b - paramLong));
  }
  
  private long C(List<? extends com.google.android.exoplayer2.source.u0.d> paramList)
  {
    boolean bool = paramList.isEmpty();
    long l1 = -9223372036854775807L;
    if (bool) {
      return -9223372036854775807L;
    }
    paramList = (com.google.android.exoplayer2.source.u0.d)j1.f(paramList);
    long l2 = paramList.g;
    long l3 = l1;
    if (l2 != -9223372036854775807L)
    {
      long l4 = paramList.h;
      l3 = l1;
      if (l4 != -9223372036854775807L) {
        l3 = l4 - l2;
      }
    }
    return l3;
  }
  
  private long E(com.google.android.exoplayer2.source.u0.e[] paramArrayOfe, List<? extends com.google.android.exoplayer2.source.u0.d> paramList)
  {
    int i1 = this.q;
    if ((i1 < paramArrayOfe.length) && (paramArrayOfe[i1].next()))
    {
      paramArrayOfe = paramArrayOfe[this.q];
      return paramArrayOfe.b() - paramArrayOfe.a();
    }
    int i2 = paramArrayOfe.length;
    for (i1 = 0; i1 < i2; i1++)
    {
      com.google.android.exoplayer2.source.u0.e locale = paramArrayOfe[i1];
      if (locale.next()) {
        return locale.b() - locale.a();
      }
    }
    return C(paramList);
  }
  
  private static long[][] F(g.a[] paramArrayOfa)
  {
    long[][] arrayOfLong = new long[paramArrayOfa.length][];
    for (int i1 = 0; i1 < paramArrayOfa.length; i1++)
    {
      g.a locala = paramArrayOfa[i1];
      if (locala == null)
      {
        arrayOfLong[i1] = new long[0];
      }
      else
      {
        arrayOfLong[i1] = new long[locala.b.length];
        for (int i2 = 0;; i2++)
        {
          int[] arrayOfInt = locala.b;
          if (i2 >= arrayOfInt.length) {
            break;
          }
          arrayOfLong[i1][i2] = locala.a.a(arrayOfInt[i2]).p0;
        }
        Arrays.sort(arrayOfLong[i1]);
      }
    }
    return arrayOfLong;
  }
  
  private static ImmutableList<Integer> G(long[][] paramArrayOfLong)
  {
    m1 localm1 = s1.c().a().e();
    for (int i1 = 0; i1 < paramArrayOfLong.length; i1++) {
      if (paramArrayOfLong[i1].length > 1)
      {
        int i2 = paramArrayOfLong[i1].length;
        double[] arrayOfDouble = new double[i2];
        double d1;
        for (int i3 = 0;; i3++)
        {
          int i4 = paramArrayOfLong[i1].length;
          d1 = 0.0D;
          if (i3 >= i4) {
            break;
          }
          if (paramArrayOfLong[i1][i3] != -1L) {
            d1 = Math.log(paramArrayOfLong[i1][i3]);
          }
          arrayOfDouble[i3] = d1;
        }
        i2--;
        double d2 = arrayOfDouble[i2] - arrayOfDouble[0];
        i3 = 0;
        while (i3 < i2)
        {
          double d3 = arrayOfDouble[i3];
          i3++;
          d1 = arrayOfDouble[i3];
          if (d2 == 0.0D) {
            d1 = 1.0D;
          } else {
            d1 = ((d3 + d1) * 0.5D - arrayOfDouble[0]) / d2;
          }
          localm1.put(Double.valueOf(d1), Integer.valueOf(i1));
        }
      }
    }
    return ImmutableList.copyOf(localm1.values());
  }
  
  private long H(long paramLong)
  {
    long l1 = ((float)this.h.e() * this.l);
    long l2 = this.h.a();
    if ((l2 != -9223372036854775807L) && (paramLong != -9223372036854775807L))
    {
      float f1 = (float)paramLong;
      float f2 = Math.max(f1 / this.p - (float)l2, 0.0F);
      return ((float)l1 * f2 / f1);
    }
    return ((float)l1 / this.p);
  }
  
  private long I(long paramLong)
  {
    int i1;
    if ((paramLong != -9223372036854775807L) && (paramLong <= this.i)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      paramLong = ((float)paramLong * this.m);
    } else {
      paramLong = this.i;
    }
    return paramLong;
  }
  
  private static void x(List<ImmutableList.a<a>> paramList, long[] paramArrayOfLong)
  {
    int i1 = 0;
    long l1 = 0L;
    int i3;
    for (int i2 = 0;; i2++)
    {
      i3 = i1;
      if (i2 >= paramArrayOfLong.length) {
        break;
      }
      l1 += paramArrayOfLong[i2];
    }
    while (i3 < paramList.size())
    {
      ImmutableList.a locala = (ImmutableList.a)paramList.get(i3);
      if (locala != null) {
        locala.h(new a(l1, paramArrayOfLong[i3]));
      }
      i3++;
    }
  }
  
  private int z(long paramLong1, long paramLong2)
  {
    paramLong2 = B(paramLong2);
    int i1 = 0;
    int i2 = 0;
    while (i1 < this.b)
    {
      if ((paramLong1 == Long.MIN_VALUE) || (!f(i1, paramLong1)))
      {
        Format localFormat = a(i1);
        if (y(localFormat, localFormat.p0, paramLong2)) {
          return i1;
        }
        i2 = i1;
      }
      i1++;
    }
    return i2;
  }
  
  protected long D()
  {
    return this.k;
  }
  
  protected boolean J(long paramLong, List<? extends com.google.android.exoplayer2.source.u0.d> paramList)
  {
    long l1 = this.s;
    boolean bool;
    if ((l1 != -9223372036854775807L) && (paramLong - l1 < 1000L) && ((paramList.isEmpty()) || (((com.google.android.exoplayer2.source.u0.d)j1.f(paramList)).equals(this.t)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @CallSuper
  public void b()
  {
    this.t = null;
  }
  
  @CallSuper
  public void c()
  {
    this.s = -9223372036854775807L;
    this.t = null;
  }
  
  public int d()
  {
    return this.q;
  }
  
  public void i(float paramFloat)
  {
    this.p = paramFloat;
  }
  
  @Nullable
  public Object j()
  {
    return null;
  }
  
  public int o(long paramLong, List<? extends com.google.android.exoplayer2.source.u0.d> paramList)
  {
    long l1 = this.o.elapsedRealtime();
    if (!J(l1, paramList)) {
      return paramList.size();
    }
    this.s = l1;
    com.google.android.exoplayer2.source.u0.d locald;
    if (paramList.isEmpty()) {
      locald = null;
    } else {
      locald = (com.google.android.exoplayer2.source.u0.d)j1.f(paramList);
    }
    this.t = locald;
    boolean bool = paramList.isEmpty();
    int i1 = 0;
    if (bool) {
      return 0;
    }
    int i2 = paramList.size();
    long l2 = o0.X(((com.google.android.exoplayer2.source.u0.d)paramList.get(i2 - 1)).g - paramLong, this.p);
    long l3 = D();
    if (l2 < l3) {
      return i2;
    }
    Format localFormat1 = a(z(l1, C(paramList)));
    while (i1 < i2)
    {
      locald = (com.google.android.exoplayer2.source.u0.d)paramList.get(i1);
      Format localFormat2 = locald.d;
      if ((o0.X(locald.g - paramLong, this.p) >= l3) && (localFormat2.p0 < localFormat1.p0))
      {
        int i3 = localFormat2.N3;
        if ((i3 != -1) && (i3 < 720))
        {
          int i4 = localFormat2.M3;
          if ((i4 != -1) && (i4 < 1280) && (i3 < localFormat1.N3)) {
            return i1;
          }
        }
      }
      i1++;
    }
    return i2;
  }
  
  public void q(long paramLong1, long paramLong2, long paramLong3, List<? extends com.google.android.exoplayer2.source.u0.d> paramList, com.google.android.exoplayer2.source.u0.e[] paramArrayOfe)
  {
    long l1 = this.o.elapsedRealtime();
    paramLong1 = E(paramArrayOfe, paramList);
    int i1 = this.r;
    if (i1 == 0)
    {
      this.r = 1;
      this.q = z(l1, paramLong1);
      return;
    }
    int i2 = this.q;
    if (paramList.isEmpty()) {
      i3 = -1;
    } else {
      i3 = p(((com.google.android.exoplayer2.source.u0.d)j1.f(paramList)).d);
    }
    if (i3 != -1)
    {
      i1 = ((com.google.android.exoplayer2.source.u0.d)j1.f(paramList)).e;
      i2 = i3;
    }
    int i4 = z(l1, paramLong1);
    int i3 = i4;
    if (!f(i2, l1))
    {
      paramList = a(i2);
      paramArrayOfe = a(i4);
      if ((paramArrayOfe.p0 <= paramList.p0) || (paramLong2 >= I(paramLong3)))
      {
        i3 = i4;
        if (paramArrayOfe.p0 < paramList.p0)
        {
          i3 = i4;
          if (paramLong2 < this.j) {}
        }
      }
      else
      {
        i3 = i2;
      }
    }
    if (i3 != i2) {
      i1 = 3;
    }
    this.r = i1;
    this.q = i3;
  }
  
  public int t()
  {
    return this.r;
  }
  
  protected boolean y(Format paramFormat, int paramInt, long paramLong)
  {
    boolean bool;
    if (paramInt <= paramLong) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final class a
  {
    public final long a;
    public final long b;
    
    public a(long paramLong1, long paramLong2)
    {
      this.a = paramLong1;
      this.b = paramLong2;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      if ((this.a != ((a)paramObject).a) || (this.b != ((a)paramObject).b)) {
        bool = false;
      }
      return bool;
    }
    
    public int hashCode()
    {
      return (int)this.a * 31 + (int)this.b;
    }
  }
  
  public static class b
    implements g.b
  {
    private final int a;
    private final int b;
    private final int c;
    private final float d;
    private final float e;
    private final com.google.android.exoplayer2.util.h f;
    
    public b()
    {
      this(10000, 25000, 25000, 0.7F, 0.75F, com.google.android.exoplayer2.util.h.a);
    }
    
    public b(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, com.google.android.exoplayer2.util.h paramh)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramFloat1;
      this.e = paramFloat2;
      this.f = paramh;
    }
    
    public final g[] a(g.a[] paramArrayOfa, com.google.android.exoplayer2.upstream.g paramg, e0.a parama, j2 paramj2)
    {
      ImmutableList localImmutableList = d.w(paramArrayOfa);
      paramj2 = new g[paramArrayOfa.length];
      for (int i = 0; i < paramArrayOfa.length; i++)
      {
        parama = paramArrayOfa[i];
        if (parama != null)
        {
          int[] arrayOfInt = parama.b;
          if (arrayOfInt.length != 0)
          {
            if (arrayOfInt.length == 1) {
              parama = new h(parama.a, arrayOfInt[0], parama.c);
            } else {
              parama = b(parama.a, arrayOfInt, parama.c, paramg, (ImmutableList)localImmutableList.get(i));
            }
            paramj2[i] = parama;
          }
        }
      }
      return paramj2;
    }
    
    protected d b(TrackGroup paramTrackGroup, int[] paramArrayOfInt, int paramInt, com.google.android.exoplayer2.upstream.g paramg, ImmutableList<d.a> paramImmutableList)
    {
      return new d(paramTrackGroup, paramArrayOfInt, paramInt, paramg, this.a, this.b, this.c, this.d, this.e, paramImmutableList, this.f);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\trackselection\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */