package com.google.gson.internal;

import java.lang.reflect.Type;

public final class h
{
  public static boolean a(Type paramType)
  {
    boolean bool;
    if (((paramType instanceof Class)) && (((Class)paramType).isPrimitive())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static <T> Class<T> b(Class<T> paramClass)
  {
    if (paramClass == Integer.TYPE) {
      return Integer.class;
    }
    if (paramClass == Float.TYPE) {
      return Float.class;
    }
    if (paramClass == Byte.TYPE) {
      return Byte.class;
    }
    if (paramClass == Double.TYPE) {
      return Double.class;
    }
    if (paramClass == Long.TYPE) {
      return Long.class;
    }
    if (paramClass == Character.TYPE) {
      return Character.class;
    }
    if (paramClass == Boolean.TYPE) {
      return Boolean.class;
    }
    if (paramClass == Short.TYPE) {
      return Short.class;
    }
    Object localObject = paramClass;
    if (paramClass == Void.TYPE) {
      localObject = Void.class;
    }
    return (Class<T>)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */