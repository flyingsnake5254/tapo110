package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.List;
import kotlin.jvm.internal.j;

public final class MultipleResponse
{
  private final List<Response<Wrappers>> responses;
  
  public MultipleResponse(List<Response<Wrappers>> paramList)
  {
    this.responses = paramList;
  }
  
  public final List<Response<Wrappers>> component1()
  {
    return this.responses;
  }
  
  public final MultipleResponse copy(List<Response<Wrappers>> paramList)
  {
    j.e(paramList, "responses");
    return new MultipleResponse(paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MultipleResponse))
      {
        paramObject = (MultipleResponse)paramObject;
        if (j.a(this.responses, ((MultipleResponse)paramObject).responses)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final List<Response<Wrappers>> getResponses()
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
    localStringBuilder.append("MultipleResponse(responses=");
    localStringBuilder.append(this.responses);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\MultipleResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */