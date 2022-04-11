package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.util.i;
import java.security.MessageDigest;

public final class e<T>
{
  private static final b<Object> a = new a();
  private final T b;
  private final b<T> c;
  private final String d;
  private volatile byte[] e;
  
  private e(@NonNull String paramString, @Nullable T paramT, @NonNull b<T> paramb)
  {
    this.d = i.b(paramString);
    this.b = paramT;
    this.c = ((b)i.d(paramb));
  }
  
  @NonNull
  public static <T> e<T> a(@NonNull String paramString, @Nullable T paramT, @NonNull b<T> paramb)
  {
    return new e(paramString, paramT, paramb);
  }
  
  @NonNull
  private static <T> b<T> b()
  {
    return a;
  }
  
  @NonNull
  private byte[] d()
  {
    if (this.e == null) {
      this.e = this.d.getBytes(c.a);
    }
    return this.e;
  }
  
  @NonNull
  public static <T> e<T> e(@NonNull String paramString)
  {
    return new e(paramString, null, b());
  }
  
  @NonNull
  public static <T> e<T> f(@NonNull String paramString, @NonNull T paramT)
  {
    return new e(paramString, paramT, b());
  }
  
  @Nullable
  public T c()
  {
    return (T)this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof e))
    {
      paramObject = (e)paramObject;
      return this.d.equals(((e)paramObject).d);
    }
    return false;
  }
  
  public void g(@NonNull T paramT, @NonNull MessageDigest paramMessageDigest)
  {
    this.c.a(d(), paramT, paramMessageDigest);
  }
  
  public int hashCode()
  {
    return this.d.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Option{key='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  class a
    implements e.b<Object>
  {
    public void a(@NonNull byte[] paramArrayOfByte, @NonNull Object paramObject, @NonNull MessageDigest paramMessageDigest) {}
  }
  
  public static abstract interface b<T>
  {
    public abstract void a(@NonNull byte[] paramArrayOfByte, @NonNull T paramT, @NonNull MessageDigest paramMessageDigest);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */