package com.tplink.libtpnetwork.IoTNetwork.bean.common.result;

import androidx.annotation.Nullable;
import com.google.gson.i;

public class ThingServiceExecResult
{
  @Nullable
  private i data;
  private String requestId;
  
  public ThingServiceExecResult(String paramString)
  {
    this.requestId = paramString;
  }
  
  public ThingServiceExecResult(String paramString, @Nullable i parami)
  {
    this.requestId = paramString;
    this.data = parami;
  }
  
  @Nullable
  public i getData()
  {
    return this.data;
  }
  
  public String getRequestId()
  {
    return this.requestId;
  }
  
  public void setData(@Nullable i parami)
  {
    this.data = parami;
  }
  
  public void setRequestId(String paramString)
  {
    this.requestId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\result\ThingServiceExecResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */