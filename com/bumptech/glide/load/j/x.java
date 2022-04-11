package com.bumptech.glide.load.j;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.f;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class x<Data>
  implements n<Uri, Data>
{
  private static final Set<String> a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "http", "https" })));
  private final n<g, Data> b;
  
  public x(n<g, Data> paramn)
  {
    this.b = paramn;
  }
  
  public n.a<Data> c(@NonNull Uri paramUri, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    paramUri = new g(paramUri.toString());
    return this.b.b(paramUri, paramInt1, paramInt2, paramf);
  }
  
  public boolean d(@NonNull Uri paramUri)
  {
    return a.contains(paramUri.getScheme());
  }
  
  public static class a
    implements o<Uri, InputStream>
  {
    public void a() {}
    
    @NonNull
    public n<Uri, InputStream> c(r paramr)
    {
      return new x(paramr.d(g.class, InputStream.class));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */