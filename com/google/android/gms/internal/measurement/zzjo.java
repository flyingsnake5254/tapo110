package com.google.android.gms.internal.measurement;

final class zzjo
{
  private final Object zza;
  private final int zzb;
  
  zzjo(Object paramObject, int paramInt)
  {
    this.zza = paramObject;
    this.zzb = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzjo)) {
      return false;
    }
    paramObject = (zzjo)paramObject;
    return (this.zza == ((zzjo)paramObject).zza) && (this.zzb == ((zzjo)paramObject).zzb);
  }
  
  public final int hashCode()
  {
    return System.identityHashCode(this.zza) * 65535 + this.zzb;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzjo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */