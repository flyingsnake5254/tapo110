package com.google.common.primitives;

import com.google.common.base.n;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class f
{
  private static final Map<Class<?>, Class<?>> a;
  private static final Map<Class<?>, Class<?>> b;
  
  static
  {
    LinkedHashMap localLinkedHashMap1 = new LinkedHashMap(16);
    LinkedHashMap localLinkedHashMap2 = new LinkedHashMap(16);
    a(localLinkedHashMap1, localLinkedHashMap2, Boolean.TYPE, Boolean.class);
    a(localLinkedHashMap1, localLinkedHashMap2, Byte.TYPE, Byte.class);
    a(localLinkedHashMap1, localLinkedHashMap2, Character.TYPE, Character.class);
    a(localLinkedHashMap1, localLinkedHashMap2, Double.TYPE, Double.class);
    a(localLinkedHashMap1, localLinkedHashMap2, Float.TYPE, Float.class);
    a(localLinkedHashMap1, localLinkedHashMap2, Integer.TYPE, Integer.class);
    a(localLinkedHashMap1, localLinkedHashMap2, Long.TYPE, Long.class);
    a(localLinkedHashMap1, localLinkedHashMap2, Short.TYPE, Short.class);
    a(localLinkedHashMap1, localLinkedHashMap2, Void.TYPE, Void.class);
    a = Collections.unmodifiableMap(localLinkedHashMap1);
    b = Collections.unmodifiableMap(localLinkedHashMap2);
  }
  
  private static void a(Map<Class<?>, Class<?>> paramMap1, Map<Class<?>, Class<?>> paramMap2, Class<?> paramClass1, Class<?> paramClass2)
  {
    paramMap1.put(paramClass1, paramClass2);
    paramMap2.put(paramClass2, paramClass1);
  }
  
  public static Set<Class<?>> b()
  {
    return b.keySet();
  }
  
  public static <T> Class<T> c(Class<T> paramClass)
  {
    n.o(paramClass);
    Class localClass = (Class)b.get(paramClass);
    if (localClass != null) {
      paramClass = localClass;
    }
    return paramClass;
  }
  
  public static <T> Class<T> d(Class<T> paramClass)
  {
    n.o(paramClass);
    Class localClass = (Class)a.get(paramClass);
    if (localClass != null) {
      paramClass = localClass;
    }
    return paramClass;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\primitives\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */