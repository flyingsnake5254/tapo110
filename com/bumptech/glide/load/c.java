package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public abstract interface c
{
  public static final Charset a = Charset.forName("UTF-8");
  
  public abstract void b(@NonNull MessageDigest paramMessageDigest);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract int hashCode();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */