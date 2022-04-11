package com.google.android.gms.internal.measurement;

public enum zzga
  implements zzkf
{
  private static final zzkg<zzga> zzc = new zzfy();
  private final int zzd;
  
  static
  {
    zzga localzzga1 = new zzga("RADS", 0, 1);
    zza = localzzga1;
    zzga localzzga2 = new zzga("PROVISIONING", 1, 2);
    zzb = localzzga2;
    zze = new zzga[] { localzzga1, localzzga2 };
  }
  
  private zzga(int paramInt)
  {
    this.zzd = paramInt;
  }
  
  public static zzga zza(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return null;
      }
      return zzb;
    }
    return zza;
  }
  
  public static zzkh zzb()
  {
    return zzfz.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzga.class.getName());
    localStringBuilder.append('@');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" number=");
    localStringBuilder.append(this.zzd);
    localStringBuilder.append(" name=");
    localStringBuilder.append(name());
    localStringBuilder.append('>');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */