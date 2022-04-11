package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;
import com.tplink.libtpcommonstream.stream.control.request.param.GetPreviewParams;

public class GetPreviewRequest
  extends Request
{
  @c("preview")
  private GetPreviewParams preview;
  
  public GetPreviewRequest()
  {
    super("get");
  }
  
  public GetPreviewParams getPreview()
  {
    return this.preview;
  }
  
  public void setPreview(GetPreviewParams paramGetPreviewParams)
  {
    this.preview = paramGetPreviewParams;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\request\GetPreviewRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */