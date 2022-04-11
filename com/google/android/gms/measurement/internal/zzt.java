package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzfk;
import com.google.android.gms.internal.measurement.zzfl;
import com.google.android.gms.internal.measurement.zzfm;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzge;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzjz;
import com.google.android.gms.internal.measurement.zzog;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzt
{
  private String zzb;
  private boolean zzc;
  private zzgd zzd;
  private BitSet zze;
  private BitSet zzf;
  private Map<Integer, Long> zzg;
  private Map<Integer, List<Long>> zzh;
  
  final void zza(@NonNull zzw paramzzw)
  {
    int i = paramzzw.zza();
    Object localObject1 = paramzzw.zzd;
    if (localObject1 != null) {
      this.zzf.set(i, ((Boolean)localObject1).booleanValue());
    }
    localObject1 = paramzzw.zze;
    if (localObject1 != null) {
      this.zze.set(i, ((Boolean)localObject1).booleanValue());
    }
    Object localObject2;
    if (paramzzw.zzf != null)
    {
      localObject2 = this.zzg;
      localObject1 = Integer.valueOf(i);
      localObject2 = (Long)((Map)localObject2).get(localObject1);
      long l = paramzzw.zzf.longValue() / 1000L;
      if ((localObject2 == null) || (l > ((Long)localObject2).longValue())) {
        this.zzg.put(localObject1, Long.valueOf(l));
      }
    }
    if (paramzzw.zzg != null)
    {
      localObject1 = this.zzh;
      Object localObject3 = Integer.valueOf(i);
      localObject2 = (List)((Map)localObject1).get(localObject3);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        this.zzh.put(localObject3, localObject1);
      }
      if (paramzzw.zzb()) {
        ((List)localObject1).clear();
      }
      zzog.zzb();
      localObject3 = this.zza.zzs.zzc();
      localObject2 = this.zzb;
      zzdz localzzdz = zzea.zzZ;
      if ((((zzae)localObject3).zzn((String)localObject2, localzzdz)) && (paramzzw.zzc())) {
        ((List)localObject1).clear();
      }
      zzog.zzb();
      if (this.zza.zzs.zzc().zzn(this.zzb, localzzdz))
      {
        paramzzw = Long.valueOf(paramzzw.zzg.longValue() / 1000L);
        if (!((List)localObject1).contains(paramzzw)) {
          ((List)localObject1).add(paramzzw);
        }
      }
      else
      {
        ((List)localObject1).add(Long.valueOf(paramzzw.zzg.longValue() / 1000L));
      }
    }
  }
  
  @NonNull
  final zzfk zzb(int paramInt)
  {
    zzfj localzzfj = zzfk.zzh();
    localzzfj.zza(paramInt);
    localzzfj.zzd(this.zzc);
    Object localObject1 = this.zzd;
    if (localObject1 != null) {
      localzzfj.zzc((zzgd)localObject1);
    }
    zzgc localzzgc = zzgd.zzk();
    localzzgc.zzc(zzkp.zzn(this.zze));
    localzzgc.zza(zzkp.zzn(this.zzf));
    localObject1 = this.zzg;
    Iterator localIterator;
    Object localObject2;
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = null;
    }
    else
    {
      localObject1 = new ArrayList(((Map)localObject1).size());
      localIterator = this.zzg.keySet().iterator();
      while (localIterator.hasNext())
      {
        paramInt = ((Integer)localIterator.next()).intValue();
        localObject2 = (Long)this.zzg.get(Integer.valueOf(paramInt));
        if (localObject2 != null)
        {
          localObject3 = zzfm.zze();
          ((zzfl)localObject3).zza(paramInt);
          ((zzfl)localObject3).zzb(((Long)localObject2).longValue());
          ((ArrayList)localObject1).add((zzfm)((zzjz)localObject3).zzaA());
        }
      }
    }
    if (localObject1 != null) {
      localzzgc.zze((Iterable)localObject1);
    }
    localObject1 = this.zzh;
    if (localObject1 == null)
    {
      localObject1 = Collections.emptyList();
    }
    else
    {
      localObject1 = new ArrayList(((Map)localObject1).size());
      localIterator = this.zzh.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (Integer)localIterator.next();
        localObject2 = zzgf.zzf();
        ((zzge)localObject2).zza(((Integer)localObject3).intValue());
        localObject3 = (List)this.zzh.get(localObject3);
        if (localObject3 != null)
        {
          Collections.sort((List)localObject3);
          ((zzge)localObject2).zzb((Iterable)localObject3);
        }
        ((ArrayList)localObject1).add((zzgf)((zzjz)localObject2).zzaA());
      }
    }
    localzzgc.zzg((Iterable)localObject1);
    localzzfj.zzb(localzzgc);
    return (zzfk)localzzfj.zzaA();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */