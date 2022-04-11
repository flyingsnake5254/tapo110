package com.tplink.libtpimagedownloadmedia.loader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.j.m;
import com.bumptech.glide.load.j.n;
import com.bumptech.glide.load.j.n.a;
import com.bumptech.glide.load.j.o;
import com.bumptech.glide.load.j.r;
import com.bumptech.glide.o.b;
import java.io.InputStream;

public class h
  implements n<g, InputStream>
{
  private final m<g, g> a;
  
  public h(m<g, g> paramm)
  {
    this.a = paramm;
  }
  
  @Nullable
  public n.a<InputStream> c(@NonNull g paramg, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    m localm = this.a;
    paramf = paramg;
    if (localm != null)
    {
      paramf = (g)localm.a(paramg, 0, 0);
      if (paramf == null)
      {
        this.a.b(paramg, 0, 0, paramg);
        paramf = paramg;
      }
    }
    return new n.a(new b(paramf), new e(paramf));
  }
  
  public boolean d(@NonNull g paramg)
  {
    boolean bool;
    if (paramg.c() != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static class a
    implements o<g, InputStream>
  {
    private final m<g, g> a = new m(500L);
    
    public void a() {}
    
    @NonNull
    public n<g, InputStream> c(@NonNull r paramr)
    {
      return new h(this.a);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpimagedownloadmedia\loader\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */