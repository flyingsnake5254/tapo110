package kotlin.jvm.internal;

import kotlin.reflect.b;
import kotlin.reflect.d;

public class MutablePropertyReference0Impl
  extends MutablePropertyReference0
{
  public MutablePropertyReference0Impl(Class paramClass, String paramString1, String paramString2, int paramInt)
  {
    super(CallableReference.NO_RECEIVER, paramClass, paramString1, paramString2, paramInt);
  }
  
  public MutablePropertyReference0Impl(Object paramObject, Class paramClass, String paramString1, String paramString2, int paramInt)
  {
    super(paramObject, paramClass, paramString1, paramString2, paramInt);
  }
  
  public MutablePropertyReference0Impl(d paramd, String paramString1, String paramString2)
  {
    super(CallableReference.NO_RECEIVER, ((c)paramd).a(), paramString1, paramString2, paramd instanceof kotlin.reflect.c ^ true);
  }
  
  public Object get()
  {
    return getGetter().call(new Object[0]);
  }
  
  public void set(Object paramObject)
  {
    getSetter().call(new Object[] { paramObject });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\MutablePropertyReference0Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */