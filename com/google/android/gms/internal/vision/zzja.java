package com.google.android.gms.internal.vision;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzja
  extends zzjb<FieldDescriptorType, Object>
{
  zzja(int paramInt)
  {
    super(paramInt, null);
  }
  
  public final void zzdq()
  {
    if (!isImmutable())
    {
      Map.Entry localEntry;
      for (int i = 0; i < zzhy(); i++)
      {
        localEntry = zzbv(i);
        if (((zzgp)localEntry.getKey()).zzfv()) {
          localEntry.setValue(Collections.unmodifiableList((List)localEntry.getValue()));
        }
      }
      Iterator localIterator = zzhz().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        if (((zzgp)localEntry.getKey()).zzfv()) {
          localEntry.setValue(Collections.unmodifiableList((List)localEntry.getValue()));
        }
      }
    }
    super.zzdq();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzja.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */