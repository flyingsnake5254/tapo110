package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class zzbb
{
  public static zzap zza(String paramString, zzae paramzzae, zzg paramzzg, List<zzap> paramList)
  {
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      break;
      if (paramString.equals("indexOf"))
      {
        i = 4;
        if (paramString.equals("reverse"))
        {
          i = 12;
          if (paramString.equals("reduceRight"))
          {
            i = 11;
            if (paramString.equals("slice"))
            {
              i = 14;
              if (paramString.equals("shift"))
              {
                i = 13;
                if (paramString.equals("every"))
                {
                  i = 1;
                  break label496;
                  if (paramString.equals("sort"))
                  {
                    i = 16;
                    if (paramString.equals("some"))
                    {
                      i = 15;
                      if (paramString.equals("push"))
                      {
                        i = 9;
                        if (paramString.equals("join"))
                        {
                          i = 5;
                          if (paramString.equals("pop"))
                          {
                            i = 8;
                            if (paramString.equals("map"))
                            {
                              i = 7;
                              if (paramString.equals("unshift"))
                              {
                                i = 19;
                                if (paramString.equals("lastIndexOf"))
                                {
                                  i = 6;
                                  if (paramString.equals("forEach"))
                                  {
                                    i = 3;
                                    if (paramString.equals("splice"))
                                    {
                                      i = 17;
                                      if (paramString.equals("reduce"))
                                      {
                                        i = 10;
                                        break label496;
                                        if (paramString.equals("filter"))
                                        {
                                          i = 2;
                                          break label496;
                                          if (paramString.equals("concat"))
                                          {
                                            i = 0;
                                            break label496;
                                            if (paramString.equals("toString"))
                                            {
                                              i = 18;
                                              break label496;
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    int i = -1;
    label496:
    double d1 = 0.0D;
    Object localObject;
    int j;
    int k;
    label1137:
    label1423:
    double d3;
    switch (i)
    {
    default: 
      throw new IllegalArgumentException("Command not supported");
    case 19: 
      if (!paramList.isEmpty())
      {
        paramString = new zzae();
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramList = paramzzg.zza((zzap)((Iterator)localObject).next());
          if (!(paramList instanceof zzag)) {
            paramString.zzn(paramString.zzh(), paramList);
          } else {
            throw new IllegalStateException("Argument evaluation failed");
          }
        }
        i = paramString.zzh();
        paramList = paramzzae.zzg();
        while (paramList.hasNext())
        {
          paramzzg = (Integer)paramList.next();
          paramString.zzn(paramzzg.intValue() + i, paramzzae.zzl(paramzzg.intValue()));
        }
        paramzzae.zzp();
        paramList = paramString.zzg();
        while (paramList.hasNext())
        {
          paramzzg = (Integer)paramList.next();
          paramzzae.zzn(paramzzg.intValue(), paramString.zzl(paramzzg.intValue()));
        }
      }
      return new zzah(Double.valueOf(paramzzae.zzh()));
    case 18: 
      zzh.zza("toString", 0, paramList);
      return new zzat(paramzzae.zzs(","));
    case 17: 
      if (paramList.isEmpty())
      {
        paramString = new zzae();
      }
      else
      {
        j = (int)zzh.zzi(paramzzg.zza((zzap)paramList.get(0)).zzd().doubleValue());
        if (j < 0)
        {
          i = Math.max(0, j + paramzzae.zzh());
        }
        else
        {
          i = j;
          if (j > paramzzae.zzh()) {
            i = paramzzae.zzh();
          }
        }
        k = paramzzae.zzh();
        paramString = new zzae();
        j = i;
        if (paramList.size() > 1)
        {
          int m = Math.max(0, (int)zzh.zzi(paramzzg.zza((zzap)paramList.get(1)).zzd().doubleValue()));
          if (m > 0) {
            for (j = i; j < Math.min(k, i + m); j++)
            {
              localObject = paramzzae.zzl(i);
              paramString.zzn(paramString.zzh(), (zzap)localObject);
              paramzzae.zzr(i);
            }
          }
          if (paramList.size() > 2)
          {
            for (j = 2;; j++)
            {
              if (j >= paramList.size()) {
                break label1137;
              }
              localObject = paramzzg.zza((zzap)paramList.get(j));
              if ((localObject instanceof zzag)) {
                break;
              }
              paramzzae.zzq(i + j - 2, (zzap)localObject);
            }
            throw new IllegalArgumentException("Failed to parse elements to add");
          }
        }
        else
        {
          while (j < k)
          {
            paramzzg = paramzzae.zzl(j);
            paramString.zzn(paramString.zzh(), paramzzg);
            paramzzae.zzn(j, null);
            j++;
          }
        }
      }
      return paramString;
    case 16: 
      zzh.zzc("sort", 1, paramList);
      if (paramzzae.zzh() >= 2)
      {
        localObject = paramzzae.zzb();
        if (!paramList.isEmpty())
        {
          paramString = paramzzg.zza((zzap)paramList.get(0));
          if ((paramString instanceof zzai)) {
            paramString = (zzai)paramString;
          } else {
            throw new IllegalArgumentException("Comparator should be a method");
          }
        }
        else
        {
          paramString = null;
        }
        Collections.sort((List)localObject, new zzba(paramString, paramzzg));
        paramzzae.zzp();
        paramString = ((List)localObject).iterator();
        for (i = 0; paramString.hasNext(); i++) {
          paramzzae.zzn(i, (zzap)paramString.next());
        }
      }
      return paramzzae;
    case 15: 
      zzh.zza("some", 1, paramList);
      paramString = paramzzg.zza((zzap)paramList.get(0));
      if ((paramString instanceof zzai))
      {
        if (paramzzae.zzh() == 0)
        {
          paramString = zzap.zzl;
        }
        else
        {
          paramString = (zzai)paramString;
          paramList = paramzzae.zzg();
          while (paramList.hasNext())
          {
            i = ((Integer)paramList.next()).intValue();
            if (paramzzae.zzo(i)) {
              if (paramString.zza(paramzzg, Arrays.asList(new zzap[] { paramzzae.zzl(i), new zzah(Double.valueOf(i)), paramzzae })).zze().booleanValue())
              {
                paramString = zzap.zzk;
                break label1423;
              }
            }
          }
          paramString = zzap.zzl;
        }
        return paramString;
      }
      throw new IllegalArgumentException("Callback should be a method");
    case 14: 
      zzh.zzc("slice", 2, paramList);
      if (paramList.isEmpty())
      {
        paramString = paramzzae.zzt();
      }
      else
      {
        double d2 = paramzzae.zzh();
        d1 = zzh.zzi(paramzzg.zza((zzap)paramList.get(0)).zzd().doubleValue());
        if (d1 < 0.0D) {
          d3 = Math.max(d1 + d2, 0.0D);
        } else {
          d3 = Math.min(d1, d2);
        }
        d1 = d2;
        if (paramList.size() == 2)
        {
          d1 = zzh.zzi(paramzzg.zza((zzap)paramList.get(1)).zzd().doubleValue());
          if (d1 < 0.0D) {
            d1 = Math.max(d2 + d1, 0.0D);
          } else {
            d1 = Math.min(d2, d1);
          }
        }
        paramzzg = new zzae();
        for (i = (int)d3;; i++)
        {
          paramString = paramzzg;
          if (i >= d1) {
            break;
          }
          paramString = paramzzae.zzl(i);
          paramzzg.zzn(paramzzg.zzh(), paramString);
        }
      }
      return paramString;
    case 13: 
      zzh.zza("shift", 0, paramList);
      if (paramzzae.zzh() == 0)
      {
        paramString = zzap.zzf;
      }
      else
      {
        paramString = paramzzae.zzl(0);
        paramzzae.zzr(0);
      }
      return paramString;
    case 12: 
      zzh.zza("reverse", 0, paramList);
      j = paramzzae.zzh();
      if (j != 0) {
        for (i = 0; i < j / 2; i++) {
          if (paramzzae.zzo(i))
          {
            paramString = paramzzae.zzl(i);
            paramzzae.zzn(i, null);
            k = j - 1 - i;
            if (paramzzae.zzo(k)) {
              paramzzae.zzn(i, paramzzae.zzl(k));
            }
            paramzzae.zzn(k, paramString);
          }
        }
      }
      return paramzzae;
    case 11: 
      return zzb(paramzzae, paramzzg, paramList, false);
    case 10: 
      return zzb(paramzzae, paramzzg, paramList, true);
    case 9: 
      if (!paramList.isEmpty())
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          paramString = paramzzg.zza((zzap)paramList.next());
          paramzzae.zzn(paramzzae.zzh(), paramString);
        }
      }
      return new zzah(Double.valueOf(paramzzae.zzh()));
    case 8: 
      zzh.zza("pop", 0, paramList);
      i = paramzzae.zzh();
      if (i == 0)
      {
        paramString = zzap.zzf;
      }
      else
      {
        i--;
        paramString = paramzzae.zzl(i);
        paramzzae.zzr(i);
      }
      return paramString;
    case 7: 
      zzh.zza("map", 1, paramList);
      paramString = paramzzg.zza((zzap)paramList.get(0));
      if ((paramString instanceof zzao))
      {
        if (paramzzae.zzh() == 0) {
          paramString = new zzae();
        } else {
          paramString = zzc(paramzzae, paramzzg, (zzao)paramString, null, null);
        }
        return paramString;
      }
      throw new IllegalArgumentException("Callback should be a method");
    case 6: 
      zzh.zzc("lastIndexOf", 2, paramList);
      paramString = zzap.zzf;
      if (!paramList.isEmpty()) {
        paramString = paramzzg.zza((zzap)paramList.get(0));
      }
      d1 = paramzzae.zzh() - 1;
      if (paramList.size() > 1)
      {
        paramzzg = paramzzg.zza((zzap)paramList.get(1));
        if (Double.isNaN(paramzzg.zzd().doubleValue())) {
          d3 = paramzzae.zzh() - 1;
        } else {
          d3 = zzh.zzi(paramzzg.zzd().doubleValue());
        }
        d1 = d3;
        if (d3 < 0.0D) {
          d1 = d3 + paramzzae.zzh();
        }
      }
      if (d1 < 0.0D)
      {
        paramString = new zzah(Double.valueOf(-1.0D));
      }
      else
      {
        for (i = (int)Math.min(paramzzae.zzh(), d1); i >= 0; i--) {
          if ((paramzzae.zzo(i)) && (zzh.zzf(paramzzae.zzl(i), paramString)))
          {
            paramString = new zzah(Double.valueOf(i));
            break label2203;
          }
        }
        paramString = new zzah(Double.valueOf(-1.0D));
      }
      return paramString;
    case 5: 
      zzh.zzc("join", 1, paramList);
      if (paramzzae.zzh() == 0)
      {
        paramString = zzap.zzm;
      }
      else
      {
        if (paramList.size() > 0)
        {
          paramString = paramzzg.zza((zzap)paramList.get(0));
          if ((!(paramString instanceof zzan)) && (!(paramString instanceof zzau))) {
            paramString = paramString.zzc();
          } else {
            paramString = "";
          }
        }
        else
        {
          paramString = ",";
        }
        paramString = new zzat(paramzzae.zzs(paramString));
      }
      return paramString;
    case 4: 
      zzh.zzc("indexOf", 2, paramList);
      paramString = zzap.zzf;
      if (!paramList.isEmpty()) {
        paramString = paramzzg.zza((zzap)paramList.get(0));
      }
      if (paramList.size() > 1)
      {
        d1 = zzh.zzi(paramzzg.zza((zzap)paramList.get(1)).zzd().doubleValue());
        if (d1 >= paramzzae.zzh())
        {
          paramString = new zzah(Double.valueOf(-1.0D));
          break label2506;
        }
        if (d1 < 0.0D) {
          d1 = paramzzae.zzh() + d1;
        }
      }
      paramzzg = paramzzae.zzg();
      while (paramzzg.hasNext())
      {
        i = ((Integer)paramzzg.next()).intValue();
        d3 = i;
        if ((d3 >= d1) && (zzh.zzf(paramzzae.zzl(i), paramString)))
        {
          paramString = new zzah(Double.valueOf(d3));
          break label2506;
        }
      }
      paramString = new zzah(Double.valueOf(-1.0D));
      return paramString;
    case 3: 
      zzh.zza("forEach", 1, paramList);
      paramString = paramzzg.zza((zzap)paramList.get(0));
      if ((paramString instanceof zzao))
      {
        if (paramzzae.zzi() == 0)
        {
          paramString = zzap.zzf;
        }
        else
        {
          zzc(paramzzae, paramzzg, (zzao)paramString, null, null);
          paramString = zzap.zzf;
        }
        return paramString;
      }
      throw new IllegalArgumentException("Callback should be a method");
    case 2: 
      zzh.zza("filter", 1, paramList);
      paramString = paramzzg.zza((zzap)paramList.get(0));
      if ((paramString instanceof zzao))
      {
        if (paramzzae.zzi() == 0)
        {
          paramString = new zzae();
        }
        else
        {
          paramList = paramzzae.zzt();
          paramzzae = zzc(paramzzae, paramzzg, (zzao)paramString, null, Boolean.TRUE);
          paramString = new zzae();
          paramzzg = paramzzae.zzg();
          while (paramzzg.hasNext())
          {
            i = ((Integer)paramzzg.next()).intValue();
            paramzzae = ((zzae)paramList).zzl(i);
            paramString.zzn(paramString.zzh(), paramzzae);
          }
        }
        return paramString;
      }
      throw new IllegalArgumentException("Callback should be a method");
    case 1: 
      label2203:
      label2506:
      zzh.zza("every", 1, paramList);
      paramString = paramzzg.zza((zzap)paramList.get(0));
      if ((paramString instanceof zzao))
      {
        if (paramzzae.zzh() == 0) {
          paramString = zzap.zzk;
        } else if (zzc(paramzzae, paramzzg, (zzao)paramString, Boolean.FALSE, Boolean.TRUE).zzh() != paramzzae.zzh()) {
          paramString = zzap.zzl;
        } else {
          paramString = zzap.zzk;
        }
        return paramString;
      }
      throw new IllegalArgumentException("Callback should be a method");
    }
    paramString = paramzzae.zzt();
    if (!paramList.isEmpty())
    {
      paramzzae = paramList.iterator();
      while (paramzzae.hasNext())
      {
        localObject = paramzzg.zza((zzap)paramzzae.next());
        if (!(localObject instanceof zzag))
        {
          paramList = (zzae)paramString;
          i = paramList.zzh();
          if ((localObject instanceof zzae))
          {
            localObject = (zzae)localObject;
            Iterator localIterator = ((zzae)localObject).zzg();
            while (localIterator.hasNext())
            {
              Integer localInteger = (Integer)localIterator.next();
              paramList.zzn(localInteger.intValue() + i, ((zzae)localObject).zzl(localInteger.intValue()));
            }
          }
          else
          {
            paramList.zzn(i, (zzap)localObject);
          }
        }
        else
        {
          throw new IllegalStateException("Failed evaluation of arguments");
        }
      }
    }
    return paramString;
  }
  
  private static zzap zzb(zzae paramzzae, zzg paramzzg, List<zzap> paramList, boolean paramBoolean)
  {
    zzh.zzb("reduce", 1, paramList);
    zzh.zzc("reduce", 2, paramList);
    Object localObject = paramzzg.zza((zzap)paramList.get(0));
    if ((localObject instanceof zzai))
    {
      if (paramList.size() == 2)
      {
        paramList = paramzzg.zza((zzap)paramList.get(1));
        if ((paramList instanceof zzag)) {
          throw new IllegalArgumentException("Failed to parse initial value");
        }
      }
      else
      {
        if (paramzzae.zzh() == 0) {
          break label318;
        }
        paramList = null;
      }
      zzai localzzai = (zzai)localObject;
      int i = paramzzae.zzh();
      int j;
      if (paramBoolean) {
        j = 0;
      } else {
        j = i - 1;
      }
      int k = -1;
      if (paramBoolean) {
        i--;
      } else {
        i = 0;
      }
      if (true == paramBoolean) {
        k = 1;
      }
      int m = i;
      int n = j;
      int i1 = k;
      localObject = paramList;
      if (paramList == null) {
        paramList = paramzzae.zzl(j);
      }
      while ((m - n) * i1 >= 0)
      {
        i = m;
        j = n;
        k = i1;
        paramList = (List<zzap>)localObject;
        if (paramzzae.zzo(n))
        {
          paramList = localzzai.zza(paramzzg, Arrays.asList(new zzap[] { localObject, paramzzae.zzl(n), new zzah(Double.valueOf(n)), paramzzae }));
          if (!(paramList instanceof zzag))
          {
            i = m;
            j = n;
            k = i1;
          }
          else
          {
            throw new IllegalStateException("Reduce operation failed");
          }
        }
        n = j + k;
        m = i;
        i1 = k;
        localObject = paramList;
      }
      return (zzap)localObject;
      label318:
      throw new IllegalStateException("Empty array with no initial value error");
    }
    throw new IllegalArgumentException("Callback should be a method");
  }
  
  private static zzae zzc(zzae paramzzae, zzg paramzzg, zzai paramzzai, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    zzae localzzae = new zzae();
    Iterator localIterator = paramzzae.zzg();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if (paramzzae.zzo(i))
      {
        zzap localzzap = paramzzai.zza(paramzzg, Arrays.asList(new zzap[] { paramzzae.zzl(i), new zzah(Double.valueOf(i)), paramzzae }));
        if (localzzap.zze().equals(paramBoolean1)) {
          return localzzae;
        }
        if ((paramBoolean2 == null) || (localzzap.zze().equals(paramBoolean2))) {
          localzzae.zzn(i, localzzap);
        }
      }
    }
    return localzzae;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzbb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */