package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

final class zzmn
  implements PrivilegedExceptionAction<Unsafe>
{
  public static final Unsafe zza()
    throws Exception
  {
    for (Object localObject : Unsafe.class.getDeclaredFields())
    {
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(null);
      if (Unsafe.class.isInstance(localObject)) {
        return (Unsafe)Unsafe.class.cast(localObject);
      }
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzmn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */