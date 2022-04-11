package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

public final class f
  implements c
{
  private final ArrayMap<e<?>, Object> b = new CachedHashCodeArrayMap();
  
  private static <T> void f(@NonNull e<T> parame, @NonNull Object paramObject, @NonNull MessageDigest paramMessageDigest)
  {
    parame.g(paramObject, paramMessageDigest);
  }
  
  public void b(@NonNull MessageDigest paramMessageDigest)
  {
    for (int i = 0; i < this.b.size(); i++) {
      f((e)this.b.keyAt(i), this.b.valueAt(i), paramMessageDigest);
    }
  }
  
  @Nullable
  public <T> T c(@NonNull e<T> parame)
  {
    if (this.b.containsKey(parame)) {
      parame = this.b.get(parame);
    } else {
      parame = parame.c();
    }
    return parame;
  }
  
  public void d(@NonNull f paramf)
  {
    this.b.putAll(paramf.b);
  }
  
  @NonNull
  public <T> f e(@NonNull e<T> parame, @NonNull T paramT)
  {
    this.b.put(parame, paramT);
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof f))
    {
      paramObject = (f)paramObject;
      return this.b.equals(((f)paramObject).b);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Options{values=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */