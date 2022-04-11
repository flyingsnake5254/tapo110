package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class RecordAudioInfo
{
  private String enabled;
  
  public RecordAudioInfo(String paramString)
  {
    this.enabled = paramString;
  }
  
  public final String component1()
  {
    return this.enabled;
  }
  
  public final RecordAudioInfo copy(String paramString)
  {
    j.e(paramString, "enabled");
    return new RecordAudioInfo(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof RecordAudioInfo))
      {
        paramObject = (RecordAudioInfo)paramObject;
        if (j.a(this.enabled, ((RecordAudioInfo)paramObject).enabled)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getEnabled()
  {
    return this.enabled;
  }
  
  public int hashCode()
  {
    String str = this.enabled;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public final void setEnabled(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.enabled = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordAudioInfo(enabled=");
    localStringBuilder.append(this.enabled);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\RecordAudioInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */