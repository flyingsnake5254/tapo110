package com.tplink.libtpnetwork.IoTNetwork.bean.sub.common;

import java.util.List;
import kotlin.jvm.internal.j;

public final class SubMultipleResponse
{
  private final List<IoTSubResponse<?>> responses;
  
  public SubMultipleResponse(List<? extends IoTSubResponse<?>> paramList)
  {
    this.responses = paramList;
  }
  
  public final List<IoTSubResponse<?>> component1()
  {
    return this.responses;
  }
  
  public final SubMultipleResponse copy(List<? extends IoTSubResponse<?>> paramList)
  {
    j.e(paramList, "responses");
    return new SubMultipleResponse(paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof SubMultipleResponse))
      {
        paramObject = (SubMultipleResponse)paramObject;
        if (j.a(this.responses, ((SubMultipleResponse)paramObject).responses)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final List<IoTSubResponse<?>> getResponses()
  {
    return this.responses;
  }
  
  public int hashCode()
  {
    List localList = this.responses;
    int i;
    if (localList != null) {
      i = localList.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SubMultipleResponse(responses=");
    localStringBuilder.append(this.responses);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\sub\common\SubMultipleResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */