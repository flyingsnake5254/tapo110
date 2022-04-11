package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class b
{
  static final Type[] a = new Type[0];
  
  public static GenericArrayType a(Type paramType)
  {
    return new a(paramType);
  }
  
  public static Type b(Type paramType)
  {
    if ((paramType instanceof Class))
    {
      Class localClass = (Class)paramType;
      paramType = localClass;
      if (localClass.isArray()) {
        paramType = new a(b(localClass.getComponentType()));
      }
      return paramType;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = (ParameterizedType)paramType;
      return new b(paramType.getOwnerType(), paramType.getRawType(), paramType.getActualTypeArguments());
    }
    if ((paramType instanceof GenericArrayType)) {
      return new a(((GenericArrayType)paramType).getGenericComponentType());
    }
    if ((paramType instanceof WildcardType))
    {
      paramType = (WildcardType)paramType;
      return new c(paramType.getUpperBounds(), paramType.getLowerBounds());
    }
    return paramType;
  }
  
  static void c(Type paramType)
  {
    boolean bool;
    if (((paramType instanceof Class)) && (((Class)paramType).isPrimitive())) {
      bool = false;
    } else {
      bool = true;
    }
    a.a(bool);
  }
  
  private static Class<?> d(TypeVariable<?> paramTypeVariable)
  {
    paramTypeVariable = paramTypeVariable.getGenericDeclaration();
    if ((paramTypeVariable instanceof Class)) {
      paramTypeVariable = (Class)paramTypeVariable;
    } else {
      paramTypeVariable = null;
    }
    return paramTypeVariable;
  }
  
  static boolean e(Object paramObject1, Object paramObject2)
  {
    boolean bool;
    if ((paramObject1 != paramObject2) && ((paramObject1 == null) || (!paramObject1.equals(paramObject2)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean f(Type paramType1, Type paramType2)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = true;
    if (paramType1 == paramType2) {
      return true;
    }
    if ((paramType1 instanceof Class)) {
      return paramType1.equals(paramType2);
    }
    if ((paramType1 instanceof ParameterizedType))
    {
      if (!(paramType2 instanceof ParameterizedType)) {
        return false;
      }
      paramType1 = (ParameterizedType)paramType1;
      paramType2 = (ParameterizedType)paramType2;
      if ((!e(paramType1.getOwnerType(), paramType2.getOwnerType())) || (!paramType1.getRawType().equals(paramType2.getRawType())) || (!Arrays.equals(paramType1.getActualTypeArguments(), paramType2.getActualTypeArguments()))) {
        bool3 = false;
      }
      return bool3;
    }
    if ((paramType1 instanceof GenericArrayType))
    {
      if (!(paramType2 instanceof GenericArrayType)) {
        return false;
      }
      paramType1 = (GenericArrayType)paramType1;
      paramType2 = (GenericArrayType)paramType2;
      return f(paramType1.getGenericComponentType(), paramType2.getGenericComponentType());
    }
    if ((paramType1 instanceof WildcardType))
    {
      if (!(paramType2 instanceof WildcardType)) {
        return false;
      }
      paramType1 = (WildcardType)paramType1;
      paramType2 = (WildcardType)paramType2;
      if ((Arrays.equals(paramType1.getUpperBounds(), paramType2.getUpperBounds())) && (Arrays.equals(paramType1.getLowerBounds(), paramType2.getLowerBounds()))) {
        bool3 = bool1;
      } else {
        bool3 = false;
      }
      return bool3;
    }
    if ((paramType1 instanceof TypeVariable))
    {
      if (!(paramType2 instanceof TypeVariable)) {
        return false;
      }
      paramType1 = (TypeVariable)paramType1;
      paramType2 = (TypeVariable)paramType2;
      if ((paramType1.getGenericDeclaration() == paramType2.getGenericDeclaration()) && (paramType1.getName().equals(paramType2.getName()))) {
        bool3 = bool2;
      } else {
        bool3 = false;
      }
      return bool3;
    }
    return false;
  }
  
  public static Type g(Type paramType)
  {
    if ((paramType instanceof GenericArrayType)) {
      paramType = ((GenericArrayType)paramType).getGenericComponentType();
    } else {
      paramType = ((Class)paramType).getComponentType();
    }
    return paramType;
  }
  
  public static Type h(Type paramType, Class<?> paramClass)
  {
    paramClass = l(paramType, paramClass, Collection.class);
    paramType = paramClass;
    if ((paramClass instanceof WildcardType)) {
      paramType = ((WildcardType)paramClass).getUpperBounds()[0];
    }
    if ((paramType instanceof ParameterizedType)) {
      return ((ParameterizedType)paramType).getActualTypeArguments()[0];
    }
    return Object.class;
  }
  
  static Type i(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2 == paramClass1) {
      return paramType;
    }
    if (paramClass2.isInterface())
    {
      paramType = paramClass1.getInterfaces();
      int i = 0;
      int j = paramType.length;
      while (i < j)
      {
        if (paramType[i] == paramClass2) {
          return paramClass1.getGenericInterfaces()[i];
        }
        if (paramClass2.isAssignableFrom(paramType[i])) {
          return i(paramClass1.getGenericInterfaces()[i], paramType[i], paramClass2);
        }
        i++;
      }
    }
    if (!paramClass1.isInterface()) {
      while (paramClass1 != Object.class)
      {
        paramType = paramClass1.getSuperclass();
        if (paramType == paramClass2) {
          return paramClass1.getGenericSuperclass();
        }
        if (paramClass2.isAssignableFrom(paramType)) {
          return i(paramClass1.getGenericSuperclass(), paramType, paramClass2);
        }
        paramClass1 = paramType;
      }
    }
    return paramClass2;
  }
  
  public static Type[] j(Type paramType, Class<?> paramClass)
  {
    if (paramType == Properties.class) {
      return new Type[] { String.class, String.class };
    }
    paramType = l(paramType, paramClass, Map.class);
    if ((paramType instanceof ParameterizedType)) {
      return ((ParameterizedType)paramType).getActualTypeArguments();
    }
    return new Type[] { Object.class, Object.class };
  }
  
  public static Class<?> k(Type paramType)
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
      return Array.newInstance(k(((GenericArrayType)paramType).getGenericComponentType()), 0).getClass();
    }
    if ((paramType instanceof TypeVariable)) {
      return Object.class;
    }
    if ((paramType instanceof WildcardType)) {
      return k(((WildcardType)paramType).getUpperBounds()[0]);
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
  
  static Type l(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    Type localType = paramType;
    if ((paramType instanceof WildcardType)) {
      localType = ((WildcardType)paramType).getUpperBounds()[0];
    }
    a.a(paramClass2.isAssignableFrom(paramClass1));
    return p(localType, paramClass1, i(localType, paramClass1, paramClass2));
  }
  
  static int m(Object paramObject)
  {
    int i;
    if (paramObject != null) {
      i = paramObject.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  private static int n(Object[] paramArrayOfObject, Object paramObject)
  {
    int i = paramArrayOfObject.length;
    for (int j = 0; j < i; j++) {
      if (paramObject.equals(paramArrayOfObject[j])) {
        return j;
      }
    }
    throw new NoSuchElementException();
  }
  
  public static ParameterizedType o(Type paramType1, Type paramType2, Type... paramVarArgs)
  {
    return new b(paramType1, paramType2, paramVarArgs);
  }
  
  public static Type p(Type paramType1, Class<?> paramClass, Type paramType2)
  {
    return q(paramType1, paramClass, paramType2, new HashSet());
  }
  
  private static Type q(Type paramType1, Class<?> paramClass, Type paramType2, Collection<TypeVariable> paramCollection)
  {
    Object localObject1;
    while ((paramType2 instanceof TypeVariable))
    {
      localObject1 = (TypeVariable)paramType2;
      if (paramCollection.contains(localObject1)) {
        return paramType2;
      }
      paramCollection.add(localObject1);
      localObject2 = r(paramType1, paramClass, (TypeVariable)localObject1);
      paramType2 = (Type)localObject2;
      if (localObject2 == localObject1) {
        return (Type)localObject2;
      }
    }
    if ((paramType2 instanceof Class))
    {
      localObject2 = (Class)paramType2;
      if (((Class)localObject2).isArray())
      {
        paramType2 = ((Class)localObject2).getComponentType();
        paramType1 = q(paramType1, paramClass, paramType2, paramCollection);
        if (paramType2 == paramType1) {
          paramType1 = (Type)localObject2;
        } else {
          paramType1 = a(paramType1);
        }
        return paramType1;
      }
    }
    if ((paramType2 instanceof GenericArrayType))
    {
      paramType2 = (GenericArrayType)paramType2;
      localObject2 = paramType2.getGenericComponentType();
      paramType1 = q(paramType1, paramClass, (Type)localObject2, paramCollection);
      if (localObject2 == paramType1) {
        paramType1 = paramType2;
      } else {
        paramType1 = a(paramType1);
      }
      return paramType1;
    }
    boolean bool = paramType2 instanceof ParameterizedType;
    int i = 0;
    Object localObject3;
    if (bool)
    {
      localObject1 = (ParameterizedType)paramType2;
      paramType2 = ((ParameterizedType)localObject1).getOwnerType();
      localObject3 = q(paramType1, paramClass, paramType2, paramCollection);
      int j;
      if (localObject3 != paramType2) {
        j = 1;
      } else {
        j = 0;
      }
      paramType2 = ((ParameterizedType)localObject1).getActualTypeArguments();
      int k = paramType2.length;
      while (i < k)
      {
        Type localType = q(paramType1, paramClass, paramType2[i], paramCollection);
        int m = j;
        localObject2 = paramType2;
        if (localType != paramType2[i])
        {
          m = j;
          localObject2 = paramType2;
          if (j == 0)
          {
            localObject2 = (Type[])paramType2.clone();
            m = 1;
          }
          localObject2[i] = localType;
        }
        i++;
        j = m;
        paramType2 = (Type)localObject2;
      }
      paramType1 = (Type)localObject1;
      if (j != 0) {
        paramType1 = o((Type)localObject3, ((ParameterizedType)localObject1).getRawType(), paramType2);
      }
      return paramType1;
    }
    Object localObject2 = paramType2;
    if ((paramType2 instanceof WildcardType))
    {
      paramType2 = (WildcardType)paramType2;
      localObject3 = paramType2.getLowerBounds();
      localObject1 = paramType2.getUpperBounds();
      if (localObject3.length == 1)
      {
        paramType1 = q(paramType1, paramClass, localObject3[0], paramCollection);
        localObject2 = paramType2;
        if (paramType1 != localObject3[0]) {
          return t(paramType1);
        }
      }
      else
      {
        localObject2 = paramType2;
        if (localObject1.length == 1) {
          localObject2 = localObject1[0];
        }
      }
    }
    try
    {
      paramType1 = q(paramType1, paramClass, (Type)localObject2, paramCollection);
      localObject2 = paramType2;
      if (paramType1 != localObject1[0]) {
        return s(paramType1);
      }
      return (Type)localObject2;
    }
    finally {}
  }
  
  static Type r(Type paramType, Class<?> paramClass, TypeVariable<?> paramTypeVariable)
  {
    Class localClass = d(paramTypeVariable);
    if (localClass == null) {
      return paramTypeVariable;
    }
    paramType = i(paramType, paramClass, localClass);
    if ((paramType instanceof ParameterizedType))
    {
      int i = n(localClass.getTypeParameters(), paramTypeVariable);
      return ((ParameterizedType)paramType).getActualTypeArguments()[i];
    }
    return paramTypeVariable;
  }
  
  public static WildcardType s(Type paramType)
  {
    if ((paramType instanceof WildcardType)) {
      paramType = ((WildcardType)paramType).getUpperBounds();
    } else {
      paramType = new Type[] { paramType };
    }
    return new c(paramType, a);
  }
  
  public static WildcardType t(Type paramType)
  {
    if ((paramType instanceof WildcardType)) {
      paramType = ((WildcardType)paramType).getLowerBounds();
    } else {
      paramType = new Type[] { paramType };
    }
    return new c(new Type[] { Object.class }, paramType);
  }
  
  public static String u(Type paramType)
  {
    if ((paramType instanceof Class)) {
      paramType = ((Class)paramType).getName();
    } else {
      paramType = paramType.toString();
    }
    return paramType;
  }
  
  private static final class a
    implements GenericArrayType, Serializable
  {
    private final Type c;
    
    public a(Type paramType)
    {
      this.c = b.b(paramType);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool;
      if (((paramObject instanceof GenericArrayType)) && (b.f(this, (GenericArrayType)paramObject))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public Type getGenericComponentType()
    {
      return this.c;
    }
    
    public int hashCode()
    {
      return this.c.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b.u(this.c));
      localStringBuilder.append("[]");
      return localStringBuilder.toString();
    }
  }
  
  private static final class b
    implements ParameterizedType, Serializable
  {
    private final Type c;
    private final Type d;
    private final Type[] f;
    
    public b(Type paramType1, Type paramType2, Type... paramVarArgs)
    {
      boolean bool1 = paramType2 instanceof Class;
      int i = 0;
      if (bool1)
      {
        Class localClass = (Class)paramType2;
        bool1 = Modifier.isStatic(localClass.getModifiers());
        boolean bool2 = true;
        if ((!bool1) && (localClass.getEnclosingClass() != null)) {
          j = 0;
        } else {
          j = 1;
        }
        bool1 = bool2;
        if (paramType1 == null) {
          if (j != 0) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
        a.a(bool1);
      }
      if (paramType1 == null) {
        paramType1 = null;
      } else {
        paramType1 = b.b(paramType1);
      }
      this.c = paramType1;
      this.d = b.b(paramType2);
      paramType1 = (Type[])paramVarArgs.clone();
      this.f = paramType1;
      int k = paramType1.length;
      for (int j = i; j < k; j++)
      {
        a.b(this.f[j]);
        b.c(this.f[j]);
        paramType1 = this.f;
        paramType1[j] = b.b(paramType1[j]);
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool;
      if (((paramObject instanceof ParameterizedType)) && (b.f(this, (ParameterizedType)paramObject))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public Type[] getActualTypeArguments()
    {
      return (Type[])this.f.clone();
    }
    
    public Type getOwnerType()
    {
      return this.c;
    }
    
    public Type getRawType()
    {
      return this.d;
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(this.f) ^ this.d.hashCode() ^ b.m(this.c);
    }
    
    public String toString()
    {
      int i = this.f.length;
      if (i == 0) {
        return b.u(this.d);
      }
      StringBuilder localStringBuilder = new StringBuilder((i + 1) * 30);
      localStringBuilder.append(b.u(this.d));
      localStringBuilder.append("<");
      localStringBuilder.append(b.u(this.f[0]));
      for (int j = 1; j < i; j++)
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(b.u(this.f[j]));
      }
      localStringBuilder.append(">");
      return localStringBuilder.toString();
    }
  }
  
  private static final class c
    implements WildcardType, Serializable
  {
    private final Type c;
    private final Type d;
    
    public c(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
    {
      int i = paramArrayOfType2.length;
      boolean bool1 = true;
      boolean bool2;
      if (i <= 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      a.a(bool2);
      if (paramArrayOfType1.length == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      a.a(bool2);
      if (paramArrayOfType2.length == 1)
      {
        a.b(paramArrayOfType2[0]);
        b.c(paramArrayOfType2[0]);
        if (paramArrayOfType1[0] == Object.class) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
        a.a(bool2);
        this.d = b.b(paramArrayOfType2[0]);
        this.c = Object.class;
      }
      else
      {
        a.b(paramArrayOfType1[0]);
        b.c(paramArrayOfType1[0]);
        this.d = null;
        this.c = b.b(paramArrayOfType1[0]);
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool;
      if (((paramObject instanceof WildcardType)) && (b.f(this, (WildcardType)paramObject))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public Type[] getLowerBounds()
    {
      Type localType = this.d;
      Type[] arrayOfType;
      if (localType != null)
      {
        arrayOfType = new Type[1];
        arrayOfType[0] = localType;
      }
      else
      {
        arrayOfType = b.a;
      }
      return arrayOfType;
    }
    
    public Type[] getUpperBounds()
    {
      return new Type[] { this.c };
    }
    
    public int hashCode()
    {
      Type localType = this.d;
      int i;
      if (localType != null) {
        i = localType.hashCode() + 31;
      } else {
        i = 1;
      }
      return i ^ this.c.hashCode() + 31;
    }
    
    public String toString()
    {
      if (this.d != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("? super ");
        localStringBuilder.append(b.u(this.d));
        return localStringBuilder.toString();
      }
      if (this.c == Object.class) {
        return "?";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("? extends ");
      localStringBuilder.append(b.u(this.c));
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */