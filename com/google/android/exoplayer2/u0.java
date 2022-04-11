package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.source.n0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.w;
import java.io.IOException;

public abstract class u0
  implements b2, d2
{
  private boolean H3;
  private final int c;
  private final i1 d;
  @Nullable
  private e2 f;
  private long p0;
  private long p1;
  private long p2;
  private boolean p3;
  private int q;
  private int x;
  @Nullable
  private n0 y;
  @Nullable
  private Format[] z;
  
  public u0(int paramInt)
  {
    this.c = paramInt;
    this.d = new i1();
    this.p2 = Long.MIN_VALUE;
  }
  
  protected final i1 A()
  {
    this.d.a();
    return this.d;
  }
  
  protected final int B()
  {
    return this.q;
  }
  
  protected final Format[] C()
  {
    return (Format[])g.e(this.z);
  }
  
  protected final boolean D()
  {
    boolean bool;
    if (i()) {
      bool = this.p3;
    } else {
      bool = ((n0)g.e(this.y)).g();
    }
    return bool;
  }
  
  protected abstract void E();
  
  protected void F(boolean paramBoolean1, boolean paramBoolean2)
    throws ExoPlaybackException
  {}
  
  protected abstract void G(long paramLong, boolean paramBoolean)
    throws ExoPlaybackException;
  
  protected void H() {}
  
  protected void I()
    throws ExoPlaybackException
  {}
  
  protected void J() {}
  
  protected void K(Format[] paramArrayOfFormat, long paramLong1, long paramLong2)
    throws ExoPlaybackException
  {}
  
  protected final int L(i1 parami1, DecoderInputBuffer paramDecoderInputBuffer, int paramInt)
  {
    int i = ((n0)g.e(this.y)).b(parami1, paramDecoderInputBuffer, paramInt);
    paramInt = -4;
    if (i == -4)
    {
      if (paramDecoderInputBuffer.k())
      {
        this.p2 = Long.MIN_VALUE;
        if (!this.p3) {
          paramInt = -3;
        }
        return paramInt;
      }
      long l = paramDecoderInputBuffer.x + this.p0;
      paramDecoderInputBuffer.x = l;
      this.p2 = Math.max(this.p2, l);
    }
    else if (i == -5)
    {
      paramDecoderInputBuffer = (Format)g.e(parami1.b);
      if (paramDecoderInputBuffer.L3 != Long.MAX_VALUE) {
        parami1.b = paramDecoderInputBuffer.a().i0(paramDecoderInputBuffer.L3 + this.p0).E();
      }
    }
    return i;
  }
  
  protected int M(long paramLong)
  {
    return ((n0)g.e(this.y)).c(paramLong - this.p0);
  }
  
  public final void b()
  {
    int i = this.x;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    g.g(bool);
    this.d.a();
    this.x = 0;
    this.y = null;
    this.z = null;
    this.p3 = false;
    E();
  }
  
  public final int f()
  {
    return this.c;
  }
  
  public final int getState()
  {
    return this.x;
  }
  
  @Nullable
  public final n0 getStream()
  {
    return this.y;
  }
  
  public final void h(int paramInt)
  {
    this.q = paramInt;
  }
  
  public final boolean i()
  {
    boolean bool;
    if (this.p2 == Long.MIN_VALUE) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void j()
  {
    this.p3 = true;
  }
  
  public void k(int paramInt, @Nullable Object paramObject)
    throws ExoPlaybackException
  {}
  
  public final void l()
    throws IOException
  {
    ((n0)g.e(this.y)).a();
  }
  
  public final boolean m()
  {
    return this.p3;
  }
  
  public final void n(Format[] paramArrayOfFormat, n0 paramn0, long paramLong1, long paramLong2)
    throws ExoPlaybackException
  {
    g.g(this.p3 ^ true);
    this.y = paramn0;
    if (this.p2 == Long.MIN_VALUE) {
      this.p2 = paramLong1;
    }
    this.z = paramArrayOfFormat;
    this.p0 = paramLong2;
    K(paramArrayOfFormat, paramLong1, paramLong2);
  }
  
  public final d2 o()
  {
    return this;
  }
  
  public final void r(e2 parame2, Format[] paramArrayOfFormat, n0 paramn0, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2, long paramLong3)
    throws ExoPlaybackException
  {
    boolean bool;
    if (this.x == 0) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    this.f = parame2;
    this.x = 1;
    this.p1 = paramLong1;
    F(paramBoolean1, paramBoolean2);
    n(paramArrayOfFormat, paramn0, paramLong2, paramLong3);
    G(paramLong1, paramBoolean1);
  }
  
  public final void reset()
  {
    boolean bool;
    if (this.x == 0) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    this.d.a();
    H();
  }
  
  public int s()
    throws ExoPlaybackException
  {
    return 0;
  }
  
  public final void start()
    throws ExoPlaybackException
  {
    int i = this.x;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    g.g(bool);
    this.x = 2;
    I();
  }
  
  public final void stop()
  {
    boolean bool;
    if (this.x == 2) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    this.x = 1;
    J();
  }
  
  public final long u()
  {
    return this.p2;
  }
  
  public final void v(long paramLong)
    throws ExoPlaybackException
  {
    this.p3 = false;
    this.p1 = paramLong;
    this.p2 = paramLong;
    G(paramLong, false);
  }
  
  @Nullable
  public w w()
  {
    return null;
  }
  
  protected final ExoPlaybackException x(Throwable paramThrowable, @Nullable Format paramFormat, int paramInt)
  {
    return y(paramThrowable, paramFormat, false, paramInt);
  }
  
  /* Error */
  protected final ExoPlaybackException y(Throwable paramThrowable, @Nullable Format paramFormat, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +50 -> 51
    //   4: aload_0
    //   5: getfield 204	com/google/android/exoplayer2/u0:H3	Z
    //   8: ifne +43 -> 51
    //   11: aload_0
    //   12: iconst_1
    //   13: putfield 204	com/google/android/exoplayer2/u0:H3	Z
    //   16: aload_0
    //   17: aload_2
    //   18: invokeinterface 207 2 0
    //   23: invokestatic 212	com/google/android/exoplayer2/c2:d	(I)I
    //   26: istore 5
    //   28: aload_0
    //   29: iconst_0
    //   30: putfield 204	com/google/android/exoplayer2/u0:H3	Z
    //   33: goto +21 -> 54
    //   36: astore_1
    //   37: aload_0
    //   38: iconst_0
    //   39: putfield 204	com/google/android/exoplayer2/u0:H3	Z
    //   42: aload_1
    //   43: athrow
    //   44: astore 6
    //   46: aload_0
    //   47: iconst_0
    //   48: putfield 204	com/google/android/exoplayer2/u0:H3	Z
    //   51: iconst_4
    //   52: istore 5
    //   54: aload_1
    //   55: aload_0
    //   56: invokeinterface 216 1 0
    //   61: aload_0
    //   62: invokevirtual 218	com/google/android/exoplayer2/u0:B	()I
    //   65: aload_2
    //   66: iload 5
    //   68: iload_3
    //   69: iload 4
    //   71: invokestatic 222	com/google/android/exoplayer2/ExoPlaybackException:createForRenderer	(Ljava/lang/Throwable;Ljava/lang/String;ILcom/google/android/exoplayer2/Format;IZI)Lcom/google/android/exoplayer2/ExoPlaybackException;
    //   74: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	u0
    //   0	75	1	paramThrowable	Throwable
    //   0	75	2	paramFormat	Format
    //   0	75	3	paramBoolean	boolean
    //   0	75	4	paramInt	int
    //   26	41	5	i	int
    //   44	1	6	localExoPlaybackException	ExoPlaybackException
    // Exception table:
    //   from	to	target	type
    //   16	28	36	finally
    //   16	28	44	com/google/android/exoplayer2/ExoPlaybackException
  }
  
  protected final e2 z()
  {
    return (e2)g.e(this.f);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\u0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */