package com.bumptech.glide.o;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.c;
import com.bumptech.glide.util.i;
import java.security.MessageDigest;

public final class b
  implements c
{
  private final Object b;
  
  public b(@NonNull Object paramObject)
  {
    this.b = i.d(paramObject);
  }
  
  public void b(@NonNull MessageDigest paramMessageDigest)
  {
    paramMessageDigest.update(this.b.toString().getBytes(c.a));
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      return this.b.equals(((b)paramObject).b);
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
    localStringBuilder.append("ObjectKey{object=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\o\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */