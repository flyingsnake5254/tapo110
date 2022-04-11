package com.tplink.libtpnetwork.IoTNetwork.bean.sub.common;

import java.util.List;
import kotlin.jvm.internal.j;

public final class SubMultipleRequest
{
  private final List<IoTSubRequest<?>> requests;
  
  public SubMultipleRequest(List<? extends IoTSubRequest<?>> paramList)
  {
    this.requests = paramList;
  }
  
  public final List<IoTSubRequest<?>> component1()
  {
    return this.requests;
  }
  
  public final SubMultipleRequest copy(List<? extends IoTSubRequest<?>> paramList)
  {
    j.e(paramList, "requests");
    return new SubMultipleRequest(paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof SubMultipleRequest))
      {
        paramObject = (SubMultipleRequest)paramObject;
        if (j.a(this.requests, ((SubMultipleRequest)paramObject).requests)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final List<IoTSubRequest<?>> getRequests()
  {
    return this.requests;
  }
  
  public int hashCode()
  {
    List localList = this.requests;
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
    localStringBuilder.append("SubMultipleRequest(requests=");
    localStringBuilder.append(this.requests);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\sub\common\SubMultipleRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */