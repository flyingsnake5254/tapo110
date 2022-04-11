package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzgd
  implements zzix
{
  private int tag;
  private int zzsl;
  private final zzfy zzte;
  private int zztf = 0;
  
  private zzgd(zzfy paramzzfy)
  {
    paramzzfy = (zzfy)zzgy.zza(paramzzfy, "input");
    this.zzte = paramzzfy;
    paramzzfy.zzsx = this;
  }
  
  public static zzgd zza(zzfy paramzzfy)
  {
    zzgd localzzgd = paramzzfy.zzsx;
    if (localzzgd != null) {
      return localzzgd;
    }
    return new zzgd(paramzzfy);
  }
  
  private final Object zza(zzkf paramzzkf, Class<?> paramClass, zzgi paramzzgi)
    throws IOException
  {
    switch (zzgc.zzsg[paramzzkf.ordinal()])
    {
    default: 
      throw new RuntimeException("unsupported field type.");
    case 17: 
      return Long.valueOf(zzdx());
    case 16: 
      return Integer.valueOf(zzef());
    case 15: 
      return zzed();
    case 14: 
      return Long.valueOf(zzek());
    case 13: 
      return Integer.valueOf(zzej());
    case 12: 
      return Long.valueOf(zzei());
    case 11: 
      return Integer.valueOf(zzeh());
    case 10: 
      return zza(paramClass, paramzzgi);
    case 9: 
      return Long.valueOf(zzdy());
    case 8: 
      return Integer.valueOf(zzdz());
    case 7: 
      return Float.valueOf(readFloat());
    case 6: 
      return Long.valueOf(zzea());
    case 5: 
      return Integer.valueOf(zzeb());
    case 4: 
      return Integer.valueOf(zzeg());
    case 3: 
      return Double.valueOf(readDouble());
    case 2: 
      return zzee();
    }
    return Boolean.valueOf(zzec());
  }
  
  private final void zza(List<String> paramList, boolean paramBoolean)
    throws IOException
  {
    if ((this.tag & 0x7) == 2)
    {
      int i;
      if (((paramList instanceof zzho)) && (!paramBoolean))
      {
        paramList = (zzho)paramList;
        do
        {
          paramList.zzc(zzee());
          if (this.zzte.zzdu()) {
            return;
          }
          i = this.zzte.zzey();
        } while (i == this.tag);
        this.zztf = i;
        return;
      }
      do
      {
        String str;
        if (paramBoolean) {
          str = zzed();
        } else {
          str = readString();
        }
        paramList.add(str);
        if (this.zzte.zzdu()) {
          return;
        }
        i = this.zzte.zzey();
      } while (i == this.tag);
      this.zztf = i;
      return;
    }
    throw zzhh.zzgs();
  }
  
  private final void zzak(int paramInt)
    throws IOException
  {
    if ((this.tag & 0x7) == paramInt) {
      return;
    }
    throw zzhh.zzgs();
  }
  
  private static void zzal(int paramInt)
    throws IOException
  {
    if ((paramInt & 0x7) == 0) {
      return;
    }
    throw zzhh.zzgt();
  }
  
  private static void zzam(int paramInt)
    throws IOException
  {
    if ((paramInt & 0x3) == 0) {
      return;
    }
    throw zzhh.zzgt();
  }
  
  private final void zzan(int paramInt)
    throws IOException
  {
    if (this.zzte.zzfa() == paramInt) {
      return;
    }
    throw zzhh.zzgn();
  }
  
  private final <T> T zzb(zziw<T> paramzziw, zzgi paramzzgi)
    throws IOException
  {
    int i = this.zzte.zzef();
    Object localObject = this.zzte;
    if (((zzfy)localObject).zzsu < ((zzfy)localObject).zzsv)
    {
      i = ((zzfy)localObject).zzat(i);
      localObject = paramzziw.newInstance();
      zzfy localzzfy = this.zzte;
      localzzfy.zzsu += 1;
      paramzziw.zza(localObject, this, paramzzgi);
      paramzziw.zzh(localObject);
      this.zzte.zzar(0);
      paramzziw = this.zzte;
      paramzziw.zzsu -= 1;
      paramzziw.zzau(i);
      return (T)localObject;
    }
    throw new zzhh("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
  
  private final <T> T zzd(zziw<T> paramzziw, zzgi paramzzgi)
    throws IOException
  {
    int i = this.zzsl;
    this.zzsl = (this.tag >>> 3 << 3 | 0x4);
    try
    {
      Object localObject = paramzziw.newInstance();
      paramzziw.zza(localObject, this, paramzzgi);
      paramzziw.zzh(localObject);
      int j = this.tag;
      int k = this.zzsl;
      if (j == k) {
        return (T)localObject;
      }
      throw zzhh.zzgt();
    }
    finally
    {
      this.zzsl = i;
    }
  }
  
  public final int getTag()
  {
    return this.tag;
  }
  
  public final double readDouble()
    throws IOException
  {
    zzak(1);
    return this.zzte.readDouble();
  }
  
  public final float readFloat()
    throws IOException
  {
    zzak(5);
    return this.zzte.readFloat();
  }
  
  public final String readString()
    throws IOException
  {
    zzak(2);
    return this.zzte.readString();
  }
  
  public final void readStringList(List<String> paramList)
    throws IOException
  {
    zza(paramList, false);
  }
  
  public final <T> T zza(zziw<T> paramzziw, zzgi paramzzgi)
    throws IOException
  {
    zzak(2);
    return (T)zzb(paramzziw, paramzzgi);
  }
  
  public final <T> T zza(Class<T> paramClass, zzgi paramzzgi)
    throws IOException
  {
    zzak(2);
    return (T)zzb(zzis.zzhp().zzf(paramClass), paramzzgi);
  }
  
  public final void zza(List<Double> paramList)
    throws IOException
  {
    int j;
    if ((paramList instanceof zzgg))
    {
      paramList = (zzgg)paramList;
      i = this.tag & 0x7;
      if (i != 1)
      {
        if (i == 2)
        {
          i = this.zzte.zzef();
          zzal(i);
          j = this.zzte.zzfa();
          do
          {
            paramList.zzc(this.zzte.readDouble());
          } while (this.zzte.zzfa() < j + i);
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.zzc(this.zzte.readDouble());
        if (this.zzte.zzdu()) {
          return;
        }
        i = this.zzte.zzey();
      } while (i == this.tag);
      this.zztf = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 1)
    {
      if (i == 2)
      {
        i = this.zzte.zzef();
        zzal(i);
        j = this.zzte.zzfa();
        do
        {
          paramList.add(Double.valueOf(this.zzte.readDouble()));
        } while (this.zzte.zzfa() < j + i);
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Double.valueOf(this.zzte.readDouble()));
      if (this.zzte.zzdu()) {
        return;
      }
      i = this.zzte.zzey();
    } while (i == this.tag);
    this.zztf = i;
  }
  
  public final <T> void zza(List<T> paramList, zziw<T> paramzziw, zzgi paramzzgi)
    throws IOException
  {
    int i = this.tag;
    if ((i & 0x7) == 2)
    {
      int j;
      do
      {
        paramList.add(zzb(paramzziw, paramzzgi));
        if ((this.zzte.zzdu()) || (this.zztf != 0)) {
          break;
        }
        j = this.zzte.zzey();
      } while (j == i);
      this.zztf = j;
      return;
    }
    throw zzhh.zzgs();
  }
  
  public final <K, V> void zza(Map<K, V> paramMap, zzhy<K, V> paramzzhy, zzgi paramzzgi)
    throws IOException
  {
    zzak(2);
    int i = this.zzte.zzef();
    int j = this.zzte.zzat(i);
    Object localObject1 = paramzzhy.zzzc;
    Object localObject2 = paramzzhy.zzgl;
    try
    {
      do
      {
        for (;;)
        {
          i = zzdv();
          if (i == Integer.MAX_VALUE) {
            break;
          }
          boolean bool = this.zzte.zzdu();
          if (bool) {
            break;
          }
          if ((i == 1) || (i != 2)) {}
          try
          {
            if (zzdw()) {
              continue;
            }
            localObject3 = new com/google/android/gms/internal/vision/zzhh;
            ((zzhh)localObject3).<init>("Unable to parse map entry.");
            throw ((Throwable)localObject3);
          }
          catch (zzhg localzzhg) {}
          Object localObject3 = zza(paramzzhy.zzzd, paramzzhy.zzgl.getClass(), paramzzgi);
          localObject2 = localObject3;
          continue;
          localObject3 = zza(paramzzhy.zzzb, null, null);
          localObject1 = localObject3;
        }
      } while (zzdw());
      paramMap = new com/google/android/gms/internal/vision/zzhh;
      paramMap.<init>("Unable to parse map entry.");
      throw paramMap;
      paramMap.put(localObject1, localObject2);
      return;
    }
    finally
    {
      this.zzte.zzau(j);
    }
  }
  
  public final <T> T zzb(Class<T> paramClass, zzgi paramzzgi)
    throws IOException
  {
    zzak(3);
    return (T)zzd(zzis.zzhp().zzf(paramClass), paramzzgi);
  }
  
  public final void zzb(List<Float> paramList)
    throws IOException
  {
    if ((paramList instanceof zzgt))
    {
      paramList = (zzgt)paramList;
      i = this.tag & 0x7;
      if (i != 2)
      {
        if (i == 5)
        {
          do
          {
            paramList.zzu(this.zzte.readFloat());
            if (this.zzte.zzdu()) {
              return;
            }
            i = this.zzte.zzey();
          } while (i == this.tag);
          this.zztf = i;
          return;
        }
        throw zzhh.zzgs();
      }
      i = this.zzte.zzef();
      zzam(i);
      j = this.zzte.zzfa();
      do
      {
        paramList.zzu(this.zzte.readFloat());
      } while (this.zzte.zzfa() < j + i);
      return;
    }
    int i = this.tag & 0x7;
    if (i != 2)
    {
      if (i == 5)
      {
        do
        {
          paramList.add(Float.valueOf(this.zzte.readFloat()));
          if (this.zzte.zzdu()) {
            return;
          }
          i = this.zzte.zzey();
        } while (i == this.tag);
        this.zztf = i;
        return;
      }
      throw zzhh.zzgs();
    }
    i = this.zzte.zzef();
    zzam(i);
    int j = this.zzte.zzfa();
    do
    {
      paramList.add(Float.valueOf(this.zzte.readFloat()));
    } while (this.zzte.zzfa() < j + i);
  }
  
  public final <T> void zzb(List<T> paramList, zziw<T> paramzziw, zzgi paramzzgi)
    throws IOException
  {
    int i = this.tag;
    if ((i & 0x7) == 3)
    {
      int j;
      do
      {
        paramList.add(zzd(paramzziw, paramzzgi));
        if ((this.zzte.zzdu()) || (this.zztf != 0)) {
          break;
        }
        j = this.zzte.zzey();
      } while (j == i);
      this.zztf = j;
      return;
    }
    throw zzhh.zzgs();
  }
  
  public final <T> T zzc(zziw<T> paramzziw, zzgi paramzzgi)
    throws IOException
  {
    zzak(3);
    return (T)zzd(paramzziw, paramzzgi);
  }
  
  public final void zzc(List<Long> paramList)
    throws IOException
  {
    if ((paramList instanceof zzhv))
    {
      paramList = (zzhv)paramList;
      i = this.tag & 0x7;
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.zzte.zzef();
          i = this.zzte.zzfa() + i;
          do
          {
            paramList.zzac(this.zzte.zzdx());
          } while (this.zzte.zzfa() < i);
          zzan(i);
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.zzac(this.zzte.zzdx());
        if (this.zzte.zzdu()) {
          return;
        }
        i = this.zzte.zzey();
      } while (i == this.tag);
      this.zztf = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.zzte.zzef();
        i = this.zzte.zzfa() + i;
        do
        {
          paramList.add(Long.valueOf(this.zzte.zzdx()));
        } while (this.zzte.zzfa() < i);
        zzan(i);
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Long.valueOf(this.zzte.zzdx()));
      if (this.zzte.zzdu()) {
        return;
      }
      i = this.zzte.zzey();
    } while (i == this.tag);
    this.zztf = i;
  }
  
  public final void zzd(List<Long> paramList)
    throws IOException
  {
    if ((paramList instanceof zzhv))
    {
      paramList = (zzhv)paramList;
      i = this.tag & 0x7;
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.zzte.zzef();
          i = this.zzte.zzfa() + i;
          do
          {
            paramList.zzac(this.zzte.zzdy());
          } while (this.zzte.zzfa() < i);
          zzan(i);
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.zzac(this.zzte.zzdy());
        if (this.zzte.zzdu()) {
          return;
        }
        i = this.zzte.zzey();
      } while (i == this.tag);
      this.zztf = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.zzte.zzef();
        i = this.zzte.zzfa() + i;
        do
        {
          paramList.add(Long.valueOf(this.zzte.zzdy()));
        } while (this.zzte.zzfa() < i);
        zzan(i);
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Long.valueOf(this.zzte.zzdy()));
      if (this.zzte.zzdu()) {
        return;
      }
      i = this.zzte.zzey();
    } while (i == this.tag);
    this.zztf = i;
  }
  
  public final int zzdv()
    throws IOException
  {
    int i = this.zztf;
    if (i != 0)
    {
      this.tag = i;
      this.zztf = 0;
    }
    else
    {
      this.tag = this.zzte.zzey();
    }
    i = this.tag;
    if ((i != 0) && (i != this.zzsl)) {
      return i >>> 3;
    }
    return Integer.MAX_VALUE;
  }
  
  public final boolean zzdw()
    throws IOException
  {
    if (!this.zzte.zzdu())
    {
      int i = this.tag;
      if (i != this.zzsl) {
        return this.zzte.zzas(i);
      }
    }
    return false;
  }
  
  public final long zzdx()
    throws IOException
  {
    zzak(0);
    return this.zzte.zzdx();
  }
  
  public final long zzdy()
    throws IOException
  {
    zzak(0);
    return this.zzte.zzdy();
  }
  
  public final int zzdz()
    throws IOException
  {
    zzak(0);
    return this.zzte.zzdz();
  }
  
  public final void zze(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzgz))
    {
      paramList = (zzgz)paramList;
      i = this.tag & 0x7;
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.zzte.zzef();
          i = this.zzte.zzfa() + i;
          do
          {
            paramList.zzbm(this.zzte.zzdz());
          } while (this.zzte.zzfa() < i);
          zzan(i);
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.zzbm(this.zzte.zzdz());
        if (this.zzte.zzdu()) {
          return;
        }
        i = this.zzte.zzey();
      } while (i == this.tag);
      this.zztf = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.zzte.zzef();
        i = this.zzte.zzfa() + i;
        do
        {
          paramList.add(Integer.valueOf(this.zzte.zzdz()));
        } while (this.zzte.zzfa() < i);
        zzan(i);
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Integer.valueOf(this.zzte.zzdz()));
      if (this.zzte.zzdu()) {
        return;
      }
      i = this.zzte.zzey();
    } while (i == this.tag);
    this.zztf = i;
  }
  
  public final long zzea()
    throws IOException
  {
    zzak(1);
    return this.zzte.zzea();
  }
  
  public final int zzeb()
    throws IOException
  {
    zzak(5);
    return this.zzte.zzeb();
  }
  
  public final boolean zzec()
    throws IOException
  {
    zzak(0);
    return this.zzte.zzec();
  }
  
  public final String zzed()
    throws IOException
  {
    zzak(2);
    return this.zzte.zzed();
  }
  
  public final zzfm zzee()
    throws IOException
  {
    zzak(2);
    return this.zzte.zzee();
  }
  
  public final int zzef()
    throws IOException
  {
    zzak(0);
    return this.zzte.zzef();
  }
  
  public final int zzeg()
    throws IOException
  {
    zzak(0);
    return this.zzte.zzeg();
  }
  
  public final int zzeh()
    throws IOException
  {
    zzak(5);
    return this.zzte.zzeh();
  }
  
  public final long zzei()
    throws IOException
  {
    zzak(1);
    return this.zzte.zzei();
  }
  
  public final int zzej()
    throws IOException
  {
    zzak(0);
    return this.zzte.zzej();
  }
  
  public final long zzek()
    throws IOException
  {
    zzak(0);
    return this.zzte.zzek();
  }
  
  public final void zzf(List<Long> paramList)
    throws IOException
  {
    int j;
    if ((paramList instanceof zzhv))
    {
      paramList = (zzhv)paramList;
      i = this.tag & 0x7;
      if (i != 1)
      {
        if (i == 2)
        {
          i = this.zzte.zzef();
          zzal(i);
          j = this.zzte.zzfa();
          do
          {
            paramList.zzac(this.zzte.zzea());
          } while (this.zzte.zzfa() < j + i);
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.zzac(this.zzte.zzea());
        if (this.zzte.zzdu()) {
          return;
        }
        i = this.zzte.zzey();
      } while (i == this.tag);
      this.zztf = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 1)
    {
      if (i == 2)
      {
        i = this.zzte.zzef();
        zzal(i);
        j = this.zzte.zzfa();
        do
        {
          paramList.add(Long.valueOf(this.zzte.zzea()));
        } while (this.zzte.zzfa() < j + i);
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Long.valueOf(this.zzte.zzea()));
      if (this.zzte.zzdu()) {
        return;
      }
      i = this.zzte.zzey();
    } while (i == this.tag);
    this.zztf = i;
  }
  
  public final void zzg(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzgz))
    {
      paramList = (zzgz)paramList;
      i = this.tag & 0x7;
      if (i != 2)
      {
        if (i == 5)
        {
          do
          {
            paramList.zzbm(this.zzte.zzeb());
            if (this.zzte.zzdu()) {
              return;
            }
            i = this.zzte.zzey();
          } while (i == this.tag);
          this.zztf = i;
          return;
        }
        throw zzhh.zzgs();
      }
      i = this.zzte.zzef();
      zzam(i);
      j = this.zzte.zzfa();
      do
      {
        paramList.zzbm(this.zzte.zzeb());
      } while (this.zzte.zzfa() < j + i);
      return;
    }
    int i = this.tag & 0x7;
    if (i != 2)
    {
      if (i == 5)
      {
        do
        {
          paramList.add(Integer.valueOf(this.zzte.zzeb()));
          if (this.zzte.zzdu()) {
            return;
          }
          i = this.zzte.zzey();
        } while (i == this.tag);
        this.zztf = i;
        return;
      }
      throw zzhh.zzgs();
    }
    int j = this.zzte.zzef();
    zzam(j);
    i = this.zzte.zzfa();
    do
    {
      paramList.add(Integer.valueOf(this.zzte.zzeb()));
    } while (this.zzte.zzfa() < i + j);
  }
  
  public final void zzh(List<Boolean> paramList)
    throws IOException
  {
    if ((paramList instanceof zzfk))
    {
      paramList = (zzfk)paramList;
      i = this.tag & 0x7;
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.zzte.zzef();
          i = this.zzte.zzfa() + i;
          do
          {
            paramList.addBoolean(this.zzte.zzec());
          } while (this.zzte.zzfa() < i);
          zzan(i);
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.addBoolean(this.zzte.zzec());
        if (this.zzte.zzdu()) {
          return;
        }
        i = this.zzte.zzey();
      } while (i == this.tag);
      this.zztf = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.zzte.zzef();
        i = this.zzte.zzfa() + i;
        do
        {
          paramList.add(Boolean.valueOf(this.zzte.zzec()));
        } while (this.zzte.zzfa() < i);
        zzan(i);
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Boolean.valueOf(this.zzte.zzec()));
      if (this.zzte.zzdu()) {
        return;
      }
      i = this.zzte.zzey();
    } while (i == this.tag);
    this.zztf = i;
  }
  
  public final void zzi(List<String> paramList)
    throws IOException
  {
    zza(paramList, true);
  }
  
  public final void zzj(List<zzfm> paramList)
    throws IOException
  {
    if ((this.tag & 0x7) == 2)
    {
      int i;
      do
      {
        paramList.add(zzee());
        if (this.zzte.zzdu()) {
          return;
        }
        i = this.zzte.zzey();
      } while (i == this.tag);
      this.zztf = i;
      return;
    }
    throw zzhh.zzgs();
  }
  
  public final void zzk(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzgz))
    {
      paramList = (zzgz)paramList;
      i = this.tag & 0x7;
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.zzte.zzef();
          i = this.zzte.zzfa() + i;
          do
          {
            paramList.zzbm(this.zzte.zzef());
          } while (this.zzte.zzfa() < i);
          zzan(i);
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.zzbm(this.zzte.zzef());
        if (this.zzte.zzdu()) {
          return;
        }
        i = this.zzte.zzey();
      } while (i == this.tag);
      this.zztf = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.zzte.zzef();
        i = this.zzte.zzfa() + i;
        do
        {
          paramList.add(Integer.valueOf(this.zzte.zzef()));
        } while (this.zzte.zzfa() < i);
        zzan(i);
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Integer.valueOf(this.zzte.zzef()));
      if (this.zzte.zzdu()) {
        return;
      }
      i = this.zzte.zzey();
    } while (i == this.tag);
    this.zztf = i;
  }
  
  public final void zzl(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzgz))
    {
      paramList = (zzgz)paramList;
      i = this.tag & 0x7;
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.zzte.zzef();
          i = this.zzte.zzfa() + i;
          do
          {
            paramList.zzbm(this.zzte.zzeg());
          } while (this.zzte.zzfa() < i);
          zzan(i);
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.zzbm(this.zzte.zzeg());
        if (this.zzte.zzdu()) {
          return;
        }
        i = this.zzte.zzey();
      } while (i == this.tag);
      this.zztf = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.zzte.zzef();
        i = this.zzte.zzfa() + i;
        do
        {
          paramList.add(Integer.valueOf(this.zzte.zzeg()));
        } while (this.zzte.zzfa() < i);
        zzan(i);
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Integer.valueOf(this.zzte.zzeg()));
      if (this.zzte.zzdu()) {
        return;
      }
      i = this.zzte.zzey();
    } while (i == this.tag);
    this.zztf = i;
  }
  
  public final void zzm(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzgz))
    {
      paramList = (zzgz)paramList;
      i = this.tag & 0x7;
      if (i != 2)
      {
        if (i == 5)
        {
          do
          {
            paramList.zzbm(this.zzte.zzeh());
            if (this.zzte.zzdu()) {
              return;
            }
            i = this.zzte.zzey();
          } while (i == this.tag);
          this.zztf = i;
          return;
        }
        throw zzhh.zzgs();
      }
      j = this.zzte.zzef();
      zzam(j);
      i = this.zzte.zzfa();
      do
      {
        paramList.zzbm(this.zzte.zzeh());
      } while (this.zzte.zzfa() < i + j);
      return;
    }
    int i = this.tag & 0x7;
    if (i != 2)
    {
      if (i == 5)
      {
        do
        {
          paramList.add(Integer.valueOf(this.zzte.zzeh()));
          if (this.zzte.zzdu()) {
            return;
          }
          i = this.zzte.zzey();
        } while (i == this.tag);
        this.zztf = i;
        return;
      }
      throw zzhh.zzgs();
    }
    i = this.zzte.zzef();
    zzam(i);
    int j = this.zzte.zzfa();
    do
    {
      paramList.add(Integer.valueOf(this.zzte.zzeh()));
    } while (this.zzte.zzfa() < j + i);
  }
  
  public final void zzn(List<Long> paramList)
    throws IOException
  {
    int j;
    if ((paramList instanceof zzhv))
    {
      paramList = (zzhv)paramList;
      i = this.tag & 0x7;
      if (i != 1)
      {
        if (i == 2)
        {
          i = this.zzte.zzef();
          zzal(i);
          j = this.zzte.zzfa();
          do
          {
            paramList.zzac(this.zzte.zzei());
          } while (this.zzte.zzfa() < j + i);
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.zzac(this.zzte.zzei());
        if (this.zzte.zzdu()) {
          return;
        }
        i = this.zzte.zzey();
      } while (i == this.tag);
      this.zztf = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 1)
    {
      if (i == 2)
      {
        j = this.zzte.zzef();
        zzal(j);
        i = this.zzte.zzfa();
        do
        {
          paramList.add(Long.valueOf(this.zzte.zzei()));
        } while (this.zzte.zzfa() < i + j);
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Long.valueOf(this.zzte.zzei()));
      if (this.zzte.zzdu()) {
        return;
      }
      i = this.zzte.zzey();
    } while (i == this.tag);
    this.zztf = i;
  }
  
  public final void zzo(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzgz))
    {
      paramList = (zzgz)paramList;
      i = this.tag & 0x7;
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.zzte.zzef();
          i = this.zzte.zzfa() + i;
          do
          {
            paramList.zzbm(this.zzte.zzej());
          } while (this.zzte.zzfa() < i);
          zzan(i);
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.zzbm(this.zzte.zzej());
        if (this.zzte.zzdu()) {
          return;
        }
        i = this.zzte.zzey();
      } while (i == this.tag);
      this.zztf = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.zzte.zzef();
        i = this.zzte.zzfa() + i;
        do
        {
          paramList.add(Integer.valueOf(this.zzte.zzej()));
        } while (this.zzte.zzfa() < i);
        zzan(i);
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Integer.valueOf(this.zzte.zzej()));
      if (this.zzte.zzdu()) {
        return;
      }
      i = this.zzte.zzey();
    } while (i == this.tag);
    this.zztf = i;
  }
  
  public final void zzp(List<Long> paramList)
    throws IOException
  {
    if ((paramList instanceof zzhv))
    {
      paramList = (zzhv)paramList;
      i = this.tag & 0x7;
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.zzte.zzef();
          i = this.zzte.zzfa() + i;
          do
          {
            paramList.zzac(this.zzte.zzek());
          } while (this.zzte.zzfa() < i);
          zzan(i);
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.zzac(this.zzte.zzek());
        if (this.zzte.zzdu()) {
          return;
        }
        i = this.zzte.zzey();
      } while (i == this.tag);
      this.zztf = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.zzte.zzef();
        i = this.zzte.zzfa() + i;
        do
        {
          paramList.add(Long.valueOf(this.zzte.zzek()));
        } while (this.zzte.zzfa() < i);
        zzan(i);
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Long.valueOf(this.zzte.zzek()));
      if (this.zzte.zzdu()) {
        return;
      }
      i = this.zzte.zzey();
    } while (i == this.tag);
    this.zztf = i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzgd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */