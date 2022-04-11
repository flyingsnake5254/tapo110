package com.tplink.cloud.bean.push.params;

import java.util.ArrayList;
import java.util.List;

public class SubscribeItemParams
{
  private String deviceId;
  private List<String> messageTypeList = new ArrayList();
  
  public SubscribeItemParams() {}
  
  public SubscribeItemParams(String paramString, List<String> paramList)
  {
    this.deviceId = paramString;
    this.messageTypeList = paramList;
  }
  
  public void addMessageType(String paramString)
  {
    if (!this.messageTypeList.contains(paramString)) {
      this.messageTypeList.add(paramString);
    }
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public List<String> getMessageTypeList()
  {
    return this.messageTypeList;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setMessageTypeList(List<String> paramList)
  {
    this.messageTypeList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\push\params\SubscribeItemParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */