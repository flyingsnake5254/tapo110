package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

public abstract interface zzap
{
  public static final zzap zzf = new zzau();
  public static final zzap zzg = new zzan();
  public static final zzap zzh = new zzag("continue");
  public static final zzap zzi = new zzag("break");
  public static final zzap zzj = new zzag("return");
  public static final zzap zzk = new zzaf(Boolean.TRUE);
  public static final zzap zzl = new zzaf(Boolean.FALSE);
  public static final zzap zzm = new zzat("");
  
  public abstract zzap zzbK(String paramString, zzg paramzzg, List<zzap> paramList);
  
  public abstract String zzc();
  
  public abstract Double zzd();
  
  public abstract Boolean zze();
  
  public abstract Iterator<zzap> zzf();
  
  public abstract zzap zzt();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */