package com.tplink.tdp.tlv.adapter;

import com.google.gson.internal.a;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

public class f
{
  public static boolean a(e<?> parame1, e<?> parame2)
  {
    if (parame1 == parame2) {
      return true;
    }
    if (parame1.a() == parame2.a()) {
      return Arrays.equals(parame1.b(), parame2.b());
    }
    return false;
  }
  
  public static Class<?> b(Type paramType)
  {
    if ((paramType instanceof Class)) {
      return (Class)paramType;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = ((ParameterizedType)paramType).getRawType();
      a.a(paramType instanceof Class);
      return (Class)paramType;
    }
    if ((paramType instanceof GenericArrayType)) {
      return Array.newInstance(b(((GenericArrayType)paramType).getGenericComponentType()), 0).getClass();
    }
    if ((paramType instanceof TypeVariable)) {
      return Object.class;
    }
    if ((paramType instanceof WildcardType)) {
      return b(((WildcardType)paramType).getUpperBounds()[0]);
    }
    String str;
    if (paramType == null) {
      str = "null";
    } else {
      str = paramType.getClass().getName();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
    localStringBuilder.append(paramType);
    localStringBuilder.append("> is of type ");
    localStringBuilder.append(str);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static Class<?> c(Class paramClass)
  {
    return b(paramClass.getGenericSuperclass());
  }
  
  public static Type[] d(Type paramType)
  {
    if ((paramType instanceof Class)) {
      return null;
    }
    if ((paramType instanceof ParameterizedType)) {
      return ((ParameterizedType)paramType).getActualTypeArguments();
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tdp\tlv\adapter\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */