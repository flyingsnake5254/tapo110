package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class SpeakerInfo
{
  private String volume;
  
  public SpeakerInfo(String paramString)
  {
    this.volume = paramString;
  }
  
  public final String component1()
  {
    return this.volume;
  }
  
  public final SpeakerInfo copy(String paramString)
  {
    j.e(paramString, "volume");
    return new SpeakerInfo(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof SpeakerInfo))
      {
        paramObject = (SpeakerInfo)paramObject;
        if (j.a(this.volume, ((SpeakerInfo)paramObject).volume)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getVolume()
  {
    return this.volume;
  }
  
  public int hashCode()
  {
    String str = this.volume;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public final void setVolume(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.volume = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SpeakerInfo(volume=");
    localStringBuilder.append(this.volume);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\SpeakerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */