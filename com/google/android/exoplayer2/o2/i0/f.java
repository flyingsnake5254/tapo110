package com.google.android.exoplayer2.o2.i0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.e0;
import com.google.android.exoplayer2.audio.e0.a;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.b.a;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.j;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.o;
import com.google.android.exoplayer2.o2.u;
import com.google.android.exoplayer2.o2.v;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.w0;
import java.io.EOFException;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class f
  implements j
{
  public static final o a = a.b;
  private static final b.a b = b.a;
  private final int c;
  private final long d;
  private final d0 e;
  private final e0.a f;
  private final u g;
  private final v h;
  private final b0 i;
  private l j;
  private b0 k;
  private b0 l;
  private int m;
  @Nullable
  private Metadata n;
  private long o;
  private long p;
  private long q;
  private int r;
  private g s;
  private boolean t;
  private boolean u;
  private long v;
  
  public f()
  {
    this(0);
  }
  
  public f(int paramInt)
  {
    this(paramInt, -9223372036854775807L);
  }
  
  public f(int paramInt, long paramLong)
  {
    this.c = paramInt;
    this.d = paramLong;
    this.e = new d0(10);
    this.f = new e0.a();
    this.g = new u();
    this.o = -9223372036854775807L;
    this.h = new v();
    com.google.android.exoplayer2.o2.i locali = new com.google.android.exoplayer2.o2.i();
    this.i = locali;
    this.l = locali;
  }
  
  @EnsuresNonNull({"extractorOutput", "realTrackOutput"})
  private void a()
  {
    com.google.android.exoplayer2.util.g.i(this.k);
    o0.i(this.j);
  }
  
  private g f(k paramk)
    throws IOException
  {
    Object localObject1 = p(paramk);
    Object localObject2 = o(this.n, paramk.getPosition());
    if (this.t) {
      return new g.a();
    }
    if ((this.c & 0x2) != 0)
    {
      long l1;
      long l2;
      if (localObject2 != null)
      {
        l1 = ((y)localObject2).i();
        l2 = ((g)localObject2).f();
      }
      for (;;)
      {
        break;
        if (localObject1 != null)
        {
          l1 = ((y)localObject1).i();
          l2 = ((g)localObject1).f();
        }
        else
        {
          l1 = j(this.n);
          l2 = -1L;
        }
      }
      localObject2 = new d(l1, paramk.getPosition(), l2);
    }
    else if (localObject2 == null)
    {
      if (localObject1 != null) {
        localObject2 = localObject1;
      } else {
        localObject2 = null;
      }
    }
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((y)localObject2).g())
      {
        localObject1 = localObject2;
        if ((this.c & 0x1) == 0) {}
      }
    }
    else
    {
      localObject1 = i(paramk);
    }
    return (g)localObject1;
  }
  
  private long g(long paramLong)
  {
    return this.o + paramLong * 1000000L / this.f.d;
  }
  
  private g i(k paramk)
    throws IOException
  {
    paramk.n(this.e.d(), 0, 4);
    this.e.P(0);
    this.f.a(this.e.n());
    return new c(paramk.a(), paramk.getPosition(), this.f);
  }
  
  private static long j(@Nullable Metadata paramMetadata)
  {
    if (paramMetadata != null)
    {
      int i1 = paramMetadata.d();
      for (int i2 = 0; i2 < i1; i2++)
      {
        Object localObject = paramMetadata.c(i2);
        if ((localObject instanceof TextInformationFrame))
        {
          localObject = (TextInformationFrame)localObject;
          if (((Id3Frame)localObject).c.equals("TLEN")) {
            return w0.d(Long.parseLong(((TextInformationFrame)localObject).f));
          }
        }
      }
    }
    return -9223372036854775807L;
  }
  
  private static int k(d0 paramd0, int paramInt)
  {
    if (paramd0.f() >= paramInt + 4)
    {
      paramd0.P(paramInt);
      paramInt = paramd0.n();
      if ((paramInt == 1483304551) || (paramInt == 1231971951)) {
        return paramInt;
      }
    }
    if (paramd0.f() >= 40)
    {
      paramd0.P(36);
      if (paramd0.n() == 1447187017) {
        return 1447187017;
      }
    }
    return 0;
  }
  
  private static boolean l(int paramInt, long paramLong)
  {
    boolean bool;
    if ((paramInt & 0xFFFE0C00) == (paramLong & 0xFFFFFFFFFFFE0C00)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Nullable
  private static e o(@Nullable Metadata paramMetadata, long paramLong)
  {
    if (paramMetadata != null)
    {
      int i1 = paramMetadata.d();
      for (int i2 = 0; i2 < i1; i2++)
      {
        Metadata.Entry localEntry = paramMetadata.c(i2);
        if ((localEntry instanceof MlltFrame)) {
          return e.b(paramLong, (MlltFrame)localEntry, j(paramMetadata));
        }
      }
    }
    return null;
  }
  
  @Nullable
  private g p(k paramk)
    throws IOException
  {
    Object localObject1 = new d0(this.f.c);
    paramk.n(((d0)localObject1).d(), 0, this.f.c);
    Object localObject2 = this.f;
    if ((((e0.a)localObject2).a & 0x1) != 0)
    {
      if (((e0.a)localObject2).e != 1)
      {
        i1 = 36;
        break label81;
      }
    }
    else {
      if (((e0.a)localObject2).e == 1) {
        break label77;
      }
    }
    int i1 = 21;
    break label81;
    label77:
    i1 = 13;
    label81:
    int i2 = k((d0)localObject1, i1);
    if ((i2 != 1483304551) && (i2 != 1231971951))
    {
      if (i2 == 1447187017)
      {
        localObject2 = h.b(paramk.a(), paramk.getPosition(), this.f, (d0)localObject1);
        paramk.l(this.f.c);
      }
      else
      {
        localObject2 = null;
        paramk.e();
      }
    }
    else
    {
      localObject1 = i.b(paramk.a(), paramk.getPosition(), this.f, (d0)localObject1);
      if ((localObject1 != null) && (!this.g.a()))
      {
        paramk.e();
        paramk.h(i1 + 141);
        paramk.n(this.e.d(), 0, 3);
        this.e.P(0);
        this.g.d(this.e.G());
      }
      paramk.l(this.f.c);
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (!((y)localObject1).g())
        {
          localObject2 = localObject1;
          if (i2 == 1231971951) {
            return i(paramk);
          }
        }
      }
    }
    return (g)localObject2;
  }
  
  private boolean q(k paramk)
    throws IOException
  {
    g localg = this.s;
    if (localg != null)
    {
      long l1 = localg.f();
      if ((l1 != -1L) && (paramk.g() > l1 - 4L)) {
        return true;
      }
    }
    try
    {
      boolean bool = paramk.c(this.e.d(), 0, 4, true);
      return bool ^ true;
    }
    catch (EOFException paramk) {}
    return true;
  }
  
  @RequiresNonNull({"extractorOutput", "realTrackOutput"})
  private int r(k paramk)
    throws IOException
  {
    if (this.m == 0) {
      try
      {
        t(paramk, false);
      }
      catch (EOFException paramk)
      {
        return -1;
      }
    }
    if (this.s == null)
    {
      Object localObject = f(paramk);
      this.s = ((g)localObject);
      this.j.o((y)localObject);
      b0 localb0 = this.l;
      Format.b localb = new Format.b().e0(this.f.b).W(4096).H(this.f.e).f0(this.f.d).M(this.g.b).N(this.g.c);
      if ((this.c & 0x4) != 0) {
        localObject = null;
      } else {
        localObject = this.n;
      }
      localb0.d(localb.X((Metadata)localObject).E());
      this.q = paramk.getPosition();
    }
    else if (this.q != 0L)
    {
      long l1 = paramk.getPosition();
      long l2 = this.q;
      if (l1 < l2) {
        paramk.l((int)(l2 - l1));
      }
    }
    return s(paramk);
  }
  
  @RequiresNonNull({"realTrackOutput", "seeker"})
  private int s(k paramk)
    throws IOException
  {
    if (this.r == 0)
    {
      paramk.e();
      if (q(paramk)) {
        return -1;
      }
      this.e.P(0);
      i1 = this.e.n();
      if ((l(i1, this.m)) && (e0.j(i1) != -1))
      {
        this.f.a(i1);
        if (this.o == -9223372036854775807L)
        {
          this.o = this.s.h(paramk.getPosition());
          if (this.d != -9223372036854775807L)
          {
            long l1 = this.s.h(0L);
            this.o += this.d - l1;
          }
        }
        e0.a locala = this.f;
        this.r = locala.c;
        Object localObject = this.s;
        if ((localObject instanceof d))
        {
          localObject = (d)localObject;
          ((d)localObject).c(g(this.p + locala.g), paramk.getPosition() + this.f.c);
          if ((this.u) && (((d)localObject).b(this.v)))
          {
            this.u = false;
            this.l = this.k;
          }
        }
      }
      else
      {
        paramk.l(1);
        this.m = 0;
        return 0;
      }
    }
    int i1 = this.l.b(paramk, this.r, true);
    if (i1 == -1) {
      return -1;
    }
    i1 = this.r - i1;
    this.r = i1;
    if (i1 > 0) {
      return 0;
    }
    this.l.e(g(this.p), 1, this.f.c, 0, null);
    this.p += this.f.g;
    this.r = 0;
    return 0;
  }
  
  private boolean t(k paramk, boolean paramBoolean)
    throws IOException
  {
    int i1;
    if (paramBoolean) {
      i1 = 32768;
    } else {
      i1 = 131072;
    }
    paramk.e();
    int i3;
    if (paramk.getPosition() == 0L)
    {
      if ((this.c & 0x4) == 0) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if (i2 != 0) {
        localObject = null;
      } else {
        localObject = b;
      }
      Object localObject = this.h.a(paramk, (b.a)localObject);
      this.n = ((Metadata)localObject);
      if (localObject != null) {
        this.g.c((Metadata)localObject);
      }
      i3 = (int)paramk.g();
      if (!paramBoolean) {
        paramk.l(i3);
      }
    }
    else
    {
      i3 = 0;
    }
    int i2 = 0;
    int i4 = 0;
    int i5 = 0;
    for (;;)
    {
      int i7;
      int i8;
      if (q(paramk))
      {
        if (i4 <= 0) {
          throw new EOFException();
        }
      }
      else
      {
        this.e.P(0);
        int i6 = this.e.n();
        if ((i2 == 0) || (l(i6, i2)))
        {
          i7 = e0.j(i6);
          if (i7 != -1) {}
        }
        else
        {
          i2 = i5 + 1;
          if (i5 == i1)
          {
            if (paramBoolean) {
              return false;
            }
            throw ParserException.createForMalformedContainer("Searched too many bytes.", null);
          }
          if (paramBoolean)
          {
            paramk.e();
            paramk.h(i3 + i2);
          }
          else
          {
            paramk.l(1);
          }
          i5 = i2;
          i2 = 0;
          i4 = 0;
          continue;
        }
        i8 = i4 + 1;
        if (i8 == 1)
        {
          this.f.a(i6);
          i4 = i6;
          break label346;
        }
        i4 = i2;
        if (i8 != 4) {
          break label346;
        }
      }
      if (paramBoolean) {
        paramk.l(i3 + i5);
      } else {
        paramk.e();
      }
      this.m = i2;
      return true;
      label346:
      paramk.h(i7 - 4);
      i2 = i4;
      i4 = i8;
    }
  }
  
  public void b(l paraml)
  {
    this.j = paraml;
    paraml = paraml.t(0, 1);
    this.k = paraml;
    this.l = paraml;
    this.j.r();
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    this.m = 0;
    this.o = -9223372036854775807L;
    this.p = 0L;
    this.r = 0;
    this.v = paramLong2;
    g localg = this.s;
    if (((localg instanceof d)) && (!((d)localg).b(paramLong2)))
    {
      this.u = true;
      this.l = this.i;
    }
  }
  
  public boolean d(k paramk)
    throws IOException
  {
    return t(paramk, true);
  }
  
  public int e(k paramk, x paramx)
    throws IOException
  {
    a();
    int i1 = r(paramk);
    if ((i1 == -1) && ((this.s instanceof d)))
    {
      long l1 = g(this.p);
      if (this.s.i() != l1)
      {
        ((d)this.s).d(l1);
        this.j.o(this.s);
      }
    }
    return i1;
  }
  
  public void h()
  {
    this.t = true;
  }
  
  public void release() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\i0\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */