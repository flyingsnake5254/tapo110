package com.tplink.iot.cloud.bean.push.params;

import com.google.gson.q.b;
import com.tplink.cloud.bean.push.SubscribeMessageAdapter;
import com.tplink.cloud.bean.push.params.SubscribeItemParams;
import java.util.ArrayList;
import java.util.List;

public class IoTSubscribeMsgParams
{
  @b(SubscribeMessageAdapter.class)
  private List<SubscribeItemParams> subscribeMsgType = new ArrayList();
  @b(SubscribeMessageAdapter.class)
  private List<SubscribeItemParams> subscribeMsgTypeForSub = new ArrayList();
  
  public IoTSubscribeMsgParams() {}
  
  public IoTSubscribeMsgParams(List<SubscribeItemParams> paramList1, List<SubscribeItemParams> paramList2)
  {
    setSubscribeMsgType(paramList1);
    setSubscribeMsgTypeForSub(paramList2);
  }
  
  public List<SubscribeItemParams> getSubscribeMsgType()
  {
    return this.subscribeMsgType;
  }
  
  public List<SubscribeItemParams> getSubscribeMsgTypeForSub()
  {
    return this.subscribeMsgTypeForSub;
  }
  
  public void setSubscribeMsgType(List<SubscribeItemParams> paramList)
  {
    if (paramList != null) {
      this.subscribeMsgType = paramList;
    }
  }
  
  public void setSubscribeMsgTypeForSub(List<SubscribeItemParams> paramList)
  {
    if (paramList != null) {
      this.subscribeMsgTypeForSub = paramList;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\push\params\IoTSubscribeMsgParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */