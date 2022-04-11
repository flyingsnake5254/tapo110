package com.google.android.gms.internal.vision;

import java.io.IOException;

abstract class zzjo<T, B>
{
  abstract void zza(B paramB, int paramInt, long paramLong);
  
  abstract void zza(B paramB, int paramInt, zzfm paramzzfm);
  
  abstract void zza(B paramB, int paramInt, T paramT);
  
  abstract void zza(T paramT, zzkl paramzzkl)
    throws IOException;
  
  abstract boolean zza(zzix paramzzix);
  
  final boolean zza(B paramB, zzix paramzzix)
    throws IOException
  {
    int i = paramzzix.getTag();
    int j = i >>> 3;
    i &= 0x7;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i == 5)
              {
                zzc(paramB, j, paramzzix.zzeb());
                return true;
              }
              throw zzhh.zzgs();
            }
            return false;
          }
          Object localObject = zzig();
          while ((paramzzix.zzdv() != Integer.MAX_VALUE) && (zza(localObject, paramzzix))) {}
          if ((0x4 | j << 3) == paramzzix.getTag())
          {
            zza(paramB, j, zzo(localObject));
            return true;
          }
          throw zzhh.zzgr();
        }
        zza(paramB, j, paramzzix.zzee());
        return true;
      }
      zzb(paramB, j, paramzzix.zzea());
      return true;
    }
    zza(paramB, j, paramzzix.zzdy());
    return true;
  }
  
  abstract void zzb(B paramB, int paramInt, long paramLong);
  
  abstract void zzc(B paramB, int paramInt1, int paramInt2);
  
  abstract void zzc(T paramT, zzkl paramzzkl)
    throws IOException;
  
  abstract void zzf(Object paramObject, T paramT);
  
  abstract void zzg(Object paramObject, B paramB);
  
  abstract T zzh(T paramT1, T paramT2);
  
  abstract void zzh(Object paramObject);
  
  abstract B zzig();
  
  abstract T zzo(B paramB);
  
  abstract int zzs(T paramT);
  
  abstract T zzw(Object paramObject);
  
  abstract B zzx(Object paramObject);
  
  abstract int zzy(T paramT);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzjo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */