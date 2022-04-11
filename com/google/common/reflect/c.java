package com.google.common.reflect;

import com.google.common.base.n;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public final class c
{
  public static <T> T a(Class<T> paramClass, InvocationHandler paramInvocationHandler)
  {
    n.o(paramInvocationHandler);
    n.j(paramClass.isInterface(), "%s is not an interface", paramClass);
    return (T)paramClass.cast(Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, paramInvocationHandler));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\reflect\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */