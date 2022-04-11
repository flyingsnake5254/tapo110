package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzeq
  implements Iterator<Map.Entry<K, V>>
{
  private int pos = -1;
  private Iterator<Map.Entry<K, V>> zzor;
  private boolean zzow;
  
  private zzeq(zzei paramzzei) {}
  
  private final Iterator<Map.Entry<K, V>> zzdw()
  {
    if (this.zzor == null) {
      this.zzor = zzei.zzc(this.zzos).entrySet().iterator();
    }
    return this.zzor;
  }
  
  public final boolean hasNext()
  {
    return (this.pos + 1 < zzei.zzb(this.zzos).size()) || ((!zzei.zzc(this.zzos).isEmpty()) && (zzdw().hasNext()));
  }
  
  public final void remove()
  {
    if (this.zzow)
    {
      this.zzow = false;
      zzei.zza(this.zzos);
      if (this.pos < zzei.zzb(this.zzos).size())
      {
        zzei localzzei = this.zzos;
        int i = this.pos;
        this.pos = (i - 1);
        zzei.zza(localzzei, i);
        return;
      }
      zzdw().remove();
      return;
    }
    throw new IllegalStateException("remove() was called before next()");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzeq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */