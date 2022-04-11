package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

public abstract class AbstractNumberAttributeValue<T extends Number>
{
  public static AbstractNumberAttributeValue newInstance(String paramString)
  {
    if (paramString.equalsIgnoreCase(Integer.class.getSimpleName())) {
      return new IntegerAttributeValue();
    }
    if (paramString.equals(Long.class.getSimpleName())) {
      return new LongAttributeValue();
    }
    if (paramString.equals(Double.class.getSimpleName())) {
      return new DoubleAttributeValue();
    }
    return null;
  }
  
  public AbstractNumberAttributeValue<T> clone()
  {
    AbstractNumberAttributeValue localAbstractNumberAttributeValue = newInstance(getNumberType());
    localAbstractNumberAttributeValue.setAbsolute(getAbsolute());
    localAbstractNumberAttributeValue.setLimits(getLimits().clone());
    localAbstractNumberAttributeValue.setRange(getRange().clone());
    return localAbstractNumberAttributeValue;
  }
  
  public abstract T getAbsolute();
  
  public abstract AbstractNumberAttributeLimits<T> getLimits();
  
  public String getNumberType()
  {
    new IntegerAttributeValue();
    return ((Class)((java.lang.reflect.ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
  }
  
  public abstract AbstractRange<T> getRange();
  
  public boolean isValid()
  {
    Number localNumber = getAbsolute();
    AbstractRange localAbstractRange = getRange();
    AbstractNumberAttributeLimits localAbstractNumberAttributeLimits = getLimits();
    boolean bool1 = false;
    if ((localNumber == null) && (localAbstractRange == null)) {
      return false;
    }
    if ((localAbstractRange != null) && (!localAbstractRange.isValid())) {
      return false;
    }
    if (localAbstractNumberAttributeLimits != null)
    {
      boolean bool2 = bool1;
      if (localAbstractNumberAttributeLimits.isValid())
      {
        bool2 = bool1;
        if (localAbstractNumberAttributeLimits.isSatisfied(this)) {
          bool2 = true;
        }
      }
      return bool2;
    }
    return true;
  }
  
  public abstract void setAbsolute(T paramT);
  
  public abstract void setLimits(AbstractNumberAttributeLimits<T> paramAbstractNumberAttributeLimits);
  
  public abstract void setRange(AbstractRange<T> paramAbstractRange);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\AbstractNumberAttributeValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */