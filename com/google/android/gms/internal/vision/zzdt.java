package com.google.android.gms.internal.vision;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzdt
{
  static int zza(Set<?> paramSet)
  {
    paramSet = paramSet.iterator();
    int j;
    for (int i = 0; paramSet.hasNext(); i = i + j ^ 0xFFFFFFFF ^ 0xFFFFFFFF)
    {
      Object localObject = paramSet.next();
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
    }
    return i;
  }
  
  static boolean zza(Set<?> paramSet, @NullableDecl Object paramObject)
  {
    if (paramSet == paramObject) {
      return true;
    }
    if ((paramObject instanceof Set)) {
      paramObject = (Set)paramObject;
    }
    try
    {
      if (paramSet.size() == ((Set)paramObject).size())
      {
        boolean bool = paramSet.containsAll((Collection)paramObject);
        if (bool) {
          return true;
        }
      }
    }
    catch (NullPointerException|ClassCastException paramSet)
    {
      for (;;) {}
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzdt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */