package com.airbnb.lottie;

import androidx.annotation.Nullable;
import java.util.Arrays;

public final class l<V>
{
  @Nullable
  private final V a;
  @Nullable
  private final Throwable b;
  
  public l(V paramV)
  {
    this.a = paramV;
    this.b = null;
  }
  
  public l(Throwable paramThrowable)
  {
    this.b = paramThrowable;
    this.a = null;
  }
  
  @Nullable
  public Throwable a()
  {
    return this.b;
  }
  
  @Nullable
  public V b()
  {
    return (V)this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof l)) {
      return false;
    }
    paramObject = (l)paramObject;
    if ((b() != null) && (b().equals(((l)paramObject).b()))) {
      return true;
    }
    if ((a() != null) && (((l)paramObject).a() != null)) {
      return a().toString().equals(a().toString());
    }
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { b(), a() });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */