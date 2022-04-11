package com.google.android.gms.internal.mlkit_vision_common;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzhf
  extends AbstractList<String>
  implements zzfc, RandomAccess
{
  private final zzfc zza;
  
  public zzhf(zzfc paramzzfc)
  {
    this.zza = paramzzfc;
  }
  
  public final zzfc a_()
  {
    return this;
  }
  
  public final Iterator<String> iterator()
  {
    return new zzhh(this);
  }
  
  public final ListIterator<String> listIterator(int paramInt)
  {
    return new zzhe(this, paramInt);
  }
  
  public final int size()
  {
    return this.zza.size();
  }
  
  public final Object zza(int paramInt)
  {
    return this.zza.zza(paramInt);
  }
  
  public final void zza(zzdj paramzzdj)
  {
    throw new UnsupportedOperationException();
  }
  
  public final List<?> zzb()
  {
    return this.zza.zzb();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzhf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */