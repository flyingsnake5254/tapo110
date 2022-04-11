package io.netty.util.internal;

import java.lang.reflect.AccessibleObject;

public final class ReflectionUtil
{
  private static RuntimeException handleInaccessibleObjectException(RuntimeException paramRuntimeException)
  {
    if ("java.lang.reflect.InaccessibleObjectException".equals(paramRuntimeException.getClass().getName())) {
      return paramRuntimeException;
    }
    throw paramRuntimeException;
  }
  
  public static Throwable trySetAccessible(AccessibleObject paramAccessibleObject, boolean paramBoolean)
  {
    if ((paramBoolean) && (!PlatformDependent0.isExplicitTryReflectionSetAccessible())) {
      return new UnsupportedOperationException("Reflective setAccessible(true) disabled");
    }
    try
    {
      paramAccessibleObject.setAccessible(true);
      return null;
    }
    catch (RuntimeException paramAccessibleObject)
    {
      return handleInaccessibleObjectException(paramAccessibleObject);
    }
    catch (SecurityException paramAccessibleObject) {}
    return paramAccessibleObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\ReflectionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */