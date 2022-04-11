package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;

public final class LineCrossingDetectionRegion
{
  public static final Companion Companion = new Companion(null);
  private final String direction;
  @c("pt1_x")
  private final String point1X;
  @c("pt1_y")
  private final String point1Y;
  @c("pt2_x")
  private final String point2X;
  @c("pt2_y")
  private final String point2Y;
  private final String sensitivity;
  
  public LineCrossingDetectionRegion(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.point1X = paramString1;
    this.point1Y = paramString2;
    this.point2X = paramString3;
    this.point2Y = paramString4;
    this.sensitivity = paramString5;
    this.direction = paramString6;
  }
  
  public final String component1()
  {
    return this.point1X;
  }
  
  public final String component2()
  {
    return this.point1Y;
  }
  
  public final String component3()
  {
    return this.point2X;
  }
  
  public final String component4()
  {
    return this.point2Y;
  }
  
  public final String component5()
  {
    return this.sensitivity;
  }
  
  public final String component6()
  {
    return this.direction;
  }
  
  public final LineCrossingDetectionRegion copy(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    j.e(paramString1, "point1X");
    j.e(paramString2, "point1Y");
    j.e(paramString3, "point2X");
    j.e(paramString4, "point2Y");
    j.e(paramString6, "direction");
    return new LineCrossingDetectionRegion(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LineCrossingDetectionRegion))
      {
        paramObject = (LineCrossingDetectionRegion)paramObject;
        if ((j.a(this.point1X, ((LineCrossingDetectionRegion)paramObject).point1X)) && (j.a(this.point1Y, ((LineCrossingDetectionRegion)paramObject).point1Y)) && (j.a(this.point2X, ((LineCrossingDetectionRegion)paramObject).point2X)) && (j.a(this.point2Y, ((LineCrossingDetectionRegion)paramObject).point2Y)) && (j.a(this.sensitivity, ((LineCrossingDetectionRegion)paramObject).sensitivity)) && (j.a(this.direction, ((LineCrossingDetectionRegion)paramObject).direction))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getDirection()
  {
    return this.direction;
  }
  
  public final String getPoint1X()
  {
    return this.point1X;
  }
  
  public final String getPoint1Y()
  {
    return this.point1Y;
  }
  
  public final String getPoint2X()
  {
    return this.point2X;
  }
  
  public final String getPoint2Y()
  {
    return this.point2Y;
  }
  
  public final String getSensitivity()
  {
    return this.sensitivity;
  }
  
  public int hashCode()
  {
    String str = this.point1X;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.point1Y;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.point2X;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.point2Y;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.sensitivity;
    int i1;
    if (str != null) {
      i1 = str.hashCode();
    } else {
      i1 = 0;
    }
    str = this.direction;
    if (str != null) {
      i = str.hashCode();
    }
    return ((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LineCrossingDetectionRegion(point1X=");
    localStringBuilder.append(this.point1X);
    localStringBuilder.append(", point1Y=");
    localStringBuilder.append(this.point1Y);
    localStringBuilder.append(", point2X=");
    localStringBuilder.append(this.point2X);
    localStringBuilder.append(", point2Y=");
    localStringBuilder.append(this.point2Y);
    localStringBuilder.append(", sensitivity=");
    localStringBuilder.append(this.sensitivity);
    localStringBuilder.append(", direction=");
    localStringBuilder.append(this.direction);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class Companion
    implements UnwrapFromResponse<List<? extends Map<String, ? extends LineCrossingDetectionRegion>>>
  {
    public List<Map<String, LineCrossingDetectionRegion>> fromResponse(Response<Wrappers> paramResponse)
    {
      j.e(paramResponse, "response");
      if (j.a(paramResponse.getMethod(), Method.GET_LINE_CROSSING_DETECTION_REGION.getValue())) {
        paramResponse = (List)Model.typeCast((Wrappers)paramResponse.getResult(), Module.LINE_CROSSING_DETECTION, Section.REGION_INFO);
      } else {
        paramResponse = null;
      }
      return paramResponse;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\LineCrossingDetectionRegion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */