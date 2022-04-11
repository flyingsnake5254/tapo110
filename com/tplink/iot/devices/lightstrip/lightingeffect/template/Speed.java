package com.tplink.iot.devices.lightstrip.lightingeffect.template;

import kotlin.jvm.internal.j;

public final class Speed
{
  private final Integer value;
  
  public Speed(Integer paramInteger)
  {
    this.value = paramInteger;
  }
  
  public final Integer component1()
  {
    return this.value;
  }
  
  public final Speed copy(Integer paramInteger)
  {
    return new Speed(paramInteger);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Speed))
      {
        paramObject = (Speed)paramObject;
        if (j.a(this.value, ((Speed)paramObject).value)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final Integer getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    Integer localInteger = this.value;
    int i;
    if (localInteger != null) {
      i = localInteger.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Speed(value=");
    localStringBuilder.append(this.value);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\lightingeffect\template\Speed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */