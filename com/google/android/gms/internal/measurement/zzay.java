package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzay
  extends zzaw
{
  public zzay()
  {
    this.zza.add(zzbl.zzx);
    this.zza.add(zzbl.zzL);
    this.zza.add(zzbl.zzM);
    this.zza.add(zzbl.zzN);
    this.zza.add(zzbl.zzO);
    this.zza.add(zzbl.zzQ);
    this.zza.add(zzbl.zzR);
    this.zza.add(zzbl.zzW);
  }
  
  private static boolean zzc(zzap paramzzap1, zzap paramzzap2)
  {
    Object localObject = paramzzap1;
    if ((paramzzap1 instanceof zzal)) {
      localObject = new zzat(paramzzap1.zzc());
    }
    paramzzap1 = paramzzap2;
    if ((paramzzap2 instanceof zzal)) {
      paramzzap1 = new zzat(paramzzap2.zzc());
    }
    if (((localObject instanceof zzat)) && ((paramzzap1 instanceof zzat))) {
      return ((zzap)localObject).zzc().compareTo(paramzzap1.zzc()) < 0;
    }
    double d1 = ((zzap)localObject).zzd().doubleValue();
    double d2 = paramzzap1.zzd().doubleValue();
    return (!Double.isNaN(d1)) && (!Double.isNaN(d2)) && (Double.compare(d1, d2) < 0);
  }
  
  private static boolean zzd(zzap paramzzap1, zzap paramzzap2)
  {
    if (paramzzap1.getClass().equals(paramzzap2.getClass()))
    {
      if ((!(paramzzap1 instanceof zzau)) && (!(paramzzap1 instanceof zzan)))
      {
        if ((paramzzap1 instanceof zzah))
        {
          if ((!Double.isNaN(paramzzap1.zzd().doubleValue())) && (!Double.isNaN(paramzzap2.zzd().doubleValue()))) {
            return paramzzap1.zzd().equals(paramzzap2.zzd());
          }
          return false;
        }
        if ((paramzzap1 instanceof zzat)) {
          return paramzzap1.zzc().equals(paramzzap2.zzc());
        }
        if ((paramzzap1 instanceof zzaf)) {
          return paramzzap1.zze().equals(paramzzap2.zze());
        }
        return paramzzap1 == paramzzap2;
      }
      return true;
    }
    boolean bool2;
    if (((!(paramzzap1 instanceof zzau)) && (!(paramzzap1 instanceof zzan))) || ((!(paramzzap2 instanceof zzau)) && (!(paramzzap2 instanceof zzan))))
    {
      boolean bool1 = paramzzap1 instanceof zzah;
      if ((bool1) && ((paramzzap2 instanceof zzat))) {
        return zzd(paramzzap1, new zzah(paramzzap2.zzd()));
      }
      bool2 = paramzzap1 instanceof zzat;
      if ((bool2) && ((paramzzap2 instanceof zzah))) {
        return zzd(new zzah(paramzzap1.zzd()), paramzzap2);
      }
      if ((paramzzap1 instanceof zzaf)) {
        return zzd(new zzah(paramzzap1.zzd()), paramzzap2);
      }
      if ((paramzzap2 instanceof zzaf)) {
        return zzd(paramzzap1, new zzah(paramzzap2.zzd()));
      }
      if (((!bool2) && (!bool1)) || (!(paramzzap2 instanceof zzal)))
      {
        if (((paramzzap1 instanceof zzal)) && (((paramzzap2 instanceof zzat)) || ((paramzzap2 instanceof zzah)))) {
          return zzd(new zzat(paramzzap1.zzc()), paramzzap2);
        }
        return false;
      }
      paramzzap2 = new zzat(paramzzap2.zzc());
    }
    try
    {
      bool2 = zzd(paramzzap1, paramzzap2);
      return bool2;
    }
    finally {}
    return true;
  }
  
  private static boolean zze(zzap paramzzap1, zzap paramzzap2)
  {
    Object localObject = paramzzap1;
    if ((paramzzap1 instanceof zzal)) {
      localObject = new zzat(paramzzap1.zzc());
    }
    paramzzap1 = paramzzap2;
    if ((paramzzap2 instanceof zzal)) {
      paramzzap1 = new zzat(paramzzap2.zzc());
    }
    return (((localObject instanceof zzat)) && ((paramzzap1 instanceof zzat))) || ((!Double.isNaN(((zzap)localObject).zzd().doubleValue())) && (!Double.isNaN(paramzzap1.zzd().doubleValue())) && (!zzc(paramzzap1, (zzap)localObject)));
  }
  
  public final zzap zza(String paramString, zzg paramzzg, List<zzap> paramList)
  {
    zzh.zza(zzh.zze(paramString).name(), 2, paramList);
    zzap localzzap = paramzzg.zza((zzap)paramList.get(0));
    paramzzg = paramzzg.zza((zzap)paramList.get(1));
    int i = zzh.zze(paramString).ordinal();
    if (i != 23)
    {
      if (i != 48) {
        if (i != 42) {
          if (i != 43) {
            switch (i)
            {
            default: 
              return super.zzb(paramString);
            }
          }
        }
      }
      for (bool = zzh.zzf(localzzap, paramzzg);; bool = zzd(localzzap, paramzzg))
      {
        bool ^= true;
        break;
        bool = zzh.zzf(localzzap, paramzzg);
        break;
        bool = zze(paramzzg, localzzap);
        break;
        bool = zzc(paramzzg, localzzap);
        break;
        bool = zze(localzzap, paramzzg);
        break;
        bool = zzc(localzzap, paramzzg);
        break;
      }
    }
    boolean bool = zzd(localzzap, paramzzg);
    if (bool) {
      paramString = zzap.zzk;
    } else {
      paramString = zzap.zzl;
    }
    return paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */