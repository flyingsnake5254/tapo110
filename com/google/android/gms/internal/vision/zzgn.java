package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

final class zzgn<T extends zzgp<T>>
{
  private static final zzgn zztt = new zzgn(true);
  final zzjb<T, Object> zztq;
  private boolean zztr;
  private boolean zzts;
  
  private zzgn()
  {
    this.zztq = zzjb.zzbu(16);
  }
  
  private zzgn(zzjb<T, Object> paramzzjb)
  {
    this.zztq = paramzzjb;
    zzdq();
  }
  
  private zzgn(boolean paramBoolean)
  {
    this(zzjb.zzbu(0));
    zzdq();
  }
  
  static int zza(zzkf paramzzkf, int paramInt, Object paramObject)
  {
    int i = zzgf.zzbb(paramInt);
    paramInt = i;
    if (paramzzkf == zzkf.zzack)
    {
      zzgy.zzf((zzih)paramObject);
      paramInt = i << 1;
    }
    return paramInt + zzb(paramzzkf, paramObject);
  }
  
  static void zza(zzgf paramzzgf, zzkf paramzzkf, int paramInt, Object paramObject)
    throws IOException
  {
    if (paramzzkf == zzkf.zzack)
    {
      paramzzkf = (zzih)paramObject;
      zzgy.zzf(paramzzkf);
      paramzzgf.writeTag(paramInt, 3);
      paramzzkf.zzb(paramzzgf);
      paramzzgf.writeTag(paramInt, 4);
      return;
    }
    paramzzgf.writeTag(paramInt, paramzzkf.zzir());
    switch (zzgq.zzsg[paramzzkf.ordinal()])
    {
    default: 
      break;
    case 18: 
      if ((paramObject instanceof zzhb))
      {
        paramzzgf.zzax(((zzhb)paramObject).zzah());
        return;
      }
      paramzzgf.zzax(((Integer)paramObject).intValue());
      break;
    case 17: 
      paramzzgf.zzt(((Long)paramObject).longValue());
      return;
    case 16: 
      paramzzgf.zzaz(((Integer)paramObject).intValue());
      return;
    case 15: 
      paramzzgf.zzu(((Long)paramObject).longValue());
      return;
    case 14: 
      paramzzgf.zzba(((Integer)paramObject).intValue());
      return;
    case 13: 
      paramzzgf.zzay(((Integer)paramObject).intValue());
      return;
    case 12: 
      if ((paramObject instanceof zzfm))
      {
        paramzzgf.zza((zzfm)paramObject);
        return;
      }
      paramzzkf = (byte[])paramObject;
      paramzzgf.zze(paramzzkf, 0, paramzzkf.length);
      return;
    case 11: 
      if ((paramObject instanceof zzfm))
      {
        paramzzgf.zza((zzfm)paramObject);
        return;
      }
      paramzzgf.zzx((String)paramObject);
      return;
    case 10: 
      paramzzgf.zzb((zzih)paramObject);
      return;
    case 9: 
      ((zzih)paramObject).zzb(paramzzgf);
      return;
    case 8: 
      paramzzgf.zzk(((Boolean)paramObject).booleanValue());
      return;
    case 7: 
      paramzzgf.zzba(((Integer)paramObject).intValue());
      return;
    case 6: 
      paramzzgf.zzu(((Long)paramObject).longValue());
      return;
    case 5: 
      paramzzgf.zzax(((Integer)paramObject).intValue());
      return;
    case 4: 
      paramzzgf.zzs(((Long)paramObject).longValue());
      return;
    case 3: 
      paramzzgf.zzs(((Long)paramObject).longValue());
      return;
    case 2: 
      paramzzgf.zzs(((Float)paramObject).floatValue());
      return;
    case 1: 
      paramzzgf.zza(((Double)paramObject).doubleValue());
    }
  }
  
  private static void zza(zzkf paramzzkf, Object paramObject)
  {
    zzgy.checkNotNull(paramObject);
    int i = zzgq.zztw[paramzzkf.zziq().ordinal()];
    boolean bool1 = true;
    boolean bool2;
    switch (i)
    {
    default: 
    case 9: 
    case 8: 
    case 7: 
      do
      {
        do
        {
          do
          {
            bool2 = false;
            break;
            bool2 = bool1;
            if ((paramObject instanceof zzih)) {
              break;
            }
          } while (!(paramObject instanceof zzhi));
          bool2 = bool1;
          break;
          bool2 = bool1;
          if ((paramObject instanceof Integer)) {
            break;
          }
        } while (!(paramObject instanceof zzhb));
        bool2 = bool1;
        break;
        bool2 = bool1;
        if ((paramObject instanceof zzfm)) {
          break;
        }
      } while (!(paramObject instanceof byte[]));
      bool2 = bool1;
      break;
    case 6: 
      bool2 = paramObject instanceof String;
      break;
    case 5: 
      bool2 = paramObject instanceof Boolean;
      break;
    case 4: 
      bool2 = paramObject instanceof Double;
      break;
    case 3: 
      bool2 = paramObject instanceof Float;
      break;
    case 2: 
      bool2 = paramObject instanceof Long;
      break;
    case 1: 
      bool2 = paramObject instanceof Integer;
    }
    if (bool2) {
      return;
    }
    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
  }
  
  private static int zzb(zzkf paramzzkf, Object paramObject)
  {
    switch (zzgq.zzsg[paramzzkf.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 18: 
      if ((paramObject instanceof zzhb)) {
        return zzgf.zzbh(((zzhb)paramObject).zzah());
      }
      return zzgf.zzbh(((Integer)paramObject).intValue());
    case 17: 
      return zzgf.zzx(((Long)paramObject).longValue());
    case 16: 
      return zzgf.zzbe(((Integer)paramObject).intValue());
    case 15: 
      return zzgf.zzz(((Long)paramObject).longValue());
    case 14: 
      return zzgf.zzbg(((Integer)paramObject).intValue());
    case 13: 
      return zzgf.zzbd(((Integer)paramObject).intValue());
    case 12: 
      if ((paramObject instanceof zzfm)) {
        return zzgf.zzb((zzfm)paramObject);
      }
      return zzgf.zzf((byte[])paramObject);
    case 11: 
      if ((paramObject instanceof zzfm)) {
        return zzgf.zzb((zzfm)paramObject);
      }
      return zzgf.zzy((String)paramObject);
    case 10: 
      if ((paramObject instanceof zzhi)) {
        return zzgf.zza((zzhi)paramObject);
      }
      return zzgf.zzc((zzih)paramObject);
    case 9: 
      return zzgf.zzd((zzih)paramObject);
    case 8: 
      return zzgf.zzl(((Boolean)paramObject).booleanValue());
    case 7: 
      return zzgf.zzbf(((Integer)paramObject).intValue());
    case 6: 
      return zzgf.zzy(((Long)paramObject).longValue());
    case 5: 
      return zzgf.zzbc(((Integer)paramObject).intValue());
    case 4: 
      return zzgf.zzw(((Long)paramObject).longValue());
    case 3: 
      return zzgf.zzv(((Long)paramObject).longValue());
    case 2: 
      return zzgf.zzt(((Float)paramObject).floatValue());
    }
    return zzgf.zzb(((Double)paramObject).doubleValue());
  }
  
  private static <T extends zzgp<T>> boolean zzb(Map.Entry<T, Object> paramEntry)
  {
    zzgp localzzgp = (zzgp)paramEntry.getKey();
    if (localzzgp.zzfu() == zzki.zzade)
    {
      if (localzzgp.zzfv())
      {
        paramEntry = ((List)paramEntry.getValue()).iterator();
        do
        {
          if (!paramEntry.hasNext()) {
            break;
          }
        } while (((zzih)paramEntry.next()).isInitialized());
        return false;
      }
      paramEntry = paramEntry.getValue();
      if ((paramEntry instanceof zzih))
      {
        if (!((zzih)paramEntry).isInitialized()) {
          return false;
        }
      }
      else
      {
        if ((paramEntry instanceof zzhi)) {
          return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    return true;
  }
  
  public static int zzc(zzgp<?> paramzzgp, Object paramObject)
  {
    zzkf localzzkf = paramzzgp.zzft();
    int i = paramzzgp.zzah();
    if (paramzzgp.zzfv())
    {
      boolean bool = paramzzgp.zzfw();
      int j = 0;
      int k = 0;
      if (bool)
      {
        paramzzgp = ((List)paramObject).iterator();
        while (paramzzgp.hasNext()) {
          k += zzb(localzzkf, paramzzgp.next());
        }
        return zzgf.zzbb(i) + k + zzgf.zzbj(k);
      }
      paramzzgp = ((List)paramObject).iterator();
      k = j;
      while (paramzzgp.hasNext()) {
        k += zza(localzzkf, i, paramzzgp.next());
      }
      return k;
    }
    return zza(localzzkf, i, paramObject);
  }
  
  private final void zzc(Map.Entry<T, Object> paramEntry)
  {
    zzgp localzzgp = (zzgp)paramEntry.getKey();
    Object localObject1 = paramEntry.getValue();
    paramEntry = (Map.Entry<T, Object>)localObject1;
    if ((localObject1 instanceof zzhi))
    {
      paramEntry = (zzhi)localObject1;
      paramEntry = zzhi.zzgv();
    }
    if (localzzgp.zzfv())
    {
      Object localObject2 = zza(localzzgp);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      localObject2 = ((List)paramEntry).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramEntry = ((Iterator)localObject2).next();
        ((List)localObject1).add(zzi(paramEntry));
      }
      this.zztq.zza(localzzgp, localObject1);
      return;
    }
    if (localzzgp.zzfu() == zzki.zzade)
    {
      localObject1 = zza(localzzgp);
      if (localObject1 == null)
      {
        this.zztq.zza(localzzgp, zzi(paramEntry));
        return;
      }
      if ((localObject1 instanceof zzim)) {
        paramEntry = localzzgp.zza((zzim)localObject1, (zzim)paramEntry);
      } else {
        paramEntry = localzzgp.zza(((zzih)localObject1).zzgj(), (zzih)paramEntry).zzgd();
      }
      this.zztq.zza(localzzgp, paramEntry);
      return;
    }
    this.zztq.zza(localzzgp, zzi(paramEntry));
  }
  
  private static int zzd(Map.Entry<T, Object> paramEntry)
  {
    zzgp localzzgp = (zzgp)paramEntry.getKey();
    Object localObject = paramEntry.getValue();
    if ((localzzgp.zzfu() == zzki.zzade) && (!localzzgp.zzfv()) && (!localzzgp.zzfw()))
    {
      if ((localObject instanceof zzhi)) {
        return zzgf.zzb(((zzgp)paramEntry.getKey()).zzah(), (zzhi)localObject);
      }
      return zzgf.zzb(((zzgp)paramEntry.getKey()).zzah(), (zzih)localObject);
    }
    return zzc(localzzgp, localObject);
  }
  
  public static <T extends zzgp<T>> zzgn<T> zzfo()
  {
    return zztt;
  }
  
  private static Object zzi(Object paramObject)
  {
    if ((paramObject instanceof zzim)) {
      return ((zzim)paramObject).zzdn();
    }
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      byte[] arrayOfByte = new byte[paramObject.length];
      System.arraycopy(paramObject, 0, arrayOfByte, 0, paramObject.length);
      return arrayOfByte;
    }
    return paramObject;
  }
  
  final Iterator<Map.Entry<T, Object>> descendingIterator()
  {
    if (this.zzts) {
      return new zzhn(this.zztq.zzia().iterator());
    }
    return this.zztq.zzia().iterator();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzgn)) {
      return false;
    }
    paramObject = (zzgn)paramObject;
    return this.zztq.equals(((zzgn)paramObject).zztq);
  }
  
  public final int hashCode()
  {
    return this.zztq.hashCode();
  }
  
  public final boolean isImmutable()
  {
    return this.zztr;
  }
  
  public final boolean isInitialized()
  {
    for (int i = 0; i < this.zztq.zzhy(); i++) {
      if (!zzb(this.zztq.zzbv(i))) {
        return false;
      }
    }
    Iterator localIterator = this.zztq.zzhz().iterator();
    while (localIterator.hasNext()) {
      if (!zzb((Map.Entry)localIterator.next())) {
        return false;
      }
    }
    return true;
  }
  
  public final Iterator<Map.Entry<T, Object>> iterator()
  {
    if (this.zzts) {
      return new zzhn(this.zztq.entrySet().iterator());
    }
    return this.zztq.entrySet().iterator();
  }
  
  public final Object zza(T paramT)
  {
    Object localObject = this.zztq.get(paramT);
    paramT = (T)localObject;
    if ((localObject instanceof zzhi))
    {
      paramT = (zzhi)localObject;
      paramT = zzhi.zzgv();
    }
    return paramT;
  }
  
  public final void zza(zzgn<T> paramzzgn)
  {
    for (int i = 0; i < paramzzgn.zztq.zzhy(); i++) {
      zzc(paramzzgn.zztq.zzbv(i));
    }
    paramzzgn = paramzzgn.zztq.zzhz().iterator();
    while (paramzzgn.hasNext()) {
      zzc((Map.Entry)paramzzgn.next());
    }
  }
  
  public final void zza(T paramT, Object paramObject)
  {
    if (paramT.zzfv())
    {
      if ((paramObject instanceof List))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll((List)paramObject);
        int i = localArrayList.size();
        int j = 0;
        while (j < i)
        {
          paramObject = localArrayList.get(j);
          j++;
          zza(paramT.zzft(), paramObject);
        }
        paramObject = localArrayList;
      }
      else
      {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    else {
      zza(paramT.zzft(), paramObject);
    }
    if ((paramObject instanceof zzhi)) {
      this.zzts = true;
    }
    this.zztq.zza(paramT, paramObject);
  }
  
  public final void zzb(T paramT, Object paramObject)
  {
    if (paramT.zzfv())
    {
      zza(paramT.zzft(), paramObject);
      Object localObject = zza(paramT);
      if (localObject == null)
      {
        localObject = new ArrayList();
        this.zztq.zza(paramT, localObject);
        paramT = (T)localObject;
      }
      else
      {
        paramT = (List)localObject;
      }
      paramT.add(paramObject);
      return;
    }
    throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
  }
  
  public final void zzdq()
  {
    if (this.zztr) {
      return;
    }
    this.zztq.zzdq();
    this.zztr = true;
  }
  
  public final int zzfp()
  {
    int i = 0;
    int j = 0;
    while (i < this.zztq.zzhy())
    {
      j += zzd(this.zztq.zzbv(i));
      i++;
    }
    Iterator localIterator = this.zztq.zzhz().iterator();
    while (localIterator.hasNext()) {
      j += zzd((Map.Entry)localIterator.next());
    }
    return j;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzgn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */