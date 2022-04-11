package com.google.android.gms.internal.vision;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzgi
{
  private static volatile boolean zztk = false;
  private static boolean zztl = true;
  private static volatile zzgi zztm;
  private static volatile zzgi zztn;
  private static final zzgi zzto = new zzgi(true);
  private final Map<zza, zzgx.zzg<?, ?>> zztp;
  
  zzgi()
  {
    this.zztp = new HashMap();
  }
  
  private zzgi(boolean paramBoolean)
  {
    this.zztp = Collections.emptyMap();
  }
  
  public static zzgi zzfl()
  {
    return new zzgi();
  }
  
  public static zzgi zzfm()
  {
    zzgi localzzgi1 = zztm;
    zzgi localzzgi2 = localzzgi1;
    if (localzzgi1 == null) {
      try
      {
        localzzgi1 = zztm;
        localzzgi2 = localzzgi1;
        if (localzzgi1 == null)
        {
          localzzgi2 = zzto;
          zztm = localzzgi2;
        }
      }
      finally {}
    }
    return localzzgi3;
  }
  
  public static zzgi zzfn()
  {
    zzgi localzzgi = zztn;
    if (localzzgi != null) {
      return localzzgi;
    }
    try
    {
      localzzgi = zztn;
      if (localzzgi != null) {
        return localzzgi;
      }
      localzzgi = zzgw.zzc(zzgi.class);
      zztn = localzzgi;
      return localzzgi;
    }
    finally {}
  }
  
  public final <ContainingType extends zzih> zzgx.zzg<ContainingType, ?> zza(ContainingType paramContainingType, int paramInt)
  {
    return (zzgx.zzg)this.zztp.get(new zza(paramContainingType, paramInt));
  }
  
  public final void zza(zzgx.zzg<?, ?> paramzzg)
  {
    this.zztp.put(new zza(paramzzg.zzxo, paramzzg.zzxq.number), paramzzg);
  }
  
  static final class zza
  {
    private final int number;
    private final Object object;
    
    zza(Object paramObject, int paramInt)
    {
      this.object = paramObject;
      this.number = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zza)) {
        return false;
      }
      paramObject = (zza)paramObject;
      return (this.object == ((zza)paramObject).object) && (this.number == ((zza)paramObject).number);
    }
    
    public final int hashCode()
    {
      return System.identityHashCode(this.object) * 65535 + this.number;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzgi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */