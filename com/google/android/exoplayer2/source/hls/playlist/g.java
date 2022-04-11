package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.j1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class g
  extends h
{
  public final int d;
  public final long e;
  public final boolean f;
  public final boolean g;
  public final long h;
  public final boolean i;
  public final int j;
  public final long k;
  public final int l;
  public final long m;
  public final long n;
  public final boolean o;
  public final boolean p;
  @Nullable
  public final DrmInitData q;
  public final List<d> r;
  public final List<b> s;
  public final Map<Uri, c> t;
  public final long u;
  public final f v;
  
  public g(int paramInt1, String paramString, List<String> paramList, long paramLong1, boolean paramBoolean1, long paramLong2, boolean paramBoolean2, int paramInt2, long paramLong3, int paramInt3, long paramLong4, long paramLong5, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, @Nullable DrmInitData paramDrmInitData, List<d> paramList1, List<b> paramList2, f paramf, Map<Uri, c> paramMap)
  {
    super(paramString, paramList, paramBoolean3);
    this.d = paramInt1;
    this.h = paramLong2;
    this.g = paramBoolean1;
    this.i = paramBoolean2;
    this.j = paramInt2;
    this.k = paramLong3;
    this.l = paramInt3;
    this.m = paramLong4;
    this.n = paramLong5;
    this.o = paramBoolean4;
    this.p = paramBoolean5;
    this.q = paramDrmInitData;
    this.r = ImmutableList.copyOf(paramList1);
    this.s = ImmutableList.copyOf(paramList2);
    this.t = ImmutableMap.copyOf(paramMap);
    if (!paramList2.isEmpty())
    {
      paramString = (b)j1.f(paramList2);
      this.u = (paramString.x + paramString.f);
    }
    else if (!paramList1.isEmpty())
    {
      paramString = (d)j1.f(paramList1);
      this.u = (paramString.x + paramString.f);
    }
    else
    {
      this.u = 0L;
    }
    paramLong2 = -9223372036854775807L;
    if (paramLong1 != -9223372036854775807L) {
      if (paramLong1 >= 0L) {
        paramLong2 = Math.min(this.u, paramLong1);
      } else {
        paramLong2 = Math.max(0L, this.u + paramLong1);
      }
    }
    this.e = paramLong2;
    if (paramLong1 >= 0L) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    this.f = paramBoolean1;
    this.v = paramf;
  }
  
  public g b(List<StreamKey> paramList)
  {
    return this;
  }
  
  public g c(long paramLong, int paramInt)
  {
    return new g(this.d, this.a, this.b, this.e, this.g, paramLong, true, paramInt, this.k, this.l, this.m, this.n, this.c, this.o, this.p, this.q, this.r, this.s, this.v, this.t);
  }
  
  public g d()
  {
    if (this.o) {
      return this;
    }
    return new g(this.d, this.a, this.b, this.e, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.c, true, this.p, this.q, this.r, this.s, this.v, this.t);
  }
  
  public long e()
  {
    return this.h + this.u;
  }
  
  public boolean f(@Nullable g paramg)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = bool1;
    if (paramg != null)
    {
      long l1 = this.k;
      long l2 = paramg.k;
      if (l1 > l2)
      {
        bool3 = bool1;
      }
      else
      {
        if (l1 < l2) {
          return false;
        }
        int i1 = this.r.size() - paramg.r.size();
        if (i1 != 0)
        {
          if (i1 > 0) {
            bool3 = bool2;
          } else {
            bool3 = false;
          }
          return bool3;
        }
        i1 = this.s.size();
        int i2 = paramg.s.size();
        bool3 = bool1;
        if (i1 <= i2) {
          if ((i1 == i2) && (this.o) && (!paramg.o)) {
            bool3 = bool1;
          } else {
            bool3 = false;
          }
        }
      }
    }
    return bool3;
  }
  
  public static final class b
    extends g.e
  {
    public final boolean H3;
    public final boolean I3;
    
    public b(String paramString1, @Nullable g.d paramd, long paramLong1, int paramInt, long paramLong2, @Nullable DrmInitData paramDrmInitData, @Nullable String paramString2, @Nullable String paramString3, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      super(paramd, paramLong1, paramInt, paramLong2, paramDrmInitData, paramString2, paramString3, paramLong3, paramLong4, paramBoolean1, null);
      this.H3 = paramBoolean2;
      this.I3 = paramBoolean3;
    }
    
    public b b(long paramLong, int paramInt)
    {
      return new b(this.c, this.d, this.f, paramInt, paramLong, this.y, this.z, this.p0, this.p1, this.p2, this.p3, this.H3, this.I3);
    }
  }
  
  public static final class c
  {
    public final Uri a;
    public final long b;
    public final int c;
    
    public c(Uri paramUri, long paramLong, int paramInt)
    {
      this.a = paramUri;
      this.b = paramLong;
      this.c = paramInt;
    }
  }
  
  public static final class d
    extends g.e
  {
    public final String H3;
    public final List<g.b> I3;
    
    public d(String paramString1, long paramLong1, long paramLong2, @Nullable String paramString2, @Nullable String paramString3)
    {
      this(paramString1, null, "", 0L, -1, -9223372036854775807L, null, paramString2, paramString3, paramLong1, paramLong2, false, ImmutableList.of());
    }
    
    public d(String paramString1, @Nullable d paramd, String paramString2, long paramLong1, int paramInt, long paramLong2, @Nullable DrmInitData paramDrmInitData, @Nullable String paramString3, @Nullable String paramString4, long paramLong3, long paramLong4, boolean paramBoolean, List<g.b> paramList)
    {
      super(paramd, paramLong1, paramInt, paramLong2, paramDrmInitData, paramString3, paramString4, paramLong3, paramLong4, paramBoolean, null);
      this.H3 = paramString2;
      this.I3 = ImmutableList.copyOf(paramList);
    }
    
    public d b(long paramLong, int paramInt)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      long l = paramLong;
      while (i < this.I3.size())
      {
        g.b localb = (g.b)this.I3.get(i);
        localArrayList.add(localb.b(l, paramInt));
        l += localb.f;
        i++;
      }
      return new d(this.c, this.d, this.H3, this.f, paramInt, paramLong, this.y, this.z, this.p0, this.p1, this.p2, this.p3, localArrayList);
    }
  }
  
  public static class e
    implements Comparable<Long>
  {
    public final String c;
    @Nullable
    public final g.d d;
    public final long f;
    @Nullable
    public final String p0;
    public final long p1;
    public final long p2;
    public final boolean p3;
    public final int q;
    public final long x;
    @Nullable
    public final DrmInitData y;
    @Nullable
    public final String z;
    
    private e(String paramString1, @Nullable g.d paramd, long paramLong1, int paramInt, long paramLong2, @Nullable DrmInitData paramDrmInitData, @Nullable String paramString2, @Nullable String paramString3, long paramLong3, long paramLong4, boolean paramBoolean)
    {
      this.c = paramString1;
      this.d = paramd;
      this.f = paramLong1;
      this.q = paramInt;
      this.x = paramLong2;
      this.y = paramDrmInitData;
      this.z = paramString2;
      this.p0 = paramString3;
      this.p1 = paramLong3;
      this.p2 = paramLong4;
      this.p3 = paramBoolean;
    }
    
    public int a(Long paramLong)
    {
      int i;
      if (this.x > paramLong.longValue()) {
        i = 1;
      } else if (this.x < paramLong.longValue()) {
        i = -1;
      } else {
        i = 0;
      }
      return i;
    }
  }
  
  public static final class f
  {
    public final long a;
    public final boolean b;
    public final long c;
    public final long d;
    public final boolean e;
    
    public f(long paramLong1, boolean paramBoolean1, long paramLong2, long paramLong3, boolean paramBoolean2)
    {
      this.a = paramLong1;
      this.b = paramBoolean1;
      this.c = paramLong2;
      this.d = paramLong3;
      this.e = paramBoolean2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\hls\playlist\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */