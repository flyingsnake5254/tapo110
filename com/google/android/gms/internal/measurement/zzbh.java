package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

public final class zzbh
  extends zzaw
{
  protected zzbh()
  {
    this.zza.add(zzbl.zzA);
    this.zza.add(zzbl.zzB);
    this.zza.add(zzbl.zzC);
    this.zza.add(zzbl.zzD);
    this.zza.add(zzbl.zzE);
    this.zza.add(zzbl.zzF);
    this.zza.add(zzbl.zzG);
    this.zza.add(zzbl.zzan);
  }
  
  private static zzap zzc(zzbf paramzzbf, zzap paramzzap1, zzap paramzzap2)
  {
    return zze(paramzzbf, paramzzap1.zzf(), paramzzap2);
  }
  
  private static zzap zzd(zzbf paramzzbf, zzap paramzzap1, zzap paramzzap2)
  {
    if ((paramzzap1 instanceof Iterable)) {
      return zze(paramzzbf, ((Iterable)paramzzap1).iterator(), paramzzap2);
    }
    throw new IllegalArgumentException("Non-iterable type in for...of loop.");
  }
  
  private static zzap zze(zzbf paramzzbf, Iterator<zzap> paramIterator, zzap paramzzap)
  {
    if (paramIterator != null) {
      while (paramIterator.hasNext())
      {
        Object localObject = paramzzbf.zza((zzap)paramIterator.next()).zzb((zzae)paramzzap);
        if ((localObject instanceof zzag))
        {
          localObject = (zzag)localObject;
          if ("break".equals(((zzag)localObject).zzg())) {
            return zzap.zzf;
          }
          if ("return".equals(((zzag)localObject).zzg())) {
            return (zzap)localObject;
          }
        }
      }
    }
    return zzap.zzf;
  }
  
  public final zzap zza(String paramString, zzg paramzzg, List<zzap> paramList)
  {
    Object localObject = zzbl.zza;
    int i = zzh.zze(paramString).ordinal();
    if (i != 65)
    {
      switch (i)
      {
      default: 
        return super.zzb(paramString);
      case 32: 
        zzh.zza(zzbl.zzG.name(), 3, paramList);
        if ((paramList.get(0) instanceof zzat))
        {
          localObject = ((zzap)paramList.get(0)).zzc();
          paramString = paramzzg.zza((zzap)paramList.get(1));
          paramList = paramzzg.zza((zzap)paramList.get(2));
          return zzd(new zzbe(paramzzg, (String)localObject), paramString, paramList);
        }
        throw new IllegalArgumentException("Variable name in FOR_OF_LET must be a string");
      case 31: 
        zzh.zza(zzbl.zzF.name(), 3, paramList);
        if ((paramList.get(0) instanceof zzat))
        {
          localObject = ((zzap)paramList.get(0)).zzc();
          paramString = paramzzg.zza((zzap)paramList.get(1));
          paramList = paramzzg.zza((zzap)paramList.get(2));
          return zzd(new zzbd(paramzzg, (String)localObject), paramString, paramList);
        }
        throw new IllegalArgumentException("Variable name in FOR_OF_CONST must be a string");
      case 30: 
        zzh.zza(zzbl.zzE.name(), 3, paramList);
        if ((paramList.get(0) instanceof zzat))
        {
          paramString = ((zzap)paramList.get(0)).zzc();
          localObject = paramzzg.zza((zzap)paramList.get(1));
          paramList = paramzzg.zza((zzap)paramList.get(2));
          return zzd(new zzbg(paramzzg, paramString), (zzap)localObject, paramList);
        }
        throw new IllegalArgumentException("Variable name in FOR_OF must be a string");
      case 29: 
        zzh.zza(zzbl.zzD.name(), 4, paramList);
        paramString = paramzzg.zza((zzap)paramList.get(0));
        if ((paramString instanceof zzae))
        {
          zzae localzzae = (zzae)paramString;
          localzzap1 = (zzap)paramList.get(1);
          localObject = (zzap)paramList.get(2);
          zzap localzzap2 = paramzzg.zza((zzap)paramList.get(3));
          paramList = paramzzg.zzc();
          for (i = 0;; i++)
          {
            paramString = paramList;
            if (i >= localzzae.zzh()) {
              break;
            }
            paramString = localzzae.zzl(i).zzc();
            paramList.zze(paramString, paramzzg.zzh(paramString));
          }
          while (paramzzg.zza(localzzap1).zze().booleanValue())
          {
            paramList = paramzzg.zzb((zzae)localzzap2);
            if ((paramList instanceof zzag))
            {
              paramList = (zzag)paramList;
              if ("break".equals(paramList.zzg()))
              {
                paramString = zzap.zzf;
                break label630;
              }
              if ("return".equals(paramList.zzg()))
              {
                paramString = paramList;
                break label630;
              }
            }
            paramList = paramzzg.zzc();
            for (i = 0; i < localzzae.zzh(); i++)
            {
              String str = localzzae.zzl(i).zzc();
              paramList.zze(str, paramString.zzh(str));
            }
            paramList.zza((zzap)localObject);
            paramString = paramList;
          }
          paramString = zzap.zzf;
          return paramString;
        }
        throw new IllegalArgumentException("Initializer variables in FOR_LET must be an ArrayList");
      case 28: 
        zzh.zza(zzbl.zzC.name(), 3, paramList);
        if ((paramList.get(0) instanceof zzat))
        {
          localObject = ((zzap)paramList.get(0)).zzc();
          paramString = paramzzg.zza((zzap)paramList.get(1));
          paramList = paramzzg.zza((zzap)paramList.get(2));
          return zzc(new zzbe(paramzzg, (String)localObject), paramString, paramList);
        }
        throw new IllegalArgumentException("Variable name in FOR_IN_LET must be a string");
      case 27: 
        label630:
        zzh.zza(zzbl.zzB.name(), 3, paramList);
        if ((paramList.get(0) instanceof zzat))
        {
          localObject = ((zzap)paramList.get(0)).zzc();
          paramString = paramzzg.zza((zzap)paramList.get(1));
          paramList = paramzzg.zza((zzap)paramList.get(2));
          return zzc(new zzbd(paramzzg, (String)localObject), paramString, paramList);
        }
        throw new IllegalArgumentException("Variable name in FOR_IN_CONST must be a string");
      }
      zzh.zza(zzbl.zzA.name(), 3, paramList);
      if ((paramList.get(0) instanceof zzat))
      {
        paramString = ((zzap)paramList.get(0)).zzc();
        localObject = paramzzg.zza((zzap)paramList.get(1));
        paramList = paramzzg.zza((zzap)paramList.get(2));
        return zzc(new zzbg(paramzzg, paramString), (zzap)localObject, paramList);
      }
      throw new IllegalArgumentException("Variable name in FOR_IN must be a string");
    }
    zzh.zza(zzbl.zzan.name(), 4, paramList);
    zzap localzzap1 = (zzap)paramList.get(0);
    localObject = (zzap)paramList.get(1);
    paramString = (zzap)paramList.get(2);
    paramList = paramzzg.zza((zzap)paramList.get(3));
    if (paramzzg.zza(paramString).zze().booleanValue())
    {
      paramString = paramzzg.zzb((zzae)paramList);
      if ((paramString instanceof zzag))
      {
        paramString = (zzag)paramString;
        if ("break".equals(paramString.zzg())) {
          paramString = zzap.zzf;
        } else if ("return".equals(paramString.zzg())) {}
      }
    }
    while (paramzzg.zza(localzzap1).zze().booleanValue())
    {
      paramString = paramzzg.zzb((zzae)paramList);
      if ((paramString instanceof zzag))
      {
        paramString = (zzag)paramString;
        if ("break".equals(paramString.zzg())) {
          paramString = zzap.zzf;
        } else if ("return".equals(paramString.zzg())) {}
      }
      paramzzg.zza((zzap)localObject);
    }
    paramString = zzap.zzf;
    return paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzbh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */