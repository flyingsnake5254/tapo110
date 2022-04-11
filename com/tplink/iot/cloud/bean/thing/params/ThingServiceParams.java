package com.tplink.iot.cloud.bean.thing.params;

import com.google.gson.i;
import com.google.gson.k;
import java.util.Objects;

public class ThingServiceParams
{
  private i inputParams;
  private String serviceId;
  
  public ThingServiceParams() {}
  
  public ThingServiceParams(String paramString)
  {
    this.serviceId = paramString;
    this.inputParams = new k();
  }
  
  public ThingServiceParams(String paramString, i parami)
  {
    this.serviceId = paramString;
    this.inputParams = parami;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (ThingServiceParams)paramObject;
      if ((!Objects.equals(this.serviceId, ((ThingServiceParams)paramObject).serviceId)) || (!Objects.equals(this.inputParams, ((ThingServiceParams)paramObject).inputParams))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public i getInputParams()
  {
    return this.inputParams;
  }
  
  public String getServiceId()
  {
    return this.serviceId;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.serviceId, this.inputParams });
  }
  
  public void setInputParams(i parami)
  {
    this.inputParams = parami;
  }
  
  public void setServiceId(String paramString)
  {
    this.serviceId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\params\ThingServiceParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */