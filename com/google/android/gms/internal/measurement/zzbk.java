package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

public final class zzbk
  extends zzaw
{
  protected zzbk()
  {
    this.zza.add(zzbl.zzd);
    this.zza.add(zzbl.zzo);
    this.zza.add(zzbl.zzr);
    this.zza.add(zzbl.zzs);
    this.zza.add(zzbl.zzy);
    this.zza.add(zzbl.zzH);
    this.zza.add(zzbl.zzJ);
    this.zza.add(zzbl.zzK);
    this.zza.add(zzbl.zzX);
    this.zza.add(zzbl.zzag);
    this.zza.add(zzbl.zzak);
    this.zza.add(zzbl.zzal);
    this.zza.add(zzbl.zzam);
  }
  
  public final zzap zza(String paramString, zzg paramzzg, List<zzap> paramList)
  {
    Object localObject = zzbl.zza;
    int i = zzh.zze(paramString).ordinal();
    int j = 0;
    int k = 0;
    int m = 0;
    if (i != 3)
    {
      if (i != 14)
      {
        if (i != 24)
        {
          if (i != 33)
          {
            if (i != 49)
            {
              if (i != 58)
              {
                if (i != 17)
                {
                  if (i != 18)
                  {
                    if ((i != 35) && (i != 36))
                    {
                      switch (i)
                      {
                      default: 
                        return super.zzb(paramString);
                      case 64: 
                        zzh.zzb(zzbl.zzam.name(), 1, paramList);
                        paramString = paramList.iterator();
                        while (paramString.hasNext())
                        {
                          paramList = paramzzg.zza((zzap)paramString.next());
                          if ((paramList instanceof zzat)) {
                            paramzzg.zzf(paramList.zzc(), zzap.zzf);
                          } else {
                            throw new IllegalArgumentException(String.format("Expected string for var name. got %s", new Object[] { paramList.getClass().getCanonicalName() }));
                          }
                        }
                        return zzap.zzf;
                      case 63: 
                        zzh.zza(zzbl.zzal.name(), 0, paramList);
                        return zzap.zzf;
                      }
                      zzh.zza(zzbl.zzak.name(), 1, paramList);
                      paramString = paramzzg.zza((zzap)paramList.get(0));
                      if ((paramString instanceof zzau))
                      {
                        paramString = "undefined";
                      }
                      else if ((paramString instanceof zzaf))
                      {
                        paramString = "boolean";
                      }
                      else if ((paramString instanceof zzah))
                      {
                        paramString = "number";
                      }
                      else if ((paramString instanceof zzat))
                      {
                        paramString = "string";
                      }
                      else if ((paramString instanceof zzao))
                      {
                        paramString = "function";
                      }
                      else
                      {
                        if (((paramString instanceof zzaq)) || ((paramString instanceof zzag))) {
                          break label353;
                        }
                        paramString = "object";
                      }
                      return new zzat(paramString);
                      label353:
                      throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", new Object[] { paramString }));
                    }
                    zzh.zza(zzbl.zzK.name(), 2, paramList);
                    paramString = paramzzg.zza((zzap)paramList.get(0));
                    paramzzg = paramzzg.zza((zzap)paramList.get(1));
                    if (((paramString instanceof zzae)) && (zzh.zzd(paramzzg)))
                    {
                      paramString = ((zzae)paramString).zzl(paramzzg.zzd().intValue());
                    }
                    else if ((paramString instanceof zzal))
                    {
                      paramString = ((zzal)paramString).zzk(paramzzg.zzc());
                    }
                    else
                    {
                      if ((paramString instanceof zzat))
                      {
                        if ("length".equals(paramzzg.zzc()))
                        {
                          paramString = new zzah(Double.valueOf(paramString.zzc().length()));
                          break label586;
                        }
                        if ((zzh.zzd(paramzzg)) && (paramzzg.zzd().doubleValue() < paramString.zzc().length()))
                        {
                          paramString = new zzat(String.valueOf(paramString.zzc().charAt(paramzzg.zzd().intValue())));
                          break label586;
                        }
                      }
                      paramString = zzap.zzf;
                    }
                    label586:
                    return paramString;
                  }
                  if (paramList.isEmpty())
                  {
                    paramString = new zzam();
                  }
                  else
                  {
                    if (paramList.size() % 2 != 0) {
                      break label725;
                    }
                    localObject = new zzam();
                    for (;;)
                    {
                      paramString = (String)localObject;
                      if (m >= paramList.size() - 1) {
                        break label723;
                      }
                      zzap localzzap = paramzzg.zza((zzap)paramList.get(m));
                      paramString = paramzzg.zza((zzap)paramList.get(m + 1));
                      if (((localzzap instanceof zzag)) || ((paramString instanceof zzag))) {
                        break;
                      }
                      ((zzam)localObject).zzm(localzzap.zzc(), paramString);
                      m += 2;
                    }
                    throw new IllegalStateException("Failed to evaluate map entry");
                  }
                  label723:
                  return paramString;
                  label725:
                  throw new IllegalArgumentException(String.format("CREATE_OBJECT requires an even number of arguments, found %s", new Object[] { Integer.valueOf(paramList.size()) }));
                }
                if (paramList.isEmpty())
                {
                  paramString = new zzae();
                }
                else
                {
                  localObject = new zzae();
                  paramList = paramList.iterator();
                  for (m = j;; m++)
                  {
                    paramString = (String)localObject;
                    if (!paramList.hasNext()) {
                      break label851;
                    }
                    paramString = paramzzg.zza((zzap)paramList.next());
                    if ((paramString instanceof zzag)) {
                      break;
                    }
                    ((zzae)localObject).zzn(m, paramString);
                  }
                  throw new IllegalStateException("Failed to evaluate array element");
                }
                label851:
                return paramString;
              }
              zzh.zza(zzbl.zzag.name(), 3, paramList);
              localObject = paramzzg.zza((zzap)paramList.get(0));
              paramString = paramzzg.zza((zzap)paramList.get(1));
              paramzzg = paramzzg.zza((zzap)paramList.get(2));
              if ((localObject != zzap.zzf) && (localObject != zzap.zzg))
              {
                if (((localObject instanceof zzae)) && ((paramString instanceof zzah))) {
                  ((zzae)localObject).zzn(paramString.zzd().intValue(), paramzzg);
                } else if ((localObject instanceof zzal)) {
                  ((zzal)localObject).zzm(paramString.zzc(), paramzzg);
                }
                return paramzzg;
              }
              throw new IllegalStateException(String.format("Can't set property %s of %s", new Object[] { paramString.zzc(), ((zzap)localObject).zzc() }));
            }
            zzh.zza(zzbl.zzX.name(), 0, paramList);
            return zzap.zzg;
          }
          zzh.zza(zzbl.zzH.name(), 1, paramList);
          paramString = paramzzg.zza((zzap)paramList.get(0));
          if ((paramString instanceof zzat)) {
            return paramzzg.zzh(paramString.zzc());
          }
          throw new IllegalArgumentException(String.format("Expected string for get var. got %s", new Object[] { paramString.getClass().getCanonicalName() }));
        }
        zzh.zzb(zzbl.zzy.name(), 1, paramList);
        paramString = zzap.zzf;
        m = k;
        while (m < paramList.size())
        {
          paramString = paramzzg.zza((zzap)paramList.get(m));
          if (!(paramString instanceof zzag)) {
            m++;
          } else {
            throw new IllegalStateException("ControlValue cannot be in an expression list");
          }
        }
        return paramString;
      }
      zzh.zzb(zzbl.zzo.name(), 2, paramList);
      if (paramList.size() % 2 == 0)
      {
        m = 0;
        while (m < paramList.size() - 1)
        {
          paramString = paramzzg.zza((zzap)paramList.get(m));
          if ((paramString instanceof zzat))
          {
            paramzzg.zzg(paramString.zzc(), paramzzg.zza((zzap)paramList.get(m + 1)));
            m += 2;
          }
          else
          {
            throw new IllegalArgumentException(String.format("Expected string for const name. got %s", new Object[] { paramString.getClass().getCanonicalName() }));
          }
        }
        return zzap.zzf;
      }
      throw new IllegalArgumentException(String.format("CONST requires an even number of arguments, found %s", new Object[] { Integer.valueOf(paramList.size()) }));
    }
    zzh.zza(zzbl.zzd.name(), 2, paramList);
    paramString = paramzzg.zza((zzap)paramList.get(0));
    if ((paramString instanceof zzat))
    {
      if (paramzzg.zzd(paramString.zzc()))
      {
        paramList = paramzzg.zza((zzap)paramList.get(1));
        paramzzg.zze(paramString.zzc(), paramList);
        return paramList;
      }
      throw new IllegalArgumentException(String.format("Attempting to assign undefined value %s", new Object[] { paramString.zzc() }));
    }
    throw new IllegalArgumentException(String.format("Expected string for assign var. got %s", new Object[] { paramString.getClass().getCanonicalName() }));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzbk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */