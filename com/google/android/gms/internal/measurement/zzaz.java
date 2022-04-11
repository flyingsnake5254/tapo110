package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

public final class zzaz
  extends zzaw
{
  protected zzaz()
  {
    this.zza.add(zzbl.zzc);
    this.zza.add(zzbl.zzl);
    this.zza.add(zzbl.zzm);
    this.zza.add(zzbl.zzn);
    this.zza.add(zzbl.zzt);
    this.zza.add(zzbl.zzp);
    this.zza.add(zzbl.zzu);
    this.zza.add(zzbl.zzz);
    this.zza.add(zzbl.zzP);
    this.zza.add(zzbl.zzac);
    this.zza.add(zzbl.zzaf);
    this.zza.add(zzbl.zzai);
    this.zza.add(zzbl.zzaj);
  }
  
  private static zzap zzc(zzg paramzzg, List<zzap> paramList)
  {
    zzh.zzb(zzbl.zzz.name(), 2, paramList);
    zzap localzzap = paramzzg.zza((zzap)paramList.get(0));
    Object localObject = paramzzg.zza((zzap)paramList.get(1));
    if ((localObject instanceof zzae))
    {
      List localList = ((zzae)localObject).zzb();
      localObject = new ArrayList();
      if (paramList.size() > 2) {
        localObject = paramList.subList(2, paramList.size());
      }
      return new zzao(localzzap.zzc(), localList, (List)localObject, paramzzg);
    }
    throw new IllegalArgumentException(String.format("FN requires an ArrayValue of parameter names found %s", new Object[] { localObject.getClass().getCanonicalName() }));
  }
  
  public final zzap zza(String paramString, zzg paramzzg, List<zzap> paramList)
  {
    Object localObject1 = zzbl.zza;
    int i = zzh.zze(paramString).ordinal();
    if (i != 2)
    {
      if (i != 15)
      {
        if (i != 25)
        {
          if (i != 41)
          {
            if (i != 54)
            {
              if (i != 57)
              {
                if (i != 19)
                {
                  if (i != 20) {
                    if (i != 60) {
                      if (i == 61) {}
                    }
                  }
                  switch (i)
                  {
                  default: 
                    return super.zzb(paramString);
                  case 12: 
                    zzh.zza(zzbl.zzm.name(), 0, paramList);
                    return zzap.zzi;
                  case 11: 
                    return paramzzg.zzc().zzb(new zzae(paramList));
                    zzh.zza(zzbl.zzaj.name(), 3, paramList);
                    if (paramzzg.zza((zzap)paramList.get(0)).zze().booleanValue()) {
                      paramString = paramzzg.zza((zzap)paramList.get(1));
                    } else {
                      paramString = paramzzg.zza((zzap)paramList.get(2));
                    }
                    return paramString;
                    zzh.zza(zzbl.zzai.name(), 3, paramList);
                    paramString = paramzzg.zza((zzap)paramList.get(0));
                    localObject1 = paramzzg.zza((zzap)paramList.get(1));
                    paramList = paramzzg.zza((zzap)paramList.get(2));
                    if ((localObject1 instanceof zzae))
                    {
                      if ((paramList instanceof zzae))
                      {
                        localObject1 = (zzae)localObject1;
                        localObject2 = (zzae)paramList;
                        int j = 0;
                        i = 0;
                        while (j < ((zzae)localObject1).zzh())
                        {
                          if ((i == 0) && (!paramString.equals(paramzzg.zza(((zzae)localObject1).zzl(j)))))
                          {
                            i = 0;
                          }
                          else
                          {
                            paramList = paramzzg.zza(((zzae)localObject2).zzl(j));
                            if ((paramList instanceof zzag))
                            {
                              paramString = paramList;
                              if (!((zzag)paramList).zzg().equals("break")) {
                                break label472;
                              }
                              return zzap.zzf;
                            }
                            i = 1;
                          }
                          j++;
                        }
                        if (((zzae)localObject1).zzh() + 1 == ((zzae)localObject2).zzh())
                        {
                          paramzzg = paramzzg.zza(((zzae)localObject2).zzl(((zzae)localObject1).zzh()));
                          if ((paramzzg instanceof zzag))
                          {
                            paramList = ((zzag)paramzzg).zzg();
                            paramString = paramzzg;
                            if (!paramList.equals("return"))
                            {
                              paramString = paramzzg;
                              if (!paramList.equals("continue")) {}
                            }
                            else
                            {
                              label472:
                              return paramString;
                            }
                          }
                        }
                        return zzap.zzf;
                      }
                      throw new IllegalArgumentException("Malformed SWITCH statement, case statements are not a list");
                    }
                    throw new IllegalArgumentException("Malformed SWITCH statement, cases are not a list");
                    zzh.zzb(zzbl.zzu.name(), 2, paramList);
                    paramString = zzc(paramzzg, paramList);
                    paramList = (zzai)paramString;
                    if (paramList.zzg() == null) {
                      paramzzg.zze("", paramString);
                    } else {
                      paramzzg.zze(paramList.zzg(), paramString);
                    }
                    return paramString;
                  }
                }
                if (paramList.isEmpty())
                {
                  paramString = zzap.zzf;
                }
                else
                {
                  paramString = paramzzg.zza((zzap)paramList.get(0));
                  if ((paramString instanceof zzae)) {
                    paramString = paramzzg.zzb((zzae)paramString);
                  } else {
                    paramString = zzap.zzf;
                  }
                }
                return paramString;
              }
              if (paramList.isEmpty())
              {
                paramString = zzap.zzj;
              }
              else
              {
                zzh.zza(zzbl.zzaf.name(), 1, paramList);
                paramString = new zzag("return", paramzzg.zza((zzap)paramList.get(0)));
              }
              return paramString;
            }
            return new zzae(paramList);
          }
          zzh.zzb(zzbl.zzP.name(), 2, paramList);
          Object localObject2 = paramzzg.zza((zzap)paramList.get(0));
          localObject1 = paramzzg.zza((zzap)paramList.get(1));
          if (paramList.size() > 2) {
            paramString = paramzzg.zza((zzap)paramList.get(2));
          } else {
            paramString = null;
          }
          paramList = zzap.zzf;
          if (((zzap)localObject2).zze().booleanValue()) {
            paramString = paramzzg.zzb((zzae)localObject1);
          } else if (paramString != null) {
            paramString = paramzzg.zzb((zzae)paramString);
          } else {
            paramString = paramList;
          }
          if ((paramString instanceof zzag)) {
            return paramString;
          }
          return paramList;
        }
        return zzc(paramzzg, paramList);
      }
      zzh.zza(zzbl.zzm.name(), 0, paramList);
      return zzap.zzh;
    }
    zzh.zza(zzbl.zzc.name(), 3, paramList);
    localObject1 = paramzzg.zza((zzap)paramList.get(0));
    paramString = paramzzg.zza((zzap)paramList.get(1)).zzc();
    paramList = paramzzg.zza((zzap)paramList.get(2));
    if ((paramList instanceof zzae))
    {
      if (!paramString.isEmpty()) {
        return ((zzap)localObject1).zzbK(paramString, paramzzg, ((zzae)paramList).zzb());
      }
      throw new IllegalArgumentException("Function name for apply is undefined");
    }
    throw new IllegalArgumentException(String.format("Function arguments for Apply are not a list found %s", new Object[] { paramList.getClass().getCanonicalName() }));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */