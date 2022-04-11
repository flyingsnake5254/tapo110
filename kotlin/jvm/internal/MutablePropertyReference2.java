package kotlin.jvm.internal;

import kotlin.reflect.b;
import kotlin.reflect.i;
import kotlin.reflect.i.a;
import kotlin.reflect.m.a;

public abstract class MutablePropertyReference2
  extends MutablePropertyReference
  implements i
{
  public MutablePropertyReference2() {}
  
  public MutablePropertyReference2(Class paramClass, String paramString1, String paramString2, int paramInt)
  {
    super(CallableReference.NO_RECEIVER, paramClass, paramString1, paramString2, paramInt);
  }
  
  protected b computeReflected()
  {
    return m.f(this);
  }
  
  public Object getDelegate(Object paramObject1, Object paramObject2)
  {
    return ((i)getReflected()).getDelegate(paramObject1, paramObject2);
  }
  
  public m.a getGetter()
  {
    return ((i)getReflected()).getGetter();
  }
  
  public i.a getSetter()
  {
    return ((i)getReflected()).getSetter();
  }
  
  public Object invoke(Object paramObject1, Object paramObject2)
  {
    return get(paramObject1, paramObject2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\MutablePropertyReference2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */