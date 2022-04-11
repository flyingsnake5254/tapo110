package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Method;

final class zzbs
{
  private static final Class<?> zzgl = ;
  
  private static Class<?> zzak()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.ExtensionRegistry");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return null;
  }
  
  public static zzbt zzal()
  {
    Object localObject = zzgl;
    if (localObject != null) {}
    try
    {
      localObject = (zzbt)((Class)localObject).getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
      return (zzbt)localObject;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return zzbt.zzgo;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzbs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */