package com.tplink.libtpcommonstream.stream.control.notification;

import com.google.gson.q.c;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class ChannelSmartCodecInfo
{
  @c("channels")
  private List<Integer> channels = new ArrayList();
  @c("enabled")
  private List<String> enabled = new ArrayList();
  
  public String getChannelSmartCodecStatus(String paramString)
  {
    int i = this.channels.indexOf(paramString);
    if ((i > 0) && (i < this.enabled.size())) {
      return (String)this.enabled.get(i);
    }
    return null;
  }
  
  public List<Integer> getChannels()
  {
    return this.channels;
  }
  
  public List<String> getEnabled()
  {
    return this.enabled;
  }
  
  public void setChannels(List<Integer> paramList)
  {
    this.channels = paramList;
  }
  
  public void setEnabled(List<String> paramList)
  {
    this.enabled = paramList;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SmartCodecInfo
  {
    public static final String OFF = "off";
    public static final String ON = "on";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\notification\ChannelSmartCodecInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */