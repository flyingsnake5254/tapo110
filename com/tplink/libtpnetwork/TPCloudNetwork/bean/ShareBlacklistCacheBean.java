package com.tplink.libtpnetwork.TPCloudNetwork.bean;

import com.tplink.cloud.bean.share.result.ShareBlacklistItemResult;

public class ShareBlacklistCacheBean
  extends ShareBlacklistItemResult
  implements Comparable<ShareBlacklistCacheBean>
{
  private long timeStamp;
  
  public int compareTo(ShareBlacklistCacheBean paramShareBlacklistCacheBean)
  {
    if (paramShareBlacklistCacheBean.getTimeStamp() > getTimeStamp()) {
      return 1;
    }
    if (paramShareBlacklistCacheBean.getTimeStamp() == getTimeStamp()) {
      return 0;
    }
    return -1;
  }
  
  public long getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public void setTimeStamp(long paramLong)
  {
    this.timeStamp = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\bean\ShareBlacklistCacheBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */