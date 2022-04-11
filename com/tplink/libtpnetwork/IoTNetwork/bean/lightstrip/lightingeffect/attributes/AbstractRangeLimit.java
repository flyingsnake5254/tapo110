package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

public abstract class AbstractRangeLimit<T extends Number>
{
  public static AbstractRangeLimit newInstance(String paramString)
  {
    if (paramString.equalsIgnoreCase(Integer.class.getSimpleName())) {
      return new IntegerRangeLimit();
    }
    if (paramString.equals(Long.class.getSimpleName())) {
      return new LongRangeLimit();
    }
    if (paramString.equals(Double.class.getSimpleName())) {
      return new DoubleRangeLimit();
    }
    return null;
  }
  
  public AbstractRangeLimit<T> clone()
  {
    AbstractRangeLimit localAbstractRangeLimit = newInstance(getNumberType());
    localAbstractRangeLimit.setMax(getMax().clone());
    localAbstractRangeLimit.setMin(getMin().clone());
    return localAbstractRangeLimit;
  }
  
  public abstract AbstractRange<T> getMax();
  
  public abstract AbstractRange<T> getMin();
  
  public String getNumberType()
  {
    return ((Class)((java.lang.reflect.ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
  }
  
  public boolean isSatisfied(AbstractRange<T> paramAbstractRange)
  {
    boolean bool1 = false;
    if (paramAbstractRange == null) {
      return false;
    }
    AbstractRange localAbstractRange1 = getMax();
    AbstractRange localAbstractRange2 = getMin();
    boolean bool2;
    if (localAbstractRange1 != null)
    {
      bool2 = bool1;
      if (!localAbstractRange1.isInRange(paramAbstractRange.getTo())) {}
    }
    else if (localAbstractRange2 != null)
    {
      bool2 = bool1;
      if (!localAbstractRange2.isInRange(paramAbstractRange.getFrom())) {}
    }
    else
    {
      bool2 = true;
    }
    return bool2;
  }
  
  public boolean isValid()
  {
    AbstractRange localAbstractRange1 = getMax();
    AbstractRange localAbstractRange2 = getMin();
    boolean bool;
    if (((localAbstractRange1 != null) && (!localAbstractRange1.isValid())) || ((localAbstractRange2 != null) && (!localAbstractRange2.isValid()))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public abstract void setMax(AbstractRange<T> paramAbstractRange);
  
  public abstract void setMin(AbstractRange<T> paramAbstractRange);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\AbstractRangeLimit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */