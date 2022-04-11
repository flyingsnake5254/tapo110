package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zziu
  extends AbstractList<String>
  implements zzgv, RandomAccess
{
  private final zzgv zza;
  
  public zziu(zzgv paramzzgv)
  {
    this.zza = paramzzgv;
  }
  
  public final Iterator<String> iterator()
  {
    return new zziw(this);
  }
  
  public final ListIterator<String> listIterator(int paramInt)
  {
    return new zzix(this, paramInt);
  }
  
  public final int size()
  {
    return this.zza.size();
  }
  
  public final void zza(zzew paramzzew)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Object zzb(int paramInt)
  {
    return this.zza.zzb(paramInt);
  }
  
  public final List<?> zzd()
  {
    return this.zza.zzd();
  }
  
  public final zzgv zze()
  {
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zziu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */