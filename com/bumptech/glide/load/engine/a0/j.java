package com.bumptech.glide.load.engine.a0;

import androidx.annotation.NonNull;
import androidx.core.util.Pools.Pool;
import com.bumptech.glide.util.f;
import com.bumptech.glide.util.i;
import com.bumptech.glide.util.k.a;
import com.bumptech.glide.util.k.a.d;
import com.bumptech.glide.util.k.a.f;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class j
{
  private final f<com.bumptech.glide.load.c, String> a = new f(1000L);
  private final Pools.Pool<b> b = a.d(10, new a());
  
  private String a(com.bumptech.glide.load.c paramc)
  {
    b localb = (b)i.d(this.b.acquire());
    try
    {
      paramc.b(localb.c);
      paramc = com.bumptech.glide.util.j.x(localb.c.digest());
      return paramc;
    }
    finally
    {
      this.b.release(localb);
    }
  }
  
  public String b(com.bumptech.glide.load.c paramc)
  {
    synchronized (this.a)
    {
      ??? = (String)this.a.g(paramc);
      ??? = ???;
      if (??? == null) {
        ??? = a(paramc);
      }
      synchronized (this.a)
      {
        this.a.k(paramc, ???);
        return (String)???;
      }
    }
  }
  
  class a
    implements a.d<j.b>
  {
    a() {}
    
    public j.b a()
    {
      try
      {
        j.b localb = new j.b(MessageDigest.getInstance("SHA-256"));
        return localb;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        throw new RuntimeException(localNoSuchAlgorithmException);
      }
    }
  }
  
  private static final class b
    implements a.f
  {
    final MessageDigest c;
    private final com.bumptech.glide.util.k.c d = com.bumptech.glide.util.k.c.a();
    
    b(MessageDigest paramMessageDigest)
    {
      this.c = paramMessageDigest;
    }
    
    @NonNull
    public com.bumptech.glide.util.k.c d()
    {
      return this.d;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\a0\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */