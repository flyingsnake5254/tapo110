package kotlin.jvm.internal;

import kotlin.reflect.c;
import kotlin.reflect.e;
import kotlin.reflect.g;
import kotlin.reflect.i;
import kotlin.reflect.k;
import kotlin.reflect.m;

public class n
{
  public e a(FunctionReference paramFunctionReference)
  {
    return paramFunctionReference;
  }
  
  public c b(Class paramClass)
  {
    return new d(paramClass);
  }
  
  public kotlin.reflect.d c(Class paramClass, String paramString)
  {
    return new l(paramClass, paramString);
  }
  
  public g d(MutablePropertyReference0 paramMutablePropertyReference0)
  {
    return paramMutablePropertyReference0;
  }
  
  public kotlin.reflect.h e(MutablePropertyReference1 paramMutablePropertyReference1)
  {
    return paramMutablePropertyReference1;
  }
  
  public i f(MutablePropertyReference2 paramMutablePropertyReference2)
  {
    return paramMutablePropertyReference2;
  }
  
  public k g(PropertyReference0 paramPropertyReference0)
  {
    return paramPropertyReference0;
  }
  
  public kotlin.reflect.l h(PropertyReference1 paramPropertyReference1)
  {
    return paramPropertyReference1;
  }
  
  public m i(PropertyReference2 paramPropertyReference2)
  {
    return paramPropertyReference2;
  }
  
  public String j(h paramh)
  {
    String str = paramh.getClass().getGenericInterfaces()[0].toString();
    paramh = str;
    if (str.startsWith("kotlin.jvm.functions.")) {
      paramh = str.substring(21);
    }
    return paramh;
  }
  
  public String k(Lambda paramLambda)
  {
    return j(paramLambda);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */