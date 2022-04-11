package com.airbnb.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import com.airbnb.lottie.d;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class f
{
  private static final f a = new f();
  private final LruCache<String, d> b = new LruCache(20);
  
  public static f b()
  {
    return a;
  }
  
  @Nullable
  public d a(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (d)this.b.get(paramString);
  }
  
  public void c(@Nullable String paramString, d paramd)
  {
    if (paramString == null) {
      return;
    }
    this.b.put(paramString, paramd);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */