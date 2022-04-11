package com.google.android.gms.internal.clearcut;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzej
  extends zzei<FieldDescriptorType, Object>
{
  zzej(int paramInt)
  {
    super(paramInt, null);
  }
  
  public final void zzv()
  {
    if (!isImmutable())
    {
      for (int i = 0; i < zzdr(); i++)
      {
        localObject = zzak(i);
        if (((zzca)((Map.Entry)localObject).getKey()).zzaw()) {
          ((Map.Entry)localObject).setValue(Collections.unmodifiableList((List)((Map.Entry)localObject).getValue()));
        }
      }
      Object localObject = zzds().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (((zzca)localEntry.getKey()).zzaw()) {
          localEntry.setValue(Collections.unmodifiableList((List)localEntry.getValue()));
        }
      }
    }
    super.zzv();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */