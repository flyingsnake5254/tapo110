package com.tplink.cloud.bean.share.result;

import com.google.gson.q.c;
import java.util.List;

public class ShareBlacklistUpdateResult
{
  @c(alternate={"removeList"}, value="addList")
  private List<ShareBlacklistItemUpdateResult> updateList;
  
  public List<ShareBlacklistItemUpdateResult> getUpdateList()
  {
    return this.updateList;
  }
  
  public void setUpdateList(List<ShareBlacklistItemUpdateResult> paramList)
  {
    this.updateList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\share\result\ShareBlacklistUpdateResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */