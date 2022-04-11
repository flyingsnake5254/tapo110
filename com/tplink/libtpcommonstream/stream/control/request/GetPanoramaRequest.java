package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;

public class GetPanoramaRequest
  extends Request
{
  @c("panorama")
  private GetPanoramaParams panorama;
  
  public GetPanoramaRequest()
  {
    super("get");
  }
  
  public GetPanoramaParams getPanorama()
  {
    return this.panorama;
  }
  
  public void setPanorama(GetPanoramaParams paramGetPanoramaParams)
  {
    this.panorama = paramGetPanoramaParams;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\request\GetPanoramaRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */