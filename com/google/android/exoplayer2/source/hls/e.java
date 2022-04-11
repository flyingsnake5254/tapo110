package com.google.android.exoplayer2.source.hls;

import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.o2.j0.i;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.l0.h;
import com.google.android.exoplayer2.o2.l0.h0;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.l0;
import java.io.IOException;

public final class e
  implements n
{
  private static final x a = new x();
  @VisibleForTesting
  final com.google.android.exoplayer2.o2.j b;
  private final Format c;
  private final l0 d;
  
  public e(com.google.android.exoplayer2.o2.j paramj, Format paramFormat, l0 paraml0)
  {
    this.b = paramj;
    this.c = paramFormat;
    this.d = paraml0;
  }
  
  public boolean a(k paramk)
    throws IOException
  {
    boolean bool;
    if (this.b.e(paramk, a) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void b(l paraml)
  {
    this.b.b(paraml);
  }
  
  public void c()
  {
    this.b.c(0L, 0L);
  }
  
  public boolean d()
  {
    com.google.android.exoplayer2.o2.j localj = this.b;
    boolean bool;
    if ((!(localj instanceof h0)) && (!(localj instanceof i))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean e()
  {
    com.google.android.exoplayer2.o2.j localj = this.b;
    boolean bool;
    if ((!(localj instanceof com.google.android.exoplayer2.o2.l0.j)) && (!(localj instanceof com.google.android.exoplayer2.o2.l0.f)) && (!(localj instanceof h)) && (!(localj instanceof com.google.android.exoplayer2.o2.i0.f))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public n f()
  {
    g.g(d() ^ true);
    Object localObject = this.b;
    if ((localObject instanceof s))
    {
      localObject = new s(this.c.f, this.d);
    }
    else if ((localObject instanceof com.google.android.exoplayer2.o2.l0.j))
    {
      localObject = new com.google.android.exoplayer2.o2.l0.j();
    }
    else if ((localObject instanceof com.google.android.exoplayer2.o2.l0.f))
    {
      localObject = new com.google.android.exoplayer2.o2.l0.f();
    }
    else if ((localObject instanceof h))
    {
      localObject = new h();
    }
    else
    {
      if (!(localObject instanceof com.google.android.exoplayer2.o2.i0.f)) {
        break label129;
      }
      localObject = new com.google.android.exoplayer2.o2.i0.f();
    }
    return new e((com.google.android.exoplayer2.o2.j)localObject, this.c, this.d);
    label129:
    localObject = this.b.getClass().getSimpleName();
    if (((String)localObject).length() != 0) {
      localObject = "Unexpected extractor type for recreation: ".concat((String)localObject);
    } else {
      localObject = new String("Unexpected extractor type for recreation: ");
    }
    throw new IllegalStateException((String)localObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\hls\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */