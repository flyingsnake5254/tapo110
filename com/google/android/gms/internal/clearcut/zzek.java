package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzek
  implements Iterator<Map.Entry<K, V>>
{
  private int pos;
  private Iterator<Map.Entry<K, V>> zzor;
  
  private zzek(zzei paramzzei)
  {
    this.pos = zzei.zzb(paramzzei).size();
  }
  
  private final Iterator<Map.Entry<K, V>> zzdw()
  {
    if (this.zzor == null) {
      this.zzor = zzei.zzd(this.zzos).entrySet().iterator();
    }
    return this.zzor;
  }
  
  public final boolean hasNext()
  {
    int i = this.pos;
    return ((i > 0) && (i <= zzei.zzb(this.zzos).size())) || (zzdw().hasNext());
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */