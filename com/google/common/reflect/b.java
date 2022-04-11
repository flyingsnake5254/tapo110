package com.google.common.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public abstract class b<T, R>
  extends a
  implements GenericDeclaration
{
  <M extends AccessibleObject,  extends Member> b(M paramM)
  {
    super(paramM);
  }
  
  public final Class<? super T> getDeclaringClass()
  {
    return super.getDeclaringClass();
  }
  
  static class a<T>
    extends b<T, T>
  {
    final Constructor<?> f;
    
    a(Constructor<?> paramConstructor)
    {
      super();
      this.f = paramConstructor;
    }
    
    private boolean c()
    {
      Class localClass = this.f.getDeclaringClass();
      Object localObject = localClass.getEnclosingConstructor();
      boolean bool = true;
      if (localObject != null) {
        return true;
      }
      localObject = localClass.getEnclosingMethod();
      if (localObject != null) {
        return Modifier.isStatic(((Method)localObject).getModifiers()) ^ true;
      }
      if ((localClass.getEnclosingClass() == null) || (Modifier.isStatic(localClass.getModifiers()))) {
        bool = false;
      }
      return bool;
    }
    
    Type[] b()
    {
      Type[] arrayOfType1 = this.f.getGenericParameterTypes();
      Type[] arrayOfType2 = arrayOfType1;
      if (arrayOfType1.length > 0)
      {
        arrayOfType2 = arrayOfType1;
        if (c())
        {
          Class[] arrayOfClass = this.f.getParameterTypes();
          arrayOfType2 = arrayOfType1;
          if (arrayOfType1.length == arrayOfClass.length)
          {
            arrayOfType2 = arrayOfType1;
            if (arrayOfClass[0] == getDeclaringClass().getEnclosingClass()) {
              arrayOfType2 = (Type[])Arrays.copyOfRange(arrayOfType1, 1, arrayOfType1.length);
            }
          }
        }
      }
      return arrayOfType2;
    }
    
    public final TypeVariable<?>[] getTypeParameters()
    {
      TypeVariable[] arrayOfTypeVariable1 = getDeclaringClass().getTypeParameters();
      TypeVariable[] arrayOfTypeVariable2 = this.f.getTypeParameters();
      TypeVariable[] arrayOfTypeVariable3 = new TypeVariable[arrayOfTypeVariable1.length + arrayOfTypeVariable2.length];
      System.arraycopy(arrayOfTypeVariable1, 0, arrayOfTypeVariable3, 0, arrayOfTypeVariable1.length);
      System.arraycopy(arrayOfTypeVariable2, 0, arrayOfTypeVariable3, arrayOfTypeVariable1.length, arrayOfTypeVariable2.length);
      return arrayOfTypeVariable3;
    }
  }
  
  static class b<T>
    extends b<T, Object>
  {
    final Method f;
    
    b(Method paramMethod)
    {
      super();
      this.f = paramMethod;
    }
    
    public final TypeVariable<?>[] getTypeParameters()
    {
      return this.f.getTypeParameters();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\reflect\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */