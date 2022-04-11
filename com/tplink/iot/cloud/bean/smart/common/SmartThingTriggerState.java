package com.tplink.iot.cloud.bean.smart.common;

import com.tplink.iot.cloud.enumerate.StateOperator;
import com.tplink.iot.cloud.enumerate.StateValueDataType;
import java.util.Objects;

public class SmartThingTriggerState
{
  private StateValueDataType dataType;
  private String key;
  private StateOperator op;
  private SmartThingTriggerStateValue value;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (SmartThingTriggerState)paramObject;
      if ((!Objects.equals(this.key, ((SmartThingTriggerState)paramObject).key)) || (!Objects.equals(this.value, ((SmartThingTriggerState)paramObject).value)) || (this.dataType != ((SmartThingTriggerState)paramObject).dataType) || (this.op != ((SmartThingTriggerState)paramObject).op)) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public StateValueDataType getDataType()
  {
    return this.dataType;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public StateOperator getOp()
  {
    return this.op;
  }
  
  public SmartThingTriggerStateValue getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.key, this.value, this.dataType, this.op });
  }
  
  public void setDataType(StateValueDataType paramStateValueDataType)
  {
    this.dataType = paramStateValueDataType;
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setOp(StateOperator paramStateOperator)
  {
    this.op = paramStateOperator;
  }
  
  public void setValue(SmartThingTriggerStateValue paramSmartThingTriggerStateValue)
  {
    this.value = paramSmartThingTriggerStateValue;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\smart\common\SmartThingTriggerState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */