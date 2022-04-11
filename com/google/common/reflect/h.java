package com.google.common.reflect;

import com.google.common.base.i;
import com.google.common.base.k;
import com.google.common.base.n;
import com.google.common.base.p;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.a;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.b;
import com.google.common.collect.j1;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class h
{
  private static final com.google.common.base.h<Type, String> a = new a();
  private static final i b = i.g(", ").i("null");
  
  private static void g(Type[] paramArrayOfType, String paramString)
  {
    int i = paramArrayOfType.length;
    for (int j = 0; j < i; j++)
    {
      Object localObject = paramArrayOfType[j];
      if ((localObject instanceof Class))
      {
        localObject = (Class)localObject;
        n.k(((Class)localObject).isPrimitive() ^ true, "Primitive type '%s' used as %s", localObject, paramString);
      }
    }
  }
  
  private static Iterable<Type> h(Iterable<Type> paramIterable)
  {
    return j1.d(paramIterable, p.f(p.c(Object.class)));
  }
  
  static Class<?> i(Class<?> paramClass)
  {
    return Array.newInstance(paramClass, 0).getClass();
  }
  
  @NullableDecl
  static Type j(Type paramType)
  {
    n.o(paramType);
    AtomicReference localAtomicReference = new AtomicReference();
    new b(localAtomicReference).a(new Type[] { paramType });
    return (Type)localAtomicReference.get();
  }
  
  static Type k(Type paramType)
  {
    if ((paramType instanceof WildcardType))
    {
      paramType = (WildcardType)paramType;
      Type[] arrayOfType = paramType.getLowerBounds();
      int i = arrayOfType.length;
      boolean bool1 = true;
      boolean bool2;
      if (i <= 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      n.e(bool2, "Wildcard cannot have more than one lower bounds.");
      if (arrayOfType.length == 1) {
        return r(k(arrayOfType[0]));
      }
      paramType = paramType.getUpperBounds();
      if (paramType.length == 1) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      n.e(bool2, "Wildcard should have only one upper bound.");
      return p(k(paramType[0]));
    }
    return e.x.b(paramType);
  }
  
  static <D extends GenericDeclaration> TypeVariable<D> l(D paramD, String paramString, Type... paramVarArgs)
  {
    Type[] arrayOfType = paramVarArgs;
    if (paramVarArgs.length == 0)
    {
      arrayOfType = new Type[1];
      arrayOfType[0] = Object.class;
    }
    return o(paramD, paramString, arrayOfType);
  }
  
  static ParameterizedType m(Class<?> paramClass, Type... paramVarArgs)
  {
    return new g(c.f.b(paramClass), paramClass, paramVarArgs);
  }
  
  static ParameterizedType n(@NullableDecl Type paramType, Class<?> paramClass, Type... paramVarArgs)
  {
    if (paramType == null) {
      return m(paramClass, paramVarArgs);
    }
    n.o(paramVarArgs);
    boolean bool;
    if (paramClass.getEnclosingClass() != null) {
      bool = true;
    } else {
      bool = false;
    }
    n.j(bool, "Owner type for unenclosed %s", paramClass);
    return new g(paramType, paramClass, paramVarArgs);
  }
  
  private static <D extends GenericDeclaration> TypeVariable<D> o(D paramD, String paramString, Type[] paramArrayOfType)
  {
    return (TypeVariable)c.a(TypeVariable.class, new i(new h(paramD, paramString, paramArrayOfType)));
  }
  
  static WildcardType p(Type paramType)
  {
    return new j(new Type[0], new Type[] { paramType });
  }
  
  @NullableDecl
  private static Type q(Type[] paramArrayOfType)
  {
    int i = paramArrayOfType.length;
    for (int j = 0; j < i; j++)
    {
      Type localType = j(paramArrayOfType[j]);
      if (localType != null)
      {
        if ((localType instanceof Class))
        {
          paramArrayOfType = (Class)localType;
          if (paramArrayOfType.isPrimitive()) {
            return paramArrayOfType;
          }
        }
        return p(localType);
      }
    }
    return null;
  }
  
  static WildcardType r(Type paramType)
  {
    return new j(new Type[] { paramType }, new Type[] { Object.class });
  }
  
  private static Type[] s(Collection<Type> paramCollection)
  {
    return (Type[])paramCollection.toArray(new Type[paramCollection.size()]);
  }
  
  static String t(Type paramType)
  {
    if ((paramType instanceof Class)) {
      paramType = ((Class)paramType).getName();
    } else {
      paramType = paramType.toString();
    }
    return paramType;
  }
  
  static final class a
    implements com.google.common.base.h<Type, String>
  {
    public String a(Type paramType)
    {
      return h.e.x.d(paramType);
    }
  }
  
  static final class b
    extends g
  {
    b(AtomicReference paramAtomicReference) {}
    
    void b(Class<?> paramClass)
    {
      this.b.set(paramClass.getComponentType());
    }
    
    void c(GenericArrayType paramGenericArrayType)
    {
      this.b.set(paramGenericArrayType.getGenericComponentType());
    }
    
    void e(TypeVariable<?> paramTypeVariable)
    {
      this.b.set(h.a(paramTypeVariable.getBounds()));
    }
    
    void f(WildcardType paramWildcardType)
    {
      this.b.set(h.a(paramWildcardType.getUpperBounds()));
    }
  }
  
  private static abstract enum c
  {
    static final c f = a();
    
    static
    {
      a locala = new a("OWNED_BY_ENCLOSING_CLASS", 0);
      c = locala;
      c localc = new c("LOCAL_CLASS_HAS_NO_OWNER", 1);
      d = localc;
      q = new c[] { locala, localc };
    }
    
    private static c a()
    {
      new d();
      ParameterizedType localParameterizedType = (ParameterizedType)d.class.getGenericSuperclass();
      for (c localc : values()) {
        if (localc.b(b.class) == localParameterizedType.getOwnerType()) {
          return localc;
        }
      }
      throw new AssertionError();
    }
    
    @NullableDecl
    abstract Class<?> b(Class<?> paramClass);
    
    static enum a
    {
      a()
      {
        super(paramInt, null);
      }
      
      @NullableDecl
      Class<?> b(Class<?> paramClass)
      {
        return paramClass.getEnclosingClass();
      }
    }
    
    class b<T> {}
    
    static enum c
    {
      c()
      {
        super(paramInt, null);
      }
      
      @NullableDecl
      Class<?> b(Class<?> paramClass)
      {
        if (paramClass.isLocalClass()) {
          return null;
        }
        return paramClass.getEnclosingClass();
      }
    }
    
    static final class d
      extends h.c.b<String>
    {}
  }
  
  private static final class d
    implements GenericArrayType, Serializable
  {
    private final Type c;
    
    d(Type paramType)
    {
      this.c = h.e.x.g(paramType);
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof GenericArrayType))
      {
        paramObject = (GenericArrayType)paramObject;
        return k.a(getGenericComponentType(), ((GenericArrayType)paramObject).getGenericComponentType());
      }
      return false;
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
      localStringBuilder.append(h.t(this.c));
      localStringBuilder.append("[]");
      return localStringBuilder.toString();
    }
  }
  
  static abstract enum e
  {
    static final e x;
    
    static
    {
      a locala = new a("JAVA6", 0);
      c = locala;
      b localb = new b("JAVA7", 1);
      d = localb;
      c localc = new c("JAVA8", 2);
      f = localc;
      d locald = new d("JAVA9", 3);
      q = locald;
      y = new e[] { locala, localb, localc, locald };
      if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class))
      {
        if (new e().capture().toString().contains("java.util.Map.java.util.Map")) {
          x = localc;
        } else {
          x = locald;
        }
      }
      else if ((new f().capture() instanceof Class)) {
        x = localb;
      } else {
        x = locala;
      }
    }
    
    boolean a()
    {
      return true;
    }
    
    abstract Type b(Type paramType);
    
    String d(Type paramType)
    {
      return h.t(paramType);
    }
    
    final ImmutableList<Type> f(Type[] paramArrayOfType)
    {
      ImmutableList.a locala = ImmutableList.builder();
      int i = paramArrayOfType.length;
      for (int j = 0; j < i; j++) {
        locala.h(g(paramArrayOfType[j]));
      }
      return locala.j();
    }
    
    abstract Type g(Type paramType);
    
    static enum a
    {
      a()
      {
        super(paramInt, null);
      }
      
      Type g(Type paramType)
      {
        n.o(paramType);
        Object localObject = paramType;
        if ((paramType instanceof Class))
        {
          Class localClass = (Class)paramType;
          localObject = paramType;
          if (localClass.isArray()) {
            localObject = new h.d(localClass.getComponentType());
          }
        }
        return (Type)localObject;
      }
      
      GenericArrayType h(Type paramType)
      {
        return new h.d(paramType);
      }
    }
    
    static enum b
    {
      b()
      {
        super(paramInt, null);
      }
      
      Type b(Type paramType)
      {
        if ((paramType instanceof Class)) {
          return h.i((Class)paramType);
        }
        return new h.d(paramType);
      }
      
      Type g(Type paramType)
      {
        return (Type)n.o(paramType);
      }
    }
    
    static enum c
    {
      c()
      {
        super(paramInt, null);
      }
      
      Type b(Type paramType)
      {
        return h.e.d.b(paramType);
      }
      
      String d(Type paramType)
      {
        try
        {
          try
          {
            paramType = (String)Type.class.getMethod("getTypeName", new Class[0]).invoke(paramType, new Object[0]);
            return paramType;
          }
          catch (IllegalAccessException paramType) {}catch (InvocationTargetException paramType) {}
          throw new RuntimeException(paramType);
        }
        catch (NoSuchMethodException paramType)
        {
          throw new AssertionError("Type.getTypeName should be available in Java 8");
        }
      }
      
      Type g(Type paramType)
      {
        return h.e.d.g(paramType);
      }
    }
    
    static enum d
    {
      d()
      {
        super(paramInt, null);
      }
      
      boolean a()
      {
        return false;
      }
      
      Type b(Type paramType)
      {
        return h.e.f.b(paramType);
      }
      
      String d(Type paramType)
      {
        return h.e.f.d(paramType);
      }
      
      Type g(Type paramType)
      {
        return h.e.f.g(paramType);
      }
    }
    
    static final class e
      extends d<Map.Entry<String, int[][]>>
    {}
    
    static final class f
      extends d<int[]>
    {}
  }
  
  static final class f<X>
  {
    static final boolean a = f.class.getTypeParameters()[0].equals(h.l(f.class, "X", new Type[0])) ^ true;
  }
  
  private static final class g
    implements ParameterizedType, Serializable
  {
    @NullableDecl
    private final Type c;
    private final ImmutableList<Type> d;
    private final Class<?> f;
    
    g(@NullableDecl Type paramType, Class<?> paramClass, Type[] paramArrayOfType)
    {
      n.o(paramClass);
      boolean bool;
      if (paramArrayOfType.length == paramClass.getTypeParameters().length) {
        bool = true;
      } else {
        bool = false;
      }
      n.d(bool);
      h.b(paramArrayOfType, "type parameter");
      this.c = paramType;
      this.f = paramClass;
      this.d = h.e.x.f(paramArrayOfType);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof ParameterizedType;
      boolean bool2 = false;
      if (!bool1) {
        return false;
      }
      paramObject = (ParameterizedType)paramObject;
      bool1 = bool2;
      if (getRawType().equals(((ParameterizedType)paramObject).getRawType()))
      {
        bool1 = bool2;
        if (k.a(getOwnerType(), ((ParameterizedType)paramObject).getOwnerType()))
        {
          bool1 = bool2;
          if (Arrays.equals(getActualTypeArguments(), ((ParameterizedType)paramObject).getActualTypeArguments())) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public Type[] getActualTypeArguments()
    {
      return h.c(this.d);
    }
    
    public Type getOwnerType()
    {
      return this.c;
    }
    
    public Type getRawType()
    {
      return this.f;
    }
    
    public int hashCode()
    {
      Type localType = this.c;
      int i;
      if (localType == null) {
        i = 0;
      } else {
        i = localType.hashCode();
      }
      return i ^ this.d.hashCode() ^ this.f.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.c != null)
      {
        h.e locale = h.e.x;
        if (locale.a())
        {
          localStringBuilder.append(locale.d(this.c));
          localStringBuilder.append('.');
        }
      }
      localStringBuilder.append(this.f.getName());
      localStringBuilder.append('<');
      localStringBuilder.append(h.e().c(j1.o(this.d, h.d())));
      localStringBuilder.append('>');
      return localStringBuilder.toString();
    }
  }
  
  private static final class h<D extends GenericDeclaration>
  {
    private final D a;
    private final String b;
    private final ImmutableList<Type> c;
    
    h(D paramD, String paramString, Type[] paramArrayOfType)
    {
      h.b(paramArrayOfType, "bound for type variable");
      this.a = ((GenericDeclaration)n.o(paramD));
      this.b = ((String)n.o(paramString));
      this.c = ImmutableList.copyOf(paramArrayOfType);
    }
    
    public D a()
    {
      return this.a;
    }
    
    public String b()
    {
      return this.b;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = h.f.a;
      boolean bool2 = true;
      boolean bool3 = true;
      if (bool1)
      {
        if ((paramObject != null) && (Proxy.isProxyClass(paramObject.getClass())) && ((Proxy.getInvocationHandler(paramObject) instanceof h.i)))
        {
          paramObject = h.i.a((h.i)Proxy.getInvocationHandler(paramObject));
          if ((!this.b.equals(((h)paramObject).b())) || (!this.a.equals(((h)paramObject).a())) || (!this.c.equals(((h)paramObject).c))) {
            bool3 = false;
          }
          return bool3;
        }
        return false;
      }
      if ((paramObject instanceof TypeVariable))
      {
        paramObject = (TypeVariable)paramObject;
        if ((this.b.equals(((TypeVariable)paramObject).getName())) && (this.a.equals(((TypeVariable)paramObject).getGenericDeclaration()))) {
          bool3 = bool2;
        } else {
          bool3 = false;
        }
        return bool3;
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.a.hashCode() ^ this.b.hashCode();
    }
    
    public String toString()
    {
      return this.b;
    }
  }
  
  private static final class i
    implements InvocationHandler
  {
    private static final ImmutableMap<String, Method> a;
    private final h.h<?> b;
    
    static
    {
      ImmutableMap.b localb = ImmutableMap.builder();
      Method[] arrayOfMethod = h.h.class.getMethods();
      int i = arrayOfMethod.length;
      int j = 0;
      for (;;)
      {
        Method localMethod;
        if (j < i)
        {
          localMethod = arrayOfMethod[j];
          if (!localMethod.getDeclaringClass().equals(h.h.class)) {}
        }
        try
        {
          localMethod.setAccessible(true);
          localb.c(localMethod.getName(), localMethod);
          j++;
          continue;
          a = localb.a();
          return;
        }
        catch (AccessControlException localAccessControlException)
        {
          for (;;) {}
        }
      }
    }
    
    i(h.h<?> paramh)
    {
      this.b = paramh;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      paramObject = paramMethod.getName();
      paramMethod = (Method)a.get(paramObject);
      if (paramMethod != null) {
        try
        {
          paramObject = paramMethod.invoke(this.b, paramArrayOfObject);
          return paramObject;
        }
        catch (InvocationTargetException paramObject)
        {
          throw ((InvocationTargetException)paramObject).getCause();
        }
      }
      throw new UnsupportedOperationException((String)paramObject);
    }
  }
  
  static final class j
    implements WildcardType, Serializable
  {
    private final ImmutableList<Type> c;
    private final ImmutableList<Type> d;
    
    j(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
    {
      h.b(paramArrayOfType1, "lower bound for wildcard");
      h.b(paramArrayOfType2, "upper bound for wildcard");
      h.e locale = h.e.x;
      this.c = locale.f(paramArrayOfType1);
      this.d = locale.f(paramArrayOfType2);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof WildcardType;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        paramObject = (WildcardType)paramObject;
        bool3 = bool2;
        if (this.c.equals(Arrays.asList(((WildcardType)paramObject).getLowerBounds())))
        {
          bool3 = bool2;
          if (this.d.equals(Arrays.asList(((WildcardType)paramObject).getUpperBounds()))) {
            bool3 = true;
          }
        }
      }
      return bool3;
    }
    
    public Type[] getLowerBounds()
    {
      return h.c(this.c);
    }
    
    public Type[] getUpperBounds()
    {
      return h.c(this.d);
    }
    
    public int hashCode()
    {
      return this.c.hashCode() ^ this.d.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("?");
      Object localObject = this.c.iterator();
      Type localType;
      while (((Iterator)localObject).hasNext())
      {
        localType = (Type)((Iterator)localObject).next();
        localStringBuilder.append(" super ");
        localStringBuilder.append(h.e.x.d(localType));
      }
      localObject = h.f(this.d).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localType = (Type)((Iterator)localObject).next();
        localStringBuilder.append(" extends ");
        localStringBuilder.append(h.e.x.d(localType));
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\reflect\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */