package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;
import com.tplink.libtpcommonstream.stream.control.request.param.GetDownloadParams;

public class GetDownloadRequest
  extends Request
{
  @c("download")
  private GetDownloadParams download;
  
  public GetDownloadRequest()
  {
    super("get");
  }
  
  public GetDownloadParams getDownload()
  {
    return this.download;
  }
  
  public void setDownload(GetDownloadParams paramGetDownloadParams)
  {
    this.download = paramGetDownloadParams;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\request\GetDownloadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */