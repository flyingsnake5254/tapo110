package com.google.common.reflect;

import com.google.common.base.i;
import com.google.common.base.n;
import com.google.common.base.o;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.a;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.a;
import com.google.common.collect.a2;
import com.google.common.collect.j3;
import com.google.common.collect.m0;
import com.google.common.collect.n0;
import com.google.common.collect.q1;
import com.google.common.collect.u0;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class TypeToken<T>
  extends d<T>
  implements Serializable
{
  private static final long serialVersionUID = 3637540370352322684L;
  @MonotonicNonNullDecl
  private transient f covariantTypeResolver;
  @MonotonicNonNullDecl
  private transient f invariantTypeResolver;
  private final Type runtimeType;
  
  protected TypeToken()
  {
    Type localType = capture();
    this.runtimeType = localType;
    n.x(localType instanceof TypeVariable ^ true, "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", localType);
  }
  
  protected TypeToken(Class<?> paramClass)
  {
    Type localType = super.capture();
    if ((localType instanceof Class)) {
      this.runtimeType = localType;
    } else {
      this.runtimeType = f.d(paramClass).j(localType);
    }
  }
  
  private TypeToken(Type paramType)
  {
    this.runtimeType = ((Type)n.o(paramType));
  }
  
  private static e any(Type[] paramArrayOfType)
  {
    return new e(paramArrayOfType, true);
  }
  
  @NullableDecl
  private TypeToken<? super T> boundAsSuperclass(Type paramType)
  {
    TypeToken localTypeToken = of(paramType);
    paramType = localTypeToken;
    if (localTypeToken.getRawType().isInterface()) {
      paramType = null;
    }
    return paramType;
  }
  
  private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] paramArrayOfType)
  {
    ImmutableList.a locala = ImmutableList.builder();
    int i = paramArrayOfType.length;
    for (int j = 0; j < i; j++)
    {
      TypeToken localTypeToken = of(paramArrayOfType[j]);
      if (localTypeToken.getRawType().isInterface()) {
        locala.h(localTypeToken);
      }
    }
    return locala.j();
  }
  
  private static Type canonicalizeTypeArg(TypeVariable<?> paramTypeVariable, Type paramType)
  {
    if ((paramType instanceof WildcardType)) {
      paramTypeVariable = canonicalizeWildcardType(paramTypeVariable, (WildcardType)paramType);
    } else {
      paramTypeVariable = canonicalizeWildcardsInType(paramType);
    }
    return paramTypeVariable;
  }
  
  private static WildcardType canonicalizeWildcardType(TypeVariable<?> paramTypeVariable, WildcardType paramWildcardType)
  {
    Type[] arrayOfType1 = paramTypeVariable.getBounds();
    ArrayList localArrayList = new ArrayList();
    for (paramTypeVariable : paramWildcardType.getUpperBounds()) {
      if (!any(arrayOfType1).a(paramTypeVariable)) {
        localArrayList.add(canonicalizeWildcardsInType(paramTypeVariable));
      }
    }
    return new h.j(paramWildcardType.getLowerBounds(), (Type[])localArrayList.toArray(new Type[0]));
  }
  
  private static ParameterizedType canonicalizeWildcardsInParameterizedType(ParameterizedType paramParameterizedType)
  {
    Class localClass = (Class)paramParameterizedType.getRawType();
    TypeVariable[] arrayOfTypeVariable = localClass.getTypeParameters();
    Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
    for (int i = 0; i < arrayOfType.length; i++) {
      arrayOfType[i] = canonicalizeTypeArg(arrayOfTypeVariable[i], arrayOfType[i]);
    }
    return h.n(paramParameterizedType.getOwnerType(), localClass, arrayOfType);
  }
  
  private static Type canonicalizeWildcardsInType(Type paramType)
  {
    if ((paramType instanceof ParameterizedType)) {
      return canonicalizeWildcardsInParameterizedType((ParameterizedType)paramType);
    }
    Type localType = paramType;
    if ((paramType instanceof GenericArrayType)) {
      localType = h.k(canonicalizeWildcardsInType(((GenericArrayType)paramType).getGenericComponentType()));
    }
    return localType;
  }
  
  private static e every(Type[] paramArrayOfType)
  {
    return new e(paramArrayOfType, false);
  }
  
  private TypeToken<? extends T> getArraySubtype(Class<?> paramClass)
  {
    return of(newArrayClassOrGenericArrayType(getComponentType().getSubtype(paramClass.getComponentType()).runtimeType));
  }
  
  private TypeToken<? super T> getArraySupertype(Class<? super T> paramClass)
  {
    return of(newArrayClassOrGenericArrayType(((TypeToken)n.q(getComponentType(), "%s isn't a super type of %s", paramClass, this)).getSupertype(paramClass.getComponentType()).runtimeType));
  }
  
  private f getCovariantTypeResolver()
  {
    f localf1 = this.covariantTypeResolver;
    f localf2 = localf1;
    if (localf1 == null)
    {
      localf2 = f.d(this.runtimeType);
      this.covariantTypeResolver = localf2;
    }
    return localf2;
  }
  
  private f getInvariantTypeResolver()
  {
    f localf1 = this.invariantTypeResolver;
    f localf2 = localf1;
    if (localf1 == null)
    {
      localf2 = f.f(this.runtimeType);
      this.invariantTypeResolver = localf2;
    }
    return localf2;
  }
  
  @NullableDecl
  private Type getOwnerTypeIfPresent()
  {
    Type localType = this.runtimeType;
    if ((localType instanceof ParameterizedType)) {
      return ((ParameterizedType)localType).getOwnerType();
    }
    if ((localType instanceof Class)) {
      return ((Class)localType).getEnclosingClass();
    }
    return null;
  }
  
  private ImmutableSet<Class<? super T>> getRawTypes()
  {
    final ImmutableSet.a locala = ImmutableSet.builder();
    new d(locala).a(new Type[] { this.runtimeType });
    return locala.k();
  }
  
  private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> paramClass, Type[] paramArrayOfType)
  {
    if (paramArrayOfType.length > 0) {
      return of(paramArrayOfType[0]).getSubtype(paramClass);
    }
    paramArrayOfType = new StringBuilder();
    paramArrayOfType.append(paramClass);
    paramArrayOfType.append(" isn't a subclass of ");
    paramArrayOfType.append(this);
    throw new IllegalArgumentException(paramArrayOfType.toString());
  }
  
  private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> paramClass, Type[] paramArrayOfType)
  {
    int i = paramArrayOfType.length;
    for (int j = 0; j < i; j++)
    {
      TypeToken localTypeToken = of(paramArrayOfType[j]);
      if (localTypeToken.isSubtypeOf(paramClass)) {
        return localTypeToken.getSupertype(paramClass);
      }
    }
    paramArrayOfType = new StringBuilder();
    paramArrayOfType.append(paramClass);
    paramArrayOfType.append(" isn't a super type of ");
    paramArrayOfType.append(this);
    throw new IllegalArgumentException(paramArrayOfType.toString());
  }
  
  private boolean is(Type paramType, TypeVariable<?> paramTypeVariable)
  {
    boolean bool1 = this.runtimeType.equals(paramType);
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    if ((paramType instanceof WildcardType))
    {
      paramType = canonicalizeWildcardType(paramTypeVariable, (WildcardType)paramType);
      if ((!every(paramType.getUpperBounds()).b(this.runtimeType)) || (!every(paramType.getLowerBounds()).a(this.runtimeType))) {
        bool2 = false;
      }
      return bool2;
    }
    return canonicalizeWildcardsInType(this.runtimeType).equals(canonicalizeWildcardsInType(paramType));
  }
  
  private boolean isOwnedBySubtypeOf(Type paramType)
  {
    Iterator localIterator = getTypes().iterator();
    while (localIterator.hasNext())
    {
      Type localType = ((TypeToken)localIterator.next()).getOwnerTypeIfPresent();
      if ((localType != null) && (of(localType).isSubtypeOf(paramType))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isSubtypeOfArrayType(GenericArrayType paramGenericArrayType)
  {
    Object localObject = this.runtimeType;
    if ((localObject instanceof Class))
    {
      localObject = (Class)localObject;
      if (!((Class)localObject).isArray()) {
        return false;
      }
      return of(((Class)localObject).getComponentType()).isSubtypeOf(paramGenericArrayType.getGenericComponentType());
    }
    if ((localObject instanceof GenericArrayType)) {
      return of(((GenericArrayType)localObject).getGenericComponentType()).isSubtypeOf(paramGenericArrayType.getGenericComponentType());
    }
    return false;
  }
  
  private boolean isSubtypeOfParameterizedType(ParameterizedType paramParameterizedType)
  {
    Object localObject = of(paramParameterizedType).getRawType();
    boolean bool1 = someRawTypeIsSubclassOf((Class)localObject);
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    localObject = ((Class)localObject).getTypeParameters();
    Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
    for (int i = 0; i < localObject.length; i++) {
      if (!of(getCovariantTypeResolver().j(localObject[i])).is(arrayOfType[i], localObject[i])) {
        return false;
      }
    }
    if ((Modifier.isStatic(((Class)paramParameterizedType.getRawType()).getModifiers())) || (paramParameterizedType.getOwnerType() == null) || (isOwnedBySubtypeOf(paramParameterizedType.getOwnerType()))) {
      bool2 = true;
    }
    return bool2;
  }
  
  private boolean isSupertypeOfArray(GenericArrayType paramGenericArrayType)
  {
    Object localObject = this.runtimeType;
    if ((localObject instanceof Class))
    {
      localObject = (Class)localObject;
      if (!((Class)localObject).isArray()) {
        return ((Class)localObject).isAssignableFrom(Object[].class);
      }
      return of(paramGenericArrayType.getGenericComponentType()).isSubtypeOf(((Class)localObject).getComponentType());
    }
    if ((localObject instanceof GenericArrayType)) {
      return of(paramGenericArrayType.getGenericComponentType()).isSubtypeOf(((GenericArrayType)this.runtimeType).getGenericComponentType());
    }
    return false;
  }
  
  private boolean isWrapper()
  {
    return com.google.common.primitives.f.b().contains(this.runtimeType);
  }
  
  private static Type newArrayClassOrGenericArrayType(Type paramType)
  {
    return h.e.d.b(paramType);
  }
  
  public static <T> TypeToken<T> of(Class<T> paramClass)
  {
    return new h(paramClass);
  }
  
  public static TypeToken<?> of(Type paramType)
  {
    return new h(paramType);
  }
  
  private TypeToken<?> resolveSupertype(Type paramType)
  {
    paramType = of(getCovariantTypeResolver().j(paramType));
    paramType.covariantTypeResolver = this.covariantTypeResolver;
    paramType.invariantTypeResolver = this.invariantTypeResolver;
    return paramType;
  }
  
  private Type resolveTypeArgsForSubclass(Class<?> paramClass)
  {
    if (((this.runtimeType instanceof Class)) && ((paramClass.getTypeParameters().length == 0) || (getRawType().getTypeParameters().length != 0))) {
      return paramClass;
    }
    TypeToken localTypeToken = toGenericType(paramClass);
    paramClass = localTypeToken.getSupertype(getRawType()).runtimeType;
    return new f().n(paramClass, this.runtimeType).j(localTypeToken.runtimeType);
  }
  
  private boolean someRawTypeIsSubclassOf(Class<?> paramClass)
  {
    j3 localj3 = getRawTypes().iterator();
    while (localj3.hasNext()) {
      if (paramClass.isAssignableFrom((Class)localj3.next())) {
        return true;
      }
    }
    return false;
  }
  
  static <T> TypeToken<? extends T> toGenericType(Class<T> paramClass)
  {
    if (paramClass.isArray()) {
      return of(h.k(toGenericType(paramClass.getComponentType()).runtimeType));
    }
    TypeVariable[] arrayOfTypeVariable = paramClass.getTypeParameters();
    Type localType;
    if ((paramClass.isMemberClass()) && (!Modifier.isStatic(paramClass.getModifiers()))) {
      localType = toGenericType(paramClass.getEnclosingClass()).runtimeType;
    } else {
      localType = null;
    }
    if ((arrayOfTypeVariable.length <= 0) && ((localType == null) || (localType == paramClass.getEnclosingClass()))) {
      return of(paramClass);
    }
    return of(h.n(localType, paramClass, arrayOfTypeVariable));
  }
  
  public final b<T, T> constructor(Constructor<?> paramConstructor)
  {
    boolean bool;
    if (paramConstructor.getDeclaringClass() == getRawType()) {
      bool = true;
    } else {
      bool = false;
    }
    n.k(bool, "%s not declared by %s", paramConstructor, getRawType());
    return new b(paramConstructor);
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    if ((paramObject instanceof TypeToken))
    {
      paramObject = (TypeToken)paramObject;
      return this.runtimeType.equals(((TypeToken)paramObject).runtimeType);
    }
    return false;
  }
  
  @NullableDecl
  public final TypeToken<?> getComponentType()
  {
    Type localType = h.j(this.runtimeType);
    if (localType == null) {
      return null;
    }
    return of(localType);
  }
  
  final ImmutableList<TypeToken<? super T>> getGenericInterfaces()
  {
    Object localObject = this.runtimeType;
    if ((localObject instanceof TypeVariable)) {
      return boundsAsInterfaces(((TypeVariable)localObject).getBounds());
    }
    if ((localObject instanceof WildcardType)) {
      return boundsAsInterfaces(((WildcardType)localObject).getUpperBounds());
    }
    ImmutableList.a locala = ImmutableList.builder();
    localObject = getRawType().getGenericInterfaces();
    int i = localObject.length;
    for (int j = 0; j < i; j++) {
      locala.h(resolveSupertype(localObject[j]));
    }
    return locala.j();
  }
  
  @NullableDecl
  final TypeToken<? super T> getGenericSuperclass()
  {
    Type localType = this.runtimeType;
    if ((localType instanceof TypeVariable)) {
      return boundAsSuperclass(((TypeVariable)localType).getBounds()[0]);
    }
    if ((localType instanceof WildcardType)) {
      return boundAsSuperclass(((WildcardType)localType).getUpperBounds()[0]);
    }
    localType = getRawType().getGenericSuperclass();
    if (localType == null) {
      return null;
    }
    return resolveSupertype(localType);
  }
  
  public final Class<? super T> getRawType()
  {
    return (Class)getRawTypes().iterator().next();
  }
  
  public final TypeToken<? extends T> getSubtype(Class<?> paramClass)
  {
    n.j(this.runtimeType instanceof TypeVariable ^ true, "Cannot get subtype of type variable <%s>", this);
    Type localType = this.runtimeType;
    if ((localType instanceof WildcardType)) {
      return getSubtypeFromLowerBounds(paramClass, ((WildcardType)localType).getLowerBounds());
    }
    if (isArray()) {
      return getArraySubtype(paramClass);
    }
    n.k(getRawType().isAssignableFrom(paramClass), "%s isn't a subclass of %s", paramClass, this);
    paramClass = of(resolveTypeArgsForSubclass(paramClass));
    n.k(paramClass.isSubtypeOf(this), "%s does not appear to be a subtype of %s", paramClass, this);
    return paramClass;
  }
  
  public final TypeToken<? super T> getSupertype(Class<? super T> paramClass)
  {
    n.k(someRawTypeIsSubclassOf(paramClass), "%s is not a super class of %s", paramClass, this);
    Type localType = this.runtimeType;
    if ((localType instanceof TypeVariable)) {
      return getSupertypeFromUpperBounds(paramClass, ((TypeVariable)localType).getBounds());
    }
    if ((localType instanceof WildcardType)) {
      return getSupertypeFromUpperBounds(paramClass, ((WildcardType)localType).getUpperBounds());
    }
    if (paramClass.isArray()) {
      return getArraySupertype(paramClass);
    }
    return resolveSupertype(toGenericType(paramClass).runtimeType);
  }
  
  public final Type getType()
  {
    return this.runtimeType;
  }
  
  public final TypeToken<T>.TypeSet getTypes()
  {
    return new TypeSet();
  }
  
  public int hashCode()
  {
    return this.runtimeType.hashCode();
  }
  
  public final boolean isArray()
  {
    boolean bool;
    if (getComponentType() != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isPrimitive()
  {
    Type localType = this.runtimeType;
    boolean bool;
    if (((localType instanceof Class)) && (((Class)localType).isPrimitive())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isSubtypeOf(TypeToken<?> paramTypeToken)
  {
    return isSubtypeOf(paramTypeToken.getType());
  }
  
  public final boolean isSubtypeOf(Type paramType)
  {
    n.o(paramType);
    if ((paramType instanceof WildcardType)) {
      return any(((WildcardType)paramType).getLowerBounds()).b(this.runtimeType);
    }
    Type localType = this.runtimeType;
    if ((localType instanceof WildcardType)) {
      return any(((WildcardType)localType).getUpperBounds()).a(paramType);
    }
    boolean bool1 = localType instanceof TypeVariable;
    boolean bool2 = false;
    if (bool1)
    {
      if ((localType.equals(paramType)) || (any(((TypeVariable)this.runtimeType).getBounds()).a(paramType))) {
        bool2 = true;
      }
      return bool2;
    }
    if ((localType instanceof GenericArrayType)) {
      return of(paramType).isSupertypeOfArray((GenericArrayType)this.runtimeType);
    }
    if ((paramType instanceof Class)) {
      return someRawTypeIsSubclassOf((Class)paramType);
    }
    if ((paramType instanceof ParameterizedType)) {
      return isSubtypeOfParameterizedType((ParameterizedType)paramType);
    }
    if ((paramType instanceof GenericArrayType)) {
      return isSubtypeOfArrayType((GenericArrayType)paramType);
    }
    return false;
  }
  
  public final boolean isSupertypeOf(TypeToken<?> paramTypeToken)
  {
    return paramTypeToken.isSubtypeOf(getType());
  }
  
  public final boolean isSupertypeOf(Type paramType)
  {
    return of(paramType).isSubtypeOf(getType());
  }
  
  public final b<T, Object> method(Method paramMethod)
  {
    n.k(someRawTypeIsSubclassOf(paramMethod.getDeclaringClass()), "%s not declared by %s", paramMethod, this);
    return new a(paramMethod);
  }
  
  @CanIgnoreReturnValue
  final TypeToken<T> rejectTypeVariables()
  {
    new c().a(new Type[] { this.runtimeType });
    return this;
  }
  
  public final TypeToken<?> resolveType(Type paramType)
  {
    n.o(paramType);
    return of(getInvariantTypeResolver().j(paramType));
  }
  
  public String toString()
  {
    return h.t(this.runtimeType);
  }
  
  public final TypeToken<T> unwrap()
  {
    if (isWrapper()) {
      return of(com.google.common.primitives.f.c((Class)this.runtimeType));
    }
    return this;
  }
  
  public final <X> TypeToken<T> where(e<X> parame, TypeToken<X> paramTypeToken)
  {
    new f();
    throw null;
  }
  
  public final <X> TypeToken<T> where(e<X> parame, Class<X> paramClass)
  {
    return where(parame, of(paramClass));
  }
  
  public final TypeToken<T> wrap()
  {
    if (isPrimitive()) {
      return of(com.google.common.primitives.f.d((Class)this.runtimeType));
    }
    return this;
  }
  
  protected Object writeReplace()
  {
    return of(new f().j(this.runtimeType));
  }
  
  public class TypeSet
    extends u0<TypeToken<? super T>>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    @MonotonicNonNullDecl
    private transient ImmutableSet<TypeToken<? super T>> types;
    
    TypeSet() {}
    
    public TypeToken<T>.TypeSet classes()
    {
      return new TypeToken.f(TypeToken.this, null);
    }
    
    protected Set<TypeToken<? super T>> delegate()
    {
      ImmutableSet localImmutableSet1 = this.types;
      ImmutableSet localImmutableSet2 = localImmutableSet1;
      if (localImmutableSet1 == null)
      {
        localImmutableSet2 = m0.d(TypeToken.i.a.d(TypeToken.this)).c(TypeToken.j.c).f();
        this.types = localImmutableSet2;
      }
      return localImmutableSet2;
    }
    
    public TypeToken<T>.TypeSet interfaces()
    {
      return new TypeToken.g(TypeToken.this, this);
    }
    
    public Set<Class<? super T>> rawTypes()
    {
      return ImmutableSet.copyOf(TypeToken.i.b.c(TypeToken.this.getRawTypes()));
    }
  }
  
  class a
    extends b.b<T>
  {
    a(Method paramMethod)
    {
      super();
    }
    
    public TypeToken<T> a()
    {
      return TypeToken.this;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a());
      localStringBuilder.append(".");
      localStringBuilder.append(super.toString());
      return localStringBuilder.toString();
    }
  }
  
  class b
    extends b.a<T>
  {
    b(Constructor paramConstructor)
    {
      super();
    }
    
    public TypeToken<T> a()
    {
      return TypeToken.this;
    }
    
    Type[] b()
    {
      return TypeToken.this.getInvariantTypeResolver().l(super.b());
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a());
      localStringBuilder.append("(");
      localStringBuilder.append(i.g(", ").e(b()));
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
  
  class c
    extends g
  {
    c() {}
    
    void c(GenericArrayType paramGenericArrayType)
    {
      a(new Type[] { paramGenericArrayType.getGenericComponentType() });
    }
    
    void d(ParameterizedType paramParameterizedType)
    {
      a(paramParameterizedType.getActualTypeArguments());
      a(new Type[] { paramParameterizedType.getOwnerType() });
    }
    
    void e(TypeVariable<?> paramTypeVariable)
    {
      paramTypeVariable = new StringBuilder();
      paramTypeVariable.append(TypeToken.this.runtimeType);
      paramTypeVariable.append("contains a type variable and is not safe for the operation");
      throw new IllegalArgumentException(paramTypeVariable.toString());
    }
    
    void f(WildcardType paramWildcardType)
    {
      a(paramWildcardType.getLowerBounds());
      a(paramWildcardType.getUpperBounds());
    }
  }
  
  class d
    extends g
  {
    d(ImmutableSet.a parama) {}
    
    void b(Class<?> paramClass)
    {
      locala.h(paramClass);
    }
    
    void c(GenericArrayType paramGenericArrayType)
    {
      locala.h(h.i(TypeToken.of(paramGenericArrayType.getGenericComponentType()).getRawType()));
    }
    
    void d(ParameterizedType paramParameterizedType)
    {
      locala.h((Class)paramParameterizedType.getRawType());
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
  
  private static class e
  {
    private final Type[] a;
    private final boolean b;
    
    e(Type[] paramArrayOfType, boolean paramBoolean)
    {
      this.a = paramArrayOfType;
      this.b = paramBoolean;
    }
    
    boolean a(Type paramType)
    {
      Type[] arrayOfType = this.a;
      int i = arrayOfType.length;
      for (int j = 0; j < i; j++)
      {
        boolean bool1 = TypeToken.of(arrayOfType[j]).isSubtypeOf(paramType);
        boolean bool2 = this.b;
        if (bool1 == bool2) {
          return bool2;
        }
      }
      return this.b ^ true;
    }
    
    boolean b(Type paramType)
    {
      paramType = TypeToken.of(paramType);
      Type[] arrayOfType = this.a;
      int i = arrayOfType.length;
      for (int j = 0; j < i; j++)
      {
        boolean bool1 = paramType.isSubtypeOf(arrayOfType[j]);
        boolean bool2 = this.b;
        if (bool1 == bool2) {
          return bool2;
        }
      }
      return this.b ^ true;
    }
  }
  
  private final class f
    extends TypeToken<T>.TypeSet
  {
    @MonotonicNonNullDecl
    private transient ImmutableSet<TypeToken<? super T>> c;
    
    private f()
    {
      super();
    }
    
    public TypeToken<T>.TypeSet classes()
    {
      return this;
    }
    
    protected Set<TypeToken<? super T>> delegate()
    {
      ImmutableSet localImmutableSet1 = this.c;
      ImmutableSet localImmutableSet2 = localImmutableSet1;
      if (localImmutableSet1 == null)
      {
        localImmutableSet2 = m0.d(TypeToken.i.a.a().d(TypeToken.this)).c(TypeToken.j.c).f();
        this.c = localImmutableSet2;
      }
      return localImmutableSet2;
    }
    
    public TypeToken<T>.TypeSet interfaces()
    {
      throw new UnsupportedOperationException("classes().interfaces() not supported.");
    }
    
    public Set<Class<? super T>> rawTypes()
    {
      return ImmutableSet.copyOf(TypeToken.i.b.a().c(TypeToken.this.getRawTypes()));
    }
  }
  
  private final class g
    extends TypeToken<T>.TypeSet
  {
    private final transient TypeToken<T>.TypeSet c;
    @MonotonicNonNullDecl
    private transient ImmutableSet<TypeToken<? super T>> d;
    
    g()
    {
      super();
      TypeToken.TypeSet localTypeSet;
      this.c = localTypeSet;
    }
    
    public TypeToken<T>.TypeSet classes()
    {
      throw new UnsupportedOperationException("interfaces().classes() not supported.");
    }
    
    protected Set<TypeToken<? super T>> delegate()
    {
      ImmutableSet localImmutableSet1 = this.d;
      ImmutableSet localImmutableSet2 = localImmutableSet1;
      if (localImmutableSet1 == null)
      {
        localImmutableSet2 = m0.d(this.c).c(TypeToken.j.d).f();
        this.d = localImmutableSet2;
      }
      return localImmutableSet2;
    }
    
    public TypeToken<T>.TypeSet interfaces()
    {
      return this;
    }
    
    public Set<Class<? super T>> rawTypes()
    {
      return m0.d(TypeToken.i.b.c(TypeToken.this.getRawTypes())).c(new a()).f();
    }
    
    class a
      implements o<Class<?>>
    {
      a() {}
      
      public boolean a(Class<?> paramClass)
      {
        return paramClass.isInterface();
      }
    }
  }
  
  private static final class h<T>
    extends TypeToken<T>
  {
    h(Type paramType)
    {
      super(null);
    }
  }
  
  private static abstract class i<K>
  {
    static final i<TypeToken<?>> a = new a();
    static final i<Class<?>> b = new b();
    
    @CanIgnoreReturnValue
    private int b(K paramK, Map<? super K, Integer> paramMap)
    {
      Object localObject = (Integer)paramMap.get(paramK);
      if (localObject != null) {
        return ((Integer)localObject).intValue();
      }
      int i = f(paramK).isInterface();
      localObject = e(paramK).iterator();
      while (((Iterator)localObject).hasNext()) {
        j = Math.max(i, b(((Iterator)localObject).next(), paramMap));
      }
      localObject = g(paramK);
      int k = j;
      if (localObject != null) {
        k = Math.max(j, b(localObject, paramMap));
      }
      int j = k + 1;
      paramMap.put(paramK, Integer.valueOf(j));
      return j;
    }
    
    private static <K, V> ImmutableList<K> h(final Map<K, V> paramMap, Comparator<? super V> paramComparator)
    {
      return new d(paramComparator, paramMap).b(paramMap.keySet());
    }
    
    final i<K> a()
    {
      return new c(this);
    }
    
    ImmutableList<K> c(Iterable<? extends K> paramIterable)
    {
      HashMap localHashMap = q1.o();
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        b(paramIterable.next(), localHashMap);
      }
      return h(localHashMap, a2.g().j());
    }
    
    final ImmutableList<K> d(K paramK)
    {
      return c(ImmutableList.of(paramK));
    }
    
    abstract Iterable<? extends K> e(K paramK);
    
    abstract Class<?> f(K paramK);
    
    @NullableDecl
    abstract K g(K paramK);
    
    static final class a
      extends TypeToken.i<TypeToken<?>>
    {
      a()
      {
        super();
      }
      
      Iterable<? extends TypeToken<?>> i(TypeToken<?> paramTypeToken)
      {
        return paramTypeToken.getGenericInterfaces();
      }
      
      Class<?> j(TypeToken<?> paramTypeToken)
      {
        return paramTypeToken.getRawType();
      }
      
      @NullableDecl
      TypeToken<?> k(TypeToken<?> paramTypeToken)
      {
        return paramTypeToken.getGenericSuperclass();
      }
    }
    
    static final class b
      extends TypeToken.i<Class<?>>
    {
      b()
      {
        super();
      }
      
      Iterable<? extends Class<?>> i(Class<?> paramClass)
      {
        return Arrays.asList(paramClass.getInterfaces());
      }
      
      Class<?> j(Class<?> paramClass)
      {
        return paramClass;
      }
      
      @NullableDecl
      Class<?> k(Class<?> paramClass)
      {
        return paramClass.getSuperclass();
      }
    }
    
    class c
      extends TypeToken.i.e<K>
    {
      c(TypeToken.i parami)
      {
        super();
      }
      
      ImmutableList<K> c(Iterable<? extends K> paramIterable)
      {
        ImmutableList.a locala = ImmutableList.builder();
        paramIterable = paramIterable.iterator();
        while (paramIterable.hasNext())
        {
          Object localObject = paramIterable.next();
          if (!f(localObject).isInterface()) {
            locala.h(localObject);
          }
        }
        return super.c(locala.j());
      }
      
      Iterable<? extends K> e(K paramK)
      {
        return ImmutableSet.of();
      }
    }
    
    static final class d
      extends a2<K>
    {
      d(Comparator paramComparator, Map paramMap) {}
      
      public int compare(K paramK1, K paramK2)
      {
        return this.c.compare(paramMap.get(paramK1), paramMap.get(paramK2));
      }
    }
    
    private static class e<K>
      extends TypeToken.i<K>
    {
      private final TypeToken.i<K> c;
      
      e(TypeToken.i<K> parami)
      {
        super();
        this.c = parami;
      }
      
      Class<?> f(K paramK)
      {
        return this.c.f(paramK);
      }
      
      K g(K paramK)
      {
        return (K)this.c.g(paramK);
      }
    }
  }
  
  private static abstract enum j
    implements o<TypeToken<?>>
  {
    static
    {
      a locala = new a("IGNORE_TYPE_VARIABLE_OR_WILDCARD", 0);
      c = locala;
      b localb = new b("INTERFACE_ONLY", 1);
      d = localb;
      f = new j[] { locala, localb };
    }
    
    static enum a
    {
      a()
      {
        super(paramInt, null);
      }
      
      public boolean a(TypeToken<?> paramTypeToken)
      {
        boolean bool;
        if ((!(paramTypeToken.runtimeType instanceof TypeVariable)) && (!(paramTypeToken.runtimeType instanceof WildcardType))) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
    }
    
    static enum b
    {
      b()
      {
        super(paramInt, null);
      }
      
      public boolean a(TypeToken<?> paramTypeToken)
      {
        return paramTypeToken.getRawType().isInterface();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\reflect\TypeToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */