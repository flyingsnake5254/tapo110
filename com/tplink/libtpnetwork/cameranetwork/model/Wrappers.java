package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.List;
import kotlin.jvm.internal.j;

public final class Wrappers
{
  private final List<Wrapper<?>> wrapperList;
  
  public Wrappers(List<? extends Wrapper<?>> paramList)
  {
    this.wrapperList = paramList;
  }
  
  public final List<Wrapper<?>> component1()
  {
    return this.wrapperList;
  }
  
  public final Wrappers copy(List<? extends Wrapper<?>> paramList)
  {
    j.e(paramList, "wrapperList");
    return new Wrappers(paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Wrappers))
      {
        paramObject = (Wrappers)paramObject;
        if (j.a(this.wrapperList, ((Wrappers)paramObject).wrapperList)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final List<Wrapper<?>> getWrapperList()
  {
    return this.wrapperList;
  }
  
  public int hashCode()
  {
    List localList = this.wrapperList;
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
    localStringBuilder.append("Wrappers(wrapperList=");
    localStringBuilder.append(this.wrapperList);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\Wrappers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */