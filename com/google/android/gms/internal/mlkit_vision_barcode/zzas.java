package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzas
{
  static <V> V zza(Map<?, V> paramMap, @NullableDecl Object paramObject)
  {
    zzh.zza(paramMap);
    try
    {
      paramMap = paramMap.get(paramObject);
      return paramMap;
    }
    catch (ClassCastException|NullPointerException paramMap) {}
    return null;
  }
  
  static boolean zzb(Map<?, ?> paramMap, Object paramObject)
  {
    zzh.zza(paramMap);
    try
    {
      boolean bool = paramMap.containsKey(paramObject);
      return bool;
    }
    catch (ClassCastException|NullPointerException paramMap) {}
    return false;
  }
  
  static <V> V zzc(Map<?, V> paramMap, Object paramObject)
  {
    zzh.zza(paramMap);
    try
    {
      paramMap = paramMap.remove(paramObject);
      return paramMap;
    }
    catch (ClassCastException|NullPointerException paramMap) {}
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */