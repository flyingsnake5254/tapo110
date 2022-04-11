package kotlin.jvm.internal;

import kotlin.reflect.b;
import kotlin.reflect.d;

public class PropertyReference0Impl
  extends PropertyReference0
{
  public PropertyReference0Impl(Class paramClass, String paramString1, String paramString2, int paramInt)
  {
    super(CallableReference.NO_RECEIVER, paramClass, paramString1, paramString2, paramInt);
  }
  
  public PropertyReference0Impl(Object paramObject, Class paramClass, String paramString1, String paramString2, int paramInt)
  {
    super(paramObject, paramClass, paramString1, paramString2, paramInt);
  }
  
  public PropertyReference0Impl(d paramd, String paramString1, String paramString2)
  {
    super(CallableReference.NO_RECEIVER, ((c)paramd).a(), paramString1, paramString2, paramd instanceof kotlin.reflect.c ^ true);
  }
  
  public Object get()
  {
    return getGetter().call(new Object[0]);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\PropertyReference0Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */