package com.google.android.exoplayer2.o2.k0;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.d0.b;
import com.google.android.exoplayer2.o2.d0.c;
import com.google.android.exoplayer2.o2.d0.d;
import com.google.android.exoplayer2.util.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class j
  extends i
{
  @Nullable
  private a n;
  private int o;
  private boolean p;
  @Nullable
  private d0.d q;
  @Nullable
  private d0.b r;
  
  @VisibleForTesting
  static void n(com.google.android.exoplayer2.util.d0 paramd0, long paramLong)
  {
    if (paramd0.b() < paramd0.f() + 4) {
      paramd0.M(Arrays.copyOf(paramd0.d(), paramd0.f() + 4));
    } else {
      paramd0.O(paramd0.f() + 4);
    }
    byte[] arrayOfByte = paramd0.d();
    arrayOfByte[(paramd0.f() - 4)] = ((byte)(byte)(int)(paramLong & 0xFF));
    arrayOfByte[(paramd0.f() - 3)] = ((byte)(byte)(int)(paramLong >>> 8 & 0xFF));
    arrayOfByte[(paramd0.f() - 2)] = ((byte)(byte)(int)(paramLong >>> 16 & 0xFF));
    arrayOfByte[(paramd0.f() - 1)] = ((byte)(byte)(int)(paramLong >>> 24 & 0xFF));
  }
  
  private static int o(byte paramByte, a parama)
  {
    int i = p(paramByte, parama.e, 1);
    if (!parama.d[i].a) {
      i = parama.a.g;
    } else {
      i = parama.a.h;
    }
    return i;
  }
  
  @VisibleForTesting
  static int p(byte paramByte, int paramInt1, int paramInt2)
  {
    return paramByte >> paramInt2 & 255 >>> 8 - paramInt1;
  }
  
  public static boolean r(com.google.android.exoplayer2.util.d0 paramd0)
  {
    try
    {
      boolean bool = com.google.android.exoplayer2.o2.d0.l(1, paramd0, true);
      return bool;
    }
    catch (ParserException paramd0) {}
    return false;
  }
  
  protected void e(long paramLong)
  {
    super.e(paramLong);
    int i = 0;
    boolean bool;
    if (paramLong != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    this.p = bool;
    d0.d locald = this.q;
    if (locald != null) {
      i = locald.g;
    }
    this.o = i;
  }
  
  protected long f(com.google.android.exoplayer2.util.d0 paramd0)
  {
    byte[] arrayOfByte = paramd0.d();
    int i = 0;
    if ((arrayOfByte[0] & 0x1) == 1) {
      return -1L;
    }
    int j = o(paramd0.d()[0], (a)g.i(this.n));
    if (this.p) {
      i = (this.o + j) / 4;
    }
    long l = i;
    n(paramd0, l);
    this.p = true;
    this.o = j;
    return l;
  }
  
  @EnsuresNonNullIf(expression={"#3.format"}, result=false)
  protected boolean i(com.google.android.exoplayer2.util.d0 paramd0, long paramLong, i.b paramb)
    throws IOException
  {
    if (this.n != null)
    {
      g.e(paramb.a);
      return false;
    }
    a locala = q(paramd0);
    this.n = locala;
    if (locala == null) {
      return true;
    }
    d0.d locald = locala.a;
    paramd0 = new ArrayList();
    paramd0.add(locald.j);
    paramd0.add(locala.c);
    paramb.a = new Format.b().e0("audio/vorbis").G(locald.e).Z(locald.d).H(locald.b).f0(locald.c).T(paramd0).E();
    return true;
  }
  
  protected void l(boolean paramBoolean)
  {
    super.l(paramBoolean);
    if (paramBoolean)
    {
      this.n = null;
      this.q = null;
      this.r = null;
    }
    this.o = 0;
    this.p = false;
  }
  
  @Nullable
  @VisibleForTesting
  a q(com.google.android.exoplayer2.util.d0 paramd0)
    throws IOException
  {
    d0.d locald = this.q;
    if (locald == null)
    {
      this.q = com.google.android.exoplayer2.o2.d0.j(paramd0);
      return null;
    }
    d0.b localb = this.r;
    if (localb == null)
    {
      this.r = com.google.android.exoplayer2.o2.d0.h(paramd0);
      return null;
    }
    byte[] arrayOfByte = new byte[paramd0.f()];
    System.arraycopy(paramd0.d(), 0, arrayOfByte, 0, paramd0.f());
    paramd0 = com.google.android.exoplayer2.o2.d0.k(paramd0, locald.b);
    return new a(locald, localb, arrayOfByte, paramd0, com.google.android.exoplayer2.o2.d0.a(paramd0.length - 1));
  }
  
  static final class a
  {
    public final d0.d a;
    public final d0.b b;
    public final byte[] c;
    public final d0.c[] d;
    public final int e;
    
    public a(d0.d paramd, d0.b paramb, byte[] paramArrayOfByte, d0.c[] paramArrayOfc, int paramInt)
    {
      this.a = paramd;
      this.b = paramb;
      this.c = paramArrayOfByte;
      this.d = paramArrayOfc;
      this.e = paramInt;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\k0\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */