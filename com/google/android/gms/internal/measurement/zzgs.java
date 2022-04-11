package com.google.android.gms.internal.measurement;

public enum zzgs
  implements zzkf
{
  private static final zzkg<zzgs> zzf = new zzgq();
  private final int zzg;
  
  static
  {
    zzgs localzzgs1 = new zzgs("UNKNOWN", 0, 0);
    zza = localzzgs1;
    zzgs localzzgs2 = new zzgs("STRING", 1, 1);
    zzb = localzzgs2;
    zzgs localzzgs3 = new zzgs("NUMBER", 2, 2);
    zzc = localzzgs3;
    zzgs localzzgs4 = new zzgs("BOOLEAN", 3, 3);
    zzd = localzzgs4;
    zzgs localzzgs5 = new zzgs("STATEMENT", 4, 4);
    zze = localzzgs5;
    zzh = new zzgs[] { localzzgs1, localzzgs2, localzzgs3, localzzgs4, localzzgs5 };
  }
  
  private zzgs(int paramInt)
  {
    this.zzg = paramInt;
  }
  
  public static zzgs zza(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return null;
            }
            return zze;
          }
          return zzd;
        }
        return zzc;
      }
      return zzb;
    }
    return zza;
  }
  
  public static zzkh zzb()
  {
    return zzgr.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzgs.class.getName());
    localStringBuilder.append('@');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" number=");
    localStringBuilder.append(this.zzg);
    localStringBuilder.append(" name=");
    localStringBuilder.append(name());
    localStringBuilder.append('>');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */