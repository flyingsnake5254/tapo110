package kotlin.jvm.internal;

import kotlin.reflect.c;
import kotlin.reflect.d;
import kotlin.reflect.e;
import kotlin.reflect.g;
import kotlin.reflect.i;
import kotlin.reflect.k;
import kotlin.reflect.l;

public class m
{
  private static final n a;
  private static final c[] b = new c[0];
  
  static
  {
    Object localObject = null;
    try
    {
      n localn = (n)Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
      localObject = localn;
    }
    catch (ClassCastException|ClassNotFoundException|InstantiationException|IllegalAccessException localClassCastException) {}
    if (localObject == null) {
      localObject = new n();
    }
    a = (n)localObject;
  }
  
  public static e a(FunctionReference paramFunctionReference)
  {
    return a.a(paramFunctionReference);
  }
  
  public static c b(Class paramClass)
  {
    return a.b(paramClass);
  }
  
  public static d c(Class paramClass)
  {
    return a.c(paramClass, "");
  }
  
  public static g d(MutablePropertyReference0 paramMutablePropertyReference0)
  {
    return a.d(paramMutablePropertyReference0);
  }
  
  public static kotlin.reflect.h e(MutablePropertyReference1 paramMutablePropertyReference1)
  {
    return a.e(paramMutablePropertyReference1);
  }
  
  public static i f(MutablePropertyReference2 paramMutablePropertyReference2)
  {
    return a.f(paramMutablePropertyReference2);
  }
  
  public static k g(PropertyReference0 paramPropertyReference0)
  {
    return a.g(paramPropertyReference0);
  }
  
  public static l h(PropertyReference1 paramPropertyReference1)
  {
    return a.h(paramPropertyReference1);
  }
  
  public static kotlin.reflect.m i(PropertyReference2 paramPropertyReference2)
  {
    return a.i(paramPropertyReference2);
  }
  
  public static String j(h paramh)
  {
    return a.j(paramh);
  }
  
  public static String k(Lambda paramLambda)
  {
    return a.k(paramLambda);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */