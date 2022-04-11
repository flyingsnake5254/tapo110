package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzjj
  implements Iterator<Map.Entry<K, V>>
{
  private int pos = -1;
  private Iterator<Map.Entry<K, V>> zzaar;
  private boolean zzaav;
  
  private zzjj(zzjb paramzzjb) {}
  
  private final Iterator<Map.Entry<K, V>> zzid()
  {
    if (this.zzaar == null) {
      this.zzaar = zzjb.zzc(this.zzaaq).entrySet().iterator();
    }
    return this.zzaar;
  }
  
  public final boolean hasNext()
  {
    return (this.pos + 1 < zzjb.zzb(this.zzaaq).size()) || ((!zzjb.zzc(this.zzaaq).isEmpty()) && (zzid().hasNext()));
  }
  
  public final void remove()
  {
    if (this.zzaav)
    {
      this.zzaav = false;
      zzjb.zza(this.zzaaq);
      if (this.pos < zzjb.zzb(this.zzaaq).size())
      {
        zzjb localzzjb = this.zzaaq;
        int i = this.pos;
        this.pos = (i - 1);
        zzjb.zza(localzzjb, i);
        return;
      }
      zzid().remove();
      return;
    }
    throw new IllegalStateException("remove() was called before next()");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzjj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */