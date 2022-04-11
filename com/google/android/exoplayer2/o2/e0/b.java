package com.google.android.exoplayer2.o2.e0;

import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.f;
import com.google.android.exoplayer2.o2.j;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.o;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.o2.y.b;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class b
  implements j
{
  public static final o a = a.b;
  private static final int[] b = { 13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1 };
  private static final int[] c;
  private static final byte[] d = o0.e0("#!AMR\n");
  private static final byte[] e = o0.e0("#!AMR-WB\n");
  private static final int f = arrayOfInt[8];
  private final byte[] g;
  private final int h;
  private boolean i;
  private long j;
  private int k;
  private int l;
  private boolean m;
  private long n;
  private int o;
  private int p;
  private long q;
  private l r;
  private b0 s;
  private y t;
  private boolean u;
  
  static
  {
    int[] arrayOfInt = new int[16];
    arrayOfInt[0] = 18;
    arrayOfInt[1] = 24;
    arrayOfInt[2] = 33;
    arrayOfInt[3] = 37;
    arrayOfInt[4] = 41;
    arrayOfInt[5] = 47;
    arrayOfInt[6] = 51;
    arrayOfInt[7] = 59;
    arrayOfInt[8] = 61;
    arrayOfInt[9] = 6;
    arrayOfInt[10] = 1;
    arrayOfInt[11] = 1;
    arrayOfInt[12] = 1;
    arrayOfInt[13] = 1;
    arrayOfInt[14] = 1;
    arrayOfInt[15] = 1;
    arrayOfInt;
    c = arrayOfInt;
  }
  
  public b()
  {
    this(0);
  }
  
  public b(int paramInt)
  {
    this.h = paramInt;
    this.g = new byte[1];
    this.o = -1;
  }
  
  @EnsuresNonNull({"extractorOutput", "trackOutput"})
  private void a()
  {
    g.i(this.s);
    o0.i(this.r);
  }
  
  private static int f(int paramInt, long paramLong)
  {
    return (int)(paramInt * 8 * 1000000L / paramLong);
  }
  
  private y g(long paramLong)
  {
    int i1 = f(this.o, 20000L);
    return new f(paramLong, this.n, i1, this.o);
  }
  
  private int h(int paramInt)
    throws ParserException
  {
    if (!j(paramInt))
    {
      String str;
      if (this.i) {
        str = "WB";
      } else {
        str = "NB";
      }
      StringBuilder localStringBuilder = new StringBuilder(str.length() + 35);
      localStringBuilder.append("Illegal AMR ");
      localStringBuilder.append(str);
      localStringBuilder.append(" frame type ");
      localStringBuilder.append(paramInt);
      throw ParserException.createForMalformedContainer(localStringBuilder.toString(), null);
    }
    if (this.i) {
      paramInt = c[paramInt];
    } else {
      paramInt = b[paramInt];
    }
    return paramInt;
  }
  
  private boolean i(int paramInt)
  {
    boolean bool;
    if ((!this.i) && ((paramInt < 12) || (paramInt > 14))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean j(int paramInt)
  {
    boolean bool;
    if ((paramInt >= 0) && (paramInt <= 15) && ((k(paramInt)) || (i(paramInt)))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean k(int paramInt)
  {
    boolean bool;
    if ((this.i) && ((paramInt < 10) || (paramInt > 13))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresNonNull({"trackOutput"})
  private void m()
  {
    if (!this.u)
    {
      this.u = true;
      boolean bool = this.i;
      String str;
      if (bool) {
        str = "audio/amr-wb";
      } else {
        str = "audio/3gpp";
      }
      int i1;
      if (bool) {
        i1 = 16000;
      } else {
        i1 = 8000;
      }
      this.s.d(new Format.b().e0(str).W(f).H(1).f0(i1).E());
    }
  }
  
  @RequiresNonNull({"extractorOutput"})
  private void n(long paramLong, int paramInt)
  {
    if (this.m) {
      return;
    }
    if (((this.h & 0x1) != 0) && (paramLong != -1L))
    {
      int i1 = this.o;
      if ((i1 == -1) || (i1 == this.k))
      {
        if ((this.p < 20) && (paramInt != -1)) {
          return;
        }
        localObject = g(paramLong);
        this.t = ((y)localObject);
        this.r.o((y)localObject);
        this.m = true;
        return;
      }
    }
    Object localObject = new y.b(-9223372036854775807L);
    this.t = ((y)localObject);
    this.r.o((y)localObject);
    this.m = true;
  }
  
  private static boolean o(k paramk, byte[] paramArrayOfByte)
    throws IOException
  {
    paramk.e();
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    paramk.n(arrayOfByte, 0, paramArrayOfByte.length);
    return Arrays.equals(arrayOfByte, paramArrayOfByte);
  }
  
  private int p(k paramk)
    throws IOException
  {
    paramk.e();
    paramk.n(this.g, 0, 1);
    int i1 = this.g[0];
    if ((i1 & 0x83) <= 0) {
      return h(i1 >> 3 & 0xF);
    }
    paramk = new StringBuilder(42);
    paramk.append("Invalid padding bits for frame header ");
    paramk.append(i1);
    throw ParserException.createForMalformedContainer(paramk.toString(), null);
  }
  
  private boolean q(k paramk)
    throws IOException
  {
    byte[] arrayOfByte = d;
    if (o(paramk, arrayOfByte))
    {
      this.i = false;
      paramk.l(arrayOfByte.length);
      return true;
    }
    arrayOfByte = e;
    if (o(paramk, arrayOfByte))
    {
      this.i = true;
      paramk.l(arrayOfByte.length);
      return true;
    }
    return false;
  }
  
  @RequiresNonNull({"trackOutput"})
  private int r(k paramk)
    throws IOException
  {
    if (this.l == 0) {
      try
      {
        i1 = p(paramk);
        this.k = i1;
        this.l = i1;
        if (this.o == -1)
        {
          this.n = paramk.getPosition();
          this.o = this.k;
        }
        if (this.o == this.k) {
          this.p += 1;
        }
      }
      catch (EOFException paramk)
      {
        return -1;
      }
    }
    int i1 = this.s.b(paramk, this.l, true);
    if (i1 == -1) {
      return -1;
    }
    i1 = this.l - i1;
    this.l = i1;
    if (i1 > 0) {
      return 0;
    }
    this.s.e(this.q + this.j, 1, this.k, 0, null);
    this.j += 20000L;
    return 0;
  }
  
  public void b(l paraml)
  {
    this.r = paraml;
    this.s = paraml.t(0, 1);
    paraml.r();
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    this.j = 0L;
    this.k = 0;
    this.l = 0;
    if (paramLong1 != 0L)
    {
      y localy = this.t;
      if ((localy instanceof f))
      {
        this.q = ((f)localy).c(paramLong1);
        return;
      }
    }
    this.q = 0L;
  }
  
  public boolean d(k paramk)
    throws IOException
  {
    return q(paramk);
  }
  
  public int e(k paramk, x paramx)
    throws IOException
  {
    a();
    if ((paramk.getPosition() == 0L) && (!q(paramk))) {
      throw ParserException.createForMalformedContainer("Could not find AMR header.", null);
    }
    m();
    int i1 = r(paramk);
    n(paramk.a(), i1);
    return i1;
  }
  
  public void release() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\e0\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */