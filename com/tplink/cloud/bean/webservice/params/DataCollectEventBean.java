package com.tplink.cloud.bean.webservice.params;

import com.google.gson.k;
import com.google.gson.q.c;

public class DataCollectEventBean
{
  @c("ct")
  private long currentTime;
  @c("eid")
  private String eventId;
  @c("ep")
  private k eventParams;
  @c("pvi")
  private String pageViewId;
  @c("usi")
  private String userId;
  
  public long getCurrentTime()
  {
    return this.currentTime;
  }
  
  public String getEventId()
  {
    return this.eventId;
  }
  
  public k getEventParams()
  {
    return this.eventParams;
  }
  
  public String getPageViewId()
  {
    return this.pageViewId;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void setCurrentTime(long paramLong)
  {
    this.currentTime = paramLong;
  }
  
  public void setEventId(String paramString)
  {
    this.eventId = paramString;
  }
  
  public void setEventParams(k paramk)
  {
    this.eventParams = paramk;
  }
  
  public void setPageViewId(String paramString)
  {
    this.pageViewId = paramString;
  }
  
  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\webservice\params\DataCollectEventBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */