package com.google.android.gms.internal.vision;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzdc
{
  public static <T> zzcz<T> zza(zzcz<T> paramzzcz)
  {
    if ((!(paramzzcz instanceof zzde)) && (!(paramzzcz instanceof zzdb)))
    {
      if ((paramzzcz instanceof Serializable)) {
        return new zzdb(paramzzcz);
      }
      return new zzde(paramzzcz);
    }
    return paramzzcz;
  }
  
  public static <T> zzcz<T> zze(@NullableDecl T paramT)
  {
    return new zzdd(paramT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzdc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */