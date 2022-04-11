package b.d.e0.h;

import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class d
{
  private static final String a = "d";
  private static final Object b;
  private static final Method c;
  
  static
  {
    String str = d.class.getSimpleName();
    Object localObject = b();
    b = localObject;
    c = c(localObject);
    if (localObject == null) {
      Log.v(str, "This device does supports control of a flashlight");
    } else {
      Log.v(str, "This device does not support control of a flashlight");
    }
  }
  
  static void a()
  {
    g(false);
  }
  
  private static Object b()
  {
    Object localObject1 = e("android.os.ServiceManager");
    if (localObject1 == null) {
      return null;
    }
    localObject1 = f((Class)localObject1, "getService", new Class[] { String.class });
    if (localObject1 == null) {
      return null;
    }
    localObject1 = d((Method)localObject1, null, new Object[] { "hardware" });
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = e("android.os.IHardwareService$Stub");
    if (localObject2 == null) {
      return null;
    }
    localObject2 = f((Class)localObject2, "asInterface", new Class[] { IBinder.class });
    if (localObject2 == null) {
      return null;
    }
    return d((Method)localObject2, null, new Object[] { localObject1 });
  }
  
  private static Method c(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return f(paramObject.getClass(), "setFlashlightEnabled", new Class[] { Boolean.TYPE });
  }
  
  private static Object d(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramObject = paramMethod.invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (RuntimeException paramObject)
    {
      localObject = a;
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("Unexpected error while invoking ");
      paramVarArgs.append(paramMethod);
      Log.w((String)localObject, paramVarArgs.toString(), (Throwable)paramObject);
      return null;
    }
    catch (InvocationTargetException paramVarArgs)
    {
      localObject = a;
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append("Unexpected error while invoking ");
      ((StringBuilder)paramObject).append(paramMethod);
      Log.w((String)localObject, ((StringBuilder)paramObject).toString(), paramVarArgs.getCause());
      return null;
    }
    catch (IllegalAccessException paramVarArgs)
    {
      paramObject = a;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unexpected error while invoking ");
      ((StringBuilder)localObject).append(paramMethod);
      Log.w((String)paramObject, ((StringBuilder)localObject).toString(), paramVarArgs);
    }
    return null;
  }
  
  private static Class<?> e(String paramString)
  {
    try
    {
      localObject = Class.forName(paramString);
      return (Class<?>)localObject;
    }
    catch (RuntimeException localRuntimeException)
    {
      Object localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected error while finding class ");
      localStringBuilder.append(paramString);
      Log.w((String)localObject, localStringBuilder.toString(), localRuntimeException);
      return null;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;) {}
    }
  }
  
  private static Method f(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    try
    {
      paramClass = paramClass.getMethod(paramString, paramVarArgs);
      return paramClass;
    }
    catch (RuntimeException paramVarArgs)
    {
      paramClass = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected error while finding method ");
      localStringBuilder.append(paramString);
      Log.w(paramClass, localStringBuilder.toString(), paramVarArgs);
      return null;
    }
    catch (NoSuchMethodException paramClass)
    {
      for (;;) {}
    }
  }
  
  private static void g(boolean paramBoolean)
  {
    Object localObject = b;
    if (localObject != null) {
      d(c, localObject, new Object[] { Boolean.valueOf(paramBoolean) });
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\e0\h\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */