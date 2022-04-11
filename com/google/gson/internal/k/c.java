package com.google.gson.internal.k;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

final class c
  extends b
{
  private static Class b;
  private final Object c = d();
  private final Field d = c();
  
  private static Field c()
  {
    try
    {
      Field localField = AccessibleObject.class.getDeclaredField("override");
      return localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException) {}
    return null;
  }
  
  private static Object d()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = Class.forName("sun.misc.Unsafe");
      b = (Class)localObject2;
      localObject2 = ((Class)localObject2).getDeclaredField("theUnsafe");
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Field)localObject2).get(null);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return localObject1;
  }
  
  public void b(AccessibleObject paramAccessibleObject)
  {
    if (!e(paramAccessibleObject)) {
      try
      {
        paramAccessibleObject.setAccessible(true);
      }
      catch (SecurityException localSecurityException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Gson couldn't modify fields for ");
        localStringBuilder.append(paramAccessibleObject);
        localStringBuilder.append("\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.");
        throw new JsonIOException(localStringBuilder.toString(), localSecurityException);
      }
    }
  }
  
  boolean e(AccessibleObject paramAccessibleObject)
  {
    if ((this.c != null) && (this.d != null)) {}
    try
    {
      long l = ((Long)b.getMethod("objectFieldOffset", new Class[] { Field.class }).invoke(this.c, new Object[] { this.d })).longValue();
      b.getMethod("putBoolean", new Class[] { Object.class, Long.TYPE, Boolean.TYPE }).invoke(this.c, new Object[] { paramAccessibleObject, Long.valueOf(l), Boolean.TRUE });
      return true;
    }
    catch (Exception paramAccessibleObject)
    {
      for (;;) {}
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\k\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */