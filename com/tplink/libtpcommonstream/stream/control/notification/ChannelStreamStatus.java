package com.tplink.libtpcommonstream.stream.control.notification;

import com.google.gson.q.c;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class ChannelStreamStatus
{
  @c("channels")
  private List<Integer> channels = new ArrayList();
  @c("status")
  private List<String> status = new ArrayList();
  
  public String getChannelStreamStatus(String paramString)
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
  
  public List<String> getStatus()
  {
    return this.status;
  }
  
  public void setChannels(List<Integer> paramList)
  {
    this.channels = paramList;
  }
  
  public void setStatus(List<String> paramList)
  {
    this.status = paramList;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PlaybackStreamStatus
  {
    public static final String LACK_BANDWIDTH = "lack_bandwidth";
    public static final String NORMAL = "normal";
    public static final String NO_DATA = "no_data";
    public static final String OFFLINE = "offline";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\notification\ChannelStreamStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */