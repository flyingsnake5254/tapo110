package com.tplink.iot.cloud.bean.thing.params;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.SubThingCategoryBean;
import java.util.List;

public class SubThingCategoryScanParams
{
  @c("scan_list")
  private List<SubThingCategoryBean> scanList;
  
  public List<SubThingCategoryBean> getScanList()
  {
    return this.scanList;
  }
  
  public void setScanList(List<SubThingCategoryBean> paramList)
  {
    this.scanList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\params\SubThingCategoryScanParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */