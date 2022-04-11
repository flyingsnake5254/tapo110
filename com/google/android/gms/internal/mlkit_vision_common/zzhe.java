package com.google.android.gms.internal.mlkit_vision_common;

import java.util.List;
import java.util.ListIterator;

final class zzhe
  implements ListIterator<String>
{
  private ListIterator<String> zza;
  
  zzhe(zzhf paramzzhf, int paramInt)
  {
    this.zza = zzhf.zza(paramzzhf).listIterator(paramInt);
  }
  
  public final boolean hasNext()
  {
    return this.zza.hasNext();
  }
  
  public final boolean hasPrevious()
  {
    return this.zza.hasPrevious();
  }
  
  public final int nextIndex()
  {
    return this.zza.nextIndex();
  }
  
  public final int previousIndex()
  {
    return this.zza.previousIndex();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzhe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */