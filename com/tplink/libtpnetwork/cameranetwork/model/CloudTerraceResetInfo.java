package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.j;

public final class CloudTerraceResetInfo
{
  @c("id")
  private final String[] idList;
  
  public CloudTerraceResetInfo(String[] paramArrayOfString)
  {
    this.idList = paramArrayOfString;
  }
  
  public final String[] component1()
  {
    return this.idList;
  }
  
  public final CloudTerraceResetInfo copy(String[] paramArrayOfString)
  {
    j.e(paramArrayOfString, "idList");
    return new CloudTerraceResetInfo(paramArrayOfString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    Class localClass;
    if (paramObject != null) {
      localClass = paramObject.getClass();
    } else {
      localClass = null;
    }
    if ((j.a(CloudTerraceResetInfo.class, localClass) ^ true)) {
      return false;
    }
    Objects.requireNonNull(paramObject, "null cannot be cast to non-null type com.tplink.libtpnetwork.cameranetwork.model.CloudTerraceResetInfo");
    paramObject = (CloudTerraceResetInfo)paramObject;
    return Arrays.equals(this.idList, ((CloudTerraceResetInfo)paramObject).idList);
  }
  
  public final String[] getIdList()
  {
    return this.idList;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.idList);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CloudTerraceResetInfo(idList=");
    localStringBuilder.append(Arrays.toString(this.idList));
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\CloudTerraceResetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */