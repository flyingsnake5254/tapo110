package com.tplink.libtpnetwork.IoTNetwork.bean.hub.result;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import java.util.List;

public class ChildDeviceListBean
{
  @c("child_device_list")
  private List<IoTSubDevice> childDeviceList;
  @c("start_index")
  private int startIndex;
  private int sum;
  
  public List<IoTSubDevice> getChildDeviceList()
  {
    return this.childDeviceList;
  }
  
  public int getStartIndex()
  {
    return this.startIndex;
  }
  
  public int getSum()
  {
    return this.sum;
  }
  
  public void setChildDeviceList(List<IoTSubDevice> paramList)
  {
    this.childDeviceList = paramList;
  }
  
  public void setStartIndex(int paramInt)
  {
    this.startIndex = paramInt;
  }
  
  public void setSum(int paramInt)
  {
    this.sum = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\hub\result\ChildDeviceListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */