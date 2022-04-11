package com.google.android.gms.internal.vision;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzcp<T>
  extends zzcs<T>
{
  static final zzcp<Object> zzls = new zzcp();
  
  public final boolean equals(@NullableDecl Object paramObject)
  {
    return paramObject == this;
  }
  
  public final T get()
  {
    throw new IllegalStateException("Optional.get() cannot be called on an absent value");
  }
  
  public final int hashCode()
  {
    return 2040732332;
  }
  
  public final boolean isPresent()
  {
    return false;
  }
  
  public final String toString()
  {
    return "Optional.absent()";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzcp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */