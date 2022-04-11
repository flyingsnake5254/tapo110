package com.tplink.libtpnetwork.TPCloudNetwork.bean;

import com.tplink.cloud.bean.push.NotificationMsgBean;
import java.util.ArrayList;
import java.util.List;

public class NotificationMsgCacheBean
{
  private List<NotificationMsgBean> list = new ArrayList();
  private String locale;
  
  public void clearList()
  {
    this.list.clear();
  }
  
  public List<NotificationMsgBean> getList()
  {
    return this.list;
  }
  
  public String getLocale()
  {
    return this.locale;
  }
  
  public void setList(List<NotificationMsgBean> paramList)
  {
    clearList();
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.list.addAll(paramList);
    }
  }
  
  public void setLocale(String paramString)
  {
    this.locale = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\bean\NotificationMsgCacheBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */