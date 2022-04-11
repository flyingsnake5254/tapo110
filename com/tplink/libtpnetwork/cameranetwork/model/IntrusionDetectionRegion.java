package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;

public final class IntrusionDetectionRegion
{
  public static final Companion Companion = new Companion(null);
  @c("pt3_x")
  private final String leftBottomX;
  @c("pt3_y")
  private final String leftBottomY;
  @c("pt1_x")
  private final String leftTopX;
  @c("pt1_y")
  private final String leftTopY;
  private final String percentage;
  @c("pt4_x")
  private final String rightBottomX;
  @c("pt4_y")
  private final String rightBottomY;
  @c("pt2_x")
  private final String rightTopX;
  @c("pt2_y")
  private final String rightTopY;
  private final String sensitivity;
  private final String threshold;
  
  public IntrusionDetectionRegion(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    this.leftTopX = paramString1;
    this.leftTopY = paramString2;
    this.rightTopX = paramString3;
    this.rightTopY = paramString4;
    this.leftBottomX = paramString5;
    this.leftBottomY = paramString6;
    this.rightBottomX = paramString7;
    this.rightBottomY = paramString8;
    this.sensitivity = paramString9;
    this.threshold = paramString10;
    this.percentage = paramString11;
  }
  
  public final String component1()
  {
    return this.leftTopX;
  }
  
  public final String component10()
  {
    return this.threshold;
  }
  
  public final String component11()
  {
    return this.percentage;
  }
  
  public final String component2()
  {
    return this.leftTopY;
  }
  
  public final String component3()
  {
    return this.rightTopX;
  }
  
  public final String component4()
  {
    return this.rightTopY;
  }
  
  public final String component5()
  {
    return this.leftBottomX;
  }
  
  public final String component6()
  {
    return this.leftBottomY;
  }
  
  public final String component7()
  {
    return this.rightBottomX;
  }
  
  public final String component8()
  {
    return this.rightBottomY;
  }
  
  public final String component9()
  {
    return this.sensitivity;
  }
  
  public final IntrusionDetectionRegion copy(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    j.e(paramString1, "leftTopX");
    j.e(paramString2, "leftTopY");
    j.e(paramString3, "rightTopX");
    j.e(paramString4, "rightTopY");
    j.e(paramString5, "leftBottomX");
    j.e(paramString6, "leftBottomY");
    j.e(paramString7, "rightBottomX");
    j.e(paramString8, "rightBottomY");
    return new IntrusionDetectionRegion(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof IntrusionDetectionRegion))
      {
        paramObject = (IntrusionDetectionRegion)paramObject;
        if ((j.a(this.leftTopX, ((IntrusionDetectionRegion)paramObject).leftTopX)) && (j.a(this.leftTopY, ((IntrusionDetectionRegion)paramObject).leftTopY)) && (j.a(this.rightTopX, ((IntrusionDetectionRegion)paramObject).rightTopX)) && (j.a(this.rightTopY, ((IntrusionDetectionRegion)paramObject).rightTopY)) && (j.a(this.leftBottomX, ((IntrusionDetectionRegion)paramObject).leftBottomX)) && (j.a(this.leftBottomY, ((IntrusionDetectionRegion)paramObject).leftBottomY)) && (j.a(this.rightBottomX, ((IntrusionDetectionRegion)paramObject).rightBottomX)) && (j.a(this.rightBottomY, ((IntrusionDetectionRegion)paramObject).rightBottomY)) && (j.a(this.sensitivity, ((IntrusionDetectionRegion)paramObject).sensitivity)) && (j.a(this.threshold, ((IntrusionDetectionRegion)paramObject).threshold)) && (j.a(this.percentage, ((IntrusionDetectionRegion)paramObject).percentage))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getLeftBottomX()
  {
    return this.leftBottomX;
  }
  
  public final String getLeftBottomY()
  {
    return this.leftBottomY;
  }
  
  public final String getLeftTopX()
  {
    return this.leftTopX;
  }
  
  public final String getLeftTopY()
  {
    return this.leftTopY;
  }
  
  public final String getPercentage()
  {
    return this.percentage;
  }
  
  public final String getRightBottomX()
  {
    return this.rightBottomX;
  }
  
  public final String getRightBottomY()
  {
    return this.rightBottomY;
  }
  
  public final String getRightTopX()
  {
    return this.rightTopX;
  }
  
  public final String getRightTopY()
  {
    return this.rightTopY;
  }
  
  public final String getSensitivity()
  {
    return this.sensitivity;
  }
  
  public final String getThreshold()
  {
    return this.threshold;
  }
  
  public int hashCode()
  {
    String str = this.leftTopX;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.leftTopY;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.rightTopX;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.rightTopY;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.leftBottomX;
    int i1;
    if (str != null) {
      i1 = str.hashCode();
    } else {
      i1 = 0;
    }
    str = this.leftBottomY;
    int i2;
    if (str != null) {
      i2 = str.hashCode();
    } else {
      i2 = 0;
    }
    str = this.rightBottomX;
    int i3;
    if (str != null) {
      i3 = str.hashCode();
    } else {
      i3 = 0;
    }
    str = this.rightBottomY;
    int i4;
    if (str != null) {
      i4 = str.hashCode();
    } else {
      i4 = 0;
    }
    str = this.sensitivity;
    int i5;
    if (str != null) {
      i5 = str.hashCode();
    } else {
      i5 = 0;
    }
    str = this.threshold;
    int i6;
    if (str != null) {
      i6 = str.hashCode();
    } else {
      i6 = 0;
    }
    str = this.percentage;
    if (str != null) {
      i = str.hashCode();
    }
    return (((((((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IntrusionDetectionRegion(leftTopX=");
    localStringBuilder.append(this.leftTopX);
    localStringBuilder.append(", leftTopY=");
    localStringBuilder.append(this.leftTopY);
    localStringBuilder.append(", rightTopX=");
    localStringBuilder.append(this.rightTopX);
    localStringBuilder.append(", rightTopY=");
    localStringBuilder.append(this.rightTopY);
    localStringBuilder.append(", leftBottomX=");
    localStringBuilder.append(this.leftBottomX);
    localStringBuilder.append(", leftBottomY=");
    localStringBuilder.append(this.leftBottomY);
    localStringBuilder.append(", rightBottomX=");
    localStringBuilder.append(this.rightBottomX);
    localStringBuilder.append(", rightBottomY=");
    localStringBuilder.append(this.rightBottomY);
    localStringBuilder.append(", sensitivity=");
    localStringBuilder.append(this.sensitivity);
    localStringBuilder.append(", threshold=");
    localStringBuilder.append(this.threshold);
    localStringBuilder.append(", percentage=");
    localStringBuilder.append(this.percentage);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class Companion
    implements UnwrapFromResponse<List<? extends Map<String, ? extends IntrusionDetectionRegion>>>
  {
    public List<Map<String, IntrusionDetectionRegion>> fromResponse(Response<Wrappers> paramResponse)
    {
      j.e(paramResponse, "response");
      if (j.a(paramResponse.getMethod(), Method.GET_INTRUSION_DETECTION_REGION.getValue())) {
        paramResponse = (List)Model.typeCast((Wrappers)paramResponse.getResult(), Module.INTRUSION_DETECTION, Section.REGION_INFO);
      } else {
        paramResponse = null;
      }
      return paramResponse;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\IntrusionDetectionRegion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */