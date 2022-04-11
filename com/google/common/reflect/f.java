package com.google.common.reflect;

import com.google.common.base.i;
import com.google.common.base.k;
import com.google.common.base.n;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.b;
import com.google.common.collect.q1;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class f
{
  private final c a;
  
  public f()
  {
    this.a = new c();
  }
  
  private f(c paramc)
  {
    this.a = paramc;
  }
  
  static f d(Type paramType)
  {
    return new f().o(b.g(paramType));
  }
  
  private static <T> T e(Class<T> paramClass, Object paramObject)
  {
    try
    {
      Object localObject = paramClass.cast(paramObject);
      return (T)localObject;
    }
    catch (ClassCastException localClassCastException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramObject);
      localStringBuilder.append(" is not a ");
      localStringBuilder.append(paramClass.getSimpleName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  static f f(Type paramType)
  {
    paramType = e.a.a(paramType);
    return new f().o(b.g(paramType));
  }
  
  private static void g(Map<d, Type> paramMap, Type paramType1, final Type paramType2)
  {
    if (paramType1.equals(paramType2)) {
      return;
    }
    new a(paramMap, paramType2).a(new Type[] { paramType1 });
  }
  
  private Type h(GenericArrayType paramGenericArrayType)
  {
    return h.k(j(paramGenericArrayType.getGenericComponentType()));
  }
  
  private ParameterizedType i(ParameterizedType paramParameterizedType)
  {
    Type localType1 = paramParameterizedType.getOwnerType();
    if (localType1 == null) {
      localType1 = null;
    } else {
      localType1 = j(localType1);
    }
    Type localType2 = j(paramParameterizedType.getRawType());
    paramParameterizedType = k(paramParameterizedType.getActualTypeArguments());
    return h.n(localType1, (Class)localType2, paramParameterizedType);
  }
  
  private Type[] k(Type[] paramArrayOfType)
  {
    Type[] arrayOfType = new Type[paramArrayOfType.length];
    for (int i = 0; i < paramArrayOfType.length; i++) {
      arrayOfType[i] = j(paramArrayOfType[i]);
    }
    return arrayOfType;
  }
  
  private WildcardType m(WildcardType paramWildcardType)
  {
    Type[] arrayOfType = paramWildcardType.getLowerBounds();
    paramWildcardType = paramWildcardType.getUpperBounds();
    return new h.j(k(arrayOfType), k(paramWildcardType));
  }
  
  public Type j(Type paramType)
  {
    n.o(paramType);
    if ((paramType instanceof TypeVariable)) {
      return this.a.a((TypeVariable)paramType);
    }
    if ((paramType instanceof ParameterizedType)) {
      return i((ParameterizedType)paramType);
    }
    if ((paramType instanceof GenericArrayType)) {
      return h((GenericArrayType)paramType);
    }
    Object localObject = paramType;
    if ((paramType instanceof WildcardType)) {
      localObject = m((WildcardType)paramType);
    }
    return (Type)localObject;
  }
  
  Type[] l(Type[] paramArrayOfType)
  {
    for (int i = 0; i < paramArrayOfType.length; i++) {
      paramArrayOfType[i] = j(paramArrayOfType[i]);
    }
    return paramArrayOfType;
  }
  
  public f n(Type paramType1, Type paramType2)
  {
    HashMap localHashMap = q1.o();
    g(localHashMap, (Type)n.o(paramType1), (Type)n.o(paramType2));
    return o(localHashMap);
  }
  
  f o(Map<d, ? extends Type> paramMap)
  {
    return new f(this.a.c(paramMap));
  }
  
  static final class a
    extends g
  {
    a(Map paramMap, Type paramType) {}
    
    void b(Class<?> paramClass)
    {
      if ((paramType2 instanceof WildcardType)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("No type mapping from ");
      localStringBuilder.append(paramClass);
      localStringBuilder.append(" to ");
      localStringBuilder.append(paramType2);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    void c(GenericArrayType paramGenericArrayType)
    {
      Type localType = paramType2;
      if ((localType instanceof WildcardType)) {
        return;
      }
      localType = h.j(localType);
      boolean bool;
      if (localType != null) {
        bool = true;
      } else {
        bool = false;
      }
      n.j(bool, "%s is not an array type.", paramType2);
      f.a(this.b, paramGenericArrayType.getGenericComponentType(), localType);
    }
    
    void d(ParameterizedType paramParameterizedType)
    {
      Object localObject = paramType2;
      if ((localObject instanceof WildcardType)) {
        return;
      }
      ParameterizedType localParameterizedType = (ParameterizedType)f.b(ParameterizedType.class, localObject);
      if ((paramParameterizedType.getOwnerType() != null) && (localParameterizedType.getOwnerType() != null)) {
        f.a(this.b, paramParameterizedType.getOwnerType(), localParameterizedType.getOwnerType());
      }
      n.k(paramParameterizedType.getRawType().equals(localParameterizedType.getRawType()), "Inconsistent raw type: %s vs. %s", paramParameterizedType, paramType2);
      localObject = paramParameterizedType.getActualTypeArguments();
      Type[] arrayOfType = localParameterizedType.getActualTypeArguments();
      int i = localObject.length;
      int j = arrayOfType.length;
      int k = 0;
      boolean bool;
      if (i == j) {
        bool = true;
      } else {
        bool = false;
      }
      n.k(bool, "%s not compatible with %s", paramParameterizedType, localParameterizedType);
      while (k < localObject.length)
      {
        f.a(this.b, localObject[k], arrayOfType[k]);
        k++;
      }
    }
    
    void e(TypeVariable<?> paramTypeVariable)
    {
      this.b.put(new f.d(paramTypeVariable), paramType2);
    }
    
    void f(WildcardType paramWildcardType)
    {
      Object localObject1 = paramType2;
      if (!(localObject1 instanceof WildcardType)) {
        return;
      }
      Object localObject2 = (WildcardType)localObject1;
      localObject1 = paramWildcardType.getUpperBounds();
      Type[] arrayOfType1 = ((WildcardType)localObject2).getUpperBounds();
      Type[] arrayOfType2 = paramWildcardType.getLowerBounds();
      localObject2 = ((WildcardType)localObject2).getLowerBounds();
      int i = localObject1.length;
      int j = arrayOfType1.length;
      int k = 0;
      boolean bool;
      if ((i == j) && (arrayOfType2.length == localObject2.length)) {
        bool = true;
      } else {
        bool = false;
      }
      n.k(bool, "Incompatible type: %s vs. %s", paramWildcardType, paramType2);
      for (j = 0;; j++)
      {
        i = k;
        if (j >= localObject1.length) {
          break;
        }
        f.a(this.b, localObject1[j], arrayOfType1[j]);
      }
      while (i < arrayOfType2.length)
      {
        f.a(this.b, arrayOfType2[i], localObject2[i]);
        i++;
      }
    }
  }
  
  private static final class b
    extends g
  {
    private final Map<f.d, Type> b = q1.o();
    
    static ImmutableMap<f.d, Type> g(Type paramType)
    {
      n.o(paramType);
      b localb = new b();
      localb.a(new Type[] { paramType });
      return ImmutableMap.copyOf(localb.b);
    }
    
    private void h(f.d paramd, Type paramType)
    {
      if (this.b.containsKey(paramd)) {
        return;
      }
      for (Type localType = paramType; localType != null; localType = (Type)this.b.get(f.d.c(localType))) {
        if (paramd.a(localType))
        {
          while (paramType != null) {
            paramType = (Type)this.b.remove(f.d.c(paramType));
          }
          return;
        }
      }
      this.b.put(paramd, paramType);
    }
    
    void b(Class<?> paramClass)
    {
      a(new Type[] { paramClass.getGenericSuperclass() });
      a(paramClass.getGenericInterfaces());
    }
    
    void d(ParameterizedType paramParameterizedType)
    {
      Class localClass = (Class)paramParameterizedType.getRawType();
      TypeVariable[] arrayOfTypeVariable = localClass.getTypeParameters();
      Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
      boolean bool;
      if (arrayOfTypeVariable.length == arrayOfType.length) {
        bool = true;
      } else {
        bool = false;
      }
      n.u(bool);
      for (int i = 0; i < arrayOfTypeVariable.length; i++) {
        h(new f.d(arrayOfTypeVariable[i]), arrayOfType[i]);
      }
      a(new Type[] { localClass });
      a(new Type[] { paramParameterizedType.getOwnerType() });
    }
    
    void e(TypeVariable<?> paramTypeVariable)
    {
      a(paramTypeVariable.getBounds());
    }
    
    void f(WildcardType paramWildcardType)
    {
      a(paramWildcardType.getUpperBounds());
    }
  }
  
  private static class c
  {
    private final ImmutableMap<f.d, Type> a;
    
    c()
    {
      this.a = ImmutableMap.of();
    }
    
    private c(ImmutableMap<f.d, Type> paramImmutableMap)
    {
      this.a = paramImmutableMap;
    }
    
    final Type a(final TypeVariable<?> paramTypeVariable)
    {
      return b(paramTypeVariable, new a(paramTypeVariable, this));
    }
    
    Type b(TypeVariable<?> paramTypeVariable, c paramc)
    {
      Object localObject = (Type)this.a.get(new f.d(paramTypeVariable));
      if (localObject == null)
      {
        localObject = paramTypeVariable.getBounds();
        if (localObject.length == 0) {
          return paramTypeVariable;
        }
        paramc = f.c(new f(paramc, null), (Type[])localObject);
        if ((h.f.a) && (Arrays.equals((Object[])localObject, paramc))) {
          return paramTypeVariable;
        }
        return h.l(paramTypeVariable.getGenericDeclaration(), paramTypeVariable.getName(), paramc);
      }
      return new f(paramc, null).j((Type)localObject);
    }
    
    final c c(Map<f.d, ? extends Type> paramMap)
    {
      ImmutableMap.b localb = ImmutableMap.builder();
      localb.f(this.a);
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        paramMap = (f.d)((Map.Entry)localObject).getKey();
        localObject = (Type)((Map.Entry)localObject).getValue();
        n.j(paramMap.a((Type)localObject) ^ true, "Type variable %s bound to itself", paramMap);
        localb.c(paramMap, localObject);
      }
      return new c(localb.a());
    }
    
    class a
      extends f.c
    {
      a(TypeVariable paramTypeVariable, f.c paramc) {}
      
      public Type b(TypeVariable<?> paramTypeVariable, f.c paramc)
      {
        if (paramTypeVariable.getGenericDeclaration().equals(paramTypeVariable.getGenericDeclaration())) {
          return paramTypeVariable;
        }
        return jdField_this.b(paramTypeVariable, paramc);
      }
    }
  }
  
  static final class d
  {
    private final TypeVariable<?> a;
    
    d(TypeVariable<?> paramTypeVariable)
    {
      this.a = ((TypeVariable)n.o(paramTypeVariable));
    }
    
    private boolean b(TypeVariable<?> paramTypeVariable)
    {
      boolean bool;
      if ((this.a.getGenericDeclaration().equals(paramTypeVariable.getGenericDeclaration())) && (this.a.getName().equals(paramTypeVariable.getName()))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    static d c(Type paramType)
    {
      if ((paramType instanceof TypeVariable)) {
        return new d((TypeVariable)paramType);
      }
      return null;
    }
    
    boolean a(Type paramType)
    {
      if ((paramType instanceof TypeVariable)) {
        return b((TypeVariable)paramType);
      }
      return false;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof d)) {
        return b(((d)paramObject).a);
      }
      return false;
    }
    
    public int hashCode()
    {
      return k.b(new Object[] { this.a.getGenericDeclaration(), this.a.getName() });
    }
    
    public String toString()
    {
      return this.a.toString();
    }
  }
  
  private static class e
  {
    static final e a = new e();
    private final AtomicInteger b;
    
    private e()
    {
      this(new AtomicInteger());
    }
    
    private e(AtomicInteger paramAtomicInteger)
    {
      this.b = paramAtomicInteger;
    }
    
    private Type c(@NullableDecl Type paramType)
    {
      if (paramType == null) {
        return null;
      }
      return a(paramType);
    }
    
    private e d(final TypeVariable<?> paramTypeVariable)
    {
      return new a(this.b, paramTypeVariable);
    }
    
    private e e()
    {
      return new e(this.b);
    }
    
    final Type a(Type paramType)
    {
      n.o(paramType);
      if ((paramType instanceof Class)) {
        return paramType;
      }
      if ((paramType instanceof TypeVariable)) {
        return paramType;
      }
      if ((paramType instanceof GenericArrayType))
      {
        paramType = (GenericArrayType)paramType;
        return h.k(e().a(paramType.getGenericComponentType()));
      }
      Object localObject;
      if ((paramType instanceof ParameterizedType))
      {
        paramType = (ParameterizedType)paramType;
        Class localClass = (Class)paramType.getRawType();
        TypeVariable[] arrayOfTypeVariable = localClass.getTypeParameters();
        localObject = paramType.getActualTypeArguments();
        for (int i = 0; i < localObject.length; i++) {
          localObject[i] = d(arrayOfTypeVariable[i]).a(localObject[i]);
        }
        return h.n(e().c(paramType.getOwnerType()), localClass, (Type[])localObject);
      }
      if ((paramType instanceof WildcardType))
      {
        localObject = (WildcardType)paramType;
        if (((WildcardType)localObject).getLowerBounds().length == 0) {
          paramType = b(((WildcardType)localObject).getUpperBounds());
        }
        return paramType;
      }
      throw new AssertionError("must have been one of the known types");
    }
    
    TypeVariable<?> b(Type[] paramArrayOfType)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("capture#");
      localStringBuilder.append(this.b.incrementAndGet());
      localStringBuilder.append("-of ? extends ");
      localStringBuilder.append(i.f('&').e(paramArrayOfType));
      return h.l(e.class, localStringBuilder.toString(), paramArrayOfType);
    }
    
    class a
      extends f.e
    {
      a(AtomicInteger paramAtomicInteger, TypeVariable paramTypeVariable)
      {
        super(null);
      }
      
      TypeVariable<?> b(Type[] paramArrayOfType)
      {
        paramArrayOfType = new LinkedHashSet(Arrays.asList(paramArrayOfType));
        paramArrayOfType.addAll(Arrays.asList(paramTypeVariable.getBounds()));
        if (paramArrayOfType.size() > 1) {
          paramArrayOfType.remove(Object.class);
        }
        return super.b((Type[])paramArrayOfType.toArray(new Type[0]));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\reflect\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */