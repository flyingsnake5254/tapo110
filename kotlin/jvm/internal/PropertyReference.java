package kotlin.jvm.internal;

public abstract class PropertyReference
  extends CallableReference
  implements kotlin.reflect.j
{
  public PropertyReference() {}
  
  public PropertyReference(Object paramObject)
  {
    super(paramObject);
  }
  
  public PropertyReference(Object paramObject, Class paramClass, String paramString1, String paramString2, int paramInt)
  {
    super(paramObject, paramClass, paramString1, paramString2, bool);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof PropertyReference))
    {
      paramObject = (PropertyReference)paramObject;
      if ((!getOwner().equals(((CallableReference)paramObject).getOwner())) || (!getName().equals(((CallableReference)paramObject).getName())) || (!getSignature().equals(((CallableReference)paramObject).getSignature())) || (!j.a(getBoundReceiver(), ((CallableReference)paramObject).getBoundReceiver()))) {
        bool = false;
      }
      return bool;
    }
    if ((paramObject instanceof kotlin.reflect.j)) {
      return paramObject.equals(compute());
    }
    return false;
  }
  
  protected kotlin.reflect.j getReflected()
  {
    return (kotlin.reflect.j)super.getReflected();
  }
  
  public int hashCode()
  {
    return (getOwner().hashCode() * 31 + getName().hashCode()) * 31 + getSignature().hashCode();
  }
  
  public boolean isConst()
  {
    return getReflected().isConst();
  }
  
  public boolean isLateinit()
  {
    return getReflected().isLateinit();
  }
  
  public String toString()
  {
    Object localObject = compute();
    if (localObject != this) {
      return localObject.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("property ");
    ((StringBuilder)localObject).append(getName());
    ((StringBuilder)localObject).append(" (Kotlin reflection is not available)");
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\PropertyReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */