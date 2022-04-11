package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import java.util.List;
import kotlin.jvm.internal.j;

public final class VideoCapability
{
  @c("bitrate_types")
  private final List<String> bitrateTypes;
  private final List<String> bitrates;
  @c("encode_types")
  private final List<String> encodeTypes;
  @c("frame_rates")
  private final List<String> frameRates;
  private final List<String> qualitys;
  private final List<String> resolutions;
  
  public VideoCapability(List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4, List<String> paramList5, List<String> paramList6)
  {
    this.encodeTypes = paramList1;
    this.frameRates = paramList2;
    this.bitrates = paramList3;
    this.bitrateTypes = paramList4;
    this.resolutions = paramList5;
    this.qualitys = paramList6;
  }
  
  public final List<String> component1()
  {
    return this.encodeTypes;
  }
  
  public final List<String> component2()
  {
    return this.frameRates;
  }
  
  public final List<String> component3()
  {
    return this.bitrates;
  }
  
  public final List<String> component4()
  {
    return this.bitrateTypes;
  }
  
  public final List<String> component5()
  {
    return this.resolutions;
  }
  
  public final List<String> component6()
  {
    return this.qualitys;
  }
  
  public final VideoCapability copy(List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4, List<String> paramList5, List<String> paramList6)
  {
    return new VideoCapability(paramList1, paramList2, paramList3, paramList4, paramList5, paramList6);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VideoCapability))
      {
        paramObject = (VideoCapability)paramObject;
        if ((j.a(this.encodeTypes, ((VideoCapability)paramObject).encodeTypes)) && (j.a(this.frameRates, ((VideoCapability)paramObject).frameRates)) && (j.a(this.bitrates, ((VideoCapability)paramObject).bitrates)) && (j.a(this.bitrateTypes, ((VideoCapability)paramObject).bitrateTypes)) && (j.a(this.resolutions, ((VideoCapability)paramObject).resolutions)) && (j.a(this.qualitys, ((VideoCapability)paramObject).qualitys))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final List<String> getBitrateTypes()
  {
    return this.bitrateTypes;
  }
  
  public final List<String> getBitrates()
  {
    return this.bitrates;
  }
  
  public final List<String> getEncodeTypes()
  {
    return this.encodeTypes;
  }
  
  public final List<String> getFrameRates()
  {
    return this.frameRates;
  }
  
  public final List<String> getQualitys()
  {
    return this.qualitys;
  }
  
  public final List<String> getResolutions()
  {
    return this.resolutions;
  }
  
  public int hashCode()
  {
    List localList = this.encodeTypes;
    int i = 0;
    int j;
    if (localList != null) {
      j = localList.hashCode();
    } else {
      j = 0;
    }
    localList = this.frameRates;
    int k;
    if (localList != null) {
      k = localList.hashCode();
    } else {
      k = 0;
    }
    localList = this.bitrates;
    int m;
    if (localList != null) {
      m = localList.hashCode();
    } else {
      m = 0;
    }
    localList = this.bitrateTypes;
    int n;
    if (localList != null) {
      n = localList.hashCode();
    } else {
      n = 0;
    }
    localList = this.resolutions;
    int i1;
    if (localList != null) {
      i1 = localList.hashCode();
    } else {
      i1 = 0;
    }
    localList = this.qualitys;
    if (localList != null) {
      i = localList.hashCode();
    }
    return ((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoCapability(encodeTypes=");
    localStringBuilder.append(this.encodeTypes);
    localStringBuilder.append(", frameRates=");
    localStringBuilder.append(this.frameRates);
    localStringBuilder.append(", bitrates=");
    localStringBuilder.append(this.bitrates);
    localStringBuilder.append(", bitrateTypes=");
    localStringBuilder.append(this.bitrateTypes);
    localStringBuilder.append(", resolutions=");
    localStringBuilder.append(this.resolutions);
    localStringBuilder.append(", qualitys=");
    localStringBuilder.append(this.qualitys);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\VideoCapability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */