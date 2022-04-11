package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

final class zzfl
  extends zzfj
{
  private final byte[] buffer;
  private int limit;
  private int pos;
  private int tag;
  private final boolean zzsj = true;
  private final int zzsk;
  private int zzsl;
  
  public zzfl(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    super(null);
    this.buffer = paramByteBuffer.array();
    int i = paramByteBuffer.arrayOffset() + paramByteBuffer.position();
    this.pos = i;
    this.zzsk = i;
    this.limit = (paramByteBuffer.arrayOffset() + paramByteBuffer.limit());
  }
  
  private final byte readByte()
    throws IOException
  {
    int i = this.pos;
    if (i != this.limit)
    {
      byte[] arrayOfByte = this.buffer;
      this.pos = (i + 1);
      return arrayOfByte[i];
    }
    throw zzhh.zzgn();
  }
  
  private final Object zza(zzkf paramzzkf, Class<?> paramClass, zzgi paramzzgi)
    throws IOException
  {
    switch (zzfi.zzsg[paramzzkf.ordinal()])
    {
    default: 
      throw new RuntimeException("unsupported field type.");
    case 17: 
      return Long.valueOf(zzdx());
    case 16: 
      return Integer.valueOf(zzef());
    case 15: 
      return zzj(true);
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
          if (zzdu()) {
            return;
          }
          i = this.pos;
        } while (zzel() == this.tag);
        this.pos = i;
        return;
      }
      do
      {
        paramList.add(zzj(paramBoolean));
        if (zzdu()) {
          return;
        }
        i = this.pos;
      } while (zzel() == this.tag);
      this.pos = i;
      return;
    }
    throw zzhh.zzgs();
  }
  
  private final void zzai(int paramInt)
    throws IOException
  {
    zzaj(paramInt);
    this.pos += paramInt;
  }
  
  private final void zzaj(int paramInt)
    throws IOException
  {
    if ((paramInt >= 0) && (paramInt <= this.limit - this.pos)) {
      return;
    }
    throw zzhh.zzgn();
  }
  
  private final void zzak(int paramInt)
    throws IOException
  {
    if ((this.tag & 0x7) == paramInt) {
      return;
    }
    throw zzhh.zzgs();
  }
  
  private final void zzal(int paramInt)
    throws IOException
  {
    zzaj(paramInt);
    if ((paramInt & 0x7) == 0) {
      return;
    }
    throw zzhh.zzgt();
  }
  
  private final void zzam(int paramInt)
    throws IOException
  {
    zzaj(paramInt);
    if ((paramInt & 0x3) == 0) {
      return;
    }
    throw zzhh.zzgt();
  }
  
  private final void zzan(int paramInt)
    throws IOException
  {
    if (this.pos == paramInt) {
      return;
    }
    throw zzhh.zzgn();
  }
  
  private final <T> T zzb(zziw<T> paramzziw, zzgi paramzzgi)
    throws IOException
  {
    int i = zzel();
    zzaj(i);
    int j = this.limit;
    i = this.pos + i;
    this.limit = i;
    try
    {
      Object localObject = paramzziw.newInstance();
      paramzziw.zza(localObject, this, paramzzgi);
      paramzziw.zzh(localObject);
      int k = this.pos;
      if (k == i) {
        return (T)localObject;
      }
      throw zzhh.zzgt();
    }
    finally
    {
      this.limit = j;
    }
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
  
  private final boolean zzdu()
  {
    return this.pos == this.limit;
  }
  
  private final int zzel()
    throws IOException
  {
    int i = this.pos;
    int j = this.limit;
    if (j != i)
    {
      byte[] arrayOfByte = this.buffer;
      int k = i + 1;
      i = arrayOfByte[i];
      if (i >= 0)
      {
        this.pos = k;
        return i;
      }
      if (j - k < 9) {
        return (int)zzen();
      }
      j = k + 1;
      i ^= arrayOfByte[k] << 7;
      if (i < 0)
      {
        k = i ^ 0xFFFFFF80;
      }
      else
      {
        k = j + 1;
        i ^= arrayOfByte[j] << 14;
        if (i >= 0)
        {
          i ^= 0x3F80;
          j = k;
          k = i;
        }
        for (;;)
        {
          break;
          j = k + 1;
          k = i ^ arrayOfByte[k] << 21;
          if (k < 0)
          {
            k ^= 0xFFE03F80;
          }
          else
          {
            int m = j + 1;
            int n = arrayOfByte[j];
            i = k ^ n << 28 ^ 0xFE03F80;
            k = i;
            j = m;
            if (n < 0)
            {
              n = m + 1;
              k = i;
              j = n;
              if (arrayOfByte[m] < 0)
              {
                m = n + 1;
                k = i;
                j = m;
                if (arrayOfByte[n] < 0)
                {
                  n = m + 1;
                  k = i;
                  j = n;
                  if (arrayOfByte[m] < 0)
                  {
                    m = n + 1;
                    k = i;
                    j = m;
                    if (arrayOfByte[n] < 0)
                    {
                      j = m + 1;
                      if (arrayOfByte[m] >= 0) {
                        k = i;
                      } else {
                        throw zzhh.zzgp();
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      this.pos = j;
      return k;
    }
    throw zzhh.zzgn();
  }
  
  private final long zzem()
    throws IOException
  {
    int i = this.pos;
    int j = this.limit;
    if (j != i)
    {
      byte[] arrayOfByte = this.buffer;
      int k = i + 1;
      i = arrayOfByte[i];
      if (i >= 0)
      {
        this.pos = k;
        return i;
      }
      if (j - k < 9) {
        return zzen();
      }
      j = k + 1;
      i ^= arrayOfByte[k] << 7;
      if (i < 0) {
        k = i ^ 0xFFFFFF80;
      }
      for (;;)
      {
        l1 = k;
        break label360;
        k = j + 1;
        i ^= arrayOfByte[j] << 14;
        if (i >= 0)
        {
          l1 = i ^ 0x3F80;
          j = k;
          break label360;
        }
        j = k + 1;
        k = i ^ arrayOfByte[k] << 21;
        if (k >= 0) {
          break;
        }
        k ^= 0xFFE03F80;
      }
      long l1 = k;
      k = j + 1;
      long l2 = l1 ^ arrayOfByte[j] << 28;
      if (l2 >= 0L)
      {
        l1 = 266354560L;
        j = k;
        l1 = l2 ^ l1;
      }
      else
      {
        j = k + 1;
        l2 ^= arrayOfByte[k] << 35;
        if (l2 < 0L) {}
        for (l1 = -34093383808L;; l1 = -558586000294016L)
        {
          l1 = l2 ^ l1;
          break label360;
          k = j + 1;
          l2 ^= arrayOfByte[j] << 42;
          if (l2 >= 0L)
          {
            l1 = 4363953127296L;
            j = k;
            break;
          }
          j = k + 1;
          l2 ^= arrayOfByte[k] << 49;
          if (l2 >= 0L) {
            break label307;
          }
        }
        label307:
        k = j + 1;
        l1 = l2 ^ arrayOfByte[j] << 56 ^ 0xFE03F80FE03F80;
        if (l1 < 0L)
        {
          j = k + 1;
          if (arrayOfByte[k] < 0L) {
            throw zzhh.zzgp();
          }
        }
        else
        {
          j = k;
        }
      }
      label360:
      this.pos = j;
      return l1;
    }
    throw zzhh.zzgn();
  }
  
  private final long zzen()
    throws IOException
  {
    long l = 0L;
    for (int i = 0; i < 64; i += 7)
    {
      int j = readByte();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
    }
    throw zzhh.zzgp();
  }
  
  private final int zzeo()
    throws IOException
  {
    zzaj(4);
    return zzeq();
  }
  
  private final long zzep()
    throws IOException
  {
    zzaj(8);
    return zzer();
  }
  
  private final int zzeq()
  {
    int i = this.pos;
    byte[] arrayOfByte = this.buffer;
    this.pos = (i + 4);
    int j = arrayOfByte[i];
    int k = arrayOfByte[(i + 1)];
    int m = arrayOfByte[(i + 2)];
    return (arrayOfByte[(i + 3)] & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
  }
  
  private final long zzer()
  {
    int i = this.pos;
    byte[] arrayOfByte = this.buffer;
    this.pos = (i + 8);
    long l1 = arrayOfByte[i];
    long l2 = arrayOfByte[(i + 1)];
    long l3 = arrayOfByte[(i + 2)];
    long l4 = arrayOfByte[(i + 3)];
    long l5 = arrayOfByte[(i + 4)];
    long l6 = arrayOfByte[(i + 5)];
    long l7 = arrayOfByte[(i + 6)];
    return (arrayOfByte[(i + 7)] & 0xFF) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
  }
  
  private final String zzj(boolean paramBoolean)
    throws IOException
  {
    zzak(2);
    int i = zzel();
    if (i == 0) {
      return "";
    }
    zzaj(i);
    if (paramBoolean)
    {
      localObject = this.buffer;
      int j = this.pos;
      if (!zzjx.zzf((byte[])localObject, j, j + i)) {
        throw zzhh.zzgu();
      }
    }
    Object localObject = new String(this.buffer, this.pos, i, zzgy.UTF_8);
    this.pos += i;
    return (String)localObject;
  }
  
  public final int getTag()
  {
    return this.tag;
  }
  
  public final double readDouble()
    throws IOException
  {
    zzak(1);
    return Double.longBitsToDouble(zzep());
  }
  
  public final float readFloat()
    throws IOException
  {
    zzak(5);
    return Float.intBitsToFloat(zzeo());
  }
  
  public final String readString()
    throws IOException
  {
    return zzj(false);
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
          i = zzel();
          zzal(i);
          j = this.pos;
          while (this.pos < j + i) {
            paramList.zzc(Double.longBitsToDouble(zzer()));
          }
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.zzc(readDouble());
        if (zzdu()) {
          return;
        }
        i = this.pos;
      } while (zzel() == this.tag);
      this.pos = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 1)
    {
      if (i == 2)
      {
        i = zzel();
        zzal(i);
        j = this.pos;
        while (this.pos < j + i) {
          paramList.add(Double.valueOf(Double.longBitsToDouble(zzer())));
        }
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Double.valueOf(readDouble()));
      if (zzdu()) {
        return;
      }
      i = this.pos;
    } while (zzel() == this.tag);
    this.pos = i;
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
        if (zzdu()) {
          return;
        }
        j = this.pos;
      } while (zzel() == i);
      this.pos = j;
      return;
    }
    throw zzhh.zzgs();
  }
  
  public final <K, V> void zza(Map<K, V> paramMap, zzhy<K, V> paramzzhy, zzgi paramzzgi)
    throws IOException
  {
    zzak(2);
    int i = zzel();
    zzaj(i);
    int j = this.limit;
    this.limit = (this.pos + i);
    try
    {
      Object localObject1 = paramzzhy.zzzc;
      Object localObject2 = paramzzhy.zzgl;
      do
      {
        for (;;)
        {
          i = zzdv();
          if (i == Integer.MAX_VALUE) {
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
      this.limit = j;
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
            paramList.zzu(readFloat());
            if (zzdu()) {
              return;
            }
            i = this.pos;
          } while (zzel() == this.tag);
          this.pos = i;
          return;
        }
        throw zzhh.zzgs();
      }
      i = zzel();
      zzam(i);
      j = this.pos;
      while (this.pos < j + i) {
        paramList.zzu(Float.intBitsToFloat(zzeq()));
      }
      return;
    }
    int i = this.tag & 0x7;
    if (i != 2)
    {
      if (i == 5)
      {
        do
        {
          paramList.add(Float.valueOf(readFloat()));
          if (zzdu()) {
            return;
          }
          i = this.pos;
        } while (zzel() == this.tag);
        this.pos = i;
        return;
      }
      throw zzhh.zzgs();
    }
    int j = zzel();
    zzam(j);
    i = this.pos;
    while (this.pos < i + j) {
      paramList.add(Float.valueOf(Float.intBitsToFloat(zzeq())));
    }
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
        if (zzdu()) {
          return;
        }
        j = this.pos;
      } while (zzel() == i);
      this.pos = j;
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
          i = zzel();
          i = this.pos + i;
          while (this.pos < i) {
            paramList.zzac(zzem());
          }
          zzan(i);
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.zzac(zzdx());
        if (zzdu()) {
          return;
        }
        i = this.pos;
      } while (zzel() == this.tag);
      this.pos = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = zzel();
        i = this.pos + i;
        while (this.pos < i) {
          paramList.add(Long.valueOf(zzem()));
        }
        zzan(i);
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Long.valueOf(zzdx()));
      if (zzdu()) {
        return;
      }
      i = this.pos;
    } while (zzel() == this.tag);
    this.pos = i;
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
          i = zzel();
          i = this.pos + i;
          while (this.pos < i) {
            paramList.zzac(zzem());
          }
          zzan(i);
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.zzac(zzdy());
        if (zzdu()) {
          return;
        }
        i = this.pos;
      } while (zzel() == this.tag);
      this.pos = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = zzel();
        i = this.pos + i;
        while (this.pos < i) {
          paramList.add(Long.valueOf(zzem()));
        }
        zzan(i);
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Long.valueOf(zzdy()));
      if (zzdu()) {
        return;
      }
      i = this.pos;
    } while (zzel() == this.tag);
    this.pos = i;
  }
  
  public final int zzdv()
    throws IOException
  {
    if (zzdu()) {
      return Integer.MAX_VALUE;
    }
    int i = zzel();
    this.tag = i;
    if (i == this.zzsl) {
      return Integer.MAX_VALUE;
    }
    return i >>> 3;
  }
  
  public final boolean zzdw()
    throws IOException
  {
    boolean bool = zzdu();
    int i = 0;
    if (!bool)
    {
      int j = this.tag;
      int k = this.zzsl;
      if (j != k)
      {
        int m = j & 0x7;
        if (m != 0)
        {
          if (m != 1)
          {
            if (m != 2)
            {
              if (m != 3)
              {
                if (m == 5)
                {
                  zzai(4);
                  return true;
                }
                throw zzhh.zzgs();
              }
              this.zzsl = (j >>> 3 << 3 | 0x4);
              while ((zzdv() != Integer.MAX_VALUE) && (zzdw())) {}
              if (this.tag == this.zzsl)
              {
                this.zzsl = k;
                return true;
              }
              throw zzhh.zzgt();
            }
            zzai(zzel());
            return true;
          }
          zzai(8);
          return true;
        }
        m = this.limit;
        k = this.pos;
        j = i;
        if (m - k >= 10)
        {
          byte[] arrayOfByte = this.buffer;
          m = 0;
          for (;;)
          {
            j = i;
            if (m >= 10) {
              break;
            }
            j = k + 1;
            if (arrayOfByte[k] >= 0)
            {
              this.pos = j;
              break label237;
            }
            m++;
            k = j;
          }
        }
        for (;;)
        {
          if (j >= 10) {
            break label239;
          }
          if (readByte() >= 0) {
            break;
          }
          j++;
        }
        label237:
        return true;
        label239:
        throw zzhh.zzgp();
      }
    }
    return false;
  }
  
  public final long zzdx()
    throws IOException
  {
    zzak(0);
    return zzem();
  }
  
  public final long zzdy()
    throws IOException
  {
    zzak(0);
    return zzem();
  }
  
  public final int zzdz()
    throws IOException
  {
    zzak(0);
    return zzel();
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
          i = zzel();
          i = this.pos + i;
          while (this.pos < i) {
            paramList.zzbm(zzel());
          }
          zzan(i);
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.zzbm(zzdz());
        if (zzdu()) {
          return;
        }
        i = this.pos;
      } while (zzel() == this.tag);
      this.pos = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = zzel();
        i = this.pos + i;
        while (this.pos < i) {
          paramList.add(Integer.valueOf(zzel()));
        }
        zzan(i);
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Integer.valueOf(zzdz()));
      if (zzdu()) {
        return;
      }
      i = this.pos;
    } while (zzel() == this.tag);
    this.pos = i;
  }
  
  public final long zzea()
    throws IOException
  {
    zzak(1);
    return zzep();
  }
  
  public final int zzeb()
    throws IOException
  {
    zzak(5);
    return zzeo();
  }
  
  public final boolean zzec()
    throws IOException
  {
    boolean bool = false;
    zzak(0);
    if (zzel() != 0) {
      bool = true;
    }
    return bool;
  }
  
  public final String zzed()
    throws IOException
  {
    return zzj(true);
  }
  
  public final zzfm zzee()
    throws IOException
  {
    zzak(2);
    int i = zzel();
    if (i == 0) {
      return zzfm.zzsm;
    }
    zzaj(i);
    zzfm localzzfm;
    if (this.zzsj) {
      localzzfm = zzfm.zzb(this.buffer, this.pos, i);
    } else {
      localzzfm = zzfm.zza(this.buffer, this.pos, i);
    }
    this.pos += i;
    return localzzfm;
  }
  
  public final int zzef()
    throws IOException
  {
    zzak(0);
    return zzel();
  }
  
  public final int zzeg()
    throws IOException
  {
    zzak(0);
    return zzel();
  }
  
  public final int zzeh()
    throws IOException
  {
    zzak(5);
    return zzeo();
  }
  
  public final long zzei()
    throws IOException
  {
    zzak(1);
    return zzep();
  }
  
  public final int zzej()
    throws IOException
  {
    zzak(0);
    return zzfy.zzav(zzel());
  }
  
  public final long zzek()
    throws IOException
  {
    zzak(0);
    return zzfy.zzr(zzem());
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
          j = zzel();
          zzal(j);
          i = this.pos;
          while (this.pos < i + j) {
            paramList.zzac(zzer());
          }
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.zzac(zzea());
        if (zzdu()) {
          return;
        }
        i = this.pos;
      } while (zzel() == this.tag);
      this.pos = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 1)
    {
      if (i == 2)
      {
        i = zzel();
        zzal(i);
        j = this.pos;
        while (this.pos < j + i) {
          paramList.add(Long.valueOf(zzer()));
        }
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Long.valueOf(zzea()));
      if (zzdu()) {
        return;
      }
      i = this.pos;
    } while (zzel() == this.tag);
    this.pos = i;
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
            paramList.zzbm(zzeb());
            if (zzdu()) {
              return;
            }
            i = this.pos;
          } while (zzel() == this.tag);
          this.pos = i;
          return;
        }
        throw zzhh.zzgs();
      }
      j = zzel();
      zzam(j);
      i = this.pos;
      while (this.pos < i + j) {
        paramList.zzbm(zzeq());
      }
      return;
    }
    int i = this.tag & 0x7;
    if (i != 2)
    {
      if (i == 5)
      {
        do
        {
          paramList.add(Integer.valueOf(zzeb()));
          if (zzdu()) {
            return;
          }
          i = this.pos;
        } while (zzel() == this.tag);
        this.pos = i;
        return;
      }
      throw zzhh.zzgs();
    }
    i = zzel();
    zzam(i);
    int j = this.pos;
    while (this.pos < j + i) {
      paramList.add(Integer.valueOf(zzeq()));
    }
  }
  
  public final void zzh(List<Boolean> paramList)
    throws IOException
  {
    boolean bool;
    if ((paramList instanceof zzfk))
    {
      paramList = (zzfk)paramList;
      i = this.tag & 0x7;
      if (i != 0)
      {
        if (i == 2)
        {
          i = zzel();
          i = this.pos + i;
          while (this.pos < i)
          {
            if (zzel() != 0) {
              bool = true;
            } else {
              bool = false;
            }
            paramList.addBoolean(bool);
          }
          zzan(i);
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.addBoolean(zzec());
        if (zzdu()) {
          return;
        }
        i = this.pos;
      } while (zzel() == this.tag);
      this.pos = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = zzel();
        i = this.pos + i;
        while (this.pos < i)
        {
          if (zzel() != 0) {
            bool = true;
          } else {
            bool = false;
          }
          paramList.add(Boolean.valueOf(bool));
        }
        zzan(i);
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Boolean.valueOf(zzec()));
      if (zzdu()) {
        return;
      }
      i = this.pos;
    } while (zzel() == this.tag);
    this.pos = i;
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
        if (zzdu()) {
          return;
        }
        i = this.pos;
      } while (zzel() == this.tag);
      this.pos = i;
      return;
    }
    throw zzhh.zzgs();
  }
  
  public final void zzk(List<Integer> paramList)
    throws IOException
  {
    int j;
    if ((paramList instanceof zzgz))
    {
      paramList = (zzgz)paramList;
      i = this.tag & 0x7;
      if (i != 0)
      {
        if (i == 2)
        {
          j = zzel();
          i = this.pos;
          while (this.pos < i + j) {
            paramList.zzbm(zzel());
          }
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.zzbm(zzef());
        if (zzdu()) {
          return;
        }
        i = this.pos;
      } while (zzel() == this.tag);
      this.pos = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        j = zzel();
        i = this.pos;
        while (this.pos < i + j) {
          paramList.add(Integer.valueOf(zzel()));
        }
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Integer.valueOf(zzef()));
      if (zzdu()) {
        return;
      }
      i = this.pos;
    } while (zzel() == this.tag);
    this.pos = i;
  }
  
  public final void zzl(List<Integer> paramList)
    throws IOException
  {
    int j;
    if ((paramList instanceof zzgz))
    {
      paramList = (zzgz)paramList;
      i = this.tag & 0x7;
      if (i != 0)
      {
        if (i == 2)
        {
          j = zzel();
          i = this.pos;
          while (this.pos < i + j) {
            paramList.zzbm(zzel());
          }
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.zzbm(zzeg());
        if (zzdu()) {
          return;
        }
        i = this.pos;
      } while (zzel() == this.tag);
      this.pos = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = zzel();
        j = this.pos;
        while (this.pos < j + i) {
          paramList.add(Integer.valueOf(zzel()));
        }
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Integer.valueOf(zzeg()));
      if (zzdu()) {
        return;
      }
      i = this.pos;
    } while (zzel() == this.tag);
    this.pos = i;
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
            paramList.zzbm(zzeh());
            if (zzdu()) {
              return;
            }
            i = this.pos;
          } while (zzel() == this.tag);
          this.pos = i;
          return;
        }
        throw zzhh.zzgs();
      }
      j = zzel();
      zzam(j);
      i = this.pos;
      while (this.pos < i + j) {
        paramList.zzbm(zzeq());
      }
      return;
    }
    int i = this.tag & 0x7;
    if (i != 2)
    {
      if (i == 5)
      {
        do
        {
          paramList.add(Integer.valueOf(zzeh()));
          if (zzdu()) {
            return;
          }
          i = this.pos;
        } while (zzel() == this.tag);
        this.pos = i;
        return;
      }
      throw zzhh.zzgs();
    }
    i = zzel();
    zzam(i);
    int j = this.pos;
    while (this.pos < j + i) {
      paramList.add(Integer.valueOf(zzeq()));
    }
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
          j = zzel();
          zzal(j);
          i = this.pos;
          while (this.pos < i + j) {
            paramList.zzac(zzer());
          }
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.zzac(zzei());
        if (zzdu()) {
          return;
        }
        i = this.pos;
      } while (zzel() == this.tag);
      this.pos = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 1)
    {
      if (i == 2)
      {
        i = zzel();
        zzal(i);
        j = this.pos;
        while (this.pos < j + i) {
          paramList.add(Long.valueOf(zzer()));
        }
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Long.valueOf(zzei()));
      if (zzdu()) {
        return;
      }
      i = this.pos;
    } while (zzel() == this.tag);
    this.pos = i;
  }
  
  public final void zzo(List<Integer> paramList)
    throws IOException
  {
    int j;
    if ((paramList instanceof zzgz))
    {
      paramList = (zzgz)paramList;
      i = this.tag & 0x7;
      if (i != 0)
      {
        if (i == 2)
        {
          i = zzel();
          j = this.pos;
          while (this.pos < j + i) {
            paramList.zzbm(zzfy.zzav(zzel()));
          }
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.zzbm(zzej());
        if (zzdu()) {
          return;
        }
        i = this.pos;
      } while (zzel() == this.tag);
      this.pos = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = zzel();
        j = this.pos;
        while (this.pos < j + i) {
          paramList.add(Integer.valueOf(zzfy.zzav(zzel())));
        }
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Integer.valueOf(zzej()));
      if (zzdu()) {
        return;
      }
      i = this.pos;
    } while (zzel() == this.tag);
    this.pos = i;
  }
  
  public final void zzp(List<Long> paramList)
    throws IOException
  {
    int j;
    if ((paramList instanceof zzhv))
    {
      paramList = (zzhv)paramList;
      i = this.tag & 0x7;
      if (i != 0)
      {
        if (i == 2)
        {
          i = zzel();
          j = this.pos;
          while (this.pos < j + i) {
            paramList.zzac(zzfy.zzr(zzem()));
          }
          return;
        }
        throw zzhh.zzgs();
      }
      do
      {
        paramList.zzac(zzek());
        if (zzdu()) {
          return;
        }
        i = this.pos;
      } while (zzel() == this.tag);
      this.pos = i;
      return;
    }
    int i = this.tag & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = zzel();
        j = this.pos;
        while (this.pos < j + i) {
          paramList.add(Long.valueOf(zzfy.zzr(zzem())));
        }
        return;
      }
      throw zzhh.zzgs();
    }
    do
    {
      paramList.add(Long.valueOf(zzek()));
      if (zzdu()) {
        return;
      }
      i = this.pos;
    } while (zzel() == this.tag);
    this.pos = i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzfl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */