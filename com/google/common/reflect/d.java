package com.google.common.reflect;

import com.google.common.base.n;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

abstract class d<T>
{
  final Type capture()
  {
    Type localType = getClass().getGenericSuperclass();
    n.j(localType instanceof ParameterizedType, "%s isn't parameterized", localType);
    return ((ParameterizedType)localType).getActualTypeArguments()[0];
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\reflect\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */