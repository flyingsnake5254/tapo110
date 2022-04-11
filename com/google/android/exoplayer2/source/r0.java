package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.b;
import com.google.android.exoplayer2.upstream.Loader.c;
import com.google.android.exoplayer2.upstream.Loader.e;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.l.a;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.upstream.x.c;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.y;
import com.google.android.exoplayer2.w0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

final class r0
  implements b0, Loader.b<c>
{
  boolean H3;
  byte[] I3;
  int J3;
  private final n c;
  private final l.a d;
  @Nullable
  private final com.google.android.exoplayer2.upstream.a0 f;
  private final long p0;
  final Loader p1;
  final Format p2;
  final boolean p3;
  private final com.google.android.exoplayer2.upstream.x q;
  private final f0.a x;
  private final TrackGroupArray y;
  private final ArrayList<b> z;
  
  public r0(n paramn, l.a parama, @Nullable com.google.android.exoplayer2.upstream.a0 parama0, Format paramFormat, long paramLong, com.google.android.exoplayer2.upstream.x paramx, f0.a parama1, boolean paramBoolean)
  {
    this.c = paramn;
    this.d = parama;
    this.f = parama0;
    this.p2 = paramFormat;
    this.p0 = paramLong;
    this.q = paramx;
    this.x = parama1;
    this.p3 = paramBoolean;
    this.y = new TrackGroupArray(new TrackGroup[] { new TrackGroup(new Format[] { paramFormat }) });
    this.z = new ArrayList();
    this.p1 = new Loader("SingleSampleMediaPeriod");
  }
  
  public long a()
  {
    long l;
    if ((!this.H3) && (!this.p1.i())) {
      l = 0L;
    } else {
      l = Long.MIN_VALUE;
    }
    return l;
  }
  
  public boolean c()
  {
    return this.p1.i();
  }
  
  public boolean d(long paramLong)
  {
    if ((!this.H3) && (!this.p1.i()) && (!this.p1.h()))
    {
      Object localObject = this.d.a();
      com.google.android.exoplayer2.upstream.a0 locala0 = this.f;
      if (locala0 != null) {
        ((l)localObject).b(locala0);
      }
      localObject = new c(this.c, (l)localObject);
      paramLong = this.p1.n((Loader.e)localObject, this, this.q.b(1));
      this.x.A(new x(((c)localObject).a, this.c, paramLong), 1, -1, this.p2, 0, null, 0L, this.p0);
      return true;
    }
    return false;
  }
  
  public long e()
  {
    long l;
    if (this.H3) {
      l = Long.MIN_VALUE;
    } else {
      l = 0L;
    }
    return l;
  }
  
  public void f(long paramLong) {}
  
  public long i(long paramLong)
  {
    for (int i = 0; i < this.z.size(); i++) {
      ((b)this.z.get(i)).e();
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
    parama.p(this);
  }
  
  public long m(com.google.android.exoplayer2.trackselection.g[] paramArrayOfg, boolean[] paramArrayOfBoolean1, n0[] paramArrayOfn0, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    for (int i = 0; i < paramArrayOfg.length; i++)
    {
      if ((paramArrayOfn0[i] != null) && ((paramArrayOfg[i] == null) || (paramArrayOfBoolean1[i] == 0)))
      {
        this.z.remove(paramArrayOfn0[i]);
        paramArrayOfn0[i] = null;
      }
      if ((paramArrayOfn0[i] == null) && (paramArrayOfg[i] != null))
      {
        b localb = new b(null);
        this.z.add(localb);
        paramArrayOfn0[i] = localb;
        paramArrayOfBoolean2[i] = true;
      }
    }
    return paramLong;
  }
  
  public void o(c paramc, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Object localObject = c.b(paramc);
    localObject = new x(paramc.a, paramc.b, ((z)localObject).p(), ((z)localObject).q(), paramLong1, paramLong2, ((z)localObject).o());
    this.q.d(paramc.a);
    this.x.r((x)localObject, 1, -1, null, 0, null, 0L, this.p0);
  }
  
  public void p(c paramc, long paramLong1, long paramLong2)
  {
    this.J3 = ((int)c.b(paramc).o());
    this.I3 = ((byte[])com.google.android.exoplayer2.util.g.e(c.d(paramc)));
    this.H3 = true;
    Object localObject = c.b(paramc);
    localObject = new x(paramc.a, paramc.b, ((z)localObject).p(), ((z)localObject).q(), paramLong1, paramLong2, this.J3);
    this.q.d(paramc.a);
    this.x.u((x)localObject, 1, -1, this.p2, 0, null, 0L, this.p0);
  }
  
  public void q() {}
  
  public Loader.c r(c paramc, long paramLong1, long paramLong2, IOException paramIOException, int paramInt)
  {
    Object localObject = c.b(paramc);
    x localx = new x(paramc.a, paramc.b, ((z)localObject).p(), ((z)localObject).q(), paramLong1, paramLong2, ((z)localObject).o());
    localObject = new a0(1, -1, this.p2, 0, null, 0L, w0.e(this.p0));
    paramLong1 = this.q.a(new x.c(localx, (a0)localObject, paramIOException, paramInt));
    boolean bool1 = paramLong1 < -9223372036854775807L;
    if ((bool1) && (paramInt < this.q.b(1))) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    if ((this.p3) && (paramInt != 0))
    {
      u.i("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", paramIOException);
      this.H3 = true;
      localObject = Loader.c;
    }
    for (;;)
    {
      break;
      if (bool1) {
        localObject = Loader.g(false, paramLong1);
      } else {
        localObject = Loader.d;
      }
    }
    boolean bool2 = ((Loader.c)localObject).c() ^ true;
    this.x.w(localx, 1, -1, this.p2, 0, null, 0L, this.p0, paramIOException, bool2);
    if (bool2) {
      this.q.d(paramc.a);
    }
    return (Loader.c)localObject;
  }
  
  public TrackGroupArray s()
  {
    return this.y;
  }
  
  public void t()
  {
    this.p1.l();
  }
  
  public void u(long paramLong, boolean paramBoolean) {}
  
  private final class b
    implements n0
  {
    private int a;
    private boolean b;
    
    private b() {}
    
    private void d()
    {
      if (!this.b)
      {
        r0.g(r0.this).c(y.k(r0.this.p2.H3), r0.this.p2, 0, null, 0L);
        this.b = true;
      }
    }
    
    public void a()
      throws IOException
    {
      r0 localr0 = r0.this;
      if (!localr0.p3) {
        localr0.p1.j();
      }
    }
    
    public int b(i1 parami1, DecoderInputBuffer paramDecoderInputBuffer, int paramInt)
    {
      d();
      r0 localr0 = r0.this;
      boolean bool = localr0.H3;
      if ((bool) && (localr0.I3 == null)) {
        this.a = 2;
      }
      int i = this.a;
      if (i == 2)
      {
        paramDecoderInputBuffer.e(4);
        return -4;
      }
      if (((paramInt & 0x2) == 0) && (i != 0))
      {
        if (!bool) {
          return -3;
        }
        com.google.android.exoplayer2.util.g.e(localr0.I3);
        paramDecoderInputBuffer.e(1);
        paramDecoderInputBuffer.x = 0L;
        if ((paramInt & 0x4) == 0)
        {
          paramDecoderInputBuffer.o(r0.this.J3);
          paramDecoderInputBuffer = paramDecoderInputBuffer.f;
          parami1 = r0.this;
          paramDecoderInputBuffer.put(parami1.I3, 0, parami1.J3);
        }
        if ((paramInt & 0x1) == 0) {
          this.a = 2;
        }
        return -4;
      }
      parami1.b = localr0.p2;
      this.a = 1;
      return -5;
    }
    
    public int c(long paramLong)
    {
      d();
      if ((paramLong > 0L) && (this.a != 2))
      {
        this.a = 2;
        return 1;
      }
      return 0;
    }
    
    public void e()
    {
      if (this.a == 2) {
        this.a = 1;
      }
    }
    
    public boolean g()
    {
      return r0.this.H3;
    }
  }
  
  static final class c
    implements Loader.e
  {
    public final long a = x.a();
    public final n b;
    private final z c;
    @Nullable
    private byte[] d;
    
    public c(n paramn, l paraml)
    {
      this.b = paramn;
      this.c = new z(paraml);
    }
    
    public void a()
      throws IOException
    {
      this.c.r();
      try
      {
        this.c.j(this.b);
        byte[] arrayOfByte;
        z localz;
        for (int i = 0; i != -1; i = localz.read(arrayOfByte, i, arrayOfByte.length - i))
        {
          i = (int)this.c.o();
          arrayOfByte = this.d;
          if (arrayOfByte == null) {
            this.d = new byte['Ѐ'];
          } else if (i == arrayOfByte.length) {
            this.d = Arrays.copyOf(arrayOfByte, arrayOfByte.length * 2);
          }
          localz = this.c;
          arrayOfByte = this.d;
        }
        return;
      }
      finally
      {
        o0.l(this.c);
      }
    }
    
    public void c() {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\r0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */