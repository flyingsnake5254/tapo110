package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzlw
  extends zzmd
{
  zzlw(int paramInt)
  {
    super(paramInt, null);
  }
  
  public final void zza()
  {
    if (!zzb())
    {
      for (int i = 0; i < zzc(); i++)
      {
        localObject = zzd(i);
        if (((zzjt)((Map.Entry)localObject).getKey()).zzc()) {
          ((Map.Entry)localObject).setValue(Collections.unmodifiableList((List)((Map.Entry)localObject).getValue()));
        }
      }
      Object localObject = zze().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (((zzjt)localEntry.getKey()).zzc()) {
          localEntry.setValue(Collections.unmodifiableList((List)localEntry.getValue()));
        }
      }
    }
    super.zza();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzlw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */