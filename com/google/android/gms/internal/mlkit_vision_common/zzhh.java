package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Iterator;
import java.util.List;

final class zzhh
  implements Iterator<String>
{
  private Iterator<String> zza;
  
  zzhh(zzhf paramzzhf)
  {
    this.zza = zzhf.zza(paramzzhf).iterator();
  }
  
  public final boolean hasNext()
  {
    return this.zza.hasNext();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzhh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */