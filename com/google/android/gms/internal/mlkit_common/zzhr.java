package com.google.android.gms.internal.mlkit_common;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzhr
  extends AbstractList<String>
  implements zzfs, RandomAccess
{
  private final zzfs zza;
  
  public zzhr(zzfs paramzzfs)
  {
    this.zza = paramzzfs;
  }
  
  public final Iterator<String> iterator()
  {
    return new zzht(this);
  }
  
  public final ListIterator<String> listIterator(int paramInt)
  {
    return new zzhu(this, paramInt);
  }
  
  public final int size()
  {
    return this.zza.size();
  }
  
  public final Object zza(int paramInt)
  {
    return this.zza.zza(paramInt);
  }
  
  public final void zza(zzdv paramzzdv)
  {
    throw new UnsupportedOperationException();
  }
  
  public final List<?> zzd()
  {
    return this.zza.zzd();
  }
  
  public final zzfs zze()
  {
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzhr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */