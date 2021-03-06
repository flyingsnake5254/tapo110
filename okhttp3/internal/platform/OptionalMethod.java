package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class OptionalMethod<T>
{
  private final String methodName;
  private final Class[] methodParams;
  private final Class<?> returnType;
  
  OptionalMethod(Class<?> paramClass, String paramString, Class... paramVarArgs)
  {
    this.returnType = paramClass;
    this.methodName = paramString;
    this.methodParams = paramVarArgs;
  }
  
  private Method getMethod(Class<?> paramClass)
  {
    String str = this.methodName;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (str != null)
    {
      localObject2 = getPublicMethod(paramClass, str, this.methodParams);
      if (localObject2 != null)
      {
        paramClass = this.returnType;
        if ((paramClass != null) && (!paramClass.isAssignableFrom(((Method)localObject2).getReturnType()))) {
          localObject2 = localObject1;
        }
      }
    }
    return (Method)localObject2;
  }
  
  private static Method getPublicMethod(Class<?> paramClass, String paramString, Class[] paramArrayOfClass)
  {
    localObject = null;
    for (;;)
    {
      try
      {
        paramClass = paramClass.getMethod(paramString, paramArrayOfClass);
      }
      catch (NoSuchMethodException paramClass)
      {
        int i;
        paramClass = (Class<?>)localObject;
        continue;
      }
      try
      {
        i = paramClass.getModifiers();
        if ((i & 0x1) == 0) {
          paramClass = (Class<?>)localObject;
        }
      }
      catch (NoSuchMethodException paramString) {}
    }
    return paramClass;
  }
  
  public Object invoke(T paramT, Object... paramVarArgs)
    throws InvocationTargetException
  {
    Method localMethod = getMethod(paramT.getClass());
    if (localMethod != null) {
      try
      {
        paramT = localMethod.invoke(paramT, paramVarArgs);
        return paramT;
      }
      catch (IllegalAccessException paramT)
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("Unexpectedly could not call: ");
        paramVarArgs.append(localMethod);
        paramVarArgs = new AssertionError(paramVarArgs.toString());
        paramVarArgs.initCause(paramT);
        throw paramVarArgs;
      }
    }
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("Method ");
    paramVarArgs.append(this.methodName);
    paramVarArgs.append(" not supported for object ");
    paramVarArgs.append(paramT);
    throw new AssertionError(paramVarArgs.toString());
  }
  
  public Object invokeOptional(T paramT, Object... paramVarArgs)
    throws InvocationTargetException
  {
    Method localMethod = getMethod(paramT.getClass());
    if (localMethod == null) {
      return null;
    }
    try
    {
      paramT = localMethod.invoke(paramT, paramVarArgs);
      return paramT;
    }
    catch (IllegalAccessException paramT) {}
    return null;
  }
  
  public Object invokeOptionalWithoutCheckedException(T paramT, Object... paramVarArgs)
  {
    try
    {
      paramT = invokeOptional(paramT, paramVarArgs);
      return paramT;
    }
    catch (InvocationTargetException paramT)
    {
      paramT = paramT.getTargetException();
      if ((paramT instanceof RuntimeException)) {
        throw ((RuntimeException)paramT);
      }
      paramVarArgs = new AssertionError("Unexpected exception");
      paramVarArgs.initCause(paramT);
      throw paramVarArgs;
    }
  }
  
  public Object invokeWithoutCheckedException(T paramT, Object... paramVarArgs)
  {
    try
    {
      paramT = invoke(paramT, paramVarArgs);
      return paramT;
    }
    catch (InvocationTargetException paramT)
    {
      paramT = paramT.getTargetException();
      if ((paramT instanceof RuntimeException)) {
        throw ((RuntimeException)paramT);
      }
      paramVarArgs = new AssertionError("Unexpected exception");
      paramVarArgs.initCause(paramT);
      throw paramVarArgs;
    }
  }
  
  public boolean isSupported(T paramT)
  {
    boolean bool;
    if (getMethod(paramT.getClass()) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\platform\OptionalMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */