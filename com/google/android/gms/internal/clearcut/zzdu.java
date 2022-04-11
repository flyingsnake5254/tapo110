package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzdu<T>
  implements zzef<T>
{
  private final zzdo zzmn;
  private final boolean zzmo;
  private final zzex<?, ?> zzmx;
  private final zzbu<?> zzmy;
  
  private zzdu(zzex<?, ?> paramzzex, zzbu<?> paramzzbu, zzdo paramzzdo)
  {
    this.zzmx = paramzzex;
    this.zzmo = paramzzbu.zze(paramzzdo);
    this.zzmy = paramzzbu;
    this.zzmn = paramzzdo;
  }
  
  static <T> zzdu<T> zza(zzex<?, ?> paramzzex, zzbu<?> paramzzbu, zzdo paramzzdo)
  {
    return new zzdu(paramzzex, paramzzbu, paramzzdo);
  }
  
  public final boolean equals(T paramT1, T paramT2)
  {
    if (!this.zzmx.zzq(paramT1).equals(this.zzmx.zzq(paramT2))) {
      return false;
    }
    if (this.zzmo) {
      return this.zzmy.zza(paramT1).equals(this.zzmy.zza(paramT2));
    }
    return true;
  }
  
  public final int hashCode(T paramT)
  {
    int i = this.zzmx.zzq(paramT).hashCode();
    int j = i;
    if (this.zzmo) {
      j = i * 53 + this.zzmy.zza(paramT).hashCode();
    }
    return j;
  }
  
  public final T newInstance()
  {
    return this.zzmn.zzbd().zzbi();
  }
  
  public final void zza(T paramT, zzfr paramzzfr)
    throws IOException
  {
    Iterator localIterator = this.zzmy.zza(paramT).iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      zzca localzzca = (zzca)((Map.Entry)localObject).getKey();
      if ((localzzca.zzav() == zzfq.zzrf) && (!localzzca.zzaw()) && (!localzzca.zzax()))
      {
        boolean bool = localObject instanceof zzct;
        int i = localzzca.zzc();
        if (bool) {
          localObject = ((zzct)localObject).zzbs().zzr();
        } else {
          localObject = ((Map.Entry)localObject).getValue();
        }
        paramzzfr.zza(i, localObject);
      }
      else
      {
        throw new IllegalStateException("Found invalid MessageSet item.");
      }
    }
    Object localObject = this.zzmx;
    ((zzex)localObject).zzc(((zzex)localObject).zzq(paramT), paramzzfr);
  }
  
  public final void zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzay paramzzay)
    throws IOException
  {
    zzcg localzzcg = (zzcg)paramT;
    Object localObject = localzzcg.zzjp;
    paramT = (T)localObject;
    if (localObject == zzey.zzea())
    {
      paramT = zzey.zzeb();
      localzzcg.zzjp = paramT;
    }
    while (paramInt1 < paramInt2)
    {
      paramInt1 = zzax.zza(paramArrayOfByte, paramInt1, paramzzay);
      int i = paramzzay.zzfd;
      if (i != 11)
      {
        if ((i & 0x7) == 2) {
          paramInt1 = zzax.zza(i, paramArrayOfByte, paramInt1, paramInt2, paramT, paramzzay);
        } else {
          paramInt1 = zzax.zza(i, paramArrayOfByte, paramInt1, paramInt2, paramzzay);
        }
      }
      else
      {
        int j = 0;
        localObject = null;
        for (;;)
        {
          i = paramInt1;
          if (paramInt1 >= paramInt2) {
            break;
          }
          paramInt1 = zzax.zza(paramArrayOfByte, paramInt1, paramzzay);
          int k = paramzzay.zzfd;
          int m = k >>> 3;
          i = k & 0x7;
          if (m != 2)
          {
            if ((m == 3) && (i == 2))
            {
              paramInt1 = zzax.zze(paramArrayOfByte, paramInt1, paramzzay);
              localObject = (zzbb)paramzzay.zzff;
            }
          }
          else if (i == 0)
          {
            paramInt1 = zzax.zza(paramArrayOfByte, paramInt1, paramzzay);
            j = paramzzay.zzfd;
            continue;
          }
          i = paramInt1;
          if (k == 12) {
            break;
          }
          paramInt1 = zzax.zza(k, paramArrayOfByte, paramInt1, paramInt2, paramzzay);
        }
        if (localObject != null) {
          paramT.zzb(j << 3 | 0x2, localObject);
        }
        paramInt1 = i;
      }
    }
    if (paramInt1 == paramInt2) {
      return;
    }
    throw zzco.zzbo();
  }
  
  public final void zzc(T paramT)
  {
    this.zzmx.zzc(paramT);
    this.zzmy.zzc(paramT);
  }
  
  public final void zzc(T paramT1, T paramT2)
  {
    zzeh.zza(this.zzmx, paramT1, paramT2);
    if (this.zzmo) {
      zzeh.zza(this.zzmy, paramT1, paramT2);
    }
  }
  
  public final int zzm(T paramT)
  {
    zzex localzzex = this.zzmx;
    int i = localzzex.zzr(localzzex.zzq(paramT)) + 0;
    int j = i;
    if (this.zzmo) {
      j = i + this.zzmy.zza(paramT).zzat();
    }
    return j;
  }
  
  public final boolean zzo(T paramT)
  {
    return this.zzmy.zza(paramT).isInitialized();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzdu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */