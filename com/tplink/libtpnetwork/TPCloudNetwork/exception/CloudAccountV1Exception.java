package com.tplink.libtpnetwork.TPCloudNetwork.exception;

import com.tplink.cloud.bean.account.result.LoginV1Result;
import com.tplink.cloud.define.CloudException;

public class CloudAccountV1Exception
  extends CloudException
{
  private LoginV1Result loginV1Result;
  
  public CloudAccountV1Exception(LoginV1Result paramLoginV1Result)
  {
    setErrCode(0);
    this.loginV1Result = paramLoginV1Result;
  }
  
  public LoginV1Result getLoginV1Result()
  {
    return this.loginV1Result;
  }
  
  public void setLoginV1Result(LoginV1Result paramLoginV1Result)
  {
    this.loginV1Result = paramLoginV1Result;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\exception\CloudAccountV1Exception.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */