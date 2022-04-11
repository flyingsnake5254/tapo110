package com.tplink.ata.result;

import com.google.gson.q.c;

public class ATABaseResult
{
  @c("err_code")
  private int errCode;
  
  public int getErrCode()
  {
    return this.errCode;
  }
  
  public void setErrCode(int paramInt)
  {
    this.errCode = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\ata\result\ATABaseResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */