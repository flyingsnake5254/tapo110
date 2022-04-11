package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.c;
import java.util.List;

public class ThingSupportCategory
{
  @c("device_category_list")
  private List<SubThingCategoryBean> deviceCategoryList;
  
  public List<SubThingCategoryBean> getDeviceCategoryList()
  {
    return this.deviceCategoryList;
  }
  
  public void setDeviceCategoryList(List<SubThingCategoryBean> paramList)
  {
    this.deviceCategoryList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingSupportCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */