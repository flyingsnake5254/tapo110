package kotlin.jvm.internal;

import kotlin.reflect.b;
import kotlin.reflect.d;

public class PropertyReference2Impl
  extends PropertyReference2
{
  public PropertyReference2Impl(Class paramClass, String paramString1, String paramString2, int paramInt)
  {
    super(paramClass, paramString1, paramString2, paramInt);
  }
  
  public PropertyReference2Impl(d paramd, String paramString1, String paramString2)
  {
    super(((c)paramd).a(), paramString1, paramString2, paramd instanceof kotlin.reflect.c ^ true);
  }
  
  public Object get(Object paramObject1, Object paramObject2)
  {
    return getGetter().call(new Object[] { paramObject1, paramObject2 });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\PropertyReference2Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */