package com.tplink.libtpnetwork.IoTNetwork.bean.hub.result;

import com.google.gson.q.c;
import java.util.List;

public class ChildComponentListBean
{
  @c("child_component_list")
  private List<ChildComponentBean> childComponentList;
  @c("start_index")
  private int startIndex;
  private int sum;
  
  public List<ChildComponentBean> getChildComponentList()
  {
    return this.childComponentList;
  }
  
  public int getStartIndex()
  {
    return this.startIndex;
  }
  
  public int getSum()
  {
    return this.sum;
  }
  
  public void setChildComponentList(List<ChildComponentBean> paramList)
  {
    this.childComponentList = paramList;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\hub\result\ChildComponentListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */