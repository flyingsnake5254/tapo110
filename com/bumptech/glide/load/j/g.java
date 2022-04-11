package com.bumptech.glide.load.j;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.c;
import com.bumptech.glide.util.i;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

public class g
  implements c
{
  private final h b;
  @Nullable
  private final URL c;
  @Nullable
  private final String d;
  @Nullable
  private String e;
  @Nullable
  private URL f;
  @Nullable
  private volatile byte[] g;
  private int h;
  
  public g(String paramString)
  {
    this(paramString, h.b);
  }
  
  public g(String paramString, h paramh)
  {
    this.c = null;
    this.d = i.b(paramString);
    this.b = ((h)i.d(paramh));
  }
  
  public g(URL paramURL)
  {
    this(paramURL, h.b);
  }
  
  public g(URL paramURL, h paramh)
  {
    this.c = ((URL)i.d(paramURL));
    this.d = null;
    this.b = ((h)i.d(paramh));
  }
  
  private byte[] d()
  {
    if (this.g == null) {
      this.g = c().getBytes(c.a);
    }
    return this.g;
  }
  
  private String f()
  {
    if (TextUtils.isEmpty(this.e))
    {
      String str1 = this.d;
      String str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        str2 = ((URL)i.d(this.c)).toString();
      }
      this.e = Uri.encode(str2, "@#&=*+-_.,:!?()/~'%;$");
    }
    return this.e;
  }
  
  private URL g()
    throws MalformedURLException
  {
    if (this.f == null) {
      this.f = new URL(f());
    }
    return this.f;
  }
  
  public void b(@NonNull MessageDigest paramMessageDigest)
  {
    paramMessageDigest.update(d());
  }
  
  public String c()
  {
    String str = this.d;
    if (str == null) {
      str = ((URL)i.d(this.c)).toString();
    }
    return str;
  }
  
  public Map<String, String> e()
  {
    return this.b.a();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof g;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (g)paramObject;
      bool3 = bool2;
      if (c().equals(((g)paramObject).c()))
      {
        bool3 = bool2;
        if (this.b.equals(((g)paramObject).b)) {
          bool3 = true;
        }
      }
    }
    return bool3;
  }
  
  public URL h()
    throws MalformedURLException
  {
    return g();
  }
  
  public int hashCode()
  {
    if (this.h == 0)
    {
      int i = c().hashCode();
      this.h = i;
      this.h = (i * 31 + this.b.hashCode());
    }
    return this.h;
  }
  
  public String toString()
  {
    return c();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */