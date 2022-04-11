package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

public final class ServiceList
{
  @c("service_list")
  private final List<TapoCareList> functions;
  
  public ServiceList(List<TapoCareList> paramList)
  {
    this.functions = paramList;
  }
  
  public final List<TapoCareList> component1()
  {
    return this.functions;
  }
  
  public final ServiceList copy(List<TapoCareList> paramList)
  {
    j.e(paramList, "functions");
    return new ServiceList(paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ServiceList))
      {
        paramObject = (ServiceList)paramObject;
        if (j.a(this.functions, ((ServiceList)paramObject).functions)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final List<TapoCareList> getFunctions()
  {
    return this.functions;
  }
  
  public int hashCode()
  {
    List localList = this.functions;
    int i;
    if (localList != null) {
      i = localList.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public final boolean isComponentNeedSubscription(ComponentType paramComponentType)
  {
    j.e(paramComponentType, "type");
    if (this.functions.isEmpty()) {
      return false;
    }
    Iterator localIterator = this.functions.iterator();
    while (localIterator.hasNext()) {
      if (paramComponentType == ComponentType.fromComponentName(((TapoCareList)localIterator.next()).getName())) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ServiceList(functions=");
    localStringBuilder.append(this.functions);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\ServiceList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */