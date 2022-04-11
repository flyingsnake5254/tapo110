package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

final class v
{
  static final Type[] a = new Type[0];
  
  static ResponseBody a(ResponseBody paramResponseBody)
    throws IOException
  {
    Buffer localBuffer = new Buffer();
    paramResponseBody.source().readAll(localBuffer);
    return ResponseBody.create(paramResponseBody.contentType(), paramResponseBody.contentLength(), localBuffer);
  }
  
  static <T> T b(@Nullable T paramT, String paramString)
  {
    Objects.requireNonNull(paramT, paramString);
    return paramT;
  }
  
  static void c(Type paramType)
  {
    if (((paramType instanceof Class)) && (((Class)paramType).isPrimitive())) {
      throw new IllegalArgumentException();
    }
  }
  
  @Nullable
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
  
  static boolean e(Type paramType1, Type paramType2)
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
      ParameterizedType localParameterizedType = (ParameterizedType)paramType2;
      paramType2 = paramType1.getOwnerType();
      Type localType = localParameterizedType.getOwnerType();
      if (((paramType2 != localType) && ((paramType2 == null) || (!paramType2.equals(localType)))) || (!paramType1.getRawType().equals(localParameterizedType.getRawType())) || (!Arrays.equals(paramType1.getActualTypeArguments(), localParameterizedType.getActualTypeArguments()))) {
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
      return e(paramType1.getGenericComponentType(), paramType2.getGenericComponentType());
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
  
  static Type f(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
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
          return f(paramClass1.getGenericInterfaces()[i], paramType[i], paramClass2);
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
          return f(paramClass1.getGenericSuperclass(), paramType, paramClass2);
        }
        paramClass1 = paramType;
      }
    }
    return paramClass2;
  }
  
  static Type g(int paramInt, ParameterizedType paramParameterizedType)
  {
    Type localType = paramParameterizedType.getActualTypeArguments()[paramInt];
    paramParameterizedType = localType;
    if ((localType instanceof WildcardType)) {
      paramParameterizedType = ((WildcardType)localType).getLowerBounds()[0];
    }
    return paramParameterizedType;
  }
  
  static Type h(int paramInt, ParameterizedType paramParameterizedType)
  {
    Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
    if ((paramInt >= 0) && (paramInt < arrayOfType.length))
    {
      localObject = arrayOfType[paramInt];
      paramParameterizedType = (ParameterizedType)localObject;
      if ((localObject instanceof WildcardType)) {
        paramParameterizedType = ((WildcardType)localObject).getUpperBounds()[0];
      }
      return paramParameterizedType;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Index ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" not in range [0,");
    ((StringBuilder)localObject).append(arrayOfType.length);
    ((StringBuilder)localObject).append(") for ");
    ((StringBuilder)localObject).append(paramParameterizedType);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  static Class<?> i(Type paramType)
  {
    b(paramType, "type == null");
    if ((paramType instanceof Class)) {
      return (Class)paramType;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = ((ParameterizedType)paramType).getRawType();
      if ((paramType instanceof Class)) {
        return (Class)paramType;
      }
      throw new IllegalArgumentException();
    }
    if ((paramType instanceof GenericArrayType)) {
      return Array.newInstance(i(((GenericArrayType)paramType).getGenericComponentType()), 0).getClass();
    }
    if ((paramType instanceof TypeVariable)) {
      return Object.class;
    }
    if ((paramType instanceof WildcardType)) {
      return i(((WildcardType)paramType).getUpperBounds()[0]);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
    localStringBuilder.append(paramType);
    localStringBuilder.append("> is of type ");
    localStringBuilder.append(paramType.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  static Type j(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2.isAssignableFrom(paramClass1)) {
      return r(paramType, paramClass1, f(paramType, paramClass1, paramClass2));
    }
    throw new IllegalArgumentException();
  }
  
  static boolean k(@Nullable Type paramType)
  {
    if ((paramType instanceof Class)) {
      return false;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = ((ParameterizedType)paramType).getActualTypeArguments();
      int i = paramType.length;
      for (int j = 0; j < i; j++) {
        if (k(paramType[j])) {
          return true;
        }
      }
      return false;
    }
    if ((paramType instanceof GenericArrayType)) {
      return k(((GenericArrayType)paramType).getGenericComponentType());
    }
    if ((paramType instanceof TypeVariable)) {
      return true;
    }
    if ((paramType instanceof WildcardType)) {
      return true;
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
  
  private static int l(Object[] paramArrayOfObject, Object paramObject)
  {
    for (int i = 0; i < paramArrayOfObject.length; i++) {
      if (paramObject.equals(paramArrayOfObject[i])) {
        return i;
      }
    }
    throw new NoSuchElementException();
  }
  
  static boolean m(Annotation[] paramArrayOfAnnotation, Class<? extends Annotation> paramClass)
  {
    int i = paramArrayOfAnnotation.length;
    for (int j = 0; j < i; j++) {
      if (paramClass.isInstance(paramArrayOfAnnotation[j])) {
        return true;
      }
    }
    return false;
  }
  
  static RuntimeException n(Method paramMethod, String paramString, Object... paramVarArgs)
  {
    return o(paramMethod, null, paramString, paramVarArgs);
  }
  
  static RuntimeException o(Method paramMethod, @Nullable Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    paramString = String.format(paramString, paramVarArgs);
    paramVarArgs = new StringBuilder();
    paramVarArgs.append(paramString);
    paramVarArgs.append("\n    for method ");
    paramVarArgs.append(paramMethod.getDeclaringClass().getSimpleName());
    paramVarArgs.append(".");
    paramVarArgs.append(paramMethod.getName());
    return new IllegalArgumentException(paramVarArgs.toString(), paramThrowable);
  }
  
  static RuntimeException p(Method paramMethod, int paramInt, String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (parameter #");
    localStringBuilder.append(paramInt + 1);
    localStringBuilder.append(")");
    return n(paramMethod, localStringBuilder.toString(), paramVarArgs);
  }
  
  static RuntimeException q(Method paramMethod, Throwable paramThrowable, int paramInt, String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (parameter #");
    localStringBuilder.append(paramInt + 1);
    localStringBuilder.append(")");
    return o(paramMethod, paramThrowable, localStringBuilder.toString(), paramVarArgs);
  }
  
  static Type r(Type paramType1, Class<?> paramClass, Type paramType2)
  {
    while ((paramType2 instanceof TypeVariable))
    {
      localObject1 = (TypeVariable)paramType2;
      paramType2 = s(paramType1, paramClass, (TypeVariable)localObject1);
      if (paramType2 == localObject1) {
        return paramType2;
      }
    }
    if ((paramType2 instanceof Class))
    {
      localObject1 = (Class)paramType2;
      if (((Class)localObject1).isArray())
      {
        paramType2 = ((Class)localObject1).getComponentType();
        paramType1 = r(paramType1, paramClass, paramType2);
        if (paramType2 == paramType1) {
          paramType1 = (Type)localObject1;
        } else {
          paramType1 = new a(paramType1);
        }
        return paramType1;
      }
    }
    if ((paramType2 instanceof GenericArrayType))
    {
      paramType2 = (GenericArrayType)paramType2;
      localObject1 = paramType2.getGenericComponentType();
      paramType1 = r(paramType1, paramClass, (Type)localObject1);
      if (localObject1 == paramType1) {
        paramType1 = paramType2;
      } else {
        paramType1 = new a(paramType1);
      }
      return paramType1;
    }
    boolean bool = paramType2 instanceof ParameterizedType;
    int i = 0;
    Object localObject2;
    Object localObject3;
    if (bool)
    {
      localObject2 = (ParameterizedType)paramType2;
      paramType2 = ((ParameterizedType)localObject2).getOwnerType();
      localObject3 = r(paramType1, paramClass, paramType2);
      int j;
      if (localObject3 != paramType2) {
        j = 1;
      } else {
        j = 0;
      }
      paramType2 = ((ParameterizedType)localObject2).getActualTypeArguments();
      int k = paramType2.length;
      while (i < k)
      {
        Type localType = r(paramType1, paramClass, paramType2[i]);
        int m = j;
        localObject1 = paramType2;
        if (localType != paramType2[i])
        {
          m = j;
          localObject1 = paramType2;
          if (j == 0)
          {
            localObject1 = (Type[])paramType2.clone();
            m = 1;
          }
          localObject1[i] = localType;
        }
        i++;
        j = m;
        paramType2 = (Type)localObject1;
      }
      paramType1 = (Type)localObject2;
      if (j != 0) {
        paramType1 = new b((Type)localObject3, ((ParameterizedType)localObject2).getRawType(), paramType2);
      }
      return paramType1;
    }
    Object localObject1 = paramType2;
    if ((paramType2 instanceof WildcardType))
    {
      paramType2 = (WildcardType)paramType2;
      localObject3 = paramType2.getLowerBounds();
      localObject2 = paramType2.getUpperBounds();
      if (localObject3.length == 1)
      {
        paramType1 = r(paramType1, paramClass, localObject3[0]);
        localObject1 = paramType2;
        if (paramType1 != localObject3[0]) {
          return new c(new Type[] { Object.class }, new Type[] { paramType1 });
        }
      }
      else
      {
        localObject1 = paramType2;
        if (localObject2.length == 1) {
          localObject1 = localObject2[0];
        }
      }
    }
    try
    {
      paramType1 = r(paramType1, paramClass, (Type)localObject1);
      localObject1 = paramType2;
      if (paramType1 != localObject2[0])
      {
        paramClass = a;
        return new c(new Type[] { paramType1 }, paramClass);
      }
      return (Type)localObject1;
    }
    finally {}
  }
  
  private static Type s(Type paramType, Class<?> paramClass, TypeVariable<?> paramTypeVariable)
  {
    Class localClass = d(paramTypeVariable);
    if (localClass == null) {
      return paramTypeVariable;
    }
    paramType = f(paramType, paramClass, localClass);
    if ((paramType instanceof ParameterizedType))
    {
      int i = l(localClass.getTypeParameters(), paramTypeVariable);
      return ((ParameterizedType)paramType).getActualTypeArguments()[i];
    }
    return paramTypeVariable;
  }
  
  static void t(Throwable paramThrowable)
  {
    if (!(paramThrowable instanceof VirtualMachineError))
    {
      if (!(paramThrowable instanceof ThreadDeath))
      {
        if (!(paramThrowable instanceof LinkageError)) {
          return;
        }
        throw ((LinkageError)paramThrowable);
      }
      throw ((ThreadDeath)paramThrowable);
    }
    throw ((VirtualMachineError)paramThrowable);
  }
  
  static String u(Type paramType)
  {
    if ((paramType instanceof Class)) {
      paramType = ((Class)paramType).getName();
    } else {
      paramType = paramType.toString();
    }
    return paramType;
  }
  
  static <T> void v(Class<T> paramClass)
  {
    if (paramClass.isInterface())
    {
      if (paramClass.getInterfaces().length <= 0) {
        return;
      }
      throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
    }
    throw new IllegalArgumentException("API declarations must be interfaces.");
  }
  
  private static final class a
    implements GenericArrayType
  {
    private final Type c;
    
    a(Type paramType)
    {
      this.c = paramType;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool;
      if (((paramObject instanceof GenericArrayType)) && (v.e(this, (GenericArrayType)paramObject))) {
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
      localStringBuilder.append(v.u(this.c));
      localStringBuilder.append("[]");
      return localStringBuilder.toString();
    }
  }
  
  static final class b
    implements ParameterizedType
  {
    @Nullable
    private final Type c;
    private final Type d;
    private final Type[] f;
    
    b(@Nullable Type paramType1, Type paramType2, Type... paramVarArgs)
    {
      boolean bool = paramType2 instanceof Class;
      int i = 0;
      if (bool)
      {
        j = 1;
        if (paramType1 == null) {
          k = 1;
        } else {
          k = 0;
        }
        if (((Class)paramType2).getEnclosingClass() != null) {
          j = 0;
        }
        if (k != j) {
          throw new IllegalArgumentException();
        }
      }
      int j = paramVarArgs.length;
      for (int k = i; k < j; k++)
      {
        Type localType = paramVarArgs[k];
        v.b(localType, "typeArgument == null");
        v.c(localType);
      }
      this.c = paramType1;
      this.d = paramType2;
      this.f = ((Type[])paramVarArgs.clone());
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool;
      if (((paramObject instanceof ParameterizedType)) && (v.e(this, (ParameterizedType)paramObject))) {
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
    
    @Nullable
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
      int i = Arrays.hashCode(this.f);
      int j = this.d.hashCode();
      Type localType = this.c;
      int k;
      if (localType != null) {
        k = localType.hashCode();
      } else {
        k = 0;
      }
      return i ^ j ^ k;
    }
    
    public String toString()
    {
      Object localObject = this.f;
      if (localObject.length == 0) {
        return v.u(this.d);
      }
      int i = localObject.length;
      int j = 1;
      localObject = new StringBuilder((i + 1) * 30);
      ((StringBuilder)localObject).append(v.u(this.d));
      ((StringBuilder)localObject).append("<");
      ((StringBuilder)localObject).append(v.u(this.f[0]));
      while (j < this.f.length)
      {
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(v.u(this.f[j]));
        j++;
      }
      ((StringBuilder)localObject).append(">");
      return ((StringBuilder)localObject).toString();
    }
  }
  
  private static final class c
    implements WildcardType
  {
    private final Type c;
    @Nullable
    private final Type d;
    
    c(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
    {
      if (paramArrayOfType2.length <= 1)
      {
        if (paramArrayOfType1.length == 1)
        {
          if (paramArrayOfType2.length == 1)
          {
            Objects.requireNonNull(paramArrayOfType2[0]);
            v.c(paramArrayOfType2[0]);
            if (paramArrayOfType1[0] == Object.class)
            {
              this.d = paramArrayOfType2[0];
              this.c = Object.class;
            }
            else
            {
              throw new IllegalArgumentException();
            }
          }
          else
          {
            Objects.requireNonNull(paramArrayOfType1[0]);
            v.c(paramArrayOfType1[0]);
            this.d = null;
            this.c = paramArrayOfType1[0];
          }
          return;
        }
        throw new IllegalArgumentException();
      }
      throw new IllegalArgumentException();
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool;
      if (((paramObject instanceof WildcardType)) && (v.e(this, (WildcardType)paramObject))) {
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
        arrayOfType = v.a;
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
        localStringBuilder.append(v.u(this.d));
        return localStringBuilder.toString();
      }
      if (this.c == Object.class) {
        return "?";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("? extends ");
      localStringBuilder.append(v.u(this.c));
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */