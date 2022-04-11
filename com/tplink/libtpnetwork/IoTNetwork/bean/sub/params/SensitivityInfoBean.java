package com.tplink.libtpnetwork.IoTNetwork.bean.sub.params;

import com.google.gson.q.c;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.jvm.internal.j;

public final class SensitivityInfoBean
{
  @c("report_interval")
  private Integer reportInterval;
  private String sensitivity;
  
  public SensitivityInfoBean(String paramString, Integer paramInteger)
  {
    this.sensitivity = paramString;
    this.reportInterval = paramInteger;
  }
  
  public final String component1()
  {
    return this.sensitivity;
  }
  
  public final Integer component2()
  {
    return this.reportInterval;
  }
  
  public final SensitivityInfoBean copy(String paramString, Integer paramInteger)
  {
    return new SensitivityInfoBean(paramString, paramInteger);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof SensitivityInfoBean))
      {
        paramObject = (SensitivityInfoBean)paramObject;
        if ((j.a(this.sensitivity, ((SensitivityInfoBean)paramObject).sensitivity)) && (j.a(this.reportInterval, ((SensitivityInfoBean)paramObject).reportInterval))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final Integer getReportInterval()
  {
    return this.reportInterval;
  }
  
  public final String getSensitivity()
  {
    return this.sensitivity;
  }
  
  public int hashCode()
  {
    Object localObject = this.sensitivity;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.reportInterval;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j * 31 + i;
  }
  
  public final void setReportInterval(Integer paramInteger)
  {
    this.reportInterval = paramInteger;
  }
  
  public final void setSensitivity(String paramString)
  {
    this.sensitivity = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SensitivityInfoBean(sensitivity=");
    localStringBuilder.append(this.sensitivity);
    localStringBuilder.append(", reportInterval=");
    localStringBuilder.append(this.reportInterval);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SensorSensitivity
  {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String HIGH = "high";
    public static final String LOW = "low";
    public static final String NORMAL = "normal";
    
    public static final class Companion
    {
      public static final String HIGH = "high";
      public static final String LOW = "low";
      public static final String NORMAL = "normal";
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\sub\params\SensitivityInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */