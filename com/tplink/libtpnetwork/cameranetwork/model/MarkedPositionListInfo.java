package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.j;

public final class MarkedPositionListInfo
{
  @c("id")
  private final Integer[] idList;
  @c("name")
  private final String[] nameList;
  @c("position_pan")
  private final double[] positionPanList;
  @c("position_tilt")
  private final double[] positionTiltList;
  @c("read_only")
  private final int[] readOnlyList;
  
  public MarkedPositionListInfo(Integer[] paramArrayOfInteger, String[] paramArrayOfString, int[] paramArrayOfInt, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    this.idList = paramArrayOfInteger;
    this.nameList = paramArrayOfString;
    this.readOnlyList = paramArrayOfInt;
    this.positionPanList = paramArrayOfDouble1;
    this.positionTiltList = paramArrayOfDouble2;
  }
  
  public final Integer[] component1()
  {
    return this.idList;
  }
  
  public final String[] component2()
  {
    return this.nameList;
  }
  
  public final int[] component3()
  {
    return this.readOnlyList;
  }
  
  public final double[] component4()
  {
    return this.positionPanList;
  }
  
  public final double[] component5()
  {
    return this.positionTiltList;
  }
  
  public final MarkedPositionListInfo copy(Integer[] paramArrayOfInteger, String[] paramArrayOfString, int[] paramArrayOfInt, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    j.e(paramArrayOfInteger, "idList");
    j.e(paramArrayOfString, "nameList");
    j.e(paramArrayOfInt, "readOnlyList");
    j.e(paramArrayOfDouble1, "positionPanList");
    j.e(paramArrayOfDouble2, "positionTiltList");
    return new MarkedPositionListInfo(paramArrayOfInteger, paramArrayOfString, paramArrayOfInt, paramArrayOfDouble1, paramArrayOfDouble2);
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
    if ((j.a(MarkedPositionListInfo.class, localClass) ^ true)) {
      return false;
    }
    Objects.requireNonNull(paramObject, "null cannot be cast to non-null type com.tplink.libtpnetwork.cameranetwork.model.MarkedPositionListInfo");
    paramObject = (MarkedPositionListInfo)paramObject;
    if (!Arrays.equals(this.idList, ((MarkedPositionListInfo)paramObject).idList)) {
      return false;
    }
    if (!Arrays.equals(this.nameList, ((MarkedPositionListInfo)paramObject).nameList)) {
      return false;
    }
    if (!Arrays.equals(this.readOnlyList, ((MarkedPositionListInfo)paramObject).readOnlyList)) {
      return false;
    }
    if (!Arrays.equals(this.positionPanList, ((MarkedPositionListInfo)paramObject).positionPanList)) {
      return false;
    }
    return Arrays.equals(this.positionTiltList, ((MarkedPositionListInfo)paramObject).positionTiltList);
  }
  
  public final Integer[] getIdList()
  {
    return this.idList;
  }
  
  public final String[] getNameList()
  {
    return this.nameList;
  }
  
  public final double[] getPositionPanList()
  {
    return this.positionPanList;
  }
  
  public final double[] getPositionTiltList()
  {
    return this.positionTiltList;
  }
  
  public final int[] getReadOnlyList()
  {
    return this.readOnlyList;
  }
  
  public int hashCode()
  {
    return (((Arrays.hashCode(this.idList) * 31 + Arrays.hashCode(this.nameList)) * 31 + Arrays.hashCode(this.readOnlyList)) * 31 + Arrays.hashCode(this.positionPanList)) * 31 + Arrays.hashCode(this.positionTiltList);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MarkedPositionListInfo(idList=");
    localStringBuilder.append(Arrays.toString(this.idList));
    localStringBuilder.append(", nameList=");
    localStringBuilder.append(Arrays.toString(this.nameList));
    localStringBuilder.append(", readOnlyList=");
    localStringBuilder.append(Arrays.toString(this.readOnlyList));
    localStringBuilder.append(", positionPanList=");
    localStringBuilder.append(Arrays.toString(this.positionPanList));
    localStringBuilder.append(", positionTiltList=");
    localStringBuilder.append(Arrays.toString(this.positionTiltList));
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\MarkedPositionListInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */