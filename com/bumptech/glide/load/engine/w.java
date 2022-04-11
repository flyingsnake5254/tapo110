package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.i;
import com.bumptech.glide.util.j;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class w
  implements c
{
  private static final com.bumptech.glide.util.f<Class<?>, byte[]> b = new com.bumptech.glide.util.f(50L);
  private final b c;
  private final c d;
  private final c e;
  private final int f;
  private final int g;
  private final Class<?> h;
  private final com.bumptech.glide.load.f i;
  private final i<?> j;
  
  w(b paramb, c paramc1, c paramc2, int paramInt1, int paramInt2, i<?> parami, Class<?> paramClass, com.bumptech.glide.load.f paramf)
  {
    this.c = paramb;
    this.d = paramc1;
    this.e = paramc2;
    this.f = paramInt1;
    this.g = paramInt2;
    this.j = parami;
    this.h = paramClass;
    this.i = paramf;
  }
  
  private byte[] c()
  {
    com.bumptech.glide.util.f localf = b;
    byte[] arrayOfByte1 = (byte[])localf.g(this.h);
    byte[] arrayOfByte2 = arrayOfByte1;
    if (arrayOfByte1 == null)
    {
      arrayOfByte2 = this.h.getName().getBytes(c.a);
      localf.k(this.h, arrayOfByte2);
    }
    return arrayOfByte2;
  }
  
  public void b(@NonNull MessageDigest paramMessageDigest)
  {
    byte[] arrayOfByte = (byte[])this.c.d(8, byte[].class);
    ByteBuffer.wrap(arrayOfByte).putInt(this.f).putInt(this.g).array();
    this.e.b(paramMessageDigest);
    this.d.b(paramMessageDigest);
    paramMessageDigest.update(arrayOfByte);
    i locali = this.j;
    if (locali != null) {
      locali.b(paramMessageDigest);
    }
    this.i.b(paramMessageDigest);
    paramMessageDigest.update(c());
    this.c.e(arrayOfByte);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof w;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (w)paramObject;
      bool3 = bool2;
      if (this.g == ((w)paramObject).g)
      {
        bool3 = bool2;
        if (this.f == ((w)paramObject).f)
        {
          bool3 = bool2;
          if (j.d(this.j, ((w)paramObject).j))
          {
            bool3 = bool2;
            if (this.h.equals(((w)paramObject).h))
            {
              bool3 = bool2;
              if (this.d.equals(((w)paramObject).d))
              {
                bool3 = bool2;
                if (this.e.equals(((w)paramObject).e))
                {
                  bool3 = bool2;
                  if (this.i.equals(((w)paramObject).i)) {
                    bool3 = true;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool3;
  }
  
  public int hashCode()
  {
    int k = ((this.d.hashCode() * 31 + this.e.hashCode()) * 31 + this.f) * 31 + this.g;
    i locali = this.j;
    int m = k;
    if (locali != null) {
      m = k * 31 + locali.hashCode();
    }
    return (m * 31 + this.h.hashCode()) * 31 + this.i.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ResourceCacheKey{sourceKey=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", signature=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", decodedResourceClass=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", transformation='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", options=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */