package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;
import com.tplink.libtpcommonstream.stream.control.request.param.GetUploadParams;

public class GetUploadRequest
  extends Request
{
  @c("upload")
  private GetUploadParams upload;
  
  public GetUploadRequest()
  {
    super("get");
  }
  
  public GetUploadParams getUpload()
  {
    return this.upload;
  }
  
  public void setUpload(GetUploadParams paramGetUploadParams)
  {
    this.upload = paramGetUploadParams;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\request\GetUploadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */