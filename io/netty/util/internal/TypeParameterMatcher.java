package io.netty.util.internal;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public abstract class TypeParameterMatcher
{
  private static final TypeParameterMatcher NOOP = new TypeParameterMatcher()
  {
    public boolean match(Object paramAnonymousObject)
    {
      return true;
    }
  };
  
  private static Class<?> fail(Class<?> paramClass, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cannot determine the type of the type parameter '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("': ");
    localStringBuilder.append(paramClass);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public static TypeParameterMatcher find(Object paramObject, Class<?> paramClass, String paramString)
  {
    Map localMap = InternalThreadLocalMap.get().typeParameterMatcherFindCache();
    Object localObject1 = paramObject.getClass();
    Object localObject2 = (Map)localMap.get(localObject1);
    Object localObject3 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = new HashMap();
      localMap.put(localObject1, localObject3);
    }
    localObject1 = (TypeParameterMatcher)((Map)localObject3).get(paramString);
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = get(find0(paramObject, paramClass, paramString));
      ((Map)localObject3).put(paramString, localObject2);
    }
    return (TypeParameterMatcher)localObject2;
  }
  
  private static Class<?> find0(Object paramObject, Class<?> paramClass, String paramString)
  {
    Class localClass = paramObject.getClass();
    paramObject = localClass;
    Object localObject;
    do
    {
      while (((Class)paramObject).getSuperclass() == paramClass)
      {
        int i = -1;
        localObject = ((Class)paramObject).getSuperclass().getTypeParameters();
        int k;
        for (int j = 0;; j++)
        {
          k = i;
          if (j >= localObject.length) {
            break;
          }
          if (paramString.equals(localObject[j].getName()))
          {
            k = j;
            break;
          }
        }
        if (k >= 0)
        {
          paramObject = ((Class)paramObject).getGenericSuperclass();
          if (!(paramObject instanceof ParameterizedType)) {
            return Object.class;
          }
          paramClass = ((ParameterizedType)paramObject).getActualTypeArguments()[k];
          paramObject = paramClass;
          if ((paramClass instanceof ParameterizedType)) {
            paramObject = ((ParameterizedType)paramClass).getRawType();
          }
          if ((paramObject instanceof Class)) {
            return (Class)paramObject;
          }
          if ((paramObject instanceof GenericArrayType))
          {
            localObject = ((GenericArrayType)paramObject).getGenericComponentType();
            paramClass = (Class<?>)localObject;
            if ((localObject instanceof ParameterizedType)) {
              paramClass = ((ParameterizedType)localObject).getRawType();
            }
            if ((paramClass instanceof Class)) {
              return Array.newInstance((Class)paramClass, 0).getClass();
            }
          }
          if ((paramObject instanceof TypeVariable))
          {
            paramObject = (TypeVariable)paramObject;
            if (!(((TypeVariable)paramObject).getGenericDeclaration() instanceof Class)) {
              return Object.class;
            }
            paramClass = (Class)((TypeVariable)paramObject).getGenericDeclaration();
            paramString = ((TypeVariable)paramObject).getName();
            if (paramClass.isAssignableFrom(localClass)) {
              paramObject = localClass;
            } else {
              return Object.class;
            }
          }
          else
          {
            return fail(localClass, paramString);
          }
        }
        else
        {
          paramObject = new StringBuilder();
          ((StringBuilder)paramObject).append("unknown type parameter '");
          ((StringBuilder)paramObject).append(paramString);
          ((StringBuilder)paramObject).append("': ");
          ((StringBuilder)paramObject).append(paramClass);
          throw new IllegalStateException(((StringBuilder)paramObject).toString());
        }
      }
      localObject = ((Class)paramObject).getSuperclass();
      paramObject = localObject;
    } while (localObject != null);
    return fail(localClass, paramString);
  }
  
  public static TypeParameterMatcher get(Class<?> paramClass)
  {
    Map localMap = InternalThreadLocalMap.get().typeParameterMatcherGetCache();
    TypeParameterMatcher localTypeParameterMatcher = (TypeParameterMatcher)localMap.get(paramClass);
    Object localObject = localTypeParameterMatcher;
    if (localTypeParameterMatcher == null)
    {
      if (paramClass == Object.class) {
        localObject = NOOP;
      } else {
        localObject = new ReflectiveMatcher(paramClass);
      }
      localMap.put(paramClass, localObject);
    }
    return (TypeParameterMatcher)localObject;
  }
  
  public abstract boolean match(Object paramObject);
  
  private static final class ReflectiveMatcher
    extends TypeParameterMatcher
  {
    private final Class<?> type;
    
    ReflectiveMatcher(Class<?> paramClass)
    {
      this.type = paramClass;
    }
    
    public boolean match(Object paramObject)
    {
      return this.type.isInstance(paramObject);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\TypeParameterMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */