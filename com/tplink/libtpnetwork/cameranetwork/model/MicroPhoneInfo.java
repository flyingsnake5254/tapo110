package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class MicroPhoneInfo
{
  private final String bitrate;
  private final String channels;
  @c("encode_type")
  private final String encodeType;
  @c("sampling_rate")
  private final String samplingRate;
  private String volume;
  
  public MicroPhoneInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.volume = paramString1;
    this.channels = paramString2;
    this.bitrate = paramString3;
    this.encodeType = paramString4;
    this.samplingRate = paramString5;
  }
  
  public final String component1()
  {
    return this.volume;
  }
  
  public final String component2()
  {
    return this.channels;
  }
  
  public final String component3()
  {
    return this.bitrate;
  }
  
  public final String component4()
  {
    return this.encodeType;
  }
  
  public final String component5()
  {
    return this.samplingRate;
  }
  
  public final MicroPhoneInfo copy(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    j.e(paramString1, "volume");
    return new MicroPhoneInfo(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MicroPhoneInfo))
      {
        paramObject = (MicroPhoneInfo)paramObject;
        if ((j.a(this.volume, ((MicroPhoneInfo)paramObject).volume)) && (j.a(this.channels, ((MicroPhoneInfo)paramObject).channels)) && (j.a(this.bitrate, ((MicroPhoneInfo)paramObject).bitrate)) && (j.a(this.encodeType, ((MicroPhoneInfo)paramObject).encodeType)) && (j.a(this.samplingRate, ((MicroPhoneInfo)paramObject).samplingRate))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getBitrate()
  {
    return this.bitrate;
  }
  
  public final String getChannels()
  {
    return this.channels;
  }
  
  public final String getEncodeType()
  {
    return this.encodeType;
  }
  
  public final String getSamplingRate()
  {
    return this.samplingRate;
  }
  
  public final String getVolume()
  {
    return this.volume;
  }
  
  public int hashCode()
  {
    String str = this.volume;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.channels;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.bitrate;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.encodeType;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.samplingRate;
    if (str != null) {
      i = str.hashCode();
    }
    return (((j * 31 + k) * 31 + m) * 31 + n) * 31 + i;
  }
  
  public final void setVolume(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.volume = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MicroPhoneInfo(volume=");
    localStringBuilder.append(this.volume);
    localStringBuilder.append(", channels=");
    localStringBuilder.append(this.channels);
    localStringBuilder.append(", bitrate=");
    localStringBuilder.append(this.bitrate);
    localStringBuilder.append(", encodeType=");
    localStringBuilder.append(this.encodeType);
    localStringBuilder.append(", samplingRate=");
    localStringBuilder.append(this.samplingRate);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\MicroPhoneInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */