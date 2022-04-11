package com.google.android.gms.internal.mlkit_common;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzhc
  extends zzgz<FieldDescriptorType, Object>
{
  zzhc(int paramInt)
  {
    super(paramInt, null);
  }
  
  public final void zza()
  {
    if (!zzb())
    {
      Map.Entry localEntry;
      for (int i = 0; i < zzc(); i++)
      {
        localEntry = zzb(i);
        if (((zzet)localEntry.getKey()).zzd()) {
          localEntry.setValue(Collections.unmodifiableList((List)localEntry.getValue()));
        }
      }
      Iterator localIterator = zzd().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        if (((zzet)localEntry.getKey()).zzd()) {
          localEntry.setValue(Collections.unmodifiableList((List)localEntry.getValue()));
        }
      }
    }
    super.zza();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzhc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */