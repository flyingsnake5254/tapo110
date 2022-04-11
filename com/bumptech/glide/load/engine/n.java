package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.f;
import java.security.MessageDigest;
import java.util.Map;

class n
  implements c
{
  private final Object b;
  private final int c;
  private final int d;
  private final Class<?> e;
  private final Class<?> f;
  private final c g;
  private final Map<Class<?>, com.bumptech.glide.load.i<?>> h;
  private final f i;
  private int j;
  
  n(Object paramObject, c paramc, int paramInt1, int paramInt2, Map<Class<?>, com.bumptech.glide.load.i<?>> paramMap, Class<?> paramClass1, Class<?> paramClass2, f paramf)
  {
    this.b = com.bumptech.glide.util.i.d(paramObject);
    this.g = ((c)com.bumptech.glide.util.i.e(paramc, "Signature must not be null"));
    this.c = paramInt1;
    this.d = paramInt2;
    this.h = ((Map)com.bumptech.glide.util.i.d(paramMap));
    this.e = ((Class)com.bumptech.glide.util.i.e(paramClass1, "Resource class must not be null"));
    this.f = ((Class)com.bumptech.glide.util.i.e(paramClass2, "Transcode class must not be null"));
    this.i = ((f)com.bumptech.glide.util.i.d(paramf));
  }
  
  public void b(@NonNull MessageDigest paramMessageDigest)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof n;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (n)paramObject;
      bool3 = bool2;
      if (this.b.equals(((n)paramObject).b))
      {
        bool3 = bool2;
        if (this.g.equals(((n)paramObject).g))
        {
          bool3 = bool2;
          if (this.d == ((n)paramObject).d)
          {
            bool3 = bool2;
            if (this.c == ((n)paramObject).c)
            {
              bool3 = bool2;
              if (this.h.equals(((n)paramObject).h))
              {
                bool3 = bool2;
                if (this.e.equals(((n)paramObject).e))
                {
                  bool3 = bool2;
                  if (this.f.equals(((n)paramObject).f))
                  {
                    bool3 = bool2;
                    if (this.i.equals(((n)paramObject).i)) {
                      bool3 = true;
                    }
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
    if (this.j == 0)
    {
      int k = this.b.hashCode();
      this.j = k;
      k = k * 31 + this.g.hashCode();
      this.j = k;
      k = k * 31 + this.c;
      this.j = k;
      k = k * 31 + this.d;
      this.j = k;
      k = k * 31 + this.h.hashCode();
      this.j = k;
      k = k * 31 + this.e.hashCode();
      this.j = k;
      k = k * 31 + this.f.hashCode();
      this.j = k;
      this.j = (k * 31 + this.i.hashCode());
    }
    return this.j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EngineKey{model=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", resourceClass=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", transcodeClass=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", signature=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", hashCode=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", transformations=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", options=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */