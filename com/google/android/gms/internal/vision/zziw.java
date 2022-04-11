package com.google.android.gms.internal.vision;

import java.io.IOException;

abstract interface zziw<T>
{
  public abstract boolean equals(T paramT1, T paramT2);
  
  public abstract int hashCode(T paramT);
  
  public abstract T newInstance();
  
  public abstract void zza(T paramT, zzix paramzzix, zzgi paramzzgi)
    throws IOException;
  
  public abstract void zza(T paramT, zzkl paramzzkl)
    throws IOException;
  
  public abstract void zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzfg paramzzfg)
    throws IOException;
  
  public abstract void zzd(T paramT1, T paramT2);
  
  public abstract void zzh(T paramT);
  
  public abstract int zzs(T paramT);
  
  public abstract boolean zzu(T paramT);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zziw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */