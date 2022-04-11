package kotlin.jvm.internal;

import kotlin.reflect.b;
import kotlin.reflect.d;

public class MutablePropertyReference1Impl
  extends MutablePropertyReference1
{
  public MutablePropertyReference1Impl(Class paramClass, String paramString1, String paramString2, int paramInt)
  {
    super(CallableReference.NO_RECEIVER, paramClass, paramString1, paramString2, paramInt);
  }
  
  public MutablePropertyReference1Impl(Object paramObject, Class paramClass, String paramString1, String paramString2, int paramInt)
  {
    super(paramObject, paramClass, paramString1, paramString2, paramInt);
  }
  
  public MutablePropertyReference1Impl(d paramd, String paramString1, String paramString2)
  {
    super(CallableReference.NO_RECEIVER, ((c)paramd).a(), paramString1, paramString2, paramd instanceof kotlin.reflect.c ^ true);
  }
  
  public Object get(Object paramObject)
  {
    return getGetter().call(new Object[] { paramObject });
  }
  
  public void set(Object paramObject1, Object paramObject2)
  {
    getSetter().call(new Object[] { paramObject1, paramObject2 });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\MutablePropertyReference1Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */