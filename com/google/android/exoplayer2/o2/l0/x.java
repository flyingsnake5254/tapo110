package com.google.android.exoplayer2.o2.l0;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.o0;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class x
  implements c0
{
  private Format a;
  private l0 b;
  private b0 c;
  
  public x(String paramString)
  {
    this.a = new Format.b().e0(paramString).E();
  }
  
  @EnsuresNonNull({"timestampAdjuster", "output"})
  private void c()
  {
    g.i(this.b);
    o0.i(this.c);
  }
  
  public void a(l0 paraml0, l paraml, i0.d paramd)
  {
    this.b = paraml0;
    paramd.a();
    paraml0 = paraml.t(paramd.c(), 5);
    this.c = paraml0;
    paraml0.d(this.a);
  }
  
  public void b(d0 paramd0)
  {
    c();
    long l1 = this.b.d();
    long l2 = this.b.e();
    if ((l1 != -9223372036854775807L) && (l2 != -9223372036854775807L))
    {
      Format localFormat = this.a;
      if (l2 != localFormat.L3)
      {
        localFormat = localFormat.a().i0(l2).E();
        this.a = localFormat;
        this.c.d(localFormat);
      }
      int i = paramd0.a();
      this.c.c(paramd0, i);
      this.c.e(l1, 1, i, 0, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */