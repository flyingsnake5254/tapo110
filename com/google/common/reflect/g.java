package com.google.common.reflect;

import com.google.common.collect.u2;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;

abstract class g
{
  private final Set<Type> a = u2.d();
  
  public final void a(Type... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      Type localType = paramVarArgs[j];
      if ((localType != null) && (this.a.add(localType))) {
        try
        {
          if ((localType instanceof TypeVariable))
          {
            e((TypeVariable)localType);
          }
          else if ((localType instanceof WildcardType))
          {
            f((WildcardType)localType);
          }
          else if ((localType instanceof ParameterizedType))
          {
            d((ParameterizedType)localType);
          }
          else if ((localType instanceof Class))
          {
            b((Class)localType);
          }
          else if ((localType instanceof GenericArrayType))
          {
            c((GenericArrayType)localType);
          }
          else
          {
            paramVarArgs = new java/lang/AssertionError;
            StringBuilder localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>();
            localStringBuilder.append("Unknown type: ");
            localStringBuilder.append(localType);
            paramVarArgs.<init>(localStringBuilder.toString());
            throw paramVarArgs;
          }
        }
        finally
        {
          this.a.remove(localType);
        }
      }
    }
  }
  
  void b(Class<?> paramClass) {}
  
  void c(GenericArrayType paramGenericArrayType) {}
  
  void d(ParameterizedType paramParameterizedType) {}
  
  abstract void e(TypeVariable<?> paramTypeVariable);
  
  abstract void f(WildcardType paramWildcardType);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\reflect\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */