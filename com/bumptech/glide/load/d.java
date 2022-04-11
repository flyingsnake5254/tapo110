package com.bumptech.glide.load;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class d<T>
  implements i<T>
{
  private final Collection<? extends i<T>> b;
  
  @SafeVarargs
  public d(@NonNull i<T>... paramVarArgs)
  {
    if (paramVarArgs.length != 0)
    {
      this.b = Arrays.asList(paramVarArgs);
      return;
    }
    throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
  }
  
  @NonNull
  public u<T> a(@NonNull Context paramContext, @NonNull u<T> paramu, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.b.iterator();
    u localu;
    for (Object localObject = paramu; localIterator.hasNext(); localObject = localu)
    {
      localu = ((i)localIterator.next()).a(paramContext, (u)localObject, paramInt1, paramInt2);
      if ((localObject != null) && (!localObject.equals(paramu)) && (!localObject.equals(localu))) {
        ((u)localObject).c();
      }
    }
    return (u<T>)localObject;
  }
  
  public void b(@NonNull MessageDigest paramMessageDigest)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).b(paramMessageDigest);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof d))
    {
      paramObject = (d)paramObject;
      return this.b.equals(((d)paramObject).b);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */