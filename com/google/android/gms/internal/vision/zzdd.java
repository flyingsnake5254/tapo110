package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdd<T>
  implements zzcz<T>, Serializable
{
  @NullableDecl
  private final T zzlx;
  
  zzdd(@NullableDecl T paramT)
  {
    this.zzlx = paramT;
  }
  
  public final boolean equals(@NullableDecl Object paramObject)
  {
    if ((paramObject instanceof zzdd))
    {
      paramObject = (zzdd)paramObject;
      return zzct.equal(this.zzlx, ((zzdd)paramObject).zzlx);
    }
    return false;
  }
  
  public final T get()
  {
    return (T)this.zzlx;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.zzlx });
  }
  
  public final String toString()
  {
    String str = String.valueOf(this.zzlx);
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 22);
    localStringBuilder.append("Suppliers.ofInstance(");
    localStringBuilder.append(str);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */