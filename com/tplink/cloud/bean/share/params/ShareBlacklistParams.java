package com.tplink.cloud.bean.share.params;

public class ShareBlacklistParams
{
  private int index;
  private int limit;
  
  public ShareBlacklistParams() {}
  
  public ShareBlacklistParams(int paramInt1, int paramInt2)
  {
    this.index = paramInt1;
    this.limit = paramInt2;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public int getLimit()
  {
    return this.limit;
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setLimit(int paramInt)
  {
    this.limit = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\share\params\ShareBlacklistParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */