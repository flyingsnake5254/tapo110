package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

final class zzgm
  extends zzgk<zzgx.zzd>
{
  final int zza(Map.Entry<?, ?> paramEntry)
  {
    return ((zzgx.zzd)paramEntry.getKey()).number;
  }
  
  final Object zza(zzgi paramzzgi, zzih paramzzih, int paramInt)
  {
    return paramzzgi.zza(paramzzih, paramInt);
  }
  
  final <UT, UB> UB zza(zzix paramzzix, Object paramObject, zzgi paramzzgi, zzgn<zzgx.zzd> paramzzgn, UB paramUB, zzjo<UT, UB> paramzzjo)
    throws IOException
  {
    zzgx.zzg localzzg = (zzgx.zzg)paramObject;
    Object localObject = localzzg.zzxq;
    int i = ((zzgx.zzd)localObject).number;
    if ((((zzgx.zzd)localObject).zzwx) && (((zzgx.zzd)localObject).zzwy))
    {
      switch (zzgl.zzsg[localObject.zzww.ordinal()])
      {
      default: 
        paramObject = String.valueOf(localzzg.zzxq.zzww);
        paramzzix = new StringBuilder(((String)paramObject).length() + 23);
        paramzzix.append("Type cannot be packed: ");
        paramzzix.append((String)paramObject);
        throw new IllegalStateException(paramzzix.toString());
      case 14: 
        paramObject = new ArrayList();
        paramzzix.zzl((List)paramObject);
        paramUB = zziy.zza(i, (List)paramObject, localzzg.zzxq.zzwv, paramUB, paramzzjo);
        paramzzix = (zzix)paramObject;
        break;
      case 13: 
        paramObject = new ArrayList();
        paramzzix.zzp((List)paramObject);
        paramzzix = (zzix)paramObject;
        break;
      case 12: 
        paramObject = new ArrayList();
        paramzzix.zzo((List)paramObject);
        paramzzix = (zzix)paramObject;
        break;
      case 11: 
        paramObject = new ArrayList();
        paramzzix.zzn((List)paramObject);
        paramzzix = (zzix)paramObject;
        break;
      case 10: 
        paramObject = new ArrayList();
        paramzzix.zzm((List)paramObject);
        paramzzix = (zzix)paramObject;
        break;
      case 9: 
        paramObject = new ArrayList();
        paramzzix.zzk((List)paramObject);
        paramzzix = (zzix)paramObject;
        break;
      case 8: 
        paramObject = new ArrayList();
        paramzzix.zzh((List)paramObject);
        paramzzix = (zzix)paramObject;
        break;
      case 7: 
        paramObject = new ArrayList();
        paramzzix.zzg((List)paramObject);
        paramzzix = (zzix)paramObject;
        break;
      case 6: 
        paramObject = new ArrayList();
        paramzzix.zzf((List)paramObject);
        paramzzix = (zzix)paramObject;
        break;
      case 5: 
        paramObject = new ArrayList();
        paramzzix.zze((List)paramObject);
        paramzzix = (zzix)paramObject;
        break;
      case 4: 
        paramObject = new ArrayList();
        paramzzix.zzc((List)paramObject);
        paramzzix = (zzix)paramObject;
        break;
      case 3: 
        paramObject = new ArrayList();
        paramzzix.zzd((List)paramObject);
        paramzzix = (zzix)paramObject;
        break;
      case 2: 
        paramObject = new ArrayList();
        paramzzix.zzb((List)paramObject);
        paramzzix = (zzix)paramObject;
        break;
      case 1: 
        paramObject = new ArrayList();
        paramzzix.zza((List)paramObject);
        paramzzix = (zzix)paramObject;
      }
      paramzzgn.zza(localzzg.zzxq, paramzzix);
    }
    else
    {
      paramObject = null;
      localObject = ((zzgx.zzd)localObject).zzww;
      if (localObject == zzkf.zzaco)
      {
        int j = paramzzix.zzdz();
        if (localzzg.zzxq.zzwv.zzh(j) == null) {
          return (UB)zziy.zza(i, j, paramUB, paramzzjo);
        }
        paramzzix = Integer.valueOf(j);
      }
      else
      {
        switch (zzgl.zzsg[localObject.ordinal()])
        {
        default: 
          paramzzix = (zzix)paramObject;
          break;
        case 18: 
          paramzzix = paramzzix.zza(localzzg.zzxp.getClass(), paramzzgi);
          break;
        case 17: 
          paramzzix = paramzzix.zzb(localzzg.zzxp.getClass(), paramzzgi);
          break;
        case 16: 
          paramzzix = paramzzix.readString();
          break;
        case 15: 
          paramzzix = paramzzix.zzee();
          break;
        case 14: 
          throw new IllegalStateException("Shouldn't reach here.");
        case 13: 
          paramzzix = Long.valueOf(paramzzix.zzek());
          break;
        case 12: 
          paramzzix = Integer.valueOf(paramzzix.zzej());
          break;
        case 11: 
          paramzzix = Long.valueOf(paramzzix.zzei());
          break;
        case 10: 
          paramzzix = Integer.valueOf(paramzzix.zzeh());
          break;
        case 9: 
          paramzzix = Integer.valueOf(paramzzix.zzef());
          break;
        case 8: 
          paramzzix = Boolean.valueOf(paramzzix.zzec());
          break;
        case 7: 
          paramzzix = Integer.valueOf(paramzzix.zzeb());
          break;
        case 6: 
          paramzzix = Long.valueOf(paramzzix.zzea());
          break;
        case 5: 
          paramzzix = Integer.valueOf(paramzzix.zzdz());
          break;
        case 4: 
          paramzzix = Long.valueOf(paramzzix.zzdx());
          break;
        case 3: 
          paramzzix = Long.valueOf(paramzzix.zzdy());
          break;
        case 2: 
          paramzzix = Float.valueOf(paramzzix.readFloat());
          break;
        case 1: 
          paramzzix = Double.valueOf(paramzzix.readDouble());
        }
      }
      paramObject = localzzg.zzxq;
      if (((zzgx.zzd)paramObject).zzwx)
      {
        paramzzgn.zzb((zzgp)paramObject, paramzzix);
      }
      else
      {
        i = zzgl.zzsg[paramObject.zzww.ordinal()];
        if ((i != 17) && (i != 18))
        {
          paramObject = paramzzix;
        }
        else
        {
          paramzzgi = paramzzgn.zza(localzzg.zzxq);
          paramObject = paramzzix;
          if (paramzzgi != null) {
            paramObject = zzgy.zzb(paramzzgi, paramzzix);
          }
        }
        paramzzgn.zza(localzzg.zzxq, paramObject);
      }
    }
    return paramUB;
  }
  
  final void zza(zzfm paramzzfm, Object paramObject, zzgi paramzzgi, zzgn<zzgx.zzd> paramzzgn)
    throws IOException
  {
    zzgx.zzg localzzg = (zzgx.zzg)paramObject;
    zzih localzzih = localzzg.zzxp.zzgk().zzgc();
    int i = paramzzfm.size();
    if (i == 0)
    {
      paramzzfm = zzgy.zzxr;
    }
    else
    {
      paramObject = new byte[i];
      paramzzfm.zza((byte[])paramObject, 0, 0, i);
      paramzzfm = (zzfm)paramObject;
    }
    paramzzfm = ByteBuffer.wrap(paramzzfm);
    if (paramzzfm.hasArray())
    {
      paramzzfm = new zzfl(paramzzfm, true);
      zzis.zzhp().zzv(localzzih).zza(localzzih, paramzzfm, paramzzgi);
      paramzzgn.zza(localzzg.zzxq, localzzih);
      if (paramzzfm.zzdv() == Integer.MAX_VALUE) {
        return;
      }
      throw zzhh.zzgr();
    }
    throw new IllegalArgumentException("Direct buffers not yet supported");
  }
  
  final void zza(zzix paramzzix, Object paramObject, zzgi paramzzgi, zzgn<zzgx.zzd> paramzzgn)
    throws IOException
  {
    paramObject = (zzgx.zzg)paramObject;
    paramzzix = paramzzix.zza(((zzgx.zzg)paramObject).zzxp.getClass(), paramzzgi);
    paramzzgn.zza(((zzgx.zzg)paramObject).zzxq, paramzzix);
  }
  
  final void zza(zzkl paramzzkl, Map.Entry<?, ?> paramEntry)
    throws IOException
  {
    zzgx.zzd localzzd = (zzgx.zzd)paramEntry.getKey();
    if (localzzd.zzwx)
    {
      List localList;
      switch (zzgl.zzsg[localzzd.zzww.ordinal()])
      {
      default: 
        break;
      case 18: 
        localList = (List)paramEntry.getValue();
        if ((localList != null) && (!localList.isEmpty())) {
          zziy.zza(localzzd.number, (List)paramEntry.getValue(), paramzzkl, zzis.zzhp().zzf(localList.get(0).getClass()));
        }
        break;
      case 17: 
        localList = (List)paramEntry.getValue();
        if ((localList != null) && (!localList.isEmpty())) {
          zziy.zzb(localzzd.number, (List)paramEntry.getValue(), paramzzkl, zzis.zzhp().zzf(localList.get(0).getClass()));
        }
        return;
      case 16: 
        zziy.zza(localzzd.number, (List)paramEntry.getValue(), paramzzkl);
        return;
      case 15: 
        zziy.zzb(localzzd.number, (List)paramEntry.getValue(), paramzzkl);
        return;
      case 14: 
        zziy.zzh(localzzd.number, (List)paramEntry.getValue(), paramzzkl, localzzd.zzwy);
        return;
      case 13: 
        zziy.zze(localzzd.number, (List)paramEntry.getValue(), paramzzkl, localzzd.zzwy);
        return;
      case 12: 
        zziy.zzj(localzzd.number, (List)paramEntry.getValue(), paramzzkl, localzzd.zzwy);
        return;
      case 11: 
        zziy.zzg(localzzd.number, (List)paramEntry.getValue(), paramzzkl, localzzd.zzwy);
        return;
      case 10: 
        zziy.zzl(localzzd.number, (List)paramEntry.getValue(), paramzzkl, localzzd.zzwy);
        return;
      case 9: 
        zziy.zzi(localzzd.number, (List)paramEntry.getValue(), paramzzkl, localzzd.zzwy);
        return;
      case 8: 
        zziy.zzn(localzzd.number, (List)paramEntry.getValue(), paramzzkl, localzzd.zzwy);
        return;
      case 7: 
        zziy.zzk(localzzd.number, (List)paramEntry.getValue(), paramzzkl, localzzd.zzwy);
        return;
      case 6: 
        zziy.zzf(localzzd.number, (List)paramEntry.getValue(), paramzzkl, localzzd.zzwy);
        return;
      case 5: 
        zziy.zzh(localzzd.number, (List)paramEntry.getValue(), paramzzkl, localzzd.zzwy);
        return;
      case 4: 
        zziy.zzd(localzzd.number, (List)paramEntry.getValue(), paramzzkl, localzzd.zzwy);
        return;
      case 3: 
        zziy.zzc(localzzd.number, (List)paramEntry.getValue(), paramzzkl, localzzd.zzwy);
        return;
      case 2: 
        zziy.zzb(localzzd.number, (List)paramEntry.getValue(), paramzzkl, localzzd.zzwy);
        return;
      case 1: 
        zziy.zza(localzzd.number, (List)paramEntry.getValue(), paramzzkl, localzzd.zzwy);
      }
      return;
    }
    switch (zzgl.zzsg[localzzd.zzww.ordinal()])
    {
    default: 
      break;
    case 18: 
      paramzzkl.zza(localzzd.number, paramEntry.getValue(), zzis.zzhp().zzf(paramEntry.getValue().getClass()));
      break;
    case 17: 
      paramzzkl.zzb(localzzd.number, paramEntry.getValue(), zzis.zzhp().zzf(paramEntry.getValue().getClass()));
      return;
    case 16: 
      paramzzkl.zza(localzzd.number, (String)paramEntry.getValue());
      return;
    case 15: 
      paramzzkl.zza(localzzd.number, (zzfm)paramEntry.getValue());
      return;
    case 14: 
      paramzzkl.zzh(localzzd.number, ((Integer)paramEntry.getValue()).intValue());
      return;
    case 13: 
      paramzzkl.zzb(localzzd.number, ((Long)paramEntry.getValue()).longValue());
      return;
    case 12: 
      paramzzkl.zzj(localzzd.number, ((Integer)paramEntry.getValue()).intValue());
      return;
    case 11: 
      paramzzkl.zzj(localzzd.number, ((Long)paramEntry.getValue()).longValue());
      return;
    case 10: 
      paramzzkl.zzr(localzzd.number, ((Integer)paramEntry.getValue()).intValue());
      return;
    case 9: 
      paramzzkl.zzi(localzzd.number, ((Integer)paramEntry.getValue()).intValue());
      return;
    case 8: 
      paramzzkl.zza(localzzd.number, ((Boolean)paramEntry.getValue()).booleanValue());
      return;
    case 7: 
      paramzzkl.zzk(localzzd.number, ((Integer)paramEntry.getValue()).intValue());
      return;
    case 6: 
      paramzzkl.zzc(localzzd.number, ((Long)paramEntry.getValue()).longValue());
      return;
    case 5: 
      paramzzkl.zzh(localzzd.number, ((Integer)paramEntry.getValue()).intValue());
      return;
    case 4: 
      paramzzkl.zza(localzzd.number, ((Long)paramEntry.getValue()).longValue());
      return;
    case 3: 
      paramzzkl.zzi(localzzd.number, ((Long)paramEntry.getValue()).longValue());
      return;
    case 2: 
      paramzzkl.zza(localzzd.number, ((Float)paramEntry.getValue()).floatValue());
      return;
    case 1: 
      paramzzkl.zza(localzzd.number, ((Double)paramEntry.getValue()).doubleValue());
    }
  }
  
  final boolean zze(zzih paramzzih)
  {
    return paramzzih instanceof zzgx.zze;
  }
  
  final zzgn<zzgx.zzd> zzf(Object paramObject)
  {
    return ((zzgx.zze)paramObject).zzwz;
  }
  
  final zzgn<zzgx.zzd> zzg(Object paramObject)
  {
    return ((zzgx.zze)paramObject).zzgl();
  }
  
  final void zzh(Object paramObject)
  {
    zzf(paramObject).zzdq();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzgm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */