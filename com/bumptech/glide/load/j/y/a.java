package com.bumptech.glide.load.j.y;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.data.j;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.j.g;
import com.bumptech.glide.load.j.m;
import com.bumptech.glide.load.j.n;
import com.bumptech.glide.load.j.n.a;
import com.bumptech.glide.load.j.o;
import com.bumptech.glide.load.j.r;
import java.io.InputStream;

public class a
  implements n<g, InputStream>
{
  public static final e<Integer> a = e.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(2500));
  @Nullable
  private final m<g, g> b;
  
  public a(@Nullable m<g, g> paramm)
  {
    this.b = paramm;
  }
  
  public n.a<InputStream> c(@NonNull g paramg, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    m localm = this.b;
    g localg = paramg;
    if (localm != null)
    {
      localg = (g)localm.a(paramg, 0, 0);
      if (localg == null)
      {
        this.b.b(paramg, 0, 0, paramg);
        localg = paramg;
      }
    }
    return new n.a(localg, new j(localg, ((Integer)paramf.c(a)).intValue()));
  }
  
  public boolean d(@NonNull g paramg)
  {
    return true;
  }
  
  public static class a
    implements o<g, InputStream>
  {
    private final m<g, g> a = new m(500L);
    
    public void a() {}
    
    @NonNull
    public n<g, InputStream> c(r paramr)
    {
      return new a(this.a);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\y\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */