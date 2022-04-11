package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.j;

public final class Result<T>
  implements Serializable
{
  public static final a Companion = new a(null);
  private final Object value;
  
  public static Object constructor-impl(Object paramObject)
  {
    return paramObject;
  }
  
  public static boolean equals-impl(Object paramObject1, Object paramObject2)
  {
    return ((paramObject2 instanceof Result)) && (j.a(paramObject1, ((Result)paramObject2).unbox-impl()));
  }
  
  public static final boolean equals-impl0(Object paramObject1, Object paramObject2)
  {
    return j.a(paramObject1, paramObject2);
  }
  
  public static final Throwable exceptionOrNull-impl(Object paramObject)
  {
    if ((paramObject instanceof Failure)) {
      paramObject = ((Failure)paramObject).exception;
    } else {
      paramObject = null;
    }
    return (Throwable)paramObject;
  }
  
  private static final T getOrNull-impl(Object paramObject)
  {
    Object localObject = paramObject;
    if (isFailure-impl(paramObject)) {
      localObject = null;
    }
    return (T)localObject;
  }
  
  public static int hashCode-impl(Object paramObject)
  {
    int i;
    if (paramObject != null) {
      i = paramObject.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public static final boolean isFailure-impl(Object paramObject)
  {
    return paramObject instanceof Failure;
  }
  
  public static final boolean isSuccess-impl(Object paramObject)
  {
    return paramObject instanceof Failure ^ true;
  }
  
  public static String toString-impl(Object paramObject)
  {
    if ((paramObject instanceof Failure))
    {
      paramObject = paramObject.toString();
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Success(");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(')');
      paramObject = localStringBuilder.toString();
    }
    return (String)paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    return equals-impl(this.value, paramObject);
  }
  
  public int hashCode()
  {
    return hashCode-impl(this.value);
  }
  
  public String toString()
  {
    return toString-impl(this.value);
  }
  
  public static final class Failure
    implements Serializable
  {
    public final Throwable exception;
    
    public Failure(Throwable paramThrowable)
    {
      this.exception = paramThrowable;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool;
      if (((paramObject instanceof Failure)) && (j.a(this.exception, ((Failure)paramObject).exception))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int hashCode()
    {
      return this.exception.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failure(");
      localStringBuilder.append(this.exception);
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */