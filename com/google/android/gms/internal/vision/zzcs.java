package com.google.android.gms.internal.vision;

import java.io.Serializable;

public abstract class zzcs<T>
  implements Serializable
{
  public static <T> zzcs<T> zzby()
  {
    return zzcp.zzls;
  }
  
  public static <T> zzcs<T> zzc(T paramT)
  {
    return new zzcx(zzcy.checkNotNull(paramT));
  }
  
  public abstract T get();
  
  public abstract boolean isPresent();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */