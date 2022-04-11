package com.google.android.exoplayer2.o2.l0;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.b;
import com.google.android.exoplayer2.o2.j;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.o2.y.b;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l0;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class b0
  implements j
{
  public static final com.google.android.exoplayer2.o2.o a = d.b;
  private final l0 b;
  private final SparseArray<a> c;
  private final d0 d;
  private final a0 e;
  private boolean f;
  private boolean g;
  private boolean h;
  private long i;
  @Nullable
  private z j;
  private l k;
  private boolean l;
  
  public b0()
  {
    this(new l0(0L));
  }
  
  public b0(l0 paraml0)
  {
    this.b = paraml0;
    this.d = new d0(4096);
    this.c = new SparseArray();
    this.e = new a0();
  }
  
  @RequiresNonNull({"output"})
  private void f(long paramLong)
  {
    if (!this.l)
    {
      this.l = true;
      if (this.e.c() != -9223372036854775807L)
      {
        z localz = new z(this.e.d(), this.e.c(), paramLong);
        this.j = localz;
        this.k.o(localz.b());
      }
      else
      {
        this.k.o(new y.b(this.e.c()));
      }
    }
  }
  
  public void b(l paraml)
  {
    this.k = paraml;
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    paramLong1 = this.b.e();
    int m = 1;
    int n = 0;
    if (paramLong1 == -9223372036854775807L) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = i1;
    if (i1 == 0)
    {
      paramLong1 = this.b.c();
      if ((paramLong1 != -9223372036854775807L) && (paramLong1 != 0L) && (paramLong1 != paramLong2)) {
        i1 = m;
      } else {
        i1 = 0;
      }
      i2 = i1;
    }
    if (i2 != 0) {
      this.b.g(paramLong2);
    }
    z localz = this.j;
    int i1 = n;
    if (localz != null) {
      localz.h(paramLong2);
    }
    for (i1 = n; i1 < this.c.size(); i1++) {
      ((a)this.c.valueAt(i1)).d();
    }
  }
  
  public boolean d(k paramk)
    throws IOException
  {
    byte[] arrayOfByte = new byte[14];
    boolean bool = false;
    paramk.n(arrayOfByte, 0, 14);
    if (442 != ((arrayOfByte[0] & 0xFF) << 24 | (arrayOfByte[1] & 0xFF) << 16 | (arrayOfByte[2] & 0xFF) << 8 | arrayOfByte[3] & 0xFF)) {
      return false;
    }
    if ((arrayOfByte[4] & 0xC4) != 68) {
      return false;
    }
    if ((arrayOfByte[6] & 0x4) != 4) {
      return false;
    }
    if ((arrayOfByte[8] & 0x4) != 4) {
      return false;
    }
    if ((arrayOfByte[9] & 0x1) != 1) {
      return false;
    }
    if ((arrayOfByte[12] & 0x3) != 3) {
      return false;
    }
    paramk.h(arrayOfByte[13] & 0x7);
    paramk.n(arrayOfByte, 0, 3);
    if (1 == ((arrayOfByte[0] & 0xFF) << 16 | (arrayOfByte[1] & 0xFF) << 8 | arrayOfByte[2] & 0xFF)) {
      bool = true;
    }
    return bool;
  }
  
  public int e(k paramk, x paramx)
    throws IOException
  {
    com.google.android.exoplayer2.util.g.i(this.k);
    long l1 = paramk.a();
    boolean bool = l1 < -1L;
    if (bool) {
      m = 1;
    } else {
      m = 0;
    }
    if ((m != 0) && (!this.e.e())) {
      return this.e.g(paramk, paramx);
    }
    f(l1);
    Object localObject = this.j;
    if ((localObject != null) && (((b)localObject).d())) {
      return this.j.c(paramk, paramx);
    }
    paramk.e();
    if (bool) {
      l1 -= paramk.g();
    } else {
      l1 = -1L;
    }
    if ((l1 != -1L) && (l1 < 4L)) {
      return -1;
    }
    if (!paramk.c(this.d.d(), 0, 4, true)) {
      return -1;
    }
    this.d.P(0);
    int m = this.d.n();
    if (m == 441) {
      return -1;
    }
    if (m == 442)
    {
      paramk.n(this.d.d(), 0, 10);
      this.d.P(9);
      paramk.l((this.d.D() & 0x7) + 14);
      return 0;
    }
    if (m == 443)
    {
      paramk.n(this.d.d(), 0, 2);
      this.d.P(0);
      paramk.l(this.d.J() + 6);
      return 0;
    }
    if ((m & 0xFF00) >> 8 != 1)
    {
      paramk.l(1);
      return 0;
    }
    m &= 0xFF;
    a locala = (a)this.c.get(m);
    paramx = locala;
    if (!this.f)
    {
      localObject = locala;
      if (locala == null)
      {
        paramx = null;
        if (m == 189)
        {
          paramx = new g();
          this.g = true;
          this.i = paramk.getPosition();
        }
        else if ((m & 0xE0) == 192)
        {
          paramx = new v();
          this.g = true;
          this.i = paramk.getPosition();
        }
        else if ((m & 0xF0) == 224)
        {
          paramx = new p();
          this.h = true;
          this.i = paramk.getPosition();
        }
        localObject = locala;
        if (paramx != null)
        {
          localObject = new i0.d(m, 256);
          paramx.d(this.k, (i0.d)localObject);
          localObject = new a(paramx, this.b);
          this.c.put(m, localObject);
        }
      }
      if ((this.g) && (this.h)) {
        l1 = this.i + 8192L;
      } else {
        l1 = 1048576L;
      }
      paramx = (x)localObject;
      if (paramk.getPosition() > l1)
      {
        this.f = true;
        this.k.r();
        paramx = (x)localObject;
      }
    }
    paramk.n(this.d.d(), 0, 2);
    this.d.P(0);
    m = this.d.J() + 6;
    if (paramx == null)
    {
      paramk.l(m);
    }
    else
    {
      this.d.L(m);
      paramk.readFully(this.d.d(), 0, m);
      this.d.P(6);
      paramx.a(this.d);
      paramk = this.d;
      paramk.O(paramk.b());
    }
    return 0;
  }
  
  public void release() {}
  
  private static final class a
  {
    private final o a;
    private final l0 b;
    private final c0 c;
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;
    private long h;
    
    public a(o paramo, l0 paraml0)
    {
      this.a = paramo;
      this.b = paraml0;
      this.c = new c0(new byte[64]);
    }
    
    private void b()
    {
      this.c.r(8);
      this.d = this.c.g();
      this.e = this.c.g();
      this.c.r(6);
      this.g = this.c.h(8);
    }
    
    private void c()
    {
      this.h = 0L;
      if (this.d)
      {
        this.c.r(4);
        long l1 = this.c.h(3);
        this.c.r(1);
        long l2 = this.c.h(15) << 15;
        this.c.r(1);
        long l3 = this.c.h(15);
        this.c.r(1);
        if ((!this.f) && (this.e))
        {
          this.c.r(4);
          long l4 = this.c.h(3);
          this.c.r(1);
          long l5 = this.c.h(15) << 15;
          this.c.r(1);
          long l6 = this.c.h(15);
          this.c.r(1);
          this.b.b(l4 << 30 | l5 | l6);
          this.f = true;
        }
        this.h = this.b.b(l1 << 30 | l2 | l3);
      }
    }
    
    public void a(d0 paramd0)
      throws ParserException
    {
      paramd0.j(this.c.a, 0, 3);
      this.c.p(0);
      b();
      paramd0.j(this.c.a, 0, this.g);
      this.c.p(0);
      c();
      this.a.f(this.h, 4);
      this.a.b(paramd0);
      this.a.e();
    }
    
    public void d()
    {
      this.f = false;
      this.a.c();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\b0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */