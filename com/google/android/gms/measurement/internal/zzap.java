package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;

final class zzap
  implements Iterator<String>
{
  final Iterator<String> zza;
  
  zzap(zzaq paramzzaq)
  {
    this.zza = zzaq.zzg(paramzzaq).keySet().iterator();
  }
  
  public final boolean hasNext()
  {
    return this.zza.hasNext();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException("Remove not supported");
  }
  
  public final String zza()
  {
    return (String)this.zza.next();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */