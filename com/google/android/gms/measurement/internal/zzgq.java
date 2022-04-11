package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;

public final class zzgq
{
  public static void zza(@NonNull Bundle paramBundle, @NonNull Object paramObject)
  {
    if ((paramObject instanceof Double))
    {
      paramBundle.putDouble("value", ((Double)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramBundle.putLong("value", ((Long)paramObject).longValue());
      return;
    }
    paramBundle.putString("value", paramObject.toString());
  }
  
  public static <T> T zzb(@NonNull Bundle paramBundle, String paramString, Class<T> paramClass, T paramT)
  {
    paramBundle = paramBundle.get(paramString);
    if (paramBundle == null) {
      return paramT;
    }
    if (paramClass.isAssignableFrom(paramBundle.getClass())) {
      return paramBundle;
    }
    throw new IllegalStateException(String.format("Invalid conditional user property field type. '%s' expected [%s] but was [%s]", new Object[] { paramString, paramClass.getCanonicalName(), paramBundle.getClass().getCanonicalName() }));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzgq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */