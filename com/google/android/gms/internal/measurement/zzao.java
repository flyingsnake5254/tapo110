package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzao
  extends zzai
  implements zzal
{
  protected final List<String> zza;
  protected final List<zzap> zzb;
  protected zzg zzc;
  
  private zzao(zzao paramzzao)
  {
    super(paramzzao.zzd);
    ArrayList localArrayList = new ArrayList(paramzzao.zza.size());
    this.zza = localArrayList;
    localArrayList.addAll(paramzzao.zza);
    localArrayList = new ArrayList(paramzzao.zzb.size());
    this.zzb = localArrayList;
    localArrayList.addAll(paramzzao.zzb);
    this.zzc = paramzzao.zzc;
  }
  
  public zzao(String paramString, List<zzap> paramList1, List<zzap> paramList2, zzg paramzzg)
  {
    super(paramString);
    this.zza = new ArrayList();
    this.zzc = paramzzg;
    if (!paramList1.isEmpty())
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString = (zzap)paramList1.next();
        this.zza.add(paramString.zzc());
      }
    }
    this.zzb = new ArrayList(paramList2);
  }
  
  public final zzap zza(zzg paramzzg, List<zzap> paramList)
  {
    zzg localzzg = this.zzc.zzc();
    for (int i = 0; i < this.zza.size(); i++) {
      if (i < paramList.size()) {
        localzzg.zzf((String)this.zza.get(i), paramzzg.zza((zzap)paramList.get(i)));
      } else {
        localzzg.zzf((String)this.zza.get(i), zzap.zzf);
      }
    }
    Iterator localIterator = this.zzb.iterator();
    while (localIterator.hasNext())
    {
      zzap localzzap = (zzap)localIterator.next();
      paramList = localzzg.zza(localzzap);
      paramzzg = paramList;
      if ((paramList instanceof zzaq)) {
        paramzzg = localzzg.zza(localzzap);
      }
      if ((paramzzg instanceof zzag)) {
        return ((zzag)paramzzg).zzb();
      }
    }
    return zzap.zzf;
  }
  
  public final zzap zzt()
  {
    return new zzao(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */