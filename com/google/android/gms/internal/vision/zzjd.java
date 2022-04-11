package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzjd
  implements Iterator<Map.Entry<K, V>>
{
  private int pos;
  private Iterator<Map.Entry<K, V>> zzaar;
  
  private zzjd(zzjb paramzzjb)
  {
    this.pos = zzjb.zzb(paramzzjb).size();
  }
  
  private final Iterator<Map.Entry<K, V>> zzid()
  {
    if (this.zzaar == null) {
      this.zzaar = zzjb.zzd(this.zzaaq).entrySet().iterator();
    }
    return this.zzaar;
  }
  
  public final boolean hasNext()
  {
    int i = this.pos;
    return ((i > 0) && (i <= zzjb.zzb(this.zzaaq).size())) || (zzid().hasNext());
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzjd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */