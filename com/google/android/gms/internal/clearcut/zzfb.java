package com.google.android.gms.internal.clearcut;

import java.util.List;
import java.util.ListIterator;

final class zzfb
  implements ListIterator<String>
{
  private ListIterator<String> zzpc;
  
  zzfb(zzfa paramzzfa, int paramInt)
  {
    this.zzpc = zzfa.zza(paramzzfa).listIterator(paramInt);
  }
  
  public final boolean hasNext()
  {
    return this.zzpc.hasNext();
  }
  
  public final boolean hasPrevious()
  {
    return this.zzpc.hasPrevious();
  }
  
  public final int nextIndex()
  {
    return this.zzpc.nextIndex();
  }
  
  public final int previousIndex()
  {
    return this.zzpc.previousIndex();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzfb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */