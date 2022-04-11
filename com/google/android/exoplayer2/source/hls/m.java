package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.hls.playlist.g.b;
import com.google.android.exoplayer2.source.hls.playlist.g.e;
import com.google.android.exoplayer2.source.hls.playlist.h;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.n.b;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.n0;
import com.google.common.base.c;
import com.google.common.collect.ImmutableList;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.AbstractCollection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class m
  extends com.google.android.exoplayer2.source.u0.d
{
  private static final AtomicInteger k = new AtomicInteger();
  private final d0 A;
  private final boolean B;
  private final boolean C;
  private n D;
  private q E;
  private int F;
  private boolean G;
  private volatile boolean H;
  private boolean I;
  private ImmutableList<Integer> J;
  private boolean K;
  private boolean L;
  public final int l;
  public final int m;
  public final Uri n;
  public final boolean o;
  public final int p;
  @Nullable
  private final l q;
  @Nullable
  private final com.google.android.exoplayer2.upstream.n r;
  @Nullable
  private final n s;
  private final boolean t;
  private final boolean u;
  private final l0 v;
  private final k w;
  @Nullable
  private final List<Format> x;
  @Nullable
  private final DrmInitData y;
  private final com.google.android.exoplayer2.metadata.id3.b z;
  
  private m(k paramk, l paraml1, com.google.android.exoplayer2.upstream.n paramn1, Format paramFormat, boolean paramBoolean1, @Nullable l paraml2, @Nullable com.google.android.exoplayer2.upstream.n paramn2, boolean paramBoolean2, Uri paramUri, @Nullable List<Format> paramList, int paramInt1, @Nullable Object paramObject, long paramLong1, long paramLong2, long paramLong3, int paramInt2, boolean paramBoolean3, int paramInt3, boolean paramBoolean4, boolean paramBoolean5, l0 paraml0, @Nullable DrmInitData paramDrmInitData, @Nullable n paramn, com.google.android.exoplayer2.metadata.id3.b paramb, d0 paramd0, boolean paramBoolean6)
  {
    super(paraml1, paramn1, paramFormat, paramInt1, paramObject, paramLong1, paramLong2, paramLong3);
    this.B = paramBoolean1;
    this.p = paramInt2;
    this.L = paramBoolean3;
    this.m = paramInt3;
    this.r = paramn2;
    this.q = paraml2;
    if (paramn2 != null) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    this.G = paramBoolean1;
    this.C = paramBoolean2;
    this.n = paramUri;
    this.t = paramBoolean5;
    this.v = paraml0;
    this.u = paramBoolean4;
    this.w = paramk;
    this.x = paramList;
    this.y = paramDrmInitData;
    this.s = paramn;
    this.z = paramb;
    this.A = paramd0;
    this.o = paramBoolean6;
    this.J = ImmutableList.of();
    this.l = k.getAndIncrement();
  }
  
  private static l h(l paraml, @Nullable byte[] paramArrayOfByte1, @Nullable byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 != null)
    {
      com.google.android.exoplayer2.util.g.e(paramArrayOfByte2);
      return new d(paraml, paramArrayOfByte1, paramArrayOfByte2);
    }
    return paraml;
  }
  
  public static m i(k paramk, l paraml, Format paramFormat, long paramLong, com.google.android.exoplayer2.source.hls.playlist.g paramg, i.e parame, Uri paramUri, @Nullable List<Format> paramList, int paramInt, @Nullable Object paramObject, boolean paramBoolean1, r paramr, @Nullable m paramm, @Nullable byte[] paramArrayOfByte1, @Nullable byte[] paramArrayOfByte2, boolean paramBoolean2)
  {
    g.e locale = parame.a;
    Object localObject = new n.b().i(n0.d(paramg.a, locale.c)).h(locale.p1).g(locale.p2);
    int i;
    if (parame.d) {
      i = 8;
    } else {
      i = 0;
    }
    com.google.android.exoplayer2.upstream.n localn = ((n.b)localObject).b(i).a();
    boolean bool1;
    if (paramArrayOfByte1 != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool1) {
      localObject = k((String)com.google.android.exoplayer2.util.g.e(locale.p0));
    } else {
      localObject = null;
    }
    l locall = h(paraml, paramArrayOfByte1, (byte[])localObject);
    localObject = locale.d;
    boolean bool2;
    if (localObject != null)
    {
      if (paramArrayOfByte2 != null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (bool2) {
        paramArrayOfByte1 = k((String)com.google.android.exoplayer2.util.g.e(((g.e)localObject).p0));
      } else {
        paramArrayOfByte1 = null;
      }
      localObject = new com.google.android.exoplayer2.upstream.n(n0.d(paramg.a, ((g.e)localObject).c), ((g.e)localObject).p1, ((g.e)localObject).p2);
      paramArrayOfByte1 = h(paraml, paramArrayOfByte2, paramArrayOfByte1);
      paramArrayOfByte2 = (byte[])localObject;
    }
    else
    {
      paramArrayOfByte1 = null;
      paramArrayOfByte2 = null;
      bool2 = false;
    }
    paramLong += locale.x;
    long l1 = locale.f;
    int j = paramg.j + locale.q;
    if (paramm != null)
    {
      paraml = paramm.r;
      if ((paramArrayOfByte2 != paraml) && ((paramArrayOfByte2 == null) || (paraml == null) || (!paramArrayOfByte2.a.equals(paraml.a)) || (paramArrayOfByte2.g != paramm.r.g))) {
        i = 0;
      } else {
        i = 1;
      }
      int i1;
      if ((paramUri.equals(paramm.n)) && (paramm.I)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      localObject = paramm.z;
      paramg = paramm.A;
      if ((i != 0) && (i1 != 0) && (!paramm.K) && (paramm.m == j)) {
        paraml = paramm.D;
      } else {
        paraml = null;
      }
      paramm = (m)localObject;
    }
    else
    {
      paraml = new com.google.android.exoplayer2.metadata.id3.b();
      paramg = new d0(10);
      localObject = null;
      paramm = paraml;
      paraml = (l)localObject;
    }
    return new m(paramk, locall, localn, paramFormat, bool1, paramArrayOfByte1, paramArrayOfByte2, bool2, paramUri, paramList, paramInt, paramObject, paramLong, paramLong + l1, parame.b, parame.c, parame.d ^ true, j, locale.p3, paramBoolean1, paramr.a(j), locale.y, paraml, paramm, paramg, paramBoolean2);
  }
  
  /* Error */
  @RequiresNonNull({"output"})
  private void j(l paraml, com.google.android.exoplayer2.upstream.n paramn, boolean paramBoolean)
    throws IOException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: iload_3
    //   7: ifeq +19 -> 26
    //   10: aload_0
    //   11: getfield 262	com/google/android/exoplayer2/source/hls/m:F	I
    //   14: ifeq +6 -> 20
    //   17: iconst_1
    //   18: istore 5
    //   20: aload_2
    //   21: astore 6
    //   23: goto +18 -> 41
    //   26: aload_2
    //   27: aload_0
    //   28: getfield 262	com/google/android/exoplayer2/source/hls/m:F	I
    //   31: i2l
    //   32: invokevirtual 265	com/google/android/exoplayer2/upstream/n:e	(J)Lcom/google/android/exoplayer2/upstream/n;
    //   35: astore 6
    //   37: iload 4
    //   39: istore 5
    //   41: aload_0
    //   42: aload_1
    //   43: aload 6
    //   45: invokespecial 268	com/google/android/exoplayer2/source/hls/m:u	(Lcom/google/android/exoplayer2/upstream/l;Lcom/google/android/exoplayer2/upstream/n;)Lcom/google/android/exoplayer2/o2/g;
    //   48: astore 6
    //   50: iload 5
    //   52: ifeq +14 -> 66
    //   55: aload 6
    //   57: aload_0
    //   58: getfield 262	com/google/android/exoplayer2/source/hls/m:F	I
    //   61: invokeinterface 272 2 0
    //   66: aload_0
    //   67: getfield 274	com/google/android/exoplayer2/source/hls/m:H	Z
    //   70: ifne +22 -> 92
    //   73: aload_0
    //   74: getfield 228	com/google/android/exoplayer2/source/hls/m:D	Lcom/google/android/exoplayer2/source/hls/n;
    //   77: aload 6
    //   79: invokeinterface 279 2 0
    //   84: istore_3
    //   85: iload_3
    //   86: ifeq +6 -> 92
    //   89: goto -23 -> 66
    //   92: aload 6
    //   94: invokeinterface 283 1 0
    //   99: lstore 7
    //   101: aload_2
    //   102: getfield 222	com/google/android/exoplayer2/upstream/n:g	J
    //   105: lstore 9
    //   107: aload_0
    //   108: lload 7
    //   110: lload 9
    //   112: lsub
    //   113: l2i
    //   114: putfield 262	com/google/android/exoplayer2/source/hls/m:F	I
    //   117: goto +51 -> 168
    //   120: astore 11
    //   122: goto +54 -> 176
    //   125: astore 11
    //   127: aload_0
    //   128: getfield 288	com/google/android/exoplayer2/source/u0/b:d	Lcom/google/android/exoplayer2/Format;
    //   131: getfield 292	com/google/android/exoplayer2/Format:x	I
    //   134: sipush 16384
    //   137: iand
    //   138: ifeq +35 -> 173
    //   141: aload_0
    //   142: getfield 228	com/google/android/exoplayer2/source/hls/m:D	Lcom/google/android/exoplayer2/source/hls/n;
    //   145: invokeinterface 294 1 0
    //   150: aload 6
    //   152: invokeinterface 283 1 0
    //   157: lstore 7
    //   159: aload_2
    //   160: getfield 222	com/google/android/exoplayer2/upstream/n:g	J
    //   163: lstore 9
    //   165: goto -58 -> 107
    //   168: aload_1
    //   169: invokestatic 299	com/google/android/exoplayer2/util/o0:l	(Lcom/google/android/exoplayer2/upstream/l;)V
    //   172: return
    //   173: aload 11
    //   175: athrow
    //   176: aload_0
    //   177: aload 6
    //   179: invokeinterface 283 1 0
    //   184: aload_2
    //   185: getfield 222	com/google/android/exoplayer2/upstream/n:g	J
    //   188: lsub
    //   189: l2i
    //   190: putfield 262	com/google/android/exoplayer2/source/hls/m:F	I
    //   193: aload 11
    //   195: athrow
    //   196: astore_2
    //   197: aload_1
    //   198: invokestatic 299	com/google/android/exoplayer2/util/o0:l	(Lcom/google/android/exoplayer2/upstream/l;)V
    //   201: aload_2
    //   202: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	m
    //   0	203	1	paraml	l
    //   0	203	2	paramn	com.google.android.exoplayer2.upstream.n
    //   0	203	3	paramBoolean	boolean
    //   1	37	4	i	int
    //   4	47	5	j	int
    //   21	157	6	localObject1	Object
    //   99	59	7	l1	long
    //   105	59	9	l2	long
    //   120	1	11	localObject2	Object
    //   125	69	11	localEOFException	EOFException
    // Exception table:
    //   from	to	target	type
    //   66	85	120	finally
    //   127	150	120	finally
    //   173	176	120	finally
    //   66	85	125	java/io/EOFException
    //   41	50	196	finally
    //   55	66	196	finally
    //   92	107	196	finally
    //   107	117	196	finally
    //   150	165	196	finally
    //   176	196	196	finally
  }
  
  private static byte[] k(String paramString)
  {
    Object localObject = paramString;
    if (c.e(paramString).startsWith("0x")) {
      localObject = paramString.substring(2);
    }
    localObject = new BigInteger((String)localObject, 16).toByteArray();
    paramString = new byte[16];
    int i;
    if (localObject.length > 16) {
      i = localObject.length - 16;
    } else {
      i = 0;
    }
    System.arraycopy(localObject, i, paramString, 16 - localObject.length + i, localObject.length - i);
    return paramString;
  }
  
  private static boolean o(i.e parame, com.google.android.exoplayer2.source.hls.playlist.g paramg)
  {
    g.e locale = parame.a;
    if ((locale instanceof g.b))
    {
      boolean bool;
      if ((!((g.b)locale).H3) && ((parame.c != 0) || (!paramg.c))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    return paramg.c;
  }
  
  @RequiresNonNull({"output"})
  private void r()
    throws IOException
  {
    try
    {
      this.v.h(this.t, this.g);
      j(this.i, this.b, this.B);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new InterruptedIOException();
    }
  }
  
  @RequiresNonNull({"output"})
  private void s()
    throws IOException
  {
    if (!this.G) {
      return;
    }
    com.google.android.exoplayer2.util.g.e(this.q);
    com.google.android.exoplayer2.util.g.e(this.r);
    j(this.q, this.r, this.C);
    this.F = 0;
    this.G = false;
  }
  
  private long t(com.google.android.exoplayer2.o2.k paramk)
    throws IOException
  {
    paramk.e();
    try
    {
      this.A.L(10);
      paramk.n(this.A.d(), 0, 10);
      if (this.A.G() != 4801587) {
        return -9223372036854775807L;
      }
      this.A.Q(3);
      int i = this.A.C();
      int j = i + 10;
      Object localObject;
      if (j > this.A.b())
      {
        localObject = this.A.d();
        this.A.L(j);
        System.arraycopy(localObject, 0, this.A.d(), 0, 10);
      }
      paramk.n(this.A.d(), 10, i);
      paramk = this.z.d(this.A.d(), i);
      if (paramk == null) {
        return -9223372036854775807L;
      }
      i = paramk.d();
      for (j = 0; j < i; j++)
      {
        localObject = paramk.c(j);
        if ((localObject instanceof PrivFrame))
        {
          localObject = (PrivFrame)localObject;
          if ("com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame)localObject).d))
          {
            System.arraycopy(((PrivFrame)localObject).f, 0, this.A.d(), 0, 8);
            this.A.P(0);
            this.A.O(8);
            return this.A.w() & 0x1FFFFFFFF;
          }
        }
      }
    }
    catch (EOFException paramk)
    {
      for (;;) {}
    }
    return -9223372036854775807L;
  }
  
  @EnsuresNonNull({"extractor"})
  @RequiresNonNull({"output"})
  private com.google.android.exoplayer2.o2.g u(l paraml, com.google.android.exoplayer2.upstream.n paramn)
    throws IOException
  {
    long l1 = paraml.j(paramn);
    com.google.android.exoplayer2.o2.g localg = new com.google.android.exoplayer2.o2.g(paraml, paramn.g, l1);
    if (this.D == null)
    {
      l1 = t(localg);
      localg.e();
      n localn = this.s;
      if (localn != null) {
        paraml = localn.f();
      } else {
        paraml = this.w.a(paramn.a, this.d, this.x, this.v, paraml.d(), localg);
      }
      this.D = paraml;
      if (paraml.e())
      {
        paraml = this.E;
        if (l1 != -9223372036854775807L) {
          l1 = this.v.b(l1);
        } else {
          l1 = this.g;
        }
        paraml.m0(l1);
      }
      else
      {
        this.E.m0(0L);
      }
      this.E.Y();
      this.D.b(this.E);
    }
    this.E.j0(this.y);
    return localg;
  }
  
  public static boolean w(@Nullable m paramm, Uri paramUri, com.google.android.exoplayer2.source.hls.playlist.g paramg, i.e parame, long paramLong)
  {
    boolean bool = false;
    if (paramm == null) {
      return false;
    }
    if ((paramUri.equals(paramm.n)) && (paramm.I)) {
      return false;
    }
    long l1 = parame.a.x;
    if ((!o(parame, paramg)) || (paramLong + l1 < paramm.h)) {
      bool = true;
    }
    return bool;
  }
  
  public void a()
    throws IOException
  {
    com.google.android.exoplayer2.util.g.e(this.E);
    if (this.D == null)
    {
      n localn = this.s;
      if ((localn != null) && (localn.d()))
      {
        this.D = this.s;
        this.G = false;
      }
    }
    s();
    if (!this.H)
    {
      if (!this.u) {
        r();
      }
      this.I = (this.H ^ true);
    }
  }
  
  public void c()
  {
    this.H = true;
  }
  
  public int l(int paramInt)
  {
    com.google.android.exoplayer2.util.g.g(this.o ^ true);
    if (paramInt >= this.J.size()) {
      return 0;
    }
    return ((Integer)this.J.get(paramInt)).intValue();
  }
  
  public void m(q paramq, ImmutableList<Integer> paramImmutableList)
  {
    this.E = paramq;
    this.J = paramImmutableList;
  }
  
  public void n()
  {
    this.K = true;
  }
  
  public boolean p()
  {
    return this.I;
  }
  
  public boolean q()
  {
    return this.L;
  }
  
  public void v()
  {
    this.L = true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\hls\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */