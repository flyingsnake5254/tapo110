package io.netty.util.internal.shaded.org.jctools.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class UnsafeAccess
{
  public static final boolean SUPPORTS_GET_AND_ADD_LONG = hasGetAndAddLongSupport();
  public static final boolean SUPPORTS_GET_AND_SET_REF;
  public static final Unsafe UNSAFE = ;
  
  static
  {
    SUPPORTS_GET_AND_SET_REF = hasGetAndSetSupport();
  }
  
  public static long fieldOffset(Class paramClass, String paramString)
    throws RuntimeException
  {
    try
    {
      long l = UNSAFE.objectFieldOffset(paramClass.getDeclaredField(paramString));
      return l;
    }
    catch (NoSuchFieldException paramClass)
    {
      throw new RuntimeException(paramClass);
    }
  }
  
  private static Unsafe getUnsafe()
  {
    try
    {
      Object localObject1 = Unsafe.class.getDeclaredField("theUnsafe");
      ((Field)localObject1).setAccessible(true);
      localObject1 = (Unsafe)((Field)localObject1).get(null);
    }
    catch (Exception localException1) {}
    try
    {
      Object localObject2 = Unsafe.class.getDeclaredConstructor(new Class[0]);
      ((Constructor)localObject2).setAccessible(true);
      localObject2 = (Unsafe)((Constructor)localObject2).newInstance(new Object[0]);
      return (Unsafe)localObject2;
    }
    catch (Exception localException2)
    {
      throw new RuntimeException(localException2);
    }
  }
  
  private static boolean hasGetAndAddLongSupport()
  {
    try
    {
      Class localClass = Long.TYPE;
      Unsafe.class.getMethod("getAndAddLong", new Class[] { Object.class, localClass, localClass });
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private static boolean hasGetAndSetSupport()
  {
    try
    {
      Unsafe.class.getMethod("getAndSetObject", new Class[] { Object.class, Long.TYPE, Object.class });
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\util\UnsafeAccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */