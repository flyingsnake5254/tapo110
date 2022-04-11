package com.tplink.iot.j.a;

import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.DeviceBean;
import java.util.List;

public class a
{
  private List<DeviceBean> a;
  private List<GroupInfo> b;
  
  public a() {}
  
  public a(List<DeviceBean> paramList, List<GroupInfo> paramList1)
  {
    this.a = paramList;
    this.b = paramList1;
  }
  
  public int a()
  {
    List localList = this.a;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    return i;
  }
  
  public List<DeviceBean> b()
  {
    return this.a;
  }
  
  public List<GroupInfo> c()
  {
    return this.b;
  }
  
  public int d()
  {
    List localList = this.b;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    return i;
  }
  
  public int e()
  {
    return a() + d();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\j\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */