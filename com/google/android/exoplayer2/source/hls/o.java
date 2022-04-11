package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.v.a;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.b0.a;
import com.google.android.exoplayer2.source.f0.a;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b;
import com.google.android.exoplayer2.source.hls.playlist.f;
import com.google.android.exoplayer2.source.hls.playlist.f.a;
import com.google.android.exoplayer2.source.hls.playlist.f.b;
import com.google.android.exoplayer2.source.n0;
import com.google.android.exoplayer2.source.o0.a;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.upstream.x.c;
import com.google.android.exoplayer2.util.y;
import com.google.common.primitives.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public final class o
  implements b0, q.b, HlsPlaylistTracker.b
{
  private final com.google.android.exoplayer2.source.r H3;
  private final boolean I3;
  private final int J3;
  private final boolean K3;
  @Nullable
  private b0.a L3;
  private int M3;
  private TrackGroupArray N3;
  private q[] O3;
  private q[] P3;
  private int[][] Q3;
  private int R3;
  private com.google.android.exoplayer2.source.o0 S3;
  private final k c;
  private final HlsPlaylistTracker d;
  private final j f;
  private final f0.a p0;
  private final e p1;
  private final IdentityHashMap<n0, Integer> p2;
  private final r p3;
  @Nullable
  private final a0 q;
  private final com.google.android.exoplayer2.drm.x x;
  private final v.a y;
  private final com.google.android.exoplayer2.upstream.x z;
  
  public o(k paramk, HlsPlaylistTracker paramHlsPlaylistTracker, j paramj, @Nullable a0 parama0, com.google.android.exoplayer2.drm.x paramx, v.a parama, com.google.android.exoplayer2.upstream.x paramx1, f0.a parama1, e parame, com.google.android.exoplayer2.source.r paramr, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.c = paramk;
    this.d = paramHlsPlaylistTracker;
    this.f = paramj;
    this.q = parama0;
    this.x = paramx;
    this.y = parama;
    this.z = paramx1;
    this.p0 = parama1;
    this.p1 = parame;
    this.H3 = paramr;
    this.I3 = paramBoolean1;
    this.J3 = paramInt;
    this.K3 = paramBoolean2;
    this.S3 = paramr.a(new com.google.android.exoplayer2.source.o0[0]);
    this.p2 = new IdentityHashMap();
    this.p3 = new r();
    this.O3 = new q[0];
    this.P3 = new q[0];
    this.Q3 = new int[0][];
  }
  
  private void r(long paramLong, List<f.a> paramList, List<q> paramList1, List<int[]> paramList2, Map<String, DrmInitData> paramMap)
  {
    ArrayList localArrayList1 = new ArrayList(paramList.size());
    ArrayList localArrayList2 = new ArrayList(paramList.size());
    ArrayList localArrayList3 = new ArrayList(paramList.size());
    HashSet localHashSet = new HashSet();
    for (int i = 0; i < paramList.size(); i++)
    {
      String str = ((f.a)paramList.get(i)).d;
      if (localHashSet.add(str))
      {
        localArrayList1.clear();
        localArrayList2.clear();
        localArrayList3.clear();
        int j = 0;
        int m;
        for (int k = 1; j < paramList.size(); k = m)
        {
          m = k;
          if (com.google.android.exoplayer2.util.o0.b(str, ((f.a)paramList.get(j)).d))
          {
            localObject = (f.a)paramList.get(j);
            localArrayList3.add(Integer.valueOf(j));
            localArrayList1.add(((f.a)localObject).a);
            localArrayList2.add(((f.a)localObject).b);
            if (com.google.android.exoplayer2.util.o0.F(((f.a)localObject).b.p1, 1) == 1) {
              m = 1;
            } else {
              m = 0;
            }
            m = k & m;
          }
          j++;
        }
        Object localObject = w(1, (Uri[])localArrayList1.toArray((Uri[])com.google.android.exoplayer2.util.o0.j(new Uri[0])), (Format[])localArrayList2.toArray(new Format[0]), null, Collections.emptyList(), paramMap, paramLong);
        paramList2.add(d.j(localArrayList3));
        paramList1.add(localObject);
        if ((this.I3) && (k != 0)) {
          ((q)localObject).c0(new TrackGroup[] { new TrackGroup((Format[])localArrayList2.toArray(new Format[0])) }, 0, new int[0]);
        }
      }
    }
  }
  
  private void t(f paramf, long paramLong, List<q> paramList, List<int[]> paramList1, Map<String, DrmInitData> paramMap)
  {
    int i = paramf.f.size();
    Object localObject1 = new int[i];
    int j = 0;
    int k = 0;
    int m = 0;
    while (j < paramf.f.size())
    {
      localObject2 = ((f.b)paramf.f.get(j)).b;
      if ((((Format)localObject2).N3 <= 0) && (com.google.android.exoplayer2.util.o0.G(((Format)localObject2).p1, 2) == null))
      {
        if (com.google.android.exoplayer2.util.o0.G(((Format)localObject2).p1, 1) != null)
        {
          localObject1[j] = 1;
          m++;
        }
        else
        {
          localObject1[j] = -1;
        }
      }
      else
      {
        localObject1[j] = 2;
        k++;
      }
      j++;
    }
    if (k > 0)
    {
      j = 1;
    }
    else
    {
      if (m < i)
      {
        k = i - m;
        j = 0;
        m = 1;
        break label174;
      }
      j = 0;
      k = i;
    }
    m = 0;
    label174:
    Uri[] arrayOfUri = new Uri[k];
    Object localObject2 = new Format[k];
    int[] arrayOfInt = new int[k];
    i = 0;
    int i1;
    for (int n = 0; i < paramf.f.size(); n = i1)
    {
      if (j != 0)
      {
        i1 = n;
        if (localObject1[i] != 2) {}
      }
      else if (m != 0)
      {
        i1 = n;
        if (localObject1[i] == 1) {}
      }
      else
      {
        f.b localb = (f.b)paramf.f.get(i);
        arrayOfUri[n] = localb.a;
        localObject2[n] = localb.b;
        arrayOfInt[n] = i;
        i1 = n + 1;
      }
      i++;
    }
    localObject1 = localObject2[0].p1;
    n = com.google.android.exoplayer2.util.o0.F((String)localObject1, 2);
    i = com.google.android.exoplayer2.util.o0.F((String)localObject1, 1);
    if ((i <= 1) && (n <= 1) && (i + n > 0)) {
      m = 1;
    } else {
      m = 0;
    }
    if ((j == 0) && (i > 0)) {
      j = 1;
    } else {
      j = 0;
    }
    paramMap = w(j, arrayOfUri, (Format[])localObject2, paramf.k, paramf.l, paramMap, paramLong);
    paramList.add(paramMap);
    paramList1.add(arrayOfInt);
    if ((this.I3) && (m != 0))
    {
      paramList = new ArrayList();
      if (n > 0)
      {
        paramList1 = new Format[k];
        for (j = 0; j < k; j++) {
          paramList1[j] = z(localObject2[j]);
        }
        paramList.add(new TrackGroup(paramList1));
        if ((i > 0) && ((paramf.k != null) || (paramf.h.isEmpty()))) {
          paramList.add(new TrackGroup(new Format[] { x(localObject2[0], paramf.k, false) }));
        }
        paramf = paramf.l;
        if (paramf != null) {
          for (k = 0; k < paramf.size(); k++) {
            paramList.add(new TrackGroup(new Format[] { (Format)paramf.get(k) }));
          }
        }
      }
      else
      {
        paramList1 = new Format[k];
        for (j = 0; j < k; j++) {
          paramList1[j] = x(localObject2[j], paramf.k, true);
        }
        paramList.add(new TrackGroup(paramList1));
      }
      paramf = new TrackGroup(new Format[] { new Format.b().S("ID3").e0("application/id3").E() });
      paramList.add(paramf);
      paramMap.c0((TrackGroup[])paramList.toArray(new TrackGroup[0]), 0, new int[] { paramList.indexOf(paramf) });
    }
  }
  
  private void v(long paramLong)
  {
    Object localObject1 = (f)com.google.android.exoplayer2.util.g.e(this.d.e());
    if (this.K3) {
      localObject2 = y(((f)localObject1).n);
    } else {
      localObject2 = Collections.emptyMap();
    }
    boolean bool = ((f)localObject1).f.isEmpty();
    Object localObject3 = ((f)localObject1).h;
    List localList = ((f)localObject1).i;
    int i = 0;
    this.M3 = 0;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((bool ^ true)) {
      t((f)localObject1, paramLong, localArrayList1, localArrayList2, (Map)localObject2);
    }
    r(paramLong, (List)localObject3, localArrayList1, localArrayList2, (Map)localObject2);
    this.R3 = localArrayList1.size();
    for (int j = 0; j < localList.size(); j++)
    {
      localObject1 = (f.a)localList.get(j);
      Uri localUri = ((f.a)localObject1).a;
      Format localFormat = ((f.a)localObject1).b;
      localObject3 = Collections.emptyList();
      localObject3 = w(3, new Uri[] { localUri }, new Format[] { localFormat }, null, (List)localObject3, (Map)localObject2, paramLong);
      localArrayList2.add(new int[] { j });
      localArrayList1.add(localObject3);
      ((q)localObject3).c0(new TrackGroup[] { new TrackGroup(new Format[] { ((f.a)localObject1).b }) }, 0, new int[0]);
    }
    this.O3 = ((q[])localArrayList1.toArray(new q[0]));
    this.Q3 = ((int[][])localArrayList2.toArray(new int[0][]));
    Object localObject2 = this.O3;
    this.M3 = localObject2.length;
    localObject2[0].l0(true);
    localObject2 = this.O3;
    int k = localObject2.length;
    for (j = i; j < k; j++) {
      localObject2[j].z();
    }
    this.P3 = this.O3;
  }
  
  private q w(int paramInt, Uri[] paramArrayOfUri, Format[] paramArrayOfFormat, @Nullable Format paramFormat, @Nullable List<Format> paramList, Map<String, DrmInitData> paramMap, long paramLong)
  {
    return new q(paramInt, this, new i(this.c, this.d, paramArrayOfUri, paramArrayOfFormat, this.f, this.q, this.p3, paramList), paramMap, this.p1, paramLong, paramFormat, this.x, this.y, this.z, this.p0, this.J3);
  }
  
  private static Format x(Format paramFormat1, @Nullable Format paramFormat2, boolean paramBoolean)
  {
    int i = -1;
    Object localObject1;
    int j;
    int k;
    int m;
    Object localObject2;
    Object localObject3;
    if (paramFormat2 != null)
    {
      str = paramFormat2.p1;
      localObject1 = paramFormat2.p2;
      j = paramFormat2.U3;
      k = paramFormat2.q;
      m = paramFormat2.x;
      localObject2 = paramFormat2.f;
      localObject3 = paramFormat2.d;
      paramFormat2 = str;
    }
    else
    {
      localObject3 = com.google.android.exoplayer2.util.o0.G(paramFormat1.p1, 1);
      paramFormat2 = paramFormat1.p2;
      if (paramBoolean)
      {
        j = paramFormat1.U3;
        k = paramFormat1.q;
        m = paramFormat1.x;
        str = paramFormat1.f;
        localObject2 = paramFormat1.d;
        localObject1 = localObject3;
        localObject3 = localObject2;
        localObject2 = paramFormat2;
        paramFormat2 = (Format)localObject1;
        localObject1 = localObject2;
        localObject2 = str;
      }
      else
      {
        localObject2 = null;
        localObject1 = paramFormat2;
        m = 0;
        k = 0;
        j = -1;
        paramFormat2 = (Format)localObject3;
        localObject3 = localObject2;
      }
    }
    String str = y.g(paramFormat2);
    int n;
    if (paramBoolean) {
      n = paramFormat1.y;
    } else {
      n = -1;
    }
    if (paramBoolean) {
      i = paramFormat1.z;
    }
    return new Format.b().S(paramFormat1.c).U((String)localObject3).K(paramFormat1.p3).e0(str).I(paramFormat2).X((Metadata)localObject1).G(n).Z(i).H(j).g0(k).c0(m).V((String)localObject2).E();
  }
  
  private static Map<String, DrmInitData> y(List<DrmInitData> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < localArrayList.size())
    {
      DrmInitData localDrmInitData1 = (DrmInitData)paramList.get(i);
      String str = localDrmInitData1.f;
      i++;
      int j = i;
      while (j < localArrayList.size())
      {
        DrmInitData localDrmInitData2 = (DrmInitData)localArrayList.get(j);
        if (TextUtils.equals(localDrmInitData2.f, str))
        {
          localDrmInitData1 = localDrmInitData1.f(localDrmInitData2);
          localArrayList.remove(j);
        }
        else
        {
          j++;
        }
      }
      localHashMap.put(str, localDrmInitData1);
    }
    return localHashMap;
  }
  
  private static Format z(Format paramFormat)
  {
    String str1 = com.google.android.exoplayer2.util.o0.G(paramFormat.p1, 2);
    String str2 = y.g(str1);
    return new Format.b().S(paramFormat.c).U(paramFormat.d).K(paramFormat.p3).e0(str2).I(str1).X(paramFormat.p2).G(paramFormat.y).Z(paramFormat.z).j0(paramFormat.M3).Q(paramFormat.N3).P(paramFormat.O3).g0(paramFormat.q).c0(paramFormat.x).E();
  }
  
  public void A(q paramq)
  {
    this.L3.n(this);
  }
  
  public void B()
  {
    this.d.a(this);
    q[] arrayOfq = this.O3;
    int i = arrayOfq.length;
    for (int j = 0; j < i; j++) {
      arrayOfq[j].e0();
    }
    this.L3 = null;
  }
  
  public long a()
  {
    return this.S3.a();
  }
  
  public void b()
  {
    int i = this.M3 - 1;
    this.M3 = i;
    if (i > 0) {
      return;
    }
    q[] arrayOfq = this.O3;
    int j = arrayOfq.length;
    int k = 0;
    i = 0;
    while (k < j)
    {
      i += arrayOfq[k].s().d;
      k++;
    }
    TrackGroup[] arrayOfTrackGroup = new TrackGroup[i];
    arrayOfq = this.O3;
    int m = arrayOfq.length;
    i = 0;
    k = 0;
    while (i < m)
    {
      q localq = arrayOfq[i];
      int n = localq.s().d;
      j = 0;
      while (j < n)
      {
        arrayOfTrackGroup[k] = localq.s().a(j);
        j++;
        k++;
      }
      i++;
    }
    this.N3 = new TrackGroupArray(arrayOfTrackGroup);
    this.L3.p(this);
  }
  
  public boolean c()
  {
    return this.S3.c();
  }
  
  public boolean d(long paramLong)
  {
    if (this.N3 == null)
    {
      q[] arrayOfq = this.O3;
      int i = arrayOfq.length;
      for (int j = 0; j < i; j++) {
        arrayOfq[j].z();
      }
      return false;
    }
    return this.S3.d(paramLong);
  }
  
  public long e()
  {
    return this.S3.e();
  }
  
  public void f(long paramLong)
  {
    this.S3.f(paramLong);
  }
  
  public void g()
  {
    q[] arrayOfq = this.O3;
    int i = arrayOfq.length;
    for (int j = 0; j < i; j++) {
      arrayOfq[j].a0();
    }
    this.L3.n(this);
  }
  
  public boolean h(Uri paramUri, x.c paramc, boolean paramBoolean)
  {
    q[] arrayOfq = this.O3;
    int i = arrayOfq.length;
    boolean bool = true;
    for (int j = 0; j < i; j++) {
      bool &= arrayOfq[j].Z(paramUri, paramc, paramBoolean);
    }
    this.L3.n(this);
    return bool;
  }
  
  public long i(long paramLong)
  {
    q[] arrayOfq = this.P3;
    if (arrayOfq.length > 0)
    {
      boolean bool = arrayOfq[0].h0(paramLong, false);
      for (int i = 1;; i++)
      {
        arrayOfq = this.P3;
        if (i >= arrayOfq.length) {
          break;
        }
        arrayOfq[i].h0(paramLong, bool);
      }
      if (bool) {
        this.p3.b();
      }
    }
    return paramLong;
  }
  
  public long j(long paramLong, g2 paramg2)
  {
    return paramLong;
  }
  
  public long k()
  {
    return -9223372036854775807L;
  }
  
  public void l(b0.a parama, long paramLong)
  {
    this.L3 = parama;
    this.d.g(this);
    v(paramLong);
  }
  
  public long m(com.google.android.exoplayer2.trackselection.g[] paramArrayOfg, boolean[] paramArrayOfBoolean1, n0[] paramArrayOfn0, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    Object localObject1 = paramArrayOfn0;
    int[] arrayOfInt1 = new int[paramArrayOfg.length];
    int[] arrayOfInt2 = new int[paramArrayOfg.length];
    Object localObject3;
    for (int i = 0; i < paramArrayOfg.length; i++)
    {
      if (localObject1[i] == null) {
        j = -1;
      } else {
        j = ((Integer)this.p2.get(localObject1[i])).intValue();
      }
      arrayOfInt1[i] = j;
      arrayOfInt2[i] = -1;
      if (paramArrayOfg[i] != null)
      {
        localObject2 = paramArrayOfg[i].m();
        for (j = 0;; j++)
        {
          localObject3 = this.O3;
          if (j >= localObject3.length) {
            break;
          }
          if (localObject3[j].s().b((TrackGroup)localObject2) != -1)
          {
            arrayOfInt2[i] = j;
            break;
          }
        }
      }
    }
    this.p2.clear();
    int k = paramArrayOfg.length;
    n0[] arrayOfn01 = new n0[k];
    n0[] arrayOfn02 = new n0[paramArrayOfg.length];
    Object localObject2 = new com.google.android.exoplayer2.trackselection.g[paramArrayOfg.length];
    localObject1 = new q[this.O3.length];
    i = 0;
    int j = 0;
    boolean bool1 = false;
    Object localObject4;
    for (;;)
    {
      localObject4 = paramArrayOfn0;
      if (j >= this.O3.length) {
        break;
      }
      for (int m = 0; m < paramArrayOfg.length; m++)
      {
        n = arrayOfInt1[m];
        Object localObject5 = null;
        if (n == j) {
          localObject3 = localObject4[m];
        } else {
          localObject3 = null;
        }
        arrayOfn02[m] = localObject3;
        localObject3 = localObject5;
        if (arrayOfInt2[m] == j) {
          localObject3 = paramArrayOfg[m];
        }
        localObject2[m] = localObject3;
      }
      localObject3 = this.O3[j];
      boolean bool2 = ((q)localObject3).i0((com.google.android.exoplayer2.trackselection.g[])localObject2, paramArrayOfBoolean1, arrayOfn02, paramArrayOfBoolean2, paramLong, bool1);
      m = 0;
      int i1;
      boolean bool3;
      boolean bool4;
      for (int n = 0;; n = i1)
      {
        i1 = paramArrayOfg.length;
        bool3 = true;
        bool4 = true;
        if (m >= i1) {
          break;
        }
        localObject4 = arrayOfn02[m];
        if (arrayOfInt2[m] == j)
        {
          com.google.android.exoplayer2.util.g.e(localObject4);
          arrayOfn01[m] = localObject4;
          this.p2.put(localObject4, Integer.valueOf(j));
          i1 = 1;
        }
        else
        {
          i1 = n;
          if (arrayOfInt1[m] == j)
          {
            if (localObject4 != null) {
              bool4 = false;
            }
            com.google.android.exoplayer2.util.g.g(bool4);
            i1 = n;
          }
        }
        m++;
      }
      if (n != 0)
      {
        localObject1[i] = localObject3;
        m = i + 1;
        if (i == 0)
        {
          ((q)localObject3).l0(true);
          if (!bool2)
          {
            localObject4 = this.P3;
            if (localObject4.length != 0)
            {
              i = m;
              if (localObject3 == localObject4[0]) {
                break label544;
              }
            }
          }
          this.p3.b();
          bool1 = true;
          i = m;
        }
        else
        {
          if (j < this.R3) {
            bool4 = bool3;
          } else {
            bool4 = false;
          }
          ((q)localObject3).l0(bool4);
          i = m;
        }
      }
      label544:
      j++;
    }
    System.arraycopy(arrayOfn01, 0, localObject4, 0, k);
    paramArrayOfg = (q[])com.google.android.exoplayer2.util.o0.w0((Object[])localObject1, i);
    this.P3 = paramArrayOfg;
    this.S3 = this.H3.a(paramArrayOfg);
    return paramLong;
  }
  
  public void o(Uri paramUri)
  {
    this.d.f(paramUri);
  }
  
  public void q()
    throws IOException
  {
    q[] arrayOfq = this.O3;
    int i = arrayOfq.length;
    for (int j = 0; j < i; j++) {
      arrayOfq[j].q();
    }
  }
  
  public TrackGroupArray s()
  {
    return (TrackGroupArray)com.google.android.exoplayer2.util.g.e(this.N3);
  }
  
  public void u(long paramLong, boolean paramBoolean)
  {
    q[] arrayOfq = this.P3;
    int i = arrayOfq.length;
    for (int j = 0; j < i; j++) {
      arrayOfq[j].u(paramLong, paramBoolean);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\hls\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */