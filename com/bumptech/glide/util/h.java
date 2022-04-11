package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class h
{
  private Class<?> a;
  private Class<?> b;
  private Class<?> c;
  
  public h() {}
  
  public h(@NonNull Class<?> paramClass1, @NonNull Class<?> paramClass2, @Nullable Class<?> paramClass3)
  {
    a(paramClass1, paramClass2, paramClass3);
  }
  
  public void a(@NonNull Class<?> paramClass1, @NonNull Class<?> paramClass2, @Nullable Class<?> paramClass3)
  {
    this.a = paramClass1;
    this.b = paramClass2;
    this.c = paramClass3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (h.class == paramObject.getClass()))
    {
      paramObject = (h)paramObject;
      if (!this.a.equals(((h)paramObject).a)) {
        return false;
      }
      if (!this.b.equals(((h)paramObject).b)) {
        return false;
      }
      return j.d(this.c, ((h)paramObject).c);
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = this.a.hashCode();
    int j = this.b.hashCode();
    Class localClass = this.c;
    int k;
    if (localClass != null) {
      k = localClass.hashCode();
    } else {
      k = 0;
    }
    return (i * 31 + j) * 31 + k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MultiClassKey{first=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", second=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\util\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */