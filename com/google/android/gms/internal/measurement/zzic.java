package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzic<T>
  implements Serializable, zzib
{
  final zzib<T> zza;
  volatile transient boolean zzb;
  @NullableDecl
  transient T zzc;
  
  zzic(zzib<T> paramzzib)
  {
    Objects.requireNonNull(paramzzib);
    this.zza = paramzzib;
  }
  
  public final String toString()
  {
    if (this.zzb)
    {
      localObject = String.valueOf(this.zzc);
      localStringBuilder = new StringBuilder(((String)localObject).length() + 25);
      localStringBuilder.append("<supplier that returned ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(">");
      localObject = localStringBuilder.toString();
    }
    else
    {
      localObject = this.zza;
    }
    Object localObject = String.valueOf(localObject);
    StringBuilder localStringBuilder = new StringBuilder(((String)localObject).length() + 19);
    localStringBuilder.append("Suppliers.memoize(");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public final T zza()
  {
    if (!this.zzb) {
      try
      {
        if (!this.zzb)
        {
          Object localObject1 = this.zza.zza();
          this.zzc = localObject1;
          this.zzb = true;
          return (T)localObject1;
        }
      }
      finally {}
    }
    return (T)this.zzc;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */