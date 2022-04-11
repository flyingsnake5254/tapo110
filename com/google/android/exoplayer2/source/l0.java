package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.decoder.b;
import com.google.android.exoplayer2.o2.b0.a;
import com.google.android.exoplayer2.upstream.d;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

class l0
{
  private final e a;
  private final int b;
  private final d0 c;
  private a d;
  private a e;
  private a f;
  private long g;
  
  public l0(e parame)
  {
    this.a = parame;
    int i = parame.e();
    this.b = i;
    this.c = new d0(32);
    parame = new a(0L, i);
    this.d = parame;
    this.e = parame;
    this.f = parame;
  }
  
  private void a(a parama)
  {
    if (!parama.c) {
      return;
    }
    Object localObject = this.f;
    int i = ((a)localObject).c + (int)(((a)localObject).a - parama.a) / this.b;
    localObject = new d[i];
    for (int j = 0; j < i; j++)
    {
      localObject[j] = parama.d;
      parama = parama.a();
    }
    this.a.b((d[])localObject);
  }
  
  private static a d(a parama, long paramLong)
  {
    while (paramLong >= parama.b) {
      parama = parama.e;
    }
    return parama;
  }
  
  private void g(int paramInt)
  {
    long l = this.g + paramInt;
    this.g = l;
    a locala = this.f;
    if (l == locala.b) {
      this.f = locala.e;
    }
  }
  
  private int h(int paramInt)
  {
    a locala = this.f;
    if (!locala.c) {
      locala.b(this.a.a(), new a(this.f.b, this.b));
    }
    return Math.min(paramInt, (int)(this.f.b - this.g));
  }
  
  private static a i(a parama, long paramLong, ByteBuffer paramByteBuffer, int paramInt)
  {
    parama = d(parama, paramLong);
    while (paramInt > 0)
    {
      int i = Math.min(paramInt, (int)(parama.b - paramLong));
      paramByteBuffer.put(parama.d.a, parama.c(paramLong), i);
      int j = paramInt - i;
      long l = paramLong + i;
      paramLong = l;
      paramInt = j;
      if (l == parama.b)
      {
        parama = parama.e;
        paramLong = l;
        paramInt = j;
      }
    }
    return parama;
  }
  
  private static a j(a parama, long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    parama = d(parama, paramLong);
    int i = paramInt;
    while (i > 0)
    {
      int j = Math.min(i, (int)(parama.b - paramLong));
      System.arraycopy(parama.d.a, parama.c(paramLong), paramArrayOfByte, paramInt - i, j);
      int k = i - j;
      long l = paramLong + j;
      i = k;
      paramLong = l;
      if (l == parama.b)
      {
        parama = parama.e;
        i = k;
        paramLong = l;
      }
    }
    return parama;
  }
  
  private static a k(a parama, DecoderInputBuffer paramDecoderInputBuffer, m0.b paramb, d0 paramd0)
  {
    long l1 = paramb.b;
    paramd0.L(1);
    parama = j(parama, l1, paramd0.d(), 1);
    l1 += 1L;
    Object localObject1 = paramd0.d();
    int i = 0;
    int j = localObject1[0];
    if ((j & 0x80) != 0) {
      k = 1;
    } else {
      k = 0;
    }
    j &= 0x7F;
    b localb = paramDecoderInputBuffer.d;
    paramDecoderInputBuffer = localb.a;
    if (paramDecoderInputBuffer == null) {
      localb.a = new byte[16];
    } else {
      Arrays.fill(paramDecoderInputBuffer, (byte)0);
    }
    parama = j(parama, l1, localb.a, j);
    l1 += j;
    if (k != 0)
    {
      paramd0.L(2);
      parama = j(parama, l1, paramd0.d(), 2);
      l1 += 2L;
      j = paramd0.J();
    }
    else
    {
      j = 1;
    }
    localObject1 = localb.d;
    if (localObject1 != null)
    {
      paramDecoderInputBuffer = (DecoderInputBuffer)localObject1;
      if (localObject1.length >= j) {}
    }
    else
    {
      paramDecoderInputBuffer = new int[j];
    }
    Object localObject2 = localb.e;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length >= j) {}
    }
    else
    {
      localObject1 = new int[j];
    }
    if (k != 0)
    {
      k = j * 6;
      paramd0.L(k);
      localObject2 = j(parama, l1, paramd0.d(), k);
      l2 = l1 + k;
      paramd0.P(0);
      for (k = i;; k++)
      {
        l1 = l2;
        parama = (a)localObject2;
        if (k >= j) {
          break;
        }
        paramDecoderInputBuffer[k] = paramd0.J();
        localObject1[k] = paramd0.H();
      }
    }
    paramDecoderInputBuffer[0] = 0;
    localObject1[0] = (paramb.a - (int)(l1 - paramb.b));
    paramd0 = (b0.a)o0.i(paramb.c);
    localb.c(j, paramDecoderInputBuffer, (int[])localObject1, paramd0.b, localb.a, paramd0.a, paramd0.c, paramd0.d);
    long l2 = paramb.b;
    int k = (int)(l1 - l2);
    paramb.b = (l2 + k);
    paramb.a -= k;
    return parama;
  }
  
  private static a l(a parama, DecoderInputBuffer paramDecoderInputBuffer, m0.b paramb, d0 paramd0)
  {
    a locala = parama;
    if (paramDecoderInputBuffer.q()) {
      locala = k(parama, paramDecoderInputBuffer, paramb, paramd0);
    }
    if (paramDecoderInputBuffer.i())
    {
      paramd0.L(4);
      parama = j(locala, paramb.b, paramd0.d(), 4);
      int i = paramd0.H();
      paramb.b += 4L;
      paramb.a -= 4;
      paramDecoderInputBuffer.o(i);
      parama = i(parama, paramb.b, paramDecoderInputBuffer.f, i);
      paramb.b += i;
      i = paramb.a - i;
      paramb.a = i;
      paramDecoderInputBuffer.s(i);
      parama = i(parama, paramb.b, paramDecoderInputBuffer.y, paramb.a);
    }
    else
    {
      paramDecoderInputBuffer.o(paramb.a);
      parama = i(locala, paramb.b, paramDecoderInputBuffer.f, paramb.a);
    }
    return parama;
  }
  
  public void b(long paramLong)
  {
    if (paramLong == -1L) {
      return;
    }
    a locala;
    for (;;)
    {
      locala = this.d;
      if (paramLong < locala.b) {
        break;
      }
      this.a.c(locala.d);
      this.d = this.d.a();
    }
    if (this.e.a < locala.a) {
      this.e = locala;
    }
  }
  
  public void c(long paramLong)
  {
    this.g = paramLong;
    if (paramLong != 0L)
    {
      Object localObject1 = this.d;
      localObject2 = localObject1;
      if (paramLong != ((a)localObject1).a)
      {
        while (this.g > ((a)localObject2).b) {
          localObject2 = ((a)localObject2).e;
        }
        a locala1 = ((a)localObject2).e;
        a(locala1);
        a locala2 = new a(((a)localObject2).b, this.b);
        ((a)localObject2).e = locala2;
        localObject1 = localObject2;
        if (this.g == ((a)localObject2).b) {
          localObject1 = locala2;
        }
        this.f = ((a)localObject1);
        if (this.e != locala1) {
          return;
        }
        this.e = locala2;
        return;
      }
    }
    a(this.d);
    Object localObject2 = new a(this.g, this.b);
    this.d = ((a)localObject2);
    this.e = ((a)localObject2);
    this.f = ((a)localObject2);
  }
  
  public long e()
  {
    return this.g;
  }
  
  public void f(DecoderInputBuffer paramDecoderInputBuffer, m0.b paramb)
  {
    l(this.e, paramDecoderInputBuffer, paramb, this.c);
  }
  
  public void m(DecoderInputBuffer paramDecoderInputBuffer, m0.b paramb)
  {
    this.e = l(this.e, paramDecoderInputBuffer, paramb, this.c);
  }
  
  public void n()
  {
    a(this.d);
    a locala = new a(0L, this.b);
    this.d = locala;
    this.e = locala;
    this.f = locala;
    this.g = 0L;
    this.a.d();
  }
  
  public void o()
  {
    this.e = this.d;
  }
  
  public int p(i parami, int paramInt, boolean paramBoolean)
    throws IOException
  {
    paramInt = h(paramInt);
    a locala = this.f;
    paramInt = parami.read(locala.d.a, locala.c(this.g), paramInt);
    if (paramInt == -1)
    {
      if (paramBoolean) {
        return -1;
      }
      throw new EOFException();
    }
    g(paramInt);
    return paramInt;
  }
  
  public void q(d0 paramd0, int paramInt)
  {
    while (paramInt > 0)
    {
      int i = h(paramInt);
      a locala = this.f;
      paramd0.j(locala.d.a, locala.c(this.g), i);
      paramInt -= i;
      g(i);
    }
  }
  
  private static final class a
  {
    public final long a;
    public final long b;
    public boolean c;
    @Nullable
    public d d;
    @Nullable
    public a e;
    
    public a(long paramLong, int paramInt)
    {
      this.a = paramLong;
      this.b = (paramLong + paramInt);
    }
    
    public a a()
    {
      this.d = null;
      a locala = this.e;
      this.e = null;
      return locala;
    }
    
    public void b(d paramd, a parama)
    {
      this.d = paramd;
      this.e = parama;
      this.c = true;
    }
    
    public int c(long paramLong)
    {
      return (int)(paramLong - this.a) + this.d.b;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\l0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */