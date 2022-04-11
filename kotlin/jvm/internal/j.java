package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

public class j
{
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    boolean bool;
    if (paramObject1 == null)
    {
      if (paramObject2 == null) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else {
      bool = paramObject1.equals(paramObject2);
    }
    return bool;
  }
  
  public static void b(Object paramObject, String paramString)
  {
    if (paramObject != null) {
      return;
    }
    paramObject = new StringBuilder();
    ((StringBuilder)paramObject).append(paramString);
    ((StringBuilder)paramObject).append(" must not be null");
    throw ((IllegalStateException)k(new IllegalStateException(((StringBuilder)paramObject).toString())));
  }
  
  public static void c(Object paramObject)
  {
    if (paramObject == null) {
      m();
    }
  }
  
  public static void d(Object paramObject, String paramString)
  {
    if (paramObject != null) {
      return;
    }
    paramObject = new StringBuilder();
    ((StringBuilder)paramObject).append(paramString);
    ((StringBuilder)paramObject).append(" must not be null");
    throw ((NullPointerException)k(new NullPointerException(((StringBuilder)paramObject).toString())));
  }
  
  public static void e(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      p(paramString);
    }
  }
  
  public static void f(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      o(paramString);
    }
  }
  
  public static int g(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      paramInt1 = -1;
    } else if (paramInt1 == paramInt2) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    return paramInt1;
  }
  
  private static String h(String paramString)
  {
    Object localObject = Thread.currentThread().getStackTrace()[4];
    String str = ((StackTraceElement)localObject).getClassName();
    localObject = ((StackTraceElement)localObject).getMethodName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Parameter specified as non-null is null: method ");
    localStringBuilder.append(str);
    localStringBuilder.append(".");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", parameter ");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void i() {}
  
  public static void j(int paramInt, String paramString) {}
  
  private static <T extends Throwable> T k(T paramT)
  {
    return l(paramT, j.class.getName());
  }
  
  static <T extends Throwable> T l(T paramT, String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = paramT.getStackTrace();
    int i = arrayOfStackTraceElement.length;
    int j = -1;
    for (int k = 0; k < i; k++) {
      if (paramString.equals(arrayOfStackTraceElement[k].getClassName())) {
        j = k;
      }
    }
    paramT.setStackTrace((StackTraceElement[])Arrays.copyOfRange(arrayOfStackTraceElement, j + 1, i));
    return paramT;
  }
  
  public static void m()
  {
    throw ((NullPointerException)k(new NullPointerException()));
  }
  
  public static void n()
  {
    throw ((KotlinNullPointerException)k(new KotlinNullPointerException()));
  }
  
  private static void o(String paramString)
  {
    throw ((IllegalArgumentException)k(new IllegalArgumentException(h(paramString))));
  }
  
  private static void p(String paramString)
  {
    throw ((NullPointerException)k(new NullPointerException(h(paramString))));
  }
  
  public static void q()
  {
    r("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
  }
  
  public static void r(String paramString)
  {
    throw new UnsupportedOperationException(paramString);
  }
  
  public static void s(String paramString)
  {
    throw ((UninitializedPropertyAccessException)k(new UninitializedPropertyAccessException(paramString)));
  }
  
  public static void t(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lateinit property ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" has not been initialized");
    s(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */