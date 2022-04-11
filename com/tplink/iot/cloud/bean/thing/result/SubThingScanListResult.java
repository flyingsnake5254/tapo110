package com.tplink.iot.cloud.bean.thing.result;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.SubThingSetupInfo;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class SubThingScanListResult
{
  @c("child_device_list")
  private List<SubThingSetupInfo> childDeviceList;
  @c("scan_status")
  private String scanStatus;
  
  public List<SubThingSetupInfo> getChildDeviceList()
  {
    return this.childDeviceList;
  }
  
  public String getScanStatus()
  {
    return this.scanStatus;
  }
  
  public void setChildDeviceList(List<SubThingSetupInfo> paramList)
  {
    this.childDeviceList = paramList;
  }
  
  public void setScanStatus(String paramString)
  {
    this.scanStatus = paramString;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ScanStatus
  {
    public static final String STATUS_IDLE = "idle";
    public static final String STATUS_SCANNING = "scanning";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\result\SubThingScanListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */