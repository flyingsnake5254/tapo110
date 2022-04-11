package com.tplink.libtpcommonstream.stream.control.notification;

import com.google.gson.q.c;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ChannelLensMaskInfo
{
  @c("channels")
  private int channels;
  @c("enabled")
  private String enabled;
  
  public int getChannels()
  {
    return this.channels;
  }
  
  public String getEnabled()
  {
    return this.enabled;
  }
  
  public void setChannels(int paramInt)
  {
    this.channels = paramInt;
  }
  
  public void setEnabled(String paramString)
  {
    this.enabled = paramString;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface LensMaskStatus
  {
    public static final String OFF = "off";
    public static final String ON = "on";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\notification\ChannelLensMaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */