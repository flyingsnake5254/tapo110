package com.tplink.iot.cloud.bean.cloudvideo.result;

import java.util.ArrayList;
import java.util.List;

public class DeviceVideoDateResult<T>
{
  private List<T> dateList = new ArrayList();
  
  public List<T> getDateList()
  {
    return this.dateList;
  }
  
  public void setDateList(List<T> paramList)
  {
    this.dateList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\cloudvideo\result\DeviceVideoDateResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */