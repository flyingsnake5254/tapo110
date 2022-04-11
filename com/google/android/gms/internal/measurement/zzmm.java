package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzmm
  extends AbstractList<String>
  implements RandomAccess, zzks
{
  private final zzks zza;
  
  public zzmm(zzks paramzzks)
  {
    this.zza = paramzzks;
  }
  
  public final Iterator<String> iterator()
  {
    return new zzml(this);
  }
  
  public final ListIterator<String> listIterator(int paramInt)
  {
    return new zzmk(this, paramInt);
  }
  
  public final int size()
  {
    return this.zza.size();
  }
  
  public final void zzf(zzjd paramzzjd)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Object zzg(int paramInt)
  {
    return this.zza.zzg(paramInt);
  }
  
  public final List<?> zzh()
  {
    return this.zza.zzh();
  }
  
  public final zzks zzi()
  {
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzmm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */