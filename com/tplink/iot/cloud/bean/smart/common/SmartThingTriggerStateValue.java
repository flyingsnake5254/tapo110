package com.tplink.iot.cloud.bean.smart.common;

import java.util.List;
import java.util.Objects;

public class SmartThingTriggerStateValue
{
  private String data;
  private List<String> list;
  private String max;
  private String min;
  
  public SmartThingTriggerStateValue() {}
  
  public SmartThingTriggerStateValue(String paramString)
  {
    this.data = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (SmartThingTriggerStateValue)paramObject;
      if ((!Objects.equals(this.data, ((SmartThingTriggerStateValue)paramObject).data)) || (!Objects.equals(this.min, ((SmartThingTriggerStateValue)paramObject).min)) || (!Objects.equals(this.max, ((SmartThingTriggerStateValue)paramObject).max)) || (!Objects.equals(this.list, ((SmartThingTriggerStateValue)paramObject).list))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getData()
  {
    return this.data;
  }
  
  public List<String> getList()
  {
    return this.list;
  }
  
  public String getMax()
  {
    return this.max;
  }
  
  public String getMin()
  {
    return this.min;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.data, this.min, this.max, this.list });
  }
  
  public void setData(String paramString)
  {
    this.data = paramString;
  }
  
  public void setList(List<String> paramList)
  {
    this.list = paramList;
  }
  
  public void setMax(String paramString)
  {
    this.max = paramString;
  }
  
  public void setMin(String paramString)
  {
    this.min = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\smart\common\SmartThingTriggerStateValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */