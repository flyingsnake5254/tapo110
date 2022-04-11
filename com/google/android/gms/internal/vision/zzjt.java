package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzjt
  extends AbstractList<String>
  implements zzho, RandomAccess
{
  private final zzho zzabd;
  
  public zzjt(zzho paramzzho)
  {
    this.zzabd = paramzzho;
  }
  
  public final Object getRaw(int paramInt)
  {
    return this.zzabd.getRaw(paramInt);
  }
  
  public final Iterator<String> iterator()
  {
    return new zzjv(this);
  }
  
  public final ListIterator<String> listIterator(int paramInt)
  {
    return new zzjs(this, paramInt);
  }
  
  public final int size()
  {
    return this.zzabd.size();
  }
  
  public final void zzc(zzfm paramzzfm)
  {
    throw new UnsupportedOperationException();
  }
  
  public final List<?> zzgy()
  {
    return this.zzabd.zzgy();
  }
  
  public final zzho zzgz()
  {
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzjt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */