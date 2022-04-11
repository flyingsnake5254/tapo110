package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;

public final class VodUserId
{
  @c("user_id")
  private final int id;
  
  public VodUserId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public final int component1()
  {
    return this.id;
  }
  
  public final VodUserId copy(int paramInt)
  {
    return new VodUserId(paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VodUserId))
      {
        paramObject = (VodUserId)paramObject;
        if (this.id == ((VodUserId)paramObject).id) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public int hashCode()
  {
    return this.id;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VodUserId(id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\VodUserId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */