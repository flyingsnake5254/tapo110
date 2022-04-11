package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzif
  extends zzic<FieldDescriptorType, Object>
{
  zzif(int paramInt)
  {
    super(paramInt, null);
  }
  
  public final void zza()
  {
    if (!zzb())
    {
      for (int i = 0; i < zzc(); i++)
      {
        localObject = zzb(i);
        if (((zzfu)((Map.Entry)localObject).getKey()).zzd()) {
          ((Map.Entry)localObject).setValue(Collections.unmodifiableList((List)((Map.Entry)localObject).getValue()));
        }
      }
      Object localObject = zzd().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (((zzfu)localEntry.getKey()).zzd()) {
          localEntry.setValue(Collections.unmodifiableList((List)localEntry.getValue()));
        }
      }
    }
    super.zza();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzif.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */