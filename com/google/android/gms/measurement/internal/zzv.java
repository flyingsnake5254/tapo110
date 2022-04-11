package com.google.android.gms.measurement.internal;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzej;
import com.google.android.gms.internal.measurement.zzel;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzv
  extends zzw
{
  private final zzej zzh;
  
  zzv(zzy paramzzy, String paramString, int paramInt, zzej paramzzej)
  {
    super(paramString, paramInt);
    this.zzh = paramzzej;
  }
  
  final int zza()
  {
    return this.zzh.zzb();
  }
  
  final boolean zzb()
  {
    return false;
  }
  
  final boolean zzc()
  {
    return this.zzh.zzg();
  }
  
  final boolean zzd(Long paramLong1, Long paramLong2, zzfo paramzzfo, long paramLong, zzao paramzzao, boolean paramBoolean)
  {
    zzog.zzb();
    boolean bool1 = this.zza.zzs.zzc().zzn(this.zzb, zzea.zzZ);
    if (this.zzh.zzm()) {
      paramLong = paramzzao.zze;
    }
    boolean bool2 = Log.isLoggable(this.zza.zzs.zzau().zzn(), 2);
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4;
    int i;
    if (bool2)
    {
      localObject4 = this.zza.zzs.zzau().zzk();
      i = this.zzc;
      if (this.zzh.zza()) {
        paramzzao = Integer.valueOf(this.zzh.zzb());
      } else {
        paramzzao = null;
      }
      ((zzek)localObject4).zzd("Evaluating filter. audience, filter, event", Integer.valueOf(i), paramzzao, this.zza.zzs.zzm().zzc(this.zzh.zzc()));
      this.zza.zzs.zzau().zzk().zzb("Filter definition", this.zza.zzf.zzm().zzi(this.zzh));
    }
    if ((this.zzh.zza()) && (this.zzh.zzb() <= 256))
    {
      bool2 = this.zzh.zzi();
      boolean bool3 = this.zzh.zzj();
      boolean bool4 = this.zzh.zzm();
      if ((!bool2) && (!bool3) && (!bool4)) {
        i = 0;
      } else {
        i = 1;
      }
      if ((paramBoolean) && (i == 0))
      {
        paramLong2 = this.zza.zzs.zzau().zzk();
        i = this.zzc;
        paramLong1 = (Long)localObject3;
        if (this.zzh.zza()) {
          paramLong1 = Integer.valueOf(this.zzh.zzb());
        }
        paramLong2.zzc("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(i), paramLong1);
        return true;
      }
      localObject4 = this.zzh;
      localObject2 = paramzzfo.zzd();
      if (((zzej)localObject4).zzg())
      {
        paramzzao = zzw.zzg(paramLong, ((zzej)localObject4).zzh());
        if (paramzzao == null)
        {
          paramzzao = (zzao)localObject1;
          break label1477;
        }
        if (!paramzzao.booleanValue())
        {
          paramzzao = Boolean.FALSE;
          break label1477;
        }
      }
      Object localObject5 = new HashSet();
      paramzzao = ((zzej)localObject4).zzd().iterator();
      while (paramzzao.hasNext())
      {
        localObject3 = (zzel)paramzzao.next();
        if (((zzel)localObject3).zzh().isEmpty())
        {
          this.zza.zzs.zzau().zze().zzb("null or empty param name in filter. event", this.zza.zzs.zzm().zzc((String)localObject2));
          paramzzao = (zzao)localObject1;
          break label1477;
        }
        ((Set)localObject5).add(((zzel)localObject3).zzh());
      }
      localObject3 = new ArrayMap();
      Object localObject6 = paramzzfo.zza().iterator();
      while (((Iterator)localObject6).hasNext())
      {
        paramzzao = (zzfs)((Iterator)localObject6).next();
        if (((Set)localObject5).contains(paramzzao.zzb()))
        {
          String str;
          if (paramzzao.zze())
          {
            str = paramzzao.zzb();
            if (paramzzao.zze()) {
              paramzzao = Long.valueOf(paramzzao.zzf());
            } else {
              paramzzao = null;
            }
            ((Map)localObject3).put(str, paramzzao);
          }
          else if (paramzzao.zzi())
          {
            str = paramzzao.zzb();
            if (paramzzao.zzi()) {
              paramzzao = Double.valueOf(paramzzao.zzj());
            } else {
              paramzzao = null;
            }
            ((Map)localObject3).put(str, paramzzao);
          }
          else if (paramzzao.zzc())
          {
            ((Map)localObject3).put(paramzzao.zzb(), paramzzao.zzd());
          }
          else
          {
            this.zza.zzs.zzau().zze().zzc("Unknown value for param. event, param", this.zza.zzs.zzm().zzc((String)localObject2), this.zza.zzs.zzm().zzd(paramzzao.zzb()));
            paramzzao = (zzao)localObject1;
            break label1477;
          }
        }
      }
      localObject4 = ((zzej)localObject4).zzd().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        paramzzao = (zzel)((Iterator)localObject4).next();
        if ((paramzzao.zze()) && (paramzzao.zzf())) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        localObject5 = paramzzao.zzh();
        if (((String)localObject5).isEmpty())
        {
          this.zza.zzs.zzau().zze().zzb("Event has empty param name. event", this.zza.zzs.zzm().zzc((String)localObject2));
          paramzzao = (zzao)localObject1;
          break label1477;
        }
        localObject6 = ((Map)localObject3).get(localObject5);
        if ((localObject6 instanceof Long))
        {
          if (!paramzzao.zzc())
          {
            this.zza.zzs.zzau().zze().zzc("No number filter for long param. event, param", this.zza.zzs.zzm().zzc((String)localObject2), this.zza.zzs.zzm().zzd((String)localObject5));
            paramzzao = (zzao)localObject1;
            break label1477;
          }
          paramzzao = zzw.zzg(((Long)localObject6).longValue(), paramzzao.zzd());
          if (paramzzao == null)
          {
            paramzzao = (zzao)localObject1;
            break label1477;
          }
          if (paramzzao.booleanValue() == paramBoolean)
          {
            paramzzao = Boolean.FALSE;
            break label1477;
          }
        }
        else if ((localObject6 instanceof Double))
        {
          if (!paramzzao.zzc())
          {
            this.zza.zzs.zzau().zze().zzc("No number filter for double param. event, param", this.zza.zzs.zzm().zzc((String)localObject2), this.zza.zzs.zzm().zzd((String)localObject5));
            paramzzao = (zzao)localObject1;
            break label1477;
          }
          paramzzao = zzw.zzh(((Double)localObject6).doubleValue(), paramzzao.zzd());
          if (paramzzao == null)
          {
            paramzzao = (zzao)localObject1;
            break label1477;
          }
          if (paramzzao.booleanValue() == paramBoolean)
          {
            paramzzao = Boolean.FALSE;
            break label1477;
          }
        }
        else if ((localObject6 instanceof String))
        {
          if (paramzzao.zza())
          {
            paramzzao = zzw.zzf((String)localObject6, paramzzao.zzb(), this.zza.zzs.zzau());
          }
          else
          {
            if (!paramzzao.zzc()) {
              break label1298;
            }
            localObject6 = (String)localObject6;
            if (!zzkp.zzl((String)localObject6)) {
              break label1242;
            }
            paramzzao = zzw.zzi((String)localObject6, paramzzao.zzd());
          }
          if (paramzzao == null)
          {
            paramzzao = (zzao)localObject1;
            break label1477;
          }
          if (paramzzao.booleanValue() == paramBoolean)
          {
            paramzzao = Boolean.FALSE;
            break label1477;
            label1242:
            this.zza.zzs.zzau().zze().zzc("Invalid param value for number filter. event, param", this.zza.zzs.zzm().zzc((String)localObject2), this.zza.zzs.zzm().zzd((String)localObject5));
            paramzzao = (zzao)localObject1;
            break label1477;
            label1298:
            this.zza.zzs.zzau().zze().zzc("No filter for String param. event, param", this.zza.zzs.zzm().zzc((String)localObject2), this.zza.zzs.zzm().zzd((String)localObject5));
            paramzzao = (zzao)localObject1;
            break label1477;
          }
        }
        else
        {
          if (localObject6 == null)
          {
            this.zza.zzs.zzau().zzk().zzc("Missing param for filter. event, param", this.zza.zzs.zzm().zzc((String)localObject2), this.zza.zzs.zzm().zzd((String)localObject5));
            paramzzao = Boolean.FALSE;
            break label1477;
          }
          this.zza.zzs.zzau().zze().zzc("Unknown param type. event, param", this.zza.zzs.zzm().zzc((String)localObject2), this.zza.zzs.zzm().zzd((String)localObject5));
          paramzzao = (zzao)localObject1;
          break label1477;
        }
      }
      paramzzao = Boolean.TRUE;
      label1477:
      localObject2 = this.zza.zzs.zzau().zzk();
      if (paramzzao == null) {
        localObject1 = "null";
      } else {
        localObject1 = paramzzao;
      }
      ((zzek)localObject2).zzb("Event filter result", localObject1);
      if (paramzzao == null) {
        return false;
      }
      localObject1 = Boolean.TRUE;
      this.zzd = ((Boolean)localObject1);
      if (!paramzzao.booleanValue()) {
        return true;
      }
      this.zze = ((Boolean)localObject1);
      if ((i != 0) && (paramzzfo.zze()))
      {
        paramzzfo = Long.valueOf(paramzzfo.zzf());
        if (this.zzh.zzj())
        {
          paramLong2 = paramzzfo;
          if (bool1) {
            if (!this.zzh.zzg()) {
              paramLong2 = paramzzfo;
            } else {
              paramLong2 = paramLong1;
            }
          }
          this.zzg = paramLong2;
        }
        else
        {
          paramLong1 = paramzzfo;
          if (bool1)
          {
            paramLong1 = paramzzfo;
            if (this.zzh.zzg()) {
              paramLong1 = paramLong2;
            }
          }
          this.zzf = paramLong1;
        }
      }
      return true;
    }
    paramzzfo = this.zza.zzs.zzau().zze();
    paramLong2 = zzem.zzl(this.zzb);
    paramLong1 = (Long)localObject2;
    if (this.zzh.zza()) {
      paramLong1 = Integer.valueOf(this.zzh.zzb());
    }
    paramzzfo.zzc("Invalid event filter ID. appId, id", paramLong2, String.valueOf(paramLong1));
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */