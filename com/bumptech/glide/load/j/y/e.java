package com.bumptech.glide.load.j.y;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.j.g;
import com.bumptech.glide.load.j.n;
import com.bumptech.glide.load.j.n.a;
import com.bumptech.glide.load.j.o;
import com.bumptech.glide.load.j.r;
import java.io.InputStream;
import java.net.URL;

public class e
  implements n<URL, InputStream>
{
  private final n<g, InputStream> a;
  
  public e(n<g, InputStream> paramn)
  {
    this.a = paramn;
  }
  
  public n.a<InputStream> c(@NonNull URL paramURL, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    return this.a.b(new g(paramURL), paramInt1, paramInt2, paramf);
  }
  
  public boolean d(@NonNull URL paramURL)
  {
    return true;
  }
  
  public static class a
    implements o<URL, InputStream>
  {
    public void a() {}
    
    @NonNull
    public n<URL, InputStream> c(r paramr)
    {
      return new e(paramr.d(g.class, InputStream.class));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\y\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */