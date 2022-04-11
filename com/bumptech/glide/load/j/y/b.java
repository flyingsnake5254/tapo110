package com.bumptech.glide.load.j.y;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.o.c;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.j.n;
import com.bumptech.glide.load.j.n.a;
import com.bumptech.glide.load.j.o;
import com.bumptech.glide.load.j.r;
import java.io.InputStream;

public class b
  implements n<Uri, InputStream>
{
  private final Context a;
  
  public b(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  public n.a<InputStream> c(@NonNull Uri paramUri, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    if (com.bumptech.glide.load.data.o.b.d(paramInt1, paramInt2)) {
      return new n.a(new com.bumptech.glide.o.b(paramUri), c.f(this.a, paramUri));
    }
    return null;
  }
  
  public boolean d(@NonNull Uri paramUri)
  {
    return com.bumptech.glide.load.data.o.b.a(paramUri);
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
      return new b(this.a);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\y\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */