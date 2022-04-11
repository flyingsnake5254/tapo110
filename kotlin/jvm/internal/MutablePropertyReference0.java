package kotlin.jvm.internal;

import kotlin.reflect.b;
import kotlin.reflect.g;
import kotlin.reflect.g.a;
import kotlin.reflect.k;
import kotlin.reflect.k.a;

public abstract class MutablePropertyReference0
  extends MutablePropertyReference
  implements g
{
  public MutablePropertyReference0() {}
  
  public MutablePropertyReference0(Object paramObject)
  {
    super(paramObject);
  }
  
  public MutablePropertyReference0(Object paramObject, Class paramClass, String paramString1, String paramString2, int paramInt)
  {
    super(paramObject, paramClass, paramString1, paramString2, paramInt);
  }
  
  protected b computeReflected()
  {
    return m.d(this);
  }
  
  public Object getDelegate()
  {
    return ((g)getReflected()).getDelegate();
  }
  
  public k.a getGetter()
  {
    return ((g)getReflected()).getGetter();
  }
  
  public g.a getSetter()
  {
    return ((g)getReflected()).getSetter();
  }
  
  public Object invoke()
  {
    return get();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\MutablePropertyReference0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */