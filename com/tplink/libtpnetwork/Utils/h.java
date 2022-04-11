package com.tplink.libtpnetwork.Utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class h
  implements ParameterizedType
{
  private final Class c;
  private final Type[] d;
  private final Type f;
  
  public h(Class paramClass, Type[] paramArrayOfType, Type paramType)
  {
    this.c = paramClass;
    this.d = paramArrayOfType;
    this.f = paramType;
  }
  
  public Type[] getActualTypeArguments()
  {
    return this.d;
  }
  
  public Type getOwnerType()
  {
    return this.f;
  }
  
  public Type getRawType()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */