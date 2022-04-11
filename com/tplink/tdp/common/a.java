package com.tplink.tdp.common;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class a
  implements ParameterizedType
{
  private final Class c;
  private final Type[] d;
  private final Type f;
  
  public a(Class paramClass, Type[] paramArrayOfType, Type paramType)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tdp\common\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */