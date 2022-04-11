package kotlin.jvm.internal;

import kotlin.reflect.b;
import kotlin.reflect.k;
import kotlin.reflect.k.a;

public abstract class PropertyReference0
  extends PropertyReference
  implements k
{
  public PropertyReference0() {}
  
  public PropertyReference0(Object paramObject)
  {
    super(paramObject);
  }
  
  public PropertyReference0(Object paramObject, Class paramClass, String paramString1, String paramString2, int paramInt)
  {
    super(paramObject, paramClass, paramString1, paramString2, paramInt);
  }
  
  protected b computeReflected()
  {
    return m.g(this);
  }
  
  public Object getDelegate()
  {
    return ((k)getReflected()).getDelegate();
  }
  
  public k.a getGetter()
  {
    return ((k)getReflected()).getGetter();
  }
  
  public Object invoke()
  {
    return get();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\PropertyReference0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */