package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzab
{
  static boolean zza(Collection<?> paramCollection, @NullableDecl Object paramObject)
  {
    zzh.zza(paramCollection);
    try
    {
      boolean bool = paramCollection.contains(paramObject);
      return bool;
    }
    catch (ClassCastException|NullPointerException paramCollection) {}
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */