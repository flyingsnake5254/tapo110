package com.tplink.ata.common;

public class ATAException
  extends Exception
{
  private int errorCode;
  
  public ATAException(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\ata\common\ATAException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */