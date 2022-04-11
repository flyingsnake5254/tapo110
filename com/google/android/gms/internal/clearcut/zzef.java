package com.google.android.gms.internal.clearcut;

import java.io.IOException;

abstract interface zzef<T>
{
  public abstract boolean equals(T paramT1, T paramT2);
  
  public abstract int hashCode(T paramT);
  
  public abstract T newInstance();
  
  public abstract void zza(T paramT, zzfr paramzzfr)
    throws IOException;
  
  public abstract void zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzay paramzzay)
    throws IOException;
  
  public abstract void zzc(T paramT);
  
  public abstract void zzc(T paramT1, T paramT2);
  
  public abstract int zzm(T paramT);
  
  public abstract boolean zzo(T paramT);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */