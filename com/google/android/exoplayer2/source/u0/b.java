package com.google.android.exoplayer2.source.u0;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.upstream.Loader.e;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.g;
import java.util.List;
import java.util.Map;

public abstract class b
  implements Loader.e
{
  public final long a;
  public final n b;
  public final int c;
  public final Format d;
  public final int e;
  @Nullable
  public final Object f;
  public final long g;
  public final long h;
  protected final z i;
  
  public b(l paraml, n paramn, int paramInt1, Format paramFormat, int paramInt2, @Nullable Object paramObject, long paramLong1, long paramLong2)
  {
    this.i = new z(paraml);
    this.b = ((n)g.e(paramn));
    this.c = paramInt1;
    this.d = paramFormat;
    this.e = paramInt2;
    this.f = paramObject;
    this.g = paramLong1;
    this.h = paramLong2;
    this.a = x.a();
  }
  
  public final long b()
  {
    return this.i.o();
  }
  
  public final long d()
  {
    return this.h - this.g;
  }
  
  public final Map<String, List<String>> e()
  {
    return this.i.q();
  }
  
  public final Uri f()
  {
    return this.i.p();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\u0\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */