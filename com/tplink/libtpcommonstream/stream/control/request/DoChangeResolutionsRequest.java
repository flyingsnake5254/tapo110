package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;
import com.tplink.libtpcommonstream.stream.control.request.param.GetPreviewParams;

public class DoChangeResolutionsRequest
  extends Request
{
  @c("change_resolutions")
  private GetPreviewParams changeResolutions;
  
  public DoChangeResolutionsRequest()
  {
    super("do");
  }
  
  public GetPreviewParams getChangeResolutions()
  {
    return this.changeResolutions;
  }
  
  public void setChangeResolutions(GetPreviewParams paramGetPreviewParams)
  {
    this.changeResolutions = paramGetPreviewParams;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\request\DoChangeResolutionsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */