package kotlin.jvm.internal;

import kotlin.reflect.b;
import kotlin.reflect.m.a;

public abstract class PropertyReference2
  extends PropertyReference
  implements kotlin.reflect.m
{
  public PropertyReference2() {}
  
  public PropertyReference2(Class paramClass, String paramString1, String paramString2, int paramInt)
  {
    super(CallableReference.NO_RECEIVER, paramClass, paramString1, paramString2, paramInt);
  }
  
  protected b computeReflected()
  {
    return m.i(this);
  }
  
  public Object getDelegate(Object paramObject1, Object paramObject2)
  {
    return ((kotlin.reflect.m)getReflected()).getDelegate(paramObject1, paramObject2);
  }
  
  public m.a getGetter()
  {
    return ((kotlin.reflect.m)getReflected()).getGetter();
  }
  
  public Object invoke(Object paramObject1, Object paramObject2)
  {
    return get(paramObject1, paramObject2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\PropertyReference2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */