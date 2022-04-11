package kotlinx.coroutines.channels;

import kotlin.jvm.internal.j;

public final class x<T>
{
  public static final b a = new b(null);
  private final Object b;
  
  public static Object b(Object paramObject)
  {
    return paramObject;
  }
  
  public static boolean c(Object paramObject1, Object paramObject2)
  {
    return ((paramObject2 instanceof x)) && (j.a(paramObject1, ((x)paramObject2).f()));
  }
  
  public static int d(Object paramObject)
  {
    int i;
    if (paramObject != null) {
      i = paramObject.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public static String e(Object paramObject)
  {
    if ((paramObject instanceof a))
    {
      paramObject = paramObject.toString();
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Value(");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(')');
      paramObject = localStringBuilder.toString();
    }
    return (String)paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    return c(this.b, paramObject);
  }
  
  public int hashCode()
  {
    return d(this.b);
  }
  
  public String toString()
  {
    return e(this.b);
  }
  
  public static final class a
  {
    public final Throwable a;
    
    public a(Throwable paramThrowable)
    {
      this.a = paramThrowable;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool;
      if (((paramObject instanceof a)) && (j.a(this.a, ((a)paramObject).a))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int hashCode()
    {
      Throwable localThrowable = this.a;
      int i;
      if (localThrowable != null) {
        i = localThrowable.hashCode();
      } else {
        i = 0;
      }
      return i;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Closed(");
      localStringBuilder.append(this.a);
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
  }
  
  public static final class b {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\channels\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */