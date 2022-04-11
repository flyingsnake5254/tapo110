package com.tplink.cloud.bean.webservice.params;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ServiceStatusInfo
{
  private boolean isOpen;
  private String serviceName;
  private String uploadType;
  
  public ServiceStatusInfo() {}
  
  public ServiceStatusInfo(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.serviceName = paramString1;
    this.uploadType = paramString2;
    this.isOpen = paramBoolean;
  }
  
  public String getServiceName()
  {
    return this.serviceName;
  }
  
  public String getUploadType()
  {
    return this.uploadType;
  }
  
  public boolean isOpen()
  {
    return this.isOpen;
  }
  
  public void setOpen(boolean paramBoolean)
  {
    this.isOpen = paramBoolean;
  }
  
  public void setServiceName(String paramString)
  {
    this.serviceName = paramString;
  }
  
  public void setUploadType(String paramString)
  {
    this.uploadType = paramString;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ServiceName
  {
    public static final String USER_EXPERIENCE_IMPROVE = "userExperienceImprove";
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface UploadType
  {
    public static final String AUTOMATIC = "automatic";
    public static final String MANUAL = "manual";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\webservice\params\ServiceStatusInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */