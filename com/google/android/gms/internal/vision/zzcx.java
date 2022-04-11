package com.google.android.gms.internal.vision;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzcx<T>
  extends zzcs<T>
{
  private final T zzlu;
  
  zzcx(T paramT)
  {
    this.zzlu = paramT;
  }
  
  public final boolean equals(@NullableDecl Object paramObject)
  {
    if ((paramObject instanceof zzcx))
    {
      paramObject = (zzcx)paramObject;
      return this.zzlu.equals(((zzcx)paramObject).zzlu);
    }
    return false;
  }
  
  public final T get()
  {
    return (T)this.zzlu;
  }
  
  public final int hashCode()
  {
    return this.zzlu.hashCode() + 1502476572;
  }
  
  public final boolean isPresent()
  {
    return true;
  }
  
  public final String toString()
  {
    String str = String.valueOf(this.zzlu);
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 13);
    localStringBuilder.append("Optional.of(");
    localStringBuilder.append(str);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzcx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */