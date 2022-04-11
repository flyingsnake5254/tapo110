package com.google.android.exoplayer2.o2.l0;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.z;
import java.util.Arrays;
import java.util.Collections;

public final class p
  implements o
{
  private static final double[] a = { 23.976023976023978D, 24.0D, 25.0D, 29.97002997002997D, 30.0D, 50.0D, 59.94005994005994D, 60.0D };
  private String b;
  private b0 c;
  @Nullable
  private final k0 d;
  @Nullable
  private final d0 e;
  @Nullable
  private final w f;
  private final boolean[] g;
  private final a h;
  private long i;
  private boolean j;
  private boolean k;
  private long l;
  private long m;
  private long n;
  private long o;
  private boolean p;
  private boolean q;
  
  public p()
  {
    this(null);
  }
  
  p(@Nullable k0 paramk0)
  {
    this.d = paramk0;
    this.g = new boolean[4];
    this.h = new a(128);
    if (paramk0 != null)
    {
      this.f = new w(178, 128);
      this.e = new d0();
    }
    else
    {
      this.f = null;
      this.e = null;
    }
  }
  
  private static Pair<Format, Long> a(a parama, String paramString)
  {
    byte[] arrayOfByte = Arrays.copyOf(parama.e, parama.c);
    int i1 = arrayOfByte[4];
    int i2 = arrayOfByte[5] & 0xFF;
    int i3 = arrayOfByte[6];
    i1 = (i1 & 0xFF) << 4 | i2 >> 4;
    i3 = (i2 & 0xF) << 8 | i3 & 0xFF;
    i2 = (arrayOfByte[7] & 0xF0) >> 4;
    float f1;
    if (i2 != 2)
    {
      if (i2 != 3)
      {
        if (i2 != 4)
        {
          f1 = 1.0F;
          break label151;
        }
        f1 = i3 * 121;
        i2 = i1 * 100;
      }
      else
      {
        f1 = i3 * 16;
        i2 = i1 * 9;
      }
    }
    else
    {
      f1 = i3 * 4;
      i2 = i1 * 3;
    }
    f1 /= i2;
    label151:
    Format localFormat = new Format.b().S(paramString).e0("video/mpeg2").j0(i1).Q(i3).a0(f1).T(Collections.singletonList(arrayOfByte)).E();
    long l1 = 0L;
    i2 = (arrayOfByte[7] & 0xF) - 1;
    long l2 = l1;
    if (i2 >= 0)
    {
      paramString = a;
      l2 = l1;
      if (i2 < paramString.length)
      {
        double d1 = paramString[i2];
        i1 = parama.d + 9;
        i2 = (arrayOfByte[i1] & 0x60) >> 5;
        i1 = arrayOfByte[i1] & 0x1F;
        double d2 = d1;
        if (i2 != i1) {
          d2 = d1 * ((i2 + 1.0D) / (i1 + 1));
        }
        l2 = (1000000.0D / d2);
      }
    }
    return Pair.create(localFormat, Long.valueOf(l2));
  }
  
  public void b(d0 paramd0)
  {
    g.i(this.c);
    int i1 = paramd0.e();
    int i2 = paramd0.f();
    byte[] arrayOfByte = paramd0.d();
    this.i += paramd0.a();
    this.c.c(paramd0, paramd0.a());
    for (;;)
    {
      int i3 = z.c(arrayOfByte, i1, i2, this.g);
      if (i3 == i2)
      {
        if (!this.k) {
          this.h.a(arrayOfByte, i1, i2);
        }
        paramd0 = this.f;
        if (paramd0 != null) {
          paramd0.a(arrayOfByte, i1, i2);
        }
        return;
      }
      Object localObject = paramd0.d();
      int i4 = i3 + 3;
      int i5 = localObject[i4] & 0xFF;
      int i6 = i3 - i1;
      boolean bool1 = this.k;
      boolean bool2 = false;
      if (!bool1)
      {
        if (i6 > 0) {
          this.h.a(arrayOfByte, i1, i3);
        }
        int i7;
        if (i6 < 0) {
          i7 = -i6;
        } else {
          i7 = 0;
        }
        if (this.h.b(i5, i7))
        {
          localObject = a(this.h, (String)g.e(this.b));
          this.c.d((Format)((Pair)localObject).first);
          this.l = ((Long)((Pair)localObject).second).longValue();
          this.k = true;
        }
      }
      localObject = this.f;
      if (localObject != null)
      {
        if (i6 > 0)
        {
          ((w)localObject).a(arrayOfByte, i1, i3);
          i1 = 0;
        }
        else
        {
          i1 = -i6;
        }
        if (this.f.b(i1))
        {
          localObject = this.f;
          i1 = z.k(((w)localObject).d, ((w)localObject).e);
          ((d0)o0.i(this.e)).N(this.f.d, i1);
          ((k0)o0.i(this.d)).a(this.o, this.e);
        }
        if ((i5 == 178) && (paramd0.d()[(i3 + 2)] == 1)) {
          this.f.e(i5);
        }
      }
      if ((i5 != 0) && (i5 != 179))
      {
        if (i5 == 184) {
          this.p = true;
        }
      }
      else
      {
        i3 = i2 - i3;
        if ((this.j) && (this.q) && (this.k))
        {
          int i8 = this.p;
          i1 = (int)(this.i - this.n);
          this.c.e(this.o, i8, i1 - i3, i3, null);
        }
        bool1 = this.j;
        if ((!bool1) || (this.q))
        {
          this.n = (this.i - i3);
          long l1 = this.m;
          if (l1 == -9223372036854775807L) {
            if (bool1) {
              l1 = this.o + this.l;
            } else {
              l1 = 0L;
            }
          }
          this.o = l1;
          this.p = false;
          this.m = -9223372036854775807L;
          this.j = true;
        }
        if (i5 == 0) {
          bool2 = true;
        }
        this.q = bool2;
      }
      i1 = i4;
    }
  }
  
  public void c()
  {
    z.a(this.g);
    this.h.c();
    w localw = this.f;
    if (localw != null) {
      localw.d();
    }
    this.i = 0L;
    this.j = false;
  }
  
  public void d(l paraml, i0.d paramd)
  {
    paramd.a();
    this.b = paramd.b();
    this.c = paraml.t(paramd.c(), 2);
    k0 localk0 = this.d;
    if (localk0 != null) {
      localk0.b(paraml, paramd);
    }
  }
  
  public void e() {}
  
  public void f(long paramLong, int paramInt)
  {
    this.m = paramLong;
  }
  
  private static final class a
  {
    private static final byte[] a = { 0, 0, 1 };
    private boolean b;
    public int c;
    public int d;
    public byte[] e;
    
    public a(int paramInt)
    {
      this.e = new byte[paramInt];
    }
    
    public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (!this.b) {
        return;
      }
      paramInt2 -= paramInt1;
      byte[] arrayOfByte = this.e;
      int i = arrayOfByte.length;
      int j = this.c;
      if (i < j + paramInt2) {
        this.e = Arrays.copyOf(arrayOfByte, (j + paramInt2) * 2);
      }
      System.arraycopy(paramArrayOfByte, paramInt1, this.e, this.c, paramInt2);
      this.c += paramInt2;
    }
    
    public boolean b(int paramInt1, int paramInt2)
    {
      if (this.b)
      {
        paramInt2 = this.c - paramInt2;
        this.c = paramInt2;
        if ((this.d == 0) && (paramInt1 == 181))
        {
          this.d = paramInt2;
        }
        else
        {
          this.b = false;
          return true;
        }
      }
      else if (paramInt1 == 179)
      {
        this.b = true;
      }
      byte[] arrayOfByte = a;
      a(arrayOfByte, 0, arrayOfByte.length);
      return false;
    }
    
    public void c()
    {
      this.b = false;
      this.c = 0;
      this.d = 0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */