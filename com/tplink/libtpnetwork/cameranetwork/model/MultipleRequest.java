package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.List;
import kotlin.jvm.internal.j;

public final class MultipleRequest
{
  private final List<Request<Wrappers>> requests;
  
  public MultipleRequest(List<Request<Wrappers>> paramList)
  {
    this.requests = paramList;
  }
  
  public final List<Request<Wrappers>> component1()
  {
    return this.requests;
  }
  
  public final MultipleRequest copy(List<Request<Wrappers>> paramList)
  {
    j.e(paramList, "requests");
    return new MultipleRequest(paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MultipleRequest))
      {
        paramObject = (MultipleRequest)paramObject;
        if (j.a(this.requests, ((MultipleRequest)paramObject).requests)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final List<Request<Wrappers>> getRequests()
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
    localStringBuilder.append("MultipleRequest(requests=");
    localStringBuilder.append(this.requests);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\MultipleRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */