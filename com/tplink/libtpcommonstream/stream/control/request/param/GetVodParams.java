package com.tplink.libtpcommonstream.stream.control.request.param;

import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.List;

public class GetVodParams
{
  @c("channels")
  private List<Integer> channels = new ArrayList();
  @c("client_id")
  private int clientId;
  @c("end_time")
  private String endTime;
  @c("event_type")
  private List<Integer> eventType = new ArrayList();
  @c("file_id")
  private String fileId;
  @c("interval")
  private String interval;
  @c("media_type")
  private Integer mediaType;
  @c("range")
  private String range;
  @c("scale")
  private String scale;
  @c("speed")
  private String speed;
  @c("start_time")
  private String startTime;
  
  public List<Integer> getChannels()
  {
    return this.channels;
  }
  
  public int getClientId()
  {
    return this.clientId;
  }
  
  public String getEndTime()
  {
    return this.endTime;
  }
  
  public List<Integer> getEventType()
  {
    return this.eventType;
  }
  
  public String getFileId()
  {
    return this.fileId;
  }
  
  public String getInterval()
  {
    return this.interval;
  }
  
  public Integer getMediaType()
  {
    return this.mediaType;
  }
  
  public String getRange()
  {
    return this.range;
  }
  
  public String getScale()
  {
    return this.scale;
  }
  
  public String getSpeed()
  {
    return this.speed;
  }
  
  public String getStartTime()
  {
    return this.startTime;
  }
  
  public void setChannels(List<Integer> paramList)
  {
    this.channels = paramList;
  }
  
  public void setClientId(int paramInt)
  {
    this.clientId = paramInt;
  }
  
  public void setEndTime(String paramString)
  {
    this.endTime = paramString;
  }
  
  public void setEventType(List<Integer> paramList)
  {
    this.eventType = paramList;
  }
  
  public void setFileId(String paramString)
  {
    this.fileId = paramString;
  }
  
  public void setInterval(String paramString)
  {
    this.interval = paramString;
  }
  
  public void setMediaType(Integer paramInteger)
  {
    this.mediaType = paramInteger;
  }
  
  public void setRange(String paramString)
  {
    this.range = paramString;
  }
  
  public void setScale(String paramString)
  {
    this.scale = paramString;
  }
  
  public void setSpeed(String paramString)
  {
    this.speed = paramString;
  }
  
  public void setStartTime(String paramString)
  {
    this.startTime = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\request\param\GetVodParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */