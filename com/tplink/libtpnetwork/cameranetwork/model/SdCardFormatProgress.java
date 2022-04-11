package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class SdCardFormatProgress
{
  private final String percent;
  private final float progress;
  private final String result;
  private final FormatResult status;
  
  public SdCardFormatProgress(String paramString1, String paramString2)
  {
    this.percent = paramString1;
    this.result = paramString2;
    this.status = FormatResult.Companion.fromString(paramString2);
    paramString1 = m.j(paramString1);
    float f;
    if (paramString1 != null) {
      f = paramString1.floatValue();
    } else {
      f = 0.0F;
    }
    this.progress = f;
  }
  
  public final String component1()
  {
    return this.percent;
  }
  
  public final String component2()
  {
    return this.result;
  }
  
  public final SdCardFormatProgress copy(String paramString1, String paramString2)
  {
    j.e(paramString1, "percent");
    j.e(paramString2, "result");
    return new SdCardFormatProgress(paramString1, paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof SdCardFormatProgress))
      {
        paramObject = (SdCardFormatProgress)paramObject;
        if ((j.a(this.percent, ((SdCardFormatProgress)paramObject).percent)) && (j.a(this.result, ((SdCardFormatProgress)paramObject).result))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getPercent()
  {
    return this.percent;
  }
  
  public final float getProgress()
  {
    return this.progress;
  }
  
  public final String getResult()
  {
    return this.result;
  }
  
  public final FormatResult getStatus()
  {
    return this.status;
  }
  
  public int hashCode()
  {
    String str = this.percent;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.result;
    if (str != null) {
      i = str.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SdCardFormatProgress(percent=");
    localStringBuilder.append(this.percent);
    localStringBuilder.append(", result=");
    localStringBuilder.append(this.result);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\SdCardFormatProgress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */