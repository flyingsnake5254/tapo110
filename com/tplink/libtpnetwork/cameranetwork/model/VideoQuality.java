package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class VideoQuality
{
  private final String bitRate;
  @c("bitrate_type")
  private final String bitRateType;
  @c("frame_rate")
  private final String frameRate;
  private final String quality;
  private final String resolution;
  @c("stream_type")
  private final String streamType;
  
  public VideoQuality(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.resolution = paramString1;
    this.bitRateType = paramString2;
    this.streamType = paramString3;
    this.quality = paramString4;
    this.bitRate = paramString5;
    this.frameRate = paramString6;
  }
  
  public final String component1()
  {
    return this.resolution;
  }
  
  public final String component2()
  {
    return this.bitRateType;
  }
  
  public final String component3()
  {
    return this.streamType;
  }
  
  public final String component4()
  {
    return this.quality;
  }
  
  public final String component5()
  {
    return this.bitRate;
  }
  
  public final String component6()
  {
    return this.frameRate;
  }
  
  public final VideoQuality copy(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    j.e(paramString1, "resolution");
    j.e(paramString2, "bitRateType");
    j.e(paramString3, "streamType");
    j.e(paramString4, "quality");
    j.e(paramString5, "bitRate");
    j.e(paramString6, "frameRate");
    return new VideoQuality(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VideoQuality))
      {
        paramObject = (VideoQuality)paramObject;
        if ((j.a(this.resolution, ((VideoQuality)paramObject).resolution)) && (j.a(this.bitRateType, ((VideoQuality)paramObject).bitRateType)) && (j.a(this.streamType, ((VideoQuality)paramObject).streamType)) && (j.a(this.quality, ((VideoQuality)paramObject).quality)) && (j.a(this.bitRate, ((VideoQuality)paramObject).bitRate)) && (j.a(this.frameRate, ((VideoQuality)paramObject).frameRate))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getBitRate()
  {
    return this.bitRate;
  }
  
  public final String getBitRateType()
  {
    return this.bitRateType;
  }
  
  public final String getFrameRate()
  {
    return this.frameRate;
  }
  
  public final String getQuality()
  {
    return this.quality;
  }
  
  public final String getResolution()
  {
    return this.resolution;
  }
  
  public final ResolutionType getResolutionType()
  {
    return ResolutionType.Companion.fromString(this.resolution);
  }
  
  public final String getStreamType()
  {
    return this.streamType;
  }
  
  public int hashCode()
  {
    String str = this.resolution;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.bitRateType;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.streamType;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.quality;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.bitRate;
    int i1;
    if (str != null) {
      i1 = str.hashCode();
    } else {
      i1 = 0;
    }
    str = this.frameRate;
    if (str != null) {
      i = str.hashCode();
    }
    return ((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoQuality(resolution=");
    localStringBuilder.append(this.resolution);
    localStringBuilder.append(", bitRateType=");
    localStringBuilder.append(this.bitRateType);
    localStringBuilder.append(", streamType=");
    localStringBuilder.append(this.streamType);
    localStringBuilder.append(", quality=");
    localStringBuilder.append(this.quality);
    localStringBuilder.append(", bitRate=");
    localStringBuilder.append(this.bitRate);
    localStringBuilder.append(", frameRate=");
    localStringBuilder.append(this.frameRate);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\VideoQuality.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */