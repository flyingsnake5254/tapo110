package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class CloudTerraceId
{
  private final String id;
  
  public CloudTerraceId(String paramString)
  {
    this.id = paramString;
  }
  
  public final String component1()
  {
    return this.id;
  }
  
  public final CloudTerraceId copy(String paramString)
  {
    j.e(paramString, "id");
    return new CloudTerraceId(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CloudTerraceId))
      {
        paramObject = (CloudTerraceId)paramObject;
        if (j.a(this.id, ((CloudTerraceId)paramObject).id)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getId()
  {
    return this.id;
  }
  
  public int hashCode()
  {
    String str = this.id;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CloudTerraceId(id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\CloudTerraceId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */