package kotlin.jvm.internal;

import kotlin.reflect.b;
import kotlin.reflect.h;
import kotlin.reflect.h.a;
import kotlin.reflect.l;
import kotlin.reflect.l.a;

public abstract class MutablePropertyReference1
  extends MutablePropertyReference
  implements h
{
  public MutablePropertyReference1() {}
  
  public MutablePropertyReference1(Object paramObject)
  {
    super(paramObject);
  }
  
  public MutablePropertyReference1(Object paramObject, Class paramClass, String paramString1, String paramString2, int paramInt)
  {
    super(paramObject, paramClass, paramString1, paramString2, paramInt);
  }
  
  protected b computeReflected()
  {
    return m.e(this);
  }
  
  public Object getDelegate(Object paramObject)
  {
    return ((h)getReflected()).getDelegate(paramObject);
  }
  
  public l.a getGetter()
  {
    return ((h)getReflected()).getGetter();
  }
  
  public h.a getSetter()
  {
    return ((h)getReflected()).getSetter();
  }
  
  public Object invoke(Object paramObject)
  {
    return get(paramObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\MutablePropertyReference1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */