package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;
import java.util.Set;

public final class zzbc
{
  static boolean zza(Set<?> paramSet, Iterator<?> paramIterator)
  {
    boolean bool = false;
    while (paramIterator.hasNext()) {
      bool |= paramSet.remove(paramIterator.next());
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */