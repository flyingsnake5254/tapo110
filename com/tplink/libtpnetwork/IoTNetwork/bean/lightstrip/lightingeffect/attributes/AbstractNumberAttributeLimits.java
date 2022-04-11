package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

public abstract class AbstractNumberAttributeLimits<T extends Number>
{
  public static AbstractNumberAttributeLimits newInstance(String paramString)
  {
    if (paramString.equalsIgnoreCase(Integer.class.getSimpleName())) {
      return new IntegerAttributeLimits();
    }
    if (paramString.equals(Long.class.getSimpleName())) {
      return new LongAttributeLimits();
    }
    if (paramString.equals(Double.class.getSimpleName())) {
      return new DoubleAttributeLimits();
    }
    return null;
  }
  
  public AbstractNumberAttributeLimits<T> clone()
  {
    AbstractNumberAttributeLimits localAbstractNumberAttributeLimits = newInstance(getNumberType());
    localAbstractNumberAttributeLimits.setAbsolute(getAbsolute().clone());
    localAbstractNumberAttributeLimits.setRange(getRange().clone());
    return localAbstractNumberAttributeLimits;
  }
  
  public abstract AbstractRange<T> getAbsolute();
  
  public String getNumberType()
  {
    return ((Class)((java.lang.reflect.ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
  }
  
  public abstract AbstractRangeLimit<T> getRange();
  
  public boolean isSatisfied(AbstractNumberAttributeValue<T> paramAbstractNumberAttributeValue)
  {
    boolean bool1 = false;
    if (paramAbstractNumberAttributeValue == null) {
      return false;
    }
    Number localNumber = paramAbstractNumberAttributeValue.getAbsolute();
    AbstractRange localAbstractRange = paramAbstractNumberAttributeValue.getRange();
    paramAbstractNumberAttributeValue = getAbsolute();
    AbstractRangeLimit localAbstractRangeLimit = getRange();
    boolean bool2;
    if ((localNumber != null) && (paramAbstractNumberAttributeValue != null))
    {
      bool2 = bool1;
      if (!paramAbstractNumberAttributeValue.isInRange(localNumber)) {}
    }
    else if ((localAbstractRange != null) && (localAbstractRangeLimit != null))
    {
      bool2 = bool1;
      if (!localAbstractRangeLimit.isSatisfied(localAbstractRange)) {}
    }
    else
    {
      bool2 = true;
    }
    return bool2;
  }
  
  public boolean isValid()
  {
    AbstractRange localAbstractRange = getAbsolute();
    AbstractRangeLimit localAbstractRangeLimit = getRange();
    boolean bool;
    if (((localAbstractRange != null) && (!localAbstractRange.isValid())) || ((localAbstractRangeLimit != null) && (!localAbstractRangeLimit.isValid()))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public abstract void setAbsolute(AbstractRange<T> paramAbstractRange);
  
  public abstract void setRange(AbstractRangeLimit<T> paramAbstractRangeLimit);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\AbstractNumberAttributeLimits.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */