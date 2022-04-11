package com.tplink.cloud.bean.push.result;

import com.tplink.cloud.bean.push.NotificationMsgBean;
import java.util.List;

public class NotificationMsgListResult
{
  private int currentIndex;
  private boolean hasNextPage;
  private List<NotificationMsgBean> notifications;
  private int total;
  
  public int getCurrentIndex()
  {
    return this.currentIndex;
  }
  
  public List<NotificationMsgBean> getNotifications()
  {
    return this.notifications;
  }
  
  public int getTotal()
  {
    return this.total;
  }
  
  public boolean isHasNextPage()
  {
    return this.hasNextPage;
  }
  
  public void setCurrentIndex(int paramInt)
  {
    this.currentIndex = paramInt;
  }
  
  public void setHasNextPage(boolean paramBoolean)
  {
    this.hasNextPage = paramBoolean;
  }
  
  public void setNotifications(List<NotificationMsgBean> paramList)
  {
    this.notifications = paramList;
  }
  
  public void setTotal(int paramInt)
  {
    this.total = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\push\result\NotificationMsgListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */