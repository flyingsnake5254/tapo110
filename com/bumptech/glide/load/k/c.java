package com.bumptech.glide.load.k;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.i;
import java.security.MessageDigest;

public final class c<T>
  implements i<T>
{
  private static final i<?> b = new c();
  
  @NonNull
  public static <T> c<T> c()
  {
    return (c)b;
  }
  
  @NonNull
  public u<T> a(@NonNull Context paramContext, @NonNull u<T> paramu, int paramInt1, int paramInt2)
  {
    return paramu;
  }
  
  public void b(@NonNull MessageDigest paramMessageDigest) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\k\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */