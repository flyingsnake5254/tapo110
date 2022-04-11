package com.tplink.libtpcommonstream.stream.control.notification;

import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.List;

public class ChannelMotorStatus
{
  @c("channels")
  private List<Integer> channels = new ArrayList();
  @c("direction")
  private List<String> direction = new ArrayList();
  @c("status")
  private List<String> status = new ArrayList();
  
  public String getChannelMotorDirection(String paramString)
  {
    int i = this.channels.indexOf(paramString);
    if ((i > 0) && (i < this.direction.size())) {
      return (String)this.direction.get(i);
    }
    return null;
  }
  
  public String getChannelMotorStatus(String paramString)
  {
    int i = this.channels.indexOf(paramString);
    if ((i > 0) && (i < this.status.size())) {
      return (String)this.status.get(i);
    }
    return null;
  }
  
  public List<Integer> getChannels()
  {
    return this.channels;
  }
  
  public List<String> getDirection()
  {
    return this.direction;
  }
  
  public List<String> getStatus()
  {
    return this.status;
  }
  
  public void setChannels(List<Integer> paramList)
  {
    this.channels = paramList;
  }
  
  public void setDirection(List<String> paramList)
  {
    this.direction = paramList;
  }
  
  public void setStatus(List<String> paramList)
  {
    this.status = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\notification\ChannelMotorStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */