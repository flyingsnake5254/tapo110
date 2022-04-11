package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzif
{
  public static <T> zzib<T> zza(zzib<T> paramzzib)
  {
    if ((!(paramzzib instanceof zzid)) && (!(paramzzib instanceof zzic)))
    {
      if ((paramzzib instanceof Serializable)) {
        paramzzib = new zzic(paramzzib);
      } else {
        paramzzib = new zzid(paramzzib);
      }
      return paramzzib;
    }
    return paramzzib;
  }
  
  public static <T> zzib<T> zzb(@NullableDecl T paramT)
  {
    return new zzie(paramT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzif.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */