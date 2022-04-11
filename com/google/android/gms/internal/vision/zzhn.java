package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzhn<K>
  implements Iterator<Map.Entry<K, Object>>
{
  private Iterator<Map.Entry<K, Object>> zzyp;
  
  public zzhn(Iterator<Map.Entry<K, Object>> paramIterator)
  {
    this.zzyp = paramIterator;
  }
  
  public final boolean hasNext()
  {
    return this.zzyp.hasNext();
  }
  
  public final void remove()
  {
    this.zzyp.remove();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzhn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */