package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

import java.math.BigDecimal;

public abstract class AbstractRange<T extends Number>
{
  public static AbstractRange newInstance(String paramString)
  {
    if (paramString.equalsIgnoreCase(Integer.class.getSimpleName())) {
      return new IntegerRange();
    }
    if (paramString.equals(Long.class.getSimpleName())) {
      return new LongRange();
    }
    if (paramString.equals(Double.class.getSimpleName())) {
      return new DoubleRange();
    }
    return null;
  }
  
  public AbstractRange<T> clone()
  {
    AbstractRange localAbstractRange = newInstance(getNumberType());
    localAbstractRange.setFrom(getFrom());
    localAbstractRange.setTo(getTo());
    return localAbstractRange;
  }
  
  public abstract T getFrom();
  
  public String getNumberType()
  {
    return ((Class)((java.lang.reflect.ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
  }
  
  public abstract T getTo();
  
  public boolean isInRange(T paramT)
  {
    boolean bool1 = false;
    if (paramT == null) {
      return false;
    }
    BigDecimal localBigDecimal1 = new BigDecimal(String.valueOf(paramT));
    paramT = new BigDecimal(String.valueOf(getFrom()));
    BigDecimal localBigDecimal2 = new BigDecimal(String.valueOf(getTo()));
    boolean bool2 = bool1;
    if (localBigDecimal1.compareTo(paramT) >= 0)
    {
      bool2 = bool1;
      if (localBigDecimal1.compareTo(localBigDecimal2) <= 0) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public boolean isValid()
  {
    boolean bool;
    if (new BigDecimal(String.valueOf(getFrom())).compareTo(new BigDecimal(String.valueOf(getTo()))) <= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public abstract void setFrom(T paramT);
  
  public abstract void setTo(T paramT);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\AbstractRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */