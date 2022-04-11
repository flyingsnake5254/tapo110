package com.tplink.cloud.bean.push.params;

import java.util.List;

public class NotificationMsgTypeListParams
{
  private List<NotificationMsgTypeParams> msgList;
  
  public List<NotificationMsgTypeParams> getMsgList()
  {
    return this.msgList;
  }
  
  public void setMsgList(List<NotificationMsgTypeParams> paramList)
  {
    this.msgList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\push\params\NotificationMsgTypeListParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */