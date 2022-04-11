package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public final class y<T>
  implements Loader.e
{
  public final long a;
  public final n b;
  public final int c;
  private final z d;
  private final a<? extends T> e;
  @Nullable
  private volatile T f;
  
  public y(l paraml, Uri paramUri, int paramInt, a<? extends T> parama)
  {
    this(paraml, new n.b().i(paramUri).b(1).a(), paramInt, parama);
  }
  
  public y(l paraml, n paramn, int paramInt, a<? extends T> parama)
  {
    this.d = new z(paraml);
    this.b = paramn;
    this.c = paramInt;
    this.e = parama;
    this.a = x.a();
  }
  
  public final void a()
    throws IOException
  {
    this.d.r();
    m localm = new m(this.d, this.b);
    try
    {
      localm.c();
      Uri localUri = (Uri)g.e(this.d.getUri());
      this.f = this.e.a(localUri, localm);
      return;
    }
    finally
    {
      o0.m(localm);
    }
  }
  
  public long b()
  {
    return this.d.o();
  }
  
  public final void c() {}
  
  public Map<String, List<String>> d()
  {
    return this.d.q();
  }
  
  @Nullable
  public final T e()
  {
    return (T)this.f;
  }
  
  public Uri f()
  {
    return this.d.p();
  }
  
  public static abstract interface a<T>
  {
    public abstract T a(Uri paramUri, InputStream paramInputStream)
      throws IOException;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */