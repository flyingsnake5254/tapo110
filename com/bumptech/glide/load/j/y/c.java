package com.bumptech.glide.load.j.y;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.j.n;
import com.bumptech.glide.load.j.n.a;
import com.bumptech.glide.load.j.o;
import com.bumptech.glide.load.j.r;
import com.bumptech.glide.load.resource.bitmap.a0;
import java.io.InputStream;

public class c
  implements n<Uri, InputStream>
{
  private final Context a;
  
  public c(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  private boolean e(f paramf)
  {
    paramf = (Long)paramf.c(a0.a);
    boolean bool;
    if ((paramf != null) && (paramf.longValue() == -1L)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Nullable
  public n.a<InputStream> c(@NonNull Uri paramUri, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    if ((com.bumptech.glide.load.data.o.b.d(paramInt1, paramInt2)) && (e(paramf))) {
      return new n.a(new com.bumptech.glide.o.b(paramUri), com.bumptech.glide.load.data.o.c.g(this.a, paramUri));
    }
    return null;
  }
  
  public boolean d(@NonNull Uri paramUri)
  {
    return com.bumptech.glide.load.data.o.b.c(paramUri);
  }
  
  public static class a
    implements o<Uri, InputStream>
  {
    private final Context a;
    
    public a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public void a() {}
    
    @NonNull
    public n<Uri, InputStream> c(r paramr)
    {
      return new c(this.a);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\y\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */