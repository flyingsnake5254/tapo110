package com.tplink.libtpmediastatistics;

import java.util.HashMap;
import java.util.Map;

public class FeedbackPayload
{
  private Map<String, Object> data = new HashMap();
  private String type;
  private String version;
  
  public void addData(String paramString, Object paramObject)
  {
    this.data.put(paramString, paramObject);
  }
  
  public Map<String, Object> getData()
  {
    return this.data;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public String getVersion()
  {
    return this.version;
  }
  
  public void setData(Map<String, Object> paramMap)
  {
    this.data = paramMap;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void setVersion(String paramString)
  {
    this.version = paramString;
  }
  
  public String toString()
  {
    return MediaJsonUtils.toJSON(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediastatistics\FeedbackPayload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */