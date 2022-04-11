package com.tplink.libtpcommonstream.stream.control.notification;

import android.util.Pair;
import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.List;

public class ChannelPassengerFlowInfo
{
  @c("channels")
  private List<Integer> channels = new ArrayList();
  @c("in")
  private List<String> passengerIn = new ArrayList();
  @c("out")
  private List<String> passengerOut = new ArrayList();
  @c("timestamp")
  private List<String> timestamp = new ArrayList();
  
  public Pair<String, String> getChannelPassengerInInfo(String paramString)
  {
    int i = this.channels.indexOf(paramString);
    if ((i > 0) && (i < this.passengerIn.size()) && (i < this.timestamp.size())) {
      paramString = new Pair((String)this.passengerIn.get(i), (String)this.timestamp.get(i));
    } else {
      paramString = null;
    }
    return paramString;
  }
  
  public Pair<String, String> getChannelPassengerOutInfo(String paramString)
  {
    int i = this.channels.indexOf(paramString);
    if ((i > 0) && (i < this.passengerOut.size()) && (i < this.timestamp.size())) {
      paramString = new Pair((String)this.passengerOut.get(i), (String)this.timestamp.get(i));
    } else {
      paramString = null;
    }
    return paramString;
  }
  
  public List<Integer> getChannels()
  {
    return this.channels;
  }
  
  public List<String> getPassengerIn()
  {
    return this.passengerIn;
  }
  
  public List<String> getPassengerOut()
  {
    return this.passengerOut;
  }
  
  public List<String> getTimestamp()
  {
    return this.timestamp;
  }
  
  public void setChannels(List<Integer> paramList)
  {
    this.channels = paramList;
  }
  
  public void setPassengerIn(List<String> paramList)
  {
    this.passengerIn = paramList;
  }
  
  public void setPassengerOut(List<String> paramList)
  {
    this.passengerOut = paramList;
  }
  
  public void setTimestamp(List<String> paramList)
  {
    this.timestamp = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\notification\ChannelPassengerFlowInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */