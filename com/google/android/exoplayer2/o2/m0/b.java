package com.google.android.exoplayer2.o2.m0;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.l0;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.j;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.o;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class b
  implements j
{
  public static final o a = a.b;
  private l b;
  private b0 c;
  private b d;
  private int e = -1;
  private long f = -1L;
  
  @EnsuresNonNull({"extractorOutput", "trackOutput"})
  private void a()
  {
    g.i(this.c);
    o0.i(this.b);
  }
  
  public void b(l paraml)
  {
    this.b = paraml;
    this.c = paraml.t(0, 1);
    paraml.r();
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    b localb = this.d;
    if (localb != null) {
      localb.c(paramLong2);
    }
  }
  
  public boolean d(k paramk)
    throws IOException
  {
    boolean bool;
    if (d.a(paramk) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int e(k paramk, x paramx)
    throws IOException
  {
    a();
    if (this.d == null)
    {
      paramx = d.a(paramk);
      if (paramx != null)
      {
        i = paramx.a;
        if (i == 17)
        {
          this.d = new a(this.b, this.c, paramx);
        }
        else if (i == 6)
        {
          this.d = new c(this.b, this.c, paramx, "audio/g711-alaw", -1);
        }
        else if (i == 7)
        {
          this.d = new c(this.b, this.c, paramx, "audio/g711-mlaw", -1);
        }
        else
        {
          i = l0.a(i, paramx.f);
          if (i != 0)
          {
            this.d = new c(this.b, this.c, paramx, "audio/raw", i);
          }
          else
          {
            i = paramx.a;
            paramk = new StringBuilder(40);
            paramk.append("Unsupported WAV format type: ");
            paramk.append(i);
            throw ParserException.createForUnsupportedContainerFeature(paramk.toString());
          }
        }
      }
      else
      {
        throw ParserException.createForMalformedContainer("Unsupported or unrecognized wav header.", null);
      }
    }
    int j = this.e;
    int i = -1;
    if (j == -1)
    {
      paramx = d.b(paramk);
      this.e = ((Long)paramx.first).intValue();
      l1 = ((Long)paramx.second).longValue();
      this.f = l1;
      this.d.a(this.e, l1);
    }
    else if (paramk.getPosition() == 0L)
    {
      paramk.l(this.e);
    }
    boolean bool;
    if (this.f != -1L) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    long l1 = this.f;
    long l2 = paramk.getPosition();
    if (!this.d.b(paramk, l1 - l2)) {
      i = 0;
    }
    return i;
  }
  
  public void release() {}
  
  private static final class a
    implements b.b
  {
    private static final int[] a = { -1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8 };
    private static final int[] b = { 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767 };
    private final l c;
    private final b0 d;
    private final c e;
    private final int f;
    private final byte[] g;
    private final d0 h;
    private final int i;
    private final Format j;
    private int k;
    private long l;
    private int m;
    private long n;
    
    public a(l paraml, b0 paramb0, c paramc)
      throws ParserException
    {
      this.c = paraml;
      this.d = paramb0;
      this.e = paramc;
      int i1 = Math.max(1, paramc.c / 10);
      this.i = i1;
      paraml = new d0(paramc.g);
      paraml.v();
      int i2 = paraml.v();
      this.f = i2;
      int i3 = paramc.b;
      int i4 = (paramc.e - i3 * 4) * 8 / (paramc.f * i3) + 1;
      if (i2 == i4)
      {
        i4 = o0.k(i1, i2);
        this.g = new byte[paramc.e * i4];
        this.h = new d0(i4 * h(i2, i3));
        i2 = paramc.c * paramc.e * 8 / i2;
        this.j = new Format.b().e0("audio/raw").G(i2).Z(i2).W(h(i1, i3)).H(paramc.b).f0(paramc.c).Y(2).E();
        return;
      }
      paraml = new StringBuilder(56);
      paraml.append("Expected frames per block: ");
      paraml.append(i4);
      paraml.append("; got: ");
      paraml.append(i2);
      throw ParserException.createForMalformedContainer(paraml.toString(), null);
    }
    
    private void d(byte[] paramArrayOfByte, int paramInt, d0 paramd0)
    {
      for (int i1 = 0; i1 < paramInt; i1++) {
        for (int i2 = 0; i2 < this.e.b; i2++) {
          e(paramArrayOfByte, i1, i2, paramd0.d());
        }
      }
      paramInt = g(this.f * paramInt);
      paramd0.P(0);
      paramd0.O(paramInt);
    }
    
    private void e(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
    {
      Object localObject = this.e;
      int i1 = ((c)localObject).e;
      int i2 = ((c)localObject).b;
      int i3 = paramInt1 * i1 + paramInt2 * 4;
      int i4 = i1 / i2;
      int i5 = (short)((paramArrayOfByte1[(i3 + 1)] & 0xFF) << 8 | paramArrayOfByte1[i3] & 0xFF);
      i1 = Math.min(paramArrayOfByte1[(i3 + 2)] & 0xFF, 88);
      int i6 = b[i1];
      paramInt2 = (paramInt1 * this.f * i2 + paramInt2) * 2;
      paramArrayOfByte2[paramInt2] = ((byte)(byte)(i5 & 0xFF));
      paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(byte)(i5 >> 8));
      for (paramInt1 = 0; paramInt1 < (i4 - 4) * 2; paramInt1++)
      {
        int i7 = paramArrayOfByte1[(paramInt1 / 8 * i2 * 4 + (i2 * 4 + i3) + paramInt1 / 2 % 4)] & 0xFF;
        if (paramInt1 % 2 == 0) {
          i7 &= 0xF;
        } else {
          i7 >>= 4;
        }
        int i8 = ((i7 & 0x7) * 2 + 1) * i6 >> 3;
        i6 = i8;
        if ((i7 & 0x8) != 0) {
          i6 = -i8;
        }
        i5 = o0.p(i5 + i6, 32768, 32767);
        paramInt2 += i2 * 2;
        paramArrayOfByte2[paramInt2] = ((byte)(byte)(i5 & 0xFF));
        paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(byte)(i5 >> 8));
        i6 = a[i7];
        localObject = b;
        i1 = o0.p(i1 + i6, 0, localObject.length - 1);
        i6 = localObject[i1];
      }
    }
    
    private int f(int paramInt)
    {
      return paramInt / (this.e.b * 2);
    }
    
    private int g(int paramInt)
    {
      return h(paramInt, this.e.b);
    }
    
    private static int h(int paramInt1, int paramInt2)
    {
      return paramInt1 * 2 * paramInt2;
    }
    
    private void i(int paramInt)
    {
      long l1 = this.l;
      long l2 = o0.C0(this.n, 1000000L, this.e.c);
      int i1 = g(paramInt);
      int i2 = this.m;
      this.d.e(l1 + l2, 1, i1, i2 - i1, null);
      this.n += paramInt;
      this.m -= i1;
    }
    
    public void a(int paramInt, long paramLong)
    {
      this.c.o(new e(this.e, this.f, paramInt, paramLong));
      this.d.d(this.j);
    }
    
    public boolean b(k paramk, long paramLong)
      throws IOException
    {
      int i1 = o0.k(this.i - f(this.m), this.f) * this.e.e;
      boolean bool;
      if (paramLong == 0L) {
        bool = true;
      } else {
        bool = false;
      }
      int i2;
      for (;;)
      {
        if (bool) {
          break label117;
        }
        i2 = this.k;
        if (i2 >= i1) {
          break label117;
        }
        i2 = (int)Math.min(i1 - i2, paramLong);
        i2 = paramk.read(this.g, this.k, i2);
        if (i2 == -1) {
          break;
        }
        this.k += i2;
      }
      label117:
      i1 = this.k / this.e.e;
      if (i1 > 0)
      {
        d(this.g, i1, this.h);
        this.k -= i1 * this.e.e;
        i1 = this.h.f();
        this.d.c(this.h, i1);
        i1 = this.m + i1;
        this.m = i1;
        i2 = f(i1);
        i1 = this.i;
        if (i2 >= i1) {
          i(i1);
        }
      }
      if (bool)
      {
        i1 = f(this.m);
        if (i1 > 0) {
          i(i1);
        }
      }
      return bool;
    }
    
    public void c(long paramLong)
    {
      this.k = 0;
      this.l = paramLong;
      this.m = 0;
      this.n = 0L;
    }
  }
  
  private static abstract interface b
  {
    public abstract void a(int paramInt, long paramLong)
      throws ParserException;
    
    public abstract boolean b(k paramk, long paramLong)
      throws IOException;
    
    public abstract void c(long paramLong);
  }
  
  private static final class c
    implements b.b
  {
    private final l a;
    private final b0 b;
    private final c c;
    private final Format d;
    private final int e;
    private long f;
    private int g;
    private long h;
    
    public c(l paraml, b0 paramb0, c paramc, String paramString, int paramInt)
      throws ParserException
    {
      this.a = paraml;
      this.b = paramb0;
      this.c = paramc;
      int i = paramc.b * paramc.f / 8;
      int j = paramc.e;
      if (j == i)
      {
        int k = paramc.c;
        j = k * i * 8;
        i = Math.max(i, k * i / 10);
        this.e = i;
        this.d = new Format.b().e0(paramString).G(j).Z(j).W(i).H(paramc.b).f0(paramc.c).Y(paramInt).E();
        return;
      }
      paraml = new StringBuilder(50);
      paraml.append("Expected block size: ");
      paraml.append(i);
      paraml.append("; got: ");
      paraml.append(j);
      throw ParserException.createForMalformedContainer(paraml.toString(), null);
    }
    
    public void a(int paramInt, long paramLong)
    {
      this.a.o(new e(this.c, 1, paramInt, paramLong));
      this.b.d(this.d);
    }
    
    public boolean b(k paramk, long paramLong)
      throws IOException
    {
      boolean bool1;
      int i;
      for (;;)
      {
        bool1 = true;
        boolean bool2 = paramLong < 0L;
        if (!bool2) {
          break;
        }
        j = this.g;
        k = this.e;
        if (j >= k) {
          break;
        }
        i = (int)Math.min(k - j, paramLong);
        i = this.b.b(paramk, i, true);
        if (i == -1)
        {
          paramLong = 0L;
        }
        else
        {
          this.g += i;
          paramLong -= i;
        }
      }
      paramk = this.c;
      int k = paramk.e;
      int j = this.g / k;
      if (j > 0)
      {
        paramLong = this.f;
        long l = o0.C0(this.h, 1000000L, paramk.c);
        int m = j * k;
        k = this.g - m;
        this.b.e(paramLong + l, 1, m, k, null);
        this.h += j;
        this.g = k;
      }
      if (i > 0) {
        bool1 = false;
      }
      return bool1;
    }
    
    public void c(long paramLong)
    {
      this.f = paramLong;
      this.g = 0;
      this.h = 0L;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\m0\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */