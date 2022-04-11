package com.tplink.cloud.bean.device.params;

import java.util.Arrays;
import java.util.List;

public class DeviceListPageParams
  extends DeviceListParams
{
  private List<String> deviceTypeList;
  private int index;
  private int limit;
  
  public DeviceListPageParams() {}
  
  public DeviceListPageParams(String paramString, int paramInt1, int paramInt2, List<String> paramList)
  {
    super(paramString, null);
    this.index = paramInt1;
    this.limit = paramInt2;
    this.deviceTypeList = paramList;
  }
  
  public DeviceListPageParams(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    super(paramString, null);
    this.index = paramInt1;
    this.limit = paramInt2;
    this.deviceTypeList = Arrays.asList(paramVarArgs);
  }
  
  public DeviceListPageParams(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramString1, paramString2);
    this.index = paramInt1;
    this.limit = paramInt2;
  }
  
  public List<String> getDeviceTypeList()
  {
    return this.deviceTypeList;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public int getLimit()
  {
    return this.limit;
  }
  
  public void setDeviceTypeList(List<String> paramList)
  {
    this.deviceTypeList = paramList;
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setLimit(int paramInt)
  {
    this.limit = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\params\DeviceListPageParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */