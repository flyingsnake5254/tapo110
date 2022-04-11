package com.tplink.cloud.bean.webservice.params;

import com.google.gson.k;
import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.List;

public class DataCollectRequestParams
{
  @c("el")
  private List<DataCollectEventBean> eventList;
  @c("ex")
  private k extension;
  @c("lg")
  private String language;
  @c("sr")
  private String source;
  @c("srp")
  private k sourceParams;
  @c("tz")
  private Integer timeZone;
  private String uvi;
  
  public void addEvent(DataCollectEventBean paramDataCollectEventBean)
  {
    if (this.eventList == null) {
      this.eventList = new ArrayList();
    }
    this.eventList.add(paramDataCollectEventBean);
  }
  
  public List<DataCollectEventBean> getEventList()
  {
    return this.eventList;
  }
  
  public k getExtension()
  {
    return this.extension;
  }
  
  public String getLanguage()
  {
    return this.language;
  }
  
  public String getSource()
  {
    return this.source;
  }
  
  public k getSourceParams()
  {
    return this.sourceParams;
  }
  
  public Integer getTimeZone()
  {
    return this.timeZone;
  }
  
  public String getUvi()
  {
    return this.uvi;
  }
  
  public void setEventList(ArrayList<DataCollectEventBean> paramArrayList)
  {
    this.eventList = paramArrayList;
  }
  
  public void setExtension(k paramk)
  {
    this.extension = paramk;
  }
  
  public void setLanguage(String paramString)
  {
    this.language = paramString;
  }
  
  public void setSource(String paramString)
  {
    this.source = paramString;
  }
  
  public void setSourceParams(k paramk)
  {
    this.sourceParams = paramk;
  }
  
  public void setTimeZone(Integer paramInteger)
  {
    this.timeZone = paramInteger;
  }
  
  public void setUvi(String paramString)
  {
    this.uvi = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\webservice\params\DataCollectRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */