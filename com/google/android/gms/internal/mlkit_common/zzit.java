package com.google.android.gms.internal.mlkit_common;

public enum zzit
  implements zzfb
{
  private static final zzfe<zzit> zzd = new zzis();
  private final int zze;
  
  static
  {
    zzit localzzit1 = new zzit("UNKNOWN_EVENT_TYPE", 0, 0);
    zza = localzzit1;
    zzit localzzit2 = new zzit("VALIDATION_TEST", 1, 1);
    zzb = localzzit2;
    zzit localzzit3 = new zzit("CONTINUOUS_FEEDBACK", 2, 2);
    zzc = localzzit3;
    zzf = new zzit[] { localzzit1, localzzit2, localzzit3 };
  }
  
  private zzit(int paramInt)
  {
    this.zze = paramInt;
  }
  
  public static zzfd zzb()
  {
    return zziu.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzit.class.getName());
    localStringBuilder.append('@');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" number=");
    localStringBuilder.append(this.zze);
    localStringBuilder.append(" name=");
    localStringBuilder.append(name());
    localStringBuilder.append('>');
    return localStringBuilder.toString();
  }
  
  public final int zza()
  {
    return this.zze;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */