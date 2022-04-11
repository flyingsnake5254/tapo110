package com.tplink.cloud.bean.account.result;

import java.util.ArrayList;
import java.util.List;

public class AccountClientListResult
{
  private List<AccountClientResult> clientList = new ArrayList();
  
  public List<AccountClientResult> getClientList()
  {
    return this.clientList;
  }
  
  public void setClientList(List<AccountClientResult> paramList)
  {
    this.clientList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\account\result\AccountClientListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */