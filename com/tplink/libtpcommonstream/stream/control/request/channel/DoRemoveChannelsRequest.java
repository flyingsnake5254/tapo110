package com.tplink.libtpcommonstream.stream.control.request.channel;

import com.google.gson.q.c;
import com.tplink.libtpcommonstream.stream.control.request.Request;
import java.util.ArrayList;
import java.util.List;

public class DoRemoveChannelsRequest
  extends Request
{
  @c("remove_channels")
  private List<Integer> removeChannels = new ArrayList();
  
  public DoRemoveChannelsRequest(String paramString)
  {
    super("do");
  }
  
  public List<Integer> getRemoveChannels()
  {
    return this.removeChannels;
  }
  
  public void setRemoveChannels(List<Integer> paramList)
  {
    this.removeChannels = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\request\channel\DoRemoveChannelsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */