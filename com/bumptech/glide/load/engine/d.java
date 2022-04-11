package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.c;
import java.security.MessageDigest;

final class d
  implements c
{
  private final c b;
  private final c c;
  
  d(c paramc1, c paramc2)
  {
    this.b = paramc1;
    this.c = paramc2;
  }
  
  public void b(@NonNull MessageDigest paramMessageDigest)
  {
    this.b.b(paramMessageDigest);
    this.c.b(paramMessageDigest);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof d;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (d)paramObject;
      bool3 = bool2;
      if (this.b.equals(((d)paramObject).b))
      {
        bool3 = bool2;
        if (this.c.equals(((d)paramObject).c)) {
          bool3 = true;
        }
      }
    }
    return bool3;
  }
  
  public int hashCode()
  {
    return this.b.hashCode() * 31 + this.c.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataCacheKey{sourceKey=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", signature=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */