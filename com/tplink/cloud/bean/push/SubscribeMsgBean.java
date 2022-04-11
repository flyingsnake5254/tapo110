package com.tplink.cloud.bean.push;

import com.google.gson.q.b;
import com.tplink.cloud.bean.push.params.SubscribeItemParams;
import java.util.List;

public class SubscribeMsgBean
{
  @b(SubscribeMessageAdapter.class)
  private List<SubscribeItemParams> subscribeMsgType;
  
  public SubscribeMsgBean() {}
  
  public SubscribeMsgBean(List<SubscribeItemParams> paramList)
  {
    this.subscribeMsgType = paramList;
  }
  
  public List<SubscribeItemParams> getSubscribeMsgType()
  {
    return this.subscribeMsgType;
  }
  
  public void setSubscribeMsgType(List<SubscribeItemParams> paramList)
  {
    this.subscribeMsgType = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\push\SubscribeMsgBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */