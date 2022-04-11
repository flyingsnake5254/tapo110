package com.tplink.libtpcommonstream.stream.control.request.channel;

import com.google.gson.q.c;
import com.tplink.libtpcommonstream.stream.control.request.Request;

public class DoAddPreviewChannelsRequest
  extends Request
{
  @c("preview_add_channels")
  private AddPreviewChannelParams params;
  
  public DoAddPreviewChannelsRequest()
  {
    super("do");
  }
  
  public AddPreviewChannelParams getParams()
  {
    return this.params;
  }
  
  public void setParams(AddPreviewChannelParams paramAddPreviewChannelParams)
  {
    this.params = paramAddPreviewChannelParams;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\request\channel\DoAddPreviewChannelsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */