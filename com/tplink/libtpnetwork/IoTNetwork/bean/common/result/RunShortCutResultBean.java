package com.tplink.libtpnetwork.IoTNetwork.bean.common.result;

import androidx.annotation.Nullable;
import java.util.List;

public class RunShortCutResultBean
{
  private int code;
  private List<String> failedDeviceNames;
  private String smartId;
  
  public RunShortCutResultBean(String paramString, int paramInt)
  {
    this.smartId = paramString;
    this.code = paramInt;
  }
  
  public RunShortCutResultBean(String paramString, int paramInt, List<String> paramList)
  {
    this.smartId = paramString;
    this.code = paramInt;
    this.failedDeviceNames = paramList;
  }
  
  public int getCode()
  {
    return this.code;
  }
  
  @Nullable
  public List<String> getFailedDeviceNames()
  {
    return this.failedDeviceNames;
  }
  
  public String getSmartId()
  {
    return this.smartId;
  }
  
  public boolean isSuccess()
  {
    boolean bool;
    if (this.code == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void setCode(int paramInt)
  {
    this.code = paramInt;
  }
  
  public void setFailedDeviceNames(@Nullable List<String> paramList)
  {
    this.failedDeviceNames = paramList;
  }
  
  public void setSmartId(String paramString)
  {
    this.smartId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\result\RunShortCutResultBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */