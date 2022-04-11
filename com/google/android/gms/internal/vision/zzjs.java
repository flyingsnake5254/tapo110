package com.google.android.gms.internal.vision;

import java.util.List;
import java.util.ListIterator;

final class zzjs
  implements ListIterator<String>
{
  private ListIterator<String> zzaba;
  
  zzjs(zzjt paramzzjt, int paramInt)
  {
    this.zzaba = zzjt.zza(paramzzjt).listIterator(paramInt);
  }
  
  public final boolean hasNext()
  {
    return this.zzaba.hasNext();
  }
  
  public final boolean hasPrevious()
  {
    return this.zzaba.hasPrevious();
  }
  
  public final int nextIndex()
  {
    return this.zzaba.nextIndex();
  }
  
  public final int previousIndex()
  {
    return this.zzaba.previousIndex();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzjs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */