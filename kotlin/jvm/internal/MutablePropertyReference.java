package kotlin.jvm.internal;

import kotlin.reflect.j;

public abstract class MutablePropertyReference
  extends PropertyReference
  implements j
{
  public MutablePropertyReference() {}
  
  public MutablePropertyReference(Object paramObject)
  {
    super(paramObject);
  }
  
  public MutablePropertyReference(Object paramObject, Class paramClass, String paramString1, String paramString2, int paramInt)
  {
    super(paramObject, paramClass, paramString1, paramString2, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\MutablePropertyReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */