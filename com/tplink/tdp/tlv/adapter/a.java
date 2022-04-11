package com.tplink.tdp.tlv.adapter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class a
{
  private <T> b<T> b(Class<? super T> paramClass)
  {
    Object localObject1;
    try
    {
      Constructor localConstructor = paramClass.getDeclaredConstructor(new Class[0]);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localObject1 = null;
    }
    final Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      paramClass = paramClass.getDeclaredConstructors();
      localObject2 = localObject1;
      if (paramClass != null)
      {
        localObject2 = localObject1;
        if (paramClass.length > 0) {
          localObject2 = paramClass[0];
        }
      }
    }
    if (localObject2 == null) {
      return null;
    }
    return new a((Constructor)localObject2);
  }
  
  public <T> b<T> a(e<T> parame)
  {
    parame = b(parame.a());
    if (parame != null) {
      return parame;
    }
    return null;
  }
  
  class a
    implements b<T>
  {
    a(Constructor paramConstructor) {}
    
    public T a()
    {
      Object localObject = null;
      try
      {
        int i = localObject2.getParameterTypes().length;
        if (i > 0) {
          localObject = new Object[i];
        }
        localObject = localObject2.newInstance((Object[])localObject);
        return (T)localObject;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new AssertionError(localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("Failed to invoke ");
        localStringBuilder2.append(localObject2);
        localStringBuilder2.append(" with no args");
        throw new RuntimeException(localStringBuilder2.toString(), localInvocationTargetException.getTargetException());
      }
      catch (InstantiationException localInstantiationException)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("Failed to invoke ");
        localStringBuilder1.append(localObject2);
        localStringBuilder1.append(" with no args");
        throw new RuntimeException(localStringBuilder1.toString(), localInstantiationException);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tdp\tlv\adapter\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */