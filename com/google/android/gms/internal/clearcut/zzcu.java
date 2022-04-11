package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzcu<K>
  implements Iterator<Map.Entry<K, Object>>
{
  private Iterator<Map.Entry<K, Object>> zzlm;
  
  public zzcu(Iterator<Map.Entry<K, Object>> paramIterator)
  {
    this.zzlm = paramIterator;
  }
  
  public final boolean hasNext()
  {
    return this.zzlm.hasNext();
  }
  
  public final void remove()
  {
    this.zzlm.remove();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzcu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */