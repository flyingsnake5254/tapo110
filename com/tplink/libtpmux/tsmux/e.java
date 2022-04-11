package com.tplink.libtpmux.tsmux;

import com.tplink.libtpmux.tsmux.f.d;
import com.tplink.libtpmux.tsmux.f.f;
import com.tplink.libtpmux.tsmux.f.g;
import com.tplink.libtpmux.tsmux.f.h;
import com.tplink.libtpmux.tsmux.f.i;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class e
{
  private final byte[] a = new byte['¼'];
  private int b = 0;
  private ByteBuffer c = ByteBuffer.allocateDirect(512000);
  private final a d;
  private int e;
  private int f;
  private final List<com.tplink.libtpmux.tsmux.f.e> g;
  private final List<h> h;
  private boolean i;
  
  public e()
  {
    a locala = new a();
    this.d = locala;
    locala.e(0);
    locala.d(0);
    locala.g(0);
    locala.f(new c());
    this.g = new ArrayList();
    this.h = new ArrayList();
    this.i = false;
  }
  
  private byte c(byte paramByte, int paramInt1, int paramInt2)
  {
    return (byte)(paramByte << paramInt1 | paramInt2);
  }
  
  private int d(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 << paramInt2 | paramInt3;
  }
  
  private long e(long paramLong, int paramInt1, int paramInt2)
  {
    return paramLong << paramInt1 | paramInt2;
  }
  
  private byte[] f(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
  
  private byte[] g(long paramLong)
  {
    return new byte[] { (byte)(int)(paramLong >> 56 & 0xFF), (byte)(int)(paramLong >> 48 & 0xFF), (byte)(int)(paramLong >> 40 & 0xFF), (byte)(int)(paramLong >> 32 & 0xFF), (byte)(int)(paramLong >> 24 & 0xFF), (byte)(int)(paramLong >> 16 & 0xFF), (byte)(int)(paramLong >> 8 & 0xFF), (byte)(int)(paramLong & 0xFF) };
  }
  
  private int h(int paramInt)
  {
    return paramInt + 1 & 0xF;
  }
  
  private int i(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = -1;
    for (int k = paramInt1; k < paramInt1 + paramInt2; k++)
    {
      int m = paramArrayOfByte[k];
      j = d.a[((j >> 24 ^ m) & 0xFF)] ^ j << 8;
    }
    return j;
  }
  
  private int j(int paramInt)
  {
    if (this.b + paramInt > 188) {
      return -4;
    }
    byte[] arrayOfByte = new byte[paramInt];
    Arrays.fill(arrayOfByte, (byte)-1);
    System.arraycopy(arrayOfByte, 0, this.a, this.b, paramInt);
    this.b += paramInt;
    return 0;
  }
  
  private void q(int paramInt)
  {
    System.arraycopy(f(i(this.a, paramInt, this.b - paramInt)), 0, this.a, this.b, 4);
    this.b += 4;
  }
  
  private void r()
  {
    if (this.b != 188) {
      return;
    }
    this.c.put(this.a);
    this.b = 0;
  }
  
  private void s(int paramInt, boolean paramBoolean, com.tplink.libtpmux.tsmux.f.c paramc)
  {
    com.tplink.libtpmux.tsmux.f.a locala = new com.tplink.libtpmux.tsmux.f.a();
    locala.l(paramInt);
    locala.m(0);
    locala.n(0);
    if (paramBoolean)
    {
      locala.q(255);
      locala.r(0);
      locala.p(paramc);
    }
    else
    {
      locala.q(0);
      locala.r(0);
    }
    if (1 == paramInt) {
      locala.r(0);
    }
    locala.o(0);
    locala.s(0);
    locala.t(0);
    locala.k(0);
    paramInt = c((byte)0, 0, locala.b());
    paramc = this.a;
    int j = this.b;
    paramc[j] = ((byte)paramInt);
    this.b = (j + 1);
    if (locala.b() == 0) {
      return;
    }
    j = c(c(c(c(c(c(c(c((byte)0, 0, locala.c()), 1, locala.h()), 1, locala.d()), 1, locala.g()), 1, locala.e()), 1, locala.i()), 1, locala.j()), 1, locala.a());
    paramc = this.a;
    paramInt = this.b;
    paramc[paramInt] = ((byte)j);
    this.b = (paramInt + 1);
    if (paramBoolean)
    {
      long l = 0;
      j = (byte)(int)(locala.f().a() >> 25 & 0xFF | l);
      paramc = this.a;
      paramInt = this.b;
      paramc[paramInt] = ((byte)j);
      this.b = (paramInt + 1);
      System.arraycopy(f(d((int)(l + (locala.f().a() & 0x1FFFFFF)), 6, locala.f().c()) << 1 | locala.f().b() & 0x100), 0, this.a, this.b, 4);
      this.b += 4;
      j = (byte)(locala.f().b() | 0x0);
      paramc = this.a;
      paramInt = this.b;
      paramc[paramInt] = ((byte)j);
      this.b = (paramInt + 1);
    }
    else
    {
      j(locala.b() - 1);
    }
  }
  
  private void u(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    com.tplink.libtpmux.tsmux.f.b localb = new com.tplink.libtpmux.tsmux.f.b();
    localb.m(71);
    localb.n(0);
    localb.l(paramInt2);
    localb.o(0);
    localb.k(paramInt1);
    localb.p(0);
    localb.i(paramInt3);
    localb.j(paramInt4);
    System.arraycopy(f(d(d(d(d(d(d(d(d(0, 0, localb.e()), 1, localb.f()), 1, localb.d()), 1, localb.g()), 13, localb.c()), 2, localb.h()), 2, localb.a()), 4, localb.b())), 0, this.a, this.b, 4);
    this.b = 4;
    if ((1 == paramInt2) && (1 == paramInt3))
    {
      this.a[4] = ((byte)0);
      this.b = (4 + 1);
    }
  }
  
  private void v(List<com.tplink.libtpmux.tsmux.f.e> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = new d();
      ((d)localObject).u(0);
      ((d)localObject).t(255);
      ((d)localObject).x(0);
      ((d)localObject).p(255);
      int j;
      int k;
      if (paramBoolean)
      {
        j = 9;
        k = 5;
      }
      else
      {
        j = 8;
        k = 4;
      }
      ((d)localObject).r(j + paramList.size() * 4);
      ((d)localObject).v(1);
      ((d)localObject).q(255);
      ((d)localObject).w(0);
      ((d)localObject).m(255);
      ((d)localObject).s(0);
      ((d)localObject).n(0);
      ((d)localObject).o(paramList);
      ((d)localObject).l(1);
      System.arraycopy(g(e(e(e(e(e(e(e(e(e(e(e(0L, 0, ((d)localObject).h()), 1, ((d)localObject).g()), 1, ((d)localObject).k()), 2, ((d)localObject).c()), 12, ((d)localObject).e()), 16, ((d)localObject).i()), 2, ((d)localObject).d()), 5, ((d)localObject).j()), 1, ((d)localObject).a()), 8, ((d)localObject).f()), 8, ((d)localObject).b())), 0, this.a, this.b, 8);
      this.b += 8;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (com.tplink.libtpmux.tsmux.f.e)paramList.next();
        System.arraycopy(f(d(d(d(0, 0, ((com.tplink.libtpmux.tsmux.f.e)localObject).b()), 3, ((com.tplink.libtpmux.tsmux.f.e)localObject).c()), 13, ((com.tplink.libtpmux.tsmux.f.e)localObject).a())), 0, this.a, this.b, 4);
        this.b += 4;
      }
      q(k);
      j(188 - this.b);
      r();
    }
  }
  
  private void w(int paramInt1, int paramInt2, int paramInt3, int paramInt4, i parami)
  {
    Object localObject = new f();
    ((f)localObject).z(1);
    ((f)localObject).H(paramInt2);
    ((f)localObject).D(paramInt1);
    ((f)localObject).x(2);
    ((f)localObject).F(0);
    ((f)localObject).E(0);
    ((f)localObject).u(0);
    ((f)localObject).s(0);
    ((f)localObject).y(0);
    ((f)localObject).G(paramInt3);
    ((f)localObject).w(0);
    ((f)localObject).v(0);
    ((f)localObject).t(0);
    ((f)localObject).r(0);
    ((f)localObject).A(0);
    ((f)localObject).B(0);
    ((f)localObject).C(paramInt4);
    System.arraycopy(g(e(e(e(e(e(e(e(e(e(e(e(e(e(e(e(e(0L, 0, ((f)localObject).i()), 8, ((f)localObject).q()), 16, ((f)localObject).m()), 2, ((f)localObject).g()), 2, ((f)localObject).o()), 1, ((f)localObject).n()), 1, ((f)localObject).d()), 1, ((f)localObject).b()), 1, ((f)localObject).h()), 2, ((f)localObject).p()), 1, ((f)localObject).f()), 1, ((f)localObject).e()), 1, ((f)localObject).c()), 1, ((f)localObject).a()), 1, ((f)localObject).j()), 1, ((f)localObject).k())), 0, this.a, this.b, 8);
    this.b += 8;
    paramInt1 = (byte)(((f)localObject).l() | 0x0);
    byte[] arrayOfByte = this.a;
    paramInt3 = this.b;
    arrayOfByte[paramInt3] = ((byte)paramInt1);
    this.b = (paramInt3 + 1);
    if ((2 == ((f)localObject).p()) && (5 == ((f)localObject).l()))
    {
      paramInt3 = c(c(c((byte)0, 0, parami.a()), 3, parami.b()), 1, parami.e());
      arrayOfByte = this.a;
      paramInt1 = this.b;
      arrayOfByte[paramInt1] = ((byte)paramInt3);
      this.b = (paramInt1 + 1);
      System.arraycopy(f(d(d(d(d(0, 0, parami.c()), 1, parami.f()), 15, parami.d()), 1, parami.g())), 0, this.a, this.b, 4);
      this.b += 4;
    }
    if ((3 == ((f)localObject).p()) && (10 == ((f)localObject).l()))
    {
      parami.h(3);
      paramInt1 = c(c(c((byte)0, 0, parami.a()), 3, parami.b()), 1, parami.e());
      localObject = this.a;
      paramInt3 = this.b;
      localObject[paramInt3] = ((byte)paramInt1);
      this.b = (paramInt3 + 1);
      System.arraycopy(f(d(d(d(d(0, 0, parami.c()), 1, parami.f()), 15, parami.d()), 1, parami.g())), 0, this.a, this.b, 4);
      this.b += 4;
    }
    if ((224 == paramInt2) && (27 == ((b)this.d.c().c().get(this.f)).d()))
    {
      parami = this.a;
      paramInt1 = this.b;
      parami[paramInt1] = ((byte)0);
      paramInt1++;
      this.b = paramInt1;
      parami[paramInt1] = ((byte)0);
      paramInt1++;
      this.b = paramInt1;
      parami[paramInt1] = ((byte)0);
      paramInt1++;
      this.b = paramInt1;
      parami[paramInt1] = ((byte)1);
      paramInt1++;
      this.b = paramInt1;
      parami[paramInt1] = ((byte)9);
      paramInt1++;
      this.b = paramInt1;
      parami[paramInt1] = ((byte)-16);
      this.b = (paramInt1 + 1);
    }
  }
  
  private void x(List<h> paramList, int paramInt, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = new g();
      ((g)localObject).D(2);
      ((g)localObject).C(1);
      ((g)localObject).F(0);
      ((g)localObject).w(255);
      int j;
      int k;
      if (paramBoolean)
      {
        j = 13;
        k = 5;
      }
      else
      {
        j = 12;
        k = 4;
      }
      ((g)localObject).A(j + paramList.size() * 5);
      ((g)localObject).v(paramInt);
      ((g)localObject).x(255);
      ((g)localObject).E(0);
      ((g)localObject).q(255);
      ((g)localObject).B(0);
      ((g)localObject).r(0);
      ((g)localObject).y(255);
      ((g)localObject).s(256);
      ((g)localObject).z(255);
      ((g)localObject).u(0);
      ((g)localObject).t(paramList);
      ((g)localObject).p(1);
      System.arraycopy(g(e(e(e(e(e(e(e(e(e(e(e(0L, 0, ((g)localObject).m()), 1, ((g)localObject).l()), 1, ((g)localObject).o()), 2, ((g)localObject).f()), 12, ((g)localObject).j()), 16, ((g)localObject).e()), 2, ((g)localObject).g()), 5, ((g)localObject).n()), 1, ((g)localObject).a()), 8, ((g)localObject).k()), 8, ((g)localObject).b())), 0, this.a, this.b, 8);
      this.b += 8;
      System.arraycopy(f(d(d(d(d(0, 0, ((g)localObject).h()), 13, ((g)localObject).c()), 4, ((g)localObject).i()), 12, ((g)localObject).d())), 0, this.a, this.b, 4);
      this.b += 4;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (h)paramList.next();
        j = c((byte)0, 0, ((h)localObject).e());
        byte[] arrayOfByte = this.a;
        paramInt = this.b;
        arrayOfByte[paramInt] = ((byte)j);
        this.b = (paramInt + 1);
        System.arraycopy(f(d(d(d(d(0, 0, ((h)localObject).c()), 13, ((h)localObject).b()), 4, ((h)localObject).d()), 12, ((h)localObject).a())), 0, this.a, this.b, 4);
        this.b += 4;
      }
      q(k);
      j(188 - this.b);
      r();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.d.c().g(paramInt1);
    this.d.c().f(0);
    this.d.c().h(0);
    this.d.c().i(paramInt2);
  }
  
  public void b(int paramInt, MimeType paramMimeType)
  {
    b localb = new b();
    localb.g(paramInt);
    localb.f(0);
    paramInt = a.a[paramMimeType.ordinal()];
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt == 4)
          {
            localb.h(192);
            localb.e(17);
            localb.i(144);
            this.e = this.d.c().c().size();
          }
        }
        else
        {
          localb.h(192);
          localb.e(17);
          localb.i(15);
          this.e = this.d.c().c().size();
        }
      }
      else
      {
        localb.h(224);
        localb.e(18);
        localb.i(27);
        this.f = this.d.c().c().size();
      }
    }
    else
    {
      localb.h(224);
      localb.e(18);
      localb.i(36);
      this.f = this.d.c().c().size();
    }
    paramInt = this.d.c().d();
    this.d.c().h(paramInt + 1);
    this.d.c().c().add(localb);
  }
  
  public byte[] k(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte.length > paramInt) {
      arrayOfByte = Arrays.copyOf(paramArrayOfByte, paramInt);
    }
    o();
    a(66, 1);
    paramArrayOfByte = MimeType.MUXTS_CODEC_PCMA;
    b(68, paramArrayOfByte);
    m();
    t(arrayOfByte, paramLong, paramArrayOfByte);
    return l();
  }
  
  public byte[] l()
  {
    this.c.flip();
    int j = this.c.remaining();
    if (j > 0)
    {
      byte[] arrayOfByte = new byte[j];
      this.c.get(arrayOfByte);
      return arrayOfByte;
    }
    return null;
  }
  
  public void m()
  {
    Object localObject = new com.tplink.libtpmux.tsmux.f.e();
    ((com.tplink.libtpmux.tsmux.f.e)localObject).e(this.d.c().e());
    ((com.tplink.libtpmux.tsmux.f.e)localObject).d(this.d.c().b());
    ((com.tplink.libtpmux.tsmux.f.e)localObject).f(255);
    this.g.add(localObject);
    for (int j = 0; j < this.d.c().d(); j++)
    {
      localObject = new h();
      b localb = (b)this.d.c().c().get(j);
      ((h)localObject).g(localb.b());
      ((h)localObject).j(localb.d());
      ((h)localObject).f(6);
      ((h)localObject).h(255);
      ((h)localObject).i(255);
      this.h.add(localObject);
    }
  }
  
  public void n()
  {
    this.c = null;
  }
  
  public void o()
  {
    this.b = 0;
    this.c.clear();
    this.d.e(0);
    this.d.d(0);
    this.d.g(0);
    this.d.f(new c());
    this.g.clear();
    this.h.clear();
  }
  
  public void p(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void t(byte[] paramArrayOfByte, long paramLong, MimeType paramMimeType)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    int j = paramArrayOfByte.length;
    if ((MimeType.MUXTS_CODEC_HEVC != paramMimeType) && (MimeType.MUXTS_CODEC_AVC != paramMimeType))
    {
      if (MimeType.MUXTS_CODEC_AAC == paramMimeType)
      {
        k = this.e;
        m = j + 8;
        break label92;
      }
      if (MimeType.MUXTS_CODEC_PCMA == paramMimeType)
      {
        n = this.e;
      }
      else
      {
        k = 0;
        m = 0;
        break label92;
      }
    }
    else
    {
      n = this.f;
    }
    int m = j;
    int k = n;
    label92:
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = j;
    j = i2;
    while (i3 > 0)
    {
      if (n == 0)
      {
        u(this.d.b(), 1, 1, this.d.a());
        v(this.g, true);
        n = h(this.d.a());
        this.d.d(n);
        u(this.d.c().b(), 1, 1, this.d.c().a());
        x(this.h, this.d.c().e(), true);
        n = h(this.d.c().a());
        this.d.c().f(n);
        n = 1;
      }
      Object localObject1;
      Object localObject2;
      if (i1 == 0)
      {
        localObject1 = (b)this.d.c().c().get(k);
        u(((b)localObject1).b(), 1, 3, ((b)localObject1).a());
        localObject2 = new com.tplink.libtpmux.tsmux.f.c();
        ((com.tplink.libtpmux.tsmux.f.c)localObject2).d(paramLong);
        ((com.tplink.libtpmux.tsmux.f.c)localObject2).f(255);
        ((com.tplink.libtpmux.tsmux.f.c)localObject2).e(0);
        if (this.i) {
          s(7, true, (com.tplink.libtpmux.tsmux.f.c)localObject2);
        } else if ((MimeType.MUXTS_CODEC_AAC != paramMimeType) && (MimeType.MUXTS_CODEC_PCMA != paramMimeType)) {
          s(7, true, (com.tplink.libtpmux.tsmux.f.c)localObject2);
        } else {
          s(1, false, (com.tplink.libtpmux.tsmux.f.c)localObject2);
        }
        localObject2 = new i();
        ((i)localObject2).h(2);
        ((i)localObject2).l(255);
        ((i)localObject2).m(255);
        ((i)localObject2).n(255);
        ((i)localObject2).i((int)(paramLong >> 30));
        ((i)localObject2).j((int)(paramLong >> 15));
        ((i)localObject2).k((int)paramLong);
        w(m + 8, ((b)localObject1).c(), 2, 5, (i)localObject2);
        ((b)localObject1).f(h(((b)localObject1).a()));
        i2 = this.b;
        if (i3 >= 188 - i2)
        {
          i1 = 188 - i2;
          System.arraycopy(paramArrayOfByte, j, this.a, i2, i1);
          j += i1;
          i3 -= i1;
          this.b += i1;
        }
        r();
        i1 = 1;
      }
      else
      {
        localObject2 = (b)this.d.c().c().get(k);
        int i4;
        if (i3 >= 184)
        {
          u(((b)localObject2).b(), 0, 1, ((b)localObject2).a());
          i4 = this.b;
          i2 = 188 - i4;
          System.arraycopy(paramArrayOfByte, j, this.a, i4, i2);
          j += i2;
          i3 -= i2;
          this.b += i2;
        }
        else
        {
          u(((b)localObject2).b(), 0, 3, ((b)localObject2).a());
          localObject1 = new com.tplink.libtpmux.tsmux.f.c();
          ((com.tplink.libtpmux.tsmux.f.c)localObject1).d(paramLong);
          ((com.tplink.libtpmux.tsmux.f.c)localObject1).f(255);
          ((com.tplink.libtpmux.tsmux.f.c)localObject1).e(0);
          s(188 - i3 - 5, false, (com.tplink.libtpmux.tsmux.f.c)localObject1);
          i4 = this.b;
          i2 = 188 - i4;
          System.arraycopy(paramArrayOfByte, j, this.a, i4, i2);
          j += i2;
          i3 -= i2;
          this.b += i2;
        }
        ((b)localObject2).f(h(((b)localObject2).a()));
        r();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmux\tsmux\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */