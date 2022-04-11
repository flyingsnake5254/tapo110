package com.tplink.libtpnetwork.IoTNetwork.transport.remote.MultiRequest;

import androidx.annotation.Keep;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTRequest;
import java.util.List;

@Keep
public class MultiRequestBean
{
  private List<TPIoTRequest> requests;
  
  public List<TPIoTRequest> getRequests()
  {
    return this.requests;
  }
  
  public void setRequests(List<TPIoTRequest> paramList)
  {
    this.requests = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\transport\remote\MultiRequest\MultiRequestBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */