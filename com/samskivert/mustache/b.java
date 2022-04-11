package com.samskivert.mustache;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class b
  extends a
{
  private void e(Set<Class<?>> paramSet, Class<?> paramClass, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramSet.add(paramClass);
    }
    paramClass = paramClass.getInterfaces();
    int i = paramClass.length;
    for (int j = 0; j < i; j++) {
      e(paramSet, paramClass[j], true);
    }
  }
  
  private Method j(Method paramMethod)
  {
    if (!paramMethod.isAccessible()) {
      paramMethod.setAccessible(true);
    }
    return paramMethod;
  }
  
  public <K, V> Map<K, V> b()
  {
    return new ConcurrentHashMap();
  }
  
  public f.v c(final Object paramObject, String paramString)
  {
    final Object localObject = super.c(paramObject, paramString);
    if (localObject != null) {
      return (f.v)localObject;
    }
    paramObject = paramObject.getClass();
    localObject = h((Class)paramObject, paramString);
    if (localObject != null) {
      return new a((Method)localObject);
    }
    localObject = f((Class)paramObject, paramString);
    if (localObject != null) {
      return new b((Field)localObject);
    }
    paramObject = g((Class)paramObject, paramString);
    if (paramObject != null) {
      return new c((Method)paramObject);
    }
    return null;
  }
  
  protected Field f(Class<?> paramClass, String paramString)
  {
    try
    {
      Field localField = paramClass.getDeclaredField(paramString);
      if (!localField.isAccessible()) {
        localField.setAccessible(true);
      }
      return localField;
    }
    catch (Exception localException)
    {
      Class localClass = paramClass.getSuperclass();
      if ((localClass != Object.class) && (localClass != null)) {
        return f(paramClass.getSuperclass(), paramString);
      }
    }
    return null;
  }
  
  protected Method g(Class<?> paramClass, String paramString)
  {
    Object localObject = new LinkedHashSet();
    while ((paramClass != null) && (paramClass != Object.class))
    {
      e((Set)localObject, paramClass, false);
      paramClass = paramClass.getSuperclass();
    }
    paramClass = ((Set)localObject).iterator();
    while (paramClass.hasNext())
    {
      localObject = i((Class)paramClass.next(), paramString);
      if (localObject != null) {
        return (Method)localObject;
      }
    }
    return null;
  }
  
  protected Method h(Class<?> paramClass, String paramString)
  {
    while ((paramClass != null) && (paramClass != Object.class))
    {
      Method localMethod = i(paramClass, paramString);
      if (localMethod != null) {
        return localMethod;
      }
      paramClass = paramClass.getSuperclass();
    }
    return null;
  }
  
  protected Method i(Class<?> paramClass, String paramString)
  {
    try
    {
      localObject = paramClass.getDeclaredMethod(paramString, new Class[0]);
      if (!((Method)localObject).getReturnType().equals(Void.TYPE))
      {
        localObject = j((Method)localObject);
        return (Method)localObject;
      }
    }
    catch (Exception localException1)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Character.toUpperCase(paramString.charAt(0)));
    ((StringBuilder)localObject).append(paramString.substring(1));
    paramString = ((StringBuilder)localObject).toString();
    for (;;)
    {
      try
      {
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        ((StringBuilder)localObject).append("get");
        ((StringBuilder)localObject).append(paramString);
        localObject = paramClass.getDeclaredMethod(((StringBuilder)localObject).toString(), new Class[0]);
        if (!((Method)localObject).getReturnType().equals(Void.TYPE))
        {
          localObject = j((Method)localObject);
          return (Method)localObject;
        }
      }
      catch (Exception localException2)
      {
        continue;
      }
      try
      {
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        ((StringBuilder)localObject).append("is");
        ((StringBuilder)localObject).append(paramString);
        paramClass = paramClass.getDeclaredMethod(((StringBuilder)localObject).toString(), new Class[0]);
        if ((paramClass.getReturnType().equals(Boolean.TYPE)) || (paramClass.getReturnType().equals(Boolean.class)))
        {
          paramClass = j(paramClass);
          return paramClass;
        }
      }
      catch (Exception paramClass) {}
    }
    return null;
  }
  
  class a
    implements f.v
  {
    a(Method paramMethod) {}
    
    public Object a(Object paramObject, String paramString)
      throws Exception
    {
      return localObject.invoke(paramObject, new Object[0]);
    }
  }
  
  class b
    implements f.v
  {
    b(Field paramField) {}
    
    public Object a(Object paramObject, String paramString)
      throws Exception
    {
      return localObject.get(paramObject);
    }
  }
  
  class c
    implements f.v
  {
    c(Method paramMethod) {}
    
    public Object a(Object paramObject, String paramString)
      throws Exception
    {
      return paramObject.invoke(paramObject, new Object[0]);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\samskivert\mustache\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */