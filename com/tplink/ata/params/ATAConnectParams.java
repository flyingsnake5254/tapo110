package com.tplink.ata.params;

import com.tplink.ata.common.ATAMethodType;
import com.tplink.ata.common.ATATransferType;

public class ATAConnectParams
  extends ATABaseParams
{
  private ATATransferType type = ATATransferType.TMP;
  
  public ATAConnectParams() {}
  
  public ATAConnectParams(String paramString)
  {
    this(paramString, ATATransferType.TMP);
  }
  
  public ATAConnectParams(String paramString, ATATransferType paramATATransferType)
  {
    super(paramString, ATAMethodType.CONNECT);
    this.type = paramATATransferType;
  }
  
  public ATATransferType getType()
  {
    return this.type;
  }
  
  public void setType(ATATransferType paramATATransferType)
  {
    this.type = paramATATransferType;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\ata\params\ATAConnectParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */