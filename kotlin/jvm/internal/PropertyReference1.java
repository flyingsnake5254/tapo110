package kotlin.jvm.internal;

import kotlin.reflect.b;
import kotlin.reflect.l;
import kotlin.reflect.l.a;

public abstract class PropertyReference1
  extends PropertyReference
  implements l
{
  public PropertyReference1() {}
  
  public PropertyReference1(Object paramObject)
  {
    super(paramObject);
  }
  
  public PropertyReference1(Object paramObject, Class paramClass, String paramString1, String paramString2, int paramInt)
  {
    super(paramObject, paramClass, paramString1, paramString2, paramInt);
  }
  
  protected b computeReflected()
  {
    return m.h(this);
  }
  
  public Object getDelegate(Object paramObject)
  {
    return ((l)getReflected()).getDelegate(paramObject);
  }
  
  public l.a getGetter()
  {
    return ((l)getReflected()).getGetter();
  }
  
  public Object invoke(Object paramObject)
  {
    return get(paramObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\PropertyReference1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */