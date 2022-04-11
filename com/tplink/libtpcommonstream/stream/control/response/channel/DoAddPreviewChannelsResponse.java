package com.tplink.libtpcommonstream.stream.control.response.channel;

import com.google.gson.q.c;
import com.tplink.libtpcommonstream.stream.control.response.Response;
import java.util.ArrayList;
import java.util.List;

public class DoAddPreviewChannelsResponse
  extends Response
{
  @c("channels_invalid")
  private List<Integer> channelsInvalid = new ArrayList();
  @c("channels_lack_bandwidth")
  private List<Integer> channelsLackBandwidth = new ArrayList();
  @c("channels_offline")
  private List<Integer> channelsOffline = new ArrayList();
  @c("channels_too_many_request")
  private List<Integer> channelsTooManyRequest = new ArrayList();
  
  public List<Integer> getChannelsInvalid()
  {
    return this.channelsInvalid;
  }
  
  public List<Integer> getChannelsLackBandwidth()
  {
    return this.channelsLackBandwidth;
  }
  
  public List<Integer> getChannelsOffline()
  {
    return this.channelsOffline;
  }
  
  public List<Integer> getChannelsTooManyRequest()
  {
    return this.channelsTooManyRequest;
  }
  
  public void setChannelsInvalid(List<Integer> paramList)
  {
    this.channelsInvalid = paramList;
  }
  
  public void setChannelsLackBandwidth(List<Integer> paramList)
  {
    this.channelsLackBandwidth = paramList;
  }
  
  public void setChannelsOffline(List<Integer> paramList)
  {
    this.channelsOffline = paramList;
  }
  
  public void setChannelsTooManyRequest(List<Integer> paramList)
  {
    this.channelsTooManyRequest = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\response\channel\DoAddPreviewChannelsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */