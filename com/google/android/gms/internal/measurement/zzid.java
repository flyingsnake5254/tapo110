package com.google.android.gms.internal.measurement;

import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzid<T>
  implements zzib<T>
{
  volatile zzib<T> zza;
  volatile boolean zzb;
  @NullableDecl
  T zzc;
  
  zzid(zzib<T> paramzzib)
  {
    Objects.requireNonNull(paramzzib);
    this.zza = paramzzib;
  }
  
  public final String toString()
  {
    Object localObject1 = this.zza;
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = String.valueOf(this.zzc);
      localObject2 = new StringBuilder(((String)localObject1).length() + 25);
      ((StringBuilder)localObject2).append("<supplier that returned ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(">");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localObject2 = String.valueOf(localObject2);
    localObject1 = new StringBuilder(((String)localObject2).length() + 19);
    ((StringBuilder)localObject1).append("Suppliers.memoize(");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(")");
    return ((StringBuilder)localObject1).toString();
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
          this.zza = null;
          return (T)localObject1;
        }
      }
      finally {}
    }
    return (T)this.zzc;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */